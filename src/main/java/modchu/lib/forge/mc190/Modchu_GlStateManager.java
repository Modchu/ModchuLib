package modchu.lib.forge.mc190;

import java.nio.FloatBuffer;
import java.util.HashMap;

import modchu.lib.Modchu_GlStateManagerBase;
import modchu.lib.Modchu_IGlStateManager;
import net.minecraft.client.renderer.GlStateManager;

public class Modchu_GlStateManager implements Modchu_IGlStateManager {

	public Modchu_GlStateManager(HashMap<String, Object> map) {
	}

	public void pushMatrix() {
		GlStateManager.pushMatrix();
	}

	public void ortho(int i, int width, int j, int height, int k, int l) {
		GlStateManager.ortho(i, width, j, height, k, l);
	}

	public void ortho(double d, double width, double height, double e, double f, double g) {
		GlStateManager.ortho(d, width, height, e, f, g);
	}

	public void clearColor(float f, float f1, float f2, float f3) {
		GlStateManager.clearColor(f, f1, f2, f3);
	}

	public void clear(int i) {
		GlStateManager.clear(i);
	}

	public void popMatrix() {
		GlStateManager.popMatrix();
	}

	public void generateTexture() {
		GlStateManager.generateTexture();
	}

	public void enableTexture2D() {
		GlStateManager.enableTexture2D();
	}

	public void enableBlend() {
		GlStateManager.enableBlend();
	}

	public void matrixMode(int i) {
		GlStateManager.matrixMode(i);
	}

	public void loadIdentity() {
		GlStateManager.loadIdentity();
	}

	public void enableDepth() {
		GlStateManager.enableDepth();
	}

	public void alphaFunc(int i, float f) {
		GlStateManager.alphaFunc(i, f);
	}

	public void translate(float f, float f1, float f2) {
		GlStateManager.translate(f, f1, f2);
	}

	public void disableLighting() {
		GlStateManager.disableLighting();
	}

	public void disableFog() {
		GlStateManager.disableFog();
	}

	public void disableDepth() {
		GlStateManager.disableDepth();
	}

	public void viewport(int i, int j, int width, int height) {
		GlStateManager.viewport(i, j, width, height);
	}

	public void color(float r, float g, float b, float a) {
		GlStateManager.color(r, g, b, a);
	}

	public void enableAlpha() {
		GlStateManager.enableAlpha();
	}

	public void pushAttrib() {
		GlStateManager.pushAttrib();
	}

	public void popAttrib() {
		GlStateManager.popAttrib();
	}

	public void disableAlpha() {
		GlStateManager.disableAlpha();
	}

	public void enableLighting() {
		GlStateManager.enableLighting();
	}

	public void enableLight(int p_179085_0_) {
		GlStateManager.enableLight(p_179085_0_);
	}

	public void disableLight(int p_179122_0_) {
		GlStateManager.disableLight(p_179122_0_);
	}

	public void enableColorMaterial() {
		GlStateManager.enableColorMaterial();
	}

	public void disableColorMaterial() {
		GlStateManager.disableColorMaterial();
	}

	public void colorMaterial(int p_179104_0_, int p_179104_1_) {
		GlStateManager.colorMaterial(p_179104_0_, p_179104_1_);
	}

	public void depthFunc(int p_179143_0_) {
		GlStateManager.depthFunc(p_179143_0_);
	}

	public void depthMask(boolean p_179132_0_) {
		GlStateManager.depthMask(p_179132_0_);
	}

	public void disableBlend() {
		GlStateManager.disableBlend();
	}

	public void blendFunc(int p_179112_0_, int p_179112_1_) {
		GlStateManager.blendFunc(p_179112_0_, p_179112_1_);
	}

	public void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		GlStateManager.tryBlendFuncSeparate(p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
	}

	public void enableFog() {
		GlStateManager.enableFog();
	}

	public void setFog(GlStateManager.FogMode fogMode) {
		GlStateManager.setFog(fogMode);
	}

	public void setFogDensity(float p_179095_0_) {
		GlStateManager.setFogDensity(p_179095_0_);
	}

	public void setFogStart(float p_179102_0_) {
		GlStateManager.setFogStart(p_179102_0_);
	}

	public void setFogEnd(float p_179153_0_) {
		GlStateManager.setFogEnd(p_179153_0_);
	}

	public void enableCull() {
		GlStateManager.enableCull();
	}

	public void disableCull() {
		GlStateManager.disableCull();
	}

	public void cullFace(GlStateManager.CullFace cullFace) {
		GlStateManager.cullFace(cullFace);
	}

	public void enablePolygonOffset() {
		GlStateManager.enablePolygonOffset();
	}

	public void disablePolygonOffset() {
		GlStateManager.disablePolygonOffset();
	}

	public void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		GlStateManager.doPolygonOffset(p_179136_0_, p_179136_1_);
	}

	public void enableColorLogic() {
		GlStateManager.enableColorLogic();
	}

	public void disableColorLogic() {
		GlStateManager.disableColorLogic();
	}

	public void colorLogicOp(int p_179116_0_) {
		GlStateManager.colorLogicOp(p_179116_0_);
	}

	public void enableTexGenCoord(Object glStateManagerTexGen) {
		GlStateManager.enableTexGenCoord((GlStateManager.TexGen) glStateManagerTexGen);
	}

	public void disableTexGenCoord(Object glStateManagerTexGen) {
		GlStateManager.disableTexGenCoord((GlStateManager.TexGen) glStateManagerTexGen);
	}

	public void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		GlStateManager.texGen((GlStateManager.TexGen) glStateManagerTexGen, p_179149_1_);
	}

	public void disableTexture2D() {
		GlStateManager.disableTexture2D();
	}

	public void deleteTexture(int p_179150_0_) {
		GlStateManager.deleteTexture(p_179150_0_);
	}

	public void bindTexture(int p_179144_0_) {
		GlStateManager.bindTexture(p_179144_0_);
	}

	public void enableNormalize() {
		GlStateManager.enableNormalize();
	}

	public void disableNormalize() {
		GlStateManager.disableNormalize();
	}

	public void shadeModel(int p_179103_0_) {
		GlStateManager.shadeModel(p_179103_0_);
	}

	public void enableRescaleNormal() {
		GlStateManager.enableRescaleNormal();
	}

	public void disableRescaleNormal() {
		GlStateManager.disableRescaleNormal();
	}

	public void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		GlStateManager.colorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
	}

	public void clearDepth(double p_179151_0_) {
		GlStateManager.clearDepth(p_179151_0_);
	}

	public void getFloat(int p_179111_0_, Object p_179111_1_) {
		GlStateManager.getFloat(p_179111_0_, (FloatBuffer) p_179111_1_);
	}

	public void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		GlStateManager.rotate(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	public void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		GlStateManager.scale(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	public void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		GlStateManager.scale(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	public void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		GlStateManager.translate(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	public void multMatrix(Object p_179110_0_) {
		GlStateManager.multMatrix((FloatBuffer) p_179110_0_);
	}

	public void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		GlStateManager.color(p_179124_0_, p_179124_1_, p_179124_2_);
	}

	public void resetColor() {
		GlStateManager.resetColor();
	}

	public void callList(int p_179148_0_) {
		GlStateManager.callList(p_179148_0_);
	}

	@Override
	public void texGen(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		GlStateManager.texGen((GlStateManager.TexGen) glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

}
