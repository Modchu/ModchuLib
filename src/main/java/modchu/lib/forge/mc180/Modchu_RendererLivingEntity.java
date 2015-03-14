package modchu.lib.forge.mc180;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRendererLivingEntity;
import modchu.lib.Modchu_IRendererLivingEntityMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class Modchu_RendererLivingEntity extends RendererLivingEntity implements Modchu_IRendererLivingEntity {
	public Modchu_IRendererLivingEntityMaster master;

	public Modchu_RendererLivingEntity(HashMap<String, Object> map) {
		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance), (ModelBase)(map.containsKey("Object") ? map.get("Object") : null), (Float) (map.containsKey("Float") ? map.get("Float") : 1.0F));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_RendererLivingEntity init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRendererLivingEntityMaster ? (Modchu_IRendererLivingEntityMaster) instance : null;
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
		doRender((Entity) entity, d, d1, d2, d3, d4);
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_RenderLivingBase doRender");
		if (master != null) master.doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	public void superDoRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((Entity) entity, d, d1, d2, d3, d4);
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

	@Override
	public Object getRenderManager() {
		return renderManager;
	}

	public Object getEntityMaster(Object entity) {
		Object entity2 = Modchu_Reflect.invokeMethod(entity.getClass(), "getMaster", entity);
		return entity2 != null ? entity2 : entity;
	}
	// 180~
	public boolean superShouldRender(Object entityLiving, Object iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return super.shouldRender((EntityLiving) entityLiving, (ICamera) iCamera, p_177104_3_, p_177104_5_, p_177104_7_);
	}

	@Override
	protected boolean canRenderName(Entity entity) {
		return master != null ? master.canRenderName(entity) : super.canRenderName(entity);
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
	protected boolean addLayer(LayerRenderer layerRenderer) {
		return master != null ? master.addLayer(layerRenderer) : super.addLayer(layerRenderer);
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return super.addLayer((LayerRenderer) layerRenderer);
	}

	@Override
	protected boolean removeLayer(LayerRenderer layerRenderer) {
		return master != null ? master.removeLayer(layerRenderer) : super.removeLayer(layerRenderer);
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return super.removeLayer((LayerRenderer) layerRenderer);
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
	public void func_82422_c() {
		if (master != null) master.func_82422_c();
		else super.func_82422_c();
	}

	@Override
	public void superFunc_82422_c() {
		super.func_82422_c();
	}

	@Override
	protected boolean func_177088_c(EntityLivingBase entityLivingBase) {
		return master != null ? master.func_177088_c(entityLivingBase) : super.func_177088_c(entityLivingBase);
	}

	@Override
	public boolean superFunc_177088_c(Object entityLivingBase) {
		return super.func_177088_c((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void func_180565_e() {
		if (master != null) master.func_180565_e();
		else super.func_180565_e();
	}

	@Override
	public void superFunc_180565_e() {
		super.func_180565_e();
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
	protected boolean func_177090_c(EntityLivingBase entityLivingBase, float p_177090_2_) {
		return master != null ? master.func_177090_c(entityLivingBase, p_177090_2_) : super.func_177090_c(entityLivingBase, p_177090_2_);
	}

	@Override
	public boolean superFunc_177090_c(Object entityLivingBase, float p_177090_2_) {
		return super.func_177090_c((EntityLivingBase) entityLivingBase, p_177090_2_);
	}

	@Override
	protected boolean func_177092_a(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return master != null ? master.func_177092_a(entityLivingBase, p_177092_2_, p_177092_3_) : super.func_177092_a(entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	public boolean superFunc_177092_a(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return super.func_177092_a((EntityLivingBase) entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	protected void func_177091_f() {
		if (master != null) master.func_177091_f();
		else super.func_177091_f();
	}

	@Override
	public void superFunc_177091_f() {
		super.func_177091_f();
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
	protected void func_177093_a(EntityLivingBase entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		if (master != null) master.func_177093_a(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
		else super.func_177093_a(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
	}

	@Override
	public void superFunc_177093_a(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		super.func_177093_a((EntityLivingBase) entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
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
	public void setRenderOutlines(boolean p_177086_1_) {
		if (master != null) master.setRenderOutlines(p_177086_1_);
		else super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void superSetRenderOutlines(boolean p_177086_1_) {
		super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void renderName(Entity entity, double x, double y, double z) {
		if (master != null) master.renderName(entity, x, y, z);
		else super.renderName(entity, x, y, z);
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
		super.renderName((Entity) entity, x, y, z);
	}

	@Override
	protected void func_177069_a(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		if (master != null) master.func_177069_a(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
		else super.func_177069_a(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
	}

	@Override
	public void superFunc_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		super.func_177069_a((Entity) entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
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
	public RenderManager func_177068_d() {
		return (RenderManager) (master != null ? master.func_177068_d() : super.func_177068_d());
	}

	@Override
	public RenderManager superFunc_177068_d() {
		return super.func_177068_d();
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
	public void setLayerArmorBase(Object layerArmorBase) {
		if (layerRenderers != null
				&& !layerRenderers.isEmpty()) {
			for (int i = 0; i < layerRenderers.size(); i++) {
				Object o = layerRenderers.get(i);
				if (o instanceof LayerArmorBase) {
					layerRenderers.set(i, layerArmorBase);
					return;
				}
			}
		}
		layerRenderers.add(layerArmorBase);
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
	public void setLayerHeldItem(Object layerHeldItem) {
		if (layerRenderers != null
				&& !layerRenderers.isEmpty()) {
			for (int i = 0; i < layerRenderers.size(); i++) {
				Object o = layerRenderers.get(i);
				if (o instanceof LayerHeldItem) {
					layerRenderers.set(i, layerHeldItem);
					return;
				}
			}
		}
		layerRenderers.add(layerHeldItem);
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
	public void setLayerCustomHead(Object layerCustomHead) {
		if (layerRenderers != null
				&& !layerRenderers.isEmpty()) {
			for (int i = 0; i < layerRenderers.size(); i++) {
				Object o = layerRenderers.get(i);
				if (o instanceof LayerCustomHead) {
					layerRenderers.set(i, layerCustomHead);
					return;
				}
			}
		}
		layerRenderers.add(layerCustomHead);
	}
	
	@Override
	public List getLayerList() {
		return layerRenderers;
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

	@Override
	public Object getRenderPassModel() {
		return null;
	}

	@Override
	public void superSetRenderPassModel(Object modelBase) {
	}

	@Override
	public float superRenderSwingProgress(Object entityLivingBase, float par2) {
		return super.getSwingProgress((EntityLivingBase) entityLivingBase, par2);
	}

	@Override
	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2) {
	}

	@Override
	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3) {
	}

	@Override
	public boolean superFunc_110813_b(Object entityLivingBase) {
		return false;
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
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
	public void superFunc_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

}
