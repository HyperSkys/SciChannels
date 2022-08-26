package dev.hyperskys.scichannels.channel.messages;

import dev.hyperskys.scichannels.channel.Channel;
import lombok.Getter;

import java.util.ArrayList;

public class ChannelListener {

    private static final @Getter ArrayList<Channel> arrayList = new ArrayList<>();

    public static void registerListener(Channel channel) {
        arrayList.add(channel);
    }
}
