package net.tonimatasdev.perworldplugins;

import net.tonimatasdev.perworldplugins.command.Command;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import net.tonimatasdev.perworldplugins.event.CommandPreProcessListener;
import net.tonimatasdev.perworldplugins.event.PluginEnableListener;
import net.tonimatasdev.perworldplugins.listener.*;
import net.tonimatasdev.perworldplugins.listener.multiversion.MultiVersion;
import net.tonimatasdev.perworldplugins.metrics.Metrics;
import net.tonimatasdev.perworldplugins.storage.TabulatorCompleter;
import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import net.tonimatasdev.perworldplugins.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }


    @SuppressWarnings("DataFlowIssue")
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        GroupsYML.register();

        getServer().getPluginManager().registerEvents(new CommandPreProcessListener(), this);
        getServer().getPluginManager().registerEvents(new PluginEnableListener(), this);

        getServer().getPluginManager().registerEvents(new BlockEvents(), this);
        getServer().getPluginManager().registerEvents(new EnchantEvents(), this);
        getServer().getPluginManager().registerEvents(new EntityEvents(), this);
        getServer().getPluginManager().registerEvents(new HangingEvents(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getPluginManager().registerEvents(new VehicleEvents(), this);
        getServer().getPluginManager().registerEvents(new WeatherEvents(), this);
        getServer().getPluginManager().registerEvents(new WorldEvents(), this);

        HandlerListUtil.register();
        MultiVersion.register();

        Bukkit.getPluginCommand("perworldplugins").setExecutor(new Command());
        Bukkit.getPluginCommand("perworldplugins").setTabCompleter(new TabulatorCompleter());

        getServer().getScheduler().scheduleSyncDelayedTask(this, ListenerUtils::addListeners);

        new Metrics(this, 15794);

        if (getConfig().getBoolean("updateChecker")) {
            UpdateChecker.check();
        }
    }

    public void onDisable() {
        this.reloadConfig();
        this.saveConfig();
    }
}

