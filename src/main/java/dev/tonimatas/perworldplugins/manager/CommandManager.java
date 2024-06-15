package dev.tonimatas.perworldplugins.manager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements Listener {
    public static Map<Command, Plugin> pluginMap = new HashMap<>();
    public static final List<Command> defaultCommands = new ArrayList<>();

    public static void addPluginCommands(Plugin plugin) {
        getCommands().values().stream().filter(cmd -> !defaultCommands.contains(cmd) && !pluginMap.containsKey(cmd)).forEach(cmd -> pluginMap.put(cmd, plugin));
    }

    public static void addDefaultCommands() {
        getCommands().values().stream().filter(command -> !defaultCommands.contains(command)).forEach(defaultCommands::add);
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
