package com.example.danny.contactosapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Danny on 03/11/2015.
 */
public class TodoCursorAdapter extends CursorAdapter {


    public TodoCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_list, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombretxt = (TextView) view.findViewById(R.id.nombre);
        TextView apellidotxt = (TextView) view.findViewById(R.id.apellido);
        //TextView nombretxt = (TextView) view.findViewById(R.id.nombre_txt);

        // Extraccion de las propiedades del cursor


        //int txtid = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String txtapellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido"));
        String txtnombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));

        //nombretxt.setText(String.valueOf(txtnombre));
        nombretxt.setText(txtnombre);
        apellidotxt.setText(txtapellido);
        //nombretxt.setText(txtnombre);
    }
}
