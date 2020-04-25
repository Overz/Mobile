package com.example.app.model.vo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.jetbrains.annotations.NotNull;

@DatabaseTable(tableName = "estados")
public class EstadoVO {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true, columnName = "idEstado", dataType = DataType.INTEGER, canBeNull = false, id = true)
    private Integer id;
    @DatabaseField(canBeNull = false, columnName = "nomeEstado", dataType = DataType.DATE_STRING, width = 100)
    private String nomeEstado;
    @DatabaseField(canBeNull = false, columnName = "uf", width = 2, dataType = DataType.DATE_STRING)
    private String uf;
    @DatabaseField(canBeNull = false, columnName = "idPais", foreignColumnName = "fk_estado_pais", dataType = DataType.INTEGER, foreign = true, foreignAutoRefresh = true, generatedId = true)
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

    public EstadoVO(Integer id, String nomeEstado) {
        this.id = id;
        this.nomeEstado = nomeEstado;
    }

    public EstadoVO(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public EstadoVO(Integer id) {
        this.id = id;
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