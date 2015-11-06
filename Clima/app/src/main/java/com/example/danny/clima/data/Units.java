package com.example.danny.clima.data;

import org.json.JSONObject;

/**
 * Created by Danny on 05/11/2015.
 */
public class Units implements JSONPopulator {
    private String temperatura;

    public String getTemperatura() {
        return temperatura;
    }

    @Override
    public void poupulate(JSONObject data) {
        temperatura = data.optString("temperatura");

    }
}
