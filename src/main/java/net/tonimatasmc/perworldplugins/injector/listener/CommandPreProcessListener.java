package net.tonimatasmc.perworldplugins.injector.listener;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class CommandPreProcessListener implements Listener {

   @EventHandler
   public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
       PluginCommand pluginCommand = Bukkit.getPluginCommand(event.getMessage().split(" ", 2)[0].replace("/", ""));

       if (pluginCommand != null) {
           if (PerWorldPlugins.getPlugin().getConfig().getStringList("plugins." + pluginCommand.getPlugin().getName()).contains(event.getPlayer().getWorld().getName())) {
               event.setCancelled(true);
               event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getPlugin().getConfig().getString("disabledCommandMessage"))));
           }
       }
   }
}