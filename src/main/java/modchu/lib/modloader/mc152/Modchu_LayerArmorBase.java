package modchu.lib.modloader.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerArmorBase;
import modchu.lib.Modchu_ILayerArmorBaseMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBase;

public class Modchu_LayerArmorBase implements Modchu_ILayerArmorBase {
	public Modchu_ILayerArmorBaseMaster master;

	public Modchu_LayerArmorBase(HashMap<String, Object> map) {
		Modchu_Debug.lDebug("Modchu_LayerArmorBase init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerArmorBase init instance="+instance);
		master = instance instanceof Modchu_ILayerArmorBaseMaster ? (Modchu_ILayerArmorBaseMaster) instance : null;
	}

	public void doRenderLayer(EntityLiving EntityLiving, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		if (master != null) master.doRenderLayer(EntityLiving, f, f1, f2, f3, f4, f5, f6);
	}

	public void superDoRenderLayer(Object EntityLiving, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
	}

	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : false;
	}

	public boolean superShouldCombineTextures() {
		return false;
	}

	public ItemStack func_177176_a(EntityLiving EntityLiving, int i) {
		return (ItemStack) (master != null ? master.getCurrentArmor(EntityLiving, i) : null);
	}

	public ItemStack superGetCurrentArmor(Object EntityLiving, int i) {
		return null;
	}

	public ModelBase func_177175_a(int i) {
		return (ModelBase) (master != null ? master.func_177175_a(i) : null);
	}

	public ModelBase superFunc_177175_a(int i) {
		return null;
	}

	protected void func_177177_a() {
		if (master != null) master.initArmor();
	}

	public void superInitArmor() {
	}

	protected void func_177179_a(ModelBase modelBase, int i) {
		if (master != null) master.func_177179_a(modelBase, i);
	}

	public void superFunc_177179_a(Object modelBase, int i) {
	}

	@Override
	public Object superGetArmorResource(Object entity, Object itemStack, int slot, String type) {
		return null;
	}

	@Override
	public Object superGetArmorModelHook(Object entityLivingBase, Object itemStack, int slot, Object modelBase) {
		return modelBase;
	}

}
