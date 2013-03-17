package net.minecraft.src;

public class MultiModel_mahoro extends MultiModel {

    public Modchu_ModelRenderer Prim;
    public Modchu_ModelRenderer RibonUR;
    public Modchu_ModelRenderer RibonUL;
    public Modchu_ModelRenderer RibonBR;
    public Modchu_ModelRenderer RibonBL;
    public Modchu_ModelRenderer SensorR;
    public Modchu_ModelRenderer SensorL;
    public Modchu_ModelRenderer DropTail;
    public Modchu_ModelRenderer ShoulderR;
    public Modchu_ModelRenderer ShoulderL;
	public Modchu_ModelRenderer eyeR;
	public Modchu_ModelRenderer eyeL;


    public MultiModel_mahoro()
    {
        this(0.0F);
    }

    public MultiModel_mahoro(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_mahoro(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_mahoro(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	super.initModel(f, f1);
    	f1 += 8F;
    	Prim = new Modchu_ModelRenderer(this, 0, 1);
    	Prim.addBoxLM(0F, -3F, -2F, 1, 6, 1, f);
    	Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Prim.angleFirst = false;
    	Prim.setRotateAngleDegZ(90F); //deg
    	Prim.rotationPointY = -9F;
    	bipedHead.addChild(Prim);

    	RibonUR = new Modchu_ModelRenderer(this, 42, 19);
    	RibonUR.addBox(-4.5F, -2F, 4F, 4, 2, 1, f);
    	RibonUR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(RibonUR);
    	RibonUL = new Modchu_ModelRenderer(this, 42, 19);
    	RibonUL.setMirror(true);
    	RibonUL.addBox(0.5F, -2F, 4F, 4, 2, 1, f);
    	RibonUL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(RibonUL);
    	RibonBR = new Modchu_ModelRenderer(this, 42, 19);
    	RibonBR.addBox(-4.5F, -2F, 3.5F, 4, 2, 1, f);
    	RibonBR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	RibonBR.parentModel = bipedHead;
    	RibonBR.rotateAngleZ = -70F / 180F * 3.141526F;
    	bipedHead.addChild(RibonBR);
    	RibonBL = new Modchu_ModelRenderer(this, 42, 19);
    	RibonBL.setMirror(true);
    	RibonBL.addBox(0.5F, -2F, 3.5F, 4, 2, 1, f);
    	RibonBL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	RibonBL.rotateAngleZ = 70F / 180F * 3.141526F;
    	bipedHead.addChild(RibonBL);

    	SensorR = new Modchu_ModelRenderer(this, 24, 16);
    	SensorR.addBox(-2.5F, -0.5F, -2F, 3, 1, 1, f);
    	SensorR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SensorR);
    	SensorR.rotateAngleZ = -10F / 180F * 3.141526F;
    	SensorR.rotationPointY = -3.5F;
    	SensorR.rotationPointX = -4.0F;
    	SensorL = new Modchu_ModelRenderer(this, 24, 16);
    	SensorL.setMirror(true);
    	SensorL.addBox(-0.5F, -0.5F, -2F, 3, 1, 1, f);
    	SensorL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SensorL);
    	SensorL.rotateAngleZ = 10F / 180F * 3.141526F;
    	SensorL.rotationPointY = -3.5F;
    	SensorL.rotationPointX = 4.0F;

    	DropTail = new Modchu_ModelRenderer(this, 46, 22);
    	DropTail.addBox(-1.0F, -0.5F, 0.0F, 2, 9, 1, f);
    	DropTail.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(DropTail);
    	DropTail.rotationPointY = -1.0F;
    	DropTail.rotationPointZ = 3.7F;

    	ShoulderR = new Modchu_ModelRenderer(this, 52, 18);
    	ShoulderR.addBox(-5.0F, -0.5F, -2F, 2, 3, 4, f);
    	ShoulderR.setRotationPoint(0.0F, -3.0F, 0.0F);
    	bipedBody.addChild(ShoulderR);
    	ShoulderL = new Modchu_ModelRenderer(this, 52, 25);
    	ShoulderL.addBox(3.0F, -0.5F, -2F, 2, 3, 4, f);
    	ShoulderL.setRotationPoint(0.0F, -3.0F, 0.0F);
    	bipedBody.addChild(ShoulderL);

    	// –Ú
    	eyeR = new Modchu_ModelRenderer(this, 0, 16);
    	eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
    	eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeR);
    	eyeL = new Modchu_ModelRenderer(this, 4, 16);
    	eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
    	eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeL);

    	// •\Ž¦‚µ‚È‚¢
    	((Modchu_ModelRenderer) bipedHead).removeChild(Tail);
    	((Modchu_ModelRenderer) bipedHead).removeChild(SideTailR);
    	((Modchu_ModelRenderer) bipedHead).removeChild(SideTailL);
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

    	// “ÁŽêƒ‚[ƒVƒ‡ƒ“
    	SensorR.rotateAngleZ = bipedRightArm.rotateAngleX * 0.3F + mh_sin(f2 * 0.067F) * 0.1F + (-10F / 180F * 3.141526F);
    	SensorL.rotateAngleZ = -SensorR.rotateAngleZ;
    	//DropTail.rotateAngleX = 10F / 180F * 3.141526F - bipedHead.rotateAngleX;

		if (getCapsValueBoolean(caps_aimedBow)) {
			eyeL.showModel = true;
			eyeR.showModel = false;
		} else {
			if (0.0D > (double) (mh_sin(f2 * 0.1F) * 0.3F)
				+ Math.random() * 0.10000000149011612D
				+ 0.18000000715255737D) {
				eyeL.showModel = true;
				eyeR.showModel = true;
			} else {
				eyeL.showModel = false;
				eyeR.showModel = false;
			}
		}
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"SideTailR", "SideTailL", "Tail"
    	};
    	showPartsHideListadd(s);
    }
}
