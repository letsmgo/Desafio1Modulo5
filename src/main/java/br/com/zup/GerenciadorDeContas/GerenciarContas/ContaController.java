package br.com.zup.GerenciadorDeContas.GerenciarContas;


import br.com.zup.GerenciadorDeContas.GerenciarContas.Dtos.ContaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta incluirConta(@RequestBody ContaDTO contaDTO){

        return contaService.incluirConta(contaDTO);
    }


}
