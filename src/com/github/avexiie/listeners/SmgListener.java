package com.github.avexiie.listeners;

import com.github.avexiie.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SmgListener implements Listener {
    private Main main;

    public SmgListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        ItemStack inhand = e.getPlayer().getItemInHand();
        Location pLoc = e.getPlayer().getEyeLocation();
        if ((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && inhand.getType() == Material.DIAMOND_AXE && inhand.getItemMeta().getDisplayName().contains("SMG")) {
            Arrow arrow = (Arrow)e.getPlayer().launchProjectile(Arrow.class, e.getPlayer().getLocation().getDirection());
            arrow.setVelocity(pLoc.getDirection().multiply(3));
        }

    }
}
