package modchu.lib;

public interface Modchu_ILayerArmorBase {
	public void superDoRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6);
	public boolean superShouldCombineTextures();
	public Object superGetCurrentArmor(Object entityLivingBase, int i);
	public Object superFunc_177175_a(int i);
	public Object superGetArmorResource(Object entity, Object itemStack, int slot, String type);
	public void superInitArmor();
	public void superFunc_177179_a(Object modelBase, int i);
	public Object superGetArmorModelHook(Object entityLivingBase, Object itemStack, int slot, Object modelBase);

}
