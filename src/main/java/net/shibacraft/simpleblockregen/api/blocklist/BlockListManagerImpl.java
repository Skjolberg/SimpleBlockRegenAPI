package net.shibacraft.simpleblockregen.api.blocklist;

import net.shibacraft.simpleblockregen.plugin.blocklist.BlockList;

import java.util.List;

public interface BlockListManagerImpl {

    /**
     * Gets all blocks from BlockList.yml
     *
     * @return  list of block name in BlockList.yml
     */
    List<String> getBlocksInBlockList();

    /**
     * Check that the block is enabled in BlockList.yml
     *
     * @param name  Name of the block
     * @return      true if the block is enabled in BlockList.yml
     */
    boolean isBlockInBlockList(String name);

    /**
     * Gets the object of the mined block or else null exists
     *
     * @param name  Name of the block
     * @return      {@link BlockList} or null
     */
    BlockList getBlockList(String name);

}
