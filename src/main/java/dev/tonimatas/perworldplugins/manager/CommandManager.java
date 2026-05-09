package dev.tonimatas.perworldplugins.manager;

import dev.tonimatas.perworldplugins.util.PerWorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.Map;

public class CommandManager implements Listener {
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
        
        if (command instanceof PluginCommand pluginCommand) {
            return PerWorldUtils.getDisabledWorlds(pluginCommand.getName()).contains(world);
        } else {
            return false;
        }
    }
}
