package com.example.danny.contactosapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class list extends ActionBarActivity {
    EditText listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        myDB db;
        db = new myDB(this, null, null, 1);
        SQLiteDatabase dbs = db.getWritableDatabase();
        Cursor cursor = db.listarPersonas();

        ListView listas = (ListView)findViewById(R.id.lvlitems);
        listas.setTextFilterEnabled(true);
        final TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, cursor);
        listas.setAdapter(todoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buscar_persona, menu);
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
