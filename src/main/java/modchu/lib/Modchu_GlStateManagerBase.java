package modchu.lib;

import java.nio.FloatBuffer;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_CastHelper;

import org.lwjgl.opengl.GL11;

public class Modchu_GlStateManagerBase {
	private static ConcurrentHashMap<String, Object> freeVariableMap = new ConcurrentHashMap();

	public static void pushMatrix() {
		GL11.glPushMatrix();
	}

	public static void ortho(int i, int width, int j, int height, int k, int l) {
		GL11.glOrtho(i, width, j, height, k, l);
	}

	public static void ortho(double d, double width, double height, double e, double f, double g) {
		GL11.glOrtho(d, width, height, e, f, g);
	}

	public static void clearColor(float f, float f1, float f2, float f3) {
		GL11.glClearColor(f, f1, f2, f3);
	}

	public static void clear(int i) {
		GL11.glClear(i);
	}

	public static void popMatrix() {
		GL11.glPopMatrix();
	}

	public static void generateTexture() {
		GL11.glGenTextures();
	}

	public static void enableTexture2D() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public static void enableBlend() {
		GL11.glEnable(GL11.GL_BLEND);
	}

	public static void matrixMode(int i) {
		GL11.glMatrixMode(i);
	}

	public static void loadIdentity() {
		GL11.glLoadIdentity();
	}

	public static void enableDepth() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	public static void alphaFunc(int i, float f) {
		GL11.glAlphaFunc(i, f);
	}

	public static void translate(float f, float f1, float f2) {
		GL11.glTranslatef(f, f1, f2);
	}

	public static void disableLighting() {
		GL11.glDisable(GL11.GL_LIGHTING);
	}

	public static void disableFog() {
		GL11.glDisable(GL11.GL_FOG);
	}

	public static void disableDepth() {
		GL11.glDisable(GL11.GL_DEPTH_TEST);
	}

	public static void viewport(int i, int j, int width, int height) {
		GL11.glViewport(i, j, width, height);
	}

	public static void color(float r, float g, float b, float a) {
		GL11.glColor4f(r, g, b, a);
	}

	public static void enableAlpha() {
		GL11.glEnable(GL11.GL_ALPHA_TEST);
	}

	public static void pushAttrib() {
		GL11.glPushAttrib(8256);
	}

	public static void popAttrib() {
		GL11.glPopAttrib();
	}

	public static void disableAlpha() {
		GL11.glDisable(GL11.GL_ALPHA_TEST);
	}

	public static void enableLighting() {
		GL11.glEnable(GL11.GL_LIGHTING);
	}

	public static void enableBooleanStateAt(int p_179085_0_) {
		GL11.glEnable(p_179085_0_);
	}

	public static void disableBooleanStateAt(int p_179122_0_) {
		GL11.glDisable(p_179122_0_);
	}

	public static void enableColorMaterial() {
		freeVariableMap.put("colorMaterial", true);
	}

	public static void disableColorMaterial() {
		freeVariableMap.put("colorMaterial", false);
	}

	public static void colorMaterial(int p_179104_0_, int p_179104_1_) {
		if (p_179104_0_ != Modchu_CastHelper.Int(freeVariableMap.get("colorMaterialStateField_179189_b"))
				| p_179104_1_ != Modchu_CastHelper.Int(freeVariableMap.get("colorMaterialStateField_179190_c"))) {
			freeVariableMap.put("colorMaterialStateField_179189_b", p_179104_0_);
			freeVariableMap.put("colorMaterialStateField_179190_c", p_179104_1_);
			GL11.glColorMaterial(p_179104_0_, p_179104_1_);
		}
	}

	public static void depthFunc(int p_179143_0_) {
		if (p_179143_0_ != Modchu_CastHelper.Int(freeVariableMap.get("depthStateField_179051_c"))) {
			freeVariableMap.put("depthStateField_179051_c", p_179143_0_);
			GL11.glDepthFunc(p_179143_0_);
		}
	}

	public static void depthMask(boolean p_179132_0_) {
		if (p_179132_0_ != Modchu_CastHelper.Boolean(freeVariableMap.get("depthStateField_179050_b"))) {
			freeVariableMap.put("depthStateField_179050_b", p_179132_0_);
			GL11.glDepthMask(p_179132_0_);
		}
	}

	public static void disableBlend() {
		freeVariableMap.put("blendStateField_179213_a", false);
	}

