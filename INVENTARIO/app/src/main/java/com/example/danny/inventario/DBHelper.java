package com.example.danny.inventario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Danny on 05/11/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MYDBName.db";
    public static final String CONTACTS_TABLE_NOMBRE= "productos";
    public static final String CONTACTS_COLUMN_INVENTARIO_ID = "id";
    public static final String CONTACTS_COLUMN_MARCA = "marca";
    public static final String CONTACTS_COLUMN_NOMBRE = "nombre";
    public static final String CONTACTS_COLUMN_TIPO = "tipo";
    public static final String CONTACTS_COLUMN_EMPRESA = "empresa";

    private HashMap hp;

    public DBHelper (Context context){
        super(context, DATABASE_NAME, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "Crear tabla de productos" +
                        "(id integer primary key, marca text, nombre text, tipo text, empresa text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop tabla si existe producto");
        onCreate(db);

    }

    public boolean insertarContactos(String marca, String nombre, String tipo, String empresa){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("marca", marca);
        contentValues.put("nombre", nombre);
        contentValues.put("tipo", tipo);
        contentValues.put("empresa", empresa);

        db.insert("productos", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from productos where id="+id+"",null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db,CONTACTS_TABLE_NOMBRE);
        return numRows;

    }

    public boolean updateContact(Integer id,String marca, String nombre, String tipo, String empresa){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("marca", marca);
        contentValues.put("nombre", nombre);
        contentValues.put("tipo", tipo);
        contentValues.put("empresa", empresa);

        db.update("productos",contentValues,"id=?",new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteContact(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("productos","id=?",new String[]{Integer.toString(id)});
    }

    public ArrayList getAllContacts(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from productos",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            arrayList.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NOMBRE)));
            res.moveToNext();
           // return arrayList;
        }
        return arrayList;
    }



}
