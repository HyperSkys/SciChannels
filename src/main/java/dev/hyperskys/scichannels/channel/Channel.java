package dev.hyperskys.scichannels.channel;

import lombok.Getter;
import lombok.Setter;

public abstract class Channel {

    public @Getter @Setter String name;
    public abstract void onMessageReceived(Object object);

    public Channel setChannel(String name) {
        setName(name);
        return this;
    }
}
