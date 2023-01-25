package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class EntityEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCreatureSpawn(CreatureSpawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCreeperPower(CreeperPowerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBreakDoor(EntityBreakDoorEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChangeBlock(EntityChangeBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCombustByBlock(EntityCombustByBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCombustByEntity(EntityCombustByEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCombust(EntityCombustEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    //@EventHandler(priority = EventPriority.MONITOR)
    //public static void onCreatePortal(EntityCreatePortalEvent event) {
    //    ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    //}

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDamageByBlock(EntityDamageByBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDamageByEntity(EntityDamageByEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDamage(EntityDamageEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDeath(EntityDeathEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExplode(EntityExplodeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInteract(EntityInteractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPortalEnter(EntityPortalEnterEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPortal(EntityPortalEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPortalExit(EntityPortalExitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRegainHealth(EntityRegainHealthEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShootBow(EntityShootBowEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpawn(EntitySpawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTame(EntityTameEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTarget(EntityTargetEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTargetLivingEntity(EntityTargetLivingEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTeleport(EntityTeleportEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUnleash(EntityUnleashEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExpBottle(ExpBottleEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExplosionPrime(ExplosionPrimeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFireworkExplode(FireworkExplodeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFoodLevelChange(FoodLevelChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onHorseJump(HorseJumpEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemDespawn(ItemDespawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemMerge(ItemMergeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemSpawn(ItemSpawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPigZap(PigZapEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerDeath(PlayerDeathEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLeashEntity(PlayerLeashEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPotionSplash(PotionSplashEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onProjectileHit(ProjectileHitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onProjectileLaunch(ProjectileLaunchEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSheepDyeWool(SheepDyeWoolEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSheepRegrowWool(SheepRegrowWoolEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSlimeSplit(SlimeSplitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpawnerSpawn(SpawnerSpawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }
}
