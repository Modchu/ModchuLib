package modchu.lib;

public interface Modchu_IRecipeMaster {
	public Object setRegistryName(Object resourceLocation);
	public Object getRegistryName();
	public Class getRegistryType();
	public boolean matches(Object inventoryCrafting, Object world);
	public Object getCraftingResult(Object inventoryCrafting);
	public boolean canFit(int width, int height);
	public Object getRecipeOutput();
	public Object getRemainingItems(Object inventoryCrafting);

}
