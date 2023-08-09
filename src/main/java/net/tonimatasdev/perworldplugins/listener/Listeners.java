package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.api.PerWorldCommand;
import net.tonimatasdev.perworldplugins.manager.CommandManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.TabCompleteEvent;

import java.util.Collections;
import java.util.Objects;

public class Listeners implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void enablePlugin(PluginEnableEvent event) {
        // Detect if the plugin is PerWorldPlugins.
        if (event.getPlugin().equals(PerWorldPlugins.getInstance())) return;

        // Create individual sections for plugins in the config.
        if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + event.getPlugin().getName()).isEmpty()) {
            PerWorldPlugins.getInstance().getConfig().set("plugins." + event.getPlugin().getName(), Collections.singletonList("Example"));
            PerWorldPlugins.getInstance().saveConfig();
            PerWorldPlugins.getInstance().reloadConfig();
        }

        // Add plugin commands to PerWorldPlugins command manager.
        CommandManager.addPluginCommands(event.getPlugin());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        // Get command.
        String message = event.getMessage().split(" ")[0].replaceFirst("/", "");
        PerWorldCommand perWorldCommand = CommandManager.commands.get(message.split(":").length > 1 ? message.split(":")[1] : message);

        // Detects if the command is null.
        if (perWorldCommand == null) return;

        // Get PerWorldCommand and check if the player is in the disabled world.
        if (perWorldCommand.getDisabledWorlds().contains(event.getPlayer().getWorld().getName())) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onTabComplete(TabCompleteEvent event) {
        // TODO: Coming Soon
    }
}
