package net.tonimatasdev.perworldplugins;

import net.tonimatasdev.perworldplugins.command.PrimaryCommand;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import net.tonimatasdev.perworldplugins.listener.Listeners;
import net.tonimatasdev.perworldplugins.manager.CommandManager;
import net.tonimatasdev.perworldplugins.manager.ListenerManager;
import net.tonimatasdev.perworldplugins.metrics.Metrics;
import net.tonimatasdev.perworldplugins.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        // Register config files.
        saveDefaultConfig();
        GroupsYML.register();

        // Register events.
        getServer().getPluginManager().registerEvents(new Listeners(), this);

        // Register command and tab completer.
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setExecutor(new PrimaryCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setTabCompleter(new PrimaryCommand());

        // Register metrics.
        if (getConfig().getBoolean("metrics")) new Metrics(this, 15794);

        // Check updates.
        if (getConfig().getBoolean("updateChecker")) UpdateChecker.check();


        // Send enabled messages.
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(getDescription().getName() + " " + getDescription().getVersion() + " has been enabled.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        // Create task for convert RegisteredListeners to PerWorldRegisteredListeners.
        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            // Convert listeners and set worlds to commands.
            ListenerManager.convert();
            CommandManager.setWorldsToCommands();
            CommandManager.clear();

            // Send a message on completion of conversion.
            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Converted all Listeners correctly.");
        });
    }

    @Override
    public void onDisable() {
        // Save config and disable the plugin.
        this.reloadConfig();
        this.saveConfig();
    }
}

