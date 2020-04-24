package com.example.app.model.vo;

import org.jetbrains.annotations.NotNull;

public class EstadoVO {

    private Integer id;
    private String nomeEstado;
    private String uf;
    private PaisVO paisVO;

    public EstadoVO(Integer id, String nomeEstado, String uf, PaisVO paisVO) {
        super();
        this.id = id;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
        this.paisVO = paisVO;
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

    public PaisVO getPaisVO() {
        return paisVO;
    }

    public void setPaisVO(PaisVO paisVO) {
        this.paisVO = paisVO;
    }

    @NotNull
    @Override
    public String toString() {
        return "Estado: " + this.nomeEstado + " (" + this.uf + ")";
    }
}