package dev.badbird.nbtparser;

import dev.badbird.nbtparser.nbt.*;
import dev.badbird.nbtparser.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

@SuppressWarnings("ALL")
public class GenericNBTPlatform implements Platform { // Super generic because obfuscation in mc exists...
    public NBTTagByte createByteFromMC(Object nbt) {
        return new NBTTagByte(ReflectionUtils.getField(nbt, byte.class));
    }

    public NBTTagShort createShortFromMC(Object nbt) {
        return new NBTTagShort(ReflectionUtils.getField(nbt, short.class));
    }

    public NBTTagInt createIntFromMC(Object nbt) {
        return new NBTTagInt(ReflectionUtils.getField(nbt, int.class));
    }

    public NBTTagLong createLongFromMC(Object nbt) {
        return new NBTTagLong(ReflectionUtils.getField(nbt, long.class));
    }

    public NBTTagFloat createFloatFromMC(Object nbt) {
        return new NBTTagFloat(ReflectionUtils.getField(nbt, float.class));
    }

    public NBTTagDouble createDoubleFromMC(Object nbt) {
        return new NBTTagDouble(ReflectionUtils.getField(nbt, double.class));
    }

    public NBTTagByteArray createByteArrayFromMC(Object nbt) {
        return new NBTTagByteArray(ReflectionUtils.getField(nbt, byte[].class));
    }

    public NBTTagString createStringFromMC(Object nbt) {
        return new NBTTagString(ReflectionUtils.getField(nbt, String.class));
    }

    public NBTTagList createListFromMC(Object nbt) {
        return new NBTTagList(ReflectionUtils.getField(nbt, List.class));
    }

    public NBTTagIntArray createIntArrayFromMC(Object nbt) {
        return new NBTTagIntArray(ReflectionUtils.getField(nbt, int[].class));
    }

    public NBTTagLongArray createLongArrayFromMC(Object nbt) {
        return new NBTTagLongArray(ReflectionUtils.getField(nbt, long[].class));
    }

    public NBTTagEnd createEndFromMC(Object nbt) {
        return new NBTTagEnd();
    }

    private static final List<Class<?>> WHITELIST = Arrays.asList(
            byte.class, short.class, int.class, long.class, float.class, double.class,
            byte[].class, String.class, List.class, int[].class, long[].class, Map.class
    );

    public NBTBase fromMCBase(Object nbt) {
        // Loop through all the fields in the NBTBase class and get the first one that is in the whitelist
        List<Field> fields = Arrays.asList(nbt.getClass().getDeclaredFields());
        for (Field declaredField : fields) {
            Class<?> type = declaredField.getType();
            if (WHITELIST.contains(type) && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                if (Objects.equals(type, List.class)) {
                    return createListFromMC(nbt);
                } else if (Objects.equals(type, Byte.class) || Objects.equals(type, byte.class)) {
                    if (fields.stream().filter(field ->
                            !Modifier.isStatic(field.getModifiers()) // We want fields that are not static
                                    && field.getType().equals(List.class) // We want fields that are a list
                    ).findFirst().isPresent()) {
                        return createListFromMC(nbt); // NBTTagList also has a byte field, so we need to check if it has a list field
                    }
                    return createByteFromMC(nbt);
                } else if (Objects.equals(type, Short.class) || Objects.equals(type, short.class)) {
                    return createShortFromMC(nbt);
                } else if (Objects.equals(type, Integer.class) || Objects.equals(type, int.class)) {
                    return createIntFromMC(nbt);
                } else if (Objects.equals(type, Long.class) || Objects.equals(type, long.class)) {
                    return createLongFromMC(nbt);
                } else if (Objects.equals(type, Float.class) || Objects.equals(type, float.class)) {
                    return createFloatFromMC(nbt);
                } else if (Objects.equals(type, Double.class) || Objects.equals(type, double.class)) {
                    return createDoubleFromMC(nbt);
                } else if (Objects.equals(type, Byte[].class) || Objects.equals(type, byte[].class)) {
                    return createByteArrayFromMC(nbt);
                } else if (Objects.equals(type, String.class)) {
                    return createStringFromMC(nbt);
                } else if (Objects.equals(type, Integer[].class) || Objects.equals(type, int[].class)) {
                    return createIntArrayFromMC(nbt);
                } else if (Objects.equals(type, Long[].class) || Objects.equals(type, long[].class)) {
                    return createLongArrayFromMC(nbt);
                } else if (Objects.equals(type, Map.class)) {
                    return createCompoundFromMC(nbt);
                }
            }
        }
        return createEndFromMC(nbt);
    }

    public NBTTagCompound createCompoundFromMC(Object nbt) {
        Map map = ReflectionUtils.getField(nbt, Map.class); // Map<String, NBTBase>
        Map<String, NBTBase> newMap = new HashMap<>();
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Object value = entry.getValue();
            newMap.put((String) entry.getKey(), fromMCBase(value));
        }
        return new NBTTagCompound(newMap);
    }
}
