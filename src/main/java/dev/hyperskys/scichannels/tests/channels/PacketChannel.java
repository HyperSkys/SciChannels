package dev.hyperskys.scichannels.tests.channels;

import dev.hyperskys.scichannels.channel.Channel;
import dev.hyperskys.scichannels.channel.annotations.ChannelInfo;
import org.json.JSONObject;

@ChannelInfo(name = "packets")
public class PacketChannel extends Channel {
    @Override
    public void onMessageReceived(JSONObject jsonObject) {
        System.out.println("> Info on " + jsonObject.getString("type") + " <");

        for (String key : jsonObject.keySet()) {
            System.out.println(" - {key = " + key + "} | {value = " + jsonObject.get(key) + "}");
        }
    }
}
