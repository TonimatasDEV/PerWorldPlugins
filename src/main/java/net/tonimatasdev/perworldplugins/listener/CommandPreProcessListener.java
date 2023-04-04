package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.Objects;

public class CommandPreProcessListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String commandString = event.getMessage().split(" ", 2)[0].replace("/", "");
        PluginCommand pluginCommand = Bukkit.getPluginCommand(commandString);
        Command command = PerWorldPlugins.getCommandMap().getCommand(commandString);

        PluginCommand minecraft = Bukkit.getPluginCommand("minecraft:" + commandString);
        System.out.println(minecraft);
        if (pluginCommand != null) {
            if (pluginCommand.getPlugin().equals(PerWorldPlugins.getInstance())) return;

            if (!PerWorldUtils.check(player.getWorld(), pluginCommand.getPlugin())) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
                event.setCancelled(true);
            }
        } else {
            if (command == null) return;

            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                if (plugin.equals(PerWorldPlugins.getInstance())) continue;
                if (!Arrays.asList(command.getClass().getName().split("\\.")).contains(plugin.getName().toLowerCase()))
                    continue;
                if (PerWorldUtils.check(player.getWorld(), plugin)) continue;

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
                event.setCancelled(true);
            }
        }
    }
}