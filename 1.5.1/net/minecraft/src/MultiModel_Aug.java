package net.minecraft.src;

public class MultiModel_Aug extends MultiModel_SR2 {

	public Modchu_ModelRenderer sidetailUpperR;
	public Modchu_ModelRenderer sidetailUpperL;

	public Modchu_ModelRenderer shaggyB;
	public Modchu_ModelRenderer shaggyR;
	public Modchu_ModelRenderer shaggyL;

	public Modchu_ModelRenderer sensor1;
	public Modchu_ModelRenderer sensor2;
	public Modchu_ModelRenderer sensor3;
	public Modchu_ModelRenderer sensor4;

	public MultiModel_Aug() {
		this(0.0F);
	}

	public MultiModel_Aug(float f) {
		this(f, 0.0F);
	}

	public MultiModel_Aug(float f, float f1) {
		this(f, f1 , 64, 32);
	}

	public MultiModel_Aug(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
		super.initModel(psize, pyoffset);

		// 再構成パーツ
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailR);
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailL);
		SideTailR = new Modchu_ModelRenderer(this);
		SideTailR.setTextureOffset(46, 20).addBox(-1.5F, -0.5F, -1.0F, 2, 10, 2, psize);
		SideTailR.setRotationPoint(-5F, -7.8F, 1.9F);
		bipedHead.addChild(SideTailR);
		SideTailL = new Modchu_ModelRenderer(this);
		SideTailL.setTextureOffset(54, 20).addBox(0.5F, -0.5F, -1.0F, 2, 10, 2, psize);
		SideTailL.setRotationPoint(4F, -7.8F, 1.9F);
		bipedHead.addChild(SideTailL);

		// 増加パーツ
		shaggyB = new Modchu_ModelRenderer(this, 24, 0);
		shaggyB.addPlate(-5.0F, 0.0F, 0.0F, 10, 4, 4, psize);
		shaggyB.setRotationPointLM(0.0F, -1.0F, 4.0F);
		shaggyB.setRotateAngleX(0.4F);
		bipedHead.addChild(shaggyB);
		shaggyR = new Modchu_ModelRenderer(this, 34, 4);
		shaggyR.addPlate(0.0F, 0.0F, -5.0F, 10, 4, 1, psize);
		shaggyR.setRotationPointLM(4.0F, -1.0F, 0.0F);
		shaggyR.setRotateAngleZ(-0.4F);
		bipedHead.addChild(shaggyR);
		shaggyL = new Modchu_ModelRenderer(this, 24, 4);
		shaggyL.addPlate(0.0F, 0.0F, -5.0F, 10, 4, 5, psize);
		shaggyL.setRotationPointLM(-4.0F, -1.0F, 0.0F);
		shaggyL.setRotateAngleZ(0.4F);
		bipedHead.addChild(shaggyL);

		sensor1 = new Modchu_ModelRenderer(this, 0, 0);
		sensor1.addPlate(-8.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor1.setRotationPointLM(0.0F, -8.0F, 0.0F);
		bipedHead.addChild(sensor1);
		sensor2 = new Modchu_ModelRenderer(this, 0, 4);
		sensor2.addPlate(0.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor2.setRotationPointLM(0.0F, -8.0F, 0.0F);
		bipedHead.addChild(sensor2);
		sensor3 = new Modchu_ModelRenderer(this, 44, 0);
		sensor3.addPlate(0.0F, -7.0F, -4.0F, 4, 8, 1);
		sensor3.setRotationPointLM(0.0F, -8.0F, 0.0F);
		bipedHead.addChild(sensor3);
		sensor4 = new Modchu_ModelRenderer(this, 34, 0);
		sensor4.addPlate(0.0F, -4.0F, -10.0F, 10, 4, 1);
		sensor4.setRotationPointLM(0.0F, -8.0F, 0.0F);
		bipedHead.addChild(sensor4);

		sidetailUpperR = new Modchu_ModelRenderer(this, 52, 10);
		sidetailUpperR.addBoxLM(-4.0F, 0.0F, -1.0F, 4, 3, 2);
		sidetailUpperR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(sidetailUpperR);
		sidetailUpperL = new Modchu_ModelRenderer(this, 52, 15);
		sidetailUpperL.addBoxLM(0.0F, 0.0F, -1.0F, 4, 3, 2);
		sidetailUpperL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(sidetailUpperL);

		// 未使用パーツ
		setCapsValue(caps_visible, bipedHeadwear, false);
		setCapsValue(caps_visible, Tail, false);
		setCapsValue(caps_visible, ChignonB, false);
	}

	@Override
	public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float renderPartialTicks)
	{
		super.setLivingAnimationsLM(entityliving, f, f1, renderPartialTicks);

		float f3 = (float)entityliving.ticksExisted + renderPartialTicks + getCapsValueFloat(caps_entityIdFactor);
		float f4 = 0.0F;
		if (getCapsValueBoolean(caps_isLookSuger)) {
			f3 *= 8.0F;
			f4 = -0.2F;
		} else {
			f4 = (1F - (float)entityliving.health / 20F) * 0.5F;
		}
		float f5 = MathHelper.sin(f3 * 0.067F) * 0.05F - f4;
		float f6 = 40.0F / 57.29578F;
		sensor1.setRotateAngle(f5, -f6, f5);
		sensor2.setRotateAngle(-f5, f6, -f5);
		sensor3.setRotateAngle(MathHelper.sin(f3 * 0.067F) * 0.05F - 1.2F - f4, MathHelper.sin(f3 * 0.09F) * 0.4F, MathHelper.cos(f3 * 0.09F) * 0.2F);
		sensor4.setRotateAngle(MathHelper.sin(f3 * 0.067F) * 0.05F + f4, MathHelper.cos(f3 * 0.09F) * 0.5F, MathHelper.sin(f3 * 0.09F) * 0.2F);
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
		SideTailR.rotateAngleX = SideTailL.rotateAngleX = -bipedHead.rotateAngleX / 1.5F;
		float y = -8.0F;
		sensor1.rotationPointY = sensor2.rotationPointY = sensor3.rotationPointY = sensor4.rotationPointY = y;
		y = -1.0F;
		shaggyB.rotationPointY = shaggyR.rotationPointY = shaggyL.rotationPointY = y;
	}

	@Override
	public void defaultPartsSettingBefore() {
		super.defaultPartsSettingBefore();
		String[] s1 = {
				"sidetailUpperR", "sidetailUpperL"
		};
		String[] s2 = {
				"s_tailUR", "s_tailUL"
		};
		addShowPartsReneme(s1, s2);
	}
}
