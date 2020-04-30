package com.example.app.model.bo;

import com.example.app.model.vo.AlunoVO;
import com.example.app.util.Constantes;

import org.jetbrains.annotations.NotNull;

public class AlunoBO {

    public static boolean validarNota(Double nota) {
        return nota != null && nota >= Constantes.MINIMO && nota <= Constantes.MAXIMO;
    }

    @NotNull
    public static Double calcularMedia(@NotNull AlunoVO a) {
        return ((a.getNp1() + a.getNp2()) / 2);
    }

    public static boolean verificarAprovacao(AlunoVO a) {
        return AlunoBO.calcularMedia(a) >= Constantes.MEDIA;
    }

}
