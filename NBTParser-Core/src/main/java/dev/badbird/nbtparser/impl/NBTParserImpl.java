package dev.badbird.nbtparser.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dev.badbird.nbtparser.NBTParser;
import dev.badbird.nbtparser.Platform;
import dev.badbird.nbtparser.nbt.NBTBase;
import dev.badbird.nbtparser.nbt.NBTTagCompound;

import java.util.Objects;

public class NBTParserImpl implements NBTParser {
    private final Platform platform;

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public NBTParserImpl(Platform platform) {
        this.platform = Objects.requireNonNull(platform, "platform");
    }

    @Override
    public String toJson(NBTTagCompound compound) {
        return GSON.toJson(compound.asJsonElement());
    }

    @Override
    public Platform getPlatform() {
        return platform;
    }
}
