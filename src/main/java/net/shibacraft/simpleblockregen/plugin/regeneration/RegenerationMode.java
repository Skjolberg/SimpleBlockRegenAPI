package net.shibacraft.simpleblockregen.plugin.regeneration;

public enum RegenerationMode {

    RANDOM, MANUAL, DEFAULT;

    public static boolean contains(String mode) {
        for (RegenerationMode value : values()) {
            if (value.toString().equalsIgnoreCase(mode)) return true;
        }
        return false;
    }

}
