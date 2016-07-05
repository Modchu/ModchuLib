package modchu.lib.forge.mc194;

import java.util.HashMap;
import java.util.Map;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.Biome;

public class Modchu_ASMaster extends modchu.lib.forge.mc190_194.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

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
	public int getVacancyGlobalEntityID() {
		Map map = EntityList.ID_TO_CLASS;
		int ID = -1;
		if (map != null) {
			for(int i = 64; i < 3000; i++) {
				//Modchu_Debug.mDebug("getVacancyGlobalEntityID i"+i+" !map.containsKey(i) = "+(!map.containsKey(i)));
				if (!map.containsKey(i)) {
					ID = i;
					//Modchu_Debug.mDebug("getVacancyGlobalEntityID !map.containsKey ID="+ID);
					break;
				}
			}
		} else {
			Modchu_Debug.lDebug("getVacancyGlobalEntityID IDtoClassMapping map == null !!");
		}
		return ID;
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
	public Map entityListIDtoClassMapping() {
		return EntityList.ID_TO_CLASS;
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
	public Map entityListStringToClassMapping() {
		return EntityList.NAME_TO_CLASS;
	}

	@Override
	public Map entityListClassToStringMapping() {
		return EntityList.CLASS_TO_NAME;
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

}