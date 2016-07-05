package modchu.lib;

import java.util.HashMap;

public class Modchu_RenderLivingMasterBasis extends Modchu_RendererLivingEntityMasterBasis implements Modchu_IRenderLivingMaster {
	public Modchu_IRenderLiving base;

	public Modchu_RenderLivingMasterBasis(HashMap<String, Object> map) {
		super(map);
		base = (Modchu_IRenderLiving) map.get("base");
	}

	@Override
	public void setLightmap(Object entityLiving, float p_177105_2_) {
		base.superSetLightmap(entityLiving, p_177105_2_);
	}

	public boolean usePassSpecialRender(Object entityLivingBase) {
		return false;
	}

	@Override
	public boolean func_130007_b(Object entityLiving) {
		return base.superFunc_130007_b(entityLiving);
	}

	@Override
	public void func_98190_a(Object entityLiving) {
		base.superFunc_98190_a(entityLiving);
	}

	@Override
	public void renderLeash(Object entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		base.superRenderLeash(entityLiving, x, y, z, entityYaw, partialTicks);
	}

}
