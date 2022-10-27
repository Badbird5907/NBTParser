package dev.badbird.nbtparser.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import dev.badbird.nbtparser.nbt.NBTBase;

import java.lang.reflect.Type;

public class NBTBaseSerializer implements JsonSerializer<NBTBase> {
    @Override
    public JsonElement serialize(NBTBase src, Type typeOfSrc, JsonSerializationContext context) {
        return src.asJsonElement();
    }
}
