package net.shibacraft.simpleblockregen.plugin.regeneration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.shibacraft.simpleblockregen.plugin.blocklist.BlockList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;

@Getter
@Setter
@ToString
public class Regeneration {

    private BlockList blockList;
    private BlockState blockState;
    private Material material;
    private Location locGenerate;
    private Location locCurrently;
    private long regenerationTime;
    private long timeToRemove;
    private BlockState replaceBlockState;
    private Material replaceMaterial;
    private final RegenerationMode mode;
    private boolean removable;
    private Location firstLocation;
    private Material firstMaterial;
    private Material firstTopMaterial;
    private Material currentTopMaterial;
    private Material previousTopMaterial;

    public Regeneration(BlockList blockList, BlockState blockState, Material material, Location locCurrently,
                        Location locGenerate, long regenerationTime, long timeToRemove, BlockState replaceBlockState,
                        Material replaceMaterial, RegenerationMode mode, boolean removable, Location firstLocation,
                        Material firstMaterial, Material firstTopMaterial, Material currentTopMaterial,
                        Material previousTopMaterial) {
        this.blockList = blockList;
        this.blockState = blockState;
        this.material = material;
        this.locCurrently = locCurrently;
        this.locGenerate = locGenerate;
        this.regenerationTime = regenerationTime;
        this.timeToRemove = timeToRemove;
        this.replaceBlockState = replaceBlockState;
        this.replaceMaterial = replaceMaterial;
        this.mode = mode;
        this.removable = removable;
        this.firstLocation = firstLocation;
        this.firstMaterial = firstMaterial;
        this.firstTopMaterial = firstTopMaterial;
        this.currentTopMaterial = currentTopMaterial;
        this.previousTopMaterial = previousTopMaterial;
    }

    public Regeneration(BlockList blockList, BlockState blockState, BlockState replaceBlockState, long regenerationTime,
                        Location locGenerate, Location locCurrently, String replaceBlock, long timeToRemove,
                        RegenerationMode mode, boolean removable, Material type, Material firstTopMaterial,
                        Material currentTopMaterial, Material previousTopMaterial) {
        this(blockList,blockState, blockState.getBlock().getType(), locCurrently, locGenerate,  regenerationTime,
                timeToRemove, replaceBlockState,  Material.valueOf(replaceBlock), mode, removable,
                blockState.getLocation(), type, firstTopMaterial, currentTopMaterial, previousTopMaterial);
    }

}
