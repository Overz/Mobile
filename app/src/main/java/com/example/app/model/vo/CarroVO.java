package com.example.app.model.vo;

import com.example.app.util.Overload;

import org.jetbrains.annotations.NotNull;

public class CarroVO {

    private String modelo;
    private Integer km;
    private Double combustivel;

    public CarroVO(String modelo, Integer km, Double combustivel) {
        this.modelo = modelo;
        this.km = km;
        this.combustivel = combustivel;
    }

    public CarroVO() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    @Overload
    public void setKm(String km) {
        try {
            this.km = Integer.parseInt(km);
        } catch (Exception e) {
            this.km = null;
        }
    }

    public Double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Double combustivel) {
        this.combustivel = combustivel;
    }

    @Overload
    public void setCombustivel(String combustivel) {
        try {
            this.combustivel = Double.parseDouble(combustivel);
        } catch (Exception e) {
            this.combustivel = null;
        }
    }

    @NotNull
    @Override
    public String toString() {
        return "Modelo: " + this.modelo +
                " - KM: " + this.km +
                " - Combustivel: " + this.combustivel;
    }
}
