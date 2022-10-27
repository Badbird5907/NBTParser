package dev.badbird.nbtparser.nbt;

import com.google.gson.JsonElement;

public abstract class NBTBase {
    public static NBTBase create(byte id) {
        switch (id) {
            case 0:
                return new NBTTagEnd();
            case 1:
                return new NBTTagByte();
            case 2:
                return new NBTTagShort();
            case 3:
                return new NBTTagInt();
            case 4:
                return new NBTTagLong();
            case 5:
                return new NBTTagFloat();
            case 6:
                return new NBTTagDouble();
            case 7:
                return new NBTTagByteArray();
            case 8:
                return new NBTTagString();
            case 9:
                return new NBTTagList();
            case 10:
                return new NBTTagCompound();
            case 11:
                return new NBTTagIntArray();
            case 12:
                return new NBTTagLongArray();
            default:
                return null;
        }
    }

    public abstract JsonElement asJsonElement();
}
