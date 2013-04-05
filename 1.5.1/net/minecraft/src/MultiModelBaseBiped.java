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
 * PlayerFormLittleMaid���ʃN���X
 */
public abstract class MultiModelBaseBiped extends MMM_ModelBiped implements Modchu_IModelCaps {

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
    private static int showModelFlag = 0;
    private static int overridePartsNumber = 0;
    private int actionCount = 0;
    private int armorType = 0;
    private int runActionNumber = 0;
    private float motionY = 0.0F;
    private float actionSpeed = 0.0F;
    private float[] pastX = new float[10];
    private float[] pastY = new float[10];
    private float[] pastZ = new float[10];
    private boolean oldwalking = false;
    private boolean firstPerson = false;
    private boolean actionReverse = false;
    private boolean sneakBan = false;
    private boolean aimedBowBan = false;
    private boolean waitBan = false;
    private boolean sittingBan = false;
    private boolean sleepingBan = false;
    private boolean ridingBan = false;
    private boolean actionFlag = false;
    private boolean shortcutKeysAction = false;
    private List<String> showPartsList = new ArrayList<String>();
    private List<String> showPartsHideList = new ArrayList<String>();
    private HashMap<String, Field> modelRendererMap = new HashMap();
    //private LinkedList<String> textureNameList = new LinkedList<String>();
    private LinkedList<String> textureList = new LinkedList<String>();
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
     * �R���X�g���N�^�͑S�Čp�������邱��
     */
    public MultiModelBaseBiped() {
    	this(0.0F);
    }

