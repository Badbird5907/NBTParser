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
public class NBTTagLong extends NBTPrimitive {
    private long value;

    @Override
    public int hashCode() {
        return super.hashCode() ^ (int) (this.value ^ this.value >>> 32);
    }

    @Override
    public long getLong() {
        return this.value;
    }

    @Override
    public int getInt() {
        return (int) (this.value & -1L);
    }

    @Override
    public short getShort() {
        return (short) ((int) (this.value & 65535L));
    }

    @Override
    public byte getByte() {
        return (byte) ((int) (this.value & 255L));
    }

    @Override
    public double getDouble() {
        return (double) this.value;
    }

    @Override
    public float getFloat() {
        return (float) this.value;
    }

    @Override
    public JsonElement asJsonElement() {
        return new JsonPrimitive(value);
    }
}
