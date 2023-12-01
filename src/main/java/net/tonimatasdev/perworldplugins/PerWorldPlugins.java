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

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        // Enable PerWorldPlugins
        this.getPluginLoader().enablePlugin(this);
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
        CommandManager.getCommandMap().register("perworldplugins", new PrimaryCommand());

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
            // Register all converted commands.
            CommandManager.setWorldsToCommands();

            // Send a message on finish all Events/Commands.
            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Converted all Listeners/Commands correctly.");
        });
    }

    @Override
    public void onDisable() {
        // Save config and disable the plugin.
        this.reloadConfig();
        this.saveConfig();
    }
}

