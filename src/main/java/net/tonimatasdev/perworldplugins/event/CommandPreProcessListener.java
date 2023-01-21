package net.tonimatasdev.perworldplugins.event;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandPreProcessListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        PluginCommand pluginCommand = Bukkit.getPluginCommand(event.getMessage().split(" ", 2)[0].replace("/", ""));

        if (pluginCommand != null) {
            if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + pluginCommand.getPlugin().getName()).contains(event.getPlayer().getWorld().getName())) {
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage")));
                event.setCancelled(true);
            }
        }
    }
}