package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class CommandPreProcessListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        PluginCommand command = Bukkit.getPluginCommand(event.getMessage().split(" ")[0].replaceFirst("/", ""));

        if (command == null) return;
        if (PerWorldUtils.check(event.getPlayer().getWorld(), command.getPlugin())) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
            event.setCancelled(true);
        }
    }
}