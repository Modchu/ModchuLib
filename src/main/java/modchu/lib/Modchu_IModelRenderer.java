package modchu.lib;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.characteristic.Modchu_IEntityCapsBase;
import modchu.lib.characteristic.Modchu_ModelRenderer;

public interface Modchu_IModelRenderer {

	public Modchu_ModelRenderer setTextureOffset(int i, int j);
	public int getTextureOffsetX();
	public int getTextureOffsetY();
	public ConcurrentHashMap<String, Object> getTextureOffsetMap();
	public void setTextureOffset(String s, int par2, int par3);
	public Object getTextureOffset(String s);
	public Modchu_ModelRenderer addCubeList(Object object);
	public Modchu_ModelRenderer addBox(String pName, float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth);
	public Modchu_ModelRenderer addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth);
	public Modchu_ModelRenderer addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth, float pSizeAdjust);
	public Modchu_ModelRenderer addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth, float pSizeAdjust, boolean b);
	public Modchu_ModelRendererBase addParts(Class pModelBoxBase, String pName, Object... pArg);
	public Modchu_ModelRenderer addParts(Class pModelBoxBase, Object... pArg);
	public Modchu_ModelRenderer addParts(Class pModelBoxBase, Class constructorClass, Object... pArg);
	public Modchu_ModelRenderer addPartsTexture(Class pModelBoxBase, String pName, Object... pArg);
	public Modchu_ModelRenderer addPartsTexture(Class pModelBoxBase, Object... pArg);
	public Object getModelBoxBaseObject(Class pModelBoxBase, Object... pArg);
	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k);
	public Modchu_ModelRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3);
	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] vertexN, int px, int py);
	public Modchu_ModelRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN);
	public Modchu_ModelRenderer addPlateFreeShape(float[][] var1, float[][] var2, float[][] var3, float[] var4);
	public Modchu_ModelRenderer addBall(float var1, float var2, float var3, float var4, float var5, float var6);
	public void clearCubeList();
	public void renderItemsHead(Object model, Modchu_IEntityCapsBase entityCaps, float scale, int addSupport);
	public void renderItemsHead(Object model, Modchu_IEntityCapsBase entityCaps, Object itemStack, float scale, int addSupport);
	public boolean renderItems(Object model, Modchu_IEntityCapsBase entityCaps, boolean pRealBlock, int pIndex);
	public void renderItems(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemStack, float scale, int addSupport, Enum type);
	public void renderItems(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemStack);
	public void renderItems(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemStack, float scale);
	public void renderItems(Object entityLiving, boolean pRealBlock, Object enumAction, Object itemStack, float scale, Enum type);
	public boolean renderBlockDoublePlant(Object renderBlocks, Object blockDoublePlant, int i, double d, int x, int y, int z);
	public boolean renderDecoBlock(Object entityLiving, boolean pRealBlock, Object enumAction, float scale, int addSupport);
	public void setRotatePriority(int pValue);
	public void setRotation();
	public void renderObject(float par1, boolean b);
	public void render(float par1);
	public void render(float par1, boolean b);
	public void renderWithRotation(float par1);
	public void postRender(float par1);
	public void postRenderAll(float par1, boolean b);
	public void compileDisplayList(float par1);
	public void preRotateRender(float f);
	public void preRotateRenderDeg(float f);
	public boolean setParentsRotate();
	public void setPreRotationPointLM(float f, float f1, float f2);
	public void individuallyHidePreRotateRender(float par1);
	public void addBoneChild(Modchu_ModelRenderer par1ModelRenderer);
	public void addBoneSpecialChild(Modchu_ModelRenderer par1ModelRenderer);
	public void removeChild(Modchu_ModelRenderer par1ModelRenderer);
	public void removeBoneChild(Modchu_ModelRenderer par1ModelRenderer);
	public void removeBoneSpecialChild(Modchu_ModelRenderer par1ModelRenderer);
	public void clearChildModels();
	public void clearBoneChildModels();
	public void clearBoneSpecialChildModels();
	public void setCompiled(boolean b);
	public int getBoxSizeX();
	public int getBoxSizeY();
	public int getBoxSizeZ();
	public int getboxSizeX(int i);
	public int getboxSizeY(int i);
	public int getboxSizeZ(int i);
	public Object getFreeVariable(String s);
	public void setFreeVariable(String s, Object o);
	public void removeFreeVariable(String s);
	public void reset();
	public void fadeStore(float var1);
	public void fadeIntermediate(float var1);
	public void setParentModel(Modchu_ModelRenderer modelRenderer);
	public List<Modchu_ModelRenderer> getBoneChildModels();
	public List<Modchu_ModelRenderer> getBoneSpecialChildModels();
	public String getBoxName();
	public void setBoxName(String s);
	public void addChild(Modchu_ModelRenderer modelRenderer);

}
