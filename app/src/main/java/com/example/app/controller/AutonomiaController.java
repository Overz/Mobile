package com.example.app.controller;

import android.app.AlertDialog;
import android.os.Build;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.app.R;
import com.example.app.model.bo.CarroBO;
import com.example.app.model.vo.CarroVO;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.Autonomia;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AutonomiaController {
    private Autonomia activity;

    private ArrayAdapter<CarroVO> adapterCarros;
    private List<CarroVO> listaCarros;

    private CarroVO c;

    public AutonomiaController(Autonomia autonomia) {
        this.activity = autonomia;
        this.configListView();
    }

    private CarroVO getResultadoForm() {
        c.setModelo(activity.getEditModelo().getText().toString());
        c.setKm(activity.getEditKm().getText().toString());
        c.setCombustivel(activity.getEditCombustivel().getText().toString());
        return c;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void calcularAction() {
        c = new CarroVO();

        if (this.verificarCampos(this.getResultadoForm())) {
//            Double individual;
//            String resIndividual = "";
            Double frota = 0.0;
            frota += CarroBO.calcularMediaFrota(c); // Media Total da Frota
            DecimalFormat df = new DecimalFormat("###,##");

            activity.getTvConsumoFrota().setText(activity.getString(R.string.frota, df.format(frota)));
            activity.getTvConsumoFrota().setTextSize(20);
            activity.getTvConsumoFrota().setVisibility(View.VISIBLE);

//            individual = CarroBO.calcularIndividual(c);// Media Individual por Carro
//            resIndividual += activity.getString(R.string.carros, c.getModelo(), individual.toString());
//            this.addResultadoDinamico(resIndividual);

           this.cadastrarAction();

            Toast.makeText(activity, "Resultado carregado", Toast.LENGTH_SHORT).show();
            MetodoAuxiliar.hideKeyboard(activity);
            this.limparForm();

        } else {
            Toast.makeText(activity, "Algo esta Errado!\nTente Novamente", Toast.LENGTH_SHORT).show();
        }
    }

    private void configListView() {
        listaCarros = new ArrayList<>();
        listaCarros.add(new CarroVO("Golf", 0, 0.0));
        adapterCarros = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                new ArrayList<>()
        );
        activity.getListView().setAdapter(adapterCarros);
        adapterCarros.add(new CarroVO("New FIESTA", 10, 10.0));
    }

    private void cadastrarAction() {
        adapterCarros.add(getResultadoForm());
        this.limparForm();
    }

    private void confirmarExclusaoAction(final CarroVO c) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluir Carro");
        alerta.setMessage("Deseja Realmente Excluir o Carro: '" + c.getModelo() + "' Desta Lista?");
        alerta.setIcon(android.R.drawable.ic_menu_delete);
        alerta.setNegativeButton("Não", null);
        // Deletar
        alerta.setPositiveButton("Sim", (dialog, which) -> adapterCarros.remove(c));
    }

    private void editarAction(CarroVO newCarro) {
        c.setModelo(newCarro.getModelo());
        c.setKm(newCarro.getKm());
        c.setCombustivel(newCarro.getCombustivel());
        adapterCarros.notifyDataSetChanged();
        c = null;
    }

    private void popularForm(CarroVO c) {
        activity.getEditModelo().setText(c.getModelo());
        activity.getEditKm().setText(c.getKm());
        activity.getEditCombustivel().setText(String.valueOf(c.getCombustivel()));
    }

    private boolean verificarCampos(CarroVO c) {
        if (!CarroBO.verificarModelo(c)) {
            activity.getEditModelo().setError(activity.getString(R.string.erro, "Campo Modelo Vazio"));
            activity.getEditModelo().requestFocus();
            return false;
        }
        if (!CarroBO.verificarKm(c)) {
            activity.getEditKm().setError(activity.getString(R.string.erro, "Campo Quilometragem Vazio ou Nulo"));
            activity.getEditKm().requestFocus();
            return false;
        }
        if (!CarroBO.verificarCombustivel(c)) {
            activity.getEditCombustivel().setError(activity.getString(R.string.erro, "Campo Combustivel Vazio ou Nulo"));
            activity.getEditCombustivel().requestFocus();
            return false;
        }
        return true;
    }

    /**
     * Adicionar resultado Dinamico a tela(Necessario um Layout para add esses resultados)
     *
     * @param r String
     */
    private void addResultadoDinamico(String r) {
        TextView tv = new TextView(activity);
        tv.setText(r);
        tv.setPadding(0, -10, 0, -15);
//        activity.getLayoutResultadoFinal().addView(tv);
    }

    private void limparForm() {
        this.activity.getEditCombustivel().setText("");
        this.activity.getEditKm().setText("");
        this.activity.getEditModelo().setText("");
        this.clearFocus();
        MetodoAuxiliar.hideKeyboard(activity);
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    public void limparResultados() {
        this.limparForm();
        this.activity.getTvConsumoFrota().setText("");
//        this.activity.getLayoutResultadoFinal().removeAllViews();
        this.clearFocus();
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    private void clearFocus() {
        this.activity.getEditCombustivel().clearFocus();
        this.activity.getEditKm().clearFocus();
        this.activity.getEditModelo().clearFocus();
    }

    public void voltarAction() {
        Toast.makeText(this.activity, R.string.voltando, Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }

}
