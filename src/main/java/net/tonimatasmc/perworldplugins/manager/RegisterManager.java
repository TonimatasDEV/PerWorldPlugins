package net.tonimatasmc.perworldplugins.manager;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.command.Command;
import net.tonimatasmc.perworldplugins.injector.listener.CommandPreProcessListener;
import net.tonimatasmc.perworldplugins.injector.listener.PluginRegisterConfigListener;
import net.tonimatasmc.perworldplugins.storage.TabulatorCompleter;
import net.tonimatasmc.perworldplugins.storage.YML.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.Objects;

public class RegisterManager {
    public static void register() {
        ymlRegister();
        injector();
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
        pluginManager.registerEvents(new PluginRegisterConfigListener(), plugin);
    }
}
