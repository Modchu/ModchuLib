package modchu.lib.characteristic;import modchu.lib.Modchu_ITexturedTriangle;import modchu.lib.Modchu_Reflect;import net.minecraft.src.PositionTextureVertex;import net.minecraft.src.Tessellator;import net.minecraft.src.TexturedQuad;public class Modchu_TexturedTriangle extends TexturedQuad {	public Modchu_ITexturedTriangle master;	public Modchu_TexturedTriangle(PositionTextureVertex[] var1) {		this(null, var1);	}	public Modchu_TexturedTriangle(PositionTextureVertex[] var1, float[][] var2, float[][] var3, float[] var4, float var5, float var6) {		this(null, var1, var2, var3, var4, var5, var6);	}	public Modchu_TexturedTriangle(Class masterClass, PositionTextureVertex[] var1) {		super(var1);		init(masterClass, (Object)var1);	}	public Modchu_TexturedTriangle(Class masterClass, PositionTextureVertex[] var1, float[][] var2, float[][] var3, float[] var4, float var5, float var6) {		this(var1);		init(masterClass, var1, var2, var3, var4, var5, var6);	}	private void init(Class masterClass, Object... o) {		if (masterClass != null) ;else masterClass = Modchu_Reflect.loadClass("modchu.model.ModchuModel_TexturedTriangleMaster");		if (masterClass != null) ;else throw new RuntimeException("Modchu_TexturedTriangle init masterClass null !!");		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_TexturedTriangle.class, Object[].class }, new Object[]{ this, (Object[])o });		//Modchu_Debug.mDebug("Modchu_TexturedTriangle instance="+instance);		master = instance instanceof Modchu_ITexturedTriangle ? (Modchu_ITexturedTriangle) instance : null;		if (master != null) ;else throw new RuntimeException("Modchu_TexturedTriangle init master null !! masterClass=" + masterClass);	}	public void flipFace() {		master.flipFace();	}	public void draw(Tessellator var1, float var2) {		master.draw(var1, var2);	}}