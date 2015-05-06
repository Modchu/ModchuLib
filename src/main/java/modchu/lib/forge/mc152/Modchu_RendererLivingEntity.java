package modchu.lib.forge.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRendererLivingEntity;
import modchu.lib.Modchu_IRendererLivingEntityMaster;
import modchu.lib.Modchu_Main;

public class Modchu_RendererLivingEntity extends Modchu_RenderLiving implements Modchu_IRendererLivingEntity {
	public Modchu_IRendererLivingEntityMaster master;

	public Modchu_RendererLivingEntity(HashMap<String, Object> map) {
		super(map);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_RendererLivingEntity init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRendererLivingEntityMaster ? (Modchu_IRendererLivingEntityMaster) instance : null;
	}

}
