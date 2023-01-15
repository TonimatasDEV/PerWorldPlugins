package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PlayerEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onAsyncChat(AsyncPlayerChatEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onAnimation(PlayerAnimationEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBedEnter(PlayerBedEnterEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBed().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBedLeave(PlayerBedLeaveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBed().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBucketEmpty(PlayerBucketEmptyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBucketFill(PlayerBucketFillEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onChangeWorld(PlayerChangedWorldEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onChannel(PlayerChannelEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onChatTabComplete(PlayerChatTabCompleteEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onDropItem(PlayerDropItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onEditBook(PlayerEditBookEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onEggThrow(PlayerEggThrowEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onExpChange(PlayerExpChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onFish(PlayerFishEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onGameModeChange(PlayerGameModeChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onInteractAtEntity(PlayerInteractAtEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onInteractEntity(PlayerInteractEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onInteract(PlayerInteractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onItemBreak(PlayerItemBreakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onItemConsume(PlayerItemConsumeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onItemDamage(PlayerItemDamageEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onItemHeld(PlayerItemHeldEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onJoin(PlayerJoinEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onKick(PlayerKickEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onLevelChange(PlayerLevelChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onLogin(PlayerLoginEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onMove(PlayerMoveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPickupItem(PlayerPickupItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPortal(PlayerPortalEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onQuit(PlayerQuitEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onRegisterChannel(PlayerRegisterChannelEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onResourcePackStatus(PlayerResourcePackStatusEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onRespawn(PlayerRespawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onShearEntity(PlayerShearEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onStatisticIncrement(PlayerStatisticIncrementEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onTeleport(PlayerTeleportEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onToggleFlight(PlayerToggleFlightEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onToggleSneak(PlayerToggleSneakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onToggleSprint(PlayerToggleSprintEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onUnleashEntity(PlayerUnleashEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onUnregisterChannel(PlayerUnregisterChannelEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onVelocity(PlayerVelocityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
