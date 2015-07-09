package modchu.lib;

import java.util.HashMap;

public class Modchu_IGuiHandlerMasterBasis implements Modchu_IGuiHandlerMaster {
	public Object base;

	public Modchu_IGuiHandlerMasterBasis(HashMap<String, Object> map) {
		base = map.get("base");
	}

	@Override
	public Object getServerGuiElement(int ID, Object entityPlayer, Object world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, Object entityPlayer, Object world, int x, int y, int z) {
		return null;
	}

}
