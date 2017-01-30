package modchu.lib.forge.mc172_189;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Multimap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_ASBasis;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.LoadingScreenRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelGhast;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.storage.WorldInfo;

public abstract class Modchu_ASMaster extends Modchu_ASBasis {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}
	//152~189
	// modLoader環境del↓
	@Override
	public void blockSetLightOpacity(Object block, int lightOpacity) {
		((Block) block).setLightOpacity(lightOpacity);
	}

	@Override
	public Object minecraftTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().renderEngine;
	}

	@Override
	public Map renderManagerEntityRenderMap() {
		return ((RenderManager) renderManagerInstance()).entityRenderMap;
	}

	@Override
	public Object renderEngine() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().renderEngine;
	}

	@Override
	public Object itemSetPotionEffect(Object item, String s) {
		return ((Item) item).setPotionEffect(s);
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
	public Object entityLivingTasks(Object entityLiving) {
		return ((EntityLiving) entityLiving).tasks;
	}

	// modLoader環境del↑
	@Override
	public Object axisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return ((AxisAlignedBB) axisAlignedBB).expand(d, d1, d2);
	}

	@Override
	public Object biomeBeach() {
		return BiomeGenBase.beach;
	}

	@Override
	public Object biomeDesert() {
		return BiomeGenBase.desert;
	}

	@Override
	public Object biomeDesertHills() {
		return BiomeGenBase.desertHills;
	}

	@Override
	public Object biomeExtremeHills() {
		return BiomeGenBase.extremeHills;
	}

	@Override
	public Object biomeExtremeHillsEdge() {
		return BiomeGenBase.extremeHillsEdge;
	}

	@Override
	public Object biomeForest() {
		return BiomeGenBase.forest;
	}

	@Override
	public Object biomeForestHills() {
		return BiomeGenBase.forestHills;
	}

	@Override
	public Object biomeFrozenOcean() {
		return BiomeGenBase.frozenOcean;
	}

	@Override
	public Object biomeFrozenRiver() {
		return BiomeGenBase.frozenRiver;
	}

	@Override
	public Object biomeHell() {
		return BiomeGenBase.hell;
	}

	@Override
	public Object biomeIceMountains() {
		return BiomeGenBase.iceMountains;
	}

	@Override
	public Object biomeIcePlains() {
		return BiomeGenBase.icePlains;
	}

	@Override
	public Object biomeJungle() {
		return BiomeGenBase.jungle;
	}

	@Override
	public Object biomeJungleHills() {
		return BiomeGenBase.jungleHills;
	}

	@Override
	public Object biomeMushroomIsland() {
		return BiomeGenBase.mushroomIsland;
	}

	@Override
	public Object biomeMushroomIslandShore() {
		return BiomeGenBase.mushroomIslandShore;
	}

	@Override
	public Object biomeOcean() {
		return BiomeGenBase.ocean;
	}

	@Override
	public Object biomePlains() {
		return BiomeGenBase.plains;
	}

	@Override
	public Object biomeRiver() {
		return BiomeGenBase.river;
	}

	@Override
	public Object biomeSky() {
		return BiomeGenBase.sky;
	}

	@Override
	public Object biomeSwampland() {
		return BiomeGenBase.swampland;
	}

	@Override
	public Object biomeTaiga() {
		return BiomeGenBase.taiga;
	}

	@Override
	public Object biomeTaigaHills() {
		return BiomeGenBase.taigaHills;
	}

	@Override
	public Object blockGetRenderType(Object block) {
		return ((Block) block).getRenderType();
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
	public Object damageSourceAnvil() {
		return DamageSource.anvil;
	}

	@Override
	public Object damageSourceCactus() {
		return DamageSource.cactus;
	}

	@Override
	public Object damageSourceDrown() {
		return DamageSource.drown;
	}

	@Override
	public Object damageSourceFall() {
		return DamageSource.fall;
	}

	@Override
	public Object damageSourceFallingBlock() {
		return DamageSource.fallingBlock;
	}

	@Override
	public Object damageSourceGeneric() {
		return DamageSource.generic;
	}

	@Override
	public Object damageSourceGetEntity(Object damageSource) {
		return ((DamageSource) damageSource).getEntity();
	}

	@Override
	public Object damageSourceInFire() {
		return DamageSource.inFire;
	}

	@Override
	public Object damageSourceInWall() {
		return DamageSource.inWall;
	}

	@Override
	public boolean damageSourceIsFireDamage(Object damageSource) {
		return ((DamageSource) damageSource).isFireDamage();
	}

	@Override
	public Object damageSourceLava() {
		return DamageSource.lava;
	}

	@Override
	public Object damageSourceMagic() {
		return DamageSource.magic;
	}

	@Override
	public Object damageSourceOnFire() {
		return DamageSource.onFire;
	}

	@Override
	public Object damageSourceOutOfWorld() {
		return DamageSource.outOfWorld;
	}

	@Override
	public Object damageSourceStarve() {
		return DamageSource.starve;
	}

	@Override
	public Object damageSourceWither() {
		return DamageSource.wither;
	}

	@Override
	public void dataManagerAddObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		((DataWatcher) entityGetDataWatcher(dataManagerOrEntity)).addObject((Integer) dataParameterOrInt, o);
	}

	@Override
	public byte dataManagerGetWatchableObjectByte(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return ((DataWatcher) entityGetDataWatcher(dataManagerOrEntity)).getWatchableObjectByte((Integer) dataParameterOrInt);
	}

	@Override
	public Object dataManagerGetWatchableObjectItemStack(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return ((DataWatcher) entityGetDataWatcher(dataManagerOrEntity)).getWatchableObjectItemStack((Integer) dataParameterOrInt);
	}

	@Override
	public void dataManagerUpdateObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		DataWatcher dataManager = ((DataWatcher) entityGetDataWatcher(dataManagerOrEntity));
		if (dataManagerGetWatchedObject(dataManagerOrEntity, dataParameterOrInt) != null) dataManager.updateObject((Integer) dataParameterOrInt, o);
		else dataManager.addObject((Integer) dataParameterOrInt, o);
	}

	@Override
	public int entityAgeableGetGrowingAge(Object entityAgeable) {
		return ((EntityAgeable) entityAgeable).getGrowingAge();
	}

	@Override
	public Object entityArrowShootingEntity(Object entityArrow) {
		return ((EntityArrow) entityArrow).shootingEntity;
	}

	@Override
	public void entityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
	}

	@Override
	public int entityDimension(Object entity) {
		return ((Entity) entity).dimension;
	}

	@Override
	public float entityDistanceWalkedModified(Object entity) {
		return ((Entity) entity).distanceWalkedModified;
	}

	@Override
	public float entityGetBrightness(Object entity, float f) {
		return ((Entity) entity).getBrightness(f);
	}

	@Override
	public int entityGetBrightnessForRender(Object entity, float f) {
		return ((Entity) entity).getBrightnessForRender(f);
	}

	@Override
	public float entityGetEyeHeight(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getEyeHeight();
	}

	@Override
	public float entityHeight(Object entity) {
		return ((Entity) entity).height;
	}

	@Override
	public int entityHurtResistantTime(Object entity) {
		return ((Entity) entity).hurtResistantTime;
	}

	@Override
	public boolean entityIsInvisible(Object entity) {
		return ((Entity) entity).isInvisible();
	}

	@Override
	public boolean entityIsInWater(Object entity) {
		return ((Entity) entity).isInWater();
	}

	@Override
	public boolean entityIsRiding(Object entity) {
		return ((Entity) entity).isRiding();
	}

	@Override
	public boolean entityIsSneaking(Object entity) {
		return ((Entity) entity).isSneaking();
	}

	@Override
	public boolean entityIsWet(Object entity) {
		return ((Entity) entity).isWet();
	}

	@Override
	public Object entityLivingGetNavigator(Object entityLivingOrPathNavigate) {
		return entityLivingOrPathNavigate instanceof Entity ? ((EntityLiving) entityLivingOrPathNavigate).getNavigator() : entityLivingOrPathNavigate;
	}

	@Override
	public void entityLivingNavigatorClearPathEntity(Object entityLivingOrPathNavigate) {
		Object navigator = entityLivingGetNavigator(entityLivingOrPathNavigate);
		if (navigator != null) ((PathNavigate) navigator).clearPathEntity();
	}

	@Override
	public double entityMotionX(Object entity) {
		return ((Entity) entity).motionX;
	}

	@Override
	public double entityMotionY(Object entity) {
		return ((Entity) entity).motionY;
	}

	@Override
	public double entityMotionZ(Object entity) {
		return ((Entity) entity).motionZ;
	}

	@Override
	public boolean entityStartRiding(Object entity, Object entity2) {
		return entityStartRiding(entity, entity2, false);
	}

	@Override
	public boolean entityStartRiding(Object entity, Object entity2, boolean b) {
		((Entity) entity).mountEntity((Entity) entity2);
		return true;
	}

	@Override
	public boolean entityOnGround(Object entity) {
		return ((Entity) entity).onGround;
	}

	@Override
	public Object[] entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorInventory;
	}

	@Override
	public float entityPlayerCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).cameraYaw;
	}

	@Override
	public float entityPlayerCurrentXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experience;
	}

	@Override
	public void entityPlayerSetItemInUse(Object entityplayer, Object itemstack, int i) {
		((EntityPlayer) entityplayer).setItemInUse((ItemStack) itemstack, i);
	}

	@Override
	public Object entityplayerGetCurrentEquippedItem(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getCurrentEquippedItem();
	}

	@Override
	public Object entityPlayerGetFoodStats(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getFoodStats();
	}

	@Override
	public int entityPlayerGetItemInUseCount(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getItemInUseCount();
	}

	@Override
	public Object entityPlayerInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) return entityplayerORInventory;
		return ((EntityPlayer) entityplayerORInventory).inventory;
	}

	@Override
	public Object entityPlayerInventoryGetCurrentItem(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) {
			return ((InventoryPlayer) entityplayerORInventory).getCurrentItem();
		}
		return ((EntityPlayer) entityplayerORInventory).inventory.getCurrentItem();
	}

	@Override
	public Object entityPlayerInventoryGetStackInSlot(Object entityplayerORInventory, int i) {
		if (entityplayerORInventory instanceof InventoryPlayer) return ((InventoryPlayer) entityplayerORInventory).getStackInSlot(i);
		return ((EntityPlayer) entityplayerORInventory).inventory.getStackInSlot(i);
	}

	@Override
	public Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		if (entityplayerORInventory instanceof InventoryPlayer); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorItemInSlot(i);
	}

	@Override
	public void entityPlayerInventorySetInventorySlotContents(Object entityplayer, int i, Object itemstack) {
		((InventoryPlayer) entityPlayerInventory(entityplayer)).setInventorySlotContents(i, (ItemStack) itemstack);
	}

	@Override
	public boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return ((EntityPlayer) entityplayer).isPlayerSleeping();
	}

	@Override
	public Object[] entityPlayerMainInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).mainInventory;
	}

	@Override
	public int entityPlayerPlayerLevel(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceLevel;
	}

	@Override
	public float entityPlayerPrevCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).prevCameraYaw;
	}

	@Override
	public int entityPlayerScore(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getScore();
	}

	@Override
	public int entityPlayerTotalXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceTotal;
	}

	@Override
	public void entityPlaySound(Object entity, Object s, float f1, float f2) {
		((Entity) entity).playSound((String) s, f1, f2);
	}

	@Override
	public double entityPosX(Object entity) {
		return ((Entity) entity).posX;
	}

	@Override
	public double entityPosY(Object entity) {
		return ((Entity) entity).posY;
	}

	@Override
	public double entityPosZ(Object entity) {
		return ((Entity) entity).posZ;
	}

	@Override
	public float entityPrevDistanceWalkedModified(Object entity) {
		return ((Entity) entity).prevDistanceWalkedModified;
	}

	@Override
	public double entityPrevPosX(Object entity) {
		return ((Entity) entity).prevPosX;
	}

	@Override
	public double entityPrevPosY(Object entity) {
		return ((Entity) entity).prevPosY;
	}

	@Override
	public double entityPrevPosZ(Object entity) {
		return ((Entity) entity).prevPosZ;
	}

	@Override
	public float entityPrevRotationPitch(Object entity) {
		return ((Entity) entity).prevRotationPitch;
	}

	@Override
	public float entityPrevRotationYaw(Object entity) {
		return ((Entity) entity).prevRotationYaw;
	}

	@Override
	public Object entityRiddenByEntity(Object entity) {
		return ((Entity) entity).riddenByEntity;
	}

	@Override
	public Object entityRidingEntity(Object entity) {
		return ((Entity) entity).ridingEntity;
	}

	@Override
	public float entityRotationPitch(Object entity) {
		return ((Entity) entity).rotationPitch;
	}

	@Override
	public float entityRotationYaw(Object entity) {
		return ((Entity) entity).rotationYaw;
	}

	@Override
	public void entitySetDead(Object entity) {
		((Entity) entity).setDead();
	}

	@Override
	public void entitySetFire(Object entity, int i) {
		((Entity) entity).setFire(i);
	}

	@Override
	public void entitySetPosition(Object entity, double x, double y, double z) {
		((Entity) entity).setPosition(x, y, z);
	}

	@Override
	public int entityTicksExisted(Object entity) {
		return ((Entity) entity).ticksExisted;
	}

	@Override
	public float entityWidth(Object entity) {
		return ((Entity) entity).width;
	}

	@Override
	public Object entityWorld(Object worldOrEntity) {
		return worldOrEntity instanceof World ? worldOrEntity : worldOrEntity instanceof Entity ? ((Entity) worldOrEntity).worldObj : null;
	}

	@Override
	public Enum enumCreatureAttributeARTHROPOD() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	public Enum enumCreatureAttributeUNDEAD() {
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	public Enum enumCreatureAttributeUNDEFINED() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	public void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		((FontRenderer) fontRenderer).drawString(s, i, j, k);
	}

	@Override
	public String gameSettingsGetKeyDisplayString(int i) {
		return GameSettings.getKeyDisplayString(i);
	}

	@Override
	public Object gameSettingsKeyBindBack() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindBack;
	}

	@Override
	public Object gameSettingsKeyBindForward() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindForward;
	}

	@Override
	public Object gameSettingsKeyBindLeft() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindLeft;
	}

	@Override
	public Object gameSettingsKeyBindRight() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindRight;
	}

	@Override
	public Object getBlockItemStack(Object itemstack) {
		if (itemstack != null); else return null;
		return blockGetBlockFromItem(itemStackGetItem(itemstack));
	}

	@Override
	public Object getResource(String s) {
		return getResource(Minecraft.class, s);
	}

	@Override
	public IntBuffer gLAllocationCreateDirectIntBuffer(int i) {
		return GLAllocation.createDirectIntBuffer(i);
	}

	@Override
	public int gLAllocationGenerateDisplayLists(int i) {
		return GLAllocation.generateDisplayLists(i);
	}

	@Override
	public boolean guiButtonEnabled(Object guiButton) {
		return ((GuiButton) guiButton).enabled;
	}

	@Override
	public int guiButtonID(Object guiButton) {
		return ((GuiButton) guiButton).id;
	}

	@Override
	public int guiButtonXPosition(Object guiButton) {
		return ((GuiButton) guiButton).xPosition;
	}

	@Override
	public int guiButtonYPosition(Object guiButton) {
		return ((GuiButton) guiButton).yPosition;
	}

	@Override
	public void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		((Gui) gui).drawCenteredString((FontRenderer) fontRenderer, s, i, i2, i3);
	}

	@Override
	public void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		((GuiScreen) guiScreen).drawScreen(i, i2, f);
	}

	@Override
	public int guiScreenHeight(Object guiScreen) {
		return ((GuiScreen) guiScreen).height;
	}

	@Override
	public int guiScreenWidth(Object guiScreen) {
		return ((GuiScreen) guiScreen).width;
	}

	@Override
	public void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		((GuiSlot) guiSlot).actionPerformed((GuiButton) guiButton);
	}

	@Override
	public void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		((GuiSlot) guiSlot).drawScreen(i, i2, f);
	}

	@Override
	public Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).armorItemInSlot(i);
	}

	@Override
	public Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).getStackInSlot(i);
	}

	@Override
	public boolean isCamouflageCheck(Object block) {
		return block instanceof BlockLeaves;
	}

	@Override
	public boolean isIntegratedServerRunning() {
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().isIntegratedServerRunning() : false;
	}

	@Override
	public boolean isLANWorld() {
		if (Modchu_Main.isServer) return false;
		if (!isMuiti()) {
			Object theIntegratedServer = Modchu_Reflect.getFieldObject("Minecraft", "field_71437_Z", "theIntegratedServer", minecraftGetMinecraft());
			if (theIntegratedServer != null
					&& (Boolean) Modchu_Reflect.invokeMethod(theIntegratedServer.getClass(), "func_71344_c", "getPublic", theIntegratedServer)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isMuiti() {
		if (Modchu_Main.isServer) return true;
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().getNetHandler() != null
				&& !Minecraft.getMinecraft().isSingleplayer() : true;
	}

	@Override
	public boolean isSkull(Object itemStackOrItem) {
		int version = Modchu_Main.getMinecraftVersion();
		Object item = itemStackOrItem;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItem)) {
			item = itemStackGetItem(itemStackOrItem);
		}
		return getItem("skull").getClass().isInstance(item);
	}

	@Override
	public int itemArmorRenderIndex(Object itemArmor) {
		return ((ItemArmor) itemArmor).renderIndex;
	}

	@Override
	public boolean itemIsFull3D(Object item) {
		return ((Item) item).isFull3D();
	}

	@Override
	public Object itemSetCreativeTab(Object item, Object creativeTabs) {
		return ((Item) item).setCreativeTab((CreativeTabs) creativeTabs);
	}

	@Override
	public Object itemSetUnlocalizedName(Object item, String s) {
		return ((Item) item).setUnlocalizedName(s);
	}

	@Override
	public Object itemStackCopyItemStack(Object itemstack) {
		return ItemStack.copyItemStack((ItemStack) itemstack);
	}

	@Override
	public Object itemStackGetItem(Object itemstack) {
		return ((ItemStack) itemstack).getItem();
	}

	@Override
	public Object itemStackGetItemUseAction(Object itemstack) {
		return ((ItemStack) itemstack).getItemUseAction();
	}

	@Override
	public boolean itemStackIsItemEnchanted(Object itemstack) {
		return ((ItemStack) itemstack).isItemEnchanted();
	}

	@Override
	public int itemStackStackSize(Object itemstack) {
		return ((ItemStack) itemstack).stackSize;
	}

	@Override
	public boolean keyBindingIsPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).isPressed() : null;
	}

	@Override
	public float mathHelperCos(float f) {
		return MathHelper.cos(f);
	}

	@Override
	public int mathHelperFloor_double(double d) {
		return MathHelper.floor_double(d);
	}

	@Override
	public float mathHelperSin(float f) {
		return MathHelper.sin(f);
	}

	@Override
	public float mathHelperSqrt_float(float f) {
		return MathHelper.sqrt_float(f);
	}

	@Override
	public Object minecraftCurrentScreen() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().currentScreen;
	}

	@Override
	public int minecraftDisplayHeight() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().displayHeight;
	}

	@Override
	public int minecraftDisplayWidth() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().displayWidth;
	}

	@Override
	public Object minecraftEntityRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().entityRenderer;
	}

	@Override
	public Object minecraftEntityRendererItemRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().entityRenderer.itemRenderer;
	}

	@Override
	public Object minecraftGameSettings() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings;
	}

	@Override
	public void minecraftGameSettingsSetThirdPersonView(int i) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.thirdPersonView = i;
	}

	@Override
	public int minecraftGameSettingsThirdPersonView() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().gameSettings.thirdPersonView;
	}

	@Override
	public boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		if (Modchu_Main.isServer) return false;
		return Minecraft.getMinecraft().gameSettings.touchscreen;
	}

	@Override
	public boolean minecraftInGameHasFocus() {
		if (Modchu_Main.isServer) return false;
		return Minecraft.getMinecraft().inGameHasFocus;
	}

	@Override
	public File minecraftMcDataDir() {
		if (Modchu_Main.isServer) return new File(".");
		return Minecraft.getMinecraft().mcDataDir;
	}

	@Override
	public Object minecraftPlayerController() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().playerController;
	}

	@Override
	public void minecraftSetDimensionAndSpawnPlayer() {
		Object thePlayer = minecraftPlayer();
		minecraftSetDimensionAndSpawnPlayer(((Entity) thePlayer).dimension);
	}

	@Override
	public void minecraftSetDimensionAndSpawnPlayer(int i) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().setDimensionAndSpawnPlayer(i);
	}

	@Override
	public Object minecraftWorld() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer().worldServers[0];
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	public float modelRendererRotateAngleX(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleX;
	}

	@Override
	public float modelRendererRotateAngleY(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleY;
	}

	@Override
	public float modelRendererRotateAngleZ(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleZ;
	}

	@Override
	public float modelRendererRotationPointX(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointX;
	}

	@Override
	public float modelRendererRotationPointY(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointY;
	}

	@Override
	public float modelRendererRotationPointZ(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointZ;
	}

	@Override
	public void modelRendererSetRotationPoint(Object modelRenderer, float f, float f1, float f2 ) {
		((ModelRenderer) modelRenderer).setRotationPoint(f, f1, f2);
	}

	@Override
	public boolean modelRendererShowModel(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).showModel;
	}

	@Override
	public boolean nbttagcompoundGetBoolean(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getBoolean(s);
	}

	@Override
	public byte nbttagcompoundGetByte(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getByte(s);
	}

	@Override
	public byte[] nbttagcompoundGetByteArray(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getByteArray(s);
	}

	@Override
	public double nbttagcompoundGetDouble(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getDouble(s);
	}

	@Override
	public float nbttagcompoundGetFloat(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getFloat(s);
	}

	@Override
	public int[] nbttagcompoundGetIntArray(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getIntArray(s);
	}

	@Override
	public int nbttagcompoundGetInteger(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getInteger(s);
	}

	@Override
	public long nbttagcompoundGetLong(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getLong(s);
	}

	@Override
	public short nbttagcompoundGetShort(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getShort(s);
	}

	@Override
	public String nbttagcompoundGetString(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getString(s);
	}

	@Override
	public void nbttagcompoundSetBoolean(Object nbttagcompound, String s, boolean b) {
		((NBTTagCompound) nbttagcompound).setBoolean(s, b);
	}

	@Override
	public void nbttagcompoundSetByte(Object nbttagcompound, String s, byte by) {
		((NBTTagCompound) nbttagcompound).setByte(s, by);
	}

	@Override
	public void nbttagcompoundSetByteArray(Object nbttagcompound, String s, byte[] by) {
		((NBTTagCompound) nbttagcompound).setByteArray(s, by);
	}

	@Override
	public void nbttagcompoundSetDouble(Object nbttagcompound, String s, double d) {
		((NBTTagCompound) nbttagcompound).setDouble(s, d);
	}

	@Override
	public void nbttagcompoundSetFloat(Object nbttagcompound, String s, float f) {
		((NBTTagCompound) nbttagcompound).setFloat(s, f);
	}

	@Override
	public void nbttagcompoundSetIntArray(Object nbttagcompound, String s, int[] in) {
		((NBTTagCompound) nbttagcompound).setIntArray(s, in);
	}

	@Override
	public void nbttagcompoundSetInteger(Object nbttagcompound, String s, int i) {
		((NBTTagCompound) nbttagcompound).setInteger(s, i);
	}

	@Override
	public void nbttagcompoundSetLong(Object nbttagcompound, String s, long l) {
		((NBTTagCompound) nbttagcompound).setLong(s, l);
	}

	@Override
	public void nbttagcompoundSetShort(Object nbttagcompound, String s, short sh) {
		((NBTTagCompound) nbttagcompound).setShort(s, sh);
	}

	@Override
	public void nbttagcompoundSetString(Object nbttagcompound, String s, String s1) {
		((NBTTagCompound) nbttagcompound).setString(s, s1);
	}

	@Override
	public int openGlHelperDefaultTexUnit() {
		return OpenGlHelper.defaultTexUnit;
	}

	@Override
	public int openGlHelperLightmapTexUnit() {
		return OpenGlHelper.lightmapTexUnit;
	}

	@Override
	public void openGlHelperSetActiveTexture(int i) {
		OpenGlHelper.setActiveTexture(i);
	}

	@Override
	public void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		((PlayerControllerMP) playerController).flipPlayer((EntityPlayer) entityplayer);
	}

	@Override
	public Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return ((PositionTextureVertex) positionTextureVertex).setTexturePosition(f, f1);
	}

	@Override
	public float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionX;
	}

	@Override
	public float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionY;
	}

	@Override
	public Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).vector3D;
	}

	@Override
	public Object potionBlindness() {
		return Potion.blindness;
	}

	@Override
	public Object potionConfusion() {
		return Potion.confusion;
	}

	@Override
	public Object potionDamageBoost() {
		return Potion.damageBoost;
	}

	@Override
	public Object potionDigSlowdown() {
		return Potion.digSlowdown;
	}

	@Override
	public Object potionDigSpeed() {
		return Potion.digSpeed;
	}

	@Override
	public Object potionFireResistance() {
		return Potion.fireResistance;
	}

	@Override
	public Object potionHarm() {
		return Potion.harm;
	}

	@Override
	public Object potionHeal() {
		return Potion.heal;
	}

	@Override
	public Object potionHunger() {
		return Potion.hunger;
	}

	@Override
	public Object potionInvisibility() {
		return Potion.invisibility;
	}

	@Override
	public Object potionJump() {
		return Potion.jump;
	}

	@Override
	public Object potionMoveSlowdown() {
		return Potion.moveSlowdown;
	}

	@Override
	public Object potionMoveSpeed() {
		return Potion.moveSpeed;
	}

	@Override
	public Object potionNightVision() {
		return Potion.nightVision;
	}

	@Override
	public Object potionPoison() {
		return Potion.poison;
	}

	@Override
	public Object potionRegeneration() {
		return Potion.regeneration;
	}

	@Override
	public Object potionResistance() {
		return Potion.resistance;
	}

	@Override
	public Object potionWaterBreathing() {
		return Potion.waterBreathing;
	}

	@Override
	public Object potionWeakness() {
		return Potion.weakness;
	}

	@Override
	public Object potionWither() {
		return Potion.wither;
	}

	@Override
	public void renderHelperDisableStandardItemLighting() {
		RenderHelper.disableStandardItemLighting();
	}

	@Override
	public void renderHelperEnableStandardItemLighting() {
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	public Object renderManagerGetEntityClassRenderObject(Class c) {
		return ((RenderManager) renderManagerInstance()).getEntityClassRenderObject(c);
	}

	@Override
	public Object renderManagerGetEntityRenderObject(Object entity) {
		return ((RenderManager) renderManagerInstance()).getEntityRenderObject((Entity) entity);
	}
/*
	@Override
	public void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		((ItemRenderer) renderManagerItemRenderer()).renderItem((EntityLivingBase) entity, (ItemStack) itemstack, (net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType) o);
	}
*/
	@Override
	public Object renderRenderManagerRenderEngine(Object render) {
		return ((RenderManager) renderRenderManager(render)).renderEngine;
	}

	@Override
	public void setEntityHurtResistantTime(Object entity, int i) {
		((Entity) entity).hurtResistantTime = i;
	}

	@Override
	public void setEntityMotionX(Object entity, double d) {
		((Entity) entity).motionX = d;
	}

	@Override
	public void setEntityMotionY(Object entity, double d) {
		((Entity) entity).motionY = d;
	}

	@Override
	public void setEntityMotionZ(Object entity, double d) {
		((Entity) entity).motionZ = d;
	}

	@Override
	public void setEntityPlayerArmorInventory(Object entityplayerORInventory, Object armorInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ((InventoryPlayer) entityplayerORInventory).armorInventory = (ItemStack[]) armorInventory;
		else ((EntityPlayer) entityplayerORInventory).inventory.armorInventory = (ItemStack[]) armorInventory;
	}

	@Override
	public void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		((EntityPlayer) entityplayer).experience = f;
	}

	@Override
	public void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		((EntityPlayer) entityplayer).inventory = (InventoryPlayer) inventory;
	}

	@Override
	public void setEntityPlayerMainInventory(Object entityplayerORInventory, Object mainInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ((InventoryPlayer) entityplayerORInventory).mainInventory = (ItemStack[]) mainInventory;
		else ((EntityPlayer) entityplayerORInventory).inventory.mainInventory = (ItemStack[]) mainInventory;
	}

	@Override
	public void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceLevel = i;
	}

	@Override
	public void setEntityPlayerScore(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).setScore(i);
	}

	@Override
	public void setEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		((EntityPlayerSP) entityplayer).movementInput = (MovementInput) movementInput;
	}

	@Override
	public void setEntityPlayerTotalXP(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceTotal = i;
	}

	@Override
	public void setEntityPosX(Object entity, double d) {
		((Entity) entity).posX = d;
	}

	@Override
	public void setEntityPosY(Object entity, double d) {
		((Entity) entity).posY = d;
	}

	@Override
	public void setEntityPosZ(Object entity, double d) {
		((Entity) entity).posZ = d;
	}

	@Override
	public void setEntityRendererItemRenderer(Object itemRenderer) {
		//final orz
		Modchu_Reflect.setFieldObject("EntityRenderer", Modchu_Main.getMinecraftVersion() > 169 ? "field_78516_c" : "field_73841_b", "itemRenderer", minecraftEntityRenderer(), itemRenderer);
	}

	@Override
	public void setEntityRiddenByEntity(Object entity, Object entity2) {
		((Entity) entity).riddenByEntity = (Entity) entity2;
	}

	@Override
	public void setGameSettingsKeyBindBack(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindBack = (KeyBinding) keyBinding;
	}

	@Override
	public void setGameSettingsKeyBindForward(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindForward = (KeyBinding) keyBinding;
	}

	@Override
	public void setGameSettingsKeyBindLeft(Object keyBinding) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.keyBindLeft = (KeyBinding) keyBinding;
	}

	@Override
	public void setGameSettingsKeyBindRight(Object keyBinding) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.keyBindRight = (KeyBinding) keyBinding;
	}

	@Override
	public void setGuiButtonEnabled(Object guiButton, boolean b) {
		((GuiButton) guiButton).enabled = b;
	}

	@Override
	public void setGuiButtonID(Object guiButton, int i) {
		((GuiButton) guiButton).id = i;
	}

	@Override
	public void setGuiButtonXPosition(Object guiButton, int i) {
		((GuiButton) guiButton).xPosition = i;
	}

	@Override
	public void setGuiButtonYPosition(Object guiButton, int i) {
		((GuiButton) guiButton).yPosition = i;
	}

	@Override
	public void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		Modchu_Reflect.setFieldObject("GuiScreen", "fontRendererObj", guiScreen, fontRenderer);
	}

	@Override
	public void setGuiScreenHeight(Object guiScreen, int i) {
		((GuiScreen) guiScreen).height = i;
	}

	@Override
	public void setGuiScreenWidth(Object guiScreen, int i) {
		((GuiScreen) guiScreen).width = i;
	}

	@Override
	public void setMinecraftDisplayGuiScreen(Object guiScreen) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) guiScreen);
	}

	@Override
	public void setMinecraftPlayerController(Object playerController) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().playerController = (PlayerControllerMP) playerController;
	}

	@Override
	public void setModelRendererRotateAngleX(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleX = f;
	}

	@Override
	public void setModelRendererRotateAngleY(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleY = f;
	}

	@Override
	public void setModelRendererRotateAngleZ(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleZ = f;
	}

	@Override
	public void setModelRendererRotationPointX(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointX = f;
	}

	@Override
	public void setModelRendererRotationPointY(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointY = f;
	}

	@Override
	public void setModelRendererRotationPointZ(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointZ = f;
	}

	@Override
	public void setModelRendererShowModel(Object modelRenderer, boolean b) {
		((ModelRenderer) modelRenderer).showModel = b;
	}

	@Override
	public void tessellatorStartDrawingQuads(Object tessellator, int i, Object vertexFormat) {
		tessellatorStartDrawing(tessellator, i, vertexFormat);
	}

	@Override
	public int textureOffsetTextureOffsetX(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetX;
	}

	@Override
	public int textureOffsetTextureOffsetY(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetY;
	}

	@Override
	public Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).crossProduct((Vec3) vec3_2);
	}

	@Override
	public Object vec3Normalize(Object vec3) {
		return ((Vec3) vec3).normalize();
	}

	@Override
	public double vec3XCoord(Object vec3) {
		return ((Vec3) vec3).xCoord;
	}

	@Override
	public double vec3YCoord(Object vec3) {
		return ((Vec3) vec3).yCoord;
	}

	@Override
	public double vec3ZCoord(Object vec3) {
		return ((Vec3) vec3).zCoord;
	}

	@Override
	public Object worldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return ((World) entityWorld(worldOrEntity)).getPlayerEntityByName(s);
	}

	@Override
	public Object worldGetWorldInfo() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().theWorld.getWorldInfo();
	}

	@Override
	public Enum worldGetWorldInfoGetGameType() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().theWorld.getWorldInfo().getGameType();
	}

	@Override
	public boolean worldIsDaytime(Object worldOrEntity) {
		return ((World) entityWorld(worldOrEntity)).isDaytime();
	}

	@Override
	public boolean worldIsRemote(Object worldOrEntity) {
		World world = ((World) entityWorld(worldOrEntity));
		return world != null ? world.isRemote : false;
	}

	@Override
	public List worldLoadedEntityList(Object worldOrEntity) {
		World world = ((World) entityWorld(worldOrEntity));
		return world != null ? world.loadedEntityList : null;
	}

	@Override
	public List worldPlayerEntities(Object worldOrEntity) {
		World world = ((World) entityWorld(worldOrEntity));
		return world != null ? world.playerEntities : null;
	}

	@Override
	public List worldWeatherEffects(Object worldOrEntity) {
		World world = ((World) entityWorld(worldOrEntity));
		return world != null ? world.weatherEffects : null;
	}

	@Override
	public void worldPlaySoundAtEntity(Object worldOrEntity, Object entity, Object soundEventOrString, float f, float f1) {
		World world = ((World) entityWorld(worldOrEntity));
		if (world != null) world.playSoundAtEntity((Entity) entity, (String) soundEventOrString, f, f1);
	}

	@Override
	public void worldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		World world = ((World) entityWorld(worldOrEntity));
		if (world != null) world.setEntityState((Entity) entity, by);
	}

	@Override
	public boolean entityIsDead(Object entity) {
		return ((Entity) entity).isDead;
	}

	@Override
	public void setEntityIsDead(Object entity, boolean b) {
		((Entity) entity).isDead = b;
	}

	@Override
	public boolean entityTameableIsTamed(Object entityTameable) {
		return entityTameable instanceof EntityTameable ? ((EntityTameable) entityTameable).isTamed() : false;
	}

	@Override
	public Object getIntegratedServer() {
		return Minecraft.getMinecraft().getIntegratedServer();
	}

	@Override
	public boolean itemShouldRotateAroundWhenRendering(Object item) {
		return ((Item) item).shouldRotateAroundWhenRendering();
	}

	@Override
	public boolean itemStackHasTagCompound(Object itemStack) {
		return ((ItemStack) itemStack).hasTagCompound();
	}

	@Override
	public Object itemStackGetTagCompound(Object nBTTagCompoundOrItemStack) {
		return nBTTagCompoundOrItemStack instanceof NBTTagCompound ? nBTTagCompoundOrItemStack : ((ItemStack) nBTTagCompoundOrItemStack).getTagCompound();
	}

	@Override
	public boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		nBTTagCompoundOrItemStack = nBTTagCompoundOrItemStack instanceof NBTTagCompound ? nBTTagCompoundOrItemStack : ((ItemStack) nBTTagCompoundOrItemStack).getTagCompound();
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).hasKey(s);
	}

	@Override
	public String nbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		nBTTagCompoundOrItemStack = nBTTagCompoundOrItemStack instanceof NBTTagCompound ? nBTTagCompoundOrItemStack : ((ItemStack) nBTTagCompoundOrItemStack).getTagCompound();
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).getString(s);
	}

	@Override
	public int itemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return ((Item) item).getColorFromItemStack((ItemStack) itemstack, i);
	}

	@Override
	public boolean entityRendererAnaglyphEnable() {
		return EntityRenderer.anaglyphEnable;
	}

	@Override
	public int itemArmorGetColor(Object itemArmor, Object itemstack) {
		return itemArmor instanceof ItemArmor ? ((ItemArmor) itemArmor).getColor((ItemStack) itemstack) : -1;
	}

	@Override
	public void setEntityRotationPitch(Object entity, float f) {
		((Entity) entity).rotationPitch = f;
	}

	@Override
	public void setEntityRotationYaw(Object entity, float f) {
		((Entity) entity).rotationYaw = f;
	}

	@Override
	public void setEntityPrevRotationPitch(Object entity, float f) {
		((Entity) entity).prevRotationPitch = f;
	}

	@Override
	public void setEntityPrevRotationYaw(Object entity, float f) {
		((Entity) entity).prevRotationYaw = f;
	}

	@Override
	public void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		((Item) item).onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityplayer);
	}

	@Override
	public Object nbtTagCompoundGetCompoundTag(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).getCompoundTag(s);
	}

	@Override
	public void setItemStackStackSize(Object itemstack, int i) {
		((ItemStack) itemstack).stackSize = i;
	}

	@Override
	public Object minecraftServerGetServer() {
		return MinecraftServer.getServer();
	}

	@Override
	public Object[] minecraftServerGetServerWorldServers() {
		return MinecraftServer.getServer().worldServers;
	}

	@Override
	public void entityPlayerDestroyCurrentEquippedItem(Object entityplayer) {
		((EntityPlayer) entityplayer).destroyCurrentEquippedItem();
	}

	@Override
	public boolean entityPlayerCapabilitiesIsCreativeMode(Object entityplayer) {
		return ((EntityPlayer) entityplayer).capabilities.isCreativeMode;
	}

	@Override
	public boolean modelBaseIsChild(Object modelBase) {
		return ((ModelBase) modelBase).isChild;
	}

	@Override
	public void setModelBaseIsChild(Object modelBase, boolean b) {
		((ModelBase) modelBase).isChild = b;
	}

	@Override
	public void entityBatSetIsBatHanging(Object entityBat, boolean b) {
		((EntityBat) entityBat).setIsBatHanging(b);
	}

	@Override
	public void entitySetEating(Object entity, boolean b) {
		((Entity) entity).setEating(b);
	}

	@Override
	public void entitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		((Entity) entity).setPositionAndRotation(x, y, z, f, f1);
	}

	@Override
	public int itemStackGetMaxDamage(Object itemstack) {
		return ((ItemStack) itemstack).getMaxDamage();
	}

	@Override
	public float mathHelperFloor_float(float f) {
		return MathHelper.floor_float(f);
	}

	@Override
	public long mathHelperLfloor(double d) {
		return MathHelper.floor_double_long(d);
	}

	@Override
	public float mathHelperAbs(float f) {
		return MathHelper.abs(f);
	}

	@Override
	public double mathHelperAbs_max(double d, double d1) {
		return MathHelper.abs_max(d, d1);
	}

	@Override
	public int mathHelperIntFloorDiv(int i, int j) {
		return MathHelper.bucketInt(i, j);
	}

	@Override
	public List modelBaseBoxList(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(modelBase.getClass(), "boxList", modelBase));
		}
		return ((ModelBase) modelBase).boxList;
	}

	@Override
	public void setModelBaseBoxList(Object modelBase, List list) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "boxList", modelBase, list);
			return;
		}
		((ModelBase) modelBase).boxList = list;
	}

	@Override
	public int modelBaseTextureWidth(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			//Modchu_Debug.mDebug("Modchu_ASMaster modelBaseTextureWidth modelBase.getClass()="+modelBase.getClass());
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureWidth", modelBase));
		}
		return ((ModelBase) modelBase).textureWidth;
	}

	@Override
	public void setModelBaseTextureWidth(Object modelBase, int i) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureWidth", modelBase, i);
			return;
		}
		((ModelBase) modelBase).textureWidth = i;
	}

	@Override
	public int modelBaseTextureHeight(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureHeight", modelBase));
		}
		return ((ModelBase) modelBase).textureHeight;
	}

	@Override
	public void setModelBaseTextureHeight(Object modelBase, int i) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureHeight", modelBase, i);
			return;
		}
		((ModelBase) modelBase).textureHeight = i;
	}

	@Override
	public Object modelWolfWolfLeg1(Object modelWolf) {
		return ((ModelWolf) modelWolf).wolfLeg1;
	}

	@Override
	public void setModelWolfWolfLeg1(Object modelWolf, Object modelRenderer) {
		((ModelWolf) modelWolf).wolfLeg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	public Object modelSnowManRightHand(Object modelSnowMan) {
		return ((ModelSnowMan) modelSnowMan).rightHand;
	}

	@Override
	public void setModelSnowManRightHand(Object modelSnowMan, Object modelRenderer) {
		((ModelSnowMan) modelSnowMan).rightHand = (ModelRenderer) modelRenderer;
	}

	@Override
	public Object modelSpiderSpiderLeg1(Object modelSpider) {
		return ((ModelSpider) modelSpider).spiderLeg1;
	}

	@Override
	public void setModelSpiderSpiderLeg1(Object modelSpider, Object modelRenderer) {
		((ModelSpider) modelSpider).spiderLeg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	public Object modelIronGolemIronGolemRightArm(Object modelIronGolem) {
		return ((ModelIronGolem) modelIronGolem).ironGolemRightArm;
	}

	@Override
	public void setModelIronGolemIronGolemRightArm(Object modelIronGolem, Object modelRenderer) {
		((ModelIronGolem) modelIronGolem).ironGolemRightArm = (ModelRenderer) modelRenderer;
	}

	@Override
	public Object modelQuadrupedLeg1(Object modelQuadruped) {
		return ((ModelQuadruped) modelQuadruped).leg1;
	}

	@Override
	public void setModelQuadrupedLeg1(Object modelQuadruped, Object modelRenderer) {
		((ModelQuadruped) modelQuadruped).leg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	public Object modelCreeperLeg1(Object modelCreeper) {
		return ((ModelCreeper) modelCreeper).leg1;
	}

	@Override
	public void setModelCreeperLeg1(Object modelCreeper, Object modelRenderer) {
		((ModelCreeper) modelCreeper).leg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	public Object modelChickenRightWing(Object modelChicken) {
		return ((ModelChicken) modelChicken).rightWing;
	}

	@Override
	public void setModelChickenRightWing(Object modelChicken, Object modelRenderer) {
		((ModelChicken) modelChicken).rightWing = (ModelRenderer) modelRenderer;
	}

	@Override
	public int scaledresolutionGetScaleFactor(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaleFactor();
	}

	@Override
	public int scaledresolutionGetScaledWidth(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaledWidth();
	}

	@Override
	public int scaledresolutionGetScaledHeight(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaledHeight();
	}

	@Override
	public boolean gameSettingsAnaglyph(Object gameSettings) {
		return ((GameSettings) gameSettings).anaglyph;
	}

	@Override
	public double mathHelperSqrt_double(double d) {
		return MathHelper.sqrt_double(d);
	}

	@Override
	public boolean itemStackHasDisplayName(Object itemstack) {
		return ((ItemStack) itemstack).hasDisplayName();
	}

	@Override
	public String itemStackGetDisplayName(Object itemstack) {
		return ((ItemStack) itemstack).getDisplayName();
	}

	@Override
	public Enum movingObjectPositionTypeOfHit(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit;
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.ENTITY;
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
	public Object containerInventorySlots(Object container) {
		return ((Container) container).inventorySlots;
	}

	@Override
	public Object containerGetSlot(Object container, int i) {
		return ((Container) container).getSlot(i);
	}

	@Override
	public Object slotGetStack(Object slot) {
		return ((Slot) slot).getStack();
	}

	@Override
	public Object containerInventoryItemStacks(Object container) {
		return ((Container) container).inventoryItemStacks;
	}

	@Override
	public Object pathNavigateTryMoveToXYZ(Object pathNavigate, int x, int y, int z, float f) {
		return ((PathNavigate) pathNavigate).tryMoveToXYZ(x, y, z, f);
	}

	@Override
	public Object worldGetEntityByID(Object worldOrEntity, int i) {
		return ((World) entityWorld(worldOrEntity)).getEntityByID(i);
	}

	@Override
	public Object vec3AddVector(Object vec3, double d, double d2, double d3) {
		return ((Vec3) vec3).addVector(d, d2, d3);
	}

	@Override
	public List worldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return ((World) entityWorld(worldOrEntity)).getEntitiesWithinAABBExcludingEntity((Entity) entity, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public boolean entityCanBeCollidedWith(Object entity) {
		return ((Entity) entity).canBeCollidedWith();
	}

	@Override
	public float entityGetCollisionBorderSize(Object entity) {
		return ((Entity) entity).getCollisionBorderSize();
	}

	@Override
	public Object axisAlignedBBCalculateIntercept(Object axisAlignedBB, Object vec3, Object vec3_2) {
		return ((AxisAlignedBB) axisAlignedBB).calculateIntercept((Vec3) vec3, (Vec3) vec3_2);
	}

	@Override
	public boolean axisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return ((AxisAlignedBB) axisAlignedBB).isVecInside((Vec3) vec3);
	}

	@Override
	public Object movingObjectPositionHitVec(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).hitVec;
	}

	@Override
	public double vec3SquareDistanceTo(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).squareDistanceTo((Vec3) vec3_2);
	}

	@Override
	public List itemPotionGetEffects(Object itemPotion, Object itemStack) {
		return ((ItemPotion) itemPotion).getEffects((ItemStack) itemStack);
	}

	@Override
	public Object itemArmorGetArmorMaterial(Object itemArmor) {
		return ((ItemArmor) itemArmor).getArmorMaterial();
	}

	@Override
	public Object minecraftLoadingScreen() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().loadingScreen;
	}

	@Override
	public Object entityPlayerFishEntity(Object entityplayer) {
		return ((EntityPlayer) entityplayer).fishEntity;
	}

	@Override
	public void setEntityPlayerFishEntity(Object entityplayer, Object entityFishHook) {
		((EntityPlayer) entityplayer).fishEntity = (EntityFishHook) entityFishHook;
	}

	@Override
	public boolean entityZombieIsVillager(Object entityZombie) {
		return ((EntityZombie) entityZombie).isVillager();
	}

	@Override
	public void entityZombieSetVillager(Object entityZombie, boolean b) {
		((EntityZombie) entityZombie).setVillager(b);
	}

	@Override
	public void nbtTagCompoundSetTag(Object nBTTagCompound, String s, Object nbtBase) {
		((NBTTagCompound) nBTTagCompound).setTag(s, (NBTBase) nbtBase);
	}

	@Override
	public Enum enumFacingUP() {
		return EnumFacing.UP;
	}

	@Override
	public Enum enumFacingDOWN() {
		return EnumFacing.DOWN;
	}

	@Override
	public Enum enumFacingEAST() {
		return EnumFacing.EAST;
	}

	@Override
	public Enum enumFacingNORTH() {
		return EnumFacing.NORTH;
	}

	@Override
	public Enum enumFacingSOUTH() {
		return EnumFacing.SOUTH;
	}

	@Override
	public Enum enumFacingWEST() {
		return EnumFacing.WEST;
	}

	@Override
	public int itemGetMetadata(Object item, int i) {
		return ((Item) item).getMetadata(i);
	}

	@Override
	public void setEntityTicksExisted(Object entity, int i) {
		((Entity) entity).ticksExisted = i;
	}

	@Override
	public List worldGetEntitiesWithinAABB(Object worldOrEntity, Class c, Object axisAlignedBB) {
		return ((World) entityWorld(worldOrEntity)).getEntitiesWithinAABB(c, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public boolean worldSpawnEntity(Object worldOrEntity, Object entity) {
		return ((World) entityWorld(worldOrEntity)).spawnEntityInWorld((Entity) entity);
	}

	@Override
	public Object worldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return ((World) entityWorld(worldOrEntity)).getClosestPlayerToEntity((Entity) entity, d);
	}

	@Override
	public void entityAITasksAddTask(Object entityAITasks, int i, Object entityAIBase) {
		((EntityAITasks) entityAITasks).addTask(i, (EntityAIBase) entityAIBase);
	}

	@Override
	public void entityOnUpdate(Object entity) {
		((Entity) entity).onUpdate();
	}

	@Override
	public void entityPlayerPreparePlayerToSpawn(Object entityplayer) {
		((EntityPlayer) entityplayer).preparePlayerToSpawn();
	}

	@Override
	public void worldRemoveEntity(Object world, Object entity) {
		((World) world).removeEntity((Entity) entity);
	}

	@Override
	public Object minecraftServerGetConfigurationManager(Object minecraftServer) {
		return ((MinecraftServer) minecraftServer).getConfigurationManager();
	}

	@Override
	public void setEntityDimension(Object entity, int i) {
		((Entity) entity).dimension = i;
	}

	@Override
	public Object minecraftGetIntegratedServer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getIntegratedServer();
	}

	@Override
	public File minecraftServerGetFile(String s) {
		return MinecraftServer.getServer().getFile(s);
	}

	@Override
	public boolean isPumpkin(Object itemStackOrBlockOrItem) {
		itemStackOrBlockOrItem = itemStackOrBlockOrItem instanceof ItemStack ? getBlock(itemStackOrBlockOrItem) : itemStackOrBlockOrItem;
		return itemStackOrBlockOrItem instanceof BlockPumpkin;
	}

	@Override
	public List modelRendererCubeList(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).cubeList;
	}

	@Override
	public void setModelRendererCubeList(Object modelRenderer, List list) {
		((ModelRenderer) modelRenderer).cubeList = list;
	}

	@Override
	public List modelRendererChildModels(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).childModels;
	}

	@Override
	public void setModelRendererChildModels(Object modelRenderer, List list) {
		((ModelRenderer) modelRenderer).childModels = list;
	}

	@Override
	public float modelRendererTextureWidth(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).textureWidth;
	}

	@Override
	public void setModelRendererTextureWidth(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).textureWidth = f;
	}

	@Override
	public float modelRendererTextureHeight(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).textureHeight;
	}

	@Override
	public void setModelRendererTextureHeight(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).textureHeight = f;
	}

	@Override
	public boolean entityIsBurning(Object entity) {
		return ((Entity) entity).isBurning();
	}

	@Override
	public boolean entityIsSprinting(Object entity) {
		return ((Entity) entity).isSprinting();
	}

	@Override
	public String entityListGetEntityString(Object entity) {
		return EntityList.getEntityString((Entity) entity);
	}

	@Override
	public long worldInfoGetWorldTotalTime(Object entityOrWorldOrWorldInfo) {
		Object worldInfo = entityOrWorldOrWorldInfo instanceof WorldInfo ? entityOrWorldOrWorldInfo : getWorldInfo(entityOrWorldOrWorldInfo);
		return ((WorldInfo) entityOrWorldOrWorldInfo).getWorldTotalTime();
	}

	public Object getWorldInfo(Object entityOrWorldOrWorldInfo) {
		if (entityOrWorldOrWorldInfo instanceof WorldInfo) return entityOrWorldOrWorldInfo;
		if (entityOrWorldOrWorldInfo instanceof World) return ((World) entityOrWorldOrWorldInfo).getWorldInfo();
		if (entityOrWorldOrWorldInfo instanceof Entity) return ((Entity) entityOrWorldOrWorldInfo).worldObj.getWorldInfo();
		return null;
	}

	@Override
	public long worldInfoGetWorldTime(Object entityOrWorldOrWorldInfo) {
		Object worldInfo = entityOrWorldOrWorldInfo instanceof WorldInfo ? entityOrWorldOrWorldInfo : getWorldInfo(entityOrWorldOrWorldInfo);
		return ((WorldInfo) entityOrWorldOrWorldInfo).getWorldTime();
	}

	@Override
	public int worldGetMoonPhase(Object entityOrWorld) {
		Object world = entityOrWorld instanceof World ? entityOrWorld : entityWorld(entityOrWorld);
		return ((World) world).getMoonPhase();
	}

	@Override
	public void entityLivingSetCurrentItemOrArmor(Object entityLiving, Object dataParameterOrInt, Object itemStack) {
		((EntityLiving) entityLiving).setCurrentItemOrArmor((Integer) dataParameterOrInt, (ItemStack) itemStack);
	}

	@Override
	public void entitySetVelocity(Object entity, double d, double d1, double d2) {
		((Entity) entity).setVelocity(d, d1, d2);
	}

	@Override
	public void entitySetSneaking(Object entity, boolean b) {
		((Entity) entity).setSneaking(b);
	}

	@Override
	public void openGlHelperSetLightmapTextureCoords(int i, float f, float f1) {
		OpenGlHelper.setLightmapTextureCoords(i, f, f1);
	}

	@Override
	public void entityTameableSetTamed(Object entityTameable, boolean b) {
		((EntityTameable) entityTameable).setTamed(b);
	}

	@Override
	public void entityAgeableSetGrowingAge(Object entityTameable, int i) {
		((EntityTameable) entityTameable).setGrowingAge(i);
	}

	@Override
	public void setEntityPlayerCapabilitiesIsCreativeMode(Object entityplayer, boolean b) {
		((EntityPlayer) entityplayer).capabilities.isCreativeMode = b;
	}

	@Override
	public void setEntityPlayerInventoryCurrentItem(Object entityplayer, int i) {
		((InventoryPlayer) entityPlayerInventory(entityplayer)).currentItem = i;
	}

	@Override
	public Object entityGetDataWatcher(Object dataManagerOrEntity) {
		return dataManagerOrEntity instanceof DataWatcher ? dataManagerOrEntity : ((Entity) dataManagerOrEntity).getDataWatcher();
	}

	@Override
	public int blockDoublePlantColorMultiplier(Object blockDoublePlant, int x, int y, int z) {
		return blockDoublePlantColorMultiplier(blockDoublePlant, minecraftWorld(), x, y, z);
	}

	@Override
	public int blockDoublePlantColorMultiplier(Object blockDoublePlant, Object world, int x, int y, int z) {
		return blockColorMultiplier(blockDoublePlant, world, Modchu_AS.get(Modchu_AS.newBlockPos, x, y, z), 0);
	}

	@Override
	public int entityPlayerInventoryCurrentItem(Object entityplayer) {
		return ((InventoryPlayer) entityPlayerInventory(entityplayer)).currentItem;
	}

	@Override
	public void entitySetLocationAndAngles(Object entity, double x, double y, double z, float f, float f1) {
		((Entity) entity).setLocationAndAngles(x, y, z, f, f1);
	}
	//162~189
	@Override
	public Object abstractClientPlayerGetTextureCape(Object entity) {
		return ((AbstractClientPlayer) entity).getLocationCape();
	}

	@Override
	public Object abstractClientPlayerGetTextureSkin(Object entity) {
		return ((AbstractClientPlayer) entity).getLocationSkin();
	}

	@Override
	public Object damageSourceCauseMobDamage(Object entityLivingBase) {
		return DamageSource.causeMobDamage((EntityLivingBase) entityLivingBase);
	}

	@Override
	public float entityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).attackedAtYaw;
	}

	@Override
	public int entityLivingBaseDeathTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).deathTime;
	}

	@Override
	public Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getAITarget();
	}

	@Override
	public float entityLivingBaseGetHealth(Object entity) {
		return ((EntityLivingBase) entity).getHealth();
	}

	@Override
	public Object entityLivingBaseGetHeldItem(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getHeldItem();
	}

	@Override
	public float entityLivingBaseGetMaxHealth(Object entity) {
		return ((EntityLivingBase) entity).getMaxHealth();
	}

	@Override
	public float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return ((EntityLivingBase) entity).getSwingProgress(f);
	}

	@Override
	public int entityLivingBaseHurtTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).hurtTime;
	}

	@Override
	public boolean entityLivingBaseIsChild(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).isChild();
	}

	@Override
	public boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		if (potionOrPotionId instanceof Potion) return ((EntityLivingBase) entityLivingBase).isPotionActive((Potion) potionOrPotionId);
		return ((EntityLivingBase) entityLivingBase).isPotionActive((Integer) potionOrPotionId);
	}

	@Override
	public void entityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		((EntityLivingBase) entityLivingBase).knockBack((Entity) entityLivingBase2, f, d, d1);
	}

	@Override
	public float entityLivingBaseLimbSwing(Object entity) {
		return ((EntityLivingBase) entity).limbSwing;
	}

	@Override
	public float entityLivingBaseLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).limbSwingAmount;
	}

	@Override
	public int entityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).maxHurtResistantTime;
	}

	@Override
	public int entityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).maxHurtTime;
	}

	@Override
	public float entityLivingBaseMoveForward(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveForward;
	}

	@Override
	public float entityLivingBaseMoveStrafing(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveStrafing;
	}

	@Override
	public void entityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		((EntityLivingBase) entityLivingBase).onDeath((DamageSource) damageSource);
	}

	@Override
	public float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).prevLimbSwingAmount;
	}

	@Override
	public float entityLivingBasePrevRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).prevRenderYawOffset;
	}

	@Override
	public float entityLivingBasePrevRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).prevRotationYawHead;
	}

	@Override
	public float entityLivingBaseRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).renderYawOffset;
	}

	@Override
	public float entityLivingBaseRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).rotationYawHead;
	}

	@Override
	public void entityLivingBaseSetHealth(Object entity, float f) {
		((EntityLivingBase) entity).setHealth(f);
	}

	@Override
	public void entityLivingBaseSetRevengeTarget(Object entityLivingBase, Object entityLivingBase2) {
		((EntityLivingBase) entityLivingBase).setRevengeTarget((EntityLivingBase) entityLivingBase2);
	}

	@Override
	public void entityLivingBaseHeal(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).heal(f);
	}

	@Override
	public boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase, null);
	}

	@Override
	public boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase, Object enumHand) {
		return ((Item) item).itemInteractionForEntity((ItemStack) itemstack, (EntityPlayer) entityplayer, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public void itemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		((ItemStack) itemstack).damageItem(i, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		((ModelBase) model).setLivingAnimations((EntityLivingBase) entity, f, f1, f2);
	}

	@Override
	public void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		((ModelBase) model).setRotationAngles(f, f1, f2, f3, f4, f5, (EntityLivingBase) entity);
	}

	@Override
	public InputStream resourceManagerInputStream(Object o) {
		if (Modchu_Main.isServer) return null;
		try {
			return Minecraft.getMinecraft().getResourceManager().getResource((ResourceLocation) o).getInputStream();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void setEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).attackedAtYaw = f;
	}

	@Override
	public void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).deathTime = i;
	}

	@Override
	public void setEntityLivingBaseHealth(Object entity, float f) {
		((EntityLivingBase) entity).getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(f, 0.0F, entityLivingGetMaxHealth(entity))));
	}

	@Override
	public void setEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).hurtTime = i;
	}

	@Override
	public void setEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).maxHurtResistantTime = i;
	}

	@Override
	public void setEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).maxHurtTime = i;
	}

	@Override
	public int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return TextureUtil.uploadTextureImage(i, (BufferedImage) bufferedimage);
	}

	@Override
	public void textureManagerBindTexture(Object textureManager, Object o) {
		if (o != null) ((TextureManager) textureManager).bindTexture((ResourceLocation) o);
	}

	@Override
	public Object textureManagerGetTexture(Object textureManager, Object o) {
		return ((TextureManager) textureManager).getTexture((ResourceLocation) o);
	}

	@Override
	public void entityLivingBaseSwingItem(Object entityLivingBase) {
		((EntityLivingBase) entityLivingBase).swingItem();
	}

	@Override
	public void entityLivingBaseSwingItem(Object entityLivingBase, Object enumHand) {
		entityLivingBaseSwingItem(entityLivingBase);
	}

	@Override
	public boolean entityHorseIsTame(Object entityHorse) {
		return entityHorse instanceof EntityHorse ? ((EntityHorse) entityHorse).isTame() : false;
	}

	@Override
	public void setEntityLivingBaseLimbSwing(Object entity, float f) {
		((EntityLivingBase) entity).limbSwing = f;
	}

	@Override
	public void setEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		((EntityLivingBase) entity).prevRenderYawOffset = f;
	}

	@Override
	public void setEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		((EntityLivingBase) entity).prevRotationYawHead = f;
	}

	@Override
	public void setEntityLivingBaseRenderYawOffset(Object entity, float f) {
		((EntityLivingBase) entity).renderYawOffset = f;
	}

	@Override
	public void setEntityLivingBaseRotationYawHead(Object entity, float f) {
		((EntityLivingBase) entity).rotationYawHead = f;
	}

	@Override
	public void setEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		((EntityLivingBase) entity).prevLimbSwingAmount = f;
	}

	@Override
	public void setEntityLivingBaseMoveStrafing(Object entityplayer, float f) {
		((EntityLivingBase) entityplayer).moveStrafing = f;
	}

	@Override
	public void setEntityLivingBaseMoveForward(Object entityplayer, float f) {
		((EntityLivingBase) entityplayer).moveForward = f;
	}

	@Override
	public void setEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		((EntityLivingBase) entity).limbSwingAmount = f;
	}

	@Override
	public void entityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		((EntityLivingBase) entity).setPositionAndUpdate(x, y, z);
	}

	@Override
	public Object modelRightArm(Object model) {
		if (model != null); else return null;
		if (model instanceof ModelBase) {
			if (model instanceof ModelBiped) return modelBipedBipedRightArm(model);
			if (model instanceof ModelQuadruped) return modelQuadrupedLeg1(model);
			if (model instanceof ModelBat) return modelBatBatRightWing(model);
			if (model instanceof ModelChicken) return modelChickenRightWing(model);
			if (model instanceof ModelCreeper) return modelCreeperLeg1(model);
			if (model instanceof ModelHorse) return modelHorseFrontRightLeg(model);
			if (model instanceof ModelIronGolem) return modelIronGolemIronGolemRightArm(model);
			if (model instanceof ModelOcelot) return modelOcelotOcelotFrontRightLeg(model);
			if (model instanceof ModelSnowMan) return modelSnowManRightHand(model);
			if (model instanceof ModelSpider) return modelSpiderSpiderLeg1(model);
			if (model instanceof ModelWolf) return modelWolfWolfLeg1(model);
			if (model instanceof ModelSquid) {
				Object[] o = modelSquidSquidTentacles(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
			if (model instanceof ModelBlaze) {
				Object[] o = modelBlazeBlazeSticks(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
			if (model instanceof ModelGhast) {
				Object[] o = modelGhastTentacles(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
		}
		return Modchu_Reflect.getFieldObject(model.getClass(), "bipedRightArm", model, -1);
	}

	@Override
	public String resourceLocationGetResourceDomain(Object resourceLocation) {
		return ((ResourceLocation) resourceLocation).getResourceDomain();
	}

	@Override
	public String resourceLocationGetResourcePath(Object resourceLocation) {
		return ((ResourceLocation) resourceLocation).getResourcePath();
	}

	@Override
	public Object entityLivingBaseGetLook(Object entityLivingBase, float f) {
		return ((EntityLivingBase) entityLivingBase).getLook(f);
	}

	@Override
	public Object sharedMonsterAttributesAttackDamage() {
		return SharedMonsterAttributes.attackDamage;
	}

	@Override
	public double attributeModifierGetAmount(Object attributeModifier) {
		return ((AttributeModifier) attributeModifier).getAmount();
	}

	@Override
	public Object abstractClientPlayerLocationSkin(Object entity) {
		return ((AbstractClientPlayer) entity).getLocationSkin();
	}

	@Override
	public boolean entityLivingBaseIsSwingInProgress(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).isSwingInProgress;
	}

	@Override
	public void setEntityLivingBaseIsSwingInProgress(Object entityLivingBase, boolean b) {
		((EntityLivingBase) entityLivingBase).isSwingInProgress = b;
	}

	@Override
	public boolean entityAttackEntityFrom(Object entity, Object damageSource, float f) {
		return ((Entity) entity).attackEntityFrom((DamageSource) damageSource, f);
	}

	@Override
	public Object guiOptionsBackground() {
		return Gui.optionsBackground;
	}

	@Override
	public void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		((GuiSlot) guiSlot).registerScrollButtons(i, i2);
	}

	@Override
	public boolean isMac() {
		return Minecraft.isRunningOnMac;
	}

	@Override
	public Object minecraftGatSession() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getSession();
	}

	@Override
	public Object minecraftGetTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getTextureManager();
	}

	@Override
	public int threadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return ((ThreadDownloadImageData) threadDownloadImageData).getGlTextureId();
	}

	@Override
	public Multimap itemStackGetAttributeModifiers(Object itemStack) {
		return ((ItemStack) itemStack).getAttributeModifiers();
	}

	@Override
	public Object textureMapLocationBlocksTexture() {
		return TextureMap.locationBlocksTexture;
	}

	@Override
	public boolean entityLivingGetLeashed(Object entityLiving) {
		return ((EntityLiving) entityLiving).getLeashed();
	}

	@Override
	public Object minecraftGetResourceManager() {
		return ((Minecraft) minecraftGetMinecraft()).getResourceManager();
	}
	// 172~189
	@Override
	public boolean isPlanterCheck(Object itemStackOrBlockOrItem) {
		itemStackOrBlockOrItem = itemStackOrBlockOrItem instanceof ItemStack ? getBlock(itemStackOrBlockOrItem) : itemStackOrBlockOrItem;
		return itemStackOrBlockOrItem instanceof BlockFlower
				| itemStackOrBlockOrItem instanceof BlockDoublePlant
				| itemStackOrBlockOrItem instanceof BlockMushroom
				| itemStackOrBlockOrItem instanceof BlockSapling
				| itemStackOrBlockOrItem instanceof BlockTallGrass;
	}

	@Override
	public void playerControllerSetGameType(Object enumGameType) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().playerController.setGameType((GameType) enumGameType);
	}

	@Override
	public void printChatMessage(String s) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(s));
	}

	@Override
	public InputStream resourceGetInputStream(Object resource) {
		return ((IResource) resource).getInputStream();
	}

	@Override
	public void framebufferBindFramebuffer(Object framebuffer, boolean b) {
		((Framebuffer) framebuffer).bindFramebuffer(b);
	}

	@Override
	public void framebufferUnbindFramebuffer(Object framebuffer) {
		((Framebuffer) framebuffer).unbindFramebuffer();
	}

	@Override
	public void framebufferFramebufferRender(Object framebuffer, int i, int i1) {
		((Framebuffer) framebuffer).framebufferRender(i, i1);
	}

	@Override
	public void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netHandlerPlayServer) {
		((EntityPlayerMP) entityplayerMP).playerNetServerHandler = (NetHandlerPlayServer) netHandlerPlayServer;
	}

	@Override
	public String iAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return ((IAttribute) iAttribute).getAttributeUnlocalizedName();
	}

	@Override
	public void setMinecraftLoadingScreen(Object loadingScreenRenderer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().loadingScreen = (LoadingScreenRenderer) loadingScreenRenderer;
	}

	@Override
	public void loadingScreenResetProgressAndMessage(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).resetProgressAndMessage(s);
	}

	@Override
	public void loadingScreenSetLoadingProgress(Object loadingScreenRenderer, int i) {
		((LoadingScreenRenderer) loadingScreenRenderer).setLoadingProgress(i);
	}

	@Override
	public Object resourceManagerGetResource(Object resourceManager, Object o) {
		try {
			return ((IResourceManager) resourceManager).getResource((ResourceLocation) o);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object biomeBirchForest() {
		return BiomeGenBase.birchForest;
	}

	@Override
	public Object biomeBirchForestHills() {
		return BiomeGenBase.birchForestHills;
	}

	@Override
	public Object biomeColdTaiga() {
		return BiomeGenBase.coldTaiga;
	}

	@Override
	public Object biomeColdTaigaHills() {
		return BiomeGenBase.coldTaigaHills;
	}

	@Override
	public Object biomeDeepOcean() {
		return BiomeGenBase.deepOcean;
	}

	@Override
	public Object biomeExtremeHillsPlus() {
		return BiomeGenBase.extremeHillsPlus;
	}

	@Override
	public Object biomeJungleEdge() {
		return BiomeGenBase.jungleEdge;
	}

	@Override
	public Object biomeMegaTaiga() {
		return BiomeGenBase.megaTaiga;
	}

	@Override
	public Object biomeMegaTaigaHills() {
		return BiomeGenBase.megaTaigaHills;
	}

	@Override
	public Object biomeMesa() {
		return BiomeGenBase.mesa;
	}

	@Override
	public Object biomeMesaPlateau() {
		return BiomeGenBase.mesaPlateau;
	}

	@Override
	public Object biomeMesaPlateau_F() {
		return BiomeGenBase.mesaPlateau_F;
	}

	@Override
	public Object biomeStoneBeach() {
		return BiomeGenBase.stoneBeach;
	}

	@Override
	public Object biomeStoneColdBeach() {
		return BiomeGenBase.coldBeach;
	}

	@Override
	public Object biomeRoofedForest() {
		return BiomeGenBase.roofedForest;
	}

	@Override
	public Object biomeSavanna() {
		return BiomeGenBase.savanna;
	}

	@Override
	public Object biomeSavannaPlateau() {
		return BiomeGenBase.savannaPlateau;
	}

	@Override
	public Object blockGetBlockFromItem(Object item) {
		if (item != null); else return null;
		return Block.getBlockFromItem((Item) item);
	}

	@Override
	public int entityEntityID(Object entity) {
		return ((Entity) entity).getEntityId();
	}

	@Override
	public Object entityLivingBaseGetEquipmentInSlot(Object entityLivingBase, Object dataParameterOrInt) {
		return ((EntityLivingBase) entityLivingBase).getEquipmentInSlot((Integer) dataParameterOrInt);
	}

	@Override
	public boolean guiButtonVisible(Object guiButton) {
		return ((GuiButton) guiButton).visible;
	}

	@Override
	public String keyBindingKeyCategory(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyCategory() : null;
	}

	@Override
	public int keyBindingKeyCode(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyCode() : -1;
	}

	@Override
	public String keyBindingKeyDescription(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyDescription() : null;
	}

	@Override
	public Object newInstanceKeyBinding(String s, int i, String s2) {
		return new KeyBinding(s, i, s2);
	}

	@Override
	public boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return ((RenderManager) renderManagerInstance()).renderEntityWithPosYaw((Entity) entity, d, d2, d3, f, f2);
	}

}