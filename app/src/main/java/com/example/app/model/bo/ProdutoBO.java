package com.example.app.model.bo;

import com.example.app.model.vo.ProdutoVO;
import com.example.app.util.Constantes;

import org.jetbrains.annotations.NotNull;

public class ProdutoBO {

    public static boolean validarNome(@NotNull ProdutoVO p) {
        return (p.getNomeProduto() != null && !(p.getNomeProduto().isEmpty()));
    }

    public static boolean validarValor(@NotNull ProdutoVO p) {
        return (p.getValor() != null && (p.getValor() >= Constantes.MINIMO));
    }

    public static boolean validarParcela(@NotNull ProdutoVO p) {
        return (p.getNumeroParcela() != null && (p.getNumeroParcela() <= Constantes.PACELA_MAX));
    }

    public static boolean validarJuros(@NotNull ProdutoVO p) {
        return (p.getJuros() != null && (p.getJuros() <= Constantes.MAXIMO));
    }

    /**
     * Calcula o Juros:  valorInicial * Juros
     *
     * @param p ProdutoVO
     * @return juros
     */
    @NotNull
    public static Double calcularJuros(@NotNull ProdutoVO p) {
        return (p.getValor() * (p.getJuros() / 100));
    }

    /**
     * Calcula a Entrada: Total - (juros * 5%)
     *
     * @param p ProdutoVO
     * @return valor com Entrada
     */
    @NotNull
    public static Double calcularTotalEntrada(ProdutoVO p) {
        return (calcularTotal(p) - (calcularJuros(p) * 0.55));
    }

    /**
     * Calcula a Parcela com Entrada: (TotalEntrada - NumberoParcela)
     *
     * @param p ProdutoVO
     * @return valor da Parcela com Entrada
     */
    @NotNull
    public static Double calcularParcelaEntrada(ProdutoVO p) {
        return (calcularTotalEntrada(p) / p.getNumeroParcela());
    }

    /**
     * Calcula a Parcela:  ((Juros + valorInicial) / NumeroParcelas)
     *
     * @param p ProdutoVO
     * @return parcelas + Juros sobre valorInicial
     */
    @NotNull
    public static Double calcularPacela(ProdutoVO p) {
        return ((calcularJuros(p) + p.getValor()) / p.getNumeroParcela());
    }

    /**
     * Calcula o Total:  valorInicial * Juros;
     *
     * @param p ProdutoVO
     * @return valorTotal
     */
    @NotNull
    public static Double calcularTotal(@NotNull ProdutoVO p) {
        return (p.getValor() + calcularJuros(p));
    }

}
