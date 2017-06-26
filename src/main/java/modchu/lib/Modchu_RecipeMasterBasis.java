package modchu.lib;

import java.util.HashMap;

public class Modchu_RecipeMasterBasis implements Modchu_IRecipeMaster {
	public Modchu_IRecipe base;

	public Modchu_RecipeMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IRecipe) map.get("base");
	}

	@Override
	public Object setRegistryName(Object resourceLocation) {
		return base.superSetRegistryName(resourceLocation);
	}

	@Override
	public Object getRegistryName() {
		return base.superGetRegistryName();
	}

	@Override
	public Class getRegistryType() {
		return base.superGetRegistryType();
	}

	@Override
	public boolean matches(Object inventoryCrafting, Object world) {
		return base.superMatches(inventoryCrafting, world);
	}

	@Override
	public Object getCraftingResult(Object inventoryCrafting) {
		return base.superGetCraftingResult(inventoryCrafting);
	}

	@Override
	public boolean canFit(int width, int height) {
		return base.superCanFit(width, height);
	}

	@Override
	public Object getRecipeOutput() {
		return base.superGetRecipeOutput();
	}

	@Override
	public Object getRemainingItems(Object inventoryCrafting) {
		return base.superGetRemainingItems(inventoryCrafting);
	}

}
