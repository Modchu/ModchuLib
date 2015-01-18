package modchu.lib;

import java.lang.reflect.Constructor;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_ModelBoxBase;
import modchu.model.ModchuModel_ModelPlate;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Modchu_ModelRendererBase {

	// ModelRenderer互換変数群
	public float textureWidth;
	public float textureHeight;
	private int textureOffsetX;
	private int textureOffsetY;
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
	public List<Modchu_ModelBoxBase> cubeList;
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

	public Modchu_ModelRendererBase(Object pModelBase, String pName) {
		textureWidth = 64.0F;
		textureHeight = 32.0F;
		compiled = false;
		displayList = 0;
		mirror = false;
		showModel = true;
		isHidden = false;
		isRendering = true;
		cubeList = new ArrayList<Modchu_ModelBoxBase>();
		baseModel = pModelBase;
		List boxList = Modchu_AS.getList(Modchu_AS.modelBaseBoxList, pModelBase);
		boxList.add(this);
		boxName = pName;
		setTextureSize(Modchu_AS.getInt(Modchu_AS.modelBaseTextureWidth, pModelBase), Modchu_AS.getInt(Modchu_AS.modelBaseTextureHeight, pModelBase));

		rotatePriority = RotXYZ;
		itemStack = null;
		adjust = true;
		matrix = BufferUtils.createFloatBuffer(16);
		isInvertX = false;

		scaleX = 1.0F;
		scaleY = 1.0F;
		scaleZ = 1.0F;

		pearent = null;
	}

	public Modchu_ModelRendererBase(Object modelBase, int px, int py) {
		this(modelBase, null);
		setTextureOffset(px, py);
	}

	public Modchu_ModelRendererBase(Object pModelBase) {
		this(pModelBase, (String)null);
	}

	public Modchu_ModelRendererBase(Object pModelBase, int px, int py, float pScaleX, float pScaleY, float pScaleZ) {
		this(pModelBase, px, py);
		this.scaleX = pScaleX;
		this.scaleY = pScaleY;
		this.scaleZ = pScaleZ;
	}

	public Modchu_ModelRendererBase(Object pModelBase, float pScaleX, float pScaleY, float pScaleZ) {
		this(pModelBase);
		this.scaleX = pScaleX;
		this.scaleY = pScaleY;
		this.scaleZ = pScaleZ;
	}

	// ModelRenderer互換関数群

	public void addChild(Modchu_ModelRendererBase pModelRenderer) {
		if (childModels == null) {
			childModels = new ArrayList<Modchu_ModelRendererBase>();
		}
		childModels.add(pModelRenderer);
		pModelRenderer.pearent = this;
	}

	public Modchu_ModelRendererBase setTextureOffset(int pOffsetX, int pOffsetY) {
		textureOffsetX = pOffsetX;
		textureOffsetY = pOffsetY;
		return this;
	}

	public Modchu_ModelRendererBase addBox(String pName, float pX, float pY, float pZ,
			int pWidth, int pHeight, int pDepth) {
		addParts(Modchu_ModelBox.class, pName, pX, pY, pZ, pWidth, pHeight, pDepth, 0.0F);
		return this;
	}

	public Modchu_ModelRendererBase addBox(float pX, float pY, float pZ,
			int pWidth, int pHeight, int pDepth) {
		addParts(Modchu_ModelBox.class, pX, pY, pZ, pWidth, pHeight, pDepth, 0.0F);
		return this;
	}

	public Modchu_ModelRendererBase addBox(float pX, float pY, float pZ,
			int pWidth, int pHeight, int pDepth, float pSizeAdjust) {
		addParts(Modchu_ModelBox.class, pX, pY, pZ, pWidth, pHeight, pDepth, pSizeAdjust);
		return this;
	}

	public Modchu_ModelRendererBase setRotationPoint(float pX, float pY, float pZ) {
		rotationPointX = pX;
		rotationPointY = pY;
		rotationPointZ = pZ;
		return this;
	}

	public void render(float par1, boolean pIsRender) {
		if (isHidden) return;
		if (!showModel) return;

		if (!compiled) {
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(offsetX, offsetY, offsetZ);

		if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			setRotation();
		}
		renderObject(par1, pIsRender);
		GL11.glPopMatrix();
	}
	public void render(float par1) {
		render(par1, true);
	}

	public void renderWithRotation(float par1) {
		if (isHidden) return;
		if (!showModel) return;

		if (!compiled) {
			compileDisplayList(par1);
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);

		setRotation();

		GL11.glCallList(displayList);
		GL11.glPopMatrix();
	}

	public void postRender(float par1) {
		if (isHidden) return;
		if (!showModel) return;

		if (!compiled) {
			compileDisplayList(par1);
		}

		if (pearent != null) {
			pearent.postRender(par1);
		}

		GL11.glTranslatef(offsetX, offsetY, offsetZ);

		if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			setRotation();
		}
	}

	protected void compileDisplayList(float par1) {
		displayList = Modchu_AS.getInt(Modchu_AS.gLAllocationGenerateDisplayLists, 1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		Object tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);

		for (int i = 0; i < cubeList.size(); i++) {
			((Modchu_ModelBoxBase) cubeList.get(i)).render(tessellator, par1);
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
	public Modchu_ModelRendererBase addCubeList(Modchu_ModelBoxBase object) {
		cubeList.add(object);
		return this;
	}

	protected Modchu_ModelBox getModelBoxBase(Class pModelBoxBase, Object ... pArg) {
		try {
			Constructor<Modchu_ModelBox> lconstructor =
					pModelBoxBase.getConstructor(Modchu_ModelRendererBase.class, Object[].class);
			return lconstructor.newInstance(this, pArg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected Object[] getArg(Object ... pArg) {
		Object lobject[] = new Object[pArg.length + 2];
		lobject[0] = textureOffsetX;
		lobject[1] = textureOffsetY;
		for (int li = 0; li < pArg.length; li++) {
			lobject[2 + li] = pArg[li];
		}
		return lobject;
	}

	public Modchu_ModelRendererBase addParts(Class pModelBoxBase, Object ... pArg) {
		addCubeList(getModelBoxBase(pModelBoxBase, getArg(pArg)));
		return this;
	}

	/**
	 * 自分でテクスチャの座標を指定する時に使います。
	 * コンストラクタへそのまま値を渡します。
	 */
	public Modchu_ModelRendererBase addPartsTexture(Class pModelBoxBase, String pName, Object ... pArg) {
		pName = (new StringBuilder()).append(boxName).append(".").append(pName).toString();
		addCubeList(((Modchu_ModelBox) getModelBoxBase(pModelBoxBase, pArg)).setBoxName(pName));
		return this;
	}

	/**
	 * 自分でテクスチャの座標を指定する時に使います。
	 * コンストラクタへそのまま値を渡します。
	 */
	public Modchu_ModelRendererBase addPartsTexture(Class pModelBoxBase, Object ... pArg) {
		addCubeList(getModelBoxBase(pModelBoxBase, pArg));
		return this;
	}


	public Modchu_ModelRendererBase addPlate(float pX, float pY, float pZ,
			int pWidth, int pHeight, int pFacePlane) {
		addParts(ModchuModel_ModelPlate.class, pX, pY, pZ, pWidth, pHeight, pFacePlane, 0.0F);
		return this;
	}

	public Modchu_ModelRendererBase addPlate(float pX, float pY, float pZ,
			int pWidth, int pHeight, int pFacePlane, float pSizeAdjust) {
		addParts(ModchuModel_ModelPlate.class, pX, pY, pZ, pWidth, pHeight, pFacePlane, pSizeAdjust);
		return this;
	}

	public Modchu_ModelRendererBase addPlate(String pName, float pX, float pY, float pZ,
			int pWidth, int pHeight, int pFacePlane) {
		addParts(ModchuModel_ModelPlate.class, pName, pX, pY, pZ, pWidth, pHeight, pFacePlane, 0.0F);
		return this;
	}

	/**
	 * 描画用のボックス、子供をクリアする
	 */
	public void clearCubeList() {
		cubeList.clear();
		compiled = false;
		if (childModels != null) {
			childModels.clear();
		}
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
	protected void setRotation() {
		// 変換順位の設定
		switch (rotatePriority) {
		case RotXYZ:
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotXZY:
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotYXZ:
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotYZX:
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotZXY:
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		case RotZYX:
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		}
	}

	/**
	 * 内部実行用、レンダリング部分。
	 */
	protected void renderObject(float par1, boolean pRendering) {
		// レンダリング、あと子供も
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix);
		if (pRendering && isRendering) {
			GL11.glPushMatrix();
			GL11.glScalef(scaleX, scaleY, scaleZ);
			GL11.glCallList(displayList);
			GL11.glPopMatrix();
		}

		if (childModels != null) {
			for (int li = 0; li < childModels.size(); li++) {
				childModels.get(li).render(par1, pRendering);
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

}
