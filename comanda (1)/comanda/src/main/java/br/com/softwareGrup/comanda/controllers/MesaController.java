package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.enuns.FormaPagamento;
import br.com.softwareGrup.comanda.model.Mesa;
import br.com.softwareGrup.comanda.model.Produto;
import br.com.softwareGrup.comanda.model.Venda;
import br.com.softwareGrup.comanda.servicies.MesaServicies;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MesaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MesaServicies mesaServicies;

    private List<Mesa> mesas;
    private Mesa mesa;
    private FormaPagamento formaPagamento;
    private List<Produto> produtos;
    private Venda venda;

    @PostConstruct
    public void init() {
        mesas = mesaServicies.getMesas();
        mesa = new Mesa();
    }

    public void abrirMesa() {
        produtos = mesaServicies.abrirMesa(mesa);
    }

    public void aguardarPagamento() {
        mesa = mesaServicies.AguardarPagamento(mesa);
    }

    public void fecharMesa() {
        venda = mesaServicies.fechaMesa(mesa, formaPagamento);
    }

    public void populaMesa() {
        mesaServicies.createMesa(mesa);
    }

    // Getters and Setters

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
