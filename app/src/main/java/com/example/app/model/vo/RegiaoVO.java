package com.example.app.model.vo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "regioes_paises")
public class RegiaoVO {

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true, indexName = "idRegiao")
    private Integer id;
    @DatabaseField(canBeNull = false, unique = true, columnName = "nomeRegiao", dataType = DataType.STRING, width = 50)
    private String nomeRegiao;

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

    public void setRegiao_localizacao(Object regiao_localizacao) {
        try {
            this.nomeRegiao = String.valueOf(regiao_localizacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "(" + id + ")" + " Regiao: " + nomeRegiao;
    }
}
