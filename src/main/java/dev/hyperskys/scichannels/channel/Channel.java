package dev.hyperskys.scichannels.channel;

import lombok.Getter;
import org.json.JSONObject;

public abstract class Channel {
    public static @Getter String name;
    public abstract void onMessageReceived(JSONObject jsonObject);
    public Channel setChannel(String name) {
        Channel.name = name;
        return this;
    }
}
