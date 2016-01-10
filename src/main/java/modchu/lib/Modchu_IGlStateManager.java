package modchu.lib;

public interface Modchu_IGlStateManager {
	public void pushMatrix();
	public void ortho(int i, int width, int j, int height, int k, int l);
	public void ortho(double d, double width, double height, double e, double f, double g);
	public void clearColor(float f, float f1, float f2, float f3);
	public void clear(int i);
	public void popMatrix();
	public void generateTexture();
	public void enableTexture2D();
	public void enableBlend();
	public void matrixMode(int i);
	public void loadIdentity();
	public void enableDepth();
	public void alphaFunc(int i, float f);
	public void translate(float f, float f1, float f2);
	public void disableLighting();
	public void disableFog();
	public void disableDepth();
	public void viewport(int i, int j, int width, int height);
	public void color(float r, float g, float b, float a);
	public void enableAlpha();
	public void pushAttrib();
	public void popAttrib();
	public void disableAlpha();
	public void enableLighting();
	public void enableLight(int p_179085_0_);
	public void disableLight(int p_179122_0_);
	public void enableColorMaterial();
	public void disableColorMaterial();
	public void colorMaterial(int p_179104_0_, int p_179104_1_);
	public void depthFunc(int p_179143_0_);
	public void depthMask(boolean p_179132_0_);
	public void disableBlend();
	public void blendFunc(int p_179112_0_, int p_179112_1_);
	public void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_);
	public void enableFog();
	public void setFog(int p_179093_0_);
	public void setFogDensity(float p_179095_0_);
	public void setFogStart(float p_179102_0_);
	public void setFogEnd(float p_179153_0_);
	public void enableCull();
	public void disableCull();
	public void cullFace(int p_179107_0_);
	public void enablePolygonOffset();
	public void disablePolygonOffset();
	public void doPolygonOffset(float p_179136_0_, float p_179136_1_);
	public void enableColorLogic();
	public void disableColorLogic();
	public void colorLogicOp(int p_179116_0_);
	public void enableTexGenCoord(Object glStateManagerTexGen);
	public void disableTexGenCoord(Object glStateManagerTexGen);
	public void texGen(Object glStateManagerTexGen, int p_179149_1_);
	public void texGen(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer);
	public void disableTexture2D();
	public void deleteTexture(int p_179150_0_);
	public void bindTexture(int p_179144_0_);
	public void enableNormalize();
	public void disableNormalize();
	public void shadeModel(int p_179103_0_);
	public void enableRescaleNormal();
	public void disableRescaleNormal();
	public void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_);
	public void clearDepth(double p_179151_0_);
	public void getFloat(int p_179111_0_, Object p_179111_1_);
	public void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_);
	public void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_);
	public void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_);
	public void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_);
	public void multMatrix(Object p_179110_0_);
	public void color(float p_179124_0_, float p_179124_1_, float p_179124_2_);
	public void resetColor();
	public void callList(int p_179148_0_);

}
