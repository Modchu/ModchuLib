package modchu.lib.forge.mc190;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

import modchu.lib.Modchu_IBlockContainer;
import modchu.lib.Modchu_IBlockContainerMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.IPlantable;

public class Modchu_BlockContainer extends BlockContainer implements Modchu_IBlockContainer {
	public Modchu_IBlockContainerMaster master;

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super((Material) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IBlockContainerMaster ? (Modchu_IBlockContainerMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_BlockContainer init master="+master);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return (TileEntity) (master != null ? master.createNewTileEntity(world, i) : null);
	}

	@Override
	public Object superCreateNewTileEntity(Object world, int i) {
		return null;
	}

	public TileEntity createNewTileEntity(World world) {
		return null;
	}

	@Override
	public Object superCreateNewTileEntity(Object world) {
		return null;
	}
	// 190~
	@Override
	protected boolean isInvalidNeighbor(World world, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.isInvalidNeighbor(world, blockPos, enumFacing) : super.isInvalidNeighbor(world, blockPos, enumFacing);
	}

	public boolean superIsInvalidNeighbor(Object world, Object blockPos, Object enumFacing) {
		return super.isInvalidNeighbor((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	protected boolean hasInvalidNeighbor(World world, BlockPos blockPos) {
		return master != null ? master.hasInvalidNeighbor(world, blockPos) : super.hasInvalidNeighbor(world, blockPos);
	}

	public boolean superHasInvalidNeighbor(Object world, Object blockPos) {
		return super.hasInvalidNeighbor((World) world, (BlockPos) blockPos);
	}

	// TODO 以下 Modchu_Blockまるコピ
	@Override
	public boolean isBlockNormalCube(IBlockState iBlockState) {
		return master != null ? master.isBlockNormalCube(iBlockState) : super.isBlockNormalCube(iBlockState);
	}

	@Override
	public int getWeakPower(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.getWeakPower(iBlockState, iBlockAccess, blockPos, enumFacing) : super.getWeakPower(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public int superGetWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.getWeakPower((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public int getStrongPower(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.getStrongPower(iBlockState, iBlockAccess, blockPos, enumFacing) : super.getStrongPower(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public int superGetStrongPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.getStrongPower((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public Block setLightOpacity(int par1) {
		return (Block) (master != null ? master.setLightOpacity(par1) : super.setLightOpacity(par1));
	}

	@Override
	public Block superSetLightOpacity(int par1) {
		return super.setLightOpacity(par1);
	}

	@Override
	public Block setResistance(float par1) {
		return (Block) (master != null ? master.setResistance(par1) : super.setResistance(par1));
	}

	@Override
	public Block superSetResistance(float par1) {
		return super.setResistance(par1);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return (EnumBlockRenderType) (master != null ? master.getRenderType(iBlockState) : super.getRenderType(iBlockState));
	}

	@Override
	public Object superGetRenderType(Object iBlockState) {
		return super.getRenderType((IBlockState) iBlockState);
	}

	@Override
	public Block setHardness(float par1) {
		return (Block) (master != null ? master.setHardness(par1) : super.setHardness(par1));
	}

	@Override
	public Block superSetHardness(float par1) {
		return super.setHardness(par1);
	}

	@Override
	public Block setBlockUnbreakable() {
		return (Block) (master != null ? master.setBlockUnbreakable() : super.setBlockUnbreakable());
	}

	@Override
	public Block superSetBlockUnbreakable() {
		return super.setBlockUnbreakable();
	}

	@Override
	public Block setTickRandomly(boolean par1) {
		return (Block) (master != null ? master.setTickRandomly(par1) : super.setTickRandomly(par1));
	}

	@Override
	public Block superSetTickRandomly(boolean par1) {
		return super.setTickRandomly(par1);
	}

	@Override
	public boolean getTickRandomly() {
		return master != null ? master.getTickRandomly() : super.getTickRandomly();
	}

	@Override
	public boolean superGetTickRandomly() {
		return super.getTickRandomly();
	}

	@Override
	public boolean hasTileEntity() {
		return master != null ? master.hasTileEntity() : super.hasTileEntity();
	}

	@Override
	public boolean superHasTileEntity() {
		return super.hasTileEntity();
	}

	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return master != null ? master.isOpaqueCube(iBlockState) : super.isOpaqueCube(iBlockState);
	}

	@Override
	public boolean superIsOpaqueCube(Object iBlockState) {
		return super.isOpaqueCube((IBlockState) iBlockState);
	}

	@Override
	public boolean isCollidable() {
		return master != null ? master.isCollidable() : super.isCollidable();
	}

	@Override
	public boolean superIsCollidable() {
		return super.isCollidable();
	}

	@Override
	public int tickRate(World world) {
		return master != null ? master.tickRate(world) : super.tickRate(world);
	}

	@Override
	public int superTickRate(Object world) {
		return super.tickRate((World) world);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return master != null ? master.quantityDropped(par1Random) : super.quantityDropped(par1Random);
	}

	@Override
	public int superQuantityDropped(Random par1Random) {
		return super.quantityDropped(par1Random);
	}

	@Override
	public float getExplosionResistance(Entity entity) {
		return master != null ? master.getExplosionResistance(entity) : super.getExplosionResistance(entity);
	}

	@Override
	public float superGetExplosionResistance(Object entity) {
		return super.getExplosionResistance((Entity) entity);
	}

	@Override
	public boolean canProvidePower(IBlockState iBlockState) {
		return master != null ? master.canProvidePower(iBlockState) : super.canProvidePower(iBlockState);
	}

	@Override
	public boolean superCanProvidePower(Object iBlockState) {
		return super.canProvidePower((IBlockState) iBlockState);
	}

	@Override
	protected boolean canSilkHarvest() {
		return master != null ? master.canSilkHarvest() : super.canSilkHarvest();
	}

	@Override
	public boolean superCanSilkHarvest() {
		return super.canSilkHarvest();
	}

	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random) {
		return master != null ? master.quantityDroppedWithBonus(par1, par2Random) : super.quantityDroppedWithBonus(par1, par2Random);
	}

	@Override
	public int superQuantityDroppedWithBonus(int par1, Random par2Random) {
		return super.quantityDroppedWithBonus(par1, par2Random);
	}

	@Override
	public String getLocalizedName() {
		return master != null ? master.getLocalizedName() : super.getLocalizedName();
	}

	@Override
	public String superGetLocalizedName() {
		return super.getLocalizedName();
	}

	@Override
	public String getUnlocalizedName() {
		return master != null ? master.getUnlocalizedName() : super.getUnlocalizedName();
	}

	@Override
	public String superGetUnlocalizedName() {
		return super.getUnlocalizedName();
	}

	@Override
	public boolean getEnableStats() {
		return master != null ? master.getEnableStats() : super.getEnableStats();
	}

	@Override
	public boolean superGetEnableStats() {
		return super.getEnableStats();
	}

	@Override
	protected Block disableStats() {
		return (Block) (master != null ? master.disableStats() : super.disableStats());
	}

	@Override
	public Block superDisableStats() {
		return super.disableStats();
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState iBlockState) {
		return (EnumPushReaction) (master != null ? master.getMobilityFlag(iBlockState) : super.getMobilityFlag(iBlockState));
	}

	@Override
	public Object superGetMobilityFlag(Object iBlockState) {
		return super.getMobilityFlag((IBlockState) iBlockState);
	}

	@Override
	public Block setCreativeTab(CreativeTabs creativeTabs) {
		return (Block) (master != null ? master.setCreativeTab(creativeTabs) : super.setCreativeTab(creativeTabs));
	}

	@Override
	public Block superSetCreativeTab(Object creativeTabs) {
		return super.setCreativeTab((CreativeTabs) creativeTabs);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return (CreativeTabs) (master != null ? master.getCreativeTabToDisplayOn() : super.getCreativeTabToDisplayOn());
	}

	@Override
	public CreativeTabs superGetCreativeTabToDisplayOn() {
		return super.getCreativeTabToDisplayOn();
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		return master != null ? master.canDropFromExplosion(explosion) : super.canDropFromExplosion(explosion);
	}

	@Override
	public boolean superCanDropFromExplosion(Object explosion) {
		return super.canDropFromExplosion((Explosion) explosion);
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState iBlockState) {
		return master != null ? master.hasComparatorInputOverride(iBlockState) : super.hasComparatorInputOverride(iBlockState);
	}

	@Override
	public boolean superHasComparatorInputOverride(Object iBlockState) {
		return super.hasComparatorInputOverride((IBlockState) iBlockState);
	}

	@Override
	protected Block setStepSound(SoundType stepSound) {
		return (Block) (master != null ? master.setStepSound(stepSound) : super.setStepSound(stepSound));
	}

	@Override
	public Block superSetStepSound(Object stepSound) {
		return super.setStepSound((SoundType) stepSound);
	}

	@Override
	public Block setLightLevel(float par1) {
		return (Block) (master != null ? master.setLightLevel(par1) : super.setLightLevel(par1));
	}

	@Override
	public Block superSetLightLevel(float par1) {
		return super.setLightLevel(par1);
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs creativeTabs, List par3List) {
		if (master != null) master.getSubBlocks(par1, creativeTabs, par3List);
		else super.getSubBlocks(par1, creativeTabs, par3List);
	}

	@Override
	public void superGetSubBlocks(Object par1, Object creativeTabs, List par3List) {
		super.getSubBlocks((Item) par1, (CreativeTabs) creativeTabs, par3List);
	}

	@Override
	public boolean isAssociatedBlock(Block par1) {
		return master != null ? master.isAssociatedBlock(par1) : super.isAssociatedBlock(par1);
	}

	@Override
	public boolean superIsAssociatedBlock(Object par1) {
		return super.isAssociatedBlock((Block) par1);
	}

	@Override
	public float getAmbientOcclusionLightValue(IBlockState iBlockState) {
		return master != null ? master.getAmbientOcclusionLightValue(iBlockState) : super.getAmbientOcclusionLightValue(iBlockState);
	}

	@Override
	public float superGetAmbientOcclusionLightValue(Object iBlockState) {
		return super.getAmbientOcclusionLightValue((IBlockState) iBlockState);
	}

	@Override
	public boolean addHitEffects(IBlockState iBlockState, World world, RayTraceResult rayTraceResult, EffectRenderer effectRenderer) {
		return master != null ? master.addHitEffects(iBlockState, world, rayTraceResult, effectRenderer) : super.addHitEffects(iBlockState, world, rayTraceResult, effectRenderer);
	}

	@Override
	public boolean superAddHitEffects(Object iBlockState, Object world, Object rayTraceResult, Object effectRenderer) {
		return super.addHitEffects((IBlockState) iBlockState, (World) world, (RayTraceResult) rayTraceResult, (EffectRenderer) effectRenderer);
	}
	// 190~
	@Override
	public boolean isFullyOpaque(IBlockState iBlockState) {
		return master != null ? master.isFullyOpaque(iBlockState) : super.isFullyOpaque(iBlockState);
	}

	public boolean superIsFullyOpaque(Object iBlockState) {
		return super.isFullyOpaque((IBlockState) iBlockState);
	}

	@Override
	public IBlockState withRotation(IBlockState iBlockState, Rotation rotation) {
		return (IBlockState) (master != null ? master.withRotation(iBlockState, rotation) : super.withRotation(iBlockState, rotation));
	}

	public IBlockState superWithRotation(Object iBlockState, Object rotation) {
		return super.withRotation((IBlockState) iBlockState, (Rotation) rotation);
	}

	@Override
	public IBlockState withMirror(IBlockState iBlockState, Mirror mirror) {
		return (IBlockState) (master != null ? master.withMirror(iBlockState, mirror) : super.withMirror(iBlockState, mirror));
	}

	public IBlockState superWithMirror(Object iBlockState, Object mirror) {
		return super.withMirror((IBlockState) iBlockState, (Mirror) mirror);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox(iBlockState, iBlockAccess, blockPos) : super.getBoundingBox(iBlockState, iBlockAccess, blockPos));
	}

	public AxisAlignedBB superGetBoundingBox(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getBoundingBox((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public void addCollisionBoxToList(IBlockState iBlockState, World world, BlockPos blockPos, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> p_185477_5_, Entity entity) {
		if (master != null) master.addCollisionBoxToList(iBlockState, world, blockPos, axisAlignedBB, p_185477_5_, entity);
		else super.addCollisionBoxToList(iBlockState, world, blockPos, axisAlignedBB, p_185477_5_, entity);
	}

	public void superAddCollisionBoxToList(Object iBlockState, Object world, Object blockPos, Object axisAlignedBB, Object p_185477_5_, Object entity) {
		super.addCollisionBoxToList((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (AxisAlignedBB) axisAlignedBB, (List) p_185477_5_, (Entity) entity);
	}

	@Override
	protected RayTraceResult rayTrace(BlockPos blockPos, Vec3d vec3d, Vec3d vec3d1, AxisAlignedBB axisAlignedBB) {
		return (RayTraceResult) (master != null ? master.rayTrace(blockPos, vec3d, vec3d1, axisAlignedBB) : super.rayTrace(blockPos, vec3d, vec3d1, axisAlignedBB));
	}

	public RayTraceResult superRayTrace(Object blockPos, Object vec3d, Object vec3d1, Object axisAlignedBB) {
		return super.rayTrace((BlockPos) blockPos, (Vec3d) vec3d, (Vec3d) vec3d1, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public boolean canSpawnInBlock() {
		return master != null ? master.canSpawnInBlock() : super.canSpawnInBlock();
	}

	public boolean superCanSpawnInBlock() {
		return super.canSpawnInBlock();
	}

	@Override
	public SoundType getStepSound() {
		return (SoundType) (master != null ? master.getStepSound() : super.getStepSound());
	}

	public SoundType superGetStepSound() {
		return super.getStepSound();
	}

	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	public String superToString() {
		return super.toString();
	}

	@Override
	public boolean doesSideBlockRendering(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.doesSideBlockRendering(iBlockState, iBlockAccess, blockPos, enumFacing) : super.doesSideBlockRendering(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	public boolean superDoesSideBlockRendering(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.doesSideBlockRendering((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean addLandingEffects(IBlockState iBlockState, WorldServer worldServer, BlockPos blockPos, IBlockState iBlockState1, EntityLivingBase entityLivingBase, int numberOfParticles) {
		return master != null ? master.addLandingEffects(iBlockState, worldServer, blockPos, iBlockState1, entityLivingBase, numberOfParticles) : super.addLandingEffects(iBlockState, worldServer, blockPos, iBlockState1, entityLivingBase, numberOfParticles);
	}

	public boolean superAddLandingEffects(Object iBlockState, Object worldServer, Object blockPos, Object iBlockState1, Object entityLivingBase, int numberOfParticles) {
		return super.addLandingEffects((IBlockState) iBlockState, (WorldServer) worldServer, (BlockPos) blockPos, (IBlockState) iBlockState1, (EntityLivingBase) entityLivingBase, numberOfParticles);
	}

	@Override
	public Boolean isEntityInsideMaterial(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, Entity entity, double yToTest, Material material, boolean testingHead) {
		return (Boolean) (master != null ? master.isEntityInsideMaterial(iBlockAccess, blockPos, iBlockState, entity, yToTest, material, testingHead) : super.isEntityInsideMaterial(iBlockAccess, blockPos, iBlockState, entity, yToTest, material, testingHead));
	}

	public Boolean superIsEntityInsideMaterial(Object iBlockAccess, Object blockPos, Object iBlockState, Object entity, double yToTest, Object material, boolean testingHead) {
		return super.isEntityInsideMaterial((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (IBlockState) iBlockState, (Entity) entity, yToTest, (Material) material, testingHead);
	}

	@Override
	public Boolean isAABBInsideMaterial(World world, BlockPos blockPos, AxisAlignedBB axisAlignedBB, Material material) {
		return (Boolean) (master != null ? master.isAABBInsideMaterial(world, blockPos, axisAlignedBB, material) : super.isAABBInsideMaterial(world, blockPos, axisAlignedBB, material));
	}

	public Boolean superIsAABBInsideMaterial(Object world, Object blockPos, Object axisAlignedBB, Object material) {
		return super.isAABBInsideMaterial((World) world, (BlockPos) blockPos, (AxisAlignedBB) axisAlignedBB, (Material) material);
	}
	// ~164
	protected void initializeBlock() {
	}

	@Override
	public void superInitializeBlock() {
	}

	public float getBlockBrightness(IBlockAccess iBlockAccess, int par2, int par3, int par4) {
		return 0.0F;
	}

	@Override
	public float superGetBlockBrightness(Object iBlockAccess, int par2, int par3, int par4) {
		return 0.0F;
	}

	public void addCreativeItems(ArrayList itemList) {
	}

	@Override
	public void superAddCreativeItems(ArrayList itemList) {
	}

	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean superCanDragonDestroy(Object world, int x, int y, int z) {
		return true;
	}

	public boolean weakTileChanges() {
		return false;
	}

	@Override
	public boolean superWeakTileChanges() {
		return false;
	}

	public float getFilledPercentage(World world, int x, int y, int z) {
		return 0.0F;
	}

	@Override
	public float superGetFilledPercentage(Object world, int x, int y, int z) {
		return 0.0F;
	}

	@Override
	public float superGetAmbientOcclusionLightValue(Object iBlockAccess, int par2, int par3, int par4) {
		return superGetAmbientOcclusionLightValue();
	}

	@Override
	public int superGetFlammability(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return superGetFlammability(iBlockAccess, x, y, z, forgeDirection);
	}

	@Override
	public boolean superIsFlammable(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return superIsFlammable(iBlockAccess, x, y, z, forgeDirection);
	}

	@Override
	public int superGetFireSpreadSpeed(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return superGetFireSpreadSpeed(iBlockAccess, x, y, z, forgeDirection);
	}

	@Override
	public boolean superIsFireSource(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return superIsFireSource(iBlockAccess, x, y, z, forgeDirection);
	}

	@Override
	public boolean isPassable(IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isPassable(iBlockAccess, blockPos) : super.isPassable(iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsPassable(Object iBlockAccess, Object blockPos) {
		return super.isPassable((IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public float getBlockHardness(IBlockState iBlockState, World world, BlockPos blockPos) {
		return master != null ? master.getBlockHardness(iBlockState, world, blockPos) : super.getBlockHardness(iBlockState, world, blockPos);
	}

	@Override
	public float superGetBlockHardness(Object iBlockState, Object world, Object blockPos) {
		return super.getBlockHardness((IBlockState) iBlockState, (World) world, (BlockPos) blockPos);
	}

	@Override
	public int getPackedLightmapCoords(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.getPackedLightmapCoords(iBlockState, iBlockAccess, blockPos) : super.getPackedLightmapCoords(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public int superGetPackedLightmapCoords(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getPackedLightmapCoords((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.shouldSideBeRendered(iBlockState, iBlockAccess, blockPos, enumFacing) : super.shouldSideBeRendered(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superShouldSideBeRendered(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.shouldSideBeRendered((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean isBlockSolid(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.isBlockSolid(iBlockAccess, blockPos, enumFacing) : super.isBlockSolid(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superIsBlockSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.isBlockSolid((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState iBlockState, World world, BlockPos blockPos) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox(iBlockState, world, blockPos) : super.getCollisionBoundingBox(iBlockState, world, blockPos));
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox(Object iBlockState, Object world, Object blockPos) {
		return super.getCollisionBoundingBox((IBlockState) iBlockState, (World) world, (BlockPos) blockPos);
	}

	@Override
	public boolean canCollideCheck(IBlockState iBlockState, boolean par2) {
		return master != null ? master.canCollideCheck(iBlockState, par2) : super.canCollideCheck(iBlockState, par2);
	}

	@Override
	public boolean superCanCollideCheck(Object iBlockState, boolean par2) {
		return super.canCollideCheck((IBlockState) iBlockState, par2);
	}

	@Override
	public void updateTick(World world, BlockPos blockPos, IBlockState iBlockState, Random par5Random) {
		if (master != null) master.updateTick(world, blockPos, iBlockState, par5Random);
		else super.updateTick(world, blockPos, iBlockState, par5Random);
	}

	@Override
	public void superUpdateTick(Object world, Object blockPos, Object iBlockState, Random par5Random) {
		super.updateTick((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, par5Random);
	}

	@Override
	public void randomDisplayTick(IBlockState iBlockState, World world, BlockPos blockPos, Random par5Random) {
		if (master != null) master.randomDisplayTick(iBlockState, world, blockPos, par5Random);
		else super.randomDisplayTick(iBlockState, world, blockPos, par5Random);
	}

	@Override
	public void superRandomDisplayTick(Object iBlockState, Object world, Object blockPos, Random par5Random) {
		super.randomDisplayTick((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, par5Random);
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos blockPos, IBlockState iBlockState) {
		if (master != null) master.onBlockDestroyedByPlayer(world, blockPos, iBlockState);
		else super.onBlockDestroyedByPlayer(world, blockPos, iBlockState);
	}

	@Override
	public void superOnBlockDestroyedByPlayer(Object world, Object blockPos, Object iBlockState) {
		super.onBlockDestroyedByPlayer((World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public void onBlockAdded(World world, BlockPos blockPos, IBlockState iBlockState) {
		if (master != null) master.onBlockAdded(world, blockPos, iBlockState);
		else super.onBlockAdded(world, blockPos, iBlockState);
	}

	@Override
	public void superOnBlockAdded(Object world, Object blockPos, Object iBlockState) {
		super.onBlockAdded((World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public float getPlayerRelativeBlockHardness(IBlockState iBlockState, EntityPlayer entityPlayer, World world, BlockPos blockPos) {
		return master != null ? master.getPlayerRelativeBlockHardness(iBlockState, entityPlayer, world, blockPos) : super.getPlayerRelativeBlockHardness(iBlockState, entityPlayer, world, blockPos);
	}

	@Override
	public float superGetPlayerRelativeBlockHardness(Object iBlockState, Object entityPlayer, Object world, Object blockPos) {
		return super.getPlayerRelativeBlockHardness((IBlockState) iBlockState, (EntityPlayer) entityPlayer, (World) world, (BlockPos) blockPos);
	}

	@Override
	public void dropBlockAsItemWithChance(World world, BlockPos blockPos, IBlockState iBlockState, float par6, int par7) {
		if (master != null) master.dropBlockAsItemWithChance(world, blockPos, iBlockState, par6, par7);
		else super.dropBlockAsItemWithChance(world, blockPos, iBlockState, par6, par7);
	}

	@Override
	public void superDropBlockAsItemWithChance(Object world, Object blockPos, Object iBlockState, float par6, int par7) {
		super.dropBlockAsItemWithChance((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, par6, par7);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos blockPos, Entity entity) {
		if (master != null) master.onEntityCollidedWithBlock(world, blockPos, entity);
		else super.onEntityCollidedWithBlock(world, blockPos, entity);
	}

	@Override
	public void superOnEntityCollidedWithBlock(Object world, Object blockPos, Object entity) {
		super.onEntityCollidedWithBlock((World) world, (BlockPos) blockPos, (Entity) entity);
	}

	@Override
	public Block setUnlocalizedName(String par1Str) {
		return (Block) (master != null ? master.setUnlocalizedName(par1Str) : super.setUnlocalizedName(par1Str));
	}

	@Override
	public Block superSetUnlocalizedName(String par1Str) {
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	public boolean isFullBlock(IBlockState iBlockState) {
		return master != null ? master.isFullBlock(iBlockState) : super.isFullBlock(iBlockState);
	}

	@Override
	public boolean superIsFullBlock(Object iBlockState) {
		return super.isFullBlock((IBlockState) iBlockState);
	}

	@Override
	public int getLightOpacity(IBlockState iBlockState) {
		return master != null ? master.getLightOpacity(iBlockState) : super.getLightOpacity(iBlockState);
	}

	@Override
	public int superGetLightOpacity(Object iBlockState) {
		return super.getLightOpacity((IBlockState) iBlockState);
	}

	@Override
	public boolean isTranslucent(IBlockState iBlockState) {
		return master != null ? master.isTranslucent(iBlockState) : super.isTranslucent(iBlockState);
	}

	@Override
	public boolean superIsTranslucent(Object iBlockState) {
		return super.isTranslucent((IBlockState) iBlockState);
	}

	@Override
	public int getLightValue(IBlockState iBlockState) {
		return master != null ? master.getLightValue(iBlockState) : super.getLightValue(iBlockState);
	}

	@Override
	public int superGetLightValue(Object iBlockState) {
		return super.getLightValue((IBlockState) iBlockState);
	}

	@Override
	public boolean getUseNeighborBrightness(IBlockState iBlockState) {
		return master != null ? master.getUseNeighborBrightness(iBlockState) : super.getUseNeighborBrightness(iBlockState);
	}

	@Override
	public boolean superGetUseNeighborBrightness(Object iBlockState) {
		return super.getUseNeighborBrightness((IBlockState) iBlockState);
	}

	@Override
	public Material getMaterial(IBlockState iBlockState) {
		return (Material) (master != null ? master.getMaterial(iBlockState) : super.getMaterial(iBlockState));
	}

	@Override
	public Object superGetMaterial(Object iBlockState) {
		return super.getMaterial((IBlockState) iBlockState);
	}

	@Override
	public MapColor getMapColor(IBlockState iBlockState) {
		return (MapColor) (master != null ? master.getMapColor(iBlockState) : super.getMapColor(iBlockState));
	}

	@Override
	public MapColor superGetMapColor(Object iBlockState) {
		return super.getMapColor((IBlockState) iBlockState);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return (IBlockState) (master != null ? master.getStateFromMeta(meta) : super.getStateFromMeta(meta));
	}

	@Override
	public IBlockState superGetStateFromMeta(int meta) {
		return super.getStateFromMeta(meta);
	}

	@Override
	public int getMetaFromState(IBlockState iBlockState) {
		return master != null ? master.getMetaFromState(iBlockState) : super.getMetaFromState(iBlockState);
	}

	@Override
	public int superGetMetaFromState(Object iBlockState) {
		return super.getMetaFromState((IBlockState) iBlockState);
	}

	@Override
	public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return (IBlockState) (master != null ? master.getActualState(iBlockState, iBlockAccess, blockPos) : super.getActualState(iBlockState, iBlockAccess, blockPos));
	}

	@Override
	public IBlockState superGetActualState(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getActualState((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isNormalCube(IBlockState iBlockState) {
		return master != null ? master.isNormalCube(iBlockState) : super.isNormalCube(iBlockState);
	}

	@Override
	public boolean superIsNormalCube(Object iBlockState) {
		return super.isNormalCube((IBlockState) iBlockState);
	}

	@Override
	public boolean isVisuallyOpaque() {
		return master != null ? master.isVisuallyOpaque() : super.isVisuallyOpaque();
	}

	@Override
	public boolean superIsVisuallyOpaque() {
		return super.isVisuallyOpaque();
	}

	@Override
	public boolean isReplaceable(IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isReplaceable(iBlockAccess, blockPos) : super.isReplaceable(iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsReplaceable(Object iBlockAccess, Object blockPos) {
		return super.isReplaceable((IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState iBlockState, World world, BlockPos blockPos) {
		return (AxisAlignedBB) (master != null ? master.getSelectedBoundingBox(iBlockState, world, blockPos) : super.getSelectedBoundingBox(iBlockState, world, blockPos));
	}

	@Override
	public Object superGetSelectedBoundingBox(Object iBlockState, Object world, Object blockPos) {
		return super.getSelectedBoundingBox((IBlockState) iBlockState, (World) world, (BlockPos) blockPos);
	}

	@Override
	public void randomTick(World world, BlockPos blockPos, IBlockState iBlockState, Random random) {
		if (master != null) master.randomTick(world, blockPos, iBlockState, random);
		else super.randomTick(world, blockPos, iBlockState, random);
	}

	@Override
	public void superRandomTick(Object world, Object blockPos, Object iBlockState, Random random) {
		super.randomTick((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, random);
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos blockPos, IBlockState iBlockState, Block block) {
		if (master != null) master.onNeighborBlockChange(world, blockPos, iBlockState, block);
		else super.onNeighborBlockChange(world, blockPos, iBlockState, block);
	}

	@Override
	public void superOnNeighborBlockChange(Object world, Object blockPos, Object iBlockState, Object block) {
		super.onNeighborBlockChange((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (Block) block);
	}

	@Override
	public void breakBlock(World world, BlockPos blockPos, IBlockState iBlockState) {
		if (master != null) master.breakBlock(world, blockPos, iBlockState);
		else super.breakBlock(world, blockPos, iBlockState);
	}

	@Override
	public void superBreakBlock(Object world, Object blockPos, Object iBlockState) {
		super.breakBlock((World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public Item getItemDropped(IBlockState iBlockState, Random rand, int fortune) {
		return (Item) (master != null ? master.getItemDropped(iBlockState, rand, fortune) : super.getItemDropped(iBlockState, rand, fortune));
	}

	@Override
	public Item superGetItemDropped(Object iBlockState, Random rand, int fortune) {
		return super.getItemDropped((IBlockState) iBlockState, rand, fortune);
	}

	@Override
	public void dropXpOnBlockBreak(World world, BlockPos blockPos, int amount) {
		if (master != null) master.dropXpOnBlockBreak(world, blockPos, amount);
		else super.dropXpOnBlockBreak(world, blockPos, amount);
	}

	@Override
	public void superDropXpOnBlockBreak(Object world, Object blockPos, int amount) {
		super.dropXpOnBlockBreak((World) world, (BlockPos) blockPos, amount);
	}

	@Override
	public int damageDropped(IBlockState iBlockState) {
		return master != null ? master.damageDropped(iBlockState) : super.damageDropped(iBlockState);
	}

	@Override
	public int superDamageDropped(Object iBlockState) {
		return super.damageDropped((IBlockState) iBlockState);
	}

	@Override
	public RayTraceResult collisionRayTrace(IBlockState iBlockState, World world, BlockPos blockPos, Vec3d vec3, Vec3d vec31) {
		return (RayTraceResult) (master != null ? master.collisionRayTrace(iBlockState, world, blockPos, vec3, vec31) : super.collisionRayTrace(iBlockState, world, blockPos, vec3, vec31));
	}

	@Override
	public Object superCollisionRayTrace(Object iBlockState, Object world, Object blockPos, Object vec3, Object vec31) {
		return super.collisionRayTrace((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (Vec3d) vec3, (Vec3d) vec31);
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos blockPos, Explosion explosion) {
		if (master != null) master.onBlockDestroyedByExplosion(world, blockPos, explosion);
		else super.onBlockDestroyedByExplosion(world, blockPos, explosion);
	}

	@Override
	public void superOnBlockDestroyedByExplosion(Object world, Object blockPos, Object explosion) {
		super.onBlockDestroyedByExplosion((World) world, (BlockPos) blockPos, (Explosion) explosion);
	}

	@Override
	public boolean canReplace(World world, BlockPos blockPos, EnumFacing enumFacing, ItemStack itemStack) {
		return master != null ? master.canReplace(world, blockPos, enumFacing, itemStack) : super.canReplace(world, blockPos, enumFacing, itemStack);
	}

	@Override
	public boolean superCanReplace(Object world, Object blockPos, Object enumFacing, Object itemStack) {
		return super.canReplace((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, (ItemStack) itemStack);
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.canPlaceBlockOnSide(world, blockPos, enumFacing) : super.canPlaceBlockOnSide(world, blockPos, enumFacing);
	}

	@Override
	public boolean superCanPlaceBlockOnSide(Object world, Object blockPos, Object enumFacing) {
		return super.canPlaceBlockOnSide((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return (BlockRenderLayer) (master != null ? master.getBlockLayer() : super.getBlockLayer());
	}

	@Override
	public Object superGetBlockLayer() {
		return super.getBlockLayer();
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos blockPos) {
		return master != null ? master.canPlaceBlockAt(world, blockPos) : super.canPlaceBlockAt(world, blockPos);
	}

	@Override
	public boolean superCanPlaceBlockAt(Object world, Object blockPos) {
		return super.canPlaceBlockAt((World) world, (BlockPos) blockPos);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumHand enumHand, ItemStack itemStack, EnumFacing enumFacing, float hitX, float hitY, float hitZ) {
		return master != null ? master.onBlockActivated(world, blockPos, iBlockState, entityPlayer, enumHand, itemStack, enumFacing, hitX, hitY, hitZ) : super.onBlockActivated(world, blockPos, iBlockState, entityPlayer, enumHand, itemStack, enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean superOnBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumHand, Object itemStack, Object enumFacing, float hitX, float hitY, float hitZ) {
		return super.onBlockActivated((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (EntityPlayer) entityPlayer, (EnumHand) enumHand, (ItemStack) itemStack, (EnumFacing) enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos blockPos, EnumFacing enumFacing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entityLivingBase) {
		return (IBlockState) (master != null ? master.onBlockPlaced(world, blockPos, enumFacing, hitX, hitY, hitZ, meta, entityLivingBase) : super.onBlockPlaced(world, blockPos, enumFacing, hitX, hitY, hitZ, meta, entityLivingBase));
	}

	@Override
	public IBlockState superOnBlockPlaced(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase) {
		return super.onBlockPlaced((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, hitX, hitY, hitZ, meta, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public void onBlockClicked(World world, BlockPos blockPos, EntityPlayer entityPlayer) {
		if (master != null) master.onBlockClicked(world, blockPos, entityPlayer);
		else super.onBlockClicked(world, blockPos, entityPlayer);
	}

	@Override
	public void superOnBlockClicked(Object world, Object blockPos, Object entityPlayer) {
		super.onBlockClicked((World) world, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
	}

	@Override
	public Vec3d modifyAcceleration(World world, BlockPos blockPos, Entity entity, Vec3d vec3) {
		return (Vec3d) (master != null ? master.modifyAcceleration(world, blockPos, entity, vec3) : super.modifyAcceleration(world, blockPos, entity, vec3));
	}

	@Override
	public Vec3d superModifyAcceleration(Object world, Object blockPos, Object entity, Object vec3) {
		return super.modifyAcceleration((World) world, (BlockPos) blockPos, (Entity) entity, (Vec3d) vec3);
	}

	public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
		return -1;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos blockPos, IBlockState iBlockState, Entity entity) {
		if (master != null) master.onEntityCollidedWithBlock(world, blockPos, iBlockState, entity);
		else super.onEntityCollidedWithBlock(world, blockPos, iBlockState, entity);
	}

	@Override
	public void superOnEntityCollidedWithBlock(Object world, Object blockPos, Object iBlockState, Object entity) {
		super.onEntityCollidedWithBlock((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (Entity) entity);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityPlayer, BlockPos blockPos, IBlockState iBlockState, TileEntity tileEntity, ItemStack itemStack) {
		if (master != null) master.harvestBlock(world, entityPlayer, blockPos, iBlockState, tileEntity, itemStack);
		else super.harvestBlock(world, entityPlayer, blockPos, iBlockState, tileEntity, itemStack);
	}

	@Override
	public void superHarvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity, Object itemStack) {
		super.harvestBlock((World) world, (EntityPlayer) entityPlayer, (BlockPos) blockPos, (IBlockState) iBlockState, (TileEntity) tileEntity, (ItemStack) itemStack);
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState iBlockState) {
		return (ItemStack) (master != null ? master.createStackedBlock(iBlockState) : super.createStackedBlock(iBlockState));
	}

	@Override
	public ItemStack superCreateStackedBlock(Object iBlockState) {
		return super.createStackedBlock((IBlockState) iBlockState);
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		if (master != null) master.onBlockPlacedBy(world, blockPos, iBlockState, entityLivingBase, itemStack);
		else super.onBlockPlacedBy(world, blockPos, iBlockState, entityLivingBase, itemStack);
	}

	@Override
	public void superOnBlockPlacedBy(Object world, Object blockPos, Object iBlockState, Object entityLivingBase, Object itemStack) {
		super.onBlockPlacedBy((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (EntityLivingBase) entityLivingBase, (ItemStack) itemStack);
	}

	@Override
	public boolean onBlockEventReceived(World world, BlockPos blockPos, IBlockState iBlockState, int eventID, int eventParam) {
		return master != null ? master.onBlockEventReceived(world, blockPos, iBlockState, eventID, eventParam) : super.onBlockEventReceived(world, blockPos, iBlockState, eventID, eventParam);
	}

	@Override
	public boolean superOnBlockEventReceived(Object world, Object blockPos, Object iBlockState, int eventID, int eventParam) {
		return super.onBlockEventReceived((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, eventID, eventParam);
	}

	@Override
	public void onFallenUpon(World world, BlockPos blockPos, Entity entity, float fallDistance) {
		if (master != null) master.onFallenUpon(world, blockPos, entity, fallDistance);
		else super.onFallenUpon(world, blockPos, entity, fallDistance);
	}

	@Override
	public void superOnFallenUpon(Object world, Object blockPos, Object entity, float fallDistance) {
		super.onFallenUpon((World) world, (BlockPos) blockPos, (Entity) entity, fallDistance);
	}

	@Override
	public void onLanded(World world, Entity entity) {
		if (master != null) master.onLanded(world, entity);
		else super.onLanded(world, entity);
	}

	@Override
	public void superOnLanded(Object world, Object entity) {
		super.onLanded((World) world, (Entity) entity);
	}

	@Override
	public ItemStack getItem(World world, BlockPos blockPos, IBlockState iBlockState) {
		return (ItemStack) (master != null ? master.getItem(world, blockPos, iBlockState) : super.getItem(world, blockPos, iBlockState));
	}

	@Override
	public Object superGetItem(Object world, Object blockPos, Object iBlockState) {
		return super.getItem((World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public void onBlockHarvested(World world, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
		if (master != null) master.onBlockHarvested(world, blockPos, iBlockState, entityPlayer);
		else super.onBlockHarvested(world, blockPos, iBlockState, entityPlayer);
	}

	@Override
	public void superOnBlockHarvested(Object world, Object blockPos, Object iBlockState, Object entityPlayer) {
		super.onBlockHarvested((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (EntityPlayer) entityPlayer);
	}

	@Override
	public void fillWithRain(World world, BlockPos blockPos) {
		if (master != null) master.fillWithRain(world, blockPos);
		else super.fillWithRain(world, blockPos);
	}

	@Override
	public void superFillWithRain(Object world, Object blockPos) {
		super.fillWithRain((World) world, (BlockPos) blockPos);
	}

	@Override
	public int getComparatorInputOverride(IBlockState iBlockState, World world, BlockPos blockPos) {
		return master != null ? master.getComparatorInputOverride(iBlockState, world, blockPos) : super.getComparatorInputOverride(iBlockState, world, blockPos);
	}

	@Override
	public int superGetComparatorInputOverride(Object iBlockState, Object world, Object blockPos) {
		return super.getComparatorInputOverride((IBlockState) iBlockState, (World) world, (BlockPos) blockPos);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return (BlockStateContainer) (master != null ? master.createBlockState() : super.createBlockState());
	}

	@Override
	public Object superCreateBlockState() {
		return super.createBlockState();
	}

	@Override
	public BlockStateContainer getBlockState() {
		return (BlockStateContainer) (master != null ? master.getBlockState() : super.getBlockState());
	}

	@Override
	public BlockStateContainer superGetBlockState() {
		return super.getBlockState();
	}

	@Override
	public EnumOffsetType getOffsetType() {
		return (EnumOffsetType) (master != null ? master.getOffsetType() : super.getOffsetType());
	}

	@Override
	public EnumOffsetType superGetOffsetType() {
		return super.getOffsetType();
	}

	@Override
	public int getLightValue(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.getLightValue(iBlockState, iBlockAccess, blockPos) : super.getLightValue(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public int superGetLightValue(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getLightValue((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isLadder(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EntityLivingBase entityLivingBase) {
		return master != null ? master.isLadder(iBlockState, iBlockAccess, blockPos, entityLivingBase) : super.isLadder(iBlockState, iBlockAccess, blockPos, entityLivingBase);
	}

	@Override
	public boolean superIsLadder(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityLivingBase) {
		return super.isLadder((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean isNormalCube(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isNormalCube(iBlockState, iBlockAccess, blockPos) : super.isNormalCube(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsNormalCube(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.isNormalCube((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isSideSolid(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.isSideSolid(iBlockState, iBlockAccess, blockPos, enumFacing) : super.isSideSolid(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superIsSideSolid(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.isSideSolid((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean isBurning(IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isBurning(iBlockAccess, blockPos) : super.isBurning(iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsBurning(Object iBlockAccess, Object blockPos) {
		return super.isBurning((IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isAir(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isAir(iBlockState, iBlockAccess, blockPos) : super.isAir(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsAir(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.isAir((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess iBlockAccess, BlockPos blockPos, EntityPlayer entityPlayer) {
		return master != null ? master.canHarvestBlock(iBlockAccess, blockPos, entityPlayer) : super.canHarvestBlock(iBlockAccess, blockPos, entityPlayer);
	}

	@Override
	public boolean superCanHarvestBlock(Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return super.canHarvestBlock((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean removedByPlayer(IBlockState iBlockState, World world, BlockPos blockPos, EntityPlayer entityPlayer, boolean willHarvest) {
		return master != null ? master.removedByPlayer(iBlockState, world, blockPos, entityPlayer, willHarvest) : super.removedByPlayer(iBlockState, world, blockPos, entityPlayer, willHarvest);
	}

	@Override
	public boolean superRemovedByPlayer(Object iBlockState, Object world, Object blockPos, Object entityPlayer, boolean willHarvest) {
		return super.removedByPlayer((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (EntityPlayer) entityPlayer, willHarvest);
	}

	@Override
	public int getFlammability(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.getFlammability(iBlockAccess, blockPos, enumFacing) : super.getFlammability(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public int superGetFlammability(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.getFlammability((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean isFlammable(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.isFlammable(iBlockAccess, blockPos, enumFacing) : super.isFlammable(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superIsFlammable(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.isFlammable((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.getFireSpreadSpeed(iBlockAccess, blockPos, enumFacing) : super.getFireSpreadSpeed(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public int superGetFireSpreadSpeed(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.getFireSpreadSpeed((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean isFireSource(World world, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.isFireSource(world, blockPos, enumFacing) : super.isFireSource(world, blockPos, enumFacing);
	}

	@Override
	public boolean superIsFireSource(Object world, Object blockPos, Object enumFacing) {
		return super.isFireSource((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean hasTileEntity(IBlockState iBlockState) {
		return master != null ? master.hasTileEntity(iBlockState) : super.hasTileEntity(iBlockState);
	}

	@Override
	public boolean superHasTileEntity(Object iBlockState) {
		return super.hasTileEntity((IBlockState) iBlockState);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState iBlockState) {
		return (TileEntity) (master != null ? master.createTileEntity(world, iBlockState) : super.createTileEntity(world, iBlockState));
	}

	@Override
	public TileEntity superCreateTileEntity(Object world, Object iBlockState) {
		return super.createTileEntity((World) world, (IBlockState) iBlockState);
	}

	@Override
	public int quantityDropped(IBlockState iBlockState, int fortune, Random random) {
		return master != null ? master.quantityDropped(iBlockState, fortune, random) : super.quantityDropped(iBlockState, fortune, random);
	}

	@Override
	public int superQuantityDropped(Object iBlockState, int fortune, Random random) {
		return super.quantityDropped((IBlockState) iBlockState, fortune, random);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, int fortune) {
		return (List<ItemStack>) (master != null ? master.getDrops(iBlockAccess, blockPos, iBlockState, fortune) : super.getDrops(iBlockAccess, blockPos, iBlockState, fortune));
	}

	@Override
	public List<ItemStack> superGetDrops(Object iBlockAccess, Object blockPos, Object iBlockState, int fortune) {
		return super.getDrops((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (IBlockState) iBlockState, fortune);
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer) {
		return master != null ? master.canSilkHarvest(world, blockPos, iBlockState, entityPlayer) : super.canSilkHarvest(world, blockPos, iBlockState, entityPlayer);
	}

	@Override
	public boolean superCanSilkHarvest(Object world, Object blockPos, Object iBlockState, Object entityPlayer) {
		return super.canSilkHarvest((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean canCreatureSpawn(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, SpawnPlacementType spawnPlacementType) {
		return master != null ? master.canCreatureSpawn(iBlockState, iBlockAccess, blockPos, spawnPlacementType) : super.canCreatureSpawn(iBlockState, iBlockAccess, blockPos, spawnPlacementType);
	}

	@Override
	public boolean superCanCreatureSpawn(Object iBlockState, Object iBlockAccess, Object blockPos, Object spawnPlacementType) {
		return super.canCreatureSpawn((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (SpawnPlacementType) spawnPlacementType);
	}

	@Override
	public boolean isBed(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, Entity entity) {
		return master != null ? master.isBed(iBlockState, iBlockAccess, blockPos, entity) : super.isBed(iBlockState, iBlockAccess, blockPos, entity);
	}

	@Override
	public boolean superIsBed(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity) {
		return super.isBed((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (Entity) entity);
	}

	@Override
	public BlockPos getBedSpawnPosition(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EntityPlayer entityPlayer) {
		return (BlockPos) (master != null ? master.getBedSpawnPosition(iBlockState, iBlockAccess, blockPos, entityPlayer) : super.getBedSpawnPosition(iBlockState, iBlockAccess, blockPos, entityPlayer));
	}

	@Override
	public Object superGetBedSpawnPosition(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return super.getBedSpawnPosition((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
	}

	@Override
	public void setBedOccupied(IBlockAccess iBlockAccess, BlockPos blockPos, EntityPlayer entityPlayer, boolean occupied) {
		if (master != null) master.setBedOccupied(iBlockAccess, blockPos, entityPlayer, occupied);
		else super.setBedOccupied(iBlockAccess, blockPos, entityPlayer, occupied);
	}

	@Override
	public void superSetBedOccupied(Object iBlockAccess, Object blockPos, Object entityPlayer, boolean occupied) {
		super.setBedOccupied((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EntityPlayer) entityPlayer, occupied);
	}

	@Override
	public EnumFacing getBedDirection(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return (EnumFacing) (master != null ? master.getBedDirection(iBlockState, iBlockAccess, blockPos) : super.getBedDirection(iBlockState, iBlockAccess, blockPos));
	}

	@Override
	public Object superGetBedDirection(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getBedDirection((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isBedFoot(IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isBedFoot(iBlockAccess, blockPos) : super.isBedFoot(iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsBedFoot(Object iBlockAccess, Object blockPos) {
		return super.isBedFoot((IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public void beginLeavesDecay(IBlockState iBlockState, World world, BlockPos blockPos) {
		if (master != null) master.beginLeavesDecay(iBlockState, world, blockPos);
		else super.beginLeavesDecay(iBlockState, world, blockPos);
	}

	@Override
	public void superBeginLeavesDecay(Object iBlockState, Object world, Object blockPos) {
		super.beginLeavesDecay((IBlockState) iBlockState, (World) world, (BlockPos) blockPos);
	}

	@Override
	public boolean canSustainLeaves(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.canSustainLeaves(iBlockState, iBlockAccess, blockPos) : super.canSustainLeaves(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean superCanSustainLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.canSustainLeaves((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isLeaves(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isLeaves(iBlockState, iBlockAccess, blockPos) : super.isLeaves(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.isLeaves((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean canBeReplacedByLeaves(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.canBeReplacedByLeaves(iBlockState, iBlockAccess, blockPos) : super.canBeReplacedByLeaves(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean superCanBeReplacedByLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.canBeReplacedByLeaves((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isWood(IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isWood(iBlockAccess, blockPos) : super.isWood(iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsWood(Object iBlockAccess, Object blockPos) {
		return super.isWood((IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isReplaceableOreGen(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, Predicate<IBlockState> predicate) {
		return master != null ? master.isReplaceableOreGen(iBlockState, iBlockAccess, blockPos, predicate) : super.isReplaceableOreGen(iBlockState, iBlockAccess, blockPos, predicate);
	}

	@Override
	public boolean superIsReplaceableOreGen(Object iBlockState, Object iBlockAccess, Object blockPos, Object predicate) {
		return super.isReplaceableOreGen((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (Predicate<IBlockState>) predicate);
	}

	@Override
	public float getExplosionResistance(World world, BlockPos blockPos, Entity entity, Explosion explosion) {
		return master != null ? master.getExplosionResistance(world, blockPos, entity, explosion) : super.getExplosionResistance(world, blockPos, entity, explosion);
	}

	@Override
	public float superGetExplosionResistance(Object world, Object blockPos, Object entity, Object explosion) {
		return super.getExplosionResistance((World) world, (BlockPos) blockPos, (Entity) entity, (Explosion) explosion);
	}

	@Override
	public void onBlockExploded(World world, BlockPos blockPos, Explosion explosion) {
		if (master != null) master.onBlockExploded(world, blockPos, explosion);
		else super.onBlockExploded(world, blockPos, explosion);
	}

	@Override
	public void superOnBlockExploded(Object world, Object blockPos, Object explosion) {
		super.onBlockExploded((World) world, (BlockPos) blockPos, (Explosion) explosion);
	}

	@Override
	public boolean canConnectRedstone(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.canConnectRedstone(iBlockState, iBlockAccess, blockPos, enumFacing) : super.canConnectRedstone(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superCanConnectRedstone(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.canConnectRedstone((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean canPlaceTorchOnTop(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.canPlaceTorchOnTop(iBlockState, iBlockAccess, blockPos) : super.canPlaceTorchOnTop(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean superCanPlaceTorchOnTop(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.canPlaceTorchOnTop((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public ItemStack getPickBlock(IBlockState iBlockState, RayTraceResult rayTraceResult, World world, BlockPos blockPos, EntityPlayer entityPlayer) {
		return (ItemStack) (master != null ? master.getPickBlock(iBlockState, rayTraceResult, world, blockPos, entityPlayer) : super.getPickBlock(iBlockState, rayTraceResult, world, blockPos, entityPlayer));
	}

	@Override
	public Object superGetPickBlock(Object iBlockState, Object movingObjectPosition, Object world, Object blockPos, Object entityPlayer) {
		return super.getPickBlock((IBlockState) iBlockState, (RayTraceResult) movingObjectPosition, (World) world, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isFoliage(IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.isFoliage(iBlockAccess, blockPos) : super.isFoliage(iBlockAccess, blockPos);
	}

	@Override
	public boolean superIsFoliage(Object iBlockAccess, Object blockPos) {
		return super.isFoliage((IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean addDestroyEffects(World world, BlockPos blockPos, EffectRenderer effectRenderer) {
		return master != null ? master.addDestroyEffects(world, blockPos, effectRenderer) : super.addDestroyEffects(world, blockPos, effectRenderer);
	}

	@Override
	public boolean superAddDestroyEffects(Object world, Object blockPos, Object effectRenderer) {
		return super.addDestroyEffects((World) world, (BlockPos) blockPos, (EffectRenderer) effectRenderer);
	}

	@Override
	public boolean canSustainPlant(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing, IPlantable iPlantable) {
		return master != null ? master.canSustainPlant(iBlockState, iBlockAccess, blockPos, enumFacing, iPlantable) : super.canSustainPlant(iBlockState, iBlockAccess, blockPos, enumFacing, iPlantable);
	}

	@Override
	public boolean superCanSustainPlant(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable) {
		return super.canSustainPlant((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing, (IPlantable) iPlantable);
	}

	@Override
	public void onPlantGrow(IBlockState iBlockState, World world, BlockPos blockPos, BlockPos blockPos1) {
		if (master != null) master.onPlantGrow(iBlockState, world, blockPos, blockPos1);
		else super.onPlantGrow(iBlockState, world, blockPos, blockPos1);
	}

	@Override
	public void superOnPlantGrow(Object iBlockState, Object world, Object blockPos, Object blockPos1) {
		super.onPlantGrow((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (BlockPos) blockPos1);
	}

	@Override
	public boolean isFertile(World world, BlockPos blockPos) {
		return master != null ? master.isFertile(world, blockPos) : super.isFertile(world, blockPos);
	}

	@Override
	public boolean superIsFertile(Object world, Object blockPos) {
		return super.isFertile((World) world, (BlockPos) blockPos);
	}

	@Override
	public int getLightOpacity(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.getLightOpacity(iBlockState, iBlockAccess, blockPos) : super.getLightOpacity(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public int superGetLightOpacity(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getLightOpacity((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean canEntityDestroy(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, Entity entity) {
		return master != null ? master.canEntityDestroy(iBlockState, iBlockAccess, blockPos, entity) : super.canEntityDestroy(iBlockState, iBlockAccess, blockPos, entity);
	}

	@Override
	public boolean superCanEntityDestroy(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity) {
		return super.canEntityDestroy((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (Entity) entity);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess iBlockAccess, BlockPos blockPos, BlockPos blockPos1) {
		return master != null ? master.isBeaconBase(iBlockAccess, blockPos, blockPos1) : super.isBeaconBase(iBlockAccess, blockPos, blockPos1);
	}

	@Override
	public boolean superIsBeaconBase(Object iBlockAccess, Object blockPos, Object blockPos1) {
		return super.isBeaconBase((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (BlockPos) blockPos1);
	}

	@Override
	public boolean rotateBlock(World world, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.rotateBlock(world, blockPos, enumFacing) : super.rotateBlock(world, blockPos, enumFacing);
	}

	@Override
	public boolean superRotateBlock(Object world, Object blockPos, Object enumFacing) {
		return super.rotateBlock((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public EnumFacing[] getValidRotations(World world, BlockPos blockPos) {
		return (EnumFacing[]) (master != null ? master.getValidRotations(world, blockPos) : super.getValidRotations(world, blockPos));
	}

	@Override
	public EnumFacing[] superGetValidRotations(Object world, Object blockPos) {
		return super.getValidRotations((World) world, (BlockPos) blockPos);
	}

	@Override
	public float getEnchantPowerBonus(World world, BlockPos blockPos) {
		return master != null ? master.getEnchantPowerBonus(world, blockPos) : super.getEnchantPowerBonus(world, blockPos);
	}

	@Override
	public float superGetEnchantPowerBonus(Object world, Object blockPos) {
		return super.getEnchantPowerBonus((World) world, (BlockPos) blockPos);
	}

	@Override
	public boolean recolorBlock(World world, BlockPos blockPos, EnumFacing enumFacing, EnumDyeColor enumDyeColor) {
		return master != null ? master.recolorBlock(world, blockPos, enumFacing, enumDyeColor) : super.recolorBlock(world, blockPos, enumFacing, enumDyeColor);
	}

	@Override
	public boolean superRecolorBlock(Object world, Object blockPos, Object enumFacing, Object enumDyeColor) {
		return super.recolorBlock((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, (EnumDyeColor) enumDyeColor);
	}

	@Override
	public int getExpDrop(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, int fortune) {
		return master != null ? master.getExpDrop(iBlockState, iBlockAccess, blockPos, fortune) : super.getExpDrop(iBlockState, iBlockAccess, blockPos, fortune);
	}

	@Override
	public int superGetExpDrop(Object iBlockState, Object iBlockAccess, Object blockPos, int fortune) {
		return super.getExpDrop((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, fortune);
	}

	@Override
	public void onNeighborChange(IBlockAccess iBlockAccess, BlockPos blockPos, BlockPos blockPos1) {
		if (master != null) master.onNeighborChange(iBlockAccess, blockPos, blockPos1);
		else super.onNeighborChange(iBlockAccess, blockPos, blockPos1);
	}

	@Override
	public void superOnNeighborChange(Object iBlockAccess, Object blockPos, Object blockPos1) {
		super.onNeighborChange((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (BlockPos) blockPos1);
	}

	@Override
	public boolean shouldCheckWeakPower(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.shouldCheckWeakPower(iBlockState, iBlockAccess, blockPos, enumFacing) : super.shouldCheckWeakPower(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superShouldCheckWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.shouldCheckWeakPower((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean getWeakChanges(IBlockAccess iBlockAccess, BlockPos blockPos) {
		return master != null ? master.getWeakChanges(iBlockAccess, blockPos) : super.getWeakChanges(iBlockAccess, blockPos);
	}

	@Override
	public boolean superGetWeakChanges(Object iBlockAccess, Object blockPos) {
		return super.getWeakChanges((IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public void setHarvestLevel(String toolClass, int level) {
		if (master != null) master.setHarvestLevel(toolClass, level);
		else super.setHarvestLevel(toolClass, level);
	}

	@Override
	public void superSetHarvestLevel(String toolClass, int level) {
		super.setHarvestLevel(toolClass, level);
	}

	@Override
	public void setHarvestLevel(String toolClass, int level, IBlockState iBlockState) {
		if (master != null) master.setHarvestLevel(toolClass, level, iBlockState);
		else super.setHarvestLevel(toolClass, level, iBlockState);
	}

	@Override
	public void superSetHarvestLevel(String toolClass, int level, Object iBlockState) {
		super.setHarvestLevel(toolClass, level, (IBlockState) iBlockState);
	}

	@Override
	public String getHarvestTool(IBlockState iBlockState) {
		return master != null ? master.getHarvestTool(iBlockState) : super.getHarvestTool(iBlockState);
	}

	@Override
	public String superGetHarvestTool(Object iBlockState) {
		return super.getHarvestTool((IBlockState) iBlockState);
	}

	@Override
	public int getHarvestLevel(IBlockState iBlockState) {
		return master != null ? master.getHarvestLevel(iBlockState) : super.getHarvestLevel(iBlockState);
	}

	@Override
	public int superGetHarvestLevel(Object iBlockState) {
		return super.getHarvestLevel((IBlockState) iBlockState);
	}

	@Override
	public boolean isToolEffective(String type, IBlockState iBlockState) {
		return master != null ? master.isToolEffective(type, iBlockState) : super.isToolEffective(type, iBlockState);
	}

	@Override
	public boolean superIsToolEffective(String type, Object iBlockState) {
		return super.isToolEffective(type, (IBlockState) iBlockState);
	}

	@Override
	public IBlockState getExtendedState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return (IBlockState) (master != null ? master.getExtendedState(iBlockState, iBlockAccess, blockPos) : super.getExtendedState(iBlockState, iBlockAccess, blockPos));
	}

	@Override
	public IBlockState superGetExtendedState(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getExtendedState((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean canRenderInLayer(BlockRenderLayer enumWorldBlockLayer) {
		return master != null ? master.canRenderInLayer(enumWorldBlockLayer) : super.canRenderInLayer(enumWorldBlockLayer);
	}

	@Override
	public boolean superCanRenderInLayer(Object enumWorldBlockLayer) {
		return super.canRenderInLayer((BlockRenderLayer) enumWorldBlockLayer);
	}

	@Override
	protected List<ItemStack> captureDrops(boolean start) {
		return (List<ItemStack>) (master != null ? master.captureDrops(start) : super.captureDrops(start));
	}

	@Override
	public List<ItemStack> superCaptureDrops(boolean start) {
		return super.captureDrops(start);
	}

	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return master != null ? master.isFullCube(iBlockState) : super.isFullCube(iBlockState);
	}

	@Override
	public boolean superIsFullCube(Object iBlockState) {
		return super.isFullCube((IBlockState) iBlockState);
	}
	// ~179
	public Object getIcon(IBlockAccess iBlockAccess, int par2, int par3, int par4, int par5) {
		return null;
	}

	@Override
	public Object superGetBlockTexture(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return null;
	}

	public Object getIcon(int par1, int par2) {
		return null;
	}

	@Override
	public Object superGetIcon(int par1, int par2) {
		return null;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4) {
		return null;
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBoxFromPool(Object world, int par2, int par3, int par4) {
		return null;
	}

	@Override
	public void superVelocityToAddToEntity(Object world, int par2, int par3, int par4, Object entity, Object vec3) {
	}

	public boolean canBlockStay(World world, int par2, int par3, int par4) {
		return false;
	}

	@Override
	public boolean superCanBlockStay(Object world, int par2, int par3, int par4) {
		return false;
	}

	public void onPostBlockPlaced(World world, int par2, int par3, int par4, int par5) {
	}

	@Override
	public void superOnPostBlockPlaced(Object world, int par2, int par3, int par4, int par5) {
	}

	public void onBlockPreDestroy(World world, int par2, int par3, int par4, int par5) {
	}

	@Override
	public void superOnBlockPreDestroy(Object world, int par2, int par3, int par4, int par5) {
	}

	public void fillWithRain(World world, int par2, int par3, int par4) {
	}

	@Override
	public void superFillWithRain(Object world, int par2, int par3, int par4) {
	}

	protected String getTextureName() {
		return null;
	}

	@Override
	public String superGetTextureName() {
		return null;
	}

	public String getItemIconName() {
		return null;
	}

	@Override
	public String superGetItemIconName() {
		return null;
	}

	@Override
	public boolean requiresUpdates() {
		return master != null ? master.requiresUpdates() : super.requiresUpdates();
	}

	@Override
	public boolean superRequiresUpdates() {
		return super.requiresUpdates();
	}

	public Block setBlockTextureName(String par1Str) {
		return this;
	}

	@Override
	public Block superSetBlockTextureName(String par1Str) {
		return this;
	}

	public void registerBlockIcons(Object iiconRegister) {
	}

	@Override
	public void superRegisterIcons(Object iiconRegister) {
	}

	public boolean isReplaceable(IBlockAccess iBlockAccess, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsReplaceable(Object iBlockAccess, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsPassable(Object iBlockAccess, int par2, int par3, int par4) {
		return false;
	}

	@Override
	public float superGetBlockHardness(Object world, int par2, int par3, int par4) {
		return 0.0F;
	}

	@Override
	public int superGetPackedLightmapCoords(Object iBlockAccess, int par2, int par3, int par4) {
		return -1;
	}

	@Override
	public boolean superShouldSideBeRendered(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return false;
	}

	@Override
	public boolean superIsBlockSolid(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return false;
	}

	@Override
	public void superAddCollisionBoxesToList(Object world, int par2, int par3, int par4, Object axisAlignedBB, List par6List, Object entity) {
	}

	@Override
	public Object superGetCollisionBoundingBox(Object world, int par2, int par3, int par4) {
		return null;
	}

	@Override
	public void superUpdateTick(Object world, int par2, int par3, int par4, Random par5Random) {
	}

	@Override
	public void superRandomDisplayTick(Object world, int par2, int par3, int par4, Random par5Random) {
	}

	@Override
	public void superOnBlockDestroyedByPlayer(Object world, int par2, int par3, int par4, int par5) {
	}

	@Override
	public void superOnNeighborBlockChange(Object world, int par2, int par3, int par4, Object par5) {
	}

	@Override
	public void superOnBlockAdded(Object world, int par2, int par3, int par4) {
	}

	@Override
	public void superBreakBlock(Object world, int par2, int par3, int par4, Object par5, int par6) {
	}

	@Override
	public Object superGetItemDropped(int par1, Random par2Random, int par3) {
		return null;
	}

	@Override
	public float superGetPlayerRelativeBlockHardness(Object entityPlayer, Object world, int par3, int par4, int par5) {
		return 0.0F;
	}

	@Override
	public void superDropBlockAsItemWithChance(Object world, int par2, int par3, int par4, int par5, float par6, int par7) {
	}

	@Override
	public void superDropBlockAsItem(Object world, int par2, int par3, int par4, Object itemStack) {
	}

	@Override
	public void superDropXpOnBlockBreak(Object world, int par2, int par3, int par4, int par5) {
	}

	@Override
	public int superDamageDropped(int par1) {
		return -1;
	}

	@Override
	public Object superCollisionRayTrace(Object world, int par2, int par3, int par4, Object vec3, Object vec31) {
		return null;
	}

	@Override
	public void superOnBlockDestroyedByExplosion(Object world, int par2, int par3, int par4, Object explosion) {
	}

	@Override
	public boolean superCanReplace(Object world, int par2, int par3, int par4, int par5, Object itemStack) {
		return false;
	}

	@Override
	public int superGetRenderBlockPass() {
		return -1;
	}

	@Override
	public boolean superCanPlaceBlockOnSide(Object world, int par2, int par3, int par4, int par5) {
		return false;
	}

	@Override
	public boolean superCanPlaceBlockAt(Object world, int par2, int par3, int par4) {
		return false;
	}

	@Override
	public boolean superOnBlockActivated(Object world, int par2, int par3, int par4, Object entityPlayer, int par6, float par7, float par8, float par9) {
		return false;
	}

	@Override
	public void superOnEntityWalking(Object world, int par2, int par3, int par4, Object entity) {
	}

	@Override
	public int superOnBlockPlaced(Object world, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return -1;
	}

	@Override
	public void superOnBlockClicked(Object world, int par2, int par3, int par4, Object entityPlayer) {
	}

	@Override
	public void superSetBlockBoundsBasedOnState(Object iBlockAccess, int par2, int par3, int par4) {
	}

	@Override
	public int superGetRenderColor(int par1) {
		return -1;
	}

	@Override
	public int superGetWeakPower(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return -1;
	}

	@Override
	public int superColorMultiplier(Object iBlockAccess, int par2, int par3, int par4) {
		return -1;
	}

	@Override
	public void superOnEntityCollidedWithBlock(Object world, int par2, int par3, int par4, Object entity) {
	}

	@Override
	public int superGetStrongPower(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return -1;
	}

	@Override
	public void superHarvestBlock(Object world, Object entityPlayer, int par3, int par4, int par5, int par6) {
	}

	@Override
	public Object superCreateStackedBlock(int par1) {
		return null;
	}

	@Override
	public void superOnBlockPlacedBy(Object world, int par2, int par3, int par4, Object entityLivingBase, Object itemStack) {
	}

	@Override
	public boolean superOnBlockEventReceived(Object world, int par2, int par3, int par4, int par5, int par6) {
		return false;
	}

	@Override
	public void superOnFallenUpon(Object world, int par2, int par3, int par4, Object entity, float par6) {
	}

	@Override
	public Object superGetItem(Object world, int par2, int par3, int par4) {
		return null;
	}

	@Override
	public int superGetDamageValue(Object world, int par2, int par3, int par4) {
		return -1;
	}

	@Override
	public void superOnBlockHarvested(Object world, int par2, int par3, int par4, int par5, Object entityPlayer) {
	}

	@Override
	public int superGetComparatorInputOverride(Object world, int par2, int par3, int par4, int par5) {
		return -1;
	}

	@Override
	public int superGetLightValue(Object iBlockAccess, int x, int y, int z) {
		return -1;
	}

	@Override
	public boolean superIsLadder(Object world, int x, int y, int z, Object entityLivingBase) {
		return false;
	}

	@Override
	public boolean superIsNormalCube(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsSideSolid(Object world, int x, int y, int z, Object forgeDirection) {
		return false;
	}

	@Override
	public boolean superIsBurning(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsAir(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superCanHarvestBlock(Object entityPlayer, int meta) {
		return false;
	}

	@Override
	public boolean superRemovedByPlayer(Object world, Object entityPlayer, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superHasTileEntity(int metadata) {
		return false;
	}

	@Override
	public Object superCreateTileEntity(Object world, int metadata) {
		return null;
	}

	@Override
	public int superQuantityDropped(int meta, int fortune, Random random) {
		return -1;
	}

	@Override
	public Object superGetDrops(Object world, int x, int y, int z, int metadata, int fortune) {
		return null;
	}

	@Override
	public boolean superCanSilkHarvest(Object world, Object entityPlayer, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public boolean superCanCreatureSpawn(Object enumCreatureType, Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsBed(Object world, int x, int y, int z, Object entityLivingBase) {
		return false;
	}

	@Override
	public Object superGetBedSpawnPosition(Object world, int x, int y, int z, Object entityPlayer) {
		return null;
	}

	@Override
	public void superSetBedOccupied(Object world, int x, int y, int z, Object entityPlayer, boolean occupied) {
	}

	@Override
	public int superGetBedDirection(Object iBlockAccess, int x, int y, int z) {
		return -1;
	}

	@Override
	public boolean superIsBedFoot(Object iBlockAccess, int x, int y, int z) {
		return false;
	}

	@Override
	public void superBeginLeavesDecay(Object world, int x, int y, int z) {
	}

	@Override
	public boolean superCanSustainLeaves(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsLeaves(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superCanBeReplacedByLeaves(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsWood(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superIsReplaceableOreGen(Object world, int x, int y, int z, Object target) {
		return false;
	}

	@Override
	public float superGetExplosionResistance(Object entity, Object world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		return 0.0F;
	}

	@Override
	public void superOnBlockExploded(Object world, int x, int y, int z, Object explosion) {
	}

	@Override
	public boolean superCanConnectRedstone(Object iBlockAccess, int x, int y, int z, int side) {
		return false;
	}

	@Override
	public boolean superCanPlaceTorchOnTop(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superCanRenderInPass(int pass) {
		return false;
	}

	@Override
	public Object superGetPickBlock(Object movingObjectPosition, Object world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean superIsFoliage(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean superAddDestroyEffects(Object world, int x, int y, int z, int meta, Object effectRenderer) {
		return false;
	}

	@Override
	public boolean superCanSustainPlant(Object world, int x, int y, int z, Object forgeDirection, Object iPlantable) {
		return false;
	}

	@Override
	public void superOnPlantGrow(Object world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
	}

	@Override
	public boolean superIsFertile(Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public int superGetLightOpacity(Object world, int x, int y, int z) {
		return -1;
	}

	@Override
	public boolean superCanEntityDestroy(Object world, int x, int y, int z, Object entity) {
		return false;
	}

	@Override
	public boolean superIsBeaconBase(Object world, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return false;
	}

	@Override
	public boolean superRotateBlock(Object world, int x, int y, int z, Object forgeDirection) {
		return false;
	}

	@Override
	public Object[] superGetValidRotations(Object world, int x, int y, int z) {
		return null;
	}

	@Override
	public float superGetEnchantPowerBonus(Object world, int x, int y, int z) {
		return 0.0F;
	}

	@Override
	public boolean superRecolourBlock(Object world, int x, int y, int z, Object forgeDirection, int colour) {
		return false;
	}

	@Override
	public int superGetExpDrop(Object world, int data, int enchantmentLevel) {
		return -1;
	}

	@Override
	public void superOnNeighborChange(Object world, int x, int y, int z, int tileX, int tileY, int tileZ) {
	}

	@Override
	public boolean superShouldCheckWeakPower(Object world, int x, int y, int z, int side) {
		return false;
	}

	@Override
	public int superGetFlammability(Object iBlockAccess, int x, int y, int z, Object forgeDirection) {
		return -1;
	}

	@Override
	public boolean superIsFlammable(Object iBlockAccess, int x, int y, int z, Object forgeDirection) {
		return false;
	}

	@Override
	public int superGetFireSpreadSpeed(Object world, int x, int y, int z, Object forgeDirection) {
		return -1;
	}

	@Override
	public boolean superIsFireSource(Object world, int x, int y, int z, Object forgeDirection) {
		return false;
	}

	@Override
	public Object getCollisionBoundingBox(Object world, Object blockPos, Object iBlockState) {
		return null;
	}

	public String superGetUnlocalizedName2() {
		return null;
	}

	public void superOnSetBlockIDWithMetaData(Object world, int par2, int par3, int par4, int par5) {
	}

	public boolean superIsLadder(Object world, int x, int y, int z) {
		return false;
	}

	public int superGetEnchantPower(Object world, int x, int y, int z) {
		return -1;
	}
	// ~189
	public int getBlockColor() {
		return -1;
	}

	@Override
	public int superGetBlockColor() {
		return -1;
	}

	public void setBlockBoundsForItemRender() {
	}

	@Override
	public void superSetBlockBoundsForItemRender() {
	}

	public boolean isFlowerPot() {
		return false;
	}

	@Override
	public boolean superIsFlowerPot() {
		return false;
	}

	public void addCollisionBoxesToList(World world, BlockPos blockPos, IBlockState iBlockState, AxisAlignedBB axisAlignedBB, List par6List, Entity entity) {
	}

	@Override
	public void superAddCollisionBoxesToList(Object world, Object blockPos, Object iBlockState, Object axisAlignedBB, List par6List, Object entity) {
	}

	public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, BlockPos blockPos) {
	}

	public void superSetBlockBoundsBasedOnState(Object iBlockAccess, Object blockPos) {
	}

	public int getRenderColor(IBlockState iBlockState) {
		return -1;
	}

	@Override
	public int superGetRenderColor(Object iBlockState) {
		return -1;
	}

	public int colorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos, int renderPass) {
		return -1;
	}

	public int superColorMultiplier(Object iBlockAccess, Object blockPos, int renderPass) {
		return -1;
	}

	public int getDamageValue(World world, BlockPos blockPos) {
		return -1;
	}

	@Override
	public int superGetDamageValue(Object world, Object blockPos) {
		return -1;
	}

	public IBlockState getStateForEntityRender(IBlockState iBlockState) {
		return null;
	}

	@Override
	public IBlockState superGetStateForEntityRender(Object iBlockState) {
		return null;
	}
	// ~189
	public boolean superIsFullCube() {
		return false;
	}

	public int superGetRenderType() {
		return -1;
	}

	public boolean superIsOpaqueCube() {
		return false;
	}

	public boolean superCanProvidePower() {
		return false;
	}

	public int superGetMobilityFlag() {
		return -1;
	}

	public boolean superHasComparatorInputOverride() {
		return false;
	}

	public boolean superAddHitEffects(Object world, Object movingObjectPosition, Object effectRenderer) {
		return false;
	}

	public float superGetAmbientOcclusionLightValue() {
		return 0.0F;
	}

	public boolean superCanEntityDestroy(Object world, Object pos, Object entity) {
		return false;
	}

	public float superGetBlockHardness(Object world, Object blockPos) {
		return 0.0F;
	}

	public int superGetPackedLightmapCoords(Object iBlockAccess, Object blockPos) {
		return -1;
	}

	public boolean superShouldSideBeRendered(Object iBlockAccess, Object blockPos, Object side) {
		return false;
	}

	public float superGetPlayerRelativeBlockHardness(Object entityPlayer, Object world, Object blockPos) {
		return 0.0F;
	}

	public boolean superIsFullBlock() {
		return false;
	}

	public int superGetLightOpacity() {
		return -1;
	}

	public boolean superIsTranslucent() {
		return false;
	}

	public int superGetLightValue() {
		return -1;
	}

	public boolean superGetUseNeighborBrightness() {
		return false;
	}

	public Object superGetMaterial() {
		return null;
	}

	public boolean superIsNormalCube() {
		return false;
	}

	public Object superGetSelectedBoundingBox(Object world, Object blockPos) {
		return null;
	}

	public Object superCollisionRayTrace(Object world, Object blockPos, Object vec3, Object vec31) {
		return null;
	}

	public boolean superOnBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumFacing, float hitX, float hitY, float hitZ) {
		return false;
	}

	public void superHarvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity) {
	}

	public Object superGetItem(Object world, Object blockPos) {
		return null;
	}

	public int superGetComparatorInputOverride(Object world, Object blockPos) {
		return -1;
	}

	public int superGetLightValue(Object iBlockAccess, Object blockPos) {
		return -1;
	}

	public boolean superIsLadder(Object iBlockAccess, Object blockPos, Object entityLivingBase) {
		return false;
	}

	public boolean superIsNormalCube(Object iBlockAccess, Object blockPos) {
		return false;
	}

	public boolean superIsSideSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	public boolean superIsAir(Object iBlockAccess, Object blockPos) {
		return false;
	}

	public boolean superRemovedByPlayer(Object world, Object blockPos, Object entityPlayer, boolean willHarvest) {
		return false;
	}

	public boolean superCanCreatureSpawn(Object iBlockAccess, Object blockPos, Object spawnPlacementType) {
		return false;
	}

	public boolean superIsBed(Object iBlockAccess, Object blockPos, Object entity) {
		return false;
	}

	public Object superGetBedSpawnPosition(Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return null;
	}

	public Object superGetBedDirection(Object iBlockAccess, Object blockPos) {
		return null;
	}

	public void superBeginLeavesDecay(Object world, Object blockPos) {
	}

	public boolean superCanSustainLeaves(Object iBlockAccess, Object blockPos) {
		return false;
	}

	public boolean superIsLeaves(Object iBlockAccess, Object blockPos) {
		return false;
	}

	public boolean superCanBeReplacedByLeaves(Object iBlockAccess, Object blockPos) {
		return false;
	}

	public boolean superIsReplaceableOreGen(Object world, Object blockPos, Object predicate) {
		return false;
	}

	public boolean superCanConnectRedstone(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	public boolean superCanPlaceTorchOnTop(Object iBlockAccess, Object blockPos) {
		return false;
	}

	public Object superGetPickBlock(Object movingObjectPosition, Object world, Object blockPos) {
		return null;
	}

	public boolean superCanSustainPlant(Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable) {
		return false;
	}

	public void superOnPlantGrow(Object world, Object blockPos, Object blockPos1) {
	}

	public int superGetLightOpacity(Object iBlockAccess, Object blockPos) {
		return -1;
	}

	public int superGetExpDrop(Object iBlockAccess, Object blockPos, int fortune) {
		return -1;
	}

	public boolean superShouldCheckWeakPower(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

}
