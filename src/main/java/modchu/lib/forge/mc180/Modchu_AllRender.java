package modchu.lib.forge.mc180;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IAllRender;
import modchu.lib.Modchu_Main;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class Modchu_AllRender extends Render implements Modchu_IAllRender {
	public static ConcurrentHashMap<Class, Modchu_Render> renderMap = new ConcurrentHashMap();

	public Modchu_AllRender(HashMap<String, Object> map) {
		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance));
		Modchu_Debug.mDebug("Modchu_AllRender init");
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_AllRender doRender");
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.doRender(entity, d, d1, d2, d3, d4);
		else {
			Modchu_Debug.mDebug("Modchu_AllRender doRender render == null !! entity="+entity+" entity.getClass()="+(entity != null ? entity.getClass() : null));
		}
	}

	public void superDoRenderLiving(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entity, d, d1, d2, d3, d4);
	}

	public void superDoRender(Object entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRender((Entity)entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) return render.getEntityTexture(entity);
		return null;
	}

	private Modchu_Render renderMapGet(Entity entity) {
		Object entity2 = Modchu_Main.getModchuCharacteristicObjectMaster(entity);
		//Modchu_Debug.mDebug("renderMapGet entity2.getClass()="+(entity2 != null ? entity2.getClass() : null));
		Class c = entity2 != null ? entity2.getClass() : entity.getClass();
		//Modchu_Debug.mDebug("renderMapGet c="+c);
		return renderMap.get(c);
	}

	public void setShadowSize(float f) {
		shadowSize = f;
	}

	public Object getRenderManager() {
		return renderManager;
	}

	@Override
	protected boolean bindEntityTexture(Entity entity) {
		Modchu_Render render = renderMapGet(entity);
		return render != null ? render.bindEntityTexture(entity) : super.bindEntityTexture(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		return super.bindEntityTexture((Entity) entity);
	}

	@Override
	public void doRenderShadowAndFire(Entity entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
		else super.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}

	@Override
	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		super.doRenderShadowAndFire((Entity) entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}
	// 180~
	@Override
	protected void func_177069_a(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.func_177069_a(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
		else super.func_177069_a(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
	}

	@Override
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		super.func_177069_a((Entity) entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
	}

	@Override
	protected void renderLivingLabel(Entity entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
		else super.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		super.renderLivingLabel((Entity) entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	protected boolean canRenderName(Entity entity) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.canRenderName(entity);
		return super.canRenderName(entity);
	}

	@Override
	public boolean shouldRender(Entity entity, ICamera iCamera, double d, double d1, double d2) {
		//Modchu_Debug.mDebug("Modchu_AllRender shouldRender");
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.shouldRender(entity, iCamera, d, d1, d2);
		return super.shouldRender(entity, iCamera, d, d1, d2);
	}
	// ~179
	public Object getRenderBlocks() {
		return null;
	}
	// 180~
	@Override
	public void renderName(Entity entity, double x, double y, double z) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.renderName(entity, x, y, z);
		else super.renderName(entity, x, y, z);
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
		super.renderName((Entity) entity, x, y, z);
	}
	// 190~
	@Override
	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
		superRenderOffsetLivingLabel(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, 0.0F, p_177069_10_);
	}

}
