package net.shibacraft.simpleblockregen.plugin.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.util.List;

@Getter
@Setter
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

}
