package com.example.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.EstadoController;

public class Cadastro_EstadosPaises extends AppCompatActivity {

    private EstadoController control;

    private Button btnCadastrar, btnVoltar;
    private EditText editNomeEstado, editUF;
    private Spinner spinnerPaises;
    private ImageButton imgBtn;
    private ListView lvEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados);
        this.initialize();
        control = new EstadoController(this);
    }

    private void initialize() {
        this.btnVoltar = findViewById(R.id.btnVoltar_Estado);
        this.btnCadastrar = findViewById(R.id.btnCadastrar_Estados);
        this.editNomeEstado = findViewById(R.id.editNome_Estados);
        this.editUF = findViewById(R.id.editUf_Estados);
        this.spinnerPaises = findViewById(R.id.spinner_Pais);
        this.imgBtn = findViewById(R.id.imageButton_Pais);
        this.lvEstados = findViewById(R.id.lvEstados_Estados);

        this.onClickListener();
    }

    private void onClickListener() {
        this.btnVoltar.setOnClickListener(v -> control.voltarAction());
        this.btnCadastrar.setOnClickListener(v -> control.salvarAction());
        this.imgBtn.setOnClickListener(v -> {
            Intent it;
            it = new Intent(this, CadastroPais.class);
            startActivity(it);
        });
    }

    public EditText getEditNomeEstado() {
        return editNomeEstado;
    }

    public EditText getEditUF() {
        return editUF;
    }

    public Spinner getSpinnerPaises() {
        return spinnerPaises;
    }

    public ImageButton getImgBtn() {
        return imgBtn;
    }

    public ListView getLvEstados() {
        return lvEstados;
    }
}
