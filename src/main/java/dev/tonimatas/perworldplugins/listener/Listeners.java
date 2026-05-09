package dev.tonimatas.perworldplugins.listener;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.manager.CommandManager;
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
        String commandStringWithVar = event.getMessage().split(" ")[0];
        String commandString = commandStringWithVar.replaceFirst("/", "");

        Command command = CommandManager.getCommands().get(commandString);
        if (!CommandManager.isCommandBlocked(command, event.getPlayer().getWorld().getName())) return;

        String possibleCommand = null;

        for (Command otherCommand : CommandManager.getCommands().values()) {
            if (!otherCommand.getName().contains(":")) continue;
            if (!otherCommand.getName().startsWith("minecraft:")) continue;
            if (CommandManager.isCommandBlocked(otherCommand, event.getPlayer().getWorld().getName())) continue;

            String[] otherCommandSplit = otherCommand.getName().split(":");

            if (otherCommandSplit[1].equals(commandString)) {
                possibleCommand = otherCommand.getName();
                break;
            }
        }

        if (possibleCommand == null) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
                            Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage")))
                    .replaceAll("\\{world}", event.getPlayer().getWorld().getName())
                    .replaceAll("\\{player}", event.getPlayer().getName()));
            event.setCancelled(true);
        } else {
            event.getPlayer().sendMessage(possibleCommand);
            event.setMessage(event.getMessage().replaceFirst(commandStringWithVar, "/" + possibleCommand));
        }
    }
}
