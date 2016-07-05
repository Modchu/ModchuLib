package modchu.lib.forge.mc190;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

import modchu.lib.Modchu_IBlock;
import modchu.lib.Modchu_IBlockMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.IPlantable;

public class Modchu_Block extends modchu.lib.forge.mc190_202.Modchu_Block implements Modchu_IBlock {

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
