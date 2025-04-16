package com.example.demo.trabalho;


import com.example.demo.pessoa.PessoaRepository;
import com.example.demo.pessoa.PessoaSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public TrabalhoSchema criaTrabalho(TrabalhoSchema objTrabalho) {
        return this.trabalhoRepository.save(objTrabalho);
    }


    public List<TrabalhoSchema> listaTrabalhos() {
        return this.trabalhoRepository.findAll();
    }

    public String deleteTrabalho(Long idTrabalho) {
        Optional<TrabalhoSchema> pessoa = this.trabalhoRepository.findById(idTrabalho);
        if(pessoa.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Trabalho não encontrado");
        }else{
            this.trabalhoRepository.deleteById(idTrabalho);
            return "Pessoa foi excluida";
        }
    }

    public TrabalhoSchema atualizaTrabalho(Long idTrabalho, TrabalhoSchema objTrabalho) {
        Optional<TrabalhoSchema> pessoa = this.trabalhoRepository.findById(idTrabalho);
        if(pessoa.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Trabalho não encontrado");
        }

        TrabalhoSchema newTrabalho = new TrabalhoSchema();
        newTrabalho.setId(pessoa.get().getId());
        newTrabalho.setNome(objTrabalho.getNome());
        newTrabalho.setEnd(objTrabalho.getEnd());
        return this.trabalhoRepository.save(newTrabalho);
    }
}
