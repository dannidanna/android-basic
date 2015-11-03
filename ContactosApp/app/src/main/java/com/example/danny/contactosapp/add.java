package com.example.danny.contactosapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add extends AppCompatActivity {
    myDB db;
    EditText nombre;
    EditText apellido;
    EditText edad;
    EditText celular;
    EditText telefono;
    EditText email;
    Button btnAgregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
        edad=(EditText)findViewById(R.id.edad);
        celular=(EditText)findViewById(R.id.celular);
        telefono=(EditText)findViewById(R.id.telefono);
        email=(EditText)findViewById(R.id.email);
        btnAgregar=(Button)findViewById(R.id.agregar_btn);
        db = new myDB(this, null, null, 1);
    }

    public void agregarPersona(View view){
    personas persona=new personas(nombre.getText().toString(), apellido.getText().toString(), Integer.parseInt(edad.getText().toString()), Integer.parseInt(celular.getText().toString()),Integer.parseInt(telefono.getText().toString()),email.getText().toString());
        db.addPersona(persona);
        confirmacion();
        limpiarcampos();
    }

    public void limpiarcampos(){

        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        celular.setText("");
        telefono.setText("");
        email.setText("");

    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Contacto Agregado");
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

}
