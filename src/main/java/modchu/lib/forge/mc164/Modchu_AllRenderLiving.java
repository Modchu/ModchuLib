package modchu.lib.forge.mc164;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IAllRenderLiving;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class Modchu_AllRenderLiving extends RenderLiving implements Modchu_IAllRenderLiving {
	public static ConcurrentHashMap<Class, Modchu_RenderLiving> renderMap = new ConcurrentHashMap();

	public Modchu_AllRenderLiving(HashMap<String, Object> map) {
		super(null, (Float)map.get("Float"));
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
		Modchu_Debug.mDebug("Modchu_AllRenderLiving init");
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.preRenderCallback(entityliving, f);
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.renderEquippedItems(entityliving, f);
	}

	@Override
	protected void func_110827_b(EntityLiving entityliving, double par2, double par4, double par6, float par8, float par9) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.func_110827_b(entityliving, par2, par4, par6, par8, par9);
	}

	@Override
	public void superRenderLeashedToEntityRope(Object entityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.func_110827_b((EntityLiving) entityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected boolean func_110813_b(EntityLivingBase entityLivingBase) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) return render.func_110813_b(entityLivingBase);
		return false;
	}

	public boolean superUsePassSpecialRender(Object entityLivingBase) {
		return super.func_110813_b((EntityLiving) entityLivingBase);
	}

	@Override
	public void doRenderLiving(EntityLiving entity, double d, double d1, double d2, float d3, float d4) {
		doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void doRenderLiving(EntityLivingBase entity, double d, double d1, double d2, float d3, float d4) {
		doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_AllRenderLiving doRender");
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) {
			setShadowSize(Modchu_AS.getFloat("Render", "shadowSize", render));
			//setShadowSize(0.0F);
			//render.setShadowSize(0.0F);
			render.doRender(entity, d, d1, d2, d3, d4);
		} else {
			//Modchu_Debug.mDebug("Modchu_AllRenderLiving doRender render == null !! entity="+entity);
			//Modchu_Debug.mDebug("Modchu_AllRenderLiving doRender render == null !! entity.getClass()="+entity.getClass());
		}
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRender(Object entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRender((Entity)entity, par2, par4, par6, par8, par9);
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
	protected void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) render.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
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

	@Override
	public void passSpecialRender(EntityLivingBase entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) render.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
		else super.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void superPassSpecialRender(Object entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		super.passSpecialRender((EntityLivingBase) entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	private Modchu_RenderLiving renderMapGet(Entity entity) {
		Object entity2 = Modchu_Main.getModchuCharacteristicObjectMaster(entity);
		//Modchu_Debug.mDebug("renderMapGet entity2.getClass()="+(entity2 != null ? entity2.getClass() : null));
		Class c = entity2 != null ? entity2.getClass() : entity.getClass();
		//Modchu_Debug.mDebug("renderMapGet c="+c);
		return renderMap.get(c);
	}

	public ModelBase getMainModel() {
		return mainModel;
	}

	public void setMainModel(Object model) {
		mainModel = (ModelBase) model;
	}

	public void setShadowSize(float f) {
		shadowSize = f;
	}

	public Object getRenderManager() {
		return renderManager;
	}

	public RenderBlocks getRenderBlocks() {
		return renderBlocks;
	}
	// 180~
	protected boolean canRenderName(EntityLiving entityLiving) {
		return false;
	}

	@Override
	public boolean superCanRenderName(Object entityLiving) {
		return false;
	}

	protected boolean addLayer(Object layerRenderer) {
		return false;
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return false;
	}

	protected boolean addLayer(EntityLiving entityLiving, Object layerRenderer) {
		return false;
	}

	protected boolean removeLayer(Object layerRenderer) {
		return false;
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return false;
	}

	protected boolean removeLayer(EntityLiving entityLiving, Object layerRenderer) {
		return false;
	}

	protected float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	@Override
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	protected float interpolateRotation(EntityLiving entityLiving, float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	public void transformHeldFull3DItemLayer() {
	}

	@Override
	public void superTransformHeldFull3DItemLayer() {
	}

	public void func_82422_c(EntityLiving entityLiving) {
	}

	protected boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		return false;
	}

	@Override
	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return false;
	}

	protected void unsetScoreTeamColor() {
	}

	@Override
	public void superUnsetScoreTeamColor() {
	}

	protected void func_180565_e(EntityLiving entityLiving) {
	}

	protected boolean setDoRenderBrightness(EntityLivingBase entityLivingBase, float p_177090_2_) {
		return false;
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {
		return false;
	}

	protected boolean setBrightness(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	@Override
	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	protected void unsetBrightness() {
	}

	@Override
	public void superUnsetBrightness() {
	}

	protected void func_177091_f(EntityLivingBase entityLivingBase) {
	}

	protected float getSwingProgress(EntityLivingBase entityLivingBase, float p_77040_2_) {
		return 0.0F;
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {
		return 0.0F;
	}

	protected void renderLayers(EntityLivingBase entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
	}

	@Override
	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
	}

	public void setRenderOutlines(boolean p_177086_1_) {
	}

	@Override
	public void superSetRenderOutlines(boolean p_177086_1_) {
	}

	public void setRenderOutlines(EntityLivingBase entityLivingBase, boolean p_177086_1_) {
	}

	public void renderName(Entity entity, double x, double y, double z) {
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
	}

}
