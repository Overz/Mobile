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
    @DatabaseField(canBeNull = false, width = 100, dataType = DataType.STRING, columnName = "nomePais")
    private String nomePais;
    @DatabaseField(canBeNull = false, unique = true, width = 100, dataType = DataType.STRING, columnName = "capitalPais")
    private String capital;
    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private RegiaoVO regiaoVO;
    @ForeignCollectionField(eager = true)
    private Collection<EstadoVO> collectionEstados;

    public PaisVO(Integer id, String nomePais, String capital, RegiaoVO regiaoVO, Collection<EstadoVO> collectionEstados) {
        this.id = id;
        this.nomePais = nomePais;
        this.capital = capital;
        this.regiaoVO = regiaoVO;
        this.collectionEstados = collectionEstados;
    }

    public PaisVO(Integer id, String nomePais, String capital, RegiaoVO regiaoVO) {
        this.id = id;
        this.nomePais = nomePais;
        this.capital = capital;
        this.regiaoVO = regiaoVO;
    }

    public PaisVO(Integer id, String nomePais, String capital) {
        this.id = id;
        this.nomePais = nomePais;
        this.capital = capital;
    }

    public PaisVO(Integer id, String nomePais) {
        this.id = id;
        this.nomePais = nomePais;
    }

    public PaisVO(String nomePais, String capital, RegiaoVO regiaoVO) {
        this.nomePais = nomePais;
        this.capital = capital;
        this.regiaoVO = regiaoVO;
    }

    public PaisVO(String nomePais, RegiaoVO regiaoVO) {
        this.nomePais = nomePais;
        this.regiaoVO = regiaoVO;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public RegiaoVO getRegiaoVO() {
        return regiaoVO;
    }

    public void setRegiaoVO(RegiaoVO regiaoVO) {
        this.regiaoVO = regiaoVO;
    }

    public Collection<EstadoVO> getCollectionEstados() {
        return collectionEstados;
    }

    public void setCollectionEstados(Collection<EstadoVO> collectionEstados) {
        this.collectionEstados = collectionEstados;
    }

    public String toString2() {
        return this.nomePais;
    }

    @NotNull
    @Override
    public String toString() {
        return "Pais: " + this.nomePais + "(" + this.capital + ")";
    }
}
