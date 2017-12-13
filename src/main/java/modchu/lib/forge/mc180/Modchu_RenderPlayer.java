package modchu.lib.forge.mc180;import java.util.HashMap;import java.util.List;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IRenderPlayer;import modchu.lib.Modchu_IRenderPlayerMaster;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.AbstractClientPlayer;import net.minecraft.client.gui.FontRenderer;import net.minecraft.client.model.ModelBase;import net.minecraft.client.model.ModelPlayer;import net.minecraft.client.renderer.culling.ICamera;import net.minecraft.client.renderer.entity.RenderManager;import net.minecraft.client.renderer.entity.RenderPlayer;import net.minecraft.client.renderer.entity.layers.LayerArmorBase;import net.minecraft.client.renderer.entity.layers.LayerCustomHead;import net.minecraft.client.renderer.entity.layers.LayerHeldItem;import net.minecraft.client.renderer.entity.layers.LayerRenderer;import net.minecraft.entity.Entity;import net.minecraft.entity.EntityLivingBase;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.util.ResourceLocation;import net.minecraftforge.client.event.RenderPlayerEvent;import net.minecraftforge.common.MinecraftForge;public class Modchu_RenderPlayer extends RenderPlayer implements Modchu_IRenderPlayer {	public Modchu_IRenderPlayerMaster master;	public Modchu_RenderPlayer(HashMap<String, Object> map) {		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance), map.containsKey("boolean") ? (Boolean)map.get("boolean") : false);		//Modchu_Debug.lDebug("Modchu_RenderPlayer init");		map.put("base", this);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.lDebug("Modchu_RenderPlayer init instance="+instance);		master = instance instanceof Modchu_IRenderPlayerMaster ? (Modchu_IRenderPlayerMaster) instance : null;	}	@Override	public int setArmorModel(Object entity, int i, float f) {		return setArmorModel(null, entity, i, f, 0);	}	@Override	public int superSetArmorModel(Object entity, int i, float f) {		return -1;	}	@Override	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {		if (master != null); else return -1;		String modchuLibEventName = "modchu_RenderPlayerSetArmorModel";		boolean isCanceled = false;		boolean flag = false;		Object[] o = null;		int i3 = -1;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ model, entityplayer, i, f, i2 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (!isCanceled					&& o != null					&& o.length > 1) {				model = o[1];				if (o.length > 2) entityplayer = o[2];				if (o.length > 3) i = Modchu_CastHelper.Int(o[3]);				if (o.length > 4) f = Modchu_CastHelper.Float(o[4]);				if (o.length > 5) i2 = Modchu_CastHelper.Int(o[5]);				if (o.length > 6) {					i3 = Modchu_CastHelper.Int(o[6]);					flag = true;				}			}		}		int i1 = !isCanceled ? master.setArmorModel(model, entityplayer, i, f, i2) : -1;		return flag ? i3 : i1;	}	@Override	public int superSetArmorModel(Object model, Object entityplayer, int i, float f, int i2) {		return -1;	}	@Override	protected void preRenderCallback(AbstractClientPlayer entityliving, float f) {		float f1 = 0.9375F;		float f2 = 0.9375F;		float f3 = 0.9375F;		String modchuLibEventName = "modchu_RenderPlayerPreRenderCallback";		boolean isCanceled = false;		Object[] o = null;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityliving, f });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (!isCanceled					&& o != null					&& o.length > 1) {				f = Modchu_CastHelper.Float(o[1]);				//if (o.length > 2) f2 = Modchu_CastHelper.Float(o[2]);				//if (o.length > 3) f3 = Modchu_CastHelper.Float(o[3]);			}		}		if (master != null				&& !isCanceled) master.renderScale(entityliving, f);	}	@Override	public void superPreRenderCallback(Object abstractClientPlayer, float f) {		super.preRenderCallback((AbstractClientPlayer) abstractClientPlayer, f);	}	@Override	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {		preRenderCallback((AbstractClientPlayer) par1EntityLiving, par2);	}	@Override	public void func_180596_a(AbstractClientPlayer entity, double d, double d1, double d2, float f, float f1) {		if (master != null); else return;		String modchuLibEventName = "modchu_RenderPlayerDoRender";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entity, d, d1, d2, f, f1 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entity = (AbstractClientPlayer) o[1];				if (o.length > 2) d = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) d1 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) f = Modchu_CastHelper.Float(o[4]);				if (o.length > 5) f1 = Modchu_CastHelper.Float(o[5]);			}		}		if (!isCanceled) master.doRender(entity, d, d1, d2, f, f1);	}	@Override	public void superDoRenderLiving(Object entity, double d, double d1, double d2, float f, float f1) {		super.func_180596_a((AbstractClientPlayer) entity, d, d1, d2, f, f1);	}	@Override	public void passSpecialRender(EntityLivingBase par1EntityLiving, double par2, double par4, double par6) {		String modchuLibEventName = "modchu_RenderPlayerPassSpecialRender";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLiving, par2, par4, par6 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLiving = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) par4 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) par6 = Modchu_CastHelper.Double(o[4]);			}		}		if (!isCanceled				&& master != null) master.passSpecialRender(par1EntityLiving, par2, par4, par6);	}	@Override	public void func_177138_b(AbstractClientPlayer abstractClientPlayer) {		renderFirstPersonArm(abstractClientPlayer, 2);	}	public void renderFirstPersonArm(EntityPlayer entityplayer, int i) {		//olddays導入時に2以外のint付きで呼ばれる。		if (master != null); else return;		String modchuLibEventName = "modchu_RenderPlayerRenderFirstPersonArm";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, i });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (EntityPlayer) o[1];				if (o.length > 2) i = Modchu_CastHelper.Int(o[2]);			}		}		if (!isCanceled) master.renderFirstPersonArm(entityplayer, i);	}	@Override	public void superRenderFirstPersonArm(Object entityplayer, int i) {		super.func_177138_b((AbstractClientPlayer) entityplayer);	}	@Override	public void func_177139_c(AbstractClientPlayer abstractClientPlayer) {		renderFirstPersonLeftArm(abstractClientPlayer, 2);	}	public void renderFirstPersonLeftArm(EntityPlayer entityplayer, int i) {		if (master != null); else return;		String modchuLibEventName = "modchu_RenderPlayerRenderFirstPersonLeftArm";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, i });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (EntityPlayer) o[1];				if (o.length > 2) i = Modchu_CastHelper.Int(o[2]);			}		}		if (!isCanceled) master.renderFirstPersonLeftArm(entityplayer, i);	}	@Override	public void superFunc_177139_c(Object abstractClientPlayer) {		super.func_177139_c((AbstractClientPlayer) abstractClientPlayer);	}	public boolean isActivatedForPlayer(AbstractClientPlayer entityplayer) {		if (master != null); else return false;		String modchuLibEventName = "modchu_RenderPlayerIsActivatedForPlayer";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (AbstractClientPlayer) o[1];			}		}		return !isCanceled ? master.isActivatedForPlayer(entityplayer) : false;	}	@Override	public boolean superIsActivatedForPlayer(Object entityplayer) {		return false;	}	@Override	protected void renderLivingLabel(Entity entityplayer, String par2Str, double d, double d1, double d2, int i) {		String modchuLibEventName = "modchu_RenderPlayerRenderLivingLabel";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, par2Str, d, d1, d2, i });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (Entity) o[1];				if (o.length > 2) par2Str = Modchu_CastHelper.String(o[2]);				if (o.length > 3) d = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) d1 = Modchu_CastHelper.Double(o[4]);				if (o.length > 5) d2 = Modchu_CastHelper.Double(o[5]);				if (o.length > 6) i = Modchu_CastHelper.Int(o[6]);			}		}		if (!isCanceled) {			if (master != null) master.renderLivingLabel(entityplayer, par2Str, d, d1, d2, i);			super.renderLivingLabel(entityplayer, par2Str, d, d1, d2, i);		}	}	@Override	public void superRenderLivingLabel(Object entity, String par2Str, double d, double d1, double d2, int i) {		super.renderLivingLabel((Entity) entity, par2Str, d, d1, d2, i);	}	protected void renderName(EntityPlayer entityplayer, double d, double d1, double d2) {		String modchuLibEventName = "modchu_RenderPlayerRenderName";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, null, d, d1, d2, -1 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (EntityPlayer) o[1];				if (o.length > 2) d = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) d1 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) d2 = Modchu_CastHelper.Double(o[4]);			}		}		if (!isCanceled				&& master != null) master.renderLivingLabel(entityplayer, null, d, d1, d2, -1);	}	@Override	protected void renderModel(EntityLivingBase par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7) {		String modchuLibEventName = "modchu_RenderPlayerRenderModel";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLiving, par2, par3, par4, par5, par6, par7 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLiving = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Float(o[2]);				if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);				if (o.length > 4) par4 = Modchu_CastHelper.Float(o[4]);				if (o.length > 5) par5 = Modchu_CastHelper.Float(o[5]);				if (o.length > 6) par6 = Modchu_CastHelper.Float(o[6]);				if (o.length > 7) par7 = Modchu_CastHelper.Float(o[7]);			}		}		if (!isCanceled				&& master != null) master.renderModel(par1EntityLiving, par2, par3, par4, par5, par6, par7);	}	@Override	public void superRenderModel(Object entityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {		super.renderModel((EntityLivingBase) entityLivingBase, par2, par3, par4, par5, par6, par7);	}	@Override	protected ResourceLocation getEntityTexture(Entity entity) {		return master != null ? (ResourceLocation) (master.getEntityTexture(entity)) : null;	}	@Override	public Object superGetEntityTexture(Object entity) {		return super.getEntityTexture((Entity) entity);	}	@Override	public Object superGetEntityTexture(Object entity, int i) {		return super.getEntityTexture((Entity) entity);	}	@Override	protected void renderLivingAt(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {		renderLivingAt((AbstractClientPlayer) par1EntityLivingBase, par2, par4, par6);	}	@Override	public void superRenderLivingAt(Object entityLivingBase, double par2, double par4, double par6) {		super.renderLivingAt((EntityLivingBase) entityLivingBase, par2, par4, par6);	}	@Override	protected void renderLivingAt(AbstractClientPlayer var1, double var2, double var4, double var6) {		String modchuLibEventName = "modchu_RenderPlayerRenderPlayerSleep";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ var1, var2, var4, var6 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				var1 = (AbstractClientPlayer) o[1];				if (o.length > 2) var2 = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) var4 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) var6 = Modchu_CastHelper.Double(o[4]);			}		}		if (!isCanceled) {			if (master != null) master.renderPlayerSleep(var1, var2, var4, var6);			super.renderLivingAt(var1, var2, var4, var6);		}	}	@Override	public void superRenderPlayerSleep(Object entityplayer, double var2, double var4, double var6) {	}	@Override	public void func_180595_a(AbstractClientPlayer var1, float var2, float var3, float var4) {		String modchuLibEventName = "modchu_RenderPlayerRotatePlayer";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ var1, var2, var3, var4 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				var1 = (AbstractClientPlayer) o[1];				if (o.length > 2) var2 = Modchu_CastHelper.Float(o[2]);				if (o.length > 3) var3 = Modchu_CastHelper.Float(o[3]);				if (o.length > 4) var4 = Modchu_CastHelper.Float(o[4]);			}		}		if (!isCanceled) {			if (master != null) master.rotatePlayer(var1, var2, var3, var4);		}	}	@Override	public void superRotatePlayer(Object abstractClientPlayer, float var2, float var3, float var4) {		superApplyRotations(abstractClientPlayer, var2, var3, var4);	}	public void superApplyRotations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {		super.func_180595_a((AbstractClientPlayer) par1EntityLivingBase, par2, par3, par4);	}	@Override	protected int getColorMultiplier(EntityLivingBase par1EntityLivingBase, float par2, float par3) {		String modchuLibEventName = "modchu_RenderPlayerGetColorMultiplier";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLivingBase, par2, par3 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLivingBase = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Float(o[2]);				if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);			}		}		return !isCanceled				&& master != null ? master.getColorMultiplier(par1EntityLivingBase, par2, par3) : -1;	}	@Override	public int superGetColorMultiplier(Object entityLivingBase, float par2, float par3) {		return super.getColorMultiplier((EntityLivingBase) entityLivingBase, par2, par3);	}	public RenderManager getRenderManager() {		return (RenderManager) (master != null ? master.getRenderManager() : renderManager);	}	@Override	public Object superGetRenderManager() {		return renderManager;	}	//smartMoving関連↓	public void renderPlayerAt(AbstractClientPlayer var1, double var2, double var4, double var6) {		if (master != null) master.renderPlayerAt((var1), var2, var4, var6);	}	@Override	public void superRenderPlayerAt(Object entityPlayer, double var2, double var4, double var6) {	}	public void renderGuiIngame(Minecraft var0) {		if (master != null) master.renderGuiIngame(var0);	}	@Override	public void superRenderGuiIngame(Object var0) {	}	//smartMoving関連↑	@Override	public Modchu_IRenderPlayerMaster getRenderPlayerMaster() {		return master;	}	@Override	public void superApplyRotations(Object entityLivingBase, float par2, float par3, float par4) {		superApplyRotations((EntityLivingBase) entityLivingBase, par2, par3, par4);	}	@Override	public void superPassSpecialRender(Object entityLiving, double d, double d1, double d2) {		super.passSpecialRender((EntityLivingBase) entityLiving, d, d1, d2);	}	public ModelBase getRenderPassModel() {		return (ModelBase) getRenderPassModel(0);	}	@Override	public Object getRenderPassModel(int i) {		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();		return Modchu_Reflect.getFieldObject(layerArmorBase.getClass(), i == 0 ? "field_177189_c" : "field_177186_d", layerArmorBase);	}	@Override	public void setRenderPassModel(Object model, Object model2) {		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177189_c", layerArmorBase, model);		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177186_d", layerArmorBase, model2);	}	@Override	public Object getLayerArmorBase() {		for (Object layerArmorBase : layerRenderers) {			if (layerArmorBase instanceof LayerArmorBase) {				Modchu_Debug.mDebug("Modchu_RenderPlayer getLayerArmorBase layerArmorBase="+layerArmorBase);				Modchu_Debug.mDebug("Modchu_RenderPlayer getLayerArmorBase layerArmorBase.master="+Modchu_Reflect.getFieldObject(layerArmorBase.getClass(), "master", layerArmorBase));				return layerArmorBase;			}		}		return null;	}	@Override	public Object getLayerHeldItem() {		for (Object layerHeldItem : layerRenderers) {			if (layerHeldItem instanceof LayerHeldItem) {				return layerHeldItem;			}		}		return null;	}	@Override	public Object getLayerCustomHead() {		for (Object layerCustomHead : layerRenderers) {			if (layerCustomHead instanceof LayerCustomHead) {				return layerCustomHead;			}		}		return null;	}	@Override	public void setLayer(Class c, Object layer) {		if (layerRenderers != null				&& !layerRenderers.isEmpty()				&& c != null				&& layer != null); else return;		for (int i = 0; i < layerRenderers.size(); i++) {			Object o = layerRenderers.get(i);			if (c.isInstance(o)) {				layerRenderers.set(i, layer);				return;			}		}		layerRenderers.add(layer);	}	@Override	public List getLayerList() {		return layerRenderers;	}	// 180~	@Override	public ModelPlayer getPlayerModel() {		Object o = master != null ? master.getMainModel() : null;		return o != null ? (ModelPlayer)o : super.getPlayerModel();	}	// ~179	protected int shouldRenderPass(AbstractClientPlayer entityplayer, int i, float f) {		if (master != null); else return -1;		int i1 = setArmorModel(null, entityplayer, i, f, 0);		int i2 = -1;		String modchuLibEventName = "modchu_RenderPlayerShouldRenderPass";		boolean isCanceled = false;		boolean flag = false;		Object[] o = null;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, i, f });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			flag = o != null					&& o.length > 1;			if (!isCanceled					&& o != null					&& o.length > 1) {				entityplayer = (AbstractClientPlayer) o[1];				if (o.length > 2) i = Modchu_CastHelper.Int(o[2]);				if (o.length > 3) f = Modchu_CastHelper.Float(o[3]);				if (o.length > 4) {					i2 = Modchu_CastHelper.Int(o[4]);					flag = true;				}			}		}		int i3 = !isCanceled ? master.shouldRenderPass(entityplayer, i, f) : -1;		i1 = i1 < 0				| i3 < 0 ? -1 : 1;		return flag ? i2 : i1;	}	@Override	public int superShouldRenderPass(Object abstractClientPlayer, int i, float f) {		return -1;	}	protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {		return shouldRenderPass((AbstractClientPlayer) entityliving, i, f);	}	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {		renderEquippedItems((AbstractClientPlayer) entityliving, f);	}	@Override	public void superRenderEquippedItems(Object entityLivingBase, float f) {	}	protected void renderEquippedItems(AbstractClientPlayer entityplayer, float f) {		RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre(entityplayer, this, f);		if (MinecraftForge.EVENT_BUS.post(event)) return;		//Object event = Modchu_Reflect.newInstance("net.minecraftforge.client.event.RenderPlayerEvent.Specials.Pre", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), Modchu_Reflect.loadClass("RenderPlayer"), float.class }, new Object[]{ entityliving, this, f });		//if (Modchu_Main.forgeEventPost(event)) return;		String modchuLibEventName = "modchu_RenderPlayerRenderEquippedItems";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, f });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (AbstractClientPlayer) o[1];				if (o.length > 2) f = Modchu_CastHelper.Float(o[2]);			}		}		if (master != null) {			if (!isCanceled) master.renderSpecials((entityplayer), f);		}		MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Specials.Post(entityplayer, this, f));	}	public void rotateCorpse(AbstractClientPlayer var1, float var2, float var3, float var4) {		func_180595_a(var1, var2, var3, var4);	}	protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {		String modchuLibEventName = "modchu_RenderPlayerInheritRenderPass";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLivingBase, par2, par3 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLivingBase = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Int(o[2]);				if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);			}		}		return !isCanceled				&& master != null ? master.inheritRenderPass(par1EntityLivingBase, par2, par3) : 0;	}	@Override	public int superInheritRenderPass(Object entityLivingBase, int par2, float par3) {		return -1;	}	@Override	protected ResourceLocation func_180594_a(AbstractClientPlayer abstractClientPlayer) {		return (ResourceLocation) (master != null ? master.func_180594_a(abstractClientPlayer) : super.func_180594_a(abstractClientPlayer));	}	@Override	public ResourceLocation superFunc_180594_a(Object abstractClientPlayer) {		return super.func_180594_a((AbstractClientPlayer) abstractClientPlayer);	}	@Override	public void func_82422_c() {		if (master != null) master.transformHeldFull3DItemLayer();		else super.func_82422_c();	}	@Override	public void superTransformHeldFull3DItemLayer() {		super.func_82422_c();	}	@Override	protected void renderOffsetLivingLabel(AbstractClientPlayer abstractClientPlayer, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {		if (master != null) master.renderOffsetLivingLabel(abstractClientPlayer, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);		else super.renderOffsetLivingLabel(abstractClientPlayer, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);	}	@Override	public void superRenderOffsetLivingLabel(Object abstractClientPlayer, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {		super.renderOffsetLivingLabel((AbstractClientPlayer) abstractClientPlayer, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);	}	@Override	protected void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {		if (master != null) master.applyRotations(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);	}	@Override	public void doRender(EntityLivingBase entityLivingBase, double x, double y, double z, float p_76986_8_, float partialTicks) {		if (master != null) master.doRender(entityLivingBase, x, y, z, p_76986_8_, partialTicks);		else super.doRender(entityLivingBase, x, y, z, p_76986_8_, partialTicks);	}	@Override	public ModelBase getMainModel() {		return (ModelBase) (master != null ? master.getMainModel() : super.getMainModel());	}	@Override	public ModelBase superGetMainModel() {		return super.getMainModel();	}	@Override	protected void func_177069_a(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {		if (master != null) master.renderOffsetLivingLabel(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);		else super.func_177069_a(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);	}	public void superFunc_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {		super.func_177069_a((Entity) entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);	}/*	@Override	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {		if (master != null) master.doRender(entity, x, y, z, p_76986_8_, partialTicks);		else super.doRender(entity, x, y, z, p_76986_8_, partialTicks);	}	public void superDoRender(Object entity, double x, double y, double z, float p_76986_8_, float partialTicks) {		super.doRender((Entity) entity, x, y, z, p_76986_8_, partialTicks);	}*/	@Override	public boolean addLayer(LayerRenderer layerRenderer) {		return master != null ? master.addLayer(layerRenderer) : super.addLayer(layerRenderer);	}	@Override	public boolean superAddLayer(Object layerRenderer) {		return super.addLayer((LayerRenderer) layerRenderer);	}	@Override	protected boolean removeLayer(LayerRenderer layerRenderer) {		return master != null ? master.removeLayer(layerRenderer) : super.removeLayer(layerRenderer);	}	@Override	public boolean superRemoveLayer(Object layerRenderer) {		return super.removeLayer((LayerRenderer) layerRenderer);	}	@Override	protected float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {		return master != null ? master.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_) : super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);	}	@Override	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {		return super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);	}	@Override	protected boolean func_177088_c(EntityLivingBase entityLivingBase) {		return master != null ? master.setScoreTeamColor(entityLivingBase) : super.func_177088_c(entityLivingBase);	}	@Override	public boolean superSetScoreTeamColor(Object entityLivingBase) {		return super.func_177088_c((EntityLivingBase) entityLivingBase);	}	@Override	protected void func_180565_e() {		if (master != null) master.unsetScoreTeamColor();		else super.func_180565_e();	}	@Override	public void superUnsetScoreTeamColor() {		super.func_180565_e();	}	@Override	protected boolean func_177090_c(EntityLivingBase entityLivingBase, float p_177090_2_) {		return master != null ? master.setDoRenderBrightness(entityLivingBase, p_177090_2_) : super.func_177090_c(entityLivingBase, p_177090_2_);	}	@Override	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {		return super.func_177090_c((EntityLivingBase) entityLivingBase, p_177090_2_);	}	@Override	protected boolean func_177092_a(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {		return master != null ? master.setBrightness(entityLivingBase, p_177092_2_, p_177092_3_) : super.func_177092_a(entityLivingBase, p_177092_2_, p_177092_3_);	}	@Override	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {		return super.func_177092_a((EntityLivingBase) entityLivingBase, p_177092_2_, p_177092_3_);	}	@Override	protected void func_177091_f() {		if (master != null) master.unsetBrightness();		else super.func_177091_f();	}	@Override	public void superUnsetBrightness() {		super.func_177091_f();	}	@Override	protected float getSwingProgress(EntityLivingBase entityLivingBase, float p_77040_2_) {		return master != null ? master.getSwingProgress(entityLivingBase, p_77040_2_) : super.getSwingProgress(entityLivingBase, p_77040_2_);	}	@Override	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {		return super.getSwingProgress((EntityLivingBase) entityLivingBase, p_77040_2_);	}	@Override	protected float handleRotationFloat(EntityLivingBase entityLivingBase, float p_77044_2_) {		return master != null ? master.handleRotationFloat(entityLivingBase, p_77044_2_) : super.handleRotationFloat(entityLivingBase, p_77044_2_);	}	@Override	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_) {		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, p_77044_2_);	}	@Override	protected void func_177093_a(EntityLivingBase entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {		if (master != null) master.renderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);		else super.func_177093_a(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);	}	@Override	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {		super.func_177093_a((EntityLivingBase) entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);	}	@Override	protected float getDeathMaxRotation(EntityLivingBase entityLivingBase) {		return master != null ? master.getDeathMaxRotation(entityLivingBase) : super.getDeathMaxRotation(entityLivingBase);	}	@Override	public float superGetDeathMaxRotation(Object entityLivingBase) {		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);	}	@Override	protected boolean canRenderName(EntityLivingBase entityLivingBase) {		return master != null ? master.canRenderName(entityLivingBase) : super.canRenderName(entityLivingBase);	}	@Override	public boolean superCanRenderName(Object entityLivingBase) {		return super.canRenderName((EntityLivingBase) entityLivingBase);	}	@Override	public void setRenderOutlines(boolean p_177086_1_) {		if (master != null) master.setRenderOutlines(p_177086_1_);		else super.setRenderOutlines(p_177086_1_);	}	@Override	public void superSetRenderOutlines(boolean p_177086_1_) {		super.setRenderOutlines(p_177086_1_);	}	@Override	public void renderName(Entity entity, double x, double y, double z) {		if (master != null) master.renderName(entity, x, y, z);		else super.renderName(entity, x, y, z);	}	@Override	public void superRenderName(Object entity, double x, double y, double z) {		super.renderName((Entity) entity, x, y, z);	}	@Override	public boolean shouldRender(Entity entity, ICamera iCamera, double camX, double camY, double camZ) {		return master != null ? master.shouldRender(entity, iCamera, camX, camY, camZ) : super.shouldRender(entity, iCamera, camX, camY, camZ);	}	@Override	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {		return super.shouldRender((Entity) entity, (ICamera) iCamera, camX, camY, camZ);	}	@Override	protected boolean bindEntityTexture(Entity entity) {		return master != null ? master.bindEntityTexture(entity) : super.bindEntityTexture(entity);	}	@Override	public boolean superBindEntityTexture(Object entity) {		return super.bindEntityTexture((Entity) entity);	}	@Override	public void bindTexture(ResourceLocation resourceLocation) {		if (master != null) master.bindTexture(resourceLocation);		else super.bindTexture(resourceLocation);	}	@Override	public void superBindTexture(Object resourceLocation) {		super.bindTexture((ResourceLocation) resourceLocation);	}	@Override	public void doRenderShadowAndFire(Entity entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {		if (master != null) master.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);		else super.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);	}	@Override	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {		super.doRenderShadowAndFire((Entity) entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);	}	@Override	public FontRenderer getFontRendererFromRenderManager() {		return (FontRenderer) (master != null ? master.getFontRendererFromRenderManager() : super.getFontRendererFromRenderManager());	}	@Override	public FontRenderer superGetFontRendererFromRenderManager() {		return super.getFontRendererFromRenderManager();	}	@Override	public RenderManager func_177068_d() {		return (RenderManager) (master != null ? master.getRenderManager() : super.func_177068_d());	}	public RenderManager superFunc_177068_d() {		return super.func_177068_d();	}	@Override	public void superSetRenderPassModel(Object modelBase) {	}	@Override	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2) {	}	@Override	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3) {	}	@Override	public boolean superIsStaticEntity() {		return false;	}	@Override	public void superSetRenderManager(Object renderManager) {	}	@Override	public void superUpdateIcons(Object iIconRegister) {	}	@Override	public void superDoRender(Object entity, double d0, double d1, double d2, float f, float f1) {		super.doRender((Entity)entity, d0, d1, d2, f, f1);	}	// ~152	@Override	public void superLoadTexture(String par1Str) {	}	@Override	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {		return false;	}	// 190~	@Override	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {		super.func_177069_a((Entity) entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, 0.0F, p_177069_10_);	}	@Override	public float superPrepareScale(Object entityLivingBase, float partialTicks) {		return 0.0F;	}	@Override	public int superGetTeamColor(Object entity) {		return -1;	}	@Override	public boolean superIsMultipass() {		return false;	}	@Override	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {	}	@Override	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {	}	@Override	public void superRotateCorpse(Object entityLivingBase, float par2, float par3, float par4) {		super.rotateCorpse((EntityLivingBase) entityLivingBase, par2, par3, par4);	}	@Override	public float superRenderSwingProgress(Object entityLivingBase, float par2) {		return 0.0F;	}	@Override	public boolean superFunc_110813_b(Object entityLivingBase) {		return false;	}	@Override	public void superFunc_110777_b(Object entity) {	}	@Override	public void superFunc_130220_b(Object abstractClientPlayer, int par2, float par3) {	}	@Override	public void superFunc_130009_a(Object abstractClientPlayer, double par2, double par4, double par6, float par8, float par9) {	}	@Override	public Object superFunc_110817_a(Object abstractClientPlayer) {		return null;	}	@Override	public void superRenderSpecials(Object abstractClientPlayer, float par2) {	}	@Override	public void superRenderPlayerScale(Object abstractClientPlayer, float par2) {	}	@Override	public void superFunc_96450_a(Object abstractClientPlayer, double par2, double par4, double par6, String par8Str, float par9, double par10) {	}	@Override	public void superFunc_98191_a(Object entityPlayer) {	}	@Override	public void superFunc_82439_b(Object entityPlayer, int par2, float par3) {	}	@Override	public void superRenderPlayer(Object entityPlayer, double par2, double par4, double par6, float par8, float par9) {	}	@Override	public void superFunc_98190_a(Object entityLiving) {	}	@Override	public boolean superIsVisible(Object abstractClientPlayer) {		return false;	}}