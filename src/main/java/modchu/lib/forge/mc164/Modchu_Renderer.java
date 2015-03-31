package modchu.lib.forge.mc164;

import java.util.HashMap;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderer;
import modchu.lib.Modchu_IRendererLivingEntity;
import modchu.lib.Modchu_IRendererLivingEntityMaster;
import modchu.lib.Modchu_IRendererMaster;
import modchu.lib.Modchu_Main;

public class Modchu_Renderer extends Render implements Modchu_IRenderer {
	public Modchu_IRendererMaster master;

	public Modchu_Renderer(HashMap<String, Object> map) {
		super();
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
		//Modchu_Debug.lDebug("Modchu_Renderer init renderManager="+renderManager);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_Renderer init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRendererMaster ? (Modchu_IRendererMaster) instance : null;
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
	protected void bindEntityTexture(Entity entity) {
		if (master != null) master.bindEntityTexture(entity);
		else super.bindEntityTexture(entity);
	}

	public void superBindEntityTexture(Object entity) {
		super.bindEntityTexture((Entity) entity);
	}

	@Override
	protected void bindTexture(ResourceLocation resourceLocation) {
		if (master != null) master.bindTexture(resourceLocation);
		else super.bindTexture(resourceLocation);
	}

	public void superBindTexture(Object resourceLocation) {
		super.bindTexture((ResourceLocation) resourceLocation);
	}

	@Override
	public void setRenderManager(RenderManager renderManager) {
		if (master != null) master.setRenderManager(renderManager);
		else super.setRenderManager(renderManager);
	}

	public void superSetRenderManager(Object renderManager) {
		super.setRenderManager((RenderManager) renderManager);
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

	@Override
	public void updateIcons(IconRegister iconRegister) {
		if (master != null) master.updateIcons(iconRegister);
		else super.updateIcons(iconRegister);
	}

	public void superUpdateIcons(Object iconRegister) {
		super.updateIcons((IconRegister) iconRegister);
	}

}
