package com.example.demo.contrato;

import com.example.demo.pessoa.PessoaSchema;
import com.example.demo.trabalho.TrabalhoSchema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class ContratoSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private TrabalhoSchema trabalho;

    private List<PessoaSchema> pessoas;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TrabalhoSchema getTrabalho() {
        return trabalho;
    }

    public List<PessoaSchema> getPessoas() {
        return pessoas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPessoas(List<PessoaSchema> pessoas) {
        this.pessoas = pessoas;
    }

    public void setTrabalho(TrabalhoSchema trabalho) {
        this.trabalho = trabalho;
    }
}
