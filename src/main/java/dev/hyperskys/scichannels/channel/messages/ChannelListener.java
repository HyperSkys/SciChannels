package dev.hyperskys.scichannels.channel.messages;

import dev.hyperskys.scichannels.channel.Channel;
import lombok.Getter;

import java.util.HashMap;

public class ChannelListener {

    private static final @Getter HashMap<Channel, String> channelMap = new HashMap<>();

    public static void registerListener(String channelName, Channel channel) {
        channelMap.put(channel, channelName);
    }
}
