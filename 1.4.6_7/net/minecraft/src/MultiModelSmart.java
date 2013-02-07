package net.minecraft.src;

public class MultiModelSmart extends MultiModelBaseBipedSmart
{
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

    public MultiModelSmart()
    {
    	this(0.0F);
    }

    public MultiModelSmart(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModelSmart(float f, float f1) {
    	this(f, f1, 64, 32);
    }

    public MultiModelSmart(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	super.initModel(f, f1);
    	bipedOuter = new Modchu_ModelRotationRenderer(this);
    	bipedBreast = new Modchu_ModelRotationRenderer(this, -1, -1);
    	bipedNeck = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
    	bipedRightShoulder = new Modchu_ModelRotationRenderer(this, 40, 16, bipedBreast);
    	bipedLeftShoulder = new Modchu_ModelRotationRenderer(this, -1, -1, bipedBreast);
    	bipedPelvic = new Modchu_ModelRotationRenderer(this, -1, -1);

    	mainFrame.addChild(bipedOuter);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	//reset(f, f1, f2, f3, f4, f5, entity);
    	if (!firstPerson && !isInventory)
    	{
            if (isSleeping)
            {
                prevOuterRenderData.rotateAngleX = 0.0F;
                prevOuterRenderData.rotateAngleY = 0.0F;
                prevOuterRenderData.rotateAngleZ = 0.0F;
            }

            bipedOuter.previous = prevOuterRenderData;
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
        }
        else
        {
            bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
            bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
            bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
            bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
            //superSetRotationAngles(f, f1, f2, f3, f4, f5, entity);
        }
    }

    public void animateHeadRotation(float var1, float var2)
    {
        bipedNeck.ignoreBase = true;
        //bipedHead.rotateAngleY = (actualRotation + var1) / (180F / (float)Math.PI);
        //bipedHead.rotateAngleX = var2 / (180F / (float)Math.PI);
    }

    public void animateSleeping()
    {
        bipedNeck.ignoreBase = false;
        //bipedHead.rotateAngleY = 0.0F;
        //bipedHead.rotateAngleX = ((float)Math.PI / 4F);
        bipedTorso.rotationPointZ = -17.0F;
    }

    public void animateArmSwinging(float var1, float var2)
    {
        //bipedRightArm.main.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        //bipedLeftArm.mainrotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        //bipedRightLeg.main.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        //bipedLeftLeg.main.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
    }

    public void animateRiding()
    {
        //bipedRightArm.main.rotateAngleX += -((float)Math.PI / 5F);
        //bipedLeftArm.mainrotateAngleX += -((float)Math.PI / 5F);
        //bipedRightLeg.main.rotateAngleX = -((float)Math.PI * 2F / 5F);
        //bipedLeftLeg.main.rotateAngleX = -((float)Math.PI * 2F / 5F);
        //bipedRightLeg.main.rotateAngleY = ((float)Math.PI / 10F);
        //bipedLeftLeg.main.rotateAngleY = -((float)Math.PI / 10F);
    }

    public void animateLeftArmItemHolding()
    {
        //bipedLeftArm.mainrotateAngleX = bipedLeftArm.mainrotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemLeft;
    }

    public void animateRightArmItemHolding()
    {
        //bipedRightArm.main.rotateAngleX = bipedRightArm.main.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)heldItemRight;
    }

    public void animateWorkingBody()
    {
        float var1 = MathHelper.sin(MathHelper.sqrt_float(onGround) * ((float)Math.PI * 2F)) * 0.2F;
        bipedBreast.main.rotateAngleY = bipedBody.main.rotateAngleY += var1;
        bipedBreast.main.rotatePriority = bipedBody.main.rotatePriority = Modchu_ModelRenderer.YXZ;
        //bipedLeftArm.mainrotateAngleX += var1;
    }

    public void animateWorkingArms()
    {
        //float var1 = 1.0F - onGround;
        //var1 = 1.0F - var1 * var1 * var1;
        //float var2 = MathHelper.sin(var1 * (float)Math.PI);
        //float var3 = MathHelper.sin(onGround * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
        //bipedRightArm.main.rotateAngleX = (float)((double)bipedRightArm.main.rotateAngleX - ((double)var2 * 1.2D + (double)var3));
        //bipedRightArm.main.rotateAngleY += MathHelper.sin(MathHelper.sqrt_float(onGround) * ((float)Math.PI * 2F)) * 0.4F;
        //bipedRightArm.main.rotateAngleZ -= MathHelper.sin(onGround * (float)Math.PI) * 0.4F;
    }

    public void animateSneaking()
    {
        bipedTorso.rotateAngleX += 0.5F;
        //bipedRightLeg.main.rotateAngleX += -0.5F;
        //bipedLeftLeg.main.rotateAngleX += -0.5F;
        //bipedRightArm.main.rotateAngleX += -0.1F;
        //bipedLeftArm.mainrotateAngleX += -0.1F;
        bipedPelvic.offsetY = -0.137F;
        bipedPelvic.offsetZ = -0.051F;
        bipedBreast.offsetY = -0.014F;
        bipedBreast.offsetZ = -0.057F;
        bipedNeck.offsetY = 0.0621F;
    }

    public void animateArms(float var1)
    {
        //bipedRightArm.main.rotateAngleZ += MathHelper.cos(var1 * 0.09F) * 0.05F + 0.05F;
        //bipedLeftArm.mainrotateAngleZ -= MathHelper.cos(var1 * 0.09F) * 0.05F + 0.05F;
        //bipedRightArm.main.rotateAngleX += MathHelper.sin(var1 * 0.067F) * 0.05F;
        //bipedLeftArm.mainrotateAngleX -= MathHelper.sin(var1 * 0.067F) * 0.05F;
    }

    public void animateBowAiming(float var1)
    {
        //bipedRightArm.main.rotateAngleZ = 0.0F;
        //bipedLeftArm.mainrotateAngleZ = 0.0F;
        //bipedRightArm.main.rotateAngleY = -0.1F + bipedHead.rotateAngleY - bipedOuter.rotateAngleY;
        //bipedLeftArm.mainrotateAngleY = 0.1F + bipedHead.rotateAngleY + 0.4F - bipedOuter.rotateAngleY;
        //bipedRightArm.main.rotateAngleX = -((float)Math.PI / 2F) + bipedHead.rotateAngleX;
        //bipedLeftArm.mainrotateAngleX = -((float)Math.PI / 2F) + bipedHead.rotateAngleX;
        //bipedRightArm.main.rotateAngleZ += MathHelper.cos(var1 * 0.09F) * 0.05F + 0.05F;
        //bipedLeftArm.mainrotateAngleZ -= MathHelper.cos(var1 * 0.09F) * 0.05F + 0.05F;
        //bipedRightArm.main.rotateAngleX += MathHelper.sin(var1 * 0.067F) * 0.05F;
        //bipedLeftArm.mainrotateAngleX -= MathHelper.sin(var1 * 0.067F) * 0.05F;
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.reset(f, f1, f2, f3, f4, f5, entity);
        bipedOuter.reset();
        bipedBreast.reset();
        bipedNeck.reset();
        bipedRightShoulder.reset();
        bipedLeftShoulder.reset();
        bipedPelvic.reset();
        bipedOuter.setRotationPoint(0.0F, 8.0F, 0.0F);
        bipedRightShoulder.setRotationPoint(-2.5F, 2.0F, 0.0F);
        bipedLeftShoulder.setRotationPoint(2.5F, 2.0F, 0.0F);
        bipedPelvic.setRotationPoint(0.0F, 12.0F, 0.0F);
        bipedRightLeg.setRotationPoint(-2.0F, 0.0F, 0.0F);
        bipedLeftLeg.setRotationPoint(2.0F, 0.0F, 0.0F);
    }

    @Override
    public float[] getArmorModelsSize() {
    	return new float[] {0.1F, 0.5F};
    }

    @Override
    public float getHeight() {
    	return 1.35F;
    }

    @Override
    public float getWidth() {
    	return 0.5F;
    }
}
