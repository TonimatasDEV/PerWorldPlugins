package net.tonimatasmc.perworldplugins.injector.listener.fixers;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.util.WorldUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.scoreboard.Scoreboard;

@SuppressWarnings("deprecation")
public class ScoreboardFixer implements Listener {
    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event) {
        if (event.getFrom() != event.getPlayer().getWorld()) {
            if (PerWorldPlugins.getPlugin().getConfig().getStringList("plugins.BuildBattle").contains(WorldUtil.getWorldFromEvent(event).getName())) {
                event.getPlayer().setScoreboard((Scoreboard) Bukkit.getServer().getScoreboardManager().getMainScoreboard().getObjectives());
                event.getPlayer().setScoreboard((Scoreboard) Bukkit.getServer().getScoreboardManager().getNewScoreboard().getObjectives());

                event.getPlayer().setScoreboard((Scoreboard) Bukkit.getServer().getScoreboardManager().getMainScoreboard().getPlayers());
                event.getPlayer().setScoreboard((Scoreboard) Bukkit.getServer().getScoreboardManager().getNewScoreboard().getPlayers());
            }
        }
    }
}
