package com.example.danny.calculator20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtn1, txtn2;
    ImageButton btnS, btnR, btnM, btnD;
    TextView txtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtn1=(EditText) findViewById(R.id.txtn1);
        txtn2=(EditText) findViewById(R.id.txtn2);
        btnS=(ImageButton)findViewById(R.id.btn_plus);
        btnR=(ImageButton)findViewById(R.id.btn_minus);
        btnM=(ImageButton)findViewById(R.id.btn_for);
        btnD=(ImageButton)findViewById(R.id.btn_divide);
        txtR=(TextView)findViewById(R.id.txt_result);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1= Integer.parseInt(txtn1.getText().toString());
                int num2= Integer.parseInt(txtn2.getText().toString());
                int resultado = num1+num2;
                txtR.setText("Result: "+resultado);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1= Integer.parseInt(txtn1.getText().toString());
                int num2= Integer.parseInt(txtn2.getText().toString());
                int resultado = num1-num2;
                txtR.setText("Result: "+resultado);
            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1= Integer.parseInt(txtn1.getText().toString());
                int num2= Integer.parseInt(txtn2.getText().toString());
                int resultado = num1*num2;
                txtR.setText("Result: "+resultado);
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1= Integer.parseInt(txtn1.getText().toString());
                int num2= Integer.parseInt(txtn2.getText().toString());
                int resultado = num1/num2;
                txtR.setText("Result: "+resultado);
            }
        });

    }
}
