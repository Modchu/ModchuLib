package net.minecraft.src;

/*//b181delete
import java.util.HashMap;
import java.util.Map;
*///b181delete
//b173deleteimport java.util.List;
import java.lang.reflect.Field;
import java.util.Map;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class ModelPlayerFormLittleMaid extends ModelPlayerFormLittleMaidBaseBiped {

    public Modchu_ModelRenderer ChignonR;
    public Modchu_ModelRenderer ChignonL;
    public Modchu_ModelRenderer ChignonB;
    public Modchu_ModelRenderer Tail;
    public Modchu_ModelRenderer SideTailR;
    public Modchu_ModelRenderer SideTailL;
    public Modchu_ModelRenderer Skirt;
    public Modchu_ModelRenderer SkirtTop;
    public Modchu_ModelRenderer SkirtFront;
    public Modchu_ModelRenderer SkirtRight;
    public Modchu_ModelRenderer SkirtLeft;
    public Modchu_ModelRenderer SkirtBack;
    public boolean skirtFloats = false;

    public ModelPlayerFormLittleMaid() {
    	this(0.0F);
    }

    public ModelPlayerFormLittleMaid(float f) {
    	this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid(float f, float f1) {
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1, 64, 32);
    }

    public ModelPlayerFormLittleMaid(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
    	if (isPFLM) skirtFloats = getSkirtFloats();
    }

    @Override
    public void initModel(float f, float f1) {
    	f1 += 8F;
    	bipedCloak = new ModelRenderer(this);
    	bipedEars = new ModelRenderer(this);
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	bipedHead.addChild(HeadMount);
    	bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
    	bipedHeadwear.addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);
    	bipedHead.addChild(bipedHeadwear);
    	bipedBody = new Modchu_ModelRenderer(this, 32, 8);
    	bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
    	bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
    	bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	bipedBody.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
    	bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	bipedBody.addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	bipedBody.addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	bipedBody.addChild(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	Skirt.addBoxLM(-4F, -4F, -4F, 8, 8, 8, f);
    	bipedBody.addChild(Skirt);
    	ChignonR = new Modchu_ModelRenderer(this, 24, 18);
    	ChignonR.addBoxLM(-5F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 24, 18);
    	ChignonL.addBoxLM(4F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonL);
    	ChignonB = new Modchu_ModelRenderer(this, 52, 10);
    	ChignonB.addBoxLM(-2F, -7.2F, 4F, 4, 4, 2, f);
    	ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonB);
    	Tail = new Modchu_ModelRenderer(this, 46, 20);
    	Tail.addBoxLM(-1.5F, -6.8F, 4F, 3, 9, 3, f);
    	Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Tail);
    	SideTailR = new Modchu_ModelRenderer(this, 58, 21);
    	SideTailR.addBoxLM(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 58, 21);
    	SideTailL.mirror = true;
    	SideTailL.addBoxLM(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailL);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);

    	skirtFloatsInit(f, f1);
    	actionPartsInit(f, f1);
    }

    /**
     * action用手足分割パーツ初期化
     */
    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 48, 0);
    	rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	rightArmPlus = new Modchu_ModelRenderer(this);
    	//rightArmPlus.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	rightArmPlus.rotateAngleX = 1.570796313F;
    	rightArm.addChild(rightArmPlus);

    	rightArm2 = new Modchu_ModelRenderer(this, 48, 3);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	rightArmPlus2 = new Modchu_ModelRenderer(this);
    	rightArmPlus2.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	rightArmPlus2.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	rightArmPlus2.rotateAngleX = 1.570796313F;
    	rightArm2.addChild(rightArmPlus2);

    	rightHand = new Modchu_ModelRenderer(this, 48, 6);
    	rightHand.addBoxLM(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 56, 0);
    	leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	leftArmPlus = new Modchu_ModelRenderer(this);
    	//leftArmPlus.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	leftArmPlus.rotateAngleX = 1.570796313F;
    	leftArm.addChild(leftArmPlus);

    	leftArm2 = new Modchu_ModelRenderer(this, 56, 3);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	leftArmPlus2 = new Modchu_ModelRenderer(this);
    	leftArmPlus2.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	leftArmPlus2.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	leftArmPlus2.rotateAngleX = 1.570796313F;
    	leftArm2.addChild(leftArmPlus2);

    	leftHand = new Modchu_ModelRenderer(this, 56, 6);
    	leftHand.addBoxLM(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	rightLeg.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);
    	rightLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	rightLegPlus.rotateAngleX = 1.570796313F;
    	rightLeg.addChild(rightLegPlus);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	rightLeg2.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	rightLegPlus2.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	rightLegPlus2.setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	rightLegPlus2.rotateAngleX = 1.570796313F;
    	rightLeg2.addChild(rightLegPlus2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	leftLeg.mirror = true;
    	leftLeg.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus.mirror = true;
    	leftLegPlus.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	leftLegPlus.rotateAngleX = 1.570796313F;
    	leftLeg.addChild(leftLegPlus);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	leftLeg2.mirror = true;
    	leftLeg2.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(leftLeg2);

    	leftLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus2.mirror = true;
    	leftLegPlus2.setTextureOffset(36, 19).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	leftLegPlus2.setTextureOffset(39, 19).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	leftLegPlus2.rotateAngleX = 1.570796313F;
    	leftLeg2.addChild(leftLegPlus2);

    	rightHand.showModel = leftHand.showModel =
    		rightArm.showModel = leftArm.showModel =
    			rightArmPlus.showModel = rightArmPlus2.showModel =
    				leftArmPlus.showModel = leftArmPlus2.showModel =
    					rightLegPlus.showModel = rightLegPlus2.showModel =
    						leftLegPlus.showModel = leftLegPlus2.showModel =
    							rightArm2.showModel = leftArm2.showModel =
    								rightLeg.showModel = rightLeg2.showModel =
    									leftLeg.showModel = leftLeg2.showModel = false;
    	aimedBowBan = false;
    	sneakBan = false;
    	waitBan = false;
    	sittingBan = false;
    	sleepingBan = false;
    }

    /**
     * ふんわりスカート初期化
     * 新仕様にまだ未対応skirtFloats=trueにすべからず
     */
    public void skirtFloatsInit(float f, float f1) {
    	if(!skirtFloats) return;
    	//ふんわりスカート上
    	SkirtTop = new Modchu_ModelRenderer(this, 8, 16);
    	SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtTop.setRotationPoint(-4.0F, 5.0F + f, 4.0F);
    	bipedBody.addChild(SkirtTop);

    	//ふんわりスカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
    	SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtFront.setRotationPoint(-4.0F, 0.0F + f, -4.0F);
    	bipedBody.addChild(SkirtFront);

    	//ふんわりスカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 24);
    	SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	SkirtRight.setRotationPoint(-4.0F, 0.0F + f, 4.0F);
    	bipedBody.addChild(SkirtRight);

    	//ふんわりスカート左
    	SkirtLeft = new Modchu_ModelRenderer(this, 16, 24);
    	SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	SkirtLeft.setRotationPoint(4.0F, 0.0F + f, -4.0F);
    	bipedBody.addChild(SkirtLeft);

    	//ふんわりスカート後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 24, 24);
    	SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtBack.setRotationPoint(-4.0F, 0.0F + f, 4.0F);
    	bipedBody.addChild(SkirtBack);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	renderLM(entity, f, f1, f2, f3, f4, f5);
    }

    public void renderLM(Entity entity, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
    	//this.entity = entity;
    	setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);
    	mainFrame.render(f5);
