package net.minecraft.src;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

/**
 * PlayerFormLittleMaid共通クラス
 */
public abstract class MultiModelBaseBiped extends MMM_ModelBiped {

    public static final int caps_getOnGround = 0x0204;
    public static final int caps_setOnGround = 0x0205;
    public static final int caps_getIsSneak = 0x0206;
    public static final int caps_getIsRiding = 0x0207;
    public static final int caps_getaimedBow = 0x0208;
    public static final int caps_getIsWait = 0x0209;
    public static final int caps_getIsSitting = 0x0210;
    public static final int caps_getIsSleeping = 0x0211;
    public static final int caps_getFirstPerson = 0x0212;
    public static final int caps_getOldwalking = 0x0213;
    public static final int caps_setOldwalking = 0x0214;
    public static final int caps_getIsPlayer = 0x0215;
    public static final int caps_setIsPlayer = 0x0216;
    public static final int caps_getMotionY = 0x0217;
    public static final int caps_setMotionY = 0x0218;
    public static final int caps_getPartsSetFlag = 0x0219;
    public static final int caps_getShowModelFlag = 0x0220;
    public static final int caps_setShowModelFlag = 0x0221;
    public static final int caps_setPartsSetFlag = 0x0222;
    public static final int caps_getShortcutKeysAction = 0x0223;
    public static final int caps_setShortcutKeysAction = 0x0224;
    public static final int caps_getRunActionNumber = 0x0225;
    public static final int caps_setRunActionNumber = 0x0226;
    public static final int caps_setIsWait = 0x0227;
    public static final int caps_getSkirtFloats = 0x0228;
    public static final int caps_renderFirstPersonHand = 0x0229;
    public static final int caps_getBipedHead = 0x0230;
    public static final int caps_getBipedRightArm = 0x0231;
    public static final int caps_getNotDominantArm = 0x0232;
    public static final int caps_getHandedness = 0x0233;
    public static final int caps_setVisible = 0x0234;
    public static final int caps_Physical_Hammer = 0x0235;
    public static final int caps_getIsLookSuger = 0x0236;
    public static final int caps_getEntityIdFactor = 0x0237;
    public static final int caps_getIsInventory = 0x0238;
    public static final int caps_convertDegtoRad = 0x0239;
    public static final int caps_shiftArray = 0x0240;
    public static final int caps_getClassName = 0x0241;
    //public static final int caps_getTextureNameList = 0x0242;
    public static final int caps_getTextureList = 0x0243;
    public static final int caps_getMaidColor = 0x0244;
    public static final int caps_getTexture = 0x0245;
    public static final int caps_getPastX = 0x0246;
    public static final int caps_getPastY = 0x0247;
    public static final int caps_getPastZ = 0x0248;
    public static final int caps_setPastX = 0x0249;
    public static final int caps_setPastY = 0x0250;
    public static final int caps_setPastZ = 0x0251;
    public static final int caps_getSneakBan = 0x0252;
    public static final int caps_getAimedBowBan = 0x0253;
    public static final int caps_getWaitBan = 0x0254;
    public static final int caps_getSittingBan = 0x0255;
    public static final int caps_getSleepingBan = 0x0256;
    public static final int caps_getRidingBan = 0x0257;
    public static final int caps_setSneakBan = 0x0258;
    public static final int caps_setAimedBowBan = 0x0259;
    public static final int caps_setWaitBan = 0x0260;
    public static final int caps_setSittingBan = 0x0261;
    public static final int caps_setSleepingBan = 0x0262;
    public static final int caps_setRidingBan = 0x0263;
    public static final int caps_indexOfAllSetVisible = 0x0264;
    public static final int caps_getModchuRemodelingModel = 0x0265;
    public static final int caps_setModchuRemodelingModel = 0x0266;
    public static final int caps_getActionSpeed = 0x0267;
    public static final int caps_getActionReverse = 0x0268;
    public static final int caps_setActionSpeed = 0x0269;
    public static final int caps_setActionReverse = 0x0270;
    public static final int caps_setHandedness = 0x0271;
    public static final int caps_setIsInventory = 0x0272;
    public static final int caps_getActionFlag = 0x0273;
    public static final int caps_setActionFlag = 0x0274;
    public static final int caps_getActionCount = 0x0275;
    public static final int caps_setActionCount = 0x0276;
    public static final int caps_setFirstPerson = 0x0277;
    public static final int caps_getArmorType = 0x0278;
    public static final int caps_setArmorType = 0x0279;
    public static final int caps_setIsSleeping = 0x0280;
    public static final int caps_setIsRiding = 0x0281;
    public static final int caps_setIsSitting = 0x0282;
    public ModelRenderer rightArm;
    public ModelRenderer rightArm2;
    public ModelRenderer rightArmPlus;
    public ModelRenderer rightArmPlus2;
    public ModelRenderer rightHand;
    public ModelRenderer rightLeg;
    public ModelRenderer rightLeg2;
    public ModelRenderer rightLegPlus;
    public ModelRenderer rightLegPlus2;
    public ModelRenderer leftArm;
    public ModelRenderer leftArm2;
    public ModelRenderer leftArmPlus;
    public ModelRenderer leftArmPlus2;
    public ModelRenderer leftHand;
    public ModelRenderer leftLeg;
    public ModelRenderer leftLeg2;
    public ModelRenderer leftLegPlus;
    public ModelRenderer leftLegPlus2;
    public ModelRenderer Arms[];
    public ModelRenderer HeadMount;
    public ModelRenderer mainFrame;
    private static Minecraft mc = Minecraft.getMinecraft();
    private static int partsSetFlag = 1;
    private static int showModelFlag = 0;
    private static int overridePartsNumber = 0;
    private static int handedness = -2;
    private int runActionNumber = 0;
    private int actionCount = 0;
    private int armorType = 0;
    private float motionY = 0.0F;
    private float actionSpeed = 0.0F;
    private float[] pastX = new float[10];
    private float[] pastY = new float[10];
    private float[] pastZ = new float[10];
    private boolean isSitting = false;
    private boolean isSleeping = false;
    private boolean oldwalking = false;
    private boolean isInventory = false;
    private boolean firstPerson = false;
    private boolean isPlayer = false;
    private boolean shortcutKeysAction = false;
    private boolean actionReverse = false;
    private boolean sneakBan = false;
    private boolean aimedBowBan = false;
    private boolean waitBan = false;
    private boolean sittingBan = false;
    private boolean sleepingBan = false;
    private boolean ridingBan = false;
    private boolean modchuRemodelingModel = false;
    private boolean actionFlag = false;
    private static boolean isLMM = false;
    private static boolean isPFLM = false;
    private static boolean skirtFloats = false;
    private boolean partsSetInit = false;
    private boolean oldRenderItems = false;
    private List<String> showPartsList = new ArrayList<String>();
    private List<String> showPartsHideList = new ArrayList<String>();
    private HashMap<String, Field> modelRendererMap = new HashMap();
    //private LinkedList<String> textureNameList = new LinkedList<String>();
    private LinkedList<String> textureList = new LinkedList<String>();
    public static Class mod_PFLM_PlayerFormLittleMaid;
    public static Class PFLM_Gui;
    public static Class PFLM_GuiModelSelect;
    public static Class PFLM_GuiOthersPlayer;
    public static Class PFLM_GuiOthersPlayerIndividualCustomize;
    public static Class PFLM_EntityPlayerDummy;
    public static Class PFLM_RenderPlayer;
    public static Class mod_LMM_littleMaidMob;
    public static Class LMM_EntityLittleMaid;
    public static Class MMM_TextureManager;
/*//125delete
    public Entity entity;
*///125delete
/*//b181delete
    public int textureWidth = Modchu_ModelRenderer.textureWidthPFLM;
    public int textureHeight = Modchu_ModelRenderer.textureHeightPFLM;
    public boolean field_40333_u;
    private Map modelTextureMap = new HashMap();
*///b181delete
    //b173deletepublic List boxList;

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelBaseBiped() {
    	this(0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelBaseBiped(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public MultiModelBaseBiped(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    public MultiModelBaseBiped(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset);
    	textureWidth = par3;
    	textureHeight = par4;
    	//b173deleteboxList = new ArrayList();

    	mod_LMM_littleMaidMob = mod_Modchu_ModchuLib.mod_LMM_littleMaidMob;
    	if (mod_LMM_littleMaidMob != null) {
    		isLMM = true;
    		LMM_EntityLittleMaid = mod_Modchu_ModchuLib.LMM_EntityLittleMaid;
    		List list = ModLoader.getLoadedMods();
    		Object instance = null;
    		BaseMod mod;
    		for(int i = 0; i < list.size(); i++) {
    			mod = (BaseMod)list.get(i);
    			if (mod.getClass() == mod_LMM_littleMaidMob) instance = mod;
    		}
    		if (instance != null) {
    			boolean b = false;
    			String s1 = (String) Modchu_Reflect.invokeMethod(mod_LMM_littleMaidMob, "getVersion", instance);
    			if (s1.startsWith("1.4.6")) ;else {
    				s1 = s1.substring(s1.length() - 1);
    				if (Integer.valueOf(s1) < 5) oldRenderItems = b;
    			}
    		}
    	}
    	mod_PFLM_PlayerFormLittleMaid = mod_Modchu_ModchuLib.mod_PFLM_PlayerFormLittleMaid;
    	if (mod_PFLM_PlayerFormLittleMaid != null) {
    		isPFLM = true;
    		PFLM_Gui = mod_Modchu_ModchuLib.PFLM_Gui;
    		PFLM_GuiModelSelect = mod_Modchu_ModchuLib.PFLM_GuiModelSelect;
    		PFLM_GuiOthersPlayer = mod_Modchu_ModchuLib.PFLM_GuiOthersPlayer;
    		PFLM_GuiOthersPlayerIndividualCustomize = mod_Modchu_ModchuLib.PFLM_GuiOthersPlayerIndividualCustomize;
    		PFLM_EntityPlayerDummy = mod_Modchu_ModchuLib.PFLM_EntityPlayerDummy;
    		PFLM_RenderPlayer = mod_Modchu_ModchuLib.PFLM_RenderPlayer;
    		if ((Boolean) getFieldObject(mod_PFLM_PlayerFormLittleMaid, "isOlddays")) {
    			setOldwalking((Boolean) getFieldObject(ModelBiped.class, "oldwalking"));
    		}
    		setFieldObject(PFLM_Gui, "partsSetFlag", 1);
    	}
    	skirtFloats = mod_Modchu_ModchuLib.skirtFloats;
    	modchuRemodelingModel = mod_Modchu_ModchuLib.modchuRemodelingModel;
    	MMM_TextureManager = mod_Modchu_ModchuLib.MMM_TextureManager;
    	armsinit(psize, pyoffset);
    	skirtFloatsInit(psize, pyoffset);
    }

    /**
     * 手持ちアイテム描画用パーツ初期化時に呼ばれる
     */
    public void armsinit(float f, float f1) {
    	Arms = new Modchu_ModelRenderer[18];
    	// 手持ち
    	Arms[0] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    	Arms[1] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
    	((Modchu_ModelRenderer) Arms[1]).isInvertX = true;
    	// バイプロダクトエフェクター
    	Arms[2] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[2].setRotationPoint(-3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	Arms[3] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[3].setRotationPoint(3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).isInvertX = true;
    	// テールソード
    	Arms[4] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[4].setRotationPoint(-2F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[4]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);
    	Arms[5] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[5].setRotationPoint(2F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[5]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);


//		Arms[8] = new Modchu_ModelRenderer(this, "HeadTop");
//		Arms[8].setRotationPoint(0F, -3F, 1F);
    	if (HeadMount != null) {
    		if (bipedHead instanceof Modchu_ModelRenderer) {
    			((Modchu_ModelRenderer) bipedHead).removeChild(HeadMount);
    		} else {
    			bipedHead.childModels.remove(HeadMount);
    		}
    	}
    	HeadMount = new Modchu_ModelRenderer(this, "HeadMount");
    	HeadMount.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(HeadMount);
    	bipedBody.addChild(Arms[4]);
    	bipedBody.addChild(Arms[5]);
    	bipedRightArm.addChild(Arms[0]);
    	bipedRightArm.addChild(Arms[2]);
    	bipedLeftArm.addChild(Arms[1]);
    	bipedLeftArm.addChild(Arms[3]);
    }

    /**
     * ふんわりスカート初期化
     */
    public void skirtFloatsInit(float f, float f1) {
    }

    @Override
    public void render(Entity entity, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
    	if (entity instanceof EntityLiving) {
    		setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);
    		try {
    			Modchu_Reflect.invokeMethod(mainFrame.getClass(), "render", new Class[]{ float.class, EntityLiving.class }, mainFrame, new Object[]{ f5, (EntityLiving)entity });
    		} catch(Exception e) {
    			mainFrame.render(f5);
    		}
    		if (modelCaps != null) {
    			renderStabilizer(entity, (Map) modelCaps.getCapsValue(caps_stabiliser), f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
    		}
    	}
    }

    @Override
    public void setLivingAnimations(EntityLiving entityliving, float f, float f1, float f2) {
/*//125delete
    	entity = entityliving;
*///125delete
    	setMotionY(entityliving.motionY + 0.0784000015258789D > 0 ? 0 : (float) ((entityliving.motionY + 0.0784000015258789D)) * mod_Modchu_ModchuLib.skirtFloatsVolume);
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entityliving)) {
    		LMMLivingAnimationsSpecialOperationsBefore(entityliving, f, f1, f2);
    	} else PFLMLivingAnimationsSpecialOperationsBefore(entityliving, f, f1, f2);
    	setLivingAnimationsLM(entityliving, f, f1, f2);
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entityliving)) {
    		LMMLivingAnimationsSpecialOperationsAfter(entityliving, f, f1, f2);
    	} else PFLMLivingAnimationsSpecialOperationsAfter(entityliving, f, f1, f2);
    }

    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (entity != null) ;else return;
    	setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		LMMRotationAnglesSpecialOperations(f, f1, f2, f3, f4, f5, entity);
    	} else {
    		PFLMRotationAnglesSpecialOperations(f, f1, f2, f3, f4, f5, entity);
    	}
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    @Override
    public void renderItems(EntityLiving pEntity, Render pRender) {
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(pEntity)) {
    		if (oldRenderItems) OldRenderItemsLM(pEntity, pRender);
    		else renderItemsLM(pEntity, pRender);
    	} else {
    		renderItemsPFLM(pEntity, pRender);
    	}
    }

	public void renderItemsLM(EntityLiving pEntity, Render pRender) {
		// 手持ちの表示
		GL11.glPushMatrix();
		boolean lflag = true;
		if (modelCaps != null) {
			ItemStack[] litemstacks = (ItemStack[])modelCaps.getCapsValue(caps_Items);
			EnumAction[] lactions = (EnumAction[])modelCaps.getCapsValue(caps_Actions);
			if (litemstacks != null) {
				Object Arms;
				for (int i = 0; i < 2; i++) {
					Arms = getArms(i);
					if (Arms != null) {
						Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
						Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ pEntity, pRender, false, lactions[i] ,litemstacks[i] });
					}
				}
				lflag = false;
			}
			// 頭部装飾品
			boolean lplanter = modelCaps.getCapsValueBoolean(caps_isPlanter);
			ItemStack litemstack = (ItemStack)modelCaps.getCapsValue(caps_HeadMount);
			int addSupport = addSupportChecks(pEntity, litemstack);
			if (modelCaps.getCapsValueBoolean(caps_isCamouflage) || lplanter
					|| addSupport > -1) {
				Object HeadMount = getHeadMount();
				Modchu_Reflect.invokeMethod(HeadMount.getClass(), "loadMatrix", HeadMount);
				if (lplanter
						|| (addSupport > -1 && addSupport < 3)) {
					equippedItemPositionFlower();
				}
				float scale = 1.0F;
				Object inventory = modelCaps.getCapsValue(caps_Inventory);
				if (inventory != null) {
					ItemStack litemstack1 = (ItemStack) Modchu_Reflect.invokeMethod(InventoryPlayer.class, "getStackInSlot", new Class[]{ int.class }, inventory, new Object[]{ 16 });
					if (litemstack1 != null) {
						Item item2 = litemstack1.getItem();
						if (item2 == item2.dyePowder) {
							scale = 1.0F + (0.2F * litemstack1.getItemDamage());
						}
					}
					Modchu_Reflect.invokeMethod(HeadMount.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class, float.class, int.class }, HeadMount, new Object[]{ pEntity, pRender, true, null, litemstack, scale, addSupport });
					//HeadMount.renderItems(pEntity, pRender, true, null, (ItemStack)modelCaps.getCapsValue(caps_HeadMount));
				}
			}
		}
		if (lflag) {
			Object Arms = getArms(0);
			if (Arms != null) {
				Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
				Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ pEntity, pRender, false, null, pEntity.getHeldItem() });
			}
		}
		GL11.glPopMatrix();
	}

    public void OldRenderItemsLM(EntityLiving pEntity, Render pRender) {
    	// 手持ちの表示
    	GL11.glPushMatrix();

    	ItemStack litemstack = null;
    	EnumAction laction;
    	Class pEntityClass = pEntity.getClass();
    	Object obj = null;
    	// int i = 0 R
    	// int i = 1 L
    	for (int i = 0; i < 2 ; i++) {
    		obj = getObjectInvokeMethod(pEntity, "getSwingStatus", new Class[]{ int.class }, i);
    		litemstack = (ItemStack) getObjectInvokeMethod(obj, "getItemStack", new Class[]{ pEntity.getClass() }, pEntity);
    		//litemstack = ((LMM_EntityLittleMaid) pEntity).mstatSwingStatus[i].getItemStack((LMM_EntityLittleMaid) pEntity);
    		int maidDominantArm = (Integer) getFieldObject(pEntity, "maidDominantArm");
    		Object maidAvatar = getFieldObject(pEntity, "maidAvatar");
    		int itemInUseCount = (Integer) getObjectInvokeMethod(EntityPlayer.class, "bL", "getItemInUseCount", maidAvatar);
    		laction = maidDominantArm == i && itemInUseCount > 0 ? litemstack.getItemUseAction() : null;
    		//laction = (((LMM_EntityLittleMaid) pEntity).maidDominantArm == i && ((LMM_EntityLittleMaid) pEntity).maidAvatar.getItemInUseCount() > 0) ? litemstack.getItemUseAction() : null;

    		if (litemstack != null) {
    			Object Arms = getArms(i);
    			if (Arms != null) {
    				Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
    				Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ pEntity, pRender, false, laction, litemstack });
    			}
    		}
    	}

    	// 頭部装飾品
    	Object maidInventory = getFieldObject(pEntity, "maidInventory");
    	litemstack = (ItemStack) getObjectInvokeMethod(maidInventory, "getHeadMount");
    	if (litemstack != null) {
    		boolean isCamouflage = (Boolean) getObjectInvokeMethod(pEntity, "isCamouflage");
    		boolean isPlanter = (Boolean) getObjectInvokeMethod(pEntity, "isPlanter");
    		int addSupport = addSupportChecks(pEntity, litemstack);
    		if (isCamouflage
    				|| isPlanter
    				|| addSupport > -1) {
    		//if (((LMM_EntityLittleMaid) pEntity).isCamouflage() || ((LMM_EntityLittleMaid) pEntity).isPlanter()) {
    			ItemStack[] litemstack1 = (ItemStack[]) getFieldObject(InventoryPlayer.class, "a", "mainInventory", maidInventory);
    			if (litemstack1 != null) {
    				ItemStack litemstack2 = litemstack1[litemstack1.length - 2];
    				Object HeadMount = getHeadMount();
    				Modchu_Reflect.invokeMethod(HeadMount.getClass(), "loadMatrix", HeadMount);
    				if (isPlanter
    						|| (addSupport > -1 && addSupport < 3)) {
    					//if (((LMM_EntityLittleMaid) pEntity).isPlanter()) {
    					equippedItemPositionFlower();
    				}
    				float scale = 1.0F;
    				if (litemstack2 != null) {
    					Item item2 = litemstack2.getItem();
    					if (item2 == item2.dyePowder) {
    						scale = 1.0F + (0.2F * litemstack2.getItemDamage());
    					}
    				}
    				Modchu_Reflect.invokeMethod(HeadMount.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class, float.class, int.class }, HeadMount, new Object[]{ pEntity, pRender, true, null, litemstack, scale, addSupport });
    				//HeadMount.renderItems(pEntity, pRender, true, null, ((LMM_EntityLittleMaid) pEntity).maidInventory.getHeadMount());
    			}
    		}
    	}

    	GL11.glPopMatrix();
    }

    public void renderItemsPFLM(EntityLiving pEntity, Render pRender) {
    	// 手持ちの表示 PFLM
    	EntityPlayer entityplayer = ((EntityPlayer) pEntity);
    	GL11.glPushMatrix();

    	ItemStack litemstack = null;
    	EnumAction laction;
    	litemstack = entityplayer.inventory.getCurrentItem();
    	laction = litemstack != null && entityplayer.getItemInUseCount() > 0 ? litemstack.getItemUseAction() : null;

    	if (litemstack != null) {
    		Object Arms = getArms((Integer) getCapsValue(caps_getHandedness));
    		if (Arms != null) {
    			Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
    			Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ entityplayer, pRender, false, laction, litemstack });
    		}
    	}

    	// 頭部装飾品
    	litemstack = entityplayer.inventory.getStackInSlot(9);
    	if (litemstack != null) {
    		int addSupport = addSupportChecks(entityplayer, litemstack);
    		if (addSupport == 3) addSupport = -1;
    		headMountRenderItems(entityplayer, pRender, litemstack, addSupport);
    	}

    	// アーマー頭部装飾品 特殊対応
    	litemstack = entityplayer.inventory.armorItemInSlot(3);
    	if (litemstack != null) {
    		int addSupport = addSupportChecks(entityplayer, litemstack);
    		if (addSupport == 3
    				| addSupport == 4) headMountRenderItems(entityplayer, pRender, litemstack, addSupport);
    	}

    	GL11.glPopMatrix();
    }

    public void headMountRenderItems(EntityPlayer entityplayer, Render pRender, ItemStack litemstack, int addSupport) {
    	Item item = litemstack.getItem();
    	Block block = null;
    	boolean isCamouflage = false;
    	boolean isPlanter = false;
    	try {
    		block = Block.blocksList[item.itemID];
    		isCamouflage = item instanceof ItemBlock
    				&& block instanceof BlockLeaves
    				|| block instanceof BlockPumpkin;
    		isPlanter = block instanceof BlockFlower;
    	} catch(Exception e) {
    	}
    	if (isCamouflage
    			|| isPlanter
    			|| addSupport > -1) {
    		ItemStack litemstack2 = entityplayer.inventory.getStackInSlot(10);
    		Object HeadMount = getHeadMount();
    		if (HeadMount != null) ;else return;
    		Modchu_Reflect.invokeMethod(HeadMount.getClass(), "loadMatrix", HeadMount);
    		if (isPlanter
    				|| (addSupport > -1 && addSupport < 3)) {
    			equippedItemPositionFlower();
    		}
    		float scale = 1.0F;
    		if (litemstack2 != null) {
    			Item item2 = litemstack2.getItem();
    			if (item2 == item2.dyePowder) {
    				scale = 1.0F + (0.2F * litemstack2.getItemDamage());
    			}
    		}
    		Modchu_Reflect.invokeMethod(HeadMount.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class, float.class, int.class }, HeadMount, new Object[]{ entityplayer, pRender, true, null, litemstack, scale, addSupport });
    	}
    }

    /**
     * PlayerFormLittleMaidで追加対応したブロック・アイテムかチェック
     * DecoBlock = 0, DecoBlockBase = 1, FavBlock = 2, Item.skull = 3,
     * BlockPumpkin = 4
     */
    public int addSupportChecks(EntityLiving pEntity, ItemStack litemstack) {
    	if (litemstack != null) ;else return -1;
    	int flag = -1;
    	Item item = litemstack.getItem();
    	Block block = null;
    	try {
    		block = Block.blocksList[item.itemID];
    		if (mod_Modchu_ModchuLib.isDecoBlock) {
    			if (mod_Modchu_ModchuLib.decoBlock.isInstance(block)) return 0;
    			if (mod_Modchu_ModchuLib.decoBlockBase.isInstance(block)) return 1;
    		}
    		if (mod_Modchu_ModchuLib.isFavBlock
    				&& mod_Modchu_ModchuLib.favBlock.isInstance(block)) {
    			return 2;
    		}
    	} catch(Exception e) {
    	}
//-@-132
    	if (item.itemID == Item.skull.itemID) return 3;
//@-@132
    	if (item instanceof ItemBlock
    			&& block instanceof BlockPumpkin) return 4;
    	return flag;
    }

    public ModelRenderer getArms(int i) {
    	return Arms[i];
    }

    public ModelRenderer getHeadMount() {
    	return HeadMount;
    }

    public Object getSwingStatus(Entity entity, int i) {
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return getObjectInvokeMethod(entity, "getSwingStatus", new Class[]{ int.class }, i);
    	}
    	if ((Integer) getCapsValue(caps_getHandedness) == i) {
        	//Modchu_Debug.mDebug("getOnGround()="+getOnGround() +" i="+i);
    		return getOnGround();
    	}
    	return 0.0F;
    }

    /**
     * PlayerFormLittleMaid専用処理
     * setLivingAnimations 呼び出し前に呼ばれる。
     */
    public void PFLMLivingAnimationsSpecialOperationsBefore(Entity entity, float f, float f1, float f2) {
    	entityIdFactor = (Float) getCapsValue(caps_getEntityIdFactor, entity);
    }

    /**
     * PlayerFormLittleMaid専用処理
     * setLivingAnimations 呼び出し後に呼ばれる。
     */
    public void PFLMLivingAnimationsSpecialOperationsAfter(Entity entity, float f, float f1, float f2) {
    	boolean isRiding = (Boolean) getCapsValue(caps_getIsRiding);
    	setCapsValue(caps_setIsRiding, !isRiding ? (Boolean) getCapsValue(caps_getIsSitting) : isRiding);
    	if (entity != null) ;else return;
    	if (entity instanceof EntityPlayer) settingShowParts();
    }

    /**
     * PlayerFormLittleMaid専用処理
     * setRotationAngles 呼び出し後に呼ばれる。
     */
    public void PFLMRotationAnglesSpecialOperations(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (entity != null) ;else return;
    	if ((Boolean) getCapsValue(caps_getFirstPerson)) setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entity);
    	if ((Boolean) getCapsValue(caps_getShortcutKeysAction)) {
    		action(entity, (Integer) getCapsValue(caps_getRunActionNumber));
    		if ((Boolean) getCapsValue(caps_getActionFlag)) {
    			setCapsValue(caps_setActionSpeed, 0.0F);
    			setCapsValue(caps_setActionFlag, false);
    		}
    	}
    }

    /**
     * PlayerFormLittleMaid専用Player用処理
     * setRotationAngles 呼び出し後に通常視点時なら呼ばれる。
     * 通常視点時の手の描画位置、角度調整を入れる。
     */
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    /**
     * GUI パーツ表示・非表示 初期設定 すべてのパーツを自動取得しリストに追加
     */
    public void showPartsInit() {
    	getShowPartsList().clear();
    	getModelRendererMap().clear();
    	int k = 0;
    	Field[] fields = getClass().getFields();
    	String s1;
    	for (int i = 0; i < fields.length; i++) {
    		//Modchu_Debug.mDebug("fields["+i+"].getType() = "+fields[i].getType());
    		Object o;
    		try {
    			o = fields[i].get(this);
    			if (ModelRenderer.class.isInstance(o)) {
    				try {
    					s1 = fields[i].getName();
    					getShowPartsList().add(s1);
    					if (fields[i].get(this) != null) {
    						getModelRendererMap().put(s1, fields[i]);
    						//Modchu_Debug.mDebug("ok. fields["+i+"].getName() = "+s1);
    					}
    				} catch (Exception e) {
    					//e.printStackTrace();
    				}
    				k++;
    			}
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
    	}
    }

    /**
     * GUI パーツ表示・非表示実行
     */
    public void settingShowParts() {
    	//GUI パーツ表示・非表示初期設定
    	if((Integer) getFieldObject(PFLM_Gui, "partsSetFlag") == 1) {
    		if (getShowPartsList().isEmpty()) showPartsInit();
    		defaultPartsSettingBefore();
    		setParts(0);
    		defaultPartsSettingAfter();
    		setFieldObject(PFLM_Gui, "partsSetFlag", 2);
    		if(!partsSetInit) {
    			partsSetInit = true;
    			setFieldObject(PFLM_Gui, "showModelFlag", true);
    			Modchu_Config.loadShowModelList((List<String>) getFieldObject(mod_PFLM_PlayerFormLittleMaid, "showModelList"));
    		}
    	}

    	//GUI パーツ表示・非表示反映
    	if((Boolean) getFieldObject(PFLM_Gui, "showModelFlag")) {
    		settingReflects();
    		setFieldObject(PFLM_Gui, "showModelFlag", false);
    	}
    }

    /**
     * GUI パーツ表示・非表示用リスト追加
     */
    public void addShowParts(String[] s) {
    	if (s != null) ;else return;
    	for(int i1 = 0; i1 < s.length; i1++) {
    		getShowPartsList().add(s[i1]);
    	}
    }

    /**
     * GUI パーツ表示・非表示用 ボタン非表示リスト追加
     */
    public void showPartsHideListadd(String[] s) {
    	for(int i = 0; i < s.length; i++) {
    		getShowPartsHideList().add(s[i]);
    	}
    }

    /**
     * GUI パーツ表示・非表示用リスト削除
     */
    public void showPartsListRemove(String s) {
    	getShowPartsList().remove(s);
    }

    /**
     * GUI パーツ表示・非表示用リスト削除
     */
    public void showPartsListRemove(String[] s) {
    	for(int i = 0; i < s.length; i++) {
    		getShowPartsList().remove(s[i]);
    	}
    }

    /**
     * GUI パーツ表示・非表示用 ボタン表示名リネーム用追加
     */
    public void addShowPartsReneme(String[] s1, String[] s2) {
    	for(int i = 0; i < s1.length && i < s2.length; i++) {
    		getShowPartsReneme().put(s1[i], s2[i]);
    	}
    }

    /**
     * GUI パーツ表示・非表示用モデルパーツリスト追加
     */
    public void addModelRendererMap(String[] s, Field[] model) {
    	if (s != null
    			&& model != null) ;else return;
    	for(int i = 0; i < s.length; i++) {
    		getModelRendererMap().put(s[i], model[i]);
    	}
    }

    /**
     * GUI パーツ表示・非表示 モデル初期化時とPFLM_Gui Customize Defaultボタンが押された時、
     * setPartsの前に呼ばれる。自動取得されたリストの編集など
     */
    public void defaultPartsSettingBefore() {
    }

    /**
     * GUI パーツ表示・非表示 モデル初期化時とPFLM_Gui Customize Defaultボタンが押された時、
     * setPartsの後に呼ばれる。デフォルトOFFにする設定など
     */
    public void defaultPartsSettingAfter() {
    }

    public List<String> getShowPartsList() {
    	return showPartsList;
    }

    public List<String> getShowPartsHideList() {
    	return showPartsHideList;
    }

    public HashMap<String, Field> getModelRendererMap() {
    	return modelRendererMap;
    }
/*
    public LinkedList<String> getTextureNameList() {
    	return textureNameList;
    }
*/
    public LinkedList<String> getTextureList() {
    	return textureList;
    }

    public void setParts(int i) {
    	getObjectInvokeMethod(PFLM_Gui, "setParts", new Class[]{ List.class, List.class }, null, new Object[]{ getShowPartsList(), getShowPartsHideList() });
    }

    public HashMap<String, Boolean> getGuiParts() {
    	return (HashMap<String, Boolean>) getFieldObject(PFLM_Gui, "parts");
    }

    public HashMap<Integer, String> getShowPartsNemeList() {
    	return (HashMap<Integer, String>) getFieldObject(PFLM_Gui, "showPartsNemeList");
    }

    public HashMap<String, String> getShowPartsReneme() {
    	return (HashMap<String, String>) getFieldObject(PFLM_Gui, "showPartsReneme");
    }

    /**
     * GUI パーツ表示・非表示反映呼び出し
     */
    public void settingReflects() {
    	showModelSettingReflects();
    }

    /**
     * GUI パーツ表示・非表示反映
     */
    public void showModelSettingReflects() {
    	HashMap<String, Boolean> parts = getGuiParts();
    	HashMap<Integer, String> showPartsNemeList = getShowPartsNemeList();
    	Field f = null;
    	ModelRenderer model = null;
    	String s2 = null;
    	for(int i1 = 0; i1 < parts.size(); i1++) {
    		s2 = showPartsNemeList.get(i1);
    		f = getModelRendererMap().get(s2);
    		if (f != null) {
    			try {
    				model = (ModelRenderer) f.get(this);
    				if (model != null) setCapsValue(caps_setVisible, model, parts.get(s2));
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }

    /**
     * indexOfで検索対象のパーツをまとめて指定パーツと同じ状態にセットする
     */
    public void indexOfAllSetVisible(String s) {
    	String s0 = null;
    	HashMap<String, Field> modelRendererMap = getModelRendererMap();
    	boolean b = getGuiParts().get(s);
    	for(int i1 = 0; i1 < modelRendererMap.size(); i1++) {
    		s0 = mod_Modchu_ModchuLib.getHashMapKey(getModelRendererMap(), i1);
    		if (s0 != null
    				&& s0.indexOf(s) > -1) {
    			try {
    				setCapsValue(caps_setVisible, (ModelRenderer) getModelRendererMap().get(s0).get(this), b);
    			} catch (Exception e) {
    				//e.printStackTrace();
    			}
    		}
    	}
    }

    /**
     * indexOfで検索対象のパーツをまとめて指定booleanにセットする
     */
    public void indexOfAllSetVisible(String s, boolean b) {
    	String s0 = null;
    	for(int i1 = 0; i1 < getShowPartsList().size(); i1++) {
    		s0 = getShowPartsList().get(i1);
    		if (s0.indexOf(s) > -1) {
    			try {
    				setCapsValue(caps_setVisible, (ModelRenderer) getModelRendererMap().get(s0).get(this), b);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }

    public void setGuiParts(String s, boolean b) {
    	getGuiParts().put(s, b);
    }

    /**
     * ショートカットアクション時に呼ばれる
     */
    public void actionInit(int i) {
    	setCapsValue(caps_setRunActionNumber, i);
    	switch(i) {
    	case 1:
    		actionInit1();
    		break;
    	case 2:
    		actionInit2();
    		break;
    	case 3:
    		actionInit3();
    		break;
    	case 4:
    		actionInit4();
    		break;
    	case 5:
    		actionInit5();
    		break;
    	case 6:
    		actionInit6();
    		break;
    	case 7:
    		actionInit7();
    		break;
    	case 8:
    		actionInit8();
    		break;
    	case 9:
    		actionInit9();
    		break;
    	case 30:
    		actionInit30();
    		break;
    	}
    }

    public void actionInit1() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    	boolean b = false;
    	setCapsValue(caps_setVisible, bipedLeftArm, b);
    	setCapsValue(caps_setVisible, bipedRightArm, b);
    	setCapsValue(caps_setVisible, bipedLeftLeg, b);
    	setCapsValue(caps_setVisible, bipedRightLeg, b);
    	b = true;
    	if (rightArm != null) setCapsValue(caps_setVisible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_setVisible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_setVisible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_setVisible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_setVisible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_setVisible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_setVisible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_setVisible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_setVisible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_setVisible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_setVisible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_setVisible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_setVisible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_setVisible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_setVisible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_setVisible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_setVisible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_setVisible, leftLegPlus2, b);
    	if (bipedRightArm != null
    			&& bipedRightArm instanceof Modchu_ModelRenderer) {
    		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
    		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
    	}
    	if (bipedLeftArm != null
    			&& bipedLeftArm instanceof Modchu_ModelRenderer) {
    		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
    		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
    	}
    	if (rightHand != null) {
    		rightHand.addChild(Arms[0]);
    		rightHand.addChild(Arms[2]);
    	}
    	if (leftHand != null) {
    		leftHand.addChild(Arms[1]);
    		leftHand.addChild(Arms[3]);
    	}
    	Arms[0].setRotationPoint(0.5F, 0.0F, 0.0F);
    	Arms[1].setRotationPoint(-0.5F, 0.0F, 0.0F);
    	setCapsValue(caps_setSneakBan, true);
    	setCapsValue(caps_setWaitBan, true);
    	setCapsValue(caps_setSittingBan, true);
    }

    public void actionInit2() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    	setCapsValue(caps_setActionCount, 0);
    	setCapsValue(caps_setWaitBan, false);
    }

    public void actionInit3() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    	setCapsValue(caps_setWaitBan, false);
    }

    public void actionInit4() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    	setCapsValue(caps_setWaitBan, false);
    }

    public void actionInit5() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    }

    public void actionInit6() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    }

    public void actionInit7() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    }

    public void actionInit8() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    }

    public void actionInit9() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    }

    public void actionInit30() {
    	setCapsValue(caps_setShortcutKeysAction, true);
    }

    /**c
     * ショートカットアクション解除時に呼ばれる。
     */
    public void actionRelease(int i) {
    	switch((Integer) getCapsValue(caps_getRunActionNumber)) {
    	case 1:
    		actionRelease1();
    		break;
    	case 2:
    		actionRelease2();
    		break;
    	case 3:
    		actionRelease3();
    		break;
    	case 4:
    		actionRelease4();
    		break;
    	case 5:
    		actionRelease5();
    		break;
    	case 6:
    		actionRelease6();
    		break;
    	case 7:
    		actionRelease7();
    		break;
    	case 8:
    		actionRelease8();
    		break;
    	case 9:
    		actionRelease9();
    		break;
    	case 30:
    		actionRelease30();
    		break;
    	}
    }

    public void actionRelease1() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    	setCapsValue(caps_setSneakBan, false);
    	setCapsValue(caps_setWaitBan, false);
    	setCapsValue(caps_setSittingBan, false);

    	boolean b = true;
    	setCapsValue(caps_setVisible, bipedLeftArm, b);
    	setCapsValue(caps_setVisible, bipedRightArm, b);
    	setCapsValue(caps_setVisible, bipedLeftLeg, b);
    	setCapsValue(caps_setVisible, bipedRightLeg, b);
    	b = false;
    	if (rightArm != null) setCapsValue(caps_setVisible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_setVisible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_setVisible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_setVisible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_setVisible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_setVisible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_setVisible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_setVisible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_setVisible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_setVisible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_setVisible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_setVisible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_setVisible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_setVisible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_setVisible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_setVisible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_setVisible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_setVisible, leftLegPlus2, b);

    	if (Arms != null) {
    		if (Arms[0] != null) bipedRightArm.addChild(Arms[0]);
    		if (Arms[2] != null) bipedRightArm.addChild(Arms[2]);
    		if (Arms[1] != null) bipedLeftArm.addChild(Arms[1]);
    		if (Arms[3] != null) bipedLeftArm.addChild(Arms[3]);
    		if (Arms[0] != null
    				&& rightHand != null) ((Modchu_ModelRenderer) rightHand).removeChild(Arms[0]);
    		if (Arms[2] != null
    				&& rightHand != null) ((Modchu_ModelRenderer) rightHand).removeChild(Arms[2]);
    		if (Arms[1] != null
    				&& leftHand != null) ((Modchu_ModelRenderer) leftHand).removeChild(Arms[1]);
    		if (Arms[3] != null
    				&& leftHand != null) ((Modchu_ModelRenderer) leftHand).removeChild(Arms[3]);
    		if (Arms[0] != null) Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    		if (Arms[1] != null) Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
    	}

    	bipedBody.rotateAngleX = 0.0F;
    	bipedBody.rotateAngleY = 0.0F;
    	bipedBody.rotateAngleZ = 0.0F;
    	bipedHead.rotateAngleX = 0.0F;
    	bipedHead.rotateAngleY = 0.0F;
    	bipedHead.rotateAngleZ = 0.0F;
    	bipedHead.rotationPointX = 0.0F;
    	bipedHead.rotationPointZ = 0.0F;
    }

    public void actionRelease2() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    	setCapsValue(caps_setWaitBan, false);
    }

    public void actionRelease3() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    	setCapsValue(caps_setWaitBan, false);
    }

    public void actionRelease4() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    	setCapsValue(caps_setWaitBan, false);
    }

    public void actionRelease5() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    }

    public void actionRelease6() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    }

    public void actionRelease7() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    }

    public void actionRelease8() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    }

    public void actionRelease9() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    }

    public void actionRelease30() {
    	setCapsValue(caps_setShortcutKeysAction, false);
    }

    public void action(Entity entity, int i) {
    	switch(i) {
    	case 1:
    		action1(entity);
    		break;
    	case 2:
    		action2(entity);
    		break;
    	case 3:
    		action3(entity);
    		break;
    	case 4:
    		action4(entity);
    		break;
    	case 5:
    		action5(entity);
    		break;
    	case 6:
    		action6(entity);
    		break;
    	case 7:
    		action7(entity);
    		break;
    	case 8:
    		action8(entity);
    		break;
    	case 9:
    		action9(entity);
    		break;
    	}
    }

    public void action1(Entity entity) {
    	// ｳｯｰｳｯｰｳﾏｳﾏ(ﾟ∀ﾟ)
    	float speed = (Float) getCapsValue(caps_getActionSpeed) / 10;
    	//Modchu_Debug.mDebug("action1 "+((Float) getCapsValue(caps_getActionSpeed))+" speed="+speed);
    	if (speed < 0.0F) return;

    	rightArm.rotationPointX = bipedRightArm.rotationPointX;
    	rightArm.rotationPointY = bipedRightArm.rotationPointY;
    	rightArm.rotationPointZ = bipedRightArm.rotationPointZ;
    	leftArm.rotationPointX = bipedLeftArm.rotationPointX;
    	leftArm.rotationPointY = bipedLeftArm.rotationPointY;
    	leftArm.rotationPointZ = bipedLeftArm.rotationPointZ;
    	rightArm2.rotationPointX = 0.0F;
    	rightArm2.rotationPointY = 4.0F;
    	rightArm2.rotationPointZ = 0.0F;
    	leftArm2.rotationPointX = 0.0F;
    	leftArm2.rotationPointY = 4.0F;
    	leftArm2.rotationPointZ = 0.0F;

    	rightLeg.rotationPointX = bipedRightLeg.rotationPointX;
    	rightLeg.rotationPointY = bipedRightLeg.rotationPointY;
    	rightLeg.rotationPointZ = bipedRightLeg.rotationPointZ;
    	leftLeg.rotationPointX = -rightLeg.rotationPointX;
    	leftLeg.rotationPointY = bipedLeftLeg.rotationPointY;
    	leftLeg.rotationPointZ = bipedLeftLeg.rotationPointZ;
    	rightLeg2.rotationPointY = bipedRightLeg.rotationPointY;
    	leftLeg2.rotationPointY = rightLeg2.rotationPointY;

    	rightArm.rotateAngleX = bipedRightArm.rotateAngleX;
    	rightArm.rotateAngleZ = bipedRightArm.rotateAngleZ;
    	leftArm.rotateAngleX = bipedLeftArm.rotateAngleX;
    	leftArm.rotateAngleZ = bipedLeftArm.rotateAngleZ;

    	float f1 = bipedBody.rotateAngleZ;
    	//actionSpeed = 0.1F;
    	//left
    	//float f1 = 0.5359998F;
    	//middle
    	//float f1 = 0.07F;
    	//right
    	//float f1 = -0.3820023F;

    	rightArm2.rotateAngleX = 0.0F;
    	rightLeg.rotationPointZ = -0.01F;
    	leftLeg.rotationPointZ = -0.01F;
    	rightLeg2.rotationPointZ = -0.02F;
    	rightLeg2.rotationPointX = -0.001F;
    	leftLeg2.rotationPointX = 0.001F;

    	rightArm.rotateAngleY = f1 * 0.09328361F;
    	rightHand.rotateAngleX = -f1 * 1.86567233F;
    	rightHand.rotateAngleZ = 0.0F;
    	if (!(Boolean) getCapsValue(caps_getActionReverse)) {
    		if (f1 < 0.5F) {
    			f1 += speed;
    		} else setCapsValue(caps_setActionReverse, true);
    	} else {
    		if (f1 > -0.3F) {
    			f1 -= speed;
    		} else setCapsValue(caps_setActionReverse, false);
    	}
    	if (f1 > 0.5449998F) f1 = 0.5449998F;
    	if (f1 < -0.3880023F) f1 = -0.3880023F;
    	//f1 = 0.5449998F;
    	//f1 = 0.01F;
    	if (f1 > 0.0F) {
    		bipedBody.rotateAngleX += f1 * 0.186567233F;
    		bipedBody.rotationPointY += f1 * 4.10447914F;
    		rightLeg.rotationPointY -= f1 * 0.93283616F;
    		rightLeg2.rotationPointY -= f1 * 0.93283616F;
    		leftLeg.rotationPointY -= f1 * 1.86567233F;
    		leftLeg2.rotationPointY -= f1 * 1.30889264F;
    		leftLeg2.rotationPointZ = -f1 * 0.74626893F;
    		rightArm.rotateAngleZ = 2.05619449F - (f1 * 1.1194034F);
    		rightArm2.rotateAngleZ = 1.3619449F + (f1 * 1.3059706F);
    		leftArm.rotateAngleX = -rightArm.rotateAngleX;
    		leftArm.rotateAngleY = -rightArm.rotateAngleY;
    		leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
    		rightLeg.rotateAngleX = f1 * 0.186567233F;
    		rightLeg.rotateAngleZ = -f1 * 1.30597063F;
    		leftLeg.rotateAngleX = -f1 * 0.186567233F;
    		leftLeg.rotateAngleY = f1 * 0.5597017F;
    		leftLeg.rotateAngleZ = -f1 * 1.02611976F;
    		leftLeg2.rotateAngleX = f1 * 1.30597063F;
    		leftArm2.rotateAngleX = -rightArm2.rotateAngleX;
    		leftArm2.rotateAngleY = -rightArm2.rotateAngleY;
    		leftArm2.rotateAngleZ = -rightArm2.rotateAngleZ;
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 3.5F + (f1 * 2.61778528F);
    	} else {
    		bipedBody.rotationPointY -= f1 * 4.10447914F;
    		leftLeg.rotationPointY -= f1 * 0.14592575F;
    		rightLeg2.rotationPointY += f1 * 1.30889264F;
    		leftLeg2.rotationPointY -= f1 * 1.30889264F;
    		leftLeg2.rotationPointZ = -0.02F;
    		rightLeg.rotationPointY -= -f1 * 2.61778528F;
    		leftLeg.rotationPointY -= -f1 * 2.61778528F;
    		rightArm.rotateAngleX = 0.0F;
    		rightArm.rotateAngleZ = 2.05619449F + (f1 * 1.8324496927929884191796750961971F);
    		rightArm2.rotateAngleZ = 1.3619449F - (f1 * 0.52355705F);
    		leftArm.rotateAngleX = -rightArm.rotateAngleX;
    		leftArm.rotateAngleY = -rightArm.rotateAngleY;
    		leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
    		leftArm2.rotateAngleX = -rightArm2.rotateAngleX;
    		leftArm2.rotateAngleY = -rightArm2.rotateAngleY;
    		leftArm2.rotateAngleZ = -rightArm2.rotateAngleZ;
    		rightLeg.rotateAngleX = 0.0F;
    		rightLeg.rotateAngleY = f1 * 0.52355705F;
    		rightLeg.rotateAngleZ = -f1 * 1.30597063F;
    		rightLeg2.rotateAngleX = -f1 * 1.30889264F;
    		leftLeg.rotateAngleX = 0.0F;
    		leftLeg.rotateAngleY = 0.0F;
    		leftLeg.rotateAngleZ = -f1 * 1.30597063F;
    		leftLeg2.rotateAngleX = 0.0F;
    		leftLeg2.rotateAngleZ = 0.0F;
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 3.5F - (f1 * 2.61778528F);
    	}
    	bipedHead.rotationPointX = f1 * 2.10447914F;
    	bipedHead.rotateAngleX = -f1 * 0.2F;
    	bipedHead.rotateAngleY = f1 * 0.2F;
    	bipedHead.rotateAngleZ = f1;
    	leftHand.rotateAngleX = -rightHand.rotateAngleX;
    	leftHand.rotateAngleY = rightHand.rotateAngleY;
    	leftHand.rotateAngleZ = rightHand.rotateAngleZ;
    	bipedBody.rotateAngleZ = f1;
    }

    public void action2(Entity entity) {
    	// 手を上げるモーション
    	((ModelRenderer) getCapsValue(caps_getBipedRightArm)).rotateAngleX -= 0.2F;
    	((ModelRenderer) getCapsValue(caps_getBipedRightArm)).rotateAngleY -= 1.0F;
    	((ModelRenderer) getCapsValue(caps_getBipedRightArm)).rotateAngleZ += (Integer) getCapsValue(caps_getHandedness) == 0 ? 2.1F : -2.1F;
    }

    public void action3(Entity entity) {
    	// 手を上げて振るモーション
    	//Modchu_Debug.mDebug("armorType="+armorType+" actionSpeed="+actionSpeed);
    	float actionSpeed = (Float) getCapsValue(caps_getActionSpeed);
    	if (actionSpeed < 0.0F) return;
    	int i = (int) (actionSpeed * 2);
    	if (i < 0) i = 0;
    	boolean actionReverse = (Boolean) getCapsValue(caps_getActionReverse);
    	int actionCount = (Integer) getCapsValue(caps_getActionCount);
    	actionCount = (int) (actionReverse ? actionCount - i : actionCount + i);
    	setCapsValue(caps_setActionCount, actionCount);
    	//Modchu_Debug.mDebug("actionReverse="+actionReverse+" actionCount="+actionCount+" "+((float) (actionCount - 15)) / 30.0F);
    	((ModelRenderer) getCapsValue(caps_getBipedRightArm)).rotateAngleZ = 2.0F - ((float) (actionCount - 15)) / 20.0F;
    	if ((Integer) getCapsValue(caps_getHandedness) == 1) ((ModelRenderer) getCapsValue(caps_getBipedRightArm)).rotateAngleZ = -((ModelRenderer) getCapsValue(caps_getBipedRightArm)).rotateAngleZ;
    	if (actionCount > 30) {
    		setCapsValue(caps_setActionReverse, true);
    		setCapsValue(caps_setActionCount, 30);
    	}
    	if (actionCount < 0) {
    		setCapsValue(caps_setActionReverse, false);
    		setCapsValue(caps_setActionCount, 0);
    	}
    }

    public void action4(Entity entity) {
    	// 両手を前に出すモーション
    	float onGroundR = (Float) getCapsValue(caps_getOnGround, 0, entity);
    	float onGroundL = (Float) getCapsValue(caps_getOnGround, 1, entity);
    	if (getOnGround(getSwingStatus(entity, (Integer) getCapsValue(caps_getHandedness)), entity) > 0.0F) {
    		bipedRightArm.rotateAngleX += bipedLeftArm.rotateAngleX += -1.57F;
    		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = bipedLeftArm.rotateAngleZ = 0.0F;
    	} else {
    		bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = -1.57F;
    		bipedRightArm.rotateAngleY = bipedLeftArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = bipedLeftArm.rotateAngleZ = 0.0F;
    	}
    }

    public void action5(Entity entity) {
    	//
    }

    public void action6(Entity entity) {
    }

    public void action7(Entity entity) {
    }

    public void action8(Entity entity) {
    }

    public void action9(Entity entity) {
    }

    public void action30(Entity entity) {
    	//デバック用
    	if (getClass().getPackage() == null) return;
    	boolean b = true;
    	if (rightArm != null) setCapsValue(caps_setVisible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_setVisible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_setVisible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_setVisible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_setVisible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_setVisible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_setVisible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_setVisible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_setVisible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_setVisible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_setVisible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_setVisible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_setVisible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_setVisible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_setVisible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_setVisible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_setVisible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_setVisible, leftLegPlus2, b);
    }

    /**
     * アーマーモデルとメインモデルの同期。
     * アーマーモデルに対して、メインモデルのデータが渡されてくるのでそれに合わせるパーツを同期させる
     */
    public void syncModel(MultiModelBaseBiped model) {
    	if ((Integer) getCapsValue(caps_getRunActionNumber) == 1
    			| (Integer) getCapsValue(caps_getRunActionNumber) == 2) bipedBody.rotateAngleZ = model.bipedBody.rotateAngleZ;
    }

    /**
     * setRotationAnglesLM実行前に呼ばれる。
     * 各パーツの初期化など。
     */
    public abstract void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity);

    /**
     * カラー切替時に実行されるコード
     */
    public void changeColor(EntityLiving pentity) {
    }

    public float getyOffset() {
    	return 1.62F;
    }

    public float getRidingHeight() {
    	return getHeight();
    }

    public float getRidingWidth() {
    	return getWidth();
    }

    public float getRidingyOffset() {
    	return getyOffset();
    }

    /**
     * 他Mobを頭に乗せた時の他Mob基準位置調整
     */
    public double getMountedYOffset() {
    	return 0.75D;
    }

    /**
     * 座っているポーズ「乗り物に乗っていない」時の位置調整
     */
    public double getSittingyOffset() {
    	return -0.35D;
    }

    /**
     * 寝ているポーズ時の位置調整
     */
    public double getSleepingyOffset() {
    	return -0.9D;
    }

    /**
     * isModelSize=true時に乗り物に乗っている状態でのカメラ位置調整
     */
    public float ridingViewCorrection() {
    	return 0.0F;
    }

    /**
     * デフォルトモデルスケール
     */
    public float getModelScale() {
    	return 0.9375F;
    }

    /**
     * 特殊頭表示アイテム「花系」の位置調整
     */
    public void equippedItemPositionFlower() {
    	GL11.glTranslatef(0F, -0.5F, 0F);
    }

    /**
     * 特殊頭表示アイテム「花系&骨粉拡大時」の位置調整
     */
    public void equippedItemPositionFlowerDyePowder() {
    	GL11.glTranslatef(0.0F, 0.0F, 0.0F);
    }

    public void setArmorBipedHeadShowModel(boolean b) {
    	setCapsValue(caps_setVisible, bipedHead, b);
    }

    public void setArmorBipedBodyShowModel(boolean b) {
    	setCapsValue(caps_setVisible, bipedBody, b);
    }

    public void setArmorBipedRightArmShowModel(boolean b) {
    	if ((Boolean) getCapsValue(caps_getShortcutKeysAction)
    			&& (Integer) getCapsValue(caps_getRunActionNumber) == 0
    			| (Integer) getCapsValue(caps_getRunActionNumber) == 1) {
    		setCapsValue(caps_setVisible, bipedRightArm, false);
    		if (rightArm != null) setCapsValue(caps_setVisible, rightArm, b);
    		if (rightArm2 != null) setCapsValue(caps_setVisible, rightArm2, b);
    		if (rightHand != null) setCapsValue(caps_setVisible, rightHand, b);
    	}
    	else setCapsValue(caps_setVisible, bipedRightArm, b);
    }

    public void setArmorBipedLeftArmShowModel(boolean b) {
    	if ((Boolean) getCapsValue(caps_getShortcutKeysAction)
    			&& (Integer) getCapsValue(caps_getRunActionNumber) == 0
    			| (Integer) getCapsValue(caps_getRunActionNumber) == 1) {
    		setCapsValue(caps_setVisible, bipedLeftArm, false);
    		if (leftArm != null) setCapsValue(caps_setVisible, leftArm, b);
    		if (leftArm2 != null) setCapsValue(caps_setVisible, leftArm2, b);
    		if (leftHand != null) setCapsValue(caps_setVisible, leftHand, b);
    	}
    	else setCapsValue(caps_setVisible, bipedLeftArm, b);
    }

    public void setArmorBipedRightLegShowModel(boolean b) {
    	if ((Boolean) getCapsValue(caps_getShortcutKeysAction)
    			&& (Integer) getCapsValue(caps_getRunActionNumber) == 0
    			| (Integer) getCapsValue(caps_getRunActionNumber) == 1) {
    		setCapsValue(caps_setVisible, bipedRightLeg, false);
    		if (rightLeg != null) setCapsValue(caps_setVisible, rightLeg, b);
    		if (rightLeg2 != null) setCapsValue(caps_setVisible, rightLeg2, b);
    	}
    	else setCapsValue(caps_setVisible, bipedRightLeg, b);
    }

    public void setArmorBipedLeftLegShowModel(boolean b) {
    	if ((Boolean) getCapsValue(caps_getShortcutKeysAction)
    			&& (Integer) getCapsValue(caps_getRunActionNumber) == 0
    			| (Integer) getCapsValue(caps_getRunActionNumber) == 1) {
    		setCapsValue(caps_setVisible, bipedLeftLeg, false);
    		if (leftLeg != null) setCapsValue(caps_setVisible, leftLeg, b);
    		if (leftLeg2 != null) setCapsValue(caps_setVisible, leftLeg2, b);
    	}
    	else setCapsValue(caps_setVisible, bipedLeftLeg, b);
    }

    public void setArmorSkirtShowModel(boolean b) {
    }

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		Object o = super.getCapsValue(pIndex, pArg);
		if (o != null) return o;
		switch (pIndex) {
		case caps_getOnGround:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) return getOnGround(getSwingStatus((Entity) pArg[1], (Integer) pArg[0]), (Entity) pArg[1]);
			return getOnGround();
		case caps_getIsSneak:
			return getIsSneak();
		case caps_getIsRiding:
			return getIsRiding();
		case caps_getaimedBow:
			return getaimedBow();
		case caps_getIsWait:
			return getIsWait();
		case caps_getIsSitting:
			return getIsSitting();
		case caps_getIsSleeping:
			return getIsSleeping();
		case caps_getFirstPerson:
			return getFirstPerson();
		case caps_getArmorType:
			return getArmorType();
		case caps_getOldwalking:
			return getOldwalking();
		case caps_getIsPlayer:
			return getIsPlayer();
		case caps_getActionFlag:
			return getActionFlag();
		case caps_getActionCount:
			return getActionCount();
		case caps_getMotionY:
			return getMotionY();
		case caps_getPartsSetFlag:
			return getPartsSetFlag();
		case caps_getShowModelFlag:
			return getShowModelFlag();
		case caps_getShortcutKeysAction:
			return getShortcutKeysAction();
		case caps_getRunActionNumber:
			return getRunActionNumber();
		case caps_getSkirtFloats:
			return getSkirtFloats();
		case caps_getBipedHead:
			return getBipedHead();
		case caps_getBipedRightArm:
			return getBipedRightArm();
		case caps_getNotDominantArm:
			return getNotDominantArm();
		case caps_getHandedness:
			if (pArg != null
				&& pArg.length > 0
				&& pArg[0] != null) return getHandedness((Entity) pArg[0]);
			return getHandedness();
		case caps_Physical_Hammer:
			return Physical_Hammer();
		case caps_getIsLookSuger:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getIsLookSuger((Entity) pArg[0]);
		case caps_getEntityIdFactor:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getEntityIdFactor((Entity) pArg[0]);
		case caps_getIsInventory:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getIsInventory((Entity) pArg[0]);
		case caps_convertDegtoRad:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return convertDegtoRad((Float) pArg[0]);
		case caps_getClassName:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getClassName((String) pArg[0]);
