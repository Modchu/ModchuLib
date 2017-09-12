package modchu.lib.forge.mc190_221;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

import javax.annotation.Nullable;

import org.lwjgl.util.vector.Quaternion;

import modchu.lib.Modchu_IGlStateManager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.CullFace;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.FogMode;
import net.minecraft.client.renderer.GlStateManager.LogicOp;
import net.minecraft.client.renderer.GlStateManager.Profile;

public class Modchu_GlStateManager implements Modchu_IGlStateManager {

	public Modchu_GlStateManager(HashMap<String, Object> map) {
	}

	@Override
	public void pushMatrix() {
		GlStateManager.pushMatrix();
	}

	@Override
	public void ortho(int i, int width, int j, int height, int k, int l) {
		GlStateManager.ortho(i, width, j, height, k, l);
	}

	@Override
	public void ortho(double d, double width, double height, double e, double f, double g) {
		GlStateManager.ortho(d, width, height, e, f, g);
	}

	@Override
	public void clearColor(float f, float f1, float f2, float f3) {
		GlStateManager.clearColor(f, f1, f2, f3);
	}

	@Override
	public void clear(int i) {
		GlStateManager.clear(i);
	}

	@Override
	public void popMatrix() {
		GlStateManager.popMatrix();
	}

	@Override
	public void generateTexture() {
		GlStateManager.generateTexture();
	}

	@Override
	public void enableTexture2D() {
		GlStateManager.enableTexture2D();
	}

	@Override
	public void enableBlend() {
		GlStateManager.enableBlend();
	}

	@Override
	public void matrixMode(int i) {
		GlStateManager.matrixMode(i);
	}

	@Override
	public void loadIdentity() {
		GlStateManager.loadIdentity();
	}

	@Override
	public void enableDepth() {
		GlStateManager.enableDepth();
	}

	@Override
	public void alphaFunc(int i, float f) {
		GlStateManager.alphaFunc(i, f);
	}

	@Override
	public void translate(float f, float f1, float f2) {
		GlStateManager.translate(f, f1, f2);
	}

	@Override
	public void disableLighting() {
		GlStateManager.disableLighting();
	}

	@Override
	public void disableFog() {
		GlStateManager.disableFog();
	}

	@Override
	public void disableDepth() {
		GlStateManager.disableDepth();
	}

	@Override
	public void viewport(int i, int j, int width, int height) {
		GlStateManager.viewport(i, j, width, height);
	}

	@Override
	public void color(float r, float g, float b, float a) {
		GlStateManager.color(r, g, b, a);
	}

	@Override
	public void enableAlpha() {
		GlStateManager.enableAlpha();
	}

	@Override
	public void pushAttrib() {
		GlStateManager.pushAttrib();
	}

	@Override
	public void popAttrib() {
		GlStateManager.popAttrib();
	}

	@Override
	public void disableAlpha() {
		GlStateManager.disableAlpha();
	}

	@Override
	public void enableLighting() {
		GlStateManager.enableLighting();
	}

	@Override
	public void enableLight(int p_179085_0_) {
		GlStateManager.enableLight(p_179085_0_);
	}

	@Override
	public void disableLight(int p_179122_0_) {
		GlStateManager.disableLight(p_179122_0_);
	}

	@Override
	public void enableColorMaterial() {
		GlStateManager.enableColorMaterial();
	}

	@Override
	public void disableColorMaterial() {
		GlStateManager.disableColorMaterial();
	}

	@Override
	public void colorMaterial(int p_179104_0_, int p_179104_1_) {
		GlStateManager.colorMaterial(p_179104_0_, p_179104_1_);
	}

	@Override
	public void depthFunc(int p_179143_0_) {
		GlStateManager.depthFunc(p_179143_0_);
	}

	@Override
	public void depthMask(boolean p_179132_0_) {
		GlStateManager.depthMask(p_179132_0_);
	}

	@Override
	public void disableBlend() {
		GlStateManager.disableBlend();
	}

	@Override
	public void blendFunc(int p_179112_0_, int p_179112_1_) {
		GlStateManager.blendFunc(p_179112_0_, p_179112_1_);
	}

