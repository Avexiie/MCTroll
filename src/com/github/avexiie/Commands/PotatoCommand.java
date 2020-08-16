package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Items;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PotatoCommand implements CommandExecutor {
    private Items ci = new Items();
    private Main main;

    public PotatoCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 1) {
            if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.potato")) {
                player.sendMessage(ChatColor.RED + "You do not have this permissions!");
            } else {
                Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var7.hasNext()) {
                    Player playertopotato = (Player)var7.next();
                    if (playertopotato.getName().equalsIgnoreCase(args[0])) {
                        this.ci.giveItems(playertopotato);
                        player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("PotatoMessage").replace("%player%", playertopotato.getName())));
                    } else if (playertopotato != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player!");
                    }
                }
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.potato")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/Potato <player>");
        }

        return true;
    }
}

