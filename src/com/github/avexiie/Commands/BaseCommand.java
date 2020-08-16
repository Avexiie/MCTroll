package com.github.avexiie.Commands;

import com.github.avexiie.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BaseCommand implements CommandExecutor {
    private Main main;

    public BaseCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("MCTroll")) {
            return false;
        } else {
            if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.base")) {
                player.sendMessage(ChatColor.RED + "Permission denied");
            } else {
                player.sendMessage(this.main.prefix + " Commands for ScTroll");
                player.sendMessage(ChatColor.RED + "/Troll <player> " + ChatColor.DARK_AQUA + "Opens A Gui to troll a player!");
                player.sendMessage(ChatColor.RED + "/Push <player> " + ChatColor.DARK_AQUA + "Pushes any player you want to the sky!");
                player.sendMessage(ChatColor.RED + "/Potato <player> " + ChatColor.DARK_AQUA + "Fills any player's inventory to all potatoes!");
                player.sendMessage(ChatColor.RED + "/Fakeop <player> " + ChatColor.DARK_AQUA + "Send a convincing OP message to any player you want!");
                player.sendMessage(ChatColor.RED + "/Fakecrash <player> " + ChatColor.DARK_AQUA + "Kicks any player you want with a worrying crash message!");
                player.sendMessage(ChatColor.RED + "/Freeze <player> " + ChatColor.DARK_AQUA + "Freezes/Unfreezes any player you want!");
                player.sendMessage(ChatColor.RED + "/Poison <player> " + ChatColor.DARK_AQUA + "Gives any player you want a poison effect for few seconds!");
                player.sendMessage(ChatColor.RED + "/Sky <player> " + ChatColor.DARK_AQUA + "Launches any player you want into the sky!");
                player.sendMessage(ChatColor.RED + "/DropInv <player> " + ChatColor.DARK_AQUA + "Drops any player's inventory on the floor!");
                player.sendMessage(ChatColor.RED + "/Smg " + ChatColor.DARK_AQUA + "Gives you an smg to troll players with!");
                player.sendMessage(ChatColor.RED + "/Lavatroll <player>" + ChatColor.DARK_AQUA + "Sets the block under any player you want to lava!");
            }

            return true;
        }
    }
}

