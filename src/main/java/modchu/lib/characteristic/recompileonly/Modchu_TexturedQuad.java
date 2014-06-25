package modchu.lib.characteristic.recompileonly;

import modchu.lib.Modchu_ITexturedQuad;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;

public class Modchu_TexturedQuad extends TexturedQuad {

	public Modchu_ITexturedQuad master;

	public Modchu_TexturedQuad(PositionTextureVertex[] arrayOfPositionTextureVertex) {
		this(null, arrayOfPositionTextureVertex);
	}

	public Modchu_TexturedQuad(PositionTextureVertex[] arrayOfPositionTextureVertex, int par2, int par3, int par4, int par5, float par6, float par7) {
		this(null, arrayOfPositionTextureVertex, par2, par3, par4, par5, par6, par7);
	}

	public Modchu_TexturedQuad(Class masterClass, PositionTextureVertex[] arrayOfPositionTextureVertex) {
		super(arrayOfPositionTextureVertex);
		init(masterClass, arrayOfPositionTextureVertex, (Object[])null);
	}

	public Modchu_TexturedQuad(Class masterClass, PositionTextureVertex[] arrayOfPositionTextureVertex, int par2, int par3, int par4, int par5, float par6, float par7) {
		super(arrayOfPositionTextureVertex, par2, par3, par4, par5, par6, par7);
		init(masterClass, arrayOfPositionTextureVertex, par2, par3, par4, par5, par6, par7);
	}

	public void init(Class masterClass, PositionTextureVertex[] arrayOfPositionTextureVertex, Object... o) {
		if (masterClass != null) ;else masterClass = Modchu_Reflect.loadClass("modchu.model.ModchuModel_TexturedQuadMaster");
		if (masterClass != null) ;else throw new RuntimeException("Modchu_TexturedQuad init masterClass null !!");
		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_TexturedQuad.class, Object[].class, Object[].class }, new Object[]{ this, arrayOfPositionTextureVertex, (Object[])o });
		//Modchu_Debug.mDebug("Modchu_TexturedQuad instance="+instance);
		master = instance instanceof Modchu_ITexturedQuad ? (Modchu_ITexturedQuad) instance : null;
		if (master != null) ;else throw new RuntimeException("Modchu_TexturedQuad init master null !! masterClass=" + masterClass);
	}

	public void flipFace() {
		master.flipFace();
	}

	public void draw(Tessellator tessellator, float f) {
		master.draw(tessellator, f);
	}

	public void setInvertNormal(boolean b) {
		master.setInvertNormal(b);
	}

}
