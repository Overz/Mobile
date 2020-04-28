package com.example.app.controller;

import android.app.AlertDialog;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.model.banco.BaseDAO;
import com.example.app.model.bo.PaisBO;
import com.example.app.model.dao.PaisDAO;
import com.example.app.model.vo.PaisVO;
import com.example.app.model.vo.RegiaoVO;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.CadastroPais;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PaisController {
    private CadastroPais activity;
    private PaisVO p;
    private BaseDAO<PaisVO> daoP;
    private BaseDAO<RegiaoVO> daoR;

    private List<PaisVO> listPais;
    private List<RegiaoVO> listRegiaoPais;
    private ArrayAdapter<PaisVO> adapterPais;
    private ArrayAdapter<RegiaoVO> adapterRegiaoPais;

    public PaisController(CadastroPais activity) {
        this.activity = activity;
        daoP = new PaisDAO(this.activity, PaisVO.class);
        this.configListView();
        this.configSpinner();
    }

    private void configListView() {
        listPais = (List<PaisVO>) daoP.consultarTodos();
        adapterPais = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listPais
        );
        adapterPais.notifyDataSetChanged();
        activity.getLvPais().setAdapter(adapterPais);

        this.addClickCurto();
        this.addClickLongo();
    }

    private void addRegiao() {
        if (daoR.cadastrar(new RegiaoVO(1, "America do Norte")) != null) {
            Log.i("Cadastro Regiao", "1, Cadsatrado");
        }
        if (daoR.cadastrar(new RegiaoVO(2, "America do Central")) != null) {
            Log.i("Cadastro Regiao", "2, Cadsatrado");
        }
        if (daoR.cadastrar(new RegiaoVO(3, "America do Sul")) != null) {
            Log.i("Cadastro Regiao", "3, Cadsatrado");
        }
        if (daoR.cadastrar(new RegiaoVO(4, "Europa")) != null) {
            Log.i("Cadastro Regiao", "4, Cadsatrado");
        }
        if (daoR.cadastrar(new RegiaoVO(5, "Asia")) != null) {
            Log.i("Cadastro Regiao", "5, Cadsatrado");
        }
        if (daoR.cadastrar(new RegiaoVO(6, "Oceania")) != null) {
            Log.i("Cadastro Regiao", "6, Cadsatrado");
        }
    }

    private void configSpinner() {
        this.addRegiao();
        listRegiaoPais = (List<RegiaoVO>) daoR.consultarTodos();
        adapterRegiaoPais = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_spinner_item,
                listRegiaoPais
        );
        adapterPais.notifyDataSetChanged();
        activity.getSpinnerPais().setAdapter(adapterRegiaoPais);
    }

    private void addClickCurto() {
        activity.getLvPais().setOnItemClickListener(
                (parent, view, position, id) -> {
                    this.p = adapterPais.getItem(position);
                    if (this.p != null) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                        alerta.setTitle("Carro");
                        alerta.setMessage(this.p.toString());
                        alerta.setNegativeButton("Fechar", (dialog, which) -> this.p = null);
                        alerta.setPositiveButton("Editar", (dialog, which) -> this.popularForm(this.p));
                        alerta.show();
                    } else {
                        Toast.makeText(activity, "Erro ao Popular o Formulario.", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void addClickLongo() {
        activity.getLvPais().setOnItemLongClickListener(
                (parent, view, position, id) -> {
                    this.p = adapterPais.getItem(position);
                    if (this.p != null) {
                        this.excluirAction();
                    } else {
                        Toast.makeText(activity, "Erro ao Tentar Excluir da Lista.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
        );
    }

    public void cadastrarAction() {
        if (this.p == null) {
            if (this.validarCampos(this.getResultadoForm())) {
                this.cadastrar();
            }
        } else {
            this.editarAction(this.getResultadoForm());
        }
        if (this.validarCampos(this.getResultadoForm())) {
            this.limparForm();
        }
        this.p = null;
        System.gc();
    }

    public void cadastrar() {
        this.p = getResultadoForm();
        PaisVO paisCadastrado = daoP.cadastrar(this.p);
        if (paisCadastrado != null) {
            adapterPais.add(paisCadastrado);
        } else {
            Toast.makeText(activity, "Erro ao Cadastrar:" + p.toString2(), Toast.LENGTH_SHORT).show();
        }
        Log.i("Cadastrando", "Cadastrando: " + getResultadoForm().toString());
        Toast.makeText(activity, "Pais Cadastrado:" + p.toString(), Toast.LENGTH_SHORT).show();
    }

    private void editarAction(@NotNull PaisVO newPais) {
        this.p.setNomePais(newPais.getNomePais());
        this.p.setCapital(newPais.getCapital());
        this.p.setRegiaoVO(newPais.getRegiaoVO());

        adapterPais.notifyDataSetChanged();
        int i = daoP.alterar(this.p);
        Toast.makeText(activity, "Pais Alterado:" + p.toString2() + "\nLinhas Alteradas: " + i, Toast.LENGTH_SHORT).show();
        Log.i("Alterando", "Alterando: " + newPais.toString());
    }

    private void excluirAction() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluindo Carro");
        alerta.setMessage("Deseja Realmente Excluir: '" + p.toString2() + "' Desta Lista?");
        alerta.setIcon(android.R.drawable.ic_menu_delete);
        alerta.setNegativeButton("Não", (dialog, which) -> this.p = null);
        // Deletar
        alerta.setPositiveButton("Sim", (dialog, which) -> {
            int i = daoP.excluir(this.p);
            Toast.makeText(activity, "Estado Excluido:" + p.toString2() + "\ni: " + i, Toast.LENGTH_SHORT).show();
            Log.i("Excluindo", "Excluido");
            adapterPais.remove(this.p);
            this.p = null;
        });
        alerta.show();
    }

    private void popularForm(PaisVO p) {
        if (p != null) {
            activity.getEditNomePais().setText(p.getNomePais());
            activity.getEditCapital().setText(p.getCapital());
            try {
                activity.getSpinnerPais().setSelection(
                        Integer.parseUnsignedInt(
                                String.valueOf(p.getRegiaoVO())
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(activity, "Erro ao Tentar popular o Formulario", Toast.LENGTH_SHORT).show();
        }
    }

    private void teste() {
        String compareValue = (String) activity.getSpinnerPais().getSelectedItem();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                activity, R.array.select_state, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activity.getSpinnerPais().setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            activity.getSpinnerPais().setSelection(spinnerPosition);
        }
    }

    @NotNull
    private PaisVO getResultadoForm() {
        PaisVO pais = new PaisVO();
        pais.setNomePais(activity.getEditNomePais().getText().toString());
        pais.setCapital(activity.getEditCapital().getText().toString());
        pais.getRegiaoVO().setRegiao_localizacao(activity.getSpinnerPais().getSelectedItem());
        return pais;
    }

    private boolean validarCampos(PaisVO p) {
        if (!PaisBO.validarNomePais(p)) {
            activity.getEditNomePais().setError("Erro ao Validar Nome do Pais");
            activity.getEditNomePais().requestFocus();
            return false;
        }
        if (!PaisBO.validarCapital(p)) {
            activity.getEditCapital().setError("Erro ao Validar Nome do Pais");
            activity.getEditCapital().requestFocus();
            return false;
        }
        return true;
    }

    private void limparForm() {
        activity.getEditNomePais().setText("");
        activity.getEditCapital().setText("");
        this.clearFocus();
        MetodoAuxiliar.hideKeyboard(activity);
    }

    public void limparDadosAction() {
        activity.getSpinnerPais().setSelection(1);
//        activity.getLvPais().removeAllViews();
    }

    private void clearFocus() {
        activity.getEditNomePais().clearFocus();
        activity.getEditCapital().clearFocus();
        activity.getSpinnerPais().clearFocus();
        activity.getLvPais().clearFocus();
    }

    public void voltarAction() {
        Toast.makeText(this.activity, R.string.voltando, Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }

}
