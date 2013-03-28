package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Yukkuri extends MultiModel {

    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;
    public Modchu_ModelRenderer Item1;
    public Modchu_ModelRenderer Item2;
    public Modchu_ModelRenderer HeadR;
    public Modchu_ModelRenderer HeadL;
    public Modchu_ModelRenderer HeadU;
    public Modchu_ModelRenderer HatFL;
    public Modchu_ModelRenderer HatBL;
    public Modchu_ModelRenderer HatFR;
    public Modchu_ModelRenderer HatBR;
    public Modchu_ModelRenderer Bangs1;
    public Modchu_ModelRenderer Bangs2;
    public Modchu_ModelRenderer Bangs3;
    public Modchu_ModelRenderer Bangs4;
    public Modchu_ModelRenderer MariribonL;
    public Modchu_ModelRenderer MariribonR;
    public Modchu_ModelRenderer MariribonC;
    public Modchu_ModelRenderer Hat1;
    public Modchu_ModelRenderer Hat2;
    public Modchu_ModelRenderer Hat3;
    public Modchu_ModelRenderer Hat4;
    public Modchu_ModelRenderer Hat5;
    public Modchu_ModelRenderer Hat6;
    public Modchu_ModelRenderer Hat7;
    public Modchu_ModelRenderer Hat8;
    public Modchu_ModelRenderer Hat9;
    public Modchu_ModelRenderer THat1;
    public Modchu_ModelRenderer THat2;
    public Modchu_ModelRenderer RSidehair1;
    public Modchu_ModelRenderer RSidehair2;
    public Modchu_ModelRenderer RSidehair3;
    public Modchu_ModelRenderer RSidehair4;
    public Modchu_ModelRenderer LSidehair1;
    public Modchu_ModelRenderer LSidehair2;
    public Modchu_ModelRenderer LSidehair3;
    public Modchu_ModelRenderer LSidehair4;
    public Modchu_ModelRenderer Backhair1;
    public Modchu_ModelRenderer Backhair2;
    public Modchu_ModelRenderer Backhair3;
    public Modchu_ModelRenderer Backhair4;
    public Modchu_ModelRenderer Backhair5;
    public Modchu_ModelRenderer Lribon;
    public Modchu_ModelRenderer Rribon;
    public Modchu_ModelRenderer HaneL1;
    public Modchu_ModelRenderer HaneL2;
    public Modchu_ModelRenderer HaneR1;
    public Modchu_ModelRenderer HaneR2;

    public MultiModel_Yukkuri()
    {
    	this(0.0F);
    }

    public MultiModel_Yukkuri(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_Yukkuri(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_Yukkuri(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    	HeadMount.setRotationPoint(0.0F, -1.0F, 0.0F);
    }

    @Override
    public void initModel(float f, float f1) {
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-5F, -8F, -5F, 10, 10, 10, f);
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Tail = new Modchu_ModelRenderer(this, 0, 0);
    	Tail.addBox(-5F, -8F, -4F, 10, 10, 10, f - 0.5F);
    	Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Tail);
    	HeadR = new Modchu_ModelRenderer(this, 0, 0);
    	HeadR.addBox(-6F, -8F, -5F, 10, 10, 10, f - 0.5F);
    	HeadR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(HeadR);
    	HeadL = new Modchu_ModelRenderer(this, 0, 0);
    	HeadL.addBox(-4F, -8F, -5F, 10, 10, 10, f - 0.5F);
    	HeadL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(HeadL);
    	HeadU = new Modchu_ModelRenderer(this, 0, 0);
    	HeadU.addBox(-5F, -9F, -5F, 10, 10, 10, f - 0.5F);
    	HeadU.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(HeadU);
//maegami
    	Bangs1 = new Modchu_ModelRenderer(this, 40, 0);
    	Bangs1.addBox(-5.3F, -7.5F, -5.5F, 3, 4, 1, f);
    	Bangs1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Bangs1);
    	Bangs2 = new Modchu_ModelRenderer(this, 40, 0);
    	Bangs2.addBox(-2.7F, -7.5F, -5.5F, 3, 4, 1, f);
    	Bangs2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Bangs2);
    	Bangs3 = new Modchu_ModelRenderer(this, 40, 0);
    	Bangs3.addBox(-0.1F, -7.5F, -5.5F, 3, 4, 1, f);
    	Bangs3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Bangs3);
    	Bangs4 = new Modchu_ModelRenderer(this, 40, 0);
    	Bangs4.addBox(2.2F, -7.5F, -5.5F, 3, 4, 1, f);
    	Bangs4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Bangs4);
