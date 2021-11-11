package br.com.zup.GerenciadorDeContas.GerenciarContas.Enums;

public enum TipoDeConta {
    LUZ,
    AGUA,
    COMIDA,
    OUTROS;

    private String tipoDeConta;

    TipoDeConta(String conta) {
        tipoDeConta = conta;
    }

    TipoDeConta() {

    }

    public String getTipoDeConta() {
        return tipoDeConta;

    }

}
