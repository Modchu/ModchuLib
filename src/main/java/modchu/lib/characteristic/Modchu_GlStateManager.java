package modchu.lib.characteristic;

import java.nio.FloatBuffer;

import modchu.lib.Modchu_GlStateManagerBase;
import net.minecraft.client.renderer.GlStateManager;

public class Modchu_GlStateManager extends Modchu_GlStateManagerBase {

	public static void pushMatrix() {
		GlStateManager.pushMatrix();
	}

	public static void ortho(int i, int width, int j, int height, int k, int l) {
		GlStateManager.ortho(i, width, j, height, k, l);
	}

	public static void ortho(double d, double width, double height, double e, double f, double g) {
		GlStateManager.ortho(d, width, height, e, f, g);
	}

	public static void clearColor(float f, float f1, float f2, float f3) {
		GlStateManager.clearColor(f, f1, f2, f3);
	}

	public static void clear(int i) {
		GlStateManager.clear(i);
	}

	public static void popMatrix() {
		GlStateManager.popMatrix();
	}

	public static void generateTexture() {
		GlStateManager.generateTexture();
	}

	public static void enableTexture2D() {
		GlStateManager.enableTexture2D();
	}

	public static void enableBlend() {
		GlStateManager.enableBlend();
	}

	public static void matrixMode(int i) {
		GlStateManager.matrixMode(i);
	}

	public static void loadIdentity() {
		GlStateManager.loadIdentity();
	}

	public static void enableDepth() {
		GlStateManager.enableDepth();
	}

	public static void alphaFunc(int i, float f) {
		GlStateManager.alphaFunc(i, f);
	}

	public static void translate(float f, float f1, float f2) {
		GlStateManager.translate(f, f1, f2);
	}

	public static void disableLighting() {
		GlStateManager.disableLighting();
	}

	public static void disableFog() {
		GlStateManager.disableFog();
	}

	public static void disableDepth() {
		GlStateManager.disableDepth();
	}

	public static void viewport(int i, int j, int width, int height) {
		GlStateManager.viewport(i, j, width, height);
	}

	public static void color(float r, float g, float b, float a) {
		GlStateManager.color(r, g, b, a);
	}

	public static void enableAlpha() {
		GlStateManager.enableAlpha();
	}

	public static void pushAttrib() {
		GlStateManager.pushAttrib();
	}

	public static void popAttrib() {
		GlStateManager.popAttrib();
	}

	public static void disableAlpha() {
		GlStateManager.disableAlpha();
	}

	public static void enableLighting() {
		GlStateManager.enableLighting();
	}

	public static void enableLight(int p_179085_0_) {
		GlStateManager.enableLight(p_179085_0_);
	}

	public static void disableLight(int p_179122_0_) {
		GlStateManager.disableLight(p_179122_0_);
	}

	public static void enableColorMaterial() {
		GlStateManager.enableColorMaterial();
	}

	public static void disableColorMaterial() {
		GlStateManager.disableColorMaterial();
	}

	public static void colorMaterial(int p_179104_0_, int p_179104_1_) {
		GlStateManager.colorMaterial(p_179104_0_, p_179104_1_);
	}

	public static void depthFunc(int p_179143_0_) {
		GlStateManager.depthFunc(p_179143_0_);
	}

	public static void depthMask(boolean p_179132_0_) {
		GlStateManager.depthMask(p_179132_0_);
	}

	public static void disableBlend() {
		GlStateManager.disableBlend();
	}

	public static void blendFunc(int p_179112_0_, int p_179112_1_) {
		GlStateManager.blendFunc(p_179112_0_, p_179112_1_);
	}

	public static void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		GlStateManager.tryBlendFuncSeparate(p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
	}

	public static void enableFog() {
		GlStateManager.enableFog();
	}

	public static void setFog(int p_179093_0_) {
		GlStateManager.setFog(p_179093_0_);
	}

	public static void setFogDensity(float p_179095_0_) {
		GlStateManager.setFogDensity(p_179095_0_);
	}

	public static void setFogStart(float p_179102_0_) {
		GlStateManager.setFogStart(p_179102_0_);
	}

	public static void setFogEnd(float p_179153_0_) {
		GlStateManager.setFogEnd(p_179153_0_);
	}

	public static void enableCull() {
		GlStateManager.enableCull();
	}

	public static void disableCull() {
		GlStateManager.disableCull();
	}

	public static void cullFace(int p_179107_0_) {
		GlStateManager.cullFace(p_179107_0_);
	}

	public static void enablePolygonOffset() {
		GlStateManager.enablePolygonOffset();
	}

	public static void disablePolygonOffset() {
		GlStateManager.disablePolygonOffset();
	}

	public static void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		GlStateManager.doPolygonOffset(p_179136_0_, p_179136_1_);
	}

	public static void enableColorLogic() {
		GlStateManager.enableColorLogic();
	}

	public static void disableColorLogic() {
		GlStateManager.disableColorLogic();
	}

	public static void colorLogicOp(int p_179116_0_) {
		GlStateManager.colorLogicOp(p_179116_0_);
	}

	public static void enableTexGenCoord(Object glStateManagerTexGen) {
		GlStateManager.enableTexGenCoord((GlStateManager.TexGen) glStateManagerTexGen);
	}

	public static void disableTexGenCoord(Object glStateManagerTexGen) {
		GlStateManager.disableTexGenCoord((GlStateManager.TexGen) glStateManagerTexGen);
	}

	public static void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		GlStateManager.texGen((GlStateManager.TexGen) glStateManagerTexGen, p_179149_1_);
	}

	public static void func_179105_a(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		GlStateManager.func_179105_a((GlStateManager.TexGen) glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

	public static void disableTexture2D() {
		GlStateManager.disableTexture2D();
	}

	public static void deleteTexture(int p_179150_0_) {
		GlStateManager.deleteTexture(p_179150_0_);
	}

	public static void bindTexture(int p_179144_0_) {
		GlStateManager.bindTexture(p_179144_0_);
	}

	public static void enableNormalize() {
		GlStateManager.enableNormalize();
	}

	public static void disableNormalize() {
		GlStateManager.disableNormalize();
	}

	public static void shadeModel(int p_179103_0_) {
		GlStateManager.shadeModel(p_179103_0_);
	}

	public static void enableRescaleNormal() {
		GlStateManager.enableRescaleNormal();
	}

	public static void disableRescaleNormal() {
		GlStateManager.disableRescaleNormal();
	}

	public static void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		GlStateManager.colorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
	}

	public static void clearDepth(double p_179151_0_) {
		GlStateManager.clearDepth(p_179151_0_);
	}

	public static void getFloat(int p_179111_0_, Object p_179111_1_) {
		GlStateManager.getFloat(p_179111_0_, (FloatBuffer) p_179111_1_);
	}

	public static void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		GlStateManager.rotate(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	public static void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		GlStateManager.scale(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	public static void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		GlStateManager.scale(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	public static void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		GlStateManager.translate(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	public static void multMatrix(Object p_179110_0_) {
		GlStateManager.multMatrix((FloatBuffer) p_179110_0_);
	}

	public static void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		GlStateManager.color(p_179124_0_, p_179124_1_, p_179124_2_);
	}

	public static void resetColor() {
		GlStateManager.resetColor();
	}

	public static void callList(int p_179148_0_) {
		GlStateManager.callList(p_179148_0_);
	}

}
