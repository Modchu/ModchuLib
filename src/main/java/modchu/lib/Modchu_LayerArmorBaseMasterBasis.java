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
	public void setModelSlotVisible(Object modelBase, Object entityEquipmentSlotOrInt) {
		base.superSetModelSlotVisible(modelBase, entityEquipmentSlotOrInt);
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
	public Object getItemStackFromSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt) {
		return base.superGetItemStackFromSlot(entityLivingBase, entityEquipmentSlotOrInt);
	}

	@Override
	public Object getModelFromSlot(Object entityEquipmentSlotOrInt) {
		return base.superGetModelFromSlot(entityEquipmentSlotOrInt);
	}

	@Override
	public Object getArmorResource(Object entity, Object itemStack, Object entityEquipmentSlotOrInt, String type) {
		return base.superGetArmorResource(entity, itemStack, entityEquipmentSlotOrInt, type);
	}

	@Override
	public Object getArmorModelHook(Object entityLivingBase, Object itemStack, Object entityEquipmentSlotOrInt, Object modelBase) {
		return base.superGetArmorModelHook(entityLivingBase, itemStack, entityEquipmentSlotOrInt, modelBase);
	}

	@Override
	public Object getCurrentArmor(Object entityLivingBase, int i) {
		return base.superGetCurrentArmor(entityLivingBase, i);
	}

}
