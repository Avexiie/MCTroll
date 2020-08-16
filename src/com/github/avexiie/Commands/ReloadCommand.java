package com.github.avexiie.Commands;

import com.github.avexiie.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    private Main main;

    public ReloadCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        Player player = (Player)sender;
        if (player.hasPermission("mctroll.*") || player.hasPermission("mctroll.reload")) {
            this.main.reloadConfig();
            player.sendMessage(this.main.prefix + " " + ChatColor.AQUA + "Config " + ChatColor.GREEN + "Has been reloaded!");
        }

        return true;
    }
}