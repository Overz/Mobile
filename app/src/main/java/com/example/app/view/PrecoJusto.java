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
import com.example.app.controller.PJustoController;

public class PrecoJusto extends AppCompatActivity {

    private EditText editNome;
    private EditText editValor;
    private EditText editParcelas;
    private EditText editJuros;

    private TextView tvResultadoFinal;

    private Button btnVoltar;
    private Button btnCalcular;
    private Button btnLimparDados;

    private PJustoController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preco_justo);
        controller = new PJustoController(this);
        this.initialize();
    }

    private void initialize() {
        this.editNome = findViewById(R.id.editNomeProduto_PrecoJusto);
        this.editValor = findViewById(R.id.editValorProduto_PrecoJusto);
        this.editParcelas = findViewById(R.id.editNumeroParcela_PrecoJusto);
        this.editJuros = findViewById(R.id.editJuros_PrecoJusto);

        this.tvResultadoFinal = findViewById(R.id.tvResultadoFinal_PrecoJusto);

        this.btnVoltar = findViewById(R.id.btnVoltar_PrecoJusto);
        this.btnCalcular = findViewById(R.id.btnCalcular_PrecoJusto);
        this.btnLimparDados = findViewById(R.id.btnLimparDados_PrecoJusto);

        this.onClickListenet();
    }

    private void onClickListenet() {
        this.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.voltarAction();
            }
        });

        this.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                controller.calcularAction();
            }
        });

        this.btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.limparResultadoAction();
            }
        });

    }

    public EditText getEditNome() {
        return editNome;
    }

    public EditText getEditValor() {
        return editValor;
    }

    public EditText getEditParcelas() {
        return editParcelas;
    }

    public EditText getEditJuros() {
        return editJuros;
    }

    public TextView getTvResultadoFinal() {
        return tvResultadoFinal;
    }

    public Button getBtnVoltar() {
        return btnVoltar;
    }

    public Button getBtnCalcular() {
        return btnCalcular;
    }

    public Button getBtnLimparDados() {
        return btnLimparDados;
    }

}
