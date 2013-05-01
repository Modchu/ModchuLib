package net.minecraft.src;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import javax.crypto.spec.PSource;

import org.lwjgl.opengl.GL11;

/**
 * ����̐l�^���f���u�������n�̋��ʃN���X
 */
public abstract class Modchu_ModelBiped extends ModelBiped implements Modchu_IModelCaps {

	/**
	 * �A�C�e���\���΍�
	 */
	public boolean isRendering = true;
	public boolean isWait;
	public Modchu_ModelRenderer Arms[];
	public Modchu_ModelRenderer HeadMount;
	public Modchu_ModelRenderer HardPoint[];

	public Render render;
	public Map<String, Modchu_EquippedStabilizer> stabiliser;
	public float scaleFactor = 0.9375F;
	public float entityIdFactor;
	protected Modchu_IModelCaps modelCaps;


	/**
	 * ���f���������Ă���@�\�Q
	 */
	private final Map<String, Integer> capsmap = new HashMap<String, Integer>() {{
		put("onGround",			caps_onGround);
		put("isRiding",			caps_isRiding);
		put("isSneak",			caps_isSneak);
		put("isWait",			caps_isWait);
		put("isChild",			caps_isChild);
		put("heldItemLeft",		caps_heldItemLeft);
		put("heldItemRight",	caps_heldItemRight);
		put("aimedBow",			caps_aimedBow);
		put("ScaleFactor", 		caps_ScaleFactor);
		put("entityIdFactor", 	caps_entityIdFactor);
	}};

	/**
	 * �R���X�g���N�^�͑S�Čp�������邱��
	 */
	public Modchu_ModelBiped() {
		this(0.0F);
	}
	/**
	 * �R���X�g���N�^�͑S�Čp�������邱��
	 */
	public Modchu_ModelBiped(float psize) {
		this(psize, 0.0F);
	}
	/**
	 * �R���X�g���N�^�͑S�Čp�������邱��
	 */
	public Modchu_ModelBiped(float psize, float pyoffset) {
		super();

		heldItemLeft = 0;
		heldItemRight = 0;
		isSneak = false;
		aimedBow = false;

		// �n�[�h�|�C���g
		Arms = new Modchu_ModelRenderer[2];
		HeadMount = new Modchu_ModelRenderer(this, "HeadMount");

		boxList.clear();
		initModel(psize, pyoffset);
		checkParents();
	}

	protected void checkParents() {
		for (int li = 0; li < boxList.size(); li++) {
			ModelRenderer lmr = (ModelRenderer)boxList.get(li);
			if (lmr.childModels != null) {
				for (int lj = 0; lj < lmr.childModels.size(); lj++) {
					ModelRenderer lmc = (ModelRenderer)lmr.childModels.get(lj);
					if (lmc instanceof Modchu_ModelRenderer) {
						((Modchu_ModelRenderer)lmc).pearent = lmr;
					}
				}
			}
		}
	}

	/**
	 * ���f���̏������R�[�h
	 */
	public abstract void initModel(float psize, float pyoffset);

	/**
	 * �A�[�}�[���f���̃T�C�Y��Ԃ��B
	 * �T�C�Y�͓����̂��̂���B
	 */
	public abstract float[] getArmorModelsSize();

	/**
	 * ���f���ؑ֎��Ɏ��s�����R�[�h
	 */
	public void changeModel(EntityLiving pentity) {
		// �J�E���^�n�̉��Z�l�A���~�b�g�l�̐ݒ�ȂǍs���\��B

	}

