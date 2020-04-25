package com.example.app.controller;

import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.model.banco.BaseDAO;
import com.example.app.model.bo.EstadoBO;
import com.example.app.model.dao.EstadoDAO;
import com.example.app.model.dao.PaisDAO;
import com.example.app.model.vo.EstadoVO;
import com.example.app.model.vo.PaisVO;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.Paises;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EstadoController {
    private Paises activity;
    private EstadoVO e;
    private BaseDAO<EstadoVO> daoE;
    private BaseDAO<PaisVO> daoP;

    private List<EstadoVO> listEstados;
    private List<PaisVO> listPais;
    private ArrayAdapter<PaisVO> adapterPaises;
    private ArrayAdapter<EstadoVO> adapterEstados;

    public EstadoController(Paises activity) {
        this.activity = activity;
        daoE = new EstadoDAO(this.activity, EstadoVO.class);
        daoP = new PaisDAO(this.activity, PaisVO.class);
        this.configListView();
        this.configSpinner();

        //TODO
    }

    //TODO
    private void configListView() {
        daoE.cadastrar(new EstadoVO(1, "Santa Catarina", "SC"));
        daoE.cadastrar(new EstadoVO(2, "Rio Grande do Sul", "RS"));
        daoE.cadastrar(new EstadoVO(3, "Parana", "PR"));

        listEstados = (List<EstadoVO>) daoE.consultarTodos();
        adapterEstados = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listEstados
        );
        activity.getLvEstados().setAdapter(adapterEstados);

        this.addClickCurto();
        this.addClickLongo();
    }

    //TODO
    private void configSpinner() {
        daoP.cadastrar(new PaisVO(1, "Brasil"));
        daoP.cadastrar(new PaisVO(2, "Argentina"));
        daoP.cadastrar(new PaisVO(3, "Uruguai"));

        adapterPaises = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_spinner_item,
                (List<PaisVO>) daoP.consultarTodos()
        );
        activity.getSpinnerPaises().setAdapter(adapterPaises);
    }

    private void addClickCurto() {
        activity.getLvEstados().setOnItemClickListener(
                (parent, view, position, id) -> {
                    this.e = adapterEstados.getItem(position);
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
                    this.e = adapterEstados.getItem(position);
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
        adapterEstados.add(getResultadoForm());
        this.limparForm();
    }

    //TODO
    private void editarAction(@NotNull EstadoVO newEstado) {
        this.e.setNomeEstado(newEstado.getNomeEstado());
        this.e.setUf(newEstado.getUf());
        adapterEstados.notifyDataSetChanged();
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
            adapterEstados.remove(e);
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
        MetodoAuxiliar.hideKeyboard(activity);
//        adapterEstados.clear();
//        adapterPaises.clear();
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
