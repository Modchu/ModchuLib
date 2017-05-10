package modchu.lib.forge.mc172_179;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import cpw.mods.fml.common.FMLCommonHandler;
import modchu.lib.Modchu_ASBasis;
import modchu.lib.Modchu_CastHelper;
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
import net.minecraft.client.LoadingScreenRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
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
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class Modchu_ASMaster extends modchu.lib.forge.mc172_189.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
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
	public void renderFirstPersonArm(Object renderplayer, Object entityplayer) {
		((RenderPlayer) renderplayer).renderFirstPersonArm((EntityPlayer) entityplayer);
	}

	@Override
	public void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		RenderManager.instance.itemRenderer.renderItem((EntityLivingBase) entity, (ItemStack) itemstack, (Integer) o);
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
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).addVertex(d, d2, d3);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).addVertex(d, d2, d3);
	}

	@Override
	public Object entityGetCollisionBoundingBox(Object entity) {
		return ((Entity) entity).getBoundingBox();
	}

	@Override
	public void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		((PathNavigate) pathNavigateGround).setAvoidsWater(b);
	}

	@Override
	public void rendererLivingEntitySetRenderPassModel(Object rendererLivingEntity, Object modelBase) {
		((RendererLivingEntity) rendererLivingEntity).setRenderPassModel((ModelBase) modelBase);
	}

	@Override
	public Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return AxisAlignedBB.getBoundingBox(d, d1, d2, d3, d4, d5);
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
	public Object FMLCommonHandlerInstance() {
		return FMLCommonHandler.instance();
	}

	@Override
	public Object FMLCommonHandlerInstanceGetMinecraftServerInstance() {
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}

	@Override
	public Object[] FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
	}

	@Override
	public int getVacancyGlobalEntityID() {
		Map map = EntityList.IDtoClassMapping;
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
	public void guiIngameDrawString(String s, int i, int j, int k) {
		if (Modchu_Main.isServer) return;
		Minecraft mc = Minecraft.getMinecraft();
		mc.ingameGUI.drawString(mc.fontRenderer, s, i, j, k);
	}

	@Override
	public boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getIsKeyPressed() : null;
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
	public Object potionAbsorption() {
		return Potion.field_76444_x;
	}

	@Override
	public Object potionHealthBoost() {
		return Potion.field_76434_w;
	}

	@Override
	public Object potionSaturation() {
		return Potion.field_76443_y;
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
	public void setMinecraftRenderViewEntity(Object entity) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().renderViewEntity = (EntityLivingBase) entity;
	}

	@Override
	public void setMinecraftPlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().thePlayer = (EntityClientPlayerMP) entityPlayer;
	}

	@Override
	public Object tessellatorInstance() {
		return Tessellator.instance;
	}

	@Override
	public void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw((Tessellator) tessellator, f);
	}

	@Override
	public Object vec3Subtract(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).subtract((Vec3) vec3_2);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return ((World) entityWorld(worldOrEntity)).canBlockSeeTheSky((int) d, (int) d2, (int) d3);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return ((World) entityWorld(worldOrEntity)).canBlockSeeTheSky(i, i2, i3);
	}

	@Override
	public boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return ((World) entityWorld(worldOrEntity)).isAirBlock(i, j, k);
	}

	@Override
	public boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return ((World) entityWorld(worldOrEntity)).isBlockNormalCubeDefault(i, j, k, b);
	}

	@Override
	public void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		World world = ((World) entityWorld(worldOrEntity));
		if (world != null) world.spawnParticle((String)stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	@Override
	public int biomeGetBiomeGrassColor(Object biome, int x, int y, int z) {
		return ((BiomeGenBase) biome).getBiomeGrassColor(x, y, z);
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
	public Object getBipedArmor(Object entityPlayer, Object itemStack, int i, Object entityEquipmentSlotOrInt, String s) {
		if (Modchu_Main.isServer) return null;
		Item item = (Item) itemStackGetItem(itemStack);
		if (item instanceof ItemArmor) {
			//int renderIndex = itemArmorRenderIndex(item);
			//String[] armorFilename = renderBipedBipedArmorFilenamePrefix();
			//String a1 = renderIndex < armorFilename.length ? armorFilename[renderIndex] : armorFilename[armorFilename.length - 1];
			return RenderBiped.getArmorResource((Entity)entityPlayer, (ItemStack)itemStack, (Integer) i, s);
		}
		return null;
	}

	@Override
	public Object worldGetBlock(Object world, int i, int i2, int i3) {
		return ((World) world).getBlock(i, i2, i3);
	}

	@Override
	public void entitySetCustomNameTag(Object entity, String s) {
		((EntityLiving) entity).setCustomNameTag(s);
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
	public int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorld(worldOrEntity)).getBlockPowerInput(x, y, z);
	}

	@Override
	public Map entityListIDtoClassMapping() {
		return EntityList.IDtoClassMapping;
	}

	@Override
	public String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return null;
	}

	@Override
	public Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return Vec3.createVectorHelper(d, d2, d3);
	}

	@Override
	public Object minecraftLoadingScreen() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().loadingScreen;
	}

	@Override
	public void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).func_73722_d(s);
	}

	@Override
	public Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return null;
	}