/*
		case caps_getTextureNameList:
			return getTextureNameList();
*/
		case caps_getTextureList:
			return getTextureList();
		case caps_getMaidColor:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getMaidColor((Entity) pArg[0]);
		case caps_getTexture:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) return getTexture((Entity) pArg[0], (String) pArg[1], (Integer) pArg[2]);
		case caps_getPastX:
			return getPastX();
		case caps_getPastY:
			return getPastY();
		case caps_getPastZ:
			return getPastZ();
		case caps_getSneakBan:
			return getSneakBan();
		case caps_getAimedBowBan:
			return getAimedBowBan();
		case caps_getWaitBan:
			return getWaitBan();
		case caps_getSittingBan:
			return getSittingBan();
		case caps_getSleepingBan:
			return getSleepingBan();
		case caps_getRidingBan:
			return getRidingBan();
		case caps_getModchuRemodelingModel:
			return getModchuRemodelingModel();
		case caps_getActionSpeed:
			return getActionSpeed();
		case caps_getActionReverse:
			return getActionReverse();
		}
		return null;
	}

	@Override
	public boolean setCapsValue(int pIndex, Object ...pArg) {
		boolean b = super.setCapsValue(pIndex, pArg);
		if (b) return b;
		switch (pIndex) {
		case caps_setIsRiding:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsRiding((Boolean) pArg[0]);
			return true;
		case caps_setIsSitting:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsSitting((Boolean) pArg[0]);
			return true;
		case caps_setOnGround:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setOnGround((Float) pArg[0]);
			return true;
		case caps_setOldwalking:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setOldwalking((Boolean) pArg[0]);
			return true;
		case caps_setIsPlayer:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsPlayer((Boolean) pArg[0]);
			return true;
		case caps_setFirstPerson:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setFirstPerson((Boolean) pArg[0]);
			return true;
		case caps_setActionCount:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionCount((Integer) pArg[0]);
			return true;
		case caps_setArmorType:
			if (pArg != null
			&& pArg[0] != null) setArmorType((Integer) pArg[0]);
			return true;
		case caps_setIsInventory:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsInventory((Boolean) pArg[0]);
			return true;
		case caps_setActionFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionFlag((Boolean) pArg[0]);
			return true;
		case caps_setIsSleeping:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsSleeping((Boolean) pArg[0]);
			return true;
		case caps_setMotionY:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setMotionY((Float) pArg[0]);
			return true;
		case caps_setShowModelFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setShowModelFlag((Integer) pArg[0]);
			return true;
		case caps_setHandedness:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setHandedness((Integer) pArg[0]);
			return true;
		case caps_setPartsSetFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setPartsSetFlag((Integer) pArg[0]);
			return true;
		case caps_setShortcutKeysAction:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setShortcutKeysAction((Boolean) pArg[0]);
			return true;
		case caps_setRunActionNumber:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setRunActionNumber((Integer) pArg[0]);
			return true;
		case caps_setIsWait:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsWait((Boolean) pArg[0]);
			return true;
		case caps_renderFirstPersonHand:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) renderFirstPersonHand((Float) pArg[0]);
			return true;
		case caps_setVisible:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) setVisible((ModelRenderer) pArg[0], (Boolean) pArg[1]);
			return true;
		case caps_shiftArray:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) shiftArray((Float) pArg[0], (Float) pArg[1], (Float) pArg[2]);
			return true;
		case caps_setPastX:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[0].getClass().isInstance(float[].class)) setPastX((float[]) pArg[0]);
				else {
					if (pArg[1] != null) setPastX((Integer) pArg[0], (Float) pArg[1]);
				}
			}
			return true;
		case caps_setPastY:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[0].getClass().isInstance(float[].class)) setPastY((float[]) pArg[0]);
				else {
					if (pArg[1] != null) setPastY((Integer) pArg[0], (Float) pArg[1]);
				}
			}
			return true;
		case caps_setPastZ:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[0].getClass().isInstance(float[].class)) setPastZ((float[]) pArg[0]);
				else {
					if (pArg[1] != null) setPastZ((Integer) pArg[0], (Float) pArg[1]);
				}
			}
			return true;
		case caps_setSneakBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setSneakBan((Boolean) pArg[0]);
			return true;
		case caps_setAimedBowBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setAimedBowBan((Boolean) pArg[0]);
			return true;
		case caps_setWaitBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setWaitBan((Boolean) pArg[0]);
			return true;
		case caps_setSittingBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setSittingBan((Boolean) pArg[0]);
			return true;
		case caps_setSleepingBan:
			if (pArg != null
			&& pArg[0] != null) setSleepingBan((Boolean) pArg[0]);
			return true;
		case caps_setRidingBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setRidingBan((Boolean) pArg[0]);
			return true;
		case caps_indexOfAllSetVisible:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[1] != null) indexOfAllSetVisible((String) pArg[0], (Boolean) pArg[1]);
				else indexOfAllSetVisible((String) pArg[0]);
			}
			return true;
		case caps_setModchuRemodelingModel:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setModchuRemodelingModel((Boolean) pArg[0]);
			return true;
		case caps_setActionSpeed:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionSpeed((Float) pArg[0]);
			return true;
		case caps_setActionReverse:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionReverse((Boolean) pArg[0]);
			return true;
		}
		return b;
	}

    private boolean getIsRiding()
    {
    	return isRiding && !ridingBan;
    }

    private void setIsRiding(boolean b)
    {
    	isRiding = b;
    }

    private boolean getIsSleeping()
    {
    	return isSleeping && !sleepingBan;
    }

    private void setIsSleeping(boolean b)
    {
    	isSleeping = b;
    }

    private float getOnGround()
    {
    	return onGround;
    }

    private float getOnGround(Object o, Entity entity)
    {
    	if (o != null) {
    		Class c = o.getClass();
    		if (c == Float.class
    				| c == float.class) {
    			return (Float) o;
    		}
    		if (LMM_EntityLittleMaid != null
    				&& LMM_EntityLittleMaid.isInstance(entity)) {
    			Object o1 = getFieldObject(c, "onGround", o);
    			if (o1 != null) return (Float) o1;
    		}
    	}
    	return 0.0F;
    }

    private float setOnGround(float f)
    {
    	return onGround = f;
    }

    private boolean getIsSneak()
    {
    	return isSneak && !sneakBan;
    }

    private boolean getaimedBow()
    {
    	return aimedBow && !aimedBowBan;
    }

    private boolean getIsWait()
    {
    	return isWait && !waitBan;
    }

    private boolean getIsSitting()
    {
    	return isSitting && !sittingBan;
    }

    private void setIsSitting(boolean b)
    {
    	isSitting = b;
    }

    private boolean getFirstPerson()
    {
    	return firstPerson;
    }

    private void setFirstPerson(boolean b)
    {
    	firstPerson = b;
    }

    private boolean getOldwalking()
    {
    	return oldwalking;
    }

    private void setOldwalking(boolean b) {
    	oldwalking = b;
    }

    private boolean getIsPlayer()
    {
    	return isPlayer;
    }

    private void setIsPlayer(boolean b)
    {
    	isPlayer = b;
    }

    private boolean getActionFlag()
    {
    	return actionFlag;
    }

    private void setActionFlag(boolean b)
    {
    	actionFlag = b;
    }

    private int getActionCount()
    {
    	return actionCount;
    }

    private void setActionCount(int i)
    {
    	actionCount = i;
    }

    private int getArmorType()
    {
    	return armorType;
    }

    private void setArmorType(int i)
    {
    	armorType = i;
    }

    private float getMotionY()
    {
    	return motionY;
    }

    private void setMotionY(float f) {
    	motionY = f;
    }

    private boolean getSneakBan()
    {
    	return sneakBan;
    }

    private boolean getAimedBowBan()
    {
    	return aimedBowBan;
    }

    private boolean getWaitBan()
    {
    	return waitBan;
    }

    private boolean getSittingBan()
    {
    	return sittingBan;
    }

    private boolean getSleepingBan()
    {
    	return sleepingBan;
    }

    private boolean getRidingBan()
    {
    	return ridingBan;
    }

    private void setAimedBowBan(boolean b)
    {
    	aimedBowBan = b;
    }

    private void setSneakBan(boolean b)
    {
    	sneakBan = b;
    }

    private void setWaitBan(boolean b)
    {
    	waitBan = b;
    }

    private void setSittingBan(boolean b)
    {
    	sittingBan = b;
    }

    private void setSleepingBan(boolean b)
    {
    	sleepingBan = b;
    }

    private void setRidingBan(boolean b)
    {
    	ridingBan = b;
    }

    private int getPartsSetFlag()
    {
    	return partsSetFlag;
    }

    private int getShowModelFlag()
    {
    	return showModelFlag;
    }

    private void setShowModelFlag(int i) {
    	showModelFlag = i;
    }

    private void setPartsSetFlag(int i) {
    	partsSetFlag = i;
    }

    private boolean getShortcutKeysAction() {
    	return shortcutKeysAction;
    }

    private void setShortcutKeysAction(boolean b) {
    	shortcutKeysAction = b;
    }

    private int getRunActionNumber() {
    	return runActionNumber;
    }

    private void setRunActionNumber(int i) {
    	runActionNumber = i;
    }

    private void setIsWait(boolean b) {
    	isWait = b;
    }

    private boolean getSkirtFloats() {
    	return skirtFloats;
    }

    private int getHandedness() {
    	if (handedness > -1) return handedness;
    	return 0;
    }

    private int getHandedness(Entity entity) {
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		modelCaps.getCapsValue(caps_dominantArm);
    	}
    	if (handedness > -1) return handedness;
    	return 0;
    }

    private void setHandedness(int i) {
    	handedness = i;
    }

    private void setVisible(ModelRenderer modelRenderer, boolean b) {
    	if (modelRenderer != null) ;else return;
    	if (modelRenderer instanceof Modchu_ModelRenderer) {
    		((Modchu_ModelRenderer) modelRenderer).setVisible(b);
    	} else {
    		modelRenderer.showModel = b;
    	}
    }

    private boolean getIsLookSuger(Entity entity) {
    	if (entity instanceof EntityPlayer) {
        	EntityPlayer entityplayer = (EntityPlayer) entity;
        	ItemStack itemstack2 = entityplayer.inventory.getCurrentItem();
        	if (itemstack2 != null) {
        		Item item = itemstack2.getItem();
        		if (item == Item.sugar) return true;
        	}
    	}
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return (Boolean) getObjectInvokeMethod(LMM_EntityLittleMaid, "isLookSuger", entity);
    	}
    	return false;
    }

    private float getEntityIdFactor(Entity entity) {
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return (Float) getFieldObject(LMM_EntityLittleMaid, "entityIdFactor", entity);
    	}
    	return (float)entity.entityId * 70;
    }

    private boolean getIsInventory(Entity entity) {
    	if (entity instanceof EntityPlayer) return isInventory;
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return (Boolean) getObjectInvokeMethod(LMM_EntityLittleMaid, "isOpenInventory", entity);
    	}
    	return false;
    }

    private void setIsInventory(boolean b) {
    	isInventory = b;
    }

    private float convertDegtoRad(float deg) {
    	return deg / 180F * (float)Math.PI;
    }

    private void shiftArray(float x,float y,float z)
    {
    	int i;
    	for(i = 0; i < 9; i++)
    	{
    		pastX[9 - i] = pastX[8 - i];
    		pastY[9 - i] = pastY[8 - i];
    		pastZ[9 - i] = pastZ[8 - i];
    	}
    	pastX[0] = x;
    	pastY[0] = y;
    	pastZ[0] = z;
    }

    private float[] getPastX() {
    	return pastX;
    }

    private float[] getPastY() {
    	return pastY;
    }

    private float[] getPastZ() {
    	return pastZ;
    }

    private void setPastX(float[] f) {
    	pastX = f;
    }

    private void setPastY(float[] f) {
    	pastY = f;
    }

    private void setPastZ(float[] f) {
    	pastZ = f;
    }

    private void setPastX(int i, float f) {
    	pastX[i] = f;
    }

    private void setPastY(int i, float f) {
    	pastY[i] = f;
    }

    private void setPastZ(int i, float f) {
    	pastZ[i] = f;
    }

    private boolean getModchuRemodelingModel() {
    	return modchuRemodelingModel;
    }

    private void setModchuRemodelingModel(boolean b) {
    	modchuRemodelingModel = b;
    }

    private float getActionSpeed() {
    	return actionSpeed;
    }

    private void setActionSpeed(float f) {
    	actionSpeed = f;
    }

    private boolean getActionReverse() {
    	return actionReverse;
    }

    private void setActionReverse(boolean b) {
    	actionReverse = b;
    }

    private String getTexture(Entity entity, String s, int i) {
    	if (mod_PFLM_PlayerFormLittleMaid != null
    			&& entity instanceof EntityPlayer
    			| (PFLM_EntityPlayerDummy != null
    			&& PFLM_EntityPlayerDummy.isInstance(entity))) {
    		return (String) getObjectInvokeMethod(mod_PFLM_PlayerFormLittleMaid, "textureManagerGetTextureName", new Class[]{ String.class, int.class }, null, new Object[]{ s, i });
    	} else
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return (String) Modchu_Reflect.invokeMethod(MMM_TextureManager, "getTextureName", new Class[]{ String.class, int.class }, null, new Object[]{ s, i });
    	}
    	return null;
    }

    private int getMaidColor(Entity entity) {
    	if (mod_PFLM_PlayerFormLittleMaid != null
    			&& entity instanceof EntityPlayer
    			| (PFLM_EntityPlayerDummy != null
    			&& PFLM_EntityPlayerDummy.isInstance(entity))) {
    		if (entity instanceof EntityPlayer) {
    			if (mc.currentScreen != null
    					&& PFLM_Gui.isInstance(mc.currentScreen)) {
    				//Modchu_Debug.mDebug("getMaidColor "+Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "maidColor"));
    				return (Integer) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "maidColor");
    			}
    			Object modelData = Modchu_Reflect.invokeMethod(PFLM_RenderPlayer, "getPlayerData", new Class[]{ EntityPlayer.class }, null, new Object[]{ entity });
    			if (modelData != null) return (Integer) Modchu_Reflect.getFieldObject(modelData.getClass(), "maidColor", modelData);
    		} else {
    			if (mc.currentScreen != null) ;else return 0;
    			if (PFLM_Gui.isInstance(mc.currentScreen)) return (Integer) Modchu_Reflect.getFieldObject(PFLM_Gui, "setColor");
    			if (PFLM_GuiModelSelect.isInstance(mc.currentScreen)) return (Integer) Modchu_Reflect.getFieldObject(PFLM_GuiModelSelect, "modelColor", mc.currentScreen);
    			if (PFLM_GuiOthersPlayerIndividualCustomize.isInstance(mc.currentScreen)) return (Integer) Modchu_Reflect.getFieldObject(PFLM_GuiOthersPlayerIndividualCustomize, "othersMaidColor");
    			if (PFLM_GuiOthersPlayer.isInstance(mc.currentScreen)) return (Integer) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "othersMaidColor");
    		}
    	} else
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return (Integer) Modchu_Reflect.getFieldObject(LMM_EntityLittleMaid, "maidColor", entity);
    	}
    	return 0;
    }

    public float Physical_Hammer() {
    	return (Float) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "Physical_Hammer");
    }

    public ModelRenderer getBipedHead() {
    	return bipedHead;
    }

    public ModelRenderer getBipedRightArm() {
    	if ((Integer) getCapsValue(caps_getHandedness) == 0) return bipedRightArm;
    	return bipedLeftArm;
    }

    public ModelRenderer getNotDominantArm() {
    	if ((Integer) getCapsValue(caps_getHandedness) == 0) return bipedLeftArm;
    	return bipedRightArm;
    }

	public void renderFirstPersonHand(float f) {
    	((ModelRenderer) getCapsValue(caps_getBipedRightArm)).render(f);
    }

    public String getClassName(String s) {
    	if (s == null) return null;
    	Package pac = getClass().getPackage();
    	if (pac != null) s = pac.getName().concat(".").concat(s);
    	return s;
    }
