package modchu.lib.modloader.mc152;

import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_ASBasis;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.BlockLeaves;
import net.minecraft.src.BlockMushroom;
import net.minecraft.src.BlockPumpkin;
import net.minecraft.src.BlockSapling;
import net.minecraft.src.BlockTallGrass;
import net.minecraft.src.Container;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.DamageSource;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityAITasks;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBat;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityFishHook;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.EnumFacing;
import net.minecraft.src.EnumGameType;
import net.minecraft.src.EnumOS;
import net.minecraft.src.Facing;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.IconRegister;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.LoadingScreenRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelBat;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.ModelBlaze;
import net.minecraft.src.ModelChicken;
import net.minecraft.src.ModelCreeper;
import net.minecraft.src.ModelGhast;
import net.minecraft.src.ModelIronGolem;
import net.minecraft.src.ModelOcelot;
import net.minecraft.src.ModelQuadruped;
import net.minecraft.src.ModelRenderer;
import net.minecraft.src.ModelSnowMan;
import net.minecraft.src.ModelSpider;
import net.minecraft.src.ModelSquid;
import net.minecraft.src.ModelWolf;
import net.minecraft.src.MovementInput;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.NetServerHandler;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Packet205ClientCommand;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.PlayerControllerMP;
import net.minecraft.src.PositionTextureVertex;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.RenderManager;
import net.minecraft.src.RenderPlayer;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.ServerConfigurationManager;
import net.minecraft.src.Slot;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TextureOffset;
import net.minecraft.src.TexturedQuad;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySkullRenderer;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class Modchu_ASMaster extends Modchu_ASBasis {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public Object abstractClientPlayerGetTextureCape(Object entity) {
		return null;
	}

	@Override
	public Object abstractClientPlayerGetTextureSkin(Object entity) {
		return null;
	}

	@Override
	public Object axisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return ((AxisAlignedBB) axisAlignedBB).expand(d, d1, d2);
	}

	@Override
	public Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return AxisAlignedBB.getBoundingBox(d, d1, d2, d3, d4, d5);
	}

	@Override
	public Object biomeBeach() {
		return BiomeGenBase.beach;
	}

	@Override
	public Object biomeBirchForest() {
		return BiomeGenBase.forest;
	}

	@Override
	public Object biomeBirchForestHills() {
		return BiomeGenBase.forestHills;
	}

	@Override
	public Object biomeColdTaiga() {
		return BiomeGenBase.taiga;
	}

	@Override
	public Object biomeColdTaigaHills() {
		return BiomeGenBase.taigaHills;
	}

	@Override
	public Object biomeDeepOcean() {
		return BiomeGenBase.ocean;
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
	public Object biomeExtremeHillsPlus() {
		return BiomeGenBase.extremeHills;
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
	public Object biomeJungleEdge() {
		return BiomeGenBase.jungle;
	}

	@Override
	public Object biomeJungleHills() {
		return BiomeGenBase.jungleHills;
	}

	@Override
	public Object biomeMegaTaiga() {
		return BiomeGenBase.taiga;
	}

	@Override
	public Object biomeMegaTaigaHills() {
		return BiomeGenBase.taigaHills;
	}

	@Override
	public Object biomeMesa() {
		return null;
	}

	@Override
	public Object biomeMesaPlateau() {
		return null;
	}

	@Override
	public Object biomeMesaPlateau_F() {
		return null;
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
	public Object biomeRoofedForest() {
		return BiomeGenBase.forest;
	}

	@Override
	public Object biomeSavanna() {
		return null;
	}

	@Override
	public Object biomeSavannaPlateau() {
		return null;
	}

	@Override
	public Object biomeSky() {
		return BiomeGenBase.sky;
	}

	@Override
	public Object biomeStoneBeach() {
		return BiomeGenBase.beach;
	}

	@Override
	public Object biomeStoneColdBeach() {
		return BiomeGenBase.beach;
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
	public Object[] blockBlockList() {
		return Block.blocksList;
	}

	@Override
	public Object blockGetBlockFromItem(Object item) {
		if (item != null) ;else return null;
		int itemID = ((Item) item).itemID;
		return itemID < Block.blocksList.length ? Block.blocksList[itemID] : null;
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
	public Object damageSourceCauseMobDamage(Object entityLivingBase) {
		return DamageSource.causeMobDamage((EntityLiving) entityLivingBase);
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
	public void dataManagerAddObject(Object dataManagerOrEntity, Object i, Object o) {
		((DataWatcher) entityGetDataWatcher(dataManagerOrEntity)).addObject((Integer) i, o);
	}

	@Override
	public byte dataManagerGetWatchableObjectByte(Object dataManagerOrEntity, Object i) {
		return ((DataWatcher) entityGetDataWatcher(dataManagerOrEntity)).getWatchableObjectByte((Integer) i);
	}

	@Override
	public Object dataManagerGetWatchableObjectItemStack(Object dataManagerOrEntity, Object i) {
		return ((DataWatcher) entityGetDataWatcher(dataManagerOrEntity)).getWatchableObjectItemStack((Integer) i);
	}

	@Override
	public void dataManagerUpdateObject(Object dataManagerOrEntity, Object i, Object o) {
		DataWatcher dataManager = ((DataWatcher) entityGetDataWatcher(dataManagerOrEntity));
		if (dataManagerGetWatchedObject(dataManagerOrEntity, i) != null) dataManager.updateObject((Integer) i, o);
		else dataManager.addObject((Integer) i, o);
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
	public boolean entityAttackEntityFrom(Object entity, Object damageSource, float f) {
		return ((Entity) entity).attackEntityFrom((DamageSource) damageSource, (int) f);
	}

	@Override
	public Object entityBoundingBox(Object entity) {
		return ((Entity) entity).boundingBox;
	}

	@Override
	public double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxX;
	}

	@Override
	public double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxY;
	}

	@Override
	public double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxZ;
	}

	@Override
	public double entityBoundingBoxMinX(Object entity) {
		return ((Entity) entity).boundingBox.minX;
	}

	@Override
	public double entityBoundingBoxMinY(Object entity) {
		return ((Entity) entity).boundingBox.minY;
	}

	@Override
	public double entityBoundingBoxMinZ(Object entity) {
		return ((Entity) entity).boundingBox.minZ;
	}

	@Override
	public String entityCloakUrl(Object entity) {
		return null;
	}

	@Override
	public Object entityCreatureGetEntityToAttack(Object entityCreature) {
		return ((EntityCreature) entityCreature).getEntityToAttack();
	}

	@Override
	public void entityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
		((EntityCreature) entityCreature).setPathToEntity((PathEntity) entityPath);
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
	public int entityEntityID(Object entity) {
		return ((Entity) entity).entityId;
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
	public float entityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).attackedAtYaw;
	}

	@Override
	public int entityLivingBaseDeathTime(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).deathTime;
	}

	@Override
	public Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).getAITarget();
	}

	@Override
	public Object entityLivingBaseGetEquipmentInSlot(Object entityLivingBase, Object i) {
		return ((EntityLiving) entityLivingBase).getCurrentItemOrArmor((Integer) i);
	}

	@Override
	public float entityLivingBaseGetHealth(Object entity) {
		return ((EntityLiving) entity).getHealth();
	}

	@Override
	public Object entityLivingBaseGetHeldItem(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).getHeldItem();
	}

	@Override
	public float entityLivingBaseGetMaxHealth(Object entity) {
		return ((EntityLiving) entity).getMaxHealth();
	}

	@Override
	public float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return ((EntityLiving) entity).getSwingProgress(f);
	}

	@Override
	public int entityLivingBaseHurtTime(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).hurtTime;
	}

	@Override
	public boolean entityLivingBaseIsChild(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).isChild();
	}

	@Override
	public boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		if (potionOrPotionId instanceof Potion) return ((EntityLiving) entityLivingBase).isPotionActive((Potion) potionOrPotionId);
		return ((EntityLiving) entityLivingBase).isPotionActive((Integer) potionOrPotionId);
	}

	@Override
	public void entityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		((EntityLiving) entityLivingBase).knockBack((Entity) entityLivingBase2, (int) f, d, d1);
	}

	@Override
	public float entityLivingBaseLimbSwing(Object entity) {
		return ((EntityLiving) entity).limbSwing;
	}

	@Override
	public float entityLivingBaseLimbSwingAmount(Object entity) {
		return ((EntityLiving) entity).limbYaw;
	}

	@Override
	public int entityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).maxHurtResistantTime;
	}

	@Override
	public int entityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).maxHurtTime;
	}

	@Override
	public void entityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		((EntityLiving) entityLivingBase).onDeath((DamageSource) damageSource);
	}

	@Override
	public float entityLivingBasePrevHealth(Object entityLivingBase) {
		return ((EntityLiving) entityLivingBase).prevHealth;
	}

	@Override
	public float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return ((EntityLiving) entity).prevLimbYaw;
	}

	@Override
	public float entityLivingBasePrevRenderYawOffset(Object entity) {
		return ((EntityLiving) entity).prevRenderYawOffset;
	}

	@Override
	public float entityLivingBasePrevRotationYawHead(Object entity) {
		return ((EntityLiving) entity).prevRotationYawHead;
	}

	@Override
	public float entityLivingBaseRenderYawOffset(Object entity) {
		return ((EntityLiving) entity).renderYawOffset;
	}

	@Override
	public float entityLivingBaseRotationYawHead(Object entity) {
		return ((EntityLiving) entity).rotationYawHead;
	}

	@Override
	public void entityLivingBaseSetHealth(Object entity, float f) {
		((EntityLiving) entity).setEntityHealth((int) f);
	}

	@Override
	public void entityLivingBaseSetRevengeTarget(Object entityLivingBase, Object entityLivingBase2) {
		((EntityLiving) entityLivingBase).setRevengeTarget((EntityLiving) entityLivingBase2);
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
	public void entityLivingBaseHeal(Object entityLivingBase, float f) {
		((EntityLiving) entityLivingBase).heal((int) f);
	}

	@Override
	public double entityPlayerChasingPosZ(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71085_bR;
	}

	@Override
	public double entityPlayerPrevChasingPosX(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71091_bM;
	}

	@Override
	public double entityPlayerChasingPosX(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71094_bP;
	}

	@Override
	public double entityPlayerChasingPosY(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71095_bQ;
	}

	@Override
	public double entityPlayerPrevChasingPosY(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71096_bN;
	}

	@Override
	public double entityPlayerPrevChasingPosZ(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71097_bO;
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
	public boolean entityPlayerGetHideCape(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getHideCape();
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
	public int entityPlayerInventoryCurrentItem(Object entityplayer) {
		return ((InventoryPlayer) entityPlayerInventory(entityplayer)).currentItem;
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
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
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
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
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
	public void entityPlayerSPFunc_6420_o(Object entityplayer) {
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
	public String entityTameableGetOwnerName(Object entityTameable) {
		return ((EntityTameable) entityTameable).getOwnerName();
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
	public Object entityWorldObj(Object worldOrEntity) {
		return worldOrEntity instanceof World ? worldOrEntity : worldOrEntity instanceof Entity ? ((Entity) worldOrEntity).worldObj : null;
	}

	@Override
	public float entityYOffset(Object entity) {
		return ((Entity) entity).yOffset;
	}

	@Override
	public Enum enumActionBlock() {
		return EnumAction.block;
	}

	@Override
	public Enum enumActionBow() {
		return EnumAction.bow;
	}

	@Override
	public Enum enumActionDrink() {
		return EnumAction.drink;
	}

	@Override
	public Enum enumActionEat() {
		return EnumAction.eat;
	}

	@Override
	public Enum enumActionNone() {
		return EnumAction.none;
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
	public Enum enumCreatureTypeAmbient() {
		return EnumCreatureType.ambient;
	}

	@Override
	public Enum enumCreatureTypeCreature() {
		return EnumCreatureType.creature;
	}

	@Override
	public Enum enumCreatureTypeMonster() {
		return EnumCreatureType.monster;
	}

	@Override
	public Enum enumCreatureTypeWaterCreature() {
		return EnumCreatureType.waterCreature;
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
		if (itemstack != null) ;else return null;
		return blockGetBlockFromItem(itemStackGetItem(itemstack));
	}

	@Override
	public Object getItem(String s) {
		if (s != null) ;else return null;
		if (!base.initOldVersionItemMap) {
			base.oldVersionItemMap = new ConcurrentHashMap();
			String[] s1 = new String[]{
					"iron_shovel",
					"iron_pickaxe",
					"iron_axe",
					"flint_and_steel",
					"apple",
					"bow",
					"arrow",
					"coal",
					"diamond",
					"iron_ingot",
					"gold_ingot",
					"iron_sword",
					"wooden_sword",
					"wooden_shovel",
					"wooden_pickaxe",
					"wooden_axe",
					"stone_sword",
					"stone_shovel",
					"stone_pickaxe",
					"stone_axe",
					"diamond_sword",
					"diamond_shovel",
					"diamond_pickaxe",
					"diamond_axe",
					"stick",
					"bowl",
					"mushroom_stew",
					"golden_sword",
					"golden_shovel",
					"golden_pickaxe",
					"golden_axe",
					"string",
					"feather",
					"gunpowder",
					"wooden_hoe",
					"stone_hoe",
					"iron_hoe",
					"diamond_hoe",
					"golden_hoe",
					"wheat_seeds",
					"wheat",
					"bread",
					"leather_helmet",
					"leather_chestplate",
					"leather_leggings",
					"leather_boots",
					"chainmail_helmet",
					"chainmail_chestplate",
					"chainmail_leggings",
					"chainmail_boots",
					"iron_helmet",
					"iron_chestplate",
					"iron_leggings",
					"iron_boots",
					"diamond_helmet",
					"diamond_chestplate",
					"diamond_leggings",
					"diamond_boots",
					"golden_helmet",
					"golden_chestplate",
					"golden_leggings",
					"golden_boots",
					"flint",
					"porkchop",
					"cooked_porkchop",
					"painting",
					"golden_apple",
					"sign",
					"wooden_door",
					"bucket",
					"water_bucket",
					"lava_bucket",
					"minecart",
					"saddle",
					"iron_door",
					"redstone",
					"snowball",
					"boat",
					"leather",
					"milk_bucket",
					"brick",
					"clay_ball",
					"reeds",
					"paper",
					"book",
					"slime_ball",
					"chest_minecart",
					"furnace_minecart",
					"egg",
					"compass",
					"fishing_rod",
					"clock",
					"glowstone_dust",
					"fish",
					"cooked_fished",
					"dye",
					"bone",
					"sugar",
					"cake",
					"bed",
					"repeater",
					"cookie",
					"filled_map",
					"shears",
					"melon",
					"pumpkin_seeds",
					"melon_seeds",
					"beef",
					"cooked_beef",
					"chicken",
					"cooked_chicken",
					"rotten_flesh",
					"ender_pearl",
					"blaze_rod",
					"ghast_tear",
					"gold_nugget",
					"nether_wart",
					"potionitem",
					"glass_bottle",
					"spider_eye",
					"fermented_spider_eye",
					"blaze_powder",
					"magma_cream",
					"brewing_stand",
					"cauldron",
					"ender_eye",
					"speckled_melon",
					"spawn_egg",
					"experience_bottle",
					"fire_charge",
					"writable_book",
					"written_book",
					"emerald",
					"item_frame",
					"flower_pot",
					"carrot",
					"potato",
					"baked_potato",
					"poisonous_potato",
					"map",
					"golden_carrot",
					"skull",
					"carrot_on_a_stick",
					"nether_star",
					"pumpkin_pie",
					"fireworks",
					"firework_charge",
					"enchanted_book",
					"comparator",
					"netherbrick",
					"quartz",
					"tnt_minecart",
					"hopper_minecart",
					"iron_horse_armor",
					"golden_horse_armor",
					"diamond_horse_armor",
					"lead",
					"name_tag",
					"record_13",
					"record_cat",
					"record_blocks",
					"record_chirp",
					"record_far",
					"record_mall",
					"record_mellohi",
					"record_stal",
					"record_strad",
					"record_ward",
					"record_11",
					"record_wait",
			};
			Object[] s2 = new Object[]{
					Item.shovelIron,
					Item.pickaxeIron,
					Item.axeIron,
					Item.flintAndSteel,
					Item.appleRed,
					Item.bow,
					Item.arrow,
					Item.coal,
					Item.diamond,
					Item.ingotIron,
					Item.ingotGold,
					Item.swordIron,
					Item.swordWood,
					Item.shovelWood,
					Item.pickaxeWood,
					Item.axeWood,
					Item.swordStone,
					Item.shovelStone,
					Item.pickaxeStone,
					Item.axeStone,
					Item.swordDiamond,
					Item.shovelDiamond,
					Item.pickaxeDiamond,
					Item.axeDiamond,
					Item.stick,
					Item.bowlEmpty,
					Item.bowlSoup,
					Item.swordGold,
					Item.shovelGold,
					Item.pickaxeGold,
					Item.axeGold,
					Item.silk,
					Item.feather,
					Item.gunpowder,
					Item.hoeWood,
					Item.hoeStone,
					Item.hoeIron,
					Item.hoeDiamond,
					Item.hoeGold,
					Item.seeds,
					Item.wheat,
					Item.bread,
					Item.helmetLeather,
					Item.plateLeather,
					Item.legsLeather,
					Item.bootsLeather,
					Item.helmetChain,
					Item.plateChain,
					Item.legsChain,
					Item.bootsChain,
					Item.helmetIron,
					Item.plateIron,
					Item.legsIron,
					Item.bootsIron,
					Item.helmetDiamond,
					Item.plateDiamond,
					Item.legsDiamond,
					Item.bootsDiamond,
					Item.helmetGold,
					Item.plateGold,
					Item.legsGold,
					Item.bootsGold,
					Item.flint,
					Item.porkRaw,
					Item.porkCooked,
					Item.painting,
					Item.appleGold,
					Item.sign,
					Item.doorWood,
					Item.bucketEmpty,
					Item.bucketWater,
					Item.bucketLava,
					Item.minecartEmpty,
					Item.saddle,
					Item.doorIron,
					Item.redstone,
					Item.snowball,
					Item.boat,
					Item.leather,
					Item.bucketMilk,
					Item.brick,
					Item.clay,
					Item.reed,
					Item.paper,
					Item.book,
					Item.slimeBall,
					Item.minecartCrate,
					Item.minecartPowered,
					Item.egg,
					Item.compass,
					Item.fishingRod,
					Item.pocketSundial,
					Item.lightStoneDust,
					Item.fishRaw,
					Item.fishCooked,
					Item.dyePowder,
					Item.bone,
					Item.sugar,
					Item.cake,
					Item.bed,
					Item.redstoneRepeater,
					Item.cookie,
					Item.map,
					Item.shears,
					Item.melon,
					Item.pumpkinSeeds,
					Item.melonSeeds,
					Item.beefRaw,
					Item.beefCooked,
					Item.chickenRaw,
					Item.chickenCooked,
					Item.rottenFlesh,
					Item.enderPearl,
					Item.blazeRod,
					Item.ghastTear,
					Item.goldNugget,
					Item.netherStalkSeeds,
					Item.potion,
					Item.glassBottle,
					Item.spiderEye,
					Item.fermentedSpiderEye,
					Item.blazePowder,
					Item.magmaCream,
					Item.brewingStand,
					Item.cauldron,
					Item.eyeOfEnder,
					Item.speckledMelon,
					Item.monsterPlacer,
					Item.expBottle,
					Item.fireballCharge,
					Item.writableBook,
					Item.writtenBook,
					Item.emerald,
					Item.itemFrame,
					Item.flowerPot,
					Item.carrot,
					Item.potato,
					Item.bakedPotato,
					Item.poisonousPotato,
					Item.map,
					Item.goldenCarrot,
					Item.skull,
					Item.carrotOnAStick,
					Item.netherStar,
					Item.pumpkinPie,
					Item.firework,
					Item.fireworkCharge,
					Item.enchantedBook,
					Item.comparator,
					Item.netherrackBrick,
					Item.netherQuartz,
					Item.minecartTnt,
					Item.minecartHopper,
					null,//Item.horseArmorIron,
					null,//Item.horseArmorGold,
					null,//Item.horseArmorDiamond,
					null,//Item.leash,
					null,//Item.nameTag,
					Item.record13,
					Item.recordCat,
					Item.recordBlocks,
					Item.recordChirp,
					Item.recordFar,
					Item.recordMall,
					Item.recordMellohi,
					Item.recordStal,
					Item.recordStrad,
					Item.recordWard,
					Item.record11,
					Item.recordWait,
			};
			for(int i = 0; i < s1.length
					&& i < s2.length; i++) {
				if (s1[i] != null
						&& s2[i] != null) base.oldVersionItemMap.put(s1[i], s2[i]);
			}
			base.initOldVersionItemMap = true;
		}
		if (!base.oldVersionItemMap.containsKey(s)) {
			String s1 = s.toLowerCase();
			if (!base.oldVersionItemMap.containsKey(s1)) {
				Modchu_Main.setRuntimeException("oldVersionItemMap s="+s+" is null !!");
				return null;
			}
			return base.oldVersionItemMap.get(s1);
		}
		return base.oldVersionItemMap.get(s);
	}

	@Override
	public Object getBlock(String s) {
		if (s != null) ;else return null;
		if (!base.initOldVersionBlockMap) {
			base.oldVersionBlockMap = new ConcurrentHashMap();
			String[] s1 = new String[]{
					"air",
					"stone",
					"grass",
					"dirt",
					"cobblestone",
					"planks",
					"sapling",
					"bedrock",
					"flowing_water",
					"water",
					"flowing_lava",
					"lava",
					"sand",
					"gravel",
					"gold_ore",
					"iron_ore",
					"coal_ore",
					"log",
					"log2",
					"leaves",
					"leaves2",
					"sponge",
					"glass",
					"lapis_ore",
					"lapis_block",
					"dispenser",
					"sandstone",
					"noteblock",
					"bed",
					"golden_rail",
					"detector_rail",
					"sticky_piston",
					"web",
					"tallgrass",
					"deadbush",
					"piston",
					"piston_head",
					"wool",
					"piston_extension",
					"yellow_flower",
					"red_flower",
					"brown_mushroom",
					"red_mushroom",
					"gold_block",
					"iron_block",
					"double_stone_slab",
					"stone_slab",
					"brick_block",
					"tnt",
					"bookshelf",
					"mossy_cobblestone",
					"obsidian",
					"torch",
					"fire",
					"mob_spawner",
					"oak_stairs",
					"chest",
					"redstone_wire",
					"diamond_ore",
					"diamond_block",
					"crafting_table",
					"wheat",
					"farmland",
					"furnace",
					"lit_furnace",
					"standing_sign",
					"wooden_door",
					"ladder",
					"rail",
					"stone_stairs",
					"wall_sign",
					"lever",
					"stone_pressure_plate",
					"iron_door",
					"wooden_pressure_plate",
					"redstone_ore",
					"lit_redstone_ore",
					"unlit_redstone_torch",
					"redstone_torch",
					"stone_button",
					"snow_layer",
					"ice",
					"snow",
					"cactus",
					"clay",
					"reeds",
					"jukebox",
					"fence",
					"pumpkin",
					"netherrack",
					"soul_sand",
					"glowstone",
					"portal",
					"lit_pumpkin",
					"cake",
					"unpowered_repeater",
					"powered_repeater",
					"trapdoor",
					"monster_egg",
					"stonebrick",
					"brown_mushroom_block",
					"red_mushroom_block",
					"iron_bars",
					"glass_pane",
					"melon_block",
					"pumpkin_stem",
					"melon_stem",
					"vine",
					"fence_gate",
					"brick_stairs",
					"stone_brick_stairs",
					"mycelium",
					"waterlily",
					"nether_brick",
					"nether_brick_fence",
					"nether_brick_stairs",
					"nether_wart",
					"enchanting_table",
					"brewing_stand",
					"cauldron",
					"end_portal",
					"end_portal_frame",
					"end_stone",
					"dragon_egg",
					"redstone_lamp",
					"lit_redstone_lamp",
					"double_wooden_slab",
					"wooden_slab",
					"cocoa",
					"sandstone_stairs",
					"emerald_ore",
					"ender_chest",
					"tripwire_hook",
					"tripwire",
					"emerald_block",
					"spruce_stairs",
					"birch_stairs",
					"jungle_stairs",
					"command_block",
					"beacon",
					"cobblestone_wall",
					"flower_pot",
					"carrots",
					"potatoes",
					"wooden_button",
					"skull",
					"anvil",
					"trapped_chest",
					"light_weighted_pressure_plate",
					"heavy_weighted_pressure_plate",
					"unpowered_comparator",
					"powered_comparator",
					"daylight_detector",
					"redstone_block",
					"quartz_ore",
					"hopper",
					"quartz_block",
					"quartz_stairs",
					"activator_rail",
					"dropper",
					"stained_hardened_clay",
					"hay_block",
					"carpet",
					"hardened_clay",
					"coal_block",
					"packed_ice",
					"acacia_stairs",
					"dark_oak_stairs",
					"double_plant",
					"stained_glass",
					"stained_glass_pane"
			};
			Object[] s2 = new Object[]{
					Block.blocksList[0],
					Block.stone,
					Block.grass,
					Block.dirt,
					Block.cobblestone,
					Block.planks,
					Block.sapling,
					Block.bedrock,
					Block.waterMoving,
					Block.waterStill,
					Block.lavaMoving,
					Block.lavaStill,
					Block.sand,
					Block.gravel,
					Block.oreGold,
					Block.oreIron,
					Block.oreCoal,
					Block.wood,
					null,//Block.log2,
					Block.leaves,
					null,//Block.leaves2,
					Block.sponge,
					Block.glass,
					Block.oreLapis,
					Block.blockLapis,
					Block.dispenser,
					Block.sandStone,
					Block.music,
					Block.bed,
					Block.railPowered,
					Block.railDetector,
					Block.pistonStickyBase,
					Block.web,
					Block.tallGrass,
					Block.deadBush,
					Block.pistonBase,
					Block.pistonExtension,
					Block.cloth,
					Block.pistonMoving,
					Block.plantYellow,
					Block.plantRed,
					Block.mushroomBrown,
					Block.mushroomRed,
					Block.blockGold,
					Block.blockIron,
					Block.stoneDoubleSlab,
					Block.stoneSingleSlab,
					Block.brick,
					Block.tnt,
					Block.bookShelf,
					Block.cobblestoneMossy,
					Block.obsidian,
					Block.torchWood,
					Block.fire,
					Block.mobSpawner,
					Block.stairsWoodOak,
					Block.chest,
					Block.redstoneWire,
					Block.oreDiamond,
					Block.blockDiamond,
					Block.workbench,
					Block.crops,
					Block.tilledField,
					Block.furnaceIdle,
					Block.furnaceBurning,
					Block.signPost,
					Block.doorWood,
					Block.ladder,
					Block.rail,
					Block.stairsCobblestone,
					Block.signWall,
					Block.lever,
					Block.pressurePlateStone,
					Block.doorIron,
					Block.pressurePlatePlanks,
					Block.oreRedstone,
					Block.oreRedstoneGlowing,
					Block.torchRedstoneIdle,
					Block.torchRedstoneActive,
					Block.stoneButton,
					Block.blockSnow,
					Block.ice,
					Block.snow,
					Block.cactus,
					Block.blockClay,
					Block.reed,
					Block.jukebox,
					Block.fence,
					Block.pumpkin,
					Block.netherrack,
					Block.slowSand,
					Block.glowStone,
					Block.portal,
					Block.pumpkinLantern,
					Block.cake,
					Block.redstoneRepeaterIdle,
					Block.redstoneRepeaterActive,
					Block.trapdoor,
					null,//Block.monster_egg,
					Block.stoneBrick,
					Block.mushroomCapBrown,
					Block.mushroomCapRed,
					Block.fenceIron,
					Block.thinGlass,
					Block.melon,
					Block.pumpkinStem,
					Block.melonStem,
					Block.vine,
					Block.fenceGate,
					Block.stairsBrick,
					Block.stairsStoneBrick,
					Block.mycelium,
					Block.waterlily,
					Block.netherBrick,
					Block.netherFence,
					Block.stairsNetherBrick,
					Block.netherStalk,
					Block.enchantmentTable,
					Block.brewingStand,
					Block.cauldron,
					Block.endPortal,
					Block.endPortalFrame,
					Block.whiteStone,
					Block.dragonEgg,
					Block.redstoneLampIdle,
					Block.redstoneLampActive,
					Block.woodDoubleSlab,
					Block.woodSingleSlab,
					Block.cocoaPlant,
					Block.stairsSandStone,
					Block.oreEmerald,
					Block.enderChest,
					Block.tripWireSource,
					Block.tripWire,
					Block.blockEmerald,
					Block.stairsWoodSpruce,
					Block.stairsWoodBirch,
					Block.stairsWoodJungle,
					Block.commandBlock,
					Block.beacon,
					Block.cobblestoneWall,
					Block.flowerPot,
					Block.carrot,
					Block.potato,
					Block.woodenButton,
					Block.skull,
					Block.anvil,
					Block.chestTrapped,
					Block.pressurePlateGold,
					Block.redstoneComparatorIdle,
					Block.redstoneComparatorIdle,
					Block.redstoneComparatorActive,
					Block.daylightSensor,
					Block.blockRedstone,
					Block.oreNetherQuartz,
					Block.hopperBlock,
					Block.blockNetherQuartz,
					Block.stairsNetherQuartz,
					Block.railActivator,
					Block.dropper,
					null,//Block.stainedClay,
					null,//Block.hay,
					null,//Block.carpet,
					null,//Block.hardenedClay,
					null,//Block.coalBlock,
					null,//Block.packed_ice,
					null,//Block.acacia_stairs,
					null,//Block.dark_oak_stairs,
					null,//Block.double_plant,
					null,//Block.stained_glass,
					null//Block.stained_glass_pane,
			};
			for(int i = 0; i < s1.length
					&& i < s2.length; i++) {
				if (s1[i] != null
						&& s2[i] != null) base.oldVersionBlockMap.put(s1[i], s2[i]);
			}
			base.initOldVersionBlockMap = true;
		}
		if (!base.oldVersionBlockMap.containsKey(s)) {
			String s1 = s.toLowerCase();
			if (!base.oldVersionBlockMap.containsKey(s1)) {
				Modchu_Main.setRuntimeException("oldVersionBlockMap s="+s+" is null !!");
				return null;
			}
			return base.oldVersionBlockMap.get(s1);
		}
		return base.oldVersionBlockMap.get(s);
	}

	@Override
	public Object getResource(String s) {
		return getResource(Minecraft.class, s);
	}

	@Override
	public String getUserName(Object entityplayer) {
		return entityplayer instanceof EntityPlayer ? ((EntityPlayer) entityplayer).getCommandSenderName() : null;
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
	public boolean guiButtonVisible(Object guiButton) {
		return ((GuiButton) guiButton).drawButton;
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
	public void guiIngameDrawString(String s, int i, int j, int k) {
		if (Modchu_Main.isServer) return;
		Minecraft mc = Minecraft.getMinecraft();
		mc.ingameGUI.drawString(mc.fontRenderer, s, i, j, k);
	}

	@Override
	public Object guiOptionsBackground() {
		return null;
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
	public void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		((GuiSlot) guiSlot).registerScrollButtons(list, i, i2);
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
	public boolean isMac() {
		String var0 = System.getProperty("os.name").toLowerCase();
		EnumOS enumOS = var0.contains("win") ? EnumOS.WINDOWS : (var0.contains("mac") ? EnumOS.MACOS : (var0.contains("solaris") ? EnumOS.SOLARIS : (var0.contains("sunos") ? EnumOS.SOLARIS : (var0.contains("linux") ? EnumOS.LINUX : (var0.contains("unix") ? EnumOS.LINUX : EnumOS.UNKNOWN)))));
		return enumOS == EnumOS.MACOS;
	}

	@Override
	public boolean isMuiti() {
		if (Modchu_Main.isServer) return true;
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().getNetHandler() != null
				&& !Minecraft.getMinecraft().isSingleplayer() : true;
	}

	@Override
	public boolean isPlanterCheck(Object itemStackOrBlockOrItem) {
		itemStackOrBlockOrItem = itemStackOrBlockOrItem instanceof ItemStack ? getBlock(itemStackOrBlockOrItem) : itemStackOrBlockOrItem;
		return itemStackOrBlockOrItem instanceof BlockFlower
				| itemStackOrBlockOrItem instanceof BlockMushroom
				| itemStackOrBlockOrItem instanceof BlockSapling
				| itemStackOrBlockOrItem instanceof BlockTallGrass;
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
	public int itemItemID(Object item) {
		return ((Item) item).itemID;
	}

	@Override
	public boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase, null);
	}

	@Override
	public boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase, Object enumHand) {
		return ((Item) item).itemInteractionForEntity((ItemStack) itemstack, (EntityPlayer) entityplayer);
	}

	@Override
	public Object[] itemItemsList() {
		return Item.itemsList;
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
	public void itemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		((ItemStack) itemstack).damageItem(i, (EntityLiving) entityLivingBase);
	}

	@Override
	public Object itemStackGetItem(Object itemstack) {
		return ((ItemStack) itemstack).getItem();
	}

	@Override
	public int itemStackGetItemDamage(Object itemstack) {
		return ((ItemStack) itemstack).getItemDamage();
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
	public int itemStackItemID(Object itemstack) {
		return ((ItemStack) itemstack).itemID;
	}

	@Override
	public int itemStackStackSize(Object itemstack) {
		return ((ItemStack) itemstack).stackSize;
	}

	@Override
	public boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).pressed : null;
	}

	@Override
	public boolean keyBindingIsPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).isPressed() : null;
	}

	@Override
	public String keyBindingKeyCategory(Object keyBinding) {
		return null;
	}

	@Override
	public int keyBindingKeyCode(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).keyCode : -1;
	}

	@Override
	public String keyBindingKeyDescription(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).keyDescription : null;
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
	public Object minecraftFontRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().fontRenderer;
	}

	@Override
	public void minecraftFontRenderer(Object fontRenderer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().fontRenderer = (FontRenderer) fontRenderer;
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
	public Object minecraftGatSession() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().session;
	}

	@Override
	public Object minecraftGetMinecraft() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer();
		return Minecraft.getMinecraft();
	}

	@Override
	public long minecraftGetSystemTime() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer().getTickCounter();
		return Minecraft.getMinecraft().getSystemTime();
	}

	@Override
	public Object minecraftGetTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().renderEngine;
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
		Object thePlayer = minecraftThePlayer();
		minecraftSetDimensionAndSpawnPlayer(((Entity) thePlayer).dimension);
	}

	@Override
	public void minecraftSetDimensionAndSpawnPlayer(int i) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().setDimensionAndSpawnPlayer(i);
	}

	@Override
	public Object minecraftThePlayer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().thePlayer;
	}

	@Override
	public Object minecraftTheWorld() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer().worldServers[0];
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	public void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		((ModelBase) model).setLivingAnimations((EntityLiving) entity, f, f1, f2);
	}

	@Override
	public void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		((ModelBase) model).setRotationAngles(f, f1, f2, f3, f4, f5, (EntityLiving) entity);
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
	public Object newInstanceKeyBinding(String s, int i, String s2) {
		return new KeyBinding(s, i);
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
	public void playerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
		((PlayerControllerMP) playerController).setPlayerCapabilities((EntityPlayer) entityplayer);
	}

	@Override
	public void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
	}

	@Override
	public Object playerControllerMPCreatePlayer(Object playerController) {
		return ((PlayerControllerMP) playerController).func_78754_a((World) minecraftTheWorld());
	}

	@Override
	public void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		((PlayerControllerMP) playerController).flipPlayer((EntityPlayer) entityplayer);
	}

	@Override
	public void playerControllerSetGameType(Object enumGameType) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().playerController.setGameType((EnumGameType) enumGameType);
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
	public Object potionAbsorption() {
		return Potion.field_76444_x;
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
	public Object potionHealthBoost() {
		return Potion.field_76434_w;
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
	public Object potionSaturation() {
		return Potion.field_76443_y;
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
	public void printChatMessage(String s) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(s);
	}

	@Override
	public void renderBindTexture(Object render, Object resourceLocation) {
		try {
			Modchu_Reflect.invokeMethod("Render", "func_76985_a", "loadTexture", new Class[]{ String.class }, render, new Object[]{ resourceLocation });
		} catch(Exception e) {
		}
	}

	@Override
	public void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		((RenderBlocks) renderBlocks).renderBlockAllFaces((Block) block, i, i2, i3);
	}

	@Override
	public void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		((RenderBlocks) renderBlocks).renderBlockAsItem((Block) block, i, f);
	}

	@Override
	public boolean renderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return ((RenderBlocks) renderBlocks).renderItemIn3d(i);
	}

	@Override
	public void renderFirstPersonArm(Object renderplayer, Object entityplayer) {
		((RenderPlayer) renderplayer).renderFirstPersonArm((EntityPlayer) entityplayer);
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
	public Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return null;
	}

	@Override
	public Object renderManagerGetEntityClassRenderObject(Class c) {
		return RenderManager.instance.getEntityClassRenderObject(c);
	}

	@Override
	public Object renderManagerGetEntityRenderObject(Object entity) {
		return RenderManager.instance.getEntityRenderObject((Entity) entity);
	}

	@Override
	public Object renderManagerInstance() {
		return RenderManager.instance;
	}

	@Override
	public Object renderManagerItemRenderer() {
		return RenderManager.instance.itemRenderer;
	}

	@Override
	public void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		RenderManager.instance.itemRenderer.renderItem((EntityLiving) entity, (ItemStack) itemstack, (Integer) o);
	}

	@Override
	public boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		RenderManager.instance.renderEntityWithPosYaw((Entity) entity, d, d2, d3, f, f2);
		return true;
	}

	@Override
	public Object renderRenderManagerRenderEngine(Object render) {
		return ((RenderManager) renderRenderManager(render)).renderEngine;
	}

	@Override
	public InputStream resourceManagerInputStream(Object o) {
		return null;
	}

	@Override
	public void setEntityEntityID(Object entity, int i) {
		((Entity) entity).entityId = i;
	}

	@Override
	public void setEntityHurtResistantTime(Object entity, int i) {
		((Entity) entity).hurtResistantTime = i;
	}

	@Override
	public void setEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		((EntityLiving) entityLivingBase).attackedAtYaw = f;
	}

	@Override
	public void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		((EntityLiving) entityLivingBase).deathTime = i;
	}

	@Override
	public void setEntityLivingBaseHealth(Object entity, float f) {
		((EntityLiving) entity).getDataWatcher().updateObject(6, Modchu_CastHelper.Float(MathHelper.clamp_float(f, 0.0F, entityLivingGetMaxHealth(entity))));
	}

	@Override
	public void setEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		((EntityLiving) entityLivingBase).hurtTime = i;
	}

	@Override
	public void setEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		((EntityLiving) entityLivingBase).maxHurtResistantTime = i;
	}

	@Override
	public void setEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		((EntityLiving) entityLivingBase).maxHurtTime = i;
	}

	@Override
	public void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
		((EntityLiving) entityLivingBase).prevHealth = (int) f;
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
		Modchu_Reflect.setFieldObject("EntityRenderer", "field_78516_c", "itemRenderer", minecraftEntityRenderer(), itemRenderer);
	}

	@Override
	public void setEntityRiddenByEntity(Object entity, Object entity2) {
		((Entity) entity).riddenByEntity = (Entity) entity2;
	}

	@Override
	public void setEntityYOffset(Object entity, float f) {
		((Entity) entity).yOffset = f;
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
	public void setGuiButtonVisible(Object guiButton, boolean b) {
		((GuiButton) guiButton).drawButton = b;
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
	public void setMinecraftRenderViewEntity(Object entity) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().renderViewEntity = (EntityLiving) entity;
	}

	@Override
	public void setMinecraftThePlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().thePlayer = (EntityClientPlayerMP) entityPlayer;
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
	public void setRenderManagerItemRenderer(Object itemRenderer) {
		RenderManager.instance.itemRenderer = (ItemRenderer) itemRenderer;
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		((Tessellator) tessellator).addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	public void tessellatorDraw(Object tessellator) {
		((Tessellator) tessellator).draw();
	}

	@Override
	public Object tessellatorInstance() {
		return Tessellator.instance;
	}

	@Override
	public void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		((Tessellator) tessellator).setColorOpaque_I(i);
	}

	@Override
	public void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		((Tessellator) tessellator).setColorRGBA_I(i, i2);
	}

	@Override
	public void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		((Tessellator) tessellator).setNormal(f, f2, f3);
	}

	@Override
	public void tessellatorStartDrawing(Object tessellator, int i) {
		((Tessellator) tessellator).startDrawing(i);
	}

	@Override
	public void tessellatorStartDrawingQuads(Object tessellator) {
		((Tessellator) tessellator).startDrawingQuads();
	}

	@Override
	public void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw((Tessellator) tessellator, f);
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
	public int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return -1;
	}

	@Override
	public boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return false;
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
	public Object vec3Subtract(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).subtract((Vec3) vec3_2);
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
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return ((World) entityWorldObj(worldOrEntity)).canBlockSeeTheSky((int) d, (int) d2, (int) d3);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return ((World) entityWorldObj(worldOrEntity)).canBlockSeeTheSky(i, i2, i3);
	}

	@Override
	public Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return ((World) entityWorldObj(worldOrEntity)).getPathEntityToEntity((Entity) entity, (Entity) entity2, f, b, b1, b2, b3);
	}

	@Override
	public Object worldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return ((World) entityWorldObj(worldOrEntity)).getPlayerEntityByName(s);
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
	public boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return ((World) entityWorldObj(worldOrEntity)).isAirBlock(i, j, k);
	}

	@Override
	public boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return ((World) entityWorldObj(worldOrEntity)).isBlockNormalCubeDefault(i, j, k, b);
	}

	@Override
	public boolean worldIsDaytime(Object worldOrEntity) {
		return ((World) entityWorldObj(worldOrEntity)).isDaytime();
	}

	@Override
	public boolean worldIsRemote(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.isRemote : false;
	}

	@Override
	public List worldLoadedEntityList(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.loadedEntityList : null;
	}

	@Override
	public List worldPlayerEntities(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.playerEntities : null;
	}

	@Override
	public List worldWeatherEffects(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.weatherEffects : null;
	}

	@Override
	public void worldPlaySoundAtEntity(Object worldOrEntity, Object entity, Object soundEventOrString, float f, float f1) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.playSoundAtEntity((Entity) entity, (String) soundEventOrString, f, f1);
	}

	@Override
	public void worldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.setEntityState((Entity) entity, by);
	}

	@Override
	public Enum worldSettingsGameTypeADVENTURE() {
		return EnumGameType.ADVENTURE;
	}

	@Override
	public Enum worldSettingsGameTypeCREATIVE() {
		return EnumGameType.CREATIVE;
	}

	@Override
	public Enum worldSettingsGameTypeNOT_SET() {
		return EnumGameType.NOT_SET;
	}

	@Override
	public Enum worldSettingsGameTypeSURVIVAL() {
		return EnumGameType.SURVIVAL;
	}

	@Override
	public void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.spawnParticle((String)stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	@Override
	public void worldSpawnPlayerWithLoadedChunks(Object entityplayer) {
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
	public Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		return ((IconRegister) iIconRegister).registerIcon(s);
	}

	@Override
	public void entityLivingBaseSwingItem(Object entityLivingBase) {
		((EntityLiving) entityLivingBase).swingItem();
	}

	@Override
	public void entityLivingBaseSwingItem(Object entityLivingBase, Object enumHand) {
		entityLivingBaseSwingItem(entityLivingBase);
	}

	@Override
	public boolean entityTameableIsTamed(Object entityTameable) {
		return entityTameable instanceof EntityTameable ? ((EntityTameable) entityTameable).isTamed() : false;
	}

	@Override
	public boolean entityHorseIsTame(Object entityHorse) {
		return false;
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
	public Object itemStackGetTagCompound(Object itemStack) {
		return ((ItemStack) itemStack).getTagCompound();
	}

	@Override
	public boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).hasKey(s);
	}

	@Override
	public String nbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).getString(s);
	}

	@Override
	public Object tileEntitySkullRendererSkullRenderer() {
		return TileEntitySkullRenderer.skullRenderer;
	}

	@Override
	public boolean itemRequiresMultipleRenderPasses(Object item) {
		return ((Item) item).requiresMultipleRenderPasses();
	}

	@Override
	public int itemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return ((Item) item).getColorFromItemStack((ItemStack) itemstack, i);
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		return -1;
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object world, int x, int y, int z) {
		return -1;
	}

	@Override
	public void tessellatorSetBrightness(Object tessellator, int i) {
		((Tessellator) tessellator).setBrightness(i);
	}

	@Override
	public int biomeGetBiomeGrassColor(Object biome, int x, int y, int z) {
		return ((BiomeGenBase) biome).getBiomeGrassColor();
	}

	@Override
	public boolean entityRendererAnaglyphEnable() {
		return EntityRenderer.anaglyphEnable;
	}

	@Override
	public void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		((Tessellator) tessellator).setColorOpaque_F(f, f1, f2);
	}

	@Override
	public boolean blockDoublePlantFunc_149887_c(int i) {
		return false;
	}

	@Override
	public int blockDoublePlantFunc_149890_d(int i) {
		return -1;
	}

	@Override
	public Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		return null;
	}

	@Override
	public Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		return null;
	}

	@Override
	public double iIconGetMinU(Object iIcon) {
		return 0.0D;
	}

	@Override
	public double iIconGetMinV(Object iIcon) {
		return 0.0D;
	}

	@Override
	public double iIconGetMaxU(Object iIcon) {
		return 0.0D;
	}

	@Override
	public double iIconGetMaxV(Object iIcon) {
		return 0.0D;
	}

	@Override
	public Object itemItemRegistry() {
		return null;
	}

	@Override
	public Map registrySimpleRegistryObjects(Object itemRegistry) {
		return null;
	}

	@Override
	public String potionHelperSugarEffect() {
		return PotionHelper.sugarEffect;
	}

	@Override
	public String potionHelperGhastTearEffect() {
		return PotionHelper.ghastTearEffect;
	}

	@Override
	public String potionHelperSpiderEyeEffect() {
		return PotionHelper.spiderEyeEffect;
	}

	@Override
	public String potionHelperFermentedSpiderEyeEffect() {
		return PotionHelper.fermentedSpiderEyeEffect;
	}

	@Override
	public String potionHelperSpeckledMelonEffect() {
		return PotionHelper.speckledMelonEffect;
	}

	@Override
	public String potionHelperBlazePowderEffect() {
		return PotionHelper.blazePowderEffect;
	}

	@Override
	public String potionHelperMagmaCreamEffect() {
		return PotionHelper.magmaCreamEffect;
	}

	@Override
	public String potionHelperRedstoneEffect() {
		return PotionHelper.redstoneEffect;
	}

	@Override
	public String potionHelperGlowstoneEffect() {
		return PotionHelper.glowstoneEffect;
	}

	@Override
	public String potionHelperGunpowderEffect() {
		return PotionHelper.gunpowderEffect;
	}

	@Override
	public String potionHelperGoldenCarrotEffect() {
		return PotionHelper.goldenCarrotEffect;
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
	public void setEntityLivingBaseLimbSwing(Object entity, float f) {
		((EntityLiving) entity).limbSwing = f;
	}

	@Override
	public void setEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		((EntityLiving) entity).prevRenderYawOffset = f;
	}

	@Override
	public void setEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		((EntityLiving) entity).prevRotationYawHead = f;
	}

	@Override
	public void setEntityLivingBaseRenderYawOffset(Object entity, float f) {
		((EntityLiving) entity).renderYawOffset = f;
	}

	@Override
	public void setEntityLivingBaseRotationYawHead(Object entity, float f) {
		((EntityLiving) entity).rotationYawHead = f;
	}

	@Override
	public void setEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		((EntityLiving) entity).prevLimbYaw = f;
	}

	@Override
	public void setEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		((EntityLiving) entity).limbYaw = f;
	}

	@Override
	public void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		((Item) item).onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityplayer);
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
	public void entityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		((EntityLiving) entity).setPositionAndUpdate(x, y, z);
	}

	@Override
	public void entitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		((Entity) entity).setPositionAndRotation(x, y, z, f, f1);
	}

	@Override
	public int threadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return -1;
	}

	@Override
	public Object netClientHandlerGetNetManager(Object netClientHandler) {
		return ((NetClientHandler) netClientHandler).getNetManager();
	}

	@Override
	public int itemStackGetMaxDamage(Object itemstack) {
		return ((ItemStack) itemstack).getMaxDamage();
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
	public Object modelRightArm(Object model) {
		if (model != null); else return null;
		if (model instanceof ModelBase) {
			if (model instanceof ModelBiped) return modelBipedBipedRightArm(model);
			if (model instanceof ModelQuadruped) return modelQuadrupedLeg1(model);
			if (model instanceof ModelBat) return modelBatBatRightWing(model);
			if (model instanceof ModelChicken) return modelChickenRightWing(model);
			if (model instanceof ModelCreeper) return modelCreeperLeg1(model);
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
	public Object modelBipedBipedRightArm(Object modelBiped) {
		return ((ModelBiped) modelBiped).bipedRightArm;
	}

	@Override
	public void setModelBipedBipedRightArm(Object modelBiped, Object modelRenderer) {
		((ModelBiped) modelBiped).bipedRightArm = (ModelRenderer) modelRenderer;
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
	public void renderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
	}

	@Override
	public String resourceLocationGetResourceDomain(Object resourceLocation) {
		return null;
	}

	@Override
	public String resourceLocationGetResourcePath(Object resourceLocation) {
		return null;
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
	public void framebufferBindFramebuffer(Object framebuffer, boolean b) {
	}

	@Override
	public void framebufferUnbindFramebuffer(Object framebuffer) {
	}

	@Override
	public void framebufferFramebufferRender(Object framebuffer, int i, int i1) {
	}

	@Override
	public boolean gameSettingsAnaglyph(Object gameSettings) {
		return ((GameSettings) gameSettings).anaglyph;
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).addVertex(d, d2, d3);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).addVertex(d, d2, d3);
	}

	@Override
	public float mathHelperFloor_float(float f) {
		return MathHelper.floor_float(f);
	}

	@Override
	public long mathHelperFloor_double_long(double d) {
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
	public int mathHelperBucketInt(int i, int j) {
		return MathHelper.bucketInt(i, j);
	}

	@Override
	public boolean mathHelperStringNullOrLengthZero(String s) {
		return MathHelper.stringNullOrLengthZero(s);
	}

	@Override
	public double mathHelperSqrt_double(double d) {
		return MathHelper.sqrt_double(d);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		tileEntitySkullRendererRenderSkull(f, f1, f2, en, f3, i, gameProfile, i2, 0.0F);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		TileEntitySkullRenderer.skullRenderer.func_82393_a(f, f1, f2, i, f3, i2, Modchu_CastHelper.String(gameProfile));
	}

	@Override
	public Object getBipedArmor(Object entityPlayer, Object itemStack, int i, Object entityEquipmentSlotOrInt, String s) {
		if (Modchu_Main.isServer) return null;
		Item item = (Item) itemStackGetItem(itemStack);
		if (item instanceof ItemArmor) {
			int renderIndex = itemArmorRenderIndex(item);
			String[] armorFilename = renderBipedBipedArmorFilenamePrefix();
			String a1 = renderIndex < armorFilename.length ? armorFilename[renderIndex] : armorFilename[armorFilename.length - 1];
			return String.format("/armor/%s_layer_%d%s.png", new Object[] {armorFilename[((ItemArmor) item).renderIndex], i == 2 ? 2 : 1, s == null ? "" : String.format("_%s", new Object[]{ s })});
		}
		return null;
	}

	@Override
	public int[] facingOffsetsXForSide() {
		return Facing.offsetsXForSide;
	}

	@Override
	public int[] facingOffsetsYForSide() {
		return Facing.offsetsYForSide;
	}

	@Override
	public int[] facingOffsetsZForSide() {
		return Facing.offsetsZForSide;
	}

	@Override
	public boolean itemStackHasDisplayName(Object itemstack) {
		return ((ItemStack) itemstack).hasDisplayName();
	}

	@Override
	public void entitySetCustomNameTag(Object entity, String s) {
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
	public Enum movingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		return null;
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		return null;
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.ENTITY;
	}

	@Override
	public boolean worldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		return ((World) worldOrEntity).canMineBlock((EntityPlayer)entityPlayer, x, y, z);
	}

	@Override
	public int movingObjectPositionSideHit(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).sideHit;
	}

	@Override
	public boolean entityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		return ((EntityPlayer) entityplayer).canPlayerEdit(x, y, z, i, (ItemStack) itemStack);
	}

	@Override
	public Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return ((EntityPlayerMP) entityplayerMP).playerNetServerHandler;
	}

	@Override
	public void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netHandlerPlayServer) {
		((EntityPlayerMP) entityplayerMP).playerNetServerHandler = (NetServerHandler) netHandlerPlayServer;
	}

	@Override
	public void entitySetLocationAndAngles(Object entity, double x, double y, double z, float f, float f1) {
		((Entity) entity).setLocationAndAngles(x, y, z, f, f1);
	}

	@Override
	public float mathHelperWrapAngleTo180_float(float f) {
		return MathHelper.wrapAngleTo180_float(f);
	}

	@Override
	public float blockPosGetX(Object blockPos) {
		return 0.0F;
	}

	@Override
	public float blockPosGetY(Object blockPos) {
		return 0.0F;
	}

	@Override
	public float blockPosGetZ(Object blockPos) {
		return 0.0F;
	}

	@Override
	public Object iBlockStateGetBlock(Object iBlockState) {
		return iBlockState;
	}

	@Override
	public int worldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorldObj(worldOrEntity)).getBlockMetadata(x, y, z);
	}

	@Override
	public int tileEntityXCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).xCoord;
	}

	@Override
	public int tileEntityYCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).yCoord;
	}

	@Override
	public int tileEntityZCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).zCoord;
	}

	@Override
	public Object newBlockPos(Object x, Object y, Object z) {
		return null;
	}

	@Override
	public Object worldGetBlockState(Object worldOrEntity, Object blockPos) {
		return null;
	}

	@Override
	public int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorldObj(worldOrEntity)).getBlockPowerInput(x, y, z);
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
		return ((World) entityWorldObj(worldOrEntity)).getEntityByID(i);
	}

	@Override
	public Object entityLivingBaseGetLook(Object entityLivingBase, float f) {
		return ((EntityLiving) entityLivingBase).getLook(f);
	}

	@Override
	public Object vec3AddVector(Object vec3, double d, double d2, double d3) {
		return ((Vec3) vec3).addVector(d, d2, d3);
	}

	@Override
	public List worldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return ((World) entityWorldObj(worldOrEntity)).getEntitiesWithinAABBExcludingEntity((Entity) entity, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public Object entityGetCollisionBoundingBox(Object entity) {
		return ((Entity) entity).getBoundingBox();
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
	public Object itemStackGetAttributeModifiers(Object itemStack) {
		return null;
	}

	@Override
	public Object sharedMonsterAttributesAttackDamage() {
		return null;
	}

	@Override
	public String iAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return null;
	}

	@Override
	public double attributeModifierGetAmount(Object attributeModifier) {
		return 0D;
	}

	@Override
	public Object itemArmorGetArmorMaterial(Object itemArmor) {
		return ((ItemArmor) itemArmor).getArmorMaterial();
	}

	@Override
	public String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return null;
	}

	@Override
	public void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).resetProgresAndWorkingMessage(s);
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
	public void openGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
	}

	@Override
	public Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return Vec3.createVectorHelper(d, d2, d3);
	}

	@Override
	public void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
	}

	@Override
	public Enum itemCameraTransformsTransformTypeNONE() {
		return null;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		return null;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		return null;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeHEAD() {
		return null;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeGUI() {
		return null;
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
	public Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return null;
	}

	@Override
	public Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return nBTTagCompound;
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
	public int itemStackGetMetadata(Object itemstack) {
		return -1;
	}

	@Override
	public Object minecraftGetBlockRendererDispatcher() {
		return null;
	}

	@Override
	public Object textureMapLocationBlocksTexture() {
		return null;
	}

	@Override
	public Object blockGetDefaultState(Object blockOrIBlockState) {
		return null;
	}

	@Override
	public void blockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
	}

	@Override
	public Object iBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Comparable comparable) {
		return null;
	}

	@Override
	public Object blockDoublePlantVARIANT() {
		return null;
	}

	@Override
	public Object blockDoublePlantHALF() {
		return null;
	}

	@Override
	public int blockGetMetaFromState(Object block, Object iBlockState) {
		return -1;
	}

	@Override
	public Object abstractClientPlayerLocationSkin(Object entity) {
		return null;
	}

	@Override
	public int itemGetMetadata(Object item, int i) {
		return ((Item) item).getMetadata(i);
	}

	@Override
	public int blockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return -1;
	}

	@Override
	public int textureUtilAnaglyphColor(int i) {
		return -1;
	}

	@Override
	public Object blockGetStateFromMeta(Object block, int i) {
		return null;
	}

	@Override
	public Object blockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return null;
	}

	@Override
	public void blockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
	}

	@Override
	public String abstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return null;
	}

	@Override
	public void setEntityTicksExisted(Object entity, int i) {
		((Entity) entity).ticksExisted = i;
	}

	@Override
	public Object worldGetBiomeGenForCoords(Object worldOrEntity, int i, int i1) {
		return ((World) entityWorldObj(worldOrEntity)).getBiomeGenForCoords(i, i1);
	}

	@Override
	public List worldGetEntitiesWithinAABB(Object worldOrEntity, Class c, Object axisAlignedBB) {
		return ((World) entityWorldObj(worldOrEntity)).getEntitiesWithinAABB(c, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public void entityTameableSetOwner(Object entityTameable, Object s) {
		((EntityTameable) entityTameable).setOwner((String) s);
	}

	@Override
	public boolean worldSpawnEntityInWorld(Object worldOrEntity, Object entity) {
		return ((World) entityWorldObj(worldOrEntity)).spawnEntityInWorld((Entity) entity);
	}

	@Override
	public Object worldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return ((World) entityWorldObj(worldOrEntity)).getClosestPlayerToEntity((Entity) entity, d);
	}

	@Override
	public Object minecraftGetRenderItem() {
		return null;
	}

	@Override
	public Object renderItemGetItemModelMesher(Object renderItem) {
		return null;
	}

	@Override
	public Object newModelResourceLocation(String s, String s1) {
		return null;
	}

	@Override
	public void itemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
	}

	@Override
	public void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		((PathNavigate) pathNavigateGround).setAvoidsWater(b);
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
	public Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return ((EntityClientPlayerMP) entityClientPlayerMP).sendQueue;
	}

	@Override
	public void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
		((NetClientHandler) netClientHandler).handleClientCommand((Packet205ClientCommand) packet205ClientCommand);
	}

	@Override
	public void worldRemoveEntity(Object world, Object entity) {
		((World) world).removeEntity((Entity) entity);
	}

	@Override
	public String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return null;
	}

	@Override
	public void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
	}

	@Override
	public Object minecraftServerGetConfigurationManager(Object minecraftServer) {
		return ((MinecraftServer) minecraftServer).getConfigurationManager();
	}

	@Override
	public Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return ((ServerConfigurationManager) serverConfigurationManager).respawnPlayer((EntityPlayerMP) entityPlayerMP, i, b);
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
	public Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return ((EntityLiving) entityLiving).getCurrentArmor(i);
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
	public void rendererLivingEntitySetRenderPassModel(Object rendererLivingEntity, Object modelBase) {
		((RenderLiving) rendererLivingEntity).setRenderPassModel((ModelBase) modelBase);
	}

	@Override
	public Object minecraftTextureManager() {
		return ((Minecraft) minecraftGetMinecraft()).renderEngine;
	}

	@Override
	public Object resourceManagerGetResource(Object resourceManager, Object o) {
		return null;
	}

	@Override
	public Object minecraftGetResourceManager() {
		return null;
	}

	@Override
	public InputStream resourceGetInputStream(Object resource) {
		return null;
	}

	@Override
	public String itemGetUnlocalizedName(Object item) {
		return ((Item) item).getUnlocalizedName();
	}

	@Override
	public Object minecraftLoadingScreen() {
		if (Modchu_Main.isServer) return null;
		System.out.println("Modchu_ASMaster Minecraft.getMinecraft().loadingScreen="+Minecraft.getMinecraft().loadingScreen);
		return Minecraft.getMinecraft().loadingScreen;
	}

	@Override
	public int entityLivingBaseAttackTime(Object entityLiving) {
		return ((EntityLiving) entityLiving).attackTime;
	}

	@Override
	public void setEntityLivingBaseAttackTime(Object entityLiving, int i) {
		((EntityLiving) entityLiving).attackTime = i;
	}

	@Override
	public int movingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).blockX;
	}

	@Override
	public int movingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).blockY;
	}

	@Override
	public int movingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).blockZ;
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
	public Object worldGetBlock(Object world, int i, int i2, int i3) {
		int i1 = ((World) world).getBlockId(i, i2, i3);
		Block block = i1 < Block.blocksList.length
				&& i1 > -1 ? Block.blocksList[i1] : null;
		return block;
	}

	@Override
	public Object entityGetDataWatcher(Object dataManagerOrEntity) {
		return dataManagerOrEntity instanceof DataWatcher ? dataManagerOrEntity : ((Entity) dataManagerOrEntity).getDataWatcher();
	}

	@Override
	public void guiSlotHandleMouseInput(Object guiSlot) {
	}

}