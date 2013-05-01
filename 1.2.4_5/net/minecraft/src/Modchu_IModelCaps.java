package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���f�����ʉ��p�C���^�[�t�F�[�X�B
 */
public interface Modchu_IModelCaps {

	/*
	 * �@�\���̌Q�A��芸���������Ă��邯�Ǖʂɔ��Ȃ���Ή��ł��ǂ��B
	 * �ꉞ�\��l���Ă��ƂŁB
	 */
	// ModelBase
	public static final int caps_onGround		= 0x0001;
	public static final int caps_isRiding		= 0x0002;
	public static final int caps_isChild		= 0x0003;
	// ModelBiped
	public static final int caps_heldItemLeft	= 0x0010;
	public static final int caps_heldItemRight	= 0x0011;
	public static final int caps_isSneak		= 0x0012;
	public static final int caps_aimedBow		= 0x0013;
	// littleMaid
	public static final int caps_isRendering	= 0x0100;
	public static final int caps_isBloodsuck	= 0x0101;
	public static final int caps_isFreedom		= 0x0102;
	public static final int caps_isTracer		= 0x0103;
	public static final int caps_isPlaying		= 0x0104;
	public static final int caps_isLookSuger	= 0x0105;
	public static final int caps_isBlocking		= 0x0106;
	public static final int caps_isWait			= 0x0107;
	public static final int caps_isWaitEX		= 0x0108;
	public static final int caps_isOpenInv		= 0x0109;
	public static final int caps_isWorking		= 0x010a;
	public static final int caps_isWorkingDelay	= 0x010b;
	public static final int caps_isContract		= 0x010c;
	public static final int caps_isContractEX	= 0x010d;
	public static final int caps_isRemainsC		= 0x010e;
	public static final int caps_isClock		= 0x010f;
	public static final int caps_isMasked		= 0x0110;
	public static final int caps_isCamouflage	= 0x0111;
	public static final int caps_isPlanter		= 0x0112;
	public static final int caps_entityIdFactor	= 0x0120;
	public static final int caps_height			= 0x0121;
	public static final int caps_width			= 0x0122;
	public static final int caps_YOffset		= 0x0123;
	public static final int caps_mountedYOffset	= 0x0124;
	public static final int caps_dominantArm	= 0x0125;
	public static final int caps_render			= 0x0130;
	public static final int caps_Arms			= 0x0131;
	public static final int caps_HeadMount		= 0x0132;
	public static final int caps_HardPoint		= 0x0133;
	public static final int caps_stabiliser		= 0x0134;
	public static final int caps_Items			= 0x0135;
	public static final int caps_Actions		= 0x0136;
	public static final int caps_Grounds		= 0x0137;
	public static final int caps_Inventory		= 0x0138;
	public static final int caps_interestedAngle	= 0x0150;

	// PlayerFormLittleMaid
	public static final int caps_ScaleFactor	= 0x0200;
	public static final int caps_PartsVisible	= 0x0201;
	public static final int caps_Posing			= 0x0202;
	public static final int caps_Actors			= 0x0203;

	/**
	 * ���f�����������Ă���@�\�����X�g�ɓ���ĕԂ��B
	 * @return
	 */
	public Map<String, Integer> getModelCaps();

	/**
	 * ���݂̐ݒ�l��ǂݎ��B
	 * @param pIndex
	 * @return
	 */
	public Object getCapsValue(int pIndex, Object ... pArg);
	public Object getCapsValue(String pCapsName, Object ... pArg);
	public int getCapsValueInt(int pIndex, Object ... pArg);
	public float getCapsValueFloat(int pIndex, Object ... pArg);
	public double getCapsValueDouble(int pIndex, Object ... pArg);
	public boolean getCapsValueBoolean(int pIndex, Object ... pArg);

	/**
	 * �@�\�ԍ��ɒl��ݒ肷��B
	 * @param pIndex
	 * @param pArg
	 * @return
	 */
	public boolean setCapsValue(int pIndex, Object ... pArg);
	public boolean setCapsValue(String pCapsName, Object ... pArg);

}
