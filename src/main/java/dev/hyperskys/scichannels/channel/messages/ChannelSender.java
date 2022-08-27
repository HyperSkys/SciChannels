package dev.hyperskys.scichannels.channel.messages;

import dev.hyperskys.scichannels.SciChannels;
import dev.hyperskys.scichannels.channel.Channel;
import dev.hyperskys.scichannels.channel.annotations.ChannelInfo;
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
                Channel instance = (Channel) clazz.newInstance();
                instance.onMessageReceived(jsonObject.getJSONObject("data"));
            }
        }

        for (Channel channel : ChannelListener.getArrayList()) {
            String name = channel.getName();
            if (jsonObject.getString("channel").equals(name)) {
                channel.onMessageReceived(jsonObject.getJSONObject("data"));
            }
        }
    }
}
