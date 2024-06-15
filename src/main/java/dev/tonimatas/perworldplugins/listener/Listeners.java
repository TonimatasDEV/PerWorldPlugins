package dev.tonimatas.perworldplugins.listener;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.manager.CommandManager;
import dev.tonimatas.perworldplugins.util.PerWorldUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

public class Listeners implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPluginEnable(PluginEnableEvent event) {
        if (event.getPlugin().equals(PerWorldPlugins.getInstance())) return;

        CommandManager.addPluginCommands(event.getPlugin());

        if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + event.getPlugin().getName()).isEmpty()) {
            PerWorldPlugins.getInstance().getConfig().set("plugins." + event.getPlugin().getName(), Collections.singletonList("Example"));
            PerWorldPlugins.getInstance().saveConfig();
            PerWorldPlugins.getInstance().reloadConfig();
        }
    }

    @SuppressWarnings("DataFlowIssue")
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        String commandString = event.getMessage().split(" ")[0].replaceFirst("/", "");
        
        Command command = CommandManager.getCommandMap().getCommand(commandString);
        
        if (command == null) return;
        
        Plugin plugin = CommandManager.pluginMap.get(command);
        
        if (plugin != null && PerWorldUtils.getDisabledWorlds(plugin).contains(event.getPlayer().getWorld().getName())) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
                            PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))
                    .replaceAll("\\{world}", event.getPlayer().getWorld().getName())
                    .replaceAll("\\{player}", event.getPlayer().getName()));

            event.setCancelled(true);
        }
    }
}
