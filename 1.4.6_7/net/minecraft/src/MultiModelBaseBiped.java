package net.minecraft.src;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

/**
 * PlayerFormLittleMaid共通クラス
 */
public abstract class MultiModelBaseBiped extends MMM_ModelBiped {

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
    public static Minecraft mc = Minecraft.getMinecraft();
    //public static int partsNumber = 0;
    public static int partsSetFlag = 1;
    public static int showModelFlag = 0;
    public static int overridePartsNumber = 0;
    public static int handedness = -2;
    public int runActionNumber = 0;
    public int actionCount = 0;
    public int armorType = 0;
    public float motionY = 0.0F;
    public float actionSpeed = 0.0F;
    public float[] pastX = new float[10];
    public float[] pastY = new float[10];
    public float[] pastZ = new float[10];
    public static boolean isSitting = false;
    public static boolean isSleeping = false;
    public static boolean oldwalking = false;
    public boolean isInventory = false;
    public boolean firstPerson = false;
    public boolean isPlayer = false;
    public boolean shortcutKeysAction = false;
    public boolean actionReverse = false;
    public boolean sneakBan = false;
    public boolean aimedBowBan = false;
    public boolean waitBan = false;
    public boolean sittingBan = false;
    public boolean sleepingBan = false;
    public boolean ridingBan = false;
    public boolean modchuRemodelingModel = false;
    public boolean actionFlag = false;
    public static boolean isLMM = false;
    public static boolean isPFLM = false;
    public static boolean skirtFloats = false;
    private boolean partsSetInit = false;
    public List<String> showPartsList = new ArrayList<String>();
    public List<String> showPartsHideList = new ArrayList<String>();
    public HashMap<String, Field> modelRendererMap = new HashMap();
    public static Class mod_PFLM_PlayerFormLittleMaid;
    public static Class PFLM_Gui;
    public static Class PFLM_EntityPlayerDummy;
    public static Class mod_LMM_littleMaidMob;
    public static Class LMM_EntityLittleMaid;
/*//b181delete
    //public Entity entity;
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
//-@-132
    	this(psize, pyoffset, 64, 32);
    }

    public MultiModelBaseBiped(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset);
    	textureWidth = par3;
    	textureHeight = par4;
//@-@132
/*//132delete
    	super();
    	textureWidth = 64;
    	textureHeight = 32;
*///132delete
    	//b173deleteboxList = new ArrayList();

    	Modchu_Reflect.setDebugMessage(false);
    	mod_LMM_littleMaidMob = mod_Modchu_ModchuLib.mod_LMM_littleMaidMob;
    	if (mod_LMM_littleMaidMob != null) {
    		isLMM = true;
    		LMM_EntityLittleMaid = mod_Modchu_ModchuLib.LMM_EntityLittleMaid;
    	}
    	mod_PFLM_PlayerFormLittleMaid = mod_Modchu_ModchuLib.mod_PFLM_PlayerFormLittleMaid;
    	if (mod_PFLM_PlayerFormLittleMaid != null) {
    		isPFLM = true;
    		PFLM_Gui = mod_Modchu_ModchuLib.PFLM_Gui;
    		PFLM_EntityPlayerDummy = mod_Modchu_ModchuLib.PFLM_EntityPlayerDummy;
    		modchuRemodelingModel = mod_Modchu_ModchuLib.modchuRemodelingModel;
    		skirtFloats = mod_Modchu_ModchuLib.skirtFloats;
    		if ((Boolean) getFieldObject(mod_PFLM_PlayerFormLittleMaid, "isOlddays")) {
    			setOldwalking((Boolean) getFieldObject(ModelBiped.class, "oldwalking"));
    		}
    		setFieldObject(PFLM_Gui, "partsSetFlag", 1);
    	}
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
    		if (mainFrame instanceof Modchu_ModelRenderer) ((Modchu_ModelRenderer) mainFrame).render(f5, (EntityLiving)entity);
    		else if (mainFrame instanceof MMM_ModelRenderer) ((MMM_ModelRenderer) mainFrame).render(f5, (EntityLiving)entity);
    		else mainFrame.render(f5);
    		if (modelCaps != null) {
    			renderStabilizer(entity, (Map) modelCaps.getCapsValue(caps_stabiliser), f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
    		}
    	}
    }

    @Override
    public void setLivingAnimations(EntityLiving entityliving, float f, float f1, float f2) {
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
    		renderItemsLM(pEntity, pRender);
    	} else {
    		renderItemsPFLM(pEntity, pRender);
    	}
    }
