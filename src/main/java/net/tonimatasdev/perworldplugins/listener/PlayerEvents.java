package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

@SuppressWarnings("deprecation")
public class PlayerEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncChat(AsyncPlayerChatEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAnimation(PlayerAnimationEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBedEnter(PlayerBedEnterEvent event) {
        PerWorldUtils.fireEvent(event, event.getBed().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBedLeave(PlayerBedLeaveEvent event) {
        PerWorldUtils.fireEvent(event, event.getBed().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBucketEmpty(PlayerBucketEmptyEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBucketFill(PlayerBucketFillEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChangeWorld(PlayerChangedWorldEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChannel(PlayerChannelEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChat(PlayerChatEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onChatTabComplete(PlayerChatTabCompleteEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDropItem(PlayerDropItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEditBook(PlayerEditBookEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onEggThrow(PlayerEggThrowEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExpChange(PlayerExpChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFish(PlayerFishEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGameModeChange(PlayerGameModeChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInteractAtEntity(PlayerInteractAtEntityEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInteractEntity(PlayerInteractEntityEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onInteract(PlayerInteractEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemBreak(PlayerItemBreakEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemConsume(PlayerItemConsumeEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemDamage(PlayerItemDamageEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemHeld(PlayerItemHeldEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onJoin(PlayerJoinEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onKick(PlayerKickEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLevelChange(PlayerLevelChangeEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLogin(PlayerLoginEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMove(PlayerMoveEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPickupItem(PlayerPickupItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPortal(PlayerPortalEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onQuit(PlayerQuitEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRegisterChannel(PlayerRegisterChannelEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onResourcePackStatus(PlayerResourcePackStatusEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRespawn(PlayerRespawnEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShearEntity(PlayerShearEntityEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onStatisticIncrement(PlayerStatisticIncrementEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTeleport(PlayerTeleportEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onToggleFlight(PlayerToggleFlightEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onToggleSneak(PlayerToggleSneakEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onToggleSprint(PlayerToggleSprintEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUnleashEntity(PlayerUnleashEntityEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUnregisterChannel(PlayerUnregisterChannelEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVelocity(PlayerVelocityEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }
}
