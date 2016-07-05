package modchu.lib.modloader.mc162;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLivingBase;
import modchu.lib.Modchu_IRenderLivingBaseMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.ICamera;
import net.minecraft.src.IconRegister;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderManager;
import net.minecraft.src.RendererLivingEntity;
import net.minecraft.src.ResourceLocation;

public class Modchu_RenderLivingBase extends RendererLivingEntity implements Modchu_IRenderLivingBase {
	public Modchu_IRenderLivingBaseMaster master;

	public Modchu_RenderLivingBase(HashMap<String, Object> map) {
		super((ModelBase)(map.containsKey("Object") ? map.get("Object") : null), (Float) (map.containsKey("Float") ? map.get("Float") : 1.0F));
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
		Modchu_Debug.lDebug("Modchu_RenderLivingBase init renderManager="+renderManager);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_RenderLivingBase init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRenderLivingBaseMaster ? (Modchu_IRenderLivingBaseMaster) instance : null;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		if (master != null) master.preRenderCallback(entityliving, f);
	}

	@Override
	public void doRenderLiving(EntityLivingBase entity, double d, double d1, double d2, float d3, float d4) {
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

	public void superDoRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		//if (master != null) Modchu_Debug.mdDebug("Modchu_RenderLivingBase getEntityTexture "+((ResourceLocation) master.getEntityTexture(entity)));
		return master != null ? (ResourceLocation) master.getEntityTexture(entity) : null;
	}

	public void setShadowSize(float f) {
		shadowSize = f;
	}

	public void setShadowOpaque(float f) {
		shadowOpaque = f;
	}

	public Object getRenderManager() {
		return master != null ? master.getRenderManager() : renderManager;
	}

	@Override
	public Object superGetRenderManager() {
		return renderManager;
	}

	public Object getEntityMaster(Object entity) {
		Object entity2 = Modchu_Reflect.invokeMethod(entity.getClass(), "getMaster", entity);
		return entity2 != null ? entity2 : entity;
	}
	// 180~
	public boolean shouldRenderLiving(EntityLiving entityLiving, ICamera iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return false;
	}

	public void func_177105_a(EntityLiving entityLiving, float p_177105_2_) {
	}

	protected boolean canRenderName(EntityLiving entityLiving) {
		return false;
	}

	protected boolean canRenderName(Entity entity) {
		return false;
	}

	public boolean shouldRender(Entity entity, ICamera iCamera, double p_177071_3_, double p_177071_5_, double p_177071_7_) {
		return false;
	}

	public boolean superShouldRender(Object entityLiving, Object iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return false;
	}

	protected void renderLeash(EntityLiving entityliving, double d, double d1, double d2, float d3, float d4) {
	}

