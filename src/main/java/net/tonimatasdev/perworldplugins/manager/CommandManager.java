package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.api.PerWorldCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.*;

public class CommandManager implements Listener {
    private static final List<String> defaultCommands = Arrays.asList("version", "timings", "reload", "plugins", "tps", "mspt", "paper", "spigot", "restart", "perworldplugins");

    private static final Map<String, PerWorldCommand> perWorldCommands = new HashMap<>();
    //private static final List<PerWorldCommand> perWorldCommands = new ArrayList<>();

    public static void init() {
        // Replace all Commands to PerWorldCommands.
        perWorldCommands.keySet().forEach(key -> getCommands().replace(key, perWorldCommands.get(key)));

        // Set the blocked worlds to the commands.
        setWorldsToCommands();
    }

    public static void addPluginCommands(Plugin plugin) {
        // Get all keys.
        for (String commandKey : getCommands().keySet()) {
            // Get the command from the key.
            Command command = getCommands().get(commandKey);
            // Check if it is default command, PerWorldCommand or is a registered key.
            if (defaultCommands.contains(command.getName()) || command instanceof PerWorldCommand || perWorldCommands.containsKey(commandKey)) continue;
            // Get and add a PerWorldCommand to perWorldCommands list.
            perWorldCommands.put(commandKey, PerWorldCommand.get(command, plugin));
        }
    }

    public static void setWorldsToCommands() {
        // Get all command map values.
        for (Command command : getCommandMap().getCommands()) {
            // Check if is a PerWorldCommand.
            if (command instanceof PerWorldCommand) {
                // Set disabled worlds to the command.
                ((PerWorldCommand) command).setDisabledWorlds();
            }
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
