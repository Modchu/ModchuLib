package modchu.lib.forge.mc220;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRecipe;
import modchu.lib.Modchu_IRecipeMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Modchu_Recipe implements IRecipe, Modchu_IRecipe {
	public Modchu_IRecipeMaster master;

	public Modchu_Recipe(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.mDebug("Modchu_Recipe init instance="+instance);
		master = instance instanceof Modchu_IRecipeMaster ? (Modchu_IRecipeMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_Recipe init master="+master);
	}

	@Override
	public IRecipe setRegistryName(ResourceLocation resourceLocation) {
		return (IRecipe) (master != null ? master.setRegistryName(resourceLocation) : null);
	}

	@Override
	public IRecipe superSetRegistryName(Object resourceLocation) {
		return null;
	}

	public ResourceLocation getRegistryName() {
		return (ResourceLocation) (master != null ? master.getRegistryName() : null);
	}

	@Override
	public ResourceLocation superGetRegistryName() {
		return null;
	}

	public Class<IRecipe> getRegistryType() {
		return master != null ? master.getRegistryType() : null;
	}

	@Override
	public Class<IRecipe> superGetRegistryType() {
		return null;
	}

	public boolean matches(InventoryCrafting inventoryCrafting, World world) {
		return master != null ? master.matches(inventoryCrafting, world) : false;
	}

	@Override
	public boolean superMatches(Object inventoryCrafting, Object world) {
		return false;
	}

	public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
		return (ItemStack) (master != null ? master.getCraftingResult(inventoryCrafting) : null);
	}

	@Override
	public ItemStack superGetCraftingResult(Object inventoryCrafting) {
		return null;
	}

	public boolean canFit(int width, int height) {
		return master != null ? master.canFit(width, height) : false;
	}

	@Override
	public boolean superCanFit(int width, int height) {
		return false;
	}

	public ItemStack getRecipeOutput() {
		return (ItemStack) (master != null ? master.getRecipeOutput() : null);
	}

	@Override
	public ItemStack superGetRecipeOutput() {
		return null;
	}

	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inventoryCrafting) {
		return master != null ? (NonNullList<ItemStack>) master.getRemainingItems(inventoryCrafting) : null;
	}

	@Override
	public NonNullList<ItemStack> superGetRemainingItems(Object inventoryCrafting) {
		return null;
	}

}
