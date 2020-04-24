package com.example.app.model.bo;

import com.example.app.model.vo.EstadoVO;

import org.jetbrains.annotations.NotNull;

public class EstadoBO {

    public static boolean validarNomeEstado(@NotNull EstadoVO e) {
        return e.getNomeEstado() != null && !e.getNomeEstado().isEmpty();
    }

    public static boolean validarEstadoUF(@NotNull EstadoVO e) {
        return e.getUf() != null && !e.getUf().isEmpty();
    }

    public static boolean validarPaisObjeto(@NotNull EstadoVO e) {
        return e.getPaisVO() != null;
    }

}
