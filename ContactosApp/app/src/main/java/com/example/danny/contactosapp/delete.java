package com.example.danny.contactosapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class delete extends ActionBarActivity {
    myDB db;
    EditText nombreAEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new myDB(this, null, null, 1);
        nombreAEliminar = (EditText)findViewById(R.id.nombreEliminar);
    }

    public void eliminarPersona(View view){

        db.borrarPersona(nombreAEliminar.getText().toString());
        confirmacion();
    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(nombreAEliminar.getText());
        dlgAlert.setTitle("Contacto eliminado");
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
