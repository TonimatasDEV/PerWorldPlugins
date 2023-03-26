package net.tonimatasdev.perworldplugins;

import net.tonimatasdev.perworldplugins.command.Command;
import net.tonimatasdev.perworldplugins.config.GroupsYML;
import net.tonimatasdev.perworldplugins.event.CommandPreProcessListener;
import net.tonimatasdev.perworldplugins.listener.*;
import net.tonimatasdev.perworldplugins.listener.multiversion.MultiVersion;
import net.tonimatasdev.perworldplugins.metrics.Metrics;
import net.tonimatasdev.perworldplugins.storage.TabulatorCompleter;
import net.tonimatasdev.perworldplugins.util.HandlerListUtil;
import net.tonimatasdev.perworldplugins.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public final class PerWorldPlugins extends JavaPlugin {
    private static final Map<HandlerList, List<RegisteredListener>> map = new HashMap<>();
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }

    public static Map<HandlerList, List<RegisteredListener>> getMap() {
        return map;
    }

    @Override
    public void onEnable() {
        instance = this;
        AtomicLong time = new AtomicLong();
        time.set(System.currentTimeMillis());

        saveDefaultConfig();
        GroupsYML.register();

        getServer().getPluginManager().registerEvents(new CommandPreProcessListener(), this);

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

        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setExecutor(new Command());
        Objects.requireNonNull(Bukkit.getPluginCommand("perworldplugins")).setTabCompleter(new TabulatorCompleter());

        new Metrics(this, 15794);

        if (getConfig().getBoolean("updateChecker")) {
            UpdateChecker.check();
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(getDescription().getName() + getDescription().getVersion() + " has been enabled. (" + (System.currentTimeMillis() - time.get()) + "ms)");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        getServer().getScheduler().scheduleSyncDelayedTask(PerWorldPlugins.getInstance(), () -> {
            time.set(System.currentTimeMillis());

            HandlerListUtil.minecraftHandlerLists.forEach((handlerList -> {
                List<RegisteredListener> listeners = new ArrayList<>();

                for (RegisteredListener registeredListener : handlerList.getRegisteredListeners()) {
                    if (registeredListener.getPlugin().getName().equalsIgnoreCase("PerWorldPlugins")) continue;
                    listeners.add(registeredListener);
                    handlerList.unregister(registeredListener);
                }

                map.put(handlerList, listeners);
            }));

            for (Plugin plugin : getServer().getPluginManager().getPlugins()) {
                if (plugin.getName().equals("PerWorldPlugins")) continue;
                if (getConfig().getStringList("plugins." + plugin.getName()).isEmpty()) continue;

                getConfig().set("plugins." + plugin.getName(), Collections.singletonList("Example"));
                saveConfig();
                reloadConfig();
            }

            Bukkit.getConsoleSender().sendMessage("[PerWorldPlugins] " + ChatColor.GREEN + "Unregistered all Listeners correctly. (" + (System.currentTimeMillis() - time.get()) + "ms)");
        });
    }

    @Override
    public void onDisable() {
        this.reloadConfig();
        this.saveConfig();
    }
}

