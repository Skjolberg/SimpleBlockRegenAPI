package net.shibacraft.simpleblockregen.api.bypass;

import org.bukkit.entity.Player;

public interface ByPassManagerImpl {

    /**
     * Checks if the player ignores region
     *
     * @param player player
     * @return true if the player ignores region
     */
    boolean isByPass(Player player);

    /**
     * Add the player to ignore the region
     *
     * @param player player
     */
    void addBypass(Player player);

    /**
     * Removes the player so that he does not ignore the region
     *
     * @param player player
     */
    void removeByPass(Player player);

}
