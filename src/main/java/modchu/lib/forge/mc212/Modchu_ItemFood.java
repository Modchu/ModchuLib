package modchu.lib.forge.mc212;

import java.util.HashMap;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class Modchu_ItemFood extends modchu.lib.forge.mc212_220.Modchu_ItemFood {

	public Modchu_ItemFood(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, NonNullList p_150895_3_) {
		if (master != null) master.getSubItems(item, creativeTabs, p_150895_3_);
		else super.getSubItems(item, creativeTabs, p_150895_3_);
	}

	@Override
	public void superGetSubItems(Object item, Object creativeTabs, Object p_150895_3_) {
		super.getSubItems((Item) item, (CreativeTabs) creativeTabs, (NonNullList) p_150895_3_);
	}

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
