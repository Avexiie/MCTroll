package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FopCommand implements CommandExecutor {
    private Main main;

    public FopCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int length = args.length;
        Player player = (Player)sender;
        if (length == 1) {
            Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(true) {
                while(var7.hasNext()) {
                    Player playertotroll = (Player)var7.next();
                    if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.fakeop")) {
                        player.sendMessage(ChatColor.RED + "You do not have this permissions!");
                    } else if (playertotroll.getName().equalsIgnoreCase(args[0])) {
                        player.sendMessage(this.main.prefix + " " + ChatColor.GREEN + "Sent " + playertotroll.getName() + "A fake op message!");
                        playertotroll.sendMessage(ChatColor.GRAY + ChatColor.ITALIC.toString() + "[Server]: Opped " + ChatColor.GRAY + ChatColor.ITALIC.toString() + playertotroll.getName() + ChatColor.GRAY + ChatColor.ITALIC.toString() + "]");
                    } else if (playertotroll != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player!");
                    }
                }

                return true;
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.fakeop")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.GRAY + ChatColor.ITALIC.toString() + "[Server]: Opped " + ChatColor.GRAY + ChatColor.ITALIC.toString() + player.getName() + ChatColor.GRAY + ChatColor.ITALIC.toString() + "]");
        }

        return true;
    }
}