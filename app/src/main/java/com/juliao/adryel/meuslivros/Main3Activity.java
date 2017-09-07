package com.juliao.adryel.meuslivros;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;



public class Main3Activity extends AppCompatActivity {

    private TextView titulo;
    private TextView autor;
    private TextView ano;
    private TextView nota;
    private List<Livro> lista;
    private int iAtual=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        titulo = (TextView) findViewById(R.id.titulo);
        autor = (TextView) findViewById(R.id.autor);
        ano = (TextView) findViewById(R.id.ano);
        nota = (TextView) findViewById(R.id.nota);

        BancoHelper db = new BancoHelper(this);

        lista = db.findAll();

        for (int i=0;i<lista.size();i++) {

            if (i==0){
                AtualizaTexts(i);
                iAtual=0;
            }

        }
    }

    private void AtualizaTexts(int i){
        titulo.setText(lista.get(i).getTitulo());
        autor.setText(lista.get(i).getAutor());
        ano.setText(String.valueOf(lista.get(i).getAno()));
        nota.setText(String.valueOf(lista.get(i).getNota()));
    }

    public void onClick(View v){
        Button b = (Button) v;
        Snackbar snack=null;

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout3);

        if(b.getId()==R.id.btnAnterior){
            if(iAtual==0){
                snack = Snackbar.make((View) layout.getParent(),"Você está no primeiro Registro", Snackbar.LENGTH_LONG);
                snack.show();
            }else{
                AtualizaTexts(iAtual-1);
                iAtual--;
            }
        }else{
            if(iAtual==lista.size()-1){
                snack = Snackbar.make((View) layout.getParent(),"Você está no último Registro", Snackbar.LENGTH_LONG);
                snack.show();
            }else{
                AtualizaTexts(iAtual+1);
                iAtual++;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}