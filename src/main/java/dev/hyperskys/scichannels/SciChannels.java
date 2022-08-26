package dev.hyperskys.scichannels;

import lombok.Getter;
import lombok.Setter;

public class SciChannels {

    private static @Getter @Setter Class<?> clazz;

    public static void setupSciChannels(Class<?> clazz) {
        setClazz(clazz);
    }
}