package modchu.lib.forge.mc210_221;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.BiMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityEntry;

public abstract class Modchu_ASMaster extends modchu.lib.forge.mc190_221.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return ((NonNullList<ItemStack>) ((EntityLiving) entityLiving).getArmorInventoryList()).get(i);
	}
	// 210~分離
	@Override
	public Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return ((World) entityWorld(worldOrInt)).getBiome((BlockPos) blockPosOrInt);
	}

	@Override
	public Object entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorInventory;
	}

	@Override
	public Object entityPlayerMainInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).mainInventory;
	}

	@Override
	public Object itemStackCopyItemStack(Object itemstack) {
		return itemstack == null ? null : ((ItemStack) itemstack).copy();
	}

	@Override
	public void setEntityPlayerArmorInventory(Object entityplayerORInventory, Object armorInventory) {
		ItemStack[] itemStacks = ((ItemStack[]) armorInventory);
		if (entityplayerORInventory instanceof InventoryPlayer) {
			for (int i = 0; i < ((InventoryPlayer) entityplayerORInventory).armorInventory.size(); i++) {
				if (i > itemStacks.length) break;
				((InventoryPlayer) entityplayerORInventory).armorInventory.set(i, itemStacks[i]);
			}
		} else {
			for (int i = 0; i < ((EntityPlayer) entityplayerORInventory).inventory.armorInventory.size(); i++) {
				if (i > itemStacks.length) break;
				((EntityPlayer) entityplayerORInventory).inventory.armorInventory.set(i, itemStacks[i]);
			}
		}
	}

	@Override
	public void setEntityPlayerMainInventory(Object entityplayerORInventory, Object mainInventory) {
		ItemStack[] itemStacks = ((ItemStack[]) mainInventory);
		if (entityplayerORInventory instanceof InventoryPlayer) {
			for (int i = 0; i < ((InventoryPlayer) entityplayerORInventory).mainInventory.size(); i++) {
				if (i > itemStacks.length) break;
				((InventoryPlayer) entityplayerORInventory).mainInventory.set(i, itemStacks[i]);
			}
		} else {
			for (int i = 0; i < ((EntityPlayer) entityplayerORInventory).inventory.mainInventory.size(); i++) {
				if (i > itemStacks.length) break;
				((EntityPlayer) entityplayerORInventory).inventory.mainInventory.set(i, itemStacks[i]);
			}
		}
	}

	@Override
	public void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer, Object enumHand) {
		((Item) item).onItemRightClick((World) world, (EntityPlayer) entityplayer, (EnumHand) enumHand);
	}

	@Override
	public boolean entityZombieIsVillager(Object entityZombie) {
		return entityZombie instanceof EntityZombieVillager;
	}

	@Override
	public int getVacancyGlobalEntityID() {
		int ID = -1;
		boolean oldFlag = false;
		Class GameData = Modchu_Reflect.loadClass("net.minecraftforge.registries.GameData");
		Object entityRegistry = null;
		if (GameData != null); else {
			GameData = Modchu_Reflect.loadClass("net.minecraftforge.fml.common.registry.GameData");
			oldFlag = true;
		}
		entityRegistry = Modchu_Reflect.invokeMethod(GameData, "getEntityRegistry");

		if (entityRegistry != null) {
			BiMap ids = null;
			if (!oldFlag) ids = (BiMap) Modchu_Reflect.getFieldObject("ForgeRegistry", "ids", entityRegistry);
			for(int i = 64; i < 256; i++) {
				//Modchu_Debug.mDebug("getVacancyGlobalEntityID i="+i+" EntityList.field_191308_b.getObjectById(i)="+EntityList.field_191308_b.getObjectById(i));
				Object o = oldFlag ? Modchu_Reflect.invokeMethod("net.minecraftforge.fml.common.registry.FMLControlledNamespacedRegistry", "getObjectById", new Class[]{ int.class }, entityRegistry, new Object[]{ i }) :
					ids.get(i);
				if (o != null); else {
					ID = i;
					//Modchu_Debug.mDebug("getVacancyGlobalEntityID ID="+ID);
					break;
				}
			}
		} else {
			Modchu_Debug.lDebug("getVacancyGlobalEntityID EntityList.field_191308_b == null !!");
		}
		return ID;
	}

	@Override
	public Map entityListIDtoClassMapping() {
		return null;
	}

	@Override
	public Map entityListStringToClassMapping() {
		return null;
	}

	@Override
	public Map entityListClassToStringMapping() {
		return null;
	}
	// 202~210共通コピペ　↓
	@Override
	public Object getBlock(String s) {
		if (s != null); else return null;
		RegistryNamespacedDefaultedByKey blockRegistry = Block.REGISTRY;
		if (blockRegistry != null); else return null;
		Object block = blockRegistry.getObject(Modchu_Main.newResourceLocation(s));
		//Modchu_Debug.mDebug("getBlock s="+s+" block="+block);
		if (block != null) return block;
		block = blockRegistry.getObject(Modchu_Main.newResourceLocation(s.toUpperCase()));
		return block;
	}

	@Override
	public Object potionAbsorption() {
		return Potion.REGISTRY.getObjectById(22);
	}

	@Override
	public Object potionHealthBoost() {
		return Potion.REGISTRY.getObjectById(21);
	}

	@Override
	public Object potionSaturation() {
		return Potion.REGISTRY.getObjectById(23);
	}

	@Override
	public int biomeGetBiomeGrassColor(Object biome, int x, int y, int z) {
		return ((Biome) biome).getGrassColorAtPos(new BlockPos(x, y, z));
	}

	@Override
	public Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return ((EntityPlayerMP) entityClientPlayerMP).connection;
	}

	@Override
	public Object getItem(String s) {
		if (s != null); else return null;
		Object o = Item.REGISTRY.getObject((ResourceLocation) Modchu_Main.newResourceLocation(s));
		if (o != null) return o;
		o = Item.REGISTRY.getObject((ResourceLocation) Modchu_Main.newResourceLocation(s.toUpperCase()));
		return o;
	}

	@Override
	public Object biomeBeach() {
		return Biomes.BEACH;
	}

	@Override
	public Object biomeDesert() {
		return Biomes.DESERT;
	}

	@Override
	public Object biomeDesertHills() {
		return Biomes.DESERT_HILLS;
	}

	@Override
	public Object biomeExtremeHills() {
		return Biomes.EXTREME_HILLS;
	}

	@Override
	public Object biomeExtremeHillsEdge() {
		return Biomes.EXTREME_HILLS_EDGE;
	}

	@Override
	public Object biomeForest() {
		return Biomes.FOREST;
	}

	@Override
	public Object biomeForestHills() {
		return Biomes.FOREST_HILLS;
	}

	@Override
	public Object biomeFrozenOcean() {
		return Biomes.FROZEN_OCEAN;
	}

	@Override
	public Object biomeFrozenRiver() {
		return Biomes.FROZEN_RIVER;
	}

	@Override
	public Object biomeHell() {
		return Biomes.HELL;
	}

	@Override
	public Object biomeIceMountains() {
		return Biomes.ICE_MOUNTAINS;
	}

	@Override
	public Object biomeIcePlains() {
		return Biomes.ICE_PLAINS;
	}

	@Override
	public Object biomeJungle() {
		return Biomes.JUNGLE;
	}

	@Override
	public Object biomeJungleHills() {
		return Biomes.JUNGLE_HILLS;
	}

	@Override
	public Object biomeMushroomIsland() {
		return Biomes.MUSHROOM_ISLAND;
	}

	@Override
	public Object biomeMushroomIslandShore() {
		return Biomes.MUSHROOM_ISLAND_SHORE;
	}

	@Override
	public Object biomeOcean() {
		return Biomes.OCEAN;
	}

	@Override
	public Object biomePlains() {
		return Biomes.PLAINS;
	}

	@Override
	public Object biomeRiver() {
		return Biomes.RIVER;
	}

	@Override
	public Object biomeSky() {
		return Biomes.SKY;
	}

	@Override
	public Object biomeSwampland() {
		return Biomes.SWAMPLAND;
	}

	@Override
	public Object biomeTaiga() {
		return Biomes.TAIGA;
	}

	@Override
	public Object biomeTaigaHills() {
		return Biomes.TAIGA_HILLS;
	}

	@Override
	public Object creativeTabsTabAllSearch() {
		return CreativeTabs.SEARCH;
	}

	@Override
	public Object creativeTabsTabBlock() {
		return CreativeTabs.BUILDING_BLOCKS;
	}

	@Override
	public Object creativeTabsTabBrewing() {
		return CreativeTabs.BREWING;
	}

	@Override
	public Object creativeTabsTabCombat() {
		return CreativeTabs.COMBAT;
	}

	@Override
	public Object creativeTabsTabDecorations() {
		return CreativeTabs.DECORATIONS;
	}

	@Override
	public Object creativeTabsTabFood() {
		return CreativeTabs.FOOD;
	}

	@Override
	public Object creativeTabsTabInventory() {
		return CreativeTabs.INVENTORY;
	}

	@Override
	public Object creativeTabsTabMaterials() {
		return CreativeTabs.MATERIALS;
	}

	@Override
	public Object creativeTabsTabMisc() {
		return CreativeTabs.MISC;
	}

	@Override
	public Object creativeTabsTabRedstone() {
		return CreativeTabs.REDSTONE;
	}

	@Override
	public Object creativeTabsTabTools() {
		return CreativeTabs.TOOLS;
	}

	@Override
	public Object creativeTabsTabTransport() {
		return CreativeTabs.TRANSPORTATION;
	}

	@Override
	public boolean isMuiti() {
		if (Modchu_Main.isServer) return true;
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().getConnection() != null
				&& !Minecraft.getMinecraft().isSingleplayer() : true;
	}

	@Override
	public Object potionBlindness() {
		return Potion.REGISTRY.getObjectById(15);
	}

	@Override
	public Object potionConfusion() {
		return Potion.REGISTRY.getObjectById(9);
	}

	@Override
	public Object potionDamageBoost() {
		return Potion.REGISTRY.getObjectById(5);
	}

	@Override
	public Object potionDigSlowdown() {
		return Potion.REGISTRY.getObjectById(4);
	}

	@Override
	public Object potionDigSpeed() {
		return Potion.REGISTRY.getObjectById(3);
	}

	@Override
	public Object potionFireResistance() {
		return Potion.REGISTRY.getObjectById(12);
	}

	@Override
	public Object potionHarm() {
		return Potion.REGISTRY.getObjectById(7);
	}

	@Override
	public Object potionHeal() {
		return Potion.REGISTRY.getObjectById(6);
	}

	@Override
	public Object potionHunger() {
		return Potion.REGISTRY.getObjectById(17);
	}

	@Override
	public Object potionInvisibility() {
		return Potion.REGISTRY.getObjectById(14);
	}

	@Override
	public Object potionJump() {
		return Potion.REGISTRY.getObjectById(8);
	}

	@Override
	public Object potionMoveSlowdown() {
		return Potion.REGISTRY.getObjectById(2);
	}

	@Override
	public Object potionMoveSpeed() {
		return Potion.REGISTRY.getObjectById(1);
	}

	@Override
	public Object potionNightVision() {
		return Potion.REGISTRY.getObjectById(16);
	}

	@Override
	public Object potionPoison() {
		return Potion.REGISTRY.getObjectById(19);
	}

	@Override
	public Object potionRegeneration() {
		return Potion.REGISTRY.getObjectById(10);
	}

	@Override
	public Object potionResistance() {
		return Potion.REGISTRY.getObjectById(11);
	}

	@Override
	public Object potionWaterBreathing() {
		return Potion.REGISTRY.getObjectById(13);
	}

	@Override
	public Object potionWeakness() {
		return Potion.REGISTRY.getObjectById(18);
	}

	@Override
	public Object potionWither() {
		return Potion.REGISTRY.getObjectById(20);
	}

	@Override
	public Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return ((EntityPlayerMP) entityplayerMP).connection;
	}

	@Override
	public float mathHelperWrapAngleTo180_float(float f) {
		return MathHelper.wrapDegrees(f);
	}

	@Override
	public boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		if (potionOrPotionId instanceof Potion) return ((EntityLivingBase) entityLivingBase).isPotionActive((Potion) potionOrPotionId);
		return ((EntityLivingBase) entityLivingBase).isPotionActive(Potion.REGISTRY.getObjectById((Integer) potionOrPotionId));
	}

	@Override
	public Object guiOptionsBackground() {
		return Gui.OPTIONS_BACKGROUND;
	}

	@Override
	public boolean isMac() {
		return Minecraft.IS_RUNNING_ON_MAC;
	}

	@Override
	public Object textureMapLocationBlocksTexture() {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}

	@Override
	public void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netHandlerPlayServer) {
		((EntityPlayerMP) entityplayerMP).connection = (NetHandlerPlayServer) netHandlerPlayServer;
	}

	@Override
	public Object biomeBirchForest() {
		return Biomes.BIRCH_FOREST;
	}

	@Override
	public Object biomeBirchForestHills() {
		return Biomes.BIRCH_FOREST_HILLS;
	}

	@Override
	public Object biomeColdTaiga() {
		return Biomes.COLD_TAIGA;
	}

	@Override
	public Object biomeColdTaigaHills() {
		return Biomes.COLD_TAIGA_HILLS;
	}

	@Override
	public Object biomeDeepOcean() {
		return Biomes.DEEP_OCEAN;
	}

	@Override
	public Object biomeExtremeHillsPlus() {
		return Biomes.EXTREME_HILLS;
	}

	@Override
	public Object biomeJungleEdge() {
		return Biomes.JUNGLE_EDGE;
	}

	@Override
	public Object biomeMegaTaiga() {
		return Biomes.REDWOOD_TAIGA;
	}

	@Override
	public Object biomeMegaTaigaHills() {
		return Biomes.REDWOOD_TAIGA_HILLS;
	}

	@Override
	public Object biomeMesa() {
		return Biomes.MESA;
	}

	@Override
	public Object biomeMesaPlateau() {
		return Biomes.MESA_CLEAR_ROCK;
	}

	@Override
	public Object biomeMesaPlateau_F() {
		return Biomes.MESA_ROCK;
	}

	@Override
	public Object biomeStoneBeach() {
		return Biomes.STONE_BEACH;
	}

	@Override
	public Object biomeStoneColdBeach() {
		return Biomes.COLD_BEACH;
	}

	@Override
	public Object biomeRoofedForest() {
		return Biomes.ROOFED_FOREST;
	}

	@Override
	public Object biomeSavanna() {
		return Biomes.SAVANNA;
	}

	@Override
	public Object biomeSavannaPlateau() {
		return Biomes.SAVANNA_PLATEAU;
	}
	// 200~分離
	@Override
	public Enum worldSettingsGameTypeADVENTURE() {
		return GameType.ADVENTURE;
	}

	@Override
	public Enum worldSettingsGameTypeCREATIVE() {
		return GameType.CREATIVE;
	}

	@Override
	public Enum worldSettingsGameTypeNOT_SET() {
		return GameType.NOT_SET;
	}

	@Override
	public Enum worldSettingsGameTypeSURVIVAL() {
		return GameType.SURVIVAL;
	}
	// 202~210共通コピペ　↑

}