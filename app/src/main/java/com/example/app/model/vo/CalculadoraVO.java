package com.example.app.model.vo;

import com.example.app.util.Overload;

import org.jetbrains.annotations.NotNull;

public class CalculadoraVO {

    private Double np1;
    private Double np2;
    private Double resultado;
    private Integer tipoCalculo;
    private String operador;

    public CalculadoraVO(Double np1, Double np2, Double resultado, Integer tipoCalculo, String operador) {
        this.np1 = np1;
        this.np2 = np2;
        this.resultado = resultado;
        this.tipoCalculo = tipoCalculo;
        this.operador = operador;
    }

    public CalculadoraVO() {
    }

    public Double getNp1() {
        return np1;
    }

    public void setNp1(Double np1) {
        this.np1 = np1;
    }

    @Overload
    public void setNp1(String np1) {
        try {
            this.np1 = Double.parseDouble(np1);
        } catch (Exception e) {
            this.np1 = null;
        }
    }

    public Double getNp2() {
        return np2;
    }

    public void setNp2(Double np2) {
        this.np2 = np2;
    }

    @Overload
    public void setNp2(String np2) {
        try {
            this.np2 = Double.parseDouble(np2);
        } catch (Exception e) {
            this.np2 = null;
        }
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Integer getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(Integer tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @NotNull
    @Override
    public String toString() {
        return " Nota 1: " + this.np1 +
                " Nota 2: " + this.np2 +
                " Resultado: " + this.resultado +
                " Tipo Calculo: " + this.tipoCalculo +
                " Operador: " + this.operador;
    }
}
