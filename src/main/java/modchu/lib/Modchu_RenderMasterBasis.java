package modchu.lib;

import java.util.HashMap;

public class Modchu_RenderMasterBasis implements Modchu_IRenderMaster {
	public Modchu_IRender base;

	public Modchu_RenderMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IRender) map.get("base");
	}

	@Override
	public void doRender(Object entity, double d0, double d1, double d2, float f, float f1) {
		base.superDoRender(entity, d0, d1, d2, f, f1);
	}

	@Override
	public Object getEntityTexture(Object entity) {
		return base.superGetEntityTexture(entity);
	}

	@Override
	public boolean bindEntityTexture(Object entity) {
		return base.superBindEntityTexture(entity);
	}

	@Override
	public void bindTexture(Object resourceLocation) {
		base.superBindTexture(resourceLocation);
	}

	@Override
	public void setRenderManager(Object renderManager) {
		base.superSetRenderManager(renderManager);
	}

	@Override
	public void doRenderShadowAndFire(Object entity, double par2, double par4, double par6, float par8, float par9) {
		base.superDoRenderShadowAndFire(entity, par2, par4, par6, par8, par9);
	}

	@Override
	public Object getFontRendererFromRenderManager() {
		return base.superGetFontRendererFromRenderManager();
	}

	@Override
	public void updateIcons(Object iconRegister) {
		base.superUpdateIcons(iconRegister);
	}
	// 172~
	@Override
	public boolean isStaticEntity() {
		return base.superIsStaticEntity();
	}

	@Override
	public void func_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		base.superFunc_147906_a(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}
	// 180~
	@Override
	public boolean shouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {
		return base.superShouldRender(entity, iCamera, camX, camY, camZ);
	}

	@Override
	public void renderName(Object entity, double x, double y, double z) {
		base.superRenderName(entity, x, y, z);
	}

	@Override
	public boolean canRenderName(Object entity) {
		return base.superCanRenderName(entity);
	}

	@Override
	public void renderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		base.superRenderOffsetLivingLabel(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
	}

	@Override
	public void renderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		base.superRenderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public Object getRenderManager() {
		return base.superGetRenderManager();
	}
	// ~152
	@Override
	public void loadTexture(String par1Str) {
		base.superLoadTexture(par1Str);
	}

	@Override
	public boolean loadDownloadableImageTexture(String par1Str, String par2Str) {
		return base.superLoadDownloadableImageTexture(par1Str, par2Str);
	}

	@Override
	public Object getEntityTexture(Object entity, int i) {
		return base.superGetEntityTexture(entity, i);
	}

	@Override
	public void renderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
		base.superRenderEntityName(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_10_);
	}

}
