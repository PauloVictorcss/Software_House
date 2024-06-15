package br.com.softwareGrup.comanda.model;

import br.com.softwareGrup.comanda.enuns.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    private Mesa mesa;
    @ManyToOne
    private Comanda comanda;
    private FormaPagamento formaPagamento;
    private LocalDate dataPagamento;
    private double valorItensPedidos;
    private double descontoPocentagemGarcon;
    private double subtotal;

    public double getValorItensPedidos() {
        return valorItensPedidos;
    }

    public void setValorItensPedidos(double valorItensPedidos) {
        this.valorItensPedidos = valorItensPedidos;
    }

    public double getDescontoPocentagemGarcon() {
        return descontoPocentagemGarcon;
    }

    public void setDescontoPocentagemGarcon(double descontoPocentagemGarcon) {
        this.descontoPocentagemGarcon = descontoPocentagemGarcon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
