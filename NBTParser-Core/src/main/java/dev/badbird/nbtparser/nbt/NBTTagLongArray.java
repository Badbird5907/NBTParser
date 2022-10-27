package dev.badbird.nbtparser.nbt;

import com.google.gson.JsonArray;
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
public class NBTTagLongArray extends NBTBase {
    private long[] value;

    @Override
    public JsonElement asJsonElement() {
        JsonArray array = new JsonArray();
        for (long l : value) {
            array.add(new JsonPrimitive(l));
        }
        return array;
    }
}
