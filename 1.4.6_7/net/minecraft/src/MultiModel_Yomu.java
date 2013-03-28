package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import java.util.*;

public class MultiModel_Yomu extends MultiModel_SR2 {

	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer Tail2;
	public Modchu_ModelRenderer Skirt1;
	public Modchu_ModelRenderer Skirt2;
	public Modchu_ModelRenderer Skirt3;
	public Modchu_ModelRenderer Skirt4;
	public Modchu_ModelRenderer Skirt5;
	public Modchu_ModelRenderer Skirt6;
	public Modchu_ModelRenderer Skirt7;
	public Modchu_ModelRenderer Skirt8;
	public Modchu_ModelRenderer Skirt9;
	public Modchu_ModelRenderer Skirt10;
	public Modchu_ModelRenderer Skirt11;
	public Modchu_ModelRenderer Skirt12;
	public Modchu_ModelRenderer Skirt13;
	public Modchu_ModelRenderer Skirt14;
	public Modchu_ModelRenderer Skirt15;
	public Modchu_ModelRenderer Skirt16;
	public Modchu_ModelRenderer HipR;
	public Modchu_ModelRenderer HipL;
	public Modchu_ModelRenderer Headband1;
	public Modchu_ModelRenderer Headband2;
	public Modchu_ModelRenderer Headband3;
	public Modchu_ModelRenderer Headband4;
	public Modchu_ModelRenderer Ribon1;
	public Modchu_ModelRenderer Ribon2;
	public Modchu_ModelRenderer Ribon3;
	public Modchu_ModelRenderer Neck;
	public Modchu_ModelRenderer Ribon4;
	public Modchu_ModelRenderer Ribon5;
	public Modchu_ModelRenderer Ribon6;
	public Modchu_ModelRenderer Collar1;
	public Modchu_ModelRenderer Collar2;
	public Modchu_ModelRenderer Collar3;
	public Modchu_ModelRenderer Collar4;
	public Modchu_ModelRenderer Collar5;
	public Modchu_ModelRenderer Collar6;
	public Modchu_ModelRenderer Collar7;
	public Modchu_ModelRenderer Best1;
	public Modchu_ModelRenderer Best2;
	public Modchu_ModelRenderer Patch;
	public Modchu_ModelRenderer Hear;
	public Modchu_ModelRenderer BradeC;
	public Modchu_ModelRenderer Brade1;
	public Modchu_ModelRenderer Brade2;
	public Modchu_ModelRenderer Brade3;
	public Modchu_ModelRenderer Brade4;
	public Modchu_ModelRenderer Tuka1;
	public Modchu_ModelRenderer Tuka2;
	public Modchu_ModelRenderer Tuka3;
	public Modchu_ModelRenderer Tuka4;
	public Modchu_ModelRenderer Tuka5;
	public Modchu_ModelRenderer Tuka6;
	public Modchu_ModelRenderer HanreiC;
	public Modchu_ModelRenderer Hanrei1;
	public Modchu_ModelRenderer Hanrei2;
	public Modchu_ModelRenderer Hanrei3;
	public Modchu_ModelRenderer Hanrei4;
	public Modchu_ModelRenderer Hanrei5;
	public Modchu_ModelRenderer Hanrei6;

	// armor only
	public Modchu_ModelRenderer PlateR1;
	public Modchu_ModelRenderer PlateR2;
	public Modchu_ModelRenderer PlateR3;
	public Modchu_ModelRenderer PlateR4;
	public Modchu_ModelRenderer PlateR5;
	public Modchu_ModelRenderer PlateR6;
	public Modchu_ModelRenderer PlateL1;
	public Modchu_ModelRenderer PlateL2;
	public Modchu_ModelRenderer PlateL3;
	public Modchu_ModelRenderer PlateL4;
	public Modchu_ModelRenderer PlateL5;
	public Modchu_ModelRenderer PlateL6;
	public Modchu_ModelRenderer Glass;



	private float x1;
	private float y1;
	private float z1;
	private float IdOffset;
	private List IdList;
	private List AngleYList;
	private List YawOffsetList;
	private float AY;
	private float prevAY;

	public MultiModel_Yomu()
	{
		this(0.0F);
	}

	public MultiModel_Yomu(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_Yomu(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}

	public MultiModel_Yomu(float f, float f1, int i, int j) {
		super(f, f1, i, j);
		HeadMount.setRotationPoint(0.0F, 1.0F, 0.0F);
	}

	@Override
	public void initModel(float f, float f1) {
		textureHeight=64;
		textureWidth=64;
		f1 += 8F;
		IdList=new ArrayList();
		AngleYList= new ArrayList();
		YawOffsetList= new ArrayList();
		bipedHead = new Modchu_ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f);
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
		bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
		bipedBody.addChild(bipedLeftLeg);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);
		bipedBody.addChild(Skirt);
		HipR = new Modchu_ModelRenderer(this, 57, 28);
		HipR.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipR.setRotationPointLM(0.6F, 1.1F, 2.0F);
		HipR.setRotateAngleDeg(-150F,0F,0F);
		bipedRightLeg.addChild(HipR);

