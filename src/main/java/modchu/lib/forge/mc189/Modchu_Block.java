package modchu.lib.forge.mc189;

import java.util.HashMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class Modchu_Block extends modchu.lib.forge.mc180_189.Modchu_Block {

	public Modchu_Block(HashMap<String, Object> map) {
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

}
