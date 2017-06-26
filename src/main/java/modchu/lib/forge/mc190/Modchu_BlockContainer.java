package modchu.lib.forge.mc190;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_IBlockContainer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Modchu_BlockContainer extends modchu.lib.forge.mc190_220.Modchu_BlockContainer implements Modchu_IBlockContainer {

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	protected Block setStepSound(SoundType stepSound) {
		return (Block) (master != null ? master.setSoundType(stepSound) : super.setStepSound(stepSound));
	}

	@Override
	public Block superSetSoundType(Object stepSound) {
		return super.setStepSound((SoundType) stepSound);
	}

	@Override
	public boolean addHitEffects(IBlockState iBlockState, World world, RayTraceResult rayTraceResult, EffectRenderer effectRenderer) {
		return master != null ? master.addHitEffects(iBlockState, world, rayTraceResult, effectRenderer) : super.addHitEffects(iBlockState, world, rayTraceResult, effectRenderer);
	}

	@Override
	public boolean superAddHitEffects(Object iBlockState, Object world, Object rayTraceResult, Object effectRenderer) {
		return super.addHitEffects((IBlockState) iBlockState, (World) world, (RayTraceResult) rayTraceResult, (EffectRenderer) effectRenderer);
	}

	@Override
	public SoundType getStepSound() {
		return (SoundType) (master != null ? master.getSoundType() : super.getStepSound());
	}

	@Override
	public SoundType superGetSoundType() {
		return super.getStepSound();
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos blockPos, Entity entity) {
		if (master != null) master.onEntityWalk(world, blockPos, entity);
		else super.onEntityCollidedWithBlock(world, blockPos, entity);
	}

	@Override
	public void superOnEntityWalk(Object world, Object blockPos, Object entity) {
		super.onEntityCollidedWithBlock((World) world, (BlockPos) blockPos, (Entity) entity);
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos blockPos, IBlockState iBlockState, Block block) {
		if (master != null) master.neighborChanged(iBlockState, world, blockPos, block, null);
		else super.onNeighborBlockChange(world, blockPos, iBlockState, block);
	}

	@Override
	public void superNeighborChanged(Object iBlockState, Object world, Object blockPos, Object block, Object blockPos1) {
		super.onNeighborBlockChange((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (Block) block);
	}

	@Override
	public boolean onBlockEventReceived(World world, BlockPos blockPos, IBlockState iBlockState, int eventID, int eventParam) {
		return master != null ? master.eventReceived(iBlockState, world, blockPos, eventID, eventParam) : super.onBlockEventReceived(world, blockPos, iBlockState, eventID, eventParam);
	}

	@Override
	public boolean superEventReceived(Object iBlockState, Object world, Object blockPos, int eventID, int eventParam) {
		return super.onBlockEventReceived((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, eventID, eventParam);
	}

	@Override
	public boolean addDestroyEffects(World world, BlockPos blockPos, EffectRenderer effectRenderer) {
		return master != null ? master.addDestroyEffects(world, blockPos, effectRenderer) : super.addDestroyEffects(world, blockPos, effectRenderer);
	}

	@Override
	public boolean superAddDestroyEffects(Object world, Object blockPos, Object effectRenderer) {
		return super.addDestroyEffects((World) world, (BlockPos) blockPos, (EffectRenderer) effectRenderer);
	}
	// 210~分離
	@Override
	public void getSubBlocks(Item par1, CreativeTabs creativeTabs, List par3List) {
		if (master != null) master.getSubBlocks(par1, creativeTabs, par3List);
		else super.getSubBlocks(par1, creativeTabs, par3List);
	}

	@Override
	public void superGetSubBlocks(Object par1, Object creativeTabs, Object par3List) {
		super.getSubBlocks((Item) par1, (CreativeTabs) creativeTabs, (List<ItemStack>) par3List);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState iBlockState, World world, BlockPos blockPos) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox(iBlockState, world, blockPos) : super.getCollisionBoundingBox(iBlockState, world, blockPos));
	}

	@Override
	public boolean isVisuallyOpaque() {
		return master != null ? master.causesSuffocation(null) : super.isVisuallyOpaque();
	}

	@Override
	public boolean superCausesSuffocation(Object iBlockState) {
		return super.isVisuallyOpaque();
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
	public boolean onBlockActivated(World world, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumHand enumHand, ItemStack itemStack, EnumFacing enumFacing, float hitX, float hitY, float hitZ) {
		return master != null ? master.onBlockActivated(world, blockPos, iBlockState, entityPlayer, enumHand, itemStack, enumFacing, hitX, hitY, hitZ) : super.onBlockActivated(world, blockPos, iBlockState, entityPlayer, enumHand, itemStack, enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean superOnBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumHand, Object itemStack, Object enumFacing, float hitX, float hitY, float hitZ) {
		return super.onBlockActivated((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (EntityPlayer) entityPlayer, (EnumHand) enumHand, (ItemStack) itemStack, (EnumFacing) enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean canRenderInLayer(BlockRenderLayer enumWorldBlockLayer) {
		return master != null ? master.canRenderInLayer(enumWorldBlockLayer) : super.canRenderInLayer(enumWorldBlockLayer);
	}

	@Override
	public boolean superCanRenderInLayer(Object enumWorldBlockLayer) {
		return super.canRenderInLayer((BlockRenderLayer) enumWorldBlockLayer);
	}
	// 190~210共通コピペ　↓
	@Override
	public void addCollisionBoxToList(IBlockState iBlockState, World world, BlockPos blockPos, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> p_185477_5_, Entity entity) {
		if (master != null) master.addCollisionBoxToList(iBlockState, world, blockPos, axisAlignedBB, p_185477_5_, entity);
		else super.addCollisionBoxToList(iBlockState, world, blockPos, axisAlignedBB, p_185477_5_, entity);
	}

	@Override
	public void superAddCollisionBoxToList(Object iBlockState, Object world, Object blockPos, Object axisAlignedBB, Object p_185477_5_, Object entity) {
		super.addCollisionBoxToList((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (AxisAlignedBB) axisAlignedBB, (List) p_185477_5_, (Entity) entity);
	}

	@Override
	public void superAddCollisionBoxToList(Object iBlockState, Object world, Object blockPos, Object axisAlignedBB, Object p_185477_5_, Object entity, boolean p_185477_7_) {
		super.addCollisionBoxToList((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (AxisAlignedBB) axisAlignedBB, (List) p_185477_5_, (Entity) entity);
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos blockPos, EnumFacing enumFacing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entityLivingBase) {
		return (IBlockState) (master != null ? master.getStateForPlacement(world, blockPos, enumFacing, hitX, hitY, hitZ, meta, entityLivingBase) : super.onBlockPlaced(world, blockPos, enumFacing, hitX, hitY, hitZ, meta, entityLivingBase));
	}

	@Override
	public IBlockState superGetStateForPlacement(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase) {
		return super.onBlockPlaced((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, hitX, hitY, hitZ, meta, (EntityLivingBase) entityLivingBase);
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState iBlockState) {
		return (ItemStack) (master != null ? master.getSilkTouchDrop(iBlockState) : super.createStackedBlock(iBlockState));
	}

	@Override
	public ItemStack superGetSilkTouchDrop(Object iBlockState) {
		return super.createStackedBlock((IBlockState) iBlockState);
	}
	// 190~210共通コピペ　↑

	// 190~212共通コピペ　↓
	@Override
	public boolean isBlockSolid(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.isBlockSolid(iBlockAccess, blockPos, enumFacing) : super.isBlockSolid(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superIsBlockSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.isBlockSolid((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public MapColor getMapColor(IBlockState iBlockState) {
		return (MapColor) (master != null ? master.getMapColor(iBlockState, null, null) : super.getMapColor(iBlockState));
	}

	@Override
	public MapColor superGetMapColor(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getMapColor((IBlockState) iBlockState);
	}
	// 190~212共通コピペ　↑

	@Override
	public boolean isFullyOpaque(IBlockState iBlockState) {
		return master != null ? master.isTopSolid(iBlockState) : super.isFullyOpaque(iBlockState);
	}

	@Override
	public boolean superIsTopSolid(Object iBlockState) {
		return super.isFullyOpaque((IBlockState) iBlockState);
	}

	@Override
	public void superAddInformation(Object itemStack, Object world, List tooltip, Object iTooltipFlag) {
	}

	@Override
	public void superObservedNeighborChange(Object iBlockState, Object world, Object blockPos, Object block, Object blockPos1) {
	}

	@Override
	public boolean superCanRenderInLayer(Object iBlockState, Object blockRenderLayer) {
		return false;
	}

	@Override
	public Object superGetSoundType(Object iBlockState, Object world, Object blockPos, Object entity) {
		return null;
	}

	@Override
	public float[] superGetBeaconColorMultiplier(Object iBlockState, Object world, Object blockPos, Object blockPos1) {
		return null;
	}

	@Override
	public Object superGetStateForPlacement(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase, Object enumHand) {
		return null;
	}

	@Override
	public boolean superCanBeConnectedTo(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetAiPathNodeType(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return null;
	}

	@Override
	protected List<ItemStack> captureDrops(boolean start) {
		return (List<ItemStack>) (master != null ? master.captureDrops(start) : super.captureDrops(start));
	}

}
