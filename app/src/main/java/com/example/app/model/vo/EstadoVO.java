package com.example.app.model.vo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.jetbrains.annotations.NotNull;

@DatabaseTable(tableName = "estados")
public class EstadoVO {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true, indexName = "idEstado", useGetSet = true)
    private Integer id;
    @DatabaseField(canBeNull = false, unique = true, width = 100, dataType = DataType.STRING, columnName = "nomeEstado", useGetSet = true)
    private String nomeEstado;
    @DatabaseField(canBeNull = false, unique = true, width = 2, dataType = DataType.STRING, columnName = "ufEstado", useGetSet = true)
    private String uf;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private PaisVO paisVO;

    public EstadoVO(Integer id, String nomeEstado, String uf, PaisVO paisVO) {
        super();
        this.id = id;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
        this.paisVO = paisVO;
    }

    public EstadoVO(Integer id, String nomeEstado, String uf) {
        this.id = id;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
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
        return this.nomeEstado + " (UF: " + this.uf.toUpperCase() + ") / " + paisVO.toString();
    }
}