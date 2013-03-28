package net.minecraft.src;

public class MultiModel_VUD1 extends MultiModel_Aug
{
    public Modchu_ModelRenderer SideTailRoot_R;
    public Modchu_ModelRenderer SideTailRoot_L;
    public Modchu_ModelRenderer SideTailM_RU;
    public Modchu_ModelRenderer SideTailM_RB;
    public Modchu_ModelRenderer SideTailM_LU;
    public Modchu_ModelRenderer SideTailM_LB;
    public Modchu_ModelRenderer SideTailF_RU;
    public Modchu_ModelRenderer SideTailF_RB;
    public Modchu_ModelRenderer SideTailF_LU;
    public Modchu_ModelRenderer SideTailF_LB;
    public Modchu_ModelRenderer SideTailN_LU;
    public Modchu_ModelRenderer SideTailN_LB;
    public Modchu_ModelRenderer SideTailR_R;
    public Modchu_ModelRenderer SideTailR_L;
    public Modchu_ModelRenderer Tail_T;
    public Modchu_ModelRenderer Tail_U;
    public Modchu_ModelRenderer Tail_B;
    public Modchu_ModelRenderer DropTail;
    public Modchu_ModelRenderer Roll1_R;
    public Modchu_ModelRenderer Roll2_R;
    public Modchu_ModelRenderer Roll3_R;
    public Modchu_ModelRenderer Roll4_R;
    public Modchu_ModelRenderer Roll1_L;
    public Modchu_ModelRenderer Roll2_L;
    public Modchu_ModelRenderer Roll3_L;
    public Modchu_ModelRenderer Roll4_L;
    public Modchu_ModelRenderer DumplingHari_L;
    public Modchu_ModelRenderer HairOrnamentM_R;
    public Modchu_ModelRenderer HairOrnamentM_L;
    public Modchu_ModelRenderer HairOrnamentF_R;
    public Modchu_ModelRenderer HairOrnamentF_L;
    public Modchu_ModelRenderer HairOrnamentN_L;
    public Modchu_ModelRenderer Ribon1_R;
    public Modchu_ModelRenderer Ribon2_R;
    public Modchu_ModelRenderer Ribon3_R;
    public Modchu_ModelRenderer Ribon4_R;
    public Modchu_ModelRenderer Ribon5_R;
    public Modchu_ModelRenderer Ribon1_L;
    public Modchu_ModelRenderer Ribon2_L;
    public Modchu_ModelRenderer Ribon3_L;
    public Modchu_ModelRenderer Ribon4_L;
    public Modchu_ModelRenderer Ribon5_L;
    public Modchu_ModelRenderer Ribon1_BU;
    public Modchu_ModelRenderer Ribon2_BU;
    public Modchu_ModelRenderer Ribon3_BU;
    public Modchu_ModelRenderer Ribon4_BU;
    public Modchu_ModelRenderer Ribon5_BU;
    public Modchu_ModelRenderer Ribon1_BB;
    public Modchu_ModelRenderer Ribon2_BB;
    public Modchu_ModelRenderer Ribon3_BB;
    public Modchu_ModelRenderer Ribon4_BB;
    public Modchu_ModelRenderer Ribon5_BB;
    public Modchu_ModelRenderer Ribon1_T;
    public Modchu_ModelRenderer Ribon2_T;
    public Modchu_ModelRenderer Ribon3_T;
    public Modchu_ModelRenderer Headwear_F;
    public Modchu_ModelRenderer Headwear_B;
    public Modchu_ModelRenderer Headwear_R;
    public Modchu_ModelRenderer Headwear_L;
    public Modchu_ModelRenderer Shaggy_F;
    public Modchu_ModelRenderer LongHair_F;
    public Modchu_ModelRenderer LongHair_B;
    public Modchu_ModelRenderer LongHair_R;
    public Modchu_ModelRenderer LongHair_L;
    public Modchu_ModelRenderer Cheek_R;
    public Modchu_ModelRenderer Cheek_L;
    public Modchu_ModelRenderer Body_F;
    public Modchu_ModelRenderer Body_B;
    public Modchu_ModelRenderer Breast1;
    public Modchu_ModelRenderer Breast2;
    public Modchu_ModelRenderer Breast3;
    public Modchu_ModelRenderer Belt_R;
    public Modchu_ModelRenderer Belt_L;
    public Modchu_ModelRenderer Number;
    public Modchu_ModelRenderer Negi1;
    public Modchu_ModelRenderer Negi2;
    public Modchu_ModelRenderer Negi3;

    public MultiModel_VUD1()
    {
    	this(0.0F);
    }

