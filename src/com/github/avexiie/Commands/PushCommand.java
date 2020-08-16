package com.github.avexiie.Commands;

import java.util.Iterator;
import java.util.Random;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class PushCommand implements CommandExecutor {
    private Main main;

    public PushCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        Random rand = new Random();
        if (length == 1) {
            Iterator var8 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(true) {
                while(var8.hasNext()) {
                    Player playertopush = (Player)var8.next();
                    if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.push")) {
                        player.sendMessage(ChatColor.RED + "You do not have this permissions!");
                    } else if (playertopush.getName().equalsIgnoreCase(args[0])) {
                        playertopush.setVelocity(new Vector(rand.nextInt(6), 1, rand.nextInt(6)));
                        player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("PushMessage").replace("%player%", playertopush.getName())));
                    } else if (playertopush != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player!");
                    }
                }

                return true;
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.push")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.setVelocity(new Vector(rand.nextInt(6), 1, rand.nextInt(6)));
            player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("PushMessage").replace("%player%", player.getName())));
        }

        return true;
    }
}
