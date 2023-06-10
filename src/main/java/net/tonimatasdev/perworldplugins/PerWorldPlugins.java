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
        AtomicLong time = new AtomicLong();
        time.set(System.currentTimeMillis());

        saveDefaultConfig();
        GroupsYML.register();

        getServer().getPluginManager().registerEvents(new CommandManager(), this);

        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setExecutor(new PrimaryCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setTabCompleter(new PrimaryCommand());

        if (getConfig().getBoolean("metrics")) {
            new Metrics(this, 15794);
        }

        if (getConfig().getBoolean("updateChecker")) {
            UpdateChecker.check();
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(getDescription().getName() + " " + getDescription().getVersion() + " has been enabled. (" + (System.currentTimeMillis() - time.get()) + "ms)");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            time.set(System.currentTimeMillis());

            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                if (plugin.equals(this)) continue;

                ListenerManager.convert(plugin);

                if (getConfig().getStringList("plugins." + plugin.getName()).isEmpty()) {
                    getConfig().set("plugins." + plugin.getName(), Collections.singletonList("Example"));
                    saveConfig();
                    reloadConfig();
                }
            }

            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Converted all Listeners correctly. (" + (System.currentTimeMillis() - time.get()) + "ms)");
        });
    }

    @Override
    public void onDisable() {
        this.reloadConfig();
        this.saveConfig();
    }
}

