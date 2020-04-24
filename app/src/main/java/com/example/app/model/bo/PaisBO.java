package com.example.app.model.bo;

import com.example.app.model.vo.PaisVO;

import org.jetbrains.annotations.NotNull;

public class PaisBO {

    public static boolean validarNomePais(@NotNull PaisVO p){
        return p.getNomePais() != null && !p.getNomePais().isEmpty();
    }

    public static boolean validarPaisCollection(@NotNull PaisVO p) {
        return p.getCollectionEstados() != null
                && p.getCollectionEstados().size() >= 1
                && !p.getCollectionEstados().isEmpty();
    }
}
