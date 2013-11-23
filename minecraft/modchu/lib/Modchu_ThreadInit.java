package modchu.lib;

import java.util.List;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.LoaderState.ModState;

public class Modchu_ThreadInit extends Thread {

	@Override
	public void run() {
		while (true) {
			List<ModContainer> mod = Loader.instance().getModList();
			ModContainer finalMod = mod.get(mod.size()-1);
			ModState finalModState = Loader.instance().getModState(finalMod);
			if (finalModState == ModState.AVAILABLE) {
				load();
				break;
			}
		}
	}

	public void load() {
		Modchu_Main.modsLoaded();
	}
}

