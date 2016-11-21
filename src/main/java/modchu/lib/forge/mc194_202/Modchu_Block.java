package modchu.lib.forge.mc194_202;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Modchu_Block extends modchu.lib.forge.mc194_210.Modchu_Block implements Modchu_IBlock {

	public Modchu_Block(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void neighborChanged(IBlockState iBlockState, World world, BlockPos blockPos, Block block) {
		if (master != null) master.neighborChanged(iBlockState, world, blockPos, block, null);
		else super.neighborChanged(iBlockState, world, blockPos, block);
	}

	@Override
	public void superNeighborChanged(Object world, Object blockPos, Object iBlockState, Object block, Object blockPos1) {
		super.neighborChanged((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (Block) block);
	}

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
		return master != null ? master.isVisuallyOpaque(null) : super.isVisuallyOpaque();
	}

	@Override
	public boolean superIsVisuallyOpaque(Object iBlockState) {
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

}
