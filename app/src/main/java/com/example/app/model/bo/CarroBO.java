package com.example.app.model.bo;

import com.example.app.model.vo.CarroVO;
import com.example.app.util.Constantes;

import org.jetbrains.annotations.NotNull;

public class CarroBO {

    public static boolean verificarModelo(@NotNull CarroVO c) {
        return (c.getModelo() != null && !(c.getModelo().isEmpty()));
    }

    public static boolean verificarKm(@NotNull CarroVO c) {
        return (c.getKm() != null && (c.getKm() >= Constantes.MINIMO));
    }

    public static boolean verificarCombustivel(@NotNull CarroVO c) {
        return (c.getCombustivel() != null && (c.getCombustivel() >= Constantes.MINIMO));
    }

    /**
     * Calcula a Media da Frota: (Km_Total / Combustivel_Total)
     *
     * @param c
     * @return Double
     */
    @NotNull
    public static Double calcularMediaFrota(@NotNull CarroVO c) {
        Integer km = 0;
        Double combustivel = 0.0;
        km += c.getKm();
        combustivel += c.getCombustivel();
        return km / combustivel;
    }

    /**
     * Calcular a Media Individual: (Km / Combustivel);
     *
     * @param c
     * @return Double
     */
    @NotNull
    public static Double calcularIndividual(@NotNull CarroVO c) {
        return c.getKm() / c.getCombustivel();
    }
}