package modchu.lib.forge.mc172;

import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Modchu_BlockContainer extends modchu.lib.forge.mc172_179.Modchu_BlockContainer {

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean removedByPlayer(World world, EntityPlayer entityPlayer, int x, int y, int z) {
		return master != null ? master.removedByPlayer(world, entityPlayer, x, y, z, false) : super.removedByPlayer(world, entityPlayer, x, y, z);
	}

	@Override
	public boolean superRemovedByPlayer(Object world, Object entityPlayer, int x, int y, int z, boolean willHarvest) {
		return super.removedByPlayer((World) world, (EntityPlayer) entityPlayer, x, y, z);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition movingObjectPosition, World world, int x, int y, int z) {
		return (ItemStack) (master != null ? master.getPickBlock(movingObjectPosition, world, x, y, z) : super.getPickBlock(movingObjectPosition, world, x, y, z));
	}

	@Override
	public ItemStack superGetPickBlock(Object movingObjectPosition, Object world, int x, int y, int z, Object entityPlayer) {
		return super.getPickBlock((MovingObjectPosition) movingObjectPosition, (World) world, x, y, z);
	}

	@Override
	public boolean superFunc_181623_g() {
		return false;
	}

	@Override
	public boolean superDoesSideBlockRendering(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetPickBlock(Object movingObjectPosition, Object world, Object blockPos, Object entityPlayer) {
		return null;
	}

	@Override
	public boolean superAddLandingEffects(Object worldServer, Object blockPos, Object iBlockState, Object entityLivingBase, int numberOfParticles) {
		return false;
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

}
