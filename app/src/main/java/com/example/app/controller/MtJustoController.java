package com.example.app.controller;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.app.R;
import com.example.app.model.bo.ProdutoBO;
import com.example.app.model.vo.ProdutoVO;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.MuitoJusto;

public class MtJustoController {
    private MuitoJusto activity;

    public MtJustoController(MuitoJusto muitoJusto) {
        this.activity = muitoJusto;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void calcularAction() {
        ProdutoVO p = new ProdutoVO();
        p.setNomeProduto(activity.getEditNome().getText().toString());
        p.setValor(activity.getEditValor().getText().toString());
        p.setNumeroParcela(activity.getEditParcelas().getText().toString());
        p.setJuros(activity.getEditJuros().getText().toString());
        p.setEntrada(activity.getCheckbox().isChecked());

        if (verificarCampos(p)) {
            Double parcela = ProdutoBO.calcularPacela(p);
            Double juros = ProdutoBO.calcularJuros(p);
            Double total = ProdutoBO.calcularTotal(p);
            Double entrada = ProdutoBO.calcularTotalEntrada(p);
            Double parcelaComEntrada = ProdutoBO.calcularParcelaEntrada(p);

            String txtlinha1, txtlinha2, txtlinha3, txtlinha4, txtlinha5;
            txtlinha1 = activity.getString(R.string.nomeProduto) + ": " + p.getNomeProduto() + "\n";
            txtlinha2 = activity.getString(R.string.valorInicial, p.getValor().toString()) + "\n";
            txtlinha4 = activity.getString(R.string.totalComJuros, juros.toString()) + "\n";

            if (activity.getCheckbox().isChecked()) {
                txtlinha3 = activity.getString(R.string.valorParcela, parcelaComEntrada.toString()) + "\n";
                txtlinha5 = activity.getString(R.string.totalCompra, entrada.toString()) + "\n";
            } else {
                txtlinha3 = activity.getString(R.string.valorParcela, parcela.toString()) + "\n";
                txtlinha5 = activity.getString(R.string.totalCompra, total.toString()) + "\n";
            }

            String txtResultadoFinal = txtlinha1 + txtlinha2 + txtlinha3 + txtlinha4 + txtlinha5;

//            txtResultadoFinal += activity.getString(R.string.nomeProduto) + ": " + p.getNomeProduto() + "\n";
//            txtResultadoFinal += activity.getString(R.string.valorInicial, p.getValor().toString()) + "\n";
//            txtResultadoFinal += activity.getString(R.string.valorParcela, parcela.toString()) + "\n";
//            txtResultadoFinal += activity.getString(R.string.totalComJuros, juros.toString());
//            txtResultadoFinal += activity.getString(R.string.totalCompra, total.toString()) + "\n";

            activity.getTvResultadoFinal().setText(txtResultadoFinal);

            activity.getTvResultadoFinal().setTextSize(20);
            activity.getTvResultadoFinal().setTextColor(activity.getColor(R.color.black));

            Toast.makeText(activity, "Resultado carregado", Toast.LENGTH_SHORT).show();
            MetodoAuxiliar.hideKeyboard(activity);

        } else {
            Toast.makeText(activity, "Algo esta Errado!\nTenta Novamente", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean verificarCampos(ProdutoVO p) {
        if (!ProdutoBO.validarNome(p)) {
            activity.getEditNome().setError(activity.getString(R.string.erro, "Campo Nome Vazio"));
            activity.getEditNome().requestFocus();
            return false;
        }
        if (!ProdutoBO.validarValor(p)) {
            activity.getEditValor().setError(activity.getString(R.string.erro, "Campo Valor Vazio ou Igual a Zero"));
            activity.getEditValor().requestFocus();
            return false;
        }
        if (!ProdutoBO.validarParcela(p)) {
            activity.getEditParcelas().setError(activity.getString(R.string.erro, "Parcelas Maximas: 0 a 12"));
            activity.getEditParcelas().requestFocus();
            return false;
        }
        if (!ProdutoBO.validarJuros(p)) {
            activity.getEditJuros().setError(activity.getString(R.string.erro, "Juros Maximo: 0 a 10"));
            activity.getEditJuros().requestFocus();
            return false;
        }
        return true;
    }

    private void limparForm() {
        this.activity.getEditNome().setText("");
        this.activity.getEditValor().setText("");
        this.activity.getEditParcelas().setText("");
        this.activity.getEditJuros().setText("");
        this.clearFocus();
        System.gc();
        MetodoAuxiliar.hideKeyboard(activity);
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    public void limparResultadoAction() {
        this.limparForm();
        this.activity.getTvResultadoFinal().setText("");
        this.clearFocus();
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    private void clearFocus() {
        this.activity.getEditNome().clearFocus();
        this.activity.getEditValor().clearFocus();
        this.activity.getEditParcelas().clearFocus();
        this.activity.getEditJuros().clearFocus();
    }

    public void voltarAction() {
        Toast.makeText(this.activity, R.string.voltando, Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }
}
