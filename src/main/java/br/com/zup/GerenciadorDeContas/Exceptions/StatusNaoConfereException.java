package br.com.zup.GerenciadorDeContas.Exceptions;

public class StatusNaoConfereException extends RuntimeException{

    public StatusNaoConfereException(String mensage){
        super(mensage);
    }
}
