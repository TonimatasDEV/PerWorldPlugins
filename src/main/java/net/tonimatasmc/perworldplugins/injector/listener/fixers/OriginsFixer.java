package net.tonimatasmc.perworldplugins.injector.listener.fixers;

import me.lemonypancakes.bukkit.origins.OriginsBukkit;
import me.lemonypancakes.bukkit.origins.entity.player.OriginPlayer;
import me.lemonypancakes.bukkit.origins.origin.layer.OriginLayer;
import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.storage.YML.Fixer;
import net.tonimatasmc.perworldplugins.util.WorldUtil;
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
                    OriginPlayer originPlayer = OriginsBukkit.getOriginPlayer(event.getPlayer());
                    OriginLayer originLayer = (OriginLayer) originPlayer;

                    if (!(PerWorldPlugins.getPlugin().getConfig().getStringList("plugins.Origins-Bukkit").contains(WorldUtil.getWorldFromEvent(event).getName()))) {
                        Fixer.getFix().set("OriginsFixer.players." + player.getName(), originPlayer.getOrigin(originLayer));
                        Fixer.reloadFix();
                        Fixer.saveFix();
                        originPlayer.setOrigin(originLayer, originLayer.getDefaultOrigin());
                    } else {
                        originPlayer.setOrigin(originLayer, originPlayer.getOrigin((OriginLayer) Fixer.getFix().get("OriginsFixer.players." + player.getName())));
                    }
                }
            }
        }
    }
}
