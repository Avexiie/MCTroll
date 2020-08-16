package com.github.avexiie.Commands;

import java.util.Iterator;
import com.github.avexiie.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LavaCommand implements CommandExecutor {
    private Main main;

    public LavaCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int length = args.length;
        Player player = (Player)sender;
        if (length == 1) {
            if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.lava")) {
                player.sendMessage(ChatColor.RED + "You do not have this permissions!");
            } else {
                Iterator var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var7.hasNext()) {
                    Player playertolava = (Player)var7.next();
                    Block block = playertolava.getLocation().getBlock().getRelative(BlockFace.DOWN);
                    if (playertolava.getName().equalsIgnoreCase(args[0])) {
                        block.setType(Material.LAVA);
                        player.sendMessage(this.main.prefix + " " + ChatColor.GREEN + playertolava.getName() + " Is now in lava!");
                    } else if (playertolava != null) {
                        player.sendMessage(ChatColor.RED + "Invalid Player");
                    }
                }
            }
        } else if (!player.hasPermission("mctroll.*") && !player.hasPermission("mctroll.lava")) {
            player.sendMessage(ChatColor.RED + "You do not have this permissions!");
        } else {
            player.sendMessage(ChatColor.RED + "/Lavatroll <player>");
        }

        return true;
    }
}
