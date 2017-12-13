package modchu.lib;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_GlStateManager;
import modchu.lib.Modchu_IModelBox;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_ModelBaseMaster;
import modchu.lib.Modchu_ModelBox;
import modchu.lib.Modchu_ModelBoxMaster;
import modchu.lib.Modchu_Reflect;

public class Modchu_ModelRendererBase {

	// ModelRenderer互換変数群
	public float textureWidth;
	public float textureHeight;
	public int textureOffsetX;
	public int textureOffsetY;
	public float rotationPointX;
	public float rotationPointY;
	public float rotationPointZ;
	public float rotateAngleX;
	public float rotateAngleY;
	public float rotateAngleZ;
	protected boolean compiled;
	protected int displayList;
	public boolean mirror;
	public boolean showModel;
	public boolean isHidden;
	/**
	 * パーツの親子関係に左右されずに描画するかを決める。
	 * アーマーの表示などに使う。
	 */
	public boolean isRendering;
	public List<Modchu_IModelBox> cubeList;
	public List<Modchu_ModelRendererBase> childModels;
	public final String boxName;
	protected Object baseModel;
	public Modchu_ModelRendererBase pearent;
	public float offsetX;
	public float offsetY;
	public float offsetZ;
	public float scaleX;
	public float scaleY;
	public float scaleZ;

	public static final float radFactor = 180F / (float)Math.PI;
	public static final float degFactor = (float)Math.PI / 180F;

	// SmartMovingに合わせるために名称の変更があるかもしれません。
	public int rotatePriority;
	public static final int RotXYZ = 0;
	public static final int RotXZY = 1;
	public static final int RotYXZ = 2;
	public static final int RotYZX = 3;
	public static final int RotZXY = 4;
	public static final int RotZYX = 5;

	protected Object itemStack;

	public boolean adjust;
	public FloatBuffer matrix;
	public boolean isInvertX;
	private ConcurrentHashMap<String, Object> textureOffsetMap;

