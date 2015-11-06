package com.example.danny.clima;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danny.clima.data.Channel;
import com.example.danny.clima.data.Item;
import com.example.danny.clima.service.WeatherServiceCallback;
import com.example.danny.clima.service.YahooWeatherService;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {
    private ImageView icono;
    private TextView temperatura;
    private TextView condicion;
    private TextView lugar;

    private YahooWeatherService service;
    private ProgressDialog dialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icono = (ImageView)findViewById(R.id.icono);
        temperatura= (TextView)findViewById(R.id.temperatura);
        condicion= (TextView)findViewById(R.id.condicion);
        lugar= (TextView)findViewById(R.id.lugar);

        service= new YahooWeatherService(this);
        dialogo = new ProgressDialog(this);
        dialogo.setMessage("Cargando...");
        dialogo.show();
        service.actualizarWeather("Cbba, Bolivia");
    }

    @Override
    public void serviceSucess(Channel channel) {
        dialogo.hide();

        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCodigo(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable iconoDraw = getResources().getDrawable(resourceId);

        icono.setImageDrawable(iconoDraw);
        temperatura.setText(item.getCondition().getTemperatura()+"\u00B0"+ channel.getUnits().getTemperatura());
        condicion.setText(item.getCondition().getDescripcion());
        lugar.setText(service.getLugar());


    }

    @Override
    public void serviceFailure(Exception exception) {
        dialogo.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();

    }
}
