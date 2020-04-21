package com.example.app.controller;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.app.R;
import com.example.app.model.bo.AlunoBO;
import com.example.app.model.bo.PessoaBO;
import com.example.app.model.vo.AlunoVO;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.CalcularMedia;

import org.jetbrains.annotations.NotNull;

public class CalcularMediaController {
    private CalcularMedia activity;

    public CalcularMediaController(CalcularMedia activity) {
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void calcularAction() {

        AlunoVO aluno = new AlunoVO();
        aluno.setNome(activity.getEditNome().getText().toString());
        aluno.setNp1(activity.getEditNp1().getText().toString());
        aluno.setNp2(activity.getEditNp2().getText().toString());

        if (verificarCampos(aluno)) {
            aluno.setMedia(AlunoBO.calcularMedia(aluno));
            int cor;

            if (AlunoBO.verificarAprovacao(aluno)) {
                aluno.setSituacao(activity.getString(R.string.aprovado));
                cor = R.color.bg_success;
            } else {
                aluno.setSituacao(activity.getString(R.string.reprovado));
                cor = R.color.bg_warning;
            }

            String txtResultadoFinal = "";
            txtResultadoFinal += activity.getString(R.string.aluno) + ": " + aluno.getNome() + "\n";
            txtResultadoFinal += activity.getString(R.string.media) + ": " + aluno.getMedia() + "\n";
            txtResultadoFinal += activity.getString(R.string.situacao) + ": " + aluno.getSituacao();

            activity.getTvResultadoFinal().setText(txtResultadoFinal);
            activity.getTvResultadoFinal().setTextSize(20);
            activity.getTvResultadoFinal().setTextColor(activity.getColor(cor));

            Toast.makeText(activity, "Calculo Completo", Toast.LENGTH_SHORT).show();
            MetodoAuxiliar.hideKeyboard(activity);
            this.limparForm();
        } else {
            Toast.makeText(activity, "Formulário incompleto", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean verificarCampos(@NotNull AlunoVO a) {
        if (!PessoaBO.validarNome(a.getNome())) {
            activity.getEditNome().setError(activity.getString(R.string.erro, "Nome"));
            activity.getEditNome().requestFocus();
            return false;
        }
        if (!AlunoBO.validarNota(a.getNp1())) {
            activity.getEditNp1().setError(activity.getString(R.string.erro, "Nota 01"));
            activity.getEditNp1().requestFocus();
            return false;
        }
        if (!AlunoBO.validarNota(a.getNp2())) {
            activity.getEditNp2().setError(activity.getString(R.string.erro, "Nota 02"));
            activity.getEditNp2().requestFocus();
            return false;
        }
        return true;
    }

    private void limparForm() {
        this.activity.getEditNome().setText("");
        this.activity.getEditNp1().setText("");
        this.activity.getEditNp2().setText("");
        this.clearFocus();
        MetodoAuxiliar.hideKeyboard(activity);
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    public void limparResultadosAction() {
        this.limparForm();
        this.activity.getTvResultadoFinal().setText("");
        this.clearFocus();
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    private void clearFocus() {
        this.activity.getEditNome().clearFocus();
        this.activity.getEditNp2().clearFocus();
        this.activity.getEditNp2().clearFocus();
    }

    public void voltarAction() {
        Toast.makeText(this.activity, R.string.voltando, Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }

}