package modchu.lib.modloader.mc162;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLiving;
import modchu.lib.Modchu_IRenderLivingMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.IconRegister;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.RenderManager;
import net.minecraft.src.ResourceLocation;

public class Modchu_RenderLiving extends RenderLiving implements Modchu_IRenderLiving {
	public Modchu_IRenderLivingMaster master;

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super((ModelBase) map.get("Object"), (Float) map.get("Float"));
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
		Modchu_Debug.lDebug("Modchu_RenderLiving init renderManager="+renderManager);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_RenderLiving init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRenderLivingMaster ? (Modchu_IRenderLivingMaster) instance : null;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		if (master != null) master.preRenderCallback(entityliving, f);
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {
		if (master != null) master.renderEquippedItems(entityliving, f);
	}

	protected void func_110827_b(EntityLiving entityliving, double d, double d1, double d2, float d3, float d4) {
		if (master != null) master.renderLeashedToEntityRope(entityliving, d, d1, d2, d3, d4);
	}

	public void superRenderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.func_110827_b((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	protected boolean func_110813_b(EntityLivingBase entityLivingBase) {
		if (master != null) return master.usePassSpecialRender(entityLivingBase);
		return false;
	}

	public boolean superUsePassSpecialRender(Object entityLivingBase) {
		return super.func_110813_b((EntityLiving) entityLivingBase);
	}

	@Override
	public void doRenderLiving(EntityLiving entity, double d, double d1, double d2, float d3, float d4) {
		doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	public void doRenderLiving(EntityLivingBase entity, double d, double d1, double d2, float d3, float d4) {
		doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_RenderLivingBase doRender");
		if (master != null) master.doRender(entity, d, d1, d2, d3, d4);
	}

	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRenderLiving((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	public void superDoRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		//if (master != null) Modchu_Debug.mdDebug("Modchu_RenderLivingBase getEntityTexture "+((ResourceLocation) master.getEntityTexture(entity)));
		return master != null ? (ResourceLocation) master.getEntityTexture(entity) : null;
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
	public void superPreRenderCallback(Object entityLivingBase, float par2) {
		super.preRenderCallback((EntityLivingBase) entityLivingBase, par2);
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
		super.renderEquippedItems((EntityLivingBase) entityliving, f);
	}

	@Override
	public int superShouldRenderPass(Object entityliving, int i, float f) {
		return super.shouldRenderPass((EntityLivingBase) entityliving, i, f);
	}

	@Override
	public int superInheritRenderPass(Object entity, int par2, float par3) {
		return super.inheritRenderPass((EntityLivingBase) entity, par2, par3);
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
	public float superRenderSwingProgress(Object entityLivingBase, float par2) {
		return super.renderSwingProgress((EntityLivingBase) entityLivingBase, par2);
	}

	@Override
	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2) {
		super.renderArrowsStuckInEntity((EntityLivingBase) entityLivingBase, par2);
	}

	@Override
	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3) {
		super.func_82408_c((EntityLivingBase) entityLivingBase, par2, par3);
	}

	@Override
	public boolean superFunc_110813_b(Object entityLivingBase) {
		return super.func_110813_b((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
		super.func_96449_a((EntityLivingBase) entityLivingBase, par2, par4, par6, par8Str, par9, par10);
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
		super.passSpecialRender((EntityLivingBase) entityLiving, d, d1, d2);
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
		super.bindEntityTexture((Entity) entity);
		return true;
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
		super.bindTexture((ResourceLocation) resourceLocation);
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
	public Object superFunc_177068_d() {
		return null;
	}

	@Override
	public void superRenderModel(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.renderModel((EntityLivingBase) entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public int superGetColorMultiplier(Object entity, float par2, float par3) {
		return super.getColorMultiplier((EntityLivingBase) entity, par2, par3);
	}

	@Override
	public void superRenderLivingLabel(Object entityplayer, String par2Str, double d, double d1, double d2, int i) {
		super.renderLivingLabel((EntityLivingBase) entityplayer, par2Str, d, d1, d2, i);
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
	public boolean superFunc_177088_c(Object entityLivingBase) {
		return false;
	}

	@Override
	public void superFunc_180565_e() {
	}

	@Override
	public boolean superFunc_177090_c(Object entityLivingBase, float p_177090_2_) {
		return false;
	}

	@Override
	public boolean superFunc_177092_a(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	@Override
	public void superFunc_177091_f() {
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {
		return 0.0F;
	}

	@Override
	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_) {
		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, p_77044_2_);
	}

	@Override
	public void superFunc_177093_a(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
	}

	@Override
	public float superGetDeathMaxRotation(Object entityLivingBase) {
		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean superCanRenderName(Object entityLivingBase) {
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
	public void superFunc_82422_c() {
	}

	@Override
	public void superRenderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt((EntityLivingBase) entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	public void superFunc_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public void superFunc_177105_a(Object entityLiving, float p_177105_2_) {
	}

	@Override
	public boolean superFunc_130007_b(Object entityLiving) {
		return super.func_130007_b((EntityLiving) entityLiving);
	}
	// ~152
	@Override
	public void superLoadTexture(String par1Str) {
	}

	@Override
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {
		return false;
	}
}
