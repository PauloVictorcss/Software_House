package br.com.softwareGrup.comanda.servicies;

import br.com.softwareGrup.comanda.enuns.StatusMesa;
import br.com.softwareGrup.comanda.exception.IsNotPossibleToDoException;
import br.com.softwareGrup.comanda.model.ItemPedido;
import br.com.softwareGrup.comanda.model.Mesa;
import br.com.softwareGrup.comanda.model.Comanda;
import br.com.softwareGrup.comanda.model.Produto;
import br.com.softwareGrup.comanda.repositories.ItemPedidoRepository;
import br.com.softwareGrup.comanda.repositories.MesaRepository;
import br.com.softwareGrup.comanda.repositories.ComandaRepository;
import br.com.softwareGrup.comanda.repositories.ProdutoRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class ComandaServicies {

    @Autowired
    private ComandaRepository comandaRepository;
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    //passando o id da mesa, para adicionar a mesa no pedido
    @Transactional
    public Comanda CriarComanda(Long id){
        Mesa mesa = mesaRepository.findById(id).orElse(null);
        Comanda comanda = new Comanda(mesa);
        comanda.setDataHora(new Date());
        return comandaRepository.save(comanda);

    }

    //Adicionar ItemPedido ao pedidoo
    @Transactional
    public Comanda AdicionarItemPedido(Long idComanda, Long idProduto, int quantidade){
        Comanda comanda = comandaRepository.findById(idComanda).orElse(null);
        if(comanda.getMesa().getStatus().equals(StatusMesa.AGUARDANDO_PAGAMENTO) || comanda.getMesa().getStatus().equals(StatusMesa.LIVRE)){
            throw new IsNotPossibleToDoException("a comanda está fechado");
        } else {
            Produto produto = produtoRepository.findById(idProduto).orElse(null);
            Hibernate.initialize(comanda.getItens());
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setComanda(comanda);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(quantidade);
            comanda.getItens().add(itemPedido);
            itemPedidoRepository.save(itemPedido);
            return comandaRepository.save(comanda);
            
        }
    }

    @Transactional(readOnly = true)
    public List<ItemPedido> ListarItensPedidos(Long id){
        Comanda comanda = comandaRepository.findById(id).orElse(null);
        return comanda.getItens();
    }

    @Transactional
    public Comanda getComanda(Long idComanda) {
        Comanda comanda =  comandaRepository.findById(idComanda).orElse(null);
        Hibernate.initialize(comanda.getItens());
        return comanda;
    }

    @Transactional(readOnly = true)
    public List<ItemPedido> GetItensComanda(Long idComanda) {
        Comanda comanda = comandaRepository.findById(idComanda).orElse(null);
        Hibernate.initialize(comanda.getItens());
        return comanda.getItens();
    }
}
