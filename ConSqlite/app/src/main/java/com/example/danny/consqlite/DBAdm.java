package com.example.danny.consqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Danny on 04/11/2015.
 */
public class DBAdm {
    public static final String TABLE_NAME = "contactos";

    public static final String CN_ID= "_id";
    public static final String CN_NAME= "nombre";
    public static final String CN_CELL= "celular";

   public static final String CREATE_TABLE= "create table " +TABLE_NAME + " ("
           +CN_ID + " integer primary key autoincrement,"
           +CN_NAME + " text not null,"
           +CN_CELL + " text);";

    private DBHelper helper;
    private SQLiteDatabase db;
    public DBAdm(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String nombre, String celular){
        ContentValues valores= new ContentValues();
        valores.put(CN_NAME,nombre);
        valores.put(CN_CELL,celular);

        return valores;
    }

    public void insertar(String nombre, String celular){


        db.insert(TABLE_NAME, null, generarContentValues(nombre, celular));
    }

    public void eliminar(String nombre){
        db.delete(TABLE_NAME, CN_NAME + "=?", new String[]{nombre});
    }

    public void eliminarMultiple(String nom1, String nom2){

        db.delete(TABLE_NAME, CN_NAME + "IN (?,?)", new String[]{nom1,nom2});
    }

    public void modificarTelefono(String nombre, String nuevoTelefono){
        db.update(TABLE_NAME, generarContentValues(nombre, nuevoTelefono), CN_NAME + "=?", new String[]{nombre});
    }

    public Cursor cargarCursorContactos(){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_CELL};
        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }

    public Cursor buscarContacto(String nombre){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_CELL};
        return db.query(TABLE_NAME,columnas,CN_NAME+"=?", new String[]{nombre},null,null,null);
    }
}
