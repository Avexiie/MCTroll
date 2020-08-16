package com.github.avexiie.listeners;

import com.github.avexiie.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {
    private Main main;

    public InvClick(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getClickedInventory().getViewers().contains("ScTroll")) {
            String name = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
            switch(e.getCurrentItem().getType()) {
                case LEGACY_PISTON_STICKY_BASE:
                    player.closeInventory();
                    player.performCommand("push " + name);
                    break;
                case LEGACY_POTATO_ITEM:
                    player.closeInventory();
                    player.performCommand("potato " + name);
                    break;
                case DIAMOND_BLOCK:
                    player.closeInventory();
                    player.performCommand("fakeop " + name);
                    break;
                case TNT:
                    player.closeInventory();
                    player.performCommand("fakecrash " + name);
                    break;
                case PACKED_ICE:
                    player.performCommand("freeze " + name);
                    player.closeInventory();
                    break;
                case LEGACY_YELLOW_FLOWER:
                    player.performCommand("poison " + name);
                    player.closeInventory();
                    break;
                case FEATHER:
                    player.performCommand("sky " + name);
                    player.closeInventory();
                    break;
                case CHEST:
                    player.performCommand("dropinv " + name);
                    player.closeInventory();
                case LEGACY_STAINED_GLASS_PANE:
                case LEGACY_SKULL_ITEM:
                default:
                    break;
                case LAVA_BUCKET:
                    player.performCommand("lavatroll " + name);
                    player.closeInventory();
            }

            e.setCancelled(true);
        }

    }
}
