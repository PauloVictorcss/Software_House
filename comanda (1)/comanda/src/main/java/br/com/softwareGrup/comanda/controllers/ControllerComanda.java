package br.com.softwareGrup.comanda.controllers;
import br.com.softwareGrup.comanda.model.Comanda;
import br.com.softwareGrup.comanda.model.ItemPedido;
import br.com.softwareGrup.comanda.servicies.ComandaServicies;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ControllerComanda implements Serializable {

    @Inject
    private ComandaServicies comandaServicies;

    private Long idMesa;
    private Long idComanda;
    private Long idProduto;
    private int quantidade;
    private List<ItemPedido> itensComanda;
    private Comanda comanda;

    @PostConstruct
    public void init() {
        // Inicializações necessárias
    }

    public void criarComanda() {
        comanda = comandaServicies.CriarComanda(idMesa);
    }

    public void adicionarItemPedidoNaComanda() {
        comanda = comandaServicies.AdicionarItemPedido(idComanda, idProduto, quantidade);
    }

    public void carregarItensComanda() {
        itensComanda = comandaServicies.GetItensComanda(idComanda);
    }

    public void carregarComanda() {
        comanda = comandaServicies.getComanda(idComanda);
    }

    // Getters e Setters
    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public Long getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Long idComanda) {
        this.idComanda = idComanda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<ItemPedido> getItensComanda() {
        return itensComanda;
    }

    public Comanda getComanda() {
        return comanda;
    }
}