	public static void blendFunc(int p_179112_0_, int p_179112_1_) {
		if (p_179112_0_ != Modchu_CastHelper.Int(freeVariableMap.get("blendStateField_179211_b"))
				| p_179112_1_ != Modchu_CastHelper.Int(freeVariableMap.get("blendStateField_179212_c"))) {
			freeVariableMap.put("blendStateField_179211_b", p_179112_0_);
			freeVariableMap.put("blendStateField_179212_c", p_179112_1_);
			GL11.glBlendFunc(p_179112_0_, p_179112_1_);
		}
	}

	public static void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		if (p_179120_0_ != Modchu_CastHelper.Int(freeVariableMap.get("blendStateField_179211_b"))
				| p_179120_1_ != Modchu_CastHelper.Int(freeVariableMap.get("blendStateField_179212_c"))
				| p_179120_2_ != Modchu_CastHelper.Int(freeVariableMap.get("blendStateField_179209_d"))
				| p_179120_3_ != Modchu_CastHelper.Int(freeVariableMap.get("blendStateField_179210_e"))) {
			freeVariableMap.put("blendStateField_179211_b", p_179120_0_);
			freeVariableMap.put("blendStateField_179212_c", p_179120_1_);
			freeVariableMap.put("blendStateField_179209_d", p_179120_2_);
			freeVariableMap.put("blendStateField_179210_e", p_179120_3_);
			Modchu_AS.set(Modchu_AS.openGlHelperGlBlendFunc, p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
		}
	}

	public static void enableFog() {
		freeVariableMap.put("fogStateField_179049_a", true);
	}

	public static void setFog(int p_179093_0_) {
		if (p_179093_0_ != Modchu_CastHelper.Int(freeVariableMap.get("fogStateField_179047_b"))) {
			freeVariableMap.put("fogStateField_179047_b", p_179093_0_);
			GL11.glFogi(GL11.GL_FOG_MODE, p_179093_0_);
		}
	}

	public static void setFogDensity(float p_179095_0_) {
		if (p_179095_0_ != Modchu_CastHelper.Float(freeVariableMap.get("fogStateField_179048_c"))) {
			freeVariableMap.put("fogStateField_179048_c", p_179095_0_);
			GL11.glFogf(GL11.GL_FOG_DENSITY, p_179095_0_);
		}
	}

	public static void setFogStart(float p_179102_0_) {
		if (p_179102_0_ != Modchu_CastHelper.Float(freeVariableMap.get("fogStateField_179045_d"))) {
			freeVariableMap.put("fogStateField_179045_d", p_179102_0_);
			GL11.glFogf(GL11.GL_FOG_START, p_179102_0_);
		}
	}

	public static void setFogEnd(float p_179153_0_) {
		if (p_179153_0_ != Modchu_CastHelper.Float(freeVariableMap.get("fogStateField_179046_e"))) {
			freeVariableMap.put("fogStateField_179046_e", p_179153_0_);
			GL11.glFogf(GL11.GL_FOG_END, p_179153_0_);
		}
	}

	public static void enableCull() {
		freeVariableMap.put("cullStateField_179054_a", true);
	}

	public static void disableCull() {
		freeVariableMap.put("cullStateField_179054_a", false);
	}

	public static void cullFace(int p_179107_0_) {
		if (p_179107_0_ != Modchu_CastHelper.Int(freeVariableMap.get("cullStateField_179053_b"))) {
			freeVariableMap.put("cullStateField_179053_b", p_179107_0_);
			GL11.glCullFace(p_179107_0_);
		}
	}

	public static void enablePolygonOffset() {
		freeVariableMap.put("polygonOffsetStateField_179044_a", true);
	}

	public static void disablePolygonOffset() {
		freeVariableMap.put("polygonOffsetStateField_179044_a", false);
	}