/*
		if(skirtFloats) {
			if(SkirtTop.showModel) {
				Skirt.showModel = false;
				SkirtFront.scaleX = SkirtBack.scaleX = 1.0F - (getMotionY() * 1.0F);
				SkirtRight.scaleZ= SkirtLeft.scaleZ = 1.0F - (getMotionY() * 1.0F);
			}
		}
*/
    	if (LMM_EntityLittleMaid != null
    			&& LMM_EntityLittleMaid.isInstance(entity)) {
    		Map map = (Map) getFieldObject(LMM_EntityLittleMaid, "maidStabilizer", entity);
    		renderStabilizer(entity, map, f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
    	}
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	//f = 移動時に増加する
    	//f1 = 増加したり戻ったり。スニーク、移動時は変化量が少し。
    	//f2 = 時間で常に増え続けている
    	//f3 = 向いている方角方向で変化
    	//f4 = 向いている上下方向で変化
    	//f5 = スケール値？
    	reset(f, f1, f2, f3, f4, f5, entity);
    	if (!getFirstPerson()) {
    		bipedHead.rotateAngleY = f3 / 57.29578F;
    		bipedHead.rotateAngleX = f4 / 57.29578F;
    		bipedRightArm.rotateAngleX = MathHelper
    				.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
    		bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1
    				* 0.5F;
    		if (!getIsSneak() && !getIsRiding() && getOldwalking()) {
    			bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    			bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    			bipedLeftArm.rotateAngleZ = (MathHelper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;
    			bipedRightArm.rotateAngleZ = (MathHelper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;
    		} else {
    			bipedRightArm.rotateAngleZ = 0.0F;
    			bipedLeftArm.rotateAngleZ = 0.0F;
    			bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F
    					* f1;
    			bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F)
    					* 1.4F * f1;
    		}
    		bipedRightLeg.rotateAngleY = 0.0F;
    		bipedLeftLeg.rotateAngleY = 0.0F;
    		if (getIsRiding()) {
    			// 乗り物に乗っている
    			bipedRightArm.rotateAngleX += -0.6283185F;
    			bipedLeftArm.rotateAngleX += -0.6283185F;
    			bipedRightLeg.rotateAngleX = -1.256637F;
    			bipedLeftLeg.rotateAngleX = -1.256637F;
    			bipedRightLeg.rotateAngleY = 0.3141593F;
    			bipedLeftLeg.rotateAngleY = -0.3141593F;
    		}
    		// アイテム持ってるときの腕振りを抑える
    		if (heldItemLeft != 0 && !getOldwalking()) {
    			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F
    					- 0.3141593F * (float) heldItemLeft;
    		}
    		if (heldItemRight != 0 && !getOldwalking()) {
    			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F
    					- 0.3141593F * (float) heldItemRight;
    		}
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleY = 0.0F;

    		armSwing(f, f1, f2, f3, f4, f5, entity);

    		bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
    		if (getIsSneak()) {
    			// しゃがみ
    			bipedBody.rotateAngleX = 0.5F;
    			Skirt.rotateAngleX = -0.5F;
    			bipedRightLeg.rotateAngleX -= 0.5F;
    			bipedLeftLeg.rotateAngleX -= 0.5F;
    			bipedHead.rotationPointY = 1.0F;
    			bipedBody.rotationPointY = 4.0F;
    			bipedBody.rotationPointZ = 2.0F;
    			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F - 1.0F;
    			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.25F;
    			Skirt.rotationPointY = 5.5F - 0.5F;
    			Skirt.rotationPointZ = -2.0F;
    			if (skirtFloats) {
    				SkirtFront.rotationPointY = SkirtLeft.rotationPointY = 3.5F;
    				SkirtRight.rotationPointY = 7.3F;
    				SkirtTop.rotationPointY = 7.4F;
    				SkirtBack.rotationPointY = 7.3F;
    				SkirtRight.rotationPointZ = 3.0F;
    				SkirtTop.rotationPointZ = 3.0F;
    				SkirtBack.rotationPointZ = 2.95F;
    				SkirtFront.rotateAngleX = SkirtLeft.rotateAngleX = SkirtBack.rotateAngleX = -bipedBody.rotateAngleX;
    				SkirtRight.rotateAngleX = bipedBody.rotateAngleX;
    				SkirtTop.rotateAngleX = -1.570796313F - bipedBody.rotateAngleX;
    			}
    		} else {
    			// 通常立ち
    			bipedBody.rotateAngleX = 0.0F;
    			Skirt.rotationPointZ = 0.0F;
    			Skirt.rotateAngleX = 0.0F;
    			Skirt.rotationPointY = 5.5F;
    			bipedHead.rotationPointY = 0.0F;
    			bipedBody.rotationPointY = 3.5F;
    			bipedBody.rotationPointZ = 0.0F;
    			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F;
    			if (skirtFloats) {
    				SkirtFront.rotationPointY = SkirtRight.rotationPointY =
    						SkirtLeft.rotationPointY = SkirtBack.rotationPointY = SkirtTop.rotationPointY = 5.0F;
    				SkirtTop.rotationPointZ = 4.0F;
    				SkirtRight.rotationPointZ = 4.0F;
    				SkirtBack.rotationPointZ = SkirtTop.rotationPointZ = 4.0F;
    				SkirtFront.rotateAngleX = SkirtRight.rotateAngleX =
    						SkirtLeft.rotateAngleX = SkirtBack.rotateAngleX = 0.0F;
    				SkirtRight.rotateAngleY = 3.141592653F;
    				SkirtTop.rotateAngleX = -1.570796313F;
    			}
    		}
    		if (skirtFloats) {
    			SkirtFront.rotateAngleX += getMotionY();
    			SkirtRight.rotateAngleZ = -getMotionY();
    			SkirtLeft.rotateAngleZ = getMotionY();
    			SkirtBack.rotateAngleX -= getMotionY();
    		}
    		if (getaimedBow()) {
    			// 弓構え
    			float f6 = MathHelper.sin(onGround * 3.141593F);
    			float f7 = MathHelper.sin((1.0F - (1.0F - onGround)
    					* (1.0F - onGround)) * 3.141593F);
    			bipedRightArm.rotateAngleZ = 0.0F;
    			bipedLeftArm.rotateAngleZ = 0.0F;
    			bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F)
    					+ bipedHead.rotateAngleY;
    			bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F)
    					+ bipedHead.rotateAngleY + 0.4F;
    			bipedRightArm.rotateAngleX = -1.470796F;
    			bipedLeftArm.rotateAngleX = -1.470796F;
    			bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    			bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    			bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    			bipedLeftArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
    			bipedLeftArm.rotateAngleX += bipedHead.rotateAngleX;
    			bipedRightArm.rotationPointX = -3F;
    			bipedLeftArm.rotationPointX = 3F;
    		} else {
    			if (getIsWait()) {
    				// 待機状態
    				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    				bipedRightArm.rotateAngleY = 0.0F;
    				bipedRightArm.rotateAngleZ = -0.4F;
    				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    				bipedLeftArm.rotateAngleY = 0.0F;
    				bipedLeftArm.rotateAngleZ = 0.4F;
    			} else {
    				// 呼吸 腕等
    				bipedRightArm.rotateAngleZ += 0.5F;
    				bipedLeftArm.rotateAngleZ -= 0.5F;
    				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    			}
    		}
    	}
    	//
    	Arms[2].setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedRightArm).getRotateAngleX(), 0F, 0F);
    	Arms[3].setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedLeftArm).getRotateAngleX(), 0F, 0F);
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
    	bipedRightArm.setRotationPoint(-3.0F, -3.0F, 0.0F);
    	bipedLeftArm.setRotationPoint(3.0F, -3.0F, 0.0F);
    	bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);
    	bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
    	Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
    }

    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	float onGroundR = getOnGround(getSwingStatus(entity, 0), entity);
    	//Modchu_Debug.mDebug("firstPersonHand onGroundR="+onGroundR+" getOnGround()="+getOnGround());
    	float onGroundL = getOnGround(getSwingStatus(entity, 1), entity);
    	//Modchu_Debug.mDebug("firstPersonHand onGroundL="+onGroundL+" getOnGround()="+getOnGround());
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !getaimedBow() && !getOldwalking()) {
    		// 腕振り
    		float f6, f7, f8;
    		f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
//            bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
    		Skirt.rotateAngleY = bipedBody.rotateAngleY;
    		bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
    		bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
    		// R
    		if (onGroundR > 0F) {
    			f6 = 1.0F - onGroundR;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			bipedRightArm.rotateAngleZ = MathHelper.sin(onGroundR * 3.141593F) * -0.4F;
    		} else {
    			bipedRightArm.rotateAngleX += bipedBody.rotateAngleY;
    		}
    		// L
    		if (onGroundL > 0F) {
    			f6 = 1.0F - onGroundL;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			//if (!getFirstPerson()) {
    				bipedLeftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    				bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    				bipedLeftArm.rotateAngleZ = MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
    			//}
    		} else {
    			bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
    		}
    	}
    }

    @Override
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (((EntityPlayer) entity).inventory.getCurrentItem() != null) {
    		//地図を持っている時
    		bipedRightArm.rotationPointX = -3.0F;
    		bipedRightArm.rotationPointY = 1.5F;
    		bipedRightArm.rotationPointZ = 0.0F;
    		bipedLeftArm.rotationPointX = -4.5F;
    		bipedLeftArm.rotationPointY = 1.5F;
    		bipedLeftArm.rotationPointZ = 0.0F;
    	} else {
    		//素手時
    		//setOnGround(((EntityPlayer) entity).getSwingProgress(1.0F));
    		bipedRightArm.rotateAngleX = 0.0F;
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = 0.5F;
    		bipedLeftArm.rotateAngleX = 0.0F;
    		bipedLeftArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleZ = 0.0F;

    		bipedRightArm.rotationPointY = 4.0F;
    		bipedLeftArm.rotationPointX = 4.0F;
    		bipedLeftArm.rotationPointY = 8.0F;
    		bipedLeftArm.rotationPointZ = -2.0F;
    	}
    }

    @Override
    public void showAllParts() {
    	// 表示制限を解除してすべての部品を表示
    	setVisible(bipedHead, true);
    	setVisible(bipedBody, true);
    	setVisible(bipedRightArm, true);
    	setVisible(bipedLeftArm, true);
    	setVisible(Skirt, true);
    	setVisible(bipedRightLeg, true);
    	setVisible(bipedLeftLeg, true);
    }

    @Override
    public int showArmorParts(int parts) {
    	// 鎧の表示用
    	boolean f;
    	// 兜
    	f = parts == 3 ? true : false;
    	setArmorBipedHeadShowModel(f);
    	// 鎧
    	f = parts == 2 ? true : false;
    	setArmorBipedBodyShowModel(f);
    	setArmorBipedRightArmShowModel(f);
    	setArmorBipedLeftArmShowModel(f);
    	// 脚甲
    	f = parts == 1 ? true : false;
    	setArmorSkirtShowModel(f);
    	// 臑当
    	f = parts == 0 ? true : false;
    	setArmorBipedRightLegShowModel(f);
    	setArmorBipedLeftLegShowModel(f);

    	return -1;
    }

    /**
     * GUI パーツ表示・非表示設定
     */
    @Override
    public void settingShowParts() {
    	//GUI パーツ表示・非表示初期設定
    	if((Integer) getFieldObject(PFLM_Gui, "partsSetFlag") == 1) {
    		String s[] = {
    				"Head",	"Body", "RightArm", "LeftArm", "RightLeg",
    				"LeftLeg", "Skirt", "Headwear", "ChignonR" ,"ChignonL",
    				"ChignonB", "SideTailR", "SideTailL", "Tail"
    		};
    		setParts(s, 0);
    		setPartsSetFlag(1);
    		setFieldObject(PFLM_Gui, "partsSetFlag", 2);
    	}

    	//GUI パーツ表示・非表示反映
    	if((Boolean) getFieldObject(PFLM_Gui, "showModelFlag")) {
    		setShowModelFlag(0);
    		superShowModelSettingReflects(0);
    		setFieldObject(PFLM_Gui, "showModelFlag", false);
    	} else {
    		setShowModelFlag(-1);
    	}
    }

    @Override
    public void superShowModelSettingReflects(int i) {
    	boolean[] b0 = (boolean[]) Modchu_Reflect.getFieldObject(PFLM_Gui, "showModel");
    	boolean b = b0[i];
    	if (bipedHead != null) setVisible(bipedHead, b);
    	i++;
    	b = b0[i];
    	if (bipedBody != null) setVisible(bipedBody, b);
    	i++;
    	b = b0[i];
    	if (bipedRightArm != null) setVisible(bipedRightArm, b);
    	i++;
    	b = b0[i];
    	if (bipedLeftArm != null) setVisible(bipedLeftArm, b);
    	i++;
    	b = b0[i];
    	if (bipedRightLeg != null) setVisible(bipedRightLeg, b);
    	i++;
    	b = b0[i];
    	if (bipedLeftLeg != null) setVisible(bipedLeftLeg, b);
    	i++;
    	b = b0[i];
    	if (Skirt != null) Skirt.setVisible(b);
    	i++;
    	b = b0[i];
    	if (bipedHeadwear != null) setVisible(bipedHeadwear, b);
    	i++;
    	b = b0[i];
    	if (ChignonR != null) ChignonR.setVisible(b);
    	i++;
    	b = b0[i];
    	if (ChignonL != null) ChignonL.setVisible(b);
    	i++;
    	b = b0[i];
    	if (ChignonB != null) ChignonB.setVisible(b);
    	i++;
    	b = b0[i];
    	if (SideTailR != null) SideTailR.setVisible(b);
    	i++;
    	b = b0[i];
    	if (SideTailL != null) SideTailL.setVisible(b);
    	i++;
    	b = b0[i];
    	if (Tail != null) Tail.setVisible(b);
    	i++;
    	b = b0[i];
    	setPartsNumber(i);
    }

    @Override
    public void syncModel(ModelPlayerFormLittleMaidBaseBiped model) {
    	if (getRunActionNumber() == 1
    			| getRunActionNumber() == 2) bipedBody.rotateAngleZ = model.bipedBody.rotateAngleZ;
    }

    /**
     * 身長
     */
    @Override
    public float getHeight() {
    	return 1.35F;
    }

    /**
     * 横幅
     */
    @Override
    public float getWidth() {
    	return 0.5F;
    }

    @Override
    public float getyOffset() {
    	return 1.17F;
    }

    @Override
    public float[] getArmorModelsSize() {
    	return new float[] {0.1F, 0.5F};
    }

    /**
     * 他Mobを頭に乗せた時の他Mob基準位置調整
     */
    @Override
    public double getMountedYOffset() {
    	double d = 1.0D;
    	if(isRiding) {
    		//d -= 0.1D;
    	};
    	return d;
    }

    @Override
    public ModelRenderer getBipedRightArm() {
    	if (getShortcutKeysAction()
    			&& getRunActionNumber() == 0
    			| getRunActionNumber() == 1) {
    		if (getHandedness() == 0) return rightArm;
    		return leftArm;
    	}
    	else {
    		if (getHandedness() == 0) return bipedRightArm;
    		return bipedLeftArm;
    	}
    }

    /**
     * 弓装備時の位置調整
     */
    @Override
    public void equippedItemBow() {
/*
    	if (getIsWait()) GL11.glTranslatef(-0.2F, 0.1F, 0.3125F);
    	else GL11.glTranslatef(-0.15F, 0.0F, 0.35F);
*/
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	if (Skirt != null) {
    		Skirt.isHidden = !b;
    		Skirt.setVisible(b);
    	}
    }

    @Override
    public ModelRenderer getArms(int i) {
    	return Arms[i];
    }

    @Override
    public ModelRenderer getHeadMount() {
    	return HeadMount;
    }
}