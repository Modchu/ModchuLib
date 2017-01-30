package modchu.lib.forge.mc210;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Modchu_BlockContainer extends modchu.lib.forge.mc210_212.Modchu_BlockContainer {

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super(map);
	}
	// 212~分離
	@Override
	public boolean isVisuallyOpaque(IBlockState iBlockState) {
		return master != null ? master.causesSuffocation(iBlockState) : super.isVisuallyOpaque(iBlockState);
	}

	@Override
	public boolean superCausesSuffocation(Object iBlockState) {
		return super.isVisuallyOpaque((IBlockState) iBlockState);
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
