package dev.hyperskys.scichannels.channel.messages;

import dev.hyperskys.scichannels.SciChannels;
import dev.hyperskys.scichannels.channel.Channel;
import dev.hyperskys.scichannels.channel.reflect.ChannelInfo;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

public class ChannelSender {
    @SneakyThrows
    public static void sendMessage(JSONObject jsonObject) {
        Reflections reflections = new Reflections(SciChannels.getClazz().getPackage().getName(), new TypeAnnotationsScanner());
        for (Class<?> clazz : reflections.getTypesAnnotatedWith(ChannelInfo.class)) {
            if (clazz.getAnnotation(ChannelInfo.class).name().equals(jsonObject.getString("channel"))) {
                ((Channel) clazz.newInstance()).onMessageReceived(jsonObject.getJSONObject("data"));
            }
        }

        for (Channel channel : ChannelListener.getArrayList()) {
            if (jsonObject.getString("channel").equals(channel.getName())) {
                channel.onMessageReceived(jsonObject.getJSONObject("data"));
            }
        }
    }
}
