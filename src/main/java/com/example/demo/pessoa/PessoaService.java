package com.example.demo.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public PessoaSchema criaPessoa(PessoaSchema objPessoa) {
        return this.pessoaRepository.save(objPessoa);
    }


    public List<PessoaSchema> listaPessoas() {
        return this.pessoaRepository.findAll();
    }

    public String deletePessoa(Long idPessoa) {
        Optional<PessoaSchema> pessoa = this.pessoaRepository.findById(idPessoa);
        if(pessoa.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada");
        }else{
            this.pessoaRepository.deleteById(idPessoa);
            return "Pessoa foi excluida";
        }
    }

    public PessoaSchema atualizaPessoa(Long idPessoa, PessoaSchema objPessoa) {
        Optional<PessoaSchema> pessoa = this.pessoaRepository.findById(idPessoa);
        if(pessoa.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada");
        }

        PessoaSchema newPessoa = new PessoaSchema();
        newPessoa.setId(pessoa.get().getId());
        newPessoa.setCpf(objPessoa.getCpf());
        newPessoa.setIdade(objPessoa.getIdade());
        return this.pessoaRepository.save(newPessoa);
    }
}
