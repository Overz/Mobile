package com.example.app.controller;

import android.app.Activity;

import com.example.app.view.CadastroPais;
import com.example.app.view.Cadastro_EstadosPaises;
import com.example.app.view.MainActivity;

public class MainController {
    private static boolean activityVisible;
    private MainActivity mainActivity;
    private Cadastro_EstadosPaises acitivityEstados;
    private CadastroPais acitivityPaises;


    public MainController(Activity activity) {
        if (activity instanceof MainActivity) {
            this.mainActivity = (MainActivity) activity;
        }
        if (activity instanceof Cadastro_EstadosPaises) {
            this.acitivityEstados = (Cadastro_EstadosPaises) activity;
        }
        if (activity instanceof CadastroPais) {
            this.acitivityPaises = (CadastroPais) activity;
        }
    }

    public MainController() {
    }

    static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }
}
