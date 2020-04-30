package com.example.app.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.MainController;
import com.example.app.controller.PaisController;

public class CadastroPais extends AppCompatActivity {

    private MainController mainController;
    private PaisController control;

    private EditText editNomePais, editCapital;
    private Button btnVoltar, btnCadastrar;
    private ListView lvPais;
    private Spinner spinnerPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        this.initialize();
        control = new PaisController(this);
        mainController = new MainController(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainController.activityResumed();
        control.refreshData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.control.refreshData();
        MainController.activityResumed();
    }

    @Override
    protected void onPause() {
        MainController.activityPaused();
        control.refreshData();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainController.activityPaused();
        control.refreshData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        control.refreshData();
    }

    private void initialize() {
        this.editNomePais = findViewById(R.id.editNome_Pais);
        this.editCapital = findViewById(R.id.editCapital_Pais);
        this.lvPais = findViewById(R.id.lvPaises);
        this.spinnerPais = findViewById(R.id.spinner_Paises);
        this.btnVoltar = findViewById(R.id.btnVoltar_Pais);
        this.btnCadastrar = findViewById(R.id.btnCadastrar_Pais);

        this.onClickListener();
    }

    private void onClickListener() {
        this.btnVoltar.setOnClickListener(v -> control.voltarAction());
        this.btnCadastrar.setOnClickListener(v -> control.cadastrarAction());
    }

    public PaisController getControl() {
        return control;
    }

    public EditText getEditNomePais() {
        return editNomePais;
    }

    public EditText getEditCapital() {
        return editCapital;
    }

    public Button getBtnVoltar() {
        return btnVoltar;
    }

    public Button getBtnCadastrar() {
        return btnCadastrar;
    }

    public ListView getLvPais() {
        return lvPais;
    }

    public Spinner getSpinnerPais() {
        return spinnerPais;
    }
}
