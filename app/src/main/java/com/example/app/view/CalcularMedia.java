package com.example.app.view;


import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.CalcularMediaController;

public class CalcularMedia extends AppCompatActivity {

    private EditText editNome;
    private EditText editNp1;
    private EditText editNp2;

    private TextView tvResultadoFinal;

    private Button btnVoltar;
    private Button btnCalcular;
    private Button btnLimparDados;

    private CalcularMediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_media);
        controller = new CalcularMediaController(this);
        this.initialize();
    }

    private void initialize() {
        this.editNome = findViewById(R.id.editNome_CalcularMedia);
        this.editNp1 = findViewById(R.id.editNp1_CalcularMedia);
        this.editNp2 = findViewById(R.id.editNp2_CalcularMedia);
        this.tvResultadoFinal = findViewById(R.id.tvResultadoFinal_CalcularMedia);
        this.btnCalcular = findViewById(R.id.btnCalcular_CalcularMedia);
        this.btnLimparDados = findViewById(R.id.btnLimparDados_CalcularMedia);
        this.btnVoltar = findViewById(R.id.btnVoltar_CalcularMedia);

        this.onClickListenter();
    }

    private void onClickListenter(){

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                controller.calcularAction();
            }
        });

        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.limparResultadosAction();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.voltarAction();
            }
        });
    }

    public EditText getEditNome() {
        return this.editNome;
    }

    public EditText getEditNp1() {
        return this.editNp1;
    }

    public EditText getEditNp2() {
        return this.editNp2;
    }

    public TextView getTvResultadoFinal() {
        return this.tvResultadoFinal;
    }

    public Button getBtnVoltar() {
        return this.btnVoltar;
    }

    public Button getBtnCalcular() {
        return this.btnCalcular;
    }

    public Button getBtnLimparDados() {
        return this.btnLimparDados;
    }
}