package net.minecraft.src;

public class MultiModel_Yukari extends MultiModel_Aug
{

    public Modchu_ModelRenderer Skirt_R;
    public Modchu_ModelRenderer Skirt_L;
    public Modchu_ModelRenderer Skirt_RF;
    public Modchu_ModelRenderer Skirt_RB;
    public Modchu_ModelRenderer Skirt_RR;
    public Modchu_ModelRenderer Skirt_RL;
    public Modchu_ModelRenderer Skirt_LF;
    public Modchu_ModelRenderer Skirt_LB;
    public Modchu_ModelRenderer Skirt_LR;
    public Modchu_ModelRenderer Skirt_LL;
    public Modchu_ModelRenderer Arm_RF;
    public Modchu_ModelRenderer Arm_RB;
    public Modchu_ModelRenderer Arm_RR;
    public Modchu_ModelRenderer Arm_RL;
    public Modchu_ModelRenderer Arm_LF;
    public Modchu_ModelRenderer Arm_LB;
    public Modchu_ModelRenderer Arm_LR;
    public Modchu_ModelRenderer Arm_LL;
    public Modchu_ModelRenderer Parka_1;
    public Modchu_ModelRenderer Parka_2;
    public Modchu_ModelRenderer Parka_F;
    public Modchu_ModelRenderer Parka_B;
    public Modchu_ModelRenderer Parka_R;
    public Modchu_ModelRenderer Parka_L;
    public Modchu_ModelRenderer RabbitEar_RB1;
    public Modchu_ModelRenderer RabbitEar_RB2;
    public Modchu_ModelRenderer RabbitEar_LB1;
    public Modchu_ModelRenderer RabbitEar_LB2;
    public Modchu_ModelRenderer RabbitEar_R1;
    public Modchu_ModelRenderer RabbitEar_R2;
    public Modchu_ModelRenderer RabbitEar_R3;
    public Modchu_ModelRenderer RabbitEar_R4;
    public Modchu_ModelRenderer RabbitEar_L1;
    public Modchu_ModelRenderer RabbitEar_L2;
    public Modchu_ModelRenderer RabbitEar_L3;
    public Modchu_ModelRenderer RabbitEar_L4;
    public Modchu_ModelRenderer HairOrnament_R;
    public Modchu_ModelRenderer HairOrnament_L;
    public Modchu_ModelRenderer PigTail_R1;
    public Modchu_ModelRenderer PigTail_R2;
    public Modchu_ModelRenderer PigTail_L1;
    public Modchu_ModelRenderer PigTail_L2;
    public Modchu_ModelRenderer Accessory_S1;
    public Modchu_ModelRenderer Accessory_S2;
    public Modchu_ModelRenderer Accessory_B1;
    public Modchu_ModelRenderer Accessory_B2;
    public Modchu_ModelRenderer Accessory_H;
    public Modchu_ModelRenderer Accessory_HRF1;
    public Modchu_ModelRenderer Accessory_HRF2;
    public Modchu_ModelRenderer Accessory_HRF3;
    public Modchu_ModelRenderer Accessory_HR1;
    public Modchu_ModelRenderer Accessory_HR2;
    public Modchu_ModelRenderer Accessory_HLF1;
    public Modchu_ModelRenderer Accessory_HLF2;
    public Modchu_ModelRenderer Accessory_HLF3;
    public Modchu_ModelRenderer Accessory_HL1;
    public Modchu_ModelRenderer Accessory_HL2;
    public Modchu_ModelRenderer Accessory_HB1;
    public Modchu_ModelRenderer Accessory_HB2;
    public Modchu_ModelRenderer ArmAccessory_RF;
    public Modchu_ModelRenderer ArmAccessory_RB;
    public Modchu_ModelRenderer ArmAccessory_RR;
    public Modchu_ModelRenderer ArmAccessory_RL;
    public Modchu_ModelRenderer ArmAccessory_R;
    public Modchu_ModelRenderer Belt_R;
    public Modchu_ModelRenderer Belt_L;
    public Modchu_ModelRenderer BeltAccessory_L;
    public Modchu_ModelRenderer Incom_1;
    public Modchu_ModelRenderer Incom_2;
    public Modchu_ModelRenderer Incom_3;
    public Modchu_ModelRenderer Shaggy_B1;
    public Modchu_ModelRenderer Shaggy_B2;
    public Modchu_ModelRenderer Shaggy_B3;
    public Modchu_ModelRenderer Shaggy_B4;
    public Modchu_ModelRenderer Shaggy_B5;
    public Modchu_ModelRenderer Shaggy_R1;
    public Modchu_ModelRenderer Shaggy_R2;
    public Modchu_ModelRenderer Shaggy_R3;
    public Modchu_ModelRenderer Shaggy_R4;
    public Modchu_ModelRenderer Shaggy_R5;
    public Modchu_ModelRenderer Shaggy_L1;
    public Modchu_ModelRenderer Shaggy_L2;
    public Modchu_ModelRenderer Shaggy_L3;
    public Modchu_ModelRenderer Shaggy_L4;
    public Modchu_ModelRenderer Shaggy_L5;
    public Modchu_ModelRenderer Cheek_R;
    public Modchu_ModelRenderer Cheek_L;
    public Modchu_ModelRenderer Head_F;
    public Modchu_ModelRenderer Body_B;
    public Modchu_ModelRenderer Breast;
    public Modchu_ModelRenderer Breast_C;
    public Modchu_ModelRenderer Breast_U;
    public Modchu_ModelRenderer Breast_B;
    public Modchu_ModelRenderer Breast_R;
    public Modchu_ModelRenderer Breast_L;
    public Modchu_ModelRenderer Breast_RU;
    public Modchu_ModelRenderer Breast_LU;
    public Modchu_ModelRenderer Breast_RB;
    public Modchu_ModelRenderer Breast_LB;

    public MultiModel_Yukari()
    {
    	this(0.0F);
    }

