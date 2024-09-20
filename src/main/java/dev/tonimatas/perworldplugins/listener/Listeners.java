package dev.tonimatas.perworldplugins.listener;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.manager.CommandManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.Collections;
import java.util.Objects;

public class Listeners implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPluginEnable(PluginEnableEvent event) {
        if (event.getPlugin().equals(PerWorldPlugins.getInstance())) return;

        CommandManager.addPluginCommands(event.getPlugin().getName());

        if (PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + event.getPlugin().getName()).isEmpty()) {
            PerWorldPlugins.getInstance().getConfig().set("plugins." + event.getPlugin().getName(), Collections.singletonList(":ignore"));
            PerWorldPlugins.getInstance().saveConfig();
            PerWorldPlugins.getInstance().reloadConfig();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        String commandStringWithVar = event.getMessage().split(" ")[0];
        String commandString = commandStringWithVar.replaceFirst("/", "");

        Command command = CommandManager.getCommands().get(commandString);
        if (!CommandManager.isCommandBlocked(command, event.getPlayer().getWorld().getName())) return;

        String possibleCommand = null;

        for (Command otherCommand : CommandManager.getCommands().values()) {
            if (CommandManager.isCommandBlocked(otherCommand, event.getPlayer().getWorld().getName())) continue;

            if (otherCommand.getName().contains(":")) {
                String[] otherCommandSplit = otherCommand.getName().split(":");

                if (otherCommandSplit[1].equals(commandString)) {
                    possibleCommand = otherCommand.getName();
                    break;
                }
            }

            // TODO: Implement not plugin:command
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
