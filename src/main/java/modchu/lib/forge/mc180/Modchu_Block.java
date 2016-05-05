package modchu.lib.forge.mc180;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

import modchu.lib.Modchu_IBlock;
import modchu.lib.Modchu_IBlockMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

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

}