	public void superRenderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
	}

	public ModelBase getMainModel() {
		return mainModel;
	}

	public void setMainModel(Object model) {
		mainModel = (ModelBase) model;
	}

	protected boolean addLayer(Object layerRenderer) {
		return false;
	}

	public boolean superAddLayer(Object layerRenderer) {
		return false;
	}

	protected boolean removeLayer(Object layerRenderer) {
		return false;
	}

	public boolean superRemoveLayer(Object layerRenderer) {
		return false;
	}

	protected float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	public void transformHeldFull3DItemLayer() {
	}

	public void superTransformHeldFull3DItemLayer() {
	}

	protected boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		return false;
	}

	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return false;
	}

	protected void unsetScoreTeamColor() {
	}

	public void superUnsetScoreTeamColor() {
	}

	protected boolean func_177090_c(EntityLivingBase entityLivingBase, float p_177090_2_) {
		return false;
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {
		return false;
	}

	protected boolean setBrightness(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	protected void unsetBrightness() {
	}

	public void superUnsetBrightness() {
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

	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
	}

	public void setRenderOutlines(boolean p_177086_1_) {
	}

	public void superSetRenderOutlines(boolean p_177086_1_) {
	}

	public void renderName(Entity entity, double x, double y, double z) {
	}

	public void superRenderName(Object entity, double x, double y, double z) {
	}

	protected void renderOffsetLivingLabel(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}
/*
	protected boolean bindEntityTexture(Entity entity) {
		return false;
	}
*/
	public boolean superBindEntityTexture(Object entity) {
		return true;
	}

	protected void renderLivingLabel(Entity entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

	@Override
	public Object getRenderPassModel(int i) {
		return getRenderPassModel();
	}

	@Override
	public void setRenderPassModel(Object model, Object model2) {
		setRenderPassModel((ModelBase) model);
	}

	@Override
	public Object getLayerArmorBase() {
		return null;
	}

	@Override
	public Object getLayerHeldItem() {
		return null;
	}

	@Override
	public Object getLayerCustomHead() {
		return null;
	}

	@Override
	public void setLayer(Class c, Object layer) {
	}

	@Override
	public List getLayerList() {
		return null;
	}
	// ~179
	@Override
	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {
		if (master != null) master.renderEquippedItems(entityliving, f);
	}

	public Object getRenderBlocks() {
		return null;
	}

	@Override
	protected void renderModel(EntityLivingBase entityLivingBase, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		if (master != null) master.renderModel(entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
		else super.renderModel(entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	}

	@Override
	public void superRenderModel(Object entityLivingBase, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		super.renderModel((EntityLivingBase) entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	}

	@Override
	protected void renderLivingAt(EntityLivingBase entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		if (master != null) master.renderLivingAt(entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
		else super.renderLivingAt(entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	public void superRenderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt((EntityLivingBase) entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	protected void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		if (master != null) master.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	protected float handleRotationFloat(EntityLivingBase entityLivingBase, float p_77044_2_) {
		return master != null ? master.handleRotationFloat(entityLivingBase, p_77044_2_) : super.handleRotationFloat(entityLivingBase, p_77044_2_);
	}

	@Override
	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_) {
		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, p_77044_2_);
	}

	@Override
	protected float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
		return master != null ? master.getDeathMaxRotation(entityLivingBase) : super.getDeathMaxRotation(entityLivingBase);
	}

	@Override
	public float superGetDeathMaxRotation(Object entityLivingBase) {
		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected int getColorMultiplier(EntityLivingBase entityLivingBase, float p_77030_2_, float p_77030_3_) {
		return master != null ? master.getColorMultiplier(entityLivingBase, p_77030_2_, p_77030_3_) : super.getColorMultiplier(entityLivingBase, p_77030_2_, p_77030_3_);
	}

	@Override
	public int superGetColorMultiplier(Object entityLivingBase, float p_77030_2_, float p_77030_3_) {
		return super.getColorMultiplier((EntityLivingBase) entityLivingBase, p_77030_2_, p_77030_3_);
	}

	@Override
	public void passSpecialRender(EntityLivingBase entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		if (master != null) master.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
		else super.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void superPassSpecialRender(Object entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		super.passSpecialRender((EntityLivingBase) entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void bindTexture(ResourceLocation resourceLocation) {
		if (master != null) master.bindTexture(resourceLocation);
		else super.bindTexture(resourceLocation);
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
		super.bindTexture((ResourceLocation) resourceLocation);
	}

	@Override
	public void doRenderShadowAndFire(Entity entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		if (master != null) master.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
		else super.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}

	@Override
	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		super.doRenderShadowAndFire((Entity) entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}

	@Override
	public FontRenderer getFontRendererFromRenderManager() {
		return (FontRenderer) (master != null ? master.getFontRendererFromRenderManager() : super.getFontRendererFromRenderManager());
	}

	@Override
	public Object superGetFontRendererFromRenderManager() {
		return super.getFontRendererFromRenderManager();
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
	public int superSetArmorModel(Object object, Object entity, int i, float f, int j) {
		return -1;
	}

	@Override
	public void superRenderEquippedItems(Object entityliving, float f) {
		super.renderEquippedItems((EntityLivingBase) entityliving, f);
	}

	@Override
	public Object superGetMainModel() {
		return mainModel;
	}

	public Object getRenderPassModel() {
		return renderPassModel;
	}

	@Override
	public void setRenderPassModel(ModelBase modelBase) {
		if (master != null) master.setRenderPassModel(modelBase);
		else super.setRenderPassModel(modelBase);
	}

	public void superSetRenderPassModel(Object modelBase) {
		super.setRenderPassModel((ModelBase) modelBase);
	}

	@Override
	protected float renderSwingProgress(EntityLivingBase entityLivingBase, float par2) {
		return master != null ? master.getSwingProgress(entityLivingBase, par2) : super.renderSwingProgress(entityLivingBase, par2);
	}

	public float superRenderSwingProgress(Object entityLivingBase, float par2) {
		return super.renderSwingProgress((EntityLivingBase) entityLivingBase, par2);
	}

	@Override
	protected void renderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float par2) {
		if (master != null) master.renderArrowsStuckInEntity(entityLivingBase, par2);
		else super.renderArrowsStuckInEntity(entityLivingBase, par2);
	}

	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2) {
		super.renderArrowsStuckInEntity((EntityLivingBase) entityLivingBase, par2);
	}

	@Override
	protected int inheritRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return master != null ? master.inheritRenderPass(entityLivingBase, par2, par3) : super.inheritRenderPass(entityLivingBase, par2, par3);
	}

	public int superInheritRenderPass(Object entityLivingBase, int par2, float par3) {
		return super.inheritRenderPass((EntityLivingBase) entityLivingBase, par2, par3);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return master != null ? master.shouldRenderPass(entityLivingBase, par2, par3) : super.shouldRenderPass(entityLivingBase, par2, par3);
	}

	public int superShouldRenderPass(Object entityLivingBase, int par2, float par3) {
		return super.shouldRenderPass((EntityLivingBase) entityLivingBase, par2, par3);
	}

	@Override
	protected void func_82408_c(EntityLivingBase entityLivingBase, int par2, float par3) {
		if (master != null) master.func_82408_c(entityLivingBase, par2, par3);
		else super.func_82408_c(entityLivingBase, par2, par3);
	}

	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3) {
		super.func_82408_c((EntityLivingBase) entityLivingBase, par2, par3);
	}

	@Override
	protected boolean func_110813_b(EntityLivingBase entityLivingBase) {
		return master != null ? master.canRenderName(entityLivingBase) : super.func_110813_b(entityLivingBase);
	}

	@Override
	public boolean superCanRenderName(Object entityLivingBase) {
		return super.func_110813_b((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void func_96449_a(EntityLivingBase entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
		if (master != null) master.func_96449_a(entityLivingBase, par2, par4, par6, par8Str, par9, par10);
		else super.func_96449_a(entityLivingBase, par2, par4, par6, par8Str, par9, par10);
	}

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
	// ~164
	@Override
	protected void renderLivingLabel(EntityLivingBase entityLivingBase, String par2Str, double par3, double par5, double par7, int par9) {
		if (master != null) master.renderLivingLabel(entityLivingBase, par2Str, par3, par5, par7, par9);
		else super.renderLivingLabel(entityLivingBase, par2Str, par3, par5, par7, par9);
	}
	// ~152
	@Override
	public void superLoadTexture(String par1Str) {
	}

	@Override
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {
		return false;
	}
	// 190~
	@Override
	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
	}

	@Override
	public void superFunc_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public int superGetTeamColor(Object entity) {
		return -1;
	}

	@Override
	public boolean superIsMultipass() {
		return false;
	}

	@Override
	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
	}

	@Override
	public int setArmorModel(Object entity, int i, float f) {
		return -1;
	}

	@Override
	public int superSetArmorModel(Object entity, int i, float f) {
		return -1;
	}

	@Override
	public float superPrepareScale(Object entityLivingBase, float partialTicks) {
		return 0.0F;
	}

}
