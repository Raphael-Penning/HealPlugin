package de.raphael.heal.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.raphael.heal.main.Main.getPlugin;

public class FeedCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (player.hasPermission(getPlugin().getConfig().getString("permissions.feed"))) {
                if (args.length == 0) {
                    player.setFoodLevel(20);
                    player.sendMessage("" + getPlugin().getConfig().getString("server.prefix") + " §a Du wurdest gefüttert");
                } else if (args.length == 1) {
                    final Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setFoodLevel(20);
                        target.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§a Du wurdest gefüttert!");
                        player.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§a Du hast den Spieler §6" + target.getName() + " §a gefüttert!");
                    }else{
                        player.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§c Der Spieler §6" + args[0] + "§c ist nicht auf dem Server");
                    }
                } else {
                    player.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§c Bitte benutze §6/Feed <SPIELER> §c!");
                }
            } else {
                player.sendMessage("" +getPlugin().getConfig().getString("server.prefix") + " §cDu hast keine Rechte dir fehlen " + getPlugin().getConfig().getString("permissions.feed"));
            }
        } else {
            sender.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") +" Du kannst den Command nur als Spieler ausfuerhren");
        }
        return false;
    }
}

