package br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;

public class ExibirContasDTO {
    private Integer id;
    private String nome;
    private Double valor;
    private StatusDaConta statusDaConta;

    public ExibirContasDTO() {
    }

    public Integer getId() {
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

    public StatusDaConta getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(StatusDaConta statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

}
