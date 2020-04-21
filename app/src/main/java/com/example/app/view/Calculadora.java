package com.example.app.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.CalcController;

public class Calculadora extends AppCompatActivity {

    private EditText editTextNota1;
    private EditText editTextNota2;

    private LinearLayout layoutResultCalculo;

    private Button btnAdicao;
    private Button btnSubtracao;
    private Button btnMultiplicacao;
    private Button btnDivisao;
    private Button btnVoltar;
    private Button btnLimparDados;

    private CalcController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        controller = new CalcController(this);
        this.initialize();
    }

    private void initialize() {
        editTextNota1 = findViewById(R.id.editNota01_Calculadora);
        editTextNota2 = findViewById(R.id.editNota02_Calculadora);
        layoutResultCalculo = findViewById(R.id.layoutResultado_Calculadora);

        btnVoltar = findViewById(R.id.btnVoltar_Calculadora);
        btnLimparDados = findViewById(R.id.btnLimparDados_Calculadora);

        btnAdicao = findViewById(R.id.btnAdicao_Calculadora);
        btnSubtracao = findViewById(R.id.btnSubtracao_Calculadora);
        btnMultiplicacao = findViewById(R.id.btnMultiplicacao_Calculadora);
        btnDivisao = findViewById(R.id.btnDivisao_Calculadora);

        this.onClickListener();
    }

    private void onClickListener() {
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.voltarAction();
            }
        });

        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.limparResultados();
            }
        });

        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.somarAction();
            }
        });

        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.subtrairAction();
            }
        });

        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.multiplicarAction();
            }
        });

        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.dividirAction();
            }
        });
    }

    public EditText getEditTextNota1() {
        return editTextNota1;
    }

    public EditText getEditTextNota2() {
        return editTextNota2;
    }

    public LinearLayout getLayoutResultCalculo() {
        return layoutResultCalculo;
    }

    public Button getBtnAdicao() {
        return btnAdicao;
    }

    public Button getBtnSubtracao() {
        return btnSubtracao;
    }

    public Button getBtnMultiplicacao() {
        return btnMultiplicacao;
    }

    public Button getBtnDivisao() {
        return btnDivisao;
    }

    public Button getBtnVoltar() {
        return btnVoltar;
    }

    public Button getBtnLimparDados() {
        return btnLimparDados;
    }
}