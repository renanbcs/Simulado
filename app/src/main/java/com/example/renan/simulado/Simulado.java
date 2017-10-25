package com.example.renan.simulado;

import java.io.Serializable;

public class Simulado implements Serializable {

    private String nome,assunto,titulo;

    public Simulado(String nome,String assunto){

        this.nome = nome;
        this.assunto = assunto;

    }

    public String getNome(){

        return nome;
    }

    public String getAssunto(){

        return assunto;
    }

}
