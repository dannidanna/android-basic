package com.example.danny.clima.data;

import org.json.JSONObject;

/**
 * Created by Danny on 05/11/2015.
 */
public class Condition implements JSONPopulator {
    private int codigo;
    private int temperatura;
    private String descripcion;

    public int getCodigo() {
        return codigo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void poupulate(JSONObject data) {
        codigo = data.optInt("codigo");
        temperatura = data.optInt("temp");
        descripcion = data.optString("texto");

    }
}
