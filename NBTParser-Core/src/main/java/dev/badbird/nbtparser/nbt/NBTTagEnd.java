package dev.badbird.nbtparser.nbt;

import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class NBTTagEnd extends NBTBase {

    @Override
    public JsonElement asJsonElement() {
        return null;
    }
}
