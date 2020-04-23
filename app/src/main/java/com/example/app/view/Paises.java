package com.example.app.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.PaisesController;

public class Paises extends AppCompatActivity {

    private PaisesController control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        this.initialize();
        control = new PaisesController(this);
    }

    private void initialize() {





        this.onClickListener();
    }

    private void onClickListener() {

    }
}
