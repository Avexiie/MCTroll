package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrashCommand implements CommandExecutor {
    private Main main;

    public CrashCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 1) {
            if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.fakecrash")) {
                player.sendMessage(ChatColor.RED + "You do not have this permissions!");
            } else {
                Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var7.hasNext()) {
                    Player playertocrash = (Player)var7.next();
                    if (playertocrash.getName().equalsIgnoreCase(args[0])) {
                        player.sendMessage(this.main.prefix + " " + ChatColor.GREEN + "Crashed " + playertocrash.getName());
                        playertocrash.kickPlayer(ChatColor.RED + "Could not connect to a default or fallback server, please try again later: io.netty.channel.ConnectTimeoutException");
                    } else if (playertocrash != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player!");
                    }
                }
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.fakecrash")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/FakeCrash <player>");
        }

        return true;
    }
}