package br.com.zup.GerenciadorDeContas.GerenciarContas;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, String> {
    List<Conta> findAllById(int id);
    List<Conta> findAllByNome(String nome);
    List<Conta> findAllByValor(double valor);
}
