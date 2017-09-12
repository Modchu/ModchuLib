package modchu.lib.common.mc152_179;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Quaternion;

import modchu.lib.Modchu_GlStateManagerBase;
import modchu.lib.Modchu_GlStateManagerBase.CullFace;
import modchu.lib.Modchu_GlStateManagerBase.DestFactor;
import modchu.lib.Modchu_GlStateManagerBase.FogMode;
import modchu.lib.Modchu_GlStateManagerBase.LogicOp;
import modchu.lib.Modchu_GlStateManagerBase.Profile;
import modchu.lib.Modchu_GlStateManagerBase.SourceFactor;
import modchu.lib.Modchu_GlStateManagerBase.TexGen;
import modchu.lib.Modchu_IGlStateManager;

public class Modchu_GlStateManager implements Modchu_IGlStateManager {

	public Modchu_GlStateManager(HashMap<String, Object> map) {
	}

	@Override
	public void pushMatrix() {
		Modchu_GlStateManagerBase.pushMatrix();
	}

	@Override
	public void ortho(int i, int width, int j, int height, int k, int l) {
		Modchu_GlStateManagerBase.ortho(i, width, j, height, k, l);
	}

	@Override
	public void ortho(double d, double width, double height, double e, double f, double g) {
		Modchu_GlStateManagerBase.ortho(d, width, height, e, f, g);
	}

	@Override
	public void clearColor(float f, float f1, float f2, float f3) {
		Modchu_GlStateManagerBase.clearColor(f, f1, f2, f3);
	}

	@Override
	public void clear(int i) {
		Modchu_GlStateManagerBase.clear(i);
	}

	@Override
	public void popMatrix() {
		Modchu_GlStateManagerBase.popMatrix();
	}

	@Override
	public void generateTexture() {
		Modchu_GlStateManagerBase.generateTexture();
	}

	@Override
	public void enableTexture2D() {
		//Modchu_GlStateManagerBase.enableTexture2D();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	@Override
	public void enableBlend() {
		Modchu_GlStateManagerBase.enableBlend();
	}

	@Override
	public void matrixMode(int i) {
		Modchu_GlStateManagerBase.matrixMode(i);
	}

	@Override
	public void loadIdentity() {
		Modchu_GlStateManagerBase.loadIdentity();
	}

	@Override
	public void enableDepth() {
		Modchu_GlStateManagerBase.enableDepth();
	}

	@Override
	public void alphaFunc(int i, float f) {
		Modchu_GlStateManagerBase.alphaFunc(i, f);
	}

	@Override
	public void translate(float f, float f1, float f2) {
		Modchu_GlStateManagerBase.translate(f, f1, f2);
	}

	@Override
	public void disableLighting() {
		Modchu_GlStateManagerBase.disableLighting();
	}

	@Override
	public void disableFog() {
		Modchu_GlStateManagerBase.disableFog();
	}

	@Override
	public void disableDepth() {
		Modchu_GlStateManagerBase.disableDepth();
	}

	@Override
	public void viewport(int i, int j, int width, int height) {
		Modchu_GlStateManagerBase.viewport(i, j, width, height);
	}

	@Override
	public void color(float r, float g, float b, float a) {
		Modchu_GlStateManagerBase.color(r, g, b, a);
	}

	@Override
	public void enableAlpha() {
		Modchu_GlStateManagerBase.enableAlpha();
	}

	@Override
	public void pushAttrib() {
		Modchu_GlStateManagerBase.pushAttrib();
	}

	@Override
	public void popAttrib() {
		Modchu_GlStateManagerBase.popAttrib();
	}

	@Override
	public void disableAlpha() {
		Modchu_GlStateManagerBase.disableAlpha();
	}

	@Override
	public void enableLighting() {
		Modchu_GlStateManagerBase.enableLighting();
	}

	@Override
	public void enableColorMaterial() {
		Modchu_GlStateManagerBase.enableColorMaterial();
	}

	@Override
	public void disableColorMaterial() {
		Modchu_GlStateManagerBase.disableColorMaterial();
	}

	@Override
	public void colorMaterial(int p_179104_0_, int p_179104_1_) {
		Modchu_GlStateManagerBase.colorMaterial(p_179104_0_, p_179104_1_);
	}

	@Override
	public void depthFunc(int p_179143_0_) {
		Modchu_GlStateManagerBase.depthFunc(p_179143_0_);
	}

	@Override
	public void depthMask(boolean p_179132_0_) {
		Modchu_GlStateManagerBase.depthMask(p_179132_0_);
	}

	@Override
	public void disableBlend() {
		Modchu_GlStateManagerBase.disableBlend();
	}

	@Override
	public void blendFunc(int p_179112_0_, int p_179112_1_) {
		Modchu_GlStateManagerBase.blendFunc(p_179112_0_, p_179112_1_);
	}

	@Override
	public void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		Modchu_GlStateManagerBase.tryBlendFuncSeparate(p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
	}

	@Override
	public void enableFog() {
		Modchu_GlStateManagerBase.enableFog();
	}

	public void setFog(int p_179093_0_) {
		Modchu_GlStateManagerBase.setFog(p_179093_0_);
	}

	@Override
	public void setFogDensity(float p_179095_0_) {
		Modchu_GlStateManagerBase.setFogDensity(p_179095_0_);
	}

	@Override
	public void setFogStart(float p_179102_0_) {
		Modchu_GlStateManagerBase.setFogStart(p_179102_0_);
	}

	@Override
	public void setFogEnd(float p_179153_0_) {
		Modchu_GlStateManagerBase.setFogEnd(p_179153_0_);
	}

	@Override
	public void enableCull() {
		Modchu_GlStateManagerBase.enableCull();
	}

	@Override
	public void disableCull() {
		Modchu_GlStateManagerBase.disableCull();
	}

	public void cullFace(int p_179107_0_) {
		Modchu_GlStateManagerBase.cullFace(p_179107_0_);
	}

	@Override
	public void enablePolygonOffset() {
		Modchu_GlStateManagerBase.enablePolygonOffset();
	}

	@Override
	public void disablePolygonOffset() {
		Modchu_GlStateManagerBase.disablePolygonOffset();
	}

	@Override
	public void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		Modchu_GlStateManagerBase.doPolygonOffset(p_179136_0_, p_179136_1_);
	}

