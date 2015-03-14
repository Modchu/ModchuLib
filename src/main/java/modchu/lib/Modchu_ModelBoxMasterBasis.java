package modchu.lib;

import java.util.HashMap;

public class Modchu_ModelBoxMasterBasis implements Modchu_IModelBoxMaster {
	public Modchu_IModelBox base;
	public String boxName;
	public int boxSizeX;
	public int boxSizeY;
	public int boxSizeZ;

	public Modchu_ModelBoxMasterBasis(HashMap<String, Object> map) {
		if (map != null); else return;
		base = map.containsKey("base") ? (Modchu_IModelBox)map.get("base") : null;
		boxSizeX = map.containsKey("Integer2") ? (Integer)map.get("Integer2") : 0;
		boxSizeY = map.containsKey("Integer3") ? (Integer)map.get("Integer3") : 0;
		boxSizeZ = map.containsKey("Integer4") ? (Integer)map.get("Integer4") : 0;
	}

	@Override
	public void render(float f) {
	}

	@Override
	public Modchu_IModelBox setBoxName(String s) {
		boxName = s;
		return base;
	}

	@Override
	public int getBoxSizeX() {
		return boxSizeX;
	}

	@Override
	public int getBoxSizeY() {
		return boxSizeY;
	}

	@Override
	public int getBoxSizeZ() {
		return boxSizeZ;
	}

}
