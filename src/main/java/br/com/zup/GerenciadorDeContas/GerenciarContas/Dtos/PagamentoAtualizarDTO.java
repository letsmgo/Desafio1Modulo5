package br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;

public class PagamentoAtualizarDTO {
    private StatusDaConta statusDaConta;

    public PagamentoAtualizarDTO() {

    }

    public PagamentoAtualizarDTO(StatusDaConta statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

    public StatusDaConta getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(StatusDaConta statusDaConta) {
        this.statusDaConta = statusDaConta;
    }
}
