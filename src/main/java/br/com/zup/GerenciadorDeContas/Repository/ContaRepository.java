package br.com.zup.GerenciadorDeContas.Repository;


import br.com.zup.GerenciadorDeContas.GerenciarContas.Conta;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.TipoDeConta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ContaRepository extends CrudRepository<Conta, Integer> {

    List<Conta> findAllByStatusDaConta (StatusDaConta statusDaConta);

    List<Conta> findAllByTipoDeConta (TipoDeConta tipoDeConta);

    @Query(value = "SELECT * FROM contas WHERE valor BETWEEN :valor*0.7 AND :valor*1.3", nativeQuery = true)
    List<Conta> findAllByValorAproximado( Double valor);

}
