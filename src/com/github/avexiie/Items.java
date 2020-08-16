package com.github.avexiie;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
    public Items() {
    }

    public void giveItems(Player player) {
        ItemStack item = new ItemStack(Material.POTATO, 2304);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "POTATO");
        ArrayList<String> lore = new ArrayList();
        lore.add(ChatColor.AQUA + "POTATO");
        meta.setLore(lore);
        item.setItemMeta(meta);
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack[]{item});
    }
}
