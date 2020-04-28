package com.example.app.model.vo;

public class RegiaoVO {

    private Integer id;
    private String regiao_localizacao;

    public RegiaoVO(Integer id, String regiao_localizacao) {
        this.id = id;
        this.regiao_localizacao = regiao_localizacao;
    }

    public RegiaoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegiao_localizacao() {
        return regiao_localizacao;
    }

    public void setRegiao_localizacao(String regiao_localizacao) {
        this.regiao_localizacao = regiao_localizacao;
    }

    public void setRegiao_localizacao(Object regiao_localizacao) {
        try {
            this.regiao_localizacao = String.valueOf(regiao_localizacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "(" + id + ")" + " Regiao: " + regiao_localizacao;
    }
}
