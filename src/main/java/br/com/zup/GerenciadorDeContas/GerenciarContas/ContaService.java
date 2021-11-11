package br.com.zup.GerenciadorDeContas.GerenciarContas;

import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.ContaDTO;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Enums.StatusDaConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Optional;

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

    private void atualizarStatus(Conta conta) {

        if (conta.getDataDeVencimento().isBefore(ChronoLocalDate.from(LocalDateTime.now()))) {
            conta.setStatusDaConta(StatusDaConta.VENCIDA);
        }

    }

    public List<Conta> exibirContasCadastradas(Integer id, String nome, Double valor) {
        if (id != null) {
            return contaRepository.findAllById(id);
        } else if (nome != null) {
            return contaRepository.findAllByNome(nome);
        } else if (valor != null) {
            return contaRepository.findAllByValor(valor);
        }
        List<Conta> contas = (List<Conta>) contaRepository.findAll();

        return contas;
    }

    public Conta localizarPorId(int id) {
        Optional<Conta> contaEncontrada = contaRepository.findById(id);
        if (contaEncontrada.isEmpty()) {
            throw new IdNaoEncontradoException("Conta não encontrada!");
        }
        return contaEncontrada.get();
    }

    public Conta atualizarPgtoConta(int id) {
        Conta contaParaAtualizarPgto = localizarPorId(id);
        contaParaAtualizarPgto.setDataDePagamento(LocalDateTime.now());
        contaParaAtualizarPgto.setStatusDaConta(StatusDaConta.PAGO);
        contaRepository.save(contaParaAtualizarPgto);

        return contaParaAtualizarPgto;
    }

}



