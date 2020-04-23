package com.example.app.controller;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.model.bo.CalculadoraBO;
import com.example.app.model.vo.CalculadoraVO;
import com.example.app.util.MetodoAuxiliar;
import com.example.app.view.Calculadora;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CalcController {

    private Calculadora activity;

    private ArrayAdapter<CalculadoraVO> adapterCalculadora;
    private List<CalculadoraVO> listCalculadora;

    private CalculadoraVO c;

    /**
     * Construtor + inicializa a Configuração do ArrayList e ArrayAdapter
     *
     * @param activity Activity
     */
    public CalcController(Calculadora activity) {
        this.activity = activity;
        this.configListView();
    }

    public void salvarAction() {
        if (this.c == null && activity.getBtnAdicao().isPressed()) {
            this.somar();
        } else if (this.c == null && activity.getBtnSubtracao().isPressed()) {
            this.subtrair();
        } else if (this.c == null && activity.getBtnMultiplicacao().isPressed()) {
            this.multiplicar();
        } else if (this.c == null && activity.getBtnDivisao().isPressed()) {
            this.dividir();
        } else {
            this.editar(getResultadoForm());
        }
    }

    /**
     * Preenche o objeto com os valores digitados na tela
     *
     * @return CalculadoraVO
     */
    private CalculadoraVO getResultadoForm() {
        c = new CalculadoraVO();
        c.setNp1(activity.getEditTextNota1().getText().toString());
        c.setNp2(activity.getEditTextNota2().getText().toString());
        return c;
    }

    /**
     * Configuração do ArrayList e ArrayAdapter
     */
    private void configListView() {
        listCalculadora = new ArrayList<>();
        adapterCalculadora = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listCalculadora
        );
        activity.getListView().setAdapter(adapterCalculadora);

        this.addClickLongoListView();
        this.addCliclCurtoListView();
    }

    /**
     * Configuração do ArrayList e ArrayAdapter
     */
    private void addClickLongoListView() {
        activity.getListView().setOnItemLongClickListener(
                (parent, view, position, id) -> {
                    this.c = adapterCalculadora.getItem(position);
                    if (this.c != null) {
                        this.excluir(this.c);
                    } else {
                        Toast.makeText(activity, "Erro ao Tentar Excluir da Lista.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
        );
    }

    /**
     * Aciona a opção para Confirmar Exclusão na posição selecionada, abrindo uma tela de confirmação
     */
    private void addCliclCurtoListView() {
        activity.getListView().setOnItemClickListener((parent, view, position, id) -> {
            this.c = adapterCalculadora.getItem(position);
            if (this.c != null) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                alerta.setTitle("Carro");
                alerta.setMessage(this.c.toString());
                alerta.setNegativeButton("Fechar", (dialog, which) -> this.c = null);
                alerta.setPositiveButton("Editar", (dialog, which) -> this.popularForm(this.c));
                alerta.show();
            } else {
                Toast.makeText(activity, "Erro ao Popular o Formulario.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Cadastra no ArrayAdapter os Valores digitados no Formulario da Tela
     */
    private void cadastrar() {
        if (this.c == null) {
            adapterCalculadora.add(getResultadoForm());
        } else {
            adapterCalculadora.add(this.c);
        }
        this.limparForm();
    }

    /**
     * Confirguração para possibilitar Confirmação de Exclusão
     *
     * @param c CarroVO
     */
    private void excluir(@NotNull final CalculadoraVO c) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluindo Carro");
        alerta.setMessage("Deseja Realmente Excluir: '" + c.getNp1() + " " + c.getOperador() + " " + c.getNp2() + "' Desta Lista?");
        alerta.setIcon(android.R.drawable.ic_menu_delete);
        alerta.setNegativeButton("Não", (dialog, which) -> this.c = null);
        // Deletar
        alerta.setPositiveButton("Sim", (dialog, which) -> {
            adapterCalculadora.remove(c);
            this.c = null;
        });
        alerta.show();
    }

    /**
     * Preenche o formulario com valor selecionado no ListView, e altera o Dataset, se editado.
     *
     * @param newCalculadora CalculadoraVO
     */
    private void editar(@NotNull CalculadoraVO newCalculadora) {
        this.c.setNp1(newCalculadora.getNp1());
        this.c.setNp2(newCalculadora.getNp2());
        adapterCalculadora.notifyDataSetChanged();
        this.c = null;
    }

    /**
     * Realiza o calculo de Adição
     */
    private void somar() {
        if (validarCampos(getResultadoForm())) {
            c.setOperador('+');
            c.setResultado(CalculadoraBO.adicao(c));

            // TODO
            this.cadastrar();

        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Realiza o calculo de Subtração
     */
    private void subtrair() {
        if (validarCampos(this.getResultadoForm())) {
            c.setOperador('-');
            c.setResultado(CalculadoraBO.subrair(c));

            // TODO
            this.cadastrar();

        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Realiza o calculo de Multiplicação
     */
    private void multiplicar() {
        if (validarCampos(this.getResultadoForm())) {
            c.setOperador('x');
            c.setResultado(CalculadoraBO.multiplicar(c));

            // TODO
            this.cadastrar();

        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Realiza o calculo de divisão
     */
    private void dividir() {
        if (validarCampos(this.getResultadoForm())) {
            c.setOperador('/');
            c.setResultado(CalculadoraBO.dividir(c));

            // TODO
            this.cadastrar();

        } else {
            Toast.makeText(activity, activity.getString(R.string.obrigatorio, "Nota 01 ou Nota 02\n"), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Popula o formulario com o valor selecionado
     *
     * @param newCalculadora CalculadoraVO
     */
    private void popularForm(CalculadoraVO newCalculadora) {
        if (newCalculadora != null) {
            activity.getEditTextNota1().setText(String.valueOf(newCalculadora.getNp1()));
            activity.getEditTextNota2().setText(String.valueOf(newCalculadora.getNp2()));
        } else {
            Toast.makeText(activity, "Erro ao Tentar popular o Formulario", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Verifica os Campos digitados
     *
     * @param c CaluladoraVO
     * @return true/false
     */
    private boolean validarCampos(CalculadoraVO c) {
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

    /**
     * Adicionar resultado Dinamico a tela(Necessario um Layout para add esses resultados)
     *
     * @param c CalculadoraVO
     */
    private void addResultadoDinamico(@NotNull CalculadoraVO c) {

        String resultado = "";
        resultado += c.getNp1() + " " + c.getOperador() + " " + c.getNp2() + " = " + c.getResultado() + "\n";

        TextView tvResDinamico = new TextView(activity);
        tvResDinamico.setTextSize(20); //Tamanho fonte 20sp
        tvResDinamico.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvResDinamico.setText(activity.getString(R.string.resultadoOperacao, c.getNp1().toString(), c.getOperador(), c.getNp2().toString(), c.getResultado().toString()));
        tvResDinamico.setPadding(0, 0, 0, -20);
//      tvResDinamico.setText(resultado);
//        activity.getLayoutResultCalculo().addView(tvResDinamico);
    }

    /**
     * Limpa o formulario
     */
    private void limparForm() {
        this.activity.getEditTextNota1().setText("");
        this.activity.getEditTextNota2().setText("");
        this.clearFocus();
        MetodoAuxiliar.hideKeyboard(activity);
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    /**
     * Limpa todos os campos
     */
    public void limparResultadosAction() {
        this.limparForm();
//        this.activity.getLayoutResultCalculo().removeAllViews();
        this.clearFocus();
        Toast.makeText(activity, activity.getString(R.string.limpando), Toast.LENGTH_SHORT).show();
    }

    /**
     * Remove o foco
     */
    private void clearFocus() {
        this.activity.getEditTextNota1().clearFocus();
        this.activity.getEditTextNota2().clearFocus();
    }

    /**
     * Fecha a tela exibida
     */
    public void voltarAction() {
        Toast.makeText(this.activity, R.string.voltando, Toast.LENGTH_SHORT).show();
        this.activity.finish();
    }
}