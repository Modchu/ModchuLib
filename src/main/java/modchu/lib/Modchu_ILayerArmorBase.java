package modchu.lib;

public interface Modchu_ILayerArmorBase {
	public void superDoRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6);
	public boolean superShouldCombineTextures();
	public Object superGetItemStackFromSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt);
	public Object superGetModelFromSlot(Object entityEquipmentSlotOrInt);
	public Object superGetArmorResource(Object entity, Object itemStack, Object entityEquipmentSlotOrInt, String type);
	public void superInitArmor();
	public void superSetModelSlotVisible(Object modelBase, Object entityEquipmentSlotOrInt);
	public Object superGetArmorModelHook(Object entityLivingBase, Object itemStack, Object entityEquipmentSlotOrInt, Object modelBase);
	public Object superGetCurrentArmor(Object entityLivingBase, int i);

}
