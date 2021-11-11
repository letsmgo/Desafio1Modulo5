package br.com.zup.GerenciadorDeContas.GerenciarContas;

import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.ContaDTO;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        atualizarStatus(conta);

        return contaRepository.save(conta);
    }

    private void atualizarStatus (Conta conta){

        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatusDaConta(StatusDaConta.VENCIDA);
        }

    }

    public List<Conta> exibirContasCadastradas(Integer id, String nome, Double valor){
        if (id != null){
            return contaRepository.findAllById(id);
        } else if (nome != null){
            return contaRepository.findAllByNome(nome);
        } else if (valor != null){
            return contaRepository.findAllByValor(valor);
        }
        List<Conta> contas = (List<Conta>) contaRepository.findAll();

        return contas;
    }
}
