package de.raphael.heal.commands;

import de.raphael.heal.main.Main;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

import static de.raphael.heal.main.Main.getPlugin;

public class HealCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (player.hasPermission(getPlugin().getConfig().getString("permissions.heal"))) {
                if (args.length == 0) {
                    player.setHealth(20.0);
                    player.sendMessage("" + getPlugin().getConfig().getString("server.prefix") + " §a Du wurdest geheilt!");
                } else if (args.length == 1) {
                    final Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {

                        target.setHealth(20.0);

                        target.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§a Du wurdest geheilt!");
                        player.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§a Du hast den Spieler §6" + target.getName() + " §a geheilt!");
                    }else{
                            player.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§c Der Spieler §6" + args[0] + "§c ist nicht auf dem Server");
                        }
                    } else {
                        player.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") + "§c Bitte benutze §6/heal <SPIELER> §c!");
                    }
                } else {
                    player.sendMessage("" +getPlugin().getConfig().getString("server.prefix") + " §cDu hast keine Rechte dir fehlen " + getPlugin().getConfig().getString("permissions.heal"));
                }
            } else {
                sender.sendMessage(""  + getPlugin().getConfig().getString("server.prefix") +" Du kannst den Command nur als Spieler ausfuerhren");
            }
            return false;
        }
    }

