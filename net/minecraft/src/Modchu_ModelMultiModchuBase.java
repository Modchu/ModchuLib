package net.minecraft.src;

public abstract class Modchu_ModelMultiModchuBase extends Modchu_ModelMultiBaseV160 {

    /**
     * コンストラクタは全て継承させること
     */
    public Modchu_ModelMultiModchuBase() {
    	this(0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public Modchu_ModelMultiModchuBase(float psize) {
    	this(psize, 0.0F);
    }

    /**
     * コンストラクタは全て継承させること
     */
    public Modchu_ModelMultiModchuBase(float psize, float pyoffset) {
    	this(psize, pyoffset, 64, 32);
    }

    public Modchu_ModelMultiModchuBase(float psize, float pyoffset, int par3, int par4) {
    	super(psize, pyoffset, par3, par4);
    }

    @Override
    public void render(MMM_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
    	entityCaps = checkModelCaps(entityCaps);
    	render((Modchu_IModelCaps)entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, pIsRender);
    }

    @Override
    public void setLivingAnimations(MMM_IModelCaps entityCaps, float f, float f1, float f2) {
    	entityCaps = checkModelCaps(entityCaps);
    	setLivingAnimations((Modchu_IModelCaps)entityCaps, f, f1, f2);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	entityCaps = checkModelCaps(entityCaps);
    	setRotationAngles(f, f1, f2, f3, f4, f5, (Modchu_IModelCaps)entityCaps);
    }

    @Override
    public void renderItems(MMM_IModelCaps entityCaps) {
    	entityCaps = checkModelCaps(entityCaps);
    	renderItems((Modchu_IModelCaps)entityCaps);
    }

    @Override
    public float getHeight(MMM_IModelCaps pEntityCaps) {
    	pEntityCaps = checkModelCaps(pEntityCaps);
    	return getHeight((Modchu_IModelCaps)pEntityCaps);
    }

    @Override
    public float getWidth(MMM_IModelCaps pEntityCaps) {
    	pEntityCaps = checkModelCaps(pEntityCaps);
    	return getWidth((Modchu_IModelCaps)pEntityCaps);
    }

    @Override
    public void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
    	entityCaps = checkModelCaps(entityCaps);
    	setDefaultPause(f, f1, f2, f3, f4, f5, (Modchu_IModelCaps)entityCaps);
    }

    @Override
    public void renderFirstPersonHand(MMM_IModelCaps entityCaps) {
    	entityCaps = checkModelCaps(entityCaps);
    	renderFirstPersonHand((Modchu_IModelCaps)entityCaps);
    }

    @Override
    public void changeModel(MMM_IModelCaps entityCaps) {
    	entityCaps = checkModelCaps(entityCaps);
    	changeModel((Modchu_IModelCaps)entityCaps);
    }

    private Modchu_IModelCaps checkModelCaps(MMM_IModelCaps pEntityCaps) {
    	return (Modchu_IModelCaps) (pEntityCaps instanceof Modchu_IModelCaps ? pEntityCaps :
    		Modchu_ModelDataMaster.instance.getPlayerData(pEntityCaps));
    }

    public abstract void render(Modchu_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender);
    public abstract void setLivingAnimations(Modchu_IModelCaps entityCaps, float f, float f1, float f2);
    public abstract void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps);
    public abstract void setDefaultPause(float f, float f1, float f2, float f3, float f4, float f5, Modchu_IModelCaps entityCaps);
    public abstract void renderItems(Modchu_IModelCaps entityCaps);
    public abstract float getHeight(Modchu_IModelCaps pEntityCaps);
    public abstract float getWidth(Modchu_IModelCaps pEntityCaps);
    public abstract void renderFirstPersonHand(Modchu_IModelCaps entityCaps);
    public abstract void changeModel(Modchu_IModelCaps entityCaps);

}
