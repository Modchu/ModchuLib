package modchu.lib.modloader.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerHeldItem;
import modchu.lib.Modchu_ILayerHeldItemMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.EntityLiving;

public class Modchu_LayerHeldItem implements Modchu_ILayerHeldItem {
	public Modchu_ILayerHeldItemMaster master;

	public Modchu_LayerHeldItem(HashMap<String, Object> map) {
		Modchu_Debug.lDebug("Modchu_LayerHeldItem init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerHeldItem init instance="+instance);
		master = instance instanceof Modchu_ILayerHeldItemMaster ? (Modchu_ILayerHeldItemMaster) instance : null;
	}

	public void doRenderLayer(EntityLiving entityLiving, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		if (master != null) master.doRenderLayer(entityLiving, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
	}

	@Override
	public void superDoRenderLayer(Object entityLivingBase, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
	}

	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : false;
	}

	@Override
	public boolean superShouldCombineTextures() {
		return false;
	}

}
