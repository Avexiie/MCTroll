package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrollCommand implements CommandExecutor {
    private Main main;

    public TrollCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 1) {
            if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.gui")) {
                player.sendMessage(ChatColor.RED + "You do not have this permissions!");
            } else {
                Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var7.hasNext()) {
                    Player playertotroll = (Player)var7.next();
                    if (playertotroll.getName().equalsIgnoreCase(args[0])) {
                        this.main.onGui(player, playertotroll);
                        player.sendMessage(ChatColor.GREEN + "Trolling " + ChatColor.DARK_AQUA + playertotroll.getName());
                    } else if (playertotroll != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player");
                    }
                }
            }
        } else if (!player.hasPermission("sctroll.*") && !player.hasPermission("sctroll.gui")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/Troll <player>");
        }

        return true;
    }
}
