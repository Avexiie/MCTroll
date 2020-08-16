package com.github.avexiie.Commands;

import com.github.avexiie.Item;
import com.github.avexiie.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SmgCommand implements CommandExecutor {
    private Item ci = new Item();
    private Main main;

    public SmgCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 0) {
            if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.smg")) {
                player.sendMessage(ChatColor.RED + "You do not have this permissions!");
            } else {
                this.ci.giveItems(player);
                player.sendMessage(this.main.prefix + " " + ChatColor.GREEN + "SMG Received!");
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.smg")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/Smg");
        }

        return true;
    }
}