	public Modchu_ModelRendererBase(Object pModelBase) {
		this(pModelBase, 0, 0, (String)null, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRendererBase(Object modelBase, int px, int py) {
		this(modelBase, px, py, (String)null, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRendererBase(Object modelBase, int px, int py, String s) {
		this(modelBase, px, py, s, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRendererBase(Object pModelBase, int px, int py, float pScaleX, float pScaleY, float pScaleZ) {
		this(pModelBase, px, py, null, pScaleX, pScaleY, pScaleZ);
	}

	public Modchu_ModelRendererBase(Object pModelBase, String s) {
		this(pModelBase, 0, 0, s, 1.0F, 1.0F, 1.0F);
	}

	public Modchu_ModelRendererBase(Object pModelBase, float pScaleX, float pScaleY, float pScaleZ) {
		this(pModelBase, 0, 0, null, pScaleX, pScaleY, pScaleZ);
	}

	public Modchu_ModelRendererBase(Object pModelBase, int px, int py, String pName, float pScaleX, float pScaleY, float pScaleZ) {
		textureWidth = 64.0F;
		textureHeight = 32.0F;
		compiled = false;
		displayList = 0;
		mirror = false;
		showModel = true;
		isHidden = false;
		isRendering = true;
		cubeList = new ArrayList();
		baseModel = pModelBase;
		List boxList = pModelBase != null
				&& pModelBase instanceof Modchu_ModelBaseMaster ? ((Modchu_ModelBaseMaster) pModelBase).boxList : pModelBase != null ? Modchu_AS.getList(Modchu_AS.modelBaseBoxList, pModelBase) : null;
		if (boxList != null) boxList.add(this);
		boxName = pName;
		if (pModelBase != null) setTextureSize(Modchu_AS.getInt(Modchu_AS.modelBaseTextureWidth, pModelBase), Modchu_AS.getInt(Modchu_AS.modelBaseTextureHeight, pModelBase));

		rotatePriority = RotXYZ;
		itemStack = null;
		adjust = true;
		matrix = BufferUtils.createFloatBuffer(16);
		isInvertX = false;

		scaleX = pScaleX;
		scaleY = pScaleY;
		scaleZ = pScaleZ;

		offsetX = 0.0F;
		offsetY = 0.0F;
		offsetZ = 0.0F;

		pearent = null;
		setTextureOffset(px, py);
	}

	public List getCubeList() {
		return cubeList;
	}

	public Object getBaseModel() {
		return baseModel;
	}

	public int getTextureOffsetX() {
		return textureOffsetX;
	}

	public int getTextureOffsetY() {
		return textureOffsetY;
	}

	public float getTextureWidth() {
		return textureWidth;
	}

	public float getTextureHeight() {
		return textureHeight;
	}

	public ConcurrentHashMap<String, Object> getTextureOffsetMap() {
		return textureOffsetMap;
	}

	public void setTextureOffset(String s, int x, int y) {
		textureOffsetMap.put(s, Modchu_Reflect.newInstance("TextureOffset", new Class[]{ int.class, int.class }, new Object[]{ x, y }));
	}

	public Object getTextureOffset(String s) {
		return textureOffsetMap.get(s);
	}

	public void addChild(Modchu_ModelRendererBase modelRenderer) {
		if (modelRenderer != null); else return;
		if (childModels == null) {
			childModels = new ArrayList();
		}
		if (!childModels.contains(modelRenderer)) childModels.add(modelRenderer);
	}

	public Modchu_ModelRendererBase setTextureOffset(int pOffsetX, int pOffsetY) {
		textureOffsetX = pOffsetX;
		textureOffsetY = pOffsetY;
		return this;
	}

	public Modchu_ModelRendererBase addBox(String pName, float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth) {
		addParts(Modchu_ModelBoxMaster.class, pName, pX, pY, pZ, pWidth, pHeight, pDepth, 0.0F);
		return this;
	}

	public Modchu_ModelRendererBase addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth) {
		addBox(pX, pY, pZ, pWidth, pHeight, pDepth, 0.0F);
		return this;
	}

	public Modchu_ModelRendererBase addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth, float pSizeAdjust) {
		addBox(pX, pY, pZ, pWidth, pHeight, pDepth, pSizeAdjust, false);
		return this;
	}

	public Modchu_ModelRendererBase addBox(float pX, float pY, float pZ, int pWidth, int pHeight, int pDepth, float pSizeAdjust, boolean b) {
		addParts(Modchu_ModelBoxMaster.class, pX, pY, pZ, pWidth, pHeight, pDepth, pSizeAdjust, b);
		return this;
	}

	public Modchu_ModelRendererBase addParts(Class pModelBoxBaseMaster, String pName, Object... pArg) {
		pName = (new StringBuilder()).append(boxName).append(".").append(pName).toString();
		Object textureOffset = getTextureOffset(pName);
		if (textureOffset != null); else textureOffset = Modchu_Reflect.newInstance("TextureOffset", new Class[]{ int.class, int.class }, new Object[]{ 0, 0 });
		int tempTextureOffsetX = getTextureOffsetX();
		int tempTextureOffsetY = getTextureOffsetY();
		setTextureOffset(Modchu_AS.getInt(Modchu_AS.textureOffsetTextureOffsetX, textureOffset), Modchu_AS.getInt(Modchu_AS.textureOffsetTextureOffsetY, textureOffset));
		addParts(pModelBoxBaseMaster, pArg);
		setTextureOffset(tempTextureOffsetX, tempTextureOffsetY);
		return this;
	}

	public Modchu_ModelRendererBase addParts(Class pModelBoxBaseMaster, Object... pArg) {
		pArg = Modchu_Main.addObjectArray(true, pArg, pModelBoxBaseMaster, this, textureOffsetX, textureOffsetY);
		//Modchu_Debug.mDebugObjectArray("addParts s------", pArg, "addParts e-----");
		addCubeList(new Modchu_ModelBox(Modchu_Main.getNewModchuCharacteristicMap(pArg)));
		return this;
	}

	public Modchu_ModelRendererBase setRotationPoint(float pX, float pY, float pZ) {
		rotationPointX = pX;
		rotationPointY = pY;
		rotationPointZ = pZ;
		return this;
	}

	public void render(float par1) {
		render(par1, showModel);
	}

	public void render(float par1, boolean b) {
		if (isHidden) return;

		if (showModel && !compiled) {
			compileDisplayList(par1);
		}

		Modchu_GlStateManager.pushMatrix();
		Modchu_GlStateManager.translate(offsetX, offsetY, offsetZ);

		if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			Modchu_GlStateManager.translate(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			setRotation();
		}
		renderObject(par1, b);
		Modchu_GlStateManager.popMatrix();
	}

	public void renderWithRotation(float par1) {
		if (isHidden) {
			return;
		}

		if (showModel
				&& !compiled) {
			compileDisplayList(par1);
		}

		Modchu_GlStateManager.pushMatrix();
		Modchu_GlStateManager.translate(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

		setRotation();

		Modchu_GlStateManager.callList(displayList);
		Modchu_GlStateManager.popMatrix();
	}

	public void postRender(float par1) {
		if (showModel
				&& !compiled) {
			compileDisplayList(par1);
		}

		Modchu_GlStateManager.pushMatrix();
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			Modchu_GlStateManager.translate(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

			setRotation();
		} else if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			Modchu_GlStateManager.translate(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}

		if (pearent != null) {
			pearent.postRender(par1);
		}
		Modchu_GlStateManager.popMatrix();
	}

	public void compileDisplayList(float par1) {
		displayList = Modchu_AS.getInt(Modchu_AS.gLAllocationGenerateDisplayLists, 1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		//Object tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
		if (cubeList != null
				&& !cubeList.isEmpty())
		for (Modchu_IModelBox modchu_IModelBox : cubeList) {
			//Modchu_Debug.mDebug1("compileDisplayList modchu_IModelBoxgetClass()="+modchu_IModelBoxgetClass());
			modchu_IModelBox.render(par1);
		}
		GL11.glEndList();
		compiled = true;
	}

	public Modchu_ModelRendererBase setTextureSize(int pWidth, int pHeight) {
		textureWidth = (float)pWidth;
		textureHeight = (float)pHeight;
		return this;
	}


	// 独自追加分

	/**
	 * ModelBox継承の独自オブジェクト追加用
	 */
	public Modchu_ModelRendererBase addCubeList(Modchu_IModelBox modchu_IModelBox) {
		cubeList.add(modchu_IModelBox);
		return this;
	}

	/**
	 * 描画用のボックス、子供をクリアする
	 */
	public void clearCubeList() {
		if (getCubeList() != null) getCubeList().clear();
		setCompiled(false);
		clearChildModels();
	}

	public void clearChildModels() {
		if (childModels != null) childModels.clear();
	}

	/**
	 *  回転変換を行う順序を指定。
	 * @param pValue
	 * Rot???を指定する
	 */
	public void setRotatePriority(int pValue) {
		rotatePriority = pValue;
	}

	/**
	 * 内部実行用、座標変換部
	 */
	public void setRotation() {
		// 変換順位の設定
		switch (rotatePriority) {
		case RotXYZ:
			if (rotateAngleZ != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotXZY:
			if (rotateAngleY != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotYXZ:
			if (rotateAngleZ != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotYZX:
			if (rotateAngleX != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotZXY:
			if (rotateAngleY != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		case RotZYX:
			if (rotateAngleX != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				Modchu_GlStateManager.rotate(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		}
	}

	/**
	 * 内部実行用、レンダリング部分。
	 */
	public void renderObject(float par1, boolean b) {
		//Modchu_Debug.mDebug1("ModchuModel_ModelRendererBase renderObject getBoxName()="+getBoxName());
		// レンダリング、あと子供も
		if (showModel) {
			Modchu_GlStateManager.scale(scaleX, scaleY, scaleZ);
			Modchu_GlStateManager.getFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
			if (b) Modchu_GlStateManager.callList(displayList);
		}
		if (childModels != null) {
			for (int i = 0; i < childModels.size(); i++) {
				childModels.get(i).render(par1, b);
			}
		}
		if (childModels != null
				&& !childModels.isEmpty()); else {
			List cubeList = getCubeList();
			boolean flag = cubeList != null
					&& cubeList.size() > 0;
			if (!flag) {
				Modchu_GlStateManager.rotate(Modchu_Debug.debaf1 * radFactor, 0.0F, 1.0F, 0.0F);
				//Modchu_Debug.dDebug(""+Modchu_Debug.debaf1);
				//Modchu_Debug.mDebug1("ModchuModel_ModelRendererBase renderObject rotate getBoxName()="+getBoxName()+" displayList="+displayList);
			} else {
				//Modchu_Debug.mDebug1("ModchuModel_ModelRendererBase renderObject !rotate getBoxName()="+getBoxName()+" displayList="+displayList);
			}
		}
	}

	/**
	 * パーツ描画時点のマトリクスを設定する。 これ以前に設定されたマトリクスは破棄される。
	 */
	public Modchu_ModelRendererBase loadMatrix() {
		GL11.glLoadMatrix(matrix);
		if (isInvertX) {
			GL11.glScalef(-1F, 1F, 1F);
		}
		return this;
	}


	// ゲッター、セッター

	public boolean getMirror() {
		return mirror;
	}

	public Modchu_ModelRendererBase setMirror(boolean flag) {
		mirror = flag;
		return this;
	}

	public boolean getVisible() {
		return showModel;
	}

	public void setVisible(boolean flag) {
		showModel = flag;
	}


	// Deg付きは角度指定が度数法

	public float getRotateAngleX() {
		return rotateAngleX;
	}

	public float getRotateAngleDegX() {
		return rotateAngleX * radFactor;
	}

	public float setRotateAngleX(float value) {
		return rotateAngleX = value;
	}

	public float setRotateAngleDegX(float value) {
		return rotateAngleX = value * degFactor;
	}

	public float addRotateAngleX(float value) {
		return rotateAngleX += value;
	}

	public float addRotateAngleDegX(float value) {
		return rotateAngleX += value * degFactor;
	}

	public float getRotateAngleY() {
		return rotateAngleY;
	}

	public float getRotateAngleDegY() {
		return rotateAngleY * radFactor;
	}

	public float setRotateAngleY(float value) {
		return rotateAngleY = value;
	}

	public float setRotateAngleDegY(float value) {
		return rotateAngleY = value * degFactor;
	}

	public float addRotateAngleY(float value) {
		return rotateAngleY += value;
	}

	public float addRotateAngleDegY(float value) {
		return rotateAngleY += value * degFactor;
	}

	public float getRotateAngleZ() {
		return rotateAngleZ;
	}

	public float getRotateAngleDegZ() {
		return rotateAngleZ * radFactor;
	}

	public float setRotateAngleZ(float value) {
		return rotateAngleZ = value;
	}

	public float setRotateAngleDegZ(float value) {
		return rotateAngleZ = value * degFactor;
	}

	public float addRotateAngleZ(float value) {
		return rotateAngleZ += value;
	}

	public float addRotateAngleDegZ(float value) {
		return rotateAngleZ += value * degFactor;
	}

	public Modchu_ModelRendererBase setRotateAngle(float x, float y, float z) {
		rotateAngleX = x;
		rotateAngleY = y;
		rotateAngleZ = z;
		return this;
	}

	public Modchu_ModelRendererBase setRotateAngleDeg(float x, float y, float z) {
		rotateAngleX = x * degFactor;
		rotateAngleY = y * degFactor;
		rotateAngleZ = z * degFactor;
		return this;
	}

	public float getRotationPointX() {
		return rotationPointX;
	}

	public float setRotationPointX(float value) {
		return rotationPointX = value;
	}

	public float addRotationPointX(float value) {
		return rotationPointX += value;
	}

	public float getRotationPointY() {
		return rotationPointY;
	}

	public float setRotationPointY(float value) {
		return rotationPointY = value;
	}

	public float addRotationPointY(float value) {
		return rotationPointY += value;
	}

	public float getRotationPointZ() {
		return rotationPointZ;
	}

	public float setRotationPointZ(float value) {
		return rotationPointZ = value;
	}

	public float addRotationPointZ(float value) {
		return rotationPointZ += value;
	}

	public Modchu_ModelRendererBase setScale(float pX, float pY, float pZ) {
		scaleX = pX;
		scaleY = pY;
		scaleZ = pZ;
		return this;
	}

	public float setScaleX(float pValue) {
		return scaleX = pValue;
	}

	public float setScaleY(float pValue) {
		return scaleY = pValue;
	}

	public float setScaleZ(float pValue) {
		return scaleZ = pValue;
	}

	public String getBoxName() {
		return boxName;
	}

	public boolean getCompiled() {
		return compiled;
	}

	public void setCompiled(boolean b) {
		compiled = b;
	}

	public int getBoxSizeX() {
		return getboxSizeX(0);
	}

	public int getBoxSizeY() {
		return getboxSizeY(0);
	}

	public int getBoxSizeZ() {
		return getboxSizeZ(0);
	}

	public int getboxSizeX(int i) {
		return cubeList != null
				&& cubeList.size() > i ? (Integer) Modchu_Reflect.invokeMethod(cubeList.get(i).getClass(), "getBoxSizeX", cubeList.get(i)) : -1;
	}

	public int getboxSizeY(int i) {
		return cubeList != null
				&& cubeList.size() > i ? (Integer) Modchu_Reflect.invokeMethod(cubeList.get(i).getClass(), "getBoxSizeY", cubeList.get(i)) : -1;
	}

	public int getboxSizeZ(int i) {
		return cubeList != null
				&& cubeList.size() > i ? (Integer) Modchu_Reflect.invokeMethod(cubeList.get(i).getClass(), "getBoxSizeZ", cubeList.get(i)) : -1;
	}

}
