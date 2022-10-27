package dev.badbird.nbtparser.nbt;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NBTTagList extends NBTBase implements Iterable<NBTBase> {
    private List<NBTBase> tagList;

    @Override
    public java.util.Iterator<NBTBase> iterator() {
        return tagList.iterator();
    }

    @Override
    public JsonElement asJsonElement() {
        JsonArray array = new JsonArray();
        for (NBTBase base : tagList) {
            array.add(base.asJsonElement());
        }
        return array;
    }
}
