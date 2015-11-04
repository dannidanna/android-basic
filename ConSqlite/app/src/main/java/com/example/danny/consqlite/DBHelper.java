package com.example.danny.consqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Danny on 04/11/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "contactos.sqlite";//nombre bd
    private static final int DB_VERSION = 1; //version de las tablas de la bd
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBAdm.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
