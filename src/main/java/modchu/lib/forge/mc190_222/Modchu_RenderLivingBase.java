package modchu.lib.forge.mc190_222;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_IRenderLivingBase;
import modchu.lib.Modchu_IRenderLivingBaseMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public abstract class Modchu_RenderLivingBase extends RenderLivingBase implements Modchu_IRenderLivingBase {
	public Modchu_IRenderLivingBaseMaster master;

	public Modchu_RenderLivingBase(HashMap<String, Object> map) {
		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance), (ModelBase)(map.containsKey("Object") ? map.get("Object") : null), (Float) (map.containsKey("Float") ? map.get("Float") : 1.0F));
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
	protected boolean canRenderName(EntityLivingBase entityLivingBase) {
		if (master != null) return master.canRenderName(entityLivingBase);
		return false;
	}

	@Override
	public boolean superCanRenderName(Object entityLivingBase) {
		return super.canRenderName((EntityLiving) entityLivingBase);
	}

	@Override
	public void doRender(EntityLivingBase entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_RenderLivingBase doRender");
		if (master != null) master.doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLivingBase) entityLiving, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLivingBase) entity, d, d1, d2, d3, d4);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		//if (master != null) Modchu_Debug.mdDebug("Modchu_RenderLivingBase getEntityTexture "+((ResourceLocation) master.getEntityTexture(entity)));
		return master != null ? (ResourceLocation) master.getEntityTexture(entity) : null;
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

	public void setShadowOpaque(float f) {
		shadowOpaque = f;
	}

	public Object getEntityMaster(Object entity) {
		Object entity2 = Modchu_Reflect.invokeMethod(entity.getClass(), "getMaster", entity);
		return entity2 != null ? entity2 : entity;
	}
	// 180~
	@Override
	public boolean superShouldRender(Object entityLiving, Object iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return super.shouldRender((EntityLiving) entityLiving, (ICamera) iCamera, p_177104_3_, p_177104_5_, p_177104_7_);
	}

	@Override
	public boolean shouldRender(Entity entity, ICamera iCamera, double p_177071_3_, double p_177071_5_, double p_177071_7_) {
		return master != null ? master.shouldRender(entity, iCamera, p_177071_3_, p_177071_5_, p_177071_7_) : super.shouldRender(entity, iCamera, p_177071_3_, p_177071_5_, p_177071_7_);
	}
	// ~179
	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {
		if (master != null) master.renderEquippedItems(entityliving, f);
	}

	public Object getRenderBlocks() {
		return null;
	}

	@Override
	public boolean addLayer(LayerRenderer layerRenderer) {
		return master != null ? master.addLayer(layerRenderer) : super.addLayer(layerRenderer);
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return super.addLayer((LayerRenderer) layerRenderer);
	}

	@Override
	protected float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return master != null ? master.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_) : super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	@Override
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		if (master != null) master.transformHeldFull3DItemLayer();
		else super.transformHeldFull3DItemLayer();
	}

	@Override
	public void superTransformHeldFull3DItemLayer() {
		super.transformHeldFull3DItemLayer();
	}

	@Override
	protected boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		return master != null ? master.setScoreTeamColor(entityLivingBase) : super.setScoreTeamColor(entityLivingBase);
	}

	@Override
	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return super.setScoreTeamColor((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void unsetScoreTeamColor() {
		if (master != null) master.unsetScoreTeamColor();
		else super.unsetScoreTeamColor();
	}

	@Override
	public void superUnsetScoreTeamColor() {
		super.unsetScoreTeamColor();
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
	protected boolean setDoRenderBrightness(EntityLivingBase entityLivingBase, float p_177090_2_) {
		return master != null ? master.setDoRenderBrightness(entityLivingBase, p_177090_2_) : super.setDoRenderBrightness(entityLivingBase, p_177090_2_);
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {
		return super.setDoRenderBrightness((EntityLivingBase) entityLivingBase, p_177090_2_);
	}

	@Override
	protected boolean setBrightness(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return master != null ? master.setBrightness(entityLivingBase, p_177092_2_, p_177092_3_) : super.setBrightness(entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return super.setBrightness((EntityLivingBase) entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	protected void unsetBrightness() {
		if (master != null) master.unsetBrightness();
		else super.unsetBrightness();
	}

	@Override
	public void superUnsetBrightness() {
		super.unsetBrightness();
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
	protected float getSwingProgress(EntityLivingBase entityLivingBase, float p_77040_2_) {
		return master != null ? master.getSwingProgress(entityLivingBase, p_77040_2_) : super.getSwingProgress(entityLivingBase, p_77040_2_);
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {
		return super.getSwingProgress((EntityLivingBase) entityLivingBase, p_77040_2_);
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
	protected void renderLayers(EntityLivingBase entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		if (master != null) master.renderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
		else super.renderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
	}

	@Override
	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		super.renderLayers((EntityLivingBase) entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
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

	public void passSpecialRender(EntityLivingBase entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		if (master != null) master.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
		else super.renderName(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void superPassSpecialRender(Object entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		super.renderName((EntityLivingBase) entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void setRenderOutlines(boolean p_177086_1_) {
		if (master != null) master.setRenderOutlines(p_177086_1_);
		else super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void superSetRenderOutlines(boolean p_177086_1_) {
		super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void renderName(EntityLivingBase entity, double x, double y, double z) {
		if (master != null) master.renderName(entity, x, y, z);
		else super.renderName(entity, x, y, z);
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
		super.renderName((EntityLivingBase) entity, x, y, z);
	}

	@Override
	protected void renderEntityName(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
		if (master != null) master.renderEntityName(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_10_);
		else super.renderEntityName(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_10_);
	}

	@Override
	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
		super.renderEntityName((Entity) entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_10_);
	}

	@Override
	protected boolean bindEntityTexture(Entity entity) {
		return master != null ? master.bindEntityTexture(entity) : super.bindEntityTexture(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		return super.bindEntityTexture((Entity) entity);
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
	protected void renderLivingLabel(Entity entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		if (master != null) master.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
		else super.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		super.renderLivingLabel((Entity) entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public RenderManager getRenderManager() {
		return (RenderManager) (master != null ? master.getRenderManager() : super.getRenderManager());
	}

	@Override
	public RenderManager superGetRenderManager() {
		return super.getRenderManager();
	}

	@Override
	public void superPreRenderCallback(Object entityLivingBase, float par2) {
	}

	@Override
	public Object getRenderPassModel(int i) {
		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();
		return Modchu_Reflect.getFieldObject(layerArmorBase.getClass(), i == 0 ? "field_177189_c" : "field_177186_d", layerArmorBase);
	}

	@Override
	public void setRenderPassModel(Object model, Object model2) {
		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();
		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177189_c", layerArmorBase, model);
		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177186_d", layerArmorBase, model2);
	}

	@Override
	public Object getLayerArmorBase() {
		for (Object layerArmorBase : layerRenderers) {
			if (layerArmorBase instanceof LayerArmorBase) {
				return layerArmorBase;
			}
		}
		return null;
	}

	@Override
	public Object getLayerHeldItem() {
		for (Object layerHeldItem : layerRenderers) {
			if (layerHeldItem instanceof LayerHeldItem) {
				return layerHeldItem;
			}
		}
		return null;
	}

	@Override
	public Object getLayerCustomHead() {
		for (Object layerCustomHead : layerRenderers) {
			if (layerCustomHead instanceof LayerCustomHead) {
				return layerCustomHead;
			}
		}
		return null;
	}

	@Override
	public void setLayer(Class c, Object layer) {
		//Modchu_Debug.mDebug("Modchu_RenderLivingBase setLayer c="+c+" layer="+layer);
		if (layerRenderers != null
				&& !layerRenderers.isEmpty()
				&& c != null
				&& layer != null)
		for (int i = 0; i < layerRenderers.size(); i++) {
			Object o = layerRenderers.get(i);
			if (c.isInstance(o)) {
				layerRenderers.set(i, layer);
				return;
			}
		}
		addLayer((LayerRenderer<EntityLivingBase>) layer);
	}

	@Override
	public List getLayerList() {
		return layerRenderers;
	}

	@Override
	public Object superGetEntityTexture(Object entity) {
		return null;
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
	public void superSetRenderPassModel(Object modelBase) {
	}

	@Override
	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2) {
	}

	@Override
	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3) {
	}

	@Override
	public boolean superIsStaticEntity() {
		return false;
	}

	@Override
	public void superSetRenderManager(Object renderManager) {
	}

	@Override
	public void superUpdateIcons(Object iIconRegister) {
	}

	@Override
	public int setArmorModel(Object entity, int i, float f) {
		return master != null ? master.setArmorModel(entity, i, f) : -1;
	}

	@Override
	public int superSetArmorModel(Object entity, int i, float f) {
		return -1;
	}

	@Override
	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {
		return master != null ? master.setArmorModel(model, entityplayer, i, f, i2) : -1;
	}

	@Override
	public int superSetArmorModel(Object model, Object entityplayer, int i, float f, int i2) {
		return -1;
	}
	// ~152
	@Override
	public void superLoadTexture(String par1Str) {
	}

	@Override
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {
		return false;
	}
	// ~189
	@Override
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		superRenderEntityName(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_10_);
	}
	// 194~
	@Override
	public float prepareScale(EntityLivingBase entityLivingBase, float partialTicks) {
		return master != null ? master.prepareScale(entityLivingBase, partialTicks) : super.prepareScale(entityLivingBase, partialTicks);
	}

	@Override
	public float superPrepareScale(Object entityLivingBase, float partialTicks) {
		return super.prepareScale((EntityLivingBase) entityLivingBase, partialTicks);
	}

	@Override
	public int getTeamColor(Entity entity) {
		return master != null ? master.getTeamColor(entity) : super.getTeamColor(entity);
	}

	@Override
	public int superGetTeamColor(Object entity) {
		return super.getTeamColor((Entity) entity);
	}

	@Override
	public boolean isMultipass() {
		return master != null ? master.isMultipass() : super.isMultipass();
	}

	@Override
	public boolean superIsMultipass() {
		return super.isMultipass();
	}

	@Override
	public void renderMultipass(Entity entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
		if (master != null) master.renderMultipass(entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
		else super.renderMultipass(entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
	}

	@Override
	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
		super.renderMultipass((Entity) entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
	}

}
