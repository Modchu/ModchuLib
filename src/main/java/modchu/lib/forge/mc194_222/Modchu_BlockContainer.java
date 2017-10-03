package modchu.lib.forge.mc194_222;

import java.util.HashMap;

import modchu.lib.Modchu_IBlockContainer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class Modchu_BlockContainer extends modchu.lib.forge.mc190_222.Modchu_BlockContainer implements Modchu_IBlockContainer {

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	protected Block setSoundType(SoundType stepSound) {
		return (Block) (master != null ? master.setSoundType(stepSound) : super.setSoundType(stepSound));
	}

	@Override
	public Block superSetSoundType(Object stepSound) {
		return super.setSoundType((SoundType) stepSound);
	}

	@Override
	public boolean addHitEffects(IBlockState iBlockState, World world, RayTraceResult rayTraceResult, ParticleManager particleManager) {
		return master != null ? master.addHitEffects(iBlockState, world, rayTraceResult, particleManager) : super.addHitEffects(iBlockState, world, rayTraceResult, particleManager);
	}

	@Override
	public boolean superAddHitEffects(Object iBlockState, Object world, Object rayTraceResult, Object particleManager) {
		return super.addHitEffects((IBlockState) iBlockState, (World) world, (RayTraceResult) rayTraceResult, (ParticleManager) particleManager);
	}

	@Override
	public SoundType getSoundType() {
		return (SoundType) (master != null ? master.getSoundType() : super.getSoundType());
	}

	@Override
	public SoundType superGetSoundType() {
		return super.getSoundType();
	}

	@Override
	public void onEntityWalk(World world, BlockPos blockPos, Entity entity) {
		if (master != null) master.onEntityWalk(world, blockPos, entity);
		else super.onEntityWalk(world, blockPos, entity);
	}

	@Override
	public void superOnEntityWalk(Object world, Object blockPos, Object entity) {
		super.onEntityWalk((World) world, (BlockPos) blockPos, (Entity) entity);
	}

	@Override
	public boolean eventReceived(IBlockState iBlockState, World world, BlockPos blockPos, int eventID, int eventParam) {
		return master != null ? master.eventReceived(iBlockState, world, blockPos, eventID, eventParam) : super.eventReceived(iBlockState, world, blockPos, eventID, eventParam);
	}

	@Override
	public boolean superEventReceived(Object iBlockState, Object world, Object blockPos, int eventID, int eventParam) {
		return super.eventReceived((IBlockState) iBlockState, (World) world, (BlockPos) blockPos, eventID, eventParam);
	}

	@Override
	public boolean addDestroyEffects(World world, BlockPos blockPos, ParticleManager particleManager) {
		return master != null ? master.addDestroyEffects(world, blockPos, particleManager) : super.addDestroyEffects(world, blockPos, particleManager);
	}

	@Override
	public boolean superAddDestroyEffects(Object world, Object blockPos, Object particleManager) {
		return super.addDestroyEffects((World) world, (BlockPos) blockPos, (ParticleManager) particleManager);
	}

}
