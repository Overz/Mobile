package com.example.app.model.vo;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class PaisVO {

    private Integer id;
    private String nomePais;
    private Collection<EstadoVO> collectionEstados;

    public PaisVO(Integer id, String nomePais, Collection<EstadoVO> collectionEstados) {
        this.id = id;
        this.nomePais = nomePais;
        this.collectionEstados = collectionEstados;
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

    public Collection<EstadoVO> getCollectionEstados() {
        return collectionEstados;
    }

    public void setCollectionEstados(Collection<EstadoVO> collectionEstados) {
        this.collectionEstados = collectionEstados;
    }

    @NotNull
    @Override
    public String toString() {
        return "Pais: " + this.nomePais + "" + collectionEstados.toString();
    }
}
