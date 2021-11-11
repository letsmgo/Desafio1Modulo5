package br.com.zup.GerenciadorDeContas.GerenciarContas;


import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.ContaDTO;
import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.ExibirContaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Conta incluirConta(@RequestBody ContaDTO contaDTO){

        return contaService.incluirConta(contaDTO);
    }

    @GetMapping
    public List<ExibirContaDto> exibirContas(@RequestParam(required = false) Integer id,
                                                @RequestParam(required = false) String nome,
                                                @RequestParam(required = false) Double valor){
        List<ExibirContaDto> contaDtos = new ArrayList<>();
        for (Conta conta : contaService.exibirContasCadastradas(id,nome,valor)) {
            ExibirContaDto exibirContaDto = modelMapper.map(conta, ExibirContaDto.class);

            contaDtos.add(exibirContaDto);
        }
        return contaDtos;
    }


}
