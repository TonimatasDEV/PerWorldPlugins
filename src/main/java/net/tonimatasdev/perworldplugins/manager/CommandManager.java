package net.tonimatasdev.perworldplugins.manager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements Listener {
    public static Map<Command, Plugin> pluginMap = new HashMap<>();
    private static final List<String> defaultCommands = Arrays.asList("version", "timings", "reload", "plugins", "tps", "mspt", "paper", "spigot", "restart", "perworldplugins");

    public static void addPluginCommands(Plugin plugin) {
        // Get all commands
        for (Command command : getCommands().values()) {
            // Detect if the command is a default command or is already registered.
            if (defaultCommands.contains(command.getName()) || pluginMap.containsKey(command)) continue;
            // Get PerWorldCommand and add to perWorldCommands list.
            pluginMap.put(command, plugin);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Command> getCommands() {
        try {
            // Get "knownCommands" field.
            Field knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");
            // Set accessible.
            knownCommandsField.setAccessible(true);

            // Return knownCommands field from command map.
            return (Map<String, Command>) knownCommandsField.get(getCommandMap());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static SimpleCommandMap getCommandMap() {
        try {
            // Get "commandMap" field.
            Field commandMapField = SimplePluginManager.class.getDeclaredField("commandMap");
            // Set accessible.
            commandMapField.setAccessible(true);

            // Return server command map.
            return (SimpleCommandMap)  commandMapField.get(Bukkit.getPluginManager());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
