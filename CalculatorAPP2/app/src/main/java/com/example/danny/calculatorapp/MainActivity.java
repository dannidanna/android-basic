package com.example.danny.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_result = (TextView)findViewById(R.id.txt_result);
    }

    public void doClick(View view){
        double resp;
        if(txt_result.getText().toString().equals("o")){
            txt_result.setText("");


        }
        switch (view.getId()){
            case R.id.btn_number0:
            case R.id.btn_number1:
            case R.id.btn_number2:
            case R.id.btn_number3:
            case R.id.btn_number4:
            case R.id.btn_number5:
            case R.id.btn_number6:
            case R.id.btn_number7:
            case R.id.btn_number8:
            case R.id.btn_number9:
                Button button = (Button) view;
                txt_result.setText(txt_result.getText() + button.getText().toString());
                break;
            case R.id.img_Plus:
                txt_result.setText(txt_result.getText() + "+");
                //resp = txt_result.getText() +
                break;
            case R.id.img_Minus:
                //ScriptE
                txt_result.setText(txt_result.getText() + "-");
                break;
            case R.id.img_For:
                txt_result.setText(txt_result.getText() + "*");
                break;
            case R.id.img_Div:
                txt_result.setText(txt_result.getText() + "/");
                break;
            case R.id.img_Percentage:
                txt_result.setText(txt_result.getText() + "%");
                break;
            case R.id.img_Equals:
               // txt_result.setText(txt_result.getText() + "= \n" + resultado());
                String loq= (String) txt_result.getText();
                int resultado= 0;
                resultado =Integer.parseInt(loq);
                txt_result.setText(resultado);
                break;
               // txt_result.setText("RESULTADO");*/
            case R.id.btn_deleteAll:
                txt_result.setText("");
                break;
            case R.id.img_Delete:
                CharSequence res= (String) txt_result.getText().subSequence(0, (txt_result.getText().length()) - 1);
                txt_result.setText(res);
                break;

        }


    }

    public double resultado(){
        double resp=0;
        return resp;
    }
}
