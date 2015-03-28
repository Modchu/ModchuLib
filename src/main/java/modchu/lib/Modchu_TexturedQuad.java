package modchu.lib;

import java.util.HashMap;

public class Modchu_TexturedQuad implements Modchu_ITexturedQuad {
	public Modchu_ITexturedQuadMaster master;

	public Modchu_TexturedQuad(HashMap<String, Object> map) {
		init(map);
	}

	public void init(HashMap<String, Object> map) {
		Class masterClass = (Class) map.get("Class");
		if (masterClass != null); else throw new RuntimeException("Modchu_TexturedQuad init masterClass null !!");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.mDebug("Modchu_TexturedQuad instance="+instance);
		master = instance instanceof Modchu_ITexturedQuadMaster ? (Modchu_ITexturedQuadMaster) instance : null;
		if (master != null); else throw new RuntimeException("Modchu_TexturedQuad init master null !! masterClass=" + masterClass);
	}

	@Override
	public void flipFace() {
		master.flipFace();
	}

	@Override
	public void draw(float f) {
		master.draw(f);
	}

	@Override
	public void setInvertNormal(boolean b) {
		master.setInvertNormal(b);
	}

}
