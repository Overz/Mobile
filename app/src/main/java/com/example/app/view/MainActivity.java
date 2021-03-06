package com.example.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
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
                break;
        }
        System.gc();
    }

}
