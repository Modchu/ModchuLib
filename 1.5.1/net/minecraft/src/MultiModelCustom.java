package net.minecraft.src;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

public abstract class MultiModelCustom extends MultiModelBaseBiped {

	public Modchu_CustomModel customModel;
	public ModelRenderer dummy;

	public MultiModelCustom()
	{
		this(0.0F);
	}

	public MultiModelCustom(float f)
	{
		this(f, 0.0F);
	}

	public MultiModelCustom(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}

	public MultiModelCustom(float f, float f1, int i, int j) {
		super(f, f1, i, j);
		dummy = new ModelRenderer(this, 0, 0);
		dummy.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, f);
	}

	public void superrender(Entity entity, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		if (entity instanceof EntityLiving) {
			setRotationAngles(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);
			try {
				Modchu_Reflect.invokeMethod(customModel.mainModel.mainFrame.getClass(), "render", new Class[]{ float.class, EntityLiving.class }, customModel.mainModel.mainFrame, new Object[]{ f5, (EntityLiving)entity });
			} catch(Exception e) {
				customModel.mainModel.mainFrame.render(f5);
			}
			if (modelCaps != null) {
				renderStabilizer(entity, (Map) modelCaps.getCapsValue(caps_stabiliser), f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
			}
		}
	}

	@Override
	public void render(Entity entity, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		//Modchu_Debug.mDebug("MultiModelCustom render");
		customModel.render(entity, f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
	}

	@Override
	public void setLivingAnimations(EntityLiving entityliving, float f, float f1, float renderPartialTicks) {
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimations start");
		customModel.setLivingAnimations(entityliving, f, f1, renderPartialTicks);
		super.setLivingAnimations(entityliving, f, f1, renderPartialTicks);
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimations end");
	}

	@Override
	public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float renderPartialTicks) {
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimationsLM start");
		super.setLivingAnimationsLM(entityliving, f, f1, renderPartialTicks);
		customModel.setLivingAnimationsLM(entityliving, f, f1, renderPartialTicks);
		//Modchu_Debug.mDebug("MultiModelCustom setLivingAnimationsLM end");
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		customModel.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

    @Override
	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, Entity entity) {
		customModel.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);
	}

	@Override
	public void renderItems(EntityLiving pEntity, Render pRender) {
		customModel.renderItems(pEntity, pRender);
	}

	@Override
	public void showPartsInit() {
		customModel.showPartsInit();
	}

	@Override
	public void addShowParts(String[] s) {
		customModel.addShowParts(s);
	}

	@Override
	public void showPartsHideListadd(String[] s) {
		customModel.showPartsHideListadd(s);
	}

	@Override
	public void showPartsListRemove(String s) {
		customModel.showPartsListRemove(s);
	}

	@Override
	public void showPartsListRemove(String[] s) {
		customModel.showPartsListRemove(s);
	}

	@Override
	public void addShowPartsReneme(String[] s1, String[] s2) {
		customModel.addShowPartsReneme(s1, s2);
	}

	@Override
	public void addModelRendererMap(String[] s, Field[] model) {
		customModel.addModelRendererMap(s, model);
	}

	@Override
	public void defaultPartsSettingBefore() {
		customModel.defaultPartsSettingBefore();
	}

	@Override
	public void defaultPartsSettingAfter() {
		customModel.defaultPartsSettingAfter();
	}

	@Override
	public List<String> getShowPartsList() {
		return customModel.getShowPartsList();
	}

    @Override
    public List<String> getShowPartsHideList() {
    	return customModel.getShowPartsHideList();
    }

    @Override
    public HashMap<String, Field> getModelRendererMap() {
    	return customModel.getModelRendererMap();
    }
