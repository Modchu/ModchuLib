package net.minecraft.src;

import net.smart.render.ModelCapeRenderer;
import net.smart.render.ModelEarsRenderer;

public class MultiModelSmart_Biped extends MultiModelBaseBipedSmart
{
    public MultiModelSmart_Biped()
    {
    	this(0.0F);
    }

    public MultiModelSmart_Biped(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModelSmart_Biped(float f, float f1) {
    	this(f, f1, 64, 32);
    }

    public MultiModelSmart_Biped(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
	public void initModel(float f, float f1) {
		bipedHead = new Modchu_ModelRotationRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedCloak = new ModelCapeRenderer(this, 0, 0, bipedHead, bipedHead);
		bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, f);
		bipedEars = new ModelEarsRenderer(this, 24, 0, bipedHead);
		bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, f);
		bipedHeadwear = new Modchu_ModelRotationRenderer(this, 32, 0);
		bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f + 0.5F);
    	bipedHead.addChild(bipedHeadwear);
		bipedBody = new Modchu_ModelRotationRenderer(this, 16, 16);
		bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, f);
		bipedRightArm = new Modchu_ModelRotationRenderer(this, 40, 16);
		bipedRightArm.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedRightArm);
		bipedLeftArm = new Modchu_ModelRotationRenderer(this, 40, 16);
		((Modchu_ModelRotationRenderer) bipedLeftArm).mirror = true;
		bipedLeftArm.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedLeftArm);
		bipedRightLeg = new Modchu_ModelRotationRenderer(this, 0, 16);
		bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedRightLeg);
		bipedLeftLeg = new Modchu_ModelRotationRenderer(this, 0, 16);
		((Modchu_ModelRotationRenderer) bipedLeftLeg).mirror = true;
		bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
		bipedBody.addChild(bipedLeftLeg);

		mainFrame = new Modchu_ModelRotationRenderer(this, 0, 0);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);

		bipedOuter = new Modchu_ModelRotationRenderer(this);
		bipedTorso = new Modchu_ModelRotationRenderer(this, -1, -1, bipedOuter);
    	bipedBreast = new Modchu_ModelRotationRenderer(this);
    	bipedNeck = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
    	bipedRightShoulder = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
    	bipedLeftShoulder = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
    	bipedPelvic = new Modchu_ModelRotationRenderer(this, -1, -1, bipedTorso);

    	//mainFrame.addChild(bipedOuter);
    	actionPartsInit(f, f1);
    }

    @Override
    public void armsinit(float f, float f1) {
    	Arms = new Modchu_ModelRotationRenderer[18];
    	// 手持ち
    	Arms[0] = new Modchu_ModelRotationRenderer(this, 0, 0);
    	Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    	Arms[1] = new Modchu_ModelRotationRenderer(this, 0, 0);
    	Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);
    	((Modchu_ModelRotationRenderer) Arms[1]).main.isInvertX = true;
    	// バイプロダクトエフェクター
    	Arms[2] = new Modchu_ModelRotationRenderer(this, 0, 0);
    	Arms[2].setRotationPoint(-3F, 9F, 6F);
    	((Modchu_ModelRotationRenderer) Arms[2]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	Arms[3] = new Modchu_ModelRotationRenderer(this, 0, 0);
    	Arms[3].setRotationPoint(3F, 9F, 6F);
    	((Modchu_ModelRotationRenderer) Arms[3]).setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
    	((Modchu_ModelRotationRenderer) Arms[3]).main.isInvertX = true;
    	// テールソード
    	Arms[4] = new Modchu_ModelRotationRenderer(this, 0, 0);
    	Arms[4].setRotationPoint(-2F, 0F, 0F);
    	((Modchu_ModelRotationRenderer) Arms[4]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);
    	Arms[5] = new Modchu_ModelRotationRenderer(this, 0, 0);
    	Arms[5].setRotationPoint(2F, 0F, 0F);
    	((Modchu_ModelRotationRenderer) Arms[5]).setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);


