package com.example.app.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.PaisController;

public class CadastroPais extends AppCompatActivity {

    private PaisController control;

    private EditText editNomePais, editCapital /*, editRegiao*/;
    private Button btnVoltar, btnCadastrar, btnLimpar;
    private ListView lvPais;
    private Spinner spinnerPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        this.initialize();
        control = new PaisController(this);
    }

    private void initialize() {
        this.editNomePais = findViewById(R.id.editNome_Pais);
        this.editCapital = findViewById(R.id.editCapital_Pais);
//        this.editRegiao = findViewById(R.id.editRegiao);
        this.lvPais = findViewById(R.id.lvPaises);
        this.spinnerPais = findViewById(R.id.spinner_Paises);
        this.btnVoltar = findViewById(R.id.btnVoltar_Pais);
        this.btnCadastrar = findViewById(R.id.btnCadastrar_Pais);
        this.btnLimpar = findViewById(R.id.btnLimparDados_Pais);

        this.onClickListener();
    }

    private void onClickListener() {
        this.btnVoltar.setOnClickListener(v -> control.voltarAction());
        this.btnCadastrar.setOnClickListener(v -> control.cadastrarAction());
        this.btnLimpar.setOnClickListener(v -> control.limparFormAction());
    }

    public EditText getEditNomePais() {
        return editNomePais;
    }

    public EditText getEditCapital() {
        return editCapital;
    }

//    public EditText getEditRegiao() {
//        return editRegiao;
//    }

    public Button getBtnVoltar() {
        return btnVoltar;
    }

    public Button getBtnCadastrar() {
        return btnCadastrar;
    }

    public Button getBtnLimpar() {
        return btnLimpar;
    }

    public ListView getLvPais() {
        return lvPais;
    }

    public Spinner getSpinnerPais() {
        return spinnerPais;
    }
}
