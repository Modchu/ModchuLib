package modchu.lib.forge.mc190;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_IItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Modchu_Item extends modchu.lib.forge.mc190_220.Modchu_Item implements Modchu_IItem {

	public Modchu_Item(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	protected RayTraceResult getMovingObjectPositionFromPlayer(World world, EntityPlayer entityPlayer, boolean par3) {
		return (RayTraceResult) (master != null ? master.rayTrace(world, entityPlayer, par3) : super.getMovingObjectPositionFromPlayer(world, entityPlayer, par3));
	}

	@Override
	public Object superRayTrace(Object world, Object entityPlayer, boolean par3) {
		return super.getMovingObjectPositionFromPlayer((World) world, (EntityPlayer) entityPlayer, par3);
	}
	// 210~分離 Modchu_Itemのコピー
	@Override
	public EnumActionResult onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, BlockPos blockPos, EnumFacing enumFacing, float hitX, float hitY, float hitZ, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.onItemUseFirst(itemStack, entityPlayer, world, blockPos, enumFacing, hitX, hitY, hitZ, enumHand) : super.onItemUseFirst(itemStack, entityPlayer, world, blockPos, enumFacing, hitX, hitY, hitZ, enumHand));
	}

	@Override
	public Object superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, Object enumHand) {
		return super.onItemUseFirst((ItemStack) itemStack, (EntityPlayer) entityPlayer, (World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, hitX, hitY, hitZ, (EnumHand) enumHand);
	}

	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List p_150895_3_) {
		if (master != null) master.getSubItems(item, creativeTabs, p_150895_3_);
		else super.getSubItems(item, creativeTabs, p_150895_3_);
	}

	@Override
	public void superGetSubItems(Object item, Object creativeTabs, Object p_150895_3_) {
		super.getSubItems((Item) item, (CreativeTabs) creativeTabs, (List) p_150895_3_);
	}

	@Override
	public Object superOnItemRightClick(Object itemStack, Object world, Object entityPlayer) {
		return super.onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer, EnumHand.MAIN_HAND);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, BlockPos blockPos, EnumHand enumHand, EnumFacing enumFacing, float f, float f1, float f2) {
		return (EnumActionResult) (master != null ? master.onItemUse(itemStack, entityPlayer, world, blockPos, enumHand, enumFacing, f, f1, f2) : super.onItemUse(itemStack, entityPlayer, world, blockPos, enumHand, enumFacing, f, f1, f2));
	}

	@Override
	public Object superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumHand, Object enumFacing, float f, float f1, float f2) {
		return super.onItemUse((ItemStack) itemStack, (EntityPlayer) entityPlayer, (World) world, (BlockPos) blockPos, (EnumHand) enumHand, (EnumFacing) enumFacing, f, f1, f2);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer, EnumHand enumHand) {
		return (ActionResult<ItemStack>) (master != null ? master.onItemRightClick(itemStack, world, entityPlayer, enumHand) : super.onItemRightClick(itemStack, world, entityPlayer, enumHand));
	}

	@Override
	public Object superOnItemRightClick(Object itemStack, Object world, Object entityPlayer, Object enumHand) {
		return super.onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer, (EnumHand) enumHand);
	}

	@Override
	public int getHarvestLevel(ItemStack itemStack, String toolClass) {
		return master != null ? master.getHarvestLevel(itemStack, toolClass) : super.getHarvestLevel(itemStack, toolClass);
	}

	@Override
	public int superGetHarvestLevel(Object itemStack, String toolClass) {
		return super.getHarvestLevel((ItemStack) itemStack, toolClass);
	}

	@Override
	public boolean superIsEnchantable(Object itemStack) {
		return super.isItemTool((ItemStack) itemStack);
	}

	@Override
	public void superAddInformation(Object itemStack, Object entityPlayer, List par3List, Object par4) {
		super.addInformation((ItemStack) itemStack, (EntityPlayer) entityPlayer, par3List, (Boolean) par4);
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
