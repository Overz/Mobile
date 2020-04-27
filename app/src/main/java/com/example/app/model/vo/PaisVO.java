package com.example.app.model.vo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

@DatabaseTable(tableName = "paises")
public class PaisVO {

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true, indexName = "idPais")
    private Integer id;
    @DatabaseField(canBeNull = false, unique = true, width = 100, dataType = DataType.STRING, columnName = "nomePais")
    private String nomePais;
    @ForeignCollectionField(eager = true)
    private Collection<EstadoVO> collectionEstados;

    public PaisVO(Integer id, String nomePais, Collection<EstadoVO> collectionEstados) {
        this.id = id;
        this.nomePais = nomePais;
        this.collectionEstados = collectionEstados;
    }

    public PaisVO(Integer id, String nomePais) {
        this.id = id;
        this.nomePais = nomePais;
    }

    public PaisVO(String nomePais) {
        this.nomePais = nomePais;
    }

    public PaisVO(Integer id) {
        this.id = id;
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
        return this.nomePais;
    }
}
