package com.github.avexiie;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
    public Item() {
    }

    public void giveItems(Player player) {
        ItemStack item = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "SMG");
        ArrayList<String> lore = new ArrayList();
        lore.add(ChatColor.AQUA + "Right Click To SHOOT.");
        meta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES});
        meta.setLore(lore);
        item.setItemMeta(meta);
        player.getInventory().addItem(new ItemStack[]{item});
    }
}

