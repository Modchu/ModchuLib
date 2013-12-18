package modchu.lib.fmlonly;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState.ModState;
import cpw.mods.fml.common.ModContainer;

public class Modchu_ThreadInit extends Thread {

	private static int waitCount;
	public static byte state = 0;
	public static ArrayList<Method> loadList = new ArrayList();

	@Override
	public void run() {
		if (state > 0) return;
		Modchu_Debug.lDebug("Modchu_ThreadInit run() start.");
		state = 1;
		while (state < 2) {
			List<ModContainer> mod = Loader.instance().getModList();
			for (int i = mod.size() - 1; i > -1; i--) {
				ModContainer finalMod = mod.get(i);
				ModState finalModState = Loader.instance().getModState(finalMod);
				Modchu_Debug.dDebug("ModchuLib Now Loading Please wait.");
				Modchu_Debug.dDebug("Modchu_ThreadInit run() (1 / 2) finalModState="+finalModState, 1);
				if (finalModState == ModState.AVAILABLE) {
					Modchu_Debug.lDebug("Modchu_ThreadInit run() AVAILABLE ok.");
					state = 2;
					break;
				} else {
					//Modchu_Debug.lDebug("Modchu_ThreadInit run() else finalModState="+finalModState);
					if (finalModState == ModState.ERRORED
							| finalModState == ModState.DISABLED) {
					} else {
						//Modchu_Debug.lDebug("Modchu_ThreadInit run() else -1");
						i = -1;
					}
				}
			}
		}
		Modchu_Debug.lDebug("Modchu_ThreadInit run() loadList.isEmpty()="+(loadList.isEmpty()));
		if (loadList.isEmpty()) state = 3;
		while (state < 3) {
			waitCount++;
			if (waitCount > 5) {
				waitCount = 0;
				if (!loadList.isEmpty()) load();
			}
			Modchu_Debug.dDebug("Modchu_ThreadInit run() (2 / 2) ModsLoaded waitting. ("+Modchu_Main.initModsLoadedCount+" / 100)", 1);
			if (Modchu_Main.initModsLoadedCount > 97) {
				state = 3;
				Modchu_Debug.lDebug("Modchu_ThreadInit run() state = 3");
			}
		}
		if (!loadList.isEmpty()) load();
		Modchu_Debug.dDebug(null, 0);
		Modchu_Debug.dDebug(null, 1);
		Modchu_Debug.lDebug("Modchu_ThreadInit run() end.");
	}

	public static void load() {
		Modchu_Debug.lDebug("Modchu_ThreadInit load()");
		for (int i = 0; i < loadList.size(); i++) {
			Method method = loadList.get(i);
			Modchu_Debug.lDebug("Modchu_ThreadInit load() method="+method);
			if (method != null) Modchu_Reflect.invoke(method);
		}
		loadList.clear();
		Modchu_Debug.lDebug("Modchu_ThreadInit load() end.");
	}

	public static void register(Method method) {
		Modchu_Debug.lDebug("Modchu_ThreadInit register method="+method);
		if (!loadList.contains(method)) {
			loadList.add(method);
			Modchu_Debug.lDebug("Modchu_ThreadInit register loadList.add");
			if (state > 2) {
				Modchu_Debug.lDebug("Modchu_ThreadInit register state > 2 load");
				load();
			}
		}
	}
}

