package com.example.app.model.vo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

@DatabaseTable(tableName = "regioes")
public class RegiaoVO {

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true, indexName = "idRegiao")
    private Integer id;
    @DatabaseField(canBeNull = false, unique = true, columnName = "nomeRegiao", dataType = DataType.STRING, width = 50)
    private String nomeRegiao;
    @ForeignCollectionField(eager = true)
    private Collection<PaisVO> collectionPaises;

    public RegiaoVO(Integer id, String nomeRegiao, Collection<PaisVO> collectionPaises) {
        this.id = id;
        this.nomeRegiao = nomeRegiao;
        this.collectionPaises = collectionPaises;
    }

    public RegiaoVO(Integer id, String nomeRegiao) {
        this.id = id;
        this.nomeRegiao = nomeRegiao;
    }

    public RegiaoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public Collection<PaisVO> getCollectionPaises() {
        return collectionPaises;
    }

    public void setCollectionPaises(Collection<PaisVO> collectionPaises) {
        this.collectionPaises = collectionPaises;
    }

    @Override
    public String toString() {
        return this.nomeRegiao + " (" + this.id + ")" ;
    }
}
