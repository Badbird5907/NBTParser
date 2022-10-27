package dev.badbird.nbtparser.nbt;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minecraft.util.math.MathHelper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NBTTagFloat extends NBTPrimitive {
    private float value;

    @Override
    public long getLong() {
        return (long) this.value;
    }

    @Override
    public int getInt() {
        return MathHelper.floor(this.value);
    }

    @Override
    public short getShort() {
        return (short) (MathHelper.floor(this.value) & 65535);
    }

    @Override
    public byte getByte() {
        return (byte) (MathHelper.floor(this.value) & 255);
    }

    @Override
    public double getDouble() {
        return this.value;
    }

    @Override
    public float getFloat() {
        return this.value;
    }

    @Override
    public JsonElement asJsonElement() {
        return new JsonPrimitive(value);
    }
}
