package com.example.app.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.CalcController;

public class Calculadora extends AppCompatActivity {

    private EditText editTextNota1, editTextNota2;
    private Button btnAdicao, btnSubtracao, btnMultiplicacao, btnDivisao, btnVoltar, btnLimparDados;
    private ListView listView;

    private CalcController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        this.initialize();
        controller = new CalcController(this);
    }

    private void initialize() {
        editTextNota1 = findViewById(R.id.editNota01_Calculadora);
        editTextNota2 = findViewById(R.id.editNota02_Calculadora);

        listView = findViewById(R.id.listView_Calculadora);

        btnVoltar = findViewById(R.id.btnVoltar_Calculadora);
        btnLimparDados = findViewById(R.id.btnLimparDados_Calculadora);

        btnAdicao = findViewById(R.id.btnAdicao_Calculadora);
        btnSubtracao = findViewById(R.id.btnSubtracao_Calculadora);
        btnMultiplicacao = findViewById(R.id.btnMultiplicacao_Calculadora);
        btnDivisao = findViewById(R.id.btnDivisao_Calculadora);

        this.onClickListener();
    }

    private void onClickListener() {
        btnVoltar.setOnClickListener(v -> controller.voltarAction());

        btnLimparDados.setOnClickListener(v -> controller.limparResultadosAction());

        btnAdicao.setOnClickListener(v -> controller.salvarAction());

        btnSubtracao.setOnClickListener(v -> controller.salvarAction());

        btnMultiplicacao.setOnClickListener(v -> controller.salvarAction());

        btnDivisao.setOnClickListener(v -> controller.salvarAction());
    }

    public EditText getEditTextNota1() {
        return editTextNota1;
    }

    public EditText getEditTextNota2() {
        return editTextNota2;
    }

    public ListView getListView() {
        return listView;
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