package br.com.zup.GerenciadorDeContas.Config;

import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import br.com.zup.GerenciadorDeContas.Exceptions.StatusNaoConfereException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroValidacao> tratarErrosDeValidacao(MethodArgumentNotValidException excecao) {
        List<ErroValidacao> erros = new ArrayList<>();

        for (FieldError referencia : excecao.getFieldErrors()) {
            ErroValidacao erroValidacao = new ErroValidacao(referencia.getDefaultMessage(), referencia.getField());
            erros.add(erroValidacao);
        }

        return erros;
    }

    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String retornoIdNaoEncontrado(IdNaoEncontradoException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(StatusNaoConfereException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String retornoStatusDiferente(StatusNaoConfereException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroValidacao manipularErroDeTipoNull(HttpMessageNotReadableException exception) {
        ErroValidacao erroValidacao = new ErroValidacao("Campo preenchido incorretamente", "tipoDeConta");

        return erroValidacao;
    }

}
