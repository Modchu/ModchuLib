package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_DogAngel extends MultiModel_SR2 {

	public Modchu_ModelRenderer EarL1;
	public Modchu_ModelRenderer EarL2;
	public Modchu_ModelRenderer EarR1;
	public Modchu_ModelRenderer EarR2;
	public Modchu_ModelRenderer WingLroot;
	public Modchu_ModelRenderer WingL2;
	public Modchu_ModelRenderer WingL3;
	public Modchu_ModelRenderer WingL4;
	public Modchu_ModelRenderer WingL5;
	public Modchu_ModelRenderer WingL6;
	public Modchu_ModelRenderer WingRroot;
	public Modchu_ModelRenderer WingR2;
	public Modchu_ModelRenderer WingR3;
	public Modchu_ModelRenderer WingR4;
	public Modchu_ModelRenderer WingR5;
	public Modchu_ModelRenderer WingR6;
	public Modchu_ModelRenderer SideTailL2;
	public Modchu_ModelRenderer SideTailR2;
	public Modchu_ModelRenderer Tail2;
	public Modchu_ModelRenderer Bust1;
	public Modchu_ModelRenderer Bust2;
	public Modchu_ModelRenderer Ahoge;
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
	public Modchu_ModelRenderer Prim;

	public MultiModel_DogAngel()
	{
		this(0.0F);
	}

	public MultiModel_DogAngel(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_DogAngel(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}

	public MultiModel_DogAngel(float f, float f1, int i, int j) {
		super(f, f1, i, j);
		HeadMount.setRotationPoint(0.0F, 1.0F, 0.0F);
	}

	@Override
	public void initModel(float f, float f1) {
		textureHeight=64;
		textureWidth=64;
		f1 += 8F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
		bipedHeadwear.addBox(-4F, 0.0F, 1.0F, 8, 4, 3, f);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(bipedHeadwear);
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
		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);

		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBoxLM(-2F, -7.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Prim);

		ChignonR = new Modchu_ModelRenderer(this, 24, 18);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonR);

		ChignonL = new Modchu_ModelRenderer(this, 24, 18);
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3,f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonL);

		ChignonB = new Modchu_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2,f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonB);

		EarL1 = new Modchu_ModelRenderer(this, 0, 20);
		EarL1.addBoxLM(-0.9F, 0.5F, -4.5F, 5, 4, 4,f);
		EarL1.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(EarL1);

		EarL2 = new Modchu_ModelRenderer(this, 0, 28);
		EarL2.addBoxLM(2.7F, -3.2F, 2.2F, 1, 3, 1,f);
		EarL2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(EarL2);

		EarR1 = new Modchu_ModelRenderer(this, 0, 20);
		EarR1.mirror=true;
		EarR1.addBoxLM(-0.8F, 0.5F, -4.5F, 5, 4, 4,f);
		EarR1.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(EarR1);

		EarR2 = new Modchu_ModelRenderer(this, 0, 28);
		EarR2.mirror=true;
		EarR2.addBoxLM(-3.5F, -3.2F, -3.5F, 1, 3, 1,f);
		EarR2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(EarR2);

		WingLroot = new Modchu_ModelRenderer(this, 0, 0);
		WingLroot.mirror=true;
		WingLroot.addBoxLM(-0.5F, 0F, -0.5F, 1, 3, 1,f);
		WingLroot.setRotationPointLM(0.4F, -1.0F, 1.2F);
		bipedBody.addChild(WingLroot);

		WingL2 = new Modchu_ModelRenderer(this, 0, 0);
		WingL2.mirror=true;
		WingL2.addBoxLM(-2.4F, 2F, -0.4F, 1, 4, 1,f);
		WingLroot.addChild(WingL2);

		WingL3 = new Modchu_ModelRenderer(this, 0, 0);
		WingL3.mirror=true;
		WingL3.addBoxLM(4.5F, 2.5F, 1.3F, 1, 3, 1,f);
		WingLroot.addChild(WingL3);

		WingL4 = new Modchu_ModelRenderer(this, 0, 0);
		WingL4.mirror=true;
		WingL4.addBoxLM(3.5F, 2F, 1.3F, 1, 3, 1,f);
		WingLroot.addChild(WingL4);

		WingL5 = new Modchu_ModelRenderer(this, 0, 0);
		WingL5.mirror=true;
		WingL5.addBoxLM(2.5F, 2F, 1.3F, 1, 2, 1,f);
		WingLroot.addChild(WingL5);

		WingL6 = new Modchu_ModelRenderer(this, 0, 0);
		WingL6.mirror=true;
		WingL6.addBoxLM(1.8F, 1.5F, 1.3F, 1, 1, 1,f);
		WingLroot.addChild(WingL6);

		WingRroot = new Modchu_ModelRenderer(this, 0, 0);
		WingRroot.addBoxLM(-0.5F, 0F, -0.5F, 1, 3, 1,f);
		WingRroot.setRotationPointLM(-0.5F, -1.0F, 1.2F);
		bipedBody.addChild(WingRroot);

		WingR2 = new Modchu_ModelRenderer(this, 0, 0);
		WingR2.addBoxLM(1.4F, 2F, -0.4F, 1, 4, 1,f);
		WingRroot.addChild(WingR2);

		WingR3 = new Modchu_ModelRenderer(this, 0, 0);
		WingR3.addBoxLM(-5.5F, 2.5F, 1.3F, 1, 3, 1,f);
		WingRroot.addChild(WingR3);

		WingR4 = new Modchu_ModelRenderer(this, 0, 0);
		WingR4.addBoxLM(-4.5F, 2F, 1.3F, 1, 3, 1,f);
		WingRroot.addChild(WingR4);

		WingR5 = new Modchu_ModelRenderer(this, 0, 0);
		WingR5.addBoxLM(-3.5F, 2F, 1.3F, 1, 2, 1,f);
		WingRroot.addChild(WingR5);

		WingR6 = new Modchu_ModelRenderer(this, 0, 0);
		WingR6.addBoxLM(-2.8F, 1.5F, 1.3F, 1, 1, 1,f);
		WingRroot.addChild(WingR6);

		SideTailL = new Modchu_ModelRenderer(this, 46, 26);
		SideTailL.addBox(4.7F, -6F, 1F, 1, 1, 1,f+0.2F);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailL);

		SideTailL2 = new Modchu_ModelRenderer(this, 46, 26);
		SideTailL2.addBoxLM(5.1F, -6F, 1F, 1, 5, 1,f);
		SideTailL2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailL2);

		SideTailR = new Modchu_ModelRenderer(this, 50, 26);
		SideTailR.addBox(-5.7F, -6F, 1F, 1, 1, 1,f+0.2F);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailR);

		SideTailR2 = new Modchu_ModelRenderer(this, 50, 26);
		SideTailR2.addBoxLM(-6.1F, -6F, 1F, 1, 5, 1,f);
		SideTailR2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailR2);

		Tail = new Modchu_ModelRenderer(this, 46, 19);
		Tail.addBox(-1F, -6F, 6.F, 2, 2, 2,f+0.1F);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tail);

		Tail2 = new Modchu_ModelRenderer(this, 46, 19);
		Tail2.addBoxLM(-1F, -4F, 6.1F, 2, 5, 2,f);
		Tail2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tail2);

		Bust1 = new Modchu_ModelRenderer(this, 54, 28);
		Bust1.addBoxLM(0F, 0F, 0F, 4, 2, 2,f);
		Bust1.setRotationPointLM(-2.0F, -1.0F, -1.5F);
		Bust1.setRotateAngle(-0.4363323F, 0F, 0F);
		bipedBody.addChild(Bust1);

		Bust2 = new Modchu_ModelRenderer(this, 54, 28);
		Bust2.addBoxLM(0F, 0F, 0F, 4, 2, 2,f);
		Bust2.setRotationPointLM(-2.0F, -4.1F, -0.5F);
		Bust2.setRotateAngle(-1.134464F, 0F, 0F);
		bipedBody.addChild(Bust2);

		Ahoge = new Modchu_ModelRenderer(this, 0, 1);
		Ahoge.addBoxLM(0F, 0F, 0F, 0, 3, 4,f);
		Ahoge.setRotationPointLM(0.0F, -7.0F, -4.0F);
		bipedHead.addChild(Ahoge);

		Skirt1 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt1.addBoxLM(0F, 0F, 0F, 6, 2, 2,f);
		Skirt1.setRotationPointLM(2.4F, -3.0F, -0.6F);

		Skirt2 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt2.addBoxLM(0F, 0F, 0F, 6, 2, 2,f);
		Skirt2.setRotationPointLM(2F,-3F,-1.2F);

		Skirt3 = new Modchu_ModelRenderer(this, -3, 16, Skirt);
		Skirt3.addBoxLM(0F, 0F, 0F, 8, 2, 2,f);
		Skirt3.setRotationPointLM(0F,-4F,0F);

		Skirt4 = new Modchu_ModelRenderer(this, -3, 16, Skirt);
		Skirt4.addBoxLM(0F, 0F, 0F, 8, 2, 2,f);
		Skirt4.setRotationPointLM(0F,-4F,0F);

		Skirt5 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt5.addBoxLM(0F, 0F, 0F, 6, 2, 2,f);
		Skirt5.setRotationPointLM(-2F,-3F,-1.2F);

		Skirt6 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt6.addBoxLM(0F, 0F, 0F, 6, 2, 2,f);
		Skirt6.setRotationPointLM(-2.4F, -3F, -0.6F);

		Skirt7 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt7.addBoxLM(0F, 0F, 0F, 6, 2, 2,f);
		Skirt7.setRotationPointLM(-2.4F,-3F,0.6F);

		Skirt8 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt8.addBoxLM(0F, 0F, 0F, 6, 2, 2,f);
		Skirt8.setRotationPointLM(-2F,-3F,1.2F);

		Skirt9 = new Modchu_ModelRenderer(this, -3, 16, Skirt);
		Skirt9.addBoxLM(0F, 0F, 0F, 8, 2, 2,f);
		Skirt9.setRotationPointLM(0F,-4F,0F);

		Skirt10 = new Modchu_ModelRenderer(this, -3, 16, Skirt);
		Skirt10.addBoxLM(0F, 0F, 0F, 8, 2, 2,f);
		Skirt10.setRotationPointLM(0F,-4F,0F);

		Skirt11 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt11.addBoxLM(0F, 0F, 0F, 6, 2, 2,f);
		Skirt11.setRotationPointLM(2F,-3F,1.2F);

		Skirt12 = new Modchu_ModelRenderer(this, -1, 16, Skirt);
		Skirt12.addBoxLM(0F, 0F, 0F,  6, 2, 2,f);
		Skirt12.setRotationPointLM(2.4F,-3F,0.6F);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);

		EarL1.setRotateAngle(0.7853982F, 0F, -2.1293016F);
		EarL2.setRotateAngle(0.1570796F, 0.7853982F, -0.1570796F);
		EarR1.setRotateAngle(0.7853982F, 3.174172F, 2.1293016F);
		EarR2.setRotateAngle(-0.1570796F, 0.7853982F, 0.1570796F);

		WingLroot.setRotateAngle(1.5707963F, 0.6108652F, 0F);
		WingL4.setRotateAngle(0F, -0.2792527F, -0.4886922F);
		WingL5.setRotateAngle(0F, -0.2792527F, -0.4886922F);
		WingRroot.setRotateAngle(1.5707963F, -0.6108652F, 0F);
		WingR4.setRotateAngle(0F, 0.2792527F, 0.4886922F);
		WingR5.setRotateAngle(0F, 0.2792527F, 0.4886922F);

		float x = -0.125F;
		float y = 0.0F;
		float z = -0.05F;
		WingR3.setRotationPointLM(x, y, z);
		WingR4.setRotationPointLM(x, y, z);
		WingR5.setRotationPointLM(x, y, z);
		WingR6.setRotationPointLM(x, y, z);

		x = 0.09F;
		y = 0.05F;
		z = -0.09F;
		WingL3.setRotationPointLM(x, y, z);
		WingL4.setRotationPointLM(x, y, z);
		WingL5.setRotationPointLM(x, y, z);
		WingL6.setRotationPointLM(x, y, z);

		WingR2.setRotationPointLM(2.85F, 2.205F, 0.1F);
		WingL2.setRotationPointLM(0.2F, 0.0F, -0.1F);

		WingL2.rotateAngleX = 0.0F;
		WingL2.rotateAngleY = 0.0F;
		WingL2.rotateAngleZ = -0.645F;
		WingL3.rotateAngleX = 5.3F;
		WingL3.rotateAngleY = -0.759F;
		WingL3.rotateAngleZ = -WingL3.rotateAngleY;
		WingL6.rotateAngleX = WingL5.rotateAngleX = WingL4.rotateAngleX = WingL3.rotateAngleX;
		WingL6.rotateAngleY = WingL5.rotateAngleY = WingL4.rotateAngleY = WingL3.rotateAngleY;
		WingL6.rotateAngleZ = WingL5.rotateAngleZ = WingL4.rotateAngleZ = WingL3.rotateAngleZ;

		WingR2.rotateAngleX = 3.141593F;
		WingR2.rotateAngleY = 0.0F;
		WingR2.rotateAngleZ = -2.5F;
		WingR3.rotateAngleX = 5.3F;
		WingR3.rotateAngleY = 0.77F;
		WingR3.rotateAngleZ = -WingR3.rotateAngleY;
		WingR6.rotateAngleX = WingR5.rotateAngleX = WingR4.rotateAngleX = WingR3.rotateAngleX;
		WingR6.rotateAngleY = WingR5.rotateAngleY = WingR4.rotateAngleY = WingR3.rotateAngleY;
		WingR6.rotateAngleZ = WingR5.rotateAngleZ = WingR4.rotateAngleZ = WingR3.rotateAngleZ;

		Skirt1.setRotateAngle(-0.7853982F, 0.2268928F, 0.8203047F);
		Skirt2.setRotateAngle(-0.7853982F, 0.9075712F, 0.8203047F);
		Skirt3.setRotateAngle(-0.7853982F, 1.308997F, 0.715585F);
		Skirt4.setRotateAngle(-0.7853982F, 1.832596F, 0.715585F);
		Skirt5.setRotateAngle(-0.7853982F, 2.181662F, 0.8203047F);
		Skirt6.setRotateAngle(-0.7853982F, 2.844887F, 0.8203047F);
		Skirt7.setRotateAngle(-0.7853982F, -2.941752F, 0.8203047F);
		Skirt8.setRotateAngle(-0.7853982F, -2.275037F, 0.8203047F);
		Skirt9.setRotateAngle(-0.7853982F, -1.885828F, 0.715585F);
		Skirt10.setRotateAngle(-0.7853982F, -1.33954F, 0.715585F);
		Skirt11.setRotateAngle(-0.7853982F, -0.9677851F, 0.8203047F);
		Skirt12.setRotateAngle(-0.7853982F, -0.299324F, 0.8203047F);

		int i = Modchu_ModelRenderer.ZYX;
		EarL1.setRotatePriority(i);
		EarL2.setRotatePriority(i);
		EarR1.setRotatePriority(i);
		EarR2.setRotatePriority(i);
		Prim.setRotatePriority(i);
		WingLroot.setRotatePriority(i);
		WingL2.setRotatePriority(i);
		WingRroot.setRotatePriority(i);
		WingR2.setRotatePriority(i);
		SideTailL2.setRotatePriority(i);
		SideTailR2.setRotatePriority(i);
		Tail2.setRotatePriority(i);
		Bust1.setRotatePriority(i);
		i = Modchu_ModelRenderer.YZX;
		WingL3.setRotatePriority(i);
		WingL4.setRotatePriority(i);
		WingL5.setRotatePriority(i);
		WingL6.setRotatePriority(i);
		WingR3.setRotatePriority(i);
		WingR4.setRotatePriority(i);
		WingR5.setRotatePriority(i);
		WingR6.setRotatePriority(i);
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

		actionPartsInit(f, f1);
	}

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

    @Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
		Bust1.setRotationPointLM(-2.0F, -3.5F, -1.5F);
		Bust2.setRotationPointLM(-2.0F, -2.6F, -0.5F);

		WingLroot.rotateAngleX=1.570796313F;
		WingRroot.rotateAngleX=1.570796313F;
		WingLroot.rotateAngleY=MathHelper.cos(f2 * 0.5F) * 0.22F + 0.35F;
		WingRroot.rotateAngleY=-WingLroot.rotateAngleY;
		Ahoge.rotateAngleY=MathHelper.cos(f2 * 0.2F + MathHelper.cos(f2*0.05F) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX=2.9F;

		if (getCapsValueBoolean(caps_aimedBow)) {
			WingLroot.rotateAngleX+= 0.5F;
			WingRroot.rotateAngleX+= 0.5F;
			WingLroot.rotateAngleY= -0.3F;
			WingRroot.rotateAngleY= 0.3F;
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
		Skirt1.setRotateAngle(-0.7853982F, 0.2268928F, 0.8203047F);
		Skirt2.setRotateAngle(-0.7853982F, 0.9075712F, 0.8203047F);
		Skirt3.setRotateAngle(-0.7853982F, 1.308997F, 0.715585F);
		Skirt4.setRotateAngle(-0.7853982F, 1.832596F, 0.715585F);
		Skirt5.setRotateAngle(-0.7853982F, 2.181662F, 0.8203047F);
		Skirt6.setRotateAngle(-0.7853982F, 2.844887F, 0.8203047F);
		Skirt7.setRotateAngle(-0.7853982F, -2.941752F, 0.8203047F);
		Skirt8.setRotateAngle(-0.7853982F, -2.275037F, 0.8203047F);
		Skirt9.setRotateAngle(-0.7853982F, -1.885828F, 0.715585F);
		Skirt10.setRotateAngle(-0.7853982F, -1.33954F, 0.715585F);
		Skirt11.setRotateAngle(-0.7853982F, -0.9677851F, 0.8203047F);
		Skirt12.setRotateAngle(-0.7853982F, -0.299324F, 0.8203047F);

		float f6 = -motionY;
		Skirt1.rotationPointY = -3F + f6;
		Skirt2.rotationPointY = -3F + f6;
		Skirt3.rotationPointY = -4F + f6;
		Skirt4.rotationPointY = -4F + f6;
		Skirt5.rotationPointY = -3F + f6;
		Skirt6.rotationPointY = -3F + f6;
		Skirt7.rotationPointY = -3F + f6;
		Skirt8.rotationPointY = -3F + f6;
		Skirt9.rotationPointY = -4F + f6;
		Skirt10.rotationPointY = -4F + f6;
		Skirt11.rotationPointY = -3F + f6;
		Skirt12.rotationPointY = -3F + f6;

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
	}

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"Skirt1", "Skirt2", "Skirt3", "Skirt4", "Skirt5",
    			"Skirt6", "Skirt7", "Skirt8", "Skirt9", "Skirt10",
    			"Skirt11", "Skirt12"
    	};
    	showPartsHideListadd(s);
    }
}
