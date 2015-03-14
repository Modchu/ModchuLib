package modchu.lib;

public interface Modchu_IModelRenderer {
	public Modchu_IModelRendererMaster getMaster();
	public void setMaster(Modchu_IModelRendererMaster modchu_IModelRendererMaster);
	public void superAddChild(Object modelRenderer);
	public Object superSetTextureOffset(int x, int y);
	public Object superAddBox(String s, float f, float f1, float f2, int f3, int i, int i1);
	public Object superAddBox(float f, float f1, float f2, int i, int i1, int i2);
	public Object superAddBox(float f, float f1, float f2, int i, int i1, int i2, boolean b);
	public void superAddBox(float f, float f1, float f2, int i, int i1, int i2, float f3);
	public void superSetRotationPoint(float x, float y, float z);
	public void superRender(float f);
	public void superRenderWithRotation(float f);
	public void superPostRender(float f);
	public Object superSetTextureSize(int x, int y);

}
