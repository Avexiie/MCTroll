package com.github.avexiie.listeners;

import com.github.avexiie.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeListener implements Listener {
    private Main main;

    public FreezeListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (this.main.frozenPlayers.containsKey(player)) {
            if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
                player.teleport((Location)this.main.frozenPlayers.get(player));
                player.sendMessage(ChatColor.RED + "You are frozen!");
            }

        }
    }
}
