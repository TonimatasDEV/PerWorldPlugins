package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

public class BlockEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBreak(BlockBreakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBurn(BlockBurnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onCanBuild(BlockCanBuildEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onDamage(BlockDamageEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onDispense(BlockDispenseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onExp(BlockExpEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onExplode(BlockExplodeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onFade(BlockFadeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onForm(BlockFormEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onFromTo(BlockFromToEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onGrow(BlockGrowEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onIgnite(BlockIgniteEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onMultiPlace(BlockMultiPlaceEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    //@EventHandler(priority = EventPriority.HIGHEST) // TODO: Magma generates many errors.
    //public static void onPhysicsEvent(BlockPhysicsEvent event) {
    //    ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    //}

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPistonExtend(BlockPistonExtendEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPistonRetract(BlockPistonRetractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onPlaceEvent(BlockPlaceEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onRedstone(BlockRedstoneEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onSpread(BlockSpreadEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onEntityForm(EntityBlockFormEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onLeavesDecay(LeavesDecayEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onNotePlay(NotePlayEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onSingChange(SignChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getBlock().getWorld());
    }
}
