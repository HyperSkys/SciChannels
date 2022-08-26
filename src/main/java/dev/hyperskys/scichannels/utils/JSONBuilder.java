package dev.hyperskys.scichannels.utils;

import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;

public class JSONBuilder {

    private static JSONObject jsonObject;
    private static JSONObject dataObject;

    public JSONBuilder() {
        jsonObject = new JSONObject();
        dataObject = new JSONObject();
    }

    public JSONBuilder setChannel(String channel) {
        jsonObject.put("channel", channel);
        return this;
    }

    public JSONBuilder addData(String key, String value) {
        dataObject.put(key, value);
        return this;
    }

    public JSONBuilder addData(String key, Number value) {
        dataObject.put(key, value);
        return this;
    }

    public JSONBuilder addData(String key, Collection<?> value) {
        dataObject.put(key, value);
        return this;
    }

    public JSONBuilder addData(String key, HashMap<?, ?> value) {
        dataObject.put(key, value);
        return this;
    }

    public JSONBuilder addData(String key, Object value) {
        dataObject.put(key, value);
        return this;
    }

    public JSONObject build() {
        jsonObject.put("data", dataObject);
        return jsonObject;
    }
}
