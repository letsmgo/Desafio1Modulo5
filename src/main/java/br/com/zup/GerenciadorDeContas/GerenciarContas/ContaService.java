package br.com.zup.GerenciadorDeContas.GerenciarContas;

import br.com.zup.GerenciadorDeContas.Exceptions.IdNaoEncontradoException;
import br.com.zup.GerenciadorDeContas.Exceptions.StatusNaoConfereException;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.ContaDTO;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.PagamentoAtualizarDTO;
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
        } else {
            conta.setStatusDaConta(StatusDaConta.AGUARDANDO);
        }

    }

    public List<Conta> exibirContasCadastradas() {
        Iterable<Conta> contas = contaRepository.findAll();

        return (List<Conta>) contas;
    }

    public Conta localizarPorId(int id) {
        Optional<Conta> contaEncontrada = contaRepository.findById(id);
        if (contaEncontrada.isEmpty()) {
            throw new IdNaoEncontradoException("Conta não encontrada!");
        }
        return contaEncontrada.get();
    }

    public Conta atualizarPgtoConta(int id, PagamentoAtualizarDTO pagamentoAtualizarDTO) {
        verificarStatusPgto(pagamentoAtualizarDTO);
        Conta contaParaAtualizarPgto = localizarPorId(id);
        contaParaAtualizarPgto.setDataDePagamento(LocalDateTime.now());
        contaParaAtualizarPgto.setStatusDaConta(StatusDaConta.PAGO);
        contaRepository.save(contaParaAtualizarPgto);

        return contaParaAtualizarPgto;
    }

    private void verificarStatusPgto (PagamentoAtualizarDTO pagamentoAtualizarDTO){

        if (StatusDaConta.PAGO != pagamentoAtualizarDTO.getStatusDaConta()){
            throw new StatusNaoConfereException("Status não compatível!");
        }
    }



}



