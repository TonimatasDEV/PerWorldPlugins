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
        getCommands().keySet().stream().filter(str -> {
            if (defaultCommands.contains(getCommands().get(str))) return false;
            if (getCommands().get(str).getClass().getName().equals("org.bukkit.craftbukkit.command.VanillaCommandWrapper")) {
                Map<String, Command> commandMap = pluginMap.get("minecraft");

                if (commandMap == null) commandMap = new HashMap<>();
                if (commandMap.containsKey(str)) return false;

                commandMap.put(str, getCommands().get(str));
                pluginMap.put("minecraft", commandMap);
                return false;
            }
            
            for (Map<String, Command> commandMap : pluginMap.values()) {
                if (commandMap.containsKey(str)) return false;
            }
            
            return true;
        }).forEach(str -> {
            Map<String, Command> commandMap = pluginMap.get(plugin);
            
            if (commandMap == null) commandMap = new HashMap<>();
            
            commandMap.put(str, getCommands().get(str));
            pluginMap.put(plugin, commandMap);
        });
    }

    public static void addDefaultCommands() {
        for (Command command : getCommands().values()) {
            if (defaultCommands.contains(command)) continue;
            defaultCommands.add(command);
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
