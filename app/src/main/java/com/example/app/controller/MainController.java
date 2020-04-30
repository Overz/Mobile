package com.example.app.controller;

import android.app.Activity;
import android.util.Log;

import com.example.app.view.CadastroPais;
import com.example.app.view.Cadastro_EstadosPaises;
import com.example.app.view.MainActivity;

import org.jetbrains.annotations.NotNull;

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

    public void recreate(@NotNull Activity activity) {
        if (activity instanceof CadastroPais && isActivityVisible()) {
            if (this.acitivityPaises.isFinishing()) {
                if (this.acitivityEstados.getControl().deletarTeste()) {
                    this.acitivityEstados.getControl().refreshData();
                    System.out.println("Estados Atualizados");
                    Log.i("RECREATE", "Estados Atualizados");
                }
            }
        }
        if (activity instanceof Cadastro_EstadosPaises && activityVisible) {
            if (this.acitivityEstados.isFinishing()) {
                this.acitivityPaises.getControl().refreshData();
                System.out.println("Paises Atualizados");
                Log.i("RECREATE", "Paises Atualizados");

            }
        }
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