//back hair
    	Backhair1 = new Modchu_ModelRenderer(this, 56, 0);
    	Backhair1.addBox(-1F, 0F, -1F, 2, 8, 2, f);
    	Backhair1.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(Backhair1);
    	Backhair2 = new Modchu_ModelRenderer(this, 56, 0);
    	Backhair2.addBox(-1F, 0F, -1F, 2, 8, 2, f);
    	Backhair2.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Backhair2);
    	Backhair3 = new Modchu_ModelRenderer(this, 56, 0);
    	Backhair3.addBox(-1F, 0F, -1F, 2, 8, 2, f);
    	Backhair3.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Backhair3);
    	Backhair4 = new Modchu_ModelRenderer(this, 56, 0);
    	Backhair4.addBox(-1F, 0F, -1F, 2, 8, 2, f);
    	Backhair4.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Backhair4);
    	Backhair5 = new Modchu_ModelRenderer(this, 56, 0);
    	Backhair5.addBox(-1F, 0F, -1F, 2, 8, 2, f);
    	Backhair5.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Backhair5);

    	SideTailL = new Modchu_ModelRenderer(this, 26, 20);
    	SideTailL.mirror = true;
    	SideTailL.addBox(1.0F, -13F, 1.5F, 6, 6, 2, f);
    	SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailL);
    	SideTailR = new Modchu_ModelRenderer(this, 26, 20);
    	SideTailR.addBox(-8F, -13F, 1.5F, 6, 6, 2, f);
    	SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailR);
    	ChignonL = new Modchu_ModelRenderer(this, 26, 20);
    	ChignonL.mirror = true;
    	ChignonL.addBox(-1F, -6F, 5.5F, 6, 6, 2, f - 0.5F);
    	ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonL);
    	ChignonR = new Modchu_ModelRenderer(this, 26, 20);
    	ChignonR.addBox(-6F, -6F, 5.5F, 6, 6, 2, f - 0.5F);
    	ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonR);
    	ChignonB = new Modchu_ModelRenderer(this, 29, 20);
    	ChignonB.addBox(-2F, -9.5F, 4F, 3, 5, 2, f + 0.1F);
    	ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonB);
//anko
    	bipedBody = new Modchu_ModelRenderer(this, 10, 24);
    	bipedBody.addBox(-1F, -1F, -1F, 2, 2, 2, f + 1.0F);
    	bipedBody.setRotationPoint(0.0F, 3.0F, 0.0F);
    	Skirt = new Modchu_ModelRenderer(this, 2, 20);
//ago
    	Skirt.addBox(-4F, -1F, -4F, 8, 4, 8, f);
    	Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Skirt);
//momiage
    	bipedRightArm = new Modchu_ModelRenderer(this, 48, 10);
    	bipedRightArm.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, f - 0.2F);
    	bipedRightArm.setRotationPoint(-2F, -1.5F, -1F);
    	bipedHead.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 10);
    	bipedLeftArm.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, f - 0.2F);
    	bipedLeftArm.setRotationPoint(0.0F, -1.5F, -1F);
    	bipedHead.addChild(bipedLeftArm);
//
    	bipedRightLeg = new Modchu_ModelRenderer(this);
    	bipedLeftLeg = new Modchu_ModelRenderer(this);
    	bipedRightLeg.isHidden = true;
    	bipedLeftLeg.isHidden = true;

    	eyeL = new Modchu_ModelRenderer(this, 5, 20);
    	eyeL.addPlate(0.0F, -6F, -5.001F, 5, 8, 0, f);
    	eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeL);
    	eyeR = new Modchu_ModelRenderer(this, 0, 20);
    	eyeR.addPlate(-5.0F, -6F, -5.001F, 5, 8, 0, f);
    	eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeR);
