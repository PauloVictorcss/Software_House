package br.com.softwareGrup.comanda.model;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "comanda")
public class Comanda {

    //Não esquecer de retornar a comanda no abrir mesa
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Mesa mesa;
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;
    private Date dataHora;
    private double subTotal = 0;

    public Comanda(Mesa mesa){
        this.mesa = mesa;

    }

    public Comanda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<ItemPedido> getItens() {

        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

}
