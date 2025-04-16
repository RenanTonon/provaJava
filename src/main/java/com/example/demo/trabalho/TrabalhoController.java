package com.example.demo.trabalho;

import com.example.demo.pessoa.PessoaSchema;
import com.example.demo.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/trabalho")
@RestController
public class TrabalhoController {


    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public TrabalhoSchema criaTrabalho(@RequestBody TrabalhoSchema objTrabalho){
        return this.trabalhoService.criaTrabalho(objTrabalho);
    }

    @GetMapping
    public List<TrabalhoSchema> listaTrabalhos(){
        return this.trabalhoService.listaTrabalhos();
    }

    @PatchMapping("/{id}")
    public TrabalhoSchema atualizaTrabalho(@PathVariable("id") Long idTrabalho,@RequestBody TrabalhoSchema objTrabalho){
        return this.trabalhoService.atualizaTrabalho(idTrabalho,objTrabalho);
    }
    @DeleteMapping("/{id}")
    public String deleteTrabalho(@PathVariable("id") Long idTrabalho){
        return this.trabalhoService.deleteTrabalho(idTrabalho);
    }

}
