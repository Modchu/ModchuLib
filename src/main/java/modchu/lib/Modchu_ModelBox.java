package modchu.lib;

import java.util.HashMap;

public class Modchu_ModelBox implements Modchu_IModelBox {
	public Modchu_IModelBoxMaster master;

	public Modchu_ModelBox(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_ModelBox init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IModelBoxMaster ? (Modchu_IModelBoxMaster) instance : null;
	}

	@Override
	public void render(float par2) {
		if (master != null) master.render(par2);
	}

	@Override
	public Modchu_ModelBox setBoxName(String pName) {
		return (Modchu_ModelBox) (master != null ? master.setBoxName(pName) : null);
	}

	@Override
	public int getBoxSizeX() {
		return master != null ? master.getBoxSizeX() : 0;
	}

	@Override
	public int getBoxSizeY() {
		return master != null ? master.getBoxSizeY() : 0;
	}

	@Override
	public int getBoxSizeZ() {
		return master != null ? master.getBoxSizeZ() : 0;
	}
}
