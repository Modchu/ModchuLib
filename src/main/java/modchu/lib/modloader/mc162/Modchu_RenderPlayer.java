package modchu.lib.modloader.mc162;import java.util.HashMap;import java.util.List;import modchu.lib.Modchu_AS;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IRenderPlayer;import modchu.lib.Modchu_IRenderPlayerMaster;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import modchu.pflm.PFLM_ModelDataMaster;import net.minecraft.src.AbstractClientPlayer;import net.minecraft.src.Entity;import net.minecraft.src.EntityLivingBase;import net.minecraft.src.EntityPlayer;import net.minecraft.src.FontRenderer;import net.minecraft.src.IconRegister;import net.minecraft.src.Minecraft;import net.minecraft.src.ModelBase;import net.minecraft.src.RenderManager;import net.minecraft.src.RenderPlayer;import net.minecraft.src.ResourceLocation;public class Modchu_RenderPlayer extends RenderPlayer implements Modchu_IRenderPlayer {	public Modchu_IRenderPlayerMaster master;	public Modchu_RenderPlayer(HashMap<String, Object> map) {		super();		Modchu_Debug.lDebug("Modchu_RenderPlayer init");		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);		Modchu_Debug.lDebug("Modchu_RenderPlayer init renderManager="+renderManager);		map.put("base", this);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		Modchu_Debug.lDebug("Modchu_RenderPlayer init instance="+instance);		master = instance instanceof Modchu_IRenderPlayerMaster ? (Modchu_IRenderPlayerMaster) instance : null;	}	@Override	protected int setArmorModel(AbstractClientPlayer entityplayer, int i, float f) {		if (master != null) ;else return -1;		return setArmorModel(null, entityplayer, i, f, 0);	}	protected int setArmorModel(Object model, EntityPlayer entityplayer, int i, float f, int i2) {		if (master != null) ;else return -1;		String modchuLibEventName = "modchu_RenderPlayerSetArmorModel";		boolean isCanceled = false;		boolean flag = false;		Object[] o = null;		int i3 = -1;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ model, entityplayer, i, f, i2 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (!isCanceled					&& o != null					&& o.length > 1) {				model = o[1];				if (o.length > 2) entityplayer = (EntityPlayer) o[2];				if (o.length > 3) i = Modchu_CastHelper.Int(o[3]);				if (o.length > 4) f = Modchu_CastHelper.Float(o[4]);				if (o.length > 5) i2 = Modchu_CastHelper.Int(o[5]);				if (o.length > 6) {					i3 = Modchu_CastHelper.Int(o[6]);					flag = true;				}			}		}		int i1 = !isCanceled ? master.setArmorModel(model, entityplayer, i, f, i2) : -1;		return flag ? i3 : i1;	}	@Override	public int superSetArmorModel(Object model, Object entityplayer, int i, float f, int i2) {		return super.setArmorModel((AbstractClientPlayer) entityplayer, i, f);	}	@Override	protected void preRenderCallback(EntityLivingBase entityliving, float f) {		float f1 = 0.9375F;		float f2 = 0.9375F;		float f3 = 0.9375F;		String modchuLibEventName = "modchu_RenderPlayerPreRenderCallback";		boolean isCanceled = false;		Object[] o = null;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityliving, f });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (!isCanceled					&& o != null					&& o.length > 1) {				f1 = Modchu_CastHelper.Float(o[1]);				if (o.length > 2) f2 = Modchu_CastHelper.Float(o[2]);				if (o.length > 3) f3 = Modchu_CastHelper.Float(o[3]);			}		}		if (master != null				&& !isCanceled) master.renderScale(entityliving, f);	}	@Override	public void superPreRenderCallback(Object par1EntityLiving, float par2) {		super.preRenderCallback((EntityLivingBase) par1EntityLiving, par2);	}	@Override	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {		if (master != null) ;else return;		String modchuLibEventName = "modchu_RenderPlayerDoRender";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entity, d, d1, d2, f, f1 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entity = (Entity) o[1];				if (o.length > 2) d = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) d1 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) f = Modchu_CastHelper.Float(o[4]);				if (o.length > 5) f1 = Modchu_CastHelper.Float(o[5]);			}		}		if (!isCanceled) master.doRender(entity, d, d1, d2, f, f1);	}	@Override	public void superDoRenderLiving(Object entity, double d, double d1, double d2, float f, float f1) {		super.func_130000_a((EntityLivingBase) entity, d, d1, d2, f, f1);	}	@Override	protected void passSpecialRender(EntityLivingBase par1EntityLiving, double par2, double par4, double par6) {		String modchuLibEventName = "modchu_RenderPlayerPassSpecialRender";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLiving, par2, par4, par6 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLiving = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) par4 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) par6 = Modchu_CastHelper.Double(o[4]);			}		}		if (!isCanceled				&& master != null) master.passSpecialRender(par1EntityLiving, par2, par4, par6);	}	@Override	public void renderFirstPersonArm(EntityPlayer entityplayer) {		renderFirstPersonArm(entityplayer, 2);	}	public void renderFirstPersonArm(EntityPlayer entityplayer, int i) {		//olddays導入時に2以外のint付きで呼ばれる。		if (master != null) ;else return;		String modchuLibEventName = "modchu_RenderPlayerRenderFirstPersonArm";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, i });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (EntityPlayer) o[1];				if (o.length > 2) i = Modchu_CastHelper.Int(o[2]);			}		}		if (!isCanceled) master.renderFirstPersonArm(entityplayer, i);	}	@Override	public void superRenderFirstPersonArm(Object entityplayer, int i) {		super.renderFirstPersonArm((EntityPlayer) entityplayer);	}	public boolean isActivatedForPlayer(AbstractClientPlayer entityplayer) {		if (master != null) ;else return false;		String modchuLibEventName = "modchu_RenderPlayerIsActivatedForPlayer";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (AbstractClientPlayer) o[1];			}		}		return !isCanceled ? master.isActivatedForPlayer(entityplayer) : false;	}	@Override	public boolean superIsActivatedForPlayer(Object entityplayer) {		return false;	}	@Override	protected void renderLivingLabel(EntityLivingBase entityLivingBase, String par2Str, double d, double d1, double d2, int i) {		String modchuLibEventName = "modchu_RenderPlayerRenderLivingLabel";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityLivingBase, par2Str, d, d1, d2, i });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityLivingBase = (EntityLivingBase) o[1];				if (o.length > 2) par2Str = Modchu_CastHelper.String(o[2]);				if (o.length > 3) d = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) d1 = Modchu_CastHelper.Double(o[4]);				if (o.length > 5) d2 = Modchu_CastHelper.Double(o[5]);				if (o.length > 6) i = Modchu_CastHelper.Int(o[6]);			}		}		if (!isCanceled) {			if (master != null) master.renderLivingLabel(entityLivingBase, par2Str, d, d1, d2, i);			super.renderLivingLabel(entityLivingBase, par2Str, d, d1, d2, i);		}	}	@Override	public void superRenderLivingLabel(Object entity, String par2Str, double d, double d1, double d2, int i) {		super.renderLivingLabel((EntityLivingBase) entity, par2Str, d, d1, d2, i);	}	protected void renderName(EntityPlayer entityplayer, double d, double d1, double d2) {		String modchuLibEventName = "modchu_RenderPlayerRenderName";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityplayer, null, d, d1, d2, -1 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityplayer = (EntityPlayer) o[1];				if (o.length > 2) d = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) d1 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) d2 = Modchu_CastHelper.Double(o[4]);			}		}		if (!isCanceled				&& master != null) master.renderLivingLabel(entityplayer, null, d, d1, d2, -1);	}	@Override	protected void renderModel(EntityLivingBase par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7) {		String modchuLibEventName = "modchu_RenderPlayerRenderModel";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLiving, par2, par3, par4, par5, par6, par7 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLiving = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Float(o[2]);				if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);				if (o.length > 4) par4 = Modchu_CastHelper.Float(o[4]);				if (o.length > 5) par5 = Modchu_CastHelper.Float(o[5]);				if (o.length > 6) par6 = Modchu_CastHelper.Float(o[6]);				if (o.length > 7) par7 = Modchu_CastHelper.Float(o[7]);			}		}		if (!isCanceled				&& master != null) master.renderModel(par1EntityLiving, par2, par3, par4, par5, par6, par7);	}	@Override	public void superRenderModel(Object entityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {		super.renderModel((EntityLivingBase) entityLivingBase, par2, par3, par4, par5, par6, par7);	}	@Override	protected ResourceLocation func_110775_a(Entity entity) {		return (ResourceLocation) ((PFLM_ModelDataMaster) PFLM_ModelDataMaster.instance).getResourceLocation(entity);	}	@Override	public Object superGetEntityTexture(Object entity) {		return super.func_110775_a((Entity) entity);	}	protected ResourceLocation getEntityTexture(Entity entity, int i) {		return (ResourceLocation) ((PFLM_ModelDataMaster) PFLM_ModelDataMaster.instance).getResourceLocation(entity, i);	}	@Override	public Object superGetEntityTexture(Object entity, int i) {		return super.func_110775_a((Entity) entity);	}	@Override	public void superRenderLivingAt(Object par1EntityLivingBase, double par2, double par4, double par6) {		super.renderLivingAt((EntityLivingBase) par1EntityLivingBase, par2, par4, par6);	}	@Override	protected void renderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6) {		String modchuLibEventName = "modchu_RenderPlayerRenderPlayerSleep";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ var1, var2, var4, var6 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				var1 = (AbstractClientPlayer) o[1];				if (o.length > 2) var2 = Modchu_CastHelper.Double(o[2]);				if (o.length > 3) var4 = Modchu_CastHelper.Double(o[3]);				if (o.length > 4) var6 = Modchu_CastHelper.Double(o[4]);			}		}		if (!isCanceled) {			if (master != null) master.renderPlayerSleep(var1, var2, var4, var6);			super.renderPlayerSleep(var1, var2, var4, var6);		}	}	@Override	public void superRenderPlayerSleep(Object entityplayer, double var2, double var4, double var6) {		super.renderPlayerSleep((AbstractClientPlayer) entityplayer, var2, var4, var6);	}	@Override	public void rotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4) {		String modchuLibEventName = "modchu_RenderPlayerRotatePlayer";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ var1, var2, var3, var4 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				var1 = (AbstractClientPlayer) o[1];				if (o.length > 2) var2 = Modchu_CastHelper.Float(o[2]);				if (o.length > 3) var3 = Modchu_CastHelper.Float(o[3]);				if (o.length > 4) var4 = Modchu_CastHelper.Float(o[4]);			}		}		if (!isCanceled) {			if (master != null) master.rotatePlayer(var1, var2, var3, var4);		}	}	@Override	public void superApplyRotations(Object par1EntityLivingBase, float par2, float par3, float par4) {		super.rotatePlayer((AbstractClientPlayer) par1EntityLivingBase, par2, par3, par4);	}	@Override	protected int getColorMultiplier(EntityLivingBase par1EntityLivingBase, float par2, float par3) {		String modchuLibEventName = "modchu_RenderPlayerGetColorMultiplier";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLivingBase, par2, par3 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLivingBase = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Float(o[2]);				if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);			}		}		return !isCanceled				&& master != null ? master.getColorMultiplier(par1EntityLivingBase, par2, par3) : -1;	}	@Override	public int superGetColorMultiplier(Object entityLivingBase, float par2, float par3) {		return super.getColorMultiplier((EntityLivingBase) entityLivingBase, par2, par3);	}	public RenderManager getRenderManager() {		return renderManager;	}	//smartMoving関連↓	public void renderPlayerAt(AbstractClientPlayer var1, double var2, double var4, double var6) {		if (master != null) master.renderPlayerAt(var1, var2, var4, var6);	}	@Override	public void superRenderPlayerAt(Object entityPlayer, double var2, double var4, double var6) {	}	public void renderGuiIngame(Minecraft var0) {		if (master != null) master.renderGuiIngame(var0);	}	@Override	public void superRenderGuiIngame(Object var0) {	}	//smartMoving関連↑	@Override	public Modchu_IRenderPlayerMaster getRenderPlayerMaster() {		return master;	}	@Override	public void superRotatePlayer(Object abstractClientPlayer, float var2, float var3, float var4) {		super.rotatePlayer((AbstractClientPlayer) abstractClientPlayer, var2, var3, var4);	}	@Override	public void superPassSpecialRender(Object entityLiving, double d, double d1, double d2) {		super.passSpecialRender((EntityLivingBase) entityLiving, d, d1, d2);	}	@Override	protected void func_130220_b(AbstractClientPlayer par1AbstractClientPlayer, int par2, float par3) {		// TODO		super.func_130220_b(par1AbstractClientPlayer, par2, par3);	}	@Override	public void func_130009_a(AbstractClientPlayer par1AbstractClientPlayer, double par2, double par4, double par6, float par8, float par9) {		// TODO		super.func_130009_a(par1AbstractClientPlayer, par2, par4, par6, par8, par9);	}	@Override	protected ResourceLocation func_110817_a(AbstractClientPlayer par1AbstractClientPlayer) {		// TODO		return super.func_110817_a(par1AbstractClientPlayer);	}	@Override	protected void renderSpecials(AbstractClientPlayer par1AbstractClientPlayer, float par2) {		renderEquippedItems(par1AbstractClientPlayer, par2);	}	@Override	public void superRenderEquippedItems(Object entityLivingBase, float f) {		super.renderEquippedItems((EntityLivingBase) entityLivingBase, f);	}	@Override	protected void renderPlayerScale(AbstractClientPlayer par1AbstractClientPlayer, float par2) {		preRenderCallback(par1AbstractClientPlayer, par2);	}	@Override	protected void func_96450_a(AbstractClientPlayer par1AbstractClientPlayer, double par2, double par4, double par6, String par8Str, float par9, double par10) {		// TODO		super.func_96450_a(par1AbstractClientPlayer, par2, par4, par6, par8Str, par9, par10);	}	@Override	protected void func_96449_a(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {		// TODO		super.func_96449_a(par1EntityLivingBase, par2, par4, par6, par8Str, par9, par10);	}	@Override	protected void func_82408_c(EntityLivingBase par1EntityLivingBase, int par2, float par3) {		// TODO		super.func_82408_c(par1EntityLivingBase, par2, par3);	}	@Override	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {		// TODO		super.rotateCorpse(par1EntityLivingBase, par2, par3, par4);	}	@Override	protected void renderLivingAt(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {		// TODO		super.renderLivingAt(par1EntityLivingBase, par2, par4, par6);	}	@Override	public void func_130000_a(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {		super.func_130000_a(par1EntityLivingBase, par2, par4, par6, par8, par9);	}	@Override	public void setRenderPassModel(ModelBase par1ModelBase) {		super.setRenderPassModel(par1ModelBase);	}	@Override	protected float renderSwingProgress(EntityLivingBase par1EntityLivingBase, float par2) {		// TODO		return super.renderSwingProgress(par1EntityLivingBase, par2);	}	@Override	protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase, float par2) {		// TODO		return super.handleRotationFloat(par1EntityLivingBase, par2);	}	@Override	protected void renderArrowsStuckInEntity(EntityLivingBase par1EntityLivingBase, float par2) {		// TODO		super.renderArrowsStuckInEntity(par1EntityLivingBase, par2);	}	@Override	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase) {		// TODO		return super.getDeathMaxRotation(par1EntityLivingBase);	}	@Override	protected boolean func_110813_b(EntityLivingBase par1EntityLivingBase) {		// TODO		return super.func_110813_b(par1EntityLivingBase);	}	@Override	protected void func_110777_b(Entity par1Entity) {		// TODO		super.func_110777_b(par1Entity);	}	@Override	protected void func_110776_a(ResourceLocation par1ResourceLocation) {		// TODO		super.func_110776_a(par1ResourceLocation);	}	@Override	public void setRenderManager(RenderManager par1RenderManager) {		// TODO		super.setRenderManager(par1RenderManager);	}	@Override	public void doRenderShadowAndFire(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {		// TODO		super.doRenderShadowAndFire(par1Entity, par2, par4, par6, par8, par9);	}	@Override	public FontRenderer getFontRendererFromRenderManager() {		// TODO		return super.getFontRendererFromRenderManager();	}	@Override	public void updateIcons(IconRegister par1IconRegister) {		// TODO		super.updateIcons(par1IconRegister);	}	// ~179	@Override	protected int shouldRenderPass(EntityLivingBase entityliving, int i, float f) {		if (master != null) ;else return -1;		int i1 = setArmorModel((AbstractClientPlayer) entityliving, i, f);		int i2 = -1;		String modchuLibEventName = "modchu_RenderPlayerShouldRenderPass";		boolean isCanceled = false;		boolean flag = false;		Object[] o = null;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityliving, i, f });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			flag = o != null					&& o.length > 1;			if (!isCanceled					&& o != null					&& o.length > 1) {				entityliving = (EntityLivingBase) o[1];				if (o.length > 2) i = Modchu_CastHelper.Int(o[2]);				if (o.length > 3) f = Modchu_CastHelper.Float(o[3]);				if (o.length > 4) {					i2 = Modchu_CastHelper.Int(o[4]);					flag = true;				}			}		}		int i3 = !isCanceled ? master.shouldRenderPass(entityliving, i, f) : -1;		i1 = i1 < 0				| i3 < 0 ? -1 : i1;		return flag ? i2 : i1;	}	@Override	public int superShouldRenderPass(Object abstractClientPlayer, int i, float f) {		return super.shouldRenderPass((AbstractClientPlayer) abstractClientPlayer, i, f);	}	@Override	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {		if (Modchu_Main.isForge				&& Modchu_Main.forgeEventPost(Modchu_Reflect.newInstance("net.minecraftforge.client.event.RenderPlayerEvent.Pre", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), Modchu_Reflect.loadClass("RenderPlayer"), float.class }, new Object[]{ entityliving, this, f }))) return;		String modchuLibEventName = "modchu_RenderPlayerRenderEquippedItems";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ entityliving, f });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				entityliving = (EntityPlayer) o[1];				if (o.length > 2) f = Modchu_CastHelper.Float(o[2]);			}		}		if (master != null) {			if (!isCanceled) master.renderSpecials(entityliving, f);		}		if (Modchu_Main.isForge) Modchu_Main.forgeEventPost(Modchu_Reflect.newInstance("net.minecraftforge.client.event.RenderPlayerEvent.Post", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), Modchu_Reflect.loadClass("RenderPlayer"), float.class }, new Object[]{ entityliving, this, f }));	}	@Override	protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {		String modchuLibEventName = "modchu_RenderPlayerInheritRenderPass";		boolean isCanceled = false;		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {			boolean flag = true;			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ par1EntityLivingBase, par2, par3 });			isCanceled = o != null					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;			if (o != null					&& o.length > 1) {				par1EntityLivingBase = (EntityLivingBase) o[1];				if (o.length > 2) par2 = Modchu_CastHelper.Int(o[2]);				if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);			}		}		return !isCanceled				&& master != null ? master.inheritRenderPass(par1EntityLivingBase, par2, par3) : 0;	}	@Override	public int superInheritRenderPass(Object entityLivingBase, int par2, float par3) {		return super.inheritRenderPass((EntityLivingBase) entityLivingBase, par2, par3);	}	public ModelBase getRenderPassModel() {		return renderPassModel;	}	@Override	public void superFunc_110777_b(Object entity) {		super.func_110777_b((Entity) entity);	}	// 180~	@Override	public Object getRenderPassModel(int i) {		return renderPassModel;	}	@Override	public void setRenderPassModel(Object model, Object model2) {	}	@Override	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {		if (master != null) ;else return -1;		return master.setArmorModel(model, entityplayer, i, f, i2);	}	@Override	public Object getLayerArmorBase() {		return null;	}	@Override	public Object getLayerHeldItem() {		return null;	}	@Override	public Object getLayerCustomHead() {		return null;	}	@Override	public void setLayer(Class c, Object layer) {	}	@Override	public List getLayerList() {		return null;	}	@Override	public void superSetRenderPassModel(Object modelBase) {		super.setRenderPassModel((ModelBase) modelBase);	}	@Override	public float superGetSwingProgress(Object entityLivingBase, float par2) {		return super.renderSwingProgress((EntityLivingBase) entityLivingBase, par2);	}	@Override	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2) {		super.renderArrowsStuckInEntity((EntityLivingBase) entityLivingBase, par2);	}	@Override	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3) {		super.func_82408_c((AbstractClientPlayer) entityLivingBase, par2, par3);	}	@Override	public boolean superCanRenderName(Object entityLivingBase) {		return super.func_110813_b((EntityLivingBase) entityLivingBase);	}	@Override	public void superRenderOffsetLivingLabel(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {		super.func_96449_a((AbstractClientPlayer) entityLivingBase, par2, par4, par6, par8Str, par9, par10);	}	@Override	public boolean superIsStaticEntity() {		return false;	}	@Override	public void superSetRenderManager(Object renderManager) {		super.setRenderManager((RenderManager) renderManager);	}	@Override	public void superUpdateIcons(Object iIconRegister) {		super.updateIcons((IconRegister) iIconRegister);	}	@Override	public Object superFunc_180594_a(Object abstractClientPlayer) {		return null;	}	@Override	public void superTransformHeldFull3DItemLayer() {	}	@Override	public void superFunc_177139_c(Object abstractClientPlayer) {	}	@Override	public Object superGetMainModel() {		return mainModel;	}	@Override	public boolean superAddLayer(Object layerRenderer) {		return false;	}	@Override	public boolean superRemoveLayer(Object layerRenderer) {		return false;	}	@Override	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {		return 0.0F;	}	@Override	public boolean superSetScoreTeamColor(Object entityLivingBase) {		return false;	}	@Override	public void superUnsetScoreTeamColor() {	}	@Override	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {		return false;	}	@Override	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {		return false;	}	@Override	public void superUnsetBrightness() {	}	@Override	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_) {		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, p_77044_2_);	}	@Override	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {	}	@Override	public float superGetDeathMaxRotation(Object entityLivingBase) {		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);	}	@Override	public void superSetRenderOutlines(boolean p_177086_1_) {	}	@Override	public void superRenderName(Object entity, double x, double y, double z) {	}	@Override	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {		return false;	}	@Override	public boolean superBindEntityTexture(Object entity) {		super.func_110777_b((Entity) entity);		return true;	}	@Override	public void superBindTexture(Object resourceLocation) {		super.func_110776_a((ResourceLocation) resourceLocation);	}	@Override	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {		super.doRenderShadowAndFire((Entity) entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);	}	@Override	public Object superGetFontRendererFromRenderManager() {		return super.getFontRendererFromRenderManager();	}	@Override	public Object superGetRenderManager() {		return renderManager;	}	// ~152	@Override	public void superLoadTexture(String par1Str) {	}	@Override	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {		return false;	}	@Override	public void superDoRender(Object entity, double d0, double d1, double d2, float f, float f1) {		super.doRender((Entity) entity, d0, d1, d2, f, f1);	}	// 190~	@Override	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {	}	@Override	public int setArmorModel(Object entity, int i, float f) {		return -1;	}	@Override	public int superSetArmorModel(Object entity, int i, float f) {		return -1;	}	@Override	public float superPrepareScale(Object entityLivingBase, float partialTicks) {		return 0.0F;	}	@Override	public int superGetTeamColor(Object entity) {		return -1;	}	@Override	public boolean superIsMultipass() {		return false;	}	@Override	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {	}	@Override	public void superFunc_98191_a(Object entityPlayer) {	}	@Override	public void superFunc_82439_b(Object entityPlayer, int par2, float par3) {	}	@Override	public void superRenderPlayer(Object entityPlayer, double par2, double par4, double par6, float par8, float par9) {	}	@Override	public void superFunc_98190_a(Object entityLiving) {	}	@Override	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {		super.func_96449_a((EntityLivingBase) entityLivingBase, par2, par4, par6, par8Str, par9, par10);	}	@Override	public void superRotateCorpse(Object entityLivingBase, float par2, float par3, float par4) {		super.rotateCorpse((EntityLivingBase) entityLivingBase, par2, par3, par4);	}	@Override	public float superRenderSwingProgress(Object entityLivingBase, float par2) {		return super.renderSwingProgress((EntityLivingBase) entityLivingBase, par2);	}	@Override	public boolean superFunc_110813_b(Object entityLivingBase) {		return super.func_110813_b((EntityLivingBase) entityLivingBase);	}	@Override	public void superFunc_130220_b(Object abstractClientPlayer, int par2, float par3) {		super.func_130220_b((AbstractClientPlayer) abstractClientPlayer, par2, par3);	}	@Override	public void superFunc_130009_a(Object abstractClientPlayer, double par2, double par4, double par6, float par8, float par9) {		super.func_130009_a((AbstractClientPlayer) abstractClientPlayer, par2, par4, par6, par8, par9);	}	@Override	public Object superFunc_110817_a(Object abstractClientPlayer) {		return super.func_110817_a((AbstractClientPlayer) abstractClientPlayer);	}	@Override	public void superRenderSpecials(Object abstractClientPlayer, float par2) {		super.renderSpecials((AbstractClientPlayer) abstractClientPlayer, par2);	}	@Override	public void superRenderPlayerScale(Object abstractClientPlayer, float par2) {		super.renderPlayerScale((AbstractClientPlayer) abstractClientPlayer, par2);	}	@Override	public void superFunc_96450_a(Object abstractClientPlayer, double par2, double par4, double par6, String par8Str, float par9, double par10) {		super.func_96450_a((AbstractClientPlayer) abstractClientPlayer, par2, par4, par6, par8Str, par9, par10);	}	@Override	public boolean superIsVisible(Object abstractClientPlayer) {		return false;	}}