    public MultiModel_Yukari(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_Yukari(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_Yukari(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	textureWidth = 64;
    	textureHeight = 64;
    	f1 += 8F;
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	bipedHead.setRotationPoint(0.0F, 0.0F , 0.0F);
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
    	Skirt = new Modchu_ModelRenderer(this, 0, 20);
    	Skirt.addBox(-3F, -2F, -2F, 6, 2, 4, f + 0.15F);
    	Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedBody.addChild(Skirt);
    	SideTailR = new Modchu_ModelRenderer(this);
    	SideTailL = new Modchu_ModelRenderer(this);
    	sidetailUpperR = new Modchu_ModelRenderer(this);
    	sidetailUpperL = new Modchu_ModelRenderer(this);
    	Skirt_R = new Modchu_ModelRenderer(this, 0, 26);
    	Skirt_R.addBox(-1.69F, 0.19F, -2F, 3, 2, 4, f + 0.2F);
    	Skirt_R.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_L = new Modchu_ModelRenderer(this, 14, 26);
    	Skirt_L.addBox(-1.31F, 0.19F, -2F, 3, 2, 4, f + 0.2F);
    	Skirt_L.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_RF = new Modchu_ModelRenderer(this, 26, 44);
    	Skirt_RF.addPlate(-2.69F, 0.0F, -3F, 5, 3, 0, f - 0.798F);
    	Skirt_RF.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_RB = new Modchu_ModelRenderer(this, 37, 44);
    	Skirt_RB.addPlate(-2.69F, 0.0F, 3F, 5, 3, 4, f - 0.798F);
    	Skirt_RB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_RR = new Modchu_ModelRenderer(this, 20, 44);
    	Skirt_RR.addPlate(-2.69F, 0.0F, -3F, 6, 3, 5, f - 0.798F);
    	Skirt_RR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_RL = new Modchu_ModelRenderer(this, 31, 44);
    	Skirt_RL.addPlate(2.31F, 0.0F, -3F, 6, 3, 1, f - 0.798F);
    	Skirt_RL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_LF = new Modchu_ModelRenderer(this, 48, 44);
    	Skirt_LF.addPlate(-2.31F, 0.0F, -3F, 5, 3, 0, f - 0.798F);
    	Skirt_LF.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_LB = new Modchu_ModelRenderer(this, 59, 44);
    	Skirt_LB.addPlate(-2.31F, 0.0F, 3F, 5, 3, 4, f - 0.798F);
    	Skirt_LB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_LR = new Modchu_ModelRenderer(this, 54, 44);
    	Skirt_LR.addPlate(-1.31F, 0.0F, -3F, 6, 3, 5, f - 0.798F);
    	Skirt_LR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt_LL = new Modchu_ModelRenderer(this, 53, 44);
    	Skirt_LL.addPlate(2.69F, 0.0F, -3F, 6, 3, 1, f - 0.798F);
    	Skirt_LL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_RF = new Modchu_ModelRenderer(this, 32, 47);
    	Arm_RF.addPlate(-2F, 3.0F, -2F, 4, 3, 0, f - 0.999F);
    	Arm_RF.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_RB = new Modchu_ModelRenderer(this, 36, 47);
    	Arm_RB.addPlate(-2F, 3.0F, 2.0F, 4, 3, 4, f - 0.999F);
    	Arm_RB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_RR = new Modchu_ModelRenderer(this, 40, 47);
    	Arm_RR.addPlate(-2F, 3.0F, -2F, 4, 3, 5, f - 0.999F);
    	Arm_RR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_RL = new Modchu_ModelRenderer(this, 44, 47);
    	Arm_RL.addPlate(2.0F, 3.0F, -2F, 4, 3, 1, f - 0.999F);
    	Arm_RL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_LF = new Modchu_ModelRenderer(this, 48, 47);
    	Arm_LF.addPlate(-2F, 3.0F, -2F, 4, 3, 0, f - 0.999F);
    	Arm_LF.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_LB = new Modchu_ModelRenderer(this, 52, 47);
    	Arm_LB.addPlate(-2F, 3.0F, 2.0F, 4, 3, 4, f - 0.999F);
    	Arm_LB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_LR = new Modchu_ModelRenderer(this, 56, 47);
    	Arm_LR.addPlate(-2F, 3.0F, -2F, 4, 3, 5, f - 0.999F);
    	Arm_LR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Arm_LL = new Modchu_ModelRenderer(this, 60, 47);
    	Arm_LL.addPlate(2F, 3.0F, -2F, 4, 3, 1, f - 0.999F);
    	Arm_LL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Parka_1 = new Modchu_ModelRenderer(this, 13, 32);
    	Parka_1.addBox(-3.5F, 0.0F, 0.0F, 7, 6, 1, f - 0.5F);
    	Parka_1.setRotationPoint(0.0F, -3.0F, 2.0F);
    	Parka_1.setRotateAngleX(0.08726461F);
    	Parka_2 = new Modchu_ModelRenderer(this, 29, 32);
    	Parka_2.addBox(-3.5F, 0.0F, 0.0F, 7, 6, 1, f - 0.7F);
    	Parka_2.setRotationPoint(0.0F, -3.0F, 0.18F);
    	Parka_F = new Modchu_ModelRenderer(this, 33, 39);
    	Parka_F.addPlate(-5.5F, -2.5F, 0.0F, 11, 5, 0, f - 2.495F);
    	Parka_F.setRotationPoint(0.0F, 3.5F, -4.5F);
    	Parka_B = new Modchu_ModelRenderer(this, 53, 39);
    	Parka_B.addPlate(-5.5F, -2.5F, 0.0F, 11, 5, 4, f - 2.495F);
    	Parka_B.setRotationPoint(0.0F, 3.5F, 4.5F);
    	Parka_R = new Modchu_ModelRenderer(this, 24, 39);
    	Parka_R.addPlate(0.0F, -2.5F, -4.5F, 9, 5, 5, f - 2.495F);
    	Parka_R.setRotationPoint(-5.5F, 3.5F, 0.0F);
    	Parka_L = new Modchu_ModelRenderer(this, 44, 39);
    	Parka_L.addPlate(0.0F, -2.5F, -4.5F, 9, 5, 1, f - 2.495F);
    	Parka_L.setRotationPoint(5.5F, 3.5F, 0.0F);
    	RabbitEar_RB1 = new Modchu_ModelRenderer(this, 0, 44);
    	RabbitEar_RB1.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
    	RabbitEar_RB1.setRotationPoint(-2.5F, 3.0F, 1.0F);
    	RabbitEar_RB2 = new Modchu_ModelRenderer(this, 8, 44);
    	RabbitEar_RB2.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
    	RabbitEar_RB2.setRotationPoint(0.0F, 4.5F, 0.0F);
    	RabbitEar_LB1 = new Modchu_ModelRenderer(this, 0, 44);
    	RabbitEar_LB1.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
    	RabbitEar_LB1.setRotationPoint(2.5F, 3.0F, 1.0F);
    	RabbitEar_LB2 = new Modchu_ModelRenderer(this, 8, 44);
    	RabbitEar_LB2.addBox(-1.5F, -0.25F, -0.25F, 3, 5, 1, f - 0.75F);
    	RabbitEar_LB2.setRotationPoint(0.0F, 4.5F, 0.0F);
    	RabbitEar_R1 = new Modchu_ModelRenderer(this, 0, 32);
    	RabbitEar_R1.addBox(-2F, -1F, -1.5F, 2, 1, 3, f - 0.5F);
       	RabbitEar_R1.setRotationPoint(-2.3F, -8.0F, -1.5F);
    	RabbitEar_R1.setRotateAngleZ(0.08726461F);
    	RabbitEar_R2 = new Modchu_ModelRenderer(this, 5, 32);
    	RabbitEar_R2.addBox(-1F, 0.0F, -1.5F, 1, 1, 3, f - 0.5F);
    	RabbitEar_R2.setRotationPoint(-2F, -1.0F, 0.0F);
    	RabbitEar_R2.setRotateAngleZ(-((float)Math.PI / 4F));
    	RabbitEar_R3 = new Modchu_ModelRenderer(this, 0, 36);
    	RabbitEar_R3.addBox(0.0F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
    	RabbitEar_R3.setRotationPoint(-1F, 0.0F, 0.0F);
    	RabbitEar_R4 = new Modchu_ModelRenderer(this, 8, 36);
    	RabbitEar_R4.addBox(-1F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
    	RabbitEar_R4.setRotationPoint(1.0F, 5.0F, 0.0F);
    	RabbitEar_R4.setRotateAngleZ(0.1745292F);
    	RabbitEar_L1 = new Modchu_ModelRenderer(this, 0, 32);
    	RabbitEar_L1.mirror = true;
    	RabbitEar_L1.addBox(0.0F, -1F, -1.5F, 2, 1, 3, f - 0.5F);
    	RabbitEar_L1.setRotationPoint(2.3F, -8.0F, -1.5F);
    	RabbitEar_L1.setRotateAngleZ(-0.08726461F);
    	RabbitEar_L2 = new Modchu_ModelRenderer(this, 5, 32);
    	RabbitEar_L2.mirror = true;
    	RabbitEar_L2.addBox(0.0F, 0.0F, -1.5F, 1, 1, 3, f - 0.5F);
    	RabbitEar_L2.setRotationPoint(2.0F, -1.0F, 0.0F);
    	RabbitEar_L2.setRotateAngleZ(((float)Math.PI / 4F));
    	RabbitEar_L3 = new Modchu_ModelRenderer(this, 0, 36);
    	RabbitEar_L3.mirror = true;
    	RabbitEar_L3.addBox(-1F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
    	RabbitEar_L3.setRotationPoint(1.0F, 0.0F, 0.0F);
    	RabbitEar_L4 = new Modchu_ModelRenderer(this, 8, 36);
    	RabbitEar_L4.mirror = true;
    	RabbitEar_L4.addBox(0.0F, 0.0F, -1.5F, 1, 5, 3, f - 0.5F);
    	RabbitEar_L4.setRotationPoint(-1F, 5.0F, 0.0F);
    	RabbitEar_L4.setRotateAngleZ(-0.1745292F);
    	HairOrnament_R = new Modchu_ModelRenderer(this, 48, 32);
    	HairOrnament_R.addBox(-2F, 0.0F, -2F, 4, 3, 4, f - 1.1F);
    	HairOrnament_R.setRotationPoint(3.5F, -1.8F, -3.5F);
    	HairOrnament_L = new Modchu_ModelRenderer(this, 48, 32);
    	HairOrnament_L.addBox(-2F, 0.0F, -2F, 4, 3, 4, f - 1.1F);
    	HairOrnament_L.setRotationPoint(-3.5F, -1.8F, -3.5F);
    	PigTail_R1 = new Modchu_ModelRenderer(this, 60, 23);
    	PigTail_R1.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, f);
    	PigTail_R1.setRotationPoint(-3.5F, 0.0F, -3.5F);
    	PigTail_R2 = new Modchu_ModelRenderer(this, 60, 25);
    	PigTail_R2.addBox(-1F, 0.0F, -1F, 1, 2, 1, f);
    	PigTail_R2.setRotationPoint(0.5F, 1.0F, 0.5F);
    	PigTail_R2.setRotateAngleX(-0.1745292F);
    	PigTail_R2.setRotateAngleY(0.0F);
    	PigTail_R2.setRotateAngleZ(0.1745292F);
    	PigTail_L1 = new Modchu_ModelRenderer(this, 60, 23);
    	PigTail_L1.mirror = true;
    	PigTail_L1.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, f);
    	PigTail_L1.setRotationPoint(3.5F, 0.0F, -3.5F);
    	PigTail_L2 = new Modchu_ModelRenderer(this, 60, 25);
    	PigTail_L2.mirror = true;
    	PigTail_L2.addBox(0.0F, 0.0F, -1F, 1, 2, 1, f);
    	PigTail_L2.setRotationPoint(-0.5F, 1.0F, 0.5F);
    	PigTail_L2.setRotateAngleX(-0.1745292F);
    	PigTail_L2.setRotateAngleY(0.0F);
    	PigTail_L2.setRotateAngleZ(-0.1745292F);
    	Accessory_S1 = new Modchu_ModelRenderer(this, 32, 58);
    	Accessory_S1.addBox(-1.5F, -1.5F, -3F, 3, 3, 3, f - 1.0F);
    	Accessory_S1.setRotationPoint(1.8F, -6.0F, -2.3F);
    	Accessory_S2 = new Modchu_ModelRenderer(this, 0, 52);
    	Accessory_S2.addPlate(-2.5F, -2.5F, -3.8F, 5, 5, 0, f - 2.0F);
    	Accessory_S2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_B1 = new Modchu_ModelRenderer(this, 34, 51);
    	Accessory_B1.addBox(-2F, -2F, -3F, 4, 4, 3, f - 1.1F);
    	Accessory_B1.setRotationPoint(3F, -6.75F, -2.599F);
    	Accessory_B2 = new Modchu_ModelRenderer(this, 0, 52);
    	Accessory_B2.addPlate(-2.5F, -2.5F, -3.3F, 5, 5, 0, f - 1.6F);
    	Accessory_B2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_H = new Modchu_ModelRenderer(this, 44, 59);
    	Accessory_H.addBox(-3.5F, -1F, -0.5F, 7, 2, 3, f - 0.3F);
    	Accessory_H.setRotationPoint(0.0F, 1.5F, 0.0F);
    	Accessory_HRF1 = new Modchu_ModelRenderer(this, 34, 51);
    	Accessory_HRF1.addBox(-2F, -2F, -2F, 4, 4, 3, f - 1.0F);
    	Accessory_HRF1.setRotationPoint(-2.3F, 0.4F, -1.4F);
    	Accessory_HRF1.setRotateAngleZ(0.226888F);
    	Accessory_HRF2 = new Modchu_ModelRenderer(this, 0, 52);
    	Accessory_HRF2.addPlate(-2.5F, -2.5F, -2.3F, 5, 5, 0, f - 1.5F);
    	Accessory_HRF2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_HRF3 = new Modchu_ModelRenderer(this, 41, 58);
    	Accessory_HRF3.addBox(0.9F, -0.3F, -1.1F, 1, 1, 1, f - 0.1F);
    	Accessory_HRF3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_HRF3.setRotateAngleZ(0.08726461F);
    	Accessory_HR1 = new Modchu_ModelRenderer(this, 48, 51);
    	Accessory_HR1.addBox(-2.5F, -2.5F, -2F, 5, 5, 3, f - 1.25F);
    	Accessory_HR1.setRotationPoint(-2.7F, 0.0F, -0.65F);
    	Accessory_HR1.setRotateAngleY(((float)Math.PI / 2F));
    	Accessory_HR2 = new Modchu_ModelRenderer(this, 0, 52);
    	Accessory_HR2.addPlate(-2.5F, -2.5F, -1.8F, 5, 5, 0, f - 1.25F);
    	Accessory_HR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_HLF1 = new Modchu_ModelRenderer(this, 34, 51);
    	Accessory_HLF1.addBox(-2F, -2F, -2F, 4, 4, 3, f - 1.0F);
    	Accessory_HLF1.setRotationPoint(2.3F, 0.4F, -1.4F);
    	Accessory_HLF1.setRotateAngleZ(-0.226888F);
    	Accessory_HLF2 = new Modchu_ModelRenderer(this, 0, 52);
    	Accessory_HLF2.addPlate(-2.5F, -2.5F, -2.3F, 5, 5, 0, f - 1.5F);
    	Accessory_HLF2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_HLF3 = new Modchu_ModelRenderer(this, 41, 58);
    	Accessory_HLF3.addBox(-1.9F, -0.3F, -1.1F, 1, 1, 1, f - 0.1F);
    	Accessory_HLF3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_HLF3.setRotateAngleZ(-0.08726461F);
    	Accessory_HL1 = new Modchu_ModelRenderer(this, 48, 51);
    	Accessory_HL1.addBox(-2.5F, -2.5F, -2F, 5, 5, 3, f - 1.25F);
    	Accessory_HL1.setRotationPoint(2.7F, 0.0F, -0.65F);
    	Accessory_HL1.setRotateAngleY(-((float)Math.PI / 2F));
    	Accessory_HL2 = new Modchu_ModelRenderer(this, 0, 52);
    	Accessory_HL2.addPlate(-2.5F, -2.5F, -1.8F, 5, 5, 0, f - 1.25F);
    	Accessory_HL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Accessory_HB1 = new Modchu_ModelRenderer(this, 32, 58);
    	Accessory_HB1.addBox(-1.5F, -1.5F, -3F, 3, 3, 3, f - 0.85F);
    	Accessory_HB1.setRotationPoint(0.0F, 0.0F, 0.3F);
    	Accessory_HB1.setRotateAngleY((float)Math.PI);
    	Accessory_HB2 = new Modchu_ModelRenderer(this, 0, 52);
    	Accessory_HB2.addPlate(-2.5F, -2.5F, -3.8F, 5, 5, 0, f - 1.85F);
    	Accessory_HB2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	ArmAccessory_RF = new Modchu_ModelRenderer(this, 16, 47);
    	ArmAccessory_RF.addPlate(-2.0F, 0.0F, -2F, 4, 3, 0, f - 0.95F);
    	ArmAccessory_RF.setRotationPoint(0.0F, 5.0F, 0.0F);
    	ArmAccessory_RB = new Modchu_ModelRenderer(this, 20, 47);
    	ArmAccessory_RB.addPlate(-2.0F, 0.0F, 2.0F, 4, 3, 4, f - 0.95F);
    	ArmAccessory_RB.setRotationPoint(0.0F, 5.0F, 0.0F);
    	ArmAccessory_RR = new Modchu_ModelRenderer(this, 24, 47);
    	ArmAccessory_RR.addPlate(0.1F, 0.0F, -2F, 4, 3, 5, f - 0.95F);
    	ArmAccessory_RR.setRotationPoint(0.0F, 5.0F, 0.0F);
    	ArmAccessory_RL = new Modchu_ModelRenderer(this, 28, 47);
    	ArmAccessory_RL.addPlate(-0.1F, 0.0F, -2F, 4, 3, 1, f - 0.95F);
    	ArmAccessory_RL.setRotationPoint(0.0F, 5.0F, 0.0F);
    	ArmAccessory_R = new Modchu_ModelRenderer(this, 45, 36);
    	ArmAccessory_R.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 0, f - 0.95F);
    	ArmAccessory_R.setRotationPoint(-1.5F, 0.36F, -1.97F);
    	ArmAccessory_R.setRotateAngleY(0.01745292F);
    	Belt_R = new Modchu_ModelRenderer(this, 0, 57);
    	Belt_R.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1, f - 0.2F);
    	Belt_R.setRotationPoint(-0.3F, 0.35F, 0.0F);
    	Belt_R.setRotateAngleX(((float)Math.PI * 2F / 9F));
    	Belt_R.setRotateAngleY(-((float)Math.PI / 2F));
    	Belt_L = new Modchu_ModelRenderer(this, 12, 57);
    	Belt_L.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1, f - 0.2F);
    	Belt_L.setRotationPoint(0.3F, 0.35F, 0.0F);
    	Belt_L.setRotateAngleX(((float)Math.PI * 2F / 9F));
    	Belt_L.setRotateAngleY(((float)Math.PI / 2F));
    	BeltAccessory_L = new Modchu_ModelRenderer(this, 16, 50);
    	BeltAccessory_L.addPlate(-3.5F, -3.5F, -3.1F, 7, 7, 0, f - 3.1F);
    	BeltAccessory_L.setRotationPoint(2.301F, 2.2F, 0.0F);
    	BeltAccessory_L.setRotateAngleY(-((float)Math.PI / 2F));
    	Incom_1 = new Modchu_ModelRenderer(this, 24, 55);
    	Incom_1.addBox(-1.5F, -2F, -1.2F, 3, 4, 2, f - 0.75F);
    	Incom_1.setRotationPoint(4F, -1.75F, -2.1F);
    	Incom_1.setRotateAngleX(((float)Math.PI / 2F));
    	Incom_1.setRotateAngleY(-1.919821F);
    	Incom_1.setRotateAngleZ(-((float)Math.PI / 2F));
    	Incom_2 = new Modchu_ModelRenderer(this, 24, 53);
    	Incom_2.addBox(-1.7F, -0.5F, -0.5F, 2, 1, 1, f - 0.3F);
    	Incom_2.setRotationPoint(3.1F, -1.0F, -4F);
    	Incom_2.setRotateAngleZ(-0.2617939F);
    	Incom_3 = new Modchu_ModelRenderer(this, 30, 53);
    	Incom_3.addBox(-1.205F, -0.5F, -0.5F, 1, 1, 1, f - 0.295F);
    	Incom_3.setRotationPoint(0.0F, 0.0F, 0.0F);

    	//不要パーツ（削除するとエラー）
    	shaggyB = new Modchu_ModelRenderer(this, 32, 0);
    	shaggyB.addPlate(-3.5F, 0.0F, 0.0F, 7, 2, 4, f);
    	shaggyB.setRotationPoint(0.0F, -8.0F, 4F);
    	shaggyB.setRotateAngleX(0.1745292F);
    	//ここまで

		Shaggy_B1 = new Modchu_ModelRenderer(this, 32, 0);
		Shaggy_B1.addPlate(-3.5F, 0.0F, 0.0F, 7, 2, 4, f);
		Shaggy_B1.setRotationPoint(0.0F, -8.0F, 4.0F);
		Shaggy_B1.setRotateAngleX(10F / 180F * 3.141526F);
    	Shaggy_B2 = new Modchu_ModelRenderer(this, 32, 2);
    	Shaggy_B2.addPlate(-3.5F, 0.0F, 0.0F, 7, 2, 4, f);
    	Shaggy_B2.setRotationPoint(0.0F, -6.0F, 4F);
    	Shaggy_B2.setRotateAngleX(0.1745292F);
    	Shaggy_B3 = new Modchu_ModelRenderer(this, 32, 4);
    	Shaggy_B3.addPlate(-3.5F, 0.0F, 0.0F, 7, 2, 4, f);
    	Shaggy_B3.setRotationPoint(0.0F, -4.0F, 4F);
    	Shaggy_B3.setRotateAngleX(0.1745292F);
    	Shaggy_B4 = new Modchu_ModelRenderer(this, 32, 6);
    	Shaggy_B4.addPlate(-4F, 0.0F, 0.0F, 8, 1, 4, f);
    	Shaggy_B4.setRotationPoint(0.0F, -2.0F, 4F);
    	Shaggy_B4.setRotateAngleX(0.2617939F);
    	Shaggy_B5 = new Modchu_ModelRenderer(this, 32, 7);
    	Shaggy_B5.addPlate(-4F, 0.0F, 0.0F, 8, 1, 4, f);
    	Shaggy_B5.setRotationPoint(0.0F, -1.0F, 4F);
    	Shaggy_B5.setRotateAngleX(0.2617939F);

    	//不要パーツ（削除するとエラー）
    	shaggyR = new Modchu_ModelRenderer(this, 40, 0);
    	shaggyR.addPlate(0.0F, 0.0F, -4F, 8, 2, 5, f);
    	shaggyR.setRotationPoint(-4F, -8.0F, 0.0F);
    	shaggyR.setRotateAngleZ(0.1745292F);
    	//ここまで

		Shaggy_R1 = new Modchu_ModelRenderer(this, 40, 0);
		Shaggy_R1.addPlate(0.0F, 0.0F, -4.0F, 8, 2, 5, f);
		Shaggy_R1.setRotationPoint(-4.0F, -8.0F, 0.0F);
		Shaggy_R1.setRotateAngleZ(10F / 180F * 3.141526F);
    	Shaggy_R2 = new Modchu_ModelRenderer(this, 40, 2);
    	Shaggy_R2.addPlate(0.0F, 0.0F, -4F, 8, 2, 5, f);
    	Shaggy_R2.setRotationPoint(-4F, -6.0F, 0.0F);
    	Shaggy_R2.setRotateAngleZ(0.1745292F);
    	Shaggy_R3 = new Modchu_ModelRenderer(this, 40, 4);
    	Shaggy_R3.addPlate(0.0F, 0.0F, -4F, 8, 2, 5, f);
    	Shaggy_R3.setRotationPoint(-4F, -4.0F, 0.0F);
    	Shaggy_R3.setRotateAngleZ(0.1745292F);
    	Shaggy_R4 = new Modchu_ModelRenderer(this, 40, 6);
    	Shaggy_R4.addPlate(0.0F, 0.0F, -4F, 8, 1, 5, f);
    	Shaggy_R4.setRotationPoint(-4F, -2.0F, 0.0F);
    	Shaggy_R4.setRotateAngleZ(0.2617939F);
    	Shaggy_R5 = new Modchu_ModelRenderer(this, 40, 7);
    	Shaggy_R5.addPlate(0.0F, 0.0F, -4F, 8, 1, 5, f);
    	Shaggy_R5.setRotationPoint(-4F, -1.0F, 0.0F);
    	Shaggy_R5.setRotateAngleZ(0.2617939F);

    	//不要パーツ（削除するとエラー）
    	shaggyL = new Modchu_ModelRenderer(this, 24, 0);
    	shaggyL.addPlate(0.0F, 0.0F, -4F, 8, 2, 1, f);
    	shaggyL.setRotationPoint(4F, -8.0F, 0.0F);
    	shaggyL.setRotateAngleZ(-0.1745292F);
    	//ここまで

		Shaggy_L1 = new Modchu_ModelRenderer(this, 24, 0);
		Shaggy_L1.addPlate(0.0F, 0.0F, -4.0F, 8, 2, 1, f);
		Shaggy_L1.setRotationPoint(4.0F, -8.0F, 0.0F);
		Shaggy_L1.setRotateAngleZ(-10F / 180F * 3.141526F);
    	Shaggy_L2 = new Modchu_ModelRenderer(this, 24, 2);
    	Shaggy_L2.addPlate(0.0F, 0.0F, -4F, 8, 2, 1, f);
    	Shaggy_L2.setRotationPoint(4F, -6.0F, 0.0F);
    	Shaggy_L2.setRotateAngleZ(-0.1745292F);
    	Shaggy_L3 = new Modchu_ModelRenderer(this, 24, 4);
    	Shaggy_L3.addPlate(0.0F, 0.0F, -4F, 8, 2, 1, f);
    	Shaggy_L3.setRotationPoint(4F, -4.0F, 0.0F);
    	Shaggy_L3.setRotateAngleZ(-0.1745292F);
    	Shaggy_L4 = new Modchu_ModelRenderer(this, 24, 6);
    	Shaggy_L4.addPlate(0.0F, 0.0F, -4F, 8, 1, 1, f);
    	Shaggy_L4.setRotationPoint(4F, -2.0F, 0.0F);
    	Shaggy_L4.setRotateAngleZ(-0.2617939F);
    	Shaggy_L5 = new Modchu_ModelRenderer(this, 24, 7);
    	Shaggy_L5.addPlate(0.0F, 0.0F, -4F, 8, 1, 1, f);
    	Shaggy_L5.setRotationPoint(4F, -1.0F, 0.0F);
    	Shaggy_L5.setRotateAngleZ(-0.2617939F);
    	sensor1 = new Modchu_ModelRenderer(this, 0, 0);
    	sensor1.addPlate(-8F, -4F, 0.0F, 8, 4, 0, f);
    	sensor1.setRotationPoint(0.0F, -8.0F, 0.0F);
    	sensor2 = new Modchu_ModelRenderer(this, 0, 4);
    	sensor2.addPlate(0.0F, -4F, 0.0F, 8, 4, 0, f);
    	sensor2.setRotationPoint(0.0F, -8.0F, 0.0F);
    	sensor3 = new Modchu_ModelRenderer(this, 8, 16);
    	sensor3.addPlate(0.0F, -4F, -0F, 8, 4, 1, f);
    	sensor3.setRotationPoint(0.0F, -8.0F, 0.0F);
    	sensor4 = new Modchu_ModelRenderer(this, 0, 16);
    	sensor4.addPlate(0.0F, -4F, -8F, 8, 4, 1, f);
    	sensor4.setRotationPoint(0.0F, -8.0F, 0.0F);
    	eyeR = new Modchu_ModelRenderer(this, 42, 19);
    	eyeR.addPlate(-4F, -5F, -4.001F, 4, 4, 0, f);
    	eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	eyeL = new Modchu_ModelRenderer(this, 46, 19);
    	eyeL.addPlate(0.0F, -5F, -4.001F, 4, 4, 0, f);
    	eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Cheek_R = new Modchu_ModelRenderer(this, 32, 8);
    	Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
    	Cheek_R.setRotationPoint(0.0F, 1.0F, 0.0F);
    	Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
    	Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
    	Cheek_L.setRotationPoint(0.0F, 1.0F, 0.0F);
    	Head_F = new Modchu_ModelRenderer(this, 16, 16);
    	Head_F.addPlate(-4F, -4F, -3F, 8, 8, 0, f - 3F);
    	Head_F.setRotationPoint(3.25F, -5.25F, -4.002F);
    	Body_B = new Modchu_ModelRenderer(this, 24, 16);
    	Body_B.addPlate(-4F, -4F, 3F, 8, 8, 4, f - 3F);
    	Body_B.setRotationPoint(0.0F, 0.0F, 2.001F);
    	Breast = new Modchu_ModelRenderer(this, 56, 16);
    	Breast.addBox(0.0F, -2.5F, 0.0F, 2, 5, 2, f);
    	Breast.setRotationPoint(0.0F, -3.0F, -2F);
    	Breast.setRotateAngleZ(((float)Math.PI / 2F));
    	Breast.setRotateAngleY(((float)Math.PI * 2F / 9F));
    	Breast_C = new Modchu_ModelRenderer(this, 53, 16);
    	Breast_C.addPlate(-2F, 0.0F, 0.0F, 4, 1, 0);
    	Breast_C.setRotationPoint(0.0F, -1.5F, -2.25F);
    	Breast_U = new Modchu_ModelRenderer(this, 53, 15);
    	Breast_U.addPlate(-2F, -1F, 0.0F, 4, 1, 0);
    	Breast_U.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Breast_U.setRotateAngleX(-0.2617939F);
    	Breast_B = new Modchu_ModelRenderer(this, 53, 17);
    	Breast_B.addPlate(-2F, 0.0F, 0.0F, 4, 1, 0);
    	Breast_B.setRotationPoint(0.0F, 1.0F, 0.0F);
    	Breast_B.setRotateAngleX(0.2617939F);
    	Breast_R = new Modchu_ModelRenderer(this, 52, 16);
    	Breast_R.addPlate(-1F, -0.5F, 0.0F, 1, 1, 0);
    	Breast_R.setRotationPoint(-2F, 0.5F, 0.0F);
    	Breast_R.setRotateAngleY(0.2617939F);
    	Breast_RU = new Modchu_ModelRenderer(this, 52, 15);
    	Breast_RU.addPlate(-1F, -1F, 0.0F, 1, 1, 0);
    	Breast_RU.setRotationPoint(0.0F, -0.5F, 0.0F);
    	Breast_RU.setRotateAngleX(-0.2617939F);
    	Breast_RB = new Modchu_ModelRenderer(this, 52, 17);
    	Breast_RB.addPlate(-1F, 0.0F, 0.0F, 1, 1, 0);
    	Breast_RB.setRotationPoint(0.0F, 0.5F, 0.0F);
    	Breast_RB.setRotateAngleX(0.2617939F);
    	Breast_L = new Modchu_ModelRenderer(this, 57, 16);
    	Breast_L.addPlate(0.0F, -0.5F, 0.0F, 1, 1, 0);
    	Breast_L.setRotationPoint(2.0F, 0.5F, 0.0F);
    	Breast_L.setRotateAngleY(-0.2617939F);
    	Breast_LU = new Modchu_ModelRenderer(this, 57, 15);
    	Breast_LU.addPlate(0.0F, -1F, 0.0F, 1, 1, 0);
    	Breast_LU.setRotationPoint(0.0F, -0.5F, 0.0F);
    	Breast_LU.setRotateAngleX(-0.2617939F);
    	Breast_LB = new Modchu_ModelRenderer(this, 57, 17);
    	Breast_LB.addPlate(0.0F, 0.0F, 0.0F, 1, 1, 0);
    	Breast_LB.setRotationPoint(0.0F, 0.5F, 0.0F);
    	Breast_LB.setRotateAngleX(0.2617939F);
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
    	bipedRightLeg.addChild(Skirt_R);
    	bipedLeftLeg.addChild(Skirt_L);
    	Skirt_R.addChild(Skirt_RF);
    	Skirt_R.addChild(Skirt_RB);
    	Skirt_R.addChild(Skirt_RR);
    	Skirt_R.addChild(Skirt_RL);
    	Skirt_L.addChild(Skirt_LF);
    	Skirt_L.addChild(Skirt_LB);
    	Skirt_L.addChild(Skirt_LR);
    	Skirt_L.addChild(Skirt_LL);
    	bipedRightArm.addChild(Arm_RF);
    	bipedRightArm.addChild(Arm_RB);
    	bipedRightArm.addChild(Arm_RR);
    	bipedRightArm.addChild(Arm_RL);
    	bipedLeftArm.addChild(Arm_LF);
    	bipedLeftArm.addChild(Arm_LB);
    	bipedLeftArm.addChild(Arm_LR);
    	bipedLeftArm.addChild(Arm_LL);
    	bipedBody.addChild(Parka_1);
    	Parka_1.addChild(Parka_2);
    	Parka_1.addChild(RabbitEar_RB1);
    	RabbitEar_RB1.addChild(RabbitEar_RB2);
    	Parka_1.addChild(RabbitEar_LB1);
    	RabbitEar_LB1.addChild(RabbitEar_LB2);
    	bipedBody.addChild(Parka_F);
    	bipedBody.addChild(Parka_B);
    	bipedBody.addChild(Parka_R);
    	bipedBody.addChild(Parka_L);
    	bipedHead.addChild(RabbitEar_R1);
    	RabbitEar_R1.addChild(RabbitEar_R2);
    	RabbitEar_R2.addChild(RabbitEar_R3);
    	RabbitEar_R3.addChild(RabbitEar_R4);
    	bipedHead.addChild(RabbitEar_L1);
    	RabbitEar_L1.addChild(RabbitEar_L2);
    	RabbitEar_L2.addChild(RabbitEar_L3);
    	RabbitEar_L3.addChild(RabbitEar_L4);
    	bipedHead.addChild(HairOrnament_R);
    	bipedHead.addChild(HairOrnament_L);
    	bipedHead.addChild(PigTail_R1);
    	PigTail_R1.addChild(PigTail_R2);
    	bipedHead.addChild(PigTail_L1);
    	PigTail_L1.addChild(PigTail_L2);
    	bipedHead.addChild(Accessory_S1);
    	Accessory_S1.addChild(Accessory_S2);
    	bipedHead.addChild(Accessory_B1);
    	Accessory_B1.addChild(Accessory_B2);
    	bipedBody.addChild(Accessory_H);
    	Accessory_H.addChild(Accessory_HRF1);
    	Accessory_HRF1.addChild(Accessory_HRF2);
    	Accessory_HRF1.addChild(Accessory_HRF3);
    	Accessory_H.addChild(Accessory_HR1);
    	Accessory_HR1.addChild(Accessory_HR2);
    	Accessory_H.addChild(Accessory_HLF1);
    	Accessory_HLF1.addChild(Accessory_HLF2);
    	Accessory_HLF1.addChild(Accessory_HLF3);
    	Accessory_H.addChild(Accessory_HL1);
    	Accessory_HL1.addChild(Accessory_HL2);
    	Accessory_H.addChild(Accessory_HB1);
    	Accessory_HB1.addChild(Accessory_HB2);
    	Accessory_H.addChild(Belt_R);
    	Accessory_H.addChild(Belt_L);
    	Belt_L.addChild(BeltAccessory_L);
    	bipedRightArm.addChild(ArmAccessory_RF);
    	bipedRightArm.addChild(ArmAccessory_RB);
    	bipedRightArm.addChild(ArmAccessory_RR);
    	bipedRightArm.addChild(ArmAccessory_RL);
    	ArmAccessory_RF.addChild(ArmAccessory_R);
    	bipedHead.addChild(Incom_1);
    	bipedHead.addChild(Incom_2);
    	Incom_2.addChild(Incom_3);
    	//bipedHead.addChild(shaggyB);
    	bipedHead.addChild(Shaggy_B1);
    	bipedHead.addChild(Shaggy_B2);
    	bipedHead.addChild(Shaggy_B3);
    	bipedHead.addChild(Shaggy_B4);
    	bipedHead.addChild(Shaggy_B5);
    	//bipedHead.addChild(shaggyR);
    	bipedHead.addChild(Shaggy_R1);
    	bipedHead.addChild(Shaggy_R2);
    	bipedHead.addChild(Shaggy_R3);
    	bipedHead.addChild(Shaggy_R4);
    	bipedHead.addChild(Shaggy_R5);
    	//bipedHead.addChild(shaggyL);
    	bipedHead.addChild(Shaggy_L1);
    	bipedHead.addChild(Shaggy_L2);
    	bipedHead.addChild(Shaggy_L3);
    	bipedHead.addChild(Shaggy_L4);
    	bipedHead.addChild(Shaggy_L5);
    	bipedHead.addChild(sensor1);
    	bipedHead.addChild(sensor2);
    	bipedHead.addChild(sensor3);
    	bipedHead.addChild(sensor4);
    	bipedHead.addChild(eyeR);
    	bipedHead.addChild(eyeL);
    	bipedHead.addChild(Cheek_R);
    	bipedHead.addChild(Cheek_L);
    	bipedHead.addChild(Head_F);
    	bipedBody.addChild(Body_B);
    	bipedBody.addChild(Breast);
    	bipedBody.addChild(Breast_C);
    	Breast_C.addChild(Breast_U);
    	Breast_C.addChild(Breast_B);
    	Breast_C.addChild(Breast_R);
    	Breast_R.addChild(Breast_RU);
    	Breast_R.addChild(Breast_RB);
    	Breast_C.addChild(Breast_L);
    	Breast_L.addChild(Breast_LU);
    	Breast_L.addChild(Breast_LB);
    	actionPartsInit(f, f1);
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
    	super.setLivingAnimationsLM(entityliving, f, f1, f2);
    	float f3 = (float)entityliving.ticksExisted + f2 + getCapsValueFloat(caps_entityIdFactor);
    	if (getCapsValueBoolean(caps_isLookSuger)) {
    		setCapsValue(caps_visible, Cheek_R, true);
    		setCapsValue(caps_visible, Cheek_L, true);
    		RabbitEar_R3.rotateAngleZ = mh_sin(f3 * 0.09F) * 0.09F + 0.87F;
    		RabbitEar_L3.rotateAngleZ = -(mh_sin(f3 * 0.09F) * 0.09F + 0.87F);
    	} else {
    		setCapsValue(caps_visible, Cheek_R, false);
    		setCapsValue(caps_visible, Cheek_L, false);
    		RabbitEar_R3.rotateAngleZ = ((float)Math.PI / 4F);
    		RabbitEar_L3.rotateAngleZ = -((float)Math.PI / 4F);
    	}
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Skirt.rotationPointY -= 2.0F;
    	Skirt.rotationPointZ = 0.0F;
    	if (getCapsValueBoolean(caps_getIsSneak)) {
    		Skirt.rotationPointZ = -0.3F;
    		Skirt.rotateAngleX += 0.3F;
    	}

    	if (getCapsValueBoolean(caps_getIsRiding))
    	{
    		RabbitEar_RB1.setRotateAngleX(0.08726461F);
    		RabbitEar_LB1.setRotateAngleX(0.08726461F);
    		RabbitEar_RB2.setRotateAngleX(0.6108523F);
    		RabbitEar_LB2.setRotateAngleX(0.6108523F);
    	}
    	else
    	{
    		RabbitEar_RB1.setRotateAngleX(0.0F);
    		RabbitEar_LB1.setRotateAngleX(0.0F);
    		RabbitEar_RB2.setRotateAngleX(0.08726461F);
    		RabbitEar_LB2.setRotateAngleX(0.08726461F);
    	}
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s1 = {
    			"RabbitEar_RB1", "RabbitEar_RB2", "RabbitEar_R1", "RabbitEar_R2", "RabbitEar_R3",
    			"RabbitEar_R4", "RabbitEar_LB1", "RabbitEar_LB2", "RabbitEar_L1", "RabbitEar_L2",
    			"RabbitEar_L3", "RabbitEar_L4", "HairOrnament_R", "HairOrnament_L", "Accessory_S1",
    			"Accessory_S2", "Accessory_B1", "Accessory_B2", "Accessory_H", "Accessory_HRF1",
    			"Accessory_HRF2", "Accessory_HRF3", "Accessory_HR1", "Accessory_HR2", "Accessory_HLF1",
    			"Accessory_HLF2", "Accessory_HLF3", "Accessory_HL1", "Accessory_HL2", "Accessory_HB1",
    			"Accessory_HB2", "ArmAccessory_RF", "ArmAccessory_RB", "ArmAccessory_RR", "ArmAccessory_RL",
    			"ArmAccessory_R", "BeltAccessory_L"
    	};
    	String[] s2 = {
    			"RabbitE_RB1", "RabbitE_RB2", "RabbitE_R1", "RabbitE_R2", "RabbitE_R3",
    			"RabbitE_R4", "RabbitE_LB1", "RabbitE_LB2", "RabbitE_L1", "RabbitE_L2",
    			"RabbitE_L3", "RabbitE_L4", "HairO_R", "HairO_L", "Ac_S1",
    			"Ac_S2", "Ac_B1", "Ac_B2", "Ac_H", "Ac_HRF1",
    			"Ac_HRF2", "Ac_HRF3", "Ac_HR1", "Ac_HR2", "Ac_HLF1",
    			"Ac_HLF2", "Ac_HLF3", "Ac_HL1", "Ac_HL2", "Ac_HB1",
    			"Ac_HB2", "ArmAc_RF", "ArmAc_RB", "ArmAc_RR", "ArmAc_RL",
    			"ArmAc_R", "BeltAc_L"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void defaultPartsSettingAfter() {
    	//Cheek Default off
    	setGuiParts("Cheek", false);
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
    	super.actionInit1();
    	((Modchu_ModelRenderer) bipedRightLeg).removeChild(Skirt_R);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arm_RF);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arm_RB);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arm_RR);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arm_RL);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(ArmAccessory_RF);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(ArmAccessory_RB);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(ArmAccessory_RR);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(ArmAccessory_RL);
    	((Modchu_ModelRenderer) bipedLeftLeg).removeChild(Skirt_L);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arm_LF);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arm_LB);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arm_LR);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arm_LL);
    	rightLeg.addChild(Skirt_R);
    	rightArm2.addChild(Arm_RF);
    	rightArm2.addChild(Arm_RB);
    	rightArm2.addChild(Arm_RR);
    	rightArm2.addChild(Arm_RL);
    	rightArm2.addChild(ArmAccessory_RF);
    	rightArm2.addChild(ArmAccessory_RB);
    	rightArm2.addChild(ArmAccessory_RR);
    	rightArm2.addChild(ArmAccessory_RL);
    	leftLeg.addChild(Skirt_L);
    	leftArm2.addChild(Arm_LF);
    	leftArm2.addChild(Arm_LB);
    	leftArm2.addChild(Arm_LR);
    	leftArm2.addChild(Arm_LL);
    	Arm_RF.rotationPointY =
    	Arm_RB.rotationPointY =
    	Arm_RR.rotationPointY =
    	Arm_RL.rotationPointY = -4.0F;
    	Arm_LF.rotationPointY =
    	Arm_LB.rotationPointY =
    	Arm_LR.rotationPointY =
    	Arm_LL.rotationPointY = -4.0F;
    	ArmAccessory_RF.rotationPointY =
    			ArmAccessory_RB.rotationPointY =
    					ArmAccessory_RR.rotationPointY =
    							ArmAccessory_RL.rotationPointY = 0.5F;
    	ArmAccessory_R.rotationPointY = 0.86F;
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	((Modchu_ModelRenderer) rightLeg).removeChild(Skirt_R);
    	((Modchu_ModelRenderer) rightArm2).removeChild(Arm_RF);
    	((Modchu_ModelRenderer) rightArm2).removeChild(Arm_RB);
    	((Modchu_ModelRenderer) rightArm2).removeChild(Arm_RR);
    	((Modchu_ModelRenderer) rightArm2).removeChild(Arm_RL);
    	((Modchu_ModelRenderer) rightArm2).removeChild(ArmAccessory_RF);
    	((Modchu_ModelRenderer) rightArm2).removeChild(ArmAccessory_RB);
    	((Modchu_ModelRenderer) rightArm2).removeChild(ArmAccessory_RR);
    	((Modchu_ModelRenderer) rightArm2).removeChild(ArmAccessory_RL);
    	((Modchu_ModelRenderer) leftLeg).removeChild(Skirt_L);
    	((Modchu_ModelRenderer) leftArm2).removeChild(Arm_LF);
    	((Modchu_ModelRenderer) leftArm2).removeChild(Arm_LB);
    	((Modchu_ModelRenderer) leftArm2).removeChild(Arm_LR);
    	((Modchu_ModelRenderer) leftArm2).removeChild(Arm_LL);
    	bipedRightLeg.addChild(Skirt_R);
    	bipedRightArm.addChild(Arm_RF);
    	bipedRightArm.addChild(Arm_RB);
    	bipedRightArm.addChild(Arm_RR);
    	bipedRightArm.addChild(Arm_RL);
    	bipedRightArm.addChild(ArmAccessory_RF);
    	bipedRightArm.addChild(ArmAccessory_RB);
    	bipedRightArm.addChild(ArmAccessory_RR);
    	bipedRightArm.addChild(ArmAccessory_RL);
    	bipedLeftLeg.addChild(Skirt_L);
    	bipedLeftArm.addChild(Arm_LF);
    	bipedLeftArm.addChild(Arm_LB);
    	bipedLeftArm.addChild(Arm_LR);
    	bipedLeftArm.addChild(Arm_LL);
    	Arm_RF.rotationPointY =
    	Arm_RB.rotationPointY =
    	Arm_RR.rotationPointY =
    	Arm_RL.rotationPointY = 0.0F;
    	Arm_LF.rotationPointY =
    	Arm_LB.rotationPointY =
    	Arm_LR.rotationPointY =
    	Arm_LL.rotationPointY = 0.0F;
    	ArmAccessory_RF.rotationPointY =
    			ArmAccessory_RB.rotationPointY =
    					ArmAccessory_RR.rotationPointY =
    							ArmAccessory_RL.rotationPointY = 0.0F;
    	ArmAccessory_R.rotationPointY = 0.36F;
    }

    @Override
    public void setArmorBipedHeadShowModel(boolean b) {
    	bipedHead.isHidden = !b;
    	super.setArmorBipedHeadShowModel(b);
    	((Modchu_ModelRenderer) RabbitEar_R1).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_R2).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_R3).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_R4).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_L1).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_L2).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_L3).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_L4).setVisible(b);
    	((Modchu_ModelRenderer) HairOrnament_R).setVisible(b);
    	((Modchu_ModelRenderer) HairOrnament_L).setVisible(b);
    	((Modchu_ModelRenderer) PigTail_R1).setVisible(b);
    	((Modchu_ModelRenderer) PigTail_R2).setVisible(b);
    	((Modchu_ModelRenderer) PigTail_L1).setVisible(b);
    	((Modchu_ModelRenderer) PigTail_L2).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_S1).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_S2).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_B1).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_B2).setVisible(b);
    	((Modchu_ModelRenderer) Incom_1).setVisible(b);
    	((Modchu_ModelRenderer) Incom_2).setVisible(b);
    	((Modchu_ModelRenderer) Incom_3).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_B1).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_B2).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_B3).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_B4).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_B5).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_R1).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_R2).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_R3).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_R4).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_R5).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_L1).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_L2).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_L3).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_L4).setVisible(b);
    	((Modchu_ModelRenderer) Shaggy_L5).setVisible(b);
    	((Modchu_ModelRenderer) sensor1).setVisible(b);
    	((Modchu_ModelRenderer) sensor2).setVisible(b);
    	((Modchu_ModelRenderer) sensor3).setVisible(b);
    	((Modchu_ModelRenderer) sensor4).setVisible(b);
    	((Modchu_ModelRenderer) eyeR).setVisible(b);
    	((Modchu_ModelRenderer) eyeL).setVisible(b);
    	((Modchu_ModelRenderer) Cheek_R).setVisible(b);
    	((Modchu_ModelRenderer) Cheek_L).setVisible(b);
    	((Modchu_ModelRenderer) Head_F).setVisible(b);
    }

    @Override
    public void setArmorBipedBodyShowModel(boolean b) {
    	super.setArmorBipedBodyShowModel(b);
    	((Modchu_ModelRenderer) Arm_RF).setVisible(b);
    	((Modchu_ModelRenderer) Arm_RB).setVisible(b);
    	((Modchu_ModelRenderer) Arm_RR).setVisible(b);
    	((Modchu_ModelRenderer) Arm_RL).setVisible(b);
    	((Modchu_ModelRenderer) Arm_LF).setVisible(b);
    	((Modchu_ModelRenderer) Arm_LB).setVisible(b);
    	((Modchu_ModelRenderer) Arm_LR).setVisible(b);
    	((Modchu_ModelRenderer) Arm_LL).setVisible(b);
    	((Modchu_ModelRenderer) Parka_1).setVisible(b);
    	((Modchu_ModelRenderer) Parka_2).setVisible(b);
    	((Modchu_ModelRenderer) Parka_F).setVisible(b);
    	((Modchu_ModelRenderer) Parka_B).setVisible(b);
    	((Modchu_ModelRenderer) Parka_R).setVisible(b);
    	((Modchu_ModelRenderer) Parka_L).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_RB1).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_RB2).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_LB1).setVisible(b);
    	((Modchu_ModelRenderer) RabbitEar_LB2).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_H).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HRF1).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HRF2).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HRF3).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HR1).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HR2).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HLF1).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HLF2).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HLF3).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HL1).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HL2).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HB1).setVisible(b);
    	((Modchu_ModelRenderer) Accessory_HB2).setVisible(b);
    	((Modchu_ModelRenderer) ArmAccessory_RF).setVisible(b);
    	((Modchu_ModelRenderer) ArmAccessory_RB).setVisible(b);
    	((Modchu_ModelRenderer) ArmAccessory_RR).setVisible(b);
    	((Modchu_ModelRenderer) ArmAccessory_RL).setVisible(b);
    	((Modchu_ModelRenderer) ArmAccessory_R).setVisible(b);
    	((Modchu_ModelRenderer) Belt_R).setVisible(b);
    	((Modchu_ModelRenderer) Belt_L).setVisible(b);
    	((Modchu_ModelRenderer) BeltAccessory_L).setVisible(b);
    	((Modchu_ModelRenderer) Body_B).setVisible(b);
    	((Modchu_ModelRenderer) Breast).setVisible(b);
    	((Modchu_ModelRenderer) Breast_C).setVisible(b);
    	((Modchu_ModelRenderer) Breast_U).setVisible(b);
    	((Modchu_ModelRenderer) Breast_B).setVisible(b);
    	((Modchu_ModelRenderer) Breast_R).setVisible(b);
    	((Modchu_ModelRenderer) Breast_L).setVisible(b);
    	((Modchu_ModelRenderer) Breast_RU).setVisible(b);
    	((Modchu_ModelRenderer) Breast_LU).setVisible(b);
    	((Modchu_ModelRenderer) Breast_RB).setVisible(b);
    	((Modchu_ModelRenderer) Breast_LB).setVisible(b);
    	Breast_C.rotationPointZ = -2.35F;
    }

    @Override
    public void setArmorBipedRightArmShowModel(boolean b) {
    	super.setArmorBipedRightArmShowModel(b);
    	bipedRightArm.isHidden = !b;
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	super.setArmorSkirtShowModel(b);
    	Skirt.isHidden = !b;
    	((Modchu_ModelRenderer) Skirt_R).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_L).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_RF).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_RB).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_RR).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_RL).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_LF).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_LB).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_LR).setVisible(b);
    	((Modchu_ModelRenderer) Skirt_LL).setVisible(b);
    }

    @Override
    public void setArmorBipedLeftArmShowModel(boolean b) {
    	super.setArmorBipedLeftArmShowModel(b);
    	bipedLeftArm.isHidden = !b;
    }

    @Override
    public void setArmorBipedRightLegShowModel(boolean b) {
    	super.setArmorBipedRightLegShowModel(b);
    	bipedRightLeg.isHidden = !b;
    }

    @Override
    public void setArmorBipedLeftLegShowModel(boolean b) {
    	super.setArmorBipedLeftLegShowModel(b);
    	bipedLeftLeg.isHidden = !b;
    }
}
