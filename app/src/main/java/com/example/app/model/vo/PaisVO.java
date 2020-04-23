package com.example.app.model.vo;

import org.jetbrains.annotations.NotNull;

public class PaisVO {

    private Integer id;
    private String nomePais;
    private String localidade;

    public PaisVO(Integer id, String nomePais, String localidade) {
        this.id = id;
        this.nomePais = nomePais;
        this.localidade = localidade;
    }

    public PaisVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @NotNull
    @Override
    public String toString() {
        return "Pais: " + this.nomePais + "(" + this.localidade + ")\n";
    }
}
