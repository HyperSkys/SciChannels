package dev.hyperskys.scichannels.tests;

import dev.hyperskys.scichannels.SciChannels;
import dev.hyperskys.scichannels.channel.messages.ChannelSender;
import dev.hyperskys.scichannels.utils.JSONBuilder;

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
    }
}
