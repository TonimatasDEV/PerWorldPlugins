package net.tonimatasdev.perworldplugins.listener.hook;

import io.lumine.mythic.bukkit.events.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MythicMobsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onApplyEnchant(MythicApplyEnchantEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onConditionLoad(MythicConditionLoadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDamage(MythicDamageEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDropLoad(MythicDropLoadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onHealMechanic(MythicHealMechanicEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMechanicLoad(MythicMechanicLoadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMobDeath(MythicMobDeathEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMobDespawn(MythicMobDespawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMobInteract(MythicMobInteractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMobItemGenerate(MythicMobItemGenerateEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMobLootDrop(MythicMobLootDropEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMobSpawn(MythicMobSpawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onModifiedInventory(MythicModifiedInventoryEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerLoaded(MythicPlayerLoadedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerSignal(MythicPlayerSignalEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPostReloaded(MythicPostReloadedEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onProjectileHit(MythicProjectileHitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getBukkitEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onReloaded(MythicReloadedEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onStatChange(MythicStatChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTargeterLoad(MythicTargeterLoadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
