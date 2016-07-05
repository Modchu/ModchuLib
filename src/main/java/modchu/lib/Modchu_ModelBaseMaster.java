package modchu.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modchu.model.multimodel.base.MultiModelCustom;

public abstract class Modchu_ModelBaseMaster implements Modchu_IEntityCapsBase, Modchu_IModelBaseMaster {
	public Modchu_IModelBase base;
	public static final float PI = (float)Math.PI;
	public int textureWidth = 64;
	public int textureHeight = 32;
	public float onGrounds[] = new float[] {0.0F, 0.0F};
	public int dominantArm = 0;
	public boolean isRiding = false;
	public boolean isChild = true;
	public List boxList = new ArrayList();
	//private Map<String, Object> modelTextureMap = new HashMap();

	public boolean aimedBow;
	public boolean isSneak;
	public boolean isWait;
	public float entityIdFactor;
	public int entityTicksExisted;
	public float scaleFactor = 0.9375F;

	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		render(entity, par2, par3, par4, par5, par6, par7, true);
	}

	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7, boolean pIsRender) {
	}

	public Object getRandomModelBox(Random par1Random) {
		// 膝に矢を受けてしまってな・・・
		int j = par1Random.nextInt(boxList.size());
		Object modelRenderer = boxList.get(j);
		for (int i = 0; i < boxList.size(); i++) {
			List cubeList = Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(modelRenderer.getClass(), "cubeList", modelRenderer));
			if (cubeList != null
					&& !cubeList.isEmpty()) {
				break;
			}
			// 箱がない
			if (++j >= boxList.size()) {
				j = 0;
			}
			modelRenderer = boxList.get(j);
		}
		return modelRenderer;
	}
