package com.example.app.controller;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.model.bo.CalculadoraBO;
import com.example.app.model.vo.CalculadoraVO;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.Calculadora;

import org.jetbrains.annotations.NotNull;

public class CalcController {

    private Calculadora activity;
    private CalculadoraVO c = new CalculadoraVO();

    public CalcController(Calculadora activity) {
        this.activity = activity;
    }

    private void setValores() {
        c.setNp1(activity.getEditTextNota1().getText().toString());
        c.setNp2(activity.getEditTextNota2().getText().toString());
    }

    public void somarAction() {
        this.setValores();
        if (validarCampos()) {
            c.setOperador("+");
            c.setResultado(CalculadoraBO.adicao(c));
            this.addResultado(c);
            this.limparForm();
        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    public void subtrairAction() {
        this.setValores();
        if (validarCampos()) {
            c.setOperador("-");
            c.setResultado(CalculadoraBO.subrair(c));
            this.addResultado(c);
            this.limparForm();
        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    public void multiplicarAction() {
        this.setValores();
        if (validarCampos()) {
            c.setOperador("x");
            c.setResultado(CalculadoraBO.multiplicar(c));
            this.addResultado(c);
            this.limparForm();
        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    public void dividirAction() {
        this.setValores();
        if (validarCampos()) {
            c.setOperador("/");
            c.setResultado(CalculadoraBO.dividir(c));
            this.addResultado(c);
            this.limparForm();
        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarCampos() {
        if (!CalculadoraBO.validarNp1(c)) {
            activity.getEditTextNota1().setError(activity.getString(R.string.erro, "Campo 'Nota 01' Não Digitado!\nCalculo Invalido!"));
            activity.getEditTextNota1().requestFocus();
            return false;
        }
        if (!CalculadoraBO.validarNp2(c)) {
            activity.getEditTextNota2().setError(activity.getString(R.string.erro, "Campo 'Nota 02' Não Digitado!\nCalculo Invalido!"));
            activity.getEditTextNota2().requestFocus();
            return false;
        }
        return true;
    }

    private void addResultado(@NotNull CalculadoraVO c) {

        String resultado = "";
        resultado += + +c.getNp1() + " " + c.getOperador() + " " + c.getNp2() + " = " + c.getResultado() + "\n";

        TextView tvResDinamico = new TextView(activity);
        tvResDinamico.setTextSize(20); //Tamanho fonte 20sp
        tvResDinamico.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvResDinamico.setText(activity.getString(R.string.resultadoOperacao, c.getNp1().toString(), c.getOperador(), c.getNp2().toString(), c.getResultado().toString()));
        tvResDinamico.setPadding(0, 0, 0, -20);
//      tvResDinamico.setText(resultado);
        activity.getLayoutResultCalculo().addView(tvResDinamico);
    }

    private void limparForm() {
        this.activity.getEditTextNota1().setText("");
        this.activity.getEditTextNota2().setText("");
        this.clearFocus();
        MetodoAuxiliar.hideKeyboard(activity);
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    public void limparResultados() {
        this.limparForm();
        this.activity.getLayoutResultCalculo().removeAllViews();
        this.clearFocus();
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    private void clearFocus() {
        this.activity.getEditTextNota1().clearFocus();
        this.activity.getEditTextNota2().clearFocus();
    }

    public void voltarAction() {
        Toast.makeText(this.activity, R.string.voltando, Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }
}