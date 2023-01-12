package net.shibacraft.simpleblockregen.plugin.region;

import lombok.AllArgsConstructor;
import org.bukkit.Location;

import java.util.List;

@AllArgsConstructor
public class Region {

    private final String name;
    private final Location min;
    private final Location max;
    private RegionMode mode;
    private List<String> blocks;

    public boolean contains(Location loc) {
        if (max.getWorld() != null && !max.getWorld().equals(loc.getWorld())) return false;

        return loc.getX() <= max.getX() && loc.getX() >= min.getX()
                && loc.getZ() <= max.getZ() && loc.getZ() >= min.getZ()
                && loc.getY() <= max.getY() && loc.getY() >= min.getY();
    }

    /**
     * Gets the name of the region
     *
     * @return  region name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets location of the lowest corner in the region
     *
     * @return  {@link Location}
     */
    public Location getMin() {
        return min;
    }

    /**
     * Gets location of the highest corner in the region
     *
     * @return  {@link Location}
     */
    public Location getMax() {
        return max;
    }

    /**
     * Returns the mode of the region;
     *
     * @return  {@link RegionMode}
     */
    public RegionMode getMode() {
        return mode;
    }

    /**
     * Sets the region mode
     *
     * @param mode  {@link RegionMode}
     */
    public void setMode(RegionMode mode) {
        this.mode = mode;
    }

    /**
     * Gets the names of the allowed/denied blocks in the region
     *
     * @return  {@link List<String>} of block names
     */
    public List<String> getBlocks() {
        return blocks;
    }

    /**
     * Sets the names of the allowed/denied blocks in the region
     *
     * @param blocks    {@link List<String>} of block names
     */
    public void setBlocks(List<String> blocks) {
        this.blocks = blocks;
    }
}