//temoti
    	Item1 = new Modchu_ModelRenderer(this, 40, 18);
    	Item1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, f);
    	Item1.setRotationPoint(0.0F, -4.5F, 0.4F);
    	bipedLeftArm.addChild(Item1);
    	Item1.rotateAngleX = -0.175F;
    	Item1.rotateAngleY = -0.524F;
    	Item1.rotateAngleZ = 0.175F;
    	Item2 = new Modchu_ModelRenderer(this, 40, 15);
    	Item2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, f);
    	Item2.setRotationPoint(0.0F, -1.5F, 0.4F);
    	bipedLeftArm.addChild(Item2);
    	Item2.rotateAngleX = -0.175F;
    	Item2.rotateAngleY = -0.524F;
    	Item2.rotateAngleZ = 0.175F;
//marisa hat_tuba
    	HatFL = new Modchu_ModelRenderer(this, 30, 0);
    	HatFL.addPlate(0F, 1F, -6.5F, 10, 10, 0, f);
    	HatFL.setRotationPoint(0.0F, 0F, 0F);
    	bipedHead.addChild(HatFL);
    	HatFL.rotateAngleX = -1.745F;
    	HatBL = new Modchu_ModelRenderer(this, 30, 0);
    	HatBL.addPlate(0.0F, -1F, 6.5F, 10, 10, 0, f);
    	HatBL.setRotationPoint(0.0F, 0F, 0F);
    	bipedHead.addChild(HatBL);
    	HatBL.rotateAngleX = 1.396F;
    	HatFR = new Modchu_ModelRenderer(this, 30, 0);
    	HatFR.mirror = true;
    	HatFR.addPlate(-10F, 1F, -6.5F, 10, 10, 0, f);
    	HatFR.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(HatFR);
    	HatFR.rotateAngleX = -1.745F;
    	HatBR = new Modchu_ModelRenderer(this, 30, 0);
    	HatBR.mirror = true;
    	HatBR.addPlate(-10F, -1F, 6.5F, 10, 10, 0, f);
    	HatBR.setRotationPoint(0F, 0.0F, 0F);
    	bipedHead.addChild(HatBR);
    	HatBR.rotateAngleX = 1.396F;
//marisa hat ribon
    	MariribonL = new Modchu_ModelRenderer(this, 50, 22);
    	MariribonL.mirror = true;
    	MariribonL.addBox(0.0F, -11F, -6.6F, 5, 4, 2, f);
    	MariribonL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(MariribonL);
    	MariribonR = new Modchu_ModelRenderer(this, 50, 22);
    	MariribonR.addBox(-5F, -11F, -6.6F, 5, 4, 2, f);
    	MariribonR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(MariribonR);
    	MariribonC = new Modchu_ModelRenderer(this, 52, 22);
    	MariribonC.addBox(-1.5F, -10.5F, -5.7F, 3, 4, 2, f);
    	MariribonC.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(MariribonC);
//marisa hat top parts
    	Hat1 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat1.addBox(-2.0F, -2.0F, 0F, 4, 4, 6, f);
    	Hat1.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat1);
    	Hat2 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat2.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
    	Hat2.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat2);
    	Hat3 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat3.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
    	Hat3.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat3);
    	Hat4 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat4.addBox(-2F, -2F, 0.0F, 4, 4, 6, f);
    	Hat4.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat4);
    	Hat5 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat5.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
    	Hat5.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat5);
    	Hat6 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat6.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, f);
    	Hat6.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat6);
    	Hat7 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat7.addBox(-2F, -2F, 0.0F, 4, 4, 6, f);
    	Hat7.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat7);
    	Hat8 = new Modchu_ModelRenderer(this, 36, 22);
    	Hat8.addBox(-2F, -2F, 0.0F, 4, 4, 6, f);
    	Hat8.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat8);

    	Hat9 = new Modchu_ModelRenderer(this, 56, 28);
    	Hat9.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, f + 0.8F);
    	Hat9.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(Hat9);
