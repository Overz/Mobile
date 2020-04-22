package com.example.app.model.vo;

import com.example.app.util.Overload;

import org.jetbrains.annotations.NotNull;

public class CalculadoraVO {

    private Double np1;
    private Double np2;
    private Double resultado;
    private Character operador;

    public CalculadoraVO(Double np1, Double np2, Double resultado, Character operador) {
        this.np1 = np1;
        this.np2 = np2;
        this.resultado = resultado;
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

    public Character getOperador() {
        return operador;
    }

    public void setOperador(Character operador) {
        this.operador = operador;
    }

    @NotNull
    @Override
    public String toString() {
        return this.np1 + " " + this.operador + " " + this.np2 + " = " + this.resultado;
    }

    public String toString_amostra() {
        return "Nota 1: " + this.np1 +
                " Nota 2: " + this.np2 +
                " Operador: " + this.operador +
                " Resultado: " + this.resultado;
    }
}
