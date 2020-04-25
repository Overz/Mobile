package com.example.app.controller;

import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.model.bo.EstadoBO;
import com.example.app.model.vo.EstadoVO;
import com.example.app.model.vo.PaisVO;
import com.example.app.view.Paises;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EstadoController {
    private Paises activity;
    private EstadoVO e;

    private List<EstadoVO> listPais;
    private ArrayAdapter<PaisVO> adapterPais;
    private ArrayAdapter<EstadoVO> adapterEstado;

    public EstadoController(Paises activity) {
        this.activity = activity;
        this.configListView();

        //TODO
    }

    //TODO
    private void configListView() {

        //TODO

        this.addClickCurto();
        this.addClickLongo();
    }

    //TODO
    private void configSpinner() {

        //TODO
    }

    private void addClickCurto() {
        activity.getLvEstados().setOnItemClickListener(
                (parent, view, position, id) -> {
                    this.e = adapterEstado.getItem(position);
                    if (this.e != null) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                        alerta.setTitle("Carro");
                        alerta.setMessage(this.e.toString());
                        alerta.setNegativeButton("Fechar", (dialog, which) -> this.e = null);
                        alerta.setPositiveButton("Editar", (dialog, which) -> this.popularForm(this.e));
                        alerta.show();
                    } else {
                        Toast.makeText(activity, "Erro ao Popular o Formulario.", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void addClickLongo() {
        activity.getLvEstados().setOnItemLongClickListener(
                (parent, view, position, id) -> {
                    this.e = adapterEstado.getItem(position);
                    if (this.e != null) {
                        this.excluirAction();
                    } else {
                        Toast.makeText(activity, "Erro ao Tentar Excluir da Lista.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
        );
    }

    public void salvarAction() {
        if (this.e == null) {
            if (this.validarCampos(this.getResultadoForm())) {
                this.cadastrar();
            }
        } else {
            this.editarAction(getResultadoForm());
        }
        this.limparTudo();
    }

    //TODO
    private void cadastrar() {
        adapterEstado.add(getResultadoForm());
        this.limparForm();
    }

    //TODO
    private void editarAction(@NotNull EstadoVO newEstado) {
        this.e.setNomeEstado(newEstado.getNomeEstado());
        this.e.setUf(newEstado.getUf());
        adapterEstado.notifyDataSetChanged();
        this.e = null;

        //TODO
    }

    //TODO
    private void excluirAction() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluindo Carro");
        alerta.setMessage("Deseja Realmente Excluir: '" + e.toString() + "' Desta Lista?");
        alerta.setIcon(android.R.drawable.ic_menu_delete);
        alerta.setNegativeButton("Não", (dialog, which) -> this.e = null);
        // Deletar
        alerta.setPositiveButton("Sim", (dialog, which) -> {
            adapterEstado.remove(e);
            this.e = null;
        });
        alerta.show();
    }

    private void popularForm(EstadoVO e) {
        if (e != null) {
            activity.getEditNomeEstado().setText(e.getNomeEstado());
            activity.getEditUF().setText(e.getUf());
        } else {
            Toast.makeText(activity, "Erro ao Tentar popular o Formulario", Toast.LENGTH_SHORT).show();
        }
    }

    private EstadoVO getResultadoForm() {
        e = new EstadoVO();
        e.setNomeEstado(activity.getSpinnerPaises().getSelectedItem().toString());
        e.setUf(activity.getEditUF().getText().toString());
        e.setPaisVO((PaisVO) activity.getSpinnerPaises().getSelectedItem());
        return e;
    }

    private boolean validarCampos(EstadoVO e) {
        if (!EstadoBO.validarNomeEstado(e)) {
            activity.getEditNomeEstado().setError("Erro ao Validar o Nome do Estado.");
            activity.getEditNomeEstado().requestFocus();
            return false;
        }
        if (!EstadoBO.validarEstadoUF(e)) {
            activity.getEditUF().setError("UF Invalido, Digite novamente.");
            activity.getEditUF().requestFocus();
            return false;
        }

        //TODO

        return true;
    }

    private void limparForm() {
        activity.getEditUF().setText("");
        activity.getEditNomeEstado().setText("");
        activity.getSpinnerPaises().setSelection(-1);
    }

    private void limparTudo() {
        this.limparForm();
        this.clearFocus();
        adapterEstado.clear();
        adapterPais.clear();
        e = null;
        System.gc();
    }

    private void clearFocus() {
        activity.getEditNomeEstado().clearFocus();
        activity.getEditUF().clearFocus();
        activity.getSpinnerPaises().clearFocus();
        activity.getLvEstados().clearFocus();
    }

    public void voltarAction() {
        Toast.makeText(this.activity, R.string.voltando, Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }



}
