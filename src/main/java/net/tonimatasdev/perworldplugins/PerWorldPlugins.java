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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins instance;
    private static final Thread thread = new Thread(() -> {
        List<String> registered = new ArrayList<>();

        while (true) {
            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                // Detect if the plugin is registered.
                if (registered.contains(plugin.getName())) continue;
                // Detect if the plugin is enabled.
                if (!plugin.isEnabled()) continue;
                // Detect if the plugin is PerWorldPlugins.
                if (plugin.equals(PerWorldPlugins.getInstance())) return;

                // Add plugin commands to PerWorldPlugins command manager.
                CommandManager.addPluginCommands(plugin);
                // Add the plugin to registered list.
                registered.add(plugin.getName());
            }
        }
    });

    public static PerWorldPlugins getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        // Start thread.
        thread.start();
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
            // Register all converted commands.
            CommandManager.init();

            // Create individual sections for plugins in the config.
            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                if (!PerWorldPlugins.getInstance().getConfig().getStringList("plugins." + plugin.getName()).isEmpty()) continue;
                PerWorldPlugins.getInstance().getConfig().set("plugins." + plugin.getName(), Collections.singletonList("Example"));
                PerWorldPlugins.getInstance().saveConfig();
                PerWorldPlugins.getInstance().reloadConfig();
            }

            // Stop the thread.
            thread.interrupt();

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

