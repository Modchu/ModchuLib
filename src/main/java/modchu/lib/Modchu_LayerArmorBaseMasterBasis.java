package modchu.lib;

import java.util.HashMap;

public class Modchu_LayerArmorBaseMasterBasis implements Modchu_ILayerArmorBaseMaster  {
	public Modchu_ILayerArmorBase base;

	public Modchu_LayerArmorBaseMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_ILayerArmorBase) map.get("base");
	}

	@Override
	public void initArmor() {
		base.superInitArmor();
	}

	@Override
	public void func_177179_a(Object modelBase, int i) {
		base.superFunc_177179_a(modelBase, i);
	}

	@Override
	public void doRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		base.superDoRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public boolean shouldCombineTextures() {
		return base.superShouldCombineTextures();
	}

	@Override
	public Object getCurrentArmor(Object entityLivingBase, int i) {
		return base.superGetCurrentArmor(entityLivingBase, i);
	}

	@Override
	public Object func_177175_a(int i) {
		return base.superFunc_177175_a(i);
	}

	@Override
	public Object getArmorResource(Object entity, Object itemStack, int slot, String type) {
		return base.superGetArmorResource(entity, itemStack, slot, type);
	}

	@Override
	public Object getArmorModelHook(Object entityLivingBase, Object itemStack, int slot, Object modelBase) {
		return base.superGetArmorModelHook(entityLivingBase, itemStack, slot, modelBase);
	}

}
