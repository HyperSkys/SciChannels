package dev.hyperskys.scichannels.tests;

import dev.hyperskys.scichannels.SciChannels;
import dev.hyperskys.scichannels.channel.Channel;
import dev.hyperskys.scichannels.channel.messages.ChannelListener;
import dev.hyperskys.scichannels.channel.messages.ChannelSender;
import dev.hyperskys.scichannels.utils.JSONBuilder;
import org.json.JSONObject;

public class SciChannelsTest {
    public static void main(String[] args) {
        SciChannels.setupSciChannels(SciChannelsTest.class);
        ChannelSender.sendMessage(new JSONBuilder()
                .setChannel("packets")
                .addData("type", "PlayerMovePacket")
                .addData("player-id", 69420)
                .addData("old-position", "69, 420, 69")
                .addData("velocity", "0.25")
                .build()
        );

        ChannelSender.sendMessage(new JSONBuilder()
                .setChannel("test")
        );

        ChannelListener.registerListener(new Channel() {
            @Override
            public void onMessageReceived(JSONObject jsonObject) {
                System.out.println(jsonObject);
            }
        }.setChannel("packets"));
    }
}
