package modchu.lib.forge.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerCustomHead;
import modchu.lib.Modchu_ILayerCustomHeadMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.EntityLiving;

public class Modchu_LayerCustomHead implements Modchu_ILayerCustomHead {
	public Modchu_ILayerCustomHeadMaster master;

	public Modchu_LayerCustomHead(HashMap<String, Object> map) {
		Modchu_Debug.lDebug("Modchu_LayerCustomHead init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerCustomHead init instance="+instance);
		master = instance instanceof Modchu_ILayerCustomHeadMaster ? (Modchu_ILayerCustomHeadMaster) instance : null;
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

}
