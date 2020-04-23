package com.example.app.controller;

import android.widget.ArrayAdapter;

import com.example.app.model.vo.EstadoVO;
import com.example.app.model.vo.PaisVO;
import com.example.app.view.Paises;

import java.util.List;

public class PaisesController {
    private Paises activity;
    private PaisVO p;

    private List<PaisVO> listPais;
    private ArrayAdapter<PaisVO> adapterPais;
    private ArrayAdapter<EstadoVO>adapterEstado;

    public PaisesController(Paises activity) {
        this.activity = activity;
        this.configListView();
    }

    private void configListView() {



        this.addClickCurto();
        this.addClickLongo();
    }

    private void addClickCurto() {
    }

    private void addClickLongo() {
    }

    private PaisVO getResultadoForm(PaisVO p) {
        if (this.p == null){
            p = new PaisVO();
        }

        return this.p;
    }
}