	@Override
	public void enableColorLogic() {
		Modchu_GlStateManagerBase.enableColorLogic();
	}

	@Override
	public void disableColorLogic() {
		Modchu_GlStateManagerBase.disableColorLogic();
	}

	@Override
	public void colorLogicOp(int p_179116_0_) {
		Modchu_GlStateManagerBase.colorLogicOp(p_179116_0_);
	}

	@Override
	public void enableTexGenCoord(Object glStateManagerTexGen) {
		Modchu_GlStateManagerBase.enableTexGenCoord((TexGen) glStateManagerTexGen);
	}

	@Override
	public void disableTexGenCoord(Object glStateManagerTexGen) {
		Modchu_GlStateManagerBase.disableTexGenCoord((TexGen) glStateManagerTexGen);
	}

	@Override
	public void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		Modchu_GlStateManagerBase.texGen((TexGen) glStateManagerTexGen, p_179149_1_);
	}

	@Override
	public void texGen(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		Modchu_GlStateManagerBase.texGen((TexGen) glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

	@Override
	public void disableTexture2D() {
		//Modchu_GlStateManagerBase.disableTexture2D();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}

	@Override
	public void bindTexture(int p_179144_0_) {
		Modchu_GlStateManagerBase.bindTexture(p_179144_0_);
	}

	@Override
	public void enableNormalize() {
		Modchu_GlStateManagerBase.enableNormalize();
	}

	@Override
	public void disableNormalize() {
		Modchu_GlStateManagerBase.disableNormalize();
	}

	@Override
	public void shadeModel(int p_179103_0_) {
		Modchu_GlStateManagerBase.shadeModel(p_179103_0_);
	}

	@Override
	public void enableRescaleNormal() {
		Modchu_GlStateManagerBase.enableRescaleNormal();
	}

	@Override
	public void disableRescaleNormal() {
		Modchu_GlStateManagerBase.disableRescaleNormal();
	}

	@Override
	public void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		Modchu_GlStateManagerBase.colorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
	}

	@Override
	public void clearDepth(double p_179151_0_) {
		Modchu_GlStateManagerBase.clearDepth(p_179151_0_);
	}

	@Override
	public void getFloat(int p_179111_0_, Object p_179111_1_) {
		Modchu_GlStateManagerBase.getFloat(p_179111_0_, (FloatBuffer) p_179111_1_);
	}

	@Override
	public void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		Modchu_GlStateManagerBase.rotate(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	@Override
	public void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		Modchu_GlStateManagerBase.scale(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	@Override
	public void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		Modchu_GlStateManagerBase.scale(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	@Override
	public void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		Modchu_GlStateManagerBase.translate(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	@Override
	public void multMatrix(Object p_179110_0_) {
		Modchu_GlStateManagerBase.multMatrix((FloatBuffer) p_179110_0_);
	}

	@Override
	public void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		Modchu_GlStateManagerBase.color(p_179124_0_, p_179124_1_, p_179124_2_);
	}

	@Override
	public void resetColor() {
		Modchu_GlStateManagerBase.resetColor();
	}

	@Override
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

	@Override
	public void glLight(int light, int pname, Object floatBuffer) {
		Modchu_GlStateManagerBase.glLight(light, pname, (FloatBuffer) floatBuffer);
	}

	@Override
	public void glLightModel(int pname, Object floatBuffer) {
		Modchu_GlStateManagerBase.glLightModel(pname, (FloatBuffer) floatBuffer);
	}

	@Override
	public void glNormal3f(float nx, float ny, float nz) {
		Modchu_GlStateManagerBase.glNormal3f(nx, ny, nz);
	}

	@Override
	public void blendFunc(Object sourceFactor, Object destFactor) {
		Modchu_GlStateManagerBase.blendFunc((SourceFactor) sourceFactor, (DestFactor) destFactor);
	}

	@Override
	public void tryBlendFuncSeparate(Object sourceFactor, Object destFactor, Object sourceFactor1, Object destFactor1) {
		Modchu_GlStateManagerBase.tryBlendFuncSeparate((SourceFactor) sourceFactor, (DestFactor) destFactor, (SourceFactor) sourceFactor1, (DestFactor) destFactor1);
	}

	@Override
	public void glBlendEquation(int blendEquation) {
		Modchu_GlStateManagerBase.glBlendEquation(blendEquation);
	}

	@Override
	public void enableOutlineMode(int p_187431_0_) {
		Modchu_GlStateManagerBase.enableOutlineMode(p_187431_0_);
	}

	@Override
	public void disableOutlineMode() {
		Modchu_GlStateManagerBase.disableOutlineMode();
	}

	@Override
	public void setFog(Object fogMode) {
		Modchu_GlStateManagerBase.setFog((FogMode) fogMode);
	}

	@Override
	public void glFog(int pname, Object floatBuffer) {
		Modchu_GlStateManagerBase.glFog(pname, (FloatBuffer) floatBuffer);
	}

	@Override
	public void glFogi(int pname, int param) {
		Modchu_GlStateManagerBase.glFogi(pname, param);
	}

	@Override
	public void cullFace(Object cullFace) {
		Modchu_GlStateManagerBase.cullFace((CullFace) cullFace);
	}

	@Override
	public void glPolygonMode(int face, int mode) {
		Modchu_GlStateManagerBase.glPolygonMode(face, mode);
	}

	@Override
	public void colorLogicOp(Object logicOp) {
		Modchu_GlStateManagerBase.colorLogicOp((LogicOp) logicOp);
	}

	@Override
	public void setActiveTexture(int texture) {
		Modchu_GlStateManagerBase.setActiveTexture(texture);
	}

	@Override
	public void glTexEnv(int target, int parameterName, Object floatBuffer) {
		Modchu_GlStateManagerBase.glTexEnv(target, parameterName, (FloatBuffer) floatBuffer);
	}

	@Override
	public void glTexEnvi(int target, int parameterName, int parameter) {
		Modchu_GlStateManagerBase.glTexEnvi(target, parameterName, parameter);
	}

	@Override
	public void glTexEnvf(int target, int parameterName, float parameter) {
		Modchu_GlStateManagerBase.glTexEnvf(target, parameterName, parameter);
	}

	@Override
	public void glTexParameterf(int target, int parameterName, float parameter) {
		Modchu_GlStateManagerBase.glTexParameterf(target, parameterName, parameter);
	}

	@Override
	public void glTexParameteri(int target, int parameterName, int parameter) {
		Modchu_GlStateManagerBase.glTexParameteri(target, parameterName, parameter);
	}

	@Override
	public int glGetTexLevelParameteri(int target, int level, int parameterName) {
		return Modchu_GlStateManagerBase.glGetTexLevelParameteri(target, level, parameterName);
	}

	@Override
	public void glTexImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, Object nullable) {
		Modchu_GlStateManagerBase.glTexImage2D(target, level, internalFormat, width, height, border, format, type, (IntBuffer) nullable);
	}

	@Override
	public void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format, int type, IntBuffer pixels) {
		Modchu_GlStateManagerBase.glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
	}

	@Override
	public void glCopyTexSubImage2D(int target, int level, int xOffset, int yOffset, int x, int y, int width, int height) {
		Modchu_GlStateManagerBase.glCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
	}

	@Override
	public void glGetTexImage(int target, int level, int format, int type, IntBuffer pixels) {
		Modchu_GlStateManagerBase.glGetTexImage(target, level, format, type, pixels);
	}

	@Override
	public void rotate(Object quaternion) {
		Modchu_GlStateManagerBase.rotate((Quaternion) quaternion);
	}

	@Override
	public Object quatToGlMatrix(Object floatBuffer, Object quaternion) {
		return Modchu_GlStateManagerBase.quatToGlMatrix((FloatBuffer) floatBuffer, (Quaternion) quaternion);
	}

	@Override
	public void glTexCoord2f(float sCoord, float tCoord) {
		Modchu_GlStateManagerBase.glTexCoord2f(sCoord, tCoord);
	}

	@Override
	public void glVertex3f(float x, float y, float z) {
		Modchu_GlStateManagerBase.glVertex3f(x, y, z);
	}

	@Override
	public void glNormalPointer(int type, int stride, Object byteBuffer) {
		Modchu_GlStateManagerBase.glNormalPointer(type, stride, (ByteBuffer) byteBuffer);
	}

	@Override
	public void glTexCoordPointer(int size, int type, int stride, int buffer_offset) {
		Modchu_GlStateManagerBase.glTexCoordPointer(size, type, stride, buffer_offset);
	}

	@Override
	public void glTexCoordPointer(int size, int type, int stride, Object byteBuffer) {
		Modchu_GlStateManagerBase.glTexCoordPointer(size, type, stride, (Integer) byteBuffer);
	}

	@Override
	public void glVertexPointer(int size, int type, int stride, int buffer_offset) {
		Modchu_GlStateManagerBase.glVertexPointer(size, type, stride, buffer_offset);
	}

	@Override
	public void glVertexPointer(int size, int type, int stride, Object byteBuffer) {
		Modchu_GlStateManagerBase.glVertexPointer(size, type, stride, (Integer) byteBuffer);
	}

	@Override
	public void glColorPointer(int size, int type, int stride, int buffer_offset) {
		Modchu_GlStateManagerBase.glColorPointer(size, type, stride, buffer_offset);
	}

	@Override
	public void glColorPointer(int size, int type, int stride, Object byteBuffer) {
		Modchu_GlStateManagerBase.glColorPointer(size, type, stride, (Integer) byteBuffer);
	}

	@Override
	public void glDisableClientState(int cap) {
		Modchu_GlStateManagerBase.glDisableClientState(cap);
	}

	@Override
	public void glEnableClientState(int cap) {
		Modchu_GlStateManagerBase.glEnableClientState(cap);
	}

	@Override
	public void glBegin(int mode) {
		Modchu_GlStateManagerBase.glBegin(mode);
	}

	@Override
	public void glEnd() {
		Modchu_GlStateManagerBase.glEnd();
	}

	@Override
	public void glDrawArrays(int mode, int first, int count) {
		Modchu_GlStateManagerBase.glDrawArrays(mode, first, count);
	}

	@Override
	public void glLineWidth(float width) {
		Modchu_GlStateManagerBase.glLineWidth(width);
	}

	@Override
	public void glDeleteLists(int list, int range) {
		Modchu_GlStateManagerBase.glDeleteLists(list, range);
	}

	@Override
	public void glNewList(int list, int mode) {
		Modchu_GlStateManagerBase.glNewList(list, mode);
	}

	@Override
	public void glEndList() {
		Modchu_GlStateManagerBase.glEndList();
	}

	@Override
	public int glGenLists(int range) {
		return Modchu_GlStateManagerBase.glGenLists(range);
	}

	@Override
	public void glPixelStorei(int parameterName, int param) {
		Modchu_GlStateManagerBase.glPixelStorei(parameterName, param);
	}

	@Override
	public void glReadPixels(int x, int y, int width, int height, int format, int type, IntBuffer pixels) {
		Modchu_GlStateManagerBase.glReadPixels(x, y, width, height, format, type, pixels);
	}

	@Override
	public int glGetError() {
		return Modchu_GlStateManagerBase.glGetError();
	}

	@Override
	public String glGetString(int name) {
		return Modchu_GlStateManagerBase.glGetString(name);
	}

	@Override
	public void glGetInteger(int parameterName, IntBuffer parameters) {
		Modchu_GlStateManagerBase.glGetInteger(parameterName, parameters);
	}

	@Override
	public int glGetInteger(int parameterName) {
		return Modchu_GlStateManagerBase.glGetInteger(parameterName);
	}

	@Override
	public void enableBlendProfile(Object profile) {
		Modchu_GlStateManagerBase.enableBlendProfile((Profile) profile);
	}

	@Override
	public void disableBlendProfile(Object profile) {
		Modchu_GlStateManagerBase.disableBlendProfile((Profile) profile);
	}

}
