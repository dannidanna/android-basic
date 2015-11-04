package com.example.danny.contactosapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class modify extends ActionBarActivity {
    myDB db;
    EditText nombre;
    EditText apellido;
    EditText edad;
    EditText celular;
    EditText telefono;
    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        nombre= (EditText)findViewById(R.id.nombre);
        apellido= (EditText)findViewById(R.id.apellido);
        edad= (EditText)findViewById(R.id.edad);
        celular= (EditText)findViewById(R.id.celular);
        telefono= (EditText)findViewById(R.id.telefono);
        email= (EditText)findViewById(R.id.email);
        db= new myDB(this, null, null, 1);
        personas persona = new personas();
        Intent i = getIntent();
        String stringNombre = i.getStringExtra("nombre_Persona");
        Cursor c = db.personasPorNombre(stringNombre);

        nombre.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        apellido.setText(c.getString(c.getColumnIndexOrThrow("apellido")));
        edad.setText(c.getString(c.getColumnIndexOrThrow("edad")));
        celular.setText(c.getString(c.getColumnIndexOrThrow("celular")));
        telefono.setText(c.getString(c.getColumnIndexOrThrow("telefono")));
        email.setText(c.getString(c.getColumnIndexOrThrow("email")));

    }

    public void modificar_clicked(View view){

        personas persona = new personas(nombre.getText().toString(), apellido.getText().toString(), Integer.parseInt(edad.getText().toString()),Integer.parseInt(celular.getText().toString()),Integer.parseInt(telefono.getText().toString()), email.getText().toString());
       String nom = nombre.getText().toString();
        persona.setNom(nom);
        db.updatePersona(persona);
        confirmacion();
        limpiarcampos();
        finish(); //Termina la actividad y vuelve al menu principal

    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha modificado exitosamente!");
        dlgAlert.setTitle("Agregar Persona");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos(){

        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        celular.setText("");
        telefono.setText("");
        email.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
