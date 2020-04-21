package com.example.app.model.vo;

import com.example.app.util.Overload;

import org.jetbrains.annotations.NotNull;

public class ProdutoVO {

    private String nomeProduto;
    private Double valor;
    private Integer numeroParcela;
    private Double juros;
    private boolean entrada;

    public ProdutoVO(String nomeProduto, Double valor, Integer numeroParcela, Double juros, boolean entrada) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.numeroParcela = numeroParcela;
        this.juros = juros;
        this.entrada = entrada;
    }

    public ProdutoVO() {
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Overload
    public void setValor(String valor) {
        try {
            this.valor = Double.parseDouble(valor);
        } catch (Exception e) {
            this.valor = null;
        }
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    @Overload
    public void setNumeroParcela(String numeroParcela) {
        try {
            this.numeroParcela = Integer.parseInt(numeroParcela);
        } catch (Exception e) {
            this.numeroParcela = null;
        }
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    @Overload
    public void setJuros(String juros) {
        try {
            this.juros = Double.parseDouble(juros);
        } catch (Exception e) {
            this.juros = null;
        }
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    @NotNull
    @Override
    public String toString() {
        return "Nome do Produto: " + this.nomeProduto +
                " Valor: " + this.valor +
                " Nº Parcelas: " + this.numeroParcela +
                " Juros: " + this.juros +
                " Entradas: " + this.entrada;
    }
}
