package modchu.lib.common.mc152_179;

import java.nio.FloatBuffer;
import java.util.HashMap;

import modchu.lib.Modchu_GlStateManagerBase;
import modchu.lib.Modchu_IGlStateManager;

public class Modchu_GlStateManager implements Modchu_IGlStateManager {

	public Modchu_GlStateManager(HashMap<String, Object> map) {
	}

	public void pushMatrix() {
		Modchu_GlStateManagerBase.pushMatrix();
	}

	public void ortho(int i, int width, int j, int height, int k, int l) {
		Modchu_GlStateManagerBase.ortho(i, width, j, height, k, l);
	}

	public void ortho(double d, double width, double height, double e, double f, double g) {
		Modchu_GlStateManagerBase.ortho(d, width, height, e, f, g);
	}

	public void clearColor(float f, float f1, float f2, float f3) {
		Modchu_GlStateManagerBase.clearColor(f, f1, f2, f3);
	}

	public void clear(int i) {
		Modchu_GlStateManagerBase.clear(i);
	}

	public void popMatrix() {
		Modchu_GlStateManagerBase.popMatrix();
	}

	public void generateTexture() {
		Modchu_GlStateManagerBase.generateTexture();
	}

	public void enableTexture2D() {
		Modchu_GlStateManagerBase.enableTexture2D();
	}

	public void enableBlend() {
		Modchu_GlStateManagerBase.enableBlend();
	}

	public void matrixMode(int i) {
		Modchu_GlStateManagerBase.matrixMode(i);
	}

	public void loadIdentity() {
		Modchu_GlStateManagerBase.loadIdentity();
	}

	public void enableDepth() {
		Modchu_GlStateManagerBase.enableDepth();
	}

	public void alphaFunc(int i, float f) {
		Modchu_GlStateManagerBase.alphaFunc(i, f);
	}

	public void translate(float f, float f1, float f2) {
		Modchu_GlStateManagerBase.translate(f, f1, f2);
	}

	public void disableLighting() {
		Modchu_GlStateManagerBase.disableLighting();
	}

	public void disableFog() {
		Modchu_GlStateManagerBase.disableFog();
	}

	public void disableDepth() {
		Modchu_GlStateManagerBase.disableDepth();
	}

	public void viewport(int i, int j, int width, int height) {
		Modchu_GlStateManagerBase.viewport(i, j, width, height);
	}

	public void color(float r, float g, float b, float a) {
		Modchu_GlStateManagerBase.color(r, g, b, a);
	}

	public void enableAlpha() {
		Modchu_GlStateManagerBase.enableAlpha();
	}

	public void pushAttrib() {
		Modchu_GlStateManagerBase.pushAttrib();
	}

	public void popAttrib() {
		Modchu_GlStateManagerBase.popAttrib();
	}

	public void disableAlpha() {
		Modchu_GlStateManagerBase.disableAlpha();
	}

	public void enableLighting() {
		Modchu_GlStateManagerBase.enableLighting();
	}

	public void enableBooleanStateAt(int p_179085_0_) {
		Modchu_GlStateManagerBase.enableBooleanStateAt(p_179085_0_);
	}

	public void disableBooleanStateAt(int p_179122_0_) {
		Modchu_GlStateManagerBase.disableBooleanStateAt(p_179122_0_);
	}

	public void enableColorMaterial() {
		Modchu_GlStateManagerBase.enableColorMaterial();
	}

	public void disableColorMaterial() {
		Modchu_GlStateManagerBase.disableColorMaterial();
	}

	public void colorMaterial(int p_179104_0_, int p_179104_1_) {
		Modchu_GlStateManagerBase.colorMaterial(p_179104_0_, p_179104_1_);
	}

	public void depthFunc(int p_179143_0_) {
		Modchu_GlStateManagerBase.depthFunc(p_179143_0_);
	}

	public void depthMask(boolean p_179132_0_) {
		Modchu_GlStateManagerBase.depthMask(p_179132_0_);
	}

	public void disableBlend() {
		Modchu_GlStateManagerBase.disableBlend();
	}

	public void blendFunc(int p_179112_0_, int p_179112_1_) {
		Modchu_GlStateManagerBase.blendFunc(p_179112_0_, p_179112_1_);
	}

	public void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		Modchu_GlStateManagerBase.tryBlendFuncSeparate(p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
	}

	public void enableFog() {
		Modchu_GlStateManagerBase.enableFog();
	}

	public void setFog(int p_179093_0_) {
		Modchu_GlStateManagerBase.setFog(p_179093_0_);
	}