/*
	public void renderItemsLM(EntityLiving pEntity, Render pRender) {
		// 手持ちの表示
		GL11.glPushMatrix();
		boolean lflag = true;
		if (modelCaps != null) {
			ItemStack[] litemstacks = (ItemStack[])modelCaps.getCapsValue(caps_Items);
			EnumAction[] lactions = (EnumAction[])modelCaps.getCapsValue(caps_Actions);
			if (litemstacks != null) {
				// R
				Arms[0].loadMatrix().renderItems(pEntity, pRender, false, lactions[0] ,litemstacks[0]);
				// L
				Arms[1].loadMatrix().renderItems(pEntity, pRender, false, lactions[1], litemstacks[1]);
				lflag = false;
			}
			// 頭部装飾品
			boolean lplanter = modelCaps.getCapsValueBoolean(caps_isPlanter);
			if (modelCaps.getCapsValueBoolean(caps_isCamouflage) || lplanter) {
				HeadMount.loadMatrix();
				if (lplanter) {
					GL11.glTranslatef(0F, -0.56F, 0F);
				}
				HeadMount.renderItems(pEntity, pRender, true, null, (ItemStack)modelCaps.getCapsValue(caps_HeadMount));
			}
		}
		if (lflag) {
			Arms[0].loadMatrix().renderItems(pEntity, pRender, false, null, pEntity.getHeldItem());
		}
		GL11.glPopMatrix();
	}
*/

    public void renderItemsLM(EntityLiving pEntity, Render pRender) {
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
    				if (Arms instanceof MMM_ModelRenderer) {
    					((MMM_ModelRenderer) Arms).loadMatrix();
    					((MMM_ModelRenderer) Arms).renderItems(pEntity, pRender, false, laction, litemstack);
    				} else if (Arms instanceof Modchu_ModelRenderer) {
    					((Modchu_ModelRenderer) Arms).loadMatrix();
    					((Modchu_ModelRenderer) Arms).renderItems(pEntity, pRender, false, laction, litemstack);
    				} else if (Arms instanceof Modchu_ModelRotationRenderer) {
    					((Modchu_ModelRotationRenderer) Arms).loadMatrix();
    					((Modchu_ModelRotationRenderer) Arms).renderItems(pEntity, pRender, false, laction, litemstack);
    				}
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
    				if (HeadMount instanceof MMM_ModelRenderer) {
    					((MMM_ModelRenderer) HeadMount).loadMatrix();
    				} else if (HeadMount instanceof Modchu_ModelRenderer) {
    					((Modchu_ModelRenderer) HeadMount).loadMatrix();
    				} else if (HeadMount instanceof Modchu_ModelRotationRenderer) {
    					((Modchu_ModelRotationRenderer) HeadMount).loadMatrix();
    				}
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
    				if (HeadMount instanceof MMM_ModelRenderer) {
    					((MMM_ModelRenderer) HeadMount).renderItems(pEntity, pRender, true, null, litemstack);
    				} else if (HeadMount instanceof Modchu_ModelRenderer) {
    					((Modchu_ModelRenderer) HeadMount).renderItems(pEntity, pRender, true, null, litemstack, scale, addSupport);
    				} else if (HeadMount instanceof Modchu_ModelRotationRenderer) {
    					((Modchu_ModelRotationRenderer) HeadMount).renderItems(pEntity, pRender, true, null, litemstack, scale, addSupport);
    				}
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
    		Object Arms = getArms(getHandedness());
    		if (Arms != null) {
    			if (Arms instanceof MMM_ModelRenderer) {
    				((MMM_ModelRenderer) Arms).loadMatrix();
    				((MMM_ModelRenderer) Arms).renderItems(entityplayer, pRender, false, laction, litemstack);
    			} else if (Arms instanceof Modchu_ModelRenderer) {
    				((Modchu_ModelRenderer) Arms).loadMatrix();
    				((Modchu_ModelRenderer) Arms).renderItems(entityplayer, pRender, false, laction, litemstack);
    			} else if (Arms instanceof Modchu_ModelRotationRenderer) {
    				((Modchu_ModelRotationRenderer) Arms).loadMatrix();
    				((Modchu_ModelRotationRenderer) Arms).renderItems(entityplayer, pRender, false, laction, litemstack);
    			}
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
    		if (HeadMount instanceof MMM_ModelRenderer) {
    			((MMM_ModelRenderer) HeadMount).loadMatrix();
    		} else {
    			((Modchu_ModelRenderer) HeadMount).loadMatrix();
    		}
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
    		if (HeadMount instanceof MMM_ModelRenderer) {
    			((MMM_ModelRenderer) HeadMount).renderItems(entityplayer, pRender, true, null, litemstack);
    		} else {
    			((Modchu_ModelRenderer) HeadMount).renderItems(entityplayer, pRender, true, null, litemstack, scale, addSupport);
    		}
    	}
    }

    /**
     * PlayerFormLittleMaidで追加対応したブロック・アイテムかチェック
     * DecoBlock = 0, DecoBlockBase = 1, FavBlock = 2, Item.skull = 3,
     * BlockPumpkin = 4
     */
    public int addSupportChecks(EntityLiving pEntity, ItemStack litemstack) {
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
    	if (item.itemID == Item.skull.itemID) return 3;
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
    	if (getHandedness() == i) {
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
    	entityIdFactor = getEntityIdFactor(entity);
    }

    /**
     * PlayerFormLittleMaid専用処理
     * setLivingAnimations 呼び出し後に呼ばれる。
     */
    public void PFLMLivingAnimationsSpecialOperationsAfter(Entity entity, float f, float f1, float f2) {
    	isRiding = !getIsRiding() ? getIsSitting() : getIsRiding();
    	if (entity instanceof EntityPlayer) settingShowParts();
    }

    /**
     * PlayerFormLittleMaid専用処理
     * setRotationAngles 呼び出し後に呼ばれる。
     */
    public void PFLMRotationAnglesSpecialOperations(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (getFirstPerson()) setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entity);
    	if (getShortcutKeysAction()) {
    		action(entity, getRunActionNumber());
    		if (actionFlag) {
    	    	actionSpeed = 0.0F;
    			actionFlag = false;
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
    	Field[] fields = this.getClass().getFields();
    	String s1;
    	for (int i = 0; i < fields.length; i++) {
    		//Modchu_Debug.mDebug("fields["+i+"].getType() = "+fields[i].getType());
    		Class c = fields[i].getType();
    		if (c == ModelRenderer.class
    				| c == Modchu_ModelRenderer.class) {
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
    				if (model != null) setVisible(model, parts.get(s2));
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
    				setVisible((ModelRenderer) getModelRendererMap().get(s0).get(this), b);
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
    				setVisible((ModelRenderer) getModelRendererMap().get(s0).get(this), b);
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
    	setRunActionNumber(i);
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
    	setShortcutKeysAction(true);
    	boolean b = false;
    	setVisible(bipedLeftArm, b);
    	setVisible(bipedRightArm, b);
    	setVisible(bipedLeftLeg, b);
    	setVisible(bipedRightLeg, b);
    	b = true;
    	if (rightArm != null) setVisible(rightArm, b);
    	if (rightArm2 != null) setVisible(rightArm2, b);
    	if (rightArmPlus != null) setVisible(rightArmPlus, b);
    	if (rightArmPlus2 != null) setVisible(rightArmPlus2, b);
    	if (rightHand != null) setVisible(rightHand, b);
    	if (leftArm != null) setVisible(leftArm, b);
    	if (leftArm2 != null) setVisible(leftArm2, b);
    	if (leftArmPlus != null) setVisible(leftArmPlus, b);
    	if (leftArmPlus2 != null) setVisible(leftArmPlus2, b);
    	if (leftHand != null) setVisible(leftHand, b);
    	if (rightLeg != null) setVisible(rightLeg, b);
    	if (rightLeg2 != null) setVisible(rightLeg2, b);
    	if (rightLegPlus != null) setVisible(rightLegPlus, b);
    	if (rightLegPlus2 != null) setVisible(rightLegPlus2, b);
    	if (leftLeg != null) setVisible(leftLeg, b);
    	if (leftLeg2 != null) setVisible(leftLeg2, b);
    	if (leftLegPlus != null) setVisible(leftLegPlus, b);
    	if (leftLegPlus2 != null) setVisible(leftLegPlus2, b);
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
    	sneakBan = true;
    	waitBan = true;
    	sittingBan = true;
    }

    public void actionInit2() {
    	setShortcutKeysAction(true);
    	actionCount = 0;
    	waitBan = true;
    }

    public void actionInit3() {
    	setShortcutKeysAction(true);
    	waitBan = true;
    }

    public void actionInit4() {
    	setShortcutKeysAction(true);
    	waitBan = true;
    }

    public void actionInit5() {
    	setShortcutKeysAction(true);
    }

    public void actionInit6() {
    	setShortcutKeysAction(true);
    }

    public void actionInit7() {
    	setShortcutKeysAction(true);
    }

    public void actionInit8() {
    	setShortcutKeysAction(true);
    }

    public void actionInit9() {
    	setShortcutKeysAction(true);
    }

    public void actionInit30() {
    	setShortcutKeysAction(true);
    }

    /**c
     * ショートカットアクション解除時に呼ばれる。
     */
    public void actionRelease(int i) {
    	switch(getRunActionNumber()) {
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
    	setShortcutKeysAction(false);
    	sneakBan = false;
    	waitBan = false;
    	sittingBan = false;

    	boolean b = true;
    	setVisible(bipedLeftArm, b);
    	setVisible(bipedRightArm, b);
    	setVisible(bipedLeftLeg, b);
    	setVisible(bipedRightLeg, b);
    	b = false;
    	if (rightArm != null) setVisible(rightArm, b);
    	if (rightArm2 != null) setVisible(rightArm2, b);
    	if (rightArmPlus != null) setVisible(rightArmPlus, b);
    	if (rightArmPlus2 != null) setVisible(rightArmPlus2, b);
    	if (rightHand != null) setVisible(rightHand, b);
    	if (leftArm != null) setVisible(leftArm, b);
    	if (leftArm2 != null) setVisible(leftArm2, b);
    	if (leftArmPlus != null) setVisible(leftArmPlus, b);
    	if (leftArmPlus2 != null) setVisible(leftArmPlus2, b);
    	if (leftHand != null) setVisible(leftHand, b);
    	if (rightLeg != null) setVisible(rightLeg, b);
    	if (rightLeg2 != null) setVisible(rightLeg2, b);
    	if (rightLegPlus != null) setVisible(rightLegPlus, b);
    	if (rightLegPlus2 != null) setVisible(rightLegPlus2, b);
    	if (leftLeg != null) setVisible(leftLeg, b);
    	if (leftLeg2 != null) setVisible(leftLeg2, b);
    	if (leftLegPlus != null) setVisible(leftLegPlus, b);
    	if (leftLegPlus2 != null) setVisible(leftLegPlus2, b);

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
    	setShortcutKeysAction(false);
    	waitBan = false;
    }

    public void actionRelease3() {
    	setShortcutKeysAction(false);
    	waitBan = false;
    }

    public void actionRelease4() {
    	setShortcutKeysAction(false);
    	waitBan = false;
    }

    public void actionRelease5() {
    	setShortcutKeysAction(false);
    }

    public void actionRelease6() {
    	setShortcutKeysAction(false);
    }

    public void actionRelease7() {
    	setShortcutKeysAction(false);
    }

    public void actionRelease8() {
    	setShortcutKeysAction(false);
    }

    public void actionRelease9() {
    	setShortcutKeysAction(false);
    }

    public void actionRelease30() {
    	setShortcutKeysAction(false);
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
    	float speed = actionSpeed / 10;
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
    	if (!actionReverse) {
    		if (f1 < 0.5F) {
    			f1 += speed;
    		} else actionReverse = true;
    	} else {
    		if (f1 > -0.3F) {
    			f1 -= speed;
    		} else actionReverse = false;
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
    	getBipedRightArm().rotateAngleX -= 0.2F;
    	getBipedRightArm().rotateAngleY -= 1.0F;
    	getBipedRightArm().rotateAngleZ += getHandedness() == 0 ? 2.1F : -2.1F;
    }

    public void action3(Entity entity) {
    	// 手を上げて振るモーション
    	//Modchu_Debug.mDebug("armorType="+armorType+" actionSpeed="+actionSpeed);
    	if (actionSpeed < 0.0F) return;
    	int i = (int) (actionSpeed * 2);
    	if (i < 0) i = 0;
    	actionCount = (int) (actionReverse ? actionCount - i : actionCount + i);
    	//Modchu_Debug.mDebug("actionReverse="+actionReverse+" actionCount="+actionCount+" "+((float) (actionCount - 15)) / 30.0F);
    	getBipedRightArm().rotateAngleZ = 2.0F - ((float) (actionCount - 15)) / 20.0F;
    	if (getHandedness() == 1) getBipedRightArm().rotateAngleZ = -getBipedRightArm().rotateAngleZ;
    	if (actionCount > 30) {
    		actionReverse = true;
    		actionCount = 30;
    	}
    	if (actionCount < 0) {
    		actionReverse = false;
    		actionCount = 0;
    	}
    }

    public void action4(Entity entity) {
    	// 両手を前に出すモーション
    	float onGroundR = getOnGround(getSwingStatus(entity, 0), entity);
    	float onGroundL = getOnGround(getSwingStatus(entity, 1), entity);
    	if (getOnGround(getSwingStatus(entity, getHandedness()), entity) > 0.0F) {
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
    	if (rightArm != null) setVisible(rightArm, b);
    	if (rightArm2 != null) setVisible(rightArm2, b);
    	if (rightArmPlus != null) setVisible(rightArmPlus, b);
    	if (rightArmPlus2 != null) setVisible(rightArmPlus2, b);
    	if (rightHand != null) setVisible(rightHand, b);
    	if (leftArm != null) setVisible(leftArm, b);
    	if (leftArm2 != null) setVisible(leftArm2, b);
    	if (leftArmPlus != null) setVisible(leftArmPlus, b);
    	if (leftArmPlus2 != null) setVisible(leftArmPlus2, b);
    	if (leftHand != null) setVisible(leftHand, b);
    	if (rightLeg != null) setVisible(rightLeg, b);
    	if (rightLeg2 != null) setVisible(rightLeg2, b);
    	if (rightLegPlus != null) setVisible(rightLegPlus, b);
    	if (rightLegPlus2 != null) setVisible(rightLegPlus2, b);
    	if (leftLeg != null) setVisible(leftLeg, b);
    	if (leftLeg2 != null) setVisible(leftLeg2, b);
    	if (leftLegPlus != null) setVisible(leftLegPlus, b);
    	if (leftLegPlus2 != null) setVisible(leftLegPlus2, b);
    }

    /**
     * アーマーモデルとメインモデルの同期。
     * アーマーモデルに対して、メインモデルのデータが渡されてくるのでそれに合わせるパーツを同期させる
     */
    public void syncModel(MultiModelBaseBiped model) {
    	if (getRunActionNumber() == 1
    			| getRunActionNumber() == 2) bipedBody.rotateAngleZ = model.bipedBody.rotateAngleZ;
    }

    /**
     * setRotationAnglesLM実行前に呼ばれる。
     * 各パーツの初期化など。
     */
    public abstract void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity);

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
    	setVisible(bipedHead, b);
    }

    public void setArmorBipedBodyShowModel(boolean b) {
    	setVisible(bipedBody, b);
    }

    public void setArmorBipedRightArmShowModel(boolean b) {
    	if (getShortcutKeysAction()
    			&& getRunActionNumber() == 0
    			| getRunActionNumber() == 1) {
    		setVisible(bipedRightArm, false);
    		if (rightArm != null) setVisible(rightArm, b);
    		if (rightArm2 != null) setVisible(rightArm2, b);
    		if (rightHand != null) setVisible(rightHand, b);
    	}
    	else setVisible(bipedRightArm, b);
    }

    public void setArmorBipedLeftArmShowModel(boolean b) {
    	if (getShortcutKeysAction()
    			&& getRunActionNumber() == 0
    			| getRunActionNumber() == 1) {
    		setVisible(bipedLeftArm, false);
    		if (leftArm != null) setVisible(leftArm, b);
    		if (leftArm2 != null) setVisible(leftArm2, b);
    		if (leftHand != null) setVisible(leftHand, b);
    	}
    	else setVisible(bipedLeftArm, b);
    }

    public void setArmorBipedRightLegShowModel(boolean b) {
    	if (getShortcutKeysAction()
    			&& getRunActionNumber() == 0
    			| getRunActionNumber() == 1) {
    		setVisible(bipedRightLeg, false);
    		if (rightLeg != null) setVisible(rightLeg, b);
    		if (rightLeg2 != null) setVisible(rightLeg2, b);
    	}
    	else setVisible(bipedRightLeg, b);
    }

    public void setArmorBipedLeftLegShowModel(boolean b) {
    	if (getShortcutKeysAction()
    			&& getRunActionNumber() == 0
    			| getRunActionNumber() == 1) {
    		setVisible(bipedLeftLeg, false);
    		if (leftLeg != null) setVisible(leftLeg, b);
    		if (leftLeg2 != null) setVisible(leftLeg2, b);
    	}
    	else setVisible(bipedLeftLeg, b);
    }

    public void setArmorSkirtShowModel(boolean b) {
    }

    public boolean getIsRiding()
    {
    	return isRiding && !ridingBan;
    }

    public float getOnGround()
    {
    	return onGround;
    }

    public float getOnGround(Object o, Entity entity)
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
    		//return getOnGround();
    	}
    	return 0.0F;
    }

    public float setOnGround(float f)
    {
    	return onGround = f;
    }

    public boolean getIsSneak()
    {
    	return isSneak && !sneakBan;
    }

    public boolean getaimedBow()
    {
    	return aimedBow && !aimedBowBan;
    }

    public boolean getIsWait()
    {
    	return isWait && !waitBan;
    }

    public boolean getIsSitting()
    {
    	return isSitting && !sittingBan;
    }

    public boolean getFirstPerson()
    {
    	return firstPerson;
    }

    public boolean getOldwalking()
    {
    	return oldwalking;
    }

    public void setOldwalking(boolean b) {
    	oldwalking = b;
    }

    public float getMotionY()
    {
    	return motionY;
    }

    public void setMotionY(float f) {
    	motionY = f;
    }

    public int getPartsSetFlag()
    {
    	return partsSetFlag;
    }

    public int getShowModelFlag()
    {
    	return showModelFlag;
    }

    public void setShowModelFlag(int i) {
    	showModelFlag = i;
    }

    public void setPartsSetFlag(int i) {
    	partsSetFlag = i;
    }
/*
    public int getPartsNumber()
    {
    	return partsNumber;
    }

    public void setPartsNumber(int i) {
    	partsNumber = i;
    }
*/
    public boolean getShortcutKeysAction() {
    	return shortcutKeysAction;
    }

    public void setShortcutKeysAction(boolean b) {
    	shortcutKeysAction = b;
    }

    public int getRunActionNumber() {
    	return runActionNumber;
    }

    public void setRunActionNumber(int i) {
    	runActionNumber = i;
    }

    public void setIsWait(boolean b) {
    	isWait = b;
    }

    public boolean getSkirtFloats() {
    	return skirtFloats;
    }

    public void renderFirstPersonHand(float f) {
    	getBipedRightArm().render(f);
    }

    public ModelRenderer getBipedHead() {
    	return bipedHead;
    }

    public ModelRenderer getBipedRightArm() {
    	if (getHandedness() == 0) return bipedRightArm;
    	return bipedLeftArm;
    }

    public int getHandedness() {
    	if (handedness > -1) return handedness;
    	return 0;
    }

    public void setVisible(ModelRenderer modelRenderer, boolean b) {
    	if (modelRenderer != null) ;else return;
    	if (modelRenderer instanceof Modchu_ModelRenderer) {
    		((Modchu_ModelRenderer) modelRenderer).setVisible(b);
    	} else {
    		modelRenderer.showModel = b;
    	}
    }

    public float Physical_Hammer() {
    	return (Float) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "Physical_Hammer");
    }

    public boolean getIsLookSuger(Entity entity) {
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

    public float getEntityIdFactor(Entity entity) {
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return (Float) getFieldObject(LMM_EntityLittleMaid, "entityIdFactor", entity);
    	}
    	return (float)entity.entityId * 70;
    }

    public boolean getIsInventory(Entity entity) {
    	if (entity instanceof EntityPlayer) return isInventory;
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		return (Boolean) getObjectInvokeMethod(LMM_EntityLittleMaid, "isOpenInventory", entity);
    	}
    	return false;
    }

    public float convertDegtoRad(float deg) {
    	return deg / 180F * (float)Math.PI;
    }

    public void shiftArray(float x,float y,float z)
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
        this.modelTextureMap.put(par1Str, new TextureOffsetPlayerFormLittleMaid(par2, par3));
    }

    public TextureOffsetPlayerFormLittleMaid getTextureOffset(String par1Str)
    {
        return (TextureOffsetPlayerFormLittleMaid)this.modelTextureMap.get(par1Str);
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

    public Object getObjectInvokeMethod(Class c, String s, Class[] c1, Object o1) {
    	return Modchu_Reflect.invokeMethod(c, s, c1, o1);
    }

    public Object getObjectInvokeMethod(Class c, String s, String s1, Class[] c1, Object o1) {
    	return Modchu_Reflect.invokeMethod(c, s, s1, c1, o1);
    }

    public Object getObjectInvokeMethod(Class c, String s, Class[] c1, Object o1, Object ... o2) {
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