/*
    @Override
    public LinkedList<String> getTextureNameList() {
    	return customModel.getTextureNameList();
    }
*/
    @Override
    public LinkedList<String> getTextureList() {
    	return customModel.getTextureList();
    }

    @Override
    public HashMap<String, Boolean> getGuiParts() {
    	return customModel.getGuiParts();
    }

    @Override
    public HashMap<Integer, String> getShowPartsNemeList() {
    	return customModel.getShowPartsNemeList();
    }

    @Override
    public HashMap<String, String> getShowPartsReneme() {
    	return customModel.getShowPartsReneme();
    }

    @Override
    public void showModelSettingReflects() {
    	customModel.showModelSettingReflects();
    }

    @Override
    public void indexOfAllSetVisible(String s) {
    	customModel.indexOfAllSetVisible(s);
    }

    @Override
    public void indexOfAllSetVisible(String s, boolean b) {
    	customModel.indexOfAllSetVisible(s, b);
    }

    @Override
    public void setGuiParts(String s, boolean b) {
    	customModel.setGuiParts(s, b);
    }

    @Override
    public void actionInit(int i) {
    	customModel.actionInit(i);
    }

    @Override
    public void actionInit2() {
    	customModel.actionInit2();
    }

    @Override
    public void actionInit3() {
    	customModel.actionInit3();
    }

    @Override
    public void actionInit4() {
    	customModel.actionInit4();
    }

    @Override
    public void actionInit5() {
    	customModel.actionInit5();
    }

    @Override
    public void actionInit6() {
    	customModel.actionInit6();
    }

    @Override
    public void actionInit7() {
    	customModel.actionInit7();
    }

    @Override
    public void actionInit8() {
    	customModel.actionInit8();
    }

    @Override
    public void actionInit9() {
    	customModel.actionInit9();
    }

    @Override
    public void actionInit30() {
    	customModel.actionInit30();
    }

    @Override
    public void actionRelease(int i) {
    	customModel.actionRelease(i);
    }

    @Override
    public void actionRelease1() {
    	customModel.actionRelease1();
    }

    @Override
    public void actionRelease2() {
    	customModel.actionRelease2();
    }

    @Override
    public void actionRelease3() {
    	customModel.actionRelease3();
    }

    @Override
    public void actionRelease4() {
    	customModel.actionRelease4();
    }

    @Override
    public void actionRelease5() {
    	customModel.actionRelease5();
    }

    @Override
    public void actionRelease6() {
    	customModel.actionRelease6();
    }

    @Override
    public void actionRelease7() {
    	customModel.actionRelease7();
    }

    @Override
    public void actionRelease8() {
    	customModel.actionRelease8();
    }

    @Override
    public void actionRelease9() {
    	customModel.actionRelease9();
    }

    @Override
    public void actionRelease30() {
    	customModel.actionRelease30();
    }

    @Override
    public void action(Entity entity, int i) {
    	customModel.action(entity, i);
    }

    @Override
    public void action1(Entity entity) {
    	customModel.action1(entity);
    }

    @Override
    public void action2(Entity entity) {
    	customModel.action2(entity);
    }

    @Override
    public void action3(Entity entity) {
    	customModel.action3(entity);
    }

    @Override
    public void action4(Entity entity) {
    	customModel.action4(entity);
    }

    @Override
    public void action5(Entity entity) {
    	customModel.action5(entity);
    }

    @Override
    public void action6(Entity entity) {
    	customModel.action6(entity);
    }

    @Override
    public void action7(Entity entity) {
    	customModel.action7(entity);
    }

    @Override
    public void action8(Entity entity) {
    	customModel.action8(entity);
    }

    @Override
    public void action9(Entity entity) {
    	customModel.action9(entity);
    }

    @Override
    public void action30(Entity entity) {
    	customModel.action30(entity);
    }

    @Override
    public void syncModel(MultiModelBaseBiped model) {
    	Modchu_Debug.mDebug("syncModel bipedBody.rotateAngleZ="+bipedBody.rotateAngleZ);
    	customModel.syncModel(model);
    }

    @Override
    public float getHeight() {
    	if (customModel != null) return customModel.getHeight();
    	return 1.35F;
    }

    @Override
    public float getWidth() {
    	if (customModel != null) return customModel.getWidth();
    	return 0.5F;
    }

    @Override
    public float getyOffset() {
    	return customModel.getyOffset();
    }

    @Override
    public float getRidingHeight() {
    	return customModel.getRidingHeight();
    }

    @Override
    public float getRidingWidth() {
    	return customModel.getRidingWidth();
    }

    @Override
    public float getRidingyOffset() {
    	return customModel.getRidingyOffset();
    }

    @Override
    public double getMountedYOffset() {
    	return customModel.getMountedYOffset();
    }

    @Override
    public double getSittingyOffset() {
    	return customModel.getSittingyOffset();
    }

    @Override
    public double getSleepingyOffset() {
    	return customModel.getSleepingyOffset();
    }

    @Override
    public float ridingViewCorrection() {
    	return customModel.ridingViewCorrection();
    }

    @Override
    public float getModelScale() {
    	return customModel.getModelScale();
    }

    @Override
    public void equippedItemPositionFlower() {
    	customModel.equippedItemPositionFlower();
    }

    @Override
    public void setArmorBipedHeadShowModel(boolean b) {
    	customModel.setArmorBipedHeadShowModel(b);
    }

    @Override
    public void setArmorBipedBodyShowModel(boolean b) {
    	customModel.setArmorBipedBodyShowModel(b);
    }

    @Override
    public void setArmorBipedRightArmShowModel(boolean b) {
    	customModel.setArmorBipedRightArmShowModel(b);
    }

    @Override
    public void setArmorBipedLeftArmShowModel(boolean b) {
    	customModel.setArmorBipedLeftArmShowModel(b);
    }

    @Override
    public void setArmorBipedRightLegShowModel(boolean b) {
    	customModel.setArmorBipedRightLegShowModel(b);
    }

    @Override
    public void setArmorBipedLeftLegShowModel(boolean b) {
    	customModel.setArmorBipedLeftLegShowModel(b);
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    }

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		Object o;
		o = customModel.getCapsValue(pIndex, pArg);
		if (o != null) return o;
		return super.getCapsValue(pIndex, pArg);
	}

	public Object superGetCapsValue(int pIndex, Object ...pArg) {
		return super.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object ...pArg) {
		return customModel.setCapsValue(pIndex, pArg);
	}

	public boolean superSetCapsValue(int pIndex, Object ...pArg) {
		return super.setCapsValue(pIndex, pArg);
	}

	@Override
	public void changeModel(EntityLiving entity) {
		customModel.changeModel(entity);
	}

	@Override
	public void changeColor(EntityLiving entity) {
		customModel.changeColor(entity);
	}

	@Override
	public void initModel(float psize, float pyoffset) {
	}

	@Override
	public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		if (customModel != null) customModel.reset(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public float[] getArmorModelsSize() {
		if (customModel != null) return customModel.getArmorModelsSize();
		return new float[] {0.1F, 0.5F};
	}
}