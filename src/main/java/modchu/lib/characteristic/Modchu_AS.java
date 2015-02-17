package modchu.lib.characteristic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Map;

import modchu.lib.Modchu_ASAlmighty;
import modchu.lib.Modchu_Debug;
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
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
import net.minecraft.entity.EnumCreatureType;
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
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.RegistryNamespacedDefaultedByKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.FMLCommonHandler;

import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;

public class Modchu_AS extends Modchu_ASAlmighty {

	public static void instanceCheck() {
		if (instance != null
				&& instance instanceof Modchu_AS); else instance = new Modchu_AS();
	}

	public Modchu_AS() {
		super();
		instance = this;
	}

	@Override
	protected Object abstractClientPlayerGetTextureCape(Object entity) {
		return ((AbstractClientPlayer) entity).getLocationCape();
	}

	@Override
	protected Object abstractClientPlayerGetTextureSkin(Object entity) {
		return ((AbstractClientPlayer) entity).getLocationSkin();
	}

	@Override
	protected Object axisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return ((AxisAlignedBB) axisAlignedBB).expand(d, d1, d2);
	}

	@Override
	protected Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return new AxisAlignedBB(d, d1, d2, d3, d4, d5);
	}

	@Override
	protected Object biomeGenBaseBeach() {
		return BiomeGenBase.beach;
	}

	@Override
	protected Object biomeGenBaseBirchForest() {
		return BiomeGenBase.birchForest;
	}

	@Override
	protected Object biomeGenBaseBirchForestHills() {
		return BiomeGenBase.birchForestHills;
	}

	@Override
	protected Object biomeGenBaseColdTaiga() {
		return BiomeGenBase.coldTaiga;
	}

	@Override
	protected Object biomeGenBaseColdTaigaHills() {
		return BiomeGenBase.coldTaigaHills;
	}

	@Override
	protected Object biomeGenBaseDeepOcean() {
		return BiomeGenBase.deepOcean;
	}

	@Override
	protected Object biomeGenBaseDesert() {
		return BiomeGenBase.desert;
	}

	@Override
	protected Object biomeGenBaseDesertHills() {
		return BiomeGenBase.desertHills;
	}

	@Override
	protected Object biomeGenBaseExtremeHills() {
		return BiomeGenBase.extremeHills;
	}

	@Override
	protected Object biomeGenBaseExtremeHillsEdge() {
		return BiomeGenBase.extremeHillsEdge;
	}

	@Override
	protected Object biomeGenBaseExtremeHillsPlus() {
		return BiomeGenBase.extremeHillsPlus;
	}

	@Override
	protected Object biomeGenBaseForest() {
		return BiomeGenBase.forest;
	}

	@Override
	protected Object biomeGenBaseForestHills() {
		return BiomeGenBase.forestHills;
	}

	@Override
	protected Object biomeGenBaseFrozenOcean() {
		return BiomeGenBase.frozenOcean;
	}

	@Override
	protected Object biomeGenBaseFrozenRiver() {
		return BiomeGenBase.frozenRiver;
	}

	@Override
	protected Object biomeGenBaseHell() {
		return BiomeGenBase.hell;
	}

	@Override
	protected Object biomeGenBaseIceMountains() {
		return BiomeGenBase.iceMountains;
	}

	@Override
	protected Object biomeGenBaseIcePlains() {
		return BiomeGenBase.icePlains;
	}

	@Override
	protected Object biomeGenBaseJungle() {
		return BiomeGenBase.jungle;
	}

	@Override
	protected Object biomeGenBaseJungleEdge() {
		return BiomeGenBase.jungleEdge;
	}

	@Override
	protected Object biomeGenBaseJungleHills() {
		return BiomeGenBase.jungleHills;
	}

	@Override
	protected Object biomeGenBaseMegaTaiga() {
		return BiomeGenBase.megaTaiga;
	}

	@Override
	protected Object biomeGenBaseMegaTaigaHills() {
		return BiomeGenBase.megaTaigaHills;
	}

	@Override
	protected Object biomeGenBaseMesa() {
		return BiomeGenBase.mesa;
	}

	@Override
	protected Object biomeGenBaseMesaPlateau() {
		return BiomeGenBase.mesaPlateau;
	}

	@Override
	protected Object biomeGenBaseMesaPlateau_F() {
		return BiomeGenBase.mesaPlateau_F;
	}

	@Override
	protected Object biomeGenBaseMushroomIsland() {
		return BiomeGenBase.mushroomIsland;
	}

	@Override
	protected Object biomeGenBaseMushroomIslandShore() {
		return BiomeGenBase.mushroomIslandShore;
	}

	@Override
	protected Object biomeGenBaseOcean() {
		return BiomeGenBase.ocean;
	}

	@Override
	protected Object biomeGenBasePlains() {
		return BiomeGenBase.plains;
	}

	@Override
	protected Object biomeGenBaseRiver() {
		return BiomeGenBase.river;
	}

	@Override
	protected Object biomeGenBaseRoofedForest() {
		return BiomeGenBase.roofedForest;
	}

	@Override
	protected Object biomeGenBaseSavanna() {
		return BiomeGenBase.savanna;
	}

	@Override
	protected Object biomeGenBaseSavannaPlateau() {
		return BiomeGenBase.savannaPlateau;
	}

	@Override
	protected Object biomeGenBaseSky() {
		return BiomeGenBase.sky;
	}

	@Override
	protected Object biomeGenBaseStoneBeach() {
		return BiomeGenBase.stoneBeach;
	}

	@Override
	protected Object biomeGenBaseStoneColdBeach() {
		return BiomeGenBase.coldBeach;
	}

	@Override
	protected Object biomeGenBaseSwampland() {
		return BiomeGenBase.swampland;
	}

	@Override
	protected Object biomeGenBaseTaiga() {
		return BiomeGenBase.taiga;
	}

	@Override
	protected Object biomeGenBaseTaigaHills() {
		return BiomeGenBase.taigaHills;
	}

	@Override
	protected Object[] blockBlockList() {
		return null;
	}

	@Override
	protected Object blockGetBlockFromItem(Object item) {
		if (item != null); else return null;
		return Block.getBlockFromItem((Item) item);
	}

	@Override
	protected int blockGetRenderType(Object block) {
		return ((Block) block).getRenderType();
	}

	@Override
	protected void blockSetLightOpacity(Object block, int lightOpacity) {
		((Block) block).setLightOpacity(lightOpacity);
	}

	@Override
	protected Object creativeTabsTabAllSearch() {
		return CreativeTabs.tabAllSearch;
	}

	@Override
	protected Object creativeTabsTabBlock() {
		return CreativeTabs.tabBlock;
	}

	@Override
	protected Object creativeTabsTabBrewing() {
		return CreativeTabs.tabBrewing;
	}

	@Override
	protected Object creativeTabsTabCombat() {
		return CreativeTabs.tabCombat;
	}

	@Override
	protected Object creativeTabsTabDecorations() {
		return CreativeTabs.tabDecorations;
	}

	@Override
	protected Object creativeTabsTabFood() {
		return CreativeTabs.tabFood;
	}

	@Override
	protected Object creativeTabsTabInventory() {
		return CreativeTabs.tabInventory;
	}

	@Override
	protected Object creativeTabsTabMaterials() {
		return CreativeTabs.tabMaterials;
	}

	@Override
	protected Object creativeTabsTabMisc() {
		return CreativeTabs.tabMisc;
	}

	@Override
	protected Object creativeTabsTabRedstone() {
		return CreativeTabs.tabRedstone;
	}

	@Override
	protected Object creativeTabsTabTools() {
		return CreativeTabs.tabTools;
	}

	@Override
	protected Object creativeTabsTabTransport() {
		return CreativeTabs.tabTransport;
	}

	@Override
	protected Object damageSourceAnvil() {
		return DamageSource.anvil;
	}

	@Override
	protected Object damageSourceCactus() {
		return DamageSource.cactus;
	}

	@Override
	protected Object damageSourceCauseMobDamage(Object entityLivingBase) {
		return DamageSource.causeMobDamage((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected Object damageSourceDrown() {
		return DamageSource.drown;
	}

	@Override
	protected Object damageSourceFall() {
		return DamageSource.fall;
	}

	@Override
	protected Object damageSourceFallingBlock() {
		return DamageSource.fallingBlock;
	}

	@Override
	protected Object damageSourceGeneric() {
		return DamageSource.generic;
	}

	@Override
	protected Object damageSourceGetEntity(Object damageSource) {
		return ((DamageSource) damageSource).getEntity();
	}

	@Override
	protected Object damageSourceInFire() {
		return DamageSource.inFire;
	}

	@Override
	protected Object damageSourceInWall() {
		return DamageSource.inWall;
	}

	@Override
	protected boolean damageSourceIsFireDamage(Object damageSource) {
		return ((DamageSource) damageSource).isFireDamage();
	}

	@Override
	protected Object damageSourceLava() {
		return DamageSource.lava;
	}

	@Override
	protected Object damageSourceMagic() {
		return DamageSource.magic;
	}

	@Override
	protected Object damageSourceOnFire() {
		return DamageSource.onFire;
	}

	@Override
	protected Object damageSourceOutOfWorld() {
		return DamageSource.outOfWorld;
	}

	@Override
	protected Object damageSourceStarve() {
		return DamageSource.starve;
	}

	@Override
	protected Object damageSourceWither() {
		return DamageSource.wither;
	}

	@Override
	protected void dataWatcherAddObject(Object dataWatcherOrEntity, int i, Object o) {
		((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity)).addObject(i, o);
	}

	@Override
	protected byte dataWatcherGetWatchableObjectByte(Object dataWatcherOrEntity, int i) {
		return ((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity)).getWatchableObjectByte(i);
	}

	@Override
	protected Object dataWatcherGetWatchableObjectItemStack(Object dataWatcherOrEntity, int i) {
		return ((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity)).getWatchableObjectItemStack(i);
	}

	@Override
	protected void dataWatcherUpdateObject(Object dataWatcherOrEntity, int i, Object o) {
		DataWatcher dataWatcher = ((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity));
		if (dataWatcherGetWatchedObject(dataWatcherOrEntity, i) != null) dataWatcher.updateObject(i, o);
		else dataWatcher.addObject(i, o);
	}

	@Override
	protected int entityAgeableGetGrowingAge(Object entityAgeable) {
		return ((EntityAgeable) entityAgeable).getGrowingAge();
	}

	@Override
	protected Object entityArrowShootingEntity(Object entityArrow) {
		return ((EntityArrow) entityArrow).shootingEntity;
	}

	@Override
	protected void entityAttackEntityFrom(Object entity, Object damageSource, float f) {
		((Entity) entity).attackEntityFrom((DamageSource) damageSource, f);
	}

	@Override
	protected Object entityBoundingBox(Object entity) {
		return ((Entity) entity).getBoundingBox();
	}

	@Override
	protected double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).getBoundingBox() : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox != null ? boundingBox.maxX : 0.0D;
	}

	@Override
	protected double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).getBoundingBox() : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox != null ? boundingBox.maxY : 0.0D;
	}

	@Override
	protected double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).getBoundingBox() : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox != null ? boundingBox.maxZ : 0.0D;
	}

	@Override
	protected double entityBoundingBoxMinX(Object entity) {
		AxisAlignedBB boundingBox = ((Entity) entity).getBoundingBox();
		return boundingBox != null ? boundingBox.minX : 0.0D;
	}

	@Override
	protected double entityBoundingBoxMinY(Object entity) {
		AxisAlignedBB boundingBox = ((Entity) entity).getBoundingBox();
		return boundingBox != null ? boundingBox.minY : 0.0D;
	}

	@Override
	protected double entityBoundingBoxMinZ(Object entity) {
		AxisAlignedBB boundingBox = ((Entity) entity).getBoundingBox();
		return boundingBox != null ? boundingBox.minZ : 0.0D;
	}

	@Override
	protected String entityCloakUrl(Object entity) {
		return null;
	}

	@Override
	protected Object entityCreatureGetEntityToAttack(Object entityCreature) {
		return ((EntityLiving) entityCreature).getAttackTarget();
	}

	@Override
	protected void entityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
	}

	@Override
	protected int entityDimension(Object entity) {
		return ((Entity) entity).dimension;
	}

	@Override
	protected float entityDistanceWalkedModified(Object entity) {
		return ((Entity) entity).distanceWalkedModified;
	}

	@Override
	protected int entityEntityID(Object entity) {
		return ((Entity) entity).getEntityId();
	}

	@Override
	protected float entityGetBrightness(Object entity, float f) {
		return ((Entity) entity).getBrightness(f);
	}

	@Override
	protected int entityGetBrightnessForRender(Object entity, float f) {
		return ((Entity) entity).getBrightnessForRender(f);
	}

	@Override
	protected float entityGetEyeHeight(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getEyeHeight();
	}

	@Override
	protected float entityHeight(Object entity) {
		return ((Entity) entity).height;
	}

	@Override
	protected int entityHurtResistantTime(Object entity) {
		return ((Entity) entity).hurtResistantTime;
	}

	@Override
	protected boolean entityIsInvisible(Object entity) {
		return ((Entity) entity).isInvisible();
	}

	@Override
	protected boolean entityIsInWater(Object entity) {
		return ((Entity) entity).isInWater();
	}

	@Override
	protected boolean entityIsRiding(Object entity) {
		return ((Entity) entity).isRiding();
	}

	@Override
	protected boolean entityIsSneaking(Object entity) {
		return ((Entity) entity).isSneaking();
	}

	@Override
	protected boolean entityIsWet(Object entity) {
		return ((Entity) entity).isWet();
	}

	@Override
	protected float entityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).attackedAtYaw;
	}

	@Override
	protected int entityLivingBaseDeathTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).deathTime;
	}

	@Override
	protected Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getAITarget();
	}

	@Override
	protected Object entityLivingBaseGetEquipmentInSlot(Object entityLivingBase, int i) {
		return ((EntityLivingBase) entityLivingBase).getEquipmentInSlot(i);
	}

	@Override
	protected float entityLivingBaseGetHealth(Object entity) {
		return ((EntityLivingBase) entity).getHealth();
	}

	@Override
	protected Object entityLivingBaseGetHeldItem(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getHeldItem();
	}

	@Override
	protected float entityLivingBaseGetMaxHealth(Object entity) {
		return ((EntityLivingBase) entity).getMaxHealth();
	}

	@Override
	protected float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return ((EntityLivingBase) entity).getSwingProgress(f);
	}

	@Override
	protected int entityLivingBaseHurtTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).hurtTime;
	}

	@Override
	protected boolean entityLivingBaseIsChild(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).isChild();
	}

	@Override
	protected boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		if (potionOrPotionId instanceof Potion) return ((EntityLivingBase) entityLivingBase).isPotionActive((Potion) potionOrPotionId);
		return ((EntityLivingBase) entityLivingBase).isPotionActive((Integer) potionOrPotionId);
	}

	@Override
	protected void entityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		((EntityLivingBase) entityLivingBase).knockBack((Entity) entityLivingBase2, f, d, d1);
	}

	@Override
	protected float entityLivingBaseLimbSwing(Object entity) {
		return ((EntityLivingBase) entity).limbSwing;
	}

	@Override
	protected float entityLivingBaseLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).limbSwingAmount;
	}

	@Override
	protected int entityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).maxHurtResistantTime;
	}

	@Override
	protected int entityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).maxHurtTime;
	}

	@Override
	protected float entityLivingBaseMoveForward(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveForward;
	}

	@Override
	protected float entityLivingBaseMoveStrafing(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveStrafing;
	}

	@Override
	protected void entityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		((EntityLivingBase) entityLivingBase).onDeath((DamageSource) damageSource);
	}

	@Override
	protected float entityLivingBasePrevHealth(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getHealth();
	}

	@Override
	protected float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).prevLimbSwingAmount;
	}

	@Override
	protected float entityLivingBasePrevRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).prevRenderYawOffset;
	}

	@Override
	protected float entityLivingBasePrevRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).prevRotationYawHead;
	}

	@Override
	protected float entityLivingBaseRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).renderYawOffset;
	}

	@Override
	protected float entityLivingBaseRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).rotationYawHead;
	}

	@Override
	protected void entityLivingBaseSetHealth(Object entity, float f) {
		((EntityLivingBase) entity).setHealth(f);
	}

	@Override
	protected void entityLivingBaseSetRevengeTarget(Object entityLivingBase, Object entityLivingBase2) {
		((EntityLivingBase) entityLivingBase).setRevengeTarget((EntityLivingBase) entityLivingBase2);
	}

	@Override
	protected Object entityLivingGetNavigator(Object entityLivingOrPathNavigate) {
		return entityLivingOrPathNavigate instanceof Entity ? ((EntityLiving) entityLivingOrPathNavigate).getNavigator() : entityLivingOrPathNavigate;
	}

	@Override
	protected void entityLivingNavigatorClearPathEntity(Object entityLivingOrPathNavigate) {
		Object navigator = entityLivingGetNavigator(entityLivingOrPathNavigate);
		if (navigator != null) ((PathNavigate) navigator).clearPathEntity();
	}

	@Override
	protected double entityMotionX(Object entity) {
		return ((Entity) entity).motionX;
	}

	@Override
	protected double entityMotionY(Object entity) {
		return ((Entity) entity).motionY;
	}

	@Override
	protected double entityMotionZ(Object entity) {
		return ((Entity) entity).motionZ;
	}

	@Override
	protected void entityMountEntity(Object entity, Object entity2) {
		((Entity) entity).mountEntity((Entity) entity2);
	}

	@Override
	protected boolean entityOnGround(Object entity) {
		return ((Entity) entity).onGround;
	}

	@Override
	protected Object[] entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer); else {
			entityplayerORInventory = entityPlayerArmorInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorInventory;
	}

	@Override
	protected float entityPlayerCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).cameraYaw;
	}

	@Override
	protected float entityPlayerCurrentXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experience;
	}

	@Override
	protected void entityPlayerSetItemInUse(Object entityplayer, Object itemstack, int i) {
		((EntityPlayer) entityplayer).setItemInUse((ItemStack) itemstack, i);
	}

	@Override
	protected void entityLivingBaseHeal(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).heal(f);
	}

	@Override
	protected double entityPlayerField_71085_bR(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71085_bR;
	}

	@Override
	protected double entityPlayerField_71091_bM(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71091_bM;
	}

	@Override
	protected double entityPlayerField_71094_bP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71094_bP;
	}

	@Override
	protected double entityPlayerField_71095_bQ(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71095_bQ;
	}

	@Override
	protected double entityPlayerField_71096_bN(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71096_bN;
	}

	@Override
	protected double entityPlayerField_71097_bO(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71097_bO;
	}

	@Override
	protected Object entityplayerGetCurrentEquippedItem(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getCurrentEquippedItem();
	}

	@Override
	protected Object entityPlayerGetFoodStats(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getFoodStats();
	}

	@Override
	protected boolean entityPlayerGetHideCape(Object entityplayer) {
		return false;
	}

	@Override
	protected int entityPlayerGetItemInUseCount(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getItemInUseCount();
	}

	@Override
	protected Object entityPlayerInventory(Object entityplayer) {
		return ((EntityPlayer) entityplayer).inventory;
	}

	@Override
	protected int entityPlayerInventoryCurrentItem(Object entityplayer) {
		return ((InventoryPlayer) entityPlayerInventory(entityplayer)).currentItem;
	}

	@Override
	protected Object entityPlayerInventoryGetCurrentItem(Object entityplayer) {
		return ((EntityPlayer) entityplayer).inventory.getCurrentItem();
	}

	@Override
	protected Object entityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return ((EntityPlayer) entityplayer).inventory.getStackInSlot(i);
	}

	@Override
	protected Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		if (entityplayerORInventory instanceof InventoryPlayer); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorItemInSlot(i);
	}

	@Override
	protected void entityPlayerInventorySetInventorySlotContents(Object entityplayer, int i, Object itemstack) {
		((InventoryPlayer) entityPlayerInventory(entityplayer)).setInventorySlotContents(i, (ItemStack) itemstack);
	}

	@Override
	protected boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return ((EntityPlayer) entityplayer).isPlayerSleeping();
	}

	@Override
	protected Object[] entityPlayerMainInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).mainInventory;
	}

	@Override
	protected int entityPlayerPlayerLevel(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceLevel;
	}

	@Override
	protected float entityPlayerPrevCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).prevCameraYaw;
	}

	@Override
	protected int entityPlayerScore(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getScore();
	}

	@Override
	protected void entityPlayerSPFunc_6420_o(Object entityplayer) {
	}

	@Override
	protected int entityPlayerTotalXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceTotal;
	}

	@Override
	protected void entityPlaySound(Object entity, String s, float f1, float f2) {
		((Entity) entity).playSound(s, f1, f2);
	}

	@Override
	protected double entityPosX(Object entity) {
		return ((Entity) entity).posX;
	}

	@Override
	protected double entityPosY(Object entity) {
		return ((Entity) entity).posY;
	}

	@Override
	protected double entityPosZ(Object entity) {
		return ((Entity) entity).posZ;
	}

	@Override
	protected float entityPrevDistanceWalkedModified(Object entity) {
		return ((Entity) entity).prevDistanceWalkedModified;
	}

	@Override
	protected double entityPrevPosX(Object entity) {
		return ((Entity) entity).prevPosX;
	}

	@Override
	protected double entityPrevPosY(Object entity) {
		return ((Entity) entity).prevPosY;
	}

	@Override
	protected double entityPrevPosZ(Object entity) {
		return ((Entity) entity).prevPosZ;
	}

	@Override
	protected float entityPrevRotationPitch(Object entity) {
		return ((EntityLivingBase) entity).prevRotationPitch;
	}

	@Override
	protected float entityPrevRotationYaw(Object entity) {
		return ((EntityLivingBase) entity).prevRotationYaw;
	}

	@Override
	protected Object entityRiddenByEntity(Object entity) {
		return ((Entity) entity).riddenByEntity;
	}

	@Override
	protected Object entityRidingEntity(Object entity) {
		return ((Entity) entity).ridingEntity;
	}

	@Override
	protected float entityRotationPitch(Object entity) {
		return ((Entity) entity).rotationPitch;
	}

	@Override
	protected float entityRotationYaw(Object entity) {
		return ((Entity) entity).rotationYaw;
	}

	@Override
	protected void entitySetDead(Object entity) {
		((Entity) entity).setDead();
	}

	@Override
	protected void entitySetFire(Object entity, int i) {
		((Entity) entity).setFire(i);
	}

	@Override
	protected void entitySetPosition(Object entity, double x, double y, double z) {
		((Entity) entity).setPosition(x, y, z);
	}

	@Override
	protected String entityTameableGetOwnerName(Object entityTameable) {
		return ((EntityTameable) entityTameable).getOwnerId();
	}

	@Override
	protected int entityTicksExisted(Object entity) {
		return ((Entity) entity).ticksExisted;
	}

	@Override
	protected float entityWidth(Object entity) {
		return ((Entity) entity).width;
	}

	@Override
	protected Object entityWorldObj(Object worldOrEntity) {
		return worldOrEntity instanceof World ? worldOrEntity : worldOrEntity instanceof Entity ? ((Entity) worldOrEntity).worldObj : null;
	}

	@Override
	protected float entityYOffset(Object entity) {
		return 0.0F;
	}

	@Override
	protected Enum enumActionBlock() {
		return EnumAction.BLOCK;
	}

	@Override
	protected Enum enumActionBow() {
		return EnumAction.BOW;
	}

	@Override
	protected Enum enumActionDrink() {
		return EnumAction.DRINK;
	}

	@Override
	protected Enum enumActionEat() {
		return EnumAction.EAT;
	}

	@Override
	protected Enum enumActionNone() {
		return EnumAction.NONE;
	}

	@Override
	protected Enum enumCreatureAttributeARTHROPOD() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	protected Enum enumCreatureAttributeUNDEAD() {
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	protected Enum enumCreatureAttributeUNDEFINED() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	protected Enum enumCreatureTypeAmbient() {
		return EnumCreatureType.AMBIENT;
	}

	@Override
	protected Enum enumCreatureTypeCreature() {
		return EnumCreatureType.CREATURE;
	}

	@Override
	protected Enum enumCreatureTypeMonster() {
		return EnumCreatureType.MONSTER;
	}

	@Override
	protected Enum enumCreatureTypeWaterCreature() {
		return EnumCreatureType.WATER_CREATURE;
	}

	@Override
	protected Object FMLCommonHandlerInstance() {
		return FMLCommonHandler.instance();
	}

	@Override
	protected Object FMLCommonHandlerInstanceGetMinecraftServerInstance() {
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}

	@Override
	protected Object[] FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
	}

	@Override
	protected void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		((FontRenderer) fontRenderer).drawString(s, i, j, k);
	}

	@Override
	protected String gameSettingsGetKeyDisplayString(int i) {
		return GameSettings.getKeyDisplayString(i);
	}

	@Override
	protected Object gameSettingsKeyBindBack() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindBack;
	}

	@Override
	protected Object gameSettingsKeyBindForward() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindForward;
	}

	@Override
	protected Object gameSettingsKeyBindLeft() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindLeft;
	}

	@Override
	protected Object gameSettingsKeyBindRight() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindRight;
	}

	@Override
	protected Object getBlockItemStack(Object itemstack) {
		if (itemstack != null); else return null;
		return blockGetBlockFromItem(itemStackGetItem(itemstack));
	}

	@Override
	protected Object getItem(String s) {
		if (s != null); else return null;
		return Item.itemRegistry.getObject(s);
	}

	@Override
	protected Object getResource(String s) {
		return getResource(Minecraft.class, s);
	}

	@Override
	protected String getUserName(Object entityplayer) {
		return entityplayer instanceof EntityPlayer ? ((EntityPlayer) entityplayer).getName() : null;
	}

	@Override
	protected int getVacancyGlobalEntityID() {
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
	protected IntBuffer gLAllocationCreateDirectIntBuffer(int i) {
		return GLAllocation.createDirectIntBuffer(i);
	}

	@Override
	protected int gLAllocationGenerateDisplayLists(int i) {
		return GLAllocation.generateDisplayLists(i);
	}

	@Override
	protected boolean guiButtonEnabled(Object guiButton) {
		return ((GuiButton) guiButton).enabled;
	}

	@Override
	protected int guiButtonID(Object guiButton) {
		return ((GuiButton) guiButton).id;
	}

	@Override
	protected boolean guiButtonVisible(Object guiButton) {
		return ((GuiButton) guiButton).visible;
	}

	@Override
	protected int guiButtonXPosition(Object guiButton) {
		return ((GuiButton) guiButton).xPosition;
	}

	@Override
	protected int guiButtonYPosition(Object guiButton) {
		return ((GuiButton) guiButton).yPosition;
	}

	@Override
	protected void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		((Gui) gui).drawCenteredString((FontRenderer) fontRenderer, s, i, i2, i3);
	}

	@Override
	protected void guiIngameDrawString(String s, int i, int j, int k) {
		if (Modchu_Main.isServer) return;
		Minecraft mc = Minecraft.getMinecraft();
		mc.ingameGUI.drawString(mc.fontRendererObj, s, i, j, k);
	}

	@Override
	protected Object guiOptionsBackground() {
		return Gui.optionsBackground;
	}

	@Override
	protected void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		((GuiScreen) guiScreen).drawScreen(i, i2, f);
	}

	@Override
	protected Object guiScreenFontRenderer(Object guiScreen) {
		return Modchu_Reflect.getFieldObject("GuiScreen", "field_146289_q", "fontRendererObj", guiScreen);
	}

	@Override
	protected int guiScreenHeight(Object guiScreen) {
		return ((GuiScreen) guiScreen).height;
	}

	@Override
	protected int guiScreenWidth(Object guiScreen) {
		return ((GuiScreen) guiScreen).width;
	}

	@Override
	protected void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		((GuiSlot) guiSlot).actionPerformed((GuiButton) guiButton);
	}

	@Override
	protected void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		((GuiSlot) guiSlot).drawScreen(i, i2, f);
	}

	@Override
	protected void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		((GuiSlot) guiSlot).registerScrollButtons(i, i2);
	}

	@Override
	protected Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).armorItemInSlot(i);
	}

	@Override
	protected Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).getStackInSlot(i);
	}

	@Override
	protected boolean isCamouflageCheck(Object block) {
		return block instanceof BlockLeaves;
	}

	@Override
	protected boolean isIntegratedServerRunning() {
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().isIntegratedServerRunning() : false;
	}

	@Override
	protected boolean isLANWorld() {
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
	protected boolean isMac() {
		return Minecraft.isRunningOnMac;
	}

	@Override
	protected boolean isMuiti() {
		if (Modchu_Main.isServer) return true;
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().getNetHandler() != null
				&& !Minecraft.getMinecraft().isSingleplayer() : true;
	}

	@Override
	protected boolean isPlanterCheck(Object itemStackOrBlockOrItem) {
		itemStackOrBlockOrItem = itemStackOrBlockOrItem instanceof ItemStack ? getBlock(itemStackOrBlockOrItem) : itemStackOrBlockOrItem;
		return itemStackOrBlockOrItem instanceof BlockFlower
				| itemStackOrBlockOrItem instanceof BlockDoublePlant
				| itemStackOrBlockOrItem instanceof BlockMushroom
				| itemStackOrBlockOrItem instanceof BlockSapling
				| itemStackOrBlockOrItem instanceof BlockTallGrass;
	}

	@Override
	protected boolean isSkull(Object itemStackOrItem) {
		int version = Modchu_Main.getMinecraftVersion();
		Object item = itemStackOrItem;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItem)) {
			item = itemStackGetItem(itemStackOrItem);
		}
		return getItem("skull").getClass().isInstance(item);
	}

	@Override
	protected int itemArmorRenderIndex(Object itemArmor) {
		return ((ItemArmor) itemArmor).renderIndex;
	}

	@Override
	protected boolean itemIsFull3D(Object item) {
		return ((Item) item).isFull3D();
	}

	@Override
	protected int itemItemID(Object item) {
		return -1;
	}

	@Override
	protected boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return ((Item) item).itemInteractionForEntity((ItemStack) itemstack, (EntityPlayer) entityplayer, (EntityLivingBase) entityLivingBase);
	}

	@Override
	protected Object[] itemItemsList() {
		return null;
	}

	@Override
	protected Object itemSetCreativeTab(Object item, Object creativeTabs) {
		return ((Item) item).setCreativeTab((CreativeTabs) creativeTabs);
	}

	@Override
	protected Object itemSetTextureName(Object item, String s) {
		return item;
	}

	@Override
	protected Object itemSetUnlocalizedName(Object item, String s) {
		return ((Item) item).setUnlocalizedName(s);
	}

	@Override
	protected Object itemStackCopyItemStack(Object itemstack) {
		return ItemStack.copyItemStack((ItemStack) itemstack);
	}

	@Override
	protected void itemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		((ItemStack) itemstack).damageItem(i, (EntityLivingBase) entityLivingBase);
	}

	@Override
	protected Object itemStackGetItem(Object itemstack) {
		return ((ItemStack) itemstack).getItem();
	}

	@Override
	protected int itemStackGetItemDamage(Object itemstack) {
		return ((ItemStack) itemstack).getItemDamage();
	}

	@Override
	protected Object itemStackGetItemUseAction(Object itemstack) {
		return ((ItemStack) itemstack).getItemUseAction();
	}

	@Override
	protected boolean itemStackIsItemEnchanted(Object itemstack) {
		return ((ItemStack) itemstack).isItemEnchanted();
	}

	@Override
	protected int itemStackItemID(Object itemstack) {
		return -1;
	}

	@Override
	protected int itemStackStackSize(Object itemstack) {
		return ((ItemStack) itemstack).stackSize;
	}

	@Override
	protected boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).isKeyDown() : null;
	}

	@Override
	protected boolean keyBindingIsPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).isPressed() : null;
	}

	@Override
	protected String keyBindingKeyCategory(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyCategory() : null;
	}

	@Override
	protected int keyBindingKeyCode(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyCode() : -1;
	}

	@Override
	protected String keyBindingKeyDescription(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyDescription() : null;
	}

	@Override
	protected float mathHelperCos(float f) {
		return MathHelper.cos(f);
	}

	@Override
	protected double mathHelperFloor_double(double d) {
		return MathHelper.floor_double(d);
	}

	@Override
	protected float mathHelperSin(float f) {
		return MathHelper.sin(f);
	}

	@Override
	protected float mathHelperSqrt_float(float f) {
		return MathHelper.sqrt_float(f);
	}

	@Override
	protected Object minecraftCurrentScreen() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().currentScreen;
	}

	@Override
	protected int minecraftDisplayHeight() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().displayHeight;
	}

	@Override
	protected int minecraftDisplayWidth() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().displayWidth;
	}

	@Override
	protected Object minecraftEntityRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().entityRenderer;
	}

	@Override
	protected Object minecraftEntityRendererItemRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().entityRenderer.itemRenderer;
	}

	@Override
	protected Object minecraftFontRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().fontRendererObj;
	}

	@Override
	protected void minecraftFontRenderer(Object fontRenderer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().fontRendererObj = (FontRenderer) fontRenderer;
	}

	@Override
	protected Object minecraftGameSettings() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings;
	}

	@Override
	protected void minecraftGameSettingsSetThirdPersonView(int i) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.thirdPersonView = i;
	}

	@Override
	protected int minecraftGameSettingsThirdPersonView() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().gameSettings.thirdPersonView;
	}

	@Override
	protected boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		if (Modchu_Main.isServer) return false;
		return Minecraft.getMinecraft().gameSettings.touchscreen;
	}

	@Override
	protected Object minecraftGatSession() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getSession();
	}

	@Override
	protected Object minecraftGetMinecraft() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft();
	}

	@Override
	protected long minecraftGetSystemTime() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().getSystemTime();
	}

	@Override
	protected Object minecraftGetTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getTextureManager();
	}

	@Override
	protected boolean minecraftInGameHasFocus() {
		if (Modchu_Main.isServer) return false;
		return Minecraft.getMinecraft().inGameHasFocus;
	}

	@Override
	protected File minecraftMcDataDir() {
		if (Modchu_Main.isServer) return new File(".");
		return Minecraft.getMinecraft().mcDataDir;
	}

	@Override
	protected Object minecraftPlayerController() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().playerController;
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer() {
		Object thePlayer = minecraftThePlayer();
		minecraftSetDimensionAndSpawnPlayer(((Entity) thePlayer).dimension);
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer(int i) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().setDimensionAndSpawnPlayer(i);
	}

	@Override
	protected Object minecraftTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().renderEngine;
	}

	@Override
	protected Object minecraftThePlayer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().thePlayer;
	}

	@Override
	protected Object minecraftTheWorld() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer().worldServers[0];
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	protected void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		((ModelBase) model).setLivingAnimations((EntityLivingBase) entity, f, f1, f2);
	}

	@Override
	protected void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		((ModelBase) model).setRotationAngles(f, f1, f2, f3, f4, f5, (EntityLivingBase) entity);
	}

	@Override
	protected float modelRendererRotateAngleX(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleX;
	}

	@Override
	protected float modelRendererRotateAngleY(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleY;
	}

	@Override
	protected float modelRendererRotateAngleZ(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleZ;
	}

	@Override
	protected float modelRendererRotationPointX(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointX;
	}

	@Override
	protected float modelRendererRotationPointY(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointY;
	}

	@Override
	protected float modelRendererRotationPointZ(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointZ;
	}

	@Override
	protected void modelRendererSetRotationPoint(Object modelRenderer, float f, float f1, float f2 ) {
		((ModelRenderer) modelRenderer).setRotationPoint(f, f1, f2);
	}

	@Override
	protected boolean modelRendererShowModel(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).showModel;
	}

	@Override
	protected boolean nbttagcompoundGetBoolean(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getBoolean(s);
	}

	@Override
	protected byte nbttagcompoundGetByte(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getByte(s);
	}

	@Override
	protected byte[] nbttagcompoundGetByteArray(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getByteArray(s);
	}

	@Override
	protected double nbttagcompoundGetDouble(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getDouble(s);
	}

	@Override
	protected float nbttagcompoundGetFloat(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getFloat(s);
	}

	@Override
	protected int[] nbttagcompoundGetIntArray(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getIntArray(s);
	}

	@Override
	protected int nbttagcompoundGetInteger(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getInteger(s);
	}

	@Override
	protected long nbttagcompoundGetLong(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getLong(s);
	}

	@Override
	protected short nbttagcompoundGetShort(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getShort(s);
	}

	@Override
	protected String nbttagcompoundGetString(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getString(s);
	}

	@Override
	protected void nbttagcompoundSetBoolean(Object nbttagcompound, String s, boolean b) {
		((NBTTagCompound) nbttagcompound).setBoolean(s, b);
	}

	@Override
	protected void nbttagcompoundSetByte(Object nbttagcompound, String s, byte by) {
		((NBTTagCompound) nbttagcompound).setByte(s, by);
	}

	@Override
	protected void nbttagcompoundSetByteArray(Object nbttagcompound, String s, byte[] by) {
		((NBTTagCompound) nbttagcompound).setByteArray(s, by);
	}

	@Override
	protected void nbttagcompoundSetDouble(Object nbttagcompound, String s, double d) {
		((NBTTagCompound) nbttagcompound).setDouble(s, d);
	}

	@Override
	protected void nbttagcompoundSetFloat(Object nbttagcompound, String s, float f) {
		((NBTTagCompound) nbttagcompound).setFloat(s, f);
	}

	@Override
	protected void nbttagcompoundSetIntArray(Object nbttagcompound, String s, int[] in) {
		((NBTTagCompound) nbttagcompound).setIntArray(s, in);
	}

	@Override
	protected void nbttagcompoundSetInteger(Object nbttagcompound, String s, int i) {
		((NBTTagCompound) nbttagcompound).setInteger(s, i);
	}

	@Override
	protected void nbttagcompoundSetLong(Object nbttagcompound, String s, long l) {
		((NBTTagCompound) nbttagcompound).setLong(s, l);
	}

	@Override
	protected void nbttagcompoundSetShort(Object nbttagcompound, String s, short sh) {
		((NBTTagCompound) nbttagcompound).setShort(s, sh);
	}

	@Override
	protected void nbttagcompoundSetString(Object nbttagcompound, String s, String s1) {
		((NBTTagCompound) nbttagcompound).setString(s, s1);
	}

	@Override
	protected Object newInstanceKeyBinding(String s, int i, String s2) {
		return new KeyBinding(s, i, s2);
	}

	@Override
	protected int openGlHelperDefaultTexUnit() {
		return OpenGlHelper.defaultTexUnit;
	}

	@Override
	protected int openGlHelperLightmapTexUnit() {
		return OpenGlHelper.lightmapTexUnit;
	}

	@Override
	protected void openGlHelperSetActiveTexture(int i) {
		OpenGlHelper.setActiveTexture(i);
	}

	@Override
	protected void playerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
	}

	@Override
	protected void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
	}

	@Override
	protected Object playerControllerMPCreatePlayer(Object playerController) {
		return null;
	}

	@Override
	protected void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		((PlayerControllerMP) playerController).flipPlayer((EntityPlayer) entityplayer);
	}

	@Override
	protected void playerControllerSetGameType(Object enumGameType) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().playerController.setGameType((GameType) enumGameType);
	}

	@Override
	protected Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return ((PositionTextureVertex) positionTextureVertex).setTexturePosition(f, f1);
	}

	@Override
	protected float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionX;
	}

	@Override
	protected float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionY;
	}

	@Override
	protected Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).vector3D;
	}

	@Override
	protected Object potionAbsorption() {
		return Potion.absorption;
	}

	@Override
	protected Object potionBlindness() {
		return Potion.blindness;
	}

	@Override
	protected Object potionConfusion() {
		return Potion.confusion;
	}

	@Override
	protected Object potionDamageBoost() {
		return Potion.damageBoost;
	}

	@Override
	protected Object potionDigSlowdown() {
		return Potion.digSlowdown;
	}

	@Override
	protected Object potionDigSpeed() {
		return Potion.digSpeed;
	}

	@Override
	protected Object potionFireResistance() {
		return Potion.fireResistance;
	}

	@Override
	protected Object potionHarm() {
		return Potion.harm;
	}

	@Override
	protected Object potionHeal() {
		return Potion.heal;
	}

	@Override
	protected Object potionHealthBoost() {
		return Potion.healthBoost;
	}

	@Override
	protected Object potionHunger() {
		return Potion.hunger;
	}

	@Override
	protected Object potionInvisibility() {
		return Potion.invisibility;
	}

	@Override
	protected Object potionJump() {
		return Potion.jump;
	}

	@Override
	protected Object potionMoveSlowdown() {
		return Potion.moveSlowdown;
	}

	@Override
	protected Object potionMoveSpeed() {
		return Potion.moveSpeed;
	}

	@Override
	protected Object potionNightVision() {
		return Potion.nightVision;
	}

	@Override
	protected Object potionPoison() {
		return Potion.poison;
	}

	@Override
	protected Object potionRegeneration() {
		return Potion.regeneration;
	}

	@Override
	protected Object potionResistance() {
		return Potion.resistance;
	}

	@Override
	protected Object potionSaturation() {
		return Potion.saturation;
	}

	@Override
	protected Object potionWaterBreathing() {
		return Potion.waterBreathing;
	}

	@Override
	protected Object potionWeakness() {
		return Potion.weakness;
	}

	@Override
	protected Object potionWither() {
		return Potion.wither;
	}

	@Override
	protected void printChatMessage(String s) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(s));
	}

	@Override
	protected void renderBindTexture(Object render, Object resourceLocation) {
		Modchu_Reflect.invokeMethod("Render", "func_110776_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, render, new Object[]{ resourceLocation });
	}

	@Override
	protected String[] renderBipedBipedArmorFilenamePrefix() {
		return null;
	}

	@Override
	protected void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
	}

	@Override
	protected void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
	}

	@Override
	protected boolean renderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return false;
	}

	@Override
	protected Object renderEngine() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().renderEngine;
	}

	@Override
	protected void renderEngineSetupTexture(Object bufferedimage, int i) {
	}

	@Override
	protected void renderFirstPersonArm(Object renderplayer, Object entityplayer) {
		((RenderPlayer) renderplayer).func_177138_b((AbstractClientPlayer) entityplayer);
	}

	@Override
	protected void renderHelperDisableStandardItemLighting() {
		RenderHelper.disableStandardItemLighting();
	}

	@Override
	protected void renderHelperEnableStandardItemLighting() {
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	protected Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return null;
	}

	@Override
	protected Map renderManagerEntityRenderMap() {
		return ((RenderManager) renderManagerInstance()).entityRenderMap;
	}

	@Override
	protected Object renderManagerGetEntityClassRenderObject(Class c) {
		return ((RenderManager) renderManagerInstance()).getEntityClassRenderObject(c);
	}

	@Override
	protected Object renderManagerGetEntityRenderObject(Object entity) {
		return ((RenderManager) renderManagerInstance()).getEntityRenderObject((Entity) entity);
	}

	@Override
	protected Object renderManagerInstance() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getRenderManager();
	}

	@Override
	protected Object renderManagerItemRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getItemRenderer();
	}
