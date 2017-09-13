package com.juliao.adryel.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Pesquisar extends AppCompatActivity {

    TextView titulo;
    TextView autor;
    TextView ano;
    TextView nota;
    List<Livro> livrosBanco = new ArrayList<>();
    String[] LISTA;
     ArrayAdapter<String> adaptador;
    Livro livro = new Livro();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        titulo = (TextView) findViewById(R.id.idTitulo);
        autor = (TextView) findViewById(R.id.idAutor);
        ano = (TextView) findViewById(R.id.idAno);
        nota = (TextView) findViewById(R.id.idNota);


        final BancoHelper db = new BancoHelper(this);

        livrosBanco = db.findAll();

        preencheArray();

        AutoCompleteTextView autoCompleteLivros = (AutoCompleteTextView) findViewById(R.id.idAuto);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LISTA);
        autoCompleteLivros.setAdapter(adaptador);

        autoCompleteLivros.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                livro = db.findByTitulo(adaptador.getItem(i).toString());

                titulo.setText(livro.getTitulo());
                autor.setText(livro.getAutor());
                ano.setText(livro.getAno()+"");
                nota.setText(livro.getNota()+"");

            }
        });



//       Log.i("LAL", titulo.getText().toString());


    }
    public void preencheArray(){

        LISTA = new String[livrosBanco.size()];
        Log.i("PRE", "preencheu");
        int i = 0;
        for(Livro l: livrosBanco){
            LISTA[i] = l.getTitulo();
            i++;
        }

    }
}