	public void setFogDensity(float p_179095_0_) {
		Modchu_GlStateManagerBase.setFogDensity(p_179095_0_);
	}

	public void setFogStart(float p_179102_0_) {
		Modchu_GlStateManagerBase.setFogStart(p_179102_0_);
	}

	public void setFogEnd(float p_179153_0_) {
		Modchu_GlStateManagerBase.setFogEnd(p_179153_0_);
	}

	public void enableCull() {
		Modchu_GlStateManagerBase.enableCull();
	}

	public void disableCull() {
		Modchu_GlStateManagerBase.disableCull();
	}

	public void cullFace(int p_179107_0_) {
		Modchu_GlStateManagerBase.cullFace(p_179107_0_);
	}

	public void enablePolygonOffset() {
		Modchu_GlStateManagerBase.enablePolygonOffset();
	}

	public void disablePolygonOffset() {
		Modchu_GlStateManagerBase.disablePolygonOffset();
	}

	public void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		Modchu_GlStateManagerBase.doPolygonOffset(p_179136_0_, p_179136_1_);
	}

	public void enableColorLogic() {
		Modchu_GlStateManagerBase.enableColorLogic();
	}

	public void disableColorLogic() {
		Modchu_GlStateManagerBase.disableColorLogic();
	}

	public void colorLogicOp(int p_179116_0_) {
		Modchu_GlStateManagerBase.colorLogicOp(p_179116_0_);
	}

	public void enableTexGenCoord(Object glStateManagerTexGen) {
		Modchu_GlStateManagerBase.enableTexGenCoord(glStateManagerTexGen);
	}

	public void disableTexGenCoord(Object glStateManagerTexGen) {
		Modchu_GlStateManagerBase.disableTexGenCoord(glStateManagerTexGen);
	}

	public void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		Modchu_GlStateManagerBase.texGen(glStateManagerTexGen, p_179149_1_);
	}

	public void texGen(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		Modchu_GlStateManagerBase.func_179105_a(glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

	public void disableTexture2D() {
		Modchu_GlStateManagerBase.disableTexture2D();
	}

	public void func_179150_h(int p_179150_0_) {
		Modchu_GlStateManagerBase.func_179150_h(p_179150_0_);
	}

	public void bindTexture(int p_179144_0_) {
		Modchu_GlStateManagerBase.bindTexture(p_179144_0_);
	}

	public void enableNormalize() {
		Modchu_GlStateManagerBase.enableNormalize();
	}

	public void disableNormalize() {
		Modchu_GlStateManagerBase.disableNormalize();
	}

	public void shadeModel(int p_179103_0_) {
		Modchu_GlStateManagerBase.shadeModel(p_179103_0_);
	}

	public void enableRescaleNormal() {
		Modchu_GlStateManagerBase.enableRescaleNormal();
	}

	public void disableRescaleNormal() {
		Modchu_GlStateManagerBase.disableRescaleNormal();
	}

	public void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		Modchu_GlStateManagerBase.colorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
	}

	public void clearDepth(double p_179151_0_) {
		Modchu_GlStateManagerBase.clearDepth(p_179151_0_);
	}

	public void getFloat(int p_179111_0_, Object p_179111_1_) {
		Modchu_GlStateManagerBase.getFloat(p_179111_0_, (FloatBuffer) p_179111_1_);
	}

	public void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		Modchu_GlStateManagerBase.rotate(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	public void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		Modchu_GlStateManagerBase.scale(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	public void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		Modchu_GlStateManagerBase.scale(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	public void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		Modchu_GlStateManagerBase.translate(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	public void multMatrix(Object p_179110_0_) {
		Modchu_GlStateManagerBase.multMatrix((FloatBuffer) p_179110_0_);
	}

	public void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		Modchu_GlStateManagerBase.color(p_179124_0_, p_179124_1_, p_179124_2_);
	}

	public void resetColor() {
		Modchu_GlStateManagerBase.resetColor();
	}

	public void callList(int p_179148_0_) {
		Modchu_GlStateManagerBase.callList(p_179148_0_);
	}

	@Override
	public void enableLight(int p_179085_0_) {
		Modchu_GlStateManagerBase.enableLight(p_179085_0_);
	}

	@Override
	public void disableLight(int p_179122_0_) {
		Modchu_GlStateManagerBase.disableLight(p_179122_0_);
	}

	@Override
	public void deleteTexture(int p_179150_0_) {
		Modchu_GlStateManagerBase.deleteTexture(p_179150_0_);
	}

}
