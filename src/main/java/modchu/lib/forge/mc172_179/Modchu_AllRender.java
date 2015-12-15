package modchu.lib.forge.mc172_179;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IAllRender;
import modchu.lib.Modchu_Main;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class Modchu_AllRender extends Render implements Modchu_IAllRender {
	public static ConcurrentHashMap<Class, Modchu_Render> renderMap = new ConcurrentHashMap();

	public Modchu_AllRender(HashMap<String, Object> map) {
		super();
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
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

	public void superDoRender(Object entity, double par2, double par4, double par6, float par8, float par9) {
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
	protected void bindEntityTexture(Entity entity) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.bindEntityTexture(entity);
		else super.bindEntityTexture(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		super.bindEntityTexture((Entity) entity);
		return true;
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

	@Override
	protected void func_147906_a(Entity entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		Modchu_Render render = renderMapGet(entity);
		if (render != null) render.func_147906_a(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
		else super.func_147906_a(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	public void superFunc_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		super.func_147906_a((Entity) entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}
	// 180~
	@Override
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
	}
	// ~179
	public Object getRenderBlocks() {
		return null;
	}

}
