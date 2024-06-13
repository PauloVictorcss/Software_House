package br.com.softwareGrup.comanda.controllers;
import br.com.softwareGrup.comanda.model.Venda;
import br.com.softwareGrup.comanda.servicies.VendaServicies;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Named
@ViewScoped
public class ControllerRelatorio implements Serializable {

    @Inject
    private VendaServicies vendaServicies;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Venda> vendas;

    @PostConstruct
    public void init() {
        // Inicializações necessárias, se houver
    }

    public void gerarRelatorioVenda() {
        vendas = vendaServicies.relatorioVenda(dataInicio, dataFim);
    }

    // Getters e Setters
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
