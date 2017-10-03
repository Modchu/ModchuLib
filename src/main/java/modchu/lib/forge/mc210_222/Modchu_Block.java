package modchu.lib.forge.mc210_222;

import java.util.HashMap;

import modchu.lib.Modchu_IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class Modchu_Block extends modchu.lib.forge.mc194_222.Modchu_Block implements Modchu_IBlock {

	public Modchu_Block(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void neighborChanged(IBlockState iBlockState, World world, BlockPos blockPos, Block block, BlockPos blockPos1) {
		if (master != null) master.neighborChanged(iBlockState, world, blockPos, block, blockPos1);
		else super.neighborChanged(iBlockState, world, blockPos, block, blockPos1);
	}

	@Override
	public void superNeighborChanged(Object world, Object blockPos, Object iBlockState, Object block, Object blockPos1) {
		super.neighborChanged((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, (Block) block, (BlockPos) blockPos1);
	}

	@Override
	public boolean superCanReplace(Object world, Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos blockPos, IBlockState iBlockState, EntityPlayer entityPlayer, EnumHand enumHand, EnumFacing enumFacing, float hitX, float hitY, float hitZ) {
		return master != null ? master.onBlockActivated(world, blockPos, iBlockState, entityPlayer, enumHand, null, enumFacing, hitX, hitY, hitZ) : super.onBlockActivated(world, blockPos, iBlockState, entityPlayer, enumHand, enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean superOnBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumHand, Object itemStack, Object enumFacing, float hitX, float hitY, float hitZ) {
		return super.onBlockActivated((World) world, (BlockPos) blockPos, (IBlockState) iBlockState, (EntityPlayer) entityPlayer, (EnumHand) enumHand, (EnumFacing) enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean superCanRenderInLayer(Object enumWorldBlockLayer) {
		return super.canRenderInLayer(null, (BlockRenderLayer) enumWorldBlockLayer);
	}

}
