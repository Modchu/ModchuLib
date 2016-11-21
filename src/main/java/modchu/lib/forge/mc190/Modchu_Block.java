package modchu.lib.forge.mc190;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_IBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Modchu_Block extends modchu.lib.forge.mc190_210.Modchu_Block implements Modchu_IBlock {

	public Modchu_Block(HashMap<String, Object> map) {
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
