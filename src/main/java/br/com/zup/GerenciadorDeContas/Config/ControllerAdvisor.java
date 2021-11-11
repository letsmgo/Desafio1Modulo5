package br.com.zup.GerenciadorDeContas.Config;

import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import br.com.zup.GerenciadorDeContas.Exceptions.StatusNaoConfereException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String retornoIdNaoEncontrado (IdNaoEncontradoException exception){
        return exception.getMessage();
    }

}
