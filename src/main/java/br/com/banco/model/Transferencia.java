package br.com.banco.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataTranferencia;

    private Double valor;

    private String tipo;

    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Transferencia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataTranferencia() {
        return dataTranferencia;
    }

    public void setDataTranferencia(LocalDateTime dataTranferencia) {
        this.dataTranferencia = dataTranferencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}