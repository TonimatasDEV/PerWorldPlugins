package net.tonimatasmc.perworldplugins.manager;

import net.tonimatasmc.perworldplugins.PerWorldPlugins;
import net.tonimatasmc.perworldplugins.command.Command;
import net.tonimatasmc.perworldplugins.injector.listener.CommandPreProcessListener;
import net.tonimatasmc.perworldplugins.injector.listener.EnablePluginConfigCreator;
import net.tonimatasmc.perworldplugins.storage.TabulatorCompleter;
import net.tonimatasmc.perworldplugins.storage.YML.Config;
import org.bukkit.Bukkit;

import java.util.Objects;

public class RegisterManager {
    public static void register() {
        ymlRegister();
        injector();
        registerEvents();
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

    private static void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new EnablePluginConfigCreator(), PerWorldPlugins.getPlugin());
        Bukkit.getServer().getPluginManager().registerEvents(new CommandPreProcessListener(), PerWorldPlugins.getPlugin());
    }
}
