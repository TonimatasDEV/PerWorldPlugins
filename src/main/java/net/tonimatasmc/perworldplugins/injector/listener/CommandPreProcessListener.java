package net.tonimatasmc.perworldplugins.injector.listener;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class CommandPreProcessListener implements Listener {

   @EventHandler
   public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
       PluginCommand pluginCommand = Bukkit.getPluginCommand(StringUtils.replaceOnce(StringUtils.split(event.getMessage(), " ", 2)[0], "/", ""));

       if (pluginCommand != null) {
           if (PerWorldPlugins.getPlugin().getConfig().getStringList("plugins." + pluginCommand.getPlugin().getName()).contains(event.getPlayer().getWorld().getName())) {
               event.setCancelled(true);
               event.getPlayer().sendMessage("This command is disabled for this world.");
           }
       }
   }
}