package net.tonimatasdev.perworldplugins.event;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.util.IncompatiblePlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class CommandPreProcessListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().split(" ", 2)[0].replace("/", "");
        PluginCommand pluginCommand = Bukkit.getPluginCommand(command);

        if (pluginCommand != null) {
            if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + pluginCommand.getPlugin().getName()).contains(event.getPlayer().getWorld().getName())) {
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage")));
                event.setCancelled(true);
            }
        } else {
            Plugin plugin = IncompatiblePlugins.getIncompatiblePluginWithCommand(command);

            if (plugin != null) {
                if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName()).contains(event.getPlayer().getWorld().getName())) {
                    event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage")));
                    event.setCancelled(true);
                }
            }
        }
    }
}