		HipL = new Modchu_ModelRenderer(this, 57, 24);
		HipL.mirror=true;
		HipL.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipL.setRotationPointLM(-0.6F, 1.1F, 2.0F);
		HipL.setRotateAngleDeg(-150F,0F,0F);
		bipedLeftLeg.addChild(HipL);

		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);

		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addPlate(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Prim);

		Skirt1 = new Modchu_ModelRenderer(this, 0, 33, Skirt);//-22,33
		Skirt1.addPlate(-0.8F, -6F, 0F, 20, 6, 0,f);
		Skirt1.setRotationPointLM(0F,-5.5F,0F);

		Skirt2 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt2.addPlate(-0.8F, 0F, 0F, 20, 6, 0,f);
		Skirt2.setRotationPointLM(0F,-5.5F,0F);

		Skirt3 = new Modchu_ModelRenderer(this, 0, 33, Skirt);
		Skirt3.addPlate(0F, -6F, 0F, 20, 6, 0,f);
		Skirt3.setRotationPointLM(0F,-6.0F,0F);

		Skirt4 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt4.addPlate(0F, 0F, 0F, 20, 6, 0,f);
		Skirt4.setRotationPointLM(0F,-6.0F,0F);

		Skirt5 = new Modchu_ModelRenderer(this, 0, 33, Skirt);
		Skirt5.addPlate(0F, -6F, 0F, 20, 6, 0,f);
		Skirt5.setRotationPointLM(0F,-6.0F,0F);

		Skirt6 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt6.addPlate(0F, 0F, 0F, 20, 6, 0,f);
		Skirt6.setRotationPointLM(0F,-6.0F,0F);

		Skirt7 = new Modchu_ModelRenderer(this, 0, 33, Skirt);
		Skirt7.addPlate(-0.8F, -6F, 0F, 20, 6, 0,f);
		Skirt7.setRotationPointLM(0F,-5.5F,0F);

		Skirt8 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt8.addPlate(-0.8F, 0F, 0F, 20, 6, 0,f);
		Skirt8.setRotationPointLM(0F,-5.5F,0F);

		Skirt9 = new Modchu_ModelRenderer(this, 0, 33, Skirt);
		Skirt9.addPlate(-0.8F, -6F, 0F, 20, 6, 0,f);
		Skirt9.setRotationPointLM(0F,-5.5F,0F);

		Skirt10 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt10.addPlate(-0.8F, 0F, 0F, 20, 6, 0,f);
		Skirt10.setRotationPointLM(0F,-5.5F,0F);

		Skirt11 = new Modchu_ModelRenderer(this, 0, 33, Skirt);
		Skirt11.addPlate(0F, -6F, 0F, 20, 6, 0,f);
		Skirt11.setRotationPointLM(0F,-6.0F,0F);

		Skirt12 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt12.addPlate(0F, 0F, 0F, 20, 6, 0,f);
		Skirt12.setRotationPointLM(0F,-6.0F,0F);

		Skirt13 = new Modchu_ModelRenderer(this, 0, 33, Skirt);
		Skirt13.addPlate(0F, -6F, 0F, 20, 6, 0,f);
		Skirt13.setRotationPointLM(0F,-6.0F,0F);

		Skirt14 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt14.addPlate(0F, 0F, 0F, 20, 6, 0,f);
		Skirt14.setRotationPointLM(0F,-6.0F,0F);

		Skirt15 = new Modchu_ModelRenderer(this, 0, 33, Skirt);
		Skirt15.addPlate(-0.8F, -6F, 0F, 20, 6, 0,f);
		Skirt15.setRotationPointLM(0F,-5.5F,0F);

		Skirt16 = new Modchu_ModelRenderer(this, 0, 27, Skirt);
		Skirt16.addPlate(-0.8F, 0F, 0F, 20, 6, 0,f);
		Skirt16.setRotationPointLM(0F,-5.5F,0F);

		Neck = new Modchu_ModelRenderer(this, 16, 5);
		Neck.addBox(-1.0F, -1.0F, 1.0F, 2, 1, 2, f);
		Neck.setRotationPointLM(0.0F, -3.0F, -2.0F);
		bipedBody.addChild(Neck);

		Collar1 = new Modchu_ModelRenderer(this, 0, 16);
		Collar1.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar1.setRotationPointLM(0.0F, -2.5F, -2.2F);
		Collar1.setRotateAngleDeg(10F,-172F,-45F);
		bipedBody.addChild(Collar1);

		Collar2 = new Modchu_ModelRenderer(this, 0, 16);
		Collar2.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar2.setRotationPointLM(0.0F, -2.5F, -2.2F);
		Collar2.setRotateAngleDeg(-76F,-170F,-44F);
		bipedBody.addChild(Collar2);

		Collar3 = new Modchu_ModelRenderer(this, 0, 16);
		Collar3.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar3.setRotationPointLM(0.0F, -2.5F, -2.2F);
		Collar3.setRotateAngleDeg(-10F,-8F,-45F);
		bipedBody.addChild(Collar3);

		Collar4 = new Modchu_ModelRenderer(this, 0, 16);
		Collar4.addPlate(0.0F, 0F, 0F, 3, 1, 0, f);
		Collar4.setRotationPointLM(0.0F,-2.5F,-2.2F);
		Collar4.setRotateAngleDeg(76F,-10F,-44F);
		bipedBody.addChild(Collar4);

		Collar5 = new Modchu_ModelRenderer(this, 0, 16);
		Collar5.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, f);
		Collar5.setRotationPointLM(1.5F,-2.6F,-1.99F);
		Collar5.setRotateAngleDeg(45F,-90F,0F);
		bipedBody.addChild(Collar5);

		Collar6 = new Modchu_ModelRenderer(this, 0, 16);
		Collar6.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, f);
		Collar6.setRotationPointLM(-1.5F,-2.6F,-1.99F);
		Collar6.setRotateAngleDeg(45F,-90F,0F);
		bipedBody.addChild(Collar6);

		Collar7 = new Modchu_ModelRenderer(this, 48, 2);
		Collar7.addBox(-2.0F, -0.5F, -0.5F, 4, 1, 1, f);
		Collar7.setRotationPointLM(0.0F,-2.58F,1.4F);
		Collar7.setRotateAngleDeg(45F,0F,0F);
		bipedBody.addChild(Collar7);

		Best1 = new Modchu_ModelRenderer(this, 0, 5);
		Best1.addPlate(0.0F, 0.0F, 0.0F, 3, 1, 0, f);
		Best1.setRotationPointLM(0.0F,-0.5F,-2.001F);
		Best1.setRotateAngleDeg(0F,0F,-61F);
		bipedBody.addChild(Best1);

		Best2 = new Modchu_ModelRenderer(this, 0, 5);
		Best2.addPlate(0.0F, 0.0F, 0.0F, 3, 1, 0, f);
		Best2.setRotationPointLM(0.0F,-0.5F,-2.001F);
		Best2.setRotateAngleDeg(0F,-180F,-61F);
		bipedBody.addChild(Best2);

		Patch = new Modchu_ModelRenderer(this, 0, 39);
		Patch.addPlate(0.0F, 0.0F, 0.0F, 20, 20, 0, f);
		Patch.setRotationPointLM(0.8F,-2.1F,-2.002F);
		Patch.setRotateAngleDeg(0F,0F,0F);
		bipedBody.addChild(Patch);

		Headband1 = new Modchu_ModelRenderer(this, 0, 20);
		Headband1.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, f);
		Headband1.setRotationPointLM(-0.3F,-7.7F,-2.5F);
		Headband1.setRotateAngleDeg(0F,0F,0F);
		bipedHead.addChild(Headband1);

		Headband2 = new Modchu_ModelRenderer(this, 0, 20);
		Headband2.addBox(-5.0F, 0.0F, 0.0F, 5, 1, 2, f);
		Headband2.setRotationPointLM(0.3F,-7.701F,-2.5F);
		Headband2.setRotateAngleDeg(0F,0F,0F);
		bipedHead.addChild(Headband2);

		Headband3 = new Modchu_ModelRenderer(this, 0, 20);
		Headband3.addBox(0.0F, -1.0F, 0.0F, 5, 1, 2, f);
		Headband3.setRotationPointLM(-4.699F,-7.701F,-2.5F);
		Headband3.parentModel=bipedHead;
		Headband3.setRotateAngleDeg(0F,0F,90F);
		bipedHead.addChild(Headband3);

		Headband4 = new Modchu_ModelRenderer(this, 0, 20);
		Headband4.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, f);
		Headband4.setRotationPointLM(4.701F,-7.7F,-2.5F);
		Headband4.setRotateAngleDeg(0F,0F,90F);
		bipedHead.addChild(Headband4);

		Ribon1 = new Modchu_ModelRenderer(this, 16, 16);
		Ribon1.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, f);
		Ribon1.setRotationPointLM(-3.0F,-7.0F,-1.2F);
		Ribon1.setRotateAngleDeg(-135F,180F,-118F);
		bipedHead.addChild(Ribon1);

		Ribon2 = new Modchu_ModelRenderer(this, 16, 16);
		Ribon2.addBox(-0.2F, -0.5F, -0.5F, 3, 1, 1, f);
		Ribon2.setRotationPointLM(-3.0F,-7.0F,-1.2F);
		Ribon2.setRotateAngleDeg(-135F,180F,-90F);
		bipedHead.addChild(Ribon2);

		Ribon3 = new Modchu_ModelRenderer(this, 16, 16);
		Ribon3.addBox(-0.5F, -0.5F, -0.5F, 3, 1, 1, f);
		Ribon3.setRotationPointLM(-3.0F,-7.0F,-1.2F);
		Ribon3.setRotateAngleDeg(-135F,180F,-59F);
		bipedHead.addChild(Ribon3);

		Ribon4 = new Modchu_ModelRenderer(this, 0, 22);
		Ribon4.addBox(-1.0F, -0.5F, -0.2F, 2, 1, 1, f);
		Ribon4.setRotationPointLM(0.0F,-1.9F,-2.2F);
		Ribon4.setRotateAngleDeg(0F,0F,0F);
		bipedBody.addChild(Ribon4);

		Ribon5 = new Modchu_ModelRenderer(this, 0, 22);
		Ribon5.addBox(0.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon5.setRotationPointLM(0.3F,-1.7F,-2.2F);
		Ribon5.setRotateAngleDeg(0F,0F,15F);
		bipedBody.addChild(Ribon5);

		Ribon6 = new Modchu_ModelRenderer(this, 0, 22);
		Ribon6.addBox(-1.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon6.setRotationPointLM(-0.3F,-1.7F,-2.2F);
		Ribon6.setRotateAngleDeg(0F,0F,-15F);
		bipedBody.addChild(Ribon6);

		Hear = new Modchu_ModelRenderer(this, 20, 32);
		Hear.addBox(-4F, -3.5F, -4F, 8, 7, 8, f);
		Hear.setRotationPointLM(0.0F, -3.5F, -0.001F);
		bipedHead.addChild(Hear);

		BradeC = new Modchu_ModelRenderer(this, 0, 0);
		BradeC.addBox(0F, 0F, 0.0F, 0, 0, 0, f);
		BradeC.setRotationPointLM(0.2F,-4.3F,-0.9F);
		BradeC.setRotateAngleDeg(-20F,0F,5F);
		bipedBody.addChild(BradeC);

		Brade1 = new Modchu_ModelRenderer(this, 0, 0);
		Brade1.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 1, f);
		Brade1.setRotationPointLM(3F,3.5F,0F);
		Brade1.setRotateAngleDeg(0F,0F,0F);
		BradeC.addChild(Brade1);

		Brade2 = new Modchu_ModelRenderer(this, 0, 21);
		Brade2.addBox(0.0F, -1.0F, -0.5F, 3, 2, 1, f);
		Brade2.setRotationPointLM(3F,3.5F,0F);
		Brade2.setRotateAngleDeg(0F,90F,0F);
		BradeC.addChild(Brade2);

		Brade3 = new Modchu_ModelRenderer(this, 0, 20);
		Brade3.addBox(0.0F, -1.0F, -0.5F, 8, 2, 1, f);
		Brade3.setRotationPointLM(3F,3.5F,0.001F);
		Brade3.setRotateAngleDeg(0F,-90F,0F);
		BradeC.addChild(Brade3);

		Brade4 = new Modchu_ModelRenderer(this, 0, 21);
		Brade4.addBox(0.0F, -1.0F, -0.5F, 4, 2, 1, f);
		Brade4.setRotationPointLM(3F,3.5F,7.99F);
		Brade4.setRotateAngleDeg(0F,-90F,5F);
		BradeC.addChild(Brade4);

		Tuka1 = new Modchu_ModelRenderer(this, 0, 9);
		Tuka1.addPlate(-0.5F, -0.5F,-0.5F, 1, 1, 0, f);
		Tuka1.setRotationPointLM(3.001F,3.5F,-2.5F);
		Tuka1.setRotateAngleDeg(0F,-90F,-45F);
		BradeC.addChild(Tuka1);

		Tuka2 = new Modchu_ModelRenderer(this, 0, 9);
		Tuka2.addPlate(-0.5F, -0.5F,-0.5F, 1, 1, 0, f);
		Tuka2.setRotationPointLM(3.001F,3.5F,-1.5F);
		Tuka2.setRotateAngleDeg(0F,-90F,-45F);
		BradeC.addChild(Tuka2);

		Tuka3 = new Modchu_ModelRenderer(this, 0, 9);
		Tuka3.addPlate(-0.5F, -0.5F,-0.5F, 1, 1, 0, f);
		Tuka3.setRotationPointLM(3.001F,3.5F,-0.5F);
		Tuka3.setRotateAngleDeg(0F,-90F,-45F);
		BradeC.addChild(Tuka3);

		Tuka4 = new Modchu_ModelRenderer(this, 0, 9);
		Tuka4.addPlate(-0.5F, -0.5F,0.5F, 1, 1, 0, f);
		Tuka4.setRotationPointLM(2.999F,3.5F,-2.5F);
		Tuka4.setRotateAngleDeg(0F,-90F,-45F);
		BradeC.addChild(Tuka4);

		Tuka5 = new Modchu_ModelRenderer(this, 0, 9);
		Tuka5.addPlate(-0.5F, -0.5F,0.5F, 1, 1, 0, f);
		Tuka5.setRotationPointLM(2.999F,3.5F,-1.5F);
		Tuka5.setRotateAngleDeg(0F,-90F,-45F);
		BradeC.addChild(Tuka5);

		Tuka6 = new Modchu_ModelRenderer(this, 0, 9);
		Tuka6.addPlate(-0.5F, -0.5F,0.5F, 1, 1, 0, f);
		Tuka6.setRotationPointLM(2.999F,3.5F,-0.5F);
		Tuka6.setRotateAngleDeg(0F,-90F,-45F);
		BradeC.addChild(Tuka6);

		HanreiC = new Modchu_ModelRenderer(this, 16, 19);
		HanreiC.addBall(8.0F, 0.0F, 6.0F, 4.0F, 4.0F, 4.0F);
		HanreiC.setRotationPointLM(0F,0F,0F);
		x1=-6.0F;
		y1=-2.0F;
		z1=-5.0F;
		IdOffset=0F;
		AY=0F;

		Hanrei1 = new Modchu_ModelRenderer(this, 2, 24);
		Hanrei1.addBall(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F);
		Hanrei1.setRotationPointLM(0F,0.0F,0F);
		Hanrei1.setRotateAngleDeg(0F,0F,0F);

		Hanrei2 = new Modchu_ModelRenderer(this, 2, 24);
		Hanrei2.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 4, f);
		Hanrei2.setRotationPointLM(8F,0.0F,4F);
		Hanrei2.setRotateAngleDeg(90F,0F,0F);

		Hanrei3 = new Modchu_ModelRenderer(this, 2, 24);
		Hanrei3.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 4, f);
		Hanrei3.setRotationPointLM(8F,0.0F,4F);
		Hanrei3.setRotateAngleDeg(0F,90F,0F);

		Hanrei4 = new Modchu_ModelRenderer(this, 0, 0);
		Hanrei4.addBall(8.0F, 0.3F, 5.0F, 2.0F, 2.0F, 2.0F);
		Hanrei4.setRotationPointLM(0F,0.0F,0F);
		Hanrei4.setRotateAngleDeg(0F,0F,0F);
		HanreiC.addChild(Hanrei4);

		Hanrei5 = new Modchu_ModelRenderer(this, 0, 0);
		Hanrei5.addBall(8.0F, 0.2F, 4.7F, 1.0F, 1.0F, 1.0F);
		Hanrei5.setRotationPointLM(0F,0F,0F);
		Hanrei5.setRotateAngleDeg(0F,0F,0F);
		Hanrei4.addChild(Hanrei5);

		PlateR1 = new Modchu_ModelRenderer(this, 45, 52, Skirt);
		PlateR1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateR1.setRotationPointLM(-3.0F,4.6F+1.0F,0.0F);
		PlateR1.setRotateAngleDeg(-50F,90F,0F);

		PlateR2 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateR2.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR2.setRotationPointLM(-3.0F,4.6F+1.0F,2.0F);
		PlateR2.setRotateAngleDeg(60F,0F,-40F);

		PlateR3 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateR3.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR3.setRotationPointLM(-3.0F,4.6F+1.0F,-2.0F);
		PlateR3.setRotateAngleDeg(-60F,0F,-40F);

		PlateR4 = new Modchu_ModelRenderer(this, 44, 52, Skirt);
		PlateR4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateR4.setRotationPointLM(-4.5F,6.3F+1.0F,0.0F);
		PlateR4.setRotateAngleDeg(-50F,90F,0F);

		PlateR5 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateR5.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR5.setRotationPointLM(-4.5F,6.3F+1.0F,2.5F);
		PlateR5.setRotateAngleDeg(60F,0F,-40F);

		PlateR6 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateR6.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR6.setRotationPointLM(-4.5F,6.3F+1.0F,-2.5F);
		PlateR6.setRotateAngleDeg(-60F,0F,-40F);

		PlateL1 = new Modchu_ModelRenderer(this, 45, 52, Skirt);
		PlateL1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateL1.setRotationPointLM(3.0F,4.6F+1.0F,0.0F);
		PlateL1.setRotateAngleDeg(50F,90F,0F);

		PlateL2 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateL2.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL2.setRotationPointLM(3.0F,4.6F+1.0F,2.0F);
		PlateL2.setRotateAngleDeg(60F,0F,40F);

		PlateL3 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateL3.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL3.setRotationPointLM(3.0F,4.6F+1.0F,-2.0F);
		PlateL3.setRotateAngleDeg(-60F,0F,40F);

		PlateL4 = new Modchu_ModelRenderer(this, 44, 52, Skirt);
		PlateL4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateL4.setRotationPointLM(4.5F,6.3F+1.0F,0.0F);
		PlateL4.setRotateAngleDeg(50F,90F,0F);

		PlateL5 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateL5.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL5.setRotationPointLM(4.5F,6.3F+1.0F,2.5F);
		PlateL5.setRotateAngleDeg(60F,0F,40F);

		PlateL6 = new Modchu_ModelRenderer(this, 44, 60, Skirt);
		PlateL6.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL6.setRotationPointLM(4.5F,6.3F+1.0F,-2.5F);
		PlateL6.setRotateAngleDeg(-60F,0F,40F);

		Glass = new Modchu_ModelRenderer(this, 24, 0);
		Glass.addPlate(-8.0F, -4.0F, 0F, 16, 8, 0, f);
		Glass.setRotationPointLM(0.0F, -4.0F, -4.0F);
		bipedHead.addChild(Glass);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
		mainFrame.addChild(HanreiC);

		Skirt1.setRotateAngleDeg(-118F, 113F, 42F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 42F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 42F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 42F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 42F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 42F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 42F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 42F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 42F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 42F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 42F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 42F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 42F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 42F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 42F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 42F);

		int i = Modchu_ModelRenderer.ZYX;
		Prim.setRotatePriority(i);
		i = Modchu_ModelRenderer.YZX;
		Best1.setRotatePriority(i);
		Best2.setRotatePriority(i);
		Neck.setRotatePriority(i);
		Collar1.setRotatePriority(i);
		Collar2.setRotatePriority(i);
		Collar3.setRotatePriority(i);
		Collar4.setRotatePriority(i);
		Collar5.setRotatePriority(i);
		Collar6.setRotatePriority(i);
		Collar7.setRotatePriority(i);
		Patch.setRotatePriority(i);
		Headband1.setRotatePriority(i);
		Headband2.setRotatePriority(i);
		Headband3.setRotatePriority(i);
		Headband4.setRotatePriority(i);
		Ribon1.setRotatePriority(i);
		Ribon2.setRotatePriority(i);
		Ribon3.setRotatePriority(i);
		Ribon4.setRotatePriority(i);
		Ribon5.setRotatePriority(i);
		Ribon6.setRotatePriority(i);
		Hear.setRotatePriority(i);
		BradeC.setRotatePriority(i);
		Glass.setRotatePriority(i);
		Skirt1.setRotatePriority(i);
		Skirt2.setRotatePriority(i);
		Skirt3.setRotatePriority(i);
		Skirt4.setRotatePriority(i);
		Skirt5.setRotatePriority(i);
		Skirt6.setRotatePriority(i);
		Skirt7.setRotatePriority(i);
		Skirt8.setRotatePriority(i);
		Skirt9.setRotatePriority(i);
		Skirt10.setRotatePriority(i);
		Skirt11.setRotatePriority(i);
		Skirt12.setRotatePriority(i);
		Skirt13.setRotatePriority(i);
		Skirt14.setRotatePriority(i);
		Skirt15.setRotatePriority(i);
		Skirt16.setRotatePriority(i);
		PlateR1.setRotatePriority(i);
		PlateR2.setRotatePriority(i);
		PlateR3.setRotatePriority(i);
		PlateR4.setRotatePriority(i);
		PlateR5.setRotatePriority(i);
		PlateR6.setRotatePriority(i);
		PlateL1.setRotatePriority(i);
		PlateL2.setRotatePriority(i);
		PlateL3.setRotatePriority(i);
		PlateL4.setRotatePriority(i);
		PlateL5.setRotatePriority(i);
		PlateL6.setRotatePriority(i);
		Brade1.setRotatePriority(i);
		Brade2.setRotatePriority(i);
		Brade3.setRotatePriority(i);
		Brade4.setRotatePriority(i);
		Tuka1.setRotatePriority(i);
		Tuka2.setRotatePriority(i);
		Tuka3.setRotatePriority(i);
		Tuka4.setRotatePriority(i);
		Tuka5.setRotatePriority(i);
		Tuka6.setRotatePriority(i);
		HipR.setRotatePriority(i);
		HipL.setRotatePriority(i);

		Skirt1.setScale(0.5F, 0.5F, 1.0F);
		Skirt2.setScale(0.5F, 0.5F, 1.0F);
		Skirt3.setScale(0.5F, 0.5F, 1.0F);
		Skirt4.setScale(0.5F, 0.5F, 1.0F);
		Skirt5.setScale(0.5F, 0.5F, 1.0F);
		Skirt6.setScale(0.5F, 0.5F, 1.0F);
		Skirt7.setScale(0.5F, 0.5F, 1.0F);
		Skirt8.setScale(0.5F, 0.5F, 1.0F);
		Skirt9.setScale(0.5F, 0.5F, 1.0F);
		Skirt10.setScale(0.5F, 0.5F, 1.0F);
		Skirt11.setScale(0.5F, 0.5F, 1.0F);
		Skirt12.setScale(0.5F, 0.5F, 1.0F);
		Skirt13.setScale(0.5F, 0.5F, 1.0F);
		Skirt14.setScale(0.5F, 0.5F, 1.0F);
		Skirt15.setScale(0.5F, 0.5F, 1.0F);
		Skirt16.setScale(0.5F, 0.5F, 1.0F);
		Collar1.setScale(0.7F, 0.7F, 0.7F);
		Collar2.setScale(0.6F, 0.6F, 0.6F);
		Collar3.setScale(0.7F, 0.7F, 0.7F);
		Collar4.setScale(0.6F, 0.6F, 0.6F);
		Collar5.setScale(0.9F, 0.9F, 0.9F);
		Collar6.setScale(0.9F, 0.9F, 0.9F);
		Collar7.setScale(0.8F, 0.8F, 0.8F);
		Patch.setScale(0.1F, 0.1F, 0.1F);
		Headband1.setScale(1.0F, 0.3F, 1.0F);
		Headband2.setScale(1.0F, 0.3F, 1.0F);
		Headband3.setScale(1.0F, 0.3F, 1.0F);
		Headband4.setScale(1.0F, 0.3F, 1.0F);
		HanreiC.setScale(2.0F, 2.0F, 2.0F);
		Hanrei1.setScale(3.0F, 3.0F, 3.0F);
		//Hanrei4.setScale(1.0F, 1.0F, 1.0F);
		Hanrei5.setScale(0.5F, 0.5F, 0.5F);
		Ribon4.setScale(0.5F, 0.5F, 0.5F);
		Ribon5.setScale(0.8F, 0.8F, 0.8F);
		Ribon6.setScale(0.8F, 0.8F, 0.8F);
		Hear.setScale(1.1F, 1.1F, 1.1F);
		Glass.setScale(0.5F, 0.5F, 1.0F);
		PlateR1.setScale(0.25F, 0.25F, 0.25F);
		PlateR2.setScale(0.25F, 0.25F, 0.25F);
		PlateR3.setScale(0.25F, 0.25F, 0.25F);
		PlateR4.setScale(0.25F, 0.25F, 0.25F);
		PlateR5.setScale(0.25F, 0.25F, 0.25F);
		PlateR6.setScale(0.25F, 0.25F, 0.25F);
		PlateL1.setScale(0.25F, 0.25F, 0.25F);
		PlateL2.setScale(0.25F, 0.25F, 0.25F);
		PlateL3.setScale(0.25F, 0.25F, 0.25F);
		PlateL4.setScale(0.25F, 0.25F, 0.25F);
		PlateL5.setScale(0.25F, 0.25F, 0.25F);
		PlateL6.setScale(0.25F, 0.25F, 0.25F);
		Brade1.setScale(1.0F, 0.8F, 0.3F);
		Brade2.setScale(1.0F, 0.6F, 0.8F);
		Brade3.setScale(1.0F, 0.7F, 0.9F);
		Brade4.setScale(1.0F, 0.7F, 0.9F);
		Tuka1.setScale(0.65F, 0.65F, 0.8F);
		Tuka2.setScale(0.65F, 0.65F, 0.8F);
		Tuka3.setScale(0.65F, 0.65F, 0.8F);
		Tuka4.setScale(0.65F, 0.65F, 0.8F);
		Tuka5.setScale(0.65F, 0.65F, 0.8F);
		Tuka6.setScale(0.65F, 0.65F, 0.8F);
		actionPartsInit(f, f1);
	}

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

	public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityliving, f, f1, f2);
		float f4;

		if (isRiding
				&& entityliving.ridingEntity != null) {
			f4 = (float)entityliving.ridingEntity.ticksExisted;
		} else {
			f4 = f2;
		}

		float f3 = (float)entityliving.ticksExisted + f4 + getCapsValueFloat(caps_entityIdFactor);
		int IdIndex;
		if(getCapsValueBoolean(caps_isOpenInv, entityliving)) {
			try
			{
				IdIndex = IdList.indexOf(Integer.valueOf(entityliving.entityId));
				HanreiC.rotateAngleY = ((Float)AngleYList.get(IdIndex)).floatValue();
				AY = ((Float)YawOffsetList.get(IdIndex)).floatValue();
			}
			catch (Exception var15)
			{
				IdList.add(Integer.valueOf(entityliving.entityId));
				AngleYList.add(Float.valueOf(HanreiC.rotateAngleY));
				YawOffsetList.add(Float.valueOf(entityliving.renderYawOffset));
				IdIndex = IdList.indexOf(Integer.valueOf(entityliving.entityId));
				AY = entityliving.renderYawOffset;
			}
			finally
			{
				Hanrei4.rotateAngleY = Hanrei5.rotateAngleY = HanreiC.rotateAngleY;
			}
		} else {
			try
			{
				IdIndex = IdList.indexOf(Integer.valueOf(entityliving.entityId));
				HanreiC.rotateAngleY = ((Float)AngleYList.get(IdIndex)).floatValue();
				AY = ((Float)YawOffsetList.get(IdIndex)).floatValue();
			}
			catch (Exception var14)
			{
				IdList.add(Integer.valueOf(entityliving.entityId));
				AngleYList.add(Float.valueOf(HanreiC.rotateAngleY));
				YawOffsetList.add(Float.valueOf(entityliving.renderYawOffset));
				IdIndex = IdList.indexOf(Integer.valueOf(entityliving.entityId));
				AY = entityliving.renderYawOffset;
			}

			float var9 = entityliving.renderYawOffset / 180.0F * (float)Math.PI;
			float var10 = var9 - AY / 180.0F * (float)Math.PI;

			for (HanreiC.rotateAngleY -= var10 * 0.45F; HanreiC.rotateAngleY > (float)Math.PI; HanreiC.rotateAngleY -= ((float)Math.PI * 2F))
			{
				;
			}

			while (HanreiC.rotateAngleY < -(float)Math.PI)
			{
				HanreiC.rotateAngleY += ((float)Math.PI * 2F);
			}

			if (HanreiC.rotateAngleY != 0.0F)
			{
				HanreiC.rotateAngleY *= 0.99F;
			}

			Hanrei4.rotateAngleY = Hanrei5.rotateAngleY = HanreiC.rotateAngleY;
			AngleYList.set(IdIndex, Float.valueOf(HanreiC.rotateAngleY));
			YawOffsetList.set(IdIndex, Float.valueOf(entityliving.renderYawOffset));
		}
	}

	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
        bipedHeadwear.rotateAngleX = bipedHeadwear.rotateAngleY = bipedHeadwear.rotateAngleZ = 0.0F;
        getCapsValue(caps_shiftArray, HanreiC.rotationPointX, HanreiC.rotationPointY, HanreiC.rotationPointZ);
        float[] pastX = (float[]) getCapsValue(caps_pastX);
        float[] pastY = (float[]) getCapsValue(caps_pastY);
        float[] pastZ = (float[]) getCapsValue(caps_pastZ);
        Hanrei4.rotationPointX = pastX[4] - HanreiC.rotationPointX;
        Hanrei4.rotationPointY = pastY[4] - HanreiC.rotationPointY + 1.0F;
        Hanrei4.rotationPointZ = pastZ[4] - HanreiC.rotationPointZ + 2.5F;
        Hanrei5.rotationPointX = pastX[9] - HanreiC.rotationPointX + 3.0F;
        Hanrei5.rotationPointY = pastY[9] - HanreiC.rotationPointY + 1.5F;
        Hanrei5.rotationPointZ = pastZ[9] - HanreiC.rotationPointZ + 3.5F;
        //Modchu_Debug.mDebug("Hanrei4.rotationPointZ="+Hanrei4.rotationPointZ+" HanreiC.rotationPointX="+HanreiC.rotationPointX);

        HanreiC.rotationPointX = x1 + MathHelper.cos((f2 + (float)entity.entityId + 0.01F * f4) * 0.11F) * 0.5F;
        HanreiC.rotationPointZ = z1 + MathHelper.cos((f2 + (float)entity.entityId + 0.01F * f4) * 0.07F) * 0.5F;
        HanreiC.rotationPointY = y1 + MathHelper.cos((f2 + (float)entity.entityId + 0.01F * f4) * 0.13F) * 0.5F;
        Skirt.rotateAngleX = 0.0F;
        Skirt.rotationPointZ = 0.0F;

        if (isRiding)
        {
            Skirt.rotationPointZ -= 0.8F;
            Skirt.rotateAngleX = getCapsValueFloat(caps_convertDegtoRad, -25.0F);
        }

        if(getCapsValueBoolean(caps_getIsSneak)){
			Skirt.rotationPointZ = -0.5F;
		} else {
			Skirt.rotationPointZ = 0.0F;
		}
		Skirt.rotationPointY = 3.5F;
		Skirt.rotateAngleX = 0.0F;
		skirtFloats(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
		Skirt1.setRotateAngleDeg(-118F, 113F, 42F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 42F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 42F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 42F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 42F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 42F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 42F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 42F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 42F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 42F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 42F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 42F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 42F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 42F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 42F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 42F);

      	float f6 = -motionY * 2.0F - 8F;
		Skirt1.rotationPointY = 2.5F + f6;
		Skirt2.rotationPointY = 2.5F + f6;
		Skirt3.rotationPointY = 2F + f6;
		Skirt4.rotationPointY = 2F + f6;
		Skirt5.rotationPointY = 2F + f6;
		Skirt6.rotationPointY = 2F + f6;
		Skirt7.rotationPointY = 2.5F + f6;
		Skirt8.rotationPointY = 2.5F + f6;
		Skirt9.rotationPointY = 2.5F + f6;
		Skirt10.rotationPointY = 2.5F + f6;
		Skirt11.rotationPointY = 2F + f6;
		Skirt12.rotationPointY = 2F + f6;
		Skirt13.rotationPointY = 2F + f6;
		Skirt14.rotationPointY = 2F + f6;
		Skirt15.rotationPointY = 2.5F + f6;
		Skirt16.rotationPointY = 2.5F + f6;

		Skirt1.rotateAngleX += motionY;
		Skirt1.rotateAngleZ += motionY;
		Skirt2.rotateAngleX += motionY;
		Skirt2.rotateAngleZ += motionY;
		Skirt3.rotateAngleX += motionY;
		Skirt3.rotateAngleZ += motionY;
		Skirt4.rotateAngleX += motionY;
		Skirt4.rotateAngleZ += motionY;
		Skirt5.rotateAngleX += motionY;
		Skirt5.rotateAngleZ += motionY;
		Skirt6.rotateAngleX += motionY;
		Skirt6.rotateAngleZ += motionY;
		Skirt7.rotateAngleZ += motionY;
		Skirt8.rotateAngleZ += motionY;
		Skirt9.rotateAngleX += motionY;
		Skirt9.rotateAngleZ += motionY;
		Skirt10.rotateAngleX += motionY;
		Skirt10.rotateAngleZ += motionY;
		Skirt11.rotateAngleX += motionY;
		Skirt11.rotateAngleZ += motionY;
		Skirt12.rotateAngleX += motionY;
		Skirt12.rotateAngleZ += motionY;
		Skirt13.rotateAngleX += motionY;
		Skirt13.rotateAngleZ += motionY;
		Skirt14.rotateAngleX += motionY;
		Skirt14.rotateAngleZ += motionY;
		Skirt15.rotateAngleX += motionY;
		Skirt15.rotateAngleZ += motionY;
		Skirt16.rotateAngleX += motionY;
		Skirt16.rotateAngleZ += motionY;
	}

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"Skirt1", "Skirt2", "Skirt3", "Skirt4", "Skirt5",
    			"Skirt6", "Skirt7", "Skirt8", "Skirt9", "Skirt10",
    			"Skirt11", "Skirt12", "Skirt13", "Skirt14", "Skirt15",
    			"Skirt16"
    	};
    	showPartsHideListadd(s);
    }

    @Override
    public void setArmorBipedHeadShowModel(boolean b) {
    	bipedHead.isHidden = !b;
    	super.setArmorBipedHeadShowModel(b);
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	super.setArmorSkirtShowModel(b);
    	Skirt.isHidden = !b;
    }
}