package net.minecraft.src;

/**
 * モデル共通化用インターフェース。
 */
public interface Modchu_IModelCaps {

	public static final int caps_getIsSneak							= 0x08000;
	public static final int caps_getIsRiding								= 0x08001;
	public static final int caps_getIsWait								= 0x08002;
	public static final int caps_isSitting									= 0x08003;
	public static final int caps_isSleeping								= 0x08004;
	public static final int caps_firstPerson							= 0x08005;
	public static final int caps_oldwalking								= 0x08006;
	public static final int caps_motionY									= 0x08007;
	public static final int caps_showModelFlag						= 0x08008;
	public static final int caps_shortcutKeysAction				= 0x08009;
	public static final int caps_runActionNumber					= 0x08010;
	public static final int caps_skirtFloats								= 0x08011;
	public static final int caps_renderFirstPersonHand			= 0x08012;
	public static final int caps_bipedHead								= 0x08013;
	public static final int caps_bipedRightArm						= 0x08014;
	public static final int caps_notDominantArm						= 0x08015;
	public static final int caps_visible									= 0x08016;
	public static final int caps_Physical_Hammer					= 0x08017;
	public static final int caps_convertDegtoRad					= 0x08018;
	public static final int caps_texture									= 0x08019;
	public static final int caps_armorTexture							= 0x08020;
	public static final int caps_sneakBan								= 0x08021;
	public static final int caps_aimedBowBan							= 0x08022;
	public static final int caps_waitBan						 			= 0x08023;
	public static final int caps_sittingBan							 	= 0x08024;
	public static final int caps_sleepingBan							= 0x08025;
	public static final int caps_ridingBan								= 0x08026;
	public static final int caps_indexOfAllVisible						= 0x08027;
	public static final int caps_modchuRemodelingModel			= 0x08028;
	public static final int caps_actionSpeed						 	= 0x08029;
	public static final int caps_actionReverse					 	= 0x08030;
	public static final int caps_actionFlag								= 0x08031;
	public static final int caps_actionCount							= 0x08032;
	public static final int caps_armorType					 			= 0x08033;
	public static final int caps_isItemHolder							= 0x08034;
	public static final int caps_isPlayer									= 0x08035;
	public static final int caps_sittingyOffset							= 0x08036;
	public static final int caps_sleepingyOffset						= 0x08037;
	public static final int caps_model									= 0x08038;
	public static final int caps_changeModel							= 0x08039;
	public static final int caps_actionInit								= 0x08040;
	public static final int caps_actionRelease						= 0x08041;
	public static final int caps_syncModel								= 0x08042;
	public static final int caps_maidColor								= 0x08043;
	public static final int caps_getIsSleeping							= 0x08044;
	public static final int caps_armorItemInSlot						= 0x08045;
	public static final int caps_showModelSettingReflects		= 0x08046;
	public static final int caps_showPartsHideList					= 0x08047;
	public static final int caps_showPartsRenemeMap				= 0x08048;
	public static final int caps_textureName							= 0x08049;
	public static final int caps_textureArmorName					= 0x08050;
	public static final int caps_defaultShowPartsMap				= 0x08051;
	public static final int caps_showPartsMap						= 0x08052;
	public static final int caps_showPartsMapBoolean				= 0x08053;
	public static final int caps_modelRendererName				= 0x08054;
	public static final int caps_setLivingAnimationsBefore		= 0x08055;
	public static final int caps_setLivingAnimationsAfter			= 0x08056;
	public static final int caps_setRotationAnglesBefore			= 0x08057;
	public static final int caps_setRotationAnglesAfter			= 0x08058;
	public static final int caps_changeModelFlag					= 0x08059;
	public static final int caps_partsSetInit							= 0x08060;
	public static final int caps_partsSetFlag							= 0x08061;
	public static final int caps_shortcutKeysActionInitFlag		= 0x08062;
	public static final int caps_isActivated							= 0x08063;
	public static final int caps_initFlag									= 0x08064;
	public static final int caps_skinMode								= 0x08065;
	public static final int caps_modelScale							= 0x08066;
	public static final int caps_localFlag								= 0x08067;
	public static final int caps_isWaitF									= 0x08068;
	public static final int caps_isWaitFSetFlag						= 0x08069;
	public static final int caps_isWaitTime								= 0x08070;
	public static final int caps_mushroomConfusionCount		= 0x08071;
	public static final int caps_mushroomConfusionType			= 0x08072;
	public static final int caps_mushroomConfusionTypeMax	= 0x08073;
	public static final int caps_motionResetFlag						= 0x08074;
	public static final int caps_mushroomConfusionLeft			= 0x08075;
	public static final int caps_mushroomConfusionRight			= 0x08076;
	public static final int caps_mushroomConfusionFront		= 0x08077;
	public static final int caps_mushroomConfusionBack			= 0x08078;
	public static final int caps_motionSetFlag						= 0x08079;
	public static final int caps_mushroomBack						= 0x08080;
	public static final int caps_mushroomForward					= 0x08081;
	public static final int caps_mushroomLeft						= 0x08082;
	public static final int caps_mushroomRight						= 0x08083;
	public static final int caps_changeColor							= 0x08084;
	public static final int caps_showPartsSetting					= 0x08085;

	public Object getCapsValue(MultiModelBaseBiped model, int pIndex, Object ...pArg);

	public boolean setCapsValue(MultiModelBaseBiped model, int pIndex, Object... pArg);
}
