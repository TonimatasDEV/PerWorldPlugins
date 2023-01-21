package net.tonimatasdev.perworldplugins.listener.hook;

import com.sk89q.worldguard.bukkit.event.block.BreakBlockEvent;
import com.sk89q.worldguard.bukkit.event.block.PlaceBlockEvent;
import com.sk89q.worldguard.bukkit.event.block.UseBlockEvent;
import com.sk89q.worldguard.bukkit.event.entity.DamageEntityEvent;
import com.sk89q.worldguard.bukkit.event.entity.DestroyEntityEvent;
import com.sk89q.worldguard.bukkit.event.entity.SpawnEntityEvent;
import com.sk89q.worldguard.bukkit.event.entity.UseEntityEvent;
import com.sk89q.worldguard.bukkit.event.inventory.UseItemEvent;
import com.sk89q.worldguard.bukkit.event.player.ProcessPlayerEvent;
import com.sk89q.worldguard.bukkit.protection.events.DisallowedPVPEvent;
import com.sk89q.worldguard.bukkit.protection.events.flags.FlagContextCreateEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class WorldGuardHook implements Listener {
    @EventHandler
    public static void onDisallowedPVP(DisallowedPVPEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAttacker().getWorld());
    }

    @EventHandler
    public static void onFlagContextCreate(FlagContextCreateEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler
    public static void onBreakBlock(BreakBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onPlaceBlock(PlaceBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onUseBlock(UseBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onDamageEntity(DamageEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onDestroyEntity(DestroyEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onSpawnEntity(SpawnEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onUseEntity(UseEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onUseItem(UseItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getWorld());
    }

    @EventHandler
    public static void onProcessPlayer(ProcessPlayerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
