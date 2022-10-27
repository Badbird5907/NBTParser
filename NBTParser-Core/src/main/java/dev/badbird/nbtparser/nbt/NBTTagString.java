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
public class NBTTagString extends NBTBase {
    private String value;

    @Override
    public JsonElement asJsonElement() {
        return new JsonPrimitive(value);
    }
}
