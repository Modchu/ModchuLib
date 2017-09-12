package modchu.lib;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.util.vector.Quaternion;

public class Modchu_GlStateManager {
	public static Modchu_IGlStateManager master;

	public static void init() {
		//Modchu_Debug.mDebug("Modchu_GlStateManager init() strat.");
		Object instance = Modchu_Main.newModchuCharacteristicObject("Modchu_GlStateManager");
		//Modchu_Debug.mDebug("Modchu_GlStateManager init instance="+instance);
		master = instance instanceof Modchu_IGlStateManager ? (Modchu_IGlStateManager) instance : null;
		//Modchu_Debug.mDebug("Modchu_GlStateManager init() master="+master);
		//Modchu_Debug.mDebug("Modchu_GlStateManager init() end.");
	}

	public static void glLight(int light, int pname, FloatBuffer floatBuffer) {
		if (master != null) master.glLight(light, pname, floatBuffer);
	}

	public static void glLightModel(int pname, FloatBuffer floatBuffer1) {
		if (master != null) master.glLightModel(pname, floatBuffer1);
	}

	public static void glNormal3f(float nx, float ny, float nz) {
		if (master != null) master.glNormal3f(nx, ny, nz);
	}

	public static void blendFunc(Object sourceFactor, Object destFactor) {
		if (master != null) master.blendFunc(sourceFactor, destFactor);
	}

	public static void tryBlendFuncSeparate(Object sourceFactor, Object destFactor, Object sourceFactor1, Object destFactor1) {
		if (master != null) master.tryBlendFuncSeparate(sourceFactor, destFactor, sourceFactor1, destFactor1);
	}

	public static void glBlendEquation(int blendEquation) {
		if (master != null) master.glBlendEquation(blendEquation);
	}

	public static void enableOutlineMode(int p_187431_0_) {
		if (master != null) master.enableOutlineMode(p_187431_0_);
	}

	public static void disableOutlineMode() {
		if (master != null) master.disableOutlineMode();
	}

	public static void setFog(Object fogMode) {
		if (master != null) master.setFog(fogMode);
	}

	private static void setFog(int param) {
		if (master != null) master.setFog(param);
	}

	public static void glFog(int pname, FloatBuffer floatBuffer1) {
		if (master != null) master.glFog(pname, floatBuffer1);
	}

	public static void glFogi(int pname, int param) {
		if (master != null) master.glFogi(pname, param);
	}

	public static void cullFace(Object cullFace) {
		if (master != null) master.cullFace(cullFace);
	}

	public static void glPolygonMode(int face, int mode) {
		if (master != null) master.glPolygonMode(face, mode);
	}

	public static void colorLogicOp(Object logicOp) {
		if (master != null) master.colorLogicOp(logicOp);
	}

	public static void texGen(Object texGen, int pname, FloatBuffer floatBuffer1) {
		if (master != null) master.texGen(texGen, pname, floatBuffer1);
	}

	public static void setActiveTexture(int texture) {
		if (master != null) master.setActiveTexture(texture);
	}

	public static void glTexEnv(int target, int parameterName, FloatBuffer floatBuffer1) {
		if (master != null) master.glTexEnv(target, parameterName, floatBuffer1);
	}

	public static void glTexEnvi(int target, int parameterName, int parameter) {
		if (master != null) master.glTexEnvi(target, parameterName, parameter);
	}

	public static void glTexEnvf(int target, int parameterName, float parameter) {
		if (master != null) master.glTexEnvf(target, parameterName, parameter);
	}

	public static void glTexParameterf(int target, int parameterName, float parameter) {
		if (master != null) master.glTexParameterf(target, parameterName, parameter);
	}

	public static void glTexParameteri(int target, int parameterName, int parameter) {
		if (master != null) master.glTexParameteri(target, parameterName, parameter);
	}

	public int glGetTexLevelParameteri(int target, int level, int parameterName) {
		return master != null ? master.glGetTexLevelParameteri(target, level, parameterName) : -1;
	}

