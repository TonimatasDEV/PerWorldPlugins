package net.tonimatasdev.perworldplugins.listener;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.api.PerWorldCommand;
import net.tonimatasdev.perworldplugins.manager.CommandManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class Listeners implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        // Get command string.
        String commandString = event.getMessage().split(" ")[0].replaceFirst("/", "");
        // Get command.
        Command command = CommandManager.getCommandMap().getCommand(commandString);
        // Detects if the command is null.
        if (command == null) return;
        // Detects if the command is PerWorldCommand.
        if (!(command instanceof PerWorldCommand)) return;
        // Get PerWorldCommand.
        PerWorldCommand perWorldCommand = (PerWorldCommand) command;
        System.out.println(perWorldCommand.getPlugin().getName());
        // Check if the player is in the disabled world
        if (perWorldCommand.getDisabledWorlds().contains(event.getPlayer().getWorld().getName())) {
            // Send block message to the player.
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
            // Cancel the event.
            event.setCancelled(true);
        }
    }
}
