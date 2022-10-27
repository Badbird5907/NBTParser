package dev.badbird.nbtparser.nbt;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NBTTagCompound extends NBTBase {
    private Map<String, NBTBase> tagMap = new HashMap<>();

    @Override
    public JsonElement asJsonElement() {
        JsonObject object = new JsonObject();
        for (Map.Entry<String, NBTBase> entry : tagMap.entrySet()) {
            object.add(entry.getKey(), entry.getValue().asJsonElement());
        }
        return object;
    }
}
