package com.example.danny.alarmas;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (ImageButton)findViewById(R.id.btnAlert);
        btn2 = (ImageButton)findViewById(R.id.btnToast);
        btn3 = (ImageButton)findViewById(R.id.btnNotice);

        //PARA EL BOTON ALERT

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertaSimple = new AlertDialog.Builder(MainActivity.this);

                alertaSimple.setTitle("ALERTA SIMPLE");
                alertaSimple.setMessage("Mensaje");
                alertaSimple.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //codigo que deseemos
                    }
                });

                alertaSimple.setNegativeButton("Calcelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //codigo que deseemos
                    }
                });

                alertaSimple.setIcon(R.drawable.gym);
                alertaSimple.create();
                alertaSimple.show();

            }
        });

        //PARA EL BOTON TOAST

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tostada = Toast.makeText(getApplicationContext(),"MENSAJE", Toast.LENGTH_LONG);
                tostada.setGravity(Gravity.TOP|Gravity.LEFT, 100,0);
                tostada.show();
            }
        });

        //PARA EL BOTON NOTICE

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder notificacion = new NotificationCompat.Builder(MainActivity.this);

                notificacion.setSmallIcon(R.drawable.woman);
                notificacion.setTicker("Notification How To Android");
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setContentTitle("How to android");
                notificacion.setContentText("Texto");
                notificacion.setContentInfo("HTS");

                Uri sonido = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
                notificacion.setSound(sonido);

                Bitmap icono = BitmapFactory.decodeResource(getResources(), R.drawable.woman2);
                notificacion.setLargeIcon(icono);

                PendingIntent myPendingIntent;
                Intent myIntent = new Intent();
                Context myContext = getApplicationContext();

                myIntent.setClass(myContext, Activity2.class);
                myIntent.putExtra("ID", 1);

                myPendingIntent = PendingIntent.getActivity(myContext,0,myIntent,0);
                notificacion.setContentIntent(myPendingIntent);

                Notification n = notificacion.build();

                NotificationManager nm= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(1,n);
            }
        });

    }
}
