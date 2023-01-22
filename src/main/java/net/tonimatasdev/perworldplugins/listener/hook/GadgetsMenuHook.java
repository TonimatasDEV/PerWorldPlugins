package net.tonimatasdev.perworldplugins.listener.hook;

import com.yapzhenyie.GadgetsMenu.api.event.mysteryboxes.OpenMysteryBoxEvent;
import com.yapzhenyie.GadgetsMenu.api.event.mysteryboxes.PlayerSendMysteryGiftEvent;
import com.yapzhenyie.GadgetsMenu.api.event.mysterydust.AssignMysteryDustEvent;
import com.yapzhenyie.GadgetsMenu.api.event.mysterydust.GainMysteryDustEvent;
import com.yapzhenyie.GadgetsMenu.api.event.mysterydust.RemoveMysteryDustEvent;
import com.yapzhenyie.GadgetsMenu.api.event.mysteryvault.MysteryVaultPreviewEvent;
import depend.xxmicloxx.NoteBlockAPI.event.SongDestroyingEvent;
import depend.xxmicloxx.NoteBlockAPI.event.SongEndEvent;
import depend.xxmicloxx.NoteBlockAPI.event.SongStoppedEvent;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class GadgetsMenuHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSongDestroying(SongDestroyingEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSongEnd(SongEndEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSongStopped(SongStoppedEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpenMysteryBox(OpenMysteryBoxEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPayerSendMysteryGift(PlayerSendMysteryGiftEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getSender().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAssignMysteryDust(AssignMysteryDustEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGainMysteryDust(GainMysteryDustEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onRemoveMysteryDust(RemoveMysteryDustEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMysteryVaultPreview(MysteryVaultPreviewEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }
}
