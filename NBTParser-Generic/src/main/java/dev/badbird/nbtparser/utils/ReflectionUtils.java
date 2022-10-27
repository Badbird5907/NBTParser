package dev.badbird.nbtparser.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {
    public static <T> T getField(Object instance, Class<?> fieldType) {
        for (Field declaredField : instance.getClass().getDeclaredFields()) {
            if (declaredField.getType() == fieldType) {
                declaredField.setAccessible(true);
                try {
                    return (T) declaredField.get(instance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
