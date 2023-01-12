package net.shibacraft.simpleblockregen.api.region;

import net.shibacraft.simpleblockregen.plugin.region.Region;
import org.bukkit.Location;

import java.util.List;

public interface RegionManagerImpl {

    /**
     * Gets a random location in a region
     *
     * @param region    {@link Region}
     * @return          random location
     */
    Location getLocationRandomInRegion(Region region);

    /**
     * Checks that the location of a block is in an SBR region
     *
     * @param location  Location to check
     * @return          true if the block is in a region
     */
    boolean isRegion(Location location);

    /**
     * Gets the name of the region
     *
     * @param location  Location
     * @return          name region or null if not exists
     */
    String getRegionName(Location location);

    /**
     * Returns a region in the verified location in case there are
     *
     * @param location  Location to check
     * @return          {@link Region} or null
     */
    Region getRegion(Location location);

    /**
     * Gets the region by name if it exists
     *
     * @param name  Name region
     * @return      {@link Region} or null
     */
    Region getRegion(String name);

    /**
     * Gets all existing region names
     *
     * @return list of all existing region names or empty list
     */
    List<String> getAllRegionName();

    /**
     * Gets a list of all existing regions
     *
     * @return lists of {@link Region} or empty list
     */
    List<Region> getAllRegion();

}
