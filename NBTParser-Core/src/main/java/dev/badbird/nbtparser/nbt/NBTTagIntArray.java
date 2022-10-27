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
public class NBTTagIntArray extends NBTBase {
    private int[] value;

    @Override
    public JsonElement asJsonElement() {
        JsonArray array = new JsonArray();
        for (int i : value) {
            array.add(new JsonPrimitive(i));
        }
        return array;
    }
}
