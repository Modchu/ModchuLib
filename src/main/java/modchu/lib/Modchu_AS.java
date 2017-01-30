package modchu.lib;

import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_AS extends Modchu_ASAlmighty {
	public Modchu_IASMaster master;

	public static void instanceCheck() {
		if (instance != null
				&& instance instanceof Modchu_AS); else instance = new Modchu_AS();
		Modchu_Debug.lDebug("Modchu_AS init Modchu_Main.isForge="+Modchu_Main.isForge);
		String modchu_AS_ClassName = (Modchu_Main.isForge ? "modchu.lib.forge.mc" : "modchu.lib.modloader.mc")+Modchu_Main.getMinecraftVersion()+".Modchu_ASMaster";
		Modchu_Debug.lDebug("Modchu_AS init modchu_AS_ClassName="+modchu_AS_ClassName);
		Class Modchu_ASMaster = Modchu_Reflect.loadClass(modchu_AS_ClassName, 1, true);
		Modchu_Debug.lDebug("Modchu_AS init Modchu_ASMaster="+Modchu_ASMaster);
		if (Modchu_ASMaster != null); else {
			String ss = "Modchu_AS instanceCheck Modchu_ASMaster null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		HashMap<String, Object> map = new HashMap();
		map.put("Class", Modchu_ASMaster);
		map.put("Object", instance);
		//Modchu_Debug.lDebug("Modchu_AS init map="+map);
		Object instance1 = Modchu_Main.newModchuCharacteristicInstance(map);
		if (instance1 != null); else {
			String ss = "Modchu_AS instanceCheck instance1 null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Modchu_Debug.lDebug("Modchu_AS init instance="+instance1);
		((Modchu_AS) instance).master = instance1 instanceof Modchu_IASMaster ? (Modchu_IASMaster) instance1 : null;
		if (((Modchu_AS) instance).master != null); else {
			String ss = "Modchu_AS instanceCheck instance.master null error !!";
			Modchu_Main.setRuntimeException(ss);
		}
		Modchu_Debug.lDebug("Modchu_AS init end. master="+((Modchu_AS) instance).master);
	}

	public Modchu_AS() {
		super();
		instance = this;
	}

	@Override
	protected float[] convertGlColor(int i) {
		return master != null ? master.convertGlColor(i) : super.convertGlColor(i);
	}

	public float[] superConvertGlColor(int i) {
		return super.convertGlColor(i);
	}

	@Override
	protected Object abstractClientPlayerGetTextureCape(Object entity) {
		return master != null ? master.abstractClientPlayerGetTextureCape(entity) : super.abstractClientPlayerGetTextureCape(entity);
	}

	public Object superAbstractClientPlayerGetTextureCape(Object entity) {
		return super.abstractClientPlayerGetTextureCape(entity);
	}

	@Override
	protected Object abstractClientPlayerGetTextureSkin(Object entity) {
		return master != null ? master.abstractClientPlayerGetTextureSkin(entity) : super.abstractClientPlayerGetTextureSkin(entity);
	}

	public Object superAbstractClientPlayerGetTextureSkin(Object entity) {
		return super.abstractClientPlayerGetTextureSkin(entity);
	}

	@Override
	protected Object abstractClientPlayerLocationSkin(Object entity) {
		return master != null ? master.abstractClientPlayerLocationSkin(entity) : super.abstractClientPlayerLocationSkin(entity);
	}

	public Object superAbstractClientPlayerLocationSkin(Object entity) {
		return super.abstractClientPlayerLocationSkin(entity);
	}

	@Override
	protected void setAbstractClientPlayerLocationSkin(Object entity, Object o) {
		if (master != null) master.setAbstractClientPlayerLocationSkin(entity, o);
		else super.setAbstractClientPlayerLocationSkin(entity, o);
	}

	public void superSetAbstractClientPlayerLocationSkin(Object entity, Object o) {
		super.setAbstractClientPlayerLocationSkin(entity, o);
	}

	@Override
	protected void abstractClientPlayerLocationCape(Object entity, Object o) {
		if (master != null) master.abstractClientPlayerLocationCape(entity, o);
		else super.abstractClientPlayerLocationCape(entity, o);
	}

	public void superAbstractClientPlayerLocationCape(Object entity, Object o) {
		super.abstractClientPlayerLocationCape(entity, o);
	}

	@Override
	protected String abstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return master != null ? master.abstractClientPlayerGetSkinType(abstractClientPlayer) : super.abstractClientPlayerGetSkinType(abstractClientPlayer);
	}

	public String superAbstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return super.abstractClientPlayerGetSkinType(abstractClientPlayer);
	}

	@Override
	protected void allModelInit(Object render, Object entity, boolean b) {
		if (master != null) master.allModelInit(render, entity, b);
		else super.allModelInit(render, entity, b);
	}

	public void superAllModelInit(Object render, Object entity, boolean b) {
		super.allModelInit(render, entity, b);
	}

	@Override
	protected double attributeModifierGetAmount(Object attributeModifier) {
		return master != null ? master.attributeModifierGetAmount(attributeModifier) : super.attributeModifierGetAmount(attributeModifier);
	}

	public double superAttributeModifierGetAmount(Object attributeModifier) {
		return super.attributeModifierGetAmount(attributeModifier);
	}

	@Override
	protected Object getBipedArmor(Object entityPlayer, Object itemStack, int i, Object entityEquipmentSlotOrInt, String s) {
		return master != null ? master.getBipedArmor(entityPlayer, itemStack, i, entityEquipmentSlotOrInt, s) : super.getBipedArmor(entityPlayer, itemStack, i, entityEquipmentSlotOrInt, s);
	}

	public Object superGetBipedArmor(Object entityPlayer, Object itemStack, int i, Object entityEquipmentSlotOrInt, String s) {
		return super.getBipedArmor(entityPlayer, itemStack, i, entityEquipmentSlotOrInt, s);
	}

	@Override
	protected Object[] blockBlockList() {
		return master != null ? master.blockBlockList() : super.blockBlockList();
	}

	public Object[] superBlockBlockList() {
		return super.blockBlockList();
	}

	@Override
	protected Object blockGetBlockFromItem(Object item) {
		return master != null ? master.blockGetBlockFromItem(item) : super.blockGetBlockFromItem(item);
	}

	public Object superBlockGetBlockFromItem(Object item) {
		return super.blockGetBlockFromItem(item);
	}

	@Override
	protected Object blockGetStateFromMeta(Object block, int i) {
		return master != null ? master.blockGetStateFromMeta(block, i) : super.blockGetStateFromMeta(block, i);
	}

	public Object superBlockGetStateFromMeta(Object block, int i) {
		return super.blockGetStateFromMeta(block, i);
	}

	@Override
	protected float blockPosGetX(Object blockPos) {
		return master != null ? master.blockPosGetX(blockPos) : super.blockPosGetX(blockPos);
	}

	public float superBlockPosGetX(Object blockPos) {
		return super.blockPosGetX(blockPos);
	}

	@Override
	protected float blockPosGetY(Object blockPos) {
		return master != null ? master.blockPosGetY(blockPos) : super.blockPosGetY(blockPos);
	}

	public float superBlockPosGetY(Object blockPos) {
		return super.blockPosGetY(blockPos);
	}

	@Override
	protected float blockPosGetZ(Object blockPos) {
		return master != null ? master.blockPosGetZ(blockPos) : super.blockPosGetZ(blockPos);
	}

	public float superBlockPosGetZ(Object blockPos) {
		return super.blockPosGetZ(blockPos);
	}

	@Override
	protected void blockSetLightOpacity(Object block, int lightOpacity) {
		if (master != null) master.blockSetLightOpacity(block, lightOpacity);
		else super.blockSetLightOpacity(block, lightOpacity);
	}

	public void superBlockSetLightOpacity(Object block, int lightOpacity) {
		super.blockSetLightOpacity(block, lightOpacity);
	}

	@Override
	protected Object blockGetRenderType(Object block) {
		return master != null ? master.blockGetRenderType(block) : super.blockGetRenderType(block);
	}

	public Object superBlockGetRenderType(Object block) {
		return super.blockGetRenderType(block);
	}

	@Override
	protected int blockGetMetaFromState(Object block, Object iBlockState) {
		return master != null ? master.blockGetMetaFromState(block, iBlockState) : super.blockGetMetaFromState(block, iBlockState);
	}

	public int superBlockGetMetaFromState(Object block, Object iBlockState) {
		return super.blockGetMetaFromState(block, iBlockState);
	}

	@Override
	protected int blockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return master != null ? master.blockColorMultiplier(block, iBlockAccess, blockPos, i) : super.blockColorMultiplier(block, iBlockAccess, blockPos, i);
	}

	public int superBlockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return super.blockColorMultiplier(block, iBlockAccess, blockPos, i);
	}

	@Override
	protected Object blockGetDefaultState(Object block) {
		return master != null ? master.blockGetDefaultState(block) : super.blockGetDefaultState(block);
	}

	public Object superBlockGetDefaultState(Object block) {
		return super.blockGetDefaultState(block);
	}

	@Override
	protected void blockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
		if (master != null) master.blockModelRendererRenderModelBrightness(blockModelRenderer, iBakedModel, iBlockState, f, b);
		else super.blockModelRendererRenderModelBrightness(blockModelRenderer, iBakedModel, iBlockState, f, b);
	}

	public void superBlockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
		super.blockModelRendererRenderModelBrightness(blockModelRenderer, iBakedModel, iBlockState, f, b);
	}

	@Override
	protected void blockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
		if (master != null) master.blockRendererDispatcherRenderBlockBrightness(blockRendererDispatcher, iBlockState, f);
		else super.blockRendererDispatcherRenderBlockBrightness(blockRendererDispatcher, iBlockState, f);
	}

	public void superBlockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
		super.blockRendererDispatcherRenderBlockBrightness(blockRendererDispatcher, iBlockState, f);
	}

	@Override
	protected Object blockRendererDispatcherGetBakedModel(Object blockRendererDispatcher, Object iBlockState, Object blockPos) {
		return master != null ? master.blockRendererDispatcherGetBakedModel(blockRendererDispatcher, iBlockState, blockPos) : super.blockRendererDispatcherGetBakedModel(blockRendererDispatcher, iBlockState, blockPos);
	}

	public Object superBlockRendererDispatcherGetBakedModel(Object blockRendererDispatcher, Object iBlockState, Object blockPos) {
		return super.blockRendererDispatcherGetBakedModel(blockRendererDispatcher, iBlockState, blockPos);
	}

	@Override
	protected Object blockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return master != null ? master.blockRendererDispatcherGetBlockModelRenderer(blockRendererDispatcher) : super.blockRendererDispatcherGetBlockModelRenderer(blockRendererDispatcher);
	}

	public Object superBlockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return super.blockRendererDispatcherGetBlockModelRenderer(blockRendererDispatcher);
	}

	@Override
	protected Object blockDoublePlantVARIANT() {
		return master != null ? master.blockDoublePlantVARIANT() : super.blockDoublePlantVARIANT();
	}

	public Object superBlockDoublePlantVARIANT() {
		return super.blockDoublePlantVARIANT();
	}

	@Override
	protected Object blockDoublePlantHALF() {
		return master != null ? master.blockDoublePlantHALF() : super.blockDoublePlantHALF();
	}

	public Object superBlockDoublePlantHALF() {
		return super.blockDoublePlantHALF();
	}

	@Override
	protected Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return master != null ? master.axisAlignedBBGetBoundingBox(d, d1, d2, d3, d4, d5) : super.axisAlignedBBGetBoundingBox(d, d1, d2, d3, d4, d5);
	}

	public Object superAxisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return super.axisAlignedBBGetBoundingBox(d, d1, d2, d3, d4, d5);
	}

	@Override
	protected Object axisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return master != null ? master.axisAlignedBBExpand(axisAlignedBB, d, d1, d2) : super.axisAlignedBBExpand(axisAlignedBB, d, d1, d2);
	}

	public Object superAxisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return super.axisAlignedBBExpand(axisAlignedBB, d, d1, d2);
	}

	@Override
	protected Object axisAlignedBBCalculateIntercept(Object axisAlignedBB, Object vec3, Object vec3_2) {
		return master != null ? master.axisAlignedBBCalculateIntercept(axisAlignedBB, vec3, vec3_2) : super.axisAlignedBBCalculateIntercept(axisAlignedBB, vec3, vec3_2);
	}

	public Object superAxisAlignedBBCalculateIntercept(Object axisAlignedBB, Object vec3, Object vec3_2) {
		return super.axisAlignedBBCalculateIntercept(axisAlignedBB, vec3, vec3_2);
	}

	@Override
	protected boolean axisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return master != null ? master.axisAlignedBBIsVecInside(axisAlignedBB, vec3) : super.axisAlignedBBIsVecInside(axisAlignedBB, vec3);
	}

	public boolean superAxisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return super.axisAlignedBBIsVecInside(axisAlignedBB, vec3);
	}

	@Override
	protected Object damageSourceAnvil() {
		return master != null ? master.damageSourceAnvil() : super.damageSourceAnvil();
	}

	public Object superDamageSourceAnvil() {
		return super.damageSourceAnvil();
	}

	@Override
	protected Object damageSourceCactus() {
		return master != null ? master.damageSourceCactus() : super.damageSourceCactus();
	}

	public Object superDamageSourceCactus() {
		return super.damageSourceCactus();
	}

	@Override
	protected Object damageSourceDrown() {
		return master != null ? master.damageSourceDrown() : super.damageSourceDrown();
	}

	public Object superDamageSourceDrown() {
		return super.damageSourceDrown();
	}

	@Override
	protected Object damageSourceFall() {
		return master != null ? master.damageSourceFall() : super.damageSourceFall();
	}

	public Object superDamageSourceFall() {
		return super.damageSourceFall();
	}

	@Override
	protected Object damageSourceFallingBlock() {
		return master != null ? master.damageSourceFallingBlock() : super.damageSourceFallingBlock();
	}

	public Object superDamageSourceFallingBlock() {
		return super.damageSourceFallingBlock();
	}

	@Override
	protected Object damageSourceGeneric() {
		return master != null ? master.damageSourceGeneric() : super.damageSourceGeneric();
	}

	public Object superDamageSourceGeneric() {
		return super.damageSourceGeneric();
	}

	@Override
	protected Object damageSourceInFire() {
		return master != null ? master.damageSourceInFire() : super.damageSourceInFire();
	}

	public Object superDamageSourceInFire() {
		return super.damageSourceInFire();
	}

	@Override
	protected Object damageSourceInWall() {
		return master != null ? master.damageSourceInWall() : super.damageSourceInWall();
	}

	public Object superDamageSourceInWall() {
		return super.damageSourceInWall();
	}

	@Override
	protected Object damageSourceLava() {
		return master != null ? master.damageSourceLava() : super.damageSourceLava();
	}

	public Object superDamageSourceLava() {
		return super.damageSourceLava();
	}

	@Override
	protected Object damageSourceMagic() {
		return master != null ? master.damageSourceMagic() : super.damageSourceMagic();
	}

	public Object superDamageSourceMagic() {
		return super.damageSourceMagic();
	}

	@Override
	protected Object damageSourceOnFire() {
		return master != null ? master.damageSourceOnFire() : super.damageSourceOnFire();
	}

	public Object superDamageSourceOnFire() {
		return super.damageSourceOnFire();
	}

	@Override
	protected Object damageSourceOutOfWorld() {
		return master != null ? master.damageSourceOutOfWorld() : super.damageSourceOutOfWorld();
	}

	public Object superDamageSourceOutOfWorld() {
		return super.damageSourceOutOfWorld();
	}

	@Override
	protected Object damageSourceStarve() {
		return master != null ? master.damageSourceStarve() : super.damageSourceStarve();
	}

	public Object superDamageSourceStarve() {
		return super.damageSourceStarve();
	}

	@Override
	protected Object damageSourceWither() {
		return master != null ? master.damageSourceWither() : super.damageSourceWither();
	}

	public Object superDamageSourceWither() {
		return super.damageSourceWither();
	}

	@Override
	protected Object damageSourceGetEntity(Object damageSource) {
		return master != null ? master.damageSourceGetEntity(damageSource) : super.damageSourceGetEntity(damageSource);
	}

	public Object superDamageSourceGetEntity(Object damageSource) {
		return super.damageSourceGetEntity(damageSource);
	}

	@Override
	protected boolean damageSourceIsFireDamage(Object damageSource) {
		return master != null ? master.damageSourceIsFireDamage(damageSource) : super.damageSourceIsFireDamage(damageSource);
	}

	public boolean superDamageSourceIsFireDamage(Object damageSource) {
		return super.damageSourceIsFireDamage(damageSource);
	}

	@Override
	protected Object damageSourceCauseMobDamage(Object entityLivingBase) {
		return master != null ? master.damageSourceCauseMobDamage(entityLivingBase) : super.damageSourceCauseMobDamage(entityLivingBase);
	}

	public Object superDamageSourceCauseMobDamage(Object entityLivingBase) {
		return super.damageSourceCauseMobDamage(entityLivingBase);
	}

	@Override
	protected Object potionMoveSpeed() {
		return master != null ? master.potionMoveSpeed() : super.potionMoveSpeed();
	}

	public Object superPotionMoveSpeed() {
		return super.potionMoveSpeed();
	}

	@Override
	protected Object potionMoveSlowdown() {
		return master != null ? master.potionMoveSlowdown() : super.potionMoveSlowdown();
	}

	public Object superPotionMoveSlowdown() {
		return super.potionMoveSlowdown();
	}

	@Override
	protected Object potionDigSpeed() {
		return master != null ? master.potionDigSpeed() : super.potionDigSpeed();
	}

	public Object superPotionDigSpeed() {
		return super.potionDigSpeed();
	}

	@Override
	protected Object potionDigSlowdown() {
		return master != null ? master.potionDigSlowdown() : super.potionDigSlowdown();
	}

	public Object superPotionDigSlowdown() {
		return super.potionDigSlowdown();
	}

	@Override
	protected Object potionDamageBoost() {
		return master != null ? master.potionDamageBoost() : super.potionDamageBoost();
	}

	public Object superPotionDamageBoost() {
		return super.potionDamageBoost();
	}

	@Override
	protected Object potionHeal() {
		return master != null ? master.potionHeal() : super.potionHeal();
	}

	public Object superPotionHeal() {
		return super.potionHeal();
	}

	@Override
	protected Object potionHarm() {
		return master != null ? master.potionHarm() : super.potionHarm();
	}

	public Object superPotionHarm() {
		return super.potionHarm();
	}

	@Override
	protected Object potionJump() {
		return master != null ? master.potionJump() : super.potionJump();
	}

	public Object superPotionJump() {
		return super.potionJump();
	}

	@Override
	protected Object potionConfusion() {
		return master != null ? master.potionConfusion() : super.potionConfusion();
	}

	public Object superPotionConfusion() {
		return super.potionConfusion();
	}

	@Override
	protected Object potionRegeneration() {
		return master != null ? master.potionRegeneration() : super.potionRegeneration();
	}

	public Object superPotionRegeneration() {
		return super.potionRegeneration();
	}

	@Override
	protected Object potionResistance() {
		return master != null ? master.potionResistance() : super.potionResistance();
	}

	public Object superPotionResistance() {
		return super.potionResistance();
	}

	@Override
	protected Object potionFireResistance() {
		return master != null ? master.potionFireResistance() : super.potionFireResistance();
	}

	public Object superPotionFireResistance() {
		return super.potionFireResistance();
	}

	@Override
	protected Object potionWaterBreathing() {
		return master != null ? master.potionWaterBreathing() : super.potionWaterBreathing();
	}

	public Object superPotionWaterBreathing() {
		return super.potionWaterBreathing();
	}

	@Override
	protected Object potionInvisibility() {
		return master != null ? master.potionInvisibility() : super.potionInvisibility();
	}

	public Object superPotionInvisibility() {
		return super.potionInvisibility();
	}

	@Override
	protected Object potionBlindness() {
		return master != null ? master.potionBlindness() : super.potionBlindness();
	}

	public Object superPotionBlindness() {
		return super.potionBlindness();
	}

	@Override
	protected Object potionNightVision() {
		return master != null ? master.potionNightVision() : super.potionNightVision();
	}

	public Object superPotionNightVision() {
		return super.potionNightVision();
	}

	@Override
	protected Object potionHunger() {
		return master != null ? master.potionHunger() : super.potionHunger();
	}

	public Object superPotionHunger() {
		return super.potionHunger();
	}

	@Override
	protected Object potionWeakness() {
		return master != null ? master.potionWeakness() : super.potionWeakness();
	}

	public Object superPotionWeakness() {
		return super.potionWeakness();
	}

	@Override
	protected Object potionPoison() {
		return master != null ? master.potionPoison() : super.potionPoison();
	}

	public Object superPotionPoison() {
		return super.potionPoison();
	}

	@Override
	protected Object potionWither() {
		return master != null ? master.potionWither() : super.potionWither();
	}

	public Object superPotionWither() {
		return super.potionWither();
	}

	@Override
	protected Object potionHealthBoost() {
		return master != null ? master.potionHealthBoost() : super.potionHealthBoost();
	}

	public Object superPotionHealthBoost() {
		return super.potionHealthBoost();
	}

	@Override
	protected Object potionAbsorption() {
		return master != null ? master.potionAbsorption() : super.potionAbsorption();
	}

	public Object superPotionAbsorption() {
		return super.potionAbsorption();
	}

	@Override
	protected Object potionSaturation() {
		return master != null ? master.potionSaturation() : super.potionSaturation();
	}

	public Object superPotionSaturation() {
		return super.potionSaturation();
	}

	@Override
	protected Object entityLivingCurrentTarget() {
		return master != null ? master.entityLivingCurrentTarget() : super.entityLivingCurrentTarget();
	}

	public Object superEntityLivingCurrentTarget() {
		return super.entityLivingCurrentTarget();
	}

	@Override
	protected Object entityLivingCurrentTarget(Object entityLivingBase) {
		return master != null ? master.entityLivingCurrentTarget(entityLivingBase) : super.entityLivingCurrentTarget(entityLivingBase);
	}

	public Object superEntityLivingCurrentTarget(Object entityLivingBase) {
		return super.entityLivingCurrentTarget(entityLivingBase);
	}

	@Override
	protected Object entityAnimalInLove(Object entityLivingBase) {
		return master != null ? master.entityAnimalInLove(entityLivingBase) : super.entityAnimalInLove(entityLivingBase);
	}

	public Object superEntityAnimalInLove(Object entityLivingBase) {
		return super.entityAnimalInLove(entityLivingBase);
	}

	@Override
	protected void setEntityAnimalInLove(Object entityLivingBase, int i) {
		if (master != null) master.setEntityAnimalInLove(entityLivingBase, i);
		else super.setEntityAnimalInLove(entityLivingBase, i);
	}

	public void superSetEntityAnimalInLove(Object entityLivingBase, int i) {
		super.setEntityAnimalInLove(entityLivingBase, i);
	}

	@Override
	protected Object entityLivingBaseGetEquipmentInSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt) {
		return master != null ? master.entityLivingBaseGetEquipmentInSlot(entityLivingBase, entityEquipmentSlotOrInt) : super.entityLivingBaseGetEquipmentInSlot(entityLivingBase, entityEquipmentSlotOrInt);
	}

	public Object superEntityLivingBaseGetEquipmentInSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt) {
		return super.entityLivingBaseGetEquipmentInSlot(entityLivingBase, entityEquipmentSlotOrInt);
	}

	@Override
	protected Object entityArrowShootingEntity(Object entityArrow) {
		return master != null ? master.entityArrowShootingEntity(entityArrow) : super.entityArrowShootingEntity(entityArrow);
	}

	public Object superEntityArrowShootingEntity(Object entityArrow) {
		return super.entityArrowShootingEntity(entityArrow);
	}

	@Override
	protected boolean entityAttackEntityFrom(Object entity, Object damageSource, float f) {
		return master != null ? master.entityAttackEntityFrom(entity, damageSource, f) : super.entityAttackEntityFrom(entity, damageSource, f);
	}

	public boolean superEntityAttackEntityFrom(Object entity, Object damageSource, float f) {
		return super.entityAttackEntityFrom(entity, damageSource, f);
	}

	@Override
	protected int entityLivingBaseEntityAge(Object entity) {
		return master != null ? master.entityLivingBaseEntityAge(entity) : super.entityLivingBaseEntityAge(entity);
	}

	public int superEntityLivingBaseEntityAge(Object entity) {
		return super.entityLivingBaseEntityAge(entity);
	}

	@Override
	protected Object entityLivingBaseGetLook(Object entityLivingBase, float f) {
		return master != null ? master.entityLivingBaseGetLook(entityLivingBase, f) : super.entityLivingBaseGetLook(entityLivingBase, f);
	}

	public Object superEntityLivingBaseGetLook(Object entityLivingBase, float f) {
		return super.entityLivingBaseGetLook(entityLivingBase, f);
	}

	@Override
	protected void setEntityLivingBaseEntityAge(Object entity, int i) {
		if (master != null) master.setEntityLivingBaseEntityAge(entity, i);
		else super.setEntityLivingBaseEntityAge(entity, i);
	}

	public void superSetEntityLivingBaseEntityAge(Object entity, int i) {
		super.setEntityLivingBaseEntityAge(entity, i);
	}

	@Override
	protected Object entityBoundingBox(Object entity) {
		return master != null ? master.entityBoundingBox(entity) : super.entityBoundingBox(entity);
	}

	public Object superEntityBoundingBox(Object entity) {
		return super.entityBoundingBox(entity);
	}

	@Override
	protected double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		return master != null ? master.entityBoundingBoxMaxX(entityOrBoundingBox) : super.entityBoundingBoxMaxX(entityOrBoundingBox);
	}

	public double superEntityBoundingBoxMaxX(Object entityOrBoundingBox) {
		return super.entityBoundingBoxMaxX(entityOrBoundingBox);
	}

	@Override
	protected double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		return master != null ? master.entityBoundingBoxMaxY(entityOrBoundingBox) : super.entityBoundingBoxMaxY(entityOrBoundingBox);
	}

	public double superEntityBoundingBoxMaxY(Object entityOrBoundingBox) {
		return super.entityBoundingBoxMaxY(entityOrBoundingBox);
	}

	@Override
	protected double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		return master != null ? master.entityBoundingBoxMaxZ(entityOrBoundingBox) : super.entityBoundingBoxMaxZ(entityOrBoundingBox);
	}

	public double superEntityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		return super.entityBoundingBoxMaxZ(entityOrBoundingBox);
	}

	@Override
	protected double entityBoundingBoxMinX(Object entity) {
		return master != null ? master.entityBoundingBoxMinX(entity) : super.entityBoundingBoxMinX(entity);
	}

	public double superEntityBoundingBoxMinX(Object entity) {
		return super.entityBoundingBoxMinX(entity);
	}

	@Override
	protected double entityBoundingBoxMinY(Object entity) {
		return master != null ? master.entityBoundingBoxMinY(entity) : super.entityBoundingBoxMinY(entity);
	}

	public double superEntityBoundingBoxMinY(Object entity) {
		return super.entityBoundingBoxMinY(entity);
	}

	@Override
	protected double entityBoundingBoxMinZ(Object entity) {
		return master != null ? master.entityBoundingBoxMinZ(entity) : super.entityBoundingBoxMinZ(entity);
	}

	public double superEntityBoundingBoxMinZ(Object entity) {
		return super.entityBoundingBoxMinZ(entity);
	}

	@Override
	protected String entityCloakUrl(Object entity) {
		return master != null ? master.entityCloakUrl(entity) : super.entityCloakUrl(entity);
	}

	public String superEntityCloakUrl(Object entity) {
		return super.entityCloakUrl(entity);
	}

	@Override
	protected int entityDimension(Object entity) {
		return master != null ? master.entityDimension(entity) : super.entityDimension(entity);
	}

	public int superEntityDimension(Object entity) {
		return super.entityDimension(entity);
	}

	@Override
	protected void setEntityDimension(Object entity, int i) {
		if (master != null) master.setEntityDimension(entity, i);
		else super.setEntityDimension(entity, i);
	}

	public void superSetEntityDimension(Object entity, int i) {
		super.setEntityDimension(entity, i);
	}

	@Override
	protected float entityDistanceWalkedModified(Object entity) {
		return master != null ? master.entityDistanceWalkedModified(entity) : super.entityDistanceWalkedModified(entity);
	}

	public float superEntityDistanceWalkedModified(Object entity) {
		return super.entityDistanceWalkedModified(entity);
	}

	@Override
	protected int entityEntityID(Object entity) {
		return master != null ? master.entityEntityID(entity) : super.entityEntityID(entity);
	}

	public int superEntityEntityID(Object entity) {
		return super.entityEntityID(entity);
	}

	@Override
	protected float entityGetBrightness(Object entity, float f) {
		return master != null ? master.entityGetBrightness(entity, f) : super.entityGetBrightness(entity, f);
	}

	public float superEntityGetBrightness(Object entity, float f) {
		return super.entityGetBrightness(entity, f);
	}

	@Override
	protected int entityGetBrightnessForRender(Object entity, float f) {
		return master != null ? master.entityGetBrightnessForRender(entity, f) : super.entityGetBrightnessForRender(entity, f);
	}

	public int superEntityGetBrightnessForRender(Object entity, float f) {
		return super.entityGetBrightnessForRender(entity, f);
	}

	@Override
	protected Object entityGetDataWatcher(Object dataManagerOrEntity) {
		return master != null ? master.entityGetDataWatcher(dataManagerOrEntity) : super.entityGetDataWatcher(dataManagerOrEntity);
	}

	public Object superEntityGetDataWatcher(Object dataManagerOrEntity) {
		return super.entityGetDataWatcher(dataManagerOrEntity);
	}

	@Override
	protected void entitySetCustomNameTag(Object entity, String s) {
		if (master != null) master.entitySetCustomNameTag(entity, s);
		else super.entitySetCustomNameTag(entity, s);
	}

	public void superEntitySetCustomNameTag(Object entity, String s) {
		super.entitySetCustomNameTag(entity, s);
	}

	@Override
	protected Object dataManagerGetWatchedObject(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return master != null ? master.dataManagerGetWatchedObject(dataManagerOrEntity, dataParameterOrInt) : super.dataManagerGetWatchedObject(dataManagerOrEntity, dataParameterOrInt);
	}

	public Object superDataWatcherGetWatchedObject(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return super.dataManagerGetWatchedObject(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	protected void dataManagerAddObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		if (master != null) master.dataManagerAddObject(dataManagerOrEntity, dataParameterOrInt, o);
		else super.dataManagerAddObject(dataManagerOrEntity, dataParameterOrInt, o);
	}

	public void superDataWatcherAddObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		super.dataManagerAddObject(dataManagerOrEntity, dataParameterOrInt, o);
	}

	@Override
	protected Object dataManagerGetWatchableObjectItemStack(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return master != null ? master.dataManagerGetWatchableObjectItemStack(dataManagerOrEntity, dataParameterOrInt) : super.dataManagerGetWatchableObjectItemStack(dataManagerOrEntity, dataParameterOrInt);
	}

	public Object superDataWatcherGetWatchableObjectItemStack(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return super.dataManagerGetWatchableObjectItemStack(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	protected String dataManagerGetWatchableObjectString(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return master != null ? master.dataManagerGetWatchableObjectString(dataManagerOrEntity, dataParameterOrInt) : super.dataManagerGetWatchableObjectString(dataManagerOrEntity, dataParameterOrInt);
	}

	public String superDataWatcherGetWatchableObjectString(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return super.dataManagerGetWatchableObjectString(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	protected byte dataManagerGetWatchableObjectByte(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return master != null ? master.dataManagerGetWatchableObjectByte(dataManagerOrEntity, dataParameterOrInt) : super.dataManagerGetWatchableObjectByte(dataManagerOrEntity, dataParameterOrInt);
	}

	public byte superDataWatcherGetWatchableObjectByte(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return super.dataManagerGetWatchableObjectByte(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	protected void dataManagerUpdateObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		if (master != null) master.dataManagerUpdateObject(dataManagerOrEntity, dataParameterOrInt, o);
		else super.dataManagerUpdateObject(dataManagerOrEntity, dataParameterOrInt, o);
	}

	public void superDataWatcherUpdateObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		super.dataManagerUpdateObject(dataManagerOrEntity, dataParameterOrInt, o);
	}

	@Override
	protected void entityAITasksAddTask(Object entityAITasks, int i, Object entityAIBase) {
		if (master != null) master.entityAITasksAddTask(entityAITasks, i, entityAIBase);
		else super.entityAITasksAddTask(entityAITasks, i, entityAIBase);
	}

	public void superEntityAITasksAddTask(Object entityAITasks, int i, Object entityAIBase) {
		super.entityAITasksAddTask(entityAITasks, i, entityAIBase);
	}

	@Override
	protected float entityGetEyeHeight(Object entityplayer) {
		return master != null ? master.entityGetEyeHeight(entityplayer) : super.entityGetEyeHeight(entityplayer);
	}

	public float superEntityGetEyeHeight(Object entityplayer) {
		return super.entityGetEyeHeight(entityplayer);
	}

	@Override
	protected float entityHeight(Object entity) {
		return master != null ? master.entityHeight(entity) : super.entityHeight(entity);
	}

	public float superEntityHeight(Object entity) {
		return super.entityHeight(entity);
	}

	@Override
	protected boolean entityIsInvisible(Object entity) {
		return master != null ? master.entityIsInvisible(entity) : super.entityIsInvisible(entity);
	}

	public boolean superEntityIsInvisible(Object entity) {
		return super.entityIsInvisible(entity);
	}

	@Override
	protected boolean entityIsInWater(Object entity) {
		return master != null ? master.entityIsInWater(entity) : super.entityIsInWater(entity);
	}

	public boolean superEntityIsInWater(Object entity) {
		return super.entityIsInWater(entity);
	}

	@Override
	protected boolean entityIsRiding(Object entity) {
		return master != null ? master.entityIsRiding(entity) : super.entityIsRiding(entity);
	}

	public boolean superEntityIsRiding(Object entity) {
		return super.entityIsRiding(entity);
	}

	@Override
	protected boolean entityIsSneaking(Object entity) {
		return master != null ? master.entityIsSneaking(entity) : super.entityIsSneaking(entity);
	}

	public boolean superEntityIsSneaking(Object entity) {
		return super.entityIsSneaking(entity);
	}

	@Override
	protected boolean entityIsWet(Object entity) {
		return master != null ? master.entityIsWet(entity) : super.entityIsWet(entity);
	}

	public boolean superEntityIsWet(Object entity) {
		return super.entityIsWet(entity);
	}

	@Override
	protected void entityOnUpdate(Object entity) {
		if (master != null) master.entityOnUpdate(entity);
		else super.entityOnUpdate(entity);
	}

	public void superEntityOnUpdate(Object entity) {
		super.entityOnUpdate(entity);
	}

	@Override
	protected boolean entityStartRiding(Object entity) {
		return master != null ? master.entityStartRiding(entity) : super.entityStartRiding(entity);
	}

	public boolean superEntityStartRiding(Object entity) {
		return super.entityStartRiding(entity);
	}

	@Override
	protected boolean entityStartRiding(Object entity, Object entity2) {
		return master != null ? master.entityStartRiding(entity, entity2) : super.entityStartRiding(entity, entity2);
	}

	public boolean superEntityStartRiding(Object entity, Object entity2) {
		return super.entityStartRiding(entity, entity2);
	}

	@Override
	protected boolean entityStartRiding(Object entity, Object entity2, boolean b) {
		return master != null ? master.entityStartRiding(entity, entity2, b) : super.entityStartRiding(entity, entity2, b);
	}

	public boolean superEntityStartRiding(Object entity, Object entity2, boolean b) {
		return super.entityStartRiding(entity, entity2, b);
	}

	@Override
	protected Object entityLivingTasks(Object entityLiving) {
		return master != null ? master.entityLivingTasks(entityLiving) : super.entityLivingTasks(entityLiving);
	}

	public Object superEntityLivingTasks(Object entityLiving) {
		return super.entityLivingTasks(entityLiving);
	}

	@Override
	protected void entityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		if (master != null) master.entityLivingBaseSetPositionAndUpdate(entity, x, y, z);
		else super.entityLivingBaseSetPositionAndUpdate(entity, x, y, z);
	}

	public void superEntityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		super.entityLivingBaseSetPositionAndUpdate(entity, x, y, z);
	}

	@Override
	protected Map entityListStringToClassMapping() {
		return master != null ? master.entityListStringToClassMapping() : super.entityListStringToClassMapping();
	}

	public Map superEntityListStringToClassMapping() {
		return super.entityListStringToClassMapping();
	}

	@Override
	protected Map entityListClassToStringMapping() {
		return master != null ? master.entityListClassToStringMapping() : super.entityListClassToStringMapping();
	}

	public Map superEntityListClassToStringMapping() {
		return super.entityListClassToStringMapping();
	}

	@Override
	protected Map entityListIDtoClassMapping() {
		return master != null ? master.entityListIDtoClassMapping() : super.entityListIDtoClassMapping();
	}

	public Map superEntityListIDtoClassMapping() {
		return super.entityListIDtoClassMapping();
	}

	@Override
	protected Map entityListClassToIDMapping() {
		return master != null ? master.entityListClassToIDMapping() : super.entityListClassToIDMapping();
	}

	public Map superEntityListClassToIDMapping() {
		return super.entityListClassToIDMapping();
	}

	@Override
	protected void entitySetLocationAndAngles(Object entity, double x, double y, double z, float f, float f1) {
		if (master != null) master.entitySetLocationAndAngles(entity, x, y, z, f, f1);
		else super.entitySetLocationAndAngles(entity, x, y, z, f, f1);
	}

	public void superEntitySetLocationAndAngles(Object entity, double x, double y, double z, float f, float f1) {
		super.entitySetLocationAndAngles(entity, x, y, z, f, f1);
	}

	@Override
	protected void entitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		if (master != null) master.entitySetPositionAndRotation(entity, x, y, z, f, f1);
		else super.entitySetPositionAndRotation(entity, x, y, z, f, f1);
	}

	public void superEntitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		super.entitySetPositionAndRotation(entity, x, y, z, f, f1);
	}

	@Override
	protected int entityAnimalBreeding(Object entityAnimal) {
		return master != null ? master.entityAnimalBreeding(entityAnimal) : super.entityAnimalBreeding(entityAnimal);
	}

	public int superEntityAnimalBreeding(Object entityAnimal) {
		return super.entityAnimalBreeding(entityAnimal);
	}

	@Override
	protected void setEntityAnimalBreeding(Object entityAnimal, int i) {
		if (master != null) master.setEntityAnimalBreeding(entityAnimal, i);
		else super.setEntityAnimalBreeding(entityAnimal, i);
	}

	public void superSetEntityAnimalBreeding(Object entityAnimal, int i) {
		super.setEntityAnimalBreeding(entityAnimal, i);
	}

	@Override
	protected boolean entityCreatureHasAttacked(Object entity) {
		return master != null ? master.entityCreatureHasAttacked(entity) : super.entityCreatureHasAttacked(entity);
	}

	public boolean superEntityCreatureHasAttacked(Object entity) {
		return super.entityCreatureHasAttacked(entity);
	}

	@Override
	protected void setEntityCreatureHasAttacked(Object entity, boolean b) {
		if (master != null) master.setEntityCreatureHasAttacked(entity, b);
		else super.setEntityCreatureHasAttacked(entity, b);
	}

	public void superSetEntityCreatureHasAttacked(Object entity, boolean b) {
		super.setEntityCreatureHasAttacked(entity, b);
	}

	@Override
	protected float entityGetDistanceToEntity(Object entity, Object entity2) {
		return master != null ? master.entityGetDistanceToEntity(entity, entity2) : super.entityGetDistanceToEntity(entity, entity2);
	}

	public float superEntityGetDistanceToEntity(Object entity, Object entity2) {
		return super.entityGetDistanceToEntity(entity, entity2);
	}

	@Override
	protected boolean entityIsEntityAlive(Object entity) {
		return master != null ? master.entityIsEntityAlive(entity) : super.entityIsEntityAlive(entity);
	}

	public boolean superEntityIsEntityAlive(Object entity) {
		return super.entityIsEntityAlive(entity);
	}

	@Override
	protected Object entityCreatureEntityToAttack(Object entity) {
		return master != null ? master.entityCreatureEntityToAttack(entity) : super.entityCreatureEntityToAttack(entity);
	}

	public Object superEntityCreatureEntityToAttack(Object entity) {
		return super.entityCreatureEntityToAttack(entity);
	}

	@Override
	protected int entityLivingNumTicksToChaseTarget(Object entityLiving) {
		return master != null ? master.entityLivingNumTicksToChaseTarget(entityLiving) : super.entityLivingNumTicksToChaseTarget(entityLiving);
	}

	public int superEntityLivingNumTicksToChaseTarget(Object entityLiving) {
		return super.entityLivingNumTicksToChaseTarget(entityLiving);
	}

	@Override
	protected void setEntityLivingNumTicksToChaseTarget(Object entityLiving, int i) {
		if (master != null) master.setEntityLivingNumTicksToChaseTarget(entityLiving, i);
		else super.setEntityLivingNumTicksToChaseTarget(entityLiving, i);
	}

	public void superSetEntityLivingNumTicksToChaseTarget(Object entityLiving, int i) {
		super.setEntityLivingNumTicksToChaseTarget(entityLiving, i);
	}

	@Override
	protected Object entityCreatureGetEntityToAttack(Object entity) {
		return master != null ? master.entityCreatureGetEntityToAttack(entity) : super.entityCreatureGetEntityToAttack(entity);
	}

	public Object superEntityCreatureGetEntityToAttack(Object entity) {
		return super.entityCreatureGetEntityToAttack(entity);
	}

	@Override
	protected void setEntityCreatureEntityToAttack(Object entity, Object entity2) {
		if (master != null) master.setEntityCreatureEntityToAttack(entity, entity2);
		else super.setEntityCreatureEntityToAttack(entity, entity2);
	}

	public void superSetEntityCreatureEntityToAttack(Object entity, Object entity2) {
		super.setEntityCreatureEntityToAttack(entity, entity2);
	}

	@Override
	protected void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
		if (master != null) master.entityClientPlayerMPFunc_142020_c(entityClientPlayerMP, s);
		else super.entityClientPlayerMPFunc_142020_c(entityClientPlayerMP, s);
	}

	public void superEntityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
		super.entityClientPlayerMPFunc_142020_c(entityClientPlayerMP, s);
	}

	@Override
	protected String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return master != null ? master.entityClientPlayerMPFunc_142021_k(entityClientPlayerMP) : super.entityClientPlayerMPFunc_142021_k(entityClientPlayerMP);
	}

	public String superEntityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return super.entityClientPlayerMPFunc_142021_k(entityClientPlayerMP);
	}

	@Override
	protected void entityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
		if (master != null) master.entityCreatureSetPathToEntity(entityCreature, entityPath);
		else super.entityCreatureSetPathToEntity(entityCreature, entityPath);
	}

	public void superEntityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
		super.entityCreatureSetPathToEntity(entityCreature, entityPath);
	}

	@Override
	protected float entityLivingBaseGetSoundVolume(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseGetSoundVolume(entityLivingBase) : super.entityLivingBaseGetSoundVolume(entityLivingBase);
	}

	public float superEntityLivingBaseGetSoundVolume(Object entityLivingBase) {
		return super.entityLivingBaseGetSoundVolume(entityLivingBase);
	}

	@Override
	protected float entityLivingBaseGetSoundPitch(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseGetSoundPitch(entityLivingBase) : super.entityLivingBaseGetSoundPitch(entityLivingBase);
	}

	public float superEntityLivingBaseGetSoundPitch(Object entityLivingBase) {
		return super.entityLivingBaseGetSoundPitch(entityLivingBase);
	}

	@Override
	protected float entityLastDamage(Object entityLivingBase) {
		return master != null ? master.entityLastDamage(entityLivingBase) : super.entityLastDamage(entityLivingBase);
	}

	public float superEntityLastDamage(Object entityLivingBase) {
		return super.entityLastDamage(entityLivingBase);
	}

	@Override
	protected int entityLivingBaseRecentlyHit(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseRecentlyHit(entityLivingBase) : super.entityLivingBaseRecentlyHit(entityLivingBase);
	}

	public int superEntityLivingBaseRecentlyHit(Object entityLivingBase) {
		return super.entityLivingBaseRecentlyHit(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBaseRecentlyHit(Object entityLivingBase, int i) {
		if (master != null) master.setEntityLivingBaseRecentlyHit(entityLivingBase, i);
		else super.setEntityLivingBaseRecentlyHit(entityLivingBase, i);
	}

	public void superSetEntityLivingBaseRecentlyHit(Object entityLivingBase, int i) {
		super.setEntityLivingBaseRecentlyHit(entityLivingBase, i);
	}

	@Override
	protected int entityLivingBaseAttackingPlayer(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseAttackingPlayer(entityLivingBase) : super.entityLivingBaseAttackingPlayer(entityLivingBase);
	}

	public int superEntityLivingBaseAttackingPlayer(Object entityLivingBase) {
		return super.entityLivingBaseAttackingPlayer(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBaseAttackingPlayer(Object entityLivingBase, Object entityLivingBase2) {
		if (master != null) master.setEntityLivingBaseAttackingPlayer(entityLivingBase, entityLivingBase2);
		else super.setEntityLivingBaseAttackingPlayer(entityLivingBase, entityLivingBase2);
	}

	public void superSetEntityLivingBaseAttackingPlayer(Object entityLivingBase, Object entityLivingBase2) {
		super.setEntityLivingBaseAttackingPlayer(entityLivingBase, entityLivingBase2);
	}

	@Override
	protected int entityLivingBaseDeathTime(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseDeathTime(entityLivingBase) : super.entityLivingBaseDeathTime(entityLivingBase);
	}

	public int superEntityLivingBaseDeathTime(Object entityLivingBase) {
		return super.entityLivingBaseDeathTime(entityLivingBase);
	}

	@Override
	protected int entityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseMaxHurtResistantTime(entityLivingBase) : super.entityLivingBaseMaxHurtResistantTime(entityLivingBase);
	}

	public int superEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return super.entityLivingBaseMaxHurtResistantTime(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		if (master != null) master.setEntityLivingBaseMaxHurtResistantTime(entityLivingBase, i);
		else super.setEntityLivingBaseMaxHurtResistantTime(entityLivingBase, i);
	}

	public void superSetEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		super.setEntityLivingBaseMaxHurtResistantTime(entityLivingBase, i);
	}

	@Override
	protected int entityHurtResistantTime(Object entity) {
		return master != null ? master.entityHurtResistantTime(entity) : super.entityHurtResistantTime(entity);
	}

	public int superEntityHurtResistantTime(Object entity) {
		return super.entityHurtResistantTime(entity);
	}

	@Override
	protected void setEntityHurtResistantTime(Object entity, int i) {
		if (master != null) master.setEntityHurtResistantTime(entity, i);
		else super.setEntityHurtResistantTime(entity, i);
	}

	public void superSetEntityHurtResistantTime(Object entity, int i) {
		super.setEntityHurtResistantTime(entity, i);
	}

	@Override
	protected UUID entityGetUniqueID(Object entity) {
		return master != null ? master.entityGetUniqueID(entity) : super.entityGetUniqueID(entity);
	}

	public UUID superEntityGetUniqueID(Object entity) {
		return super.entityGetUniqueID(entity);
	}

	@Override
	protected Object entityLivingBaseGetHeldItem(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseGetHeldItem(entityLivingBase) : super.entityLivingBaseGetHeldItem(entityLivingBase);
	}

	public Object superEntityLivingBaseGetHeldItem(Object entityLivingBase) {
		return super.entityLivingBaseGetHeldItem(entityLivingBase);
	}

	@Override
	protected Object entityLivingBaseGetHeldItem(Object entityLivingBase, Object enumHand) {
		return master != null ? master.entityLivingBaseGetHeldItem(entityLivingBase, enumHand) : super.entityLivingBaseGetHeldItem(entityLivingBase, enumHand);
	}

	public Object superEntityLivingBaseGetHeldItem(Object entityLivingBase, Object enumHand) {
		return super.entityLivingBaseGetHeldItem(entityLivingBase, enumHand);
	}

	@Override
	protected float entityLivingBaseGetHealth(Object entity) {
		return master != null ? master.entityLivingBaseGetHealth(entity) : super.entityLivingBaseGetHealth(entity);
	}

	public float superEntityLivingBaseGetHealth(Object entity) {
		return super.entityLivingBaseGetHealth(entity);
	}

	@Override
	protected float entityLivingBaseGetMaxHealth(Object entity) {
		return master != null ? master.entityLivingBaseGetMaxHealth(entity) : super.entityLivingBaseGetMaxHealth(entity);
	}

	public float superEntityLivingBaseGetMaxHealth(Object entity) {
		return super.entityLivingBaseGetMaxHealth(entity);
	}

	@Override
	protected void entityLivingBaseDamageEntity(Object entity, Object damageSource, float f) {
		if (master != null) master.entityLivingBaseDamageEntity(entity, damageSource, f);
		else super.entityLivingBaseDamageEntity(entity, damageSource, f);
	}

	public void superEntityLivingBaseDamageEntity(Object entity, Object damageSource, float f) {
		super.entityLivingBaseDamageEntity(entity, damageSource, f);
	}

	@Override
	protected void entityLivingBaseHeal(Object entityLivingBase, float f) {
		if (master != null) master.entityLivingBaseHeal(entityLivingBase, f);
		else super.entityLivingBaseHeal(entityLivingBase, f);
	}

	public void superEntityLivingBaseHeal(Object entityLivingBase, float f) {
		super.entityLivingBaseHeal(entityLivingBase, f);
	}

	@Override
	protected void entityLivingBaseSetRevengeTarget(Object entity, Object entity2) {
		if (master != null) master.entityLivingBaseSetRevengeTarget(entity, entity2);
		else super.entityLivingBaseSetRevengeTarget(entity, entity2);
	}

	public void superEntityLivingBaseSetRevengeTarget(Object entity, Object entity2) {
		super.entityLivingBaseSetRevengeTarget(entity, entity2);
	}

	@Override
	protected float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return master != null ? master.entityLivingBaseGetSwingProgress(entity, f) : super.entityLivingBaseGetSwingProgress(entity, f);
	}

	public float superEntityLivingBaseGetSwingProgress(Object entity, float f) {
		return super.entityLivingBaseGetSwingProgress(entity, f);
	}

	@Override
	protected float entityLivingBaseHealth(Object entity) {
		return master != null ? master.entityLivingBaseHealth(entity) : super.entityLivingBaseHealth(entity);
	}

	public float superEntityLivingBaseHealth(Object entity) {
		return super.entityLivingBaseHealth(entity);
	}

	@Override
	protected boolean entityLivingBaseIsJumping(Object entity) {
		return master != null ? master.entityLivingBaseIsJumping(entity) : super.entityLivingBaseIsJumping(entity);
	}

	public boolean superEntityLivingBaseIsJumping(Object entity) {
		return super.entityLivingBaseIsJumping(entity);
	}

	@Override
	protected float entityLivingBaseLimbSwing(Object entity) {
		return master != null ? master.entityLivingBaseLimbSwing(entity) : super.entityLivingBaseLimbSwing(entity);
	}

	public float superEntityLivingBaseLimbSwing(Object entity) {
		return super.entityLivingBaseLimbSwing(entity);
	}

	@Override
	protected void setEntityLivingBaseLimbSwing(Object entity, float f) {
		if (master != null) master.setEntityLivingBaseLimbSwing(entity, f);
		else super.setEntityLivingBaseLimbSwing(entity, f);
	}

	public void superSetEntityLivingBaseLimbSwing(Object entity, float f) {
		super.setEntityLivingBaseLimbSwing(entity, f);
	}

	@Override
	protected float entityLivingBaseLimbSwingAmount(Object entity) {
		return master != null ? master.entityLivingBaseLimbSwingAmount(entity) : super.entityLivingBaseLimbSwingAmount(entity);
	}

	public float superEntityLivingBaseLimbSwingAmount(Object entity) {
		return super.entityLivingBaseLimbSwingAmount(entity);
	}

	@Override
	protected void setEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		if (master != null) master.setEntityLivingBaseLimbSwingAmount(entity, f);
		else super.setEntityLivingBaseLimbSwingAmount(entity, f);
	}

	public void superSetEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		super.setEntityLivingBaseLimbSwingAmount(entity, f);
	}

	@Override
	protected float entityLivingBaseMoveForward(Object entityplayer) {
		return master != null ? master.entityLivingBaseMoveForward(entityplayer) : super.entityLivingBaseMoveForward(entityplayer);
	}

	public float superEntityLivingBaseMoveForward(Object entityplayer) {
		return super.entityLivingBaseMoveForward(entityplayer);
	}

	@Override
	protected void setEntityLivingBaseMoveForward(Object entityplayer, float f) {
		if (master != null) master.setEntityLivingBaseMoveForward(entityplayer, f);
		else super.setEntityLivingBaseMoveForward(entityplayer, f);
	}

	public void superSetEntityLivingBaseMoveForward(Object entityplayer, float f) {
		super.setEntityLivingBaseMoveForward(entityplayer, f);
	}

	@Override
	protected float entityLivingBaseMoveStrafing(Object entityplayer) {
		return master != null ? master.entityLivingBaseMoveStrafing(entityplayer) : super.entityLivingBaseMoveStrafing(entityplayer);
	}

	public float superEntityLivingBaseMoveStrafing(Object entityplayer) {
		return super.entityLivingBaseMoveStrafing(entityplayer);
	}

	@Override
	protected void setEntityLivingBaseMoveStrafing(Object entityplayer, float f) {
		if (master != null) master.setEntityLivingBaseMoveStrafing(entityplayer, f);
		else super.setEntityLivingBaseMoveStrafing(entityplayer, f);
	}

	public void superSetEntityLivingBaseMoveStrafing(Object entityplayer, float f) {
		super.setEntityLivingBaseMoveStrafing(entityplayer, f);
	}

	@Override
	protected float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return master != null ? master.entityLivingBasePrevLimbSwingAmount(entity) : super.entityLivingBasePrevLimbSwingAmount(entity);
	}

	public float superEntityLivingBasePrevLimbSwingAmount(Object entity) {
		return super.entityLivingBasePrevLimbSwingAmount(entity);
	}

	@Override
	protected void setEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		if (master != null) master.setEntityLivingBasePrevLimbSwingAmount(entity, f);
		else super.setEntityLivingBasePrevLimbSwingAmount(entity, f);
	}

	public void superSetEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		super.setEntityLivingBasePrevLimbSwingAmount(entity, f);
	}

	@Override
	protected float entityLivingBasePrevRenderYawOffset(Object entity) {
		return master != null ? master.entityLivingBasePrevRenderYawOffset(entity) : super.entityLivingBasePrevRenderYawOffset(entity);
	}

	public float superEntityLivingBasePrevRenderYawOffset(Object entity) {
		return super.entityLivingBasePrevRenderYawOffset(entity);
	}

	@Override
	protected void setEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		if (master != null) master.setEntityLivingBasePrevRenderYawOffset(entity, f);
		else super.setEntityLivingBasePrevRenderYawOffset(entity, f);
	}

	public void superSetEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		super.setEntityLivingBasePrevRenderYawOffset(entity, f);
	}

	@Override
	protected float entityLivingBasePrevRotationYawHead(Object entity) {
		return master != null ? master.entityLivingBasePrevRotationYawHead(entity) : super.entityLivingBasePrevRotationYawHead(entity);
	}

	public float superEntityLivingBasePrevRotationYawHead(Object entity) {
		return super.entityLivingBasePrevRotationYawHead(entity);
	}

	@Override
	protected void setEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		if (master != null) master.setEntityLivingBasePrevRotationYawHead(entity, f);
		else super.setEntityLivingBasePrevRotationYawHead(entity, f);
	}

	public void superSetEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		super.setEntityLivingBasePrevRotationYawHead(entity, f);
	}

	@Override
	protected float entityLivingBaseRenderYawOffset(Object entity) {
		return master != null ? master.entityLivingBaseRenderYawOffset(entity) : super.entityLivingBaseRenderYawOffset(entity);
	}

	public float superEntityLivingBaseRenderYawOffset(Object entity) {
		return super.entityLivingBaseRenderYawOffset(entity);
	}

	@Override
	protected void setEntityLivingBaseRenderYawOffset(Object entity, float f) {
		if (master != null) master.setEntityLivingBaseRenderYawOffset(entity, f);
		else super.setEntityLivingBaseRenderYawOffset(entity, f);
	}

	public void superSetEntityLivingBaseRenderYawOffset(Object entity, float f) {
		super.setEntityLivingBaseRenderYawOffset(entity, f);
	}

	@Override
	protected float entityLivingBaseRotationYawHead(Object entity) {
		return master != null ? master.entityLivingBaseRotationYawHead(entity) : super.entityLivingBaseRotationYawHead(entity);
	}

	public float superEntityLivingBaseRotationYawHead(Object entity) {
		return super.entityLivingBaseRotationYawHead(entity);
	}

	@Override
	protected void setEntityLivingBaseRotationYawHead(Object entity, float f) {
		if (master != null) master.setEntityLivingBaseRotationYawHead(entity, f);
		else super.setEntityLivingBaseRotationYawHead(entity, f);
	}

	public void superSetEntityLivingBaseRotationYawHead(Object entity, float f) {
		super.setEntityLivingBaseRotationYawHead(entity, f);
	}

	@Override
	protected void entityLivingBaseSetHealth(Object entity, float f) {
		if (master != null) master.entityLivingBaseSetHealth(entity, f);
		else super.entityLivingBaseSetHealth(entity, f);
	}

	public void superEntityLivingBaseSetHealth(Object entity, float f) {
		super.entityLivingBaseSetHealth(entity, f);
	}

	@Override
	protected int entityLivingGetHealth(Object entity) {
		return master != null ? master.entityLivingGetHealth(entity) : super.entityLivingGetHealth(entity);
	}

	public int superEntityLivingGetHealth(Object entity) {
		return super.entityLivingGetHealth(entity);
	}

	@Override
	protected int entityLivingGetMaxHealth(Object entity) {
		return master != null ? master.entityLivingGetMaxHealth(entity) : super.entityLivingGetMaxHealth(entity);
	}

	public int superEntityLivingGetMaxHealth(Object entity) {
		return super.entityLivingGetMaxHealth(entity);
	}

	@Override
	protected Object entityTameableAiSit(Object entityTameable) {
		return master != null ? master.entityTameableAiSit(entityTameable) : super.entityTameableAiSit(entityTameable);
	}

	public Object superEntityTameableAiSit(Object entityTameable) {
		return super.entityTameableAiSit(entityTameable);
	}

	@Override
	protected String entityTameableGetOwnerName(Object entityTameable) {
		return master != null ? master.entityTameableGetOwnerName(entityTameable) : super.entityTameableGetOwnerName(entityTameable);
	}

	public String superEntityTameableGetOwnerName(Object entityTameable) {
		return super.entityTameableGetOwnerName(entityTameable);
	}

	@Override
	protected void entityTameableSetOwner(Object entityTameable) {
		if (master != null) master.entityTameableSetOwner(entityTameable);
		else super.entityTameableSetOwner(entityTameable);
	}

	public void superEntityTameableSetOwner(Object entityTameable) {
		super.entityTameableSetOwner(entityTameable);
	}

	@Override
	protected void entityTameableSetOwner(Object entityTameable, Object entityOrString) {
		if (master != null) master.entityTameableSetOwner(entityTameable, entityOrString);
		else super.entityTameableSetOwner(entityTameable, entityOrString);
	}

	public void superEntityTameableSetOwner(Object entityTameable, Object uUIDOrString) {
		super.entityTameableSetOwner(entityTameable, uUIDOrString);
	}

	@Override
	protected void entityLivingSetHealth(Object entity, int i) {
		if (master != null) master.entityLivingSetHealth(entity, i);
		else super.entityLivingSetHealth(entity, i);
	}

	public void superEntityLivingSetHealth(Object entity, int i) {
		super.entityLivingSetHealth(entity, i);
	}

	@Override
	protected double entityMotionX(Object entity) {
		return master != null ? master.entityMotionX(entity) : super.entityMotionX(entity);
	}

	public double superEntityMotionX(Object entity) {
		return super.entityMotionX(entity);
	}

	@Override
	protected double entityMotionY(Object entity) {
		return master != null ? master.entityMotionY(entity) : super.entityMotionY(entity);
	}

	public double superEntityMotionY(Object entity) {
		return super.entityMotionY(entity);
	}

	@Override
	protected double entityMotionZ(Object entity) {
		return master != null ? master.entityMotionZ(entity) : super.entityMotionZ(entity);
	}

	public double superEntityMotionZ(Object entity) {
		return super.entityMotionZ(entity);
	}

	@Override
	protected Object entityPlayerArmorInventory(Object entityplayerORInventory) {
		return master != null ? master.entityPlayerArmorInventory(entityplayerORInventory) : super.entityPlayerArmorInventory(entityplayerORInventory);
	}

	public Object superEntityPlayerArmorInventory(Object entityplayerORInventory) {
		return super.entityPlayerArmorInventory(entityplayerORInventory);
	}

	@Override
	protected float entityPlayerCameraYaw(Object entity) {
		return master != null ? master.entityPlayerCameraYaw(entity) : super.entityPlayerCameraYaw(entity);
	}

	public float superEntityPlayerCameraYaw(Object entity) {
		return super.entityPlayerCameraYaw(entity);
	}

	@Override
	protected float entityPlayerCurrentXP(Object entityplayer) {
		return master != null ? master.entityPlayerCurrentXP(entityplayer) : super.entityPlayerCurrentXP(entityplayer);
	}

	public float superEntityPlayerCurrentXP(Object entityplayer) {
		return super.entityPlayerCurrentXP(entityplayer);
	}

	@Override
	protected double entityPlayerChasingPosZ(Object entityplayer) {
		return master != null ? master.entityPlayerChasingPosZ(entityplayer) : super.entityPlayerChasingPosZ(entityplayer);
	}

	public double superEntityPlayerChasingPosZ(Object entityplayer) {
		return super.entityPlayerChasingPosZ(entityplayer);
	}

	@Override
	protected double entityPlayerPrevChasingPosX(Object entityplayer) {
		return master != null ? master.entityPlayerPrevChasingPosX(entityplayer) : super.entityPlayerPrevChasingPosX(entityplayer);
	}

	public double superEntityPlayerPrevChasingPosX(Object entityplayer) {
		return super.entityPlayerPrevChasingPosX(entityplayer);
	}

	@Override
	protected double entityPlayerChasingPosX(Object entityplayer) {
		return master != null ? master.entityPlayerChasingPosX(entityplayer) : super.entityPlayerChasingPosX(entityplayer);
	}

	public double superEntityPlayerChasingPosX(Object entityplayer) {
		return super.entityPlayerChasingPosX(entityplayer);
	}

	@Override
	protected double entityPlayerChasingPosY(Object entityplayer) {
		return master != null ? master.entityPlayerChasingPosY(entityplayer) : super.entityPlayerChasingPosY(entityplayer);
	}

	public double superEntityPlayerChasingPosY(Object entityplayer) {
		return super.entityPlayerChasingPosY(entityplayer);
	}

	@Override
	protected double entityPlayerPrevChasingPosY(Object entityplayer) {
		return master != null ? master.entityPlayerPrevChasingPosY(entityplayer) : super.entityPlayerPrevChasingPosY(entityplayer);
	}

	public double superEntityPlayerPrevChasingPosY(Object entityplayer) {
		return super.entityPlayerPrevChasingPosY(entityplayer);
	}

	@Override
	protected double entityPlayerPrevChasingPosZ(Object entityplayer) {
		return master != null ? master.entityPlayerPrevChasingPosZ(entityplayer) : super.entityPlayerPrevChasingPosZ(entityplayer);
	}

	public double superEntityPlayerPrevChasingPosZ(Object entityplayer) {
		return super.entityPlayerPrevChasingPosZ(entityplayer);
	}

	@Override
	protected Object entityPlayerFoodStats(Object entityplayer) {
		return master != null ? master.entityPlayerFoodStats(entityplayer) : super.entityPlayerFoodStats(entityplayer);
	}

	public Object superEntityPlayerFoodStats(Object entityplayer) {
		return super.entityPlayerFoodStats(entityplayer);
	}

	@Override
	protected Object entityplayerGetCurrentEquippedItem(Object entityplayer) {
		return master != null ? master.entityplayerGetCurrentEquippedItem(entityplayer) : super.entityplayerGetCurrentEquippedItem(entityplayer);
	}

	public Object superEntityplayerGetCurrentEquippedItem(Object entityplayer) {
		return super.entityplayerGetCurrentEquippedItem(entityplayer);
	}

	@Override
	protected Object entityPlayerGetFoodStats(Object entityplayer) {
		return master != null ? master.entityPlayerGetFoodStats(entityplayer) : super.entityPlayerGetFoodStats(entityplayer);
	}

	public Object superEntityPlayerGetFoodStats(Object entityplayer) {
		return super.entityPlayerGetFoodStats(entityplayer);
	}

	@Override
	protected boolean entityPlayerGetHideCape(Object entityplayer) {
		return master != null ? master.entityPlayerGetHideCape(entityplayer) : super.entityPlayerGetHideCape(entityplayer);
	}

	public boolean superEntityPlayerGetHideCape(Object entityplayer) {
		return super.entityPlayerGetHideCape(entityplayer);
	}

	@Override
	protected int entityPlayerGetItemInUseCount(Object entityplayer) {
		return master != null ? master.entityPlayerGetItemInUseCount(entityplayer) : super.entityPlayerGetItemInUseCount(entityplayer);
	}

	public int superEntityPlayerGetItemInUseCount(Object entityplayer) {
		return super.entityPlayerGetItemInUseCount(entityplayer);
	}

	@Override
	protected Object entityPlayerInventory(Object entityplayer) {
		return master != null ? master.entityPlayerInventory(entityplayer) : super.entityPlayerInventory(entityplayer);
	}

	public Object superEntityPlayerInventory(Object entityplayer) {
		return super.entityPlayerInventory(entityplayer);
	}

	@Override
	protected Object entityPlayerInventoryGetCurrentItem(Object entityplayer) {
		return master != null ? master.entityPlayerInventoryGetCurrentItem(entityplayer) : super.entityPlayerInventoryGetCurrentItem(entityplayer);
	}

	public Object superEntityPlayerInventoryGetCurrentItem(Object entityplayer) {
		return super.entityPlayerInventoryGetCurrentItem(entityplayer);
	}

	@Override
	protected int entityPlayerInventoryCurrentItem(Object entityplayer) {
		return master != null ? master.entityPlayerInventoryCurrentItem(entityplayer) : super.entityPlayerInventoryCurrentItem(entityplayer);
	}

	public int superEntityPlayerInventoryCurrentItem(Object entityplayer) {
		return super.entityPlayerInventoryCurrentItem(entityplayer);
	}

	@Override
	protected void setEntityPlayerInventoryCurrentItem(Object entityplayer, int i) {
		if (master != null) master.setEntityPlayerInventoryCurrentItem(entityplayer, i);
		else super.setEntityPlayerInventoryCurrentItem(entityplayer, i);
	}

	public void superSetEntityPlayerInventoryCurrentItem(Object entityplayer, int i) {
		super.setEntityPlayerInventoryCurrentItem(entityplayer, i);
	}

	@Override
	protected Object entityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return master != null ? master.entityPlayerInventoryGetStackInSlot(entityplayer, i) : super.entityPlayerInventoryGetStackInSlot(entityplayer, i);
	}

	public Object superEntityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return super.entityPlayerInventoryGetStackInSlot(entityplayer, i);
	}

	@Override
	protected Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		return master != null ? master.entityPlayerInventoryPlayerArmorItemInSlot(entityplayerORInventory, i) : super.entityPlayerInventoryPlayerArmorItemInSlot(entityplayerORInventory, i);
	}

	public Object superEntityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		return super.entityPlayerInventoryPlayerArmorItemInSlot(entityplayerORInventory, i);
	}

	@Override
	protected void entityPlayerInventorySetInventorySlotContents(Object entityplayer, int i, Object itemstack) {
		if (master != null) master.entityPlayerInventorySetInventorySlotContents(entityplayer, i, itemstack);
		else super.entityPlayerInventorySetInventorySlotContents(entityplayer, i, itemstack);
	}

	public void superEntityPlayerInventorySetInventorySlotContents(Object entityplayer, int i, Object itemstack) {
		super.entityPlayerInventorySetInventorySlotContents(entityplayer, i, itemstack);
	}

	@Override
	protected boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return master != null ? master.entityPlayerIsPlayerSleeping(entityplayer) : super.entityPlayerIsPlayerSleeping(entityplayer);
	}

	public boolean superEntityPlayerIsPlayerSleeping(Object entityplayer) {
		return super.entityPlayerIsPlayerSleeping(entityplayer);
	}

	@Override
	protected boolean entityPlayerCapabilitiesIsCreativeMode(Object entityplayer) {
		return master != null ? master.entityPlayerCapabilitiesIsCreativeMode(entityplayer) : super.entityPlayerCapabilitiesIsCreativeMode(entityplayer);
	}

	public boolean superEntityPlayerCapabilitiesIsCreativeMode(Object entityplayer) {
		return super.entityPlayerCapabilitiesIsCreativeMode(entityplayer);
	}

	@Override
	protected Object entityPlayerMainInventory(Object entityplayerORInventory) {
		return master != null ? master.entityPlayerMainInventory(entityplayerORInventory) : super.entityPlayerMainInventory(entityplayerORInventory);
	}

	public Object superEntityPlayerMainInventory(Object entityplayerORInventory) {
		return super.entityPlayerMainInventory(entityplayerORInventory);
	}

	@Override
	protected void entityPlayerPreparePlayerToSpawn(Object entityplayer) {
		if (master != null) master.entityPlayerPreparePlayerToSpawn(entityplayer);
		else super.entityPlayerPreparePlayerToSpawn(entityplayer);
	}

	public void superEntityPlayerPreparePlayerToSpawn(Object entityplayer) {
		super.entityPlayerPreparePlayerToSpawn(entityplayer);
	}

	@Override
	protected Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return master != null ? master.entityClientPlayerMPSendQueue(entityClientPlayerMP) : super.entityClientPlayerMPSendQueue(entityClientPlayerMP);
	}

	public Object superEntityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return super.entityClientPlayerMPSendQueue(entityClientPlayerMP);
	}

	@Override
	protected void entityLivingBaseSwingItem(Object entityLivingBase) {
		if (master != null) master.entityLivingBaseSwingItem(entityLivingBase);
		else super.entityLivingBaseSwingItem(entityLivingBase);
	}

	public void superEntityLivingBaseSwingItem(Object entityLivingBase) {
		super.entityLivingBaseSwingItem(entityLivingBase);
	}

	@Override
	protected void entityLivingBaseSwingItem(Object entityLivingBase, Object enumHand) {
		if (master != null) master.entityLivingBaseSwingItem(entityLivingBase, enumHand);
		else super.entityLivingBaseSwingItem(entityLivingBase, enumHand);
	}

	public void superEntityLivingBaseSwingItem(Object entityLivingBase, Object enumHand) {
		super.entityLivingBaseSwingItem(entityLivingBase, enumHand);
	}

	@Override
	protected int entityPlayerPlayerLevel(Object entityplayer) {
		return master != null ? master.entityPlayerPlayerLevel(entityplayer) : super.entityPlayerPlayerLevel(entityplayer);
	}

	public int superEntityPlayerPlayerLevel(Object entityplayer) {
		return super.entityPlayerPlayerLevel(entityplayer);
	}

	@Override
	protected float entityPlayerPrevCameraYaw(Object entity) {
		return master != null ? master.entityPlayerPrevCameraYaw(entity) : super.entityPlayerPrevCameraYaw(entity);
	}

	public float superEntityPlayerPrevCameraYaw(Object entity) {
		return super.entityPlayerPrevCameraYaw(entity);
	}

	@Override
	protected int entityPlayerScore(Object entityplayer) {
		return master != null ? master.entityPlayerScore(entityplayer) : super.entityPlayerScore(entityplayer);
	}

	public int superEntityPlayerScore(Object entityplayer) {
		return super.entityPlayerScore(entityplayer);
	}

	@Override
	protected void entityPlayerSPFunc_6420_o(Object entityplayer) {
		if (master != null) master.entityPlayerSPFunc_6420_o(entityplayer);
		else super.entityPlayerSPFunc_6420_o(entityplayer);
	}

	public void superEntityPlayerSPFunc_6420_o(Object entityplayer) {
		super.entityPlayerSPFunc_6420_o(entityplayer);
	}

	@Override
	protected int entityPlayerTotalXP(Object entityplayer) {
		return master != null ? master.entityPlayerTotalXP(entityplayer) : super.entityPlayerTotalXP(entityplayer);
	}

	public int superEntityPlayerTotalXP(Object entityplayer) {
		return super.entityPlayerTotalXP(entityplayer);
	}

	@Override
	protected void entityPlayerSetItemInUse(Object entityplayer, Object itemstack, int i) {
		if (master != null) master.entityPlayerSetItemInUse(entityplayer, itemstack, i);
		else super.entityPlayerSetItemInUse(entityplayer, itemstack, i);
	}

	public void superEntityPlayerSetItemInUse(Object entityplayer, Object itemstack, int i) {
		super.entityPlayerSetItemInUse(entityplayer, itemstack, i);
	}

	@Override
	protected void entityPlayerDestroyCurrentEquippedItem(Object entityplayer) {
		if (master != null) master.entityPlayerDestroyCurrentEquippedItem(entityplayer);
		else super.entityPlayerDestroyCurrentEquippedItem(entityplayer);
	}

	public void superEntityPlayerDestroyCurrentEquippedItem(Object entityplayer) {
		super.entityPlayerDestroyCurrentEquippedItem(entityplayer);
	}

	@Override
	protected boolean entityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		return master != null ? master.entityPlayerCanPlayerEdit(entityplayer, x, y, z, i, itemStack) : super.entityPlayerCanPlayerEdit(entityplayer, x, y, z, i, itemStack);
	}

	public boolean superEntityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		return super.entityPlayerCanPlayerEdit(entityplayer, x, y, z, i, itemStack);
	}

	@Override
	protected Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return master != null ? master.entityPlayerMPPlayerNetServerHandler(entityplayerMP) : super.entityPlayerMPPlayerNetServerHandler(entityplayerMP);
	}

	public Object superEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return super.entityPlayerMPPlayerNetServerHandler(entityplayerMP);
	}

	@Override
	protected void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netServerHandler) {
		if (master != null) master.setEntityPlayerMPPlayerNetServerHandler(entityplayerMP, netServerHandler);
		else super.setEntityPlayerMPPlayerNetServerHandler(entityplayerMP, netServerHandler);
	}

	public void superSetEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netServerHandler) {
		super.setEntityPlayerMPPlayerNetServerHandler(entityplayerMP, netServerHandler);
	}

	@Override
	protected Object entityPlayerFishEntity(Object entityplayer) {
		return master != null ? master.entityPlayerFishEntity(entityplayer) : super.entityPlayerFishEntity(entityplayer);
	}

	public Object superEntityPlayerFishEntity(Object entityplayer) {
		return super.entityPlayerFishEntity(entityplayer);
	}

	@Override
	protected void setEntityPlayerFishEntity(Object entityplayer, Object entityFishHook) {
		if (master != null) master.setEntityPlayerFishEntity(entityplayer, entityFishHook);
		else super.setEntityPlayerFishEntity(entityplayer, entityFishHook);
	}

	public void superSetEntityPlayerFishEntity(Object entityplayer, Object entityFishHook) {
		super.setEntityPlayerFishEntity(entityplayer, entityFishHook);
	}

	@Override
	protected boolean entityZombieIsVillager(Object entityZombie) {
		return master != null ? master.entityZombieIsVillager(entityZombie) : super.entityZombieIsVillager(entityZombie);
	}

	public boolean superEntityZombieIsVillager(Object entityZombie) {
		return super.entityZombieIsVillager(entityZombie);
	}

	@Override
	protected void entityZombieSetVillager(Object entityZombie, boolean b) {
		if (master != null) master.entityZombieSetVillager(entityZombie, b);
		else super.entityZombieSetVillager(entityZombie, b);
	}

	public void superEntityZombieSetVillager(Object entityZombie, boolean b) {
		super.entityZombieSetVillager(entityZombie, b);
	}

	@Override
	protected double entityPosX(Object entity) {
		return master != null ? master.entityPosX(entity) : super.entityPosX(entity);
	}

	public double superEntityPosX(Object entity) {
		return super.entityPosX(entity);
	}

	@Override
	protected double entityPosY(Object entity) {
		return master != null ? master.entityPosY(entity) : super.entityPosY(entity);
	}

	public double superEntityPosY(Object entity) {
		return super.entityPosY(entity);
	}

	@Override
	protected double entityPosZ(Object entity) {
		return master != null ? master.entityPosZ(entity) : super.entityPosZ(entity);
	}

	public double superEntityPosZ(Object entity) {
		return super.entityPosZ(entity);
	}

	@Override
	protected float entityPrevDistanceWalkedModified(Object entity) {
		return master != null ? master.entityPrevDistanceWalkedModified(entity) : super.entityPrevDistanceWalkedModified(entity);
	}

	public float superEntityPrevDistanceWalkedModified(Object entity) {
		return super.entityPrevDistanceWalkedModified(entity);
	}

	@Override
	protected double entityPrevPosX(Object entity) {
		return master != null ? master.entityPrevPosX(entity) : super.entityPrevPosX(entity);
	}

	public double superEntityPrevPosX(Object entity) {
		return super.entityPrevPosX(entity);
	}

	@Override
	protected double entityPrevPosY(Object entity) {
		return master != null ? master.entityPrevPosY(entity) : super.entityPrevPosY(entity);
	}

	public double superEntityPrevPosY(Object entity) {
		return super.entityPrevPosY(entity);
	}

	@Override
	protected double entityPrevPosZ(Object entity) {
		return master != null ? master.entityPrevPosZ(entity) : super.entityPrevPosZ(entity);
	}

	public double superEntityPrevPosZ(Object entity) {
		return super.entityPrevPosZ(entity);
	}

	@Override
	protected float entityPrevRotationPitch(Object entity) {
		return master != null ? master.entityPrevRotationPitch(entity) : super.entityPrevRotationPitch(entity);
	}

	public float superEntityPrevRotationPitch(Object entity) {
		return super.entityPrevRotationPitch(entity);
	}

	@Override
	protected void setEntityPrevRotationPitch(Object entity, float f) {
		if (master != null) master.setEntityPrevRotationPitch(entity, f);
		else super.setEntityPrevRotationPitch(entity, f);
	}

	public void superSetEntityPrevRotationPitch(Object entity, float f) {
		super.setEntityPrevRotationPitch(entity, f);
	}

	@Override
	protected float entityPrevRotationYaw(Object entity) {
		return master != null ? master.entityPrevRotationYaw(entity) : super.entityPrevRotationYaw(entity);
	}

	public float superEntityPrevRotationYaw(Object entity) {
		return super.entityPrevRotationYaw(entity);
	}

	@Override
	protected void setEntityPrevRotationYaw(Object entity, float f) {
		if (master != null) master.setEntityPrevRotationYaw(entity, f);
		else super.setEntityPrevRotationYaw(entity, f);
	}

	public void superSetEntityPrevRotationYaw(Object entity, float f) {
		super.setEntityPrevRotationYaw(entity, f);
	}

	@Override
	protected Object entityRidingEntity(Object entity) {
		return master != null ? master.entityRidingEntity(entity) : super.entityRidingEntity(entity);
	}

	public Object superEntityRidingEntity(Object entity) {
		return super.entityRidingEntity(entity);
	}

	@Override
	protected Object entityGetCollisionBoundingBox(Object entity) {
		return master != null ? master.entityGetCollisionBoundingBox(entity) : super.entityGetCollisionBoundingBox(entity);
	}

	public Object superEntityGetCollisionBoundingBox(Object entity) {
		return super.entityGetCollisionBoundingBox(entity);
	}

	@Override
	protected boolean entityCanBeCollidedWith(Object entity) {
		return master != null ? master.entityCanBeCollidedWith(entity) : super.entityCanBeCollidedWith(entity);
	}

	public boolean superEntityCanBeCollidedWith(Object entity) {
		return super.entityCanBeCollidedWith(entity);
	}

	@Override
	protected float entityGetCollisionBorderSize(Object entity) {
		return master != null ? master.entityGetCollisionBorderSize(entity) : super.entityGetCollisionBorderSize(entity);
	}

	public float superEntityGetCollisionBorderSize(Object entity) {
		return super.entityGetCollisionBorderSize(entity);
	}

	@Override
	protected void setEntityRidingEntity(Object entity, Object entity2) {
		if (master != null) master.setEntityRidingEntity(entity, entity2);
		else super.setEntityRidingEntity(entity, entity2);
	}

	public void superSetEntityRidingEntity(Object entity, Object entity2) {
		super.setEntityRidingEntity(entity, entity2);
	}

	@Override
	protected Object entityRiddenByEntity(Object entity) {
		return master != null ? master.entityRiddenByEntity(entity) : super.entityRiddenByEntity(entity);
	}

	public Object superEntityRiddenByEntity(Object entity) {
		return super.entityRiddenByEntity(entity);
	}

	@Override
	protected void setEntityRiddenByEntity(Object entity, Object entity2) {
		if (master != null) master.setEntityRiddenByEntity(entity, entity2);
		else super.setEntityRiddenByEntity(entity, entity2);
	}

	public void superSetEntityRiddenByEntity(Object entity, Object entity2) {
		super.setEntityRiddenByEntity(entity, entity2);
	}

	@Override
	protected boolean entityIsDead(Object entity) {
		return master != null ? master.entityIsDead(entity) : super.entityIsDead(entity);
	}

	public boolean superEntityIsDead(Object entity) {
		return super.entityIsDead(entity);
	}

	@Override
	protected boolean entityTameableIsTamed(Object entityTameable) {
		return master != null ? master.entityTameableIsTamed(entityTameable) : super.entityTameableIsTamed(entityTameable);
	}

	public boolean superEntityTameableIsTamed(Object entityTameable) {
		return super.entityTameableIsTamed(entityTameable);
	}

	@Override
	protected boolean entityHorseIsTame(Object entityHorse) {
		return master != null ? master.entityHorseIsTame(entityHorse) : super.entityHorseIsTame(entityHorse);
	}

	public boolean superEntityHorseIsTame(Object entityHorse) {
		return super.entityHorseIsTame(entityHorse);
	}

	@Override
	protected boolean isTamed(Object entity) {
		return master != null ? master.isTamed(entity) : super.isTamed(entity);
	}

	public boolean superIsTamed(Object entity) {
		return super.isTamed(entity);
	}

	@Override
	protected void setEntityIsDead(Object entity, boolean b) {
		if (master != null) master.setEntityIsDead(entity, b);
		else super.setEntityIsDead(entity, b);
	}

	public void superSetEntityIsDead(Object entity, boolean b) {
		super.setEntityIsDead(entity, b);
	}

	@Override
	protected float entityRotationPitch(Object entity) {
		return master != null ? master.entityRotationPitch(entity) : super.entityRotationPitch(entity);
	}

	public float superEntityRotationPitch(Object entity) {
		return super.entityRotationPitch(entity);
	}

	@Override
	protected void setEntityRotationPitch(Object entity, float f) {
		if (master != null) master.setEntityRotationPitch(entity, f);
		else super.setEntityRotationPitch(entity, f);
	}

	public void superSetEntityRotationPitch(Object entity, float f) {
		super.setEntityRotationPitch(entity, f);
	}

	@Override
	protected float entityRotationYaw(Object entity) {
		return master != null ? master.entityRotationYaw(entity) : super.entityRotationYaw(entity);
	}

	public float superEntityRotationYaw(Object entity) {
		return super.entityRotationYaw(entity);
	}

	@Override
	protected void setEntityRotationYaw(Object entity, float f) {
		if (master != null) master.setEntityRotationYaw(entity, f);
		else super.setEntityRotationYaw(entity, f);
	}

	public void superSetEntityRotationYaw(Object entity, float f) {
		super.setEntityRotationYaw(entity, f);
	}

	@Override
	protected void entitySetDead(Object entity) {
		if (master != null) master.entitySetDead(entity);
		else super.entitySetDead(entity);
	}

	public void superEntitySetDead(Object entity) {
		super.entitySetDead(entity);
	}

	@Override
	protected void entitySetFire(Object entity, int i) {
		if (master != null) master.entitySetFire(entity, i);
		else super.entitySetFire(entity, i);
	}

	public void superEntitySetFire(Object entity, int i) {
		super.entitySetFire(entity, i);
	}

	@Override
	protected void entitySetPosition(Object entity, double x, double y, double z) {
		if (master != null) master.entitySetPosition(entity, x, y, z);
		else super.entitySetPosition(entity, x, y, z);
	}

	public void superEntitySetPosition(Object entity, double x, double y, double z) {
		super.entitySetPosition(entity, x, y, z);
	}

	@Override
	protected void entitySetSize(Object entity, float f1, float f2) {
		if (master != null) master.entitySetSize(entity, f1, f2);
		else super.entitySetSize(entity, f1, f2);
	}

	public void superEntitySetSize(Object entity, float f1, float f2) {
		super.entitySetSize(entity, f1, f2);
	}

	@Override
	protected void entityPlaySound(Object entity, Object soundEventOrString, float f1, float f2) {
		if (master != null) master.entityPlaySound(entity, soundEventOrString, f1, f2);
		else super.entityPlaySound(entity, soundEventOrString, f1, f2);
	}

	public void superEntityPlaySound(Object entity, Object soundEventOrString, float f1, float f2) {
		super.entityPlaySound(entity, soundEventOrString, f1, f2);
	}

	@Override
	protected int entityTicksExisted(Object entity) {
		return master != null ? master.entityTicksExisted(entity) : super.entityTicksExisted(entity);
	}

	public int superEntityTicksExisted(Object entity) {
		return super.entityTicksExisted(entity);
	}

	@Override
	protected void setEntityTicksExisted(Object entity, int i) {
		if (master != null) master.setEntityTicksExisted(entity, i);
		else super.setEntityTicksExisted(entity, i);
	}

	public void superSetEntityTicksExisted(Object entity, int i) {
		super.setEntityTicksExisted(entity, i);
	}

	@Override
	protected Object entityLivingGetNavigator(Object entityLivingOrPathNavigate) {
		return master != null ? master.entityLivingGetNavigator(entityLivingOrPathNavigate) : super.entityLivingGetNavigator(entityLivingOrPathNavigate);
	}

	public Object superEntityLivingGetNavigator(Object entityLivingOrPathNavigate) {
		return super.entityLivingGetNavigator(entityLivingOrPathNavigate);
	}

	@Override
	protected void entityLivingNavigatorClearPathEntity(Object entityLivingOrPathNavigate) {
		if (master != null) master.entityLivingNavigatorClearPathEntity(entityLivingOrPathNavigate);
		else super.entityLivingNavigatorClearPathEntity(entityLivingOrPathNavigate);
	}

	public void superEntityLivingNavigatorClearPathEntity(Object entityLivingOrPathNavigate) {
		super.entityLivingNavigatorClearPathEntity(entityLivingOrPathNavigate);
	}

	@Override
	protected Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return master != null ? master.entityLivingGetCurrentArmor(entityLiving, i) : super.entityLivingGetCurrentArmor(entityLiving, i);
	}

	public Object superEntityLivingGetCurrentArmor(Object entityLiving, int i) {
		return super.entityLivingGetCurrentArmor(entityLiving, i);
	}

	@Override
	protected boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		return master != null ? master.entityLivingBaseIsPotionActive(entityLivingBase, potionOrPotionId) : super.entityLivingBaseIsPotionActive(entityLivingBase, potionOrPotionId);
	}

	public boolean superEntityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		return super.entityLivingBaseIsPotionActive(entityLivingBase, potionOrPotionId);
	}

	@Override
	protected boolean entityOnGround(Object entity) {
		return master != null ? master.entityOnGround(entity) : super.entityOnGround(entity);
	}

	public boolean superEntityOnGround(Object entity) {
		return super.entityOnGround(entity);
	}

	@Override
	protected void entityLivingBaseSetBeenAttacked(Object entityLivingBase) {
		if (master != null) master.entityLivingBaseSetBeenAttacked(entityLivingBase);
		else super.entityLivingBaseSetBeenAttacked(entityLivingBase);
	}

	public void superEntityLivingBaseSetBeenAttacked(Object entityLivingBase) {
		super.entityLivingBaseSetBeenAttacked(entityLivingBase);
	}

	@Override
	protected void entityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		if (master != null) master.entityLivingBaseOnDeath(entityLivingBase, damageSource);
		else super.entityLivingBaseOnDeath(entityLivingBase, damageSource);
	}

	public void superEntityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		super.entityLivingBaseOnDeath(entityLivingBase, damageSource);
	}

	@Override
	protected int entityAgeableGetGrowingAge(Object entityLivingBase) {
		return master != null ? master.entityAgeableGetGrowingAge(entityLivingBase) : super.entityAgeableGetGrowingAge(entityLivingBase);
	}

	public int superEntityAgeableGetGrowingAge(Object entityLivingBase) {
		return super.entityAgeableGetGrowingAge(entityLivingBase);
	}

	@Override
	protected int entityLivingBaseHurtTime(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseHurtTime(entityLivingBase) : super.entityLivingBaseHurtTime(entityLivingBase);
	}

	public int superEntityLivingBaseHurtTime(Object entityLivingBase) {
		return super.entityLivingBaseHurtTime(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		if (master != null) master.setEntityLivingBaseHurtTime(entityLivingBase, i);
		else super.setEntityLivingBaseHurtTime(entityLivingBase, i);
	}

	public void superSetEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		super.setEntityLivingBaseHurtTime(entityLivingBase, i);
	}

	@Override
	protected int entityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseMaxHurtTime(entityLivingBase) : super.entityLivingBaseMaxHurtTime(entityLivingBase);
	}

	public int superEntityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return super.entityLivingBaseMaxHurtTime(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		if (master != null) master.setEntityLivingBaseMaxHurtTime(entityLivingBase, i);
		else super.setEntityLivingBaseMaxHurtTime(entityLivingBase, i);
	}

	public void superSetEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		super.setEntityLivingBaseMaxHurtTime(entityLivingBase, i);
	}

	@Override
	protected float entityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseAttackedAtYaw(entityLivingBase) : super.entityLivingBaseAttackedAtYaw(entityLivingBase);
	}

	public float superEntityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return super.entityLivingBaseAttackedAtYaw(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		if (master != null) master.setEntityLivingBaseAttackedAtYaw(entityLivingBase, f);
		else super.setEntityLivingBaseAttackedAtYaw(entityLivingBase, f);
	}

	public void superSetEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		super.setEntityLivingBaseAttackedAtYaw(entityLivingBase, f);
	}

	@Override
	protected float entityLivingBasePrevHealth(Object entityLivingBase) {
		return master != null ? master.entityLivingBasePrevHealth(entityLivingBase) : super.entityLivingBasePrevHealth(entityLivingBase);
	}

	public float superEntityLivingBasePrevHealth(Object entityLivingBase) {
		return super.entityLivingBasePrevHealth(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
		if (master != null) master.setEntityLivingBasePrevHealth(entityLivingBase, f);
		else super.setEntityLivingBasePrevHealth(entityLivingBase, f);
	}

	public void superSetEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
		super.setEntityLivingBasePrevHealth(entityLivingBase, f);
	}

	@Override
	protected boolean entityLivingBaseIsChild(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseIsChild(entityLivingBase) : super.entityLivingBaseIsChild(entityLivingBase);
	}

	public boolean superEntityLivingBaseIsChild(Object entityLivingBase) {
		return super.entityLivingBaseIsChild(entityLivingBase);
	}

	@Override
	protected void entityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		if (master != null) master.entityLivingBaseKnockBack(entityLivingBase, entityLivingBase2, f, d, d1);
		else super.entityLivingBaseKnockBack(entityLivingBase, entityLivingBase2, f, d, d1);
	}

	public void superEntityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		super.entityLivingBaseKnockBack(entityLivingBase, entityLivingBase2, f, d, d1);
	}

	@Override
	protected Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseGetAITarget(entityLivingBase) : super.entityLivingBaseGetAITarget(entityLivingBase);
	}

	public Object superEntityLivingBaseGetAITarget(Object entityLivingBase) {
		return super.entityLivingBaseGetAITarget(entityLivingBase);
	}

	@Override
	protected void entityBatSetIsBatHanging(Object entityBat, boolean b) {
		if (master != null) master.entityBatSetIsBatHanging(entityBat, b);
		else super.entityBatSetIsBatHanging(entityBat, b);
	}

	public void superEntityBatSetIsBatHanging(Object entityBat, boolean b) {
		super.entityBatSetIsBatHanging(entityBat, b);
	}

	@Override
	protected void entitySetEating(Object entity, boolean b) {
		if (master != null) master.entitySetEating(entity, b);
		else super.entitySetEating(entity, b);
	}

	public void superEntitySetEating(Object entity, boolean b) {
		super.entitySetEating(entity, b);
	}

	@Override
	protected float entityWidth(Object entity) {
		return master != null ? master.entityWidth(entity) : super.entityWidth(entity);
	}

	public float superEntityWidth(Object entity) {
		return super.entityWidth(entity);
	}

	@Override
	protected Object entityWorld(Object worldOrEntity) {
		return master != null ? master.entityWorld(worldOrEntity) : super.entityWorld(worldOrEntity);
	}

	public Object superEntityWorld(Object worldOrEntity) {
		return super.entityWorld(worldOrEntity);
	}

	@Override
	protected float entityYOffset(Object entity) {
		return master != null ? master.entityYOffset(entity) : super.entityYOffset(entity);
	}

	public float superEntityYOffset(Object entity) {
		return super.entityYOffset(entity);
	}

	@Override
	protected Enum enumActionBlock() {
		return master != null ? master.enumActionBlock() : super.enumActionBlock();
	}

	public Enum superEnumActionBlock() {
		return super.enumActionBlock();
	}

	@Override
	protected Enum enumActionBow() {
		return master != null ? master.enumActionBow() : super.enumActionBow();
	}

	public Enum superEnumActionBow() {
		return super.enumActionBow();
	}

	@Override
	protected Enum enumActionDrink() {
		return master != null ? master.enumActionDrink() : super.enumActionDrink();
	}

	public Enum superEnumActionDrink() {
		return super.enumActionDrink();
	}

	@Override
	protected Enum enumActionEat() {
		return master != null ? master.enumActionEat() : super.enumActionEat();
	}

	public Enum superEnumActionEat() {
		return super.enumActionEat();
	}

	@Override
	protected Enum enumActionNone() {
		return master != null ? master.enumActionNone() : super.enumActionNone();
	}

	public Enum superEnumActionNone() {
		return super.enumActionNone();
	}

	@Override
	protected Enum enumCreatureAttributeARTHROPOD() {
		return master != null ? master.enumCreatureAttributeARTHROPOD() : super.enumCreatureAttributeARTHROPOD();
	}

	public Enum superEnumCreatureAttributeARTHROPOD() {
		return super.enumCreatureAttributeARTHROPOD();
	}

	@Override
	protected Enum enumCreatureAttributeUNDEAD() {
		return master != null ? master.enumCreatureAttributeUNDEAD() : super.enumCreatureAttributeUNDEAD();
	}

	public Enum superEnumCreatureAttributeUNDEAD() {
		return super.enumCreatureAttributeUNDEAD();
	}

	@Override
	protected Enum enumCreatureAttributeUNDEFINED() {
		return master != null ? master.enumCreatureAttributeUNDEFINED() : super.enumCreatureAttributeUNDEFINED();
	}

	public Enum superEnumCreatureAttributeUNDEFINED() {
		return super.enumCreatureAttributeUNDEFINED();
	}

	@Override
	protected Enum enumCreatureTypeMonster() {
		return master != null ? master.enumCreatureTypeMonster() : super.enumCreatureTypeMonster();
	}

	public Enum superEnumCreatureTypeMonster() {
		return super.enumCreatureTypeMonster();
	}

	@Override
	protected Enum enumCreatureTypeCreature() {
		return master != null ? master.enumCreatureTypeCreature() : super.enumCreatureTypeCreature();
	}

	public Enum superEnumCreatureTypeCreature() {
		return super.enumCreatureTypeCreature();
	}

	@Override
	protected Enum enumCreatureTypeAmbient() {
		return master != null ? master.enumCreatureTypeAmbient() : super.enumCreatureTypeAmbient();
	}

	public Enum superEnumCreatureTypeAmbient() {
		return super.enumCreatureTypeAmbient();
	}

	@Override
	protected Enum enumCreatureTypeWaterCreature() {
		return master != null ? master.enumCreatureTypeWaterCreature() : super.enumCreatureTypeWaterCreature();
	}

	public Enum superEnumCreatureTypeWaterCreature() {
		return super.enumCreatureTypeWaterCreature();
	}

	@Override
	protected Enum enumFacingUP() {
		return master != null ? master.enumFacingUP() : super.enumFacingUP();
	}

	public Enum superEnumFacingUP() {
		return super.enumFacingUP();
	}

	@Override
	protected Enum enumFacingDOWN() {
		return master != null ? master.enumFacingDOWN() : super.enumFacingDOWN();
	}

	public Enum superEnumFacingDOWN() {
		return super.enumFacingDOWN();
	}

	@Override
	protected Enum enumFacingEAST() {
		return master != null ? master.enumFacingEAST() : super.enumFacingEAST();
	}

	public Enum superEnumFacingEAST() {
		return super.enumFacingEAST();
	}

	@Override
	protected Enum enumFacingNORTH() {
		return master != null ? master.enumFacingNORTH() : super.enumFacingNORTH();
	}

	public Enum superEnumFacingNORTH() {
		return super.enumFacingNORTH();
	}

	@Override
	protected Enum enumFacingSOUTH() {
		return master != null ? master.enumFacingSOUTH() : super.enumFacingSOUTH();
	}

	public Enum superEnumFacingSOUTH() {
		return super.enumFacingSOUTH();
	}

	@Override
	protected Enum enumFacingWEST() {
		return master != null ? master.enumFacingWEST() : super.enumFacingWEST();
	}

	public Enum superEnumFacingWEST() {
		return super.enumFacingWEST();
	}

	@Override
	protected boolean gameSettingsAnaglyph(Object gameSettings) {
		return master != null ? master.gameSettingsAnaglyph(gameSettings) : super.gameSettingsAnaglyph(gameSettings);
	}

	public boolean superGameSettingsAnaglyph(Object gameSettings) {
		return super.gameSettingsAnaglyph(gameSettings);
	}

	@Override
	protected Object biomeOcean() {
		return master != null ? master.biomeOcean() : super.biomeOcean();
	}

	public Object superBiomeOcean() {
		return super.biomeOcean();
	}

	@Override
	protected Object biomePlains() {
		return master != null ? master.biomePlains() : super.biomePlains();
	}

	public Object superBiomePlains() {
		return super.biomePlains();
	}

	@Override
	protected Object biomeDesert() {
		return master != null ? master.biomeDesert() : super.biomeDesert();
	}

	public Object superBiomeDesert() {
		return super.biomeDesert();
	}

	@Override
	protected Object biomeExtremeHills() {
		return master != null ? master.biomeExtremeHills() : super.biomeExtremeHills();
	}

	public Object superBiomeExtremeHills() {
		return super.biomeExtremeHills();
	}

	@Override
	protected Object biomeForest() {
		return master != null ? master.biomeForest() : super.biomeForest();
	}

	public Object superBiomeForest() {
		return super.biomeForest();
	}

	@Override
	protected Object biomeTaiga() {
		return master != null ? master.biomeTaiga() : super.biomeTaiga();
	}

	public Object superBiomeTaiga() {
		return super.biomeTaiga();
	}

	@Override
	protected Object biomeSwampland() {
		return master != null ? master.biomeSwampland() : super.biomeSwampland();
	}

	public Object superBiomeSwampland() {
		return super.biomeSwampland();
	}

	@Override
	protected Object biomeRiver() {
		return master != null ? master.biomeRiver() : super.biomeRiver();
	}

	public Object superBiomeRiver() {
		return super.biomeRiver();
	}

	@Override
	protected Object biomeHell() {
		return master != null ? master.biomeHell() : super.biomeHell();
	}

	public Object superBiomeHell() {
		return super.biomeHell();
	}

	@Override
	protected Object biomeSky() {
		return master != null ? master.biomeSky() : super.biomeSky();
	}

	public Object superBiomeSky() {
		return super.biomeSky();
	}

	@Override
	protected Object biomeFrozenOcean() {
		return master != null ? master.biomeFrozenOcean() : super.biomeFrozenOcean();
	}

	public Object superBiomeFrozenOcean() {
		return super.biomeFrozenOcean();
	}

	@Override
	protected Object biomeFrozenRiver() {
		return master != null ? master.biomeFrozenRiver() : super.biomeFrozenRiver();
	}

	public Object superBiomeFrozenRiver() {
		return super.biomeFrozenRiver();
	}

	@Override
	protected Object biomeIcePlains() {
		return master != null ? master.biomeIcePlains() : super.biomeIcePlains();
	}

	public Object superBiomeIcePlains() {
		return super.biomeIcePlains();
	}

	@Override
	protected Object biomeIceMountains() {
		return master != null ? master.biomeIceMountains() : super.biomeIceMountains();
	}

	public Object superBiomeIceMountains() {
		return super.biomeIceMountains();
	}

	@Override
	protected Object biomeMushroomIsland() {
		return master != null ? master.biomeMushroomIsland() : super.biomeMushroomIsland();
	}

	public Object superBiomeMushroomIsland() {
		return super.biomeMushroomIsland();
	}

	@Override
	protected Object biomeMushroomIslandShore() {
		return master != null ? master.biomeMushroomIslandShore() : super.biomeMushroomIslandShore();
	}

	public Object superBiomeMushroomIslandShore() {
		return super.biomeMushroomIslandShore();
	}

	@Override
	protected Object biomeBeach() {
		return master != null ? master.biomeBeach() : super.biomeBeach();
	}

	public Object superBiomeBeach() {
		return super.biomeBeach();
	}

	@Override
	protected Object biomeDesertHills() {
		return master != null ? master.biomeDesertHills() : super.biomeDesertHills();
	}

	public Object superBiomeDesertHills() {
		return super.biomeDesertHills();
	}

	@Override
	protected Object biomeForestHills() {
		return master != null ? master.biomeForestHills() : super.biomeForestHills();
	}

	public Object superBiomeForestHills() {
		return super.biomeForestHills();
	}

	@Override
	protected Object biomeTaigaHills() {
		return master != null ? master.biomeTaigaHills() : super.biomeTaigaHills();
	}

	public Object superBiomeTaigaHills() {
		return super.biomeTaigaHills();
	}

	@Override
	protected Object biomeExtremeHillsEdge() {
		return master != null ? master.biomeExtremeHillsEdge() : super.biomeExtremeHillsEdge();
	}

	public Object superBiomeExtremeHillsEdge() {
		return super.biomeExtremeHillsEdge();
	}

	@Override
	protected Object biomeJungle() {
		return master != null ? master.biomeJungle() : super.biomeJungle();
	}

	public Object superBiomeJungle() {
		return super.biomeJungle();
	}

	@Override
	protected Object biomeJungleHills() {
		return master != null ? master.biomeJungleHills() : super.biomeJungleHills();
	}

	public Object superBiomeJungleHills() {
		return super.biomeJungleHills();
	}

	@Override
	protected Object biomeJungleEdge() {
		return master != null ? master.biomeJungleEdge() : super.biomeJungleEdge();
	}

	public Object superBiomeJungleEdge() {
		return super.biomeJungleEdge();
	}

	@Override
	protected Object biomeDeepOcean() {
		return master != null ? master.biomeDeepOcean() : super.biomeDeepOcean();
	}

	public Object superBiomeDeepOcean() {
		return super.biomeDeepOcean();
	}

	@Override
	protected Object biomeStoneBeach() {
		return master != null ? master.biomeStoneBeach() : super.biomeStoneBeach();
	}

	public Object superBiomeStoneBeach() {
		return super.biomeStoneBeach();
	}

	@Override
	protected Object biomeStoneColdBeach() {
		return master != null ? master.biomeStoneColdBeach() : super.biomeStoneColdBeach();
	}

	public Object superBiomeStoneColdBeach() {
		return super.biomeStoneColdBeach();
	}

	@Override
	protected Object biomeBirchForest() {
		return master != null ? master.biomeBirchForest() : super.biomeBirchForest();
	}

	public Object superBiomeBirchForest() {
		return super.biomeBirchForest();
	}

	@Override
	protected Object biomeBirchForestHills() {
		return master != null ? master.biomeBirchForestHills() : super.biomeBirchForestHills();
	}

	public Object superBiomeBirchForestHills() {
		return super.biomeBirchForestHills();
	}

	@Override
	protected Object biomeRoofedForest() {
		return master != null ? master.biomeRoofedForest() : super.biomeRoofedForest();
	}

	public Object superBiomeRoofedForest() {
		return super.biomeRoofedForest();
	}

	@Override
	protected Object biomeColdTaiga() {
		return master != null ? master.biomeColdTaiga() : super.biomeColdTaiga();
	}

	public Object superBiomeColdTaiga() {
		return super.biomeColdTaiga();
	}

	@Override
	protected Object biomeColdTaigaHills() {
		return master != null ? master.biomeColdTaigaHills() : super.biomeColdTaigaHills();
	}

	public Object superBiomeColdTaigaHills() {
		return super.biomeColdTaigaHills();
	}

	@Override
	protected Object biomeMegaTaiga() {
		return master != null ? master.biomeMegaTaiga() : super.biomeMegaTaiga();
	}

	public Object superBiomeMegaTaiga() {
		return super.biomeMegaTaiga();
	}

	@Override
	protected Object biomeMegaTaigaHills() {
		return master != null ? master.biomeMegaTaigaHills() : super.biomeMegaTaigaHills();
	}

	public Object superBiomeMegaTaigaHills() {
		return super.biomeMegaTaigaHills();
	}

	@Override
	protected Object biomeExtremeHillsPlus() {
		return master != null ? master.biomeExtremeHillsPlus() : super.biomeExtremeHillsPlus();
	}

	public Object superBiomeExtremeHillsPlus() {
		return super.biomeExtremeHillsPlus();
	}

	@Override
	protected Object biomeSavanna() {
		return master != null ? master.biomeSavanna() : super.biomeSavanna();
	}

	public Object superBiomeSavanna() {
		return super.biomeSavanna();
	}

	@Override
	protected Object biomeSavannaPlateau() {
		return master != null ? master.biomeSavannaPlateau() : super.biomeSavannaPlateau();
	}

	public Object superBiomeSavannaPlateau() {
		return super.biomeSavannaPlateau();
	}

	@Override
	protected Object biomeMesa() {
		return master != null ? master.biomeMesa() : super.biomeMesa();
	}

	public Object superBiomeMesa() {
		return super.biomeMesa();
	}

	@Override
	protected Object biomeMesaPlateau_F() {
		return master != null ? master.biomeMesaPlateau_F() : super.biomeMesaPlateau_F();
	}

	public Object superBiomeMesaPlateau_F() {
		return super.biomeMesaPlateau_F();
	}

	@Override
	protected Object biomeMesaPlateau() {
		return master != null ? master.biomeMesaPlateau() : super.biomeMesaPlateau();
	}

	public Object superBiomeMesaPlateau() {
		return super.biomeMesaPlateau();
	}

	@Override
	protected Object creativeTabsTabBlock() {
		return master != null ? master.creativeTabsTabBlock() : super.creativeTabsTabBlock();
	}

	public Object superCreativeTabsTabBlock() {
		return super.creativeTabsTabBlock();
	}

	@Override
	protected Object creativeTabsTabDecorations() {
		return master != null ? master.creativeTabsTabDecorations() : super.creativeTabsTabDecorations();
	}

	public Object superCreativeTabsTabDecorations() {
		return super.creativeTabsTabDecorations();
	}

	@Override
	protected Object creativeTabsTabRedstone() {
		return master != null ? master.creativeTabsTabRedstone() : super.creativeTabsTabRedstone();
	}

	public Object superCreativeTabsTabRedstone() {
		return super.creativeTabsTabRedstone();
	}

	@Override
	protected Object creativeTabsTabTransport() {
		return master != null ? master.creativeTabsTabTransport() : super.creativeTabsTabTransport();
	}

	public Object superCreativeTabsTabTransport() {
		return super.creativeTabsTabTransport();
	}

	@Override
	protected Object creativeTabsTabMisc() {
		return master != null ? master.creativeTabsTabMisc() : super.creativeTabsTabMisc();
	}

	public Object superCreativeTabsTabMisc() {
		return super.creativeTabsTabMisc();
	}

	@Override
	protected Object creativeTabsTabAllSearch() {
		return master != null ? master.creativeTabsTabAllSearch() : super.creativeTabsTabAllSearch();
	}

	public Object superCreativeTabsTabAllSearch() {
		return super.creativeTabsTabAllSearch();
	}

	@Override
	protected Object creativeTabsTabFood() {
		return master != null ? master.creativeTabsTabFood() : super.creativeTabsTabFood();
	}

	public Object superCreativeTabsTabFood() {
		return super.creativeTabsTabFood();
	}

	@Override
	protected Object creativeTabsTabTools() {
		return master != null ? master.creativeTabsTabTools() : super.creativeTabsTabTools();
	}

	public Object superCreativeTabsTabTools() {
		return super.creativeTabsTabTools();
	}

	@Override
	protected Object creativeTabsTabCombat() {
		return master != null ? master.creativeTabsTabCombat() : super.creativeTabsTabCombat();
	}

	public Object superCreativeTabsTabCombat() {
		return super.creativeTabsTabCombat();
	}

	@Override
	protected Object creativeTabsTabBrewing() {
		return master != null ? master.creativeTabsTabBrewing() : super.creativeTabsTabBrewing();
	}

	public Object superCreativeTabsTabBrewing() {
		return super.creativeTabsTabBrewing();
	}

	@Override
	protected Object creativeTabsTabMaterials() {
		return master != null ? master.creativeTabsTabMaterials() : super.creativeTabsTabMaterials();
	}

	public Object superCreativeTabsTabMaterials() {
		return super.creativeTabsTabMaterials();
	}

	@Override
	protected Object creativeTabsTabInventory() {
		return master != null ? master.creativeTabsTabInventory() : super.creativeTabsTabInventory();
	}

	public Object superCreativeTabsTabInventory() {
		return super.creativeTabsTabInventory();
	}

	@Override
	protected Object containerInventorySlots(Object container) {
		return master != null ? master.containerInventorySlots(container) : super.containerInventorySlots(container);
	}

	public Object superContainerInventorySlots(Object container) {
		return super.containerInventorySlots(container);
	}

	@Override
	protected Object containerInventoryItemStacks(Object container) {
		return master != null ? master.containerInventoryItemStacks(container) : super.containerInventoryItemStacks(container);
	}

	public Object superContainerInventoryItemStacks(Object container) {
		return super.containerInventoryItemStacks(container);
	}

	@Override
	protected Object containerGetSlot(Object container, int i) {
		return master != null ? master.containerGetSlot(container, i) : super.containerGetSlot(container, i);
	}

	public Object superContainerGetSlot(Object container, int i) {
		return super.containerGetSlot(container, i);
	}

	@Override
	protected Object FMLCommonHandlerInstance() {
		return master != null ? master.FMLCommonHandlerInstance() : super.FMLCommonHandlerInstance();
	}

	public Object superFMLCommonHandlerInstance() {
		return super.FMLCommonHandlerInstance();
	}

	@Override
	protected Object FMLCommonHandlerInstanceGetMinecraftServerInstance() {
		return master != null ? master.FMLCommonHandlerInstanceGetMinecraftServerInstance() : super.FMLCommonHandlerInstanceGetMinecraftServerInstance();
	}

	public Object superFMLCommonHandlerInstanceGetMinecraftServerInstance() {
		return super.FMLCommonHandlerInstanceGetMinecraftServerInstance();
	}

	@Override
	protected Object[] FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() {
		return master != null ? master.FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() : super.FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers();
	}

	public Object[] superFMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() {
		return super.FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers();
	}

	@Override
	protected void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		if (master != null) master.fontRendererDrawString(fontRenderer, s, i, j, k);
		else super.fontRendererDrawString(fontRenderer, s, i, j, k);
	}

	public void superFontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		super.fontRendererDrawString(fontRenderer, s, i, j, k);
	}

	@Override
	protected int[] facingOffsetsXForSide() {
		return master != null ? master.facingOffsetsXForSide() : super.facingOffsetsXForSide();
	}

	public int[] superFacingOffsetsXForSide() {
		return super.facingOffsetsXForSide();
	}

	@Override
	protected int[] facingOffsetsYForSide() {
		return master != null ? master.facingOffsetsYForSide() : super.facingOffsetsYForSide();
	}

	public int[] superFacingOffsetsYForSide() {
		return super.facingOffsetsYForSide();
	}

	@Override
	protected int[] facingOffsetsZForSide() {
		return master != null ? master.facingOffsetsZForSide() : super.facingOffsetsZForSide();
	}

	public int[] superFacingOffsetsZForSide() {
		return super.facingOffsetsZForSide();
	}

	@Override
	protected String gameSettingsGetKeyDisplayString(int i) {
		return master != null ? master.gameSettingsGetKeyDisplayString(i) : super.gameSettingsGetKeyDisplayString(i);
	}

	public String superGameSettingsGetKeyDisplayString(int i) {
		return super.gameSettingsGetKeyDisplayString(i);
	}

	@Override
	protected Object gameSettingsKeyBindBack() {
		return master != null ? master.gameSettingsKeyBindBack() : super.gameSettingsKeyBindBack();
	}

	public Object superGameSettingsKeyBindBack() {
		return super.gameSettingsKeyBindBack();
	}

	@Override
	protected Object gameSettingsKeyBindForward() {
		return master != null ? master.gameSettingsKeyBindForward() : super.gameSettingsKeyBindForward();
	}

	public Object superGameSettingsKeyBindForward() {
		return super.gameSettingsKeyBindForward();
	}

	@Override
	protected Object gameSettingsKeyBindLeft() {
		return master != null ? master.gameSettingsKeyBindLeft() : super.gameSettingsKeyBindLeft();
	}

	public Object superGameSettingsKeyBindLeft() {
		return super.gameSettingsKeyBindLeft();
	}

	@Override
	protected Object gameSettingsKeyBindRight() {
		return master != null ? master.gameSettingsKeyBindRight() : super.gameSettingsKeyBindRight();
	}

	public Object superGameSettingsKeyBindRight() {
		return super.gameSettingsKeyBindRight();
	}

	@Override
	protected Object getBlock(Object itemStackOrItemOrBlock) {
		return master != null ? master.getBlock(itemStackOrItemOrBlock) : super.getBlock(itemStackOrItemOrBlock);
	}

	public Object superGetBlock(Object itemStackOrItemOrBlock) {
		return super.getBlock(itemStackOrItemOrBlock);
	}

	@Override
	protected Object getBlockItemStack(Object itemstack) {
		return master != null ? master.getBlockItemStack(itemstack) : super.getBlockItemStack(itemstack);
	}

	public Object superGetBlockItemStack(Object itemstack) {
		return super.getBlockItemStack(itemstack);
	}

	@Override
	protected Object getItem(String s) {
		return master != null ? master.getItem(s) : super.getItem(s);
	}

	public Object superGetItem(String s) {
		return super.getItem(s);
	}

	@Override
	protected Object getBlock(String s) {
		Modchu_Debug.mDebug("Modchu_AS getBlock String master="+master);
		return master != null ? master.getBlock(s) : super.getBlock(s);
	}

	public Object superGetBlock(String s) {
		return super.getBlock(s);
	}

	@Override
	protected Object getResource(Class c, String s) {
		return master != null ? master.getResource(c, s) : super.getResource(c, s);
	}

	public Object superGetResource(Object c, String s) {
		return super.getResource((Class) c, s);
	}

	@Override
	protected Object getResource(String s) {
		return master != null ? master.getResource(s) : super.getResource(s);
	}

	public Object superGetResource(String s) {
		return super.getResource(s);
	}

	@Override
	protected String getUserName(Object entityplayer) {
		return master != null ? master.getUserName(entityplayer) : super.getUserName(entityplayer);
	}

	public String superGetUserName(Object entityplayer) {
		return super.getUserName(entityplayer);
	}

	@Override
	protected int getVacancyGlobalEntityID() {
		return master != null ? master.getVacancyGlobalEntityID() : super.getVacancyGlobalEntityID();
	}

	public int superGetVacancyGlobalEntityID() {
		return super.getVacancyGlobalEntityID();
	}

	@Override
	protected IntBuffer gLAllocationCreateDirectIntBuffer(int i) {
		return master != null ? master.gLAllocationCreateDirectIntBuffer(i) : super.gLAllocationCreateDirectIntBuffer(i);
	}

	public IntBuffer superGLAllocationCreateDirectIntBuffer(int i) {
		return super.gLAllocationCreateDirectIntBuffer(i);
	}

	@Override
	protected int gLAllocationGenerateDisplayLists(int i) {
		return master != null ? master.gLAllocationGenerateDisplayLists(i) : super.gLAllocationGenerateDisplayLists(i);
	}

	public int superGLAllocationGenerateDisplayLists(int i) {
		return super.gLAllocationGenerateDisplayLists(i);
	}

	@Override
	protected boolean guiButtonEnabled(Object guiButton) {
		return master != null ? master.guiButtonEnabled(guiButton) : super.guiButtonEnabled(guiButton);
	}

	public boolean superGuiButtonEnabled(Object guiButton) {
		return super.guiButtonEnabled(guiButton);
	}

	@Override
	protected int guiButtonHeight(Object guiButton) {
		return master != null ? master.guiButtonHeight(guiButton) : super.guiButtonHeight(guiButton);
	}

	public int superGuiButtonHeight(Object guiButton) {
		return super.guiButtonHeight(guiButton);
	}

	@Override
	protected int guiButtonID(Object guiButton) {
		return master != null ? master.guiButtonID(guiButton) : super.guiButtonID(guiButton);
	}

	public int superGuiButtonID(Object guiButton) {
		return super.guiButtonID(guiButton);
	}

	@Override
	protected boolean guiButtonVisible(Object guiButton) {
		return master != null ? master.guiButtonVisible(guiButton) : super.guiButtonVisible(guiButton);
	}

	public boolean superGuiButtonVisible(Object guiButton) {
		return super.guiButtonVisible(guiButton);
	}

	@Override
	protected int guiButtonWidth(Object guiButton) {
		return master != null ? master.guiButtonWidth(guiButton) : super.guiButtonWidth(guiButton);
	}

	public int superGuiButtonWidth(Object guiButton) {
		return super.guiButtonWidth(guiButton);
	}

	@Override
	protected int guiButtonXPosition(Object guiButton) {
		return master != null ? master.guiButtonXPosition(guiButton) : super.guiButtonXPosition(guiButton);
	}

	public int superGuiButtonXPosition(Object guiButton) {
		return super.guiButtonXPosition(guiButton);
	}

	@Override
	protected int guiButtonYPosition(Object guiButton) {
		return master != null ? master.guiButtonYPosition(guiButton) : super.guiButtonYPosition(guiButton);
	}

	public int superGuiButtonYPosition(Object guiButton) {
		return super.guiButtonYPosition(guiButton);
	}

	@Override
	protected void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		if (master != null) master.guiDrawCenteredString(gui, fontRenderer, s, i, i2, i3);
		else super.guiDrawCenteredString(gui, fontRenderer, s, i, i2, i3);
	}

	public void superGuiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		super.guiDrawCenteredString(gui, fontRenderer, s, i, i2, i3);
	}

	@Override
	protected void guiIngameDrawString(String s, int i, int j, int k) {
		if (master != null) master.guiIngameDrawString(s, i, j, k);
		else super.guiIngameDrawString(s, i, j, k);
	}

	public void superGuiIngameDrawString(String s, int i, int j, int k) {
		super.guiIngameDrawString(s, i, j, k);
	}

	@Override
	protected Object guiOptionsBackground() {
		return master != null ? master.guiOptionsBackground() : super.guiOptionsBackground();
	}

	public Object superGuiOptionsBackground() {
		return super.guiOptionsBackground();
	}

	@Override
	protected void guiScreenActionPerformed(Object guiScreen, Object guiButton) {
		if (master != null) master.guiScreenActionPerformed(guiScreen, guiButton);
		else super.guiScreenActionPerformed(guiScreen, guiButton);
	}

	public void superGuiScreenActionPerformed(Object guiScreen, Object guiButton) {
		super.guiScreenActionPerformed(guiScreen, guiButton);
	}

	@Override
	protected List guiScreenButtonList(Object guiScreen) {
		return master != null ? master.guiScreenButtonList(guiScreen) : super.guiScreenButtonList(guiScreen);
	}

	public List superGuiScreenButtonList(Object guiScreen) {
		return super.guiScreenButtonList(guiScreen);
	}

	@Override
	protected void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		if (master != null) master.guiScreenDrawScreen(guiScreen, i, i2, f);
		else super.guiScreenDrawScreen(guiScreen, i, i2, f);
	}

	public void superGuiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		super.guiScreenDrawScreen(guiScreen, i, i2, f);
	}

	@Override
	protected Object guiScreenFontRenderer(Object guiScreen) {
		return master != null ? master.guiScreenFontRenderer(guiScreen) : super.guiScreenFontRenderer(guiScreen);
	}

	public Object superGuiScreenFontRenderer(Object guiScreen) {
		return super.guiScreenFontRenderer(guiScreen);
	}

	@Override
	protected int guiScreenHeight(Object guiScreen) {
		return master != null ? master.guiScreenHeight(guiScreen) : super.guiScreenHeight(guiScreen);
	}

	public int superGuiScreenHeight(Object guiScreen) {
		return super.guiScreenHeight(guiScreen);
	}

	@Override
	protected int guiScreenWidth(Object guiScreen) {
		return master != null ? master.guiScreenWidth(guiScreen) : super.guiScreenWidth(guiScreen);
	}

	public int superGuiScreenWidth(Object guiScreen) {
		return super.guiScreenWidth(guiScreen);
	}

	@Override
	protected void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		if (master != null) master.guiSlotActionPerformed(guiSlot, guiButton);
		else super.guiSlotActionPerformed(guiSlot, guiButton);
	}

	public void superGuiSlotActionPerformed(Object guiSlot, Object guiButton) {
		super.guiSlotActionPerformed(guiSlot, guiButton);
	}

	@Override
	protected void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		if (master != null) master.guiSlotDrawScreen(guiSlot, i, i2, f);
		else super.guiSlotDrawScreen(guiSlot, i, i2, f);
	}

	public void superGuiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		super.guiSlotDrawScreen(guiSlot, i, i2, f);
	}

	@Override
	protected void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		if (master != null) master.guiSlotRegisterScrollButtons(guiSlot, list, i, i2);
		else super.guiSlotRegisterScrollButtons(guiSlot, list, i, i2);
	}

	public void superGuiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		super.guiSlotRegisterScrollButtons(guiSlot, list, i, i2);
	}

	@Override
	protected void guiScreenFunc_175273_b(Object guiScreen, int i, int i1) {
		if (master != null) master.guiScreenFunc_175273_b(guiScreen, i, i1);
		else super.guiScreenFunc_175273_b(guiScreen, i, i1);
	}

	public void superGuiScreenFunc_175273_b(Object guiScreen, int i, int i1) {
		super.guiScreenFunc_175273_b(guiScreen, i, i1);
	}

	@Override
	protected void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
		if (master != null) master.guiScreenFunc_175273_b(guiScreen, minecraft, i, i2);
		else super.guiScreenFunc_175273_b(guiScreen, minecraft, i, i2);
	}

	public void superGuiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
		super.guiScreenFunc_175273_b(guiScreen, minecraft, i, i2);
	}

	@Override
	protected Object iBlockStateGetBlock(Object iBlockState) {
		return master != null ? master.iBlockStateGetBlock(iBlockState) : super.iBlockStateGetBlock(iBlockState);
	}

	public Object superIBlockStateGetBlock(Object iBlockState) {
		return super.iBlockStateGetBlock(iBlockState);
	}

	@Override
	protected Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return master != null ? master.inventoryPlayerArmorItemInSlot(inventory, i) : super.inventoryPlayerArmorItemInSlot(inventory, i);
	}

	public Object superInventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return super.inventoryPlayerArmorItemInSlot(inventory, i);
	}

	@Override
	protected Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return master != null ? master.inventoryPlayerGetStackInSlot(inventory, i) : super.inventoryPlayerGetStackInSlot(inventory, i);
	}

	public Object superInventoryPlayerGetStackInSlot(Object inventory, int i) {
		return super.inventoryPlayerGetStackInSlot(inventory, i);
	}

	@Override
	protected boolean isCamouflage(Object itemStackOrItemOrBlock) {
		return master != null ? master.isCamouflage(itemStackOrItemOrBlock) : super.isCamouflage(itemStackOrItemOrBlock);
	}

	public boolean superIsCamouflage(Object itemStackOrItemOrBlock) {
		return super.isCamouflage(itemStackOrItemOrBlock);
	}

	@Override
	protected boolean isCamouflageCheck(Object block) {
		return master != null ? master.isCamouflageCheck(block) : super.isCamouflageCheck(block);
	}

	public boolean superIsCamouflageCheck(Object block) {
		return super.isCamouflageCheck(block);
	}

	@Override
	protected boolean isPumpkin(Object itemStackOrItemOrBlock) {
		return master != null ? master.isPumpkin(itemStackOrItemOrBlock) : super.isPumpkin(itemStackOrItemOrBlock);
	}

	public boolean superIsPumpkin(Object itemStackOrItemOrBlock) {
		return super.isPumpkin(itemStackOrItemOrBlock);
	}

	@Override
	protected boolean isCtrlKeyDown() {
		return master != null ? master.isCtrlKeyDown() : super.isCtrlKeyDown();
	}

	public boolean superIsCtrlKeyDown() {
		return super.isCtrlKeyDown();
	}

	@Override
	protected boolean isIntegratedServerRunning() {
		return master != null ? master.isIntegratedServerRunning() : super.isIntegratedServerRunning();
	}

	public boolean superIsIntegratedServerRunning() {
		return super.isIntegratedServerRunning();
	}

	@Override
	protected boolean isLANWorld() {
		return master != null ? master.isLANWorld() : super.isLANWorld();
	}

	public boolean superIsLANWorld() {
		return super.isLANWorld();
	}

	@Override
	protected Object getIntegratedServer() {
		return master != null ? master.getIntegratedServer() : super.getIntegratedServer();
	}

	public Object superGetIntegratedServer() {
		return super.getIntegratedServer();
	}

	@Override
	protected boolean isMac() {
		return master != null ? master.isMac() : super.isMac();
	}

	public boolean superIsMac() {
		return super.isMac();
	}

	@Override
	protected boolean isMuiti() {
		return master != null ? master.isMuiti() : super.isMuiti();
	}

	public boolean superIsMuiti() {
		return super.isMuiti();
	}

	@Override
	protected boolean isPlanter(Object itemStackOrItemOrBlock) {
		return master != null ? master.isPlanter(itemStackOrItemOrBlock) : super.isPlanter(itemStackOrItemOrBlock);
	}

	public boolean superIsPlanter(Object itemStackOrItemOrBlock) {
		return super.isPlanter(itemStackOrItemOrBlock);
	}

	@Override
	protected boolean isPlanterCheck(Object itemStackOrBlock) {
		return master != null ? master.isPlanterCheck(itemStackOrBlock) : super.isPlanterCheck(itemStackOrBlock);
	}

	public boolean superIsPlanterCheck(Object itemStackOrBlock) {
		return super.isPlanterCheck(itemStackOrBlock);
	}

	@Override
	protected boolean isShiftKeyDown() {
		return master != null ? master.isShiftKeyDown() : super.isShiftKeyDown();
	}

	public boolean superIsShiftKeyDown() {
		return super.isShiftKeyDown();
	}

	@Override
	protected boolean isSkull(Object itemStackOrItem) {
		return master != null ? master.isSkull(itemStackOrItem) : super.isSkull(itemStackOrItem);
	}

	public boolean superIsSkull(Object itemStackOrItem) {
		return super.isSkull(itemStackOrItem);
	}

	@Override
	protected int itemArmorRenderIndex(Object itemArmor) {
		return master != null ? master.itemArmorRenderIndex(itemArmor) : super.itemArmorRenderIndex(itemArmor);
	}

	public int superItemArmorRenderIndex(Object itemArmor) {
		return super.itemArmorRenderIndex(itemArmor);
	}

	@Override
	protected int itemArmorGetColor(Object itemArmor, Object itemstack) {
		return master != null ? master.itemArmorGetColor(itemArmor, itemstack) : super.itemArmorGetColor(itemArmor, itemstack);
	}

	public int superItemArmorGetColor(Object itemArmor, Object itemstack) {
		return super.itemArmorGetColor(itemArmor, itemstack);
	}

	@Override
	protected Object itemArmorGetArmorMaterial(Object itemArmor) {
		return master != null ? master.itemArmorGetArmorMaterial(itemArmor) : super.itemArmorGetArmorMaterial(itemArmor);
	}

	public Object superItemArmorGetArmorMaterial(Object itemArmor) {
		return super.itemArmorGetArmorMaterial(itemArmor);
	}

	@Override
	protected String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return master != null ? master.itemArmorArmorMaterialGetName(armorMaterial) : super.itemArmorArmorMaterialGetName(armorMaterial);
	}

	public String superItemArmorArmorMaterialGetName(Object armorMaterial) {
		return super.itemArmorArmorMaterialGetName(armorMaterial);
	}

	@Override
	protected Object itemSetPotionEffect(Object item, String s) {
		return master != null ? master.itemSetPotionEffect(item, s) : super.itemSetPotionEffect(item, s);
	}

	public Object superItemSetPotionEffect(Object item, String s) {
		return super.itemSetPotionEffect(item, s);
	}

	@Override
	protected int itemItemID(Object item) {
		return master != null ? master.itemItemID(item) : super.itemItemID(item);
	}

	public int superItemItemID(Object item) {
		return super.itemItemID(item);
	}

	@Override
	protected Object itemItemRegistry() {
		return master != null ? master.itemItemRegistry() : super.itemItemRegistry();
	}

	public Object superItemItemRegistry() {
		return super.itemItemRegistry();
	}

	@Override
	protected int itemGetMetadata(Object item, int i) {
		return master != null ? master.itemGetMetadata(item, i) : super.itemGetMetadata(item, i);
	}

	public int superItemGetMetadata(Object item, int i) {
		return super.itemGetMetadata(item, i);
	}

	@Override
	protected String potionHelperSugarEffect() {
		return master != null ? master.potionHelperSugarEffect() : super.potionHelperSugarEffect();
	}

	public String superPotionHelperSugarEffect() {
		return super.potionHelperSugarEffect();
	}

	@Override
	protected String potionHelperGhastTearEffect() {
		return master != null ? master.potionHelperGhastTearEffect() : super.potionHelperGhastTearEffect();
	}

	public String superPotionHelperGhastTearEffect() {
		return super.potionHelperGhastTearEffect();
	}

	@Override
	protected String potionHelperSpiderEyeEffect() {
		return master != null ? master.potionHelperSpiderEyeEffect() : super.potionHelperSpiderEyeEffect();
	}

	public String superPotionHelperSpiderEyeEffect() {
		return super.potionHelperSpiderEyeEffect();
	}

	@Override
	protected String potionHelperFermentedSpiderEyeEffect() {
		return master != null ? master.potionHelperFermentedSpiderEyeEffect() : super.potionHelperFermentedSpiderEyeEffect();
	}

	public String superPotionHelperFermentedSpiderEyeEffect() {
		return super.potionHelperFermentedSpiderEyeEffect();
	}

	@Override
	protected String potionHelperSpeckledMelonEffect() {
		return master != null ? master.potionHelperSpeckledMelonEffect() : super.potionHelperSpeckledMelonEffect();
	}

	public String superPotionHelperSpeckledMelonEffect() {
		return super.potionHelperSpeckledMelonEffect();
	}

	@Override
	protected String potionHelperBlazePowderEffect() {
		return master != null ? master.potionHelperBlazePowderEffect() : super.potionHelperBlazePowderEffect();
	}

	public String superPotionHelperBlazePowderEffect() {
		return super.potionHelperBlazePowderEffect();
	}

	@Override
	protected String potionHelperMagmaCreamEffect() {
		return master != null ? master.potionHelperMagmaCreamEffect() : super.potionHelperMagmaCreamEffect();
	}

	public String superPotionHelperMagmaCreamEffect() {
		return super.potionHelperMagmaCreamEffect();
	}

	@Override
	protected String potionHelperRedstoneEffect() {
		return master != null ? master.potionHelperRedstoneEffect() : super.potionHelperRedstoneEffect();
	}

	public String superPotionHelperRedstoneEffect() {
		return super.potionHelperRedstoneEffect();
	}

	@Override
	protected String potionHelperGlowstoneEffect() {
		return master != null ? master.potionHelperGlowstoneEffect() : super.potionHelperGlowstoneEffect();
	}

	public String superPotionHelperGlowstoneEffect() {
		return super.potionHelperGlowstoneEffect();
	}

	@Override
	protected String potionHelperGunpowderEffect() {
		return master != null ? master.potionHelperGunpowderEffect() : super.potionHelperGunpowderEffect();
	}

	public String superPotionHelperGunpowderEffect() {
		return super.potionHelperGunpowderEffect();
	}

	@Override
	protected String potionHelperGoldenCarrotEffect() {
		return master != null ? master.potionHelperGoldenCarrotEffect() : super.potionHelperGoldenCarrotEffect();
	}

	public String superPotionHelperGoldenCarrotEffect() {
		return super.potionHelperGoldenCarrotEffect();
	}

	@Override
	protected Map registrySimpleRegistryObjects() {
		return master != null ? master.registrySimpleRegistryObjects() : super.registrySimpleRegistryObjects();
	}

	public Map superRegistrySimpleRegistryObjects() {
		return super.registrySimpleRegistryObjects();
	}

	@Override
	protected Map registrySimpleRegistryObjects(Object registrySimple) {
		return master != null ? master.registrySimpleRegistryObjects(registrySimple) : super.registrySimpleRegistryObjects(registrySimple);
	}

	public Map superRegistrySimpleRegistryObjects(Object registrySimple) {
		return super.registrySimpleRegistryObjects(registrySimple);
	}

	@Override
	protected Object iBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Comparable comparable) {
		return master != null ? master.iBlockStateWithProperty(blockOrIBlockState, iProperty, comparable) : super.iBlockStateWithProperty(blockOrIBlockState, iProperty, comparable);
	}

	public Object superIBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Object comparable) {
		return super.iBlockStateWithProperty(blockOrIBlockState, iProperty, (Comparable) comparable);
	}

	@Override
	protected boolean itemIsFull3D(Object item) {
		return master != null ? master.itemIsFull3D(item) : super.itemIsFull3D(item);
	}

	public boolean superItemIsFull3D(Object item) {
		return super.itemIsFull3D(item);
	}

	@Override
	protected boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return master != null ? master.itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase) : super.itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase);
	}

	public boolean superItemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return super.itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase);
	}

	@Override
	protected boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase, Object enumHand) {
		return master != null ? master.itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase, enumHand) : super.itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase, enumHand);
	}

	public boolean superItemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase, Object enumHand) {
		return super.itemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase, enumHand);
	}

	@Override
	protected void itemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
		if (master != null) master.itemModelMesherRegister(itemModelMesher, item, i, modelResourceLocation);
		else super.itemModelMesherRegister(itemModelMesher, item, i, modelResourceLocation);
	}

	public void superItemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
		super.itemModelMesherRegister(itemModelMesher, item, i, modelResourceLocation);
	}

	public void superItemModelMesherRegister(Object itemModelMesher, Object item, Object itemMeshDefinition) {
		super.itemModelMesherRegister(itemModelMesher, item, itemMeshDefinition);
	}

	@Override
	protected List itemPotionGetEffects(Object itemPotion, Object itemStack) {
		return master != null ? master.itemPotionGetEffects(itemPotion, itemStack) : super.itemPotionGetEffects(itemPotion, itemStack);
	}

	public List superItemPotionGetEffects(Object itemPotion, Object itemStack) {
		return super.itemPotionGetEffects(itemPotion, itemStack);
	}

	@Override
	protected Object[] itemItemsList() {
		return master != null ? master.itemItemsList() : super.itemItemsList();
	}

	public Object[] superItemItemsList() {
		return super.itemItemsList();
	}

	@Override
	protected Object itemSetTextureName(Object item, String s) {
		return master != null ? master.itemSetTextureName(item, s) : super.itemSetTextureName(item, s);
	}

	public Object superItemSetTextureName(Object item, String s) {
		return super.itemSetTextureName(item, s);
	}

	@Override
	protected Object itemSetUnlocalizedName(Object item, String s) {
		return master != null ? master.itemSetUnlocalizedName(item, s) : super.itemSetUnlocalizedName(item, s);
	}

	public Object superItemSetUnlocalizedName(Object item, String s) {
		return super.itemSetUnlocalizedName(item, s);
	}

	@Override
	protected Object itemSetCreativeTab(Object item, Object creativeTabs) {
		return master != null ? master.itemSetCreativeTab(item, creativeTabs) : super.itemSetCreativeTab(item, creativeTabs);
	}

	public Object superItemSetCreativeTab(Object item, Object creativeTabs) {
		return super.itemSetCreativeTab(item, creativeTabs);
	}

	@Override
	protected String itemIconString(Object item) {
		return master != null ? master.itemIconString(item) : super.itemIconString(item);
	}

	public String superItemIconString(Object item) {
		return super.itemIconString(item);
	}

	@Override
	protected void setItemIconString(Object item, String s) {
		if (master != null) master.setItemIconString(item, s);
		else super.setItemIconString(item, s);
	}

	public void superSetItemIconString(Object item, String s) {
		super.setItemIconString(item, s);
	}

	@Override
	protected Object itemItemIcon(Object item) {
		return master != null ? master.itemItemIcon(item) : super.itemItemIcon(item);
	}

	public Object superItemItemIcon(Object item) {
		return super.itemItemIcon(item);
	}

	@Override
	protected void setItemItemIcon(Object item, Object icon) {
		if (master != null) master.setItemItemIcon(item, icon);
		else super.setItemItemIcon(item, icon);
	}

	public void superSetItemItemIcon(Object item, Object icon) {
		super.setItemItemIcon(item, icon);
	}

	@Override
	protected void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		if (master != null) master.itemOnItemRightClick(item, itemStack, world, entityplayer);
		else super.itemOnItemRightClick(item, itemStack, world, entityplayer);
	}

	public void superItemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		super.itemOnItemRightClick(item, itemStack, world, entityplayer);
	}

	@Override
	protected void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer, Object enumHand) {
		if (master != null) master.itemOnItemRightClick(item, itemStack, world, entityplayer, enumHand);
		else super.itemOnItemRightClick(item, itemStack, world, entityplayer, enumHand);
	}

	public void superItemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer, Object enumHand) {
		super.itemOnItemRightClick(item, itemStack, world, entityplayer, enumHand);
	}

	@Override
	protected Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		return master != null ? master.iIconRegisterRegisterIcon(iIconRegister, s) : super.iIconRegisterRegisterIcon(iIconRegister, s);
	}

	public Object superIIconRegisterRegisterIcon(Object iIconRegister, String s) {
		return super.iIconRegisterRegisterIcon(iIconRegister, s);
	}

	@Override
	protected Object itemStackCopyItemStack(Object itemStack) {
		return master != null ? master.itemStackCopyItemStack(itemStack) : super.itemStackCopyItemStack(itemStack);
	}

	public Object superItemStackCopyItemStack(Object itemStack) {
		return super.itemStackCopyItemStack(itemStack);
	}

	@Override
	protected Object itemStackGetItem(Object itemstack) {
		return master != null ? master.itemStackGetItem(itemstack) : super.itemStackGetItem(itemstack);
	}

	public Object superItemStackGetItem(Object itemstack) {
		return super.itemStackGetItem(itemstack);
	}

	@Override
	protected int itemStackGetItemDamage(Object itemstack) {
		return master != null ? master.itemStackGetItemDamage(itemstack) : super.itemStackGetItemDamage(itemstack);
	}

	public int superItemStackGetItemDamage(Object itemstack) {
		return super.itemStackGetItemDamage(itemstack);
	}

	@Override
	protected int itemStackGetMaxDamage(Object itemstack) {
		return master != null ? master.itemStackGetMaxDamage(itemstack) : super.itemStackGetMaxDamage(itemstack);
	}

	public int superItemStackGetMaxDamage(Object itemstack) {
		return super.itemStackGetMaxDamage(itemstack);
	}

	@Override
	protected Object itemStackGetItemUseAction(Object itemstack) {
		return master != null ? master.itemStackGetItemUseAction(itemstack) : super.itemStackGetItemUseAction(itemstack);
	}

	public Object superItemStackGetItemUseAction(Object itemstack) {
		return super.itemStackGetItemUseAction(itemstack);
	}

	@Override
	protected boolean itemStackIsItemEnchanted(Object itemstack) {
		return master != null ? master.itemStackIsItemEnchanted(itemstack) : super.itemStackIsItemEnchanted(itemstack);
	}

	public boolean superItemStackIsItemEnchanted(Object itemstack) {
		return super.itemStackIsItemEnchanted(itemstack);
	}

	@Override
	protected boolean itemStackHasDisplayName(Object itemstack) {
		return master != null ? master.itemStackHasDisplayName(itemstack) : super.itemStackHasDisplayName(itemstack);
	}

	public boolean superItemStackHasDisplayName(Object itemstack) {
		return super.itemStackHasDisplayName(itemstack);
	}

	@Override
	protected boolean itemShouldRotateAroundWhenRendering(Object item) {
		return master != null ? master.itemShouldRotateAroundWhenRendering(item) : super.itemShouldRotateAroundWhenRendering(item);
	}

	public boolean superItemShouldRotateAroundWhenRendering(Object item) {
		return super.itemShouldRotateAroundWhenRendering(item);
	}

	@Override
	protected boolean itemStackHasTagCompound(Object itemStack) {
		return master != null ? master.itemStackHasTagCompound(itemStack) : super.itemStackHasTagCompound(itemStack);
	}

	public boolean superItemStackHasTagCompound(Object itemStack) {
		return super.itemStackHasTagCompound(itemStack);
	}

	@Override
	protected Object itemStackGetTagCompound(Object nBTTagCompoundOrItemStack) {
		return master != null ? master.itemStackGetTagCompound(nBTTagCompoundOrItemStack) : super.itemStackGetTagCompound(nBTTagCompoundOrItemStack);
	}

	public Object superItemStackGetTagCompound(Object nBTTagCompoundOrItemStack) {
		return super.itemStackGetTagCompound(nBTTagCompoundOrItemStack);
	}

	@Override
	protected Object itemStackGetAttributeModifiers(Object itemStack) {
		return master != null ? master.itemStackGetAttributeModifiers(itemStack) : super.itemStackGetAttributeModifiers(itemStack);
	}

	public Object superItemStackGetAttributeModifiers(Object itemStack) {
		return super.itemStackGetAttributeModifiers(itemStack);
	}

	@Override
	protected Object itemStackGetAttributeModifiers(Object itemStack, Object entityEquipmentSlot) {
		return master != null ? master.itemStackGetAttributeModifiers(itemStack, entityEquipmentSlot) : super.itemStackGetAttributeModifiers(itemStack, entityEquipmentSlot);
	}

	public Object superItemStackGetAttributeModifiers(Object itemStack, Object entityEquipmentSlot) {
		return super.itemStackGetAttributeModifiers(itemStack, entityEquipmentSlot);
	}

	@Override
	protected int itemStackGetMetadata(Object itemStack) {
		return master != null ? master.itemStackGetMetadata(itemStack) : super.itemStackGetMetadata(itemStack);
	}

	public int superItemStackGetMetadata(Object itemStack) {
		return super.itemStackGetMetadata(itemStack);
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeNONE() {
		return master != null ? master.itemCameraTransformsTransformTypeNONE() : super.itemCameraTransformsTransformTypeNONE();
	}

	public Enum superItemCameraTransformsTransformTypeNONE() {
		return super.itemCameraTransformsTransformTypeNONE();
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		return master != null ? master.itemCameraTransformsTransformTypeTHIRD_PERSON() : super.itemCameraTransformsTransformTypeTHIRD_PERSON();
	}

	public Enum superItemCameraTransformsTransformTypeTHIRD_PERSON() {
		return super.itemCameraTransformsTransformTypeTHIRD_PERSON();
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		return master != null ? master.itemCameraTransformsTransformTypeFIRST_PERSON() : super.itemCameraTransformsTransformTypeFIRST_PERSON();
	}

	public Enum superItemCameraTransformsTransformTypeFIRST_PERSON() {
		return super.itemCameraTransformsTransformTypeFIRST_PERSON();
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeHEAD() {
		return master != null ? master.itemCameraTransformsTransformTypeHEAD() : super.itemCameraTransformsTransformTypeHEAD();
	}

	public Enum superItemCameraTransformsTransformTypeHEAD() {
		return super.itemCameraTransformsTransformTypeHEAD();
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeGUI() {
		return master != null ? master.itemCameraTransformsTransformTypeGUI() : super.itemCameraTransformsTransformTypeGUI();
	}

	public Enum superItemCameraTransformsTransformTypeGUI() {
		return super.itemCameraTransformsTransformTypeGUI();
	}

	@Override
	protected boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		return master != null ? master.nbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s) : super.nbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s);
	}

	public boolean superNbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		return super.nbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s);
	}

	@Override
	protected boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s, int i) {
		return master != null ? master.nbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s, i) : super.nbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s, i);
	}

	public boolean superNbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s, int i) {
		return super.nbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s, i);
	}

	@Override
	protected String nbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		return master != null ? master.nbtTagCompoundGetString(nBTTagCompoundOrItemStack, s) : super.nbtTagCompoundGetString(nBTTagCompoundOrItemStack, s);
	}

	public String superNbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		return super.nbtTagCompoundGetString(nBTTagCompoundOrItemStack, s);
	}

	@Override
	protected void nbtTagCompoundSetTag(Object nBTTagCompound, String s, Object nbtBase) {
		if (master != null) master.nbtTagCompoundSetTag(nBTTagCompound, s, nbtBase);
		else super.nbtTagCompoundSetTag(nBTTagCompound, s, nbtBase);
	}

	public void superNbtTagCompoundSetTag(Object nBTTagCompound, String s, Object nbtBase) {
		super.nbtTagCompoundSetTag(nBTTagCompound, s, nbtBase);
	}

	@Override
	protected Object nbtTagCompoundGetCompoundTag(Object nBTTagCompoundOrItemStack, String s) {
		return master != null ? master.nbtTagCompoundGetCompoundTag(nBTTagCompoundOrItemStack, s) : super.nbtTagCompoundGetCompoundTag(nBTTagCompoundOrItemStack, s);
	}

	public Object superNbtTagCompoundGetCompoundTag(Object nBTTagCompoundOrItemStack, String s) {
		return super.nbtTagCompoundGetCompoundTag(nBTTagCompoundOrItemStack, s);
	}

	@Override
	protected Object nbtUtilReadGameProfileFromNBT(Object nBTTagCompound) {
		return master != null ? master.nbtUtilReadGameProfileFromNBT(nBTTagCompound) : super.nbtUtilReadGameProfileFromNBT(nBTTagCompound);
	}

	public Object superNbtUtilReadGameProfileFromNBT(Object nBTTagCompound) {
		return super.nbtUtilReadGameProfileFromNBT(nBTTagCompound);
	}

	@Override
	protected Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return master != null ? master.nBTUtilWriteGameProfile(nBTTagCompound, gameprofile) : super.nBTUtilWriteGameProfile(nBTTagCompound, gameprofile);
	}

	public Object superNBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return super.nBTUtilWriteGameProfile(nBTTagCompound, gameprofile);
	}

	@Override
	protected Object tileEntitySkullRendererSkullRenderer() {
		return master != null ? master.tileEntitySkullRendererSkullRenderer() : super.tileEntitySkullRendererSkullRenderer();
	}

	public Object superTileEntitySkullRendererSkullRenderer() {
		return super.tileEntitySkullRendererSkullRenderer();
	}

	@Override
	protected Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return master != null ? master.tileEntitySkullUpdateGameprofile(gameprofile) : super.tileEntitySkullUpdateGameprofile(gameprofile);
	}

	public Object superTileEntitySkullUpdateGameprofile(Object gameprofile) {
		return super.tileEntitySkullUpdateGameprofile(gameprofile);
	}

	@Override
	protected void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, int i, float f3, int i2, Object gameProfile) {
		if (master != null) master.tileEntitySkullRendererRenderSkull(f, f1, f2, i, f3, i2, gameProfile);
		else super.tileEntitySkullRendererRenderSkull(f, f1, f2, i, f3, i2, gameProfile);
	}

	public void superTileEntitySkullRendererRenderSkull(float f, float f1, float f2, int i, float f3, int i2, Object gameProfile) {
		super.tileEntitySkullRendererRenderSkull(f, f1, f2, i, f3, i2, gameProfile);
	}

	@Override
	protected void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		if (master != null) master.tileEntitySkullRendererRenderSkull(f, f1, f2, en, f3, i, gameProfile, i2);
		else super.tileEntitySkullRendererRenderSkull(f, f1, f2, en, f3, i, gameProfile, i2);
	}

	public void superTileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		super.tileEntitySkullRendererRenderSkull(f, f1, f2, en, f3, i, gameProfile, i2);
	}

	@Override
	protected void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		if (master != null) master.tileEntitySkullRendererRenderSkull(null, f, f1, f2, en, f3, i, gameProfile, i2, f4);
		else super.tileEntitySkullRendererRenderSkull(null, f, f1, f2, en, f3, i, gameProfile, i2, f4);
	}

	public void superTileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		super.tileEntitySkullRendererRenderSkull(null, f, f1, f2, en, f3, i, gameProfile, i2, f4);
	}

	@Override
	protected void tileEntitySkullRendererRenderSkull(Object skullRenderer, float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		if (master != null) master.tileEntitySkullRendererRenderSkull(skullRenderer, f, f1, f2, en, f3, i, gameProfile, i2, f4);
		else super.tileEntitySkullRendererRenderSkull(skullRenderer, f, f1, f2, en, f3, i, gameProfile, i2, f4);
	}

	public void superTileEntitySkullRendererRenderSkull(Object skullRenderer, float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		super.tileEntitySkullRendererRenderSkull(skullRenderer, f, f1, f2, en, f3, i, gameProfile, i2, f4);
	}

	@Override
	protected int itemStackItemID(Object itemstack) {
		return master != null ? master.itemStackItemID(itemstack) : super.itemStackItemID(itemstack);
	}

	public int superItemStackItemID(Object itemstack) {
		return super.itemStackItemID(itemstack);
	}

	@Override
	protected int itemStackStackSize(Object itemstack) {
		return master != null ? master.itemStackStackSize(itemstack) : super.itemStackStackSize(itemstack);
	}

	public int superItemStackStackSize(Object itemstack) {
		return super.itemStackStackSize(itemstack);
	}

	@Override
	protected void setItemStackStackSize(Object itemstack, int i) {
		if (master != null) master.setItemStackStackSize(itemstack, i);
		else super.setItemStackStackSize(itemstack, i);
	}

	public void superSetItemStackStackSize(Object itemstack, int i) {
		super.setItemStackStackSize(itemstack, i);
	}

	@Override
	protected String itemStackGetDisplayName(Object itemstack) {
		return master != null ? master.itemStackGetDisplayName(itemstack) : super.itemStackGetDisplayName(itemstack);
	}

	public String superItemStackGetDisplayName(Object itemstack) {
		return super.itemStackGetDisplayName(itemstack);
	}

	@Override
	protected void itemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		if (master != null) master.itemStackDamageItem(itemstack, i, entityLivingBase);
		else super.itemStackDamageItem(itemstack, i, entityLivingBase);
	}

	public void superItemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		super.itemStackDamageItem(itemstack, i, entityLivingBase);
	}

	@Override
	protected boolean itemRequiresMultipleRenderPasses(Object item) {
		return master != null ? master.itemRequiresMultipleRenderPasses(item) : super.itemRequiresMultipleRenderPasses(item);
	}

	public boolean superItemRequiresMultipleRenderPasses(Object item) {
		return super.itemRequiresMultipleRenderPasses(item);
	}

	@Override
	protected int itemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return master != null ? master.itemGetColorFromItemStack(item, itemstack, i) : super.itemGetColorFromItemStack(item, itemstack, i);
	}

	public int superItemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return super.itemGetColorFromItemStack(item, itemstack, i);
	}

	@Override
	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		return master != null ? master.blockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, x, y, z) : super.blockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, x, y, z);
	}

	public int superBlockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		return super.blockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, x, y, z);
	}

	@Override
	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object iBlockAccess, int x, int y, int z) {
		return master != null ? master.blockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, iBlockAccess, x, y, z) : super.blockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, iBlockAccess, x, y, z);
	}

	public int superBlockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object iBlockAccess, int x, int y, int z) {
		return super.blockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, iBlockAccess, x, y, z);
	}

	@Override
	protected int blockDoublePlantColorMultiplier(Object blockDoublePlant, int x, int y, int z) {
		return master != null ? master.blockDoublePlantColorMultiplier(blockDoublePlant, x, y, z) : super.blockDoublePlantColorMultiplier(blockDoublePlant, x, y, z);
	}

	public int superBlockDoublePlantColorMultiplier(Object blockDoublePlant, int x, int y, int z) {
		return super.blockDoublePlantColorMultiplier(blockDoublePlant, x, y, z);
	}

	@Override
	protected int blockDoublePlantColorMultiplier(Object blockDoublePlant, Object world, int x, int y, int z) {
		return master != null ? master.blockDoublePlantColorMultiplier(blockDoublePlant, world, x, y, z) : super.blockDoublePlantColorMultiplier(blockDoublePlant, world, x, y, z);
	}

	public int superBlockDoublePlantColorMultiplier(Object blockDoublePlant, Object world, int x, int y, int z) {
		return super.blockDoublePlantColorMultiplier(blockDoublePlant, world, x, y, z);
	}

	@Override
	protected int biomeGetBiomeGrassColor(Object biome) {
		return master != null ? master.biomeGetBiomeGrassColor(biome) : super.biomeGetBiomeGrassColor(biome);
	}

	public int superBiomeGetBiomeGrassColor(Object biome) {
		return super.biomeGetBiomeGrassColor(biome);
	}

	@Override
	protected int biomeGetBiomeGrassColor(Object biome, int x, int y, int z) {
		return master != null ? master.biomeGetBiomeGrassColor(biome, x, y, z) : super.biomeGetBiomeGrassColor(biome, x, y, z);
	}

	public int superBiomeGetBiomeGrassColor(Object biome, int x, int y, int z) {
		return super.biomeGetBiomeGrassColor(biome, x, y, z);
	}

	@Override
	protected boolean blockDoublePlantFunc_149887_c(int i) {
		return master != null ? master.blockDoublePlantFunc_149887_c(i) : super.blockDoublePlantFunc_149887_c(i);
	}

	public boolean superBlockDoublePlantFunc_149887_c(int i) {
		return super.blockDoublePlantFunc_149887_c(i);
	}

	@Override
	protected int blockDoublePlantFunc_149890_d(int i) {
		return master != null ? master.blockDoublePlantFunc_149890_d(i) : super.blockDoublePlantFunc_149890_d(i);
	}

	public int superBlockDoublePlantFunc_149890_d(int i) {
		return super.blockDoublePlantFunc_149890_d(i);
	}

	@Override
	protected Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		return master != null ? master.blockDoublePlantFunc_149888_a(blockDoublePlant, b, i) : super.blockDoublePlantFunc_149888_a(blockDoublePlant, b, i);
	}

	public Object superBlockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		return super.blockDoublePlantFunc_149888_a(blockDoublePlant, b, i);
	}

	@Override
	protected Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		return master != null ? master.blockDoublePlantSunflowerIcons(blockDoublePlant) : super.blockDoublePlantSunflowerIcons(blockDoublePlant);
	}

	public Object[] superBlockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		return super.blockDoublePlantSunflowerIcons(blockDoublePlant);
	}

	@Override
	protected double iIconGetMinU(Object iIcon) {
		return master != null ? master.iIconGetMinU(iIcon) : super.iIconGetMinU(iIcon);
	}

	public double superIIconGetMinU(Object iIcon) {
		return super.iIconGetMinU(iIcon);
	}

	@Override
	protected double iIconGetMinV(Object iIcon) {
		return master != null ? master.iIconGetMinV(iIcon) : super.iIconGetMinV(iIcon);
	}

	public double superIIconGetMinV(Object iIcon) {
		return super.iIconGetMinV(iIcon);
	}

	@Override
	protected double iIconGetMaxU(Object iIcon) {
		return master != null ? master.iIconGetMaxU(iIcon) : super.iIconGetMaxU(iIcon);
	}

	public double superIIconGetMaxU(Object iIcon) {
		return super.iIconGetMaxU(iIcon);
	}

	@Override
	protected double iIconGetMaxV(Object iIcon) {
		return master != null ? master.iIconGetMaxV(iIcon) : super.iIconGetMaxV(iIcon);
	}

	public double superIIconGetMaxV(Object iIcon) {
		return super.iIconGetMaxV(iIcon);
	}

	@Override
	protected String iAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return master != null ? master.iAttributeGetAttributeUnlocalizedName(iAttribute) : super.iAttributeGetAttributeUnlocalizedName(iAttribute);
	}

	public String superIAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return super.iAttributeGetAttributeUnlocalizedName(iAttribute);
	}

	@Override
	protected boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return master != null ? master.keyBindingGetIsKeyPressed(keyBinding) : super.keyBindingGetIsKeyPressed(keyBinding);
	}

	public boolean superKeyBindingGetIsKeyPressed(Object keyBinding) {
		return super.keyBindingGetIsKeyPressed(keyBinding);
	}

	@Override
	protected List keybindArray() {
		return master != null ? master.keybindArray() : super.keybindArray();
	}

	public List superKeybindArray() {
		return super.keybindArray();
	}

	@Override
	protected boolean entityRendererAnaglyphEnable() {
		return master != null ? master.entityRendererAnaglyphEnable() : super.entityRendererAnaglyphEnable();
	}

	public boolean superEntityRendererAnaglyphEnable() {
		return super.entityRendererAnaglyphEnable();
	}

	@Override
	protected boolean keyBindingIsPressed(Object keyBinding) {
		return master != null ? master.keyBindingIsPressed(keyBinding) : super.keyBindingIsPressed(keyBinding);
	}

	public boolean superKeyBindingIsPressed(Object keyBinding) {
		return super.keyBindingIsPressed(keyBinding);
	}

	@Override
	protected String keyBindingKeyCategory(Object keyBinding) {
		return master != null ? master.keyBindingKeyCategory(keyBinding) : super.keyBindingKeyCategory(keyBinding);
	}

	public String superKeyBindingKeyCategory(Object keyBinding) {
		return super.keyBindingKeyCategory(keyBinding);
	}

	@Override
	protected int keyBindingKeyCode(Object keyBinding) {
		return master != null ? master.keyBindingKeyCode(keyBinding) : super.keyBindingKeyCode(keyBinding);
	}

	public int superKeyBindingKeyCode(Object keyBinding) {
		return super.keyBindingKeyCode(keyBinding);
	}

	@Override
	protected String keyBindingKeyDescription(Object keyBinding) {
		return master != null ? master.keyBindingKeyDescription(keyBinding) : super.keyBindingKeyDescription(keyBinding);
	}

	public String superKeyBindingKeyDescription(Object keyBinding) {
		return super.keyBindingKeyDescription(keyBinding);
	}

	@Override
	protected boolean keyBindingPressed(Object keyBinding) {
		return master != null ? master.keyBindingPressed(keyBinding) : super.keyBindingPressed(keyBinding);
	}

	public boolean superKeyBindingPressed(Object keyBinding) {
		return super.keyBindingPressed(keyBinding);
	}

	@Override
	protected int keyBindingPressTime(Object keyBinding) {
		return master != null ? master.keyBindingPressTime(keyBinding) : super.keyBindingPressTime(keyBinding);
	}

	public int superKeyBindingPressTime(Object keyBinding) {
		return super.keyBindingPressTime(keyBinding);
	}

	@Override
	protected boolean keyBindingSetPressed(Object keyBinding, boolean b) {
		return master != null ? master.keyBindingSetPressed(keyBinding, b) : super.keyBindingSetPressed(keyBinding, b);
	}

	public boolean superKeyBindingSetPressed(Object keyBinding, boolean b) {
		return super.keyBindingSetPressed(keyBinding, b);
	}

	@Override
	protected void loadingScreenDisplayLoadingString(String s) {
		if (master != null) master.loadingScreenDisplayLoadingString(s);
		else super.loadingScreenDisplayLoadingString(s);
	}

	public void superLoadingScreenDisplayLoadingString(String s) {
		super.loadingScreenDisplayLoadingString(s);
	}

	@Override
	protected void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		if (master != null) master.loadingScreenDisplayLoadingString(loadingScreenRenderer, s);
		else super.loadingScreenDisplayLoadingString(loadingScreenRenderer, s);
	}

	public void superLoadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		super.loadingScreenDisplayLoadingString(loadingScreenRenderer, s);
	}

	@Override
	protected void loadingScreenResetProgressAndMessage(String s) {
		if (master != null) master.loadingScreenResetProgressAndMessage(s);
		else super.loadingScreenResetProgressAndMessage(s);
	}

	public void superLoadingScreenResetProgressAndMessage(String s) {
		super.loadingScreenResetProgressAndMessage(s);
	}

	@Override
	protected void loadingScreenResetProgressAndMessage(Object loadingScreenRenderer, String s) {
		if (master != null) master.loadingScreenResetProgressAndMessage(loadingScreenRenderer, s);
		else super.loadingScreenResetProgressAndMessage(loadingScreenRenderer, s);
	}

	public void superLoadingScreenResetProgressAndMessage(Object loadingScreenRenderer, String s) {
		super.loadingScreenResetProgressAndMessage(loadingScreenRenderer, s);
	}

	@Override
	protected void loadingScreenSetLoadingProgress(int i) {
		if (master != null) master.loadingScreenSetLoadingProgress(i);
		else super.loadingScreenSetLoadingProgress(i);
	}

	public void superLoadingScreenSetLoadingProgress(int i) {
		super.loadingScreenSetLoadingProgress(i);
	}

	@Override
	protected void loadingScreenSetLoadingProgress(Object loadingScreenRenderer, int i) {
		if (master != null) master.loadingScreenSetLoadingProgress(loadingScreenRenderer, i);
		else super.loadingScreenSetLoadingProgress(loadingScreenRenderer, i);
	}

	public void superLoadingScreenSetLoadingProgress(Object loadingScreenRenderer, int i) {
		super.loadingScreenSetLoadingProgress(loadingScreenRenderer, i);
	}

	@Override
	protected float mathHelperCos(float f) {
		return master != null ? master.mathHelperCos(f) : super.mathHelperCos(f);
	}

	public float superMathHelperCos(float f) {
		return super.mathHelperCos(f);
	}

	@Override
	protected int mathHelperFloor(double d) {
		return master != null ? master.mathHelperFloor_double(d) : super.mathHelperFloor(d);
	}

	public int superMathHelperFloor_double(double d) {
		return super.mathHelperFloor(d);
	}

	@Override
	protected float mathHelperFloor(float f) {
		return master != null ? master.mathHelperFloor_float(f) : super.mathHelperFloor(f);
	}

	public float superMathHelperFloor_float(float f) {
		return super.mathHelperFloor(f);
	}

	@Override
	protected float mathHelperWrapAngleTo180_float(float f) {
		return master != null ? master.mathHelperWrapAngleTo180_float(f) : super.mathHelperWrapAngleTo180_float(f);
	}

	public float superMathHelperWrapAngleTo180_float(float f) {
		return super.mathHelperWrapAngleTo180_float(f);
	}

	@Override
	protected long mathHelperLfloor(double d) {
		return master != null ? master.mathHelperLfloor(d) : super.mathHelperLfloor(d);
	}

	public long superMathHelperLfloor(double d) {
		return super.mathHelperLfloor(d);
	}

	@Override
	protected float mathHelperAbs(float f) {
		return master != null ? master.mathHelperAbs(f) : super.mathHelperAbs(f);
	}

	public float superMathHelperAbs(float f) {
		return super.mathHelperAbs(f);
	}

	@Override
	protected double mathHelperAbs_max(double d, double d1) {
		return master != null ? master.mathHelperAbs_max(d, d1) : super.mathHelperAbs_max(d, d1);
	}

	public double superMathHelperAbs_max(double d, double d1) {
		return super.mathHelperAbs_max(d, d1);
	}

	@Override
	protected int mathHelperIntFloorDiv(int i, int j) {
		return master != null ? master.mathHelperIntFloorDiv(i, j) : super.mathHelperIntFloorDiv(i, j);
	}

	public int superMathHelperBucketInt(int i, int j) {
		return super.mathHelperIntFloorDiv(i, j);
	}

	@Override
	protected boolean mathHelperStringNullOrLengthZero(String s) {
		return master != null ? master.mathHelperStringNullOrLengthZero(s) : super.mathHelperStringNullOrLengthZero(s);
	}

	public boolean superMathHelperStringNullOrLengthZero(String s) {
		return super.mathHelperStringNullOrLengthZero(s);
	}

	@Override
	protected float mathHelperSin(float f) {
		return master != null ? master.mathHelperSin(f) : super.mathHelperSin(f);
	}

	public float superMathHelperSin(float f) {
		return super.mathHelperSin(f);
	}

	@Override
	protected float mathHelperSqrt(float f) {
		return master != null ? master.mathHelperSqrt_float(f) : super.mathHelperSqrt(f);
	}

	public float superMathHelperSqrt_float(float f) {
		return super.mathHelperSqrt(f);
	}

	@Override
	protected double mathHelperSqrt(double d) {
		return master != null ? master.mathHelperSqrt_double(d) : super.mathHelperSqrt(d);
	}

	public double superMathHelperSqrt_double(double d) {
		return super.mathHelperSqrt(d);
	}

	@Override
	protected Object minecraftCurrentScreen() {
		return master != null ? master.minecraftCurrentScreen() : super.minecraftCurrentScreen();
	}

	public Object superMinecraftCurrentScreen() {
		return super.minecraftCurrentScreen();
	}

	@Override
	protected Object minecraftMyNetworkManager() {
		return master != null ? master.minecraftMyNetworkManager() : super.minecraftMyNetworkManager();
	}

	public Object superMinecraftMyNetworkManager() {
		return super.minecraftMyNetworkManager();
	}

	@Override
	protected void setMinecraftMyNetworkManager(Object iNetworkManager) {
		if (master != null) master.setMinecraftMyNetworkManager(iNetworkManager);
		else super.setMinecraftMyNetworkManager(iNetworkManager);
	}

	public void superSetMinecraftMyNetworkManager(Object iNetworkManager) {
		super.setMinecraftMyNetworkManager(iNetworkManager);
	}

	@Override
	protected int minecraftDisplayHeight() {
		return master != null ? master.minecraftDisplayHeight() : super.minecraftDisplayHeight();
	}

	public int superMinecraftDisplayHeight() {
		return super.minecraftDisplayHeight();
	}

	@Override
	protected int minecraftDisplayWidth() {
		return master != null ? master.minecraftDisplayWidth() : super.minecraftDisplayWidth();
	}

	public int superMinecraftDisplayWidth() {
		return super.minecraftDisplayWidth();
	}

	@Override
	protected Object minecraftEntityRenderer() {
		return master != null ? master.minecraftEntityRenderer() : super.minecraftEntityRenderer();
	}

	public Object superMinecraftEntityRenderer() {
		return super.minecraftEntityRenderer();
	}

	@Override
	protected Object minecraftEntityRendererItemRenderer() {
		return master != null ? master.minecraftEntityRendererItemRenderer() : super.minecraftEntityRendererItemRenderer();
	}

	public Object superMinecraftEntityRendererItemRenderer() {
		return super.minecraftEntityRendererItemRenderer();
	}

	@Override
	protected Object minecraftFontRenderer() {
		return master != null ? master.minecraftFontRenderer() : super.minecraftFontRenderer();
	}

	public Object superMinecraftFontRenderer() {
		return super.minecraftFontRenderer();
	}

	@Override
	protected void minecraftFontRenderer(Object fontRenderer) {
		if (master != null) master.minecraftFontRenderer(fontRenderer);
		else super.minecraftFontRenderer(fontRenderer);
	}

	public void superMinecraftFontRenderer(Object fontRenderer) {
		super.minecraftFontRenderer(fontRenderer);
	}

	@Override
	protected Object minecraftGameSettings() {
		return master != null ? master.minecraftGameSettings() : super.minecraftGameSettings();
	}

	public Object superMinecraftGameSettings() {
		return super.minecraftGameSettings();
	}

	@Override
	protected void minecraftGameSettingsSetThirdPersonView(int i) {
		if (master != null) master.minecraftGameSettingsSetThirdPersonView(i);
		else super.minecraftGameSettingsSetThirdPersonView(i);
	}

	public void superMinecraftGameSettingsSetThirdPersonView(int i) {
		super.minecraftGameSettingsSetThirdPersonView(i);
	}

	@Override
	protected int minecraftGameSettingsThirdPersonView() {
		return master != null ? master.minecraftGameSettingsThirdPersonView() : super.minecraftGameSettingsThirdPersonView();
	}

	public int superMinecraftGameSettingsThirdPersonView() {
		return super.minecraftGameSettingsThirdPersonView();
	}

	@Override
	protected boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		return master != null ? master.minecraftGameSettingsTouchscreen(gameSettings) : super.minecraftGameSettingsTouchscreen(gameSettings);
	}

	public boolean superMinecraftGameSettingsTouchscreen(Object gameSettings) {
		return super.minecraftGameSettingsTouchscreen(gameSettings);
	}

	@Override
	protected Object minecraftGatSession() {
		return master != null ? master.minecraftGatSession() : super.minecraftGatSession();
	}

	public Object superMinecraftGatSession() {
		return super.minecraftGatSession();
	}

	@Override
	protected Object minecraftGetMinecraft() {
		return master != null ? master.minecraftGetMinecraft() : super.minecraftGetMinecraft();
	}

	public Object superMinecraftGetMinecraft() {
		return super.minecraftGetMinecraft();
	}

	@Override
	protected Object minecraftGetRenderItem() {
		return master != null ? master.minecraftGetRenderItem() : super.minecraftGetRenderItem();
	}

	public Object superMinecraftGetRenderItem() {
		return super.minecraftGetRenderItem();
	}

	@Override
	protected Object minecraftGetResourceManager() {
		return master != null ? master.minecraftGetResourceManager() : super.minecraftGetResourceManager();
	}

	public Object superMinecraftGetResourceManager() {
		return super.minecraftGetResourceManager();
	}

	@Override
	protected long minecraftGetSystemTime() {
		return master != null ? master.minecraftGetSystemTime() : super.minecraftGetSystemTime();
	}

	public long superMinecraftGetSystemTime() {
		return super.minecraftGetSystemTime();
	}

	@Override
	protected Object minecraftGetTextureManager() {
		return master != null ? master.minecraftGetTextureManager() : super.minecraftGetTextureManager();
	}

	public Object superMinecraftGetTextureManager() {
		return super.minecraftGetTextureManager();
	}

	@Override
	protected boolean minecraftInGameHasFocus() {
		return master != null ? master.minecraftInGameHasFocus() : super.minecraftInGameHasFocus();
	}

	public boolean superMinecraftInGameHasFocus() {
		return super.minecraftInGameHasFocus();
	}

	@Override
	protected File minecraftMcDataDir() {
		return master != null ? master.minecraftMcDataDir() : super.minecraftMcDataDir();
	}

	public File superMinecraftMcDataDir() {
		return super.minecraftMcDataDir();
	}

	@Override
	protected Object minecraftGetBlockRendererDispatcher() {
		return master != null ? master.minecraftGetBlockRendererDispatcher() : super.minecraftGetBlockRendererDispatcher();
	}

	public Object superMinecraftGetBlockRendererDispatcher() {
		return super.minecraftGetBlockRendererDispatcher();
	}

	@Override
	protected Object minecraftLoadingScreen() {
		return master != null ? master.minecraftLoadingScreen() : super.minecraftLoadingScreen();
	}

	public Object superMinecraftLoadingScreen() {
		return super.minecraftLoadingScreen();
	}

	@Override
	protected void setMinecraftLoadingScreen(Object loadingScreenRenderer) {
		if (master != null) master.setMinecraftLoadingScreen(loadingScreenRenderer);
		else super.setMinecraftLoadingScreen(loadingScreenRenderer);
	}

	public void superSetMinecraftLoadingScreen(Object loadingScreenRenderer) {
		super.setMinecraftLoadingScreen(loadingScreenRenderer);
	}

	@Override
	protected Object minecraftPlayerController() {
		return master != null ? master.minecraftPlayerController() : super.minecraftPlayerController();
	}

	public Object superMinecraftPlayerController() {
		return super.minecraftPlayerController();
	}

	@Override
	protected Object minecraftSession() {
		return master != null ? master.minecraftSession() : super.minecraftSession();
	}

	public Object superMinecraftSession() {
		return super.minecraftSession();
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer() {
		if (master != null) master.minecraftSetDimensionAndSpawnPlayer();
		else super.minecraftSetDimensionAndSpawnPlayer();
	}

	public void superMinecraftSetDimensionAndSpawnPlayer() {
		super.minecraftSetDimensionAndSpawnPlayer();
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer(int i) {
		if (master != null) master.minecraftSetDimensionAndSpawnPlayer(i);
		else super.minecraftSetDimensionAndSpawnPlayer(i);
	}

	public void superMinecraftSetDimensionAndSpawnPlayer(int i) {
		super.minecraftSetDimensionAndSpawnPlayer(i);
	}

	@Override
	protected long minecraftSystemTime() {
		return master != null ? master.minecraftSystemTime() : super.minecraftSystemTime();
	}

	public long superMinecraftSystemTime() {
		return super.minecraftSystemTime();
	}

	@Override
	protected Object minecraftTextureManager() {
		return master != null ? master.minecraftTextureManager() : super.minecraftTextureManager();
	}

	public Object superMinecraftTextureManager() {
		return super.minecraftTextureManager();
	}

	@Override
	protected Object minecraftPlayer() {
		return master != null ? master.minecraftPlayer() : super.minecraftPlayer();
	}

	public Object superMinecraftPlayer() {
		return super.minecraftPlayer();
	}

	@Override
	protected Object minecraftWorld() {
		return master != null ? master.minecraftWorld() : super.minecraftWorld();
	}

	public Object superMinecraftWorld() {
		return super.minecraftWorld();
	}

	@Override
	protected Object minecraftDisplayGuiScreen() {
		return master != null ? master.minecraftDisplayGuiScreen() : super.minecraftDisplayGuiScreen();
	}

	public Object superMinecraftDisplayGuiScreen() {
		return super.minecraftDisplayGuiScreen();
	}

	@Override
	protected Object minecraftGetIntegratedServer() {
		return master != null ? master.minecraftGetIntegratedServer() : super.minecraftGetIntegratedServer();
	}

	public Object superMinecraftGetIntegratedServer() {
		return super.minecraftGetIntegratedServer();
	}

	@Override
	protected Object minecraftServerGetServer() {
		return master != null ? master.minecraftServerGetServer() : super.minecraftServerGetServer();
	}

	public Object superMinecraftServerGetServer() {
		return super.minecraftServerGetServer();
	}

	@Override
	protected Object[] minecraftServerGetServerWorldServers() {
		return master != null ? master.minecraftServerGetServerWorldServers() : super.minecraftServerGetServerWorldServers();
	}

	public Object[] superMinecraftServerGetServerWorldServers() {
		return super.minecraftServerGetServerWorldServers();
	}

	@Override
	protected File minecraftServerGetFile(String s) {
		return master != null ? master.minecraftServerGetFile(s) : super.minecraftServerGetFile(s);
	}

	public File superMinecraftServerGetFile(String s) {
		return super.minecraftServerGetFile(s);
	}

	@Override
	protected Object minecraftServerGetConfigurationManager(Object minecraftServer) {
		return master != null ? master.minecraftServerGetConfigurationManager(minecraftServer) : super.minecraftServerGetConfigurationManager(minecraftServer);
	}

	public Object superMinecraftServerGetConfigurationManager(Object minecraftServer) {
		return super.minecraftServerGetConfigurationManager(minecraftServer);
	}

	@Override
	protected String minecraftLaunchedVersion() {
		return master != null ? master.minecraftLaunchedVersion() : super.minecraftLaunchedVersion();
	}

	public String superMinecraftLaunchedVersion() {
		return super.minecraftLaunchedVersion();
	}

	@Override
	protected String minecraftLaunchedVersion(Object minecraft) {
		return master != null ? master.minecraftLaunchedVersion(minecraft) : super.minecraftLaunchedVersion(minecraft);
	}

	public String superMinecraftLaunchedVersion(Object minecraft) {
		return super.minecraftLaunchedVersion(minecraft);
	}

	@Override
	protected void minecraftUpdateFramebufferSize() {
		if (master != null) master.minecraftUpdateFramebufferSize();
		else super.minecraftUpdateFramebufferSize();
	}

	public void superMinecraftUpdateFramebufferSize() {
		super.minecraftUpdateFramebufferSize();
	}

	@Override
	protected void minecraftUpdateFramebufferSize(Object minecraft) {
		if (master != null) master.minecraftUpdateFramebufferSize(minecraft);
		else super.minecraftUpdateFramebufferSize(minecraft);
	}

	public void superMinecraftUpdateFramebufferSize(Object minecraft) {
		super.minecraftUpdateFramebufferSize(minecraft);
	}

	@Override
	protected Object modelRightArm(Object model) {
		return master != null ? master.modelRightArm(model) : super.modelRightArm(model);
	}

	public Object superModelRightArm(Object model) {
		return super.modelRightArm(model);
	}

	@Override
	protected Object modelBipedBipedRightArm(Object modelBiped) {
		return master != null ? master.modelBipedBipedRightArm(modelBiped) : super.modelBipedBipedRightArm(modelBiped);
	}

	public Object superModelBipedBipedRightArm(Object modelBiped) {
		return super.modelBipedBipedRightArm(modelBiped);
	}

	@Override
	protected void setModelBipedBipedRightArm(Object modelBiped, Object modelRenderer) {
		if (master != null) master.setModelBipedBipedRightArm(modelBiped, modelRenderer);
		else super.setModelBipedBipedRightArm(modelBiped, modelRenderer);
	}

	public void superSetModelBipedBipedRightArm(Object modelBiped, Object modelRenderer) {
		super.setModelBipedBipedRightArm(modelBiped, modelRenderer);
	}

	@Override
	protected Object modelWolfWolfLeg1(Object modelWolf) {
		return master != null ? master.modelWolfWolfLeg1(modelWolf) : super.modelWolfWolfLeg1(modelWolf);
	}

	public Object superModelWolfWolfLeg1(Object modelWolf) {
		return super.modelWolfWolfLeg1(modelWolf);
	}

	@Override
	protected void setModelWolfWolfLeg1(Object modelWolf, Object modelRenderer) {
		if (master != null) master.setModelWolfWolfLeg1(modelWolf, modelRenderer);
		else super.setModelWolfWolfLeg1(modelWolf, modelRenderer);
	}

	public void superSetModelWolfWolfLeg1(Object modelWolf, Object modelRenderer) {
		super.setModelWolfWolfLeg1(modelWolf, modelRenderer);
	}

	@Override
	protected Object modelSnowManRightHand(Object modelSnowMan) {
		return master != null ? master.modelSnowManRightHand(modelSnowMan) : super.modelSnowManRightHand(modelSnowMan);
	}

	public Object superModelSnowManRightHand(Object modelSnowMan) {
		return super.modelSnowManRightHand(modelSnowMan);
	}

	@Override
	protected void setModelSnowManRightHand(Object modelSnowMan, Object modelRenderer) {
		if (master != null) master.setModelSnowManRightHand(modelSnowMan, modelRenderer);
		else super.setModelSnowManRightHand(modelSnowMan, modelRenderer);
	}

	public void superSetModelSnowManRightHand(Object modelSnowMan, Object modelRenderer) {
		super.setModelSnowManRightHand(modelSnowMan, modelRenderer);
	}

	@Override
	protected Object modelSpiderSpiderLeg1(Object modelSpider) {
		return master != null ? master.modelSpiderSpiderLeg1(modelSpider) : super.modelSpiderSpiderLeg1(modelSpider);
	}

	public Object superModelSpiderSpiderLeg1(Object modelSpider) {
		return super.modelSpiderSpiderLeg1(modelSpider);
	}

	@Override
	protected void setModelSpiderSpiderLeg1(Object modelSpider, Object modelRenderer) {
		if (master != null) master.setModelSpiderSpiderLeg1(modelSpider, modelRenderer);
		else super.setModelSpiderSpiderLeg1(modelSpider, modelRenderer);
	}

	public void superSetModelSpiderSpiderLeg1(Object modelSpider, Object modelRenderer) {
		super.setModelSpiderSpiderLeg1(modelSpider, modelRenderer);
	}

	@Override
	protected Object modelOcelotOcelotFrontRightLeg(Object modelOcelot) {
		return master != null ? master.modelOcelotOcelotFrontRightLeg(modelOcelot) : super.modelOcelotOcelotFrontRightLeg(modelOcelot);
	}

	public Object superModelOcelotOcelotFrontRightLeg(Object modelOcelot) {
		return super.modelOcelotOcelotFrontRightLeg(modelOcelot);
	}

	@Override
	protected void setModelOcelotOcelotFrontRightLeg(Object modelOcelot, Object modelRenderer) {
		if (master != null) master.setModelOcelotOcelotFrontRightLeg(modelOcelot, modelRenderer);
		else super.setModelOcelotOcelotFrontRightLeg(modelOcelot, modelRenderer);
	}

	public void superSetModelOcelotOcelotFrontRightLeg(Object modelOcelot, Object modelRenderer) {
		super.setModelOcelotOcelotFrontRightLeg(modelOcelot, modelRenderer);
	}

	@Override
	protected Object modelIronGolemIronGolemRightArm(Object modelIronGolem) {
		return master != null ? master.modelIronGolemIronGolemRightArm(modelIronGolem) : super.modelIronGolemIronGolemRightArm(modelIronGolem);
	}

	public Object superModelIronGolemIronGolemRightArm(Object modelIronGolem) {
		return super.modelIronGolemIronGolemRightArm(modelIronGolem);
	}

	@Override
	protected void setModelIronGolemIronGolemRightArm(Object modelIronGolem, Object modelRenderer) {
		if (master != null) master.setModelIronGolemIronGolemRightArm(modelIronGolem, modelRenderer);
		else super.setModelIronGolemIronGolemRightArm(modelIronGolem, modelRenderer);
	}

	public void superSetModelIronGolemIronGolemRightArm(Object modelIronGolem, Object modelRenderer) {
		super.setModelIronGolemIronGolemRightArm(modelIronGolem, modelRenderer);
	}

	@Override
	protected Object modelQuadrupedLeg1(Object modelQuadruped) {
		return master != null ? master.modelQuadrupedLeg1(modelQuadruped) : super.modelQuadrupedLeg1(modelQuadruped);
	}

	public Object superModelQuadrupedLeg1(Object modelQuadruped) {
		return super.modelQuadrupedLeg1(modelQuadruped);
	}

	@Override
	protected void setModelQuadrupedLeg1(Object modelQuadruped, Object modelRenderer) {
		if (master != null) master.setModelQuadrupedLeg1(modelQuadruped, modelRenderer);
		else super.setModelQuadrupedLeg1(modelQuadruped, modelRenderer);
	}

	public void superSetModelQuadrupedLeg1(Object modelQuadruped, Object modelRenderer) {
		super.setModelQuadrupedLeg1(modelQuadruped, modelRenderer);
	}

	@Override
	protected Object modelCreeperLeg1(Object modelCreeper) {
		return master != null ? master.modelCreeperLeg1(modelCreeper) : super.modelCreeperLeg1(modelCreeper);
	}

	public Object superModelCreeperLeg1(Object modelCreeper) {
		return super.modelCreeperLeg1(modelCreeper);
	}

	@Override
	protected void setModelCreeperLeg1(Object modelCreeper, Object modelRenderer) {
		if (master != null) master.setModelCreeperLeg1(modelCreeper, modelRenderer);
		else super.setModelCreeperLeg1(modelCreeper, modelRenderer);
	}

	public void superSetModelCreeperLeg1(Object modelCreeper, Object modelRenderer) {
		super.setModelCreeperLeg1(modelCreeper, modelRenderer);
	}

	@Override
	protected Object modelHorseFrontRightLeg(Object modelHorse) {
		return master != null ? master.modelHorseFrontRightLeg(modelHorse) : super.modelHorseFrontRightLeg(modelHorse);
	}

	public Object superModelHorseFrontRightLeg(Object modelHorse) {
		return super.modelHorseFrontRightLeg(modelHorse);
	}

	@Override
	protected void setModelHorseFrontRightLeg(Object modelHorse, Object modelRenderer) {
		if (master != null) master.setModelHorseFrontRightLeg(modelHorse, modelRenderer);
		else super.setModelHorseFrontRightLeg(modelHorse, modelRenderer);
	}

	public void superSetModelHorseFrontRightLeg(Object modelHorse, Object modelRenderer) {
		super.setModelHorseFrontRightLeg(modelHorse, modelRenderer);
	}

	@Override
	protected Object modelBatBatRightWing(Object modelBat) {
		return master != null ? master.modelBatBatRightWing(modelBat) : super.modelBatBatRightWing(modelBat);
	}

	public Object superModelBatBatRightWing(Object modelBat) {
		return super.modelBatBatRightWing(modelBat);
	}

	@Override
	protected void setModelBatBatRightWing(Object modelBat, Object modelRenderer) {
		if (master != null) master.setModelBatBatRightWing(modelBat, modelRenderer);
		else super.setModelBatBatRightWing(modelBat, modelRenderer);
	}

	public void superSetModelBatBatRightWing(Object modelBat, Object modelRenderer) {
		super.setModelBatBatRightWing(modelBat, modelRenderer);
	}

	@Override
	protected Object[] modelSquidSquidTentacles(Object modelSquid) {
		return master != null ? master.modelSquidSquidTentacles(modelSquid) : super.modelSquidSquidTentacles(modelSquid);
	}

	public Object[] superModelSquidSquidTentacles(Object modelSquid) {
		return super.modelSquidSquidTentacles(modelSquid);
	}

	@Override
	protected void setModelSquidSquidTentacles(Object modelSquid, Object[] modelRenderer) {
		if (master != null) master.setModelSquidSquidTentacles(modelSquid, modelRenderer);
		else super.setModelSquidSquidTentacles(modelSquid, modelRenderer);
	}

	public void superSetModelSquidSquidTentacles(Object modelSquid, Object[] modelRenderer) {
		super.setModelSquidSquidTentacles(modelSquid, modelRenderer);
	}

	@Override
	protected Object[] modelBlazeBlazeSticks(Object modelBlaze) {
		return master != null ? master.modelBlazeBlazeSticks(modelBlaze) : super.modelBlazeBlazeSticks(modelBlaze);
	}

	public Object[] superModelBlazeBlazeSticks(Object modelBlaze) {
		return super.modelBlazeBlazeSticks(modelBlaze);
	}

	@Override
	protected void setModelBlazeBlazeSticks(Object modelBlaze, Object[] modelRenderer) {
		if (master != null) master.setModelBlazeBlazeSticks(modelBlaze, modelRenderer);
		else super.setModelBlazeBlazeSticks(modelBlaze, modelRenderer);
	}

	public void superSetModelBlazeBlazeSticks(Object modelBlaze, Object[] modelRenderer) {
		super.setModelBlazeBlazeSticks(modelBlaze, modelRenderer);
	}

	@Override
	protected Object[] modelGhastTentacles(Object modelGhast) {
		return master != null ? master.modelGhastTentacles(modelGhast) : super.modelGhastTentacles(modelGhast);
	}

	public Object[] superModelGhastTentacles(Object modelGhast) {
		return super.modelGhastTentacles(modelGhast);
	}

	@Override
	protected void setModelGhastTentacles(Object modelBlaze, Object[] modelRenderer) {
		if (master != null) master.setModelGhastTentacles(modelBlaze, modelRenderer);
		else super.setModelGhastTentacles(modelBlaze, modelRenderer);
	}

	public void superSetModelGhastTentacles(Object modelBlaze, Object[] modelRenderer) {
		super.setModelGhastTentacles(modelBlaze, modelRenderer);
	}

	@Override
	protected Object modelChickenRightWing(Object modelChicken) {
		return master != null ? master.modelChickenRightWing(modelChicken) : super.modelChickenRightWing(modelChicken);
	}

	public Object superModelChickenRightWing(Object modelChicken) {
		return super.modelChickenRightWing(modelChicken);
	}

	@Override
	protected void setModelChickenRightWing(Object modelChicken, Object modelRenderer) {
		if (master != null) master.setModelChickenRightWing(modelChicken, modelRenderer);
		else super.setModelChickenRightWing(modelChicken, modelRenderer);
	}

	public void superSetModelChickenRightWing(Object modelChicken, Object modelRenderer) {
		super.setModelChickenRightWing(modelChicken, modelRenderer);
	}

	@Override
	protected boolean modelBaseIsChild(Object modelBase) {
		return master != null ? master.modelBaseIsChild(modelBase) : super.modelBaseIsChild(modelBase);
	}

	public boolean superModelBaseIsChild(Object modelBase) {
		return super.modelBaseIsChild(modelBase);
	}

	@Override
	protected void setModelBaseIsChild(Object modelBase, boolean b) {
		if (master != null) master.setModelBaseIsChild(modelBase, b);
		else super.setModelBaseIsChild(modelBase, b);
	}

	public void superSetModelBaseIsChild(Object modelBase, boolean b) {
		super.setModelBaseIsChild(modelBase, b);
	}

	@Override
	protected List modelBaseBoxList(Object modelBase) {
		return master != null ? master.modelBaseBoxList(modelBase) : super.modelBaseBoxList(modelBase);
	}

	public List superModelBaseBoxList(Object modelBase) {
		return super.modelBaseBoxList(modelBase);
	}

	@Override
	protected void setModelBaseBoxList(Object modelBase, List list) {
		if (master != null) master.setModelBaseBoxList(modelBase, list);
		else super.setModelBaseBoxList(modelBase, list);
	}

	public void superSetModelBaseBoxList(Object modelBase, List list) {
		super.setModelBaseBoxList(modelBase, list);
	}

	@Override
	protected int modelBaseTextureWidth(Object modelBase) {
		return master != null ? master.modelBaseTextureWidth(modelBase) : super.modelBaseTextureWidth(modelBase);
	}

	public int superModelBaseTextureWidth(Object modelBase) {
		return super.modelBaseTextureWidth(modelBase);
	}

	@Override
	protected void setModelBaseTextureWidth(Object modelBase, int i) {
		if (master != null) master.setModelBaseTextureWidth(modelBase, i);
		else super.setModelBaseTextureWidth(modelBase, i);
	}

	public void superSetModelBaseTextureWidth(Object modelBase, int i) {
		super.setModelBaseTextureWidth(modelBase, i);
	}

	@Override
	protected int modelBaseTextureHeight(Object modelBase) {
		return master != null ? master.modelBaseTextureHeight(modelBase) : super.modelBaseTextureHeight(modelBase);
	}

	public int superModelBaseTextureHeight(Object modelBase) {
		return super.modelBaseTextureHeight(modelBase);
	}

	@Override
	protected void setModelBaseTextureHeight(Object modelBase, int i) {
		if (master != null) master.setModelBaseTextureHeight(modelBase, i);
		else super.setModelBaseTextureHeight(modelBase, i);
	}

	public void superSetModelBaseTextureHeight(Object modelBase, int i) {
		super.setModelBaseTextureHeight(modelBase, i);
	}

	@Override
	protected Object modelBaseRender(Object model, Object entity, float f, float f2, float f3, float f4, float f5, float f6) {
		return master != null ? master.modelBaseRender(model, entity, f, f2, f3, f4, f5, f6) : super.modelBaseRender(model, entity, f, f2, f3, f4, f5, f6);
	}

	public Object superModelBaseRender(Object model, Object entity, float f, float f2, float f3, float f4, float f5, float f6) {
		return super.modelBaseRender(model, entity, f, f2, f3, f4, f5, f6);
	}

	@Override
	protected void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		if (master != null) master.modelBaseSetLivingAnimations(model, entity, f, f1, f2);
		else super.modelBaseSetLivingAnimations(model, entity, f, f1, f2);
	}

	public void superModelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		super.modelBaseSetLivingAnimations(model, entity, f, f1, f2);
	}

	@Override
	protected void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		if (master != null) master.modelBaseSetRotationAngles(model, f, f1, f2, f3, f4, f5, entity);
		else super.modelBaseSetRotationAngles(model, f, f1, f2, f3, f4, f5, entity);
	}

	public void superModelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		super.modelBaseSetRotationAngles(model, f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	protected ConcurrentHashMap modelRendererGetTextureOffsetMap(Object modelRenderer) {
		return master != null ? master.modelRendererGetTextureOffsetMap(modelRenderer) : super.modelRendererGetTextureOffsetMap(modelRenderer);
	}

	public ConcurrentHashMap superModelRendererGetTextureOffsetMap(Object modelRenderer) {
		return super.modelRendererGetTextureOffsetMap(modelRenderer);
	}

	@Override
	protected int movingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionBlockPosGetX(movingObjectPosition) : super.movingObjectPositionBlockPosGetX(movingObjectPosition);
	}

	public int superMovingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		return super.movingObjectPositionBlockPosGetX(movingObjectPosition);
	}

	@Override
	protected int movingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionBlockPosGetY(movingObjectPosition) : super.movingObjectPositionBlockPosGetY(movingObjectPosition);
	}

	public int superMovingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		return super.movingObjectPositionBlockPosGetY(movingObjectPosition);
	}

	@Override
	protected int movingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionBlockPosGetZ(movingObjectPosition) : super.movingObjectPositionBlockPosGetZ(movingObjectPosition);
	}

	public int superMovingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		return super.movingObjectPositionBlockPosGetZ(movingObjectPosition);
	}

	@Override
	protected int movingObjectPositionSideHit(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionSideHit(movingObjectPosition) : super.movingObjectPositionSideHit(movingObjectPosition);
	}

	public int superMovingObjectPositionSideHit(Object movingObjectPosition) {
		return super.movingObjectPositionSideHit(movingObjectPosition);
	}

	@Override
	protected Enum movingObjectPositionTypeOfHit(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionTypeOfHit(movingObjectPosition) : super.movingObjectPositionTypeOfHit(movingObjectPosition);
	}

	public Enum superMovingObjectPositionTypeOfHit(Object movingObjectPosition) {
		return super.movingObjectPositionTypeOfHit(movingObjectPosition);
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionMovingObjectTypeMISS(movingObjectPosition) : super.movingObjectPositionMovingObjectTypeMISS(movingObjectPosition);
	}

	public Enum superMovingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		return super.movingObjectPositionMovingObjectTypeMISS(movingObjectPosition);
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionMovingObjectTypeBLOCK(movingObjectPosition) : super.movingObjectPositionMovingObjectTypeBLOCK(movingObjectPosition);
	}

	public Enum superMovingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		return super.movingObjectPositionMovingObjectTypeBLOCK(movingObjectPosition);
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionMovingObjectTypeENTITY(movingObjectPosition) : super.movingObjectPositionMovingObjectTypeENTITY(movingObjectPosition);
	}

	public Enum superMovingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		return super.movingObjectPositionMovingObjectTypeENTITY(movingObjectPosition);
	}

	@Override
	protected Object movingObjectPositionHitVec(Object movingObjectPosition) {
		return master != null ? master.movingObjectPositionHitVec(movingObjectPosition) : super.movingObjectPositionHitVec(movingObjectPosition);
	}

	public Object superMovingObjectPositionHitVec(Object movingObjectPosition) {
		return super.movingObjectPositionHitVec(movingObjectPosition);
	}

	@Override
	protected Object newInstanceKeyBinding(String s, int i, String s2) {
		return master != null ? master.newInstanceKeyBinding(s, i, s2) : super.newInstanceKeyBinding(s, i, s2);
	}

	public Object superNewInstanceKeyBinding(String s, int i, String s2) {
		return super.newInstanceKeyBinding(s, i, s2);
	}

	@Override
	protected Object newModelRenderer(Object[] pArg) {
		return master != null ? master.newModelRenderer(pArg) : super.newModelRenderer(pArg);
	}

	public Object superNewModelRenderer(Object[] pArg) {
		return super.newModelRenderer(pArg);
	}

	@Override
	protected Object modelRendererAddBox(Object[] pArg) {
		return master != null ? master.modelRendererAddBox(pArg) : super.modelRendererAddBox(pArg);
	}

	public Object superModelRendererAddBox(Object[] pArg) {
		return super.modelRendererAddBox(pArg);
	}

	@Override
	protected void modelRendererSetRotationPoint(Object modelRenderer, float f, float f1, float f2) {
		if (master != null) master.modelRendererSetRotationPoint(modelRenderer, f, f1, f2);
		else super.modelRendererSetRotationPoint(modelRenderer, f, f1, f2);
	}

	public void superModelRendererSetRotationPoint(Object modelRenderer, float f, float f1, float f2) {
		super.modelRendererSetRotationPoint(modelRenderer, f, f1, f2);
	}

	@Override
	protected boolean modelRendererShowModel(Object modelRenderer) {
		return master != null ? master.modelRendererShowModel(modelRenderer) : super.modelRendererShowModel(modelRenderer);
	}

	public boolean superModelRendererShowModel(Object modelRenderer) {
		return super.modelRendererShowModel(modelRenderer);
	}

	@Override
	protected void setModelRendererShowModel(Object modelRenderer, boolean b) {
		if (master != null) master.setModelRendererShowModel(modelRenderer, b);
		else super.setModelRendererShowModel(modelRenderer, b);
	}

	public void superSetModelRendererShowModel(Object modelRenderer, boolean b) {
		super.setModelRendererShowModel(modelRenderer, b);
	}

	@Override
	protected float modelRendererRotateAngleX(Object modelRenderer) {
		return master != null ? master.modelRendererRotateAngleX(modelRenderer) : super.modelRendererRotateAngleX(modelRenderer);
	}

	public float superModelRendererRotateAngleX(Object modelRenderer) {
		return super.modelRendererRotateAngleX(modelRenderer);
	}

	@Override
	protected void setModelRendererRotateAngleX(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererRotateAngleX(modelRenderer, f);
		else super.setModelRendererRotateAngleX(modelRenderer, f);
	}

	public void superSetModelRendererRotateAngleX(Object modelRenderer, float f) {
		super.setModelRendererRotateAngleX(modelRenderer, f);
	}

	@Override
	protected float modelRendererRotateAngleY(Object modelRenderer) {
		return master != null ? master.modelRendererRotateAngleY(modelRenderer) : super.modelRendererRotateAngleY(modelRenderer);
	}

	public float superModelRendererRotateAngleY(Object modelRenderer) {
		return super.modelRendererRotateAngleY(modelRenderer);
	}

	@Override
	protected void setModelRendererRotateAngleY(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererRotateAngleY(modelRenderer, f);
		else super.setModelRendererRotateAngleY(modelRenderer, f);
	}

	public void superSetModelRendererRotateAngleY(Object modelRenderer, float f) {
		super.setModelRendererRotateAngleY(modelRenderer, f);
	}

	@Override
	protected float modelRendererRotateAngleZ(Object modelRenderer) {
		return master != null ? master.modelRendererRotateAngleZ(modelRenderer) : super.modelRendererRotateAngleZ(modelRenderer);
	}

	public float superModelRendererRotateAngleZ(Object modelRenderer) {
		return super.modelRendererRotateAngleZ(modelRenderer);
	}

	@Override
	protected void setModelRendererRotateAngleZ(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererRotateAngleZ(modelRenderer, f);
		else super.setModelRendererRotateAngleZ(modelRenderer, f);
	}

	public void superSetModelRendererRotateAngleZ(Object modelRenderer, float f) {
		super.setModelRendererRotateAngleZ(modelRenderer, f);
	}

	@Override
	protected float modelRendererRotationPointX(Object modelRenderer) {
		return master != null ? master.modelRendererRotationPointX(modelRenderer) : super.modelRendererRotationPointX(modelRenderer);
	}

	public float superModelRendererRotationPointX(Object modelRenderer) {
		return super.modelRendererRotationPointX(modelRenderer);
	}

	@Override
	protected void setModelRendererRotationPointX(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererRotationPointX(modelRenderer, f);
		else super.setModelRendererRotationPointX(modelRenderer, f);
	}

	public void superSetModelRendererRotationPointX(Object modelRenderer, float f) {
		super.setModelRendererRotationPointX(modelRenderer, f);
	}

	@Override
	protected float modelRendererRotationPointY(Object modelRenderer) {
		return master != null ? master.modelRendererRotationPointY(modelRenderer) : super.modelRendererRotationPointY(modelRenderer);
	}

	public float superModelRendererRotationPointY(Object modelRenderer) {
		return super.modelRendererRotationPointY(modelRenderer);
	}

	@Override
	protected void setModelRendererRotationPointY(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererRotationPointY(modelRenderer, f);
		else super.setModelRendererRotationPointY(modelRenderer, f);
	}

	public void superSetModelRendererRotationPointY(Object modelRenderer, float f) {
		super.setModelRendererRotationPointY(modelRenderer, f);
	}

	@Override
	protected float modelRendererRotationPointZ(Object modelRenderer) {
		return master != null ? master.modelRendererRotationPointZ(modelRenderer) : super.modelRendererRotationPointZ(modelRenderer);
	}

	public float superModelRendererRotationPointZ(Object modelRenderer) {
		return super.modelRendererRotationPointZ(modelRenderer);
	}

	@Override
	protected void setModelRendererRotationPointZ(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererRotationPointZ(modelRenderer, f);
		else super.setModelRendererRotationPointZ(modelRenderer, f);
	}

	public void superSetModelRendererRotationPointZ(Object modelRenderer, float f) {
		super.setModelRendererRotationPointZ(modelRenderer, f);
	}

	@Override
	protected void modelRendererRender(Object modelRenderer, float f) {
		if (master != null) master.modelRendererRender(modelRenderer, f);
		else super.modelRendererRender(modelRenderer, f);
	}

	public void superModelRendererRender(Object modelRenderer, float f) {
		super.modelRendererRender(modelRenderer, f);
	}

	@Override
	protected void modelRendererPostRender(Object modelRenderer, float f) {
		if (master != null) master.modelRendererPostRender(modelRenderer, f);
		else super.modelRendererPostRender(modelRenderer, f);
	}

	public void superModelRendererPostRender(Object modelRenderer, float f) {
		super.modelRendererPostRender(modelRenderer, f);
	}

	@Override
	protected void modelRendererRenderWithRotation(Object modelRenderer, float f) {
		if (master != null) master.modelRendererRenderWithRotation(modelRenderer, f);
		else super.modelRendererRenderWithRotation(modelRenderer, f);
	}

	public void superModelRendererRenderWithRotation(Object modelRenderer, float f) {
		super.modelRendererRenderWithRotation(modelRenderer, f);
	}

	@Override
	protected Object[] modelBoxVertexPositions(Object modelBox) {
		return master != null ? master.modelBoxVertexPositions(modelBox) : super.modelBoxVertexPositions(modelBox);
	}

	public Object[] superModelBoxVertexPositions(Object modelBox) {
		return super.modelBoxVertexPositions(modelBox);
	}

	@Override
	protected void setModelBoxVertexPositions(Object modelBox, Object vertexPositions) {
		if (master != null) master.setModelBoxVertexPositions(modelBox, vertexPositions);
		else super.setModelBoxVertexPositions(modelBox, vertexPositions);
	}

	public void superSetModelBoxVertexPositions(Object modelBox, Object vertexPositions) {
		super.setModelBoxVertexPositions(modelBox, vertexPositions);
	}

	@Override
	protected Object[] modelBoxQuadList(Object modelBox) {
		return master != null ? master.modelBoxQuadList(modelBox) : super.modelBoxQuadList(modelBox);
	}

	public Object[] superModelBoxQuadList(Object modelBox) {
		return super.modelBoxQuadList(modelBox);
	}

	@Override
	protected void setModelBoxQuadList(Object modelBox, Object quadList) {
		if (master != null) master.setModelBoxQuadList(modelBox, quadList);
		else super.setModelBoxQuadList(modelBox, quadList);
	}

	public void superSetModelBoxQuadList(Object modelBox, Object quadList) {
		super.setModelBoxQuadList(modelBox, quadList);
	}

	@Override
	protected boolean nbttagcompoundGetBoolean(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetBoolean(nbttagcompound, s) : super.nbttagcompoundGetBoolean(nbttagcompound, s);
	}

	public boolean superNbttagcompoundGetBoolean(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetBoolean(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetBoolean(Object nbttagcompound, String s, boolean b) {
		if (master != null) master.nbttagcompoundSetBoolean(nbttagcompound, s, b);
		else super.nbttagcompoundSetBoolean(nbttagcompound, s, b);
	}

	public void superNbttagcompoundSetBoolean(Object nbttagcompound, String s, boolean b) {
		super.nbttagcompoundSetBoolean(nbttagcompound, s, b);
	}

	@Override
	protected String nbttagcompoundGetString(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetString(nbttagcompound, s) : super.nbttagcompoundGetString(nbttagcompound, s);
	}

	public String superNbttagcompoundGetString(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetString(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetString(Object nbttagcompound, String s, String s1) {
		if (master != null) master.nbttagcompoundSetString(nbttagcompound, s, s1);
		else super.nbttagcompoundSetString(nbttagcompound, s, s1);
	}

	public void superNbttagcompoundSetString(Object nbttagcompound, String s, String s1) {
		super.nbttagcompoundSetString(nbttagcompound, s, s1);
	}

	@Override
	protected int nbttagcompoundGetInteger(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetInteger(nbttagcompound, s) : super.nbttagcompoundGetInteger(nbttagcompound, s);
	}

	public int superNbttagcompoundGetInteger(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetInteger(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetInteger(Object nbttagcompound, String s, int i) {
		if (master != null) master.nbttagcompoundSetInteger(nbttagcompound, s, i);
		else super.nbttagcompoundSetInteger(nbttagcompound, s, i);
	}

	public void superNbttagcompoundSetInteger(Object nbttagcompound, String s, int i) {
		super.nbttagcompoundSetInteger(nbttagcompound, s, i);
	}

	@Override
	protected float nbttagcompoundGetFloat(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetFloat(nbttagcompound, s) : super.nbttagcompoundGetFloat(nbttagcompound, s);
	}

	public float superNbttagcompoundGetFloat(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetFloat(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetFloat(Object nbttagcompound, String s, float f) {
		if (master != null) master.nbttagcompoundSetFloat(nbttagcompound, s, f);
		else super.nbttagcompoundSetFloat(nbttagcompound, s, f);
	}

	public void superNbttagcompoundSetFloat(Object nbttagcompound, String s, float f) {
		super.nbttagcompoundSetFloat(nbttagcompound, s, f);
	}

	@Override
	protected double nbttagcompoundGetDouble(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetDouble(nbttagcompound, s) : super.nbttagcompoundGetDouble(nbttagcompound, s);
	}

	public double superNbttagcompoundGetDouble(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetDouble(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetDouble(Object nbttagcompound, String s, double d) {
		if (master != null) master.nbttagcompoundSetDouble(nbttagcompound, s, d);
		else super.nbttagcompoundSetDouble(nbttagcompound, s, d);
	}

	public void superNbttagcompoundSetDouble(Object nbttagcompound, String s, double d) {
		super.nbttagcompoundSetDouble(nbttagcompound, s, d);
	}

	@Override
	protected short nbttagcompoundGetShort(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetShort(nbttagcompound, s) : super.nbttagcompoundGetShort(nbttagcompound, s);
	}

	public short superNbttagcompoundGetShort(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetShort(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetShort(Object nbttagcompound, String s, short sh) {
		if (master != null) master.nbttagcompoundSetShort(nbttagcompound, s, sh);
		else super.nbttagcompoundSetShort(nbttagcompound, s, sh);
	}

	public void superNbttagcompoundSetShort(Object nbttagcompound, String s, short sh) {
		super.nbttagcompoundSetShort(nbttagcompound, s, sh);
	}

	@Override
	protected long nbttagcompoundGetLong(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetLong(nbttagcompound, s) : super.nbttagcompoundGetLong(nbttagcompound, s);
	}

	public long superNbttagcompoundGetLong(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetLong(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetLong(Object nbttagcompound, String s, long l) {
		if (master != null) master.nbttagcompoundSetLong(nbttagcompound, s, l);
		else super.nbttagcompoundSetLong(nbttagcompound, s, l);
	}

	public void superNbttagcompoundSetLong(Object nbttagcompound, String s, long l) {
		super.nbttagcompoundSetLong(nbttagcompound, s, l);
	}

	@Override
	protected byte nbttagcompoundGetByte(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetByte(nbttagcompound, s) : super.nbttagcompoundGetByte(nbttagcompound, s);
	}

	public byte superNbttagcompoundGetByte(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetByte(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetByte(Object nbttagcompound, String s, byte by) {
		if (master != null) master.nbttagcompoundSetByte(nbttagcompound, s, by);
		else super.nbttagcompoundSetByte(nbttagcompound, s, by);
	}

	public void superNbttagcompoundSetByte(Object nbttagcompound, String s, byte by) {
		super.nbttagcompoundSetByte(nbttagcompound, s, by);
	}

	@Override
	protected byte[] nbttagcompoundGetByteArray(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetByteArray(nbttagcompound, s) : super.nbttagcompoundGetByteArray(nbttagcompound, s);
	}

	public byte[] superNbttagcompoundGetByteArray(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetByteArray(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetByteArray(Object nbttagcompound, String s, byte[] by) {
		if (master != null) master.nbttagcompoundSetByteArray(nbttagcompound, s, by);
		else super.nbttagcompoundSetByteArray(nbttagcompound, s, by);
	}

	public void superNbttagcompoundSetByteArray(Object nbttagcompound, String s, byte[] by) {
		super.nbttagcompoundSetByteArray(nbttagcompound, s, by);
	}

	@Override
	protected int[] nbttagcompoundGetIntArray(Object nbttagcompound, String s) {
		return master != null ? master.nbttagcompoundGetIntArray(nbttagcompound, s) : super.nbttagcompoundGetIntArray(nbttagcompound, s);
	}

	public int[] superNbttagcompoundGetIntArray(Object nbttagcompound, String s) {
		return super.nbttagcompoundGetIntArray(nbttagcompound, s);
	}

	@Override
	protected void nbttagcompoundSetIntArray(Object nbttagcompound, String s, int[] in) {
		if (master != null) master.nbttagcompoundSetIntArray(nbttagcompound, s, in);
		else super.nbttagcompoundSetIntArray(nbttagcompound, s, in);
	}

	public void superNbttagcompoundSetIntArray(Object nbttagcompound, String s, int[] in) {
		super.nbttagcompoundSetIntArray(nbttagcompound, s, in);
	}

	@Override
	protected Object netClientHandlerGetNetManager(Object netClientHandler) {
		return master != null ? master.netClientHandlerGetNetManager(netClientHandler) : super.netClientHandlerGetNetManager(netClientHandler);
	}

	public Object superNetClientHandlerGetNetManager(Object netClientHandler) {
		return super.netClientHandlerGetNetManager(netClientHandler);
	}

	@Override
	protected void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
		if (master != null) master.netClientHandlerHandleClientCommand(netClientHandler, packet205ClientCommand);
		else super.netClientHandlerHandleClientCommand(netClientHandler, packet205ClientCommand);
	}

	public void superNetClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
		super.netClientHandlerHandleClientCommand(netClientHandler, packet205ClientCommand);
	}

	@Override
	protected Object oldVersionItem(String s) {
		return master != null ? master.oldVersionItem(s) : super.oldVersionItem(s);
	}

	public Object superOldVersionItem(String s) {
		return super.oldVersionItem(s);
	}

	@Override
	protected Object oldVersionBlock(String s) {
		return master != null ? master.oldVersionBlock(s) : super.oldVersionBlock(s);
	}

	public Object superOldVersionBlock(String s) {
		return super.oldVersionBlock(s);
	}

	@Override
	protected int openGlHelperDefaultTexUnit() {
		return master != null ? master.openGlHelperDefaultTexUnit() : super.openGlHelperDefaultTexUnit();
	}

	public int superOpenGlHelperDefaultTexUnit() {
		return super.openGlHelperDefaultTexUnit();
	}

	@Override
	protected int openGlHelperLightmapTexUnit() {
		return master != null ? master.openGlHelperLightmapTexUnit() : super.openGlHelperLightmapTexUnit();
	}

	public int superOpenGlHelperLightmapTexUnit() {
		return super.openGlHelperLightmapTexUnit();
	}

	@Override
	protected void openGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
		if (master != null) master.openGlHelperGlBlendFunc(i, i1, i2, i3);
		else super.openGlHelperGlBlendFunc(i, i1, i2, i3);
	}

	public void superOpenGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
		super.openGlHelperGlBlendFunc(i, i1, i2, i3);
	}

	@Override
	protected void openGlHelperSetActiveTexture(int i) {
		if (master != null) master.openGlHelperSetActiveTexture(i);
		else super.openGlHelperSetActiveTexture(i);
	}

	public void superOpenGlHelperSetActiveTexture(int i) {
		super.openGlHelperSetActiveTexture(i);
	}

	@Override
	protected Object pathNavigateTryMoveToXYZ(Object pathNavigate, int x, int y, int z, float f) {
		return master != null ? master.pathNavigateTryMoveToXYZ(pathNavigate, x, y, z, f) : super.pathNavigateTryMoveToXYZ(pathNavigate, x, y, z, f);
	}

	public Object superPathNavigateTryMoveToXYZ(Object pathNavigate, int x, int y, int z, float f) {
		return super.pathNavigateTryMoveToXYZ(pathNavigate, x, y, z, f);
	}

	@Override
	protected void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		if (master != null) master.pathNavigateGroundFunc_179690_a(pathNavigateGround, b);
		else super.pathNavigateGroundFunc_179690_a(pathNavigateGround, b);
	}

	public void superPathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		super.pathNavigateGroundFunc_179690_a(pathNavigateGround, b);
	}

	@Override
	protected void playerControllerMPSetPlayerCapabilities() {
		if (master != null) master.playerControllerMPSetPlayerCapabilities();
		else super.playerControllerMPSetPlayerCapabilities();
	}

	public void superPlayerControllerMPSetPlayerCapabilities() {
		super.playerControllerMPSetPlayerCapabilities();
	}

	@Override
	protected void playerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
		if (master != null) master.playerControllerMPSetPlayerCapabilities(playerController, entityplayer);
		else super.playerControllerMPSetPlayerCapabilities(playerController, entityplayer);
	}

	public void superPlayerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
		super.playerControllerMPSetPlayerCapabilities(playerController, entityplayer);
	}

	@Override
	protected void playerControllerFunc_6473_b() {
		if (master != null) master.playerControllerFunc_6473_b();
		else super.playerControllerFunc_6473_b();
	}

	public void superPlayerControllerFunc_6473_b() {
		super.playerControllerFunc_6473_b();
	}

	@Override
	protected void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
		if (master != null) master.playerControllerFunc_6473_b(playerController, entityplayer);
		else super.playerControllerFunc_6473_b(playerController, entityplayer);
	}

	public void superPlayerControllerFunc_6473_b(Object playerController, Object entityplayer) {
		super.playerControllerFunc_6473_b(playerController, entityplayer);
	}

	@Override
	protected Object playerControllerMPCreatePlayer() {
		return master != null ? master.playerControllerMPCreatePlayer() : super.playerControllerMPCreatePlayer();
	}

	public Object superPlayerControllerMPCreatePlayer() {
		return super.playerControllerMPCreatePlayer();
	}

	@Override
	protected Object playerControllerMPCreatePlayer(Object playerController) {
		return master != null ? master.playerControllerMPCreatePlayer(playerController) : super.playerControllerMPCreatePlayer(playerController);
	}

	public Object superPlayerControllerMPCreatePlayer(Object playerController) {
		return super.playerControllerMPCreatePlayer(playerController);
	}

	@Override
	protected void playerControllerMPFlipPlayer() {
		if (master != null) master.playerControllerMPFlipPlayer();
		else super.playerControllerMPFlipPlayer();
	}

	public void superPlayerControllerMPFlipPlayer() {
		super.playerControllerMPFlipPlayer();
	}

	@Override
	protected void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		if (master != null) master.playerControllerMPFlipPlayer(playerController, entityplayer);
		else super.playerControllerMPFlipPlayer(playerController, entityplayer);
	}

	public void superPlayerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		super.playerControllerMPFlipPlayer(playerController, entityplayer);
	}

	@Override
	protected void playerControllerSetGameType(Object enumGameType) {
		if (master != null) master.playerControllerSetGameType(enumGameType);
		else super.playerControllerSetGameType(enumGameType);
	}

	public void superPlayerControllerSetGameType(Object enumGameType) {
		super.playerControllerSetGameType(enumGameType);
	}

	@Override
	protected Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return master != null ? master.positionTextureVertexSetTexturePosition(positionTextureVertex, f, f1) : super.positionTextureVertexSetTexturePosition(positionTextureVertex, f, f1);
	}

	public Object superPositionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return super.positionTextureVertexSetTexturePosition(positionTextureVertex, f, f1);
	}

	@Override
	protected float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return master != null ? master.positionTextureVertexTexturePositionX(positionTextureVertex) : super.positionTextureVertexTexturePositionX(positionTextureVertex);
	}

	public float superPositionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return super.positionTextureVertexTexturePositionX(positionTextureVertex);
	}

	@Override
	protected float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return master != null ? master.positionTextureVertexTexturePositionY(positionTextureVertex) : super.positionTextureVertexTexturePositionY(positionTextureVertex);
	}

	public float superPositionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return super.positionTextureVertexTexturePositionY(positionTextureVertex);
	}

	@Override
	protected Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return master != null ? master.positionTextureVertexVector3D(positionTextureVertex) : super.positionTextureVertexVector3D(positionTextureVertex);
	}

	public Object superPositionTextureVertexVector3D(Object positionTextureVertex) {
		return super.positionTextureVertexVector3D(positionTextureVertex);
	}

	@Override
	protected void printChatMessage(String s) {
		if (master != null) master.printChatMessage(s);
		else super.printChatMessage(s);
	}

	public void superPrintChatMessage(String s) {
		super.printChatMessage(s);
	}

	@Override
	protected Object render(Object model) {
		return master != null ? master.render(model) : super.render(model);
	}

	public Object superRender(Object model) {
		return super.render(model);
	}

	@Override
	protected void renderBindTexture(Object render, Object resourceLocation) {
		if (master != null) master.renderBindTexture(render, resourceLocation);
		else super.renderBindTexture(render, resourceLocation);
	}

	public void superRenderBindTexture(Object render, Object resourceLocation) {
		super.renderBindTexture(render, resourceLocation);
	}

	@Override
	protected String[] renderBipedBipedArmorFilenamePrefix() {
		return master != null ? master.renderBipedBipedArmorFilenamePrefix() : super.renderBipedBipedArmorFilenamePrefix();
	}

	public String[] superRenderBipedBipedArmorFilenamePrefix() {
		return super.renderBipedBipedArmorFilenamePrefix();
	}

	@Override
	protected void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		if (master != null) master.renderBlocksRenderBlockAllFaces(renderBlocks, block, i, i2, i3);
		else super.renderBlocksRenderBlockAllFaces(renderBlocks, block, i, i2, i3);
	}

	public void superRenderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		super.renderBlocksRenderBlockAllFaces(renderBlocks, block, i, i2, i3);
	}

	@Override
	protected void renderBlocksDrawCrossedSquares(Object renderBlocks, Object iIcon, double d, double d2, double d3, float f) {
		if (master != null) master.renderBlocksDrawCrossedSquares(renderBlocks, iIcon, d, d2, d3, f);
		else super.renderBlocksDrawCrossedSquares(renderBlocks, iIcon, d, d2, d3, f);
	}

	public void superRenderBlocksDrawCrossedSquares(Object renderBlocks, Object iIcon, double d, double d2, double d3, float f) {
		super.renderBlocksDrawCrossedSquares(renderBlocks, iIcon, d, d2, d3, f);
	}

	@Override
	protected void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		if (master != null) master.renderBlocksRenderBlockAsItem(renderBlocks, block, i, f);
		else super.renderBlocksRenderBlockAsItem(renderBlocks, block, i, f);
	}

	public void superRenderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		super.renderBlocksRenderBlockAsItem(renderBlocks, block, i, f);
	}

	@Override
	protected boolean renderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return master != null ? master.renderBlocksRenderItemIn3d(renderBlocks, i) : super.renderBlocksRenderItemIn3d(renderBlocks, i);
	}

	public boolean superRenderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return super.renderBlocksRenderItemIn3d(renderBlocks, i);
	}

	@Override
	protected Object renderEngine() {
		return master != null ? master.renderEngine() : super.renderEngine();
	}

	public Object superRenderEngine() {
		return super.renderEngine();
	}

	@Override
	protected void renderEngineBindTexture(Object o) {
		if (master != null) master.renderEngineBindTexture(o);
		else super.renderEngineBindTexture(o);
	}

	public void superRenderEngineBindTexture(Object o) {
		super.renderEngineBindTexture(o);
	}

	@Override
	protected void renderEngineSetupTexture(Object bufferedimage, int i) {
		if (master != null) master.renderEngineSetupTexture(bufferedimage, i);
		else super.renderEngineSetupTexture(bufferedimage, i);
	}

	public void superRenderEngineSetupTexture(Object bufferedimage, int i) {
		super.renderEngineSetupTexture(bufferedimage, i);
	}

	@Override
	protected void renderEngineDeleteTexture(Object resourceLocation) {
		if (master != null) master.renderEngineDeleteTexture(resourceLocation);
		else super.renderEngineDeleteTexture(resourceLocation);
	}

	public void superRenderEngineDeleteTexture(Object resourceLocation) {
		super.renderEngineDeleteTexture(resourceLocation);
	}

	@Override
	protected void renderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
		if (master != null) master.renderEngineDeleteTexture(renderEngine, resourceLocation);
		else super.renderEngineDeleteTexture(renderEngine, resourceLocation);
	}

	public void superRenderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
		super.renderEngineDeleteTexture(renderEngine, resourceLocation);
	}

	@Override
	protected Object renderItemGetItemModelMesher(Object renderItem) {
		return master != null ? master.renderItemGetItemModelMesher(renderItem) : super.renderItemGetItemModelMesher(renderItem);
	}

	public Object superRenderItemGetItemModelMesher(Object renderItem) {
		return super.renderItemGetItemModelMesher(renderItem);
	}

	@Override
	protected Object rendererLivingEntityRES_ITEM_GLINT(Object render) {
		return master != null ? master.rendererLivingEntityRES_ITEM_GLINT(render) : super.rendererLivingEntityRES_ITEM_GLINT(render);
	}

	public Object superRendererLivingEntityRES_ITEM_GLINT(Object render) {
		return super.rendererLivingEntityRES_ITEM_GLINT(render);
	}

	@Override
	protected void rendererLivingEntityPassSpecialRender(Object rendererLivingEntity, Object entity, double d, double d1, double d2) {
		if (master != null) master.rendererLivingEntityPassSpecialRender(rendererLivingEntity, entity, d, d1, d2);
		else super.rendererLivingEntityPassSpecialRender(rendererLivingEntity, entity, d, d1, d2);
	}

	public void superRendererLivingEntityPassSpecialRender(Object rendererLivingEntity, Object entity, double d, double d1, double d2) {
		super.rendererLivingEntityPassSpecialRender(rendererLivingEntity, entity, d, d1, d2);
	}

	@Override
	protected void rendererLivingEntitySetRenderPassModel(Object rendererLivingEntity, Object modelBase) {
		if (master != null) master.rendererLivingEntitySetRenderPassModel(rendererLivingEntity, modelBase);
		else super.rendererLivingEntitySetRenderPassModel(rendererLivingEntity, modelBase);
	}

	public void superRendererLivingEntitySetRenderPassModel(Object rendererLivingEntity, Object modelBase) {
		super.rendererLivingEntitySetRenderPassModel(rendererLivingEntity, modelBase);
	}

	@Override
	protected void renderFirstPersonArm(Object render, Object entityplayer) {
		if (master != null) master.renderFirstPersonArm(render, entityplayer);
		else super.renderFirstPersonArm(render, entityplayer);
	}

	public void superRenderFirstPersonArm(Object render, Object entityplayer) {
		super.renderFirstPersonArm(render, entityplayer);
	}

	@Override
	protected boolean renderPlayerSmallArms(Object renderPlayer) {
		return master != null ? master.renderPlayerSmallArms(renderPlayer) : super.renderPlayerSmallArms(renderPlayer);
	}

	public boolean superRenderPlayerSmallArms(Object renderPlayer) {
		return super.renderPlayerSmallArms(renderPlayer);
	}

	@Override
	protected void renderHelperDisableStandardItemLighting() {
		if (master != null) master.renderHelperDisableStandardItemLighting();
		else super.renderHelperDisableStandardItemLighting();
	}

	public void superRenderHelperDisableStandardItemLighting() {
		super.renderHelperDisableStandardItemLighting();
	}

	@Override
	protected void renderHelperEnableStandardItemLighting() {
		if (master != null) master.renderHelperEnableStandardItemLighting();
		else super.renderHelperEnableStandardItemLighting();
	}

	public void superRenderHelperEnableStandardItemLighting() {
		super.renderHelperEnableStandardItemLighting();
	}

	@Override
	protected void renderItems(Object model, Object entity, Object render) {
		if (master != null) master.renderItems(model, entity, render);
		else super.renderItems(model, entity, render);
	}

	public void superRenderItems(Object model, Object entity, Object render) {
		super.renderItems(model, entity, render);
	}

	@Override
	protected Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return master != null ? master.renderLoadDownloadableImageTexture(render, s, s1) : super.renderLoadDownloadableImageTexture(render, s, s1);
	}

	public Object superRenderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return super.renderLoadDownloadableImageTexture(render, s, s1);
	}

	@Override
	protected Object renderMainModel(Object render) {
		return master != null ? master.renderMainModel(render) : super.renderMainModel(render);
	}

	public Object superRenderMainModel(Object render) {
		return super.renderMainModel(render);
	}

	@Override
	protected void renderLivingFunc_110827_b(Object renderLiving, Object entityLiving, double d, double d2, double d3, float f, float f1) {
		if (master != null) master.renderLivingFunc_110827_b(renderLiving, entityLiving, d, d2, d3, f, f1);
		else super.renderLivingFunc_110827_b(renderLiving, entityLiving, d, d2, d3, f, f1);
	}

	public void superRenderLivingFunc_110827_b(Object renderLiving, Object entityLiving, double d, double d2, double d3, float f, float f1) {
		super.renderLivingFunc_110827_b(renderLiving, entityLiving, d, d2, d3, f, f1);
	}

	@Override
	protected boolean renderLivingFunc_110813_b(Object renderLiving, Object entityLiving) {
		return master != null ? master.renderLivingFunc_110813_b(renderLiving, entityLiving) : super.renderLivingFunc_110813_b(renderLiving, entityLiving);
	}

	public boolean superRenderLivingFunc_110813_b(Object renderLiving, Object entityLiving) {
		return super.renderLivingFunc_110813_b(renderLiving, entityLiving);
	}

	@Override
	protected Map renderManagerEntityRenderMap() {
		return master != null ? master.renderManagerEntityRenderMap() : super.renderManagerEntityRenderMap();
	}

	public Map superRenderManagerEntityRenderMap() {
		return super.renderManagerEntityRenderMap();
	}

	@Override
	protected Map renderManagerSkinMap() {
		return master != null ? master.renderManagerSkinMap() : super.renderManagerSkinMap();
	}

	public Map superRenderManagerSkinMap() {
		return super.renderManagerSkinMap();
	}

	@Override
	protected Object renderManagerGetEntityClassRenderObject(Class c) {
		return master != null ? master.renderManagerGetEntityClassRenderObject(c) : super.renderManagerGetEntityClassRenderObject(c);
	}

	public Object superRenderManagerGetEntityClassRenderObject(Class c) {
		return super.renderManagerGetEntityClassRenderObject(c);
	}

	@Override
	protected Object renderManagerGetEntityRenderObject(Object entity) {
		return master != null ? master.renderManagerGetEntityRenderObject(entity) : super.renderManagerGetEntityRenderObject(entity);
	}

	public Object superRenderManagerGetEntityRenderObject(Object entity) {
		return super.renderManagerGetEntityRenderObject(entity);
	}

	@Override
	protected Object renderManagerInstance() {
		//Modchu_Debug.lDebug("Modchu_AS renderManagerInstance master="+master);
		return master != null ? master.renderManagerInstance() : super.renderManagerInstance();
	}

	public Object superRenderManagerInstance() {
		return super.renderManagerInstance();
	}

	@Override
	protected Object renderManagerItemRenderer() {
		return master != null ? master.renderManagerItemRenderer() : super.renderManagerItemRenderer();
	}

	public Object superRenderManagerItemRenderer() {
		return super.renderManagerItemRenderer();
	}

	@Override
	protected void renderManagerItemRendererRenderItem(Object entity, Object itemstack, Object o) {
		if (master != null) master.renderManagerItemRendererRenderItem(entity, itemstack, o);
		else super.renderManagerItemRendererRenderItem(entity, itemstack, o);
	}

	public void superRenderManagerItemRendererRenderItem(Object entity, Object itemstack, Object o) {
		super.renderManagerItemRendererRenderItem(entity, itemstack, o);
	}

	@Override
	protected void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		if (master != null) master.renderManagerItemRendererRenderItem(itemRenderer, entity, itemstack, o);
		else super.renderManagerItemRendererRenderItem(itemRenderer, entity, itemstack, o);
	}

	public void superRenderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		super.renderManagerItemRendererRenderItem(itemRenderer, entity, itemstack, o);
	}

	@Override
	protected boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return master != null ? master.renderManagerRenderEntityWithPosYaw(entity, d, d2, d3, f, f2) : super.renderManagerRenderEntityWithPosYaw(entity, d, d2, d3, f, f2);
	}

	public boolean superRenderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return super.renderManagerRenderEntityWithPosYaw(entity, d, d2, d3, f, f2);
	}

	@Override
	protected Object renderRenderBlocks(Object pRender) {
		return master != null ? master.renderRenderBlocks(pRender) : super.renderRenderBlocks(pRender);
	}

	public Object superRenderRenderBlocks(Object pRender) {
		return super.renderRenderBlocks(pRender);
	}

	@Override
	protected Object renderRenderManager(Object render) {
		return master != null ? master.renderRenderManager(render) : super.renderRenderManager(render);
	}

	public Object superRenderRenderManager(Object render) {
		return super.renderRenderManager(render);
	}

	@Override
	protected Object renderRenderManagerRenderEngine(Object render) {
		return master != null ? master.renderRenderManagerRenderEngine(render) : super.renderRenderManagerRenderEngine(render);
	}

	public Object superRenderRenderManagerRenderEngine(Object render) {
		return super.renderRenderManagerRenderEngine(render);
	}

	@Override
	protected void renderSetRenderManager(Object render) {
		if (master != null) master.renderSetRenderManager(render);
		else super.renderSetRenderManager(render);
	}

	public void superRenderSetRenderManager(Object render) {
		super.renderSetRenderManager(render);
	}

	@Override
	protected InputStream resourceGetInputStream(Object resource) {
		return master != null ? master.resourceGetInputStream(resource) : super.resourceGetInputStream(resource);
	}

	public InputStream superResourceGetInputStream(Object resource) {
		return super.resourceGetInputStream(resource);
	}

	@Override
	protected Object resourceManagerGetResource(Object o) {
		return master != null ? master.resourceManagerGetResource(o) : super.resourceManagerGetResource(o);
	}

	public Object superResourceManagerGetResource(Object o) {
		return super.resourceManagerGetResource(o);
	}

	@Override
	protected Object resourceManagerGetResource(Object resourceManager, Object o) {
		return master != null ? master.resourceManagerGetResource(resourceManager, o) : super.resourceManagerGetResource(resourceManager, o);
	}

	public Object superResourceManagerGetResource(Object resourceManager, Object o) {
		return super.resourceManagerGetResource(resourceManager, o);
	}

	@Override
	protected InputStream resourceManagerInputStream(Object o) {
		return master != null ? master.resourceManagerInputStream(o) : super.resourceManagerInputStream(o);
	}

	public InputStream superResourceManagerInputStream(Object o) {
		return super.resourceManagerInputStream(o);
	}

	@Override
	protected String resourceLocationGetResourceDomain(Object resourceLocation) {
		return master != null ? master.resourceLocationGetResourceDomain(resourceLocation) : super.resourceLocationGetResourceDomain(resourceLocation);
	}

	public String superResourceLocationGetResourceDomain(Object resourceLocation) {
		return super.resourceLocationGetResourceDomain(resourceLocation);
	}

	@Override
	protected String resourceLocationGetResourcePath(Object resourceLocation) {
		return master != null ? master.resourceLocationGetResourcePath(resourceLocation) : super.resourceLocationGetResourcePath(resourceLocation);
	}

	public String superResourceLocationGetResourcePath(Object resourceLocation) {
		return super.resourceLocationGetResourcePath(resourceLocation);
	}

	@Override
	protected void setArmorRendering(Object model, boolean b) {
		if (master != null) master.setArmorRendering(model, b);
		else super.setArmorRendering(model, b);
	}

	public void superSetArmorRendering(Object model, boolean b) {
		super.setArmorRendering(model, b);
	}

	@Override
	protected void setEntityEntityID(Object entity, int i) {
		if (master != null) master.setEntityEntityID(entity, i);
		else super.setEntityEntityID(entity, i);
	}

	public void superSetEntityEntityID(Object entity, int i) {
		super.setEntityEntityID(entity, i);
	}

	@Override
	protected void setEntityFoodStats(Object entityplayer, Object entityGetFoodStats) {
		if (master != null) master.setEntityFoodStats(entityplayer, entityGetFoodStats);
		else super.setEntityFoodStats(entityplayer, entityGetFoodStats);
	}

	public void superSetEntityFoodStats(Object entityplayer, Object entityGetFoodStats) {
		super.setEntityFoodStats(entityplayer, entityGetFoodStats);
	}

	@Override
	protected void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		if (master != null) master.setEntityLivingBaseDeathTime(entityLivingBase, i);
		else super.setEntityLivingBaseDeathTime(entityLivingBase, i);
	}

	public void superSetEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		super.setEntityLivingBaseDeathTime(entityLivingBase, i);
	}

	@Override
	protected void setEntityLivingBaseHealth(Object entity, float f) {
		if (master != null) master.setEntityLivingBaseHealth(entity, f);
		else super.setEntityLivingBaseHealth(entity, f);
	}

	public void superSetEntityLivingBaseHealth(Object entity, float f) {
		super.setEntityLivingBaseHealth(entity, f);
	}

	@Override
	protected void setEntityMotionX(Object entity, double d) {
		if (master != null) master.setEntityMotionX(entity, d);
		else super.setEntityMotionX(entity, d);
	}

	public void superSetEntityMotionX(Object entity, double d) {
		super.setEntityMotionX(entity, d);
	}

	@Override
	protected void setEntityMotionY(Object entity, double d) {
		if (master != null) master.setEntityMotionY(entity, d);
		else super.setEntityMotionY(entity, d);
	}

	public void superSetEntityMotionY(Object entity, double d) {
		super.setEntityMotionY(entity, d);
	}

	@Override
	protected void setEntityMotionZ(Object entity, double d) {
		if (master != null) master.setEntityMotionZ(entity, d);
		else super.setEntityMotionZ(entity, d);
	}

	public void superSetEntityMotionZ(Object entity, double d) {
		super.setEntityMotionZ(entity, d);
	}

	@Override
	protected void setEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		if (master != null) master.setEntityPlayerArmorInventory(entityplayer, armorInventory);
		else super.setEntityPlayerArmorInventory(entityplayer, armorInventory);
	}

	public void superSetEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		super.setEntityPlayerArmorInventory(entityplayer, armorInventory);
	}

	@Override
	protected void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		if (master != null) master.setEntityPlayerCurrentXP(entityplayer, f);
		else super.setEntityPlayerCurrentXP(entityplayer, f);
	}

	public void superSetEntityPlayerCurrentXP(Object entityplayer, float f) {
		super.setEntityPlayerCurrentXP(entityplayer, f);
	}

	@Override
	protected void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		if (master != null) master.setEntityPlayerInventory(entityplayer, inventory);
		else super.setEntityPlayerInventory(entityplayer, inventory);
	}

	public void superSetEntityPlayerInventory(Object entityplayer, Object inventory) {
		super.setEntityPlayerInventory(entityplayer, inventory);
	}

	@Override
	protected void setEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		if (master != null) master.setEntityPlayerMainInventory(entityplayer, mainInventory);
		else super.setEntityPlayerMainInventory(entityplayer, mainInventory);
	}

	public void superSetEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		super.setEntityPlayerMainInventory(entityplayer, mainInventory);
	}

	@Override
	protected void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		if (master != null) master.setEntityPlayerPlayerLevel(entityplayer, i);
		else super.setEntityPlayerPlayerLevel(entityplayer, i);
	}

	public void superSetEntityPlayerPlayerLevel(Object entityplayer, int i) {
		super.setEntityPlayerPlayerLevel(entityplayer, i);
	}

	@Override
	protected void setEntityPlayerScore(Object entityplayer, int i) {
		if (master != null) master.setEntityPlayerScore(entityplayer, i);
		else super.setEntityPlayerScore(entityplayer, i);
	}

	public void superSetEntityPlayerScore(Object entityplayer, int i) {
		super.setEntityPlayerScore(entityplayer, i);
	}

	@Override
	protected void setEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		if (master != null) master.setEntityPlayerSPMovementInput(entityplayer, movementInput);
		else super.setEntityPlayerSPMovementInput(entityplayer, movementInput);
	}

	public void superSetEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		super.setEntityPlayerSPMovementInput(entityplayer, movementInput);
	}

	@Override
	protected void setEntityPlayerTotalXP(Object entityplayer, int i) {
		if (master != null) master.setEntityPlayerTotalXP(entityplayer, i);
		else super.setEntityPlayerTotalXP(entityplayer, i);
	}

	public void superSetEntityPlayerTotalXP(Object entityplayer, int i) {
		super.setEntityPlayerTotalXP(entityplayer, i);
	}

	@Override
	protected void setEntityPosX(Object entity, double d) {
		if (master != null) master.setEntityPosX(entity, d);
		else super.setEntityPosX(entity, d);
	}

	public void superSetEntityPosX(Object entity, double d) {
		super.setEntityPosX(entity, d);
	}

	@Override
	protected void setEntityPosY(Object entity, double d) {
		if (master != null) master.setEntityPosY(entity, d);
		else super.setEntityPosY(entity, d);
	}

	public void superSetEntityPosY(Object entity, double d) {
		super.setEntityPosY(entity, d);
	}

	@Override
	protected void setEntityPosZ(Object entity, double d) {
		if (master != null) master.setEntityPosZ(entity, d);
		else super.setEntityPosZ(entity, d);
	}

	public void superSetEntityPosZ(Object entity, double d) {
		super.setEntityPosZ(entity, d);
	}

	@Override
	protected void setEntityRendererItemRenderer(Object itemRenderer) {
		if (master != null) master.setEntityRendererItemRenderer(itemRenderer);
		else super.setEntityRendererItemRenderer(itemRenderer);
	}

	public void superSetEntityRendererItemRenderer(Object itemRenderer) {
		super.setEntityRendererItemRenderer(itemRenderer);
	}

	@Override
	protected void setEntityYOffset(Object entity, float f) {
		if (master != null) master.setEntityYOffset(entity, f);
		else super.setEntityYOffset(entity, f);
	}

	public void superSetEntityYOffset(Object entity, float f) {
		super.setEntityYOffset(entity, f);
	}

	@Override
	protected void setGameSettingsKeyBindBack(Object keyBinding) {
		if (master != null) master.setGameSettingsKeyBindBack(keyBinding);
		else super.setGameSettingsKeyBindBack(keyBinding);
	}

	public void superSetGameSettingsKeyBindBack(Object keyBinding) {
		super.setGameSettingsKeyBindBack(keyBinding);
	}

	@Override
	protected void setGameSettingsKeyBindForward(Object keyBinding) {
		if (master != null) master.setGameSettingsKeyBindForward(keyBinding);
		else super.setGameSettingsKeyBindForward(keyBinding);
	}

	public void superSetGameSettingsKeyBindForward(Object keyBinding) {
		super.setGameSettingsKeyBindForward(keyBinding);
	}

	@Override
	protected void setGameSettingsKeyBindLeft(Object keyBinding) {
		if (master != null) master.setGameSettingsKeyBindLeft(keyBinding);
		else super.setGameSettingsKeyBindLeft(keyBinding);
	}

	public void superSetGameSettingsKeyBindLeft(Object keyBinding) {
		super.setGameSettingsKeyBindLeft(keyBinding);
	}

	@Override
	protected void setGameSettingsKeyBindRight(Object keyBinding) {
		if (master != null) master.setGameSettingsKeyBindRight(keyBinding);
		else super.setGameSettingsKeyBindRight(keyBinding);
	}

	public void superSetGameSettingsKeyBindRight(Object keyBinding) {
		super.setGameSettingsKeyBindRight(keyBinding);
	}

	@Override
	protected void setGuiButtonEnabled(Object guiButton, boolean b) {
		if (master != null) master.setGuiButtonEnabled(guiButton, b);
		else super.setGuiButtonEnabled(guiButton, b);
	}

	public void superSetGuiButtonEnabled(Object guiButton, boolean b) {
		super.setGuiButtonEnabled(guiButton, b);
	}

	@Override
	protected void setGuiButtonID(Object guiButton, int i) {
		if (master != null) master.setGuiButtonID(guiButton, i);
		else super.setGuiButtonID(guiButton, i);
	}

	public void superSetGuiButtonID(Object guiButton, int i) {
		super.setGuiButtonID(guiButton, i);
	}

	@Override
	protected void setGuiButtonVisible(Object guiButton, boolean b) {
		if (master != null) master.setGuiButtonVisible(guiButton, b);
		else super.setGuiButtonVisible(guiButton, b);
	}

	public void superSetGuiButtonVisible(Object guiButton, boolean b) {
		super.setGuiButtonVisible(guiButton, b);
	}

	@Override
	protected void setGuiButtonXPosition(Object guiButton, int i) {
		if (master != null) master.setGuiButtonXPosition(guiButton, i);
		else super.setGuiButtonXPosition(guiButton, i);
	}

	public void superSetGuiButtonXPosition(Object guiButton, int i) {
		super.setGuiButtonXPosition(guiButton, i);
	}

	@Override
	protected void setGuiButtonYPosition(Object guiButton, int i) {
		if (master != null) master.setGuiButtonYPosition(guiButton, i);
		else super.setGuiButtonYPosition(guiButton, i);
	}

	public void superSetGuiButtonYPosition(Object guiButton, int i) {
		super.setGuiButtonYPosition(guiButton, i);
	}

	@Override
	protected void setGuiScreenButtonList(Object guiScreen, List list) {
		if (master != null) master.setGuiScreenButtonList(guiScreen, list);
		else super.setGuiScreenButtonList(guiScreen, list);
	}

	public void superSetGuiScreenButtonList(Object guiScreen, List list) {
		super.setGuiScreenButtonList(guiScreen, list);
	}

	@Override
	protected void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		if (master != null) master.setGuiScreenFontRenderer(guiScreen, fontRenderer);
		else super.setGuiScreenFontRenderer(guiScreen, fontRenderer);
	}

	public void superSetGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		super.setGuiScreenFontRenderer(guiScreen, fontRenderer);
	}

	@Override
	protected void setGuiScreenHeight(Object guiScreen, int i) {
		if (master != null) master.setGuiScreenHeight(guiScreen, i);
		else super.setGuiScreenHeight(guiScreen, i);
	}

	public void superSetGuiScreenHeight(Object guiScreen, int i) {
		super.setGuiScreenHeight(guiScreen, i);
	}

	@Override
	protected void setGuiScreenWidth(Object guiScreen, int i) {
		if (master != null) master.setGuiScreenWidth(guiScreen, i);
		else super.setGuiScreenWidth(guiScreen, i);
	}

	public void superSetGuiScreenWidth(Object guiScreen, int i) {
		super.setGuiScreenWidth(guiScreen, i);
	}

	@Override
	protected void setMinecraftDisplayGuiScreen(Object guiScreen) {
		if (master != null) master.setMinecraftDisplayGuiScreen(guiScreen);
		else super.setMinecraftDisplayGuiScreen(guiScreen);
	}

	public void superSetMinecraftDisplayGuiScreen(Object guiScreen) {
		super.setMinecraftDisplayGuiScreen(guiScreen);
	}

	@Override
	protected void setMinecraftPlayerController(Object playerController) {
		if (master != null) master.setMinecraftPlayerController(playerController);
		else super.setMinecraftPlayerController(playerController);
	}

	public void superSetMinecraftPlayerController(Object playerController) {
		super.setMinecraftPlayerController(playerController);
	}

	@Override
	protected void setMinecraftRenderViewEntity(Object entity) {
		if (master != null) master.setMinecraftRenderViewEntity(entity);
		else super.setMinecraftRenderViewEntity(entity);
	}

	public void superSetMinecraftRenderViewEntity(Object entity) {
		super.setMinecraftRenderViewEntity(entity);
	}

	@Override
	protected void setMinecraftPlayer(Object entityPlayer) {
		if (master != null) master.setMinecraftPlayer(entityPlayer);
		else super.setMinecraftPlayer(entityPlayer);
	}

	public void superSetMinecraftPlayer(Object entityPlayer) {
		super.setMinecraftPlayer(entityPlayer);
	}

	@Override
	protected void setRender(Object model, Object render) {
		if (master != null) master.setRender(model, render);
		else super.setRender(model, render);
	}

	public void superSetRender(Object model, Object render) {
		super.setRender(model, render);
	}

	@Override
	protected void setRenderMainModel(Object render, Object model) {
		if (master != null) master.setRenderMainModel(render, model);
		else super.setRenderMainModel(render, model);
	}

	public void superSetRenderMainModel(Object render, Object model) {
		super.setRenderMainModel(render, model);
	}

	@Override
	protected void setRenderManagerItemRenderer(Object itemRenderer) {
		if (master != null) master.setRenderManagerItemRenderer(itemRenderer);
		else super.setRenderManagerItemRenderer(itemRenderer);
	}

	public void superSetRenderManagerItemRenderer(Object itemRenderer) {
		super.setRenderManagerItemRenderer(itemRenderer);
	}

	@Override
	protected boolean stringUtilsIsNullOrEmpty(String s) {
		return master != null ? master.stringUtilsIsNullOrEmpty(s) : super.stringUtilsIsNullOrEmpty(s);
	}

	public boolean superStringUtilsIsNullOrEmpty(String s) {
		return super.stringUtilsIsNullOrEmpty(s);
	}

	@Override
	protected Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return master != null ? master.serverConfigurationManagerRespawnPlayer(serverConfigurationManager, entityPlayerMP, i, b) : super.serverConfigurationManagerRespawnPlayer(serverConfigurationManager, entityPlayerMP, i, b);
	}

	public Object superServerConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return super.serverConfigurationManagerRespawnPlayer(serverConfigurationManager, entityPlayerMP, i, b);
	}

	@Override
	protected int scaledresolutionGetScaleFactor(Object scaledresolution) {
		return master != null ? master.scaledresolutionGetScaleFactor(scaledresolution) : super.scaledresolutionGetScaleFactor(scaledresolution);
	}

	public int superScaledresolutionGetScaleFactor(Object scaledresolution) {
		return super.scaledresolutionGetScaleFactor(scaledresolution);
	}

	@Override
	protected int scaledresolutionGetScaledWidth(Object scaledresolution) {
		return master != null ? master.scaledresolutionGetScaledWidth(scaledresolution) : super.scaledresolutionGetScaledWidth(scaledresolution);
	}

	public int superScaledresolutionGetScaledWidth(Object scaledresolution) {
		return super.scaledresolutionGetScaledWidth(scaledresolution);
	}

	@Override
	protected int scaledresolutionGetScaledHeight(Object scaledresolution) {
		return master != null ? master.scaledresolutionGetScaledHeight(scaledresolution) : super.scaledresolutionGetScaledHeight(scaledresolution);
	}

	public int superScaledresolutionGetScaledHeight(Object scaledresolution) {
		return super.scaledresolutionGetScaledHeight(scaledresolution);
	}

	@Override
	protected Object slotGetStack(Object slot) {
		return master != null ? master.slotGetStack(slot) : super.slotGetStack(slot);
	}

	public Object superSlotGetStack(Object slot) {
		return super.slotGetStack(slot);
	}

	@Override
	protected Object sharedMonsterAttributesAttackDamage() {
		return master != null ? master.sharedMonsterAttributesAttackDamage() : super.sharedMonsterAttributesAttackDamage();
	}

	public Object superSharedMonsterAttributesAttackDamage() {
		return super.sharedMonsterAttributesAttackDamage();
	}

	@Override
	protected void framebufferBindFramebuffer(Object framebuffer, boolean b) {
		if (master != null) master.framebufferBindFramebuffer(framebuffer, b);
		else super.framebufferBindFramebuffer(framebuffer, b);
	}

	public void superFramebufferBindFramebuffer(Object framebuffer, boolean b) {
		super.framebufferBindFramebuffer(framebuffer, b);
	}

	@Override
	protected void framebufferUnbindFramebuffer(Object framebuffer) {
		if (master != null) master.framebufferUnbindFramebuffer(framebuffer);
		else super.framebufferUnbindFramebuffer(framebuffer);
	}

	public void superFramebufferUnbindFramebuffer(Object framebuffer) {
		super.framebufferUnbindFramebuffer(framebuffer);
	}

	@Override
	protected void framebufferFramebufferRender(Object framebuffer, int i, int i1) {
		if (master != null) master.framebufferFramebufferRender(framebuffer, i, i1);
		else super.framebufferFramebufferRender(framebuffer, i, i1);
	}

	public void superFramebufferFramebufferRender(Object framebuffer, int i, int i1) {
		super.framebufferFramebufferRender(framebuffer, i, i1);
	}

	@Override
	protected void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		if (master != null) master.tessellatorAddVertex(tessellator, d, d2, d3);
		else super.tessellatorAddVertex(tessellator, d, d2, d3);
	}

	public void superTessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		super.tessellatorAddVertex(tessellator, d, d2, d3);
	}

	public void superTessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		super.tessellatorAddVertex(tessellator, d, d2, d3, i, i1, i2, i3);
	}

	@Override
	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		if (master != null) master.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5);
		else super.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5);
	}

	public void superTessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		super.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5);
	}

	@Override
	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		if (master != null) master.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, f, f1, f2);
		else super.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, f, f1, f2);
	}

	public void superTessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		super.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, f, f1, f2);
	}

	@Override
	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		if (master != null) master.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, i, i1, i2, i3);
		else super.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, i, i1, i2, i3);
	}

	public void superTessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		super.tessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, i, i1, i2, i3);
	}

	@Override
	protected void tessellatorDraw(Object tessellator) {
		if (master != null) master.tessellatorDraw(tessellator);
		else super.tessellatorDraw(tessellator);
	}

	public void superTessellatorDraw(Object tessellator) {
		super.tessellatorDraw(tessellator);
	}

	@Override
	protected Object tessellatorInstance() {
		return master != null ? master.tessellatorInstance() : super.tessellatorInstance();
	}

	public Object superTessellatorInstance() {
		return super.tessellatorInstance();
	}

	@Override
	protected void tessellatorSetColorOpaque_I(int i) {
		if (master != null) master.tessellatorSetColorOpaque_I(i);
		else super.tessellatorSetColorOpaque_I(i);
	}

	public void superTessellatorSetColorOpaque_I(int i) {
		super.tessellatorSetColorOpaque_I(i);
	}

	@Override
	protected void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		if (master != null) master.tessellatorSetColorOpaque_I(tessellator, i);
		else super.tessellatorSetColorOpaque_I(tessellator, i);
	}

	public void superTessellatorSetColorOpaque_I(Object tessellator, int i) {
		super.tessellatorSetColorOpaque_I(tessellator, i);
	}

	@Override
	protected void tessellatorSetColorOpaque_F(float f, float f1, float f2) {
		if (master != null) master.tessellatorSetColorOpaque_F(f, f1, f2);
		else super.tessellatorSetColorOpaque_F(f, f1, f2);
	}

	public void superTessellatorSetColorOpaque_F(float f, float f1, float f2) {
		super.tessellatorSetColorOpaque_F(f, f1, f2);
	}

	@Override
	protected void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		if (master != null) master.tessellatorSetColorOpaque_F(tessellator, f, f1, f2);
		else super.tessellatorSetColorOpaque_F(tessellator, f, f1, f2);
	}

	public void superTessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		super.tessellatorSetColorOpaque_F(tessellator, f, f1, f2);
	}

	@Override
	protected void tessellatorSetBrightness(Object tessellator, int i) {
		if (master != null) master.tessellatorSetBrightness(tessellator, i);
		else super.tessellatorSetBrightness(tessellator, i);
	}

	public void superTessellatorSetBrightness(Object tessellator, int i) {
		super.tessellatorSetBrightness(tessellator, i);
	}

	@Override
	protected void tessellatorSetColorRGBA_I(int i, int i2) {
		if (master != null) master.tessellatorSetColorRGBA_I(i, i2);
		else super.tessellatorSetColorRGBA_I(i, i2);
	}

	public void superTessellatorSetColorRGBA_I(int i, int i2) {
		super.tessellatorSetColorRGBA_I(i, i2);
	}

	@Override
	protected void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		if (master != null) master.tessellatorSetColorRGBA_I(tessellator, i, i2);
		else super.tessellatorSetColorRGBA_I(tessellator, i, i2);
	}

	public void superTessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		super.tessellatorSetColorRGBA_I(tessellator, i, i2);
	}

	@Override
	protected void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		if (master != null) master.tessellatorSetNormal(tessellator, f, f2, f3);
		else super.tessellatorSetNormal(tessellator, f, f2, f3);
	}

	public void superTessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		super.tessellatorSetNormal(tessellator, f, f2, f3);
	}

	@Override
	protected void tessellatorStartDrawing(Object tessellator, int i) {
		if (master != null) master.tessellatorStartDrawing(tessellator, i);
		else super.tessellatorStartDrawing(tessellator, i);
	}

	public void superTessellatorStartDrawing(Object tessellator, int i) {
		super.tessellatorStartDrawing(tessellator, i);
	}

	@Override
	protected void tessellatorStartDrawing(Object tessellator, int i, Object vertexFormat) {
		if (master != null) master.tessellatorStartDrawing(tessellator, i, vertexFormat);
		else super.tessellatorStartDrawing(tessellator, i, vertexFormat);
	}

	public void superTessellatorStartDrawing(Object tessellator, int i, Object vertexFormat) {
		super.tessellatorStartDrawing(tessellator, i, vertexFormat);
	}

	@Override
	protected void tessellatorStartDrawingQuads() {
		if (master != null) master.tessellatorStartDrawingQuads();
		else super.tessellatorStartDrawingQuads();
	}

	public void superTessellatorStartDrawingQuads() {
		super.tessellatorStartDrawingQuads();
	}

	@Override
	protected void tessellatorStartDrawingQuads(Object tessellator) {
		if (master != null) master.tessellatorStartDrawingQuads(tessellator);
		else super.tessellatorStartDrawingQuads(tessellator);
	}

	public void superTessellatorStartDrawingQuads(Object tessellator) {
		super.tessellatorStartDrawingQuads(tessellator);
	}

	@Override
	protected void tessellatorStartDrawingQuads(Object tessellator, int i, Object vertexFormat) {
		if (master != null) master.tessellatorStartDrawingQuads(tessellator, i, vertexFormat);
		else super.tessellatorStartDrawingQuads(tessellator, i, vertexFormat);
	}

	public void superTessellatorStartDrawingQuads(Object tessellator, int i, Object vertexFormat) {
		super.tessellatorStartDrawingQuads(tessellator, i, vertexFormat);
	}

	@Override
	protected void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		if (master != null) master.texturedQuadDraw(texturedQuad, tessellator, f);
		else super.texturedQuadDraw(texturedQuad, tessellator, f);
	}

	public void superTexturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		super.texturedQuadDraw(texturedQuad, tessellator, f);
	}

	@Override
	protected void textureManagerBindTexture(Object o) {
		if (master != null) master.textureManagerBindTexture(o);
		else super.textureManagerBindTexture(o);
	}

	public void superTextureManagerBindTexture(Object o) {
		super.textureManagerBindTexture(o);
	}

	@Override
	protected void textureManagerBindTexture(Object textureManager, Object o) {
		if (master != null) master.textureManagerBindTexture(textureManager, o);
		else super.textureManagerBindTexture(textureManager, o);
	}

	public void superTextureManagerBindTexture(Object textureManager, Object o) {
		super.textureManagerBindTexture(textureManager, o);
	}

	@Override
	protected Object textureManagerGetResourceLocation(int i) {
		return master != null ? master.textureManagerGetResourceLocation(i) : super.textureManagerGetResourceLocation(i);
	}

	public Object superTextureManagerGetResourceLocation(int i) {
		return super.textureManagerGetResourceLocation(i);
	}

	@Override
	protected Object textureManagerGetResourceLocation(Object textureManager, int i) {
		return master != null ? master.textureManagerGetResourceLocation(textureManager, i) : super.textureManagerGetResourceLocation(textureManager, i);
	}

	public Object superTextureManagerGetResourceLocation(Object textureManager, int i) {
		return super.textureManagerGetResourceLocation(textureManager, i);
	}

	@Override
	protected Object textureManagerGetTexture(Object o) {
		return master != null ? master.textureManagerGetTexture(o) : super.textureManagerGetTexture(o);
	}

	public Object superTextureManagerGetTexture(Object o) {
		return super.textureManagerGetTexture(o);
	}

	@Override
	protected Object textureManagerGetTexture(Object textureManager, Object o) {
		return master != null ? master.textureManagerGetTexture(textureManager, o) : super.textureManagerGetTexture(textureManager, o);
	}

	public Object superTextureManagerGetTexture(Object textureManager, Object o) {
		return super.textureManagerGetTexture(textureManager, o);
	}

	@Override
	protected Object textureMapLocationBlocksTexture() {
		return master != null ? master.textureMapLocationBlocksTexture() : super.textureMapLocationBlocksTexture();
	}

	public Object superTextureMapLocationBlocksTexture() {
		return super.textureMapLocationBlocksTexture();
	}

	@Override
	protected int textureOffsetTextureOffsetX(Object textureOffset) {
		return master != null ? master.textureOffsetTextureOffsetX(textureOffset) : super.textureOffsetTextureOffsetX(textureOffset);
	}

	public int superTextureOffsetTextureOffsetX(Object textureOffset) {
		return super.textureOffsetTextureOffsetX(textureOffset);
	}

	@Override
	protected int textureOffsetTextureOffsetY(Object textureOffset) {
		return master != null ? master.textureOffsetTextureOffsetY(textureOffset) : super.textureOffsetTextureOffsetY(textureOffset);
	}

	public int superTextureOffsetTextureOffsetY(Object textureOffset) {
		return super.textureOffsetTextureOffsetY(textureOffset);
	}

	@Override
	protected void textureUtilBindTexture(int i) {
		if (master != null) master.textureUtilBindTexture(i);
		else super.textureUtilBindTexture(i);
	}

	public void superTextureUtilBindTexture(int i) {
		super.textureUtilBindTexture(i);
	}

	@Override
	protected int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return master != null ? master.textureUtilUploadTextureImage(i, bufferedimage) : super.textureUtilUploadTextureImage(i, bufferedimage);
	}

	public int superTextureUtilUploadTextureImage(int i, Object bufferedimage) {
		return super.textureUtilUploadTextureImage(i, bufferedimage);
	}

	@Override
	protected int textureUtilAnaglyphColor(int i) {
		return master != null ? master.textureUtilAnaglyphColor(i) : super.textureUtilAnaglyphColor(i);
	}

	public int superTextureUtilAnaglyphColor(int i) {
		return super.textureUtilAnaglyphColor(i);
	}

	@Override
	protected boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return master != null ? master.threadDownloadImageDataIsTextureUploaded(threadDownloadImageData) : super.threadDownloadImageDataIsTextureUploaded(threadDownloadImageData);
	}

	public boolean superThreadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return super.threadDownloadImageDataIsTextureUploaded(threadDownloadImageData);
	}

	@Override
	protected int threadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return master != null ? master.threadDownloadImageDataGetGlTextureId(threadDownloadImageData) : super.threadDownloadImageDataGetGlTextureId(threadDownloadImageData);
	}

	public int superThreadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return super.threadDownloadImageDataGetGlTextureId(threadDownloadImageData);
	}

	@Override
	protected Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return master != null ? master.vec3CreateVectorHelper(d, d2, d3) : super.vec3CreateVectorHelper(d, d2, d3);
	}

	public Object superVec3CreateVectorHelper(double d, double d2, double d3) {
		return super.vec3CreateVectorHelper(d, d2, d3);
	}

	@Override
	protected Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return master != null ? master.vec3CrossProduct(vec3, vec3_2) : super.vec3CrossProduct(vec3, vec3_2);
	}

	public Object superVec3CrossProduct(Object vec3, Object vec3_2) {
		return super.vec3CrossProduct(vec3, vec3_2);
	}

	@Override
	protected Object vec3Normalize(Object vec3) {
		return master != null ? master.vec3Normalize(vec3) : super.vec3Normalize(vec3);
	}

	public Object superVec3Normalize(Object vec3) {
		return super.vec3Normalize(vec3);
	}

	@Override
	protected Object vec3Subtract(Object vec3, Object vec3_2) {
		return master != null ? master.vec3Subtract(vec3, vec3_2) : super.vec3Subtract(vec3, vec3_2);
	}

	public Object superVec3Subtract(Object vec3, Object vec3_2) {
		return super.vec3Subtract(vec3, vec3_2);
	}

	@Override
	protected double vec3XCoord(Object vec3) {
		return master != null ? master.vec3XCoord(vec3) : super.vec3XCoord(vec3);
	}

	public double superVec3XCoord(Object vec3) {
		return super.vec3XCoord(vec3);
	}

	@Override
	protected double vec3YCoord(Object vec3) {
		return master != null ? master.vec3YCoord(vec3) : super.vec3YCoord(vec3);
	}

	public double superVec3YCoord(Object vec3) {
		return super.vec3YCoord(vec3);
	}

	@Override
	protected double vec3ZCoord(Object vec3) {
		return master != null ? master.vec3ZCoord(vec3) : super.vec3ZCoord(vec3);
	}

	public double superVec3ZCoord(Object vec3) {
		return super.vec3ZCoord(vec3);
	}

	@Override
	protected double vec3SquareDistanceTo(Object vec3, Object vec3_2) {
		return master != null ? master.vec3SquareDistanceTo(vec3, vec3_2) : super.vec3SquareDistanceTo(vec3, vec3_2);
	}

	public double superVec3SquareDistanceTo(Object vec3, Object vec3_2) {
		return super.vec3SquareDistanceTo(vec3, vec3_2);
	}

	@Override
	protected Object vec3AddVector(Object vec3, double d, double d2, double d3) {
		return master != null ? master.vec3AddVector(vec3, d, d2, d3) : super.vec3AddVector(vec3, d, d2, d3);
	}

	public Object superVec3AddVector(Object vec3, double d, double d2, double d3) {
		return super.vec3AddVector(vec3, d, d2, d3);
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(double d, double d2, double d3) {
		return master != null ? master.worldCanBlockSeeTheSky(d, d2, d3) : super.worldCanBlockSeeTheSky(d, d2, d3);
	}

	public boolean superWorldCanBlockSeeTheSky(double d, double d2, double d3) {
		return super.worldCanBlockSeeTheSky(d, d2, d3);
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(int i, int i2, int i3) {
		return master != null ? master.worldCanBlockSeeTheSky(i, i2, i3) : super.worldCanBlockSeeTheSky(i, i2, i3);
	}

	public boolean superWorldCanBlockSeeTheSky(int i, int i2, int i3) {
		return super.worldCanBlockSeeTheSky(i, i2, i3);
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return master != null ? master.worldCanBlockSeeTheSky(worldOrEntity, d, d2, d3) : super.worldCanBlockSeeTheSky(worldOrEntity, d, d2, d3);
	}

	public boolean superWorldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return super.worldCanBlockSeeTheSky(worldOrEntity, d, d2, d3);
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return master != null ? master.worldCanBlockSeeTheSky(worldOrEntity, i, i2, i3) : super.worldCanBlockSeeTheSky(worldOrEntity, i, i2, i3);
	}

	public boolean superWorldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return super.worldCanBlockSeeTheSky(worldOrEntity, i, i2, i3);
	}

	@Override
	protected List worldGetEntitiesWithinAABBExcludingEntity(Object entity, Object axisAlignedBB) {
		return master != null ? master.worldGetEntitiesWithinAABBExcludingEntity(entity, axisAlignedBB) : super.worldGetEntitiesWithinAABBExcludingEntity(entity, axisAlignedBB);
	}

	public List superWorldGetEntitiesWithinAABBExcludingEntity(Object entity, Object axisAlignedBB) {
		return super.worldGetEntitiesWithinAABBExcludingEntity(entity, axisAlignedBB);
	}

	@Override
	protected List worldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return master != null ? master.worldGetEntitiesWithinAABBExcludingEntity(worldOrEntity, entity, axisAlignedBB) : super.worldGetEntitiesWithinAABBExcludingEntity(worldOrEntity, entity, axisAlignedBB);
	}

	public List superWorldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return super.worldGetEntitiesWithinAABBExcludingEntity(worldOrEntity, entity, axisAlignedBB);
	}

	@Override
	protected Object worldGetWorldInfo() {
		return master != null ? master.worldGetWorldInfo() : super.worldGetWorldInfo();
	}

	public Object superWorldGetWorldInfo() {
		return super.worldGetWorldInfo();
	}

	@Override
	protected void worldRemoveEntity(Object world, Object entity) {
		if (master != null) master.worldRemoveEntity(world, entity);
		else super.worldRemoveEntity(world, entity);
	}

	public void superWorldRemoveEntity(Object world, Object entity) {
		super.worldRemoveEntity(world, entity);
	}

	@Override
	protected Object worldGetBlock(int i, int i2, int i3) {
		return master != null ? master.worldGetBlock(i, i2, i3) : super.worldGetBlock(i, i2, i3);
	}

	public Object superWorldGetBlock(int i, int i2, int i3) {
		return super.worldGetBlock(i, i2, i3);
	}

	@Override
	protected Object worldGetBlock(Object world, int i, int i2, int i3) {
		return master != null ? master.worldGetBlock(world, i, i2, i3) : super.worldGetBlock(world, i, i2, i3);
	}

	public Object superWorldGetBlock(Object world, int i, int i2, int i3) {
		return super.worldGetBlock(world, i, i2, i3);
	}

	@Override
	protected Enum worldGetWorldInfoGetGameType() {
		return master != null ? master.worldGetWorldInfoGetGameType() : super.worldGetWorldInfoGetGameType();
	}

	public Enum superWorldGetWorldInfoGetGameType() {
		return super.worldGetWorldInfoGetGameType();
	}

	@Override
	protected Enum worldSettingsGameTypeNOT_SET() {
		return master != null ? master.worldSettingsGameTypeNOT_SET() : super.worldSettingsGameTypeNOT_SET();
	}

	public Enum superWorldSettingsGameTypeNOT_SET() {
		return super.worldSettingsGameTypeNOT_SET();
	}

	@Override
	protected Enum worldSettingsGameTypeSURVIVAL() {
		return master != null ? master.worldSettingsGameTypeSURVIVAL() : super.worldSettingsGameTypeSURVIVAL();
	}

	public Enum superWorldSettingsGameTypeSURVIVAL() {
		return super.worldSettingsGameTypeSURVIVAL();
	}

	@Override
	protected Enum worldSettingsGameTypeCREATIVE() {
		return master != null ? master.worldSettingsGameTypeCREATIVE() : super.worldSettingsGameTypeCREATIVE();
	}

	public Enum superWorldSettingsGameTypeCREATIVE() {
		return super.worldSettingsGameTypeCREATIVE();
	}

	@Override
	protected Enum worldSettingsGameTypeADVENTURE() {
		return master != null ? master.worldSettingsGameTypeADVENTURE() : super.worldSettingsGameTypeADVENTURE();
	}

	public Enum superWorldSettingsGameTypeADVENTURE() {
		return super.worldSettingsGameTypeADVENTURE();
	}

	@Override
	protected boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return master != null ? master.worldIsAirBlock(worldOrEntity, i, j, k) : super.worldIsAirBlock(worldOrEntity, i, j, k);
	}

	public boolean superWorldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return super.worldIsAirBlock(worldOrEntity, i, j, k);
	}

	@Override
	protected boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return master != null ? master.worldIsBlockNormalCubeDefault(worldOrEntity, i, j, k, b) : super.worldIsBlockNormalCubeDefault(worldOrEntity, i, j, k, b);
	}

	public boolean superWorldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return super.worldIsBlockNormalCubeDefault(worldOrEntity, i, j, k, b);
	}

	@Override
	protected boolean worldIsDaytime(Object worldOrEntity) {
		return master != null ? master.worldIsDaytime(worldOrEntity) : super.worldIsDaytime(worldOrEntity);
	}

	public boolean superWorldIsDaytime(Object worldOrEntity) {
		return super.worldIsDaytime(worldOrEntity);
	}

	@Override
	protected boolean worldIsRemote(Object worldOrEntity) {
		return master != null ? master.worldIsRemote(worldOrEntity) : super.worldIsRemote(worldOrEntity);
	}

	public boolean superWorldIsRemote(Object worldOrEntity) {
		return super.worldIsRemote(worldOrEntity);
	}

	@Override
	protected List playerEntities(Object worldOrEntity) {
		return master != null ? master.playerEntities(worldOrEntity) : super.playerEntities(worldOrEntity);
	}

	public List superPlayerEntities(Object worldOrEntity) {
		return super.playerEntities(worldOrEntity);
	}

	@Override
	protected List worldPlayerEntities(Object worldOrEntity) {
		return master != null ? master.worldPlayerEntities(worldOrEntity) : super.worldPlayerEntities(worldOrEntity);
	}

	public List superWorldPlayerEntities(Object worldOrEntity) {
		return super.worldPlayerEntities(worldOrEntity);
	}

	@Override
	protected List worldWeatherEffects(Object worldOrEntity) {
		return master != null ? master.worldWeatherEffects(worldOrEntity) : super.worldWeatherEffects(worldOrEntity);
	}

	public List superWorldWeatherEffects(Object worldOrEntity) {
		return super.worldWeatherEffects(worldOrEntity);
	}

	@Override
	protected void worldSetEntityDead(Object worldOrEntity, Object entity) {
		if (master != null) master.worldSetEntityDead(worldOrEntity, entity);
		else super.worldSetEntityDead(worldOrEntity, entity);
	}

	public void superWorldSetEntityDead(Object worldOrEntity, Object entity) {
		super.worldSetEntityDead(worldOrEntity, entity);
	}

	@Override
	protected void worldSpawnPlayerWithLoadedChunks(Object entity) {
		if (master != null) master.worldSpawnPlayerWithLoadedChunks(entity);
		else super.worldSpawnPlayerWithLoadedChunks(entity);
	}

	public void superWorldSpawnPlayerWithLoadedChunks(Object entity) {
		super.worldSpawnPlayerWithLoadedChunks(entity);
	}

	@Override
	protected Random worldRand(Object worldOrEntity) {
		return (Random) (master != null ? master.worldRand(worldOrEntity) : super.worldRand(worldOrEntity));
	}

	public Random superWorldRand(Object worldOrEntity) {
		return super.worldRand(worldOrEntity);
	}

	@Override
	protected void worldSpawnPlayerWithLoadedChunks(Object worldOrEntity, Object entity) {
		if (master != null) master.worldSpawnPlayerWithLoadedChunks(worldOrEntity, entity);
		else super.worldSpawnPlayerWithLoadedChunks(worldOrEntity, entity);
	}

	public void superWorldSpawnPlayerWithLoadedChunks(Object worldOrEntity, Object entity) {
		super.worldSpawnPlayerWithLoadedChunks(worldOrEntity, entity);
	}

	@Override
	protected void worldSpawnParticle(Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		if (master != null) master.worldSpawnParticle(stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
		else super.worldSpawnParticle(stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	public void superWorldSpawnParticle(Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		super.worldSpawnParticle(stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	@Override
	protected void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		if (master != null) master.worldSpawnParticle(worldOrEntity, stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
		else super.worldSpawnParticle(worldOrEntity, stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	public void superWorldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		super.worldSpawnParticle(worldOrEntity, stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	@Override
	protected void worldPlaySoundAtEntity(Object worldOrEntity, Object entity, Object soundEventOrString, float f, float f1) {
		if (master != null) master.worldPlaySoundAtEntity(worldOrEntity, entity, soundEventOrString, f, f1);
		else super.worldPlaySoundAtEntity(worldOrEntity, entity, soundEventOrString, f, f1);
	}

	public void superWorldPlaySoundAtEntity(Object worldOrEntity, Object entity, Object soundEventOrString, float f, float f1) {
		super.worldPlaySoundAtEntity(worldOrEntity, entity, soundEventOrString, f, f1);
	}

	@Override
	protected void worldPlaySoundAtEntity(Object worldOrEntity, Object entityPlayer, double x, double y, double z, Object soundEvent, Object soundCategory, float f, float f1) {
		if (master != null) master.worldPlaySoundAtEntity(worldOrEntity, entityPlayer, x, y, z, soundEvent, soundCategory, f, f1);
		else super.worldPlaySoundAtEntity(worldOrEntity, entityPlayer, x, y, z, soundEvent, soundCategory, f, f1);
	}

	public void superWorldPlaySoundAtEntity(Object worldOrEntity, Object entityPlayer, double x, double y, double z, Object soundEvent, Object soundCategory, float f, float f1) {
		super.worldPlaySoundAtEntity(worldOrEntity, entityPlayer, x, y, z, soundEvent, soundCategory, f, f1);
	}

	@Override
	protected boolean worldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		return master != null ? master.worldIsBlockModifiable(worldOrEntity, entityPlayer, x, y, z) : super.worldIsBlockModifiable(worldOrEntity, entityPlayer, x, y, z);
	}

	public boolean superWorldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		return super.worldIsBlockModifiable(worldOrEntity, entityPlayer, x, y, z);
	}

	@Override
	protected void worldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		if (master != null) master.worldSetEntityState(worldOrEntity, entity, by);
		else super.worldSetEntityState(worldOrEntity, entity, by);
	}

	public void superWorldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		super.worldSetEntityState(worldOrEntity, entity, by);
	}

	@Override
	protected Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return master != null ? master.worldGetPathEntityToEntity(worldOrEntity, entity, entity2, f, b, b1, b2, b3) : super.worldGetPathEntityToEntity(worldOrEntity, entity, entity2, f, b, b1, b2, b3);
	}

	public Object superWorldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return super.worldGetPathEntityToEntity(worldOrEntity, entity, entity2, f, b, b1, b2, b3);
	}

	@Override
	protected List worldGetEntitiesWithinAABB(Object worldOrEntity, Class c, Object axisAlignedBB) {
		return master != null ? master.worldGetEntitiesWithinAABB(worldOrEntity, c, axisAlignedBB) : super.worldGetEntitiesWithinAABB(worldOrEntity, c, axisAlignedBB);
	}

	public List superWorldGetEntitiesWithinAABB(Object worldOrEntity, Object c, Object axisAlignedBB) {
		return super.worldGetEntitiesWithinAABB(worldOrEntity, (Class) c, axisAlignedBB);
	}

	@Override
	protected List worldLoadedEntityList(Object worldOrEntity) {
		return master != null ? master.worldLoadedEntityList(worldOrEntity) : super.worldLoadedEntityList(worldOrEntity);
	}

	public List superWorldLoadedEntityList(Object worldOrEntity) {
		return super.worldLoadedEntityList(worldOrEntity);
	}

	@Override
	protected Object worldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return master != null ? master.worldGetClosestPlayerToEntity(worldOrEntity, entity, d) : super.worldGetClosestPlayerToEntity(worldOrEntity, entity, d);
	}

	public Object superWorldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return super.worldGetClosestPlayerToEntity(worldOrEntity, entity, d);
	}

	@Override
	protected Object worldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return master != null ? master.worldGetPlayerEntityByName(worldOrEntity, s) : super.worldGetPlayerEntityByName(worldOrEntity, s);
	}

	public Object superWorldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return super.worldGetPlayerEntityByName(worldOrEntity, s);
	}

	@Override
	protected Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return master != null ? master.worldGetBiomeGenForCoords(worldOrInt, blockPosOrInt) : super.worldGetBiomeGenForCoords(worldOrInt, blockPosOrInt);
	}

	public Object superWorldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return super.worldGetBiomeGenForCoords(worldOrInt, blockPosOrInt);
	}

	@Override
	protected Object worldGetBiomeGenForCoords(Object worldOrEntity, int i, int i1) {
		return master != null ? master.worldGetBiomeGenForCoords(worldOrEntity, i, i1) : super.worldGetBiomeGenForCoords(worldOrEntity, i, i1);
	}

	public Object superWorldGetBiomeGenForCoords(Object worldOrEntity, int i, int i1) {
		return super.worldGetBiomeGenForCoords(worldOrEntity, i, i1);
	}

	@Override
	protected boolean worldSpawnEntity(Object worldOrEntity, Object entity) {
		return master != null ? master.worldSpawnEntity(worldOrEntity, entity) : super.worldSpawnEntity(worldOrEntity, entity);
	}

	public boolean superWorldSpawnEntity(Object worldOrEntity, Object entity) {
		return super.worldSpawnEntity(worldOrEntity, entity);
	}

	@Override
	protected void worldClientAddEntityToWorld(Object worldClient, int i, Object entity) {
		if (master != null) master.worldClientAddEntityToWorld(worldClient, i, entity);
		else super.worldClientAddEntityToWorld(worldClient, i, entity);
	}

	public void superWorldClientAddEntityToWorld(Object worldClient, int i, Object entity) {
		super.worldClientAddEntityToWorld(worldClient, i, entity);
	}

	@Override
	protected int worldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		return master != null ? master.worldGetBlockStateGetBlockMetadata(worldOrEntity, x, y, z) : super.worldGetBlockStateGetBlockMetadata(worldOrEntity, x, y, z);
	}

	public int superWorldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		return super.worldGetBlockStateGetBlockMetadata(worldOrEntity, x, y, z);
	}

	@Override
	protected int worldGetBlockLightValue(Object worldOrEntity, int x, int y, int z) {
		return master != null ? master.worldGetBlockLightValue(worldOrEntity, x, y, z) : super.worldGetBlockLightValue(worldOrEntity, x, y, z);
	}

	public int superWorldGetBlockLightValue(Object worldOrEntity, int x, int y, int z) {
		return super.worldGetBlockLightValue(worldOrEntity, x, y, z);
	}

	@Override
	protected int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return master != null ? master.worldGetStrongPower(worldOrEntity, x, y, z) : super.worldGetStrongPower(worldOrEntity, x, y, z);
	}

	public int superWorldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return super.worldGetStrongPower(worldOrEntity, x, y, z);
	}

	@Override
	protected int tileEntityXCoord(Object tileEntity) {
		return master != null ? master.tileEntityXCoord(tileEntity) : super.tileEntityXCoord(tileEntity);
	}

	public int superTileEntityXCoord(Object tileEntity) {
		return super.tileEntityXCoord(tileEntity);
	}

	@Override
	protected int tileEntityYCoord(Object tileEntity) {
		return master != null ? master.tileEntityYCoord(tileEntity) : super.tileEntityYCoord(tileEntity);
	}

	public int superTileEntityYCoord(Object tileEntity) {
		return super.tileEntityYCoord(tileEntity);
	}

	@Override
	protected int tileEntityZCoord(Object tileEntity) {
		return master != null ? master.tileEntityZCoord(tileEntity) : super.tileEntityZCoord(tileEntity);
	}

	public int superTileEntityZCoord(Object tileEntity) {
		return super.tileEntityZCoord(tileEntity);
	}

	@Override
	protected Object newBlockPos(Object x, Object y, Object z) {
		return master != null ? master.newBlockPos(x, y, z) : super.newBlockPos(x, y, z);
	}

	public Object superNewBlockPos(Object x, Object y, Object z) {
		return super.newBlockPos(x, y, z);
	}

	@Override
	protected Object newModelResourceLocation(String s, String s1) {
		return master != null ? master.newModelResourceLocation(s, s1) : super.newModelResourceLocation(s, s1);
	}

	public Object superNewModelResourceLocation(String s, String s1) {
		return super.newModelResourceLocation(s, s1);
	}

	@Override
	protected Object worldGetBlockState(Object worldOrEntity, Object blockPos) {
		return master != null ? master.worldGetBlockState(worldOrEntity, blockPos) : super.worldGetBlockState(worldOrEntity, blockPos);
	}

	public Object superWorldGetBlockState(Object worldOrEntity, Object blockPos) {
		return super.worldGetBlockState(worldOrEntity, blockPos);
	}

	@Override
	protected Object worldGetEntityByID(Object worldOrEntity, int i) {
		return master != null ? master.worldGetEntityByID(worldOrEntity, i) : super.worldGetEntityByID(worldOrEntity, i);
	}

	public Object superWorldGetEntityByID(Object worldOrEntity, int i) {
		return super.worldGetEntityByID(worldOrEntity, i);
	}

	@Override
	protected List modelRendererCubeList(Object modelRenderer) {
		return master != null ? master.modelRendererCubeList(modelRenderer) : null;
	}

	public List superModelRendererCubeList(Object modelRenderer) {
		return super.modelRendererCubeList(modelRenderer);
	}

	@Override
	protected void setModelRendererCubeList(Object modelRenderer, List list) {
		if (master != null) master.setModelRendererCubeList(modelRenderer, list);
	}

	public void superSetModelRendererCubeList(Object modelRenderer, List list) {
		super.setModelRendererCubeList(modelRenderer, list);
	}

	@Override
	protected List modelRendererChildModels(Object modelRenderer) {
		return master != null ? master.modelRendererChildModels(modelRenderer) : null;
	}

	public List superModelRendererChildModels(Object modelRenderer) {
		return super.modelRendererChildModels(modelRenderer);
	}

	@Override
	protected void setModelRendererChildModels(Object modelRenderer, List list) {
		if (master != null) master.setModelRendererChildModels(modelRenderer, list);
	}

	public void superSetModelRendererChildModels(Object modelRenderer, List list) {
		super.setModelRendererChildModels(modelRenderer, list);
	}

	@Override
	protected float modelRendererTextureWidth(Object modelRenderer) {
		return master != null ? master.modelRendererTextureWidth(modelRenderer) : 0.0F;
	}

	public float superModelRendererTextureWidth(Object modelRenderer) {
		return super.modelRendererTextureWidth(modelRenderer);
	}

	@Override
	protected void setModelRendererTextureWidth(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererTextureWidth(modelRenderer, f);
	}

	public void superSetModelRendererTextureWidth(Object modelRenderer, float f) {
		super.setModelRendererTextureWidth(modelRenderer, f);
	}

	@Override
	protected float modelRendererTextureHeight(Object modelRenderer) {
		return master != null ? master.modelRendererTextureHeight(modelRenderer) : 0.0F;
	}

	public float superModelRendererTextureHeight(Object modelRenderer) {
		return super.modelRendererTextureHeight(modelRenderer);
	}

	@Override
	protected void setModelRendererTextureHeight(Object modelRenderer, float f) {
		if (master != null) master.setModelRendererTextureHeight(modelRenderer, f);
	}

	public void superSetModelRendererTextureHeight(Object modelRenderer, float f) {
		super.setModelRendererTextureHeight(modelRenderer, f);
	}

	@Override
	protected boolean entityLivingBaseIsSwingInProgress(Object entityLivingBase) {
		return master != null ? master.entityLivingBaseIsSwingInProgress(entityLivingBase) : false;
	}

	public boolean superEntityLivingBaseIsSwingInProgress(Object entityLivingBase) {
		return super.entityLivingBaseIsSwingInProgress(entityLivingBase);
	}

	@Override
	protected void setEntityLivingBaseIsSwingInProgress(Object entityLivingBase, boolean b) {
		if (master != null) master.setEntityLivingBaseIsSwingInProgress(entityLivingBase, b);
	}

	public void superSetEntityLivingBaseIsSwingInProgress(Object entityLivingBase, boolean b) {
		super.setEntityLivingBaseIsSwingInProgress(entityLivingBase, b);
	}

	@Override
	public boolean entityIsBurning(Object entity) {
		return master != null ? master.entityIsBurning(entity) : false;
	}

	public boolean superEntityIsBurning(Object entity) {
		return super.entityIsBurning(entity);
	}

	@Override
	public boolean entityIsSprinting(Object entity) {
		return master != null ? master.entityIsSprinting(entity) : false;
	}

	public boolean superEntityIsSprinting(Object entity) {
		return super.entityIsSprinting(entity);
	}

	@Override
	public boolean entityLivingGetLeashed(Object entityLiving) {
		return master != null ? master.entityLivingGetLeashed(entityLiving) : false;
	}

	public boolean superEntityLivingGetLeashed(Object entity) {
		return super.entityLivingGetLeashed(entity);
	}

	@Override
	public String entityListGetEntityString(Object entity) {
		return master != null ? master.entityListGetEntityString(entity) : null;
	}

	public String superEntityListGetEntityString(Object entity) {
		return super.entityListGetEntityString(entity);
	}

	@Override
	public long worldInfoGetWorldTotalTime(Object entityOrWorldInfo) {
		return master != null ? master.worldInfoGetWorldTotalTime(entityOrWorldInfo) : null;
	}

	public long superWorldInfoGetWorldTotalTime(Object entityOrWorldInfo) {
		return super.worldInfoGetWorldTotalTime(entityOrWorldInfo);
	}

	@Override
	public long worldInfoGetWorldTime(Object entityOrWorldInfo) {
		return master != null ? master.worldInfoGetWorldTime(entityOrWorldInfo) : null;
	}

	public long superWorldInfoGetWorldTime(Object entityOrWorldInfo) {
		return super.worldInfoGetWorldTime(entityOrWorldInfo);
	}

	@Override
	public int worldGetMoonPhase(Object entityOrWorld) {
		return master != null ? master.worldGetMoonPhase(entityOrWorld) : null;
	}

	public int superWorldGetMoonPhase(Object entityOrWorld) {
		return super.worldGetMoonPhase(entityOrWorld);
	}

	@Override
	public void entityLivingSetCurrentItemOrArmor(Object entityLiving, Object entityEquipmentSlotOrInt, Object itemStack) {
		if (master != null) master.entityLivingSetCurrentItemOrArmor(entityLiving, entityEquipmentSlotOrInt, itemStack);
	}

	public void superEntityLivingSetCurrentItemOrArmor(Object entityLiving, Object entityEquipmentSlotOrInt, Object itemStack) {
		super.entityLivingSetCurrentItemOrArmor(entityLiving, entityEquipmentSlotOrInt, itemStack);
	}

	@Override
	public void entitySetVelocity(Object entity, double d, double d1, double d2) {
		if (master != null) master.entitySetVelocity(entity, d, d1, d2);
	}

	public void superEntitySetVelocity(Object entity, double d, double d1, double d2) {
		super.entitySetVelocity(entity, d, d1, d2);
	}

	@Override
	public void entitySetSneaking(Object entity, boolean b) {
		if (master != null) master.entitySetSneaking(entity, b);
	}

	public void superEntitySetSneaking(Object entity, boolean b) {
		super.entitySetSneaking(entity, b);
	}

	@Override
	public void openGlHelperSetLightmapTextureCoords(int i, float f, float f1) {
		if (master != null) master.openGlHelperSetLightmapTextureCoords(i, f, f1);
	}

	public void superOpenGlHelperSetLightmapTextureCoords(int i, float f, float f1) {
		super.openGlHelperSetLightmapTextureCoords(i, f, f1);
	}

	@Override
	public void entityTameableSetTamed(Object entityTameable, boolean b) {
		if (master != null) master.entityTameableSetTamed(entityTameable, b);
	}

	public void superEntityTameableSetTamed(Object entityTameable, boolean b) {
		super.entityTameableSetTamed(entityTameable, b);
	}

	@Override
	public void entityAgeableSetGrowingAge(Object entityTameable, int i) {
		if (master != null) master.entityAgeableSetGrowingAge(entityTameable, i);
	}

	public void superEntityAgeableSetGrowingAge(Object entityTameable, int i) {
		super.entityAgeableSetGrowingAge(entityTameable, i);
	}

	@Override
	public String chatAllowedCharactersFilterAllowedCharacters(String s) {
		return master != null ? master.chatAllowedCharactersFilterAllowedCharacters(s) : null;
	}

	public String superChatAllowedCharactersFilterAllowedCharacters(String s) {
		return super.chatAllowedCharactersFilterAllowedCharacters(s);
	}

	@Override
	public String itemGetUnlocalizedName(Object item) {
		return master != null ? master.itemGetUnlocalizedName(item) : null;
	}

	public String superItemGetUnlocalizedName(Object item) {
		return super.itemGetUnlocalizedName(item);
	}

	@Override
	public int entityLivingBaseAttackTime(Object entity) {
		return master != null ? master.entityLivingBaseAttackTime(entity) : null;
	}

	public int superEntityLivingBaseAttackTime(Object entity) {
		return super.entityLivingBaseAttackTime(entity);
	}

	@Override
	public void setEntityLivingBaseAttackTime(Object entityLivingBase, int i) {
		if (master != null) master.setEntityLivingBaseAttackTime(entityLivingBase, i);
	}

	public void superSetEntityLivingBaseAttackTime(Object entityLivingBase, int i) {
		super.setEntityLivingBaseAttackTime(entityLivingBase, i);
	}

	@Override
	public void setEntityPlayerCapabilitiesIsCreativeMode(Object entityplayer, boolean b) {
		if (master != null) master.setEntityPlayerCapabilitiesIsCreativeMode(entityplayer, b);
	}

	public void superSetEntityPlayerCapabilitiesIsCreativeMode(Object entityplayer, boolean b) {
		super.setEntityPlayerCapabilitiesIsCreativeMode(entityplayer, b);
	}

	@Override
	public void guiSlotHandleMouseInput(Object guiSlot) {
		if (master != null) master.guiSlotHandleMouseInput(guiSlot);
	}

	public void superGuiSlotHandleMouseInput(Object guiSlot) {
		super.guiSlotHandleMouseInput(guiSlot);
	}

	@Override
	public Object newDataParameter(Class c, Class[] c1, int i) {
		return master != null ? master.newDataParameter(c, c1, i) : null;
	}

	public Object superNewDataParameter(Class c, Class[] c1, int i) {
		return super.newDataParameter(c, c1, i);
	}

	@Override
	public Object newSoundEvent(Object resourceLocationOrString) {
		return master != null ? master.newSoundEvent(resourceLocationOrString) : null;
	}

	public Object superNewSoundEvent(Object resourceLocationOrString) {
		return super.newSoundEvent(resourceLocationOrString);
	}

	@Override
	public Object newResourceLocation(String s) {
		return master != null ? master.newResourceLocation(s) : null;
	}

	public Object superNewResourceLocation(String s) {
		return super.newResourceLocation(s);
	}

}
