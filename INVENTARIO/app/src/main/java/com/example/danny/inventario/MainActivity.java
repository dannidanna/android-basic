package com.example.danny.inventario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ListView obj;
    DBHelper myDbName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj = (ListView)findViewById(R.id.listProd);
        myDbName = new DBHelper(this);
        ArrayList arrayList = myDbName.getAllContacts();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        obj.setAdapter(arrayAdapter);

        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int Id_to_Search = arg2 + 1;
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", Id_to_Search);
                Intent intent = new Intent(getApplicationContext(), com.example.danny.inventario.DisplayContact.class);
                intent.putExtras(dataBundle);
                startActivity(intent);

            }
        });

       // @Override
        public boolean OnCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        public boolean onOptionsItemSelect(MenuItem item){
            super.onOptionsItemSelected(item);
            Switch(item.getItemId()){
                case R.id.item1;

            }
        }
    }
}
