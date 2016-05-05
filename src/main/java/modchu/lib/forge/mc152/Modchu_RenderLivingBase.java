package modchu.lib.forge.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLivingBase;
import modchu.lib.Modchu_IRenderLivingBaseMaster;
import modchu.lib.Modchu_Main;

public class Modchu_RenderLivingBase extends Modchu_RenderLiving implements Modchu_IRenderLivingBase {
	public Modchu_IRenderLivingBaseMaster master;

	public Modchu_RenderLivingBase(HashMap<String, Object> map) {
		super(map);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_RenderLivingBase init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRenderLivingBaseMaster ? (Modchu_IRenderLivingBaseMaster) instance : null;
	}

}
