package modchu.lib.forge.mc190_222;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityHelper;
import modchu.lib.Modchu_IAllRenderLiving;
import modchu.lib.Modchu_IEntityHelper;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public abstract class Modchu_AllRenderLiving extends RenderLiving implements Modchu_IAllRenderLiving {
	public static ConcurrentHashMap<Class, Modchu_RenderLiving> renderMap = new ConcurrentHashMap();

	public Modchu_AllRenderLiving(HashMap<String, Object> map) {
		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance), null, (Float)map.get("Float"));
		Modchu_Debug.mDebug("Modchu_AllRenderLiving init");
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.preRenderCallback(entityliving, f);
	}
/*
	@Override
	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.renderEquippedItems(entityliving, f);
	}
*/
	@Override
	protected void renderLeash(EntityLiving entityliving, double par2, double par4, double par6, float par8, float par9) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.renderLeash(entityliving, par2, par4, par6, par8, par9);
	}

	@Override
	public void superRenderLeashedToEntityRope(Object entityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.renderLeash((EntityLiving) entityLiving, par2, par4, par6, par8, par9);
	}
/*
	public boolean superUsePassSpecialRender(Object entityLivingBase) {
		return super.func_110813_b((EntityLiving) entityLivingBase);
	}
*/
	@Override
	public void doRender(EntityLiving entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_AllRenderLiving doRender");
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) render.doRender(entity, d, d1, d2, d3, d4);
		else {
			Modchu_Debug.mDebug1("Modchu_AllRenderLiving doRender render == null !! entity="+entity);
			Modchu_Debug.mDebug1("Modchu_AllRenderLiving doRender render == null !! entity.getClass()="+entity.getClass());
			Modchu_IEntityHelper modchu_IEntityHelper = (Modchu_IEntityHelper) entity;
			Modchu_EntityHelper.getInstance().unRegisterEntityDeadSetting(modchu_IEntityHelper);
		}
	}

	@Override
	public void superDoRenderLiving(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entity, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRender(Object entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRender((EntityLiving)entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) return render.getEntityTexture(entity);
		return null;
	}

	@Override
	protected void renderModel(EntityLivingBase entityLivingBase, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) render.renderModel(entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
		else super.renderModel(entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	}

	@Override
	public void superRenderModel(Object entityLivingBase, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		super.renderModel((EntityLivingBase) entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	}

	@Override
	protected void renderLivingAt(EntityLivingBase entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) render.renderLivingAt(entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
		else super.renderLivingAt(entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	public void superRenderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt((EntityLivingBase) entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	protected float handleRotationFloat(EntityLivingBase entityLivingBase, float p_77044_2_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.handleRotationFloat(entityLivingBase, p_77044_2_) : super.handleRotationFloat(entityLivingBase, p_77044_2_);
	}

	@Override
	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_) {
		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, p_77044_2_);
	}

	@Override
	protected float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.getDeathMaxRotation(entityLivingBase) : super.getDeathMaxRotation(entityLivingBase);
	}

	@Override
	public float superGetDeathMaxRotation(Object entityLivingBase) {
		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected int getColorMultiplier(EntityLivingBase entityLivingBase, float p_77030_2_, float p_77030_3_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.getColorMultiplier(entityLivingBase, p_77030_2_, p_77030_3_) : super.getColorMultiplier(entityLivingBase, p_77030_2_, p_77030_3_);
	}

	@Override
	public int superGetColorMultiplier(Object entityLivingBase, float p_77030_2_, float p_77030_3_) {
		return super.getColorMultiplier((EntityLivingBase) entityLivingBase, p_77030_2_, p_77030_3_);
	}

	public void passSpecialRender(EntityLiving entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
	}

	@Override
	public void superPassSpecialRender(Object entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		super.renderName((EntityLiving) entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	protected Modchu_RenderLiving renderMapGet(Entity entity) {
		Object entity2 = Modchu_Main.getModchuCharacteristicObjectMaster(entity);
		//Modchu_Debug.mDebug("renderMapGet entity2.getClass()="+(entity2 != null ? entity2.getClass() : null));
		Class c = entity2 != null ? entity2.getClass() : entity.getClass();
		//Modchu_Debug.mDebug("renderMapGet c="+c);
		return renderMap.get(c);
	}

	@Override
	public ModelBase getMainModel() {
		return mainModel;
	}

	public void setMainModel(Object model) {
		mainModel = (ModelBase) model;
	}

	public void setShadowSize(float f) {
		shadowSize = f;
	}
	// 180
	public boolean shouldRenderLiving(EntityLiving entityLiving, ICamera iCamera, double d, double d1, double d2) {
		return true;
	}

	@Override
	public boolean shouldRender(EntityLiving entity, ICamera iCamera, double d, double d1, double d2) {
		//Modchu_Debug.mDebug("Modchu_AllRenderLiving shouldRender");
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) render.shouldRender(entity, iCamera, d, d1, d2);
		return super.shouldRender(entity, iCamera, d, d1, d2);
	}
	// ~179
	public Object getRenderBlocks() {
		return null;
	}
	// 180~
	@Override
	protected boolean canRenderName(EntityLiving entityLiving) {
		Modchu_RenderLiving render = renderMapGet(entityLiving);
		return render != null ? render.canRenderName(entityLiving) : super.canRenderName(entityLiving);
	}

	@Override
	public boolean superCanRenderName(Object entityLiving) {
		return super.canRenderName((EntityLiving) entityLiving);
	}

	@Override
	public boolean addLayer(LayerRenderer layerRenderer) {
		return super.addLayer(layerRenderer);
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return super.addLayer((LayerRenderer) layerRenderer);
	}

	protected boolean addLayer(EntityLiving entityLiving, LayerRenderer layerRenderer) {
		Modchu_RenderLiving render = renderMapGet(entityLiving);
		return render != null ? render.addLayer(layerRenderer) : super.addLayer(layerRenderer);
	}

	@Override
	protected float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	@Override
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	protected float interpolateRotation(EntityLiving entityLiving, float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		Modchu_RenderLiving render = renderMapGet(entityLiving);
		return render != null ? render.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_) : super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		super.transformHeldFull3DItemLayer();
	}

	@Override
	public void superTransformHeldFull3DItemLayer() {
		super.transformHeldFull3DItemLayer();
	}

	public void transformHeldFull3DItemLayer(EntityLiving entityLiving) {
		Modchu_RenderLiving render = renderMapGet(entityLiving);
		if (render != null) render.transformHeldFull3DItemLayer();
		else super.transformHeldFull3DItemLayer();
	}

	@Override
	protected boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.setScoreTeamColor(entityLivingBase) : super.setScoreTeamColor(entityLivingBase);
	}

	@Override
	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return super.setScoreTeamColor((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void unsetScoreTeamColor() {
		super.unsetScoreTeamColor();
	}

	@Override
	public void superUnsetScoreTeamColor() {
		super.unsetScoreTeamColor();
	}

	protected void unsetScoreTeamColor(EntityLiving entityLiving) {
		Modchu_RenderLiving render = renderMapGet(entityLiving);
		if (render != null) render.unsetScoreTeamColor();
		else super.unsetScoreTeamColor();
	}

	@Override
	protected boolean setDoRenderBrightness(EntityLivingBase entityLivingBase, float p_177090_2_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.setDoRenderBrightness(entityLivingBase, p_177090_2_) : super.setDoRenderBrightness(entityLivingBase, p_177090_2_);
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {
		return super.setDoRenderBrightness((EntityLivingBase) entityLivingBase, p_177090_2_);
	}

	@Override
	protected boolean setBrightness(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.setBrightness(entityLivingBase, p_177092_2_, p_177092_3_) : super.setBrightness(entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return super.setBrightness((EntityLivingBase) entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	protected void unsetBrightness() {
		super.unsetBrightness();
	}

	@Override
	public void superUnsetBrightness() {
		super.unsetBrightness();
	}

	protected void unsetBrightness(EntityLivingBase entityLivingBase) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) render.unsetBrightness();
		else super.unsetBrightness();
	}

	@Override
	protected float getSwingProgress(EntityLivingBase entityLivingBase, float p_77040_2_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.getSwingProgress(entityLivingBase, p_77040_2_) : super.getSwingProgress(entityLivingBase, p_77040_2_);
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {
		return super.getSwingProgress((EntityLivingBase) entityLivingBase, p_77040_2_);
	}

	@Override
	protected void renderLayers(EntityLivingBase entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) render.renderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
		else super.renderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
	}

	@Override
	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		super.renderLayers((EntityLivingBase) entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
	}

	@Override
	public void setRenderOutlines(boolean p_177086_1_) {
		super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void superSetRenderOutlines(boolean p_177086_1_) {
		super.setRenderOutlines(p_177086_1_);
	}

	public void setRenderOutlines(EntityLivingBase entityLivingBase, boolean p_177086_1_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) render.setRenderOutlines(p_177086_1_);
		else super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void renderName(EntityLivingBase entity, double x, double y, double z) {
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) render.renderName(entity, x, y, z);
		else super.renderName(entity, x, y, z);
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
		super.renderName((EntityLivingBase) entity, x, y, z);
	}

	@Override
	public float prepareScale(EntityLivingBase entityLivingBase, float partialTicks) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		return render != null ? render.prepareScale(entityLivingBase, partialTicks) : super.prepareScale(entityLivingBase, partialTicks);
	}

	@Override
	public void doRenderShadowAndFire(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) render.doRenderShadowAndFire(entity, x, y, z, yaw, partialTicks);
		else super.doRenderShadowAndFire(entity, x, y, z, yaw, partialTicks);
	}

	@Override
	public void renderMultipass(Entity entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) render.renderMultipass(entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
		else super.renderMultipass(entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
	}

}
