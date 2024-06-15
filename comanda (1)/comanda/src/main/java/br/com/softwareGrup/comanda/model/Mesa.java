package br.com.softwareGrup.comanda.model;

import br.com.softwareGrup.comanda.enuns.StatusMesa;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "mesa")
public class Mesa implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_Mesa")
    private StatusMesa status = StatusMesa.LIVRE;
    private int numero;
    @Column(name = "numero_ocupante")
    private int numeroOcupante;
    @Column(name = "data_hora_abertura")
    private LocalDateTime dataHoraAbertura;
    @Column(name = "data_hora_fechamento")
    private LocalDateTime dataHoraFechamento;


    public LocalDateTime getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(LocalDateTime dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusMesa getStatus() {
        return status;
    }

    public void setStatus(StatusMesa status) {
        this.status = status;
    }

    public int getNumeroOcupante() {
        return numeroOcupante;
    }

    public void setNumeroOcupante(int numeroOcupante) {
        this.numeroOcupante = numeroOcupante;
    }


    public LocalDateTime getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(LocalDateTime dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}
