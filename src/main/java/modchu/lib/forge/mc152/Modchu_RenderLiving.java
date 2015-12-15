package modchu.lib.forge.mc152;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLiving;
import modchu.lib.Modchu_IRenderLivingMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class Modchu_RenderLiving extends RenderLiving implements Modchu_IRenderLiving {
	public Modchu_IRenderLivingMaster master;

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super((ModelBase) (map != null && map.containsKey("Object") ? map.get("Object") : null), (Float) (map != null && map.containsKey("Float") ? map.get("Float") : 1.0F));
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
		Modchu_Debug.lDebug("Modchu_RenderLiving init renderManager="+renderManager);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_RenderLiving init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRenderLivingMaster ? (Modchu_IRenderLivingMaster) instance : null;
	}

	@Override
	protected void preRenderCallback(EntityLiving entityliving, float f) {
		if (master != null) master.preRenderCallback(entityliving, f);
	}

	@Override
	protected void renderEquippedItems(EntityLiving entityliving, float f) {
		if (master != null) master.renderEquippedItems(entityliving, f);
	}

	protected void func_110827_b(EntityLiving entityliving, double d, double d1, double d2, float d3, float d4) {
		if (master != null) master.renderLeashedToEntityRope(entityliving, d, d1, d2, d3, d4);
	}

	@Override
	public void superRenderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
	}

	protected boolean func_110813_b(EntityLiving EntityLiving) {
		if (master != null) return master.usePassSpecialRender(EntityLiving);
		return false;
	}

	@Override
	public boolean superUsePassSpecialRender(Object EntityLiving) {
		return true;
	}

	@Override
	public void doRenderLiving(EntityLiving entity, double d, double d1, double d2, float d3, float d4) {
		doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_RenderLivingBase doRender");
		if (master != null) master.doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRenderLiving((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	protected String getEntityTexture(Entity entity) {
		//if (master != null) Modchu_Debug.mdDebug("Modchu_RenderLivingBase getEntityTexture "+((String) master.getEntityTexture(entity)));
		return master != null ? (String) master.getEntityTexture(entity) : null;
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

	public void setShadowOpaque(float f) {
		shadowOpaque = f;
	}

	public Object getRenderManager() {
		return renderManager;
	}

	public RenderBlocks getRenderBlocks() {
		return renderBlocks;
	}

	public Object getEntityMaster(Object entity) {
		Object entity2 = Modchu_Reflect.invokeMethod(entity.getClass(), "getMaster", entity);
		return entity2 != null ? entity2 : entity;
	}

	@Override
	public void superPreRenderCallback(Object EntityLiving, float par2) {
		super.preRenderCallback((EntityLiving) EntityLiving, par2);
	}

	@Override
	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {
		return -1;
	}

	@Override
	public Object superGetEntityTexture(Object entity) {
		return null;
	}

	@Override
	public Object superGetEntityTexture(Object entity, int i) {
		return null;
	}

	@Override
	public int superSetArmorModel(Object object, Object entity, int i, float f, int j) {
		return -1;
	}

	@Override
	public void superRenderEquippedItems(Object entityliving, float f) {
		super.renderEquippedItems((EntityLiving) entityliving, f);
	}

	@Override
	public int superShouldRenderPass(Object entityliving, int i, float f) {
		return super.shouldRenderPass((EntityLiving) entityliving, i, f);
	}

	@Override
	public int superInheritRenderPass(Object entity, int par2, float par3) {
		return super.inheritRenderPass((EntityLiving) entity, par2, par3);
	}

	@Override
	public Object superGetMainModel() {
		return mainModel;
	}

	public Object getRenderPassModel() {
		return renderPassModel;
	}

	@Override
	public void renderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
	}

	@Override
	public void superSetRenderPassModel(Object modelBase) {
		super.setRenderPassModel((ModelBase) modelBase);
	}

	@Override
	public float superRenderSwingProgress(Object EntityLiving, float par2) {
		return super.renderSwingProgress((EntityLiving) EntityLiving, par2);
	}

	@Override
	public void superRenderArrowsStuckInEntity(Object EntityLiving, float par2) {
		super.renderArrowsStuckInEntity((EntityLiving) EntityLiving, par2);
	}

	@Override
	public void superFunc_82408_c(Object EntityLiving, int par2, float par3) {
		super.func_82408_c((EntityLiving) EntityLiving, par2, par3);
	}

	@Override
	public boolean superFunc_110813_b(Object EntityLiving) {
		return false;
	}

	@Override
	public void superFunc_96449_a(Object EntityLiving, double par2, double par4, double par6, String par8Str, float par9, double par10) {
		super.func_96449_a((EntityLiving) EntityLiving, par2, par4, par6, par8Str, par9, par10);
	}

	@Override
	public boolean superIsStaticEntity() {
		return false;
	}

	@Override
	public void superSetRenderManager(Object renderManager) {
		super.setRenderManager((RenderManager) renderManager);
	}

	@Override
	public void superUpdateIcons(Object iIconRegister) {
		super.updateIcons((IconRegister) iIconRegister);
	}

	@Override
	public void superFunc_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}
	// ~164
	@Override
	public void superPassSpecialRender(Object entityLiving, double d, double d1, double d2) {
		super.passSpecialRender((EntityLiving) entityLiving, d, d1, d2);
	}

	@Override
	public Object getRenderPassModel(int i) {
		return renderPassModel;
	}

	@Override
	public void setRenderPassModel(Object model, Object model2) {
	}

	@Override
	public Object getLayerArmorBase() {
		return null;
	}

	@Override
	public void setLayerArmorBase(Object layerBipedArmor) {
	}

	@Override
	public Object getLayerHeldItem() {
		return null;
	}

	@Override
	public void setLayerHeldItem(Object layerHeldItem) {
	}

	@Override
	public Object getLayerCustomHead() {
		return null;
	}

	@Override
	public void setLayerCustomHead(Object layerCustomHead) {
	}

	@Override
	public List getLayerList() {
		return null;
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		return false;
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
	}

	@Override
	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		super.doRenderShadowAndFire((Entity) entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}

	@Override
	public Object superGetFontRendererFromRenderManager() {
		return super.getFontRendererFromRenderManager();
	}

	@Override
	public Object superGetRenderManager() {
		return renderManager;
	}

	@Override
	public void superRenderModel(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.renderModel((EntityLiving) entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public int superGetColorMultiplier(Object entity, float par2, float par3) {
		return super.getColorMultiplier((EntityLiving) entity, par2, par3);
	}

	@Override
	public void superRenderLivingLabel(Object entityplayer, String par2Str, double d, double d1, double d2, int i) {
		super.renderLivingLabel((EntityLiving) entityplayer, par2Str, d, d1, d2, i);
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return false;
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return false;
	}

	@Override
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	@Override
	public boolean superSetScoreTeamColor(Object EntityLiving) {
		return false;
	}

	@Override
	public void superUnsetScoreTeamColor() {
	}

	@Override
	public boolean superSetDoRenderBrightness(Object EntityLiving, float p_177090_2_) {
		return false;
	}

	@Override
	public boolean superSetBrightness(Object EntityLiving, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	@Override
	public void superUnsetBrightness() {
	}

	@Override
	public float superGetSwingProgress(Object EntityLiving, float p_77040_2_) {
		return 0.0F;
	}

	@Override
	public float superHandleRotationFloat(Object EntityLiving, float p_77044_2_) {
		return super.handleRotationFloat((EntityLiving) EntityLiving, p_77044_2_);
	}

	@Override
	public void superRenderLayers(Object EntityLiving, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
	}

	@Override
	public float superGetDeathMaxRotation(Object EntityLiving) {
		return super.getDeathMaxRotation((EntityLiving) EntityLiving);
	}

	@Override
	public boolean superCanRenderName(Object EntityLiving) {
		return false;
	}

	@Override
	public void superSetRenderOutlines(boolean p_177086_1_) {
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
	}

	@Override
	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {
		return false;
	}

	@Override
	public void superTransformHeldFull3DItemLayer() {
	}

	@Override
	public void superRenderLivingAt(Object EntityLiving, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt((EntityLiving) EntityLiving, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	public void superRotateCorpse(Object EntityLiving, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.rotateCorpse((EntityLiving) EntityLiving, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public void superFunc_177105_a(Object entityLiving, float p_177105_2_) {
	}

	@Override
	public boolean superFunc_130007_b(Object entityLiving) {
		return false;
	}
	// ~152
	@Override
	public void superLoadTexture(String par1Str) {
		super.loadTexture(par1Str);
	}

	@Override
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {
		return super.loadDownloadableImageTexture(par1Str, par2Str);
	}
}