	public static void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		if (p_179136_0_ != Modchu_CastHelper.Float(freeVariableMap.get("polygonOffsetStateField_179043_c"))
				| p_179136_1_ != Modchu_CastHelper.Float(freeVariableMap.get("polygonOffsetStateField_179041_d"))) {
			freeVariableMap.put("polygonOffsetStateField_179043_c", p_179136_0_);
			freeVariableMap.put("polygonOffsetStateField_179041_d", p_179136_1_);
			GL11.glPolygonOffset(p_179136_0_, p_179136_1_);
		}
	}

	public static void enableColorLogic() {
		freeVariableMap.put("colorLogicStateField_179197_a", true);
	}

	public static void disableColorLogic() {
		freeVariableMap.put("colorLogicStateField_179197_a", false);
	}

	public static void colorLogicOp(int p_179116_0_) {
		if (p_179116_0_ != Modchu_CastHelper.Int(freeVariableMap.get("colorLogicStateField_179196_b"))) {
			freeVariableMap.put("colorLogicStateField_179196_b", p_179116_0_);
			GL11.glLogicOp(p_179116_0_);
		}
	}

	public static void enableTexGenCoord(Object glStateManagerTexGen) {
		freeVariableMap.put("texGenCoordField_179067_a", true);
	}

	public static void disableTexGenCoord(Object glStateManagerTexGen) {
		freeVariableMap.put("texGenCoordField_179067_a", false);
	}

	public static void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		if (p_179149_1_ != Modchu_CastHelper.Int(freeVariableMap.get("texgencoordField_179066_c"))) {
			freeVariableMap.put("texgencoordField_179066_c", p_179149_1_);
			GL11.glTexGeni(8192, GL11.GL_TEXTURE_GEN_MODE, p_179149_1_);
		}
	}

	public static void func_179105_a(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		GL11.glTexGen(8192, p_179105_1_, (FloatBuffer) floatBuffer);
	}

	public static void disableTexture2D() {
		freeVariableMap.put("field_179174_pField_179060_a", false);
	}

	public static void func_179150_h(int p_179150_0_) {
		GL11.glDeleteTextures(p_179150_0_);
	}

	public static void bindTexture(int p_179144_0_) {
		if (p_179144_0_ != Modchu_CastHelper.Int(freeVariableMap.get("field_179174_pField_179059_b"))) {
			freeVariableMap.put("field_179174_pField_179059_b", p_179144_0_);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, p_179144_0_);
		}
	}

	public static void enableNormalize() {
		freeVariableMap.put("normalizeStateSetDisabled", true);
	}

	public static void disableNormalize() {
		freeVariableMap.put("normalizeStateSetDisabled", false);
	}

	public static void shadeModel(int p_179103_0_) {
		if (p_179103_0_ != Modchu_CastHelper.Int(freeVariableMap.get("field_179173_q"))) {
			freeVariableMap.put("field_179173_q", p_179103_0_);
			GL11.glShadeModel(p_179103_0_);
		}
	}

	public static void enableRescaleNormal() {
		freeVariableMap.put("rescaleNormalState", true);
	}

	public static void disableRescaleNormal() {
		freeVariableMap.put("rescaleNormalState", false);
	}

	public static void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		if (p_179135_0_ != Modchu_CastHelper.Boolean(freeVariableMap.get("colorMaskStateField_179188_a"))
				| p_179135_1_ != Modchu_CastHelper.Boolean(freeVariableMap.get("colorMaskStateField_179186_b"))
				| p_179135_2_ != Modchu_CastHelper.Boolean(freeVariableMap.get("colorMaskStateField_179187_c"))
				| p_179135_3_ != Modchu_CastHelper.Boolean(freeVariableMap.get("colorMaskStateField_179185_d"))) {
			GL11.glColorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
		}
	}

	public static void clearDepth(double p_179151_0_) {
		if (p_179151_0_ != Modchu_CastHelper.Int(freeVariableMap.get("clearStateField_179205_a"))) {
			freeVariableMap.put("clearStateField_179205_a", p_179151_0_);
			GL11.glClearDepth(p_179151_0_);
		}
	}

	public static void getFloat(int p_179111_0_, FloatBuffer p_179111_1_) {
		GL11.glGetFloat(p_179111_0_, p_179111_1_);
	}

	public static void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		GL11.glRotatef(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	public static void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		GL11.glScalef(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	public static void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		GL11.glScaled(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	public static void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		GL11.glTranslated(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	public static void multMatrix(FloatBuffer p_179110_0_) {
		GL11.glMultMatrix(p_179110_0_);
	}

	public static void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		color(p_179124_0_, p_179124_1_, p_179124_2_, 1.0F);
	}

	public static void resetColor() {
		freeVariableMap.put("colorStateField_179195_a", -1.0F);
		freeVariableMap.put("colorStateGreen", -1.0F);
		freeVariableMap.put("colorStateBlue", -1.0F);
		freeVariableMap.put("colorStateAlpha", -1.0F);
	}

	public static void callList(int p_179148_0_) {
		GL11.glCallList(p_179148_0_);
	}

}
