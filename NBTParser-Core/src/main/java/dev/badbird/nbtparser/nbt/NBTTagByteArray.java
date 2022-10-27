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
public class NBTTagByteArray extends NBTBase {
    private byte[] value;

    @Override
    public JsonElement asJsonElement() {
        JsonArray array = new JsonArray();
        for (byte b : value) {
            array.add(new JsonPrimitive(b));
        }
        return array;
    }
}
