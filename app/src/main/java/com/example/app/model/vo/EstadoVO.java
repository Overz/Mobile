package com.example.app.model.vo;

import org.jetbrains.annotations.NotNull;

public class EstadoVO extends PaisVO {

    private Integer id;
    private String nomeEstado;
    private String uf;
    private String capital;

    public EstadoVO(Integer id, String nomeEstado, String uf, String capital) {
        super();
        this.id = id;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
        this.capital = capital;
    }

    public EstadoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @NotNull
    @Override
    public String toString() {
        return "Estado: " + this.nomeEstado + "/" + this.capital + " (" + this.uf + ")";
    }
}