package com.example.danny.clima.data;

import org.json.JSONObject;

/**
 * Created by Danny on 05/11/2015.
 */
public class Channel implements JSONPopulator {
    private Units units;
    private Item item;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void poupulate(JSONObject data) {
        units = new Units();
        units.poupulate(data.optJSONObject("units"));

        item = new Item();
        item.poupulate(data.optJSONObject("item"));

    }
}
