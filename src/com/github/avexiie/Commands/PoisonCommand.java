package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PoisonCommand implements CommandExecutor {
    private Main main;

    public PoisonCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        int length = args.length;
        if (length == 1) {
            if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.poison")) {
                player.sendMessage(ChatColor.RED + "You do not have this permissions!");
            } else {
                Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var7.hasNext()) {
                    Player playertopoison = (Player)var7.next();
                    if (playertopoison.getName().equalsIgnoreCase(args[0])) {
                        playertopoison.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 1));
                        player.sendMessage(this.main.prefix + " " + ChatColor.translateAlternateColorCodes('&', this.main.getConfig().getString("PoisonMessage").replace("%player%", playertopoison.getName())));
                    } else if (playertopoison != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player!");
                    }
                }
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.poison")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/Poison <player>");
        }

        return true;
    }
}

