package modchu.lib.forge.mc189;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class Modchu_BlockContainer extends modchu.lib.forge.mc180_189.Modchu_BlockContainer {

	public Modchu_BlockContainer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean isBlockNormalCube() {
		return master != null ? master.isBlockNormalCube() : super.isBlockNormalCube();
	}

	@Override
	public boolean superIsNormalCube() {
		return super.isBlockNormalCube();
	}

	@Override
	public int getWeakPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
		return master != null ? master.getWeakPower(iBlockState, iBlockAccess, blockPos, enumFacing) : super.getWeakPower(iBlockAccess, blockPos, iBlockState, enumFacing);
	}

	@Override
	public int superGetWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.getWeakPower((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (IBlockState) iBlockState, (EnumFacing) enumFacing);
	}

	@Override
	public Object superGetPickBlock(Object iBlockState, Object movingObjectPosition, Object world, Object blockPos, Object entityPlayer) {
		return super.getPickBlock((MovingObjectPosition) movingObjectPosition, (World) world, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
	}

	@Override
	public int getStrongPower(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, EnumFacing enumFacing) {
		return master != null ? master.getStrongPower(iBlockAccess, blockPos, iBlockState, enumFacing) : super.getStrongPower(iBlockAccess, blockPos, iBlockState, enumFacing);
	}

	@Override
	public int superGetStrongPower(Object iBlockAccess, Object blockPos, Object iBlockState, Object enumFacing) {
		return super.getStrongPower((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (IBlockState) iBlockState, (EnumFacing) enumFacing);
	}

	@Override
	public boolean superDoesSideBlockRendering(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.doesSideBlockRendering((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean superAddLandingEffects(Object iBlockState, Object worldServer, Object blockPos, Object iBlockState1, Object entityLivingBase, int numberOfParticles) {
		return super.addLandingEffects((WorldServer) worldServer, (BlockPos) blockPos, (IBlockState) iBlockState1, (EntityLivingBase) entityLivingBase, numberOfParticles);
	}

	@Override
	public boolean func_181623_g() {
		return master != null ? master.canSpawnInBlock() : super.func_181623_g();
	}

	@Override
	public boolean superFunc_181623_g() {
		return super.func_181623_g();
	}

	@Override
	public boolean doesSideBlockRendering(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing enumFacing) {
		return master != null ? master.doesSideBlockRendering(null, iBlockAccess, blockPos, enumFacing) : super.doesSideBlockRendering(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean superDoesSideBlockRendering(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return super.doesSideBlockRendering((IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EnumFacing) enumFacing);
	}

	@Override
	public boolean addLandingEffects(WorldServer worldServer, BlockPos blockPos, IBlockState iBlockState, EntityLivingBase entityLivingBase, int numberOfParticles) {
		return master != null ? master.addLandingEffects(worldServer, blockPos, iBlockState, entityLivingBase, numberOfParticles) : super.addLandingEffects(worldServer, blockPos, iBlockState, entityLivingBase, numberOfParticles);
	}

	@Override
	public boolean superAddLandingEffects(Object worldServer, Object blockPos, Object iBlockState, Object entityLivingBase, int numberOfParticles) {
		return super.addLandingEffects((WorldServer) worldServer, (BlockPos) blockPos, (IBlockState) iBlockState, (EntityLivingBase) entityLivingBase, numberOfParticles);
	}

	@Override
	public boolean superIsBlockNormalCube() {
		return super.isBlockNormalCube();
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
