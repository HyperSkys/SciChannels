package dev.hyperskys.scichannels.channel.messages;

import dev.hyperskys.scichannels.SciChannels;
import dev.hyperskys.scichannels.channel.Channel;
import dev.hyperskys.scichannels.channel.reflect.ChannelInfo;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

public class ChannelSender {
    @SneakyThrows
    public static void sendMessage(String channel, Object object) {
        Reflections reflections = new Reflections(SciChannels.getClazz().getPackage().getName(), new TypeAnnotationsScanner());
        for (Class<?> clazz : reflections.getTypesAnnotatedWith(ChannelInfo.class)) {
            if (clazz.getAnnotation(ChannelInfo.class).name().equals(channel)) {
                ((Channel) clazz.newInstance()).onMessageReceived(object);
            }
        }

        for (Channel instance : ChannelListener.getArrayList()) {
            if (channel.equals(instance.getName())) instance.onMessageReceived(object);
        }
    }
}
