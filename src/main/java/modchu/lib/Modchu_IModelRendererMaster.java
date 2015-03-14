package modchu.lib;


public interface Modchu_IModelRendererMaster {
	public void addChild(Object modelRenderer);
	public Modchu_IModelRenderer setTextureOffset(int x, int y);
	public Modchu_IModelRenderer addBox(String s, float f, float f1, float f2, int f3, int i, int i1);
	public Modchu_IModelRenderer addBox(float f, float f1, float f2, int i, int i1, int i2);
	public Modchu_IModelRenderer addBox(float f, float f1, float f2, int i, int i1, int i2, boolean b);
	public void addBox(float f, float f1, float f2, int i, int i1, int i2, float f3);
	public void setRotationPoint(float x, float y, float z);
	public void render(float f);
	public void renderWithRotation(float f);
	public void postRender(float f);
	public Modchu_IModelRenderer setTextureSize(int x, int y);

}
