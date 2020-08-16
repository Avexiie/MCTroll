package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

public class DropCommand implements CommandExecutor {
    private Main main;

    public DropCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 1) {
            Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(true) {
                while(var7.hasNext()) {
                    Player playertodrop = (Player)var7.next();
                    if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.dropinv")) {
                        player.sendMessage(ChatColor.RED + "You do not have this permissions!");
                    } else if (!playertodrop.getName().equalsIgnoreCase(args[0])) {
                        if (playertodrop != null) {
                            player.sendMessage(ChatColor.RED + "Invalid Player!");
                        }
                    } else {
                        Inventory inv = playertodrop.getInventory();

                        for(int i = 0; i <= 36; ++i) {
                            try {
                                playertodrop.getWorld().dropItem(playertodrop.getLocation(), inv.getItem(i)).setPickupDelay(40);
                            } catch (Exception var13) {
                            }

                            try {
                                switch(i) {
                                    case 1:
                                        playertodrop.getWorld().dropItem(player.getLocation(), ((PlayerInventory)inv).getChestplate()).setPickupDelay(40);
                                        break;
                                    case 2:
                                        player.getWorld().dropItem(player.getLocation(), ((PlayerInventory)inv).getLeggings()).setPickupDelay(40);
                                        break;
                                    case 3:
                                        player.getWorld().dropItem(player.getLocation(), ((PlayerInventory)inv).getHelmet()).setPickupDelay(40);
                                }
                            } catch (Exception var12) {
                            }
                        }

                        player.getInventory().clear();
                        player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("DropInvMessage").replace("%player%", playertodrop.getName())));
                    }
                }

                return true;
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.dropinv")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/DropInv <Player>");
        }

        return true;
    }
}