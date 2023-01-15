package net.tonimatasdev.perworldplugins;

import net.tonimatasdev.perworldplugins.command.Command;
import net.tonimatasdev.perworldplugins.metrics.Metrics;
import net.tonimatasdev.perworldplugins.storage.TabulatorCompleter;
import net.tonimatasdev.perworldplugins.storage.YML.Config;
import net.tonimatasdev.perworldplugins.util.ListenerUtils;
import net.tonimatasdev.perworldplugins.listener.BlockEventP;
import net.tonimatasdev.perworldplugins.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }


    public void onEnable() {
        instance = this;
        Config.registerConfig();

        getServer().getPluginManager().registerEvents(new BlockEventP(), this);

        Bukkit.getPluginCommand("perworldplugins").setExecutor(new Command());
        Bukkit.getPluginCommand("perworldplugins").setTabCompleter(new TabulatorCompleter());

        getServer().getScheduler().scheduleSyncDelayedTask(this, ListenerUtils::addListeners);

        new Metrics(this, 15794);

        if (this.getConfig().getBoolean("updateChecker")) {
            UpdateChecker.check();
        }
    }

    public void onDisable() {
        this.reloadConfig();
        this.saveConfig();
    }
}

