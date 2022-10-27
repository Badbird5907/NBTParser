package dev.badbird.nbtparser.nbt;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NBTTagByte extends NBTPrimitive {
    private byte value;

    @Override
    public long getLong() {
        return value;
    }

    @Override
    public int getInt() {
        return value;
    }

    @Override
    public short getShort() {
        return value;
    }

    @Override
    public byte getByte() {
        return value;
    }

    @Override
    public double getDouble() {
        return value;
    }

    @Override
    public float getFloat() {
        return value;
    }

    @Override
    public JsonElement asJsonElement() {
        return new JsonPrimitive(value);
    }
}
