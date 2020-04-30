package com.example.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.MainController;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainController = new MainController(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainController.activityResumed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainController.activityResumed();
        mainController.recreate(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainController.activityPaused();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainController.activityPaused();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClick(@NotNull View view) {
        Intent it;
        switch (view.getId()) {
            case R.id.btnCalcularMedia_Main:
                it = new Intent(this, CalcularMedia.class);
                startActivity(it);
                break;
            case R.id.btnPrecoJusto_Main:
                it = new Intent(this, PrecoJusto.class);
                startActivity(it);
                break;
            case R.id.btnAutonomia_Main:
                it = new Intent(this, Autonomia.class);
                startActivity(it);
                break;
            case R.id.btnCalculadora_Main:
                it = new Intent(this, Calculadora.class);
                startActivity(it);
                break;
            case R.id.btnMtJusto_Main:
                it = new Intent(this, MuitoJusto.class);
                startActivity(it);
                break;
            case R.id.btnPaises_Main:
                it = new Intent(this, Cadastro_EstadosPaises.class);
                startActivity(it);
        }
        System.gc();
    }

}
