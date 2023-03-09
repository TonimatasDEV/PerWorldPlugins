package net.tonimatasdev.perworldplugins.event;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class CommandPreProcessListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String commandName = event.getMessage().split(" ", 2)[0].replace("/", "");

        PluginCommand pluginCommand = Bukkit.getPluginCommand(commandName);
        if (pluginCommand == null) {
            return;
        }

        String pluginName = pluginCommand.getPlugin().getName();
        List<String> disabledWorlds = PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + pluginName);
        String worldName = player.getWorld().getName();

        if (disabledWorlds.contains(worldName)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage")));
            event.setCancelled(true);
        }
    }
}