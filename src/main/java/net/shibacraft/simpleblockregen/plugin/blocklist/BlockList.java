package net.shibacraft.simpleblockregen.plugin.blocklist;

import lombok.Getter;
import net.shibacraft.library.chat.SLTextColor;
import net.shibacraft.library.effects.SLParticle;
import net.shibacraft.simpleblockregen.plugin.regeneration.RegenerationMode;
import org.bukkit.Color;
import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class BlockList {

    private final String blockMinedName;
    private final RegenerationMode mode;
    private final int agePlacing;
    private final int ageBreaking;
    private final String replaceBlock;
    private final String permission;
    private final long delay;
    private final long timeToRemove;
    private final boolean glow;
    private final boolean dropInventory;
    private final boolean dropNaturally;
    private final SLParticle particle;
    private final String sound;
    private final float volume;
    private final String displayName;
    private final List<String> lore;
    private final String reward;
    private final int min;
    private final int max;
    private final float itemProbability;
    private final String typeExp;
    private final int amountExp;
    private final float expProbability;
    private final int durability;
    private final List<String> toolRequired;
    private final HashMap<Enchantment, Integer> enchantments;
    private final List<String> commands;

    @SuppressWarnings("unchecked")
    public BlockList(Map<String, Object> map) {
        blockMinedName = (String) map.get("block-mined-name");
        mode = (RegenerationMode) map.get("mode");
        replaceBlock = (String) map.get("replace-block");
        agePlacing = (int) map.get("ageplacing");
        ageBreaking = (int) map.get("agebreaking");
        delay = (long) map.get("delay");
        timeToRemove = (long) map.get("timeToRemove");

        glow = (boolean) map.get("glow");
        dropInventory = (boolean) map.get("drop-inventory");
        dropNaturally = (boolean) map.get("drop-naturally");

        String name = (String) map.get("particle");
        float speed = (float) map.get("particlespeed");
        int count = (int) map.get("particleamount");
        int red = (int) map.get("particlered");
        int green = (int) map.get("particlegreen");
        int blue = (int) map.get("particleblue");
        Color color = Color.fromRGB(red, green, blue);

        if (!name.isEmpty()) {
            particle = new SLParticle(name, speed, count, color);
        } else {
            particle = new SLParticle();
        }

        sound = (String) map.get("sound");
        volume = (float) map.get("volume");
        displayName = SLTextColor.color((String) map.get("display-name"));
        lore = ((List<String>) map.get("lore")).stream().map(SLTextColor::color).collect(Collectors.toList());
        reward = (String) map.get("reward");
        min = (int) map.get("min");
        max = (int) map.get("max");
        itemProbability = (float) map.get("itemProbability");
        typeExp = (String) map.get("typeExp");
        amountExp = (int) map.get("amount");
        expProbability = (float) map.get("expProbability");
        durability = (int) map.get("durability");
        enchantments = (HashMap<Enchantment, Integer>) map.get("enchantment");
        permission = (String) map.get("permission");
        toolRequired = (List<String>) map.get("tool-required");
        commands = (List<String>) map.get("commands");
    }

}
