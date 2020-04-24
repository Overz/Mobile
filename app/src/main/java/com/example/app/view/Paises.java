package com.example.app.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.EstadoController;

public class Paises extends AppCompatActivity {

    private EstadoController control;

    private Button btnCadastrar, btnVoltar;
    private EditText editNomeEstado, editUF;
    private Spinner spinnerPaises;
    private ImageButton imgBtn;
    private ListView lvEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        this.initialize();
        control = new EstadoController(this);
    }

    private void initialize() {
        this.btnVoltar = findViewById(R.id.btnVoltar_Pais);
        this.btnCadastrar = findViewById(R.id.btnCadastrar_Pais);
        this.editNomeEstado = findViewById(R.id.editNomeEstado_Pais);
        this.editUF = findViewById(R.id.editUf_Pais);
        this.spinnerPaises = findViewById(R.id.spinner_Pais);
        this.imgBtn = findViewById(R.id.imageButton_Pais);
        this.lvEstados = findViewById(R.id.lvEstados_Pais);

        this.onClickListener();
    }

    private void onClickListener() {
        this.btnVoltar.setOnClickListener(v -> control.voltarAction());
        this.btnCadastrar.setOnClickListener(v -> control.salvarAction());
    }

    public EstadoController getControl() {
        return control;
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
