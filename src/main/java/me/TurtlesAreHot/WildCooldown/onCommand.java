package me.TurtlesAreHot.WildCooldown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class onCommand implements Listener {

    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent event) {
        if(event.getMessage().length() >= "/wild".length()) {
            if (event.getMessage().startsWith("/wild") ||
                    event.getMessage().startsWith("/rtp")) {
                // Check the cooldown to make sure they don't have a cooldown.
                long cooldown = (long) Cooldown.checkCooldown(event.getPlayer()) / 1000;
                // cooldown is the number of seconds that has passed since the cooldown started.
                if (cooldown < Config.getCooldown() && cooldown != -1) {
                    // This case is if the player is still on cooldown
                    event.getPlayer().sendMessage(ChatColor.RED + "You are still on cooldown. You must wait before using this command again.");
                    event.setCancelled(true);
                } else {
                    if (cooldown >= Config.getCooldown()) {
                        Cooldown.removeCooldown(event.getPlayer());
                    }
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wild -p " + event.getPlayer().getName() + " -w bending");
                    Cooldown.addCooldown(event.getPlayer(), System.currentTimeMillis());
                    event.setCancelled(true);
                }
            }
        }

    }
}