/*
	@Override
	protected void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		((ItemRenderer) renderManagerItemRenderer()).renderItem((EntityLivingBase) entity, (ItemStack) itemstack, (net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType) o);
	}
*/
	@Override
	protected boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return ((RenderManager) renderManagerInstance()).renderEntityWithPosYaw((Entity) entity, d, d2, d3, f, f2);
	}

	@Override
	protected Object renderRenderBlocks(Object pRender) {
		return null;
	}

	@Override
	protected Object renderRenderManagerRenderEngine(Object render) {
		return ((RenderManager) renderRenderManager(render)).renderEngine;
	}

	@Override
	protected InputStream resourceGetInputStream(Object resource) {
		return ((IResource) resource).getInputStream();
	}

	@Override
	protected InputStream resourceManagerInputStream(Object o) {
		if (Modchu_Main.isServer) return null;
		try {
			return Minecraft.getMinecraft().getResourceManager().getResource((ResourceLocation) o).getInputStream();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	protected void setEntityEntityID(Object entity, int i) {
		((Entity) entity).setEntityId(i);
	}

	@Override
	protected void setEntityHurtResistantTime(Object entity, int i) {
		((Entity) entity).hurtResistantTime = i;
	}

	@Override
	protected void setEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).attackedAtYaw = f;
	}

	@Override
	protected void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).deathTime = i;
	}

	@Override
	protected void setEntityLivingBaseHealth(Object entity, float f) {
		((EntityLivingBase) entity).getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(f, 0.0F, entityLivingGetMaxHealth(entity))));
	}

	@Override
	protected void setEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).hurtTime = i;
	}

	@Override
	protected void setEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).maxHurtResistantTime = i;
	}

	@Override
	protected void setEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).maxHurtTime = i;
	}

	@Override
	protected void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
	}

	@Override
	protected void setEntityMotionX(Object entity, double d) {
		((Entity) entity).motionX = d;
	}

	@Override
	protected void setEntityMotionY(Object entity, double d) {
		((Entity) entity).motionY = d;
	}

	@Override
	protected void setEntityMotionZ(Object entity, double d) {
		((Entity) entity).motionZ = d;
	}

	@Override
	protected void setEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		((EntityPlayer) entityplayer).inventory.armorInventory = (ItemStack[]) armorInventory;
	}

	@Override
	protected void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		((EntityPlayer) entityplayer).experience = f;
	}

	@Override
	protected void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		((EntityPlayer) entityplayer).inventory = (InventoryPlayer) inventory;
	}

	@Override
	protected void setEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		((EntityPlayer) entityplayer).inventory.mainInventory = (ItemStack[]) mainInventory;
	}

	@Override
	protected void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceLevel = i;
	}

	@Override
	protected void setEntityPlayerScore(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).setScore(i);
	}

	@Override
	protected void setEntityPlayerSPMovementInput() {
		Object thePlayer = minecraftThePlayer();
		Object gameSettings = minecraftGameSettings();
		setEntityPlayerSPMovementInput(thePlayer, new MovementInputFromOptions((GameSettings) gameSettings));
	}

	@Override
	protected void setEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		((EntityPlayerSP) entityplayer).movementInput = (MovementInput) movementInput;
	}

	@Override
	protected void setEntityPlayerTotalXP(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceTotal = i;
	}

	@Override
	protected void setEntityPosX(Object entity, double d) {
		((Entity) entity).posX = d;
	}

	@Override
	protected void setEntityPosY(Object entity, double d) {
		((Entity) entity).posY = d;
	}

	@Override
	protected void setEntityPosZ(Object entity, double d) {
		((Entity) entity).posZ = d;
	}

	@Override
	protected void setEntityRendererItemRenderer(Object itemRenderer) {
		//final orz
		Modchu_Reflect.setFieldObject("EntityRenderer", Modchu_Main.getMinecraftVersion() > 169 ? "field_78516_c" : "field_73841_b", "itemRenderer", minecraftEntityRenderer(), itemRenderer);
	}

	@Override
	protected void setEntityRiddenByEntity(Object entity, Object entity2) {
		((Entity) entity).riddenByEntity = (Entity) entity2;
	}

	@Override
	protected void setEntityYOffset(Object entity, float f) {
	}

	@Override
	protected void setGameSettingsKeyBindBack(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindBack = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindForward(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindForward = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindLeft(Object keyBinding) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.keyBindLeft = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindRight(Object keyBinding) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.keyBindRight = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGuiButtonEnabled(Object guiButton, boolean b) {
		((GuiButton) guiButton).enabled = b;
	}

	@Override
	protected void setGuiButtonID(Object guiButton, int i) {
		((GuiButton) guiButton).id = i;
	}

	@Override
	protected void setGuiButtonVisible(Object guiButton, boolean b) {
		((GuiButton) guiButton).visible = b;
	}

	@Override
	protected void setGuiButtonXPosition(Object guiButton, int i) {
		((GuiButton) guiButton).xPosition = i;
	}

	@Override
	protected void setGuiButtonYPosition(Object guiButton, int i) {
		((GuiButton) guiButton).yPosition = i;
	}

	@Override
	protected void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		Modchu_Reflect.setFieldObject("GuiScreen", "fontRendererObj", guiScreen, fontRenderer);
	}

	@Override
	protected void setGuiScreenHeight(Object guiScreen, int i) {
		((GuiScreen) guiScreen).height = i;
	}

	@Override
	protected void setGuiScreenWidth(Object guiScreen, int i) {
		((GuiScreen) guiScreen).width = i;
	}

	@Override
	protected void setMinecraftDisplayGuiScreen(Object guiScreen) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) guiScreen);
	}

	@Override
	protected void setMinecraftPlayerController(Object playerController) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().playerController = (PlayerControllerMP) playerController;
	}

	@Override
	protected void setMinecraftRenderViewEntity(Object entity) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().setRenderViewEntity((Entity) entity);
	}

	@Override
	protected void setMinecraftThePlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().thePlayer = (EntityPlayerSP) entityPlayer;
	}

	@Override
	protected void setModelRendererRotateAngleX(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleX = f;
	}

	@Override
	protected void setModelRendererRotateAngleY(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleY = f;
	}

	@Override
	protected void setModelRendererRotateAngleZ(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleZ = f;
	}

	@Override
	protected void setModelRendererRotationPointX(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointX = f;
	}

	@Override
	protected void setModelRendererRotationPointY(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointY = f;
	}

	@Override
	protected void setModelRendererRotationPointZ(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointZ = f;
	}

	@Override
	protected void setModelRendererShowModel(Object modelRenderer, boolean b) {
		((ModelRenderer) modelRenderer).showModel = b;
	}

	@Override
	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).getWorldRenderer().addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	protected void tessellatorDraw(Object tessellator) {
		((Tessellator) tessellator).draw();
	}

	@Override
	protected Object tessellatorInstance() {
		return Tessellator.getInstance();
	}

	@Override
	protected void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		((Tessellator) tessellator).getWorldRenderer().setColorOpaque_I(i);
	}

	@Override
	protected void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		((Tessellator) tessellator).getWorldRenderer().setColorRGBA_I(i, i2);
	}

	@Override
	protected void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		((Tessellator) tessellator).getWorldRenderer().setNormal(f, f2, f3);
	}

	@Override
	protected void tessellatorStartDrawing(Object tessellator, byte by) {
		((Tessellator) tessellator).getWorldRenderer().startDrawing(by);
	}

	@Override
	protected void tessellatorStartDrawingQuads(Object tessellator) {
		((Tessellator) tessellator).getWorldRenderer().startDrawingQuads();
	}

	@Override
	protected void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw(((Tessellator) tessellator).getWorldRenderer(), f);
	}

	@Override
	protected void textureManagerBindTexture(Object textureManager, Object o) {
		if (o != null) ((TextureManager) textureManager).bindTexture((ResourceLocation) o);
	}

	@Override
	protected Object textureManagerGetTexture(Object textureManager, Object o) {
		return ((TextureManager) textureManager).getTexture((ResourceLocation) o);
	}

	@Override
	protected Object textureManagerGetResourceLocation(Object textureManager, int i) {
		// TODO
		return null;
	}

	@Override
	protected int textureOffsetTextureOffsetX(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetX;
	}

	@Override
	protected int textureOffsetTextureOffsetY(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetY;
	}

	@Override
	protected int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return TextureUtil.uploadTextureImage(i, (BufferedImage) bufferedimage);
	}

	@Override
	protected Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).crossProduct((Vec3) vec3_2);
	}

	@Override
	protected Object vec3Normalize(Object vec3) {
		return ((Vec3) vec3).normalize();
	}

	@Override
	protected Object vec3Subtract(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).subtractReverse((Vec3) vec3_2);
	}

	@Override
	protected double vec3XCoord(Object vec3) {
		return ((Vec3) vec3).xCoord;
	}

	@Override
	protected double vec3YCoord(Object vec3) {
		return ((Vec3) vec3).yCoord;
	}

	@Override
	protected double vec3ZCoord(Object vec3) {
		return ((Vec3) vec3).zCoord;
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return ((World) entityWorldObj(worldOrEntity)).canSeeSky(new BlockPos(d, d2, d3));
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return ((World) entityWorldObj(worldOrEntity)).canSeeSky(new BlockPos(i, i2, i3));
	}

	@Override
	protected Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		// TODO
		return null;
	}

	@Override
	protected Object worldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return ((World) entityWorldObj(worldOrEntity)).getPlayerEntityByName(s);
	}

	@Override
	protected Object worldGetWorldInfo() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().theWorld.getWorldInfo();
	}

	@Override
	protected Enum worldGetWorldInfoGetGameType() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().theWorld.getWorldInfo().getGameType();
	}

	@Override
	protected boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return ((World) entityWorldObj(worldOrEntity)).isAirBlock(new BlockPos(i, j, k));
	}

	@Override
	protected boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return ((World) entityWorldObj(worldOrEntity)).isBlockNormalCube(new BlockPos(i, j, k), b);
	}

	@Override
	protected boolean worldIsDaytime(Object worldOrEntity) {
		return ((World) entityWorldObj(worldOrEntity)).isDaytime();
	}

	@Override
	protected boolean worldIsRemote(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.isRemote : false;
	}

	@Override
	protected List worldLoadedEntityList(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.loadedEntityList : null;
	}

	@Override
	protected List worldPlayerEntities(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.playerEntities : null;
	}

	@Override
	protected List worldWeatherEffects(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.weatherEffects : null;
	}

	@Override
	protected void worldPlaySoundAtEntity(Object worldOrEntity, Object entity, String s, float f, float f1) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.playSoundAtEntity((Entity) entity, s, f, f1);
	}

	@Override
	protected void worldSetEntityDead(Object entity) {
	}

	@Override
	protected void worldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.setEntityState((Entity) entity, by);
	}

	@Override
	protected Enum worldSettingsGameTypeADVENTURE() {
		return WorldSettings.GameType.ADVENTURE;
	}

	@Override
	protected Enum worldSettingsGameTypeCREATIVE() {
		return WorldSettings.GameType.CREATIVE;
	}

	@Override
	protected Enum worldSettingsGameTypeNOT_SET() {
		return WorldSettings.GameType.NOT_SET;
	}

	@Override
	protected Enum worldSettingsGameTypeSURVIVAL() {
		return WorldSettings.GameType.SURVIVAL;
	}

	@Override
	protected void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) {
			Object type = getEnumParticleTypes(stingOrEnumParticleTypes);
			if (type != null) world.spawnParticle((EnumParticleTypes) type, d, d1, d2, d3, d4, d5);
		}
	}

	private Object getEnumParticleTypes(Object stingOrEnumParticleTypes) {
		if (stingOrEnumParticleTypes instanceof EnumParticleTypes) return stingOrEnumParticleTypes;
		if (stingOrEnumParticleTypes.equals("explode")) return EnumParticleTypes.EXPLOSION_NORMAL;
		if (stingOrEnumParticleTypes.equals("largeexplode")) return EnumParticleTypes.EXPLOSION_LARGE;
		if (stingOrEnumParticleTypes.equals("hugeexplosion")) return EnumParticleTypes.EXPLOSION_HUGE;
		if (stingOrEnumParticleTypes.equals("fireworksSpark")) return EnumParticleTypes.FIREWORKS_SPARK;
		if (stingOrEnumParticleTypes.equals("bubble")) return EnumParticleTypes.WATER_BUBBLE;
		if (stingOrEnumParticleTypes.equals("splash")) return EnumParticleTypes.WATER_SPLASH;
		if (stingOrEnumParticleTypes.equals("wake")) return EnumParticleTypes.WATER_WAKE;
		if (stingOrEnumParticleTypes.equals("suspended")) return EnumParticleTypes.SUSPENDED;
		if (stingOrEnumParticleTypes.equals("depthsuspend")) return EnumParticleTypes.SUSPENDED_DEPTH;
		if (stingOrEnumParticleTypes.equals("crit")) return EnumParticleTypes.CRIT;
		if (stingOrEnumParticleTypes.equals("magicCrit")) return EnumParticleTypes.CRIT_MAGIC;
		if (stingOrEnumParticleTypes.equals("smoke")) return EnumParticleTypes.SMOKE_NORMAL;
		if (stingOrEnumParticleTypes.equals("largesmoke")) return EnumParticleTypes.SMOKE_LARGE;
		if (stingOrEnumParticleTypes.equals("spell")) return EnumParticleTypes.SPELL;
		if (stingOrEnumParticleTypes.equals("instantSpell")) return EnumParticleTypes.SPELL_INSTANT;
		if (stingOrEnumParticleTypes.equals("mobSpell")) return EnumParticleTypes.SPELL_MOB;
		if (stingOrEnumParticleTypes.equals("mobSpellAmbient")) return EnumParticleTypes.SPELL_MOB_AMBIENT;
		if (stingOrEnumParticleTypes.equals("witchMagic")) return EnumParticleTypes.SPELL_WITCH;
		if (stingOrEnumParticleTypes.equals("dripWater")) return EnumParticleTypes.DRIP_WATER;
		if (stingOrEnumParticleTypes.equals("dripLava")) return EnumParticleTypes.DRIP_LAVA;
		if (stingOrEnumParticleTypes.equals("angryVillager")) return EnumParticleTypes.VILLAGER_ANGRY;
		if (stingOrEnumParticleTypes.equals("happyVillager")) return EnumParticleTypes.VILLAGER_HAPPY;
		if (stingOrEnumParticleTypes.equals("townaura")) return EnumParticleTypes.TOWN_AURA;
		if (stingOrEnumParticleTypes.equals("note")) return EnumParticleTypes.NOTE;
		if (stingOrEnumParticleTypes.equals("portal")) return EnumParticleTypes.PORTAL;
		if (stingOrEnumParticleTypes.equals("enchantmenttable")) return EnumParticleTypes.ENCHANTMENT_TABLE;
		if (stingOrEnumParticleTypes.equals("flame")) return EnumParticleTypes.FLAME;
		if (stingOrEnumParticleTypes.equals("lava")) return EnumParticleTypes.LAVA;
		if (stingOrEnumParticleTypes.equals("footstep")) return EnumParticleTypes.FOOTSTEP;
		if (stingOrEnumParticleTypes.equals("cloud")) return EnumParticleTypes.CLOUD;
		if (stingOrEnumParticleTypes.equals("reddust")) return EnumParticleTypes.REDSTONE;
		if (stingOrEnumParticleTypes.equals("snowballpoof")) return EnumParticleTypes.SNOWBALL;
		if (stingOrEnumParticleTypes.equals("snowshovel")) return EnumParticleTypes.SNOW_SHOVEL;
		if (stingOrEnumParticleTypes.equals("slime")) return EnumParticleTypes.SLIME;
		if (stingOrEnumParticleTypes.equals("heart")) return EnumParticleTypes.HEART;
		if (stingOrEnumParticleTypes.equals("barrier")) return EnumParticleTypes.BARRIER;
		if (stingOrEnumParticleTypes.equals("iconcrack_")) return EnumParticleTypes.ITEM_CRACK;
		if (stingOrEnumParticleTypes.equals("blockcrack_")) return EnumParticleTypes.BLOCK_CRACK;
		if (stingOrEnumParticleTypes.equals("blockdust_")) return EnumParticleTypes.BLOCK_DUST;
		if (stingOrEnumParticleTypes.equals("droplet")) return EnumParticleTypes.WATER_DROP;
		if (stingOrEnumParticleTypes.equals("take")) return EnumParticleTypes.ITEM_TAKE;
		if (stingOrEnumParticleTypes.equals("mobappearance")) return EnumParticleTypes.MOB_APPEARANCE;
		try {
			EnumParticleTypes type = stingOrEnumParticleTypes instanceof String ? EnumParticleTypes.valueOf((String) stingOrEnumParticleTypes) : null;
			return type;
		} catch (Exception e) {
		}
		Modchu_Debug.mlDebug("Modchu_AS getEnumParticleTypes type null !! stingOrEnumParticleTypes="+stingOrEnumParticleTypes);
		return null;
	}

	@Override
	protected void worldSpawnPlayerWithLoadedChunks(Object entityplayer) {
	}

	@Override
	protected boolean entityIsDead(Object entity) {
		return ((Entity) entity).isDead;
	}

	@Override
	protected void setEntityIsDead(Object entity, boolean b) {
		((Entity) entity).isDead = b;
	}

	@Override
	protected Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		// TODO
		return null;
	}

	@Override
	protected void entityLivingBaseSwingItem(Object entityLivingBase) {
		((EntityLivingBase) entityLivingBase).swingItem();
	}

	@Override
	protected boolean entityTameableIsTamed(Object entityTameable) {
		return entityTameable instanceof EntityTameable ? ((EntityTameable) entityTameable).isTamed() : false;
	}

	@Override
	protected boolean entityHorseIsTame(Object entityHorse) {
		return entityHorse instanceof EntityHorse ? ((EntityHorse) entityHorse).isTame() : false;
	}

	@Override
	protected Object getIntegratedServer() {
		return Minecraft.getMinecraft().getIntegratedServer();
	}

	@Override
	protected boolean itemShouldRotateAroundWhenRendering(Object item) {
		return ((Item) item).shouldRotateAroundWhenRendering();
	}

	@Override
	protected boolean itemStackHasTagCompound(Object itemStack) {
		return ((ItemStack) itemStack).hasTagCompound();
	}

	@Override
	protected Object itemStackGetTagCompound(Object itemStack) {
		return ((ItemStack) itemStack).getTagCompound();
	}

	@Override
	protected boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).hasKey(s);
	}

	@Override
	protected String nbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).getString(s);
	}

	@Override
	protected boolean itemRequiresMultipleRenderPasses(Object item) {
		// TODO
		return false;
	}

	@Override
	protected int itemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return ((Item) item).getColorFromItemStack((ItemStack) itemstack, i);
	}

	@Override
	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		// TODO
		return -1;
	}

	@Override
	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object iBlockAccess, int x, int y, int z) {
		// TODO
		return -1;
	}

	@Override
	protected int biomeGenBaseGetBiomeGrassColor(Object biomeGenBase, int x, int y, int z) {
		return ((BiomeGenBase) biomeGenBase).getGrassColorAtPos(new BlockPos(x, y, z));
	}

	@Override
	protected boolean entityRendererAnaglyphEnable() {
		return EntityRenderer.anaglyphEnable;
	}

	@Override
	protected void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		((Tessellator) tessellator).getWorldRenderer().setColorOpaque_F(f, f1, f2);
	}

	@Override
	protected boolean blockDoublePlantFunc_149887_c(int i) {
		// TODO
		return false;
	}

	@Override
	protected int blockDoublePlantFunc_149890_d(int i) {
		// TODO
		return -1;
	}

	@Override
	protected Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		// TODO
		return null;
	}

	@Override
	protected Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		// TODO
		return null;
	}

	@Override
	protected double iIconGetMinU(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	protected double iIconGetMinV(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	protected double iIconGetMaxU(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	protected double iIconGetMaxV(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	protected Object itemItemRegistry() {
		return Item.itemRegistry;
	}

	@Override
	protected String potionHelperSugarEffect() {
		return PotionHelper.sugarEffect;
	}

	@Override
	protected String potionHelperGhastTearEffect() {
		return PotionHelper.ghastTearEffect;
	}

	@Override
	protected String potionHelperSpiderEyeEffect() {
		return PotionHelper.spiderEyeEffect;
	}

	@Override
	protected String potionHelperFermentedSpiderEyeEffect() {
		return PotionHelper.fermentedSpiderEyeEffect;
	}

	@Override
	protected String potionHelperSpeckledMelonEffect() {
		return PotionHelper.speckledMelonEffect;
	}

	@Override
	protected String potionHelperBlazePowderEffect() {
		return PotionHelper.blazePowderEffect;
	}

	@Override
	protected String potionHelperMagmaCreamEffect() {
		return PotionHelper.magmaCreamEffect;
	}

	@Override
	protected String potionHelperRedstoneEffect() {
		return PotionHelper.redstoneEffect;
	}

	@Override
	protected String potionHelperGlowstoneEffect() {
		return PotionHelper.glowstoneEffect;
	}

	@Override
	protected String potionHelperGunpowderEffect() {
		return PotionHelper.gunpowderEffect;
	}

	@Override
	protected String potionHelperGoldenCarrotEffect() {
		return PotionHelper.goldenCarrotEffect;
	}

	@Override
	protected Object itemSetPotionEffect(Object item, String s) {
		return ((Item) item).setPotionEffect(s);
	}

	@Override
	protected int itemArmorGetColor(Object itemArmor, Object itemstack) {
		return itemArmor instanceof ItemArmor ? ((ItemArmor) itemArmor).getColor((ItemStack) itemstack) : -1;
	}

	@Override
	protected void setEntityRotationPitch(Object entity, float f) {
		((Entity) entity).rotationPitch = f;
	}

	@Override
	protected void setEntityRotationYaw(Object entity, float f) {
		((Entity) entity).rotationYaw = f;
	}

	@Override
	protected void setEntityPrevRotationPitch(Object entity, float f) {
		((Entity) entity).prevRotationPitch = f;
	}

	@Override
	protected void setEntityPrevRotationYaw(Object entity, float f) {
		((Entity) entity).prevRotationYaw = f;
	}

	@Override
	protected void setEntityLivingBaseLimbSwing(Object entity, float f) {
		((EntityLivingBase) entity).limbSwing = f;
	}

	@Override
	protected void setEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		((EntityLivingBase) entity).prevRenderYawOffset = f;
	}

	@Override
	protected void setEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		((EntityLivingBase) entity).prevRotationYawHead = f;
	}

	@Override
	protected void setEntityLivingBaseRenderYawOffset(Object entity, float f) {
		((EntityLivingBase) entity).renderYawOffset = f;
	}

	@Override
	protected void setEntityLivingBaseRotationYawHead(Object entity, float f) {
		((EntityLivingBase) entity).rotationYawHead = f;
	}

	@Override
	protected void setEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		((EntityLivingBase) entity).prevLimbSwingAmount = f;
	}

	@Override
	protected void setEntityLivingBaseMoveStrafing(Object entityplayer, float f) {
		((EntityLivingBase) entityplayer).moveStrafing = f;
	}

	@Override
	protected void setEntityLivingBaseMoveForward(Object entityplayer, float f) {
		((EntityLivingBase) entityplayer).moveForward = f;
	}

	@Override
	protected void setEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		((EntityLivingBase) entity).limbSwingAmount = f;
	}

	@Override
	protected void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		((Item) item).onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityplayer);
	}

	@Override
	protected boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s, int i) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).hasKey(s, i);
	}

	@Override
	protected Object nbtTagCompoundGetCompoundTag(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).getCompoundTag(s);
	}

	@Override
	protected Object nbtUtilReadGameProfileFromNBT(Object nBTTagCompound) {
		return NBTUtil.readGameProfileFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean stringUtilsIsNullOrEmpty(String s) {
		return StringUtils.isNullOrEmpty(s);
	}

	@Override
	protected void setItemStackStackSize(Object itemstack, int i) {
		((ItemStack) itemstack).stackSize = i;
	}

	@Override
	protected Object minecraftServerGetServer() {
		return MinecraftServer.getServer();
	}

	@Override
	protected Object[] minecraftServerGetServerWorldServers() {
		return MinecraftServer.getServer().worldServers;
	}

	@Override
	protected void entityPlayerDestroyCurrentEquippedItem(Object entityplayer) {
		((EntityPlayer) entityplayer).destroyCurrentEquippedItem();
	}

	@Override
	protected boolean entityPlayerCapabilitiesIsCreativeMode(Object entityplayer) {
		return ((EntityPlayer) entityplayer).capabilities.isCreativeMode;
	}

	@Override
	protected boolean modelBaseIsChild(Object modelBase) {
		return ((ModelBase) modelBase).isChild;
	}

	@Override
	protected void setModelBaseIsChild(Object modelBase, boolean b) {
		((ModelBase) modelBase).isChild = b;
	}

	@Override
	protected void entityBatSetIsBatHanging(Object entityBat, boolean b) {
		((EntityBat) entityBat).setIsBatHanging(b);
	}

	@Override
	protected void entitySetEating(Object entity, boolean b) {
		((Entity) entity).setEating(b);
	}

	@Override
	protected void entityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		((EntityLivingBase) entity).setPositionAndUpdate(x, y, z);
	}

	@Override
	protected void entitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		((Entity) entity).setPositionAndRotation(x, y, z, f, f1);
	}

	@Override
	protected int itemStackGetMaxDamage(Object itemstack) {
		return ((ItemStack) itemstack).getMaxDamage();
	}

	@Override
	protected float mathHelperFloor_float(float f) {
		return MathHelper.floor_float(f);
	}

	@Override
	protected long mathHelperFloor_double_long(double d) {
		return MathHelper.floor_double_long(d);
	}

	@Override
	protected float mathHelperAbs(float f) {
		return MathHelper.abs(f);
	}

	@Override
	protected double mathHelperAbs_max(double d, double d1) {
		return MathHelper.abs_max(d, d1);
	}

	@Override
	protected int mathHelperBucketInt(int i, int j) {
		return MathHelper.bucketInt(i, j);
	}

	@Override
	protected boolean mathHelperStringNullOrLengthZero(String s) {
		return s == null | s.length() == 0;
	}

	@Override
	protected int threadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return ((ThreadDownloadImageData) threadDownloadImageData).getGlTextureId();
	}

	@Override
	protected Object netClientHandlerGetNetManager(Object netClientHandler) {
		return null;
	}

	@Override
	protected List modelBaseBoxList(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(modelBase.getClass(), "boxList", modelBase));
		}
		return ((ModelBase) modelBase).boxList;
	}

	@Override
	protected void setModelBaseBoxList(Object modelBase, List list) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "boxList", modelBase, list);
			return;
		}
		((ModelBase) modelBase).boxList = list;
	}

	@Override
	protected int modelBaseTextureWidth(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureWidth", modelBase));
		}
		return ((ModelBase) modelBase).textureWidth;
	}

	@Override
	protected void setModelBaseTextureWidth(Object modelBase, int i) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureWidth", modelBase, i);
			return;
		}
		((ModelBase) modelBase).textureWidth = i;
	}

	@Override
	protected int modelBaseTextureHeight(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureHeight", modelBase));
		}
		return ((ModelBase) modelBase).textureHeight;
	}

	@Override
	protected void setModelBaseTextureHeight(Object modelBase, int i) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureHeight", modelBase, i);
			return;
		}
		((ModelBase) modelBase).textureHeight = i;
	}

	@Override
	protected Object modelRightArm(Object model) {
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
	protected Object modelBipedBipedRightArm(Object modelBiped) {
		return ((ModelBiped) modelBiped).bipedRightArm;
	}

	@Override
	protected void setModelBipedBipedRightArm(Object modelBiped, Object modelRenderer) {
		((ModelBiped) modelBiped).bipedRightArm = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelWolfWolfLeg1(Object modelWolf) {
		return ((ModelWolf) modelWolf).wolfLeg1;
	}

	@Override
	protected void setModelWolfWolfLeg1(Object modelWolf, Object modelRenderer) {
		((ModelWolf) modelWolf).wolfLeg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelSnowManRightHand(Object modelSnowMan) {
		return ((ModelSnowMan) modelSnowMan).rightHand;
	}

	@Override
	protected void setModelSnowManRightHand(Object modelSnowMan, Object modelRenderer) {
		((ModelSnowMan) modelSnowMan).rightHand = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelSpiderSpiderLeg1(Object modelSpider) {
		return ((ModelSpider) modelSpider).spiderLeg1;
	}

	@Override
	protected void setModelSpiderSpiderLeg1(Object modelSpider, Object modelRenderer) {
		((ModelSpider) modelSpider).spiderLeg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelIronGolemIronGolemRightArm(Object modelIronGolem) {
		return ((ModelIronGolem) modelIronGolem).ironGolemRightArm;
	}

	@Override
	protected void setModelIronGolemIronGolemRightArm(Object modelIronGolem, Object modelRenderer) {
		((ModelIronGolem) modelIronGolem).ironGolemRightArm = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelQuadrupedLeg1(Object modelQuadruped) {
		return ((ModelQuadruped) modelQuadruped).leg1;
	}

	@Override
	protected void setModelQuadrupedLeg1(Object modelQuadruped, Object modelRenderer) {
		((ModelQuadruped) modelQuadruped).leg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelCreeperLeg1(Object modelCreeper) {
		return ((ModelCreeper) modelCreeper).leg1;
	}

	@Override
	protected void setModelCreeperLeg1(Object modelCreeper, Object modelRenderer) {
		((ModelCreeper) modelCreeper).leg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelChickenRightWing(Object modelChicken) {
		return ((ModelChicken) modelChicken).rightWing;
	}

	@Override
	protected void setModelChickenRightWing(Object modelChicken, Object modelRenderer) {
		((ModelChicken) modelChicken).rightWing = (ModelRenderer) modelRenderer;
	}

	@Override
	protected void renderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
		((TextureManager) renderEngine).deleteTexture((ResourceLocation) resourceLocation);
	}

	@Override
	protected String resourceLocationGetResourceDomain(Object resourceLocation) {
		return ((ResourceLocation) resourceLocation).getResourceDomain();
	}

	@Override
	protected String resourceLocationGetResourcePath(Object resourceLocation) {
		return ((ResourceLocation) resourceLocation).getResourcePath();
	}

	@Override
	protected int scaledresolutionGetScaleFactor(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaleFactor();
	}

	@Override
	protected int scaledresolutionGetScaledWidth(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaledWidth();
	}

	@Override
	protected int scaledresolutionGetScaledHeight(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaledHeight();
	}

	@Override
	protected void framebufferBindFramebuffer(Object framebuffer, boolean b) {
		((Framebuffer) framebuffer).bindFramebuffer(b);
	}

	@Override
	protected void framebufferUnbindFramebuffer(Object framebuffer) {
		((Framebuffer) framebuffer).unbindFramebuffer();
	}

	@Override
	protected void framebufferFramebufferRender(Object framebuffer, int i, int i1) {
		((Framebuffer) framebuffer).framebufferRender(i, i1);
	}

	@Override
	protected boolean gameSettingsAnaglyph(Object gameSettings) {
		return ((GameSettings) gameSettings).anaglyph;
	}

	@Override
	protected void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).getWorldRenderer().addVertex(d, d2, d3);
	}

	@Override
	protected double mathHelperSqrt_double(double d) {
		return MathHelper.sqrt_double(d);
	}

	@Override
	protected int movingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).getBlockPos().getX();
	}

	@Override
	protected int movingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).getBlockPos().getY();
	}

	@Override
	protected int movingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).getBlockPos().getZ();
	}

	@Override
	protected Object getBipedArmor(Object entityPlayer, Object itemStack, int i, int i2, String s) {
		if (Modchu_Main.isServer
				| itemStack == null) return null;
		Object render = renderManagerGetEntityRenderObject(entityPlayer);
		if (render != null); else return null;
		List<Object> list = Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(render.getClass(), "field_177097_h", "layerRenderers", render));
		if (list != null
				&& !list.isEmpty()); else return null;
		LayerArmorBase layerArmorBase = null;
		for (Object o : list) {
			if (o instanceof LayerArmorBase) {
				layerArmorBase = (LayerArmorBase) o;
				break;
			}
		}
		Item item = ((ItemStack)itemStack).getItem();
		if (!(item instanceof ItemArmor)) return null;
		return layerArmorBase != null ? layerArmorBase.getArmorResource((Entity)entityPlayer, (ItemStack)itemStack, i, s) : null;
	}

	@Override
	protected Object worldGetBlock(Object world, int i, int i2, int i3) {
		return ((World) world).getBlockState(new BlockPos(i, i2, i3)).getBlock();
	}

	@Override
	protected int[] facingOffsetsXForSide() {
		return null;
	}

	@Override
	protected int[] facingOffsetsYForSide() {
		return null;
	}

	@Override
	protected int[] facingOffsetsZForSide() {
		return null;
	}

	@Override
	protected boolean itemStackHasDisplayName(Object itemstack) {
		return ((ItemStack) itemstack).hasDisplayName();
	}

	@Override
	protected void entitySetCustomNameTag(Object entity, String s) {
		((Entity) entity).setCustomNameTag(s);
	}

	@Override
	protected String itemStackGetDisplayName(Object itemstack) {
		return ((ItemStack) itemstack).getDisplayName();
	}

	@Override
	protected Enum movingObjectPositionTypeOfHit(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit;
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.MISS;
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.BLOCK;
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.ENTITY;
	}

	@Override
	protected boolean worldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		return ((World) worldOrEntity).isBlockModifiable((EntityPlayer)entityPlayer, new BlockPos(x, y, z));
	}

	@Override
	protected boolean entityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		return ((EntityPlayer) entityplayer).isAllowEdit();
	}

	@Override
	protected Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return ((EntityPlayerMP) entityplayerMP).playerNetServerHandler;
	}

	@Override
	protected void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netHandlerPlayServer) {
		((EntityPlayerMP) entityplayerMP).playerNetServerHandler = (NetHandlerPlayServer) netHandlerPlayServer;
	}

	@Override
	protected float mathHelperWrapAngleTo180_float(float f) {
		return MathHelper.wrapAngleTo180_float(f);
	}

	@Override
	protected float blockPosGetX(Object blockPos) {
		return ((BlockPos) blockPos).getX();
	}

	@Override
	protected float blockPosGetY(Object blockPos) {
		return ((BlockPos) blockPos).getY();
	}

	@Override
	protected float blockPosGetZ(Object blockPos) {
		return ((BlockPos) blockPos).getZ();
	}

	@Override
	protected Object iBlockStateGetBlock(Object iBlockState) {
		return ((IBlockState) iBlockState).getBlock();
	}

	@Override
	protected int worldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		IBlockState iBlockState = (IBlockState) worldGetBlockState(worldOrEntity, newBlockPos(x, y, z));
		Block block = (Block) (iBlockState != null ? iBlockStateGetBlock(iBlockState) : null);
		if (block != null); else return 0;
		return ((Block) block).getMetaFromState(iBlockState);
	}

	@Override
	protected int tileEntityXCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).getPos().getX();
	}

	@Override
	protected int tileEntityYCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).getPos().getY();
	}

	@Override
	protected int tileEntityZCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).getPos().getZ();
	}

	@Override
	protected Object newBlockPos(Object x, Object y, Object z) {
		return x instanceof Integer ? new BlockPos((Integer) x, (Integer) y, (Integer) z) : new BlockPos((Double) x, (Double) y, (Double) z);
	}

	@Override
	protected Object worldGetBlockState(Object worldOrEntity, Object blockPos) {
		return ((World) entityWorldObj(worldOrEntity)).getBlockState((BlockPos) blockPos);
	}

	@Override
	protected int worldGetBlockLightValue(Object worldOrEntity, int x, int y, int z) {
		IBlockState iBlockState = (IBlockState) worldGetBlockState(worldOrEntity, newBlockPos(x, y, z));
		Block block = (Block) (iBlockState != null ? iBlockStateGetBlock(iBlockState) : null);
		if (block != null); else return 0;
		return ((Block) block).getLightValue();
	}

	@Override
	protected Object containerInventorySlots(Object container) {
		return ((Container) container).inventorySlots;
	}

	@Override
	protected int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorldObj(worldOrEntity)).getStrongPower(new BlockPos(x, y, z));
	}

	@Override
	protected Object containerGetSlot(Object container, int i) {
		return ((Container) container).getSlot(i);
	}

	@Override
	protected Object slotGetStack(Object slot) {
		return ((Slot) slot).getStack();
	}

	@Override
	protected Object containerInventoryItemStacks(Object container) {
		return ((Container) container).inventoryItemStacks;
	}

	@Override
	protected Object pathNavigateTryMoveToXYZ(Object pathNavigate, int x, int y, int z, float f) {
		return ((PathNavigate) pathNavigate).tryMoveToXYZ(x, y, z, f);
	}

	@Override
	protected Object worldGetEntityByID(Object worldOrEntity, int i) {
		return ((World) entityWorldObj(worldOrEntity)).getEntityByID(i);
	}

	@Override
	protected Map entityListStringToClassMapping() {
		return EntityList.stringToClassMapping;
	}

	@Override
	protected Map entityListClassToStringMapping() {
		return EntityList.classToStringMapping;
	}

	@Override
	protected Map entityListIDtoClassMapping() {
		return EntityList.idToClassMapping;
	}

	@Override
	protected Object entityLivingBaseGetLook(Object entityLivingBase, float f) {
		return ((EntityLivingBase) entityLivingBase).getLook(f);
	}

	@Override
	protected Object vec3AddVector(Object vec3, double d, double d2, double d3) {
		return ((Vec3) vec3).addVector(d, d2, d3);
	}

	@Override
	protected List worldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return ((World) entityWorldObj(worldOrEntity)).getEntitiesWithinAABBExcludingEntity((Entity) entity, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	protected Object entityGetBoundingBox(Object entity) {
		return ((Entity) entity).getBoundingBox();
	}

	@Override
	protected boolean entityCanBeCollidedWith(Object entity) {
		return ((Entity) entity).canBeCollidedWith();
	}

	@Override
	protected float entityGetCollisionBorderSize(Object entity) {
		return ((Entity) entity).getCollisionBorderSize();
	}

	@Override
	protected Object axisAlignedBBCalculateIntercept(Object axisAlignedBB, Object vec3, Object vec3_2) {
		return ((AxisAlignedBB) axisAlignedBB).calculateIntercept((Vec3) vec3, (Vec3) vec3_2);
	}

	@Override
	protected boolean axisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return ((AxisAlignedBB) axisAlignedBB).isVecInside((Vec3) vec3);
	}

	@Override
	protected Object movingObjectPositionHitVec(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).hitVec;
	}

	@Override
	protected double vec3SquareDistanceTo(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).squareDistanceTo((Vec3) vec3_2);
	}

	@Override
	protected List itemPotionGetEffects(Object itemPotion, Object itemStack) {
		return ((ItemPotion) itemPotion).getEffects((ItemStack) itemStack);
	}

	@Override
	protected Multimap itemStackGetAttributeModifiers(Object itemStack) {
		return ((ItemStack) itemStack).getAttributeModifiers();
	}

	@Override
	protected Object sharedMonsterAttributesAttackDamage() {
		return SharedMonsterAttributes.attackDamage;
	}

	@Override
	protected String iAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return ((IAttribute) iAttribute).getAttributeUnlocalizedName();
	}

	@Override
	protected double attributeModifierGetAmount(Object attributeModifier) {
		return ((AttributeModifier) attributeModifier).getAmount();
	}

	@Override
	protected Object getBlock(String s) {
		if (s != null); else return null;
		RegistryNamespacedDefaultedByKey blockRegistry = Block.blockRegistry;
		if (blockRegistry != null); else return null;
		Object block = blockRegistry.getObject(s);
		Modchu_Debug.mDebug("getBlock s="+s+" block="+block);
		return block != null ? block : null;
	}

	@Override
	protected Object itemArmorGetArmorMaterial(Object itemArmor) {
		return ((ItemArmor) itemArmor).getArmorMaterial();
	}

	@Override
	protected String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return ((ItemArmor.ArmorMaterial) armorMaterial).getName();
	}

	@Override
	protected Object minecraftLoadingScreen() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().loadingScreen;
	}

	@Override
	protected void setMinecraftLoadingScreen(Object loadingScreenRenderer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().loadingScreen = (LoadingScreenRenderer) loadingScreenRenderer;
	}

	@Override
	protected void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).displayLoadingString(s);
	}

	@Override
	protected void loadingScreenResetProgressAndMessage(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).resetProgressAndMessage(s);
	}

	@Override
	protected void loadingScreenSetLoadingProgress(Object loadingScreenRenderer, int i) {
		((LoadingScreenRenderer) loadingScreenRenderer).setLoadingProgress(i);
	}

	@Override
	protected void openGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
		OpenGlHelper.glBlendFunc(i, i1, i2, i3);
	}

	@Override
	protected Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return new Vec3(d, d2, d3);
	}

	@Override
	protected void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
		((GuiScreen) guiScreen).func_175273_b((Minecraft) minecraft, i, i2);
	}