	/**
	 * �n�[�h�|�C���g�ɐڑ����ꂽ�A�C�e����\������
	 */
	public abstract void renderItems(EntityLiving pEntity, Render pRender);

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		if (preRender(par1Entity, par2, par3, par4, par5, par6, par7)) {
			this.setRotationAngles(par2, par3, par4, par5, par6, par7);
			this.bipedHead.render(par7);
			this.bipedBody.render(par7);
			this.bipedRightArm.render(par7);
			this.bipedLeftArm.render(par7);
			this.bipedRightLeg.render(par7);
			this.bipedLeftLeg.render(par7);
			this.bipedHeadwear.render(par7);
		}
		renderExtention(par1Entity, par2, par3, par4, par5, par6, par7);
		renderStabilizer(par1Entity, stabiliser, par2, par3, par4, par5, par6, par7);
	}

	/**
	 * �ʏ�̃����_�����O�O�ɌĂ΂��B
	 *
	 * @return false��Ԃ��ƒʏ�̃����_�����O���X�L�b�v����B
	 */
	public boolean preRender(Entity par1Entity, float par2, float par3,
			float par4, float par5, float par6, float par7) {
		return true;
	}

	/**
	 * �ʏ�̃����_�����O��ɌĂԁB ��{�I�ɑ����i�Ȃǂ̎����^�����Ȃ��p�[�c�̕`��p�B
	 */
	public void renderExtention(Entity par1Entity, float par2, float par3,
			float par4, float par5, float par6, float par7) {
	}

	/**
	 * �X�^�r���C�U�[�̕`��B �����ł͌Ă΂�Ȃ��̂�render���ŌĂԕK�v������܂��B
	 */
	protected void renderStabilizer(Entity pEntity,
			Map<String, Modchu_EquippedStabilizer> pmap, float par2, float par3,
			float par4, float par5, float par6, float par7) {
		// �X�^�r���C�U�[�̕`��AdoRender�̕����������H
		if (pmap == null || pmap.isEmpty() || render == null)
			return;

		GL11.glPushMatrix();
		for (Entry<String, Modchu_EquippedStabilizer> le : pmap.entrySet()) {
			Modchu_EquippedStabilizer les = le.getValue();
			if (les != null && les.equipPoint != null) {
				Modchu_ModelStabilizerBase lsb = les.stabilizer;
				if (lsb.isLoadAnotherTexture()) {
					render.loadTexture(lsb.getTexture());
				}
				les.equipPoint.loadMatrix();
				lsb.render((MultiModelBaseBiped) this, pEntity, par2, par3, par4, par5, par6, par7);
			}
		}
		GL11.glPopMatrix();
	}

	/**
	 * �����_���Ńp�[�c��Ԃ��B
	 */
	public ModelRenderer func_85181_a(Random par1Random) {
		// �G�ɖ���󂯂Ă��܂��ĂȁE�E�E
		int li = par1Random.nextInt(this.boxList.size());
		ModelRenderer lmr = (ModelRenderer)this.boxList.get(li);
		for (int lj = 0; lj < boxList.size(); lj++) {
			if (!lmr.cubeList.isEmpty()) {
				break;
			}
			// �����Ȃ�
			if (++li >= boxList.size()) {
				li = 0;
			}
			lmr = (ModelRenderer)this.boxList.get(li);
		}
		return lmr;
	}


	/**
	 *  �g��
	 */
	public abstract float getHeight();
	/**
	 * ����
	 */
	public abstract float getWidth();
	/**
	 * ���f����Y�I�t�Z�b�g
	 * PF�p�B
	 */
	public abstract float getyOffset();

	public boolean isItemHolder() {
		// �A�C�e���������Ă���Ƃ��Ɏ��O�ɏo�����ǂ����B
		return false;
	}

	public void showAllParts() {
		// �\�����ׂ����ׂĂ̕��i
	}

	public int showArmorParts(int parts) {
		// ���ʂ��Ƃ̑��b�\��
		// 3:����
		// 2:����
		// 1:�r��
		// 0:����
		// �߂�l�͊�{ -1
		return -1;
	}

	@Override
	public Map<String, Integer> getModelCaps() {
		return capsmap;
	}

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		switch (pIndex) {
		case caps_onGround:
			return onGround;
		case caps_isRiding:
			return isRiding;
		case caps_isSneak:
			return isSneak;
		case caps_isWait:
			return isWait;
		case caps_isChild:
			return isChild;
		case caps_heldItemLeft:
			return heldItemLeft;
		case caps_heldItemRight:
			return heldItemRight;
		case caps_aimedBow:
			return aimedBow;
		case caps_ScaleFactor:
			return scaleFactor;
		case caps_entityIdFactor:
			return entityIdFactor;
		}
		return null;
	}
	@Override
	public Object getCapsValue(String pCapsName, Object ...pArg) {
		return getCapsValue(capsmap.get(pCapsName), pArg);
	}
	@Override
	public int getCapsValueInt(int pIndex, Object ...pArg) {
		Integer li = (Integer)getCapsValue(pIndex, pArg);
		return li == null ? 0 : li;
	}
	@Override
	public float getCapsValueFloat(int pIndex, Object ...pArg) {
		Float lf = (Float)getCapsValue(pIndex, pArg);
		return lf == null ? 0F : lf;
	}
	@Override
	public double getCapsValueDouble(int pIndex, Object ...pArg) {
		Double ld = (Double)getCapsValue(pIndex, pArg);
		return ld == null ? 0D : ld;
	}
	@Override
	public boolean getCapsValueBoolean(int pIndex, Object ...pArg) {
		Boolean lb = (Boolean)getCapsValue(pIndex, pArg);
		return lb == null ? false : lb;
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_onGround:
			onGround = (Float)pArg[0];
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
		case caps_heldItemLeft:
			heldItemLeft = (Integer)pArg[0];
			return true;
		case caps_heldItemRight:
			heldItemRight = (Integer)pArg[0];
			return true;
		case caps_aimedBow:
			aimedBow = (Boolean)pArg[0];
			return true;
		case caps_ScaleFactor:
			scaleFactor = (Float)pArg[0];
			return true;
		case caps_entityIdFactor:
			entityIdFactor = (Float)pArg[0];
			return true;
		}

		return false;
	}
	@Override
	public boolean setCapsValue(String pCapsName, Object... pArg) {
		return setCapsValue(capsmap.get(pCapsName), pArg);
	}

	/**
	 * Renderer�ӂł��̕ϐ���ݒ肷��B
	 * �ݒ�l��Modchu_IModelCaps���p������Entitiy�Ƃ���z��B
	 */
	public void setModelCaps(Modchu_IModelCaps pModelCaps) {
		modelCaps = pModelCaps;
	}

	// MathHelper�g���l���֐��Q
	public static final float mh_sin(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return MathHelper.sin(f);
	}

	public static final float mh_cos(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return MathHelper.cos(f);
	}

	public static final float mh_sqrt_float(float f) {
		return MathHelper.sqrt_float(f);
	}

	public static final float mh_sqrt_double(double d) {
		return MathHelper.sqrt_double(d);
	}

	public static final int mh_floor_float(float f) {
		return MathHelper.floor_float(f);
	}

	public static final int mh_floor_double(double d) {
		return MathHelper.floor_double(d);
	}

	public static final long mh_floor_double_long(double d) {
		return MathHelper.floor_double_long(d);
	}

	public static final float mh_abs(float f) {
		return MathHelper.abs(f);
	}

	public static final double mh_abs_max(double d, double d1) {
		return MathHelper.abs_max(d, d1);
	}

	public static final int mh_bucketInt(int i, int j) {
		return MathHelper.bucketInt(i, j);
	}

	public static final boolean mh_stringNullOrLengthZero(String s) {
		return MathHelper.stringNullOrLengthZero(s);
	}

	public static final int mh_getRandomIntegerInRange(Random random, int i,
			int j) {
		return MathHelper.getRandomIntegerInRange(random, i, j);
	}

}
