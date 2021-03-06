package modchu.lib.modloader.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_IRender;
import modchu.lib.Modchu_IRenderMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.Entity;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.IconRegister;
import net.minecraft.src.Render;
import net.minecraft.src.RenderManager;
import net.minecraft.src.ResourceLocation;

public class Modchu_Render extends Render implements Modchu_IRender {
	public Modchu_IRenderMaster master;

	public Modchu_Render(HashMap<String, Object> map) {
		super();
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
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

	@Override
	public void superDoRender(Object entity, double d0, double d1, double d2, float f, float f1) {
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return (ResourceLocation) (master != null ? master.getEntityTexture(entity) : null);
	}

	@Override
	public ResourceLocation superGetEntityTexture(Object entity) {
		return null;
	}

	@Override
	protected void func_110777_b(Entity entity) {
		if (master != null) master.bindEntityTexture(entity);
		else super.func_110777_b(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		super.func_110777_b((Entity) entity);
		return true;
	}

	@Override
	protected void func_110776_a(ResourceLocation resourceLocation) {
		if (master != null) master.bindTexture(resourceLocation);
		else super.func_110776_a(resourceLocation);
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
		super.func_110776_a((ResourceLocation) resourceLocation);
	}

	@Override
	public void setRenderManager(RenderManager renderManager) {
		if (master != null) master.setRenderManager(renderManager);
		else super.setRenderManager(renderManager);
	}

	@Override
	public void superSetRenderManager(Object renderManager) {
		super.setRenderManager((RenderManager) renderManager);
	}

	@Override
	public void doRenderShadowAndFire(Entity entity, double par2, double par4, double par6, float par8, float par9) {
		if (master != null) master.doRenderShadowAndFire(entity, par2, par4, par6, par8, par9);
		else super.doRenderShadowAndFire(entity, par2, par4, par6, par8, par9);
	}

	@Override
	public void superDoRenderShadowAndFire(Object entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderShadowAndFire((Entity) entity, par2, par4, par6, par8, par9);
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
	public void updateIcons(IconRegister iconRegister) {
		if (master != null) master.updateIcons(iconRegister);
		else super.updateIcons(iconRegister);
	}

	@Override
	public void superUpdateIcons(Object iconRegister) {
		super.updateIcons((IconRegister) iconRegister);
	}
	// 172~179
	@Override
	public boolean superIsStaticEntity() {
		return false;
	}
	// 180~
	@Override
	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {
		return true;
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
	}

	@Override
	public boolean superCanRenderName(Object entity) {
		return false;
	}

	@Override
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

	@Override
	public Object superGetRenderManager() {
		return renderManager;
	}
	// ~152
	@Override
	public void superLoadTexture(String par1Str) {
	}

	@Override
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {
		return false;
	}
	// 190~
	@Override
	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
	}

	@Override
	public int superGetTeamColor(Object entity) {
		return -1;
	}

	@Override
	public boolean superIsMultipass() {
		return false;
	}

	@Override
	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
	}

}
