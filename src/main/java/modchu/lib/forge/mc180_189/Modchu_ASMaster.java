package modchu.lib.forge.mc180_189;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;

import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.LoadingScreenRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
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
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.RegistryNamespacedDefaultedByKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.FMLCommonHandler;

public abstract class Modchu_ASMaster extends modchu.lib.forge.mc172_189.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public String entityTameableGetOwnerName(Object entityTameable) {
		return ((EntityTameable) entityTameable).getOwnerId();
	}

	@Override
	public Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return new AxisAlignedBB(d, d1, d2, d3, d4, d5);
	}

	@Override
	public Enum enumActionBlock() {
		return EnumAction.BLOCK;
	}

	@Override
	public Enum enumActionBow() {
		return EnumAction.BOW;
	}

	@Override
	public Enum enumActionDrink() {
		return EnumAction.DRINK;
	}

	@Override
	public Enum enumActionEat() {
		return EnumAction.EAT;
	}

	@Override
	public Enum enumActionNone() {
		return EnumAction.NONE;
	}

	@Override
	public Enum enumCreatureTypeAmbient() {
		return EnumCreatureType.AMBIENT;
	}

	@Override
	public Enum enumCreatureTypeCreature() {
		return EnumCreatureType.CREATURE;
	}

	@Override
	public Enum enumCreatureTypeMonster() {
		return EnumCreatureType.MONSTER;
	}

	@Override
	public Enum enumCreatureTypeWaterCreature() {
		return EnumCreatureType.WATER_CREATURE;
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
	public void guiIngameDrawString(String s, int i, int j, int k) {
		if (Modchu_Main.isServer) return;
		Minecraft mc = Minecraft.getMinecraft();
		mc.ingameGUI.drawString(mc.fontRendererObj, s, i, j, k);
	}

	@Override
	public boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).isKeyDown() : null;
	}

	@Override
	public Object minecraftFontRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().fontRendererObj;
	}

	@Override
	public void minecraftFontRenderer(Object fontRenderer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().fontRendererObj = (FontRenderer) fontRenderer;
	}

	@Override
	public Object potionAbsorption() {
		return Potion.absorption;
	}

	@Override
	public Object potionHealthBoost() {
		return Potion.healthBoost;
	}

	@Override
	public Object potionSaturation() {
		return Potion.saturation;
	}

	@Override
	public Object renderManagerInstance() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getRenderManager();
	}

	@Override
	public Object renderManagerItemRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getItemRenderer();
	}

	@Override
	public void setMinecraftRenderViewEntity(Object entity) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().setRenderViewEntity((Entity) entity);
	}

	@Override
	public void setMinecraftThePlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().thePlayer = (EntityPlayerSP) entityPlayer;
	}

	@Override
	public Object tessellatorInstance() {
		return Tessellator.getInstance();
	}

	@Override
	public void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw(((Tessellator) tessellator).getWorldRenderer(), f);
	}

	@Override
	public Object vec3Subtract(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).subtractReverse((Vec3) vec3_2);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return ((World) entityWorldObj(worldOrEntity)).canSeeSky(new BlockPos(d, d2, d3));
	}

	@Override
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return ((World) entityWorldObj(worldOrEntity)).canSeeSky(new BlockPos(i, i2, i3));
	}

	@Override
	public boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return ((World) entityWorldObj(worldOrEntity)).isAirBlock(new BlockPos(i, j, k));
	}

	@Override
	public boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return ((World) entityWorldObj(worldOrEntity)).isBlockNormalCube(new BlockPos(i, j, k), b);
	}

	@Override
	public void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
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
	public int biomeGenBaseGetBiomeGrassColor(Object biomeGenBase, int x, int y, int z) {
		return ((BiomeGenBase) biomeGenBase).getGrassColorAtPos(new BlockPos(x, y, z));
	}

	@Override
	public Object nbtUtilReadGameProfileFromNBT(Object nBTTagCompound) {
		return NBTUtil.readGameProfileFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public int movingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).getBlockPos().getX();
	}

	@Override
	public int movingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).getBlockPos().getY();
	}

	@Override
	public int movingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).getBlockPos().getZ();
	}

	@Override
	public Object getBipedArmor(Object entityPlayer, Object itemStack, int i, Object entityEquipmentSlotOrInt, String s) {
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
	public Object worldGetBlock(Object world, int i, int i2, int i3) {
		return ((World) world).getBlockState(new BlockPos(i, i2, i3)).getBlock();
	}

	@Override
	public void entitySetCustomNameTag(Object entity, String s) {
		((Entity) entity).setCustomNameTag(s);
	}

	@Override
	public boolean worldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		return ((World) worldOrEntity).isBlockModifiable((EntityPlayer)entityPlayer, new BlockPos(x, y, z));
	}

	@Override
	public boolean entityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		return ((EntityPlayer) entityplayer).isAllowEdit();
	}

	@Override
	public float blockPosGetX(Object blockPos) {
		return ((BlockPos) blockPos).getX();
	}

	@Override
	public float blockPosGetY(Object blockPos) {
		return ((BlockPos) blockPos).getY();
	}

	@Override
	public float blockPosGetZ(Object blockPos) {
		return ((BlockPos) blockPos).getZ();
	}

	@Override
	public Object iBlockStateGetBlock(Object iBlockState) {
		return ((IBlockState) iBlockState).getBlock();
	}

	@Override
	public int worldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		IBlockState iBlockState = (IBlockState) worldGetBlockState(worldOrEntity, newBlockPos(x, y, z));
		Block block = (Block) (iBlockState != null ? iBlockStateGetBlock(iBlockState) : null);
		if (block != null); else return 0;
		return ((Block) block).getMetaFromState(iBlockState);
	}

	@Override
	public int tileEntityXCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).getPos().getX();
	}

	@Override
	public int tileEntityYCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).getPos().getY();
	}

	@Override
	public int tileEntityZCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).getPos().getZ();
	}

	@Override
	public Object newBlockPos(Object x, Object y, Object z) {
		return x instanceof Integer ? new BlockPos((Integer) x, (Integer) y, (Integer) z) : new BlockPos((Double) x, (Double) y, (Double) z);
	}

	@Override
	public Object worldGetBlockState(Object worldOrEntity, Object blockPos) {
		return ((World) entityWorldObj(worldOrEntity)).getBlockState((BlockPos) blockPos);
	}

	@Override
	public int worldGetBlockLightValue(Object worldOrEntity, int x, int y, int z) {
		IBlockState iBlockState = (IBlockState) worldGetBlockState(worldOrEntity, newBlockPos(x, y, z));
		Block block = (Block) (iBlockState != null ? iBlockStateGetBlock(iBlockState) : null);
		if (block != null); else return 0;
		return ((Block) block).getLightValue();
	}

	@Override
	public int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorldObj(worldOrEntity)).getStrongPower(new BlockPos(x, y, z));
	}

	@Override
	public Map entityListIDtoClassMapping() {
		return EntityList.idToClassMapping;
	}

	@Override
	public Object getBlock(String s) {
		if (s != null); else return null;
		RegistryNamespacedDefaultedByKey blockRegistry = Block.blockRegistry;
		if (blockRegistry != null); else return null;
		Object block = blockRegistry.getObject(Modchu_Main.newResourceLocation(s));
		Modchu_Debug.mDebug("getBlock s="+s+" block="+block);
		return block != null ? block : null;
	}

	@Override
	public String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return ((ItemArmor.ArmorMaterial) armorMaterial).getName();
	}

	@Override
	public Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return new Vec3(d, d2, d3);
	}

	@Override
	public void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).displayLoadingString(s);
	}

	@Override
	public Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return TileEntitySkull.updateGameprofile((GameProfile) gameprofile);
	}

	@Override
	public Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return NBTUtil.writeGameProfile((NBTTagCompound) nBTTagCompound, (GameProfile) gameprofile);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		TileEntitySkullRenderer.instance.renderSkull(f, f1, f2, (EnumFacing) en, f3, i, (GameProfile) gameProfile, i2);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		TileEntitySkullRenderer.instance.renderSkull(f, f1, f2, (EnumFacing) en, f3, i, (GameProfile) gameProfile, i2);
	}

	@Override
	public int itemStackGetMetadata(Object itemstack) {
		return ((ItemStack) itemstack).getMetadata();
	}

	@Override
	public Object minecraftGetBlockRendererDispatcher() {
		return Minecraft.getMinecraft().getBlockRendererDispatcher();
	}

	@Override
	public Object blockGetDefaultState(Object blockOrIBlockState) {
		return blockOrIBlockState instanceof Block ? ((Block) blockOrIBlockState).getDefaultState() : blockOrIBlockState instanceof IBlockState ? blockOrIBlockState : null;
	}

	@Override
	public void blockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
		((BlockRendererDispatcher) blockRendererDispatcher).renderBlockBrightness((IBlockState) iBlockState, f);
	}

	@Override
	public Object iBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Comparable comparable) {
		Object iBlockState = blockGetDefaultState(blockOrIBlockState);
		return iBlockState != null ? ((IBlockState) iBlockState).withProperty((IProperty) iProperty, comparable) : null;
	}

	@Override
	public Object blockDoublePlantVARIANT() {
		return BlockDoublePlant.VARIANT;
	}

	@Override
	public Object blockDoublePlantHALF() {
		return BlockDoublePlant.HALF;
	}

	@Override
	public int blockGetMetaFromState(Object block, Object iBlockState) {
		return ((Block) block).getMetaFromState((IBlockState) iBlockState);
	}

	@Override
	public int blockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return ((Block) block).colorMultiplier((IBlockAccess) iBlockAccess, (BlockPos) blockPos, i);
	}

	@Override
	public int textureUtilAnaglyphColor(int i) {
		return TextureUtil.anaglyphColor(i);
	}

	@Override
	public Object blockGetStateFromMeta(Object block, int i) {
		return ((Block) block).getStateFromMeta(i);
	}

	@Override
	public Object blockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return ((BlockRendererDispatcher) blockRendererDispatcher).getBlockModelRenderer();
	}

	@Override
	public void blockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
		((BlockModelRenderer) blockModelRenderer).renderModelBrightness((IBakedModel) iBakedModel, (IBlockState) iBlockState, f, b);
	}

	@Override
	public String abstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return ((AbstractClientPlayer) abstractClientPlayer).getSkinType();
	}

	@Override
	public Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return ((World) entityWorldObj(worldOrInt)).getBiomeGenForCoords((BlockPos) blockPosOrInt);
	}

	@Override
	public void entityTameableSetOwner(Object entityTameable, Object s) {
		((EntityTameable) entityTameable).setOwnerId((String) s);
	}

	@Override
	public Object minecraftGetRenderItem() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getRenderItem();
	}

	@Override
	public Object renderItemGetItemModelMesher(Object renderItem) {
		return ((RenderItem) renderItem).getItemModelMesher();
	}

	@Override
	public Object newModelResourceLocation(String s, String s1) {
		return new ModelResourceLocation(s, s1);
	}

	@Override
	public void itemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
		((ItemModelMesher) itemModelMesher).register((Item) item, i, (ModelResourceLocation) modelResourceLocation);
	}

	@Override
	public void itemModelMesherRegister(Object itemModelMesher, Object item, Object itemMeshDefinition) {
		((ItemModelMesher) itemModelMesher).register((Item) item, (ItemMeshDefinition) itemMeshDefinition);
	}

	@Override
	public Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return ((ServerConfigurationManager) serverConfigurationManager).recreatePlayerEntity((EntityPlayerMP) entityPlayerMP, i, b);
	}

	@Override
	public Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return ((EntityLiving) entityLiving).getCurrentArmor(i);
	}

	@Override
	public String chatAllowedCharactersFilterAllowedCharacters(String s) {
		return ChatAllowedCharacters.filterAllowedCharacters(s);
	}

	@Override
	public void guiSlotHandleMouseInput(Object guiSlot) {
		((GuiSlot) guiSlot).handleMouseInput();
	}

	@Override
	public String[] renderBipedBipedArmorFilenamePrefix() {
		return null;
	}

	@Override
	public void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
	}

	@Override
	public void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
	}

	@Override
	public boolean renderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return false;
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
		return 0.0F;
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
		return item;
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
		return null;
	}

	@Override
	public void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
	}

	@Override
	public void setEntityYOffset(Object entity, float f) {
	}

	@Override
	public void tessellatorSetColorOpaque_I(Object tessellator, int i) {
	}

	@Override
	public void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
	}

	@Override
	public void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
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
	public Object textureManagerGetResourceLocation(Object textureManager, int i) {
		// TODO
		return null;
	}

	@Override
	public Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		// TODO
		return null;
	}

	@Override
	public void worldSpawnPlayerWithLoadedChunks(Object entityplayer) {
	}

	@Override
	public Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		// TODO
		return null;
	}

	@Override
	public boolean itemRequiresMultipleRenderPasses(Object item) {
		// TODO
		return false;
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		// TODO
		return -1;
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object iBlockAccess, int x, int y, int z) {
		// TODO
		return -1;
	}

	@Override
	public boolean blockDoublePlantFunc_149887_c(int i) {
		// TODO
		return false;
	}

	@Override
	public int blockDoublePlantFunc_149890_d(int i) {
		// TODO
		return -1;
	}

	@Override
	public Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		// TODO
		return null;
	}

	@Override
	public Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		// TODO
		return null;
	}

	@Override
	public double iIconGetMinU(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	public double iIconGetMinV(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	public double iIconGetMaxU(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	public double iIconGetMaxV(Object iIcon) {
		// TODO
		return 0.0D;
	}

	@Override
	public Object netClientHandlerGetNetManager(Object netClientHandler) {
		return null;
	}

	@Override
	public int[] facingOffsetsXForSide() {
		return null;
	}

	@Override
	public int[] facingOffsetsYForSide() {
		return null;
	}

	@Override
	public int[] facingOffsetsZForSide() {
		return null;
	}
/*
	@Override
	public Enum itemCameraTransformsTransformTypeNONE() {
		return ItemCameraTransforms.TransformType.NONE;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		return ItemCameraTransforms.TransformType.THIRD_PERSON;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		return ItemCameraTransforms.TransformType.FIRST_PERSON;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeHEAD() {
		return ItemCameraTransforms.TransformType.HEAD;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeGUI() {
		return ItemCameraTransforms.TransformType.GUI;
	}
*/
	@Override
	public void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
	}

	@Override
	public String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return null;
	}

	@Override
	public void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
	}

	@Override
	public int entityLivingBaseAttackTime(Object entity) {
		return 0;
	}

	@Override
	public void setEntityLivingBaseAttackTime(Object entityLivingBase, int i) {
	}

	@Override
	public void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
	}

	@Override
	public Object entityCreatureGetEntityToAttack(Object entityCreature) {
		return ((EntityLiving) entityCreature).getAttackTarget();
	}

	@Override
	public float entityLivingBasePrevHealth(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getHealth();
	}

	@Override
	public boolean entityPlayerGetHideCape(Object entityplayer) {
		return false;
	}

	@Override
	public boolean mathHelperStringNullOrLengthZero(String s) {
		return s == null | s.length() == 0;
	}

	@Override
	public Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return ((EntityPlayerMP) entityClientPlayerMP).playerNetServerHandler;
	}

	@Override
	public Object getItem(String s) {
		if (s != null); else return null;
		return Item.itemRegistry.getObject((ResourceLocation) Modchu_Main.newResourceLocation(s));
	}

	@Override
	public void renderBindTexture(Object render, Object resourceLocation) {
		if (render instanceof Render
				&& resourceLocation instanceof ResourceLocation) {
			//Modchu_Debug.mDebug("renderBindTexture render="+render+" resourceLocation="+resourceLocation);
			((Render) render).bindTexture((ResourceLocation) resourceLocation);
		}
	}

	@Override
	public Object newResourceLocation(String s) {
		return new ResourceLocation(s);
	}
	// ビルド時にバージョン別変化有り ↓
	@Override
	public Object minecraftThePlayer() {
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