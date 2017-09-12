package modchu.lib.forge.mc220_221;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Modchu_Block extends modchu.lib.forge.mc212_221.Modchu_Block implements Modchu_IBlock {

	public Modchu_Block(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void getSubBlocks(CreativeTabs creativeTabs, NonNullList par3List) {
		if (master != null) master.getSubBlocks(null, creativeTabs, par3List);
		else super.getSubBlocks(creativeTabs, par3List);
	}

	@Override
	public void superGetSubBlocks(Object par1, Object creativeTabs, Object par3List) {
		super.getSubBlocks((CreativeTabs) creativeTabs, (NonNullList<ItemStack>) par3List);
	}

	@Override
	public boolean superIsBlockSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public MapColor getMapColor(IBlockState iBlockState, IBlockAccess p_180659_2_, BlockPos p_180659_3_) {
		return (MapColor) (master != null ? master.getMapColor(iBlockState, p_180659_2_, p_180659_3_) : super.getMapColor(iBlockState, p_180659_2_, p_180659_3_));
	}

	@Override
	public MapColor superGetMapColor(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getMapColor((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	public boolean isTopSolid(IBlockState iBlockState) {
		return master != null ? master.isTopSolid(iBlockState) : super.isTopSolid(iBlockState);
	}

	@Override
	public boolean superIsTopSolid(Object iBlockState) {
		return super.isTopSolid((IBlockState) iBlockState);
	}

	@Override
	public void addInformation(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag iTooltipFlag) {
		if (master != null) master.addInformation(itemStack, world, tooltip, iTooltipFlag);
		else super.addInformation(itemStack, world, tooltip, iTooltipFlag);
	}

	@Override
	public void superAddInformation(Object itemStack, Object world, List tooltip, Object iTooltipFlag) {
		super.addInformation((ItemStack) itemStack, (World) world, (List) tooltip, (ITooltipFlag) iTooltipFlag);
	}

	public void observedNeighborChange(IBlockState iBlockState, World world, BlockPos blockPos, Block block, BlockPos blockPos1) {
		if (master != null) master.observedNeighborChange(iBlockState, world, blockPos, block, blockPos1);
		else super.observedNeighborChange(iBlockState, world, blockPos, block, blockPos1);
	}

	@Override
	public void superObservedNeighborChange(Object iBlockState, Object world, Object blockPos, Object block, Object blockPos1) {
		super.observedNeighborChange((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (Block) block, (BlockPos) blockPos1);
	}

	public boolean canRenderInLayer(IBlockState iBlockState, BlockRenderLayer blockRenderLayer) {
		return master != null ? master.canRenderInLayer(iBlockState, blockRenderLayer) : super.canRenderInLayer(iBlockState, blockRenderLayer);
	}

	@Override
	public boolean superCanRenderInLayer(Object iBlockState, Object blockRenderLayer) {
		return super.canRenderInLayer((IBlockState) iBlockState, (BlockRenderLayer) blockRenderLayer);
	}

	public SoundType getSoundType(IBlockState iBlockState, World world, BlockPos blockPos, Entity entity) {
		return (SoundType) (master != null ? master.getSoundType(iBlockState, world, blockPos, entity) : super.getSoundType(iBlockState, world, blockPos, entity));
	}

	@Override
	public SoundType superGetSoundType(Object iBlockState, Object world, Object blockPos, Object entity) {
		return super.getSoundType((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (Entity) entity);
	}

	public float[] getBeaconColorMultiplier(IBlockState iBlockState, World world, BlockPos blockPos, BlockPos blockPos1) {
		return master != null ? master.getBeaconColorMultiplier(iBlockState, world, blockPos, blockPos1) : super.getBeaconColorMultiplier(iBlockState, world, blockPos, blockPos1);
	}

	@Override
	public float[] superGetBeaconColorMultiplier(Object iBlockState, Object world, Object blockPos, Object blockPos1) {
		return super.getBeaconColorMultiplier((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (BlockPos) blockPos1);
	}

	public IBlockState getStateForPlacement(World world, BlockPos blockPos, EnumFacing enumFacing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entityLivingBase, EnumHand enumHand) {
		return (IBlockState) (master != null ? master.getStateForPlacement(world, blockPos, enumFacing, hitX, hitY, hitZ, meta, entityLivingBase, enumHand) : super.getStateForPlacement(world, blockPos, enumFacing, hitX, hitY, hitZ, meta, entityLivingBase, enumHand));
	}

	@Override
	public IBlockState superGetStateForPlacement(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase, Object enumHand) {
		return super.getStateForPlacement((World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, hitX, hitY, hitZ, meta, (EntityLivingBase) entityLivingBase, (EnumHand) enumHand);
	}

	public boolean canBeConnectedTo(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.canBeConnectedTo(iBlockAccess, blockPos, enumFacing) : super.canBeConnectedTo(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superCanBeConnectedTo(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.canBeConnectedTo((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	public PathNodeType getAiPathNodeType(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
		return (PathNodeType) (master != null ? master.getAiPathNodeType(iBlockState, iBlockAccess, blockPos) : super.getAiPathNodeType(iBlockState, iBlockAccess, blockPos));
	}

	@Override
	public PathNodeType superGetAiPathNodeType(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getAiPathNodeType((IBlockState) iBlockState, (IBlockAccess) iBlockAccess, (BlockPos) blockPos);
	}

	@Override
	protected NonNullList<ItemStack> captureDrops(boolean start) {
		return (NonNullList<ItemStack>) (master != null ? master.captureDrops(start) : super.captureDrops(start));
	}

}