/*
	@Override
	protected Enum itemCameraTransformsTransformTypeNONE() {
		return ItemCameraTransforms.TransformType.NONE;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		return ItemCameraTransforms.TransformType.THIRD_PERSON;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		return ItemCameraTransforms.TransformType.FIRST_PERSON;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeHEAD() {
		return ItemCameraTransforms.TransformType.HEAD;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeGUI() {
		return ItemCameraTransforms.TransformType.GUI;
	}
*/
	@Override
	protected Object entityPlayerFishEntity(Object entityplayer) {
		return ((EntityPlayer) entityplayer).fishEntity;
	}

	@Override
	protected void setEntityPlayerFishEntity(Object entityplayer, Object entityFishHook) {
		((EntityPlayer) entityplayer).fishEntity = (EntityFishHook) entityFishHook;
	}

	@Override
	protected boolean entityZombieIsVillager(Object entityZombie) {
		return ((EntityZombie) entityZombie).isVillager();
	}

	@Override
	protected void entityZombieSetVillager(Object entityZombie, boolean b) {
		((EntityZombie) entityZombie).setVillager(b);
	}

	@Override
	protected Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return TileEntitySkull.updateGameprofile((GameProfile) gameprofile);
	}

	@Override
	protected Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return NBTUtil.writeGameProfile((NBTTagCompound) nBTTagCompound, (GameProfile) gameprofile);
	}

	@Override
	protected void nbtTagCompoundSetTag(Object nBTTagCompound, String s, Object nbtBase) {
		((NBTTagCompound) nBTTagCompound).setTag(s, (NBTBase) nbtBase);
	}

	@Override
	protected void tileEntitySkullRendererRenderSkull(Object skullRenderer, float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		TileEntitySkullRenderer.instance.renderSkull(f, f1, f2, (EnumFacing) en, f3, i, (GameProfile) gameProfile, i2);
	}

	@Override
	protected Enum enumFacingUP() {
		return EnumFacing.UP;
	}

	@Override
	protected Enum enumFacingDOWN() {
		return EnumFacing.DOWN;
	}

	@Override
	protected Enum enumFacingEAST() {
		return EnumFacing.EAST;
	}

	@Override
	protected Enum enumFacingNORTH() {
		return EnumFacing.NORTH;
	}

	@Override
	protected Enum enumFacingSOUTH() {
		return EnumFacing.SOUTH;
	}

	@Override
	protected Enum enumFacingWEST() {
		return EnumFacing.WEST;
	}

	@Override
	protected int itemStackGetMetadata(Object itemstack) {
		return ((ItemStack) itemstack).getMetadata();
	}

	@Override
	protected Object minecraftGetBlockRendererDispatcher() {
		return Minecraft.getMinecraft().getBlockRendererDispatcher();
	}

	@Override
	protected Object textureMapLocationBlocksTexture() {
		return TextureMap.locationBlocksTexture;
	}

	@Override
	protected Object blockGetDefaultState(Object blockOrIBlockState) {
		return blockOrIBlockState instanceof Block ? ((Block) blockOrIBlockState).getDefaultState() : blockOrIBlockState instanceof IBlockState ? blockOrIBlockState : null;
	}

	@Override
	protected void blockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
		((BlockRendererDispatcher) blockRendererDispatcher).renderBlockBrightness((IBlockState) iBlockState, f);
	}

	@Override
	protected Object iBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Comparable comparable) {
		Object iBlockState = blockGetDefaultState(blockOrIBlockState);
		return iBlockState != null ? ((IBlockState) iBlockState).withProperty((IProperty) iProperty, comparable) : null;
	}

	@Override
	protected Object blockDoublePlantVARIANT() {
		return BlockDoublePlant.VARIANT;
	}

	@Override
	protected Object blockDoublePlantHALF() {
		return BlockDoublePlant.HALF;
	}

	@Override
	protected int blockGetMetaFromState(Object block, Object iBlockState) {
		return ((Block) block).getMetaFromState((IBlockState) iBlockState);
	}

	@Override
	protected Object abstractClientPlayerLocationSkin(Object entity) {
		return ((AbstractClientPlayer) entity).getLocationSkin();
	}

	@Override
	protected int itemGetMetadata(Object item, int i) {
		return ((Item) item).getMetadata(i);
	}

	@Override
	protected int blockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return ((Block) block).colorMultiplier((IBlockAccess) iBlockAccess, (BlockPos) blockPos, i);
	}

	@Override
	protected int textureUtilAnaglyphColor(int i) {
		return TextureUtil.anaglyphColor(i);
	}

	@Override
	protected Object blockGetStateFromMeta(Object block, int i) {
		return ((Block) block).getStateFromMeta(i);
	}

	@Override
	protected Object blockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return ((BlockRendererDispatcher) blockRendererDispatcher).getBlockModelRenderer();
	}

	@Override
	protected void blockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
		((BlockModelRenderer) blockModelRenderer).renderModelBrightness((IBakedModel) iBakedModel, (IBlockState) iBlockState, f, b);
	}

	@Override
	protected String abstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return ((AbstractClientPlayer) abstractClientPlayer).getSkinType();
	}

	@Override
	protected void setEntityTicksExisted(Object entity, int i) {
		((Entity) entity).ticksExisted = i;
	}

	@Override
	protected Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return ((World) entityWorldObj(worldOrInt)).getBiomeGenForCoords((BlockPos) blockPosOrInt);
	}

	@Override
	protected List worldGetEntitiesWithinAABB(Object worldOrEntity, Class c, Object axisAlignedBB) {
		return ((World) entityWorldObj(worldOrEntity)).getEntitiesWithinAABB(c, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	protected void entityTameableSetOwner(Object entityTameable, String s) {
		((EntityTameable) entityTameable).setOwnerId(s);
	}

	@Override
	protected boolean worldSpawnEntityInWorld(Object worldOrEntity, Object entity) {
		return ((World) entityWorldObj(worldOrEntity)).spawnEntityInWorld((Entity) entity);
	}

	@Override
	protected Object worldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return ((World) entityWorldObj(worldOrEntity)).getClosestPlayerToEntity((Entity) entity, d);
	}

	@Override
	protected Object minecraftGetRenderItem() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getRenderItem();
	}

	@Override
	protected Object renderItemGetItemModelMesher(Object renderItem) {
		return ((RenderItem) renderItem).getItemModelMesher();
	}

	@Override
	protected Object newModelResourceLocation(String s, String s1) {
		return new ModelResourceLocation(s, s1);
	}

	@Override
	protected void itemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
		((ItemModelMesher) itemModelMesher).register((Item) item, i, (ModelResourceLocation) modelResourceLocation);
	}

	@Override
	protected void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		((PathNavigateGround) pathNavigateGround).func_179690_a(b);
	}

	@Override
	protected Object entityLivingTasks(Object entityLiving) {
		return ((EntityLiving) entityLiving).tasks;
	}

	@Override
	protected void entityAITasksAddTask(Object entityAITasks, int i, Object entityAIBase) {
		((EntityAITasks) entityAITasks).addTask(i, (EntityAIBase) entityAIBase);
	}

	@Override
	protected void entityOnUpdate(Object entity) {
		((Entity) entity).onUpdate();
	}

	@Override
	protected void entityPlayerPreparePlayerToSpawn(Object entityplayer) {
		((EntityPlayer) entityplayer).preparePlayerToSpawn();
	}

	@Override
	protected Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return ((EntityPlayerMP) entityClientPlayerMP).playerNetServerHandler;
	}

	@Override
	protected void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
	}

	@Override
	protected void worldRemoveEntity(Object world, Object entity) {
		((World) world).removeEntity((Entity) entity);
	}

	@Override
	protected String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return null;
	}

	@Override
	protected void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
	}

	@Override
	protected Object minecraftServerGetConfigurationManager(Object minecraftServer) {
		return ((MinecraftServer) minecraftServer).getConfigurationManager();
	}

	@Override
	protected Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return ((ServerConfigurationManager) serverConfigurationManager).recreatePlayerEntity((EntityPlayerMP) entityPlayerMP, i, b);
	}

	@Override
	protected void setEntityDimension(Object entity, int i) {
		((Entity) entity).dimension = i;
	}

	@Override
	protected Object minecraftGetIntegratedServer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getIntegratedServer();
	}

	@Override
	protected Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return ((EntityLiving) entityLiving).getCurrentArmor(i);
	}

	@Override
	protected File minecraftServerGetFile(String s) {
		return MinecraftServer.getServer().getFile(s);
	}

	@Override
	protected boolean isPumpkin(Object itemStackOrBlockOrItem) {
		itemStackOrBlockOrItem = itemStackOrBlockOrItem instanceof ItemStack ? getBlock(itemStackOrBlockOrItem) : itemStackOrBlockOrItem;
		return itemStackOrBlockOrItem instanceof BlockPumpkin;
	}

	@Override
	protected void rendererLivingEntitySetRenderPassModel(Object rendererLivingEntity, Object modelBase) {
	}

	@Override
	protected Object pathNavigateGetPathToEntityLiving(Object pathNavigate, Object entity) {
		return ((PathNavigate) pathNavigate).getPathToEntityLiving((Entity) entity);
	}

	@Override
	protected Object pathNavigateSetPath(Object pathNavigate, Object pathEntity, double d) {
		return ((PathNavigate) pathNavigate).setPath((PathEntity) pathEntity, d);
	}

	@Override
	protected void pathNavigateClearPathEntity(Object pathNavigate) {
		((PathNavigate) pathNavigate).clearPathEntity();
	}

	@Override
	protected float entityGetDistanceToEntity(Object entity, Object entity2) {
		return ((Entity) entity).getDistanceToEntity((Entity) entity2);
	}

}
