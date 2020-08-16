package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
    private Main main;

    public FreezeCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 1) {
            Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(true) {
                while(var7.hasNext()) {
                    Player playertofreeze = (Player)var7.next();
                    if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.freeze")) {
                        player.sendMessage(ChatColor.RED + "You do not have this permissions!");
                    } else if (playertofreeze.getName().equalsIgnoreCase(args[0])) {
                        if (this.main.frozenPlayers.containsKey(playertofreeze)) {
                            this.main.frozenPlayers.remove(playertofreeze);
                            player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("UnfreezeMessage").replace("%player%", playertofreeze.getName())));
                        } else {
                            this.main.frozenPlayers.put(playertofreeze, playertofreeze.getLocation().clone());
                            player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("FreezeMessage").replace("%player%", playertofreeze.getName())));
                        }
                    } else if (playertofreeze != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player!");
                    }
                }

                return true;
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.freeze")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/Freeze <player>");
        }

        return true;
    }
}
