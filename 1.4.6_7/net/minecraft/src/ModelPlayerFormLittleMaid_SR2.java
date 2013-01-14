package net.minecraft.src;

public class ModelPlayerFormLittleMaid_SR2 extends ModelPlayerFormLittleMaid {

	public Modchu_ModelRenderer eyeR;
	public Modchu_ModelRenderer eyeL;

	public ModelPlayerFormLittleMaid_SR2()
	{
		this(0.0F);
	}

	public ModelPlayerFormLittleMaid_SR2(float f)
	{
		this(f, 0.0F);
	}

	public ModelPlayerFormLittleMaid_SR2(float f, float f1)
	{
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 32);
	}

	public ModelPlayerFormLittleMaid_SR2(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
		super.initModel(psize, pyoffset);

		// 追加パーツ
		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, psize);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
	}

	@Override
	public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float renderPartialTicks)
	{
		super.setLivingAnimationsLM(entityliving, f, f1, renderPartialTicks);

		float f3 = 0.0F;
		if ((entityliving instanceof EntityPlayer)
				&& !getaimedBow()) {
			EntityPlayer entityplayer = (EntityPlayer) entityliving;
			f3 = (float)entityplayer.ticksExisted + renderPartialTicks + ((float)entityplayer.entityId * 70);
		}

		if (LMM_EntityLittleMaid != null
				&& LMM_EntityLittleMaid.isInstance(entityliving)) {
			f3 = (float)entityliving.ticksExisted + renderPartialTicks + (Float) Modchu_Reflect.getFieldObject(Modchu_Reflect.getField(LMM_EntityLittleMaid, "entityIdFactor"), entityliving);
		}

		// 目パチ
		if( 0 > MathHelper.sin(f3 * 0.05F) + MathHelper.sin(f3 * 0.13F) + MathHelper.sin(f3 * 0.7F) + 2.55F) {
			eyeR.setVisible(true);
			eyeL.setVisible(true);
		} else {
			eyeR.setVisible(false);
			eyeL.setVisible(false);
		}
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, Entity entity)
	{
		super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);

		if (getaimedBow()) {
			eyeL.setVisible(true);
			eyeR.setVisible(false);
		}
	}

    @Override
    public void settingShowParts() {
    	super.settingShowParts();
    	//GUI パーツ表示・非表示初期設定
    	//前回の項目最後[partsNumber]から設定
    	overridePartsNumber = 0;
    	int k = getPartsNumber();
    	if(k < 0) k = 0;
    	if(getPartsSetFlag() == 1) {
    		String s[] = {
    				"eyeR", "eyeL"
    		};
    		setParts(s, k);
    		setPartsSetFlag(2);
    	}

    	//GUI パーツ表示・非表示反映
    	if(getShowModelFlag() == 0) {
    		showModelSettingReflects(k);
    		setShowModelFlag(1);
    	}
    }

    @Override
    public void showModelSettingReflects(int i) {
    	eyeR.setVisible(getGuiShowModel(i));
    	i++;
    	eyeL.setVisible(getGuiShowModel(i));
    	i++;
    	setPartsNumber(i);
    }

}