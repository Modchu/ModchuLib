package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_DogAngel2 extends MultiModel_DogAngel {

	public MultiModel_DogAngel2()
	{
		this(0.0F);
	}

	public MultiModel_DogAngel2(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_DogAngel2(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}

	public MultiModel_DogAngel2(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		((Modchu_ModelRenderer) Skirt).clearCubeList();
		Skirt1 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt1.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt1.setRotationPointLM(2.4F, -3.0F, -0.6F);

		Skirt2 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt2.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt2.setRotationPointLM(2F,-3F,-1.2F);

		Skirt3 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt3.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt3.setRotationPointLM(0F,-4F,0F);

		Skirt4 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt4.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt4.setRotationPointLM(0F,-4F,0F);

		Skirt5 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt5.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt5.setRotationPointLM(-2F,-3F,-1.2F);

		Skirt6 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt6.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt6.setRotationPointLM(-2.4F, -3F, -0.6F);

		Skirt7 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt7.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt7.setRotationPointLM(-2.4F,-3F,0.6F);

		Skirt8 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt8.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt8.setRotationPointLM(-2F,-3F,1.2F);

		Skirt9 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt9.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt9.setRotationPointLM(0F,-4F,0F);

		Skirt10 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt10.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt10.setRotationPointLM(0F,-4F,0F);

		Skirt11 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt11.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt11.setRotationPointLM(2F,-3F,1.2F);

		Skirt12 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt12.addBoxLM(0F, 0F, 0F,  12, 4, 4,f);
		Skirt12.setRotationPointLM(2.4F,-3F,0.6F);

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

		int i = Modchu_ModelRenderer.YZX;
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

		Skirt1.setScale(0.5F, 0.5F, 0.5F);
		Skirt2.setScale(0.5F, 0.5F, 0.5F);
		Skirt3.setScale(0.5F, 0.5F, 0.5F);
		Skirt4.setScale(0.5F, 0.5F, 0.5F);
		Skirt5.setScale(0.5F, 0.5F, 0.5F);
		Skirt6.setScale(0.5F, 0.5F, 0.5F);
		Skirt7.setScale(0.5F, 0.5F, 0.5F);
		Skirt8.setScale(0.5F, 0.5F, 0.5F);
		Skirt9.setScale(0.5F, 0.5F, 0.5F);
		Skirt10.setScale(0.5F, 0.5F, 0.5F);
		Skirt11.setScale(0.5F, 0.5F, 0.5F);
		Skirt12.setScale(0.5F, 0.5F, 0.5F);
	}
}
