package br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.TipoDeConta;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ContaDTO {
    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoDeConta tipoDeConta;

    @Column(nullable = false)
    @Size(min = 2, message = "Digite um nome válido")
    private String nome;

    @DecimalMin(value = "0.1", inclusive = false, message = "Valor incompleto")
    @Digits(integer = 10, fraction = 2, message = "Valor inválido")
    private double valor;

    @NotNull(message = "Data de vencimento inválida")
    private LocalDate dataDeVencimento;

    public ContaDTO() {
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

}
