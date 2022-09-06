package net.tonimatasdev.perworldplugins.injector.listener.fixers;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.storage.YML.Fixer;
import net.tonimatasdev.perworldplugins.util.WorldUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class OriginsFixer implements Listener {
    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        if (event.getFrom() != event.getPlayer().getWorld()) {
            if (PerWorldPlugins.getPlugin().getServer().getPluginManager().getPlugin("Origins-Bukkit") != null) {
                if (Fixer.getFix().getBoolean("OriginsFixer.enabled")) {

                    if (PerWorldPlugins.getPlugin().getConfig().getStringList("plugins.Origins-Bukkit").contains(WorldUtil.getWorldFromEvent(event).getName())) {
                        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "origin set " + player.getName() + " origins-bukkit:origin origins-bukkit:human");
                    } else {
                        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "origin item give " + player.getName() + " origins-bukkit:orb_of_origin 1");
                    }
                }
            }
        }
    }
}