/*
	@Override
	public void tileEntitySkullRendererRenderSkull(Object skullRenderer, float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
	}
*/
	@Override
	public int itemStackGetMetadata(Object itemstack) {
		return -1;
	}

	@Override
	public Object minecraftGetBlockRendererDispatcher() {
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
	public Object worldGetBiomeGenForCoords(Object worldOrEntity, int i, int i1) {
		return ((World) entityWorld(worldOrEntity)).getBiomeGenForCoords(i, i1);
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
	public Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return ((ServerConfigurationManager) serverConfigurationManager).respawnPlayer((EntityPlayerMP) entityPlayerMP, i, b);
	}

	@Override
	public Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return ((EntityLiving) entityLiving).func_130225_q(i);
	}

	@Override
	public void guiSlotHandleMouseInput(Object guiSlot) {
	}

	@Override
	public Object getItem(String s) {
		if (s != null); else return null;
		Object o = Item.itemRegistry.getObject(s);
		if (o != null) return o;
		o = Item.itemRegistry.getObject(s.toLowerCase());
		return o;
	}

	@Override
	public String[] renderBipedBipedArmorFilenamePrefix() {
		return RenderBiped.bipedArmorFilenamePrefix;
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
	public Object[] blockBlockList() {
		return null;
	}

	@Override
	public String entityCloakUrl(Object entity) {
		return null;
	}

	@Override
	public float entityYOffset(Object entity) {
		return ((Entity) entity).yOffset;
	}

	@Override
	public void entityPlayerSPFunc_6420_o(Object entityplayer) {
	}

	@Override
	public int itemItemID(Object item) {
		return -1;
	}

	@Override
	public Object[] itemItemsList() {
		return null;
	}

	@Override
	public Object itemSetTextureName(Object item, String s) {
		return ((Item) item).setTextureName(s);
	}

	@Override
	public int itemStackItemID(Object itemstack) {
		return -1;
	}

	@Override
	public void playerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
	}

	@Override
	public void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
	}

	@Override
	public Object playerControllerMPCreatePlayer(Object playerController) {
		return null;
	}

	@Override
	public void renderEngineSetupTexture(Object bufferedimage, int i) {
	}

	@Override
	public Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return null;
	}

	@Override
	public Object renderRenderBlocks(Object pRender) {
		return Modchu_Reflect.getFieldObject("Render", "field_147909_c", pRender);
	}

	@Override
	public float entityLivingBasePrevHealth(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).prevHealth;
	}

	@Override
	public void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).prevHealth = f;
	}

	@Override
	public void setEntityYOffset(Object entity, float f) {
		((Entity) entity).yOffset = f;
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
	public Object textureManagerGetResourceLocation(Object textureManager, int i) {
		return ((TextureManager) textureManager).getResourceLocation(i);
	}

	@Override
	public Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return ((World) entityWorld(worldOrEntity)).getPathEntityToEntity((Entity) entity, (Entity) entity2, f, b, b1, b2, b3);
	}

	@Override
	public void worldSpawnPlayerWithLoadedChunks(Object entityplayer) {
	}

	@Override
	public Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		return ((IIconRegister) iIconRegister).registerIcon(s);
	}

	@Override
	public boolean itemRequiresMultipleRenderPasses(Object item) {
		return ((Item) item).requiresMultipleRenderPasses();
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		return ((BlockDoublePlant) blockDoublePlant).getMixedBrightnessForBlock((IBlockAccess) minecraftWorld(), x, y, z);
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object iBlockAccess, int x, int y, int z) {
		return ((BlockDoublePlant) blockDoublePlant).getMixedBrightnessForBlock((IBlockAccess) iBlockAccess, x, y, z);
	}

	@Override
	public boolean blockDoublePlantFunc_149887_c(int i) {
		return BlockDoublePlant.func_149887_c(i);
	}

	@Override
	public int blockDoublePlantFunc_149890_d(int i) {
		return BlockDoublePlant.func_149890_d(i);
	}

	@Override
	public Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		return ((BlockDoublePlant) blockDoublePlant).func_149888_a(b, i);
	}

	@Override
	public Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		return ((BlockDoublePlant) blockDoublePlant).sunflowerIcons;
	}

	@Override
	public double iIconGetMinU(Object iIcon) {
		return ((IIcon) iIcon).getMinU();
	}

	@Override
	public double iIconGetMinV(Object iIcon) {
		return ((IIcon) iIcon).getMinV();
	}

	@Override
	public double iIconGetMaxU(Object iIcon) {
		return ((IIcon) iIcon).getMaxU();
	}

	@Override
	public double iIconGetMaxV(Object iIcon) {
		return ((IIcon) iIcon).getMaxV();
	}

	@Override
	public Object netClientHandlerGetNetManager(Object netClientHandler) {
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
	public void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
	}

	@Override
	public String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return ((EntityClientPlayerMP) entityClientPlayerMP).func_142021_k();
	}

	@Override
	public void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
		((EntityClientPlayerMP) entityClientPlayerMP).func_142020_c(s);
	}

	@Override
	public int entityLivingBaseAttackTime(Object entity) {
		return ((EntityLivingBase) entity).attackTime;
	}

	@Override
	public void setEntityLivingBaseAttackTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).attackTime = i;
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
	public void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		((Tessellator) tessellator).setColorOpaque_F(f, f1, f2);
	}

	@Override
	public Object entityCreatureGetEntityToAttack(Object entityCreature) {
		return ((EntityCreature) entityCreature).getEntityToAttack();
	}

	@Override
	public boolean entityPlayerGetHideCape(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getHideCape();
	}

	@Override
	public String getUserName(Object entityplayer) {
		return entityplayer instanceof EntityPlayer ? ((EntityPlayer) entityplayer).getCommandSenderName() : null;
	}

	@Override
	public boolean mathHelperStringNullOrLengthZero(String s) {
		return MathHelper.stringNullOrLengthZero(s);
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
		return ((World) entityWorld(worldOrEntity)).getBlockMetadata(x, y, z);
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
	public int worldGetBlockLightValue(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorld(worldOrEntity)).getBlockLightValue(x, y, z);
	}

	@Override
	public void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
	}

	@Override
	public Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return ((EntityClientPlayerMP) entityClientPlayerMP).sendQueue;
	}

	@Override
	public Object minecraftGetMinecraft() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft();
	}

	@Override
	public long minecraftGetSystemTime() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().getSystemTime();
	}

	@Override
	public Object getBlock(String s) {
		if (s != null) ;else return null;
		RegistryNamespaced blockRegistry = Block.blockRegistry;
		if (blockRegistry != null) ;else return null;
		Object block = blockRegistry.getObject(s);
		//Modchu_Debug.mDebug("getBlock s="+s+" block="+block);
		if (block != null) return block;
		block = blockRegistry.getObject(Modchu_Main.newResourceLocation(s.toLowerCase()));
		return block;
	}

	@Override
	public void setEntityEntityID(Object entity, int i) {
		((Entity) entity).setEntityId(i);
	}

	@Override
	public void setGuiButtonVisible(Object guiButton, boolean b) {
		((GuiButton) guiButton).visible = b;
	}

	@Override
	public Enum worldSettingsGameTypeADVENTURE() {
		return WorldSettings.GameType.ADVENTURE;
	}

	@Override
	public Enum worldSettingsGameTypeCREATIVE() {
		return WorldSettings.GameType.CREATIVE;
	}

	@Override
	public Enum worldSettingsGameTypeNOT_SET() {
		return WorldSettings.GameType.NOT_SET;
	}

	@Override
	public Enum worldSettingsGameTypeSURVIVAL() {
		return WorldSettings.GameType.SURVIVAL;
	}

	@Override
	public Object itemItemRegistry() {
		return Item.itemRegistry;
	}

	@Override
	public boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s, int i) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).hasKey(s, i);
	}

	@Override
	public boolean stringUtilsIsNullOrEmpty(String s) {
		return StringUtils.isNullOrEmpty(s);
	}

	@Override
	public void renderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
		((TextureManager) renderEngine).deleteTexture((ResourceLocation) resourceLocation);
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.MISS;
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.BLOCK;
	}

	@Override
	public void openGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
		OpenGlHelper.glBlendFunc(i, i1, i2, i3);
	}

	@Override
	public void renderBindTexture(Object render, Object resourceLocation) {
		if (render instanceof Render
				&& resourceLocation instanceof ResourceLocation) {
			//Modchu_Debug.mDebug("renderBindTexture render="+render+" resourceLocation="+resourceLocation);
			Modchu_Reflect.invokeMethod("Render", "func_110776_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, render, new Object[]{ resourceLocation });
		}
	}

	@Override
	public Object newResourceLocation(String s) {
		return new ResourceLocation(s);
	}

	@Override
	public Object minecraftServerGetServer() {
		return MinecraftServer.getServer();
	}

	@Override
	public Object entityLivingOnInitialSpawn(Object entityLiving) {
		return entityLivingOnInitialSpawn(entityLiving, null);
	}

	@Override
	public Object entityLivingOnInitialSpawn(Object entityLiving, Object iEntityLivingData) {
		return entityLivingOnInitialSpawn(entityLiving, null, iEntityLivingData);
	}

	@Override
	public Object entityLivingOnInitialSpawn(Object entityLiving, Object difficultyInstance, Object iEntityLivingData) {
		return ((EntityLiving) entityLiving).onSpawnWithEgg((IEntityLivingData) iEntityLivingData);
	}
	// ビルド時にバージョン別変化有り ↓
	@Override
	public Object minecraftPlayer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().thePlayer;
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
	public void tessellatorDraw(Object tessellator) {
		((Tessellator) tessellator).draw();
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
	public int itemStackGetItemDamage(Object itemstack) {
		return ((ItemStack) itemstack).getItemDamage();
	}
	// ビルド時にバージョン別変化有り ↑

}