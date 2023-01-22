package net.tonimatasdev.perworldplugins.listener.hook;

import com.bencodez.votingplugin.events.*;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class VotingPluginHook implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerPostVote(PlayerPostVoteEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerReceivePoints(PlayerReceivePointsEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerSpecialReward(PlayerSpecialRewardEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getUser().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerVoteCoolDownEnd(PlayerVoteCoolDownEndEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerVote(PlayerVoteEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVotingPluginUser().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerVoteSiteCoolDownEnd(PlayerVoteSiteCoolDownEndEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onVoteParty(VotePartyEvent event) {
        ListenerUtils.noWorldEvents(event);
    }
}
