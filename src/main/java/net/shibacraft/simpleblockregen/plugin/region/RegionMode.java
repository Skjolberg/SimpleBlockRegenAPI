package net.shibacraft.simpleblockregen.plugin.region;

public enum RegionMode {

    WHITELIST, BLACKLIST, DEFAULT;

    public static boolean contains(String mode) {
        for (RegionMode value : values()) {
            if (value.toString().equalsIgnoreCase(mode)) return true;
        }
        return false;
    }

}