/*
	public void setTextureOffset(String par1Str, int par2, int par3) {
		modelTextureMap.put(par1Str, Modchu_Reflect.newInstance("TextureOffset", new Class[]{ int.class, int.class }, new Object[]{ par2, par3 }));
	}

	public Object getTextureOffset(String par1Str) {
		return modelTextureMap.get(par1Str);
	}
*/

	// MathHelperトンネル関数群

	public static final float mh_sin(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return Modchu_AS.getFloat(Modchu_AS.mathHelperSin, f);
	}

	public static final float mh_cos(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return Modchu_AS.getFloat(Modchu_AS.mathHelperCos, f);
	}

	public static final float mh_sqrt_float(float f) {
		return Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_float, f);
	}

	public static final float mh_sqrt_double(double d) {
		return Modchu_AS.getFloat(Modchu_AS.mathHelperSqrt_double, d);
	}

	public static final int mh_floor_float(float f) {
		return Modchu_AS.getInt(Modchu_AS.mathHelperFloor_float, f);
	}

	public static final int mh_floor_double(double d) {
		return Modchu_AS.getInt(Modchu_AS.mathHelperFloor_double, d);
	}

	public static final long mh_floor_double_long(double d) {
		return Modchu_AS.getLong(Modchu_AS.mathHelperFloor_double_long, d);
	}

	public static final float mh_abs(float f) {
		return Modchu_AS.getFloat(Modchu_AS.mathHelperAbs, f);
	}

	public static final double mh_abs_max(double d, double d1) {
		return Modchu_AS.getDouble(Modchu_AS.mathHelperAbs_max, d, d1);
	}

	public static final int mh_bucketInt(int i, int j) {
		return Modchu_AS.getInt(Modchu_AS.mathHelperBucketInt, i, j);
	}

	public static final boolean mh_stringNullOrLengthZero(String s) {
		return Modchu_AS.getBoolean(Modchu_AS.mathHelperStringNullOrLengthZero, s);
	}

	public static final int mh_getRandomIntegerInRange(Random random, int i, int j) {
		return Modchu_AS.getInt(Modchu_AS.mathHelperGetRandomIntegerInRange, random, i, j);
	}
	// 独自定義関数群
	/**
	 * モデルの初期化コード
	 */
	public abstract void initModel(float psize, float pyoffset, Object... o);

	/**
	 * アーマーモデルのサイズを返す。
	 * サイズは内側のものから。
	 */
	public abstract float[] getArmorModelsSize();

	/**
	 * モデル指定詞に依らずに使用するテクスチャパック名。
	 * 一つのテクスチャに複数のモデルを割り当てる時に使う。
	 * @return
	 */
	public String getUsingTexture() {
		return null;
	}

	/**
	 *  身長
	 */
	public abstract float getHeight(Modchu_IEntityCapsBase entityCaps);

	/**
	 * 横幅
	 */
	public abstract float getWidth(Modchu_IEntityCapsBase entityCaps);

	/**
	 * モデルのYオフセット
	 */
	public abstract float getYOffset(Modchu_IEntityCapsBase entityCaps);

	/**
	 * 上に乗せる時のオフセット高
	 */
	public abstract float getMountedYOffset(Modchu_IEntityCapsBase entityCaps);

	/**
	 * ロープの取り付け位置調整用
	 */
	public abstract float getLeashOffset(Modchu_IEntityCapsBase entityCaps);

	/**
	 * アイテムを持っているときに手を前に出すかどうか。
	 */
	public abstract boolean isItemHolder(Modchu_IEntityCapsBase entityCaps);

	/**
	 * 表示すべきすべての部品
	 */
	public abstract void showAllParts(Modchu_IEntityCapsBase entityCaps);

	/**
	 * 部位ごとの装甲表示。
	 * @param parts
	 * 3:頭部。
	 * 2:胴部。
	 * 1:脚部
	 * 0:足部
	 * @param index
	 * 0:inner
	 * 1:outer
	 * @return
	 * 戻り値は基本 -1
	 */
	public int showArmorParts(Modchu_IEntityCapsBase entityCaps, int parts, int index) {
		return -1;
	}

	/**
	 * ハードポイントに接続されたアイテムを表示する
	 */
	public abstract void renderItems(Modchu_IEntityCapsBase entityCaps);

	/**
	 * プレイヤーモデル設定時に通常視点＆素手状態で呼ばれる
	 */
	public abstract void renderFirstPersonHand(Modchu_IEntityCapsBase entityCaps, int i);

	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_onGround:
			return onGrounds;
		case caps_isRiding:
			return isRiding;
		case caps_isSneak:
			return isSneak;
		case caps_isWait:
			return isWait;
		case caps_isChild:
			return isChild;
		case caps_aimedBow:
			return aimedBow;
		case caps_entityIdFactor:
			return entityIdFactor;
		case caps_ticksExisted:
			return entityTicksExisted;
		case caps_ScaleFactor:
			return scaleFactor;
		case caps_dominantArm:
			return dominantArm;
		}
		return null;
	}

	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_Ground:
		case caps_Grounds:
		case caps_onGround:
			for (int li = 0; li < onGrounds.length && li < pArg.length; li++) {
				onGrounds[li] = (Float)pArg[li];
			}
			return true;
		case caps_isRiding:
			isRiding = (Boolean)pArg[0];
			return true;
		case caps_isSneak:
			isSneak = (Boolean)pArg[0];
			return true;
		case caps_isWait:
			isWait = (Boolean)pArg[0];
			return true;
		case caps_isChild:
			isChild = (Boolean)pArg[0];
			return true;
		case caps_aimedBow:
			aimedBow = (Boolean)pArg[0];
			return true;
		case caps_entityIdFactor:
			entityIdFactor = (Float)pArg[0];
			return true;
		case caps_ticksExisted:
			entityTicksExisted = (Integer)pArg[0];
			return true;
		case caps_ScaleFactor:
			scaleFactor = (Float)pArg[0];
			return true;
		case caps_dominantArm:
			dominantArm = (Integer)pArg[0];
		}
		return false;
	}

	public boolean canSpawnHear(Object world, int pX, int pY, int pZ) {
		return true;
	}

	/**
	 * 通常のレンダリング前に呼ばれる。
	 * @return falseを返すと通常のレンダリングをスキップする。
	 */
	public boolean preRender(Modchu_IEntityCapsBase entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
		return true;
	}

	/**
	 * 通常のレンダリング後に呼ぶ。 基本的に装飾品などの自律運動しないパーツの描画用。
	 */
	public void renderExtention(Modchu_IEntityCapsBase entityCaps, float par2, float par3, float par4, float par5, float par6, float par7) {
	}

	/**
	 * モデル切替時に実行されるコード
	 */
	public void changeModel(Modchu_IEntityCapsBase entityCaps) {
		// カウンタ系の加算値、リミット値の設定など行う予定。
	}

	public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, Modchu_IEntityCapsBase entityCaps) {
	}

	public float[] getTextureLightColor(Modchu_IEntityCapsBase entityCaps) {
		return null;
	}

}