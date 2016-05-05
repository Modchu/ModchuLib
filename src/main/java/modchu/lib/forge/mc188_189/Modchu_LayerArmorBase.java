package modchu.lib.forge.mc188_189;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerArmorBase;
import modchu.lib.Modchu_ILayerArmorBaseMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Modchu_LayerArmorBase extends LayerArmorBase implements Modchu_ILayerArmorBase {
	public Modchu_ILayerArmorBaseMaster master;

	public Modchu_LayerArmorBase(HashMap<String, Object> map) {
		super((RendererLivingEntity) map.get("Object"));
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
	public ItemStack getCurrentArmor(EntityLivingBase entityLivingBase, int i) {
		return (ItemStack) (master != null ? master.getCurrentArmor(entityLivingBase, i) : super.getCurrentArmor(entityLivingBase, i));
	}

	@Override
	public ItemStack superGetCurrentArmor(Object entityLivingBase, int i) {
		return super.getCurrentArmor((EntityLivingBase) entityLivingBase, i);
	}

	@Override
	public ModelBase func_177175_a(int i) {
		return (ModelBase) (master != null ? master.getModelFromSlot(i) : super.func_177175_a(i));
	}

	@Override
	public ModelBase superGetModelFromSlot(Object i) {
		return super.func_177175_a((Integer) i);
	}

	@Override
	public ResourceLocation getArmorResource(Entity entity, ItemStack itemStack, int slot, String type) {
		return (ResourceLocation) (master != null ? master.getArmorResource(entity, itemStack, slot, type) : super.getArmorResource(entity, itemStack, slot, type));
	}

	@Override
	public ResourceLocation superGetArmorResource(Object entity, Object itemStack, Object slot, String type) {
		return super.getArmorResource((Entity) entity, (ItemStack) itemStack, (Integer) slot, type);
	}

	@Override
	protected void initArmor() {
		if (master != null) master.initArmor();
	}

	@Override
	public void superInitArmor() {
	}

	@Override
	protected void func_177179_a(ModelBase modelBase, int i) {
		if (master != null) master.setModelSlotVisible(modelBase, i);
	}

	@Override
	public void superSetModelSlotVisible(Object modelBase, Object i) {
	}

	@Override
	protected ModelBase getArmorModelHook(EntityLivingBase entityLivingBase, ItemStack itemStack, int slot, ModelBase modelBase) {
		return (ModelBase) (master != null ? master.getArmorModelHook(entityLivingBase, itemStack, slot, modelBase) : super.getArmorModelHook(entityLivingBase, itemStack, slot, modelBase));
	}

	@Override
	public Object superGetArmorModelHook(Object entityLivingBase, Object itemStack, Object slot, Object modelBase) {
		return super.getArmorModelHook((EntityLivingBase) entityLivingBase, (ItemStack) itemStack, (Integer) slot, (ModelBase) modelBase);
	}
	// 190~
	@Override
	public Object superGetItemStackFromSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt) {
		return null;
	}

}