    /**
     * �R���X�g���N�^�͑S�Čp�������邱��
     */
    public MultiModelBaseBiped(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * �R���X�g���N�^�͑S�Čp�������邱��
     */
    public MultiModelBaseBiped(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    public MultiModelBaseBiped(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset);
    	textureWidth = par3;
    	textureHeight = par4;
    	//b173deleteboxList = new ArrayList();
    	armsinit(psize, pyoffset);
    	skirtFloatsInit(psize, pyoffset);
    }

    /**
     * �莝���A�C�e���`��p�p�[�c���������ɌĂ΂��
     */
    public void armsinit(float f, float f1) {
    	Arms = new Modchu_ModelRenderer[18];
    	// �莝��
    	Arms[0] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    	Arms[1] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
    	((Modchu_ModelRenderer) Arms[1]).isInvertX = true;
    	// �o�C�v���_�N�g�G�t�F�N�^�[
    	Arms[2] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[2].setRotationPoint(-3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	Arms[3] = new Modchu_ModelRenderer(this, 0, 0);
    	Arms[3].setRotationPoint(3F, 9F, 6F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).isInvertX = true;
    	// �e�[���\�[�h
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
     * �ӂ���X�J�[�g������
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
    	if (mod_Modchu_ModchuLib.skirtFloats) setMotionY(entityliving.motionY + 0.0784000015258789D > 0 ? 0 : (float) ((entityliving.motionY + 0.0784000015258789D)) * mod_Modchu_ModchuLib.skirtFloatsVolume);

    	if (modelCaps != null) {
    		// ��LMM�p ��p
    		if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
    				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entityliving)) {
    			setLivingAnimationsAfter(entityliving, f, f1, f2);
    		} else {
    			if (modelCaps instanceof PFLM_ModelData) ((PFLM_ModelData) modelCaps).setLivingAnimationsBefore(this, entityliving, f, f1, f2);
    		}
    	}

    	setLivingAnimationsLM(entityliving, f, f1, f2);

    	if (modelCaps != null) {
    		// ��LMM�p ��p
    		if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
    				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entityliving)) {
    			setLivingAnimationsAfter(entityliving, f, f1, f2);
    		} else {
    			((PFLM_ModelData) modelCaps).setLivingAnimationsAfter(this, entityliving, f, f1, f2);
    		}
    	}

    }

    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (entity != null) ;else return;

    	if (modelCaps != null) {
    		if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
    				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entity)) {
    		} else {
    			((PFLM_ModelData) modelCaps).setRotationAnglesBefore(this, f, f1, f2, f3, f4, f5, entity);
    		}
    	}

    	setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

    	if (modelCaps != null) {
    		if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
    				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entity)) {
    		} else {
    			((PFLM_ModelData) modelCaps).setRotationAnglesAfter(this, f, f1, f2, f3, f4, f5, entity);
    		}
    	}

    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    @Override
    public void renderItems(EntityLiving pEntity, Render pRender) {
    	if (modelCaps != null) {
    		if (mod_Modchu_ModchuLib.oldRenderItems
    				&& mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
    				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(pEntity)) {
    			OldRenderItemsLM(pEntity, pRender);
    		} else renderItemsLM(pEntity, pRender);
    	}
    }

	public void renderItemsLM(EntityLiving pEntity, Render pRender) {
		// �莝���̕\��
		GL11.glPushMatrix();
		boolean lflag = true;
		if (modelCaps != null) {
			ItemStack[] litemstacks = (ItemStack[])modelCaps.getCapsValue(caps_Items);
			EnumAction[] lactions = (EnumAction[])modelCaps.getCapsValue(caps_Actions);
			if (litemstacks != null) {
				Object Arms;
				for (int i = 0; i < litemstacks.length; i++) {
					Arms = getArms(i);
					if (Arms != null
							&& litemstacks[i] != null) {
						Modchu_Reflect.invokeMethod(Arms.getClass(), "loadMatrix", Arms);
						Modchu_Reflect.invokeMethod(Arms.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class }, Arms, new Object[]{ pEntity, pRender, false, lactions[i] ,litemstacks[i] });
					}
				}
				lflag = false;
			}
			// ���������i
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
					int slot = pEntity instanceof EntityPlayer ? 10 : 16;
					ItemStack litemstack1 = (ItemStack) Modchu_Reflect.invokeMethod(InventoryPlayer.class, "a", "getStackInSlot", new Class[]{ int.class }, inventory, new Object[]{ slot });
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

			// �A�[�}�[���������i �Ή�
			litemstack = (ItemStack) getCapsValue(caps_armorItemInSlot, 3);
			if (litemstack != null) {
				addSupport = addSupportChecks(pEntity, litemstack);
				headMountRenderItems(pEntity, pRender, litemstack, addSupport);
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
    	// �莝���̕\��
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

    	// ���������i
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

    public void headMountRenderItems(EntityLiving pEntity, Render pRender, ItemStack litemstack, int addSupport) {
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
    		Object inventory = modelCaps.getCapsValue(caps_Inventory);
    		float scale = 1.0F;
    		if (inventory != null) {
    			int slot = pEntity instanceof EntityPlayer ? 10 : 16;
    			ItemStack litemstack2 = (ItemStack) Modchu_Reflect.invokeMethod(InventoryPlayer.class, "a", "getStackInSlot", new Class[]{ int.class }, inventory, new Object[]{ slot });
    			Object HeadMount = getHeadMount();
    			if (HeadMount != null) ;else return;
    			Modchu_Reflect.invokeMethod(HeadMount.getClass(), "loadMatrix", HeadMount);
    			if (isPlanter
    					|| (addSupport > -1 && addSupport < 3)) {
    				equippedItemPositionFlower();
    			}
    			if (litemstack2 != null) {
    				Item item2 = litemstack2.getItem();
    				if (item2 == item2.dyePowder) {
    					scale = 1.0F + (0.2F * litemstack2.getItemDamage());
    				}
    			}
    		}
    		Modchu_Reflect.invokeMethod(HeadMount.getClass(), "renderItems", new Class[]{ EntityLiving.class, Render.class, boolean.class, EnumAction.class, ItemStack.class, float.class, int.class }, HeadMount, new Object[]{ pEntity, pRender, true, null, litemstack, scale, addSupport });
    	}
    }

    /**
     * PlayerFormLittleMaid�Œǉ��Ή������u���b�N�E�A�C�e�����`�F�b�N
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

    /**
     * PlayerFormLittleMaid��pPlayer�p����
     * setRotationAngles �Ăяo����ɒʏ펋�_���Ȃ�Ă΂��B
     * �ʏ펋�_���̎�̕`��ʒu�A�p�x����������B
     */
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    /**
     * GUI �p�[�c�\���E��\�� �����ݒ� ���ׂẴp�[�c�������擾�����X�g�ɒǉ�
     */
    public void showPartsInit() {
    	if (getCapsValueInt(caps_armorType) != 0) return;
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
     * GUI �p�[�c�\���E��\���p���X�g�ǉ�
     */
    public void addShowParts(String[] s) {
    	if (s != null) ;else return;
    	for(int i1 = 0; i1 < s.length; i1++) {
    		getShowPartsList().add(s[i1]);
    	}
    }

    /**
     * GUI �p�[�c�\���E��\���p �{�^����\�����X�g�ǉ�
     */
    public void showPartsHideListadd(String[] s) {
    	for(int i = 0; i < s.length; i++) {
    		getShowPartsHideList().add(s[i]);
    	}
    }

    /**
     * GUI �p�[�c�\���E��\���p���X�g�폜
     */
    public void showPartsListRemove(String s) {
    	getShowPartsList().remove(s);
    }

    /**
     * GUI �p�[�c�\���E��\���p���X�g�폜
     */
    public void showPartsListRemove(String[] s) {
    	for(int i = 0; i < s.length; i++) {
    		getShowPartsList().remove(s[i]);
    	}
    }

    /**
     * GUI �p�[�c�\���E��\���p �{�^���\�������l�[���p�ǉ�
     */
    public void addShowPartsReneme(String[] s1, String[] s2) {
    	for(int i = 0; i < s1.length && i < s2.length; i++) {
    		getShowPartsReneme().put(s1[i], s2[i]);
    	}
    }

    /**
     * GUI �p�[�c�\���E��\���p���f���p�[�c���X�g�ǉ�
     */
    public void addModelRendererMap(String[] s, Field[] model) {
    	if (s != null
    			&& model != null) ;else return;
    	for(int i = 0; i < s.length; i++) {
    		getModelRendererMap().put(s[i], model[i]);
    	}
    }

    /**
     * GUI �p�[�c�\���E��\�� ���f������������PFLM_Gui Customize Default�{�^���������ꂽ���A
     * setParts�̑O�ɌĂ΂��B�����擾���ꂽ���X�g�̕ҏW�Ȃ�
     */
    public void defaultPartsSettingBefore() {
    }

    /**
     * GUI �p�[�c�\���E��\�� ���f������������PFLM_Gui Customize Default�{�^���������ꂽ���A
     * setParts�̌�ɌĂ΂��B�f�t�H���gOFF�ɂ���ݒ�Ȃ�
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

    public HashMap<String, Boolean> getGuiParts() {
    	return (HashMap<String, Boolean>) getFieldObject(mod_Modchu_ModchuLib.PFLM_Gui, "parts");
    }

    public HashMap<Integer, String> getShowPartsNemeList() {
    	return (HashMap<Integer, String>) getFieldObject(mod_Modchu_ModchuLib.PFLM_Gui, "showPartsNemeList");
    }

    public HashMap<String, String> getShowPartsReneme() {
    	return (HashMap<String, String>) getFieldObject(mod_Modchu_ModchuLib.PFLM_Gui, "showPartsReneme");
    }

    /**
     * GUI �p�[�c�\���E��\�����f
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
    				if (model != null) setCapsValue(caps_visible, model, parts.get(s2));
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }

    /**
     * indexOf�Ō����Ώۂ̃p�[�c���܂Ƃ߂Ďw��p�[�c�Ɠ�����ԂɃZ�b�g����
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
    				setCapsValue(caps_visible, (ModelRenderer) getModelRendererMap().get(s0).get(this), b);
    			} catch (Exception e) {
    				//e.printStackTrace();
    			}
    		}
    	}
    }

    /**
     * indexOf�Ō����Ώۂ̃p�[�c���܂Ƃ߂Ďw��boolean�ɃZ�b�g����
     */
    public void indexOfAllSetVisible(String s, boolean b) {
    	String s0 = null;
    	for(int i1 = 0; i1 < getShowPartsList().size(); i1++) {
    		s0 = getShowPartsList().get(i1);
    		if (s0.indexOf(s) > -1) {
    			try {
    				setCapsValue(caps_visible, (ModelRenderer) getModelRendererMap().get(s0).get(this), b);
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
     * �V���[�g�J�b�g�A�N�V�������ɌĂ΂��
     */
    public void actionInit(int i) {
    	setCapsValue(caps_runActionNumber, i);
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
    	setCapsValue(caps_shortcutKeysAction, true);
    	boolean b = false;
    	setCapsValue(caps_visible, bipedLeftArm, b);
    	setCapsValue(caps_visible, bipedRightArm, b);
    	setCapsValue(caps_visible, bipedLeftLeg, b);
    	setCapsValue(caps_visible, bipedRightLeg, b);
    	b = true;
    	if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_visible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_visible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_visible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_visible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_visible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_visible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_visible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_visible, leftLegPlus2, b);
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
    	setCapsValue(caps_sneakBan, true);
    	setCapsValue(caps_waitBan, true);
    	setCapsValue(caps_sittingBan, true);
    }

    public void actionInit2() {
    	setCapsValue(caps_shortcutKeysAction, true);
    	setCapsValue(caps_actionCount, 0);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionInit3() {
    	setCapsValue(caps_shortcutKeysAction, true);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionInit4() {
    	setCapsValue(caps_shortcutKeysAction, true);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionInit5() {
    	setCapsValue(caps_shortcutKeysAction, true);
    }

    public void actionInit6() {
    	setCapsValue(caps_shortcutKeysAction, true);
    }

    public void actionInit7() {
    	setCapsValue(caps_shortcutKeysAction, true);
    }

    public void actionInit8() {
    	setCapsValue(caps_shortcutKeysAction, true);
    }

    public void actionInit9() {
    	setCapsValue(caps_shortcutKeysAction, true);
    }

    public void actionInit30() {
    	setCapsValue(caps_shortcutKeysAction, true);
    }

    /**c
     * �V���[�g�J�b�g�A�N�V�����������ɌĂ΂��B
     */
    public void actionRelease(int i) {
    	switch(getCapsValueInt(caps_runActionNumber)) {
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
    	setCapsValue(caps_shortcutKeysAction, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);

    	boolean b = true;
    	setCapsValue(caps_visible, bipedLeftArm, b);
    	setCapsValue(caps_visible, bipedRightArm, b);
    	setCapsValue(caps_visible, bipedLeftLeg, b);
    	setCapsValue(caps_visible, bipedRightLeg, b);
    	b = false;
    	if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_visible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_visible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_visible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_visible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_visible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_visible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_visible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_visible, leftLegPlus2, b);

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
    	setCapsValue(caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease3() {
    	setCapsValue(caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease4() {
    	setCapsValue(caps_shortcutKeysAction, false);
    	setCapsValue(caps_waitBan, false);
    }

    public void actionRelease5() {
    	setCapsValue(caps_shortcutKeysAction, false);
    }

    public void actionRelease6() {
    	setCapsValue(caps_shortcutKeysAction, false);
    }

    public void actionRelease7() {
    	setCapsValue(caps_shortcutKeysAction, false);
    }

    public void actionRelease8() {
    	setCapsValue(caps_shortcutKeysAction, false);
    }

    public void actionRelease9() {
    	setCapsValue(caps_shortcutKeysAction, false);
    }

    public void actionRelease30() {
    	setCapsValue(caps_shortcutKeysAction, false);
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
    	// �������ϳ�(߁��)
    	float speed = getCapsValueFloat(caps_actionSpeed) / 10;
    	//Modchu_Debug.mDebug("action1 "+(getCapsValueFloat(caps_actionSpeed))+" speed="+speed+" Type="+getCapsValue(caps_armorType));
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
    	if (!getCapsValueBoolean(caps_actionReverse)) {
    		if (f1 < 0.5F) {
    			f1 += speed;
    		} else setCapsValue(caps_actionReverse, true);
    	} else {
    		if (f1 > -0.3F) {
    			f1 -= speed;
    		} else setCapsValue(caps_actionReverse, false);
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
    	// ����グ�郂�[�V����
    	((ModelRenderer) getCapsValue(caps_bipedRightArm)).rotateAngleX -= 0.2F;
    	((ModelRenderer) getCapsValue(caps_bipedRightArm)).rotateAngleY -= 1.0F;
    	((ModelRenderer) getCapsValue(caps_bipedRightArm)).rotateAngleZ += getCapsValueInt(caps_dominantArm) == 0 ? 2.1F : -2.1F;
    }

    public void action3(Entity entity) {
    	// ����グ�ĐU�郂�[�V����
    	//Modchu_Debug.mDebug("armorType="+armorType+" actionSpeed="+actionSpeed);
    	float actionSpeed = getCapsValueFloat(caps_actionSpeed);
    	if (actionSpeed < 0.0F) return;
    	int i = (int) (actionSpeed * 2);
    	if (i < 0) i = 0;
    	boolean actionReverse = getCapsValueBoolean(caps_actionReverse);
    	int actionCount = getCapsValueInt(caps_actionCount);
    	actionCount = (int) (actionReverse ? actionCount - i : actionCount + i);
    	setCapsValue(caps_actionCount, actionCount);
    	//Modchu_Debug.mDebug("actionReverse="+actionReverse+" actionCount="+actionCount+" "+((float) (actionCount - 15)) / 30.0F);
    	((ModelRenderer) getCapsValue(caps_bipedRightArm)).rotateAngleZ = 2.0F - ((float) (actionCount - 15)) / 20.0F;
    	if (getCapsValueInt(caps_dominantArm) == 1) ((ModelRenderer) getCapsValue(caps_bipedRightArm)).rotateAngleZ = -((ModelRenderer) getCapsValue(caps_bipedRightArm)).rotateAngleZ;
    	if (actionCount > 30) {
    		setCapsValue(caps_actionReverse, true);
    		setCapsValue(caps_actionCount, 30);
    	}
    	if (actionCount < 0) {
    		setCapsValue(caps_actionReverse, false);
    		setCapsValue(caps_actionCount, 0);
    	}
    }

    public void action4(Entity entity) {
    	// �����O�ɏo�����[�V����
    	if (getOnGround(getCapsValueInt(caps_dominantArm)) > 0.0F) {
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
    	//�f�o�b�N�p
    	if (getClass().getPackage() == null) return;
    	boolean b = true;
    	if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    	if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    	if (rightArmPlus != null) setCapsValue(caps_visible, rightArmPlus, b);
    	if (rightArmPlus2 != null) setCapsValue(caps_visible, rightArmPlus2, b);
    	if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    	if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    	if (leftArmPlus != null) setCapsValue(caps_visible, leftArmPlus, b);
    	if (leftArmPlus2 != null) setCapsValue(caps_visible, leftArmPlus2, b);
    	if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	if (rightLegPlus != null) setCapsValue(caps_visible, rightLegPlus, b);
    	if (rightLegPlus2 != null) setCapsValue(caps_visible, rightLegPlus2, b);
    	if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	if (leftLegPlus != null) setCapsValue(caps_visible, leftLegPlus, b);
    	if (leftLegPlus2 != null) setCapsValue(caps_visible, leftLegPlus2, b);
    }

    /**
     * �A�[�}�[���f���ƃ��C�����f���̓����B
     * �A�[�}�[���f���ɑ΂��āA���C�����f���̃f�[�^���n����Ă���̂ł���ɍ��킹��p�[�c�𓯊�������
     */
    public void syncModel(MultiModelBaseBiped model) {
    	if (getCapsValueInt(caps_runActionNumber) == 1
    			| getCapsValueInt(caps_runActionNumber) == 3) bipedBody.rotateAngleZ = model.bipedBody.rotateAngleZ;
    }

    /**
     * setRotationAnglesLM���s�O�ɌĂ΂��B
     * �e�p�[�c�̏������ȂǁB
     */
    public abstract void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity);

    /**
     * �J���[�ؑ֎��Ɏ��s�����R�[�h
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
     * ��Mob�𓪂ɏ悹�����̑�Mob��ʒu����
     */
    public double getMountedYOffset() {
    	return 0.75D;
    }

    /**
     * �����Ă���|�[�Y�u��蕨�ɏ���Ă��Ȃ��v���̈ʒu����
     */
    public double getSittingyOffset() {
    	return -0.35D;
    }

    /**
     * �Q�Ă���|�[�Y���̈ʒu����
     */
    public double getSleepingyOffset() {
    	return -0.9D;
    }

    /**
     * isModelSize=true���ɏ�蕨�ɏ���Ă����Ԃł̃J�����ʒu����
     */
    public float ridingViewCorrection() {
    	return 0.0F;
    }

    /**
     * �f�t�H���g���f���X�P�[��
     */
    public float getModelScale() {
    	return 0.9375F;
    }

    /**
     * ���ꓪ�\���A�C�e���u�Ԍn�v�̈ʒu����
     */
    public void equippedItemPositionFlower() {
    	GL11.glTranslatef(0F, -0.5F, 0F);
    }

    public void setArmorBipedHeadShowModel(boolean b) {
    	setCapsValue(caps_visible, bipedHead, b);
    }

    public void setArmorBipedBodyShowModel(boolean b) {
    	setCapsValue(caps_visible, bipedBody, b);
    }

    public void setArmorBipedRightArmShowModel(boolean b) {
    	if (getCapsValueBoolean(caps_shortcutKeysAction)
    			&& getCapsValueInt(caps_runActionNumber) == 0
    			| getCapsValueInt(caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedRightArm, false);
    		if (rightArm != null) setCapsValue(caps_visible, rightArm, b);
    		if (rightArm2 != null) setCapsValue(caps_visible, rightArm2, b);
    		if (rightHand != null) setCapsValue(caps_visible, rightHand, b);
    	}
    	else setCapsValue(caps_visible, bipedRightArm, b);
    }

    public void setArmorBipedLeftArmShowModel(boolean b) {
    	if (getCapsValueBoolean(caps_shortcutKeysAction)
    			&& getCapsValueInt(caps_runActionNumber) == 0
    			| getCapsValueInt(caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedLeftArm, false);
    		if (leftArm != null) setCapsValue(caps_visible, leftArm, b);
    		if (leftArm2 != null) setCapsValue(caps_visible, leftArm2, b);
    		if (leftHand != null) setCapsValue(caps_visible, leftHand, b);
    	}
    	else setCapsValue(caps_visible, bipedLeftArm, b);
    }

    public void setArmorBipedRightLegShowModel(boolean b) {
    	if (getCapsValueBoolean(caps_shortcutKeysAction)
    			&& getCapsValueInt(caps_runActionNumber) == 0
    			| getCapsValueInt(caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedRightLeg, false);
    		if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    		if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	}
    	else setCapsValue(caps_visible, bipedRightLeg, b);
    }

    public void setArmorBipedLeftLegShowModel(boolean b) {
    	if (getCapsValueBoolean(caps_shortcutKeysAction)
    			&& getCapsValueInt(caps_runActionNumber) == 0
    			| getCapsValueInt(caps_runActionNumber) == 1) {
    		setCapsValue(caps_visible, bipedLeftLeg, false);
    		if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    		if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	}
    	else setCapsValue(caps_visible, bipedLeftLeg, b);
    }

    public void setArmorSkirtShowModel(boolean b) {
    }

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		if (modelCaps != null) {
			Object o = modelCaps.getCapsValue(pIndex, pArg);
			if (o != null) return o;
		}
		switch (pIndex) {
		case caps_Grounds:
			return getGrounds();
		case caps_getIsSneak:
			return getIsSneak();
		case caps_getIsRiding:
			return getIsRiding();
		case caps_isRiding:
			return isRiding;
		case caps_aimedBow:
			return getaimedBow();
		case caps_getIsWait:
			return getIsWait();
		case caps_isSitting:
			return getIsSitting();
		case caps_getIsSleeping:
			return getIsSleeping();
		case caps_firstPerson:
			return getFirstPerson();
		case caps_armorType:
			return getArmorType();
		case caps_oldwalking:
			return getOldwalking();
		case caps_isItemHolder:
			return isItemHolder();
		case caps_actionFlag:
			return getActionFlag();
		case caps_actionCount:
			return getActionCount();
		case caps_motionY:
			return getMotionY();
		case caps_showModelFlag:
			return getShowModelFlag();
		case caps_shortcutKeysAction:
			return getShortcutKeysAction();
		case caps_runActionNumber:
			return getRunActionNumber();
		case caps_skirtFloats:
			return getSkirtFloats();
		case caps_bipedHead:
			return getBipedHead();
		case caps_bipedRightArm:
			return getBipedRightArm();
		case caps_notDominantArm:
			return getNotDominantArm();
		case caps_Physical_Hammer:
			return Physical_Hammer();
		case caps_height:
			return getHeight();
		case caps_width:
			return getWidth();
		case caps_YOffset:
			return getyOffset();
		case caps_convertDegtoRad:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return convertDegtoRad((Float) pArg[0]);
		case caps_className:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) return getClassName((String) pArg[0]);
		case caps_textureList:
			return getTextureList();
		case caps_pastX:
			return getPastX();
		case caps_pastY:
			return getPastY();
		case caps_pastZ:
			return getPastZ();
		case caps_sneakBan:
			return getSneakBan();
		case caps_aimedBowBan:
			return getAimedBowBan();
		case caps_waitBan:
			return getWaitBan();
		case caps_sittingBan:
			return getSittingBan();
		case caps_sleepingBan:
			return getSleepingBan();
		case caps_ridingBan:
			return getRidingBan();
		case caps_modchuRemodelingModel:
			return getModchuRemodelingModel();
		case caps_actionSpeed:
			return getActionSpeed();
		case caps_actionReverse:
			return getActionReverse();
		case caps_sittingyOffset:
			return getSittingyOffset();
		case caps_sleepingyOffset:
			return getSleepingyOffset();

		//modelCaps�����@�\������LMM�΍�
		case caps_texture:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) return getTexture((String) pArg[0], (Integer) pArg[1]);
		case caps_maidColor:
			return getMaidColor((Entity) pArg[0]);
		}
		return super.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object ...pArg) {
		switch (pIndex) {
		case caps_isRiding:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsRiding((Boolean) pArg[0]);
			return true;
		case caps_isSneak:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsSneak((Boolean) pArg[0]);
			return true;
		case caps_onGround:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setOnGround((Float) pArg[0]);
			return true;
		case caps_oldwalking:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setOldwalking((Boolean) pArg[0]);
			return true;
		case caps_isItemHolder:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setIsItemHolder((Integer) pArg[0]);
			return true;
		case caps_firstPerson:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setFirstPerson((Boolean) pArg[0]);
			return true;
		case caps_actionCount:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionCount((Integer) pArg[0]);
			return true;
		case caps_armorType:
			if (pArg != null
			&& pArg[0] != null) setArmorType((Integer) pArg[0]);
			return true;
		case caps_actionFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionFlag((Boolean) pArg[0]);
			return true;
		case caps_motionY:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setMotionY((Float) pArg[0]);
			return true;
		case caps_showModelFlag:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setShowModelFlag((Integer) pArg[0]);
			return true;
		case caps_shortcutKeysAction:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setShortcutKeysAction((Boolean) pArg[0]);
			return true;
		case caps_runActionNumber:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setRunActionNumber((Integer) pArg[0]);
			return true;
		case caps_renderFirstPersonHand:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) renderFirstPersonHand((Float) pArg[0]);
			return true;
		case caps_visible:
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
		case caps_pastX:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[0].getClass().isInstance(float[].class)) setPastX((float[]) pArg[0]);
				else {
					if (pArg[1] != null) setPastX((Integer) pArg[0], (Float) pArg[1]);
				}
			}
			return true;
		case caps_pastY:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[0].getClass().isInstance(float[].class)) setPastY((float[]) pArg[0]);
				else {
					if (pArg[1] != null) setPastY((Integer) pArg[0], (Float) pArg[1]);
				}
			}
			return true;
		case caps_pastZ:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[0].getClass().isInstance(float[].class)) setPastZ((float[]) pArg[0]);
				else {
					if (pArg[1] != null) setPastZ((Integer) pArg[0], (Float) pArg[1]);
				}
			}
			return true;
		case caps_sneakBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setSneakBan((Boolean) pArg[0]);
			return true;
		case caps_aimedBowBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setAimedBowBan((Boolean) pArg[0]);
			return true;
		case caps_aimedBow:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setAimedBow((Boolean) pArg[0]);
			return true;
		case caps_waitBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setWaitBan((Boolean) pArg[0]);
			return true;
		case caps_sittingBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setSittingBan((Boolean) pArg[0]);
			return true;
		case caps_sleepingBan:
			if (pArg != null
			&& pArg[0] != null) setSleepingBan((Boolean) pArg[0]);
			return true;
		case caps_ridingBan:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setRidingBan((Boolean) pArg[0]);
			return true;
		case caps_indexOfAllVisible:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg[1] != null) indexOfAllSetVisible((String) pArg[0], (Boolean) pArg[1]);
				else indexOfAllSetVisible((String) pArg[0]);
			}
			return true;
		case caps_modchuRemodelingModel:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setModchuRemodelingModel((Boolean) pArg[0]);
			return true;
		case caps_actionSpeed:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionSpeed((Float) pArg[0]);
			return true;
		case caps_actionReverse:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) setActionReverse((Boolean) pArg[0]);
			return true;
		case caps_changeModel:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) changeModel((EntityLiving) pArg[0]);
			return true;
		case caps_showPartsInit:
			showPartsInit();
			return true;
		case caps_actionInit:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) actionInit((Integer) pArg[0]);
			return true;
		case caps_actionRelease:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) actionRelease((Integer) pArg[0]);
			return true;
		case caps_syncModel:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) syncModel((MultiModelBaseBiped) pArg[0]);
			return true;
		}
		return super.setCapsValue(pIndex, pArg);
	}

	private int getMaidColor(Entity entity) {
		Object o = null;
		if (modelCaps != null) o = modelCaps.getCapsValue(caps_maidColor);
		if (o != null) return (Integer) o;
		if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entity)) {
			o = (Integer) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.LMM_EntityLittleMaid, "maidColor", entity);
		}
		if (o != null) return (Integer) o;
		return 0;
	}

	private String getTexture(String s, int i) {
		Object o = null;
		if (modelCaps != null) {
			o = modelCaps.getCapsValue(caps_texture, s, i);
			if (o != null) return  (String) o;
		}
		//Modchu_Debug.mDebug("getTexture o ="+o);
		o = (String) Modchu_Reflect.invokeMethod(mod_Modchu_ModchuLib.MMM_TextureManager, "getTextureName", new Class[]{ String.class, int.class }, null, new Object[]{ s, i });
		return (String) o;
	}

    private float getOnGround()
    {
    	return onGround;
    }

    private float getOnGround(int i) {
    	if (getCapsValueInt(caps_dominantArm) == i) {
    		//Modchu_Debug.mDebug("getOnGround()="+getOnGround() +" i="+i);
    		return getGrounds()[i];
    	}
    	return 0.0F;
    }

    private float[] getGrounds() {
    	if (modelCaps != null) {
    		Object o = modelCaps.getCapsValue(caps_Grounds);
    		if (o != null) return (float[]) o;
    	}
    	float[] f = new float[]{ 0.0F, 0.0F };
    	int i = getCapsValueInt(caps_dominantArm);
    	if (i < f.length) {
    		//Modchu_Debug.mDebug("getOnGround()="+getOnGround() +" i="+i);
    		f[i] = getOnGround();
    	}
    	return f;
    }

    private float setOnGround(float f)
    {
    	return onGround = f;
    }

    private void setIsItemHolder(int i) {
    	heldItemRight = i;
    }

    private boolean getIsRiding()
    {
    	return isRiding && !ridingBan;
    }

    private void setIsRiding(boolean b)
    {
    	isRiding = b;
    }

    private boolean getIsSneak()
    {
    	return isSneak && !sneakBan;
    }

    private void setIsSneak(boolean b)
    {
    	isSneak = b;
    }

    private boolean getIsSleeping()
    {
    	return getCapsValueBoolean(caps_isSleeping) && !sleepingBan;
    }

    private boolean getaimedBow()
    {
    	return aimedBow && !aimedBowBan;
    }

    private boolean getIsWait()
    {
    	return getCapsValueBoolean(caps_isWait) && !waitBan;
    }

    private boolean getIsSitting()
    {
    	if (modelCaps != null) return modelCaps.getCapsValueBoolean(caps_isSitting) && !sittingBan;
    	return false;
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

    private boolean getAimedBow()
    {
    	return aimedBow;
    }

    private void setAimedBow(boolean b)
    {
    	aimedBow = b;
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

    private int getShowModelFlag()
    {
    	return showModelFlag;
    }

    private void setShowModelFlag(int i) {
    	showModelFlag = i;
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

    private boolean getSkirtFloats() {
    	return mod_Modchu_ModchuLib.skirtFloats;
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
    	if (modelCaps != null) {
    		return modelCaps.getCapsValueBoolean(caps_isLookSuger, entity);
    	}
    	return false;
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
    	return mod_Modchu_ModchuLib.modchuRemodelingModel;
    }

    private void setModchuRemodelingModel(boolean b) {
    	mod_Modchu_ModchuLib.modchuRemodelingModel = b;
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

    public float Physical_Hammer() {
    	return (Float) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.mod_PFLM_PlayerFormLittleMaid, "Physical_Hammer");
    }

    public ModelRenderer getBipedHead() {
    	return bipedHead;
    }

    public ModelRenderer getBipedRightArm() {
    	if (getCapsValueInt(caps_dominantArm) == 0) return bipedRightArm;
    	return bipedLeftArm;
    }

    public ModelRenderer getNotDominantArm() {
    	if (getCapsValueInt(caps_dominantArm) == 0) return bipedLeftArm;
    	return bipedRightArm;
    }

	public void renderFirstPersonHand(float f) {
    	((ModelRenderer) getCapsValue(caps_bipedRightArm)).render(f);
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

    // �ȉ��ALMM_EntityCaps���ɂ����Ăق�������
	/**
     * LMM��p����
     * setLivingAnimations �Ăяo����ɌĂ΂��B
     */
    public void setLivingAnimationsAfter(Entity entity, float f, float f1, float f2) {
    	float angle = modelCaps.getCapsValueFloat(caps_interestedAngle, f2);
    	bipedHead.rotateAngleZ = angle;
    }
}
