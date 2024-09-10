package dev.tonimatas.perworldplugins.manager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements Listener {
    public static Map<String, Map<String, Command>> pluginMap = new HashMap<>();
    public static final List<Command> defaultCommands = new ArrayList<>();

    public static void addPluginCommands(String plugin) {
        getCommands().values().stream().filter(command -> {
            if (defaultCommands.contains(command)) return false;
            if (command.getClass().getName().contains("VanillaCommandWrapper")) return false;
            
            for (Map<String, Command> commandMap : pluginMap.values()) {
                if (commandMap.containsValue(command)) return false;
            }
            
            return true;
        }).forEach(command -> {
            Map<String, Command> commandMap = pluginMap.get(plugin);
            
            if (commandMap == null) commandMap = new HashMap<>();

            commandMap.put(command.getName(), command);
            pluginMap.put(plugin, commandMap);
        });
    }

    public static void addDefaultCommands(boolean onlyMinecraft) {
        for (Command command : getCommands().values()) {
            if (defaultCommands.contains(command)) continue;
            if (onlyMinecraft) {
                if (command.getClass().getName().contains("VanillaCommandWrapper")) {
                    defaultCommands.add(command);
                }
            } else {
                defaultCommands.add(command);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Command> getCommands() {
        try {
            Field knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");

            knownCommandsField.setAccessible(true);

            return (Map<String, Command>) knownCommandsField.get(getCommandMap());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Error on get knownCommands field. Report it on PerWorldPlugins github.");
        }
    }

    public static CommandMap getCommandMap() {
        try {
            Field commandMapField = SimplePluginManager.class.getDeclaredField("commandMap");

            commandMapField.setAccessible(true);

            return (CommandMap) commandMapField.get(Bukkit.getPluginManager());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Error on get commandMap field. Report it on PerWorldPlugins github.");
        }
    }
}
