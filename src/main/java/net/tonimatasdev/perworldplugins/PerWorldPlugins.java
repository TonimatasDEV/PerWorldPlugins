package net.tonimatasdev.perworldplugins;

import net.tonimatasdev.perworldplugins.command.PrimaryCommand;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import net.tonimatasdev.perworldplugins.manager.CommandManager;
import net.tonimatasdev.perworldplugins.manager.ListenerManager;
import net.tonimatasdev.perworldplugins.metrics.Metrics;
import net.tonimatasdev.perworldplugins.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public final class PerWorldPlugins extends JavaPlugin {
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        // Count time for get ms to load.
        AtomicLong time = new AtomicLong();
        time.set(System.currentTimeMillis());

        // Register config files.
        saveDefaultConfig();
        GroupsYML.register();

        // Register events.
        getServer().getPluginManager().registerEvents(new CommandManager(), this);

        // Register command and tab completer.
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setExecutor(new PrimaryCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setTabCompleter(new PrimaryCommand());

        // Register metrics.
        if (getConfig().getBoolean("metrics")) {
            new Metrics(this, 15794);
        }

        // Check updates.
        if (getConfig().getBoolean("updateChecker")) {
            UpdateChecker.check();
        }

        // Send enabled message.
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(getDescription().getName() + " " + getDescription().getVersion() + " has been enabled. (" + (System.currentTimeMillis() - time.get()) + "ms)");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        // Create task for convert RegisteredListeners to PerWorldRegisteredListeners.
        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            time.set(System.currentTimeMillis());

            //Get all plugins and convert events 1 by 1.
            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                if (plugin.equals(this)) continue; // If plugins is PerWorldPlugins it is not executed and goes to the next one.

                // Convert.
                ListenerManager.convert(plugin);

                // Create individual sections for plugins in the config.
                if (getConfig().getStringList("plugins." + plugin.getName()).isEmpty()) {
                    getConfig().set("plugins." + plugin.getName(), Collections.singletonList("Example"));
                    saveConfig();
                    reloadConfig();
                }
            }

            // Send message on completion of conversion.
            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Converted all Listeners correctly. (" + (System.currentTimeMillis() - time.get()) + "ms)");
        });
    }

    @Override
    public void onDisable() {
        // Save config and disable the plugin.
        this.reloadConfig();
        this.saveConfig();
    }
}

