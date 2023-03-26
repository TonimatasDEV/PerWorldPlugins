package net.tonimatasdev.perworldplugins.listener.multiversion;

import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.SpongeAbsorbEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import org.bukkit.event.entity.PigZombieAngerEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerRiptideEvent;

public class v1130 implements Listener {
    public static void addHandlerList() {
        HandlerListUtil.minecraftHandlerLists.add(BlockFertilizeEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(SpongeAbsorbEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityDropItemEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityToggleSwimEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PigZombieAngerEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerCommandSendEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(PlayerRiptideEvent.getHandlerList());
        HandlerListUtil.minecraftHandlerLists.add(EntityPotionEffectEvent.getHandlerList());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFertilize(BlockFertilizeEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSpongeAbsorb(SpongeAbsorbEvent event) {
        PerWorldUtils.fireEvent(event, event.getBlock().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onDropItem(EntityDropItemEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onToggleSwim(EntityToggleSwimEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPigZombieAnger(PigZombieAngerEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCommandSend(PlayerCommandSendEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRiptide(PlayerRiptideEvent event) {
        PerWorldUtils.fireEvent(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRiptide(EntityPotionEffectEvent event) {
        PerWorldUtils.fireEvent(event, event.getEntity().getWorld());
    }
}
