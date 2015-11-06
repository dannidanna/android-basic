package com.example.danny.clima.data;

import org.json.JSONObject;

/**
 * Created by Danny on 05/11/2015.
 */
public class Item implements JSONPopulator {
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void poupulate(JSONObject data) {
        condition = new Condition();
        condition.poupulate(data.optJSONObject("Condicion"));

    }
}
