package net.tonimatasmc.perworldplugins.injector.listener.fixers;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.storage.YML.Fixer;
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
                    //Object object = Fixer.getFix().get("OriginsFixer.origin");
                    //OriginPlayer originPlayer = OriginsBukkit.getOriginPlayer(event.getPlayer());
                    //((OriginLayer) object).setEnabled(!PerWorldPlugins.getPlugin().getConfig().getStringList("plugins.Origins-Bukkit").contains(WorldUtil.getWorldFromEvent(event).getName()));
                }
            }
        }
    }
}
