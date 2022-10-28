# NBTParser

A library to serialize minecraft NBT data into JSON

## Usage

```java
public class Hello {
    public static String getNBTJson(net.minecraft.nbt.NBTTagCompound nbt) {
        // GenericNBTPlatform is completely platform independent, and relies on reflection to access the NBT data/class type.
        // Based off 1.12.2 docs.
        GenericNBTPlatform platform = new GenericNBTPlatform();
        NBTParser parser = new NBTParserImpl(platform); // NBTParserImpl is the default implementation of NBTParser

        dev.badbird.nbtparser.nbt.NBTTagCompound compound = platform.createCompoundFromMC(nbt); // Create a NBTParser NBTTagCompound from a Minecraft NBTTagCompound
        String json = parser.toJson(compound); // Serialize the NBTParser NBTTagCompound into JSON
        return json;
    }
}
```

### Why?
Because [Dufji](https://github.com/Dufji) is dumb and kept asking me to spoonfeed him on parsing NBTTagCompond to JSON for over a week

So i made this to spoonfeed him lol, but in the process made it really complicated because:

*why the fuck not?*

After all, ***we're programmers, we overcomplicate things just because we __can__***
