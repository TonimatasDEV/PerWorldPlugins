package net.tonimatasdev.perworldplugins.util;

import org.bukkit.event.HandlerList;
import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.*;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.*;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class HandlerListUtil {
    public static ArrayList<HandlerList> minecraftHandlerLists = new ArrayList<>();

    public static void register() {

        // Block HandlerLists
        minecraftHandlerLists.add(BlockBreakEvent.getHandlerList());
        minecraftHandlerLists.add(BlockBurnEvent.getHandlerList());
        minecraftHandlerLists.add(BlockCanBuildEvent.getHandlerList());
        minecraftHandlerLists.add(BlockDamageEvent.getHandlerList());
        minecraftHandlerLists.add(BlockDispenseEvent.getHandlerList());
        minecraftHandlerLists.add(BlockExpEvent.getHandlerList());
        minecraftHandlerLists.add(BlockExplodeEvent.getHandlerList());
        minecraftHandlerLists.add(BlockFadeEvent.getHandlerList());
        minecraftHandlerLists.add(BlockFormEvent.getHandlerList());
        minecraftHandlerLists.add(BlockFromToEvent.getHandlerList());
        minecraftHandlerLists.add(BlockGrowEvent.getHandlerList());
        minecraftHandlerLists.add(BlockIgniteEvent.getHandlerList());
        minecraftHandlerLists.add(BlockMultiPlaceEvent.getHandlerList());
        minecraftHandlerLists.add(BlockPhysicsEvent.getHandlerList());
        minecraftHandlerLists.add(BlockPistonExtendEvent.getHandlerList());
        minecraftHandlerLists.add(BlockPistonRetractEvent.getHandlerList());
        minecraftHandlerLists.add(BlockPlaceEvent.getHandlerList());
        minecraftHandlerLists.add(BlockRedstoneEvent.getHandlerList());
        minecraftHandlerLists.add(BlockSpreadEvent.getHandlerList());
        minecraftHandlerLists.add(EntityBlockFormEvent.getHandlerList());
        minecraftHandlerLists.add(LeavesDecayEvent.getHandlerList());
        minecraftHandlerLists.add(NotePlayEvent.getHandlerList());
        minecraftHandlerLists.add(SignChangeEvent.getHandlerList());

        // Enchants HandlerLists
        minecraftHandlerLists.add(EnchantItemEvent.getHandlerList());
        minecraftHandlerLists.add(PrepareItemEnchantEvent.getHandlerList());

        // Entity HandlerLists
        minecraftHandlerLists.add(CreatureSpawnEvent.getHandlerList());
        minecraftHandlerLists.add(CreeperPowerEvent.getHandlerList());
        minecraftHandlerLists.add(EntityBreakDoorEvent.getHandlerList());
        minecraftHandlerLists.add(EntityChangeBlockEvent.getHandlerList());
        minecraftHandlerLists.add(EntityCombustByBlockEvent.getHandlerList());
        minecraftHandlerLists.add(EntityCombustByEntityEvent.getHandlerList());
        minecraftHandlerLists.add(EntityCombustEvent.getHandlerList());
        minecraftHandlerLists.add(EntityCreatePortalEvent.getHandlerList());
        minecraftHandlerLists.add(EntityDamageByBlockEvent.getHandlerList());
        minecraftHandlerLists.add(EntityDamageByEntityEvent.getHandlerList());
        minecraftHandlerLists.add(EntityDamageEvent.getHandlerList());
        minecraftHandlerLists.add(EntityDeathEvent.getHandlerList());
        minecraftHandlerLists.add(EntityExplodeEvent.getHandlerList());
        minecraftHandlerLists.add(EntityInteractEvent.getHandlerList());
        minecraftHandlerLists.add(EntityPortalEnterEvent.getHandlerList());
        minecraftHandlerLists.add(EntityPortalEvent.getHandlerList());
        minecraftHandlerLists.add(EntityPortalExitEvent.getHandlerList());
        minecraftHandlerLists.add(EntityRegainHealthEvent.getHandlerList());
        minecraftHandlerLists.add(EntityShootBowEvent.getHandlerList());
        minecraftHandlerLists.add(EntitySpawnEvent.getHandlerList());
        minecraftHandlerLists.add(EntityTameEvent.getHandlerList());
        minecraftHandlerLists.add(EntityTargetEvent.getHandlerList());
        minecraftHandlerLists.add(EntityTargetLivingEntityEvent.getHandlerList());
        minecraftHandlerLists.add(EntityTeleportEvent.getHandlerList());
        minecraftHandlerLists.add(EntityUnleashEvent.getHandlerList());
        minecraftHandlerLists.add(ExpBottleEvent.getHandlerList());
        minecraftHandlerLists.add(ExplosionPrimeEvent.getHandlerList());
        minecraftHandlerLists.add(FireworkExplodeEvent.getHandlerList());
        minecraftHandlerLists.add(FoodLevelChangeEvent.getHandlerList());
        minecraftHandlerLists.add(HorseJumpEvent.getHandlerList());
        minecraftHandlerLists.add(ItemDespawnEvent.getHandlerList());
        minecraftHandlerLists.add(ItemMergeEvent.getHandlerList());
        minecraftHandlerLists.add(ItemSpawnEvent.getHandlerList());
        minecraftHandlerLists.add(PigZapEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerDeathEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerLeashEntityEvent.getHandlerList());
        minecraftHandlerLists.add(PotionSplashEvent.getHandlerList());
        minecraftHandlerLists.add(ProjectileHitEvent.getHandlerList());
        minecraftHandlerLists.add(ProjectileLaunchEvent.getHandlerList());
        minecraftHandlerLists.add(SheepDyeWoolEvent.getHandlerList());
        minecraftHandlerLists.add(SheepRegrowWoolEvent.getHandlerList());
        minecraftHandlerLists.add(SlimeSplitEvent.getHandlerList());
        minecraftHandlerLists.add(SpawnerSpawnEvent.getHandlerList());

        // Hanging HandlerLists
        minecraftHandlerLists.add(HangingBreakByEntityEvent.getHandlerList());
        minecraftHandlerLists.add(HangingBreakEvent.getHandlerList());
        minecraftHandlerLists.add(HangingPlaceEvent.getHandlerList());

        // Inventory HandlerLists
        minecraftHandlerLists.add(BrewEvent.getHandlerList());
        minecraftHandlerLists.add(CraftItemEvent.getHandlerList());
        minecraftHandlerLists.add(FurnaceBurnEvent.getHandlerList());
        minecraftHandlerLists.add(FurnaceExtractEvent.getHandlerList());
        minecraftHandlerLists.add(FurnaceSmeltEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryClickEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryCloseEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryCreativeEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryDragEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryInteractEvent.getHandlerList());
        //minecraftHandlerLists.add(InventoryMoveItemEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryOpenEvent.getHandlerList());
        minecraftHandlerLists.add(InventoryPickupItemEvent.getHandlerList());
        minecraftHandlerLists.add(PrepareItemCraftEvent.getHandlerList());

        // Player HandlerLists
        minecraftHandlerLists.add(AsyncPlayerChatEvent.getHandlerList());
        //minecraftHandlerLists.add(AsyncPlayerPreLoginEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerAnimationEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerArmorStandManipulateEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerBedEnterEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerBedLeaveEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerBucketEmptyEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerBucketFillEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerChangedWorldEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerChannelEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerChatEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerChatTabCompleteEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerCommandPreprocessEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerDropItemEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerEditBookEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerEggThrowEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerExpChangeEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerFishEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerGameModeChangeEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerInteractAtEntityEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerInteractEntityEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerInteractEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerItemBreakEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerItemConsumeEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerItemDamageEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerItemHeldEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerJoinEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerKickEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerLevelChangeEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerLoginEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerMoveEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerPickupItemEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerPortalEvent.getHandlerList());
        //minecraftHandlerLists.add(PlayerPreLoginEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerQuitEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerRegisterChannelEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerResourcePackStatusEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerRespawnEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerShearEntityEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerStatisticIncrementEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerTeleportEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerToggleFlightEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerToggleSneakEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerToggleSprintEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerUnleashEntityEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerUnregisterChannelEvent.getHandlerList());
        minecraftHandlerLists.add(PlayerVelocityEvent.getHandlerList());

        // Vehicle HandlerLists
        minecraftHandlerLists.add(VehicleBlockCollisionEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleCreateEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleDamageEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleDestroyEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleEnterEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleEntityCollisionEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleExitEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleMoveEvent.getHandlerList());
        minecraftHandlerLists.add(VehicleUpdateEvent.getHandlerList());

        // Weather HandlerLists
        minecraftHandlerLists.add(LightningStrikeEvent.getHandlerList());
        minecraftHandlerLists.add(ThunderChangeEvent.getHandlerList());
        minecraftHandlerLists.add(WeatherChangeEvent.getHandlerList());

        // World HandlerLists
        minecraftHandlerLists.add(ChunkLoadEvent.getHandlerList());
        minecraftHandlerLists.add(ChunkPopulateEvent.getHandlerList());
        minecraftHandlerLists.add(ChunkUnloadEvent.getHandlerList());
        minecraftHandlerLists.add(PortalCreateEvent.getHandlerList());
        minecraftHandlerLists.add(SpawnChangeEvent.getHandlerList());
        minecraftHandlerLists.add(StructureGrowEvent.getHandlerList());
        minecraftHandlerLists.add(WorldInitEvent.getHandlerList());
        minecraftHandlerLists.add(WorldLoadEvent.getHandlerList());
        minecraftHandlerLists.add(WorldSaveEvent.getHandlerList());
        minecraftHandlerLists.add(WorldUnloadEvent.getHandlerList());
    }
}
