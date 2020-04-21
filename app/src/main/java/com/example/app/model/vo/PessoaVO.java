package com.example.app.model.vo;

import com.example.app.util.Overload;

import org.jetbrains.annotations.NotNull;

public class PessoaVO {

    private String nome;
    private Integer idade;

    public PessoaVO(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public PessoaVO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Overload
    public void setIdade(String idade) {
        try {
            this.idade = Integer.parseInt(idade);
        } catch (Exception e) {
            this.idade = null;
        }
    }

    @NotNull
    @Override
    public String toString() {
        return "Nome: " + this.nome + " Idade: " + this.idade;
    }
}
