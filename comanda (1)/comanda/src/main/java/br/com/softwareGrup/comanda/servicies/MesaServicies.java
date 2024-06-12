package br.com.softwareGrup.comanda.servicies;

import br.com.softwareGrup.comanda.enuns.FormaPagamento;
import br.com.softwareGrup.comanda.enuns.StatusMesa;
import br.com.softwareGrup.comanda.exception.EntityNotFoundException;
import br.com.softwareGrup.comanda.exception.IsNotPossibleToDoException;
import br.com.softwareGrup.comanda.model.*;
import br.com.softwareGrup.comanda.repositories.ComandaRepository;
import br.com.softwareGrup.comanda.repositories.MesaRepository;
import br.com.softwareGrup.comanda.repositories.ProdutoRepository;
import br.com.softwareGrup.comanda.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MesaServicies {

    @Autowired
    MesaRepository repository;
    @Autowired
    ComandaRepository comandaRepository;
    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Mesa> getMesas(){
        return repository.findAll();

    }

    public List<Produto> abrirMesa(Mesa mesa) {
        Mesa mesaNoBanco = repository.findById(mesa.getId()).orElseThrow(() -> new EntityNotFoundException("Mesa não existe"));
        if(mesaNoBanco.getStatus().equals(StatusMesa.LIVRE)) {
            mesaNoBanco.setNumeroOcupante(mesa.getNumeroOcupante());
            mesaNoBanco.setHoraAbertura(LocalDateTime.now());
            mesaNoBanco.setHoraFechamento(null);
            mesaNoBanco.setStatus(StatusMesa.OCUPADA);
            repository.save(mesaNoBanco);
            return produtoRepository.findAll();
        } else {
            throw new IsNotPossibleToDoException("Não é possível fazer abertura pois a mesa não está livre");
        }
    }

    public Mesa AguardarPagamento(Mesa mesa) {
        Mesa mesaNoBanco = repository.findById(mesa.getId()).orElseThrow(() -> new EntityNotFoundException("Mesa não existe"));
        if(mesaNoBanco.getHoraAbertura() == null){
            throw new IsNotPossibleToDoException("Se a mesa não foi aberta não é possível aguardar pagamento");
        }else {
            mesaNoBanco.setStatus(StatusMesa.AGUARDANDO_PAGAMENTO);
            return repository.save(mesaNoBanco);
        }
    }

    @Transactional
    public Venda fechaMesa(Mesa mesa, FormaPagamento formaPagamento) {
        Mesa mesaNoBanco = repository.findById(mesa.getId()).orElseThrow(() -> new EntityNotFoundException("Mesa não existe"));
        if(mesaNoBanco.getHoraAbertura() == null){
            throw new IsNotPossibleToDoException("Não é possível fechar mesa sem antes ter abrido");
        } else {

            Comanda comada = comandaRepository.findByMesa(mesa).orElse(null);
            List<ItemPedido> itens = comada.getItens();
            double subTotal = itens.stream().mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade()).sum();

            Venda venda = new Venda();
            venda.setMesa(mesaNoBanco);
            venda.setComanda(comada);
            venda.setSubtotal(subTotal);
            venda.setDataHoraPagamento(new Date());
            venda.setFormaPagamento(formaPagamento);

            mesaNoBanco.setNumeroOcupante(mesa.getNumeroOcupante());
            mesaNoBanco.setHoraFechamento(LocalDateTime.now());
            mesaNoBanco.setStatus(StatusMesa.LIVRE);

            repository.save(mesaNoBanco);
            return vendaRepository.save(venda);
        }
    }


    public void createMesa(Mesa mesa){
        repository.save(mesa);
    }

}
