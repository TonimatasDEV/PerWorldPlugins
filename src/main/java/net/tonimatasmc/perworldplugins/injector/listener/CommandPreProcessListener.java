package net.tonimatasmc.perworldplugins.injector.listener;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.util.IncompatiblePlugins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class CommandPreProcessListener implements Listener {

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
       String command = event.getMessage().split(" ", 2)[0].replace("/", "");
       PluginCommand pluginCommand = Bukkit.getPluginCommand(command);

       if (pluginCommand != null) {
           if (PerWorldPlugins.getPlugin().getConfig().getStringList("plugins." + pluginCommand.getPlugin().getName()).contains(event.getPlayer().getWorld().getName())) {
               event.setCancelled(true);
               event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getPlugin().getConfig().getString("disabledCommandMessage"))));
           }
       } else {
           Plugin plugin = IncompatiblePlugins.getIncompatiblePluginWithCommand(command);

           if (plugin != null) {
               if (PerWorldPlugins.getPlugin().getConfig().getStringList("plugins." + plugin.getName()).contains(event.getPlayer().getWorld().getName())) {
                   event.setCancelled(true);
                   event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getPlugin().getConfig().getString("disabledCommandMessage"))));
               }
           }
       }
   }
}