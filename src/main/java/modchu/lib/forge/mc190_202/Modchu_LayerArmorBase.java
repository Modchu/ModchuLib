package modchu.lib.forge.mc190_202;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerArmorBase;
import modchu.lib.Modchu_ILayerArmorBaseMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Modchu_LayerArmorBase extends LayerArmorBase implements Modchu_ILayerArmorBase {
	public Modchu_ILayerArmorBaseMaster master;

	public Modchu_LayerArmorBase(HashMap<String, Object> map) {
		super((RenderLivingBase) map.get("Object"));
		Modchu_Debug.lDebug("Modchu_LayerArmorBase init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerArmorBase init instance="+instance);
		master = instance instanceof Modchu_ILayerArmorBaseMaster ? (Modchu_ILayerArmorBaseMaster) instance : null;
	}

	@Override
	public void doRenderLayer(EntityLivingBase entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		if (master != null) master.doRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
		else super.doRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public void superDoRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		super.doRenderLayer((EntityLivingBase) entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : super.shouldCombineTextures();
	}

	@Override
	public boolean superShouldCombineTextures() {
		return super.shouldCombineTextures();
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityLivingBase entityLivingBase, EntityEquipmentSlot entityEquipmentSlot) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(entityLivingBase, entityEquipmentSlot) : super.getItemStackFromSlot(entityLivingBase, entityEquipmentSlot));
	}

	@Override
	public ItemStack superGetItemStackFromSlot(Object entityLivingBase, Object entityEquipmentSlot) {
		return super.getItemStackFromSlot((EntityLivingBase) entityLivingBase, (EntityEquipmentSlot) entityEquipmentSlot);
	}

	@Override
	public ModelBase getModelFromSlot(EntityEquipmentSlot entityEquipmentSlot) {
		return (ModelBase) (master != null ? master.getModelFromSlot(entityEquipmentSlot) : super.getModelFromSlot(entityEquipmentSlot));
	}

	@Override
	public ModelBase superGetModelFromSlot(Object entityEquipmentSlot) {
		return super.getModelFromSlot((EntityEquipmentSlot) entityEquipmentSlot);
	}

	@Override
	public ResourceLocation getArmorResource(Entity entity, ItemStack itemStack, EntityEquipmentSlot entityEquipmentSlot, String type) {
		return (ResourceLocation) (master != null ? master.getArmorResource(entity, itemStack, entityEquipmentSlot, type) : super.getArmorResource(entity, itemStack, entityEquipmentSlot, type));
	}

	@Override
	public ResourceLocation superGetArmorResource(Object entity, Object itemStack, Object entityEquipmentSlot, String type) {
		return super.getArmorResource((Entity) entity, (ItemStack) itemStack, (EntityEquipmentSlot) entityEquipmentSlot, type);
	}

	@Override
	protected void initArmor() {
		if (master != null) master.initArmor();
	}

	@Override
	public void superInitArmor() {
	}

	@Override
	protected void setModelSlotVisible(ModelBase modelBase, EntityEquipmentSlot entityEquipmentSlot) {
		if (master != null) master.setModelSlotVisible(modelBase, entityEquipmentSlot);
	}

	@Override
	public void superSetModelSlotVisible(Object modelBase, Object entityEquipmentSlot) {
	}

	@Override
	protected ModelBase getArmorModelHook(EntityLivingBase entityLivingBase, ItemStack itemStack, EntityEquipmentSlot entityEquipmentSlot, ModelBase modelBase) {
		return (ModelBase) (master != null ? master.getArmorModelHook(entityLivingBase, itemStack, entityEquipmentSlot, modelBase) : super.getArmorModelHook(entityLivingBase, itemStack, entityEquipmentSlot, modelBase));
	}

	@Override
	public Object superGetArmorModelHook(Object entityLivingBase, Object itemStack, Object entityEquipmentSlot, Object modelBase) {
		return super.getArmorModelHook((EntityLivingBase) entityLivingBase, (ItemStack) itemStack, (EntityEquipmentSlot) entityEquipmentSlot, (ModelBase) modelBase);
	}

	@Override
	public Object superGetCurrentArmor(Object entityLivingBase, int i) {
		return null;
	}

}
