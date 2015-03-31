package modchu.lib;

import java.util.HashMap;

public class Modchu_RendererMasterBasis implements Modchu_IRendererMaster {
	public Modchu_IRenderer base;

	public Modchu_RendererMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IRenderer) map.get("base");
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
	public void bindEntityTexture(Object entity) {
		base.superBindEntityTexture(entity);
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

}
