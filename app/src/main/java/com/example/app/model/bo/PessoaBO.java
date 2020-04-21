package com.example.app.model.bo;

public class PessoaBO {

    public static boolean validarNome(String nome) {
        return nome != null && !nome.equals("");
    }
}
