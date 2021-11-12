package br.com.zup.GerenciadorDeContas.GerenciarContas;


import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta incluirConta(@RequestBody @Valid ContaDTO contaDTO) {

        return contaService.incluirConta(contaDTO);
    }

    @GetMapping
    public List<ExibirContasDTO> exibirContas() {
        List<ExibirContasDTO> contaDtos = new ArrayList<>();
        for (Conta conta : contaService.exibirContasCadastradas()) {
            ExibirContasDTO exibirContaDto = modelMapper.map(conta, ExibirContasDTO.class);

            contaDtos.add(exibirContaDto);
        }
        return contaDtos;
    }

    @PutMapping("/{id}")
    public SaidaPgtoAtualizadoDTO atualizarPgto(@PathVariable int id, @RequestBody PagamentoAtualizarDTO
            contaAtualizada) {
        return modelMapper.map(contaService.atualizarPgtoConta(id, contaAtualizada), SaidaPgtoAtualizadoDTO.class);
    }

    @GetMapping("/{id}")
    public ContaSaidaGeralDTO buscaPorIdEspecifico(@PathVariable int id) {
        Conta conta = contaService.localizarPorId(id);

        return modelMapper.map(conta, ContaSaidaGeralDTO.class);
    }

}
