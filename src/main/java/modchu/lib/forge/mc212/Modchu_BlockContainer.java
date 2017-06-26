package modchu.lib.forge.mc212;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Modchu_BlockContainer extends modchu.lib.forge.mc212_220.Modchu_BlockContainer {

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs creativeTabs, NonNullList par3List) {
		if (master != null) master.getSubBlocks(par1, creativeTabs, par3List);
		else super.getSubBlocks(par1, creativeTabs, par3List);
	}

	@Override
	public void superGetSubBlocks(Object par1, Object creativeTabs, Object par3List) {
		super.getSubBlocks((Item) par1, (CreativeTabs) creativeTabs, (NonNullList<ItemStack>) par3List);
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
	public MapColor getMapColor(IBlockState iBlockState) {
		return (MapColor) (master != null ? master.getMapColor(iBlockState, null, null) : super.getMapColor(iBlockState));
	}

	@Override
	public MapColor superGetMapColor(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return super.getMapColor((IBlockState) iBlockState);
	}

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
	protected NonNullList<ItemStack> captureDrops(boolean start) {
		return (NonNullList<ItemStack>) (master != null ? master.captureDrops(start) : super.captureDrops(start));
	}

}
