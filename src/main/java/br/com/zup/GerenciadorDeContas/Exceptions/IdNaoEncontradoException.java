package br.com.zup.GerenciadorDeContas.Exceptions;

public class IdNaoEncontradoException extends RuntimeException{

    public IdNaoEncontradoException (String mensagem){
        super(mensagem);
    }
}
