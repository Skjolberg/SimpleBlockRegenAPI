package net.shibacraft.simpleblockregen.api.regeneration;

import net.shibacraft.simpleblockregen.plugin.regeneration.Regeneration;
import org.bukkit.Location;

public interface RegenerationManagerImpl {

    /**
     * Gets the regeneration object in a location
     *
     * @param location Location
     * @return {@link Regeneration} or null
     */
    Regeneration getRegeneration(Location location);

    /**
     * Removes regeneration if it exists
     *
     * @param location Location
     */
    void removeRegeneration(Location location);

    /**
     * Removes all active regenerations
     */
    void removeAllRegeneration();

    /**
     * Check the location for regenerating blocks
     *
     * @param location Location to check
     * @return true if it is regenerating
     */
    boolean isRegenerating(Location location);

}
