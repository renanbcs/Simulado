package com.example.renan.simulado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ResultadoActivity extends AppCompatActivity {

    private List<Livro> listaLivros = new ArrayList<>();
    private List<String> nomesLivros = new ArrayList<>();
    private Livro l;
    private ListView livrosListView;
    private TextView nomeTextView;

    private void iniciaBase(){

        l = new Livro("Concrete Mathematics","Tecnico");
        listaLivros.add(l);
        l = new Livro("The C++ Programming Language","Tecnico");
        listaLivros.add(l);
        l = new Livro("Curtiço","Literatura");
        listaLivros.add(l);
        l = new Livro("Boca de Ouro","Literatura");
        listaLivros.add(l);
        l = new Livro("Tudo Sobre a Arquitetura","Arquitetura");
        listaLivros.add(l);
        l = new Livro("Arquetetura e sua Arte de Encher os olhos","Arquitetura");
        listaLivros.add(l);

        for (int a = 0;a<listaLivros.size();a++){

            nomesLivros.add(listaLivros.get(a).getTitulo());

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        livrosListView = (ListView) findViewById(R.id.livrosListView);
        Intent intentOrigem = getIntent();

        Simulado s = (Simulado) intentOrigem.getSerializableExtra("simulado");

        iniciaBase();

        nomeTextView = (TextView) findViewById(R.id.nomeTextView1);

        nomeTextView.setText("Bem Vindo "+ s.getNome() +"!!!");

        nomeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ((TextView)view).getText().toString();
                Toast.makeText(ResultadoActivity.this, texto, Toast.LENGTH_SHORT).show();

            }
        });

        List<String> resultado = pegaLivros(s.getAssunto());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);
        livrosListView.setAdapter(adapter);

        if (resultado.size() <= 0)
            Toast.makeText(this,"Sem resultados para o Assunto", Toast.LENGTH_SHORT).show();


    }


    private List<String> pegaLivros(String assunto){

        if (assunto == null || assunto.length() <= 0)
            return nomesLivros;
        List <String> resultado = new ArrayList<>();

        for (int a = 0;a<listaLivros.size();a++){

            if (assunto.equals(listaLivros.get(a).getAssunto())) {

                resultado.add(listaLivros.get(a).getTitulo());
            }
        }
        return resultado;


    }



}
