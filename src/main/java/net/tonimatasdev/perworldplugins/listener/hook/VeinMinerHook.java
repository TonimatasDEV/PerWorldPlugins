package net.tonimatasdev.perworldplugins.listener.hook;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import wtf.choco.veinminer.api.event.player.PlayerClientActivateVeinMinerEvent;
import wtf.choco.veinminer.api.event.player.PlayerVeinMineEvent;
import wtf.choco.veinminer.api.event.player.PlayerVeinMiningPatternChangeEvent;

public class VeinMinerHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerClientActiveVeinMiner(PlayerClientActivateVeinMinerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerVeinMine(PlayerVeinMineEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerVeinMiningPatternChange(PlayerVeinMiningPatternChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

}
