package com.example.demo.contrato;

import com.example.demo.pessoa.PessoaSchema;
import com.example.demo.pessoa.PessoaService;
import com.example.demo.trabalho.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private TrabalhoService trabalhoService;
    public ContratoSchema criaContrato(ContratoSchema objContrato) {

        List<PessoaSchema> pessoas = objContrato.getPessoas();
        for(PessoaSchema pessoa : pessoas){
            this.pessoaService.criaPessoa(pessoa);
        }
        this.trabalhoService.criaTrabalho(objContrato.getTrabalho());
        return this.contratoRepository.save(objContrato);
    }
}
