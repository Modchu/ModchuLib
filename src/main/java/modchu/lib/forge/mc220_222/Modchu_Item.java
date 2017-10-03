package modchu.lib.forge.mc220_222;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.animation.ITimeValue;

public class Modchu_Item extends modchu.lib.forge.mc212_222.Modchu_Item {

	public Modchu_Item(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void getSubItems(CreativeTabs creativeTabs, NonNullList p_150895_3_) {
		if (master != null) master.getSubItems(null, creativeTabs, p_150895_3_);
		else super.getSubItems(creativeTabs, p_150895_3_);
	}

	@Override
	public void superGetSubItems(Object item, Object creativeTabs, Object p_150895_3_) {
		super.getSubItems((CreativeTabs) creativeTabs, (NonNullList) p_150895_3_);
	}

	@Override
	public void superAddInformation(Object itemStack, Object world, List par3List, Object iTooltipFlag) {
		super.addInformation((ItemStack) itemStack, (World) world, par3List, (ITooltipFlag) iTooltipFlag);
	}

	@Override
	public void addInformation(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag iTooltipFlag) {
		if (master != null) master.addInformation(itemStack, world, tooltip, iTooltipFlag);
		else super.addInformation(itemStack, world, tooltip, iTooltipFlag);
	}

	public boolean isInCreativeTab(CreativeTabs creativeTabs) {
		return master != null ? master.isInCreativeTab(creativeTabs) : super.isInCreativeTab(creativeTabs);
	}

	@Override
	public boolean superIsInCreativeTab(Object creativeTabs) {
		return super.isInCreativeTab((CreativeTabs) creativeTabs);
	}

	public NBTTagCompound getNBTShareTag(ItemStack itemStack) {
		return (NBTTagCompound) (master != null ? master.getNBTShareTag(itemStack) : super.getNBTShareTag(itemStack));
	}

	@Override
	public NBTTagCompound superGetNBTShareTag(Object itemStack) {
		return super.getNBTShareTag((ItemStack) itemStack);
	}

	public int getRGBDurabilityForDisplay(ItemStack itemStack) {
		return master != null ? master.getRGBDurabilityForDisplay(itemStack) : super.getRGBDurabilityForDisplay(itemStack);
	}

	@Override
	public int superGetRGBDurabilityForDisplay(Object itemStack) {
		return super.getRGBDurabilityForDisplay((ItemStack) itemStack);
	}

	public boolean canDestroyBlockInCreative(World world, BlockPos blockPos, ItemStack itemStack, EntityPlayer entityPlayer) {
		return master != null ? master.canDestroyBlockInCreative(world, blockPos, itemStack, entityPlayer) : super.canDestroyBlockInCreative(world, blockPos, itemStack, entityPlayer);
	}

	@Override
	public boolean superCanDestroyBlockInCreative(Object world, Object blockPos, Object itemStack, Object entityPlayer) {
		return super.canDestroyBlockInCreative((World) world, (BlockPos) blockPos, (ItemStack) itemStack, (EntityPlayer) entityPlayer);
	}

	public int getHarvestLevel(ItemStack itemStack, String toolClass, EntityPlayer entityPlayer, IBlockState iBlockState) {
		return master != null ? master.getHarvestLevel(itemStack, toolClass, entityPlayer, iBlockState) : super.getHarvestLevel(itemStack, toolClass, entityPlayer, iBlockState);
	}

	@Override
	public int superGetHarvestLevel(Object itemStack, String toolClass, Object entityPlayer, Object iBlockState) {
		return super.getHarvestLevel((ItemStack) itemStack, toolClass, (EntityPlayer) entityPlayer, (IBlockState) iBlockState);
	}

	public boolean canApplyAtEnchantingTable(ItemStack itemStack, Enchantment enchantment) {
		return master != null ? master.canApplyAtEnchantingTable(itemStack, enchantment) : super.canApplyAtEnchantingTable(itemStack, enchantment);
	}

	@Override
	public boolean superCanApplyAtEnchantingTable(Object itemStack, Object enchantment) {
		return super.canApplyAtEnchantingTable((ItemStack) itemStack, (Enchantment) enchantment);
	}

	public boolean shouldCauseBlockBreakReset(ItemStack itemStack, ItemStack itemStack1) {
		return master != null ? master.shouldCauseBlockBreakReset(itemStack, itemStack1) : super.shouldCauseBlockBreakReset(itemStack, itemStack1);
	}

	@Override
	public boolean superShouldCauseBlockBreakReset(Object itemStack, Object itemStack1) {
		return super.shouldCauseBlockBreakReset((ItemStack) itemStack, (ItemStack) itemStack1);
	}

	public ImmutableMap<String, ITimeValue> getAnimationParameters(ItemStack itemStack, World world, EntityLivingBase entityLivingBase) {
		return (ImmutableMap<String, ITimeValue>) (master != null ? master.getAnimationParameters(itemStack, world, entityLivingBase) : super.getAnimationParameters(itemStack, world, entityLivingBase));
	}

	@Override
	public ImmutableMap<String, ITimeValue> superGetAnimationParameters(Object itemStack, Object world, Object entityLivingBase) {
		return super.getAnimationParameters((ItemStack) itemStack, (World) world, (EntityLivingBase) entityLivingBase);
	}

	public ItemStack getDefaultInstance() {
		return (ItemStack) (master != null ? master.getDefaultInstance() : super.getDefaultInstance());
	}

	@Override
	public ItemStack superGetDefaultInstance() {
		return super.getDefaultInstance();
	}

}