	public static void glTexImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, IntBuffer pixels) {
		if (master != null
				&& pixels != null) master.glTexImage2D(target, level, internalFormat, width, height, border, format, type, pixels);
	}

	public static void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format, int type, IntBuffer pixels) {
		if (master != null) master.glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
	}

	public static void glCopyTexSubImage2D(int target, int level, int xOffset, int yOffset, int x, int y, int width, int height) {
		if (master != null) master.glCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
	}

	public static void glGetTexImage(int target, int level, int format, int type, IntBuffer pixels) {
		if (master != null) master.glGetTexImage(target, level, format, type, pixels);
	}

	public static void getFloat(int pname, FloatBuffer floatBuffer1) {
		if (master != null) master.getFloat(pname, floatBuffer1);
	}

	public static void multMatrix(FloatBuffer floatBuffer1) {
		if (master != null) master.multMatrix(floatBuffer1);
	}

	public static void rotate(Quaternion quaternion) {
		if (master != null) master.rotate(quaternion);
	}

	public FloatBuffer quatToGlMatrix(FloatBuffer floatBuffer1, Quaternion quaternion1) {
		return (FloatBuffer) (master != null ? master.quatToGlMatrix(floatBuffer1, quaternion1) : null);
	}

	public static void glTexCoord2f(float sCoord, float tCoord) {
		if (master != null) master.glTexCoord2f(sCoord, tCoord);
	}

	public static void glVertex3f(float x, float y, float z) {
		if (master != null) master.glVertex3f(x, y, z);
	}

	public static void glNormalPointer(int type, int stride, ByteBuffer byteBuffer) {
		if (master != null) master.glNormalPointer(type, stride, byteBuffer);
	}

	public static void glTexCoordPointer(int size, int type, int stride, int buffer_offset) {
		if (master != null) master.glTexCoordPointer(size, type, stride, buffer_offset);
	}

	public static void glTexCoordPointer(int size, int type, int stride, ByteBuffer byteBuffer1) {
		if (master != null) master.glTexCoordPointer(size, type, stride, byteBuffer1);
	}

	public static void glVertexPointer(int size, int type, int stride, int buffer_offset) {
		if (master != null) master.glVertexPointer(size, type, stride, buffer_offset);
	}

	public static void glVertexPointer(int size, int type, int stride, ByteBuffer byteBuffer1) {
		if (master != null) master.glVertexPointer(size, type, stride, byteBuffer1);
	}

	public static void glColorPointer(int size, int type, int stride, int buffer_offset) {
		if (master != null) master.glColorPointer(size, type, stride, buffer_offset);
	}

	public static void glColorPointer(int size, int type, int stride, ByteBuffer byteBuffer1) {
		if (master != null) master.glColorPointer(size, type, stride, byteBuffer1);
	}

	public static void glDisableClientState(int cap) {
		if (master != null) master.glDisableClientState(cap);
	}

	public static void glEnableClientState(int cap) {
		if (master != null) master.glEnableClientState(cap);
	}

	public static void glBegin(int mode) {
		if (master != null) master.glBegin(mode);
	}

	public static void glEnd() {
		if (master != null) master.glEnd();
	}

	public static void glDrawArrays(int mode, int first, int count) {
		if (master != null) master.glDrawArrays(mode, first, count);
	}

	public static void glLineWidth(float width) {
		if (master != null) master.glLineWidth(width);
	}

	public static void glDeleteLists(int list, int range) {
		if (master != null) master.glDeleteLists(list, range);
	}

	public static void glNewList(int list, int mode) {
		if (master != null) master.glNewList(list, mode);
	}

	public static void glEndList() {
		if (master != null) master.glEndList();
	}

	public int glGenLists(int range) {
		return master != null ? master.glGenLists(range) : -1;
	}

	public static void glPixelStorei(int parameterName, int param) {
		if (master != null) master.glPixelStorei(parameterName, param);
	}

	public static void glReadPixels(int x, int y, int width, int height, int format, int type, IntBuffer pixels) {
		if (master != null) master.glReadPixels(x, y, width, height, format, type, pixels);
	}

	public int glGetError() {
		return master != null ? master.glGetError() : -1;
	}

	public String glGetString(int name) {
		return master != null ? master.glGetString(name) : null;
	}

	public static void glGetInteger(int parameterName, IntBuffer parameters) {
		if (master != null) master.glGetInteger(parameterName, parameters);
	}

	public int glGetInteger(int parameterName) {
		return master != null ? master.glGetInteger(parameterName) : -1;
	}

	public static void enableBlendProfile(Object profile) {
		if (master != null) master.enableBlendProfile(profile);
	}

	public static void disableBlendProfile(Object profile) {
		if (master != null) master.disableBlendProfile(profile);
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

	/*
		public static void setFog(int p_179093_0_) {
			master.setFog(p_179093_0_);
		}
	*/
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

	/*
		public static void cullFace(int p_179107_0_) {
			master.cullFace(p_179107_0_);
		}
	*/
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
		master.texGen(glStateManagerTexGen, p_179105_1_, floatBuffer);
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
		master.getFloat(p_179111_0_, p_179111_1_);
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
		master.multMatrix(p_179110_0_);
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
