package dev.hyperskys.scichannels.channel;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

public abstract class Channel {
    public @Getter @Setter String name;
    public abstract void onMessageReceived(JSONObject jsonObject);
    public Channel setChannel(String name) {
        setName(name);
        return this;
    }
}
