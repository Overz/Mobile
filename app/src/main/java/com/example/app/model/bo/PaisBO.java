package com.example.app.model.bo;

import com.example.app.model.vo.PaisVO;

import org.jetbrains.annotations.NotNull;

public class PaisBO {

    public static boolean validarNomePais(@NotNull PaisVO p) {
        return p.getNomePais() != null && !p.getNomePais().isEmpty() && p.getCapital().length() <= 100;
    }

    public static boolean validarCapital(@NotNull PaisVO p) {
        return p.getCapital() != null && !p.getCapital().isEmpty() && p.getCapital().length() <= 100;
    }

    public static boolean validarRegiao(@NotNull PaisVO p) {
        return p.getRegiaoVO().getRegiao_localizacao() != null && !p.getRegiaoVO().getRegiao_localizacao().isEmpty() && p.getRegiaoVO().getRegiao_localizacao().length() <= 50;
    }
}
