package net.tonimatasdev.perworldplugins.manager;

import net.tonimatasdev.perworldplugins.PerWorldPlugins;
import net.tonimatasdev.perworldplugins.command.Command;
import net.tonimatasdev.perworldplugins.injector.listener.CommandPreProcessListener;
import net.tonimatasdev.perworldplugins.injector.listener.EnablePluginConfigCreator;
import net.tonimatasdev.perworldplugins.storage.TabulatorCompleter;
import net.tonimatasdev.perworldplugins.storage.YML.Config;
import net.tonimatasdev.perworldplugins.util.UpdateChecker;
import net.tonimatasdev.perworldplugins.util.metrics.Metrics;
import org.bukkit.Bukkit;

import java.util.Objects;

public class RegisterManager {
    public static void register() {
        ymlRegister();
        injector();
        registerEvents();
        registerCommands();
        registerTabulatorsCompleter();
        updateChecker();
        metrics();
    }

    private static void injector() {
        PerWorldPlugins.getInjector().load();
    }

    private static void metrics() {
        int pluginId = 15794;
        new Metrics(PerWorldPlugins.getPlugin(), pluginId);
    }

    private static void updateChecker() {
        if (PerWorldPlugins.getPlugin().getConfig().getBoolean("updateChecker")) {
            UpdateChecker.check();
        }
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
