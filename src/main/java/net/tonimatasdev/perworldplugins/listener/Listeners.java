package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.manager.CommandManager;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

import java.util.Collections;
import java.util.Objects;

public class Listeners implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPluginEnable(PluginEnableEvent event) {
        // Detect if the plugin is PerWorldPlugins.
        if (event.getPlugin().equals(PerWorldPlugins.getInstance())) return;

        // Add plugin commands to PerWorldPlugins command manager.
        CommandManager.addPluginCommands(event.getPlugin());

        // Create individual sections for plugins in the config.

        if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + event.getPlugin().getName()).isEmpty()) {
            PerWorldPlugins.getInstance().getConfig().set("plugins." + event.getPlugin().getName(), Collections.singletonList("Example"));
            PerWorldPlugins.getInstance().saveConfig();
            PerWorldPlugins.getInstance().reloadConfig();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        // Get command string.
        String commandString = event.getMessage().split(" ")[0].replaceFirst("/", "");
        // Get command.
        Command command = CommandManager.getCommandMap().getCommand(commandString);
        // Detects if the command is null.
        if (command == null) return;
        // Get the plugin of the command.
        Plugin plugin = CommandManager.pluginMap.get(command);
        // Detects if the plugin is null.
        if (plugin == null) return;

        // Check if the player is in the disabled world
        if (PerWorldUtils.getDisabledWorlds(plugin).contains(event.getPlayer().getWorld().getName())) {
            // Send block message to the player.
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', 
                    Objects.requireNonNull(Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))
                            .replaceAll("\\{world}", event.getPlayer().getWorld().getName())
                            .replaceAll("\\{player}", event.getPlayer().getName()))));
            // Cancel the event.
            event.setCancelled(true);
        }
    }
}