//		Arms[8] = new Modchu_ModelRotationRenderer(this, "HeadTop");
//		Arms[8].setRotationPoint(0F, -3F, 1F);
    	if (HeadMount != null) {
    		if (bipedHead instanceof Modchu_ModelRotationRenderer) {
    			((Modchu_ModelRotationRenderer) bipedHead).removeChild(HeadMount);
    		} else {
    			bipedHead.childModels.remove(HeadMount);
    		}
    	}
    	HeadMount = new Modchu_ModelRotationRenderer(this, "HeadMount");
    	HeadMount.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(HeadMount);
    	bipedBody.addChild(Arms[4]);
    	bipedBody.addChild(Arms[5]);
    	bipedRightArm.addChild(Arms[0]);
    	bipedRightArm.addChild(Arms[2]);
    	bipedLeftArm.addChild(Arms[1]);
    	bipedLeftArm.addChild(Arms[3]);
    }

    @Override
    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRotationRenderer(this, 40, 16);
    	rightArm.addBox(-2.0F, -1.0F, -1.0F, 4, 6, 4, f);
    	bipedBody.addChild(rightArm);

    	rightArm2 = new Modchu_ModelRotationRenderer(this, 40, 24);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 4, 6, 4, f);
    	rightArm.addChild(rightArm2);

    	leftArm = new Modchu_ModelRotationRenderer(this, 40, 16);
    	((Modchu_ModelRotationRenderer) leftArm).mirror = true;
    	leftArm.addBox(0.0F, -1.0F, -1.0F, 4, 6, 4, f);
    	bipedBody.addChild(leftArm);

    	leftArm2 = new Modchu_ModelRotationRenderer(this, 40, 24);
    	((Modchu_ModelRotationRenderer) leftArm2).mirror = true;
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 4, 6, 4, f);
    	leftArm.addChild(leftArm2);

    	rightLeg = new Modchu_ModelRotationRenderer(this, 0, 16);
    	rightLeg.addBox(-2.5F, 0.0F, -2F, 4, 6, 4, f);
    	bipedBody.addChild(rightLeg);

    	rightLeg2 = new Modchu_ModelRotationRenderer(this, 0, 22);
    	rightLeg2.addBox(-1.1F, 0.0F, -1.5F, 4, 6, 4, f);
    	rightLeg.addChild(rightLeg2);

    	leftLeg = new Modchu_ModelRotationRenderer(this, 0, 16);
    	((Modchu_ModelRotationRenderer) leftLeg).mirror = true;
    	leftLeg.addBox(-0.5F, 0.0F, -2F, 4, 6, 4, f);
    	bipedBody.addChild(leftLeg);

    	leftLeg2 = new Modchu_ModelRotationRenderer(this, 0, 22);
    	((Modchu_ModelRotationRenderer) leftLeg2).mirror = true;
    	leftLeg2.addBox(-0.9F, 0.0F, -1.5F, 4, 6, 4, f);
    	leftLeg.addChild(leftLeg2);

    	rightHand = new Modchu_ModelRotationRenderer(this, 40, 24);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 4, 4, 4, f);
    	rightArm2.addChild(rightHand);

    	leftHand = new Modchu_ModelRotationRenderer(this, 40, 24);
    	((Modchu_ModelRotationRenderer) leftHand).mirror = true;
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 4, 4, 4, f);
    	leftArm2.addChild(leftHand);

    	leftArmPlus = new Modchu_ModelRotationRenderer(this);
    	leftArmPlus2 = new Modchu_ModelRotationRenderer(this);
    	rightArmPlus = new Modchu_ModelRotationRenderer(this);
    	rightArmPlus2 = new Modchu_ModelRotationRenderer(this);
    	rightLegPlus = new Modchu_ModelRotationRenderer(this);
    	rightLegPlus2 = new Modchu_ModelRotationRenderer(this);
    	leftLegPlus = new Modchu_ModelRotationRenderer(this);
    	leftLegPlus2 = new Modchu_ModelRotationRenderer(this);

    	boolean b = false;
    	((Modchu_ModelRotationRenderer) rightHand).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftHand).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightArm).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftArm).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightArmPlus).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightArmPlus2).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftArmPlus).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftArmPlus2).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightLegPlus).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightLegPlus2).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftLegPlus).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftLegPlus2).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightArm2).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftArm2).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightLeg).setVisible(b);
    	((Modchu_ModelRotationRenderer) rightLeg2).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftLeg).setVisible(b);
    	((Modchu_ModelRotationRenderer) leftLeg2).setVisible(b);

    	aimedBowBan = false;
    	sneakBan = false;
    	waitBan = false;
    	sittingBan = false;
    	sleepingBan = false;
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	reset(f, f1, f2, f3, f4, f5, entity);
    	if (!firstPerson && !isInventory)
    	{
            if (isSleeping)
            {
                //prevOuterRenderData.rotateAngleX = 0.0F;
                //prevOuterRenderData.rotateAngleY = 0.0F;
                //prevOuterRenderData.rotateAngleZ = 0.0F;
            }

            //bipedOuter.previous = prevOuterRenderData;
            bipedOuter.rotateAngleY = actualRotation / (180F / (float)Math.PI);
            bipedOuter.fadeRotateAngleY = true;
            animateHeadRotation(f, f1, f2, f3, f4, f5);

            if (isSleeping)
            {
                animateSleeping(f, f1, f2, f3, f4, f5);
            }

            animateArmSwinging(f, f1, f2, f3, f4, f5);

            if (isRiding)
            {
                animateRiding(f, f1, f2, f3, f4, f5);
            }

            if (heldItemLeft != 0)
            {
                animateLeftArmItemHolding(f, f1, f2, f3, f4, f5);
            }

            if (heldItemRight != 0)
            {
                animateRightArmItemHolding(f, f1, f2, f3, f4, f5);
            }

            if (onGround > -9990.0F)
            {
                animateWorkingBody(f, f1, f2, f3, f4, f5);
                animateWorkingArms(f, f1, f2, f3, f4, f5);
            }

            if (isSneak)
            {
                animateSneaking(f, f1, f2, f3, f4, f5);
            }

            animateArms(f, f1, f2, f3, f4, f5);

            if (aimedBow)
            {
                animateBowAiming(f, f1, f2, f3, f4, f5);
            }

            if (bipedOuter.previous != null && !bipedOuter.fadeRotateAngleX)
            {
                bipedOuter.previous.rotateAngleX = bipedOuter.rotateAngleX;
            }

            if (bipedOuter.previous != null && !bipedOuter.fadeRotateAngleY)
            {
                bipedOuter.previous.rotateAngleY = bipedOuter.rotateAngleY;
            }

            bipedOuter.fadeIntermediate(f2);
            bipedOuter.fadeStore(f2);
            //bipedCloak.ignoreBase = false;
            //bipedCloak.rotateAngleX = 0.09817477F;
            smartPartsRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	}
        else
        {
        	superSetRotationAngles(f, f1, f2, f3, f4, f5, entity);
        }
    }

    @Override
    public void superSetRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		reset(f, f1, f2, f3, f4, f5, entity);
		bipedHead.main.rotateAngleY = f3 / (180F / (float) Math.PI);
		bipedHead.main.rotateAngleX = f4 / (180F / (float) Math.PI);
		if (!this.getIsSneak() && !this.getIsRiding() && getOldwalking()) {
			bipedRightArm.main.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1;
			bipedLeftArm.main.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1;
			bipedLeftArm.main.rotateAngleZ = (MathHelper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;
			bipedRightArm.main.rotateAngleZ = (MathHelper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;
		} else {
			bipedRightArm.main.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
			bipedLeftArm.main.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
			bipedRightArm.main.rotateAngleZ = 0.0F;
			bipedLeftArm.main.rotateAngleZ = 0.0F;
		}
		bipedRightLeg.main.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		bipedLeftLeg.main.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		bipedRightLeg.main.rotateAngleY = 0.0F;
		bipedLeftLeg.main.rotateAngleY = 0.0F;

		if (getIsRiding()) {
			bipedRightArm.main.rotateAngleX += -((float) Math.PI / 5F);
			bipedLeftArm.main.rotateAngleX += -((float) Math.PI / 5F);
			bipedRightLeg.main.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedLeftLeg.main.rotateAngleX = -((float) Math.PI * 2F / 5F);
			bipedRightLeg.main.rotateAngleY = ((float) Math.PI / 10F);
			bipedLeftLeg.main.rotateAngleY = -((float) Math.PI / 10F);
		}

		if (heldItemLeft != 0 && !getOldwalking()) {
			bipedLeftArm.main.rotateAngleX = bipedLeftArm.main.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * (float) heldItemLeft;
		}

		if (heldItemRight != 0 && !getOldwalking()) {
			bipedRightArm.main.rotateAngleX = bipedRightArm.main.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * (float) heldItemRight;
		}

		bipedRightArm.main.rotateAngleY = 0.0F;
		bipedLeftArm.main.rotateAngleY = 0.0F;
		float var7;
		float var8;
		armSwing(f, f1, f2, f3, f4, f5, entity);
		if (getIsSneak()) {
			bipedBody.main.rotateAngleX = 0.5F;
			bipedHead.main.rotationPointY = 1.0F;
			bipedRightLeg.main.rotateAngleX -= 0.5F;
			bipedLeftLeg.main.rotateAngleX -= 0.5F;
		} else {
			bipedBody.main.rotateAngleX = 0.0F;
			bipedHead.main.rotationPointY = 0.0F;
		}

		if (getaimedBow()) {
			var7 = 0.0F;
			var8 = 0.0F;
			bipedRightArm.main.rotateAngleZ = 0.0F;
			bipedLeftArm.main.rotateAngleZ = 0.0F;
			bipedRightArm.main.rotateAngleY = -(0.1F - var7 * 0.6F) + bipedHead.main.rotateAngleY;
			bipedLeftArm.main.rotateAngleY = 0.1F - var7 * 0.6F + bipedHead.main.rotateAngleY + 0.4F;
			bipedRightArm.main.rotateAngleX = -((float) Math.PI / 2F) + bipedHead.main.rotateAngleX;
			bipedLeftArm.main.rotateAngleX = -((float) Math.PI / 2F) + bipedHead.main.rotateAngleX;
			bipedRightArm.main.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
			bipedLeftArm.main.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
			bipedRightArm.main.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.main.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.main.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
			bipedLeftArm.main.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
		} else {
			if (getIsWait()) {
				// 待機状態
				bipedRightArm.main.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.5F;
				bipedRightArm.main.rotateAngleY = 0.0F;
				bipedRightArm.main.rotateAngleZ = -0.4F;
				bipedLeftArm.main.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.5F;
				bipedLeftArm.main.rotateAngleY = 0.0F;
				bipedLeftArm.main.rotateAngleZ = 0.4F;
			} else {
				// 呼吸 腕等
				bipedRightArm.main.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.main.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.main.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.main.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
			}
		}
    }

    @Override
    public void superAnimateHeadRotation(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateSleeping(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateArmSwinging(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateRiding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateLeftArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateRightArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateWorkingBody(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateWorkingArms(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateSneaking(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superApplyAnimationOffsets(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    @Override
    public void superAnimateBowAiming(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void smartPartsRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		bipedHead.main.rotateAngleY += f3 / (180F / (float) Math.PI);
		bipedHead.main.rotateAngleX += f4 / (180F / (float) Math.PI);
		bipedHead.main.rotateAngleZ = 0.0F;
		if (!this.getIsSneak() && !this.getIsRiding() && getOldwalking()) {
			bipedRightArm.main.rotateAngleX += MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1;
			bipedLeftArm.main.rotateAngleX += MathHelper.cos(f * 0.6662F) * 2.0F * f1;
			bipedLeftArm.main.rotateAngleZ += (MathHelper.cos(f * 0.2812F) - 1.0F) * 1.0F * f1;
			bipedRightArm.main.rotateAngleZ += (MathHelper.cos(f * 0.2312F) + 1.0F) * 1.0F * f1;
		} else {
			bipedRightArm.main.rotateAngleX += MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
			bipedLeftArm.main.rotateAngleX += MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
			//bipedRightArm.main.rotateAngleZ = 0.0F;
			//bipedLeftArm.main.rotateAngleZ = 0.0F;
		}
		bipedRightLeg.main.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		bipedLeftLeg.main.rotateAngleX += MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		//bipedRightLeg.main.rotateAngleY = 0.0F;
		//bipedLeftLeg.main.rotateAngleY = 0.0F;

		if (getIsRiding()) {
			bipedRightArm.main.rotateAngleX += -((float) Math.PI / 5F);
			bipedLeftArm.main.rotateAngleX += -((float) Math.PI / 5F);
			bipedRightLeg.main.rotateAngleX += -((float) Math.PI * 2F / 5F);
			bipedLeftLeg.main.rotateAngleX += -((float) Math.PI * 2F / 5F);
			bipedRightLeg.main.rotateAngleY += ((float) Math.PI / 10F);
			bipedLeftLeg.main.rotateAngleY += -((float) Math.PI / 10F);
		}

		if (heldItemLeft != 0 && !getOldwalking()) {
			bipedLeftArm.main.rotateAngleX += bipedLeftArm.main.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * (float) heldItemLeft;
		}

		if (heldItemRight != 0 && !getOldwalking()) {
			bipedRightArm.main.rotateAngleX += bipedRightArm.main.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * (float) heldItemRight;
		}

		//bipedRightArm.main.rotateAngleY = 0.0F;
		//bipedLeftArm.main.rotateAngleY = 0.0F;
		float var7;
		float var8;
		armSwing(f, f1, f2, f3, f4, f5, entity);
		if (getIsSneak()) {
			bipedBody.main.rotateAngleX += 0.5F;
			bipedHead.main.rotationPointY += 1.0F;
			bipedRightLeg.main.rotateAngleX -= 0.5F;
			bipedLeftLeg.main.rotateAngleX -= 0.5F;
		} else {
			//bipedBody.main.rotateAngleX = 0.0F;
			//bipedHead.main.rotationPointY = 0.0F;
		}

		if (getaimedBow()) {
			var7 = 0.0F;
			var8 = 0.0F;
			//bipedRightArm.main.rotateAngleZ = 0.0F;
			//bipedLeftArm.main.rotateAngleZ = 0.0F;
			bipedRightArm.main.rotateAngleY += -(0.1F - var7 * 0.6F) + bipedHead.main.rotateAngleY;
			bipedLeftArm.main.rotateAngleY += 0.1F - var7 * 0.6F + bipedHead.main.rotateAngleY + 0.4F;
			bipedRightArm.main.rotateAngleX += -((float) Math.PI / 2F) + bipedHead.main.rotateAngleX;
			bipedLeftArm.main.rotateAngleX += -((float) Math.PI / 2F) + bipedHead.main.rotateAngleX;
			bipedRightArm.main.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
			bipedLeftArm.main.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
			bipedRightArm.main.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.main.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.main.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
			bipedLeftArm.main.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
		} else {
			if (getIsWait()) {
				// 待機状態
				bipedRightArm.main.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F - 0.5F;
				//bipedRightArm.main.rotateAngleY = 0.0F;
				bipedRightArm.main.rotateAngleZ += -0.4F;
				bipedLeftArm.main.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F - 0.5F;
				//bipedLeftArm.main.rotateAngleY = 0.0F;
				bipedLeftArm.main.rotateAngleZ += 0.4F;
			} else {
				// 呼吸 腕等
				bipedRightArm.main.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.main.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.main.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.main.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
			}
		}
    }

    @Override
    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	float onGroundR = getOnGround(getSwingStatus(entity, 0), entity);
    	float onGroundL = getOnGround(getSwingStatus(entity, 1), entity);
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !getaimedBow() && !getOldwalking()) {
    		// 腕振り
    		float f6, f7, f8;
    		f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		bipedBody.main.rotateAngleY += (f6 - f7) * 0.2F;
    		// R
    		if (onGroundR > 0F) {
    			f6 = 1.0F - onGroundR;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.main.rotateAngleX - 0.7F) * 0.75F;
    			bipedRightArm.main.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedRightArm.main.rotateAngleY += bipedBody.main.rotateAngleY * 2.0F;
    			bipedRightArm.main.rotateAngleZ += MathHelper.sin(onGroundR * 3.141593F) * -0.4F;
    		}
    		// L
    		if (onGroundL > 0F) {
    			f6 = 1.0F - onGroundL;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.main.rotateAngleX - 0.7F) * 0.75F;
    			bipedLeftArm.main.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			bipedLeftArm.main.rotateAngleY += bipedBody.main.rotateAngleY * 2.0F;
    			bipedLeftArm.main.rotateAngleZ += MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
    		}
    	}
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	bipedOuter.reset();
    	bipedBreast.reset();
    	bipedNeck.reset();
    	bipedRightShoulder.reset();
    	bipedLeftShoulder.reset();
    	bipedPelvic.reset();
    	bipedHead.reset();
    	bipedBody.reset();
    	bipedHeadwear.reset();
    	bipedRightArm.reset();
    	bipedLeftArm.reset();
    	bipedRightLeg.reset();
    	bipedLeftLeg.reset();
    	((Modchu_ModelRotationRenderer) mainFrame).main.setRotationPoint(0.0F, 28.0F, 0.0F);
    	bipedHead.main.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedBody.main.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHeadwear.main.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedRightArm.main.setRotationPoint(-6.0F, 0.0F, 0.0F);
    	bipedLeftArm.main.setRotationPoint(6.0F, 0.0F, 0.0F);
    	bipedRightLeg.main.setRotationPoint(-2.0F, 12.0F, 0.0F);
    	bipedLeftLeg.main.setRotationPoint(1.9F, 12.0F, 0.0F);
    	bipedRightShoulder.setRotationPoint(-5.0F, 2.0F, 0.0F);
    	bipedLeftShoulder.setRotationPoint(5.0F, 2.0F, 0.0F);
    	bipedPelvic.setRotationPoint(0.0F, 12.0F, 0.0F);
    	bipedRightLeg.setRotationPoint(-2.0F, 0.0F, 0.0F);
    	bipedLeftLeg.setRotationPoint(2.0F, 0.0F, 0.0F);
    	bipedCloak.setRotationPoint(0.0F, 0.0F, 2.0F);
    	((Modchu_ModelRotationRenderer) Arms[0]).main.setRotationPoint(0.0F, 9.5F, 0F);
    	((Modchu_ModelRotationRenderer) Arms[1]).main.setRotationPoint(0.0F, 9.5F, 0F);
    }

    @Override
    public float[] getArmorModelsSize() {
    	return new float[] {0.5F, 1.0F};
    }

    @Override
    public float getHeight() {
    	return 1.8F;
    }

    @Override
    public float getWidth() {
    	return 0.6F;
    }
}
