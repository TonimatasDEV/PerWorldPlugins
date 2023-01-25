package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;
import org.bukkit.event.player.PlayerRiptideEvent;

import java.util.Arrays;

public class v113 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.addAll(Arrays.asList(
                BlockCookEvent.getHandlerList(),
                BlockDispenseArmorEvent.getHandlerList(),
                BlockDropItemEvent.getHandlerList(),
                BlockFertilizeEvent.getHandlerList(),
                BlockShearEntityEvent.getHandlerList(),
                FluidLevelChangeEvent.getHandlerList(),
                MoistureChangeEvent.getHandlerList(),
                SpongeAbsorbEvent.getHandlerList(),
                BatToggleSleepEvent.getHandlerList(),
                EntityDropItemEvent.getHandlerList(),
                EntityPlaceEvent.getHandlerList(),
                EntityPoseChangeEvent.getHandlerList(),
                EntityToggleSwimEvent.getHandlerList(),
                EntityTransformEvent.getHandlerList(),
                PigZombieAngerEvent.getHandlerList(),
                VillagerCareerChangeEvent.getHandlerList(),
                PlayerCommandSendEvent.getHandlerList(),
                PlayerRecipeDiscoverEvent.getHandlerList(),
                PlayerRiptideEvent.getHandlerList()
                //ServerLoadEvent.getHandlerList()
        ));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCook(BlockCookEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDispenseArmor(BlockDispenseArmorEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDropItem(BlockDropItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFertilize(BlockFertilizeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShearEntity(BlockShearEntityEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFluidLevelChange(FluidLevelChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMoistureChange(MoistureChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpongeAbsorb(SpongeAbsorbEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBatToggleSleep(BatToggleSleepEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDropItem(EntityDropItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlace(EntityPlaceEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPoseChange(EntityPoseChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onToggleSwim(EntityToggleSwimEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTransform(EntityTransformEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPigZombieAnger(PigZombieAngerEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVillagerCareerChange(VillagerCareerChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCommandSend(PlayerCommandSendEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRecipeDiscover(PlayerRecipeDiscoverEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRiptide(PlayerRiptideEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    //@EventHandler(priority = EventPriority.MONITOR)
    //public static void onLoad(ServerLoadEvent event) {
    //    ListenerUtils.noWorldEvents(event);
    //}
}
