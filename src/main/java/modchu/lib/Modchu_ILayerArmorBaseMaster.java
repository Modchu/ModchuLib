package modchu.lib;

public interface Modchu_ILayerArmorBaseMaster {

	public void initArmor();
	public void func_177179_a(Object modelBase, int i);
	public void doRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6);
	public boolean shouldCombineTextures();
	public Object getCurrentArmor(Object entityLivingBase, int i);
	public Object func_177175_a(int i);
	public Object getArmorResource(Object entity, Object itemStack, int slot, String type);
	public Object getArmorModelHook(Object entityLivingBase, Object itemStack, int slot, Object modelBase);

}