//tengu hat
    	THat1 = new Modchu_ModelRenderer(this, 10, 20);
    	THat1.addBox(0.0F, -2F, 0.0F, 2, 2, 2, f + 0.6F);
    	THat1.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(THat1);
    	THat2 = new Modchu_ModelRenderer(this, 10, 20);
    	THat2.addBox(0.0F, -2F, 0.0F, 2, 2, 2, f);
    	THat2.setRotationPoint(0F, 0F, 0.0F);
    	bipedHead.addChild(THat2);
//side hair
    	RSidehair1 = new Modchu_ModelRenderer(this, 48, 0);
    	RSidehair1.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
    	RSidehair1.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(RSidehair1);
    	RSidehair2 = new Modchu_ModelRenderer(this, 48, 0);
    	RSidehair2.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
    	RSidehair2.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(RSidehair2);
    	RSidehair3 = new Modchu_ModelRenderer(this, 48, 0);
    	RSidehair3.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
    	RSidehair3.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(RSidehair3);
    	RSidehair4 = new Modchu_ModelRenderer(this, 48, 0);
    	RSidehair4.addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);
    	RSidehair4.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(RSidehair4);
    	LSidehair1 = new Modchu_ModelRenderer(this, 48, 0);
    	LSidehair1.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
    	LSidehair1.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(LSidehair1);
    	LSidehair2 = new Modchu_ModelRenderer(this, 48, 0);
    	LSidehair2.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
    	LSidehair2.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(LSidehair2);
    	LSidehair3 = new Modchu_ModelRenderer(this, 48, 0);
    	LSidehair3.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
    	LSidehair3.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(LSidehair3);
    	LSidehair4 = new Modchu_ModelRenderer(this, 48, 0);
    	LSidehair4.addBox(0F, -1.0F, -1.0F, 2, 8, 2, f);
    	LSidehair4.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(LSidehair4);
//head side ribon
    	Rribon = new Modchu_ModelRenderer(this, 40, 10);
    	Rribon.addPlate(-8F, -5F, 0F, 8, 5, 0, f);
    	Rribon.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Rribon);
    	Lribon = new Modchu_ModelRenderer(this, 40, 5);
    	Lribon.addPlate(0F, -5F, 0F, 8, 5, 0, f);
    	Lribon.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Lribon);
//hane
    	HaneL1 = new Modchu_ModelRenderer(this, 0, 4);
    	HaneL1.addPlate(0F, -3F, 0F, 10, 6, 0, f);
    	HaneL1.setRotationPoint(2F, -3F, 6F);
    	bipedHead.addChild(HaneL1);

    	HaneL2 = new Modchu_ModelRenderer(this, 0, 0);
    	HaneL2.addPlate(0F, -1.5F, 0F, 8, 4, 0, f);
    	HaneL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(HaneL2);

    	HaneR1 = new Modchu_ModelRenderer(this, 0, 4);
    	HaneR1.mirror = true;
    	HaneR1.addPlate(-10F, -3F, 0F, 10, 6, 0, f);
    	HaneR1.setRotationPoint(-2F, -3F, 6F);
    	bipedHead.addChild(HaneR1);

    	HaneR2 = new Modchu_ModelRenderer(this, 0, 0);
    	HaneR2.mirror = true;
    	HaneR2.addPlate(-10F, -1.5F, 0F, 8, 4, 0, f);
    	HaneR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(HaneR2);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	SideTailL.rotateAngleX = SideTailR.rotateAngleX = -0.262F;
    	ChignonL.rotateAngleX = ChignonR.rotateAngleX = 0.262F;
    	ChignonL.rotateAngleZ = 0.262F;
    	ChignonR.rotateAngleZ = -0.262F;
