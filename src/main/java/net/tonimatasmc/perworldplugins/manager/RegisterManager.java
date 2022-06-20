package net.tonimatasmc.perworldplugins.manager;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.command.Command;
import net.tonimatasmc.perworldplugins.injector.listener.CommandPreProcessListener;
import net.tonimatasmc.perworldplugins.storage.TabulatorCompleter;
import net.tonimatasmc.perworldplugins.storage.YML.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterManager {
    public static int number;

    public static void register() {
        ymlRegister();
        injector();
        pluginConfigCreator();
        registerEvents(Bukkit.getServer().getPluginManager(), PerWorldPlugins.getPlugin());
        registerCommands();
        registerTabulatorsCompleter();
    }

    private static void injector() {
        PerWorldPlugins.getInjector().load();
    }

    private static void ymlRegister() {
        Config.registerConfig();
    }

    private static void registerCommands() {
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setExecutor(new Command());

    }

    private static void registerTabulatorsCompleter() {
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setTabCompleter(new TabulatorCompleter());
    }

    private static void registerEvents(PluginManager pluginManager, Plugin plugin) {
        pluginManager.registerEvents(new CommandPreProcessListener(), plugin);
    }

    private static void pluginConfigCreator() {
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();

        while (number < plugins.length) {
            if (PerWorldPlugins.getPlugin().getConfig().getConfigurationSection("plugins." + plugins[number].getName()) == null) {
                if (!plugins[number].getName().equalsIgnoreCase(PerWorldPlugins.getPlugin().getName())) {
                    PerWorldPlugins.getPlugin().getConfig().set("plugins." + plugins[number].getName(), new ArrayList<>(List.of(("Example"))));
                    PerWorldPlugins.getPlugin().saveConfig();
                    PerWorldPlugins.getPlugin().reloadConfig();
                }
                number++;
            }
        }
    }
}
