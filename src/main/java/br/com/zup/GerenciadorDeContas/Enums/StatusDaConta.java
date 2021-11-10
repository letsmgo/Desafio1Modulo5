package br.com.zup.GerenciadorDeContas.Enums;

public enum StatusDaConta {
    AGUARDANDO,
    PAGO,
    VENCIDA;

    private String statusDaConta;

    StatusDaConta(String statusConta){
        statusDaConta = statusConta;
    }

    StatusDaConta() {

    }

    public String getStatusDaConta(){

        return statusDaConta;

    }
}
