package br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.TipoDeConta;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaSaidaGeralDTO {
    private int id;
    private String nome;
    private double valor;
    private TipoDeConta tipoDeConta;
    private LocalDate dataDeVencimento;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDePagamento;
    private StatusDaConta statusDaConta;

    public ContaSaidaGeralDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipo(TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
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

    public StatusDaConta getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(StatusDaConta statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

}
