package modchu.lib.forge.mc210;

import java.util.HashMap;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Modchu_ItemFood extends modchu.lib.forge.mc190_220.Modchu_ItemFood {

	public Modchu_ItemFood(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean isItemTool(ItemStack itemStack) {
		return master != null ? master.isEnchantable(itemStack) : super.isItemTool(itemStack);
	}

	@Override
	public boolean superIsEnchantable(Object itemStack) {
		return super.isItemTool((ItemStack) itemStack);
	}

	// 190~212共通コピペ　↓
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List par3List, boolean par4) {
		if (master != null) master.addInformation(itemStack, entityPlayer, par3List, par4);
		else super.addInformation(itemStack, entityPlayer, par3List, par4);
	}

	@Override
	public void superAddInformation(Object itemStack, Object entityPlayer, List par3List, Object par4) {
		super.addInformation((ItemStack) itemStack, (EntityPlayer) entityPlayer, par3List, (Boolean) par4);
	}

	@Override
	public Object superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumHand, Object enumFacing, float f, float f1, float f2) {
		return super.onItemUse((EntityPlayer) entityPlayer, (World) world, (BlockPos) blockPos, (EnumHand) enumHand, (EnumFacing) enumFacing, f, f1, f2);
	}

	@Override
	public Object superOnItemRightClick(Object itemStack, Object world, Object entityPlayer, Object enumHand) {
		return super.onItemRightClick((World) world, (EntityPlayer) entityPlayer, (EnumHand) enumHand);
	}

	@Override
	public Object superOnItemRightClick(Object itemStack, Object world, Object entityPlayer) {
		return super.onItemRightClick((World) world, (EntityPlayer) entityPlayer, EnumHand.MAIN_HAND);
	}

	@Override
	protected RayTraceResult rayTrace(World world, EntityPlayer entityPlayer, boolean par3) {
		return (RayTraceResult) (master != null ? master.rayTrace(world, entityPlayer, par3) : super.rayTrace(world, entityPlayer, par3));
	}

	@Override
	public Object superRayTrace(Object world, Object entityPlayer, boolean par3) {
		return super.rayTrace((World) world, (EntityPlayer) entityPlayer, par3);
	}

	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer entityPlayer, World world, BlockPos blockPos, EnumFacing enumFacing, float hitX, float hitY, float hitZ, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.onItemUseFirst(entityPlayer.getHeldItem(enumHand), entityPlayer, world, blockPos, enumFacing, hitX, hitY, hitZ, enumHand) : super.onItemUseFirst(entityPlayer, world, blockPos, enumFacing, hitX, hitY, hitZ, enumHand));
	}

	@Override
	public Object superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, Object enumHand) {
		return super.onItemUseFirst((EntityPlayer) entityPlayer, (World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, hitX, hitY, hitZ, (EnumHand) enumHand);
	}

	@Override
	public int superGetHarvestLevel(Object itemStack, String toolClass) {
		return super.getHarvestLevel((ItemStack) itemStack, toolClass, null, null);
	}
	// 190~212共通コピペ　↑

	@Override
	public void superGetSubItems(Object item, Object creativeTabs, Object p_150895_3_) {
		super.getSubItems((Integer) item, (CreativeTabs) creativeTabs, (List) p_150895_3_);
	}

	@Override
	public boolean superIsInCreativeTab(Object creativeTabs) {
		return false;
	}

	@Override
	public Object superGetNBTShareTag(Object itemStack) {
		return null;
	}

	@Override
	public int superGetRGBDurabilityForDisplay(Object itemStack) {
		return -1;
	}

	@Override
	public boolean superCanDestroyBlockInCreative(Object world, Object blockPos, Object itemStack, Object entityPlayer) {
		return false;
	}

	@Override
	public int superGetHarvestLevel(Object itemStack, String toolClass, Object entityPlayer, Object iBlockState) {
		return -1;
	}

	@Override
	public boolean superCanApplyAtEnchantingTable(Object itemStack, Object enchantment) {
		return false;
	}

	@Override
	public boolean superShouldCauseBlockBreakReset(Object itemStack, Object itemStack1) {
		return false;
	}

	@Override
	public Object superGetAnimationParameters(Object itemStack, Object world, Object entityLivingBase) {
		return null;
	}

	@Override
	public Object superGetDefaultInstance() {
		return null;
	}

}
