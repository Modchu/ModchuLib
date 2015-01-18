package modchu.lib.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerArmorBaseMaster;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ResourceLocation;

public class Modchu_LayerArmorBase {
	public static Modchu_ILayerArmorBaseMaster master;

	public Modchu_LayerArmorBase(Class masterClass, Object rendererLivingEntity) {
		Modchu_Debug.lDebug("Modchu_LayerArmorBase init");
		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Object.class }, new Object[]{ this });
		Modchu_Debug.mDebug("Modchu_LayerArmorBase init instance="+instance);
		master = instance instanceof Modchu_ILayerArmorBaseMaster ? (Modchu_ILayerArmorBaseMaster) instance : null;
	}

	public void doRenderLayer(EntityLivingBase entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		if (master != null) master.doRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	public void superDoRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
	}

	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : false;
	}

	public boolean superShouldCombineTextures() {
		return false;
	}

	public ItemStack func_177176_a(EntityLivingBase entityLivingBase, int i) {
		return (ItemStack) (master != null ? master.func_177176_a(entityLivingBase, i) : null);
	}

	public ItemStack superFunc_177176_a(Object entityLivingBase, int i) {
		return null;
	}

	public ModelBase func_177175_a(int i) {
		return (ModelBase) (master != null ? master.func_177175_a(i) : null);
	}

	public ModelBase superFunc_177175_a(int i) {
		return null;
	}

	public ResourceLocation getArmorResource(Entity entity, ItemStack itemStack, int slot, String type) {
		return (ResourceLocation) (master != null ? master.getArmorResource(entity, itemStack, slot, type) : null);
	}

	public ResourceLocation superGetArmorResource(Object entity, Object itemStack, int slot, String type) {
		return null;
	}

	protected void func_177177_a() {
		if (master != null) master.func_177177_a();
	}

	public void superFunc_177177_a() {
	}

	protected void func_177179_a(ModelBase modelBase, int i) {
		if (master != null) master.func_177179_a(modelBase, i);
	}

	public void superFunc_177179_a(Object modelBase, int i) {
	}

}
