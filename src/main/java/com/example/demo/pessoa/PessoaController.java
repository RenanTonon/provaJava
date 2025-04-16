package com.example.demo.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoa")
@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaSchema criaPessoa(@RequestBody PessoaSchema objPessoa){
        return this.pessoaService.criaPessoa(objPessoa);
    }

    @GetMapping
    public List<PessoaSchema> listPessoa(){
        return this.pessoaService.listaPessoas();
    }

    @PatchMapping("/{id}")
    public PessoaSchema atualizaPessoa(@PathVariable("id") Long idPessoa,@RequestBody PessoaSchema objPessoa){
        return this.pessoaService.atualizaPessoa(idPessoa,objPessoa);
    }
    @DeleteMapping("/{id}")
    public String deletePessoa(@PathVariable("id") Long idPessoa){
        return this.pessoaService.deletePessoa(idPessoa);
    }
}
