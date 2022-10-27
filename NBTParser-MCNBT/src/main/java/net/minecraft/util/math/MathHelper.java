package net.minecraft.util.math;

public class MathHelper {
    public static int floor(float value) {
        int i = (int) value;
        return value < (float) i ? i - 1 : i;
    }

    public static int floor(double value)
    {
        int i = (int)value;
        return value < (double)i ? i - 1 : i;
    }

}
