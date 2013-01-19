package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelPlayerFormLittleMaid_Elsie extends ModelPlayerFormLittleMaid
{

    public Modchu_ModelRenderer RightSkirt;
    public Modchu_ModelRenderer LeftSkirt;
    public Modchu_ModelRenderer bipedHeadwearB;
	public Modchu_ModelRenderer SkirtTopL;
	public Modchu_ModelRenderer SkirtFrontL;
	public Modchu_ModelRenderer SkirtLeftL;
	public Modchu_ModelRenderer SkirtBackL;

    public ModelPlayerFormLittleMaid_Elsie()
    {
        this(0.0F);
    }

    public ModelPlayerFormLittleMaid_Elsie(float f)
    {
        this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_Elsie(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 32);
	}

	public ModelPlayerFormLittleMaid_Elsie(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
	}

    @Override
    public void initModel(float f, float f1) {
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	bipedHead.setRotationPoint(0.0F, 4.0F, 0.0F);
    	bipedHeadwearB = new Modchu_ModelRenderer(this, 42, 0);
    	bipedHeadwearB.addBox(-4F, -1.5F, 1.0F, 8, 6, 3, f);
    	bipedHeadwearB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(bipedHeadwearB);
    	bipedBody = new Modchu_ModelRenderer(this, 36, 20);
    	bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 8, 4, f);
    	bipedBody.setRotationPoint(0.0F, 4.0F, 0.0F);
    	bipedRightArm = new Modchu_ModelRenderer(this, 56, 20);
    	bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, f);
    	bipedRightArm.setRotationPoint(-3.0F, 0.0F, 0.0F);
    	bipedBody.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 20);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(-1.0F, 0.0F, -1F, 2, 10, 2, f);
    	bipedLeftArm.setRotationPoint(3.0F, 0.0F, 0.0F);
    	bipedBody.addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 0, 16);
    	bipedRightLeg.addBox(-1.5F, 0.0F, -2F, 3, 12, 4, f);
    	bipedRightLeg.setRotationPoint(-1.5F, 8F, 0.0F);
    	bipedBody.addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 0, 16);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1.5F, 0.0F, -2F, 3, 12, 4, f);
    	bipedLeftLeg.setRotationPoint(1.5F, 8F, 0.0F);
    	bipedBody.addChild(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 36, 10);
    	Skirt.addBox(-4F, 0.0F, -3F, 8, 4, 6, f);
    	Skirt.setRotationPoint(0.0F, 6.0F, 0.0F);
    	bipedBody.addChild(Skirt);
    	RightSkirt = new Modchu_ModelRenderer(this, 14, 16);
    	RightSkirt.addBox(-2.5F, 0.0F, -3F, 5, 10, 6, f);
    	RightSkirt.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedRightLeg.addChild(RightSkirt);
    	LeftSkirt = new Modchu_ModelRenderer(this, 14, 16);
    	LeftSkirt.mirror = true;
    	LeftSkirt.addBox(-2.5F, 0.0F, -3F, 5, 10, 6, f);
    	LeftSkirt.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedLeftLeg.addChild(LeftSkirt);
    	ChignonR = new Modchu_ModelRenderer(this, 24, 2);
    	ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 24, 2);
    	ChignonL.mirror = true;
    	ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonL);
    	SideTailR = new Modchu_ModelRenderer(this, 32, 0);
    	SideTailR.addBox(-6.5F, -6.8F, 0.9F, 2, 13, 3, f);
    	SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 32, 0);
    	SideTailL.mirror = true;
    	SideTailL.addBox(4.5F, -6.8F, 0.9F, 2, 13, 3, f);
    	SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailL);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	((Modchu_ModelRenderer) bipedHead).removeChild(bipedHeadwear);
    	((Modchu_ModelRenderer) bipedHead).removeChild(ChignonB);
    	((Modchu_ModelRenderer) bipedHead).removeChild(Tail);
    	skirtFloatsInit(f, f1);
    	actionPartsInit(f, f1);
    }

	public void skirtFloatsInit(float f, float f1) {
		if(!skirtFloats) return;
		//RightSkirt 前
		SkirtFront = new Modchu_ModelRenderer(this, 21, 22);
		SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 5, 10, 0);
		SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSkirt.addChild(SkirtFront);

		//RightSkirt 右
		SkirtRight = new Modchu_ModelRenderer(this, 14, 22);
		SkirtRight.addPlate(-3.0F, 0.0F, -6.0F, 6, 10, 1);
		SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSkirt.addChild(SkirtRight);

		//RightSkirt 後ろ
		SkirtBack = new Modchu_ModelRenderer(this, 31, 22);
		SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 5, 10, 0);
		SkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightSkirt.addChild(SkirtBack);

		//LeftSkirt 前
		SkirtFrontL = new Modchu_ModelRenderer(this, 21, 22);
		SkirtFrontL.addPlate(0.0F, 0.0F, 0.0F, 5, 10, 0);
		SkirtFrontL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSkirt.addChild(SkirtFrontL);

		//LeftSkirt 左
		SkirtLeftL = new Modchu_ModelRenderer(this, 25, 22);
		SkirtLeftL.addPlate(-3.0F, 0.0F, -6.0F, 6, 10, 1);
		SkirtLeftL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSkirt.addChild(SkirtLeftL);

		//LeftSkirt 後ろ
		SkirtBackL = new Modchu_ModelRenderer(this, 31, 22);
		SkirtBackL.addPlate(0.0F, 0.0F, 0.0F, 5, 10, 0);
		SkirtBackL.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftSkirt.addChild(SkirtBackL);
		RightSkirt.setVisible(false);
		LeftSkirt.setVisible(false);
	}

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	RightSkirt.rotationPointZ = 0.0F;
    	LeftSkirt.rotationPointZ = 0.0F;
    	RightSkirt.rotateAngleX = -0.01F;
    	LeftSkirt.rotateAngleX = 0.01F;
    	RightSkirt.rotateAngleY = 0.0F;
    	LeftSkirt.rotateAngleY = 0.0F;
    	RightSkirt.rotateAngleZ = 0.0F;
    	LeftSkirt.rotateAngleZ = 0.0F;
    	if (skirtFloats) {
    		SkirtBack.rotateAngleX = SkirtRight.rotateAngleX = SkirtFront.rotateAngleX = 0.0F;
    		SkirtBack.rotateAngleY = SkirtRight.rotateAngleY = SkirtFront.rotateAngleY = 0.0F;
    		SkirtBack.rotateAngleZ = SkirtRight.rotateAngleZ = SkirtFront.rotateAngleZ = 0.0F;

    		SkirtBackL.rotateAngleX = SkirtLeftL.rotateAngleX = SkirtFrontL.rotateAngleX = 0.0F;
    		SkirtBackL.rotateAngleY = SkirtLeftL.rotateAngleY = SkirtFrontL.rotateAngleY = 0.0F;
    		SkirtBackL.rotateAngleZ = SkirtLeftL.rotateAngleZ = SkirtFrontL.rotateAngleZ = 0.0F;
    	}

    	bipedHead.rotationPointY = 4.0F;
    	bipedBody.rotationPointY = 4.0F;
    	bipedRightLeg.rotationPointY = 8.0F;
    	bipedLeftLeg.rotationPointY = 8.0F;
    	bipedRightArm.rotationPointY += 3.0F;
    	bipedLeftArm.rotationPointY += 3.0F;
    	bipedBody.rotationPointZ = 0.0F;
    	if(getIsSneak())
    	{
    		bipedHead.rotationPointY += 1.0F;
    		bipedBody.rotationPointY += 1.0F;
    		bipedBody.rotationPointZ -= 0.1F;
    		bipedRightLeg.rotationPointZ += 0.3F;
    		bipedLeftLeg.rotationPointZ += 0.3F;
    		bipedRightLeg.rotationPointY -= 1.0F;
    		bipedLeftLeg.rotationPointY -= 1.0F;
        	Skirt.rotationPointZ = 2.0F;
    	} else
    	{

    	}
    	if(getIsRiding())
    	{

    	}
    	if(getIsWait() && !getaimedBow())
    	{
    		bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = -0.4F;
    		bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    		bipedLeftArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleZ = 0.4F;
    	}
    	//スカートと髪ゆらゆら
    	RightSkirt.rotateAngleZ += mh_cos(f2 * 0.06F) * 0.03F + 0.03F;
    	LeftSkirt.rotateAngleZ -= mh_cos(f2 * 0.06F) * 0.03F + 0.03F;
    	RightSkirt.rotateAngleX += mh_sin(f2 * 0.04F) * 0.03F;
    	LeftSkirt.rotateAngleX -= mh_sin(f2 * 0.04F) * 0.03F;

    	SideTailR.rotateAngleZ =   mh_sin(f2 * 0.08F) * 0.03F + 0.03F;
    	SideTailL.rotateAngleZ = -(mh_sin(f2 * 0.08F) * 0.03F + 0.03F);
    	SideTailR.rotateAngleX =   mh_cos(f2 * 0.05F) * 0.03F;
    	SideTailL.rotateAngleX =   mh_cos(f2 * 0.05F) * 0.03F;
    	bipedHeadwear.rotateAngleX = -(mh_sin(f2 * 0.09F) * 0.03F + 0.03F);

    	if (skirtFloats) {
    		SkirtRight.rotateAngleY = 3.141592653F;
    		SkirtFront.setRotationPoint(-3.0F, 0.0F, -2.5F);
    		SkirtRight.setRotationPoint(-6.0F, 0.0F, -2.5F);
    		SkirtBack.setRotationPoint(-3.0F, 0.0F, 3.0F);
    		SkirtFrontL.setRotationPoint(-2.0F, 0.0F, -3.0F);
    		SkirtLeftL.setRotationPoint(6.0F, 0.0F, 2.5F);
    		SkirtBackL.setRotationPoint(-2.0F, 0.0F, 3.0F);
    		if(getIsSneak()) {
    			SkirtFront.rotationPointZ += 3.0F;
    			SkirtRight.rotationPointZ += 3.0F;
    			SkirtBack.rotationPointZ += 3.0F;
    			SkirtFrontL.rotationPointZ += 3.0F;
    			SkirtLeftL.rotationPointZ += 3.0F;
    			SkirtBackL.rotationPointZ += 3.0F;
    		}
    		SkirtFront.rotationPointX -= motionY * 2.0F;
    		SkirtFront.rotationPointY += motionY * 4.0F;
    		SkirtFront.rotationPointZ -= motionY * 8.0F;
    		SkirtRight.rotationPointX -= motionY * 8.0F;
    		SkirtRight.rotationPointY += motionY * 4.0F;
    		SkirtBack.rotationPointX -= motionY * 2.0F;
    		SkirtBack.rotationPointY += motionY * 4.0F;
    		SkirtBack.rotationPointZ += motionY * 8.0F;
    		SkirtFrontL.rotationPointX += motionY * 2.0F;
    		SkirtFrontL.rotationPointY += motionY * 4.0F;
    		SkirtFrontL.rotationPointZ -= motionY * 8.0F;
    		SkirtLeftL.rotationPointY += motionY * 4.0F;
    		SkirtLeftL.rotationPointX += motionY * 8.0F;
    		SkirtBackL.rotationPointX += motionY * 2.0F;
    		SkirtBackL.rotationPointY += motionY * 4.0F;
    		SkirtBackL.rotationPointZ += motionY * 8.0F;

    		SkirtFront.rotateAngleX += motionY;
    		SkirtRight.rotateAngleZ += -motionY / 2.0F;
    		SkirtBack.rotateAngleX += -motionY;
    		SkirtFrontL.rotateAngleX += motionY;
    		SkirtLeftL.rotateAngleZ += motionY / 2.0F;
    		SkirtBackL.rotateAngleX += -motionY;
    	}
    }

    @Override
    public void settingShowParts() {
    	super.settingShowParts();
    	//GUI パーツ表示・非表示初期設定
    	//前回の項目最後から7個上書きして設定
    	overridePartsNumber = 7;
    	int k = getPartsNumber() - overridePartsNumber;
    	if(k < 0) k = 0;
    	if(getPartsSetFlag() == 1) {
    		String s[] = {
    				"ChignonR" ,"ChignonL", "SideTailR", "SideTailL"
    		};
    		setParts(s, k);
    		setPartsSetFlag(2);
    	}

    	//GUI パーツ表示・非表示反映
    	if(getShowModelFlag() == 0) {
    		boolean b = getGuiShowModel(6);
    		RightSkirt.setVisible(b);
    		LeftSkirt.setVisible(b);
    		b = getGuiShowModel(k);
    		ChignonR.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		ChignonL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		SideTailR.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		SideTailL.setVisible(b);
    		setShowModelFlag(1);
    	}
    }

    @Override
    public float getHeight()
    {
    	return 1.58F;
    }

    @Override
    public float getWidth()
    {
    	return 0.55F;
    }

    @Override
	public float getyOffset() {
		return 1.4F;
	}

    @Override
	public double getMountedYOffset() {
		return 0.85D;
	}
}
