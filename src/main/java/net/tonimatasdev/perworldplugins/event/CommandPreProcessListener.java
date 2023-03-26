package net.tonimatasdev.perworldplugins.event;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class CommandPreProcessListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String commandName = event.getMessage().split(" ", 2)[0].replace("/", "");

        PluginCommand pluginCommand = Bukkit.getPluginCommand(commandName);

        if (pluginCommand == null) return;
        if (pluginCommand.getPlugin().getName().equalsIgnoreCase("PerWorldPlugins")) return;

        if (!PerWorldUtils.check(player.getWorld(), pluginCommand.getPlugin())) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
            event.setCancelled(true);
        }
    }
}