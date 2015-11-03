package com.example.danny.contactosapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Danny on 02/11/2015.
 */
public class myDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "personas.db";
    public static final String TABLA_PERSONAS = "personas";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_EDAD = "edad";
    public static String COLUMN_CELULAR = "Celular";
    public static String COLUMN_TELEFONO = "Telefono";
    public static String COLUMN_EMAIL = "Email";

    public myDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_PERSONAS + "(" +
                COLUMN_NOMBRE + " TEXT PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_APELLIDO + " TEXT, " +
                COLUMN_EDAD + " INTEGER, " +
                COLUMN_CELULAR + " INTEGER, " +
                COLUMN_TELEFONO + " INTEGER, " +
                COLUMN_EMAIL + " TEXT " +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PERSONAS);
        onCreate(db);

    }

    public void addPersona(personas persona) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, persona.getNom());
        values.put(COLUMN_APELLIDO, persona.getApell());
        values.put(COLUMN_EDAD, persona.getEd());
        values.put(COLUMN_CELULAR, persona.getCel());
        values.put(COLUMN_TELEFONO, persona.getTel());
        values.put(COLUMN_EMAIL, persona.getEma());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PERSONAS, null, values);
        db.close();

    }

    public void updatePersona(personas persona){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, persona.getNom());
        values.put(COLUMN_APELLIDO, persona.getApell());
        values.put(COLUMN_EDAD, persona.getEd());
        values.put(COLUMN_CELULAR, persona.getCel());
        values.put(COLUMN_TELEFONO, persona.getTel());
        values.put(COLUMN_EMAIL, persona.getEma());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLA_PERSONAS, values, COLUMN_NOMBRE + "= ?", new String[]{String.valueOf(persona.getNom())});
        db.close();

    }

    public void borrarPersona(String persona_nombre){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLA_PERSONAS + " WHERE " + COLUMN_NOMBRE + " = " + persona_nombre + ";");
        db.close();
    }

    //listar por id

    public Cursor personasPorNombre(String nombre){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLA_PERSONAS + " WHERE " + COLUMN_NOMBRE + " = " + nombre + ";";
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    //listar a todas las personas
    public Cursor listarPersonas(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLA_PERSONAS + " WHERE 1 ORDER BY " + COLUMN_APELLIDO + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

}