    public MultiModel_VUD1(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_VUD1(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_VUD1(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	textureWidth = 64;
    	textureHeight = 64;
    	f1 += 8F;
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedBody = new Modchu_ModelRenderer(this, 32, 8);
    	bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
    	bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
    	bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
    	bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.0F);
    	bipedBody.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
    	bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	bipedLeftArm.setRotationPoint(3.0F, 4.5F, 0.0F);
    	bipedBody.addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);
    	bipedBody.addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 46, 19);
    	bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
    	bipedBody.addChild(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 2, 18);
    	Skirt.addBox(-4F, -2F, -3F, 8, 8, 6, f);
    	Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);
    	bipedBody.addChild(Skirt);
    	SideTailR = new Modchu_ModelRenderer(this);
    	SideTailL = new Modchu_ModelRenderer(this);
    	SideTailRoot_R = new Modchu_ModelRenderer(this, 54, 40);
    	SideTailRoot_R.addBox(-1F, -0.5F, -0.5F, 1, 1, 1, f + 0.15F);
    	SideTailRoot_R.setRotationPointLM(-4F, -7F, 2.0F);
    	SideTailRoot_L = new Modchu_ModelRenderer(this, 54, 40);
    	SideTailRoot_L.mirror = true;
    	SideTailRoot_L.addBox(0.0F, -0.5F, -0.5F, 1, 1, 1, f + 0.15F);
    	SideTailRoot_L.setRotationPointLM(4F, -7F, 2.0F);
    	SideTailM_RU = new Modchu_ModelRenderer(this, 56, 40);
    	SideTailM_RU.addBox(-2F, -1F, -1F, 2, 10, 2, f - 0.3F);
    	SideTailM_RU.setRotationPointLM(-4.8F, -7F, 2.0F);
    	SideTailM_RU.setRotateAngleZ(0.087266F);
    	SideTailM_RB = new Modchu_ModelRenderer(this, 56, 52);
    	SideTailM_RB.addBoxLM(-1.5F, 0.0F, -1F, 2, 10, 2, f);
    	SideTailM_RB.setRotationPointLM(-0.5F, 8.5F, 0.0F);
    	SideTailM_RB.setRotateAngleZ(0.087266F);
    	SideTailM_LU = new Modchu_ModelRenderer(this, 56, 40);
    	SideTailM_LU.mirror = true;
    	SideTailM_LU.addBox(0.0F, -1F, -1F, 2, 10, 2, f - 0.3F);
    	SideTailM_LU.setRotationPointLM(4.8F, -7F, 2.0F);
    	SideTailM_LU.setRotateAngleZ(-0.087266F);
    	SideTailM_LB = new Modchu_ModelRenderer(this, 56, 52);
    	SideTailM_LB.mirror = true;
    	SideTailM_LB.addBoxLM(0.5F, 0.0F, -1F, 2, 10, 2, f);
    	SideTailM_LB.setRotationPointLM(-0.5F, 8.5F, 0.0F);
    	SideTailM_LB.setRotateAngleZ(-0.087266F);
    	SideTailF_RU = new Modchu_ModelRenderer(this, 32, 44);
    	SideTailF_RU.addBox(-2F, -1.5F, -1F, 2, 8, 2, f - 0.3F);
    	SideTailF_RU.setRotationPointLM(-4.8F, -7F, 2.0F);
    	SideTailF_RU.setRotateAngleZ(0.087266F);
    	SideTailF_RB = new Modchu_ModelRenderer(this, 32, 54);
    	SideTailF_RB.addBoxLM(-1.5F, 0.0F, -1F, 2, 8, 2, f);
    	SideTailF_RB.setRotationPointLM(-0.5F, 6.5F, 0.0F);
    	SideTailF_RB.setRotateAngleZ(0.087266F);
    	SideTailF_LU = new Modchu_ModelRenderer(this, 32, 44);
    	SideTailF_LU.mirror = true;
    	SideTailF_LU.addBox(0.0F, -1.5F, -1F, 2, 8, 2, f - 0.3F);
    	SideTailF_LU.setRotationPointLM(4.8F, -7F, 2.0F);
    	SideTailF_LU.setRotateAngleZ(-0.087266F);
    	SideTailF_LB = new Modchu_ModelRenderer(this, 32, 54);
    	SideTailF_LB.mirror = true;
    	SideTailF_LB.addBoxLM(0.5F, 0.0F, -1F, 2, 8, 2, f);
    	SideTailF_LB.setRotationPointLM(-0.5F, 6.5F, 0.0F);
    	SideTailF_LB.setRotateAngleZ(-0.087266F);
    	SideTailN_LU = new Modchu_ModelRenderer(this, 48, 40);
    	SideTailN_LU.addBoxLM(0.0F, -1F, -1F, 2, 10, 2, f);
    	SideTailN_LU.setRotationPointLM(5F, -7F, 2.0F);
    	SideTailN_LU.setRotateAngleZ(0.0F);
    	SideTailN_LB = new Modchu_ModelRenderer(this, 48, 40);
    	SideTailN_LB.addBoxLM(0.5F, 0.0F, -2F, 2, 10, 2, f);
    	SideTailN_LB.setRotationPointLM(-0.5F, 8.5F, 1.0F);
    	SideTailN_LB.setRotateAngleZ(0.0F);
    	SideTailR_R = new Modchu_ModelRenderer(this, 48, 52);
    	SideTailR_R.addBoxLM(-2F, -1F, -1F, 2, 10, 2, f);
    	SideTailR_R.setRotationPointLM(-4.001F, -8F, 0.0F);
    	SideTailR_R.setRotateAngleZ(0.0F);
    	SideTailR_L = new Modchu_ModelRenderer(this, 48, 52);
    	SideTailR_L.mirror = true;
    	SideTailR_L.addBoxLM(0.0F, -1F, -1F, 2, 10, 2, f);
    	SideTailR_L.setRotationPointLM(4.001F, -8F, 0.0F);
    	SideTailR_L.setRotateAngleZ(0.0F);
    	Tail_T = new Modchu_ModelRenderer(this, 32, 40);
    	Tail_T.addBoxLM(-1F, -1F, 0.0F, 2, 2, 2, f);
    	Tail_T.setRotationPointLM(0.0F, -8F, 4F);
    	Tail_U = new Modchu_ModelRenderer(this, 40, 40);
    	Tail_U.addBoxLM(-1F, -1F, 0.0F, 2, 10, 2, f);
    	Tail_U.setRotationPointLM(0.0F, -6F, 4F);
    	Tail_B = new Modchu_ModelRenderer(this, 40, 52);
    	Tail_B.addBoxLM(-1F, 0.0F, -1F, 2, 10, 2, f + 0.2F);
    	Tail_B.setRotationPointLM(0.0F, 9.0F, 1.0F);
    	DropTail = new Modchu_ModelRenderer(this, 24, 40);
    	DropTail.addBoxLM(-1F, 0.0F, -1F, 2, 10, 2, f);
    	DropTail.setRotationPointLM(0.0F, -1F, 4F);
    	Roll1_R = new Modchu_ModelRenderer(this, 24, 60);
    	Roll1_R.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
    	Roll1_R.setRotationPointLM(-5.6F, -7F, 1.5F);
    	Roll1_R.setRotateAngleX(-((float)Math.PI / 2F));
    	Roll2_R = new Modchu_ModelRenderer(this, 24, 56);
    	Roll2_R.addBoxLM(-1F, -1F, 0.0F, 2, 2, 2, f);
    	Roll2_R.setRotationPointLM(0.0F, 0.0F, 1.0F);
    	Roll3_R = new Modchu_ModelRenderer(this, 24, 56);
    	Roll3_R.addBoxLM(-1F, -1F, 0.0F, 2, 2, 2, f);
    	Roll3_R.setRotationPointLM(0.0F, 0.0F, 3F);
    	Roll4_R = new Modchu_ModelRenderer(this, 26, 53);
    	Roll4_R.addBoxLM(-0.5F, -0.5F, 0.0F, 1, 1, 2, f);
    	Roll4_R.setRotationPointLM(0.0F, 0.0F, 5F);
    	Roll1_L = new Modchu_ModelRenderer(this, 24, 60);
    	Roll1_L.mirror = true;
    	Roll1_L.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
    	Roll1_L.setRotationPointLM(5.6F, -7F, 1.5F);
    	Roll1_L.setRotateAngleX(-((float)Math.PI / 2F));
    	Roll2_L = new Modchu_ModelRenderer(this, 24, 56);
    	Roll2_L.mirror = true;
    	Roll2_L.addBoxLM(-1F, -1F, 0.0F, 2, 2, 2, f);
    	Roll2_L.setRotationPointLM(0.0F, 0.0F, 1.0F);
    	Roll3_L = new Modchu_ModelRenderer(this, 24, 56);
    	Roll3_L.mirror = true;
    	Roll3_L.addBoxLM(-1F, -1F, 0.0F, 2, 2, 2, f);
    	Roll3_L.setRotationPointLM(0.0F, 0.0F, 3F);
    	Roll4_L = new Modchu_ModelRenderer(this, 26, 53);
    	Roll4_L.mirror = true;
    	Roll4_L.addBoxLM(-0.5F, -0.5F, 0.0F, 1, 1, 2, f);
    	Roll4_L.setRotationPointLM(0.0F, 0.0F, 5F);
    	DumplingHari_L = new Modchu_ModelRenderer(this, 10, 58);
    	DumplingHari_L.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 3, f);
    	DumplingHari_L.setRotationPointLM(3.5F, -7.5F, 3F);
    	HairOrnamentM_R = new Modchu_ModelRenderer(this, 0, 32);
    	HairOrnamentM_R.addBoxLM(-2.5F, -2.5F, 0.0F, 5, 5, 3, f - 0.9F);
    	HairOrnamentM_R.setRotationPointLM(-3.1F, -7F, 2.0F);
    	HairOrnamentM_R.setRotateAngleZ(-((float)Math.PI / 2F));
    	HairOrnamentM_R.setRotateAngleY(((float)Math.PI / 4F));
    	HairOrnamentM_R.setRotateAngleX(((float)Math.PI / 2F));
    	HairOrnamentM_L = new Modchu_ModelRenderer(this, 0, 32);
    	HairOrnamentM_L.addBoxLM(-2.5F, -2.5F, 0.0F, 5, 5, 3, f - 0.9F);
    	HairOrnamentM_L.setRotationPointLM(3.1F, -7F, 2.0F);
    	HairOrnamentM_L.setRotateAngleZ(((float)Math.PI / 2F));
    	HairOrnamentM_L.setRotateAngleY(-((float)Math.PI / 4F));
    	HairOrnamentM_L.setRotateAngleX(((float)Math.PI / 2F));
    	HairOrnamentF_R = new Modchu_ModelRenderer(this, 8, 40);
    	HairOrnamentF_R.addBox(-1.5F, -1.5F, -0.5F, 3, 3, 1, f - 0.2F);
    	HairOrnamentF_R.setRotationPointLM(-4.5F, -7F, 2.0F);
    	HairOrnamentF_R.setRotateAngleY(-((float)Math.PI / 2F));
    	HairOrnamentF_L = new Modchu_ModelRenderer(this, 16, 40);
    	HairOrnamentF_L.addBox(-1.5F, -1.5F, -0.5F, 3, 3, 1, f - 0.2F);
    	HairOrnamentF_L.setRotationPointLM(4.5F, -7F, 2.0F);
    	HairOrnamentF_L.setRotateAngleY(((float)Math.PI / 2F));
    	HairOrnamentN_L = new Modchu_ModelRenderer(this, 0, 40);
    	HairOrnamentN_L.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
    	HairOrnamentN_L.setRotationPointLM(4F, -7F, 2.0F);
    	HairOrnamentN_L.setRotateAngleY(((float)Math.PI / 2F));
    	Ribon1_R = new Modchu_ModelRenderer(this, 0, 56);
    	Ribon1_R.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 1, f - 0.3F);
    	Ribon1_R.setRotationPointLM(-1.5F, 1.1F, 0.0F);
    	Ribon1_R.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon1_R.setRotateAngleX(((float)Math.PI / 2F));
    	Ribon2_R = new Modchu_ModelRenderer(this, 0, 56);
    	Ribon2_R.addBoxLM(0.0F, -3F, 0.0F, 4, 3, 1, f);
    	Ribon2_R.setRotationPointLM(-1.5F, 0.7F, -0.5F);
    	Ribon2_R.setRotateAngleZ(((float)Math.PI / 2F));
    	Ribon2_R.setRotateAngleY(0.0F);
    	Ribon3_R = new Modchu_ModelRenderer(this, 0, 56);
    	Ribon3_R.addBoxLM(0.0F, -3F, -1F, 4, 3, 1, f);
    	Ribon3_R.setRotationPointLM(-1.5F, -0.7F, -0.5F);
    	Ribon3_R.setRotateAngleZ(((float)Math.PI / 2F));
    	Ribon3_R.setRotateAngleY(-(float)Math.PI);
    	Ribon4_R = new Modchu_ModelRenderer(this, 0, 56);
    	Ribon4_R.addBoxLM(0.0F, -3F, 0.0F, 4, 3, 1, f - 0.2F);
    	Ribon4_R.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon4_R.setRotateAngleZ(1.308997F);
    	Ribon5_R = new Modchu_ModelRenderer(this, 0, 56);
    	Ribon5_R.addBoxLM(0.0F, -3F, -1F, 4, 3, 1, f - 0.2F);
    	Ribon5_R.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon5_R.setRotateAngleZ(1.308997F);
    	Ribon1_L = new Modchu_ModelRenderer(this, 0, 60);
    	Ribon1_L.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 1, f - 0.3F);
    	Ribon1_L.setRotationPointLM(1.5F, 1.1F, 0.0F);
    	Ribon1_L.setRotateAngleZ(((float)Math.PI / 2F));
    	Ribon1_L.setRotateAngleX(((float)Math.PI / 2F));
    	Ribon2_L = new Modchu_ModelRenderer(this, 0, 60);
    	Ribon2_L.addBoxLM(0.0F, -3F, 0.0F, 4, 3, 1, f);
    	Ribon2_L.setRotationPointLM(1.5F, 0.7F, 0.5F);
    	Ribon2_L.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon2_L.setRotateAngleY((float)Math.PI);
    	Ribon3_L = new Modchu_ModelRenderer(this, 0, 60);
    	Ribon3_L.addBoxLM(0.0F, -3F, -1F, 4, 3, 1, f);
    	Ribon3_L.setRotationPointLM(1.5F, -0.7F, 0.5F);
    	Ribon3_L.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon3_L.setRotateAngleY(0.0F);
    	Ribon4_L = new Modchu_ModelRenderer(this, 0, 60);
    	Ribon4_L.addBoxLM(0.0F, -3F, 0.0F, 4, 3, 1, f - 0.2F);
    	Ribon4_L.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon4_L.setRotateAngleZ(1.308997F);
    	Ribon5_L = new Modchu_ModelRenderer(this, 0, 60);
    	Ribon5_L.addBoxLM(0.0F, -3F, -1F, 4, 3, 1, f - 0.2F);
    	Ribon5_L.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon5_L.setRotateAngleZ(1.308997F);
    	Ribon1_BU = new Modchu_ModelRenderer(this, 0, 48);
    	Ribon1_BU.addBoxLM(-1.5F, -1.5F, 1.0F, 3, 3, 1, f - 0.3F);
    	Ribon1_BU.setRotationPointLM(0.0F, 1.5F, 0.7F);
    	Ribon1_BU.setRotateAngleZ(((float)Math.PI / 2F));
    	Ribon2_BU = new Modchu_ModelRenderer(this, 0, 48);
    	Ribon2_BU.addBoxLM(-4F, -3F, 1.0F, 4, 3, 1, f);
    	Ribon2_BU.setRotationPointLM(1.5F, 0.7F, -0.5F);
    	Ribon2_BU.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon3_BU = new Modchu_ModelRenderer(this, 0, 48);
    	Ribon3_BU.addBoxLM(0.0F, -3F, 1.0F, 4, 3, 1, f);
    	Ribon3_BU.setRotationPointLM(1.5F, -0.7F, -0.5F);
    	Ribon3_BU.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon4_BU = new Modchu_ModelRenderer(this, 0, 48);
    	Ribon4_BU.addBoxLM(-4F, -3F, 1.0F, 4, 3, 1, f - 0.2F);
    	Ribon4_BU.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon4_BU.setRotateAngleZ(-1.308997F);
    	Ribon5_BU = new Modchu_ModelRenderer(this, 0, 48);
    	Ribon5_BU.addBoxLM(0.0F, -3F, 1.0F, 4, 3, 1, f - 0.2F);
    	Ribon5_BU.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon5_BU.setRotateAngleZ(1.308997F);
    	Ribon1_BB = new Modchu_ModelRenderer(this, 0, 52);
    	Ribon1_BB.addBoxLM(-1.5F, -1.5F, 1.0F, 3, 3, 1, f - 0.3F);
    	Ribon1_BB.setRotationPointLM(0.0F, 0.5F, -0.3F);
    	Ribon1_BB.setRotateAngleZ(((float)Math.PI / 2F));
    	Ribon2_BB = new Modchu_ModelRenderer(this, 0, 52);
    	Ribon2_BB.addBoxLM(-4F, -3F, 1.0F, 4, 3, 1, f);
    	Ribon2_BB.setRotationPointLM(1.5F, 0.7F, -0.5F);
    	Ribon2_BB.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon3_BB = new Modchu_ModelRenderer(this, 0, 52);
    	Ribon3_BB.addBoxLM(0.0F, -3F, 1.0F, 4, 3, 1, f);
    	Ribon3_BB.setRotationPointLM(1.5F, -0.7F, -0.5F);
    	Ribon3_BB.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon4_BB = new Modchu_ModelRenderer(this, 0, 52);
    	Ribon4_BB.addBoxLM(-4F, -3F, 1.0F, 4, 3, 1, f - 0.2F);
    	Ribon4_BB.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon4_BB.setRotateAngleZ(-1.308997F);
    	Ribon5_BB = new Modchu_ModelRenderer(this, 0, 52);
    	Ribon5_BB.addBoxLM(0.0F, -3F, 1.0F, 4, 3, 1, f - 0.2F);
    	Ribon5_BB.setRotationPointLM(0.0F, -0.2F, 0.0F);
    	Ribon5_BB.setRotateAngleZ(1.308997F);
    	Ribon1_T = new Modchu_ModelRenderer(this, 1, 44);
    	Ribon1_T.addBoxLM(-0.5F, -0.5F, -1F, 1, 1, 1, f + 0.1F);
    	Ribon1_T.setRotationPointLM(0.0F, -7.8F, -1.5F);
    	Ribon1_T.setRotateAngleZ(((float)Math.PI / 2F));
    	Ribon1_T.setRotateAngleY(1.396263F);
    	Ribon2_T = new Modchu_ModelRenderer(this, 0, 44);
    	Ribon2_T.addBoxLM(-4F, -1.5F, -1F, 4, 3, 1, f);
    	Ribon2_T.setRotationPointLM(0.0F, 0.5F, 0.0F);
    	Ribon2_T.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon2_T.setRotateAngleY(-0.174533F);
    	Ribon3_T = new Modchu_ModelRenderer(this, 0, 44);
    	Ribon3_T.mirror = true;
    	Ribon3_T.addBoxLM(0.0F, -1.5F, -1F, 4, 3, 1, f);
    	Ribon3_T.setRotationPointLM(0.0F, -0.5F, 0.0F);
    	Ribon3_T.setRotateAngleZ(-((float)Math.PI / 2F));
    	Ribon3_T.setRotateAngleY(0.174533F);
    	Headwear_F = new Modchu_ModelRenderer(this, 24, 16);
    	Headwear_F.addPlate(-4F, 0.0F, 0.0F, 8, 4, 0, f);
    	Headwear_F.setRotationPointLM(0.0F, 0.0F, -4F);
    	Headwear_B = new Modchu_ModelRenderer(this, 24, 20);
    	Headwear_B.addPlate(-4F, 0.0F, 0.0F, 8, 4, 4, f);
    	Headwear_B.setRotationPointLM(0.0F, 0.0F, 4F);
    	Headwear_R = new Modchu_ModelRenderer(this, 44, 0);
    	Headwear_R.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 5, f);
    	Headwear_R.setRotationPointLM(-4F, 0.0F, 0.0F);
    	Headwear_L = new Modchu_ModelRenderer(this, 44, 4);
    	Headwear_L.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 1, f);
    	Headwear_L.setRotationPointLM(4F, 0.0F, 0.0F);
    	Shaggy_F = new Modchu_ModelRenderer(this, 34, 0);
    	Shaggy_F.addPlate(-5F, 0.0F, 0.0F, 10, 4, 0, f);
    	Shaggy_F.setRotationPointLM(0.0F, -1.0F, -4F);
    	Shaggy_F.setRotateAngleX(-0.4F);
    	shaggyB = new Modchu_ModelRenderer(this, 24, 0);
    	shaggyB.addPlate(-5F, 0.0F, 0.0F, 10, 4, 4, f);
    	shaggyB.setRotationPointLM(0.0F, -1.0F, 4F);
    	shaggyB.setRotateAngleX(0.4F);
    	shaggyR = new Modchu_ModelRenderer(this, 24, 4);
    	shaggyR.addPlate(0.0F, 0.0F, -5F, 10, 4, 5, f);
    	shaggyR.setRotationPointLM(-4F, -1.0F, 0.0F);
    	shaggyR.setRotateAngleZ(0.4F);
    	shaggyL = new Modchu_ModelRenderer(this, 34, 4);
    	shaggyL.addPlate(0.0F, 0.0F, -5F, 10, 4, 1, f);
    	shaggyL.setRotationPointLM(4F, -1.0F, 0.0F);
    	shaggyL.setRotateAngleZ(-0.4F);
    	sidetailUpperR = new Modchu_ModelRenderer(this);
    	sidetailUpperL = new Modchu_ModelRenderer(this);
    	LongHair_F = new Modchu_ModelRenderer(this, 34, 32);
    	LongHair_F.addPlate(-5F, 0.0F, 0.0F, 10, 8, 0, f);
    	LongHair_F.setRotationPointLM(0.0F, -1.0F, -4F);
    	LongHair_F.setRotateAngleX(-0.202458F);
    	LongHair_B = new Modchu_ModelRenderer(this, 24, 32);
    	LongHair_B.addPlate(-5F, 0.0F, 0.0F, 10, 8, 4, f);
    	LongHair_B.setRotationPointLM(0.0F, -1.0F, 4F);
    	LongHair_B.setRotateAngleX(0.202458F);
    	LongHair_R = new Modchu_ModelRenderer(this, 44, 32);
    	LongHair_R.addPlate(0.0F, 0.0F, -5F, 10, 8, 5, f);
    	LongHair_R.setRotationPointLM(-4F, -1.0F, 0.0F);
    	LongHair_R.setRotateAngleZ(0.202458F);
    	LongHair_L = new Modchu_ModelRenderer(this, 54, 32);
    	LongHair_L.addPlate(0.0F, 0.0F, -5F, 10, 8, 1, f);
    	LongHair_L.setRotationPointLM(4F, -1.0F, 0.0F);
    	LongHair_L.setRotateAngleZ(-0.202458F);
    	sensor1 = new Modchu_ModelRenderer(this, 0, 0);
    	sensor1.addPlate(-8F, -4F, 0.0F, 8, 4, 0, f);
    	sensor1.setRotationPointLM(0.0F, -8F, 0.0F);
    	sensor2 = new Modchu_ModelRenderer(this, 0, 4);
    	sensor2.addPlate(0.0F, -4F, 0.0F, 8, 4, 0, f);
    	sensor2.setRotationPointLM(0.0F, -8F, 0.0F);
    	sensor3 = new Modchu_ModelRenderer(this, 0, 20);
    	sensor3.addPlate(0.0F, -4F, -0F, 8, 4, 1, f);
    	sensor3.setRotationPointLM(0.0F, -8F, 0.0F);
    	sensor4 = new Modchu_ModelRenderer(this, 0, 16);
    	sensor4.addPlate(0.0F, -4F, -8F, 8, 4, 1, f);
    	sensor4.setRotationPointLM(0.0F, -8F, 0.0F);
    	eyeR = new Modchu_ModelRenderer(this, 42, 19);
    	eyeR.addPlate(-4F, -5F, -4.001F, 4, 4, 0, f);
    	eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	eyeL = new Modchu_ModelRenderer(this, 46, 19);
    	eyeL.addPlate(0.0F, -5F, -4.001F, 4, 4, 0, f);
    	eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	Cheek_R = new Modchu_ModelRenderer(this, 32, 8);
    	Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
    	Cheek_R.setRotationPointLM(0.0F, 1.0F, 0.0F);
    	Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
    	Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
    	Cheek_L.setRotationPointLM(0.0F, 1.0F, 0.0F);
    	Body_F = new Modchu_ModelRenderer(this, 56, 16);
    	Body_F.addPlate(-2.5F, 0.0F, -2.001F, 5, 7, 0, f);
    	Body_F.setRotationPointLM(0.0F, -3.5F, 0.0F);
    	Body_B = new Modchu_ModelRenderer(this, 18, 44);
    	Body_B.addPlate(-2.5F, 0.0F, 2.001F, 5, 7, 0, f);
    	Body_B.setRotationPointLM(0.0F, -3.5F, 0.0F);
    	Breast1 = new Modchu_ModelRenderer(this, 18, 52);
    	Breast1.addBoxLM(0.0F, -2.5F, 0.0F, 2, 5, 1, f);
    	Breast1.setRotationPointLM(0.0F, -2.5F, -2F);
    	Breast1.setRotateAngleZ(((float)Math.PI / 2F));
    	Breast1.setRotateAngleY(0.4363323F);
    	Breast2 = new Modchu_ModelRenderer(this, 10, 51);
    	Breast2.addBoxLM(0.0F, -2.5F, 0.0F, 2, 5, 2, f);
    	Breast2.setRotationPointLM(0.0F, -2.5F, -2F);
    	Breast2.setRotateAngleZ(((float)Math.PI / 2F));
    	Breast2.setRotateAngleY(0.567232F);
    	Breast3 = new Modchu_ModelRenderer(this, 10, 44);
    	Breast3.addBoxLM(0.0F, -2.5F, 0.0F, 2, 5, 2, f);
    	Breast3.setRotationPointLM(0.0F, -2.5F, -2F);
    	Breast3.setRotateAngleZ(((float)Math.PI / 2F));
    	Breast3.setRotateAngleY(((float)Math.PI * 2F / 9F));
    	Belt_R = new Modchu_ModelRenderer(this, 52, 10);
    	Belt_R.addPlate(0.0F, 0.0F, -3F, 6, 6, 5, f);
    	Belt_R.setRotationPointLM(-3F, 2.5F, 0.0F);
    	Belt_R.setRotateAngleZ(((float)Math.PI / 10F));
    	Belt_L = new Modchu_ModelRenderer(this, 58, 10);
    	Belt_L.addPlate(0.0F, 0.0F, -3F, 6, 6, 1, f);
    	Belt_L.setRotationPointLM(3F, 2.5F, 0.0F);
    	Belt_L.setRotateAngleZ(-((float)Math.PI / 10F));
    	Number = new Modchu_ModelRenderer(this, 16, 32);
    	Number.addPlate(0.0F, -4F, -4F, 8, 8, 1, f - 3.3F);
    	Number.setRotationPointLM(5.301F, 0.0F, 0.0F);
    	Negi1 = new Modchu_ModelRenderer(this, 60, 23);
    	Negi1.addBoxLM(-0.5F, -4F, -0.5F, 1, 8, 1, f);
    	Negi1.setRotationPointLM(0.0F, 7.0F, 0.0F);
    	Negi1.setRotateAngleX(((float)Math.PI / 2F));
    	Negi2 = new Modchu_ModelRenderer(this, 52, 16);
    	Negi2.addBoxLM(-0.5F, 0.0F, 0.0F, 1, 2, 1, f);
    	Negi2.setRotationPointLM(0.0F, 6.5F, -4F);
    	Negi2.setRotateAngleX(-2.094395F);
    	Negi3 = new Modchu_ModelRenderer(this, 52, 16);
    	Negi3.addBoxLM(-0.5F, 0.0F, 0.0F, 1, 2, 1, f);
    	Negi3.setRotationPointLM(0.0F, 6.5F, -4F);
    	Negi3.setRotateAngleX(-0.8726646F);
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
    	bipedHead.addChild(SideTailRoot_R);
    	bipedHead.addChild(SideTailRoot_L);
    	bipedHead.addChild(SideTailM_RU);
    	bipedHead.addChild(SideTailM_LU);
    	SideTailM_RU.addChild(SideTailM_RB);
    	SideTailM_LU.addChild(SideTailM_LB);
    	bipedHead.addChild(SideTailF_RU);
    	bipedHead.addChild(SideTailF_LU);
    	SideTailF_RU.addChild(SideTailF_RB);
    	SideTailF_LU.addChild(SideTailF_LB);
    	bipedHead.addChild(SideTailN_LU);
    	SideTailN_LU.addChild(SideTailN_LB);
    	bipedHead.addChild(SideTailR_R);
    	bipedHead.addChild(SideTailR_L);
    	bipedHead.addChild(Tail_T);
    	bipedHead.addChild(Tail_U);
    	Tail_U.addChild(Tail_B);
    	bipedHead.addChild(DropTail);
    	bipedHead.addChild(HairOrnamentM_R);
    	bipedHead.addChild(HairOrnamentM_L);
    	bipedHead.addChild(HairOrnamentF_R);
    	bipedHead.addChild(HairOrnamentF_L);
    	bipedHead.addChild(HairOrnamentN_L);
    	SideTailF_RU.addChild(Ribon1_R);
    	Ribon1_R.addChild(Ribon2_R);
    	Ribon1_R.addChild(Ribon3_R);
    	Ribon2_R.addChild(Ribon4_R);
    	Ribon3_R.addChild(Ribon5_R);
    	SideTailF_LU.addChild(Ribon1_L);
    	Ribon1_L.addChild(Ribon2_L);
    	Ribon1_L.addChild(Ribon3_L);
    	Ribon2_L.addChild(Ribon4_L);
    	Ribon3_L.addChild(Ribon5_L);
    	Tail_U.addChild(Ribon1_BU);
    	Ribon1_BU.addChild(Ribon2_BU);
    	Ribon1_BU.addChild(Ribon3_BU);
    	Ribon2_BU.addChild(Ribon4_BU);
    	Ribon3_BU.addChild(Ribon5_BU);
    	DropTail.addChild(Ribon1_BB);
    	Ribon1_BB.addChild(Ribon2_BB);
    	Ribon1_BB.addChild(Ribon3_BB);
    	Ribon2_BB.addChild(Ribon4_BB);
    	Ribon3_BB.addChild(Ribon5_BB);
    	bipedHead.addChild(Ribon1_T);
    	Ribon1_T.addChild(Ribon2_T);
    	Ribon1_T.addChild(Ribon3_T);
    	bipedHead.addChild(Roll1_R);
    	Roll1_R.addChild(Roll2_R);
    	Roll1_R.addChild(Roll3_R);
    	Roll1_R.addChild(Roll4_R);
    	bipedHead.addChild(Roll1_L);
    	Roll1_L.addChild(Roll2_L);
    	Roll1_L.addChild(Roll3_L);
    	Roll1_L.addChild(Roll4_L);
    	bipedHead.addChild(DumplingHari_L);
    	bipedHead.addChild(Headwear_F);
    	bipedHead.addChild(Headwear_B);
    	bipedHead.addChild(Headwear_R);
    	bipedHead.addChild(Headwear_L);
    	bipedHead.addChild(Shaggy_F);
    	bipedHead.addChild(shaggyB);
    	bipedHead.addChild(shaggyR);
    	bipedHead.addChild(shaggyL);
    	bipedHead.addChild(LongHair_F);
    	bipedHead.addChild(LongHair_B);
    	bipedHead.addChild(LongHair_R);
    	bipedHead.addChild(LongHair_L);
    	bipedHead.addChild(sensor1);
    	bipedHead.addChild(sensor2);
    	bipedHead.addChild(sensor3);
    	bipedHead.addChild(sensor4);
    	bipedHead.addChild(eyeR);
    	bipedHead.addChild(eyeL);
    	bipedHead.addChild(Cheek_R);
    	bipedHead.addChild(Cheek_L);
    	bipedBody.addChild(Body_F);
    	bipedBody.addChild(Body_B);
    	bipedBody.addChild(Breast1);
    	bipedBody.addChild(Breast2);
    	bipedBody.addChild(Breast3);
    	bipedBody.addChild(Belt_R);
    	bipedBody.addChild(Belt_L);
    	bipedLeftArm.addChild(Number);
    	bipedLeftArm.addChild(Negi1);
    	bipedLeftArm.addChild(Negi2);
    	bipedLeftArm.addChild(Negi3);
    	actionPartsInit(f, f1);
    }

    public void skirtFloatsInit(float f, float f1) {
    	if(!getCapsValueBoolean(caps_skirtFloats)) return;
    	//ふんわりスカート上
    	SkirtTop = new Modchu_ModelRenderer(this, 8, 18);
    	((Modchu_ModelRenderer) SkirtTop).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtTop.setRotationPoint(-4.0F, -4.0F, 4.0F);
    	if (Skirt != null) Skirt.addChild(SkirtTop);

    	//ふんわりスカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtFront.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtFront);

    	//ふんわりスカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 2, 24);
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
    	SkirtBack = new Modchu_ModelRenderer(this, 22, 24);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0);
    	SkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtBack);
    	if (Skirt != null) ((Modchu_ModelRenderer) Skirt).setVisible(false);
    }

    @Override
    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
    	super.setLivingAnimationsLM(entityliving, f, f1, f2);
    	if (getCapsValueBoolean(caps_isLookSuger)) {
    		Cheek_R.setVisible(true);
    		Cheek_L.setVisible(true);
    	} else {
    		Cheek_R.setVisible(false);
    		Cheek_L.setVisible(false);
    	}
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

    	SideTailR_R.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    	SideTailR_L.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    	DropTail.setRotateAngleX(0.1745292F - ((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    	sensor1.rotationPointY = -8.0F;
    	if (!getCapsValueBoolean(caps_skirtFloats)) Skirt.rotationPointY -= 2.0F;
    	Skirt.rotationPointZ = 0.0F;
    	if (getCapsValueBoolean(caps_getIsSneak)) {
    		Skirt.rotateAngleX += 0.3F;
    	}
    	if (((Modchu_ModelRenderer) bipedHead).getRotateAngleX() < 0.0F)
    	{
    		SideTailM_RU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    		SideTailM_LU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    		SideTailM_RB.setRotateAngleX(0.08726461F);
    		SideTailM_LB.setRotateAngleX(0.08726461F);
    		SideTailF_RU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    		SideTailF_LU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    		SideTailF_RB.setRotateAngleX(0.08726461F);
    		SideTailF_LB.setRotateAngleX(0.08726461F);
    		SideTailN_LU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    		SideTailN_LB.setRotateAngleX(0.0F);
    		Tail_U.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    		Tail_B.setRotateAngleX(0.0F + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
    	}
    	else
    	{
    		SideTailM_RU.setRotateAngleX(0.0F);
    		SideTailM_LU.setRotateAngleX(0.0F);
    		SideTailM_RB.setRotateAngleX((0.08726461F - ((Modchu_ModelRenderer) bipedHead).getRotateAngleX()) + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
    		SideTailM_LB.setRotateAngleX((0.08726461F - ((Modchu_ModelRenderer) bipedHead).getRotateAngleX()) + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
    		SideTailF_RU.setRotateAngleX(0.0F);
    		SideTailF_LU.setRotateAngleX(0.0F);
    		SideTailF_RB.setRotateAngleX((0.08726461F - ((Modchu_ModelRenderer) bipedHead).getRotateAngleX()) + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
    		SideTailF_LB.setRotateAngleX((0.08726461F - ((Modchu_ModelRenderer) bipedHead).getRotateAngleX()) + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
    		SideTailN_LU.setRotateAngleX(0.0F);
    		SideTailN_LB.setRotateAngleX((0.0F - ((Modchu_ModelRenderer) bipedHead).getRotateAngleX()) + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
    		Tail_U.setRotateAngleX(0.0F);
    		Tail_B.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX() + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
    	}
    	if (mod_Modchu_ModchuLib.LMM_EntityLittleMaid != null
    			&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entity)) {
    		if (getCapsValueBoolean(caps_getIsSneak)) {
    			Negi1.setVisible(true);
    			Negi2.setVisible(true);
    			Negi3.setVisible(true);
    		} else {
    			Negi1.setVisible(false);
    			Negi2.setVisible(false);
    			Negi3.setVisible(false);
    		}
    	}
    	float f6 = mh_sin(f2 * 0.09F) * 0.05F + 0.05F;
    	SideTailM_RU.rotateAngleZ = SideTailF_RU.rotateAngleZ =
    			SideTailN_LU.rotateAngleZ = SideTailR_R.rotateAngleZ = f6;
    	SideTailM_LU.rotateAngleZ = SideTailF_LU.rotateAngleZ =
    			SideTailN_LB.rotateAngleZ = SideTailR_L.rotateAngleZ = -f6;
    	SideTailM_LU.rotateAngleX = SideTailM_RU.rotateAngleX =
    			SideTailN_LU.rotateAngleX = SideTailN_LB.rotateAngleX =
    				SideTailF_RU.rotateAngleX = SideTailF_LU.rotateAngleX =
    					SideTailR_R.rotateAngleX = SideTailR_L.rotateAngleX = -bipedHead.rotateAngleX / 2.0F;
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s1 = {
    			"SideTailRoot_R", "SideTailRoot_L", "SideTailM_RU", "SideTailM_RB", "SideTailM_LU",
    			"SideTailM_LB", "SideTailF_RU", "SideTailF_RB", "SideTailF_LU", "SideTailF_LB",
    			"SideTailN_LU", "SideTailN_LB", "SideTailR_R", "SideTailR_L", "DumplingHari_L",
    			"HairOrnamentM_R", "HairOrnamentM_L", "HairOrnamentF_R", "HairOrnamentF_L", "HairOrnamentN_L"
    	};
    	String[] s2 = {
    			"SideT_R", "SideT_L", "SideTM_RU", "SideTM_RB", "SideTM_LU",
    			"SideTM_LB", "SideTF_RU", "SideTF_RB", "SideTF_LU", "SideTF_LB",
    			"SideTN_LU", "SideTN_LB", "SideTR_R", "SideTR_L", "D_Hari_L",
    			"HOM_R", "HOM_L", "HOF_R", "HOF_L", "HON_L"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void defaultPartsSettingAfter() {
    	//Cheek Default off
    	setGuiParts("Cheek", false);
    	//Negi Default off
    	setGuiParts("Negi", false);
    }
}