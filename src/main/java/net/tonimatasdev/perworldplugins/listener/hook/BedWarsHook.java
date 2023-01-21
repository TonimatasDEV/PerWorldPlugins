package net.tonimatasdev.perworldplugins.listener.hook;

import org.bukkit.event.Listener;

public class BedWarsHook implements Listener {/*
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onApplyPropertyToItem(BedwarsApplyPropertyToItem event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onBedDestroyedMessageSend(BedwarsBedDestroyedMessageSendEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getDestroyer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGameChangedStatus(BedwarsGameChangedStatusEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGameEnd(BedwarsGameEndEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGameEnding(BedwarsGameEndingEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGameStarted(BedwarsGameStartedEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGameStart(BedwarsGameStartEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGameTick(BedwarsGameTickEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onItemBought(BedwarsItemBoughtEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getCustomer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpenShop(BedwarsOpenShopEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpenTeamSelection(BedwarsOpenTeamSelectionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerBreakBlock(BedwarsPlayerBreakBlock event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerBuild(BedwarsPlayerBuildBlock event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerDeathMessageSend(BedwarsPlayerDeathMessageSendEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getVictim().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerJoined(BedwarsPlayerJoinedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerJoin(BedwarsPlayerJoinEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerKilled(BedwarsPlayerKilledEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerLastLeave(BedWarsPlayerLastLeaveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerLeave(BedwarsPlayerLeaveEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPostRebuilding(BedwarsPostRebuildingEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPostSpawnEffect(BedwarsPostSpawnEffectEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreRebuilding(BedwarsPreRebuildingEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreSpawnEffect(BedwarsPreSpawnEffectEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onResourceSpawn(BedwarsResourceSpawnEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getLocation().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onSavePlayerStatistic(BedwarsSavePlayerStatisticEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onServerRestart(BedWarsServerRestartEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTargetBlockDestroyed(BedwarsTargetBlockDestroyedEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onTeamChestOpen(BedwarsTeamChestOpenEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUpgradeBought(BedwarsUpgradeBoughtEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getCustomer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUpgradeImproved(BedwarsUpgradeImprovedEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUpgradeRegistered(BedwarsUpgradeRegisteredEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onUpgradeUnregistered(BedwarsUpgradeUnregisteredEvent event) {
        ListenerUtils.noWorldEvents(event);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onCloseInventory(CloseInventoryEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onGenerateItem(GenerateItemEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onOpenInventory(OpenInventoryEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPostAction(PostActionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPreAction(PreActionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onShopTransaction(ShopTransactionEvent event) {
        ListenerUtils.perWorldPlugins(event, event.getPlayer().getWorld());
    }*/
}
