package com.example.app.controller;

import android.app.AlertDialog;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.model.banco.BaseDAO;
import com.example.app.model.bo.EstadoBO;
import com.example.app.model.dao.EstadoDAO;
import com.example.app.model.dao.PaisDAO;
import com.example.app.model.dao.RegiaoDAO;
import com.example.app.model.vo.EstadoVO;
import com.example.app.model.vo.PaisVO;
import com.example.app.model.vo.RegiaoVO;
import com.example.app.util.Constantes;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.Cadastro_EstadosPaises;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EstadoController {
    private Cadastro_EstadosPaises activity;
    private EstadoVO e;
    private BaseDAO<RegiaoVO> daoR;
    private BaseDAO<EstadoVO> daoE;
    private BaseDAO<PaisVO> daoP;

    private ArrayAdapter<PaisVO> adapterPaises;
    private ArrayAdapter<EstadoVO> adapterEstados;

    public EstadoController(Cadastro_EstadosPaises activity) {
        this.activity = activity;
        daoE = new EstadoDAO(this.activity, EstadoVO.class);
        daoP = new PaisDAO(this.activity, PaisVO.class);
        daoR = new RegiaoDAO(this.activity, RegiaoVO.class);
        this.addPaises();
        this.configListView();
        this.configSpinner();
        this.refreshData();
    }

    private void addTeste() {
        RegiaoVO rCadastrado;
        PaisVO pCadastrado;
        EstadoVO eCadastrado;

        try {
            rCadastrado = daoR.cadastrar(new RegiaoVO(1, "_regiao_teste"));
            pCadastrado = daoP.cadastrar(new PaisVO(1, "_nome_pais_", "_nome_capital_", rCadastrado));
            eCadastrado = daoE.cadastrar(new EstadoVO(1, "_nome_estado_", "TS", pCadastrado));

            if (rCadastrado != null && pCadastrado != null && eCadastrado != null) {
                System.out.println("Dados de Teste Cadastrados");
                Log.i("Cadastrado", "Dados de: Estado, Pais, Regiao, cadastrados");
            }
        } catch (Exception e) {
            Log.e("DB_CREATE_ERRO", "Erro ao Cadastrar os Dados no Sistema");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    private void addPaises() {
        if (daoP.cadastrar(new PaisVO(1, "Brasil", "Brasilia", new RegiaoVO(1, "America do Sul"))) != null) {
            Log.i("Cadastro Pais", "1, Cadsatrado");
        } else {
            Log.e("DB_CREATE_ERRO", "ERRO AO CRIAR OS PAISES EM 'addPaises()'");
        }
        if (daoP.cadastrar(new PaisVO(2, "Argentina", "Buenos Aires", new RegiaoVO(1, "America do Sul"))) != null) {
            Log.i("Cadastro Pais", "2, Cadsatrado");
        } else {
            Log.e("DB_CREATE_ERRO", "ERRO AO CRIAR OS PAISES EM 'addPaises()'");
        }
        if (daoP.cadastrar(new PaisVO(3, "Uruguai", "Montevideo", new RegiaoVO(1, "America do Sul"))) != null) {
            Log.i("Cadastro Pais", "3, Cadsatrado");
        } else {
            Log.e("DB_CREATE_ERRO", "ERRO AO CRIAR OS PAISES EM 'addPaises()'");
        }
        if (daoP.cadastrar(new PaisVO(4, "Japao", "Toquio", new RegiaoVO(5, "Asia"))) != null) {
            Log.i("Cadastro Pais", "4, Cadsatrado");
        } else {
            Log.e("DB_CREATE_ERRO", "ERRO AO CRIAR OS PAISES EM 'addPaises()'");
        }
    }

    private void configListView() {
        List<EstadoVO> listEstados = (List<EstadoVO>) daoE.consultarTodos();
        adapterEstados = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listEstados
        );
        adapterEstados.notifyDataSetChanged();
        activity.getLvEstados().setAdapter(adapterEstados);

        this.addClickCurto();
        this.addClickLongo();
    }

    private void configSpinner() {
        List<PaisVO> listPais = (List<PaisVO>) daoP.consultarColunas(Constantes.DB_PAIS_NOME, Constantes.DB_PAIS_CAPITAL);
        adapterPaises = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_spinner_dropdown_item,
                listPais
        );
        adapterPaises.notifyDataSetChanged();
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
            this.editarAction(this.getResultadoForm());
        }
        if (this.validarCampos(this.getResultadoForm())) {
            this.limparForm();
        }
        this.e = null;
        System.gc();
    }

    private void cadastrar() {
        this.e = getResultadoForm();
        EstadoVO estadoCadastrado = daoE.cadastrar(this.e);
        if (estadoCadastrado != null) {
            adapterEstados.add(estadoCadastrado);
        } else {
            Toast.makeText(activity, "Erro ao Cadastrar:" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.e("DB_INSERT_ERRO", "Cadastro: " + getResultadoForm().toString());
        }
        this.refreshData();
        Log.i("Cadastrando", "Cadastrando: " + getResultadoForm().toString());
        Toast.makeText(activity, "Estado Cadastrado:" + e.toString(), Toast.LENGTH_SHORT).show();
    }

    private void editarAction(@NotNull EstadoVO newEstado) {
        this.e.setNomeEstado(newEstado.getNomeEstado());
        this.e.setUf(newEstado.getUf());
        this.e.setPaisVO(newEstado.getPaisVO());

        int i = daoE.alterar(this.e);
        this.refreshData();
        Toast.makeText(activity, "Estado Alterado:" + e.toString() + "\nLinhas Alteradas: " + i, Toast.LENGTH_SHORT).show();
        Log.i("Alterando", "Alterando: " + newEstado.toString());
    }

    private void excluirAction() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluindo Carro");
        alerta.setMessage("Deseja Realmente Excluir: '" + e.toString() + "' Desta Lista?");
        alerta.setIcon(android.R.drawable.ic_menu_delete);
        alerta.setNegativeButton("Não", (dialog, which) -> this.e = null);
        // Deletar
        alerta.setPositiveButton("Sim", (dialog, which) -> {
            int i = daoE.excluirPorID(this.e.getId());
            Toast.makeText(activity, "Estado Excluido:" + e.toString() + "\ni: " + i, Toast.LENGTH_SHORT).show();
            Log.i("Excluindo", "Excluido");

            adapterEstados.remove(this.e);

            this.refreshData();
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

    @NotNull
    private EstadoVO getResultadoForm() {
        EstadoVO estado = new EstadoVO();
        estado.setNomeEstado(activity.getEditNomeEstado().getText().toString());
        estado.setUf(activity.getEditUF().getText().toString());
        estado.setPaisVO((PaisVO) activity.getSpinnerPaises().getSelectedItem());
        return estado;
    }

    private boolean validarCampos(EstadoVO e) {
        if (!EstadoBO.validarNomeEstado(e)) {
            activity.getEditNomeEstado().setError("Erro ao Validar o Nome do Estado.");
            activity.getEditNomeEstado().requestFocus();
            return false;
        }
        if (!EstadoBO.validarEstadoUF(e)) {
            activity.getEditUF().setError("UF Invalido, Use 2 Caracteres.");
            activity.getEditUF().requestFocus();
            return false;
        }
        return true;
    }

    private void limparForm() {
        activity.getEditUF().setText("");
        activity.getEditNomeEstado().setText("");
        activity.getSpinnerPaises().setSelection(-1);
        this.clearFocus();
        this.refreshData();
        MetodoAuxiliar.hideKeyboard(activity);
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

    public void refreshData() {
        this.adapterPaises.notifyDataSetChanged();
        this.adapterEstados.notifyDataSetChanged();
    }

}
