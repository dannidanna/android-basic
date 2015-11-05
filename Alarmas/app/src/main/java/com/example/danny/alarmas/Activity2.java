package com.example.danny.alarmas;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int ID = getIntent().getIntExtra("ID",8);
        nm.cancel(ID);
    }
}
