package dev.hyperskys.scichannels.channel;

import org.json.JSONObject;

public abstract class Channel {
    public abstract void onMessageReceived(JSONObject jsonObject);
}
