package modchu.lib.forge.mc180_188;

import java.nio.FloatBuffer;
import java.util.HashMap;

import net.minecraft.client.renderer.GlStateManager;

public class Modchu_GlStateManager extends modchu.lib.forge.mc180_189.Modchu_GlStateManager {

	public Modchu_GlStateManager(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void texGen(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		GlStateManager.func_179105_a((GlStateManager.TexGen) glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

}
