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
            Field commandMapField = SimplePluginManager.class.getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getPluginManager());


            if (commandMap instanceof SimpleCommandMap) {
                SimpleCommandMap simpleCommandMap = (SimpleCommandMap) commandMap;

                List<Command> commandList = new ArrayList<>();

                for (Command command : simpleCommandMap.getCommands()) {
                    if (defaultCommands.contains(command.getName()) || registered.contains(command) || command instanceof PluginCommand) continue;

                    commandList.add(command);
                    registered.add(command);
                }

                if (!commandList.isEmpty()) {
                    perWorldPluginsCommandMap.put(event.getPlugin(), commandList);

                    for (Command command : commandList) {
                        System.out.println(command.getName());
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        String commandName = event.getMessage().split(" ")[0].replaceFirst("/", "");
        PluginCommand pluginCommand = Bukkit.getPluginCommand(commandName);

        boolean pluginIsBlocked = false;
        if (pluginCommand != null) {
            pluginIsBlocked = PerWorldUtils.check(event.getPlayer().getWorld(), pluginCommand.getPlugin());
        } else {
            for (Plugin plugin : perWorldPluginsCommandMap.keySet()) {
                if (perWorldPluginsCommandMap.get(plugin).stream().map(Command::getName).collect(Collectors.toList()).contains(commandName)) {
                    pluginIsBlocked = PerWorldUtils.check(event.getPlayer().getWorld(), plugin);
                }
            }
        }


        if (pluginIsBlocked) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldPlugins.getInstance().getConfig().getString("disabledCommandMessage"))));
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }
}
