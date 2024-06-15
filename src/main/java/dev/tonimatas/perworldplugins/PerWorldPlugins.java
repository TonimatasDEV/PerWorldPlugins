package dev.tonimatas.perworldplugins;

import dev.tonimatas.perworldplugins.command.PrimaryCommand;
import dev.tonimatas.perworldplugins.config.GroupsYML;
import dev.tonimatas.perworldplugins.listener.Listeners;
import dev.tonimatas.perworldplugins.manager.CommandManager;
import dev.tonimatas.perworldplugins.manager.ListenerManager;
import dev.tonimatas.perworldplugins.metrics.Metrics;
import dev.tonimatas.perworldplugins.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        this.getPluginLoader().enablePlugin(this);
    }

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        GroupsYML.register();

        getServer().getPluginManager().registerEvents(new Listeners(), this);

        CommandManager.getCommandMap().register("perworldplugins", new PrimaryCommand());
        
        CommandManager.addDefaultCommands();

        if (getConfig().getBoolean("metrics")) new Metrics(this, 15794);

        if (getConfig().getBoolean("updateChecker")) UpdateChecker.check();

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(getDescription().getName() + " " + getDescription().getVersion() + " has been enabled.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            ListenerManager.convert();

            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Converted all Listeners correctly.");
        });
    }

    @Override
    public void onDisable() {
        this.reloadConfig();
        this.saveConfig();
    }
}

