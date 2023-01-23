package net.tonimatasdev.perworldplugins.listener.hook;

import net.ess3.api.events.*;
import net.essentialsx.api.v2.events.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class EssentialsHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAfkStatusChange(AfkStatusChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onFlyStatusChange(FlyStatusChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGodStatusChange(GodStatusChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onIgnoreStatusChange(IgnoreStatusChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onJailStatusChange(JailStatusChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onKitClaim(KitClaimEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onLocalChatSpy(LocalChatSpyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onMuteStatusChange(MuteStatusChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onNickChange(NickChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrivateMessagePreSent(PrivateMessagePreSendEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPrivateMessageSent(PrivateMessageSentEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSignBreak(SignBreakEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSignCreate(SignCreateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSign(SignEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSignInteract(SignInteractEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTPARequest(TPARequestEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getTarget().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onNickChange(UserBalanceUpdateEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUserRandomTeleport(UserRandomTeleportEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getCenter().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUserTeleportHome(UserTeleportHomeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUserRandomTeleport(UserWarpEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVanishStatusChange(VanishStatusChangeEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getAffected().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onAsyncUserDataLoad(AsyncUserDataLoadEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTeleportRequestResponse(TeleportRequestResponseEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getRequester().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTransaction(TransactionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getTarget().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUserAction(UserActionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUserKick(UserKickEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getKicker().getBase().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onWarpModify(WarpModifyEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getNewLocation().getWorld());
    }
}
