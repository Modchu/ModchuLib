package modchu.lib;

import java.nio.FloatBuffer;

public class Modchu_GlStateManager {
	public static Modchu_IGlStateManager master;
	
	public static void init() {
		Object instance = Modchu_Main.newModchuCharacteristicObject("Modchu_GlStateManager");
		//Modchu_Debug.mDebug("Modchu_GlStateManager init instance="+instance);
		master = instance instanceof Modchu_IGlStateManager ? (Modchu_IGlStateManager) instance : null;
	}

	public static void pushMatrix() {
		master.pushMatrix();
	}

	public static void ortho(int i, int width, int j, int height, int k, int l) {
		master.ortho(i, width, j, height, k, l);
	}

	public static void ortho(double d, double width, double height, double e, double f, double g) {
		master.ortho(d, width, height, e, f, g);
	}

	public static void clearColor(float f, float f1, float f2, float f3) {
		master.clearColor(f, f1, f2, f3);
	}

	public static void clear(int i) {
		master.clear(i);
	}

	public static void popMatrix() {
		master.popMatrix();
	}

	public static void generateTexture() {
		master.generateTexture();
	}

	public static void enableTexture2D() {
		master.enableTexture2D();
	}

	public static void enableBlend() {
		master.enableBlend();
	}

	public static void matrixMode(int i) {
		master.matrixMode(i);
	}

	public static void loadIdentity() {
		master.loadIdentity();
	}

	public static void enableDepth() {
		master.enableDepth();
	}

	public static void alphaFunc(int i, float f) {
		master.alphaFunc(i, f);
	}

	public static void translate(float f, float f1, float f2) {
		master.translate(f, f1, f2);
	}

	public static void disableLighting() {
		master.disableLighting();
	}

	public static void disableFog() {
		master.disableFog();
	}

	public static void disableDepth() {
		master.disableDepth();
	}

	public static void viewport(int i, int j, int width, int height) {
		master.viewport(i, j, width, height);
	}

	public static void color(float r, float g, float b, float a) {
		master.color(r, g, b, a);
	}

	public static void enableAlpha() {
		master.enableAlpha();
	}

	public static void pushAttrib() {
		master.pushAttrib();
	}

	public static void popAttrib() {
		master.popAttrib();
	}

	public static void disableAlpha() {
		master.disableAlpha();
	}

	public static void enableLighting() {
		master.enableLighting();
	}

	public static void enableLight(int p_179085_0_) {
		master.enableLight(p_179085_0_);
	}

	public static void disableLight(int p_179122_0_) {
		master.disableLight(p_179122_0_);
	}

	public static void enableColorMaterial() {
		master.enableColorMaterial();
	}

	public static void disableColorMaterial() {
		master.disableColorMaterial();
	}

	public static void colorMaterial(int p_179104_0_, int p_179104_1_) {
		master.colorMaterial(p_179104_0_, p_179104_1_);
	}

	public static void depthFunc(int p_179143_0_) {
		master.depthFunc(p_179143_0_);
	}

	public static void depthMask(boolean p_179132_0_) {
		master.depthMask(p_179132_0_);
	}

	public static void disableBlend() {
		master.disableBlend();
	}

	public static void blendFunc(int p_179112_0_, int p_179112_1_) {
		master.blendFunc(p_179112_0_, p_179112_1_);
	}

	public static void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		master.tryBlendFuncSeparate(p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
	}

	public static void enableFog() {
		master.enableFog();
	}

	public static void setFog(int p_179093_0_) {
		master.setFog(p_179093_0_);
	}

	public static void setFogDensity(float p_179095_0_) {
		master.setFogDensity(p_179095_0_);
	}

	public static void setFogStart(float p_179102_0_) {
		master.setFogStart(p_179102_0_);
	}

	public static void setFogEnd(float p_179153_0_) {
		master.setFogEnd(p_179153_0_);
	}

	public static void enableCull() {
		master.enableCull();
	}

	public static void disableCull() {
		master.disableCull();
	}

	public static void cullFace(int p_179107_0_) {
		master.cullFace(p_179107_0_);
	}

	public static void enablePolygonOffset() {
		master.enablePolygonOffset();
	}

	public static void disablePolygonOffset() {
		master.disablePolygonOffset();
	}

	public static void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		master.doPolygonOffset(p_179136_0_, p_179136_1_);
	}

	public static void enableColorLogic() {
		master.enableColorLogic();
	}

	public static void disableColorLogic() {
		master.disableColorLogic();
	}

	public static void colorLogicOp(int p_179116_0_) {
		master.colorLogicOp(p_179116_0_);
	}

	public static void enableTexGenCoord(Object glStateManagerTexGen) {
		master.enableTexGenCoord(glStateManagerTexGen);
	}

	public static void disableTexGenCoord(Object glStateManagerTexGen) {
		master.disableTexGenCoord(glStateManagerTexGen);
	}

	public static void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		master.texGen(glStateManagerTexGen, p_179149_1_);
	}

	public static void texGen(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		master.texGen(glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

	public static void disableTexture2D() {
		master.disableTexture2D();
	}

	public static void deleteTexture(int p_179150_0_) {
		master.deleteTexture(p_179150_0_);
	}

	public static void bindTexture(int p_179144_0_) {
		master.bindTexture(p_179144_0_);
	}

	public static void enableNormalize() {
		master.enableNormalize();
	}

	public static void disableNormalize() {
		master.disableNormalize();
	}

	public static void shadeModel(int p_179103_0_) {
		master.shadeModel(p_179103_0_);
	}

	public static void enableRescaleNormal() {
		master.enableRescaleNormal();
	}

	public static void disableRescaleNormal() {
		master.disableRescaleNormal();
	}

	public static void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		master.colorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
	}

	public static void clearDepth(double p_179151_0_) {
		master.clearDepth(p_179151_0_);
	}

	public static void getFloat(int p_179111_0_, Object p_179111_1_) {
		master.getFloat(p_179111_0_, (FloatBuffer) p_179111_1_);
	}

	public static void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		master.rotate(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	public static void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		master.scale(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	public static void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		master.scale(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	public static void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		master.translate(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	public static void multMatrix(Object p_179110_0_) {
		master.multMatrix((FloatBuffer) p_179110_0_);
	}

	public static void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		master.color(p_179124_0_, p_179124_1_, p_179124_2_);
	}

	public static void resetColor() {
		master.resetColor();
	}

	public static void callList(int p_179148_0_) {
		master.callList(p_179148_0_);
	}

}
