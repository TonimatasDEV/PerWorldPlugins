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
    private static final List<PerWorldCommand> commands = new ArrayList<>();

    public static void init() {
        // Replace all Commands to PerWorldCommands.
        for (PerWorldCommand command : commands) {
            // Replace command for the PerWorldCommand.
            replace(command);
        }

        // Set the blocked worlds to the commands.
        setWorldsToCommands();
        commands.clear();
    }

    public static void addPluginCommands(Plugin plugin) {
        // Get all keys.
        List<String> keys = new ArrayList<>(getCommands().keySet());

        for (String key : keys) {
            // Get PerWorldCommand and add to perWorldCommands list.
            Command command = getCommands().get(key);

            // If a default command or PerWorldCommand, continue.
            if (defaultCommands.contains(command.getName()) || command instanceof PerWorldCommand) continue;
            // If the command are registered, continue.
            if (commands.stream().anyMatch(perWorldCommand -> perWorldCommand.getName().equals(command.getName()) || perWorldCommand.getAliases().contains(command.getName()))) continue;

            // Get and add PerWorldCommand.
            commands.add(PerWorldCommand.get(command, plugin));
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

    public static void replace(PerWorldCommand command) {
        // Replace command name.
        getCommands().replace(command.getName(), command);
        // Replace plugin + command name.
        getCommands().replace(command.getPlugin().getName().toLowerCase(Locale.ENGLISH) + ":" + command.getName(), command);

        // Replace all aliases.
        for (String alias : command.getAliases()) {
            // Replace alias.
            getCommands().replace(alias, command);
            // Replace plugin + alias.
            getCommands().replace(command.getPlugin().getName().toLowerCase(Locale.ENGLISH) + ":" + alias, command);
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
