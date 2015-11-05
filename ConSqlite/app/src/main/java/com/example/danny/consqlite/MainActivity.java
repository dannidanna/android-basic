package com.example.danny.consqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private DBAdm manager;
    private Cursor cursor;
    private ListView lista;
    private SimpleCursorAdapter adapter;
    private TextView tv;
    private ImageButton bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new DBAdm(this);
        lista = (ListView) findViewById(R.id.listaCon);
        tv = (TextView)findViewById(R.id.busqueda);
        bt = (ImageButton)findViewById(R.id.btn_busq);
        bt.setOnClickListener(this);

        manager.insertar("Jose", "324234");
        manager.insertar("Maria", "3242");

        String[] from = new String[]{manager.CN_NAME, manager.CN_CELL};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};

        cursor = manager.cargarCursorContactos();
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_busq){
            Cursor c =manager.buscarContacto(tv.getText().toString());
            adapter.changeCursor(c);
        }
    }
}
