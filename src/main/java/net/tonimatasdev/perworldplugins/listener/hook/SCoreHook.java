package net.tonimatasdev.perworldplugins.listener.hook;

import com.ssomar.score.api.executableblocks.load.ExecutableBlocksPostLoadEvent;
import com.ssomar.score.api.executableitems.events.AddItemInPlayerInventoryEvent;
import com.ssomar.score.api.executableitems.load.ExecutableItemsPostLoadEvent;
import com.ssomar.sevents.events.player.beforedeath.PlayerBeforeDeathEvent;
import com.ssomar.sevents.events.player.click.left.PlayerLeftClickEvent;
import com.ssomar.sevents.events.player.click.onentity.left.PlayerLeftClickOnEntityEvent;
import com.ssomar.sevents.events.player.click.onentity.right.PlayerRightClickOnEntityEvent;
import com.ssomar.sevents.events.player.click.onplayer.left.PlayerLeftClickOnPlayerEvent;
import com.ssomar.sevents.events.player.click.onplayer.right.PlayerRightClickOnPlayerEvent;
import com.ssomar.sevents.events.player.click.right.PlayerRightClickEvent;
import com.ssomar.sevents.events.player.equip.armor.PlayerEquipArmorEvent;
import com.ssomar.sevents.events.player.fish.block.PlayerFishBlockEvent;
import com.ssomar.sevents.events.player.fish.entity.PlayerFishEntityEvent;
import com.ssomar.sevents.events.player.fish.nothing.PlayerFishNothingEvent;
import com.ssomar.sevents.events.player.fish.player.PlayerFishPlayerEvent;
import com.ssomar.sevents.events.player.fly.active.PlayerActiveFlyEvent;
import com.ssomar.sevents.events.player.fly.desactive.PlayerDesactiveFlyEvent;
import com.ssomar.sevents.events.player.jump.PlayerJumpEvent;
import com.ssomar.sevents.events.player.kill.entity.PlayerKillEntityEvent;
import com.ssomar.sevents.events.player.kill.player.PlayerKillPlayerEvent;
import com.ssomar.sevents.events.player.press.PlayerPressPlateEvent;
import com.ssomar.sevents.events.player.receivehit.byentity.PlayerReceiveHitByEntityEvent;
import com.ssomar.sevents.events.player.receivehit.byplayer.PlayerReceiveHitByPlayerEvent;
import com.ssomar.sevents.events.player.receivehit.global.PlayerReceiveHitGlobalEvent;
import com.ssomar.sevents.events.player.sneak.active.PlayerActiveSneakEvent;
import com.ssomar.sevents.events.player.sneak.desactive.PlayerDesactiveSneakEvent;
import com.ssomar.sevents.events.player.sprint.active.PlayerActiveSprintEvent;
import com.ssomar.sevents.events.player.sprint.desactive.PlayerDesactiveSprintEvent;
import com.ssomar.sevents.events.player.tramplecrop.PlayerTrampleCropEvent;
import com.ssomar.sevents.events.projectile.hitblock.ProjectileHitBlockEvent;
import com.ssomar.sevents.events.projectile.hitentity.ProjectileHitEntityEvent;
import com.ssomar.sevents.events.projectile.hitplayer.ProjectileHitPlayerEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class SCoreHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExecutableBlocksPostLoad(ExecutableBlocksPostLoadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAddItemInPlayerInventory(AddItemInPlayerInventoryEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onExecutableItemsPostLoad(ExecutableItemsPostLoadEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerBeforeDeath(PlayerBeforeDeathEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerLeftClick(PlayerLeftClickEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerLeftClickOnEntity(PlayerLeftClickOnEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerRightClickOnEntity(PlayerRightClickOnEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerLeftClickOnPlayer(PlayerLeftClickOnPlayerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerRightClickOnPlayer(PlayerRightClickOnPlayerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerRightClick(PlayerRightClickEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerEquipArmor(PlayerEquipArmorEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerFishBlock(PlayerFishBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerFishEntity(PlayerFishEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerFishNothing(PlayerFishNothingEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerFishPlayer(PlayerFishPlayerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerActiveFly(PlayerActiveFlyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerDesactiveFly(PlayerDesactiveFlyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerJump(PlayerJumpEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerKillEntity(PlayerKillEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerKillPlayer(PlayerKillPlayerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerPressPlate(PlayerPressPlateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerReceiveHitByEntity(PlayerReceiveHitByEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerReceiveHitByPlayer(PlayerReceiveHitByPlayerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerReceiveHitGlobal(PlayerReceiveHitGlobalEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerActiveSneak(PlayerActiveSneakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerDesactiveSneak(PlayerDesactiveSneakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerActiveSprint(PlayerActiveSprintEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerDesactiveSprint(PlayerDesactiveSprintEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerTrampleCrop(PlayerTrampleCropEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onProjectileHitBlock(ProjectileHitBlockEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onProjectileHitEntity(ProjectileHitEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getTarget().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onProjectileHitPlayer(ProjectileHitPlayerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getTarget().getWorld());
    }
}
