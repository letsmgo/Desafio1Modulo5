package br.com.zup.GerenciadorDeContas.GerenciarContas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

}
