package br.com.softwareGrup.comanda.servicies;

import br.com.softwareGrup.comanda.enuns.StatusMesa;
import br.com.softwareGrup.comanda.exception.IsNotPossibleToDoException;
import br.com.softwareGrup.comanda.model.ItemPedido;
import br.com.softwareGrup.comanda.model.Mesa;
import br.com.softwareGrup.comanda.model.Pedido;
import br.com.softwareGrup.comanda.model.Produto;
import br.com.softwareGrup.comanda.repositories.MesaRepository;
import br.com.softwareGrup.comanda.repositories.PedidoRepository;
import br.com.softwareGrup.comanda.repositories.ProdutoRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
public class PedidoServicies {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    //passando o id da mesa, para adicionar a mesa no pedido
    @Transactional
    public Pedido CriarPedido(Long id){
        Mesa mesa = mesaRepository.findById(id).orElse(null);
        Pedido pedido = new Pedido(mesa);
        pedido.setDataHora(new Date());
        return pedidoRepository.save(pedido);

    }

    //Adicionar ItemPedido ao pedidoo
    @Transactional
    public Pedido AdicionarItemPedido(Long idPedido, Long idProduto, int quantidade){
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if(pedido.getMesa().getStatus().equals(StatusMesa.AGUARDANDO_PAGAMENTO) || pedido.getMesa().getStatus().equals(StatusMesa.LIVRE)){
            throw new IsNotPossibleToDoException("O pedido está fechado");
        } else {
            Produto produto = produtoRepository.findById(idProduto).orElse(null);
            Hibernate.initialize(pedido.getItens());
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(quantidade);
            pedido.getItens().add(itemPedido);
            return pedidoRepository.save(pedido);
        }
    }

    @Transactional(readOnly = true)
    public List<ItemPedido> ListarItensPedidos(Long id){
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        return pedido.getItens();
    }

    @Transactional
    public Pedido getPedido(Long idPedido) {
        Pedido pedido =  pedidoRepository.findById(idPedido).orElse(null);
        Hibernate.initialize(pedido.getItens());
        return pedido;
    }

    @Transactional(readOnly = true)
    public List<ItemPedido> Getitenspedidos(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        Hibernate.initialize(pedido.getItens());
        return pedido.getItens();
    }
}
