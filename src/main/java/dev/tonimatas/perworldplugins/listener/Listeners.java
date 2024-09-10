package dev.tonimatas.perworldplugins.listener;

import dev.tonimatas.perworldplugins.PerWorldPlugins;
import dev.tonimatas.perworldplugins.manager.CommandManager;
import dev.tonimatas.perworldplugins.util.PerWorldUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.*;

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
        Map<String, Command> commands = CommandManager.getCommands();
        String commandStringWithVar = event.getMessage().split(" ")[0];
        String commandString = commandStringWithVar.replaceFirst("/", "");
        
        Command command = commands.get(commandString);

        if (command == null) return;
        
        List<String> possibleCommands = new ArrayList<>();

        for (String plugin : CommandManager.pluginMap.keySet()) {
            Map<String, Command> commandMap = CommandManager.pluginMap.get(plugin);

            if (PerWorldUtils.getDisabledWorlds(plugin).contains(event.getPlayer().getWorld().getName())) {
                continue;
            }

            boolean isHere = false;
            for (Command cmd : commandMap.values()) {
                if (cmd.getName().equalsIgnoreCase(commandString) || cmd.getAliases().contains(commandString)) {
                    isHere = true;
                    break;
                }
            }
            
            if (!isHere) continue;
            
            String commandStr;
            
            if (commandString.contains(":")) {
                commandStr = commandString;
            } else {
                commandStr = plugin.toLowerCase(Locale.ENGLISH) + ":" + commandString;
            }

            if (CommandManager.getCommands().get(commandStr) == null) {
                possibleCommands.add(commandString);
            } else {
                possibleCommands.add(commandStr);
            }
        }
        
        for (Command defaultCommand : CommandManager.defaultCommands) {
            if (defaultCommand.getName().equals(commandString) || defaultCommand.getAliases().contains(commandString)) {
                possibleCommands.add(defaultCommand.getName());
            }
        }
        
        if (possibleCommands.isEmpty() && commands.containsKey(commandString)) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
                            Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage")))
                    .replaceAll("\\{world}", event.getPlayer().getWorld().getName())
                    .replaceAll("\\{player}", event.getPlayer().getName()));
            event.setCancelled(true);
        } else {
            if (possibleCommands.isEmpty()) return;
            
            event.setMessage(event.getMessage().replaceFirst(commandStringWithVar, "/" + possibleCommands.get(0)));
        }
        
    }
}