//‘«Šp“xƒ}ƒCƒiƒX‚ÅƒWƒƒƒ“ƒv
    	bipedHead.rotationPointY = bipedRightLeg.rotateAngleX < 0.0F ? 20F : 20F - bipedRightLeg.rotateAngleX * 8F;
    	bipedBody.rotationPointY = bipedHead.rotationPointY - 3F;
    	Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);

    	bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.5F * f1 * 0.3F;
    	bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1 * 0.3F;
    	bipedRightArm.rotationPointX = -7.0F;
    	bipedRightArm.rotationPointZ = -3.0F;
    	bipedLeftArm.rotationPointX = 5.0F;
    	bipedLeftArm.rotationPointZ = -3.0F;
    	Item1.rotationPointX = 2.5F;
    	Item2.rotationPointX = 2.5F;
    	Item1.rotationPointY = 1.0F;
    	Item2.rotationPointY = -2F;
    	Item1.rotationPointZ = Item2.rotationPointZ = -3.5F;
    	MariribonL.rotateAngleX = -0.175F;
    	MariribonL.rotateAngleY = -0.175F;
    	MariribonL.rotateAngleZ = 0.087F;
    	MariribonR.rotateAngleX = -0.175F;
    	MariribonR.rotateAngleY = 0.175F;
    	MariribonR.rotateAngleZ = -0.087F;
    	MariribonC.rotateAngleX = -0.175F;

    	Hat1.rotateAngleX = 1.134F;
    	Hat1.rotateAngleY = 0.349F;
    	Hat1.rotateAngleZ = 0F;
    	Hat1.rotationPointX = -1.8F;
    	Hat1.rotationPointY = -6.8F;
    	Hat1.rotationPointZ = -2F;
    	Hat2.rotateAngleX = 1.134F;
    	Hat2.rotateAngleY = -0.349F;
    	Hat2.rotateAngleZ = 0F;
    	Hat2.rotationPointX = 1.9F;
    	Hat2.rotationPointY = -6.8F;
    	Hat2.rotationPointZ = -2F;
    	Hat3.rotateAngleX = 1.187F;
    	Hat3.rotateAngleY = 0F;
    	Hat3.rotateAngleZ = 0.262F;
    	Hat3.rotationPointX = -3.0F;
    	Hat3.rotationPointY = -6.5F;
    	Hat3.rotationPointZ = -1.1F;
    	Hat4.rotateAngleX = 1.187F;
    	Hat4.rotateAngleY = 0F;
    	Hat4.rotateAngleZ = -0.262F;
    	Hat4.rotationPointX = 3.3F;
    	Hat4.rotationPointY = -6.3F;
    	Hat4.rotationPointZ = -1.1F;
    	Hat5.rotateAngleX = -0.524F;
    	Hat5.rotateAngleY = 0.262F;
    	Hat5.rotateAngleZ = 0F;
    	Hat5.rotationPointX = -2.0F;
    	Hat5.rotationPointY = -9.9F;
    	Hat5.rotationPointZ = 1.5F;
    	Hat6.rotateAngleX = -0.524F;
    	Hat6.rotateAngleY = -0.262F;
    	Hat6.rotateAngleZ = 0F;
    	Hat6.rotationPointX = 2.2F;
    	Hat6.rotationPointY = -9.8F;
    	Hat6.rotationPointZ = 1.5F;
    	Hat7.rotateAngleX = 0.611F;
    	Hat7.rotateAngleY = 0F;
    	Hat7.rotateAngleZ = 0.017F;
    	Hat7.rotationPointX = 0F;
    	Hat7.rotationPointY = -11.3F;
    	Hat7.rotationPointZ = 0F;
    	Hat8.rotateAngleX = 0F;
    	Hat8.rotateAngleY = 1.571F;
    	Hat8.rotateAngleZ = 0.262F;
    	Hat8.rotationPointX = -3F;
    	Hat8.rotationPointY = -10.5F;
    	Hat8.rotationPointZ = 4.0F;
    	Hat9.rotateAngleX = 0F;
    	Hat9.rotateAngleY = 0F;
    	Hat9.rotateAngleZ = 0.785F;
    	Hat9.rotationPointX = 0F;
    	Hat9.rotationPointY = -14.2F;
    	Hat9.rotationPointZ = 4.5F;

    	THat1.rotateAngleX = 0F;
    	THat1.rotateAngleY = -0.785F;
    	THat1.rotateAngleZ = 0F;
    	THat1.rotationPointX = 0F;
    	THat1.rotationPointY = -7F;
    	THat1.rotationPointZ = -2F;
    	THat2.rotateAngleX = 0.785F;
    	THat2.rotateAngleY = 1.571F;
    	THat2.rotateAngleZ = 0F;
    	THat2.rotationPointX = 0F;
    	THat2.rotationPointY = -8F;
    	THat2.rotationPointZ = 0.5F;
