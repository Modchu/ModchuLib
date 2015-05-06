package modchu.lib.forge.mc172_179;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLiving;
import modchu.lib.Modchu_IRenderLivingMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

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
	public void doRender(EntityLiving entity, double d, double d1, double d2, float d3, float d4) {
		doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		if (master != null) master.preRenderCallback(entityliving, f);
	}

	@Override
	public void doRender(EntityLivingBase entity, double d, double d1, double d2, float d3, float d4) {
		doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_RenderLiving doRender");
		if (master != null) master.doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		//if (master != null) Modchu_Debug.mdDebug("Modchu_RenderLiving getEntityTexture "+((ResourceLocation) master.getEntityTexture(entity)));
		return master != null ? (ResourceLocation) master.getEntityTexture(entity) : null;
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

	public Object getEntityMaster(Object entity) {
		Object entity2 = Modchu_Reflect.invokeMethod(entity.getClass(), "getMaster", entity);
		return entity2 != null ? entity2 : entity;
	}
	// 180~
	public boolean shouldRenderLiving(EntityLiving entityLiving, ICamera iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return false;
	}

	@Override
	public void superFunc_177105_a(Object entityLiving, float p_177105_2_) {
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

	@Override
	public boolean superShouldRender(Object entityLiving, Object iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return false;
	}

	protected void renderLeash(EntityLiving entityliving, double d, double d1, double d2, float d3, float d4) {
	}

	@Override
	public void superRenderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
	}

	protected boolean canRenderName(EntityLivingBase entityLivingBase) {
		return false;
	}

	@Override
	public boolean superCanRenderName(Object entityLivingBase) {
		return false;
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

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return false;
	}

	protected boolean removeLayer(Object layerRenderer) {
		return false;
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return false;
	}

	protected float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	@Override
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return 0.0F;
	}

	public void func_82422_c() {
	}

	@Override
	public void superFunc_82422_c() {
	}

	protected boolean func_177088_c(EntityLivingBase entityLivingBase) {
		return false;
	}

	@Override
	public boolean superFunc_177088_c(Object entityLivingBase) {
		return false;
	}

	protected void func_180565_e() {
	}

	@Override
	public void superFunc_180565_e() {
	}

	protected boolean func_177090_c(EntityLivingBase entityLivingBase, float p_177090_2_) {
		return false;
	}

	@Override
	public boolean superFunc_177090_c(Object entityLivingBase, float p_177090_2_) {
		return false;
	}

	protected boolean func_177092_a(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	@Override
	public boolean superFunc_177092_a(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return false;
	}

	protected void func_177091_f() {
	}

	@Override
	public void superFunc_177091_f() {
	}

	protected float getSwingProgress(EntityLivingBase entityLivingBase, float p_77040_2_) {
		return 0.0F;
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {
		return 0.0F;
	}

	protected void func_177093_a(EntityLivingBase entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
	}

	@Override
	public void superFunc_177093_a(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
	}

	public void setRenderOutlines(boolean p_177086_1_) {
	}

	@Override
	public void superSetRenderOutlines(boolean p_177086_1_) {
	}

	public void renderName(Entity entity, double x, double y, double z) {
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
	}

	protected void func_177069_a(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public void superFunc_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}
/*
	protected boolean bindEntityTexture(Entity entity) {
		return false;
	}
*/
	@Override
	public boolean superBindEntityTexture(Object entity) {
		return false;
	}

	protected void renderLivingLabel(Entity entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

	@Override
	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

	public RenderManager func_177068_d() {
		return null;
	}

	@Override
	public RenderManager superFunc_177068_d() {
		return null;
	}

	@Override
	public Object getRenderPassModel(int i) {
		return getRenderPassModel();
	}

	@Override
	public void setRenderPassModel(Object model, Object model2) {
	}

	@Override
	public Object getLayerArmorBase() {
		return null;
	}

	@Override
	public void setLayerArmorBase(Object layerArmorBase) {
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
	public FontRenderer superGetFontRendererFromRenderManager() {
		return super.getFontRendererFromRenderManager();
	}

	@Override
	public void superPreRenderCallback(Object entityLivingBase, float par2) {
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
	}

	@Override
	public int superShouldRenderPass(Object entityliving, int i, float f) {
		return -1;
	}

	@Override
	public int superInheritRenderPass(Object entity, int par2, float par3) {
		return -1;
	}

	@Override
	public Object superGetMainModel() {
		return mainModel;
	}

	public Object getRenderPassModel() {
		return null;
	}

	@Override
	public boolean superUsePassSpecialRender(Object entityLivingBase) {
		return false;
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
		super.func_82408_c((AbstractClientPlayer) entityLivingBase, par2, par3);
	}

	@Override
	public boolean superFunc_110813_b(Object entityLivingBase) {
		return super.func_110813_b((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
		super.func_96449_a((AbstractClientPlayer) entityLivingBase, par2, par4, par6, par8Str, par9, par10);
	}

	@Override
	public boolean superIsStaticEntity() {
		return super.isStaticEntity();
	}

	@Override
	public void superSetRenderManager(Object renderManager) {
		super.setRenderManager((RenderManager) renderManager);
	}

	@Override
	public void superUpdateIcons(Object iIconRegister) {
		super.updateIcons((IIconRegister) iIconRegister);
	}

	@Override
	public void superFunc_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		super.func_147906_a((Entity) entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public boolean superFunc_130007_b(Object entityLiving) {
		return false;
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
