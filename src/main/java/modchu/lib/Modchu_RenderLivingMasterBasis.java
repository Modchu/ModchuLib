package modchu.lib;

public class Modchu_RenderLivingMasterBasis extends Modchu_RendererLivingEntityMasterBasis implements Modchu_IRenderLivingMaster {
	public Modchu_IRenderLiving base;

	public Modchu_RenderLivingMasterBasis(Modchu_IRenderLiving modchu_IRenderLiving, Object[] o) {
		this((Modchu_IRendererLivingEntity) modchu_IRenderLiving, o);
		base = modchu_IRenderLiving;
	}

	public Modchu_RenderLivingMasterBasis(Modchu_IRendererLivingEntity modchu_IRenderLivingBase, Object[] o) {
		super(modchu_IRenderLivingBase, o);
	}

	@Override
	public void renderLeashedToEntityRope(Object entityliving, double d, double d1, double d2, float d3, float d4) {
		base.superRenderLeashedToEntityRope(entityliving, d, d1, d2, d3, d4);
	}

	@Override
	public void func_177105_a(Object entityLiving, float p_177105_2_) {
		base.superFunc_177105_a(entityLiving, p_177105_2_);
	}

	@Override
	public boolean usePassSpecialRender(Object entityLivingBase) {
		return base.superUsePassSpecialRender(entityLivingBase);
	}

	@Override
	public boolean func_130007_b(Object entityLiving) {
		return base.superFunc_130007_b(entityLiving);
	}

}
