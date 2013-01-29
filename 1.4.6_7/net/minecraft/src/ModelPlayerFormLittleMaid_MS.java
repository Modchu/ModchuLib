package net.minecraft.src;

public class ModelPlayerFormLittleMaid_MS extends ModelPlayerFormLittleMaid_MS1
{

    public ModelPlayerFormLittleMaid_MS()
    {
        this(0.0F);
    }

    public ModelPlayerFormLittleMaid_MS(float f)
    {
        this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_MS(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 64);
	}

	public ModelPlayerFormLittleMaid_MS(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
	}

    @Override
    public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);
    	Goggles1A.setVisible(false);
    	Goggles2A.setVisible(false);
    	Goggles3A.setVisible(false);
    	GogglesRA.setVisible(false);
    	GogglesLA.setVisible(false);
    	if (getaimedBow()) {
    		eyeR.setVisible(false);
    		eyeL.setVisible(true);
    		Goggles1.setVisible(false);
    		Goggles2.setVisible(false);
    		Goggles3.setVisible(false);
    		GogglesR.setVisible(false);
    		GogglesL.setVisible(false);
    		Goggles1A.setVisible(true);
    		Goggles2A.setVisible(true);
    		Goggles3A.setVisible(true);
    		GogglesRA.setVisible(true);
    		GogglesLA.setVisible(true);
    	} else {
    		Goggles1.setVisible(true);
    		Goggles2.setVisible(true);
    		Goggles3.setVisible(true);
    		GogglesR.setVisible(true);
    		GogglesL.setVisible(true);
    		Goggles1A.setVisible(false);
    		Goggles2A.setVisible(false);
    		Goggles3A.setVisible(false);
    		GogglesRA.setVisible(false);
    		GogglesLA.setVisible(false);
    	}
    }

    @Override
    public void defaultPartsSettingAfter() {
    	//Cheek Default off
    	setGuiShowModel("Cheek", false);
    }
}
