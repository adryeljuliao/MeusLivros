package com.juliao.adryel.meuslivros;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;



public class Main2Activity extends AppCompatActivity {

    EditText titulo;
    EditText autor;
    EditText ano;
    RatingBar nota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titulo=(EditText) findViewById(R.id.titulo);
        autor=(EditText) findViewById(R.id.autor);
        ano=(EditText) findViewById(R.id.ano);
        nota=(RatingBar) findViewById(R.id.nota);


    }

    public void onClick(View v){
        Button b = (Button) v;



        if(b.getId()==R.id.cancelar){

            setResult(RESULT_CANCELED);
            finish();

        }else{
            Intent i = new Intent();
            BancoHelper db = new BancoHelper(this);
            Livro l = new Livro(titulo.getText().toString(), autor.getText().toString(), Integer.parseInt(ano.getText().toString()), nota.getRating());
            Log.i("CAD", l.toString());
            db.save(l);
            setResult(RESULT_OK, i);
            finish();

        }


    }
}