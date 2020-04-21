package com.example.app.model.bo;

import com.example.app.model.vo.CalculadoraVO;

import org.jetbrains.annotations.NotNull;

public class CalculadoraBO {

    @NotNull
    public static Double adicao(@NotNull CalculadoraVO c) {
        return c.getNp1() + c.getNp2();
    }

    @NotNull
    public static Double subrair(@NotNull CalculadoraVO c) {
        return c.getNp1() - c.getNp2();
    }

    @NotNull
    public static Double multiplicar(@NotNull CalculadoraVO c) {
        return c.getNp1() * c.getNp2();
    }

    @NotNull
    public static Double dividir(@NotNull CalculadoraVO c) {
        return c.getNp1() / c.getNp2();
    }

    public static boolean validarNp1(@NotNull CalculadoraVO c) {
        return (c.getNp1() != null);
    }

    public static boolean validarNp2(@NotNull CalculadoraVO c) {
        return (c.getNp2() != null);
    }
}
