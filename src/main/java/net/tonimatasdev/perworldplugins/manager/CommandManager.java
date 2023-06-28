package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class CommandManager implements Listener {
    private static final Map<Plugin, List<Command>> perWorldPluginsCommandMap = new HashMap<>();
    private static final List<Command> registered = new ArrayList<>();
    private static final List<String> defaultCommands = Arrays.asList("version", "timings", "reload", "plugins", "tps", "mspt", "paper", "spigot", "restart");

    @EventHandler
    private void onPluginEnable(PluginEnableEvent event) {
        try {
            // Get CommandMap of Bukkit.
            Field commandMapField = SimplePluginManager.class.getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getPluginManager());

            // Detects if CommandMap is a SimpleCommandMap.
            if (commandMap instanceof SimpleCommandMap) {
                SimpleCommandMap simpleCommandMap = (SimpleCommandMap) commandMap;

                // Create the command list.
                List<Command> commandList = new ArrayList<>();

                // Get all commands of SimpleCommandManager.
                for (Command command : simpleCommandMap.getCommands()) {
                    // If the command is default, registered or PluginCommand, skip it.
                    if (defaultCommands.contains(command.getName()) || registered.contains(command) || command instanceof PluginCommand) continue;

                    // Add the command to lists.
                    commandList.add(command);
                    registered.add(command);
                }

                // Detects if the command list is empty.
                if (!commandList.isEmpty()) {

                    // Put the command list to the specific plugin.
                    perWorldPluginsCommandMap.put(event.getPlugin(), commandList);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        String commandName = event.getMessage().split(" ")[0].replaceFirst("/", ""); // Get command.
        PluginCommand pluginCommand = Bukkit.getPluginCommand(commandName);

        boolean pluginIsBlocked = false;

        // If PluginCommand is not null.
        if (pluginCommand != null) {
            pluginIsBlocked = PerWorldUtils.check(event.getPlayer().getWorld(), pluginCommand.getPlugin());
        } else { // If PluginCommand is null.
            // Get all plugins of PerWorldCommandMap.
            for (Plugin plugin : perWorldPluginsCommandMap.keySet()) {
                // If the command is in the list of plugin commands.
                if (perWorldPluginsCommandMap.get(plugin).stream().map(Command::getName).collect(Collectors.toList()).contains(commandName)) {
                    // Check if the plugin is blocked and change the variable.
                    pluginIsBlocked = PerWorldUtils.check(event.getPlayer().getWorld(), plugin);
                    break;
                }
            }
        }

        // If plugin is blocked send a message and cancel the event, otherwise nothing happens.
        if (pluginIsBlocked) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
            event.setCancelled(true);
        }
    }
}
