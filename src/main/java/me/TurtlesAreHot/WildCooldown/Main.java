package me.TurtlesAreHot.WildCooldown;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    private static File dataFolder;

    @Override
    public void onEnable() {
        dataFolder = getDataFolder();
        createCooldownFolder();
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        config.addDefault("cooldown", 300); // in seconds
        Config.reloadConfig();
        this.getServer().getPluginManager().registerEvents(new onCommand(), this);
    }

    @Override
    public void onDisable() {

    }

    public static File getFolder() { return dataFolder; }

    public void createCooldownFolder() {
        File cooldownFolder = new File(getFolder(),  "/cooldown/");
        if(!(cooldownFolder.exists())) {
            cooldownFolder.mkdirs();
        }
    }
}