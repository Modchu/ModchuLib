package modchu.lib.forge.mc180;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Modchu_Block extends modchu.lib.forge.mc180_189.Modchu_Block {

	public Modchu_Block(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public int superGetWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.isProvidingWeakPower((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (IBlockState) iBlockState, (EnumFacing) enumFacing);
	}

	@Override
	public Object superGetPickBlock(Object iBlockState, Object movingObjectPosition, Object world, Object blockPos, Object entityPlayer) {
		return super.getPickBlock((MovingObjectPosition) movingObjectPosition, (World) world, (BlockPos) blockPos);
	}

	@Override
	public boolean isSolidFullCube() {
		return master != null ? master.isBlockNormalCube() : super.isSolidFullCube();
	}

	@Override
	public boolean superIsNormalCube() {
		return super.isSolidFullCube();
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
	public int superGetStrongPower(Object iBlockAccess, Object blockPos, Object iBlockState, Object enumFacing) {
		return -1;
	}

	@Override
	public boolean superDoesSideBlockRendering(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superAddLandingEffects(Object iBlockState, Object worldServer, Object blockPos, Object iBlockState1, Object entityLivingBase, int numberOfParticles) {
		return false;
	}

	@Override
	public boolean superAddLandingEffects(Object worldServer, Object blockPos, Object iBlockState, Object entityLivingBase, int numberOfParticles) {
		return false;
	}

	@Override
	public boolean superIsBlockNormalCube() {
		return super.isNormalCube();
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
