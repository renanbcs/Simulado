package com.example.renan.simulado;

/**
 * Created by renan on 22/10/2017.
 */

public class Livro {

    private String titulo, assunto;

    public Livro (String titulo,String assunto){

        this.titulo = titulo;
        this.assunto = assunto;
    }

    public String getTitulo(){

        return titulo;
    }

    public String getAssunto(){

        return assunto;
    }
}
