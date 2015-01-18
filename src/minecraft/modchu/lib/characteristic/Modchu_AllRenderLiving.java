package modchu.lib.characteristic;

import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.RenderManager;
import net.minecraft.src.ResourceLocation;

public class Modchu_AllRenderLiving extends RenderLiving {
	public static ConcurrentHashMap<Class, Modchu_RenderLiving> renderMap = new ConcurrentHashMap();

	public Modchu_AllRenderLiving(float f) {
		super(null, f);
		setRenderManager((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance));
		Modchu_Debug.mDebug("Modchu_AllRenderLiving init");
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.preRenderCallback(entityliving, f);
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.renderEquippedItems(entityliving, f);
	}

	protected void func_110827_b(EntityLiving entityliving, double par2, double par4, double par6, float par8, float par9) {
		Modchu_RenderLiving render = renderMapGet(entityliving);
		if (render != null) render.func_110827_b(entityliving, par2, par4, par6, par8, par9);
	}

	public void superRenderLeashedToEntityRope(Object entityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.func_110827_b((EntityLiving) entityLiving, par2, par4, par6, par8, par9);
	}

	protected boolean func_110813_b(EntityLivingBase entityLivingBase) {
		Modchu_RenderLiving render = renderMapGet(entityLivingBase);
		if (render != null) return render.func_110813_b(entityLivingBase);
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
		//Modchu_Debug.mDebug("Modchu_AllRenderLiving doRender");
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) render.doRender(entity, d, d1, d2, d3, d4);
		else {
			Modchu_Debug.mDebug("Modchu_AllRenderLiving doRender render == null !! entity="+entity);
			Modchu_Debug.mDebug("Modchu_AllRenderLiving doRender render == null !! entity.getClass()="+entity.getClass());
		}
	}

	public void superDoRenderLiving(EntityLiving entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entity, d, d1, d2, d3, d4);
	}

	public void superDoRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		Modchu_RenderLiving render = renderMapGet(entity);
		if (render != null) return (ResourceLocation) render.getEntityTexture(entity);
		return null;
	}

	private Modchu_RenderLiving renderMapGet(Entity entity) {
		Object entity2 = Modchu_Reflect.invokeMethod(entity.getClass(), "getMaster", entity);
		//Modchu_Debug.mDebug("renderMapGet entity2.getClass()="+(entity2 != null ? entity2.getClass() : null));
		Class c = entity2 != null ? entity2.getClass() : entity.getClass();
		//Modchu_Debug.mDebug("renderMapGet c="+c);
		return renderMap.get(c);
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

	public Object getRenderManager() {
		return renderManager;
	}

	public RenderBlocks getRenderBlocks() {
		return renderBlocks;
	}
}
