package modchu.lib;

public interface Modchu_IItemFood extends Modchu_IItem {
	public void onFoodEaten(Object itemStack, Object world, Object entityPlayer);
	public int func_150905_g(Object itemStack);
	public float func_150906_h(Object itemStack);
	public boolean isWolfsFavoriteMeat();
	public Object setPotionEffect(int par1, int par2, int par3, float par4);
	public Object setAlwaysEdible();

}
