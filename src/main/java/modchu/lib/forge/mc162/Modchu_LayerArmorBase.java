package modchu.lib.forge.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerArmorBase;
import modchu.lib.Modchu_ILayerArmorBaseMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Modchu_LayerArmorBase implements Modchu_ILayerArmorBase {
	public Modchu_ILayerArmorBaseMaster master;

	public Modchu_LayerArmorBase(HashMap<String, Object> map) {
		Modchu_Debug.lDebug("Modchu_LayerArmorBase init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerArmorBase init instance="+instance);
		master = instance instanceof Modchu_ILayerArmorBaseMaster ? (Modchu_ILayerArmorBaseMaster) instance : null;
	}

	public void doRenderLayer(EntityLivingBase entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		if (master != null) master.doRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public void superDoRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
	}

	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : false;
	}

	@Override
	public boolean superShouldCombineTextures() {
		return false;
	}

	public ItemStack func_177176_a(EntityLivingBase entityLivingBase, int i) {
		return (ItemStack) (master != null ? master.getCurrentArmor(entityLivingBase, i) : null);
	}

	@Override
	public ItemStack superGetCurrentArmor(Object entityLivingBase, int i) {
		return null;
	}

	public ModelBase func_177175_a(int i) {
		return (ModelBase) (master != null ? master.getModelFromSlot(i) : null);
	}

	@Override
	public ModelBase superGetModelFromSlot(Object i) {
		return null;
	}

	public ResourceLocation getArmorResource(Entity entity, ItemStack itemStack, Object slot, String type) {
		return (ResourceLocation) (master != null ? master.getArmorResource(entity, itemStack, slot, type) : null);
	}

	@Override
	public ResourceLocation superGetArmorResource(Object entity, Object itemStack, Object slot, String type) {
		return null;
	}

	protected void func_177177_a() {
		if (master != null) master.initArmor();
	}

	@Override
	public void superInitArmor() {
	}

	protected void func_177179_a(ModelBase modelBase, int i) {
		if (master != null) master.setModelSlotVisible(modelBase, i);
	}

	@Override
	public void superSetModelSlotVisible(Object modelBase, Object i) {
	}

	@Override
	public Object superGetArmorModelHook(Object entityLivingBase, Object itemStack, Object slot, Object modelBase) {
		return modelBase;
	}
	// 190~
	@Override
	public Object superGetItemStackFromSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt) {
		return null;
	}

}
