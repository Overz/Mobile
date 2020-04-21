package com.example.app.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.AutonomiaController;

public class Autonomia extends AppCompatActivity {

    private EditText editModelo;
    private EditText editKm;
    private EditText editCombustivel;

    private TextView tvConsumoFrota;
    private ListView listView;

    private Button btnVoltar;
    private Button btnCalcular;
    private Button btnLimparDados;

    private AutonomiaController controller;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomia);
        controller = new AutonomiaController(this);
        this.initialize();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void initialize() {
        this.editModelo = findViewById(R.id.editModeloCarro_Autonomia);
        this.editKm = findViewById(R.id.editKmPercorrido_Autonomia);
        this.editCombustivel = findViewById(R.id.editCombustivel_Autonomia);
        this.tvConsumoFrota = findViewById(R.id.tvConsumoFrota);
        this.listView = findViewById(R.id.listView_Autonomia);
        this.btnVoltar = findViewById(R.id.btnVoltar_Autonomia);
        this.btnCalcular = findViewById(R.id.btnCalcular_Autonomia);
        this.btnLimparDados = findViewById(R.id.btnLimparDados_Autonomia);

        this.onClickListener();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void onClickListener(){
        btnVoltar.setOnClickListener(v -> controller.voltarAction());

        btnCalcular.setOnClickListener(v -> controller.calcularAction());

        btnLimparDados.setOnClickListener(v -> controller.limparResultados());
    }

    public EditText getEditModelo() {
        return editModelo;
    }

    public EditText getEditKm() {
        return editKm;
    }

    public EditText getEditCombustivel() {
        return editCombustivel;
    }

    public TextView getTvConsumoFrota() {
        return tvConsumoFrota;
    }

    public ListView getListView() {
        return listView;
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
