package dev.tonimatas.perworldplugins.manager;

import dev.tonimatas.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandManager implements Listener {
    public static final List<Command> defaultCommands = new ArrayList<>();

    public static void addPluginCommands(String plugin) {
        getCommands().keySet().stream().filter(key -> {
            if (getCommands().get(key).getClass().getName().contains("VanillaCommandWrapper")) return false;
            if (defaultCommands.contains(getCommands().get(key))) return false;

            Command command = getCommands().get(key);
            return !command.getDescription().contains("pwp-");
        }).forEach(key -> getCommands().get(key).setDescription(getCommands().get(key).getDescription() + " pwp-" + plugin));
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

    public static boolean isCommandBlocked(Command command, String world) {
        if (command == null) return false;

        String[] splitDescription = command.getDescription().split("pwp-");
        if (splitDescription.length != 2) return false;

        return PerWorldUtils.getDisabledWorlds(splitDescription[1]).contains(world);
    }
}
