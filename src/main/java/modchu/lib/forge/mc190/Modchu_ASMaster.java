package modchu.lib.forge.mc190;

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
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class Modchu_ASMaster extends modchu.lib.forge.mc190_194.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public Object getBlock(String s) {
		if (s != null); else return null;
		RegistryNamespacedDefaultedByKey blockRegistry = Block.blockRegistry;
		if (blockRegistry != null); else return null;
		Object block = blockRegistry.getObject(Modchu_Main.newResourceLocation(s));
		//Modchu_Debug.mDebug("getBlock s="+s+" block="+block);
		if (block != null) return block;
		block = blockRegistry.getObject(Modchu_Main.newResourceLocation(s.toLowerCase()));
		return block;
	}

	@Override
	public int getVacancyGlobalEntityID() {
		Map map = EntityList.idToClassMapping;
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
		return Potion.potionRegistry.getObjectById(22);
	}

	@Override
	public Object potionHealthBoost() {
		return Potion.potionRegistry.getObjectById(21);
	}

	@Override
	public Object potionSaturation() {
		return Potion.potionRegistry.getObjectById(23);
	}

	@Override
	public int biomeGetBiomeGrassColor(Object biome, int x, int y, int z) {
		return ((BiomeGenBase) biome).getGrassColorAtPos(new BlockPos(x, y, z));
	}

	@Override
	public Map entityListIDtoClassMapping() {
		return EntityList.idToClassMapping;
	}

	@Override
	public Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return ((EntityPlayerMP) entityClientPlayerMP).playerNetServerHandler;
	}

	@Override
	public Object getItem(String s) {
		if (s != null); else return null;
		Object o = Item.itemRegistry.getObject((ResourceLocation) Modchu_Main.newResourceLocation(s));
		if (o != null) return o;
		o = Item.itemRegistry.getObject((ResourceLocation) Modchu_Main.newResourceLocation(s.toLowerCase()));
		return o;
	}

	@Override
	public Map entityListStringToClassMapping() {
		return EntityList.stringToClassMapping;
	}

	@Override
	public Map entityListClassToStringMapping() {
		return EntityList.classToStringMapping;
	}

	@Override
	public Object biomeBeach() {
		return Biomes.beach;
	}

	@Override
	public Object biomeDesert() {
		return Biomes.desert;
	}

	@Override
	public Object biomeDesertHills() {
		return Biomes.desertHills;
	}

	@Override
	public Object biomeExtremeHills() {
		return Biomes.extremeHills;
	}

	@Override
	public Object biomeExtremeHillsEdge() {
		return Biomes.extremeHillsEdge;
	}

	@Override
	public Object biomeForest() {
		return Biomes.forest;
	}

	@Override
	public Object biomeForestHills() {
		return Biomes.forestHills;
	}

	@Override
	public Object biomeFrozenOcean() {
		return Biomes.frozenOcean;
	}

	@Override
	public Object biomeFrozenRiver() {
		return Biomes.frozenRiver;
	}

	@Override
	public Object biomeHell() {
		return Biomes.hell;
	}

	@Override
	public Object biomeIceMountains() {
		return Biomes.iceMountains;
	}

	@Override
	public Object biomeIcePlains() {
		return Biomes.icePlains;
	}

	@Override
	public Object biomeJungle() {
		return Biomes.jungle;
	}

	@Override
	public Object biomeJungleHills() {
		return Biomes.jungleHills;
	}

	@Override
	public Object biomeMushroomIsland() {
		return Biomes.mushroomIsland;
	}

	@Override
	public Object biomeMushroomIslandShore() {
		return Biomes.mushroomIslandShore;
	}

	@Override
	public Object biomeOcean() {
		return Biomes.ocean;
	}

	@Override
	public Object biomePlains() {
		return Biomes.plains;
	}

	@Override
	public Object biomeRiver() {
		return Biomes.river;
	}

	@Override
	public Object biomeSky() {
		return Biomes.sky;
	}

	@Override
	public Object biomeSwampland() {
		return Biomes.swampland;
	}

	@Override
	public Object biomeTaiga() {
		return Biomes.taiga;
	}

	@Override
	public Object biomeTaigaHills() {
		return Biomes.taigaHills;
	}

	@Override
	public Object creativeTabsTabAllSearch() {
		return CreativeTabs.tabAllSearch;
	}

	@Override
	public Object creativeTabsTabBlock() {
		return CreativeTabs.tabBlock;
	}

	@Override
	public Object creativeTabsTabBrewing() {
		return CreativeTabs.tabBrewing;
	}

	@Override
	public Object creativeTabsTabCombat() {
		return CreativeTabs.tabCombat;
	}

	@Override
	public Object creativeTabsTabDecorations() {
		return CreativeTabs.tabDecorations;
	}

	@Override
	public Object creativeTabsTabFood() {
		return CreativeTabs.tabFood;
	}

	@Override
	public Object creativeTabsTabInventory() {
		return CreativeTabs.tabInventory;
	}

	@Override
	public Object creativeTabsTabMaterials() {
		return CreativeTabs.tabMaterials;
	}

	@Override
	public Object creativeTabsTabMisc() {
		return CreativeTabs.tabMisc;
	}

	@Override
	public Object creativeTabsTabRedstone() {
		return CreativeTabs.tabRedstone;
	}

	@Override
	public Object creativeTabsTabTools() {
		return CreativeTabs.tabTools;
	}

	@Override
	public Object creativeTabsTabTransport() {
		return CreativeTabs.tabTransport;
	}

	@Override
	public boolean isMuiti() {
		if (Modchu_Main.isServer) return true;
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().getNetHandler() != null
				&& !Minecraft.getMinecraft().isSingleplayer() : true;
	}

	@Override
	public Object potionBlindness() {
		return Potion.potionRegistry.getObjectById(15);
	}

	@Override
	public Object potionConfusion() {
		return Potion.potionRegistry.getObjectById(9);
	}

	@Override
	public Object potionDamageBoost() {
		return Potion.potionRegistry.getObjectById(5);
	}

	@Override
	public Object potionDigSlowdown() {
		return Potion.potionRegistry.getObjectById(4);
	}

	@Override
	public Object potionDigSpeed() {
		return Potion.potionRegistry.getObjectById(3);
	}

	@Override
	public Object potionFireResistance() {
		return Potion.potionRegistry.getObjectById(12);
	}

	@Override
	public Object potionHarm() {
		return Potion.potionRegistry.getObjectById(7);
	}

	@Override
	public Object potionHeal() {
		return Potion.potionRegistry.getObjectById(6);
	}

	@Override
	public Object potionHunger() {
		return Potion.potionRegistry.getObjectById(17);
	}

	@Override
	public Object potionInvisibility() {
		return Potion.potionRegistry.getObjectById(14);
	}

	@Override
	public Object potionJump() {
		return Potion.potionRegistry.getObjectById(8);
	}

	@Override
	public Object potionMoveSlowdown() {
		return Potion.potionRegistry.getObjectById(2);
	}

	@Override
	public Object potionMoveSpeed() {
		return Potion.potionRegistry.getObjectById(1);
	}

	@Override
	public Object potionNightVision() {
		return Potion.potionRegistry.getObjectById(16);
	}

	@Override
	public Object potionPoison() {
		return Potion.potionRegistry.getObjectById(19);
	}

	@Override
	public Object potionRegeneration() {
		return Potion.potionRegistry.getObjectById(10);
	}

	@Override
	public Object potionResistance() {
		return Potion.potionRegistry.getObjectById(11);
	}

	@Override
	public Object potionWaterBreathing() {
		return Potion.potionRegistry.getObjectById(13);
	}

	@Override
	public Object potionWeakness() {
		return Potion.potionRegistry.getObjectById(18);
	}

	@Override
	public Object potionWither() {
		return Potion.potionRegistry.getObjectById(20);
	}

	@Override
	public Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return ((EntityPlayerMP) entityplayerMP).playerNetServerHandler;
	}

	@Override
	public float mathHelperWrapAngleTo180_float(float f) {
		return MathHelper.wrapAngleTo180_float(f);
	}

	@Override
	public boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		if (potionOrPotionId instanceof Potion) return ((EntityLivingBase) entityLivingBase).isPotionActive((Potion) potionOrPotionId);
		return ((EntityLivingBase) entityLivingBase).isPotionActive(Potion.potionRegistry.getObjectById((Integer) potionOrPotionId));
	}

	@Override
	public Object guiOptionsBackground() {
		return Gui.optionsBackground;
	}

	@Override
	public boolean isMac() {
		return Minecraft.isRunningOnMac;
	}

	@Override
	public Object textureMapLocationBlocksTexture() {
		return TextureMap.locationBlocksTexture;
	}

	@Override
	public void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netHandlerPlayServer) {
		((EntityPlayerMP) entityplayerMP).playerNetServerHandler = (NetHandlerPlayServer) netHandlerPlayServer;
	}

	@Override
	public Object biomeBirchForest() {
		return Biomes.birchForest;
	}

	@Override
	public Object biomeBirchForestHills() {
		return Biomes.birchForestHills;
	}

	@Override
	public Object biomeColdTaiga() {
		return Biomes.coldTaiga;
	}

	@Override
	public Object biomeColdTaigaHills() {
		return Biomes.coldTaigaHills;
	}

	@Override
	public Object biomeDeepOcean() {
		return Biomes.deepOcean;
	}

	@Override
	public Object biomeExtremeHillsPlus() {
		return Biomes.extremeHillsPlus;
	}

	@Override
	public Object biomeJungleEdge() {
		return Biomes.jungleEdge;
	}

	@Override
	public Object biomeMegaTaiga() {
		return Biomes.megaTaiga;
	}

	@Override
	public Object biomeMegaTaigaHills() {
		return Biomes.megaTaigaHills;
	}

	@Override
	public Object biomeMesa() {
		return Biomes.mesa;
	}

	@Override
	public Object biomeMesaPlateau() {
		return Biomes.mesaPlateau;
	}

	@Override
	public Object biomeMesaPlateau_F() {
		return Biomes.mesaPlateau_F;
	}

	@Override
	public Object biomeStoneBeach() {
		return Biomes.stoneBeach;
	}

	@Override
	public Object biomeStoneColdBeach() {
		return Biomes.coldBeach;
	}

	@Override
	public Object biomeRoofedForest() {
		return Biomes.roofedForest;
	}

	@Override
	public Object biomeSavanna() {
		return Biomes.savanna;
	}

	@Override
	public Object biomeSavannaPlateau() {
		return Biomes.savannaPlateau;
	}
	// ビルド時問題で分離
	@Override
	public Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return ((World) entityWorldObj(worldOrInt)).getBiomeGenForCoords((BlockPos) blockPosOrInt);
	}

}