//@-@b173
/*//b181delete
    protected void setTextureOffset(String par1Str, int par2, int par3)
    {
        modelTextureMap.put(par1Str, new TextureOffsetPlayerFormLittleMaid(par2, par3));
    }

    public TextureOffsetPlayerFormLittleMaid getTextureOffset(String par1Str)
    {
        return (TextureOffsetPlayerFormLittleMaid)modelTextureMap.get(par1Str);
    }
*///b181delete

    public Object getFieldObject(Class c, String s) {
    	return Modchu_Reflect.getFieldObject(c, s);
    }

    public Object getFieldObject(Object o, String s) {
    	return Modchu_Reflect.getFieldObject(o.getClass(), s, o);
    }

    public Object getFieldObject(Class c, String s, Object o2) {
    	return Modchu_Reflect.getFieldObject(c, s, o2);
    }

    public Object getFieldObject(Class c, String s, String s1, Object o2) {
    	return Modchu_Reflect.getFieldObject(c, s, s1, o2);
    }

    public Object getFieldObject(Object o, String s, Object o2) {
    	return Modchu_Reflect.getFieldObject(o.getClass(), s, o2);
    }

    public Object getFieldObject(Object o, String s, String s1, Object o2) {
    	return Modchu_Reflect.getFieldObject(o.getClass(), s, s1, o2);
    }

    public Object getObjectInvokeMethod(Class c, String s) {
    	return Modchu_Reflect.invokeMethod(c, s);
    }

    public Object getObjectInvokeMethod(Object o, String s) {
    	return Modchu_Reflect.invokeMethod(o.getClass(), s, o);
    }

    public Object getObjectInvokeMethod(Class c, String s, Object o1) {
    	return Modchu_Reflect.invokeMethod(c, s, o1);
    }

    public Object getObjectInvokeMethod(Class c, String s, String s1, Object o1) {
    	return Modchu_Reflect.invokeMethod(c, s, s1, o1);
    }

    public Object getObjectInvokeMethod(Object o, String s, Object o1) {
    	return Modchu_Reflect.invokeMethod(o.getClass(), s, o1);
    }

    public Object getObjectInvokeMethod(Object o, String s, String s1, Object o1) {
    	return Modchu_Reflect.invokeMethod(o.getClass(), s, s1, o1);
    }

    public Object getObjectInvokeMethod(Class c, String s, Class[] c1, Object[] o1) {
    	return Modchu_Reflect.invokeMethod(c, s, c1, o1);
    }

    public Object getObjectInvokeMethod(Class c, String s, Class[] c1, Object o1) {
    	return Modchu_Reflect.invokeMethod(c, s, c1, o1);
    }

    public Object getObjectInvokeMethod(Class c, String s, String s1, Class[] c1, Object o1) {
    	return Modchu_Reflect.invokeMethod(c, s, s1, c1, o1);
    }

    public Object getObjectInvokeMethod(Class c, String s, Class[] c1, Object o1, Object ... o2) {
    	return Modchu_Reflect.invokeMethod(c, s, c1, o1, o2);
    }

    public Object getObjectInvokeMethod(Class c, String s, Class[] c1, Object[] o1, Object ... o2) {
    	return Modchu_Reflect.invokeMethod(c, s, c1, o1, o2);
    }

    public Object getObjectInvokeMethod(Class c, String s, String s1, Class[] c1, Object o1, Object ... o2) {
    	return Modchu_Reflect.invokeMethod(c, s, s1, c1, o1, o2);
    }

    public Object getObjectInvokeMethod(Object o, String s, Class[] c, Object o1) {
    	return Modchu_Reflect.invokeMethod(o.getClass(), s, c, o, o1);
    }

    public Object getObjectInvokeMethod(Object o, String s, String s1, Class[] c, Object o1) {
    	return Modchu_Reflect.invokeMethod(o.getClass(), s, s1, c, o, o1);
    }

    public Object getObjectInvokeMethod(Object o, String s, Class[] c, Object ... o1) {
    	return Modchu_Reflect.invokeMethod(o.getClass(), s, c, o, o1);
    }

    public Object getObjectInvokeMethod(Object o, String s, String s1, Class[] c, Object ... o1) {
    	return Modchu_Reflect.invokeMethod(o.getClass(), s, c, o, o1);
    }

    public Object getMethod(Class c, String s) {
    	return Modchu_Reflect.getMethod(c, s);
    }

    public Object getMethod(Class c, String s, String s1) {
    	return Modchu_Reflect.getMethod(c, s, s1);
    }

    public Object getMethod(Class c, String s, Class[] c1) {
    	return Modchu_Reflect.getMethod(c, s, c1);
    }

    public void setFieldObject(Class c, String s, Object o2) {
    	Modchu_Reflect.setFieldObject(c, s, null, o2);
    }

    public void setFieldObject(Object o, String s, Object o2) {
    	Modchu_Reflect.setFieldObject(o.getClass(), s, null, o2);
    }

    public void setFieldObject(Class c, String s, Object o2, Object b) {
    	Modchu_Reflect.setFieldObject(c, s, o2, b);
    }

    public void setFieldObject(Object o, String s, Object o2, Object b) {
    	Modchu_Reflect.setFieldObject(o.getClass(), s, o2, b);
    }

    public Class loadClass(String s) {
    	return Modchu_Reflect.loadClass(s);
    }

    // 以下、MMM_ModelBiped側にあってほしいもの
    /**
     * littleMaidMob専用処理
     * setLivingAnimations 呼び出し前に呼ばれる。
     */
    public void LMMLivingAnimationsSpecialOperationsBefore(Entity entity, float f, float f1, float f2) {
    }

	/**
     * littleMaidMob専用処理
     * setLivingAnimations 呼び出し後に呼ばれる。
     */
    public void LMMLivingAnimationsSpecialOperationsAfter(Entity entity, float f, float f1, float f2) {
    	float angle = (Float) getObjectInvokeMethod(entity, "getInterestedAngle", new Class[]{ float.class }, f2);
    	bipedHead.rotateAngleZ = angle;
    }

    /**
     * LittleMaidMob専用処理
     * setRotationAngles 呼び出し後に呼ばれる。
     */
    public void LMMRotationAnglesSpecialOperations(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }
}
