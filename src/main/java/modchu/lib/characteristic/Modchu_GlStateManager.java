package modchu.lib.characteristic;

import java.nio.FloatBuffer;

import modchu.lib.Modchu_GlStateManagerBase;

public class Modchu_GlStateManager extends Modchu_GlStateManagerBase {

	public static void pushMatrix() {
		Modchu_GlStateManagerBase.pushMatrix();
	}

	public static void ortho(int i, int width, int j, int height, int k, int l) {
		Modchu_GlStateManagerBase.ortho(i, width, j, height, k, l);
	}

	public static void ortho(double d, double width, double height, double e, double f, double g) {
		Modchu_GlStateManagerBase.ortho(d, width, height, e, f, g);
	}

	public static void clearColor(float f, float f1, float f2, float f3) {
		Modchu_GlStateManagerBase.clearColor(f, f1, f2, f3);
	}

	public static void clear(int i) {
		Modchu_GlStateManagerBase.clear(i);
	}

	public static void popMatrix() {
		Modchu_GlStateManagerBase.popMatrix();
	}

	public static void func_179146_y() {
		Modchu_GlStateManagerBase.func_179146_y();
	}

	public static void func_179098_w() {
		Modchu_GlStateManagerBase.func_179098_w();
	}

	public static void enableBlend() {
		Modchu_GlStateManagerBase.enableBlend();
	}

	public static void matrixMode(int i) {
		Modchu_GlStateManagerBase.matrixMode(i);
	}

	public static void loadIdentity() {
		Modchu_GlStateManagerBase.loadIdentity();
	}

	public static void enableDepth() {
		Modchu_GlStateManagerBase.enableDepth();
	}

	public static void alphaFunc(int i, float f) {
		Modchu_GlStateManagerBase.alphaFunc(i, f);
	}

	public static void translate(float f, float f1, float f2) {
		Modchu_GlStateManagerBase.translate(f, f1, f2);
	}

	public static void disableLighting() {
		Modchu_GlStateManagerBase.disableLighting();
	}

	public static void disableFog() {
		Modchu_GlStateManagerBase.disableFog();
	}

	public static void disableDepth() {
		Modchu_GlStateManagerBase.disableDepth();
	}

	public static void viewport(int i, int j, int width, int height) {
		Modchu_GlStateManagerBase.viewport(i, j, width, height);
	}

	public static void color(float r, float g, float b, float a) {
		Modchu_GlStateManagerBase.color(r, g, b, a);
	}

	public static void enableAlpha() {
		Modchu_GlStateManagerBase.enableAlpha();
	}

	public static void pushAttrib() {
		Modchu_GlStateManagerBase.pushAttrib();
	}

	public static void popAttrib() {
		Modchu_GlStateManagerBase.popAttrib();
	}

	public static void disableAlpha() {
		Modchu_GlStateManagerBase.disableAlpha();
	}

	public static void enableLighting() {
		Modchu_GlStateManagerBase.enableLighting();
	}

	public static void enableBooleanStateAt(int p_179085_0_) {
		Modchu_GlStateManagerBase.enableBooleanStateAt(p_179085_0_);
	}

	public static void disableBooleanStateAt(int p_179122_0_) {
		Modchu_GlStateManagerBase.disableBooleanStateAt(p_179122_0_);
	}

	public static void enableColorMaterial() {
		Modchu_GlStateManagerBase.enableColorMaterial();
	}

	public static void disableColorMaterial() {
		Modchu_GlStateManagerBase.disableColorMaterial();
	}

	public static void colorMaterial(int p_179104_0_, int p_179104_1_) {
		Modchu_GlStateManagerBase.colorMaterial(p_179104_0_, p_179104_1_);
	}

	public static void depthFunc(int p_179143_0_) {
		Modchu_GlStateManagerBase.depthFunc(p_179143_0_);
	}

	public static void depthMask(boolean p_179132_0_) {
		Modchu_GlStateManagerBase.depthMask(p_179132_0_);
	}

	public static void disableBlend() {
		Modchu_GlStateManagerBase.disableBlend();
	}

	public static void blendFunc(int p_179112_0_, int p_179112_1_) {
		Modchu_GlStateManagerBase.blendFunc(p_179112_0_, p_179112_1_);
	}

	public static void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		Modchu_GlStateManagerBase.tryBlendFuncSeparate(p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
	}

