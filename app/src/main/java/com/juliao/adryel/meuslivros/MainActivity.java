package com.juliao.adryel.meuslivros;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private static final int CADASTRO = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v){
        Button b = (Button) v;
        Intent intent=null;


        if(b.getId()==R.id.novo){

            intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivityForResult(intent, CADASTRO);
        }else{
            intent = new Intent(MainActivity.this, Main3Activity.class);
            startActivity(intent);
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        Snackbar snack=null;

        if(resultCode==RESULT_OK) {

            snack = Snackbar.make((View) layout.getParent(),"Cadastro Realizado", Snackbar.LENGTH_LONG);

        }else if (resultCode==RESULT_CANCELED){

            snack = Snackbar.make((View) layout.getParent(),"Cadastro Cancelado", Snackbar.LENGTH_LONG);

        }
        snack.show();
    }

}