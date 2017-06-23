package modchu.lib.modloader.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_ITexturedQuad;
import modchu.lib.Modchu_ITexturedQuadMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.PositionTextureVertex;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TexturedQuad;

public class Modchu_TexturedQuad extends TexturedQuad implements Modchu_ITexturedQuad {
	public Modchu_ITexturedQuadMaster master;

	public Modchu_TexturedQuad(HashMap<String, Object> map) {
		super(new PositionTextureVertex[6]);
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
	public void draw(Tessellator par1Tessellator, float f) {
		master.draw(f);
	}

	@Override
	public void setInvertNormal(boolean b) {
		master.setInvertNormal(b);
	}

}
