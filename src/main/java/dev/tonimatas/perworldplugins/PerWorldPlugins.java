package dev.tonimatas.perworldplugins;

import dev.tonimatas.perworldplugins.command.PrimaryCommand;
import dev.tonimatas.perworldplugins.config.GroupsYML;
import dev.tonimatas.perworldplugins.listener.Listeners;
import dev.tonimatas.perworldplugins.manager.CommandManager;
import dev.tonimatas.perworldplugins.manager.ListenerManager;
import dev.tonimatas.perworldplugins.metrics.Metrics;
import dev.tonimatas.perworldplugins.util.PerWorldUtils;
import dev.tonimatas.perworldplugins.util.UpdateChecker;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("UnstableApiUsage")
public final class PerWorldPlugins extends JavaPlugin {
    public static final ComponentLogger LOGGER = ComponentLogger.logger("PerWorldPlugins");
    private static PerWorldPlugins instance;

    public static PerWorldPlugins getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        GroupsYML.register();

        getServer().getPluginManager().registerEvents(new Listeners(), this);

        CommandManager.getCommandMap().register("perworldplugins", new PrimaryCommand());

        if (getConfig().getBoolean("metrics")) new Metrics(this, 15794);

        if (getConfig().getBoolean("updateChecker")) UpdateChecker.check();

        LOGGER.info(Component.text("<---------------------------------------->", NamedTextColor.DARK_GREEN));
        LOGGER.info(Component.text("PerWorldPlugins " + getPluginMeta().getVersion() + " has been enabled."));
        LOGGER.info(Component.text("<---------------------------------------->", NamedTextColor.DARK_GREEN));

        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            PerWorldUtils.generateConfig();
            LOGGER.info(Component.text("Config generated correctly.", NamedTextColor.GREEN));
            ListenerManager.convert();
            LOGGER.info(Component.text("Converted all Listeners correctly.", NamedTextColor.GREEN));
        });
    }

    @Override
    public void onDisable() {
        this.reloadConfig();
        this.saveConfig();
    }
}

