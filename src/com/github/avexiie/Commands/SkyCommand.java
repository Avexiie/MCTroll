package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SkyCommand implements CommandExecutor {
    private Main main;

    public SkyCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 1) {
            Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(true) {
                while(var7.hasNext()) {
                    Player playertosky = (Player)var7.next();
                    if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.sky")) {
                        player.sendMessage(ChatColor.RED + "You do not have this permissions!");
                    } else if (playertosky.getName().equalsIgnoreCase(args[0])) {
                        playertosky.setVelocity(new Vector(0, 9, 0));
                        player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("SkyMessage").replace("%player%", playertosky.getName())));
                    } else if (playertosky != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player!");
                    }
                }

                return true;
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.sky")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.setVelocity(new Vector(0, 9, 0));
            player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("SkyMessage").replace("%player%", player.getName())));
        }

        return true;
    }
}