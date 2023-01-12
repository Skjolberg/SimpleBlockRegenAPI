package net.shibacraft.simpleblockregen.plugin.region;

public enum RegionMode {

    /**
     * The blocks established in the region will be allowed, while the rest will be denied.
     */
    WHITELIST,
    /**
     * The blocks established in the region will be denied, while the rest will be allowed.
     */
    BLACKLIST,
    /**
     * The list of blocks in the region will be ignored, and will give priority to all blocks in BlockList.yml.
     */
    DEFAULT;

    public static boolean contains(String mode) {
        for (RegionMode value : values()) {
            if (value.toString().equalsIgnoreCase(mode)) return true;
        }
        return false;
    }

}
