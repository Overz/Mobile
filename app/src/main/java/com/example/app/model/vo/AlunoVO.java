package com.example.app.model.vo;

import com.example.app.util.Overload;

import org.jetbrains.annotations.NotNull;

public class AlunoVO extends PessoaVO {

    private Double np1;
    private Double np2;
    private Double media;
    private String situacao;

    public AlunoVO(Double np1, Double np2, Double media, String situacao) {
        this.np1 = np1;
        this.np2 = np2;
        this.media = media;
        this.situacao = situacao;
    }

    public AlunoVO() {
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

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Overload
    public void setMedia(String media) {
        try {
            this.media = Double.parseDouble(media);
        } catch (Exception e) {
            this.media = null;
        }
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @NotNull
    @Override
    public String toString() {
        return "Nota 1: " + this.np1 +
                "Nota 2" + this.np2 +
                "Media: " + this.media +
                "Situacao: " + this.situacao;
    }

}
