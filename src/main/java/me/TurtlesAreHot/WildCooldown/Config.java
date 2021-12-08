package me.TurtlesAreHot.WildCooldown;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class Config {
    private static FileConfiguration config;

    public static void reloadConfig() { config = JavaPlugin.getPlugin(Main.class).getConfig(); }



    public static int getCooldown() { return config.getInt("cooldown"); }
}
