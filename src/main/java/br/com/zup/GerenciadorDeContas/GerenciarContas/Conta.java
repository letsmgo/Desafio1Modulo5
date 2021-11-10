package br.com.zup.GerenciadorDeContas.GerenciarContas;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.TipoDeConta;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TipoDeConta tipoDeConta;
    @Column(nullable = false)
    private String nome;
    private double valor;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private StatusDaConta satusDaConta;

    public Conta() {

    }

    public Conta(int id, TipoDeConta tipoDeConta, String nome, double valor, LocalDate dataDeVencimento,
                 LocalDateTime dataDePagamento, StatusDaConta satusDaConta) {
        this.id = id;
        this.tipoDeConta = tipoDeConta;
        this.nome = nome;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.satusDaConta = satusDaConta;
    }

    public int getId() {
        return id;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public StatusDaConta getSatusDaConta() {
        return satusDaConta;
    }

    public void setSatusDaConta(StatusDaConta satusDaConta) {
        this.satusDaConta = satusDaConta;
    }
}