	public static void enableFog() {
		Modchu_GlStateManagerBase.enableFog();
	}

	public static void setFog(int p_179093_0_) {
		Modchu_GlStateManagerBase.setFog(p_179093_0_);
	}

	public static void setFogDensity(float p_179095_0_) {
		Modchu_GlStateManagerBase.setFogDensity(p_179095_0_);
	}

	public static void setFogStart(float p_179102_0_) {
		Modchu_GlStateManagerBase.setFogStart(p_179102_0_);
	}

	public static void setFogEnd(float p_179153_0_) {
		Modchu_GlStateManagerBase.setFogEnd(p_179153_0_);
	}

	public static void enableCull() {
		Modchu_GlStateManagerBase.enableCull();
	}

	public static void disableCull() {
		Modchu_GlStateManagerBase.disableCull();
	}

	public static void cullFace(int p_179107_0_) {
		Modchu_GlStateManagerBase.cullFace(p_179107_0_);
	}

	public static void enablePolygonOffset() {
		Modchu_GlStateManagerBase.enablePolygonOffset();
	}

	public static void disablePolygonOffset() {
		Modchu_GlStateManagerBase.disablePolygonOffset();
	}

	public static void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		Modchu_GlStateManagerBase.doPolygonOffset(p_179136_0_, p_179136_1_);
	}

	public static void enableColorLogic() {
		Modchu_GlStateManagerBase.enableColorLogic();
	}

	public static void disableColorLogic() {
		Modchu_GlStateManagerBase.disableColorLogic();
	}

	public static void colorLogicOp(int p_179116_0_) {
		Modchu_GlStateManagerBase.colorLogicOp(p_179116_0_);
	}

	public static void enableTexGenCoord(Object glStateManagerTexGen) {
		Modchu_GlStateManagerBase.enableTexGenCoord(glStateManagerTexGen);
	}

	public static void disableTexGenCoord(Object glStateManagerTexGen) {
		Modchu_GlStateManagerBase.disableTexGenCoord(glStateManagerTexGen);
	}

	public static void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		Modchu_GlStateManagerBase.texGen(glStateManagerTexGen, p_179149_1_);
	}

	public static void func_179105_a(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		Modchu_GlStateManagerBase.func_179105_a(glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

	public static void func_179090_x() {
		Modchu_GlStateManagerBase.func_179090_x();
	}

	public static void func_179150_h(int p_179150_0_) {
		Modchu_GlStateManagerBase.func_179150_h(p_179150_0_);
	}

	public static void func_179144_i(int p_179144_0_) {
		Modchu_GlStateManagerBase.func_179144_i(p_179144_0_);
	}

	public static void enableNormalize() {
		Modchu_GlStateManagerBase.enableNormalize();
	}

	public static void disableNormalize() {
		Modchu_GlStateManagerBase.disableNormalize();
	}

	public static void shadeModel(int p_179103_0_) {
		Modchu_GlStateManagerBase.shadeModel(p_179103_0_);
	}

	public static void enableRescaleNormal() {
		Modchu_GlStateManagerBase.enableRescaleNormal();
	}

	public static void disableRescaleNormal() {
		Modchu_GlStateManagerBase.disableRescaleNormal();
	}

	public static void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		Modchu_GlStateManagerBase.colorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
	}

	public static void clearDepth(double p_179151_0_) {
		Modchu_GlStateManagerBase.clearDepth(p_179151_0_);
	}

	public static void getFloat(int p_179111_0_, Object p_179111_1_) {
		Modchu_GlStateManagerBase.getFloat(p_179111_0_, (FloatBuffer) p_179111_1_);
	}

	public static void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		Modchu_GlStateManagerBase.rotate(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	public static void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		Modchu_GlStateManagerBase.scale(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	public static void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		Modchu_GlStateManagerBase.scale(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	public static void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		Modchu_GlStateManagerBase.translate(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	public static void multMatrix(Object p_179110_0_) {
		Modchu_GlStateManagerBase.multMatrix((FloatBuffer) p_179110_0_);
	}

	public static void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		Modchu_GlStateManagerBase.color(p_179124_0_, p_179124_1_, p_179124_2_);
	}

	public static void func_179117_G() {
		Modchu_GlStateManagerBase.func_179117_G();
	}

	public static void callList(int p_179148_0_) {
		Modchu_GlStateManagerBase.callList(p_179148_0_);
	}

}
