package modchu.lib;

import java.util.HashMap;

public class Modchu_ModelRendererMasterBasis implements Modchu_IModelRendererMaster {
	public Modchu_IModelRenderer base;

	public Modchu_ModelRendererMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IModelRenderer) map.get("base");
	}

	@Override
	public void addChild(Object modelRenderer) {
		base.superAddChild(modelRenderer);
	}

	@Override
	public Modchu_IModelRenderer setTextureOffset(int x, int y) {
		return (Modchu_IModelRenderer) base.superSetTextureOffset(x, y);
	}

	@Override
	public Modchu_IModelRenderer addBox(String s, float f, float f1, float f2, int f3, int i, int i1) {
		return (Modchu_IModelRenderer) base.superAddBox(s, f, f1, f2, f3, i, i1);
	}

	@Override
	public Modchu_IModelRenderer addBox(float f, float f1, float f2, int i, int i1, int i2) {
		return (Modchu_IModelRenderer) base.superAddBox(f, f1, f2, i, i1, i2);
	}

	@Override
	public Modchu_IModelRenderer addBox(float f, float f1, float f2, int i, int i1, int i2, boolean b) {
		return (Modchu_IModelRenderer) base.superAddBox(f, f1, f2, i, i1, i2, b);
	}

	@Override
	public Modchu_IModelRenderer setTextureSize(int x, int y) {
		return (Modchu_IModelRenderer) base.superSetTextureSize(x, y);
	}

	@Override
	public void addBox(float f, float f1, float f2, int i, int i1, int i2, float f3) {
		base.superAddBox(f, f1, f2, i, i1, i2, f3);
	}

	@Override
	public void setRotationPoint(float x, float y, float z) {
		base.superSetRotationPoint(x, y, z);
	}

	@Override
	public void render(float f) {
		base.superRender(f);
	}

	@Override
	public void renderWithRotation(float f) {
		base.superRenderWithRotation(f);
	}

	@Override
	public void postRender(float f) {
		base.superPostRender(f);
	}

}