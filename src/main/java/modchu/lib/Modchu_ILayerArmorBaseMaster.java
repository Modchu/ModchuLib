package modchu.lib;

public interface Modchu_ILayerArmorBaseMaster {

	public void initArmor();
	public void setModelSlotVisible(Object modelBase, Object entityEquipmentSlotOrInt);
	public void doRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6);
	public boolean shouldCombineTextures();
	public Object getItemStackFromSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt);
	public Object getModelFromSlot(Object entityEquipmentSlotOrInt);
	public Object getArmorResource(Object entity, Object itemStack, Object entityEquipmentSlotOrInt, String type);
	public Object getArmorModelHook(Object entityLivingBase, Object itemStack, Object entityEquipmentSlotOrInt, Object modelBase);
	public Object getCurrentArmor(Object entityLivingBase, int i);

}
