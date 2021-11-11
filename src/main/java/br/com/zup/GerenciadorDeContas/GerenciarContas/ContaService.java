package br.com.zup.GerenciadorDeContas.GerenciarContas;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.ContaDTO;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta incluirConta(ContaDTO contaDTO) {
        Conta conta = new Conta();

        conta.getStatusDaConta();
        conta.getDataDePagamento();
        conta.setTipoDeConta(contaDTO.getTipoDeConta());
        conta.setNome(contaDTO.getNome());
        conta.setValor(contaDTO.getValor());
        conta.setDataDeVencimento(contaDTO.getDataDeVencimento());


        return contaRepository.save(conta);
    }


}
