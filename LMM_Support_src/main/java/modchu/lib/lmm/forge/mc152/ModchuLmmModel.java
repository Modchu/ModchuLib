package modchu.lib.lmm.forge.mc152;import java.util.Map;import java.util.Random;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import modchu.model.ModchuModel_IEntityCaps;import modchu.model.ModchuModel_Main;import modchu.model.ModchuModel_ModelDataMaster;import modchu.model.ModchuModel_ModelRenderer;import modchu.model.multimodel.base.MultiModelBaseBiped;import net.minecraft.client.model.TextureOffset;import net.minecraft.src.MMM_IModelCaps;import net.minecraft.src.MMM_ModelMultiMMMBase;import net.minecraft.src.MMM_ModelRenderer;public class ModchuLmmModel extends MMM_ModelMultiMMMBase {	public MultiModelBaseBiped master;	public MMM_ModelRenderer dummyModelRenderer;	public ModchuLmmModel(Class masterClass) {		init(masterClass, null, (Object[]) null);	}	public ModchuLmmModel(Class masterClass, float psize) {		init(masterClass, new Class[]{ float.class }, psize);	}	public ModchuLmmModel(Class masterClass, float psize, float pYOffset) {		init(masterClass, new Class[]{ float.class, float.class }, psize, pYOffset);	}	public ModchuLmmModel(Class masterClass, float psize, float pYOffset, int par3, int par4) {		init(masterClass, new Class[]{ float.class, float.class, int.class, int.class }, psize, pYOffset, par3, par4);	}	public ModchuLmmModel(MultiModelBaseBiped masterModel) {		init(masterModel, (Object[]) null);	}	public ModchuLmmModel(MultiModelBaseBiped masterModel, float psize) {		init(masterModel, psize);	}	public ModchuLmmModel(MultiModelBaseBiped masterModel, float psize, float pyoffset) {		init(masterModel, psize, pyoffset);	}	public ModchuLmmModel(MultiModelBaseBiped masterModel, float psize, float pyoffset, int par3, int par4) {		init(masterModel, psize, pyoffset, par3, par4);	}	public void init(Class masterClass, Class[] c, Object... o) {		if (masterClass != null) ;else throw new RuntimeException("Modchu_LmmModel init masterClass null !!");		Object instance = o != null ? Modchu_Reflect.newInstance(masterClass, c, o) : Modchu_Reflect.newInstance(masterClass);		//Modchu_Debug.mDebug("Modchu_LmmModel instance="+instance);		master = instance instanceof MultiModelBaseBiped ? (MultiModelBaseBiped) instance : null;		if (master != null) ;else throw new RuntimeException("Modchu_LmmModel init master null !! masterClass=" + masterClass);		initAfter();	}	public void init(MultiModelBaseBiped masterModel, Object... o) {		if (masterModel != null) ;else throw new RuntimeException("Modchu_LmmModel init masterModel null !!");		master = masterModel;		initAfter();	}	private void initAfter() {		dummyModelRenderer = new MMM_ModelRenderer(this, 0, 0);		dummyModelRenderer.addBox(0, 0, 0, 0, 0, 0, 0.0F);	}	public String getModelName() {		return Modchu_Main.lastIndexProcessing(master.getClass().getSimpleName(), "_");	}	private ModchuModel_IEntityCaps getModchu_IModelCaps(Object iModelCaps) {		return ModchuModel_ModelDataMaster.instance.getPlayerData(iModelCaps);	}	public void worldEventLoad(Object event) {		if (master != null) master.worldEventLoad(event);	}	@Override	public void initModel(float psize, float pyoffset) {		if (master != null) master.initModel(psize, pyoffset);	}	public void superInitModel(float psize, float pyoffset) {	}	@Override	public float[] getArmorModelsSize() {		return master != null ? master.getArmorModelsSize() : null;	}	public float[] superGetArmorModelsSize() {		return null;	}	@Override	public float getHeight() {		return master != null ? master.getHeight(null) : 1.6F;	}	public float superGetHeight() {		return 0.8F;	}	@Override	public float getWidth() {		return master != null ? master.getWidth(null) : 0.8F;	}	public float superGetWidth() {		return 0.8F;	}	@Override	public float getyOffset() {		return master != null ? master.getYOffset(null) : 1.62F;	}	public float superGetYOffset() {		return 1.62F;	}	@Override	public float getMountedYOffset() {		return master != null ? master.getMountedYOffset(null) : 0.0F;	}	public float superGetMountedYOffset() {		return 0.0F;	}	@Override	public void renderItems(MMM_IModelCaps iModelCaps) {		if (master != null) master.renderItems(getModchu_IModelCaps(iModelCaps));	}	public void superRenderItems(Object iModelCaps) {	}	@Override	public void renderFirstPersonHand(MMM_IModelCaps iModelCaps) {		if (master != null) master.renderFirstPersonHand(getModchu_IModelCaps(iModelCaps), 0);	}	public void superRenderFirstPersonHand(Object iModelCaps) {	}	@Override	public void render(MMM_IModelCaps iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {		String eventName = "modchuLmmModelRenderBefore";		boolean isCanceled = false;		if (ModchuModel_Main.modchuLibEvent(eventName)) {			boolean flag = true;			Object[] o = ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender, this });			if (o != null) {				if (o.length > 0) isCanceled = Modchu_CastHelper.Boolean(o[0]);				else if (o.length > 1) iModelCaps = (MMM_IModelCaps) o[1];				else if (o.length > 2) par2 = Modchu_CastHelper.Float(o[2]);				else if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);				else if (o.length > 4) ticksExisted = Modchu_CastHelper.Float(o[4]);				else if (o.length > 5) pheadYaw = Modchu_CastHelper.Float(o[5]);				else if (o.length > 6) pheadPitch = Modchu_CastHelper.Float(o[6]);				else if (o.length > 7) par7 = Modchu_CastHelper.Float(o[7]);				else if (o.length > 8) pIsRender = Modchu_CastHelper.Boolean(o[8]);			}		}		if (isCanceled) return;		if (master != null) master.render(getModchu_IModelCaps(iModelCaps), par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);		else super.render(iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);		eventName = "modchuLmmModelRenderAfter";		if (ModchuModel_Main.modchuLibEvent(eventName)) ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender, this });	}	public void superRender(Object iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {		super.render((MMM_IModelCaps) iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);	}	@Override	public boolean preRender(float par2, float par3, float par4, float par5, float par6, float par7) {		return master != null ? master.preRender(null, par2, par3, par4, par5, par6, par7) : super.preRender(par2, par3, par4, par5, par6, par7);	}	public boolean superPreRender(float par2, float par3, float par4, float par5, float par6, float par7) {		return super.preRender(par2, par3, par4, par5, par6, par7);	}	@Override	public void renderExtention(float par2, float par3, float par4, float par5, float par6, float par7) {		if (master != null) master.renderExtention(null, par2, par3, par4, par5, par6, par7);		else super.renderExtention(par2, par3, par4, par5, par6, par7);	}	public void superRenderExtention(float par2, float par3, float par4, float par5, float par6, float par7) {		super.renderExtention(par2, par3, par4, par5, par6, par7);	}/*	@Override	protected void renderStabilizer(MMM_IModelCaps iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7) {		if (master != null) master.renderStabilizer(getModchu_IModelCaps(iModelCaps), par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);		else super.renderStabilizer(iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);	}	public void superRenderStabilizer(Object iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7) {		super.renderStabilizer((MMM_IModelCaps) iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);	}*/	@Override	public void changeModel(MMM_IModelCaps iModelCaps) {		if (master != null) master.changeModel(getModchu_IModelCaps(iModelCaps));		else super.changeModel(iModelCaps);	}	public void superChangeModel(Object iModelCaps) {		super.changeModel((MMM_IModelCaps) iModelCaps);	}	@Override	public void buildTexture() {		super.buildTexture();	}	public void superBuildTexture() {		super.buildTexture();	}	@Override	public void setDefaultPause() {		if (master != null) master.setDefaultPause(0F, 0F, 0F, 0F, 0F, 0F, null);		else super.setDefaultPause();	}	public void superSetDefaultPause() {		super.setDefaultPause();	}	@Override	public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, MMM_IModelCaps iModelCaps) {		if (master != null) master.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, getModchu_IModelCaps(iModelCaps));		else super.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, iModelCaps);	}	public void superSetDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, Object iModelCaps) {		super.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, (MMM_IModelCaps) iModelCaps);	}	@Override	public boolean setCapsValue(int pIndex, Object... pArg) {		return master != null ? master.setCapsValue(pIndex, pArg) : super.setCapsValue(pIndex, pArg);	}	public boolean superSetCapsValue(int pIndex, Object... pArg) {		return super.setCapsValue(pIndex, pArg);	}	@Override	public Object getCapsValue(int pIndex, Object... pArg) {		return master != null ? master.getCapsValue(pIndex, pArg) : super.getCapsValue(pIndex, pArg);	}	public Object superGetCapsValue(int pIndex, Object... pArg) {		return super.getCapsValue(pIndex, pArg);	}	@Override	public void renderFace(MMM_IModelCaps iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {		if (master != null) master.renderFace(getModchu_IModelCaps(iModelCaps), par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);		else super.renderFace(iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);	}	public void superRenderFace(Object iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {		super.renderFace((MMM_IModelCaps) iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);	}	@Override	public void renderBody(MMM_IModelCaps iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {		if (master != null) master.renderBody(getModchu_IModelCaps(iModelCaps), par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);		else super.renderBody(iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);	}	public void superRenderBody(Object iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {		super.renderBody((MMM_IModelCaps) iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);	}	@Override	public int setFaceTexture(int pIndex) {		return master != null ? master.setFaceTexture(pIndex) : super.setFaceTexture(pIndex);	}	public int superSetFaceTexture(int pIndex) {		return super.setFaceTexture(pIndex);	}	@Override	public String getUsingTexture() {		return master != null ? master.getUsingTexture() : super.getUsingTexture();	}	public String superGetUsingTexture() {		return super.getUsingTexture();	}	@Override	public float getHeight(MMM_IModelCaps iModelCaps) {		return master != null ? master.getHeight(getModchu_IModelCaps(iModelCaps)) : super.getHeight(iModelCaps);	}	public float superGetHeight(Object iModelCaps) {		return super.getHeight((MMM_IModelCaps) iModelCaps);	}	@Override	public float getWidth(MMM_IModelCaps iModelCaps) {		return master != null ? master.getWidth(getModchu_IModelCaps(iModelCaps)) : super.getWidth(iModelCaps);	}	public float superGetWidth(Object iModelCaps) {		return super.getWidth((MMM_IModelCaps) iModelCaps);	}	@Override	public float getyOffset(MMM_IModelCaps iModelCaps) {		return master != null ? master.getYOffset(getModchu_IModelCaps(iModelCaps)) : super.getyOffset(iModelCaps);	}	public float superGetYOffset(Object iModelCaps) {		return super.getyOffset((MMM_IModelCaps) iModelCaps);	}	@Override	public float getMountedYOffset(MMM_IModelCaps iModelCaps) {		return master != null ? master.getMountedYOffset(getModchu_IModelCaps(iModelCaps)) : super.getMountedYOffset(iModelCaps);	}	public float superGetMountedYOffset(Object iModelCaps) {		return super.getMountedYOffset((MMM_IModelCaps) iModelCaps);	}	@Override	public boolean isItemHolder() {		return master != null ? master.isItemHolder(null) : super.isItemHolder();	}	public boolean superIsItemHolder() {		return super.isItemHolder();	}	@Override	public boolean isItemHolder(MMM_IModelCaps iModelCaps) {		return master != null ? master.isItemHolder(getModchu_IModelCaps(iModelCaps)) : super.isItemHolder(iModelCaps);	}	public boolean superIsItemHolder(Object iModelCaps) {		return super.isItemHolder((MMM_IModelCaps) iModelCaps);	}	@Override	public void showAllParts() {		if (master != null) master.showAllParts(null);		else super.showAllParts();	}	public void superShowAllParts() {		super.showAllParts();	}	@Override	public void showAllParts(MMM_IModelCaps iModelCaps) {		if (master != null) master.showAllParts(getModchu_IModelCaps(iModelCaps));		else super.showAllParts(iModelCaps);	}	public void superShowAllParts(Object iModelCaps) {		super.showAllParts((MMM_IModelCaps) iModelCaps);	}	@Override	public int showArmorParts(int parts, int index) {		return master != null ? master.showArmorParts(null, parts, index) : super.showArmorParts(parts, index);	}	public int superShowArmorParts(int parts, int index) {		return super.showArmorParts(parts, index);	}	@Override	public Map<String, Integer> getModelCaps() {		return super.getModelCaps();	}	public Map<String, Integer> superGetModelCaps() {		return super.getModelCaps();	}	@Override	public void setRotationAngles(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, MMM_IModelCaps iModelCaps) {		String eventName = "modchuLmmModelSetRotationAnglesBefore";		boolean isCanceled = false;		if (ModchuModel_Main.modchuLibEvent(eventName)) {			boolean flag = true;			Object[] o = ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, iModelCaps, this });			if (o != null) {				if (o.length > 0) isCanceled = Modchu_CastHelper.Boolean(o[0]);				else if (o.length > 1) par1 = Modchu_CastHelper.Float(o[1]);				else if (o.length > 2) par2 = Modchu_CastHelper.Float(o[2]);				else if (o.length > 3) pTicksExisted = Modchu_CastHelper.Float(o[3]);				else if (o.length > 4) pHeadYaw = Modchu_CastHelper.Float(o[4]);				else if (o.length > 5) pHeadPitch = Modchu_CastHelper.Float(o[5]);				else if (o.length > 6) par6 = Modchu_CastHelper.Float(o[6]);				else if (o.length > 7) iModelCaps = (MMM_IModelCaps) o[7];			}		}		if (isCanceled) return;		if (master != null) master.setRotationAngles(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, getModchu_IModelCaps(iModelCaps));		else super.setRotationAngles(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, iModelCaps);		eventName = "modchuLmmModelSetRotationAnglesAfter";		if (ModchuModel_Main.modchuLibEvent(eventName)) ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, iModelCaps, this });	}	public void superSetRotationAngles(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6, Object iModelCaps) {		super.setRotationAngles(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, (MMM_IModelCaps) iModelCaps);	}	@Override	public void setLivingAnimations(MMM_IModelCaps iModelCaps, float par2, float par3, float pRenderPartialTicks) {		String eventName = "modchuLmmModelSetLivingAnimationsBefore";		boolean isCanceled = false;		if (ModchuModel_Main.modchuLibEvent(eventName)) {			boolean flag = true;			Object[] o = ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ iModelCaps, par2, par3, pRenderPartialTicks, this });			if (o != null) {				if (o.length > 0) isCanceled = Modchu_CastHelper.Boolean(o[0]);				else if (o.length > 1) iModelCaps = (MMM_IModelCaps) o[1];				else if (o.length > 2) par2 = Modchu_CastHelper.Float(o[2]);				else if (o.length > 3) par3 = Modchu_CastHelper.Float(o[3]);				else if (o.length > 4) pRenderPartialTicks = Modchu_CastHelper.Float(o[4]);			}		}		if (isCanceled) return;		if (master != null) master.setLivingAnimations(getModchu_IModelCaps(iModelCaps), par2, par3, pRenderPartialTicks);		else super.setLivingAnimations(iModelCaps, par2, par3, pRenderPartialTicks);		eventName = "modchuLmmModelSetLivingAnimationsAfter";		if (ModchuModel_Main.modchuLibEvent(eventName)) ModchuModel_Main.modchuLibEvent(eventName, new Object[]{ iModelCaps, par2, par3, pRenderPartialTicks, this });	}	public void superSetLivingAnimations(Object iModelCaps, float par2, float par3, float pRenderPartialTicks) {		super.setLivingAnimations((MMM_IModelCaps) iModelCaps, par2, par3, pRenderPartialTicks);	}	@Override	public MMM_ModelRenderer getRandomModelBox(Random random) {		if (master != null) {			Object o = master.getRandomModelBox(random);			if (o != null					&& o instanceof ModchuModel_ModelRenderer) {				ModchuModel_ModelRenderer modelRenderer = (ModchuModel_ModelRenderer) o;				dummyModelRenderer.setRotationPoint(modelRenderer.rotationPointX, modelRenderer.rotationPointY, modelRenderer.rotationPointZ);			}		}		return dummyModelRenderer;	}	public MMM_ModelRenderer superGetRandomModelBox(Object random) {		return super.getRandomModelBox((Random) random);	}/*	@Override	protected void setTextureOffset(String par1Str, int par2, int par3) {		if (master != null) master.setTextureOffset(par1Str, par2, par3);		else super.setTextureOffset(par1Str, par2, par3);	}	public void superSetTextureOffset(String par1Str, int par2, int par3) {		super.setTextureOffset(par1Str, par2, par3);	}*/	@Override	public TextureOffset getTextureOffset(String par1Str) {		return super.getTextureOffset(par1Str);	}	public TextureOffset superGetTextureOffset(String par1Str) {		return super.getTextureOffset(par1Str);	}	@Override	protected void renderStabilizer(MMM_IModelCaps iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7) {		super.renderStabilizer(iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);	}	public void superRenderStabilizer(Object iModelCaps, float par2, float par3, float ticksExisted, float pheadYaw, float pheadPitch, float par7) {		super.renderStabilizer((MMM_IModelCaps) iModelCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);	}}