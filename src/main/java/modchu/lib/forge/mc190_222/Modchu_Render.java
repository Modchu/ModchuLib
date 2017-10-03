package modchu.lib.forge.mc190_222;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRender;
import modchu.lib.Modchu_IRenderMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class Modchu_Render extends Render implements Modchu_IRender {
	public Modchu_IRenderMaster master;

	public Modchu_Render(HashMap<String, Object> map) {
		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance));
		//Modchu_Debug.lDebug("Modchu_Renderer init renderManager="+renderManager);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_Renderer init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRenderMaster ? (Modchu_IRenderMaster) instance : null;
		//Modchu_Debug.lDebug("Modchu_Renderer init master="+master);
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		//Modchu_Debug.mDebug("Modchu_Renderer doRender master="+master);
		if (master != null) master.doRender(entity, d0, d1, d2, f, f1);
	}

	public void superDoRender(Object entity, double d0, double d1, double d2, float f, float f1) {
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return (ResourceLocation) (master != null ? master.getEntityTexture(entity) : null);
	}

	public ResourceLocation superGetEntityTexture(Object entity) {
		return null;
	}

	@Override
	protected boolean bindEntityTexture(Entity entity) {
		return master != null ? master.bindEntityTexture(entity) : super.bindEntityTexture(entity);
	}

	public boolean superBindEntityTexture(Object entity) {
		return super.bindEntityTexture((Entity) entity);
	}

	@Override
	public void bindTexture(ResourceLocation resourceLocation) {
		if (master != null) master.bindTexture(resourceLocation);
		else super.bindTexture(resourceLocation);
	}

	public void superBindTexture(Object resourceLocation) {
		super.bindTexture((ResourceLocation) resourceLocation);
	}

	public void superSetRenderManager(Object renderManager) {
	}

	@Override
	public void doRenderShadowAndFire(Entity entity, double par2, double par4, double par6, float par8, float par9) {
		if (master != null) master.doRenderShadowAndFire(entity, par2, par4, par6, par8, par9);
		else super.doRenderShadowAndFire(entity, par2, par4, par6, par8, par9);
	}

	public void superDoRenderShadowAndFire(Object entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderShadowAndFire((Entity) entity, par2, par4, par6, par8, par9);
	}

	@Override
	public FontRenderer getFontRendererFromRenderManager() {
		return (FontRenderer) (master != null ? master.getFontRendererFromRenderManager() : super.getFontRendererFromRenderManager());
	}

	public FontRenderer superGetFontRendererFromRenderManager() {
		return super.getFontRendererFromRenderManager();
	}

	public void superUpdateIcons(Object iconRegister) {
	}
	// 180~
	@Override
	public boolean shouldRender(Entity entity, ICamera iCamera, double camX, double camY, double camZ) {
		return master != null ? master.shouldRender(entity, iCamera, camX, camY, camZ) : super.shouldRender(entity, iCamera, camX, camY, camZ);
	}

	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {
		return super.shouldRender((Entity) entity, (ICamera) iCamera, camX, camY, camZ);
	}

	@Override
	protected void renderName(Entity entity, double x, double y, double z) {
		if (master != null) master.renderName(entity, x, y, z);
		else super.renderName(entity, x, y, z);
	}

	public void superRenderName(Object entity, double x, double y, double z) {
		super.renderName((Entity) entity, x, y, z);
	}

	@Override
	protected boolean canRenderName(Entity entity) {
		return master != null ? master.canRenderName(entity) : super.canRenderName(entity);
	}

	public boolean superCanRenderName(Object entity) {
		return super.canRenderName((Entity) entity);
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
	protected void renderLivingLabel(Entity entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		if (master != null) master.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
		else super.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		super.renderLivingLabel((Entity) entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public RenderManager getRenderManager() {
		return (RenderManager) (master != null ? master.getRenderManager() : super.getRenderManager());
	}

	public RenderManager superGetRenderManager() {
		return super.getRenderManager();
	}

	// 172~179
	public boolean superIsStaticEntity() {
		return false;
	}

	public void superFunc_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
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
	// 190~
	@Override
	public int superGetTeamColor(Object entity) {
		return super.getTeamColor((Entity) entity);
	}

	@Override
	public boolean superIsMultipass() {
		return super.isMultipass();
	}

	@Override
	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
		super.renderMultipass((Entity) entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
	}

}
