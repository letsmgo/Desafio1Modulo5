package br.com.zup.GerenciadorDeContas.GerenciarContas;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.TipoDeConta;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Necessário informar um tipo de conta válido.")
    private TipoDeConta tipoDeConta;
    @Column(nullable = false)
    @NotEmpty(message = "Não é possível cadastrar uma conta sem nome!")
    @Size(min = 2, max = 50, message = "Nome de conta superior ao tamanho suportado (entre 2 e 50 caracteres).")
    private String nome;
    @DecimalMin(value = "0.1")
    private double valor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private StatusDaConta statusDaConta = StatusDaConta.AGUARDANDO;

    public Conta() {

    }

    public Conta(int id, TipoDeConta tipoDeConta, String nome, double valor, LocalDate dataDeVencimento,
                 LocalDateTime dataDePagamento, StatusDaConta statusDaConta) {
        this.id = id;
        this.tipoDeConta = tipoDeConta;
        this.nome = nome;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.statusDaConta = statusDaConta;
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

    public StatusDaConta getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(StatusDaConta statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

}