//‰¡”¯ •à‚¢‚½‚Æ‚«ŠO‚ÉL‚ª‚é‚æ‚¤‚ÉB
    	RSidehair1.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
    	RSidehair1.rotationPointX = -4.5F;
    	RSidehair1.rotationPointY = -5F;
    	RSidehair1.rotationPointZ = -2F;
    	RSidehair2.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F + 0.2F) + 0.262F;
    	RSidehair2.rotationPointX = -4.5F;
    	RSidehair2.rotationPointY = -4.5F;
    	RSidehair2.rotationPointZ = 0F;
    	RSidehair3.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F + 0.1F) + 0.262F;
    	RSidehair3.rotationPointX = -4.5F;
    	RSidehair3.rotationPointY = -4.3F;
    	RSidehair3.rotationPointZ = 2F;
    	RSidehair4.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
    	RSidehair4.rotationPointX = -4.5F;
    	RSidehair4.rotationPointY = -4F;
    	RSidehair4.rotationPointZ = 4F;

    	LSidehair1.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F) - 0.262F;
    	LSidehair1.rotationPointX = 4.5F;
    	LSidehair1.rotationPointY = -5F;
    	LSidehair1.rotationPointZ = -2F;
    	LSidehair2.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F - 0.2F) - 0.262F;
    	LSidehair2.rotationPointX = 4.5F;
    	LSidehair2.rotationPointY = -4.5F;
    	LSidehair2.rotationPointZ = 0F;
    	LSidehair3.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F - 0.1F) - 0.262F;
    	LSidehair3.rotationPointX = 4.5F;
    	LSidehair3.rotationPointY = -4.3F;
    	LSidehair3.rotationPointZ = 2F;
    	LSidehair4.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F) - 0.262F;
    	LSidehair4.rotationPointX = 4.5F;
    	LSidehair4.rotationPointY = -4F;
    	LSidehair4.rotationPointZ = 4F;
//Œã‚ë”¯ •à‚¢‚½‚Æ‚«ŠO‚ÉL‚ª‚é‚æ‚¤‚É
    	Backhair1.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
    	Backhair1.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) + 0.175F;
    	Backhair1.rotationPointX = 4.0F;
    	Backhair1.rotationPointY = -5F;
    	Backhair1.rotationPointZ = 4.5F;
    	Backhair2.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F + 0.1F) + 0.262F;
    	Backhair2.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) + 0.087F;
    	Backhair2.rotationPointX = 2.0F;
    	Backhair2.rotationPointY = -4.8F;
    	Backhair2.rotationPointZ = 4.7F;
    	Backhair3.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F + 0.2F) + 0.262F;
    	Backhair3.rotationPointX = 0F;
    	Backhair3.rotationPointY = -5F;
    	Backhair3.rotationPointZ = 5F;
    	Backhair4.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F + 0.1F) + 0.262F;
    	Backhair4.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) - 0.087F;
    	Backhair4.rotationPointX = -2.0F;
    	Backhair4.rotationPointY = -4.8F;
    	Backhair4.rotationPointZ = 4.7F;
    	Backhair5.rotateAngleX = (bipedRightLeg.rotateAngleX / 3F) + 0.262F;
    	Backhair5.rotateAngleY = (bipedRightLeg.rotateAngleX / 3F) - 0.175F;
    	Backhair5.rotationPointX = -4.0F;
    	Backhair5.rotationPointY = -5F;
    	Backhair5.rotationPointZ = 4.5F;

    	Rribon.rotateAngleX = 0F;
    	Rribon.rotateAngleY = 0.349F;
    	Rribon.rotateAngleZ = (bipedRightLeg.rotateAngleX / 3F) - 0.262F;
    	Rribon.rotationPointX = -4F;
    	Rribon.rotationPointY = -7.5F;
    	Rribon.rotationPointZ = -3.5F;
    	Lribon.rotateAngleX = 0F;
    	Lribon.rotateAngleY = -0.349F;
    	Lribon.rotateAngleZ = (bipedLeftLeg.rotateAngleX / 3F) + 0.262F;
    	Lribon.rotationPointX = 4F;
    	Lribon.rotationPointY = -7.5F;
    	Lribon.rotationPointZ = -3.5F;

    	HaneL1.rotationPointX = 2F;
    	HaneL1.rotationPointY = -3F;
    	HaneL1.rotationPointZ = 6F;
    	HaneL1.rotateAngleX = 0.349F;
