package modchu.lib.forge.mc190;

import java.util.HashMap;

import modchu.lib.Modchu_IBlockContainer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Modchu_BlockContainer extends modchu.lib.forge.mc190_202.Modchu_BlockContainer implements Modchu_IBlockContainer {

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
		if (master != null) master.neighborChanged(iBlockState, world, blockPos, block);
		else super.onNeighborBlockChange(world, blockPos, iBlockState, block);
	}

	@Override
	public void superNeighborChanged(Object iBlockState, Object world, Object blockPos, Object block) {
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

}
