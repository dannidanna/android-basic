package com.example.danny.contactosapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


public class MainActivity extends ActionBarActivity {

    Button btAgr;
    Button btList;
    Button btModi;
    Button btEli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAgr = (Button)findViewById(R.id.agregarbtn);
        btList = (Button)findViewById(R.id.listarbtn);
        btModi = (Button)findViewById(R.id.modificar_btn);
        btEli = (Button)findViewById(R.id.eliminar_btn);
/*
        btAgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(this, add.class);
                startActivity(i);
            }
        });*/
    }

    public void onAgregar(View view){
        Intent i = new Intent(this, add.class);
        startActivity(i);
    }

    public void onListar(View view){
        Intent i = new Intent(this, list.class);
        startActivity(i);
    }

    public void onEliminar(View view){
        Intent i = new Intent(this, delete.class);
        startActivity(i);
    }
    public void onPreModificar(View view){
        Intent i = new Intent(this, pre_modify.class);
        startActivity(i);
    }


    //@Override
    public boolean OnCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //String nombre= item.getItemNombre();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
