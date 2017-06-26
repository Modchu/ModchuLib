package modchu.lib;

public interface Modchu_IRecipe {
	public Object superSetRegistryName(Object resourceLocation);
	public Object superGetRegistryName();
	public Class superGetRegistryType();
	public boolean superMatches(Object inventoryCrafting, Object world);
	public Object superGetCraftingResult(Object inventoryCrafting);
	public boolean superCanFit(int width, int height);
	public Object superGetRecipeOutput();
	public Object superGetRemainingItems(Object inventoryCrafting);

}