	@Override
	public void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
		GlStateManager.tryBlendFuncSeparate(p_179120_0_, p_179120_1_, p_179120_2_, p_179120_3_);
	}

	@Override
	public void enableFog() {
		GlStateManager.enableFog();
	}

	@Override
	public void setFogDensity(float p_179095_0_) {
		GlStateManager.setFogDensity(p_179095_0_);
	}

	@Override
	public void setFogStart(float p_179102_0_) {
		GlStateManager.setFogStart(p_179102_0_);
	}

	@Override
	public void setFogEnd(float p_179153_0_) {
		GlStateManager.setFogEnd(p_179153_0_);
	}

	@Override
	public void enableCull() {
		GlStateManager.enableCull();
	}

	@Override
	public void disableCull() {
		GlStateManager.disableCull();
	}

	@Override
	public void enablePolygonOffset() {
		GlStateManager.enablePolygonOffset();
	}

	@Override
	public void disablePolygonOffset() {
		GlStateManager.disablePolygonOffset();
	}

	@Override
	public void doPolygonOffset(float p_179136_0_, float p_179136_1_) {
		GlStateManager.doPolygonOffset(p_179136_0_, p_179136_1_);
	}

	@Override
	public void enableColorLogic() {
		GlStateManager.enableColorLogic();
	}

	@Override
	public void disableColorLogic() {
		GlStateManager.disableColorLogic();
	}

	@Override
	public void colorLogicOp(int p_179116_0_) {
		GlStateManager.colorLogicOp(p_179116_0_);
	}

	@Override
	public void enableTexGenCoord(Object glStateManagerTexGen) {
		GlStateManager.enableTexGenCoord((GlStateManager.TexGen) glStateManagerTexGen);
	}

	@Override
	public void disableTexGenCoord(Object glStateManagerTexGen) {
		GlStateManager.disableTexGenCoord((GlStateManager.TexGen) glStateManagerTexGen);
	}

	@Override
	public void texGen(Object glStateManagerTexGen, int p_179149_1_) {
		GlStateManager.texGen((GlStateManager.TexGen) glStateManagerTexGen, p_179149_1_);
	}

	@Override
	public void disableTexture2D() {
		GlStateManager.disableTexture2D();
	}

	@Override
	public void deleteTexture(int p_179150_0_) {
		GlStateManager.deleteTexture(p_179150_0_);
	}

	@Override
	public void bindTexture(int p_179144_0_) {
		GlStateManager.bindTexture(p_179144_0_);
	}

	@Override
	public void enableNormalize() {
		GlStateManager.enableNormalize();
	}

	@Override
	public void disableNormalize() {
		GlStateManager.disableNormalize();
	}

	@Override
	public void shadeModel(int p_179103_0_) {
		GlStateManager.shadeModel(p_179103_0_);
	}

	@Override
	public void enableRescaleNormal() {
		GlStateManager.enableRescaleNormal();
	}

	@Override
	public void disableRescaleNormal() {
		GlStateManager.disableRescaleNormal();
	}

	@Override
	public void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
		GlStateManager.colorMask(p_179135_0_, p_179135_1_, p_179135_2_, p_179135_3_);
	}

	@Override
	public void clearDepth(double p_179151_0_) {
		GlStateManager.clearDepth(p_179151_0_);
	}

	@Override
	public void getFloat(int p_179111_0_, Object p_179111_1_) {
		GlStateManager.getFloat(p_179111_0_, (FloatBuffer) p_179111_1_);
	}

	@Override
	public void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
		GlStateManager.rotate(p_179114_0_, p_179114_1_, p_179114_2_, p_179114_3_);
	}

	@Override
	public void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
		GlStateManager.scale(p_179152_0_, p_179152_1_, p_179152_2_);
	}

	@Override
	public void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
		GlStateManager.scale(p_179139_0_, p_179139_2_, p_179139_4_);
	}

	@Override
	public void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
		GlStateManager.translate(p_179137_0_, p_179137_2_, p_179137_4_);
	}

	@Override
	public void multMatrix(Object p_179110_0_) {
		GlStateManager.multMatrix((FloatBuffer) p_179110_0_);
	}

	@Override
	public void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
		GlStateManager.color(p_179124_0_, p_179124_1_, p_179124_2_);
	}

	@Override
	public void resetColor() {
		GlStateManager.resetColor();
	}

	@Override
	public void callList(int p_179148_0_) {
		GlStateManager.callList(p_179148_0_);
	}

	@Override
	public void texGen(Object glStateManagerTexGen, int p_179105_1_, Object floatBuffer) {
		GlStateManager.texGen((GlStateManager.TexGen) glStateManagerTexGen, p_179105_1_, (FloatBuffer) floatBuffer);
	}

	@Override
	public void glNormal3f(float nx, float ny, float nz) {
		GlStateManager.glNormal3f(nx, ny, nz);
	}

	@Override
	public void glBlendEquation(int blendEquation) {
		GlStateManager.glBlendEquation(blendEquation);
	}

	@Override
	public void enableOutlineMode(int p_187431_0_) {
		GlStateManager.enableOutlineMode(p_187431_0_);
	}

	@Override
	public void disableOutlineMode() {
		GlStateManager.disableOutlineMode();
	}

	@Override
	public void glFogi(int pname, int param) {
		GlStateManager.glFogi(pname, param);
	}

	@Override
	public void glPolygonMode(int face, int mode) {
		GlStateManager.glPolygonMode(face, mode);
	}

	@Override
	public void setActiveTexture(int texture) {
		GlStateManager.setActiveTexture(texture);
	}

	@Override
	public void glTexEnvi(int target, int parameterName, int parameter) {
		GlStateManager.glTexEnvi(target, parameterName, parameter);
	}

	@Override
	public void glTexEnvf(int target, int parameterName, float parameter) {
		GlStateManager.glTexEnvf(target, parameterName, parameter);
	}

	@Override
	public void glTexParameterf(int target, int parameterName, float parameter) {
		GlStateManager.glTexParameterf(target, parameterName, parameter);
	}

	@Override
	public void glTexParameteri(int target, int parameterName, int parameter) {
		GlStateManager.glTexParameteri(target, parameterName, parameter);
	}

	@Override
	public int glGetTexLevelParameteri(int target, int level, int parameterName) {
		return GlStateManager.glGetTexLevelParameteri(target, level, parameterName);
	}

	@Override
	public void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format, int type, IntBuffer pixels) {
		GlStateManager.glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
	}

	@Override
	public void glCopyTexSubImage2D(int target, int level, int xOffset, int yOffset, int x, int y, int width, int height) {
		GlStateManager.glCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
	}

	@Override
	public void glGetTexImage(int target, int level, int format, int type, IntBuffer pixels) {
		GlStateManager.glGetTexImage(target, level, format, type, pixels);
	}

	@Override
	public void glTexCoord2f(float sCoord, float tCoord) {
		GlStateManager.glTexCoord2f(sCoord, tCoord);
	}

	@Override
	public void glVertex3f(float x, float y, float z) {
		GlStateManager.glVertex3f(x, y, z);
	}

	@Override
	public void glTexCoordPointer(int size, int type, int stride, int buffer_offset) {
		GlStateManager.glTexCoordPointer(size, type, stride, buffer_offset);
	}

	@Override
	public void glVertexPointer(int size, int type, int stride, int buffer_offset) {
		GlStateManager.glVertexPointer(size, type, stride, buffer_offset);
	}

	@Override
	public void glColorPointer(int size, int type, int stride, int buffer_offset) {
		GlStateManager.glColorPointer(size, type, stride, buffer_offset);
	}

	@Override
	public void glDisableClientState(int cap) {
		GlStateManager.glDisableClientState(cap);
	}

	@Override
	public void glEnableClientState(int cap) {
		GlStateManager.glEnableClientState(cap);
	}

	@Override
	public void glBegin(int mode) {
		GlStateManager.glBegin(mode);
	}

	@Override
	public void glEnd() {
		GlStateManager.glEnd();
	}

	@Override
	public void glDrawArrays(int mode, int first, int count) {
		GlStateManager.glDrawArrays(mode, first, count);
	}

	@Override
	public void glLineWidth(float width) {
		GlStateManager.glLineWidth(width);
	}

	@Override
	public void glDeleteLists(int list, int range) {
		GlStateManager.glDeleteLists(list, range);
	}

	@Override
	public void glNewList(int list, int mode) {
		GlStateManager.glNewList(list, mode);
	}

	@Override
	public void glEndList() {
		GlStateManager.glEndList();
	}

	@Override
	public int glGenLists(int range) {
		return GlStateManager.glGenLists(range);
	}

	@Override
	public void glPixelStorei(int parameterName, int param) {
		GlStateManager.glPixelStorei(parameterName, param);
	}

	@Override
	public void glReadPixels(int x, int y, int width, int height, int format, int type, IntBuffer pixels) {
		GlStateManager.glReadPixels(x, y, width, height, format, type, pixels);
	}

	@Override
	public int glGetError() {
		return GlStateManager.glGetError();
	}

	@Override
	public String glGetString(int name) {
		return GlStateManager.glGetString(name);
	}

	@Override
	public void glGetInteger(int parameterName, IntBuffer parameters) {
		GlStateManager.glGetInteger(parameterName, parameters);
	}

	@Override
	public int glGetInteger(int parameterName) {
		return GlStateManager.glGetInteger(parameterName);
	}

	@Override
	public void glLight(int light, int pname, Object floatBuffer) {
		GlStateManager.glLight(light, pname, (FloatBuffer) floatBuffer);
	}

	@Override
	public void glLightModel(int pname, Object floatBuffer) {
		GlStateManager.glLightModel(pname, (FloatBuffer) floatBuffer);
	}

	@Override
	public void blendFunc(Object sourceFactor, Object destFactor) {
		GlStateManager.blendFunc((GlStateManager.SourceFactor) sourceFactor, (GlStateManager.DestFactor) destFactor);
	}

	@Override
	public void tryBlendFuncSeparate(Object sourceFactor, Object destFactor, Object sourceFactor1, Object destFactor1) {
		GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor) sourceFactor, (GlStateManager.DestFactor) destFactor, (GlStateManager.SourceFactor) sourceFactor1, (GlStateManager.DestFactor) destFactor1);
	}

	@Override
	public void setFog(Object fogMode) {
		GlStateManager.setFog((GlStateManager.FogMode) fogMode);
	}

	@Override
	public void glFog(int pname, Object floatBuffer) {
		GlStateManager.glFog(pname, (FloatBuffer) floatBuffer);
	}

	@Override
	public void cullFace(Object cullFace) {
		GlStateManager.cullFace((CullFace) cullFace);
	}

	@Override
	public void colorLogicOp(Object logicOp) {
		GlStateManager.colorLogicOp((LogicOp) logicOp);
	}

	@Override
	public void glTexEnv(int target, int parameterName, Object floatBuffer) {
		GlStateManager.glTexEnv(target, parameterName, (FloatBuffer) floatBuffer);
	}

	@Override
	public void glTexImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, Object nullable) {
		GlStateManager.glTexImage2D(target, level, internalFormat, width, height, border, format, type, (IntBuffer) nullable);
	}

	@Override
	public void rotate(Object quaternion) {
		GlStateManager.rotate((Quaternion) quaternion);
	}

	@Override
	public Object quatToGlMatrix(Object floatBuffer, Object quaternion) {
		return GlStateManager.quatToGlMatrix((FloatBuffer) floatBuffer, (Quaternion) quaternion);
	}

	@Override
	public void glNormalPointer(int type, int stride, Object byteBuffer) {
		GlStateManager.glNormalPointer(type, stride, (ByteBuffer) byteBuffer);
	}

	@Override
	public void glTexCoordPointer(int size, int type, int stride, Object byteBuffer) {
		GlStateManager.glTexCoordPointer(size, type, stride, (ByteBuffer) byteBuffer);
	}

	@Override
	public void glVertexPointer(int size, int type, int stride, Object byteBuffer) {
		GlStateManager.glVertexPointer(size, type, stride, (ByteBuffer) byteBuffer);
	}

	@Override
	public void glColorPointer(int size, int type, int stride, Object byteBuffer) {
		GlStateManager.glColorPointer(size, type, stride, (ByteBuffer) byteBuffer);
	}

	@Override
	public void enableBlendProfile(Object profile) {
		GlStateManager.enableBlendProfile((Profile) profile);
	}

	@Override
	public void disableBlendProfile(Object profile) {
		GlStateManager.disableBlendProfile((Profile) profile);
	}

}
