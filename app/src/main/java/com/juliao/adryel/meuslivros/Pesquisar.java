package com.juliao.adryel.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pesquisar extends AppCompatActivity {

    private TextView titulo;
    private TextView autor;
    private TextView ano;
    private TextView nota;
    private List<Livro> livrosBanco = new ArrayList<>();
    private String[] LISTA;
    private ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        titulo = (TextView) findViewById(R.id.idTitulo);
        autor = (TextView) findViewById(R.id.idTitulo);
        ano = (TextView) findViewById(R.id.idTitulo);
        nota = (TextView) findViewById(R.id.idTitulo);


        BancoHelper db = new BancoHelper(this);

        livrosBanco = db.findAll();

        preencheArray();

        AutoCompleteTextView autoCompleteLivros = (AutoCompleteTextView) findViewById(R.id.idAuto);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LISTA);
        autoCompleteLivros.setAdapter(adaptador);

        autoCompleteLivros.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Livro livro;

            }
        });


    }
    public void preencheArray(){

        LISTA = new String[livrosBanco.size()];

        int i = 0;
        for(Livro l: livrosBanco){
            LISTA[i] = l.getTitulo();
            i++;
        }

    }
}