//h1 —ƒAŽ©“®“®‚« + ˆÚ“®“®‚«
    	float h1 =(MathHelper.cos(f2 * 0.2F) * 0.05F) + (bipedLeftLeg.rotateAngleX / 3F);
    	HaneL1.rotateAngleZ = h1 -0.262F;

    	HaneL2.rotationPointX = 11F;
    	HaneL2.rotationPointY = (MathHelper.sin(h1) * 8F) -6F;
    	HaneL2.rotationPointZ = 6F;
    	HaneL2.rotateAngleX = 0.349F;
    	HaneL2.rotateAngleY = h1 + 0.262F;

    	HaneR1.rotationPointX = -2F;
    	HaneR1.rotationPointY = -3F;
    	HaneR1.rotationPointZ = 6F;
    	HaneR1.rotateAngleX = 0.349F;
//h2 —ƒAŽ©“®“®‚« + ˆÚ“®“®‚« ‹t‘¤
    	float h2 =(MathHelper.cos(f2 * 0.2F + 3.141593F) * 0.05F) + (bipedRightLeg.rotateAngleX / 3F);
    	HaneR1.rotateAngleZ = h2 + 0.262F;

    	HaneR2.rotationPointX = -9F;
    	HaneR2.rotationPointY = (MathHelper.sin(h2) * -8F) -6F;
    	HaneR2.rotationPointZ = 6F;
    	HaneR2.rotateAngleX = 0.349F;
    	HaneR2.rotateAngleY = h2 - 0.262F;

    	if(getCapsValueBoolean(caps_getIsRiding)) {
    		bipedHead.rotationPointY = 15F;
    	}
    	armSwing(f, f1, f2, f3, f4, f5, entity);
    	if(getCapsValueBoolean(caps_getIsSneak)) {
    		bipedHead.rotationPointY = bipedRightLeg.rotateAngleX < 0.0F ? 20F : 20F - bipedRightLeg.rotateAngleX * 8F;
    	}
    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		bipedHead.rotationPointY = bipedRightLeg.rotateAngleX < 0.0F ? 20F : 20F - bipedRightLeg.rotateAngleX * 8F;
    	}
    	if(getCapsValueBoolean(caps_aimedBow)) {
    		float f6 = MathHelper.sin(getCapsValueFloat(caps_onGround) * 3.141593F);
    		float f7 = MathHelper.sin((1.0F - (1.0F - getCapsValueFloat(caps_onGround))
    				* (1.0F - getCapsValueFloat(caps_onGround))) * 3.141593F);
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
    		bipedRightArm.rotationPointX = -7F;
    		bipedLeftArm.rotationPointX = 6F;
    		bipedRightArm.rotationPointZ = -2F;
    		bipedLeftArm.rotationPointZ = -2F;
    		//•Ð–Ú‚Â‚Ô‚è
    		setCapsValue(caps_visible, eyeR, false);
    		setCapsValue(caps_visible, eyeL, true);
    	} else {

    		if(0.0D > (double)(mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
    			setCapsValue(caps_visible, eyeL, false);
    			setCapsValue(caps_visible, eyeR, false);
    		} else {
    			setCapsValue(caps_visible, eyeL, true);
    			setCapsValue(caps_visible, eyeR, true);
    		}
    	}
    }

    @Override
    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	float[] lgrounds = null;
    	float onGroundR = 0;
    	float onGroundL = 0;
    	if (modelCaps != null) {
    		lgrounds = (float[])getCapsValue(caps_Grounds);
    		if (lgrounds != null) {
    			onGroundR = lgrounds[0];
    			onGroundL = lgrounds[1];
    		}
    	}
    	if (lgrounds == null) {
    		onGroundR = onGround;
    	}
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !getCapsValueBoolean(caps_aimedBow) && !getCapsValueBoolean(caps_oldwalking)) {
    		// ˜rU‚è
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
    		} else {
    			bipedRightArm.rotateAngleZ = 0.0F;
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
    		} else {
    			bipedLeftArm.rotateAngleZ = 0.0F;
    		}
    	}
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s1 = {
    			"MariribonL", "MariribonR", "MariribonC", "RSidehair1", "RSidehair2",
    			"RSidehair3", "RSidehair4", "LSidehair1", "LSidehair2", "LSidehair3",
    			"LSidehair4", "Backhair1", "Backhair2", "Backhair3", "Backhair4",
    			"Backhair5"
    	};
    	String[] s2 = {
    			"M_ribonL", "M_ribonR", "M_ribonC", "R_hair1", "R_hair2",
    			"R_hair3", "R_hair4", "L_hair1", "L_hair2", "L_hair3",
    			"L_hair4", "B_hair1", "B_hair2", "B_hair3", "B_hair4",
    			"B_hair5"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		setCapsValue(caps_visible, Skirt, getGuiParts().get("Skirt"));
    	}
    }

    @Override
    public void actionInit1() {
    	setCapsValue(caps_shortcutKeysAction, true);
    	setCapsValue(caps_sneakBan, true);
    	setCapsValue(caps_waitBan, true);
    	setCapsValue(caps_sittingBan, true);
    }

    @Override
    public void actionRelease1() {
    	setCapsValue(caps_shortcutKeysAction, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);

    	bipedBody.rotateAngleX = 0.0F;
    	bipedBody.rotateAngleY = 0.0F;
    	bipedBody.rotateAngleZ = 0.0F;
    	bipedHead.rotateAngleX = 0.0F;
    	bipedHead.rotateAngleY = 0.0F;
    	bipedHead.rotateAngleZ = 0.0F;
    	bipedHead.rotationPointX = 0.0F;
    	bipedHead.rotationPointZ = 0.0F;
    }

    @Override
    public void action1(Entity entity) {
    	float speed = getCapsValueFloat(caps_actionSpeed) / 10;
    	if (speed < 0.0F) return;

    	float f1 = bipedBody.rotateAngleZ;

    	bipedRightArm.rotateAngleX = -f1 * 1.86567233F;
    	bipedRightArm.rotateAngleY = 0.0F;
    	bipedRightArm.rotateAngleZ = 0.0F;
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
    	if (f1 > 0.0F) {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 3.5F + (f1 * 2.61778528F);
    	} else {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 3.5F - (f1 * 2.61778528F);
    	}
    	bipedHead.rotationPointX = f1 * 2.10447914F;
    	bipedHead.rotateAngleX = -f1 * 0.2F;
    	bipedHead.rotateAngleY = f1 * 0.2F;
    	bipedHead.rotateAngleZ = f1;
    	bipedLeftArm.rotateAngleX = -bipedRightArm.rotateAngleX;
    	bipedLeftArm.rotateAngleY = bipedRightArm.rotateAngleY;
    	bipedLeftArm.rotateAngleZ = bipedRightArm.rotateAngleZ;
    	bipedBody.rotateAngleZ = f1;
    }

    @Override
    public float getHeight()
    {
    	return 0.999F;
    }

    @Override
    public float getWidth()
    {
    	return 1.2F;
    }

    @Override
    public float getyOffset() {
    	return 0.4F;
    }

    @Override
    public double getMountedYOffset() {
    	double d = 1.4D;
    	if(getCapsValueBoolean(caps_getIsRiding)) {
    		d -= 0.1D;
    	};
    	return d;
    }
}
