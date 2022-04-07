package de.raphael.heal.main;

import de.raphael.heal.commands.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;

    public void onEnable() {
        plugin = this;
        FileConfiguration config = Main.getPlugin().getConfig();
        saveDefaultConfig();
        System.out.println("Das Plugin SoftHeal ist mit dem Prefix" + getConfig().getString("server.prefix") + " gestartet!");
        getCommand("heal").setExecutor((CommandExecutor)new HealCommand());
        getCommand("feed").setExecutor((CommandExecutor)new FeedCommand());
    }

    public static Main getPlugin() {
        return plugin;
    }

}