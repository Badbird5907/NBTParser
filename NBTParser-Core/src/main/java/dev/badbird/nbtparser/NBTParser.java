package dev.badbird.nbtparser;

import dev.badbird.nbtparser.nbt.NBTTagCompound;

public interface NBTParser {
    String toJson(NBTTagCompound compound);

    Platform getPlatform();
}
