package net.minecraft.src;

/*//b181delete
import java.util.HashMap;
import java.util.Map;
*///b181delete
//b173deleteimport java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class MultiModel extends MultiModelBaseBiped {

    public ModelRenderer ChignonR;
    public ModelRenderer ChignonL;
    public ModelRenderer ChignonB;
    public ModelRenderer Tail;
    public ModelRenderer SideTailR;
    public ModelRenderer SideTailL;
    public ModelRenderer Skirt;
    public ModelRenderer SkirtTop;
    public ModelRenderer SkirtFront;
    public ModelRenderer SkirtRight;
    public ModelRenderer SkirtLeft;
    public ModelRenderer SkirtBack;

    public MultiModel() {
    	this(0.0F);
    }

    public MultiModel(float f) {
    	this(f, 0.0F);
    }

    public MultiModel(float f, float f1) {
    	this(f, f1, 64, 32);
    }

    public MultiModel(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
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
    	Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
    	bipedBody.addChild(Skirt);
    	ChignonR = new Modchu_ModelRenderer(this, 24, 18);
    	ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 24, 18);
    	ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonL);
    	ChignonB = new Modchu_ModelRenderer(this, 52, 10);
    	ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
    	ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonB);
    	Tail = new Modchu_ModelRenderer(this, 46, 20);
    	Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
    	Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Tail);
    	SideTailR = new Modchu_ModelRenderer(this, 58, 21);
    	SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 58, 21);
    	SideTailL.mirror = true;
    	SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
    	SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailL);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);

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
    	((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	rightArmPlus2.rotateAngleX = 1.570796313F;
    	rightArm2.addChild(rightArmPlus2);

    	rightHand = new Modchu_ModelRenderer(this, 48, 6);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
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
    	((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	leftArmPlus2.rotateAngleX = 1.570796313F;
    	leftArm2.addChild(leftArmPlus2);

    	leftHand = new Modchu_ModelRenderer(this, 56, 6);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	rightLegPlus.rotateAngleX = 1.570796313F;
    	rightLeg.addChild(rightLegPlus);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) rightLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	rightLegPlus2.rotateAngleX = 1.570796313F;
    	rightLeg2.addChild(rightLegPlus2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	leftLegPlus.rotateAngleX = 1.570796313F;
    	leftLeg.addChild(leftLegPlus);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(leftLeg2);

    	leftLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus2.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) leftLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
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
    	setCapsValue(caps_aimedBowBan, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);
    	setCapsValue(caps_sleepingBan, false);
    }

    /**
     * ふんわりスカート初期化
     */
    public void skirtFloatsInit(float f, float f1) {
    	if(!getCapsValueBoolean(caps_skirtFloats)) return;
    	//ふんわりスカート上
    	SkirtTop = new Modchu_ModelRenderer(this, 8, 16);
    	((Modchu_ModelRenderer) SkirtTop).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtTop.setRotationPoint(-4.0F, -4.0F, 4.0F);
    	if (Skirt != null) Skirt.addChild(SkirtTop);

    	//ふんわりスカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtFront.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtFront);

    	//ふんわりスカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 24);
    	((Modchu_ModelRenderer) SkirtRight).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtRight);

    	//ふんわりスカート左
    	SkirtLeft = new Modchu_ModelRenderer(this, 16, 24);
    	((Modchu_ModelRenderer) SkirtLeft).setMirror(true);
    	((Modchu_ModelRenderer) SkirtLeft).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1);
    	SkirtLeft.setRotationPoint(8.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtLeft);

    	//ふんわりスカート後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 24, 24);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtBack);
    	if (Skirt != null) setCapsValue(caps_visible, Skirt, false);
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
    	if (!getCapsValueBoolean(caps_firstPerson)) {
    		bipedHead.rotateAngleY = f3 / 57.29578F;
    		bipedHead.rotateAngleX = f4 / 57.29578F;
    		bipedRightArm.rotateAngleX = MathHelper
    				.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
    		bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1
    				* 0.5F;
    		if (!getCapsValueBoolean(caps_getIsSneak) && !getCapsValueBoolean(caps_getIsRiding) && getCapsValueBoolean(caps_oldwalking)) {
    			bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    			bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    			bipedLeftArm.rotateAngleZ = (MathHelper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;
    			bipedRightArm.rotateAngleZ = (MathHelper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;
    		} else {
    			bipedRightArm.rotateAngleZ = 0.0F;
    			bipedLeftArm.rotateAngleZ = 0.0F;
    		}
    		bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F
    				* f1;
    		bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F)
    				* 1.4F * f1;
    		bipedRightLeg.rotateAngleY = 0.0F;
    		bipedLeftLeg.rotateAngleY = 0.0F;
    		if (getCapsValueBoolean(caps_getIsRiding)) {
    			// 乗り物に乗っている
    			bipedRightArm.rotateAngleX += -0.6283185F;
    			bipedLeftArm.rotateAngleX += -0.6283185F;
    			bipedRightLeg.rotateAngleX = -1.256637F;
    			bipedLeftLeg.rotateAngleX = -1.256637F;
    			bipedRightLeg.rotateAngleY = 0.3141593F;
    			bipedLeftLeg.rotateAngleY = -0.3141593F;
    		}
    		// アイテム持ってるときの腕振りを抑える
    		if (heldItemLeft != 0 && !getCapsValueBoolean(caps_oldwalking)) {
    			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F
    					- 0.3141593F * (float) heldItemLeft;
    		}
    		if (heldItemRight != 0 && !getCapsValueBoolean(caps_oldwalking)) {
    			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F
    					- 0.3141593F * (float) heldItemRight;
    		}
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleY = 0.0F;

    		armSwing(f, f1, f2, f3, f4, f5, entity);

    		bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.0F;
    		if (getCapsValueBoolean(caps_getIsSneak)) {
    			// しゃがみ
    			bipedBody.rotateAngleX = 0.5F;
    			Skirt.rotateAngleX = -0.5F;
    			bipedRightLeg.rotateAngleX -= 0.5F;
    			bipedLeftLeg.rotateAngleX -= 0.5F;
    			bipedHead.rotationPointY = 1.0F;
    			bipedBody.rotationPointY = 3.5F;
    			bipedBody.rotationPointZ = 1.0F;
    			bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F - 1.0F;
    			bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.25F;
    			Skirt.rotationPointY = 5.5F - 0.5F;
    			Skirt.rotationPointZ = -1.0F;
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
    		}
    		if (getCapsValueBoolean(caps_aimedBow)) {
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
    			bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    			bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    			bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
    			bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;
    			bipedRightArm.rotationPointX = -3F;
    			bipedLeftArm.rotationPointX = 3F;
    		} else {
    			if (getCapsValueBoolean(caps_getIsWait)) {
    				// 待機状態
    				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.062F) * 0.05F - 0.7F;
    				bipedRightArm.rotateAngleY = 0.0F;
    				bipedRightArm.rotateAngleZ = -0.4F;
    				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.062F) * 0.05F - 0.7F;
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
    		skirtFloats(f, f1, f2, f3, f4, f5, entity);
    	}
    	//
    	((Modchu_ModelRenderer) Arms[2]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedRightArm).getRotateAngleX(), 0F, 0F);
    	((Modchu_ModelRenderer) Arms[3]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedLeftArm).getRotateAngleX(), 0F, 0F);
    }

    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
    	SkirtFront.rotationPointX =
    			SkirtBack.rotationPointX = motionY * 4.0F;
    	SkirtRight.rotationPointY = motionY * 4.0F;
    	SkirtLeft.rotationPointY = 8.0F - motionY * 4.0F;

    	SkirtTop.rotateAngleX = -1.570796313F;
    	SkirtBack.rotateAngleX = 1.570796313F;
    	SkirtFront.rotateAngleX = 1.570796313F;
    	SkirtRight.rotateAngleX = -1.570796313F;
    	SkirtRight.rotateAngleY = 3.141592653F;
    	SkirtLeft.rotateAngleX = 1.570796313F;
    	SkirtFront.rotateAngleX += motionY;
    	SkirtRight.rotateAngleY += motionY;
    	SkirtLeft.rotateAngleY = -motionY;
    	SkirtBack.rotateAngleX -= motionY;

    	((Modchu_ModelRenderer) SkirtFront).scaleX = ((Modchu_ModelRenderer) SkirtBack).scaleX = 1.0F - (motionY * 1.0F);
    	((Modchu_ModelRenderer) SkirtRight).scaleZ = ((Modchu_ModelRenderer) SkirtLeft).scaleZ = 1.0F - (motionY * 1.0F);
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
    	float[] lgrounds = null;
    	float onGroundR = 0F;
    	float onGroundL = 0F;
    	if (modelCaps != null) {
    		lgrounds = (float[])getCapsValue(caps_Grounds);
    		if (lgrounds != null) {
    			onGroundR = lgrounds[0];
    			onGroundL = lgrounds[1];
    		}
    	}
    	if (lgrounds == null) {
    		onGroundR = getCapsValueFloat(caps_onGround);
    	}
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !getCapsValueBoolean(caps_aimedBow) && !getCapsValueBoolean(caps_oldwalking)) {
    		// 腕振り
    		float f6, f7, f8;
    		f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
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
    		}
    		// L
    		if (onGroundL > 0F) {
    			f6 = 1.0F - onGroundL;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedLeftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			bipedLeftArm.rotateAngleZ = MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
    		}
    	}
    }

    @Override
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	InventoryPlayer inventoryPlayer = (InventoryPlayer) getCapsValue(caps_Inventory);
    	if (inventoryPlayer != null
    			&& inventoryPlayer.getCurrentItem() != null) {
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
/*
    	setCapsValue(caps_visible, bipedHead, true);
    	setCapsValue(caps_visible, bipedBody, true);
    	setCapsValue(caps_visible, bipedRightArm, true);
    	setCapsValue(caps_visible, bipedLeftArm, true);
    	setCapsValue(caps_visible, Skirt, true);
    	setCapsValue(caps_visible, bipedRightLeg, true);
    	setCapsValue(caps_visible, bipedLeftLeg, true);
*/
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

    @Override
    public void defaultPartsSettingBefore() {
    	String[] s = {
    			"bipedCloak", "bipedEars", "SkirtTop", "SkirtFront", "SkirtLeft",
    			"SkirtRight", "SkirtBack", "rightArm", "rightArm2", "rightArmPlus",
    			"rightArmPlus2", "rightHand", "rightLeg", "rightLeg2", "rightLegPlus",
    			"rightLegPlus2", "leftArm", "leftArm2", "leftArmPlus", "leftArmPlus2",
    			"leftHand", "leftLeg", "leftLeg2", "leftLegPlus", "leftLegPlus2",
    			"HeadMount", "mainFrame", "j", "k"
    	};
    	showPartsHideListadd(s);
    	String[] s1 = {
    			"bipedHead", "bipedHeadwear", "bipedBody", "bipedRightArm", "bipedLeftArm",
    			"bipedRightLeg", "bipedLeftLeg", "c", "d", "e",
    			"f", "g", "h", "i"
    	};
    	String[] s2 = {
    			"Head", "Headwear", "Body", "RightArm", "LeftArm",
    			"RightLeg", "LeftLeg", "Head", "Headwear", "Body",
    			"RightArm", "LeftArm", "RightLeg", "LeftLeg"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		if (getGuiParts().get("Skirt") != null) setCapsValue(caps_indexOfAllVisible, "Skirt");
    	}
    	if (getCapsValueBoolean(caps_skirtFloats)
    			&& Skirt != null) setCapsValue(caps_visible, Skirt, false);
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
    	if (getCapsValueBoolean(caps_shortcutKeysAction)
    			&& getCapsValueInt(caps_runActionNumber) == 0
    			| getCapsValueInt(caps_runActionNumber) == 1) {
    		if (getCapsValueInt(caps_dominantArm) == 0) return rightArm;
    		return leftArm;
    	}
    	else {
    		if (getCapsValueInt(caps_dominantArm) == 0) return bipedRightArm;
    		return bipedLeftArm;
    	}
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	if (Skirt != null
    			&& !getCapsValueBoolean(caps_skirtFloats)) {
    		Skirt.isHidden = !b;
    		setCapsValue(caps_visible, Skirt, b);
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