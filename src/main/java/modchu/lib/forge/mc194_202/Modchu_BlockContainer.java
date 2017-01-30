package modchu.lib.forge.mc194_202;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.world.World;

public class Modchu_BlockContainer extends modchu.lib.forge.mc194_212.Modchu_BlockContainer {

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super(map);
	}
	// 210~分離 Modchu_Blockのコピー
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

}
