package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.api.PerWorldCommand;
import net.tonimatasdev.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.*;

public class CommandManager implements Listener {
    public static final Map<String, PerWorldCommand> commands = new HashMap<>();
    private static final List<String> defaultCommands = Arrays.asList("version", "timings", "reload", "plugins", "tps", "mspt", "paper", "spigot", "restart", "perworldplugins");
    private static final List<Command> registered = new ArrayList<>();

    public static void addPluginCommands(Plugin plugin) {
        // Get all commands of server command map.
        for (Command command : getCommandMap().getCommands()) {
            // If the command is default, registered or PluginCommand, skip it.
            if (defaultCommands.contains(command.getName()) || registered.contains(command)) continue;
            // Put the command to the command map.
            registered.add(command);
            commands.put(command.getName(), new PerWorldCommand(plugin));
        }
    }

    public static void setWorldsToCommands() {
        // Get all command map values.
        for (PerWorldCommand command : commands.values()) {
            // Set disabled worlds to the command.
            command.setDisabledWorlds(PerWorldUtils.getDisabledWorlds(command.getPlugin()));
        }
    }

    private static SimpleCommandMap getCommandMap() {
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

    public static void clear() {
        registered.clear();
    }
}
