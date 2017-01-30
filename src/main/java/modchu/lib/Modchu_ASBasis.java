package modchu.lib;

import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_ASBasis implements Modchu_IASMaster {
	public Modchu_AS base;

	public Modchu_ASBasis(HashMap<String, Object> map) {
		base = (Modchu_AS) map.get("Object");
	}

	@Override
	public float[] convertGlColor(int i) {
		return base.superConvertGlColor(i);
	}

	@Override
	public Object abstractClientPlayerGetTextureCape(Object entity) {
		return base.superAbstractClientPlayerGetTextureCape(entity);
	}

	@Override
	public Object abstractClientPlayerGetTextureSkin(Object entity) {
		return base.superAbstractClientPlayerGetTextureSkin(entity);
	}

	@Override
	public Object abstractClientPlayerLocationSkin(Object entity) {
		return base.superAbstractClientPlayerLocationSkin(entity);
	}

	@Override
	public void setAbstractClientPlayerLocationSkin(Object entity, Object o) {
		base.superSetAbstractClientPlayerLocationSkin(entity, o);
	}

	@Override
	public void abstractClientPlayerLocationCape(Object entity, Object o) {
		base.superAbstractClientPlayerLocationCape(entity, o);
	}

	@Override
	public String abstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return base.superAbstractClientPlayerGetSkinType(abstractClientPlayer);
	}

	@Override
	public void allModelInit(Object render, Object entity, boolean b) {
		base.superAllModelInit(render, entity, b);
	}

	@Override
	public double attributeModifierGetAmount(Object attributeModifier) {
		return base.superAttributeModifierGetAmount(attributeModifier);
	}

	@Override
	public Object getBipedArmor(Object entityPlayer, Object itemStack, int i, Object entityEquipmentSlotOrInt, String s) {
		return base.superGetBipedArmor(entityPlayer, itemStack, i, entityEquipmentSlotOrInt, s);
	}

	@Override
	public Object[] blockBlockList() {
		return base.superBlockBlockList();
	}

	@Override
	public Object blockGetBlockFromItem(Object item) {
		return base.superBlockGetBlockFromItem(item);
	}

	@Override
	public Object blockGetStateFromMeta(Object block, int i) {
		return base.superBlockGetStateFromMeta(block, i);
	}

	@Override
	public float blockPosGetX(Object blockPos) {
		return base.superBlockPosGetX(blockPos);
	}

	@Override
	public float blockPosGetY(Object blockPos) {
		return base.superBlockPosGetY(blockPos);
	}

	@Override
	public float blockPosGetZ(Object blockPos) {
		return base.superBlockPosGetZ(blockPos);
	}

	@Override
	public void blockSetLightOpacity(Object block, int lightOpacity) {
		base.superBlockSetLightOpacity(block, lightOpacity);
	}

	@Override
	public Object blockGetRenderType(Object block) {
		return base.superBlockGetRenderType(block);
	}

	@Override
	public int blockGetMetaFromState(Object block, Object iBlockState) {
		return base.superBlockGetMetaFromState(block, iBlockState);
	}

	@Override
	public int blockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return base.superBlockColorMultiplier(block, iBlockAccess, blockPos, i);
	}

	@Override
	public Object blockGetDefaultState(Object block) {
		return base.superBlockGetDefaultState(block);
	}

	@Override
	public void blockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
		base.superBlockModelRendererRenderModelBrightness(blockModelRenderer, iBakedModel, iBlockState, f, b);
	}

	@Override
	public void blockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
		base.superBlockRendererDispatcherRenderBlockBrightness(blockRendererDispatcher, iBlockState, f);
	}

	@Override
	public Object blockRendererDispatcherGetBakedModel(Object blockRendererDispatcher, Object iBlockState, Object blockPos) {
		return base.superBlockRendererDispatcherGetBakedModel(blockRendererDispatcher, iBlockState, blockPos);
	}

	@Override
	public Object blockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return base.superBlockRendererDispatcherGetBlockModelRenderer(blockRendererDispatcher);
	}

	@Override
	public Object blockDoublePlantVARIANT() {
		return base.superBlockDoublePlantVARIANT();
	}

	@Override
	public Object blockDoublePlantHALF() {
		return base.superBlockDoublePlantHALF();
	}

	@Override
	public Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return base.superAxisAlignedBBGetBoundingBox(d, d1, d2, d3, d4, d5);
	}

	@Override
	public Object axisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return base.superAxisAlignedBBExpand(axisAlignedBB, d, d1, d2);
	}

	@Override
	public Object axisAlignedBBCalculateIntercept(Object axisAlignedBB, Object vec3, Object vec3_2) {
		return base.superAxisAlignedBBCalculateIntercept(axisAlignedBB, vec3, vec3_2);
	}

	@Override
	public boolean axisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return base.superAxisAlignedBBIsVecInside(axisAlignedBB, vec3);
	}

	@Override
	public Object damageSourceAnvil() {
		return base.superDamageSourceAnvil();
	}

	@Override
	public Object damageSourceCactus() {
		return base.superDamageSourceCactus();
	}

	@Override
	public Object damageSourceDrown() {
		return base.superDamageSourceDrown();
	}

	@Override
	public Object damageSourceFall() {
		return base.superDamageSourceFall();
	}

	@Override
	public Object damageSourceFallingBlock() {
		return base.superDamageSourceFallingBlock();
	}

	@Override
	public Object damageSourceGeneric() {
		return base.superDamageSourceGeneric();
	}

	@Override
	public Object damageSourceInFire() {
		return base.superDamageSourceInFire();
	}

	@Override
	public Object damageSourceInWall() {
		return base.superDamageSourceInWall();
	}

	@Override
	public Object damageSourceLava() {
		return base.superDamageSourceLava();
	}

	@Override
	public Object damageSourceMagic() {
		return base.superDamageSourceMagic();
	}

	@Override
	public Object damageSourceOnFire() {
		return base.superDamageSourceOnFire();
	}

	@Override
	public Object damageSourceOutOfWorld() {
		return base.superDamageSourceOutOfWorld();
	}

	@Override
	public Object damageSourceStarve() {
		return base.superDamageSourceStarve();
	}

	@Override
	public Object damageSourceWither() {
		return base.superDamageSourceWither();
	}

	@Override
	public Object damageSourceGetEntity(Object damageSource) {
		return base.superDamageSourceGetEntity(damageSource);
	}

	@Override
	public boolean damageSourceIsFireDamage(Object damageSource) {
		return base.superDamageSourceIsFireDamage(damageSource);
	}

	@Override
	public Object damageSourceCauseMobDamage(Object entityLivingBase) {
		return base.superDamageSourceCauseMobDamage(entityLivingBase);
	}

	@Override
	public Object potionMoveSpeed() {
		return base.superPotionMoveSpeed();
	}

	@Override
	public Object potionMoveSlowdown() {
		return base.superPotionMoveSlowdown();
	}

	@Override
	public Object potionDigSpeed() {
		return base.superPotionDigSpeed();
	}

	@Override
	public Object potionDigSlowdown() {
		return base.superPotionDigSlowdown();
	}

	@Override
	public Object potionDamageBoost() {
		return base.superPotionDamageBoost();
	}

	@Override
	public Object potionHeal() {
		return base.superPotionHeal();
	}

	@Override
	public Object potionHarm() {
		return base.superPotionHarm();
	}

	@Override
	public Object potionJump() {
		return base.superPotionJump();
	}

	@Override
	public Object potionConfusion() {
		return base.superPotionConfusion();
	}

	@Override
	public Object potionRegeneration() {
		return base.superPotionRegeneration();
	}

	@Override
	public Object potionResistance() {
		return base.superPotionResistance();
	}

	@Override
	public Object potionFireResistance() {
		return base.superPotionFireResistance();
	}

	@Override
	public Object potionWaterBreathing() {
		return base.superPotionWaterBreathing();
	}

	@Override
	public Object potionInvisibility() {
		return base.superPotionInvisibility();
	}

	@Override
	public Object potionBlindness() {
		return base.superPotionBlindness();
	}

	@Override
	public Object potionNightVision() {
		return base.superPotionNightVision();
	}

	@Override
	public Object potionHunger() {
		return base.superPotionHunger();
	}

	@Override
	public Object potionWeakness() {
		return base.superPotionWeakness();
	}

	@Override
	public Object potionPoison() {
		return base.superPotionPoison();
	}

	@Override
	public Object potionWither() {
		return base.superPotionWither();
	}

	@Override
	public Object potionHealthBoost() {
		return base.superPotionHealthBoost();
	}

	@Override
	public Object potionAbsorption() {
		return base.superPotionAbsorption();
	}

	@Override
	public Object potionSaturation() {
		return base.superPotionSaturation();
	}

	@Override
	public Object entityLivingCurrentTarget() {
		return base.superEntityLivingCurrentTarget();
	}

	@Override
	public Object entityLivingCurrentTarget(Object entityLivingBase) {
		return base.superEntityLivingCurrentTarget(entityLivingBase);
	}

	@Override
	public Object entityAnimalInLove(Object entityLivingBase) {
		return base.superEntityAnimalInLove(entityLivingBase);
	}

	@Override
	public void setEntityAnimalInLove(Object entityLivingBase, int i) {
		base.superSetEntityAnimalInLove(entityLivingBase, i);
	}

	@Override
	public Object entityLivingBaseGetEquipmentInSlot(Object entityLivingBase, Object entityEquipmentSlotOrInt) {
		return base.superEntityLivingBaseGetEquipmentInSlot(entityLivingBase, entityEquipmentSlotOrInt);
	}

	@Override
	public Object entityArrowShootingEntity(Object entityArrow) {
		return base.superEntityArrowShootingEntity(entityArrow);
	}

	@Override
	public boolean entityAttackEntityFrom(Object entity, Object damageSource, float f) {
		return base.superEntityAttackEntityFrom(entity, damageSource, f);
	}

	@Override
	public int entityLivingBaseEntityAge(Object entity) {
		return base.superEntityLivingBaseEntityAge(entity);
	}

	@Override
	public Object entityLivingBaseGetLook(Object entityLivingBase, float f) {
		return base.superEntityLivingBaseGetLook(entityLivingBase, f);
	}

	@Override
	public void setEntityLivingBaseEntityAge(Object entity, int i) {
		base.superSetEntityLivingBaseEntityAge(entity, i);
	}

	@Override
	public Object entityBoundingBox(Object entity) {
		return base.superEntityBoundingBox(entity);
	}

	@Override
	public double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		return base.superEntityBoundingBoxMaxX(entityOrBoundingBox);
	}

	@Override
	public double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		return base.superEntityBoundingBoxMaxY(entityOrBoundingBox);
	}

	@Override
	public double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		return base.superEntityBoundingBoxMaxZ(entityOrBoundingBox);
	}

	@Override
	public double entityBoundingBoxMinX(Object entity) {
		return base.superEntityBoundingBoxMinX(entity);
	}

	@Override
	public double entityBoundingBoxMinY(Object entity) {
		return base.superEntityBoundingBoxMinY(entity);
	}

	@Override
	public double entityBoundingBoxMinZ(Object entity) {
		return base.superEntityBoundingBoxMinZ(entity);
	}

	@Override
	public String entityCloakUrl(Object entity) {
		return base.superEntityCloakUrl(entity);
	}

	@Override
	public int entityDimension(Object entity) {
		return base.superEntityDimension(entity);
	}

	@Override
	public void setEntityDimension(Object entity, int i) {
		base.superSetEntityDimension(entity, i);
	}

	@Override
	public float entityDistanceWalkedModified(Object entity) {
		return base.superEntityDistanceWalkedModified(entity);
	}

	@Override
	public int entityEntityID(Object entity) {
		return base.superEntityEntityID(entity);
	}

	@Override
	public float entityGetBrightness(Object entity, float f) {
		return base.superEntityGetBrightness(entity, f);
	}

	@Override
	public int entityGetBrightnessForRender(Object entity, float f) {
		return base.superEntityGetBrightnessForRender(entity, f);
	}

	@Override
	public Object entityGetDataWatcher(Object dataManagerOrEntity) {
		return base.superEntityGetDataWatcher(dataManagerOrEntity);
	}

	@Override
	public void entitySetCustomNameTag(Object entity, String s) {
		base.superEntitySetCustomNameTag(entity, s);
	}

	@Override
	public Object dataManagerGetWatchedObject(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return base.superDataWatcherGetWatchedObject(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	public void dataManagerAddObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		base.superDataWatcherAddObject(dataManagerOrEntity, dataParameterOrInt, o);
	}

	@Override
	public Object dataManagerGetWatchableObjectItemStack(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return base.superDataWatcherGetWatchableObjectItemStack(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	public String dataManagerGetWatchableObjectString(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return base.superDataWatcherGetWatchableObjectString(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	public byte dataManagerGetWatchableObjectByte(Object dataManagerOrEntity, Object dataParameterOrInt) {
		return base.superDataWatcherGetWatchableObjectByte(dataManagerOrEntity, dataParameterOrInt);
	}

	@Override
	public void dataManagerUpdateObject(Object dataManagerOrEntity, Object dataParameterOrInt, Object o) {
		base.superDataWatcherUpdateObject(dataManagerOrEntity, dataParameterOrInt, o);
	}

	@Override
	public void entityAITasksAddTask(Object entityAITasks, int i, Object entityAIBase) {
		base.superEntityAITasksAddTask(entityAITasks, i, entityAIBase);
	}

	@Override
	public float entityGetEyeHeight(Object entityplayer) {
		return base.superEntityGetEyeHeight(entityplayer);
	}

	@Override
	public float entityHeight(Object entity) {
		return base.superEntityHeight(entity);
	}

	@Override
	public boolean entityIsInvisible(Object entity) {
		return base.superEntityIsInvisible(entity);
	}

	@Override
	public boolean entityIsInWater(Object entity) {
		return base.superEntityIsInWater(entity);
	}

	@Override
	public boolean entityIsRiding(Object entity) {
		return base.superEntityIsRiding(entity);
	}

	@Override
	public boolean entityIsSneaking(Object entity) {
		return base.superEntityIsSneaking(entity);
	}

	@Override
	public boolean entityIsWet(Object entity) {
		return base.superEntityIsWet(entity);
	}

	@Override
	public void entityOnUpdate(Object entity) {
		base.superEntityOnUpdate(entity);
	}

	@Override
	public boolean entityStartRiding(Object entity) {
		return base.superEntityStartRiding(entity);
	}

	@Override
	public boolean entityStartRiding(Object entity, Object entity2) {
		return base.superEntityStartRiding(entity, entity2);
	}

	@Override
	public boolean entityStartRiding(Object entity, Object entity2, boolean b) {
		return base.superEntityStartRiding(entity, entity2, b);
	}

	@Override
	public Object entityLivingTasks(Object entityLiving) {
		return base.superEntityLivingTasks(entityLiving);
	}

	@Override
	public void entityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		base.superEntityLivingBaseSetPositionAndUpdate(entity, x, y, z);
	}

	@Override
	public Map entityListStringToClassMapping() {
		return base.superEntityListStringToClassMapping();
	}

	@Override
	public Map entityListClassToStringMapping() {
		return base.superEntityListClassToStringMapping();
	}

	@Override
	public Map entityListIDtoClassMapping() {
		return base.superEntityListIDtoClassMapping();
	}

	@Override
	public Map entityListClassToIDMapping() {
		return base.superEntityListClassToIDMapping();
	}

	@Override
	public void entitySetLocationAndAngles(Object entity, double x, double y, double z, float f, float f1) {
		base.superEntitySetLocationAndAngles(entity, x, y, z, f, f1);
	}

	@Override
	public void entitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		base.superEntitySetPositionAndRotation(entity, x, y, z, f, f1);
	}

	@Override
	public int entityAnimalBreeding(Object entityAnimal) {
		return base.superEntityAnimalBreeding(entityAnimal);
	}

	@Override
	public void setEntityAnimalBreeding(Object entityAnimal, int i) {
		base.superSetEntityAnimalBreeding(entityAnimal, i);
	}

	@Override
	public boolean entityCreatureHasAttacked(Object entity) {
		return base.superEntityCreatureHasAttacked(entity);
	}

	@Override
	public void setEntityCreatureHasAttacked(Object entity, boolean b) {
		base.superSetEntityCreatureHasAttacked(entity, b);
	}

	@Override
	public float entityGetDistanceToEntity(Object entity, Object entity2) {
		return base.superEntityGetDistanceToEntity(entity, entity2);
	}

	@Override
	public boolean entityIsEntityAlive(Object entity) {
		return base.superEntityIsEntityAlive(entity);
	}

	@Override
	public Object entityCreatureEntityToAttack(Object entity) {
		return base.superEntityCreatureEntityToAttack(entity);
	}

	@Override
	public int entityLivingNumTicksToChaseTarget(Object entityLiving) {
		return base.superEntityLivingNumTicksToChaseTarget(entityLiving);
	}

	@Override
	public void setEntityLivingNumTicksToChaseTarget(Object entityLiving, int i) {
		base.superSetEntityLivingNumTicksToChaseTarget(entityLiving, i);
	}

	@Override
	public Object entityCreatureGetEntityToAttack(Object entity) {
		return base.superEntityCreatureGetEntityToAttack(entity);
	}

	@Override
	public void setEntityCreatureEntityToAttack(Object entity, Object entity2) {
		base.superSetEntityCreatureEntityToAttack(entity, entity2);
	}

	@Override
	public void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
		base.superEntityClientPlayerMPFunc_142020_c(entityClientPlayerMP, s);
	}

	@Override
	public String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return base.superEntityClientPlayerMPFunc_142021_k(entityClientPlayerMP);
	}

	@Override
	public void entityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
		base.superEntityCreatureSetPathToEntity(entityCreature, entityPath);
	}

	@Override
	public float entityLivingBaseGetSoundVolume(Object entityLivingBase) {
		return base.superEntityLivingBaseGetSoundVolume(entityLivingBase);
	}

	@Override
	public float entityLivingBaseGetSoundPitch(Object entityLivingBase) {
		return base.superEntityLivingBaseGetSoundPitch(entityLivingBase);
	}

	@Override
	public float entityLastDamage(Object entityLivingBase) {
		return base.superEntityLastDamage(entityLivingBase);
	}

	@Override
	public int entityLivingBaseRecentlyHit(Object entityLivingBase) {
		return base.superEntityLivingBaseRecentlyHit(entityLivingBase);
	}

	@Override
	public void setEntityLivingBaseRecentlyHit(Object entityLivingBase, int i) {
		base.superSetEntityLivingBaseRecentlyHit(entityLivingBase, i);
	}

	@Override
	public int entityLivingBaseAttackingPlayer(Object entityLivingBase) {
		return base.superEntityLivingBaseAttackingPlayer(entityLivingBase);
	}

	@Override
	public void setEntityLivingBaseAttackingPlayer(Object entityLivingBase, Object entityLivingBase2) {
		base.superSetEntityLivingBaseAttackingPlayer(entityLivingBase, entityLivingBase2);
	}

	@Override
	public int entityLivingBaseDeathTime(Object entityLivingBase) {
		return base.superEntityLivingBaseDeathTime(entityLivingBase);
	}

	@Override
	public int entityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return base.superEntityLivingBaseMaxHurtResistantTime(entityLivingBase);
	}

	@Override
	public void setEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		base.superSetEntityLivingBaseMaxHurtResistantTime(entityLivingBase, i);
	}

	@Override
	public int entityHurtResistantTime(Object entity) {
		return base.superEntityHurtResistantTime(entity);
	}

	@Override
	public void setEntityHurtResistantTime(Object entity, int i) {
		base.superSetEntityHurtResistantTime(entity, i);
	}

	@Override
	public UUID entityGetUniqueID(Object entity) {
		return base.superEntityGetUniqueID(entity);
	}

	@Override
	public Object entityLivingBaseGetHeldItem(Object entityLivingBase) {
		return base.superEntityLivingBaseGetHeldItem(entityLivingBase);
	}

	@Override
	public Object entityLivingBaseGetHeldItem(Object entityLivingBase, Object enumHand) {
		return base.superEntityLivingBaseGetHeldItem(entityLivingBase, enumHand);
	}

	@Override
	public float entityLivingBaseGetHealth(Object entity) {
		return base.superEntityLivingBaseGetHealth(entity);
	}

	@Override
	public float entityLivingBaseGetMaxHealth(Object entity) {
		return base.superEntityLivingBaseGetMaxHealth(entity);
	}

	@Override
	public void entityLivingBaseDamageEntity(Object entity, Object damageSource, float f) {
		base.superEntityLivingBaseDamageEntity(entity, damageSource, f);
	}

	@Override
	public void entityLivingBaseHeal(Object entityLivingBase, float f) {
		base.superEntityLivingBaseHeal(entityLivingBase, f);
	}

	@Override
	public void entityLivingBaseSetRevengeTarget(Object entity, Object entity2) {
		base.superEntityLivingBaseSetRevengeTarget(entity, entity2);
	}

	@Override
	public float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return base.superEntityLivingBaseGetSwingProgress(entity, f);
	}

	@Override
	public float entityLivingBaseHealth(Object entity) {
		return base.superEntityLivingBaseHealth(entity);
	}

	@Override
	public boolean entityLivingBaseIsJumping(Object entity) {
		return base.superEntityLivingBaseIsJumping(entity);
	}

	@Override
	public float entityLivingBaseLimbSwing(Object entity) {
		return base.superEntityLivingBaseLimbSwing(entity);
	}

	@Override
	public void setEntityLivingBaseLimbSwing(Object entity, float f) {
		base.superSetEntityLivingBaseLimbSwing(entity, f);
	}

	@Override
	public float entityLivingBaseLimbSwingAmount(Object entity) {
		return base.superEntityLivingBaseLimbSwingAmount(entity);
	}

	@Override
	public void setEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		base.superSetEntityLivingBaseLimbSwingAmount(entity, f);
	}

	@Override
	public float entityLivingBaseMoveForward(Object entityplayer) {
		return base.superEntityLivingBaseMoveForward(entityplayer);
	}

	@Override
	public void setEntityLivingBaseMoveForward(Object entityplayer, float f) {
		base.superSetEntityLivingBaseMoveForward(entityplayer, f);
	}

	@Override
	public float entityLivingBaseMoveStrafing(Object entityplayer) {
		return base.superEntityLivingBaseMoveStrafing(entityplayer);
	}

	@Override
	public void setEntityLivingBaseMoveStrafing(Object entityplayer, float f) {
		base.superSetEntityLivingBaseMoveStrafing(entityplayer, f);
	}

	@Override
	public float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return base.superEntityLivingBasePrevLimbSwingAmount(entity);
	}

	@Override
	public void setEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		base.superSetEntityLivingBasePrevLimbSwingAmount(entity, f);
	}

	@Override
	public float entityLivingBasePrevRenderYawOffset(Object entity) {
		return base.superEntityLivingBasePrevRenderYawOffset(entity);
	}

	@Override
	public void setEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		base.superSetEntityLivingBasePrevRenderYawOffset(entity, f);
	}

	@Override
	public float entityLivingBasePrevRotationYawHead(Object entity) {
		return base.superEntityLivingBasePrevRotationYawHead(entity);
	}

	@Override
	public void setEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		base.superSetEntityLivingBasePrevRotationYawHead(entity, f);
	}

	@Override
	public float entityLivingBaseRenderYawOffset(Object entity) {
		return base.superEntityLivingBaseRenderYawOffset(entity);
	}

	@Override
	public void setEntityLivingBaseRenderYawOffset(Object entity, float f) {
		base.superSetEntityLivingBaseRenderYawOffset(entity, f);
	}

	@Override
	public float entityLivingBaseRotationYawHead(Object entity) {
		return base.superEntityLivingBaseRotationYawHead(entity);
	}

	@Override
	public void setEntityLivingBaseRotationYawHead(Object entity, float f) {
		base.superSetEntityLivingBaseRotationYawHead(entity, f);
	}

	@Override
	public void entityLivingBaseSetHealth(Object entity, float f) {
		base.superEntityLivingBaseSetHealth(entity, f);
	}

	@Override
	public int entityLivingGetHealth(Object entity) {
		return base.superEntityLivingGetHealth(entity);
	}

	@Override
	public int entityLivingGetMaxHealth(Object entity) {
		return base.superEntityLivingGetMaxHealth(entity);
	}

	@Override
	public Object entityTameableAiSit(Object entityTameable) {
		return base.superEntityTameableAiSit(entityTameable);
	}

	@Override
	public String entityTameableGetOwnerName(Object entityTameable) {
		return base.superEntityTameableGetOwnerName(entityTameable);
	}

	@Override
	public void entityTameableSetOwner(Object entityTameable) {
		base.superEntityTameableSetOwner(entityTameable);
	}

	@Override
	public void entityTameableSetOwner(Object entityTameable, Object uUIDOrString) {
		base.superEntityTameableSetOwner(entityTameable, uUIDOrString);
	}

	@Override
	public void entityLivingSetHealth(Object entity, int i) {
		base.superEntityLivingSetHealth(entity, i);
	}

	@Override
	public double entityMotionX(Object entity) {
		return base.superEntityMotionX(entity);
	}

	@Override
	public double entityMotionY(Object entity) {
		return base.superEntityMotionY(entity);
	}

	@Override
	public double entityMotionZ(Object entity) {
		return base.superEntityMotionZ(entity);
	}

	@Override
	public Object entityPlayerArmorInventory(Object entityplayerORInventory) {
		return base.superEntityPlayerArmorInventory(entityplayerORInventory);
	}

	@Override
	public float entityPlayerCameraYaw(Object entity) {
		return base.superEntityPlayerCameraYaw(entity);
	}

	@Override
	public float entityPlayerCurrentXP(Object entityplayer) {
		return base.superEntityPlayerCurrentXP(entityplayer);
	}

	@Override
	public double entityPlayerChasingPosZ(Object entityplayer) {
		return base.superEntityPlayerChasingPosZ(entityplayer);
	}

	@Override
	public double entityPlayerPrevChasingPosX(Object entityplayer) {
		return base.superEntityPlayerPrevChasingPosX(entityplayer);
	}

	@Override
	public double entityPlayerChasingPosX(Object entityplayer) {
		return base.superEntityPlayerChasingPosX(entityplayer);
	}

	@Override
	public double entityPlayerChasingPosY(Object entityplayer) {
		return base.superEntityPlayerChasingPosY(entityplayer);
	}

	@Override
	public double entityPlayerPrevChasingPosY(Object entityplayer) {
		return base.superEntityPlayerPrevChasingPosY(entityplayer);
	}

	@Override
	public double entityPlayerPrevChasingPosZ(Object entityplayer) {
		return base.superEntityPlayerPrevChasingPosZ(entityplayer);
	}

	@Override
	public Object entityPlayerFoodStats(Object entityplayer) {
		return base.superEntityPlayerFoodStats(entityplayer);
	}

	@Override
	public Object entityplayerGetCurrentEquippedItem(Object entityplayer) {
		return base.superEntityplayerGetCurrentEquippedItem(entityplayer);
	}

	@Override
	public Object entityPlayerGetFoodStats(Object entityplayer) {
		return base.superEntityPlayerGetFoodStats(entityplayer);
	}

	@Override
	public boolean entityPlayerGetHideCape(Object entityplayer) {
		return base.superEntityPlayerGetHideCape(entityplayer);
	}

	@Override
	public int entityPlayerGetItemInUseCount(Object entityplayer) {
		return base.superEntityPlayerGetItemInUseCount(entityplayer);
	}

	@Override
	public Object entityPlayerInventory(Object entityplayer) {
		return base.superEntityPlayerInventory(entityplayer);
	}

	@Override
	public Object entityPlayerInventoryGetCurrentItem(Object entityplayer) {
		return base.superEntityPlayerInventoryGetCurrentItem(entityplayer);
	}

	@Override
	public int entityPlayerInventoryCurrentItem(Object entityplayer) {
		return base.superEntityPlayerInventoryCurrentItem(entityplayer);
	}

	@Override
	public Object entityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return base.superEntityPlayerInventoryGetStackInSlot(entityplayer, i);
	}

	@Override
	public Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		return base.superEntityPlayerInventoryPlayerArmorItemInSlot(entityplayerORInventory, i);
	}

	@Override
	public void entityPlayerInventorySetInventorySlotContents(Object entityplayer, int i, Object itemstack) {
		base.superEntityPlayerInventorySetInventorySlotContents(entityplayer, i, itemstack);
	}

	@Override
	public boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return base.superEntityPlayerIsPlayerSleeping(entityplayer);
	}

	@Override
	public boolean entityPlayerCapabilitiesIsCreativeMode(Object entityplayer) {
		return base.superEntityPlayerCapabilitiesIsCreativeMode(entityplayer);
	}

	@Override
	public Object entityPlayerMainInventory(Object entityplayerORInventory) {
		return base.superEntityPlayerMainInventory(entityplayerORInventory);
	}

	@Override
	public void entityPlayerPreparePlayerToSpawn(Object entityplayer) {
		base.superEntityPlayerPreparePlayerToSpawn(entityplayer);
	}

	@Override
	public Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return base.superEntityClientPlayerMPSendQueue(entityClientPlayerMP);
	}

	@Override
	public void entityLivingBaseSwingItem(Object entityLivingBase) {
		base.superEntityLivingBaseSwingItem(entityLivingBase);
	}

	@Override
	public void entityLivingBaseSwingItem(Object entityLivingBase, Object enumHand) {
		base.superEntityLivingBaseSwingItem(entityLivingBase, enumHand);
	}

	@Override
	public int entityPlayerPlayerLevel(Object entityplayer) {
		return base.superEntityPlayerPlayerLevel(entityplayer);
	}

	@Override
	public float entityPlayerPrevCameraYaw(Object entity) {
		return base.superEntityPlayerPrevCameraYaw(entity);
	}

	@Override
	public int entityPlayerScore(Object entityplayer) {
		return base.superEntityPlayerScore(entityplayer);
	}

	@Override
	public void entityPlayerSPFunc_6420_o(Object entityplayer) {
		base.superEntityPlayerSPFunc_6420_o(entityplayer);
	}

	@Override
	public int entityPlayerTotalXP(Object entityplayer) {
		return base.superEntityPlayerTotalXP(entityplayer);
	}

	@Override
	public void entityPlayerSetItemInUse(Object entityplayer, Object itemstack, int i) {
		base.superEntityPlayerSetItemInUse(entityplayer, itemstack, i);
	}

	@Override
	public void entityPlayerDestroyCurrentEquippedItem(Object entityplayer) {
		base.superEntityPlayerDestroyCurrentEquippedItem(entityplayer);
	}

	@Override
	public boolean entityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		return base.superEntityPlayerCanPlayerEdit(entityplayer, x, y, z, i, itemStack);
	}

	@Override
	public Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return base.superEntityPlayerMPPlayerNetServerHandler(entityplayerMP);
	}

	@Override
	public void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netServerHandler) {
		base.superSetEntityPlayerMPPlayerNetServerHandler(entityplayerMP, netServerHandler);
	}

	@Override
	public Object entityPlayerFishEntity(Object entityplayer) {
		return base.superEntityPlayerFishEntity(entityplayer);
	}

	@Override
	public void setEntityPlayerFishEntity(Object entityplayer, Object entityFishHook) {
		base.superSetEntityPlayerFishEntity(entityplayer, entityFishHook);
	}

	@Override
	public boolean entityZombieIsVillager(Object entityZombie) {
		return base.superEntityZombieIsVillager(entityZombie);
	}

	@Override
	public void entityZombieSetVillager(Object entityZombie, boolean b) {
		base.superEntityZombieSetVillager(entityZombie, b);
	}

	@Override
	public double entityPosX(Object entity) {
		return base.superEntityPosX(entity);
	}

	@Override
	public double entityPosY(Object entity) {
		return base.superEntityPosY(entity);
	}

	@Override
	public double entityPosZ(Object entity) {
		return base.superEntityPosZ(entity);
	}

	@Override
	public float entityPrevDistanceWalkedModified(Object entity) {
		return base.superEntityPrevDistanceWalkedModified(entity);
	}

	@Override
	public double entityPrevPosX(Object entity) {
		return base.superEntityPrevPosX(entity);
	}

	@Override
	public double entityPrevPosY(Object entity) {
		return base.superEntityPrevPosY(entity);
	}

	@Override
	public double entityPrevPosZ(Object entity) {
		return base.superEntityPrevPosZ(entity);
	}

	@Override
	public float entityPrevRotationPitch(Object entity) {
		return base.superEntityPrevRotationPitch(entity);
	}

	@Override
	public void setEntityPrevRotationPitch(Object entity, float f) {
		base.superSetEntityPrevRotationPitch(entity, f);
	}

	@Override
	public float entityPrevRotationYaw(Object entity) {
		return base.superEntityPrevRotationYaw(entity);
	}

	@Override
	public void setEntityPrevRotationYaw(Object entity, float f) {
		base.superSetEntityPrevRotationYaw(entity, f);
	}

	@Override
	public Object entityRidingEntity(Object entity) {
		return base.superEntityRidingEntity(entity);
	}

	@Override
	public Object entityGetCollisionBoundingBox(Object entity) {
		return base.superEntityGetCollisionBoundingBox(entity);
	}

	@Override
	public boolean entityCanBeCollidedWith(Object entity) {
		return base.superEntityCanBeCollidedWith(entity);
	}

	@Override
	public float entityGetCollisionBorderSize(Object entity) {
		return base.superEntityGetCollisionBorderSize(entity);
	}

	@Override
	public void setEntityRidingEntity(Object entity, Object entity2) {
		base.superSetEntityRidingEntity(entity, entity2);
	}

	@Override
	public Object entityRiddenByEntity(Object entity) {
		return base.superEntityRiddenByEntity(entity);
	}

	@Override
	public void setEntityRiddenByEntity(Object entity, Object entity2) {
		base.superSetEntityRiddenByEntity(entity, entity2);
	}

	@Override
	public boolean entityIsDead(Object entity) {
		return base.superEntityIsDead(entity);
	}

	@Override
	public boolean entityTameableIsTamed(Object entityTameable) {
		return base.superEntityTameableIsTamed(entityTameable);
	}

	@Override
	public boolean entityHorseIsTame(Object entityHorse) {
		return base.superEntityHorseIsTame(entityHorse);
	}

	@Override
	public boolean isTamed(Object entity) {
		return base.superIsTamed(entity);
	}

	@Override
	public void setEntityIsDead(Object entity, boolean b) {
		base.superSetEntityIsDead(entity, b);
	}

	@Override
	public float entityRotationPitch(Object entity) {
		return base.superEntityRotationPitch(entity);
	}

	@Override
	public void setEntityRotationPitch(Object entity, float f) {
		base.superSetEntityRotationPitch(entity, f);
	}

	@Override
	public float entityRotationYaw(Object entity) {
		return base.superEntityRotationYaw(entity);
	}

	@Override
	public void setEntityRotationYaw(Object entity, float f) {
		base.superSetEntityRotationYaw(entity, f);
	}

	@Override
	public void entitySetDead(Object entity) {
		base.superEntitySetDead(entity);
	}

	@Override
	public void entitySetFire(Object entity, int i) {
		base.superEntitySetFire(entity, i);
	}

	@Override
	public void entitySetPosition(Object entity, double x, double y, double z) {
		base.superEntitySetPosition(entity, x, y, z);
	}

	@Override
	public void entitySetSize(Object entity, float f1, float f2) {
		base.superEntitySetSize(entity, f1, f2);
	}

	@Override
	public void entityPlaySound(Object entity, Object soundEventOrString, float f1, float f2) {
		base.superEntityPlaySound(entity, soundEventOrString, f1, f2);
	}

	@Override
	public int entityTicksExisted(Object entity) {
		return base.superEntityTicksExisted(entity);
	}

	@Override
	public void setEntityTicksExisted(Object entity, int i) {
		base.superSetEntityTicksExisted(entity, i);
	}

	@Override
	public Object entityLivingGetNavigator(Object entityLivingOrPathNavigate) {
		return base.superEntityLivingGetNavigator(entityLivingOrPathNavigate);
	}

	@Override
	public void entityLivingNavigatorClearPathEntity(Object entityLivingOrPathNavigate) {
		base.superEntityLivingNavigatorClearPathEntity(entityLivingOrPathNavigate);
	}

	@Override
	public Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return base.superEntityLivingGetCurrentArmor(entityLiving, i);
	}

	@Override
	public boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		return base.superEntityLivingBaseIsPotionActive(entityLivingBase, potionOrPotionId);
	}

	@Override
	public boolean entityOnGround(Object entity) {
		return base.superEntityOnGround(entity);
	}

	@Override
	public void entityLivingBaseSetBeenAttacked(Object entityLivingBase) {
		base.superEntityLivingBaseSetBeenAttacked(entityLivingBase);
	}

	@Override
	public void entityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		base.superEntityLivingBaseOnDeath(entityLivingBase, damageSource);
	}

	@Override
	public int entityAgeableGetGrowingAge(Object entityLivingBase) {
		return base.superEntityAgeableGetGrowingAge(entityLivingBase);
	}

	@Override
	public int entityLivingBaseHurtTime(Object entityLivingBase) {
		return base.superEntityLivingBaseHurtTime(entityLivingBase);
	}

	@Override
	public void setEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		base.superSetEntityLivingBaseHurtTime(entityLivingBase, i);
	}

	@Override
	public int entityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return base.superEntityLivingBaseMaxHurtTime(entityLivingBase);
	}

	@Override
	public void setEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		base.superSetEntityLivingBaseMaxHurtTime(entityLivingBase, i);
	}

	@Override
	public float entityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return base.superEntityLivingBaseAttackedAtYaw(entityLivingBase);
	}

	@Override
	public void setEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		base.superSetEntityLivingBaseAttackedAtYaw(entityLivingBase, f);
	}

	@Override
	public float entityLivingBasePrevHealth(Object entityLivingBase) {
		return base.superEntityLivingBasePrevHealth(entityLivingBase);
	}

	@Override
	public void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
		base.superSetEntityLivingBasePrevHealth(entityLivingBase, f);
	}

	@Override
	public boolean entityLivingBaseIsChild(Object entityLivingBase) {
		return base.superEntityLivingBaseIsChild(entityLivingBase);
	}

	@Override
	public void entityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		base.superEntityLivingBaseKnockBack(entityLivingBase, entityLivingBase2, f, d, d1);
	}

	@Override
	public Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return base.superEntityLivingBaseGetAITarget(entityLivingBase);
	}

	@Override
	public void entityBatSetIsBatHanging(Object entityBat, boolean b) {
		base.superEntityBatSetIsBatHanging(entityBat, b);
	}

	@Override
	public void entitySetEating(Object entity, boolean b) {
		base.superEntitySetEating(entity, b);
	}

	@Override
	public float entityWidth(Object entity) {
		return base.superEntityWidth(entity);
	}

	@Override
	public Object entityWorld(Object worldOrEntity) {
		return base.superEntityWorld(worldOrEntity);
	}

	@Override
	public float entityYOffset(Object entity) {
		return base.superEntityYOffset(entity);
	}

	@Override
	public Enum enumActionBlock() {
		return base.superEnumActionBlock();
	}

	@Override
	public Enum enumActionBow() {
		return base.superEnumActionBow();
	}

	@Override
	public Enum enumActionDrink() {
		return base.superEnumActionDrink();
	}

	@Override
	public Enum enumActionEat() {
		return base.superEnumActionEat();
	}

	@Override
	public Enum enumActionNone() {
		return base.superEnumActionNone();
	}

	@Override
	public Enum enumCreatureAttributeARTHROPOD() {
		return base.superEnumCreatureAttributeARTHROPOD();
	}

	@Override
	public Enum enumCreatureAttributeUNDEAD() {
		return base.superEnumCreatureAttributeUNDEAD();
	}

	@Override
	public Enum enumCreatureAttributeUNDEFINED() {
		return base.superEnumCreatureAttributeUNDEFINED();
	}

	@Override
	public Enum enumCreatureTypeMonster() {
		return base.superEnumCreatureTypeMonster();
	}

	@Override
	public Enum enumCreatureTypeCreature() {
		return base.superEnumCreatureTypeCreature();
	}

	@Override
	public Enum enumCreatureTypeAmbient() {
		return base.superEnumCreatureTypeAmbient();
	}

	@Override
	public Enum enumCreatureTypeWaterCreature() {
		return base.superEnumCreatureTypeWaterCreature();
	}

	@Override
	public Enum enumFacingUP() {
		return base.superEnumFacingUP();
	}

	@Override
	public Enum enumFacingDOWN() {
		return base.superEnumFacingDOWN();
	}

	@Override
	public Enum enumFacingEAST() {
		return base.superEnumFacingEAST();
	}

	@Override
	public Enum enumFacingNORTH() {
		return base.superEnumFacingNORTH();
	}

	@Override
	public Enum enumFacingSOUTH() {
		return base.superEnumFacingSOUTH();
	}

	@Override
	public Enum enumFacingWEST() {
		return base.superEnumFacingWEST();
	}

	@Override
	public boolean gameSettingsAnaglyph(Object gameSettings) {
		return base.superGameSettingsAnaglyph(gameSettings);
	}

	@Override
	public Object biomeOcean() {
		return base.superBiomeOcean();
	}

	@Override
	public Object biomePlains() {
		return base.superBiomePlains();
	}

	@Override
	public Object biomeDesert() {
		return base.superBiomeDesert();
	}

	@Override
	public Object biomeExtremeHills() {
		return base.superBiomeExtremeHills();
	}

	@Override
	public Object biomeForest() {
		return base.superBiomeForest();
	}

	@Override
	public Object biomeTaiga() {
		return base.superBiomeTaiga();
	}

	@Override
	public Object biomeSwampland() {
		return base.superBiomeSwampland();
	}

	@Override
	public Object biomeRiver() {
		return base.superBiomeRiver();
	}

	@Override
	public Object biomeHell() {
		return base.superBiomeHell();
	}

	@Override
	public Object biomeSky() {
		return base.superBiomeSky();
	}

	@Override
	public Object biomeFrozenOcean() {
		return base.superBiomeFrozenOcean();
	}

	@Override
	public Object biomeFrozenRiver() {
		return base.superBiomeFrozenRiver();
	}

	@Override
	public Object biomeIcePlains() {
		return base.superBiomeIcePlains();
	}

	@Override
	public Object biomeIceMountains() {
		return base.superBiomeIceMountains();
	}

	@Override
	public Object biomeMushroomIsland() {
		return base.superBiomeMushroomIsland();
	}

	@Override
	public Object biomeMushroomIslandShore() {
		return base.superBiomeMushroomIslandShore();
	}

	@Override
	public Object biomeBeach() {
		return base.superBiomeBeach();
	}

	@Override
	public Object biomeDesertHills() {
		return base.superBiomeDesertHills();
	}

	@Override
	public Object biomeForestHills() {
		return base.superBiomeForestHills();
	}

	@Override
	public Object biomeTaigaHills() {
		return base.superBiomeTaigaHills();
	}

	@Override
	public Object biomeExtremeHillsEdge() {
		return base.superBiomeExtremeHillsEdge();
	}

	@Override
	public Object biomeJungle() {
		return base.superBiomeJungle();
	}

	@Override
	public Object biomeJungleHills() {
		return base.superBiomeJungleHills();
	}

	@Override
	public Object biomeJungleEdge() {
		return base.superBiomeJungleEdge();
	}

	@Override
	public Object biomeDeepOcean() {
		return base.superBiomeDeepOcean();
	}

	@Override
	public Object biomeStoneBeach() {
		return base.superBiomeStoneBeach();
	}

	@Override
	public Object biomeStoneColdBeach() {
		return base.superBiomeStoneColdBeach();
	}

	@Override
	public Object biomeBirchForest() {
		return base.superBiomeBirchForest();
	}

	@Override
	public Object biomeBirchForestHills() {
		return base.superBiomeBirchForestHills();
	}

	@Override
	public Object biomeRoofedForest() {
		return base.superBiomeRoofedForest();
	}

	@Override
	public Object biomeColdTaiga() {
		return base.superBiomeColdTaiga();
	}

	@Override
	public Object biomeColdTaigaHills() {
		return base.superBiomeColdTaigaHills();
	}

	@Override
	public Object biomeMegaTaiga() {
		return base.superBiomeMegaTaiga();
	}

	@Override
	public Object biomeMegaTaigaHills() {
		return base.superBiomeMegaTaigaHills();
	}

	@Override
	public Object biomeExtremeHillsPlus() {
		return base.superBiomeExtremeHillsPlus();
	}

	@Override
	public Object biomeSavanna() {
		return base.superBiomeSavanna();
	}

	@Override
	public Object biomeSavannaPlateau() {
		return base.superBiomeSavannaPlateau();
	}

	@Override
	public Object biomeMesa() {
		return base.superBiomeMesa();
	}

	@Override
	public Object biomeMesaPlateau_F() {
		return base.superBiomeMesaPlateau_F();
	}

	@Override
	public Object biomeMesaPlateau() {
		return base.superBiomeMesaPlateau();
	}

	@Override
	public Object creativeTabsTabBlock() {
		return base.superCreativeTabsTabBlock();
	}

	@Override
	public Object creativeTabsTabDecorations() {
		return base.superCreativeTabsTabDecorations();
	}

	@Override
	public Object creativeTabsTabRedstone() {
		return base.superCreativeTabsTabRedstone();
	}

	@Override
	public Object creativeTabsTabTransport() {
		return base.superCreativeTabsTabTransport();
	}

	@Override
	public Object creativeTabsTabMisc() {
		return base.superCreativeTabsTabMisc();
	}

	@Override
	public Object creativeTabsTabAllSearch() {
		return base.superCreativeTabsTabAllSearch();
	}

	@Override
	public Object creativeTabsTabFood() {
		return base.superCreativeTabsTabFood();
	}

	@Override
	public Object creativeTabsTabTools() {
		return base.superCreativeTabsTabTools();
	}

	@Override
	public Object creativeTabsTabCombat() {
		return base.superCreativeTabsTabCombat();
	}

	@Override
	public Object creativeTabsTabBrewing() {
		return base.superCreativeTabsTabBrewing();
	}

	@Override
	public Object creativeTabsTabMaterials() {
		return base.superCreativeTabsTabMaterials();
	}

	@Override
	public Object creativeTabsTabInventory() {
		return base.superCreativeTabsTabInventory();
	}

	@Override
	public Object containerInventorySlots(Object container) {
		return base.superContainerInventorySlots(container);
	}

	@Override
	public Object containerInventoryItemStacks(Object container) {
		return base.superContainerInventoryItemStacks(container);
	}

	@Override
	public Object containerGetSlot(Object container, int i) {
		return base.superContainerGetSlot(container, i);
	}

	@Override
	public Object FMLCommonHandlerInstance() {
		return base.superFMLCommonHandlerInstance();
	}

	@Override
	public Object FMLCommonHandlerInstanceGetMinecraftServerInstance() {
		return base.superFMLCommonHandlerInstanceGetMinecraftServerInstance();
	}

	@Override
	public Object[] FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() {
		return base.superFMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers();
	}

	@Override
	public void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		base.superFontRendererDrawString(fontRenderer, s, i, j, k);
	}

	@Override
	public int[] facingOffsetsXForSide() {
		return base.superFacingOffsetsXForSide();
	}

	@Override
	public int[] facingOffsetsYForSide() {
		return base.superFacingOffsetsYForSide();
	}

	@Override
	public int[] facingOffsetsZForSide() {
		return base.superFacingOffsetsZForSide();
	}

	@Override
	public String gameSettingsGetKeyDisplayString(int i) {
		return base.superGameSettingsGetKeyDisplayString(i);
	}

	@Override
	public Object gameSettingsKeyBindBack() {
		return base.superGameSettingsKeyBindBack();
	}

	@Override
	public Object gameSettingsKeyBindForward() {
		return base.superGameSettingsKeyBindForward();
	}

	@Override
	public Object gameSettingsKeyBindLeft() {
		return base.superGameSettingsKeyBindLeft();
	}

	@Override
	public Object gameSettingsKeyBindRight() {
		return base.superGameSettingsKeyBindRight();
	}

	@Override
	public Object getBlock(Object itemStackOrItemOrBlock) {
		return base.superGetBlock(itemStackOrItemOrBlock);
	}

	@Override
	public Object getBlockItemStack(Object itemstack) {
		return base.superGetBlockItemStack(itemstack);
	}

	@Override
	public Object getItem(String s) {
		return base.superGetItem(s);
	}

	@Override
	public Object getBlock(String s) {
		return base.superGetBlock(s);
	}

	@Override
	public Object getResource(Class c, String s) {
		return base.superGetResource(c, s);
	}

	@Override
	public Object getResource(String s) {
		return base.superGetResource(s);
	}

	@Override
	public String getUserName(Object entityplayer) {
		return base.superGetUserName(entityplayer);
	}

	@Override
	public int getVacancyGlobalEntityID() {
		return base.superGetVacancyGlobalEntityID();
	}

	@Override
	public IntBuffer gLAllocationCreateDirectIntBuffer(int i) {
		return base.superGLAllocationCreateDirectIntBuffer(i);
	}

	@Override
	public int gLAllocationGenerateDisplayLists(int i) {
		return base.superGLAllocationGenerateDisplayLists(i);
	}

	@Override
	public boolean guiButtonEnabled(Object guiButton) {
		return base.superGuiButtonEnabled(guiButton);
	}

	@Override
	public int guiButtonHeight(Object guiButton) {
		return base.superGuiButtonHeight(guiButton);
	}

	@Override
	public int guiButtonID(Object guiButton) {
		return base.superGuiButtonID(guiButton);
	}

	@Override
	public boolean guiButtonVisible(Object guiButton) {
		return base.superGuiButtonVisible(guiButton);
	}

	@Override
	public int guiButtonWidth(Object guiButton) {
		return base.superGuiButtonWidth(guiButton);
	}

	@Override
	public int guiButtonXPosition(Object guiButton) {
		return base.superGuiButtonXPosition(guiButton);
	}

	@Override
	public int guiButtonYPosition(Object guiButton) {
		return base.superGuiButtonYPosition(guiButton);
	}

	@Override
	public void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		base.superGuiDrawCenteredString(gui, fontRenderer, s, i, i2, i3);
	}

	@Override
	public void guiIngameDrawString(String s, int i, int j, int k) {
		base.superGuiIngameDrawString(s, i, j, k);
	}

	@Override
	public Object guiOptionsBackground() {
		return base.superGuiOptionsBackground();
	}

	@Override
	public void guiScreenActionPerformed(Object guiScreen, Object guiButton) {
		base.superGuiScreenActionPerformed(guiScreen, guiButton);
	}

	@Override
	public List guiScreenButtonList(Object guiScreen) {
		return base.superGuiScreenButtonList(guiScreen);
	}

	@Override
	public void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		base.superGuiScreenDrawScreen(guiScreen, i, i2, f);
	}

	@Override
	public Object guiScreenFontRenderer(Object guiScreen) {
		return base.superGuiScreenFontRenderer(guiScreen);
	}

	@Override
	public int guiScreenHeight(Object guiScreen) {
		return base.superGuiScreenHeight(guiScreen);
	}

	@Override
	public int guiScreenWidth(Object guiScreen) {
		return base.superGuiScreenWidth(guiScreen);
	}

	@Override
	public void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		base.superGuiSlotActionPerformed(guiSlot, guiButton);
	}

	@Override
	public void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		base.superGuiSlotDrawScreen(guiSlot, i, i2, f);
	}

	@Override
	public void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		base.superGuiSlotRegisterScrollButtons(guiSlot, list, i, i2);
	}

	@Override
	public void guiScreenFunc_175273_b(Object guiScreen, int i, int i1) {
		base.superGuiScreenFunc_175273_b(guiScreen, i, i1);
	}

	@Override
	public void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
		base.superGuiScreenFunc_175273_b(guiScreen, minecraft, i, i2);
	}

	@Override
	public Object iBlockStateGetBlock(Object iBlockState) {
		return base.superIBlockStateGetBlock(iBlockState);
	}

	@Override
	public Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return base.superInventoryPlayerArmorItemInSlot(inventory, i);
	}

	@Override
	public Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return base.superInventoryPlayerGetStackInSlot(inventory, i);
	}

	@Override
	public boolean isCamouflage(Object itemStackOrItemOrBlock) {
		return base.superIsCamouflage(itemStackOrItemOrBlock);
	}

	@Override
	public boolean isCamouflageCheck(Object block) {
		return base.superIsCamouflageCheck(block);
	}

	@Override
	public boolean isPumpkin(Object itemStackOrItemOrBlock) {
		return base.superIsPumpkin(itemStackOrItemOrBlock);
	}

	@Override
	public boolean isCtrlKeyDown() {
		return base.superIsCtrlKeyDown();
	}

	@Override
	public boolean isIntegratedServerRunning() {
		return base.superIsIntegratedServerRunning();
	}

	@Override
	public boolean isLANWorld() {
		return base.superIsLANWorld();
	}

	@Override
	public Object getIntegratedServer() {
		return base.superGetIntegratedServer();
	}

	@Override
	public boolean isMac() {
		return base.superIsMac();
	}

	@Override
	public boolean isMuiti() {
		return base.superIsMuiti();
	}

	@Override
	public boolean isPlanter(Object itemStackOrItemOrBlock) {
		return base.superIsPlanter(itemStackOrItemOrBlock);
	}

	@Override
	public boolean isPlanterCheck(Object itemStackOrBlock) {
		return base.superIsPlanterCheck(itemStackOrBlock);
	}

	@Override
	public boolean isShiftKeyDown() {
		return base.superIsShiftKeyDown();
	}

	@Override
	public boolean isSkull(Object itemStackOrItem) {
		return base.superIsSkull(itemStackOrItem);
	}

	@Override
	public int itemArmorRenderIndex(Object itemArmor) {
		return base.superItemArmorRenderIndex(itemArmor);
	}

	@Override
	public int itemArmorGetColor(Object itemArmor, Object itemstack) {
		return base.superItemArmorGetColor(itemArmor, itemstack);
	}

	@Override
	public Object itemArmorGetArmorMaterial(Object itemArmor) {
		return base.superItemArmorGetArmorMaterial(itemArmor);
	}

	@Override
	public String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return base.superItemArmorArmorMaterialGetName(armorMaterial);
	}

	@Override
	public Object itemSetPotionEffect(Object item, String s) {
		return base.superItemSetPotionEffect(item, s);
	}

	@Override
	public int itemItemID(Object item) {
		return base.superItemItemID(item);
	}

	@Override
	public Object itemItemRegistry() {
		return base.superItemItemRegistry();
	}

	@Override
	public int itemGetMetadata(Object item, int i) {
		return base.superItemGetMetadata(item, i);
	}

	@Override
	public String potionHelperSugarEffect() {
		return base.superPotionHelperSugarEffect();
	}

	@Override
	public String potionHelperGhastTearEffect() {
		return base.superPotionHelperGhastTearEffect();
	}

	@Override
	public String potionHelperSpiderEyeEffect() {
		return base.superPotionHelperSpiderEyeEffect();
	}

	@Override
	public String potionHelperFermentedSpiderEyeEffect() {
		return base.superPotionHelperFermentedSpiderEyeEffect();
	}

	@Override
	public String potionHelperSpeckledMelonEffect() {
		return base.superPotionHelperSpeckledMelonEffect();
	}

	@Override
	public String potionHelperBlazePowderEffect() {
		return base.superPotionHelperBlazePowderEffect();
	}

	@Override
	public String potionHelperMagmaCreamEffect() {
		return base.superPotionHelperMagmaCreamEffect();
	}

	@Override
	public String potionHelperRedstoneEffect() {
		return base.superPotionHelperRedstoneEffect();
	}

	@Override
	public String potionHelperGlowstoneEffect() {
		return base.superPotionHelperGlowstoneEffect();
	}

	@Override
	public String potionHelperGunpowderEffect() {
		return base.superPotionHelperGunpowderEffect();
	}

	@Override
	public String potionHelperGoldenCarrotEffect() {
		return base.superPotionHelperGoldenCarrotEffect();
	}

	@Override
	public Map registrySimpleRegistryObjects() {
		return base.superRegistrySimpleRegistryObjects();
	}

	@Override
	public Map registrySimpleRegistryObjects(Object registrySimple) {
		return base.superRegistrySimpleRegistryObjects(registrySimple);
	}

	@Override
	public Object iBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Comparable comparable) {
		return base.superIBlockStateWithProperty(blockOrIBlockState, iProperty, comparable);
	}

	@Override
	public boolean itemIsFull3D(Object item) {
		return base.superItemIsFull3D(item);
	}

	@Override
	public boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return base.superItemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase);
	}

	@Override
	public boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase, Object enumHand) {
		return base.superItemItemInteractionForEntity(item, itemstack, entityplayer, entityLivingBase, enumHand);
	}

	@Override
	public void itemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
		base.superItemModelMesherRegister(itemModelMesher, item, i, modelResourceLocation);
	}

	@Override
	public void itemModelMesherRegister(Object itemModelMesher, Object item, Object itemMeshDefinition) {
		base.superItemModelMesherRegister(itemModelMesher, item, itemMeshDefinition);
	}

	@Override
	public List itemPotionGetEffects(Object itemPotion, Object itemStack) {
		return base.superItemPotionGetEffects(itemPotion, itemStack);
	}

	@Override
	public Object[] itemItemsList() {
		return base.superItemItemsList();
	}

	@Override
	public Object itemSetTextureName(Object item, String s) {
		return base.superItemSetTextureName(item, s);
	}

	@Override
	public Object itemSetUnlocalizedName(Object item, String s) {
		return base.superItemSetUnlocalizedName(item, s);
	}

	@Override
	public Object itemSetCreativeTab(Object item, Object creativeTabs) {
		return base.superItemSetCreativeTab(item, creativeTabs);
	}

	@Override
	public String itemIconString(Object item) {
		return base.superItemIconString(item);
	}

	@Override
	public void setItemIconString(Object item, String s) {
		base.superSetItemIconString(item, s);
	}

	@Override
	public Object itemItemIcon(Object item) {
		return base.superItemItemIcon(item);
	}

	@Override
	public void setItemItemIcon(Object item, Object icon) {
		base.superSetItemItemIcon(item, icon);
	}

	@Override
	public void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		base.superItemOnItemRightClick(item, itemStack, world, entityplayer);
	}

	@Override
	public void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer, Object enumHand) {
		base.superItemOnItemRightClick(item, itemStack, world, entityplayer, enumHand);
	}

	@Override
	public Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		return base.superIIconRegisterRegisterIcon(iIconRegister, s);
	}

	@Override
	public Object itemStackCopyItemStack(Object itemStack) {
		return base.superItemStackCopyItemStack(itemStack);
	}

	@Override
	public Object itemStackGetItem(Object itemstack) {
		return base.superItemStackGetItem(itemstack);
	}

	@Override
	public int itemStackGetItemDamage(Object itemstack) {
		return base.superItemStackGetItemDamage(itemstack);
	}

	@Override
	public int itemStackGetMaxDamage(Object itemstack) {
		return base.superItemStackGetMaxDamage(itemstack);
	}

	@Override
	public Object itemStackGetItemUseAction(Object itemstack) {
		return base.superItemStackGetItemUseAction(itemstack);
	}

	@Override
	public boolean itemStackIsItemEnchanted(Object itemstack) {
		return base.superItemStackIsItemEnchanted(itemstack);
	}

	@Override
	public boolean itemStackHasDisplayName(Object itemstack) {
		return base.superItemStackHasDisplayName(itemstack);
	}

	@Override
	public boolean itemShouldRotateAroundWhenRendering(Object item) {
		return base.superItemShouldRotateAroundWhenRendering(item);
	}

	@Override
	public boolean itemStackHasTagCompound(Object itemStack) {
		return base.superItemStackHasTagCompound(itemStack);
	}

	@Override
	public Object itemStackGetTagCompound(Object nBTTagCompoundOrItemStack) {
		return base.superItemStackGetTagCompound(nBTTagCompoundOrItemStack);
	}

	@Override
	public Object itemStackGetAttributeModifiers(Object itemStack) {
		return base.superItemStackGetAttributeModifiers(itemStack);
	}

	@Override
	public Object itemStackGetAttributeModifiers(Object itemStack, Object entityEquipmentSlot) {
		return base.superItemStackGetAttributeModifiers(itemStack, entityEquipmentSlot);
	}

	@Override
	public int itemStackGetMetadata(Object itemStack) {
		return base.superItemStackGetMetadata(itemStack);
	}

	@Override
	public Enum itemCameraTransformsTransformTypeNONE() {
		return base.superItemCameraTransformsTransformTypeNONE();
	}

	@Override
	public Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		return base.superItemCameraTransformsTransformTypeTHIRD_PERSON();
	}

	@Override
	public Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		return base.superItemCameraTransformsTransformTypeFIRST_PERSON();
	}

	@Override
	public Enum itemCameraTransformsTransformTypeHEAD() {
		return base.superItemCameraTransformsTransformTypeHEAD();
	}

	@Override
	public Enum itemCameraTransformsTransformTypeGUI() {
		return base.superItemCameraTransformsTransformTypeGUI();
	}

	@Override
	public boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		return base.superNbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s);
	}

	@Override
	public boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s, int i) {
		return base.superNbtTagCompoundHasKey(nBTTagCompoundOrItemStack, s, i);
	}

	@Override
	public String nbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		return base.superNbtTagCompoundGetString(nBTTagCompoundOrItemStack, s);
	}

	@Override
	public void nbtTagCompoundSetTag(Object nBTTagCompound, String s, Object nbtBase) {
		base.superNbtTagCompoundSetTag(nBTTagCompound, s, nbtBase);
	}

	@Override
	public Object nbtTagCompoundGetCompoundTag(Object nBTTagCompoundOrItemStack, String s) {
		return base.superNbtTagCompoundGetCompoundTag(nBTTagCompoundOrItemStack, s);
	}

	@Override
	public Object nbtUtilReadGameProfileFromNBT(Object nBTTagCompound) {
		return base.superNbtUtilReadGameProfileFromNBT(nBTTagCompound);
	}

	@Override
	public Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return base.superNBTUtilWriteGameProfile(nBTTagCompound, gameprofile);
	}

	@Override
	public Object tileEntitySkullRendererSkullRenderer() {
		return base.superTileEntitySkullRendererSkullRenderer();
	}

	@Override
	public Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return base.superTileEntitySkullUpdateGameprofile(gameprofile);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, int i, float f3, int i2, Object gameProfile) {
		base.superTileEntitySkullRendererRenderSkull(f, f1, f2, i, f3, i2, gameProfile);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		base.superTileEntitySkullRendererRenderSkull(f, f1, f2, en, f3, i, gameProfile, i2);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		base.superTileEntitySkullRendererRenderSkull(null, f, f1, f2, en, f3, i, gameProfile, i2, f4);
	}

	@Override
	public void tileEntitySkullRendererRenderSkull(Object skullRenderer, float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2, float f4) {
		base.superTileEntitySkullRendererRenderSkull(skullRenderer, f, f1, f2, en, f3, i, gameProfile, i2, f4);
	}

	@Override
	public int itemStackItemID(Object itemstack) {
		return base.superItemStackItemID(itemstack);
	}

	@Override
	public int itemStackStackSize(Object itemstack) {
		return base.superItemStackStackSize(itemstack);
	}

	@Override
	public void setItemStackStackSize(Object itemstack, int i) {
		base.superSetItemStackStackSize(itemstack, i);
	}

	@Override
	public String itemStackGetDisplayName(Object itemstack) {
		return base.superItemStackGetDisplayName(itemstack);
	}

	@Override
	public void itemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		base.superItemStackDamageItem(itemstack, i, entityLivingBase);
	}

	@Override
	public boolean itemRequiresMultipleRenderPasses(Object item) {
		return base.superItemRequiresMultipleRenderPasses(item);
	}

	@Override
	public int itemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return base.superItemGetColorFromItemStack(item, itemstack, i);
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		return base.superBlockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, x, y, z);
	}

	@Override
	public int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object iBlockAccess, int x, int y, int z) {
		return base.superBlockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, iBlockAccess, x, y, z);
	}

	@Override
	public int blockDoublePlantColorMultiplier(Object blockDoublePlant, int x, int y, int z) {
		return base.superBlockDoublePlantColorMultiplier(blockDoublePlant, x, y, z);
	}

	@Override
	public int blockDoublePlantColorMultiplier(Object blockDoublePlant, Object world, int x, int y, int z) {
		return base.superBlockDoublePlantColorMultiplier(blockDoublePlant, world, x, y, z);
	}

	@Override
	public int biomeGetBiomeGrassColor(Object biome) {
		return base.superBiomeGetBiomeGrassColor(biome);
	}

	@Override
	public int biomeGetBiomeGrassColor(Object biome, int x, int y, int z) {
		return base.superBiomeGetBiomeGrassColor(biome, x, y, z);
	}

	@Override
	public boolean blockDoublePlantFunc_149887_c(int i) {
		return base.superBlockDoublePlantFunc_149887_c(i);
	}

	@Override
	public int blockDoublePlantFunc_149890_d(int i) {
		return base.superBlockDoublePlantFunc_149890_d(i);
	}

	@Override
	public Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		return base.superBlockDoublePlantFunc_149888_a(blockDoublePlant, b, i);
	}

	@Override
	public Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		return base.superBlockDoublePlantSunflowerIcons(blockDoublePlant);
	}

	@Override
	public double iIconGetMinU(Object iIcon) {
		return base.superIIconGetMinU(iIcon);
	}

	@Override
	public double iIconGetMinV(Object iIcon) {
		return base.superIIconGetMinV(iIcon);
	}

	@Override
	public double iIconGetMaxU(Object iIcon) {
		return base.superIIconGetMaxU(iIcon);
	}

	@Override
	public double iIconGetMaxV(Object iIcon) {
		return base.superIIconGetMaxV(iIcon);
	}

	@Override
	public String iAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return base.superIAttributeGetAttributeUnlocalizedName(iAttribute);
	}

	@Override
	public boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return base.superKeyBindingGetIsKeyPressed(keyBinding);
	}

	@Override
	public List keybindArray() {
		return base.superKeybindArray();
	}

	@Override
	public boolean entityRendererAnaglyphEnable() {
		return base.superEntityRendererAnaglyphEnable();
	}

	@Override
	public boolean keyBindingIsPressed(Object keyBinding) {
		return base.superKeyBindingIsPressed(keyBinding);
	}

	@Override
	public String keyBindingKeyCategory(Object keyBinding) {
		return base.superKeyBindingKeyCategory(keyBinding);
	}

	@Override
	public int keyBindingKeyCode(Object keyBinding) {
		return base.superKeyBindingKeyCode(keyBinding);
	}

	@Override
	public String keyBindingKeyDescription(Object keyBinding) {
		return base.superKeyBindingKeyDescription(keyBinding);
	}

	@Override
	public boolean keyBindingPressed(Object keyBinding) {
		return base.superKeyBindingPressed(keyBinding);
	}

	@Override
	public int keyBindingPressTime(Object keyBinding) {
		return base.superKeyBindingPressTime(keyBinding);
	}

	@Override
	public boolean keyBindingSetPressed(Object keyBinding, boolean b) {
		return base.superKeyBindingSetPressed(keyBinding, b);
	}

	@Override
	public void loadingScreenDisplayLoadingString(String s) {
		base.superLoadingScreenDisplayLoadingString(s);
	}

	@Override
	public void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		base.superLoadingScreenDisplayLoadingString(loadingScreenRenderer, s);
	}

	@Override
	public void loadingScreenResetProgressAndMessage(String s) {
		base.superLoadingScreenResetProgressAndMessage(s);
	}

	@Override
	public void loadingScreenResetProgressAndMessage(Object loadingScreenRenderer, String s) {
		base.superLoadingScreenResetProgressAndMessage(loadingScreenRenderer, s);
	}

	@Override
	public void loadingScreenSetLoadingProgress(int i) {
		base.superLoadingScreenSetLoadingProgress(i);
	}

	@Override
	public void loadingScreenSetLoadingProgress(Object loadingScreenRenderer, int i) {
		base.superLoadingScreenSetLoadingProgress(loadingScreenRenderer, i);
	}

	@Override
	public float mathHelperCos(float f) {
		return base.superMathHelperCos(f);
	}

	@Override
	public int mathHelperFloor_double(double d) {
		return base.superMathHelperFloor_double(d);
	}

	@Override
	public float mathHelperFloor_float(float f) {
		return base.superMathHelperFloor_float(f);
	}

	@Override
	public float mathHelperWrapAngleTo180_float(float f) {
		return base.superMathHelperWrapAngleTo180_float(f);
	}

	@Override
	public long mathHelperLfloor(double d) {
		return base.superMathHelperLfloor(d);
	}

	@Override
	public float mathHelperAbs(float f) {
		return base.superMathHelperAbs(f);
	}

	@Override
	public double mathHelperAbs_max(double d, double d1) {
		return base.superMathHelperAbs_max(d, d1);
	}

	@Override
	public int mathHelperIntFloorDiv(int i, int j) {
		return base.superMathHelperBucketInt(i, j);
	}

	@Override
	public boolean mathHelperStringNullOrLengthZero(String s) {
		return base.superMathHelperStringNullOrLengthZero(s);
	}

	@Override
	public float mathHelperSin(float f) {
		return base.superMathHelperSin(f);
	}

	@Override
	public float mathHelperSqrt_float(float f) {
		return base.superMathHelperSqrt_float(f);
	}

	@Override
	public double mathHelperSqrt_double(double d) {
		return base.superMathHelperSqrt_double(d);
	}

	@Override
	public Object minecraftCurrentScreen() {
		return base.superMinecraftCurrentScreen();
	}

	@Override
	public Object minecraftMyNetworkManager() {
		return base.superMinecraftMyNetworkManager();
	}

	@Override
	public void setMinecraftMyNetworkManager(Object iNetworkManager) {
		base.superSetMinecraftMyNetworkManager(iNetworkManager);
	}

	@Override
	public int minecraftDisplayHeight() {
		return base.superMinecraftDisplayHeight();
	}

	@Override
	public int minecraftDisplayWidth() {
		return base.superMinecraftDisplayWidth();
	}

	@Override
	public Object minecraftEntityRenderer() {
		return base.superMinecraftEntityRenderer();
	}

	@Override
	public Object minecraftEntityRendererItemRenderer() {
		return base.superMinecraftEntityRendererItemRenderer();
	}

	@Override
	public Object minecraftFontRenderer() {
		return base.superMinecraftFontRenderer();
	}

	@Override
	public void minecraftFontRenderer(Object fontRenderer) {
		base.superMinecraftFontRenderer(fontRenderer);
	}

	@Override
	public Object minecraftGameSettings() {
		return base.superMinecraftGameSettings();
	}

	@Override
	public void minecraftGameSettingsSetThirdPersonView(int i) {
		base.superMinecraftGameSettingsSetThirdPersonView(i);
	}

	@Override
	public int minecraftGameSettingsThirdPersonView() {
		return base.superMinecraftGameSettingsThirdPersonView();
	}

	@Override
	public boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		return base.superMinecraftGameSettingsTouchscreen(gameSettings);
	}

	@Override
	public Object minecraftGatSession() {
		return base.superMinecraftGatSession();
	}

	@Override
	public Object minecraftGetMinecraft() {
		return base.superMinecraftGetMinecraft();
	}

	@Override
	public Object minecraftGetRenderItem() {
		return base.superMinecraftGetRenderItem();
	}

	@Override
	public Object minecraftGetResourceManager() {
		return base.superMinecraftGetResourceManager();
	}

	@Override
	public long minecraftGetSystemTime() {
		return base.superMinecraftGetSystemTime();
	}

	@Override
	public Object minecraftGetTextureManager() {
		return base.superMinecraftGetTextureManager();
	}

	@Override
	public boolean minecraftInGameHasFocus() {
		return base.superMinecraftInGameHasFocus();
	}

	@Override
	public File minecraftMcDataDir() {
		return base.superMinecraftMcDataDir();
	}

	@Override
	public Object minecraftGetBlockRendererDispatcher() {
		return base.superMinecraftGetBlockRendererDispatcher();
	}

	@Override
	public Object minecraftLoadingScreen() {
		return base.superMinecraftLoadingScreen();
	}

	@Override
	public void setMinecraftLoadingScreen(Object loadingScreenRenderer) {
		base.superSetMinecraftLoadingScreen(loadingScreenRenderer);
	}

	@Override
	public Object minecraftPlayerController() {
		return base.superMinecraftPlayerController();
	}

	@Override
	public Object minecraftSession() {
		return base.superMinecraftSession();
	}

	@Override
	public void minecraftSetDimensionAndSpawnPlayer() {
		base.superMinecraftSetDimensionAndSpawnPlayer();
	}

	@Override
	public void minecraftSetDimensionAndSpawnPlayer(int i) {
		base.superMinecraftSetDimensionAndSpawnPlayer(i);
	}

	@Override
	public long minecraftSystemTime() {
		return base.superMinecraftSystemTime();
	}

	@Override
	public Object minecraftTextureManager() {
		return base.superMinecraftTextureManager();
	}

	@Override
	public Object minecraftPlayer() {
		return base.superMinecraftPlayer();
	}

	@Override
	public Object minecraftWorld() {
		return base.superMinecraftWorld();
	}

	@Override
	public Object minecraftDisplayGuiScreen() {
		return base.superMinecraftDisplayGuiScreen();
	}

	@Override
	public Object minecraftGetIntegratedServer() {
		return base.superMinecraftGetIntegratedServer();
	}

	@Override
	public Object minecraftServerGetServer() {
		return base.superMinecraftServerGetServer();
	}

	@Override
	public Object[] minecraftServerGetServerWorldServers() {
		return base.superMinecraftServerGetServerWorldServers();
	}

	@Override
	public File minecraftServerGetFile(String s) {
		return base.superMinecraftServerGetFile(s);
	}

	@Override
	public Object minecraftServerGetConfigurationManager(Object minecraftServer) {
		return base.superMinecraftServerGetConfigurationManager(minecraftServer);
	}

	@Override
	public String minecraftLaunchedVersion() {
		return base.superMinecraftLaunchedVersion();
	}

	@Override
	public String minecraftLaunchedVersion(Object minecraft) {
		return base.superMinecraftLaunchedVersion(minecraft);
	}

	@Override
	public void minecraftUpdateFramebufferSize() {
		base.superMinecraftUpdateFramebufferSize();
	}

	@Override
	public void minecraftUpdateFramebufferSize(Object minecraft) {
		base.superMinecraftUpdateFramebufferSize(minecraft);
	}

	@Override
	public Object modelRightArm(Object model) {
		return base.superModelRightArm(model);
	}

	@Override
	public Object modelBipedBipedRightArm(Object modelBiped) {
		return base.superModelBipedBipedRightArm(modelBiped);
	}

	@Override
	public void setModelBipedBipedRightArm(Object modelBiped, Object modelRenderer) {
		base.superSetModelBipedBipedRightArm(modelBiped, modelRenderer);
	}

	@Override
	public Object modelWolfWolfLeg1(Object modelWolf) {
		return base.superModelWolfWolfLeg1(modelWolf);
	}

	@Override
	public void setModelWolfWolfLeg1(Object modelWolf, Object modelRenderer) {
		base.superSetModelWolfWolfLeg1(modelWolf, modelRenderer);
	}

	@Override
	public Object modelSnowManRightHand(Object modelSnowMan) {
		return base.superModelSnowManRightHand(modelSnowMan);
	}

	@Override
	public void setModelSnowManRightHand(Object modelSnowMan, Object modelRenderer) {
		base.superSetModelSnowManRightHand(modelSnowMan, modelRenderer);
	}

	@Override
	public Object modelSpiderSpiderLeg1(Object modelSpider) {
		return base.superModelSpiderSpiderLeg1(modelSpider);
	}

	@Override
	public void setModelSpiderSpiderLeg1(Object modelSpider, Object modelRenderer) {
		base.superSetModelSpiderSpiderLeg1(modelSpider, modelRenderer);
	}

	@Override
	public Object modelOcelotOcelotFrontRightLeg(Object modelOcelot) {
		return base.superModelOcelotOcelotFrontRightLeg(modelOcelot);
	}

	@Override
	public void setModelOcelotOcelotFrontRightLeg(Object modelOcelot, Object modelRenderer) {
		base.superSetModelOcelotOcelotFrontRightLeg(modelOcelot, modelRenderer);
	}

	@Override
	public Object modelIronGolemIronGolemRightArm(Object modelIronGolem) {
		return base.superModelIronGolemIronGolemRightArm(modelIronGolem);
	}

	@Override
	public void setModelIronGolemIronGolemRightArm(Object modelIronGolem, Object modelRenderer) {
		base.superSetModelIronGolemIronGolemRightArm(modelIronGolem, modelRenderer);
	}

	@Override
	public Object modelQuadrupedLeg1(Object modelQuadruped) {
		return base.superModelQuadrupedLeg1(modelQuadruped);
	}

	@Override
	public void setModelQuadrupedLeg1(Object modelQuadruped, Object modelRenderer) {
		base.superSetModelQuadrupedLeg1(modelQuadruped, modelRenderer);
	}

	@Override
	public Object modelCreeperLeg1(Object modelCreeper) {
		return base.superModelCreeperLeg1(modelCreeper);
	}

	@Override
	public void setModelCreeperLeg1(Object modelCreeper, Object modelRenderer) {
		base.superSetModelCreeperLeg1(modelCreeper, modelRenderer);
	}

	@Override
	public Object modelHorseFrontRightLeg(Object modelHorse) {
		return base.superModelHorseFrontRightLeg(modelHorse);
	}

	@Override
	public void setModelHorseFrontRightLeg(Object modelHorse, Object modelRenderer) {
		base.superSetModelHorseFrontRightLeg(modelHorse, modelRenderer);
	}

	@Override
	public Object modelBatBatRightWing(Object modelBat) {
		return base.superModelBatBatRightWing(modelBat);
	}

	@Override
	public void setModelBatBatRightWing(Object modelBat, Object modelRenderer) {
		base.superSetModelBatBatRightWing(modelBat, modelRenderer);
	}

	@Override
	public Object[] modelSquidSquidTentacles(Object modelSquid) {
		return base.superModelSquidSquidTentacles(modelSquid);
	}

	@Override
	public void setModelSquidSquidTentacles(Object modelSquid, Object[] modelRenderer) {
		base.superSetModelSquidSquidTentacles(modelSquid, modelRenderer);
	}

	@Override
	public Object[] modelBlazeBlazeSticks(Object modelBlaze) {
		return base.superModelBlazeBlazeSticks(modelBlaze);
	}

	@Override
	public void setModelBlazeBlazeSticks(Object modelBlaze, Object[] modelRenderer) {
		base.superSetModelBlazeBlazeSticks(modelBlaze, modelRenderer);
	}

	@Override
	public Object[] modelGhastTentacles(Object modelGhast) {
		return base.superModelGhastTentacles(modelGhast);
	}

	@Override
	public void setModelGhastTentacles(Object modelBlaze, Object[] modelRenderer) {
		base.superSetModelGhastTentacles(modelBlaze, modelRenderer);
	}

	@Override
	public Object modelChickenRightWing(Object modelChicken) {
		return base.superModelChickenRightWing(modelChicken);
	}

	@Override
	public void setModelChickenRightWing(Object modelChicken, Object modelRenderer) {
		base.superSetModelChickenRightWing(modelChicken, modelRenderer);
	}

	@Override
	public boolean modelBaseIsChild(Object modelBase) {
		return base.superModelBaseIsChild(modelBase);
	}

	@Override
	public void setModelBaseIsChild(Object modelBase, boolean b) {
		base.superSetModelBaseIsChild(modelBase, b);
	}

	@Override
	public List modelBaseBoxList(Object modelBase) {
		return base.superModelBaseBoxList(modelBase);
	}

	@Override
	public void setModelBaseBoxList(Object modelBase, List list) {
		base.superSetModelBaseBoxList(modelBase, list);
	}

	@Override
	public int modelBaseTextureWidth(Object modelBase) {
		return base.superModelBaseTextureWidth(modelBase);
	}

	@Override
	public void setModelBaseTextureWidth(Object modelBase, int i) {
		base.superSetModelBaseTextureWidth(modelBase, i);
	}

	@Override
	public int modelBaseTextureHeight(Object modelBase) {
		return base.superModelBaseTextureHeight(modelBase);
	}

	@Override
	public void setModelBaseTextureHeight(Object modelBase, int i) {
		base.superSetModelBaseTextureHeight(modelBase, i);
	}

	@Override
	public Object modelBaseRender(Object model, Object entity, float f, float f2, float f3, float f4, float f5, float f6) {
		return base.superModelBaseRender(model, entity, f, f2, f3, f4, f5, f6);
	}

	@Override
	public void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		base.superModelBaseSetLivingAnimations(model, entity, f, f1, f2);
	}

	@Override
	public void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		base.superModelBaseSetRotationAngles(model, f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public ConcurrentHashMap modelRendererGetTextureOffsetMap(Object modelRenderer) {
		return base.superModelRendererGetTextureOffsetMap(modelRenderer);
	}

	@Override
	public int movingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		return base.superMovingObjectPositionBlockPosGetX(movingObjectPosition);
	}

	@Override
	public int movingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		return base.superMovingObjectPositionBlockPosGetY(movingObjectPosition);
	}

	@Override
	public int movingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		return base.superMovingObjectPositionBlockPosGetZ(movingObjectPosition);
	}

	@Override
	public int movingObjectPositionSideHit(Object movingObjectPosition) {
		return base.superMovingObjectPositionSideHit(movingObjectPosition);
	}

	@Override
	public Enum movingObjectPositionTypeOfHit(Object movingObjectPosition) {
		return base.superMovingObjectPositionTypeOfHit(movingObjectPosition);
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		return base.superMovingObjectPositionMovingObjectTypeMISS(movingObjectPosition);
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		return base.superMovingObjectPositionMovingObjectTypeBLOCK(movingObjectPosition);
	}

	@Override
	public Enum movingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		return base.superMovingObjectPositionMovingObjectTypeENTITY(movingObjectPosition);
	}

	@Override
	public Object movingObjectPositionHitVec(Object movingObjectPosition) {
		return base.superMovingObjectPositionHitVec(movingObjectPosition);
	}

	@Override
	public Object newInstanceKeyBinding(String s, int i, String s2) {
		return base.superNewInstanceKeyBinding(s, i, s2);
	}

	@Override
	public Object newModelRenderer(Object[] pArg) {
		return base.superNewModelRenderer(pArg);
	}

	@Override
	public Object modelRendererAddBox(Object[] pArg) {
		return base.superModelRendererAddBox(pArg);
	}

	@Override
	public void modelRendererSetRotationPoint(Object modelRenderer, float f, float f1, float f2) {
		base.superModelRendererSetRotationPoint(modelRenderer, f, f1, f2);
	}

	@Override
	public boolean modelRendererShowModel(Object modelRenderer) {
		return base.superModelRendererShowModel(modelRenderer);
	}

	@Override
	public void setModelRendererShowModel(Object modelRenderer, boolean b) {
		base.superSetModelRendererShowModel(modelRenderer, b);
	}

	@Override
	public float modelRendererRotateAngleX(Object modelRenderer) {
		return base.superModelRendererRotateAngleX(modelRenderer);
	}

	@Override
	public void setModelRendererRotateAngleX(Object modelRenderer, float f) {
		base.superSetModelRendererRotateAngleX(modelRenderer, f);
	}

	@Override
	public float modelRendererRotateAngleY(Object modelRenderer) {
		return base.superModelRendererRotateAngleY(modelRenderer);
	}

	@Override
	public void setModelRendererRotateAngleY(Object modelRenderer, float f) {
		base.superSetModelRendererRotateAngleY(modelRenderer, f);
	}

	@Override
	public float modelRendererRotateAngleZ(Object modelRenderer) {
		return base.superModelRendererRotateAngleZ(modelRenderer);
	}

	@Override
	public void setModelRendererRotateAngleZ(Object modelRenderer, float f) {
		base.superSetModelRendererRotateAngleZ(modelRenderer, f);
	}

	@Override
	public float modelRendererRotationPointX(Object modelRenderer) {
		return base.superModelRendererRotationPointX(modelRenderer);
	}

	@Override
	public void setModelRendererRotationPointX(Object modelRenderer, float f) {
		base.superSetModelRendererRotationPointX(modelRenderer, f);
	}

	@Override
	public float modelRendererRotationPointY(Object modelRenderer) {
		return base.superModelRendererRotationPointY(modelRenderer);
	}

	@Override
	public void setModelRendererRotationPointY(Object modelRenderer, float f) {
		base.superSetModelRendererRotationPointY(modelRenderer, f);
	}

	@Override
	public float modelRendererRotationPointZ(Object modelRenderer) {
		return base.superModelRendererRotationPointZ(modelRenderer);
	}

	@Override
	public void setModelRendererRotationPointZ(Object modelRenderer, float f) {
		base.superSetModelRendererRotationPointZ(modelRenderer, f);
	}

	@Override
	public void modelRendererRender(Object modelRenderer, float f) {
		base.superModelRendererRender(modelRenderer, f);
	}

	@Override
	public void modelRendererPostRender(Object modelRenderer, float f) {
		base.superModelRendererPostRender(modelRenderer, f);
	}

	@Override
	public void modelRendererRenderWithRotation(Object modelRenderer, float f) {
		base.superModelRendererRenderWithRotation(modelRenderer, f);
	}

	@Override
	public Object[] modelBoxVertexPositions(Object modelBox) {
		return base.superModelBoxVertexPositions(modelBox);
	}

	@Override
	public void setModelBoxVertexPositions(Object modelBox, Object vertexPositions) {
		base.superSetModelBoxVertexPositions(modelBox, vertexPositions);
	}

	@Override
	public Object[] modelBoxQuadList(Object modelBox) {
		return base.superModelBoxQuadList(modelBox);
	}

	@Override
	public void setModelBoxQuadList(Object modelBox, Object quadList) {
		base.superSetModelBoxQuadList(modelBox, quadList);
	}

	@Override
	public boolean nbttagcompoundGetBoolean(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetBoolean(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetBoolean(Object nbttagcompound, String s, boolean b) {
		base.superNbttagcompoundSetBoolean(nbttagcompound, s, b);
	}

	@Override
	public String nbttagcompoundGetString(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetString(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetString(Object nbttagcompound, String s, String s1) {
		base.superNbttagcompoundSetString(nbttagcompound, s, s1);
	}

	@Override
	public int nbttagcompoundGetInteger(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetInteger(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetInteger(Object nbttagcompound, String s, int i) {
		base.superNbttagcompoundSetInteger(nbttagcompound, s, i);
	}

	@Override
	public float nbttagcompoundGetFloat(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetFloat(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetFloat(Object nbttagcompound, String s, float f) {
		base.superNbttagcompoundSetFloat(nbttagcompound, s, f);
	}

	@Override
	public double nbttagcompoundGetDouble(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetDouble(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetDouble(Object nbttagcompound, String s, double d) {
		base.superNbttagcompoundSetDouble(nbttagcompound, s, d);
	}

	@Override
	public short nbttagcompoundGetShort(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetShort(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetShort(Object nbttagcompound, String s, short sh) {
		base.superNbttagcompoundSetShort(nbttagcompound, s, sh);
	}

	@Override
	public long nbttagcompoundGetLong(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetLong(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetLong(Object nbttagcompound, String s, long l) {
		base.superNbttagcompoundSetLong(nbttagcompound, s, l);
	}

	@Override
	public byte nbttagcompoundGetByte(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetByte(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetByte(Object nbttagcompound, String s, byte by) {
		base.superNbttagcompoundSetByte(nbttagcompound, s, by);
	}

	@Override
	public byte[] nbttagcompoundGetByteArray(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetByteArray(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetByteArray(Object nbttagcompound, String s, byte[] by) {
		base.superNbttagcompoundSetByteArray(nbttagcompound, s, by);
	}

	@Override
	public int[] nbttagcompoundGetIntArray(Object nbttagcompound, String s) {
		return base.superNbttagcompoundGetIntArray(nbttagcompound, s);
	}

	@Override
	public void nbttagcompoundSetIntArray(Object nbttagcompound, String s, int[] in) {
		base.superNbttagcompoundSetIntArray(nbttagcompound, s, in);
	}

	@Override
	public Object netClientHandlerGetNetManager(Object netClientHandler) {
		return base.superNetClientHandlerGetNetManager(netClientHandler);
	}

	@Override
	public void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
		base.superNetClientHandlerHandleClientCommand(netClientHandler, packet205ClientCommand);
	}

	@Override
	public Object oldVersionItem(String s) {
		return base.superOldVersionItem(s);
	}

	@Override
	public Object oldVersionBlock(String s) {
		return base.superOldVersionBlock(s);
	}

	@Override
	public int openGlHelperDefaultTexUnit() {
		return base.superOpenGlHelperDefaultTexUnit();
	}

	@Override
	public int openGlHelperLightmapTexUnit() {
		return base.superOpenGlHelperLightmapTexUnit();
	}

	@Override
	public void openGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
		base.superOpenGlHelperGlBlendFunc(i, i1, i2, i3);
	}

	@Override
	public void openGlHelperSetActiveTexture(int i) {
		base.superOpenGlHelperSetActiveTexture(i);
	}

	@Override
	public Object pathNavigateTryMoveToXYZ(Object pathNavigate, int x, int y, int z, float f) {
		return base.superPathNavigateTryMoveToXYZ(pathNavigate, x, y, z, f);
	}

	@Override
	public void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		base.superPathNavigateGroundFunc_179690_a(pathNavigateGround, b);
	}

	@Override
	public void playerControllerMPSetPlayerCapabilities() {
		base.superPlayerControllerMPSetPlayerCapabilities();
	}

	@Override
	public void playerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
		base.superPlayerControllerMPSetPlayerCapabilities(playerController, entityplayer);
	}

	@Override
	public void playerControllerFunc_6473_b() {
		base.superPlayerControllerFunc_6473_b();
	}

	@Override
	public void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
		base.superPlayerControllerFunc_6473_b(playerController, entityplayer);
	}

	@Override
	public Object playerControllerMPCreatePlayer() {
		return base.superPlayerControllerMPCreatePlayer();
	}

	@Override
	public Object playerControllerMPCreatePlayer(Object playerController) {
		return base.superPlayerControllerMPCreatePlayer(playerController);
	}

	@Override
	public void playerControllerMPFlipPlayer() {
		base.superPlayerControllerMPFlipPlayer();
	}

	@Override
	public void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		base.superPlayerControllerMPFlipPlayer(playerController, entityplayer);
	}

	@Override
	public void playerControllerSetGameType(Object enumGameType) {
		base.superPlayerControllerSetGameType(enumGameType);
	}

	@Override
	public Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return base.superPositionTextureVertexSetTexturePosition(positionTextureVertex, f, f1);
	}

	@Override
	public float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return base.superPositionTextureVertexTexturePositionX(positionTextureVertex);
	}

	@Override
	public float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return base.superPositionTextureVertexTexturePositionY(positionTextureVertex);
	}

	@Override
	public Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return base.superPositionTextureVertexVector3D(positionTextureVertex);
	}

	@Override
	public void printChatMessage(String s) {
		base.superPrintChatMessage(s);
	}

	@Override
	public Object render(Object model) {
		return base.superRender(model);
	}

	@Override
	public void renderBindTexture(Object render, Object resourceLocation) {
		base.superRenderBindTexture(render, resourceLocation);
	}

	@Override
	public String[] renderBipedBipedArmorFilenamePrefix() {
		return base.superRenderBipedBipedArmorFilenamePrefix();
	}

	@Override
	public void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		base.superRenderBlocksRenderBlockAllFaces(renderBlocks, block, i, i2, i3);
	}

	@Override
	public void renderBlocksDrawCrossedSquares(Object renderBlocks, Object iIcon, double d, double d2, double d3, float f) {
		base.superRenderBlocksDrawCrossedSquares(renderBlocks, iIcon, d, d2, d3, f);
	}

	@Override
	public void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		base.superRenderBlocksRenderBlockAsItem(renderBlocks, block, i, f);
	}

	@Override
	public boolean renderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return base.superRenderBlocksRenderItemIn3d(renderBlocks, i);
	}

	@Override
	public Object renderEngine() {
		return base.superRenderEngine();
	}

	@Override
	public void renderEngineBindTexture(Object o) {
		base.superRenderEngineBindTexture(o);
	}

	@Override
	public void renderEngineSetupTexture(Object bufferedimage, int i) {
		base.superRenderEngineSetupTexture(bufferedimage, i);
	}

	@Override
	public void renderEngineDeleteTexture(Object resourceLocation) {
		base.superRenderEngineDeleteTexture(resourceLocation);
	}

	@Override
	public void renderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
		base.superRenderEngineDeleteTexture(renderEngine, resourceLocation);
	}

	@Override
	public Object renderItemGetItemModelMesher(Object renderItem) {
		return base.superRenderItemGetItemModelMesher(renderItem);
	}

	@Override
	public Object rendererLivingEntityRES_ITEM_GLINT(Object render) {
		return base.superRendererLivingEntityRES_ITEM_GLINT(render);
	}

	@Override
	public void rendererLivingEntityPassSpecialRender(Object rendererLivingEntity, Object entity, double d, double d1, double d2) {
		base.superRendererLivingEntityPassSpecialRender(rendererLivingEntity, entity, d, d1, d2);
	}

	@Override
	public void rendererLivingEntitySetRenderPassModel(Object rendererLivingEntity, Object modelBase) {
		base.superRendererLivingEntitySetRenderPassModel(rendererLivingEntity, modelBase);
	}

	@Override
	public void renderFirstPersonArm(Object render, Object entityplayer) {
		base.superRenderFirstPersonArm(render, entityplayer);
	}

	@Override
	public boolean renderPlayerSmallArms(Object renderPlayer) {
		return base.superRenderPlayerSmallArms(renderPlayer);
	}

	@Override
	public void renderHelperDisableStandardItemLighting() {
		base.superRenderHelperDisableStandardItemLighting();
	}

	@Override
	public void renderHelperEnableStandardItemLighting() {
		base.superRenderHelperEnableStandardItemLighting();
	}

	@Override
	public void renderItems(Object model, Object entity, Object render) {
		base.superRenderItems(model, entity, render);
	}

	@Override
	public Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return base.superRenderLoadDownloadableImageTexture(render, s, s1);
	}

	@Override
	public Object renderMainModel(Object render) {
		return base.superRenderMainModel(render);
	}

	@Override
	public void renderLivingFunc_110827_b(Object renderLiving, Object entityLiving, double d, double d2, double d3, float f, float f1) {
		base.superRenderLivingFunc_110827_b(renderLiving, entityLiving, d, d2, d3, f, f1);
	}

	@Override
	public boolean renderLivingFunc_110813_b(Object renderLiving, Object entityLiving) {
		return base.superRenderLivingFunc_110813_b(renderLiving, entityLiving);
	}

	@Override
	public Map renderManagerEntityRenderMap() {
		return base.superRenderManagerEntityRenderMap();
	}

	@Override
	public Map renderManagerSkinMap() {
		return base.superRenderManagerSkinMap();
	}

	@Override
	public Object renderManagerGetEntityClassRenderObject(Class c) {
		return base.superRenderManagerGetEntityClassRenderObject(c);
	}

	@Override
	public Object renderManagerGetEntityRenderObject(Object entity) {
		return base.superRenderManagerGetEntityRenderObject(entity);
	}

	@Override
	public Object renderManagerInstance() {
		return base.superRenderManagerInstance();
	}

	@Override
	public Object renderManagerItemRenderer() {
		return base.superRenderManagerItemRenderer();
	}

	@Override
	public void renderManagerItemRendererRenderItem(Object entity, Object itemstack, Object o) {
		base.superRenderManagerItemRendererRenderItem(entity, itemstack, o);
	}

	@Override
	public void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		base.superRenderManagerItemRendererRenderItem(itemRenderer, entity, itemstack, o);
	}

	@Override
	public boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return base.superRenderManagerRenderEntityWithPosYaw(entity, d, d2, d3, f, f2);
	}

	@Override
	public Object renderRenderBlocks(Object pRender) {
		return base.superRenderRenderBlocks(pRender);
	}

	@Override
	public Object renderRenderManager(Object render) {
		return base.superRenderRenderManager(render);
	}

	@Override
	public Object renderRenderManagerRenderEngine(Object render) {
		return base.superRenderRenderManagerRenderEngine(render);
	}

	@Override
	public void renderSetRenderManager(Object render) {
		base.superRenderSetRenderManager(render);
	}

	@Override
	public InputStream resourceGetInputStream(Object resource) {
		return base.superResourceGetInputStream(resource);
	}

	@Override
	public Object resourceManagerGetResource(Object o) {
		return base.superResourceManagerGetResource(o);
	}

	@Override
	public Object resourceManagerGetResource(Object resourceManager, Object o) {
		return base.superResourceManagerGetResource(resourceManager, o);
	}

	@Override
	public InputStream resourceManagerInputStream(Object o) {
		return base.superResourceManagerInputStream(o);
	}

	@Override
	public String resourceLocationGetResourceDomain(Object resourceLocation) {
		return base.superResourceLocationGetResourceDomain(resourceLocation);
	}

	@Override
	public String resourceLocationGetResourcePath(Object resourceLocation) {
		return base.superResourceLocationGetResourcePath(resourceLocation);
	}

	@Override
	public void setArmorRendering(Object model, boolean b) {
		base.superSetArmorRendering(model, b);
	}

	@Override
	public void setEntityEntityID(Object entity, int i) {
		base.superSetEntityEntityID(entity, i);
	}

	@Override
	public void setEntityFoodStats(Object entityplayer, Object entityGetFoodStats) {
		base.superSetEntityFoodStats(entityplayer, entityGetFoodStats);
	}

	@Override
	public void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		base.superSetEntityLivingBaseDeathTime(entityLivingBase, i);
	}

	@Override
	public void setEntityLivingBaseHealth(Object entity, float f) {
		base.superSetEntityLivingBaseHealth(entity, f);
	}

	@Override
	public void setEntityMotionX(Object entity, double d) {
		base.superSetEntityMotionX(entity, d);
	}

	@Override
	public void setEntityMotionY(Object entity, double d) {
		base.superSetEntityMotionY(entity, d);
	}

	@Override
	public void setEntityMotionZ(Object entity, double d) {
		base.superSetEntityMotionZ(entity, d);
	}

	@Override
	public void setEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		base.superSetEntityPlayerArmorInventory(entityplayer, armorInventory);
	}

	@Override
	public void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		base.superSetEntityPlayerCurrentXP(entityplayer, f);
	}

	@Override
	public void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		base.superSetEntityPlayerInventory(entityplayer, inventory);
	}

	@Override
	public void setEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		base.superSetEntityPlayerMainInventory(entityplayer, mainInventory);
	}

	@Override
	public void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		base.superSetEntityPlayerPlayerLevel(entityplayer, i);
	}

	@Override
	public void setEntityPlayerScore(Object entityplayer, int i) {
		base.superSetEntityPlayerScore(entityplayer, i);
	}

	@Override
	public void setEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		base.superSetEntityPlayerSPMovementInput(entityplayer, movementInput);
	}

	@Override
	public void setEntityPlayerTotalXP(Object entityplayer, int i) {
		base.superSetEntityPlayerTotalXP(entityplayer, i);
	}

	@Override
	public void setEntityPosX(Object entity, double d) {
		base.superSetEntityPosX(entity, d);
	}

	@Override
	public void setEntityPosY(Object entity, double d) {
		base.superSetEntityPosY(entity, d);
	}

	@Override
	public void setEntityPosZ(Object entity, double d) {
		base.superSetEntityPosZ(entity, d);
	}

	@Override
	public void setEntityRendererItemRenderer(Object itemRenderer) {
		base.superSetEntityRendererItemRenderer(itemRenderer);
	}

	@Override
	public void setEntityYOffset(Object entity, float f) {
		base.superSetEntityYOffset(entity, f);
	}

	@Override
	public void setGameSettingsKeyBindBack(Object keyBinding) {
		base.superSetGameSettingsKeyBindBack(keyBinding);
	}

	@Override
	public void setGameSettingsKeyBindForward(Object keyBinding) {
		base.superSetGameSettingsKeyBindForward(keyBinding);
	}

	@Override
	public void setGameSettingsKeyBindLeft(Object keyBinding) {
		base.superSetGameSettingsKeyBindLeft(keyBinding);
	}

	@Override
	public void setGameSettingsKeyBindRight(Object keyBinding) {
		base.superSetGameSettingsKeyBindRight(keyBinding);
	}

	@Override
	public void setGuiButtonEnabled(Object guiButton, boolean b) {
		base.superSetGuiButtonEnabled(guiButton, b);
	}

	@Override
	public void setGuiButtonID(Object guiButton, int i) {
		base.superSetGuiButtonID(guiButton, i);
	}

	@Override
	public void setGuiButtonVisible(Object guiButton, boolean b) {
		base.superSetGuiButtonVisible(guiButton, b);
	}

	@Override
	public void setGuiButtonXPosition(Object guiButton, int i) {
		base.superSetGuiButtonXPosition(guiButton, i);
	}

	@Override
	public void setGuiButtonYPosition(Object guiButton, int i) {
		base.superSetGuiButtonYPosition(guiButton, i);
	}

	@Override
	public void setGuiScreenButtonList(Object guiScreen, List list) {
		base.superSetGuiScreenButtonList(guiScreen, list);
	}

	@Override
	public void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		base.superSetGuiScreenFontRenderer(guiScreen, fontRenderer);
	}

	@Override
	public void setGuiScreenHeight(Object guiScreen, int i) {
		base.superSetGuiScreenHeight(guiScreen, i);
	}

	@Override
	public void setGuiScreenWidth(Object guiScreen, int i) {
		base.superSetGuiScreenWidth(guiScreen, i);
	}

	@Override
	public void setMinecraftDisplayGuiScreen(Object guiScreen) {
		base.superSetMinecraftDisplayGuiScreen(guiScreen);
	}

	@Override
	public void setMinecraftPlayerController(Object playerController) {
		base.superSetMinecraftPlayerController(playerController);
	}

	@Override
	public void setMinecraftRenderViewEntity(Object entity) {
		base.superSetMinecraftRenderViewEntity(entity);
	}

	@Override
	public void setMinecraftPlayer(Object entityPlayer) {
		base.superSetMinecraftPlayer(entityPlayer);
	}

	@Override
	public void setRender(Object model, Object render) {
		base.superSetRender(model, render);
	}

	@Override
	public void setRenderMainModel(Object render, Object model) {
		base.superSetRenderMainModel(render, model);
	}

	@Override
	public void setRenderManagerItemRenderer(Object itemRenderer) {
		base.superSetRenderManagerItemRenderer(itemRenderer);
	}

	@Override
	public boolean stringUtilsIsNullOrEmpty(String s) {
		return base.superStringUtilsIsNullOrEmpty(s);
	}

	@Override
	public Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return base.superServerConfigurationManagerRespawnPlayer(serverConfigurationManager, entityPlayerMP, i, b);
	}

	@Override
	public int scaledresolutionGetScaleFactor(Object scaledresolution) {
		return base.superScaledresolutionGetScaleFactor(scaledresolution);
	}

	@Override
	public int scaledresolutionGetScaledWidth(Object scaledresolution) {
		return base.superScaledresolutionGetScaledWidth(scaledresolution);
	}

	@Override
	public int scaledresolutionGetScaledHeight(Object scaledresolution) {
		return base.superScaledresolutionGetScaledHeight(scaledresolution);
	}

	@Override
	public Object slotGetStack(Object slot) {
		return base.superSlotGetStack(slot);
	}

	@Override
	public Object sharedMonsterAttributesAttackDamage() {
		return base.superSharedMonsterAttributesAttackDamage();
	}

	@Override
	public void framebufferBindFramebuffer(Object framebuffer, boolean b) {
		base.superFramebufferBindFramebuffer(framebuffer, b);
	}

	@Override
	public void framebufferUnbindFramebuffer(Object framebuffer) {
		base.superFramebufferUnbindFramebuffer(framebuffer);
	}

	@Override
	public void framebufferFramebufferRender(Object framebuffer, int i, int i1) {
		base.superFramebufferFramebufferRender(framebuffer, i, i1);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		base.superTessellatorAddVertex(tessellator, d, d2, d3);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		base.superTessellatorAddVertex(tessellator, d, d2, d3, i, i1, i2, i3);
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		base.superTessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5);
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		base.superTessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, f, f1, f2);
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		base.superTessellatorAddVertexWithUV(tessellator, d, d2, d3, d4, d5, i, i1, i2, i3);
	}

	@Override
	public void tessellatorDraw(Object tessellator) {
		base.superTessellatorDraw(tessellator);
	}

	@Override
	public Object tessellatorInstance() {
		return base.superTessellatorInstance();
	}

	@Override
	public void tessellatorSetColorOpaque_I(int i) {
		base.superTessellatorSetColorOpaque_I(i);
	}

	@Override
	public void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		base.superTessellatorSetColorOpaque_I(tessellator, i);
	}

	@Override
	public void tessellatorSetColorOpaque_F(float f, float f1, float f2) {
		base.superTessellatorSetColorOpaque_F(f, f1, f2);
	}

	@Override
	public void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		base.superTessellatorSetColorOpaque_F(tessellator, f, f1, f2);
	}

	@Override
	public void tessellatorSetBrightness(Object tessellator, int i) {
		base.superTessellatorSetBrightness(tessellator, i);
	}

	@Override
	public void tessellatorSetColorRGBA_I(int i, int i2) {
		base.superTessellatorSetColorRGBA_I(i, i2);
	}

	@Override
	public void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		base.superTessellatorSetColorRGBA_I(tessellator, i, i2);
	}

	@Override
	public void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		base.superTessellatorSetNormal(tessellator, f, f2, f3);
	}

	@Override
	public void tessellatorStartDrawing(Object tessellator, int i) {
		base.superTessellatorStartDrawing(tessellator, i);
	}

	@Override
	public void tessellatorStartDrawing(Object tessellator, int i, Object vertexFormat) {
		base.superTessellatorStartDrawing(tessellator, i, vertexFormat);
	}

	@Override
	public void tessellatorStartDrawingQuads() {
		base.superTessellatorStartDrawingQuads();
	}

	@Override
	public void tessellatorStartDrawingQuads(Object tessellator) {
		base.superTessellatorStartDrawingQuads(tessellator);
	}

	@Override
	public void tessellatorStartDrawingQuads(Object tessellator, int i, Object vertexFormat) {
		base.superTessellatorStartDrawingQuads(tessellator, i, vertexFormat);
	}

	@Override
	public void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		base.superTexturedQuadDraw(texturedQuad, tessellator, f);
	}

	@Override
	public void textureManagerBindTexture(Object o) {
		base.superTextureManagerBindTexture(o);
	}

	@Override
	public void textureManagerBindTexture(Object textureManager, Object o) {
		base.superTextureManagerBindTexture(textureManager, o);
	}

	@Override
	public Object textureManagerGetResourceLocation(int i) {
		return base.superTextureManagerGetResourceLocation(i);
	}

	@Override
	public Object textureManagerGetResourceLocation(Object textureManager, int i) {
		return base.superTextureManagerGetResourceLocation(textureManager, i);
	}

	@Override
	public Object textureManagerGetTexture(Object o) {
		return base.superTextureManagerGetTexture(o);
	}

	@Override
	public Object textureManagerGetTexture(Object textureManager, Object o) {
		return base.superTextureManagerGetTexture(textureManager, o);
	}

	@Override
	public Object textureMapLocationBlocksTexture() {
		return base.superTextureMapLocationBlocksTexture();
	}

	@Override
	public int textureOffsetTextureOffsetX(Object textureOffset) {
		return base.superTextureOffsetTextureOffsetX(textureOffset);
	}

	@Override
	public int textureOffsetTextureOffsetY(Object textureOffset) {
		return base.superTextureOffsetTextureOffsetY(textureOffset);
	}

	@Override
	public void textureUtilBindTexture(int i) {
		base.superTextureUtilBindTexture(i);
	}

	@Override
	public int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return base.superTextureUtilUploadTextureImage(i, bufferedimage);
	}

	@Override
	public int textureUtilAnaglyphColor(int i) {
		return base.superTextureUtilAnaglyphColor(i);
	}

	@Override
	public boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return base.superThreadDownloadImageDataIsTextureUploaded(threadDownloadImageData);
	}

	@Override
	public int threadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return base.superThreadDownloadImageDataGetGlTextureId(threadDownloadImageData);
	}

	@Override
	public Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return base.superVec3CreateVectorHelper(d, d2, d3);
	}

	@Override
	public Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return base.superVec3CrossProduct(vec3, vec3_2);
	}

	@Override
	public Object vec3Normalize(Object vec3) {
		return base.superVec3Normalize(vec3);
	}

	@Override
	public Object vec3Subtract(Object vec3, Object vec3_2) {
		return base.superVec3Subtract(vec3, vec3_2);
	}

	@Override
	public double vec3XCoord(Object vec3) {
		return base.superVec3XCoord(vec3);
	}

	@Override
	public double vec3YCoord(Object vec3) {
		return base.superVec3YCoord(vec3);
	}

	@Override
	public double vec3ZCoord(Object vec3) {
		return base.superVec3ZCoord(vec3);
	}

	@Override
	public double vec3SquareDistanceTo(Object vec3, Object vec3_2) {
		return base.superVec3SquareDistanceTo(vec3, vec3_2);
	}

	@Override
	public Object vec3AddVector(Object vec3, double d, double d2, double d3) {
		return base.superVec3AddVector(vec3, d, d2, d3);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(double d, double d2, double d3) {
		return base.superWorldCanBlockSeeTheSky(d, d2, d3);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(int i, int i2, int i3) {
		return base.superWorldCanBlockSeeTheSky(i, i2, i3);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return base.superWorldCanBlockSeeTheSky(worldOrEntity, d, d2, d3);
	}

	@Override
	public boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return base.superWorldCanBlockSeeTheSky(worldOrEntity, i, i2, i3);
	}

	@Override
	public List worldGetEntitiesWithinAABBExcludingEntity(Object entity, Object axisAlignedBB) {
		return base.superWorldGetEntitiesWithinAABBExcludingEntity(entity, axisAlignedBB);
	}

	@Override
	public List worldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return base.superWorldGetEntitiesWithinAABBExcludingEntity(worldOrEntity, entity, axisAlignedBB);
	}

	@Override
	public Object worldGetWorldInfo() {
		return base.superWorldGetWorldInfo();
	}

	@Override
	public void worldRemoveEntity(Object world, Object entity) {
		base.superWorldRemoveEntity(world, entity);
	}

	@Override
	public Object worldGetBlock(int i, int i2, int i3) {
		return base.superWorldGetBlock(i, i2, i3);
	}

	@Override
	public Object worldGetBlock(Object world, int i, int i2, int i3) {
		return base.superWorldGetBlock(world, i, i2, i3);
	}

	@Override
	public Enum worldGetWorldInfoGetGameType() {
		return base.superWorldGetWorldInfoGetGameType();
	}

	@Override
	public Enum worldSettingsGameTypeNOT_SET() {
		return base.superWorldSettingsGameTypeNOT_SET();
	}

	@Override
	public Enum worldSettingsGameTypeSURVIVAL() {
		return base.superWorldSettingsGameTypeSURVIVAL();
	}

	@Override
	public Enum worldSettingsGameTypeCREATIVE() {
		return base.superWorldSettingsGameTypeCREATIVE();
	}

	@Override
	public Enum worldSettingsGameTypeADVENTURE() {
		return base.superWorldSettingsGameTypeADVENTURE();
	}

	@Override
	public boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return base.superWorldIsAirBlock(worldOrEntity, i, j, k);
	}

	@Override
	public boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return base.superWorldIsBlockNormalCubeDefault(worldOrEntity, i, j, k, b);
	}

	@Override
	public boolean worldIsDaytime(Object worldOrEntity) {
		return base.superWorldIsDaytime(worldOrEntity);
	}

	@Override
	public boolean worldIsRemote(Object worldOrEntity) {
		return base.superWorldIsRemote(worldOrEntity);
	}

	@Override
	public List playerEntities(Object worldOrEntity) {
		return base.superPlayerEntities(worldOrEntity);
	}

	@Override
	public List worldPlayerEntities(Object worldOrEntity) {
		return base.superWorldPlayerEntities(worldOrEntity);
	}

	@Override
	public List worldWeatherEffects(Object worldOrEntity) {
		return base.superWorldWeatherEffects(worldOrEntity);
	}

	@Override
	public void worldSetEntityDead(Object worldOrEntity, Object entity) {
		base.superWorldSetEntityDead(worldOrEntity, entity);
	}

	@Override
	public void worldSpawnPlayerWithLoadedChunks(Object entity) {
		base.superWorldSpawnPlayerWithLoadedChunks(entity);
	}

	@Override
	public Object worldRand(Object worldOrEntity) {
		return base.superWorldRand(worldOrEntity);
	}

	@Override
	public void worldSpawnPlayerWithLoadedChunks(Object worldOrEntity, Object entity) {
		base.superWorldSpawnPlayerWithLoadedChunks(worldOrEntity, entity);
	}

	@Override
	public void worldSpawnParticle(Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		base.superWorldSpawnParticle(stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	@Override
	public void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		base.superWorldSpawnParticle(worldOrEntity, stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	@Override
	public void worldPlaySoundAtEntity(Object worldOrEntity, Object entity, Object soundEventOrString, float f, float f1) {
		base.superWorldPlaySoundAtEntity(worldOrEntity, entity, soundEventOrString, f, f1);
	}

	@Override
	public boolean worldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		return base.superWorldIsBlockModifiable(worldOrEntity, entityPlayer, x, y, z);
	}

	@Override
	public void worldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		base.superWorldSetEntityState(worldOrEntity, entity, by);
	}

	@Override
	public Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return base.superWorldGetPathEntityToEntity(worldOrEntity, entity, entity2, f, b, b1, b2, b3);
	}

	@Override
	public List worldGetEntitiesWithinAABB(Object worldOrEntity, Class c, Object axisAlignedBB) {
		return base.superWorldGetEntitiesWithinAABB(worldOrEntity, c, axisAlignedBB);
	}

	@Override
	public List worldLoadedEntityList(Object worldOrEntity) {
		return base.superWorldLoadedEntityList(worldOrEntity);
	}

	@Override
	public Object worldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return base.superWorldGetClosestPlayerToEntity(worldOrEntity, entity, d);
	}

	@Override
	public Object worldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return base.superWorldGetPlayerEntityByName(worldOrEntity, s);
	}

	@Override
	public Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return base.superWorldGetBiomeGenForCoords(worldOrInt, blockPosOrInt);
	}

	@Override
	public Object worldGetBiomeGenForCoords(Object worldOrEntity, int i, int i1) {
		return base.superWorldGetBiomeGenForCoords(worldOrEntity, i, i1);
	}

	@Override
	public boolean worldSpawnEntity(Object worldOrEntity, Object entity) {
		return base.superWorldSpawnEntity(worldOrEntity, entity);
	}

	@Override
	public void worldClientAddEntityToWorld(Object worldClient, int i, Object entity) {
		base.superWorldClientAddEntityToWorld(worldClient, i, entity);
	}

	@Override
	public int worldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		return base.superWorldGetBlockStateGetBlockMetadata(worldOrEntity, x, y, z);
	}

	@Override
	public int worldGetBlockLightValue(Object worldOrEntity, int x, int y, int z) {
		return base.superWorldGetBlockLightValue(worldOrEntity, x, y, z);
	}

	@Override
	public int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return base.superWorldGetStrongPower(worldOrEntity, x, y, z);
	}

	@Override
	public int tileEntityXCoord(Object tileEntity) {
		return base.superTileEntityXCoord(tileEntity);
	}

	@Override
	public int tileEntityYCoord(Object tileEntity) {
		return base.superTileEntityYCoord(tileEntity);
	}

	@Override
	public int tileEntityZCoord(Object tileEntity) {
		return base.superTileEntityZCoord(tileEntity);
	}

	@Override
	public Object newBlockPos(Object x, Object y, Object z) {
		return base.superNewBlockPos(x, y, z);
	}

	@Override
	public Object newModelResourceLocation(String s, String s1) {
		return base.superNewModelResourceLocation(s, s1);
	}

	@Override
	public Object worldGetBlockState(Object worldOrEntity, Object blockPos) {
		return base.superWorldGetBlockState(worldOrEntity, blockPos);
	}

	@Override
	public Object worldGetEntityByID(Object worldOrEntity, int i) {
		return base.superWorldGetEntityByID(worldOrEntity, i);
	}

	@Override
	public List modelRendererCubeList(Object modelRenderer) {
		return base.superModelRendererCubeList(modelRenderer);
	}

	@Override
	public void setModelRendererCubeList(Object modelRenderer, List list) {
		base.superSetModelRendererCubeList(modelRenderer, list);
	}

	@Override
	public List modelRendererChildModels(Object modelRenderer) {
		return base.superModelRendererChildModels(modelRenderer);
	}

	@Override
	public void setModelRendererChildModels(Object modelRenderer, List list) {
		base.superSetModelRendererChildModels(modelRenderer, list);
	}

	@Override
	public float modelRendererTextureWidth(Object modelRenderer) {
		return base.superModelRendererTextureWidth(modelRenderer);
	}

	@Override
	public void setModelRendererTextureWidth(Object modelRenderer, float f) {
		base.superSetModelRendererTextureWidth(modelRenderer, f);
	}

	@Override
	public float modelRendererTextureHeight(Object modelRenderer) {
		return base.superModelRendererTextureHeight(modelRenderer);
	}

	@Override
	public void setModelRendererTextureHeight(Object modelRenderer, float f) {
		base.superSetModelRendererTextureHeight(modelRenderer, f);
	}

	@Override
	public boolean entityLivingBaseIsSwingInProgress(Object entityLivingBase) {
		return base.superEntityLivingBaseIsSwingInProgress(entityLivingBase);
	}

	@Override
	public void setEntityLivingBaseIsSwingInProgress(Object entityLivingBase, boolean b) {
		base.superSetEntityLivingBaseIsSwingInProgress(entityLivingBase, b);
	}

	@Override
	public boolean entityIsBurning(Object entity) {
		return base.superEntityIsBurning(entity);
	}

	@Override
	public boolean entityIsSprinting(Object entity) {
		return base.superEntityIsSprinting(entity);
	}

	@Override
	public boolean entityLivingGetLeashed(Object entityLiving) {
		return base.superEntityLivingGetLeashed(entityLiving);
	}

	@Override
	public long worldInfoGetWorldTotalTime(Object entityOrWorldOrWorldInfo) {
		return base.superWorldInfoGetWorldTotalTime(entityOrWorldOrWorldInfo);
	}

	@Override
	public long worldInfoGetWorldTime(Object entityOrWorldOrWorldInfo) {
		return base.superWorldInfoGetWorldTime(entityOrWorldOrWorldInfo);
	}

	@Override
	public int worldGetMoonPhase(Object entityOrWorld) {
		return base.superWorldGetMoonPhase(entityOrWorld);
	}

	@Override
	public String entityListGetEntityString(Object entity) {
		return base.superEntityListGetEntityString(entity);
	}

	@Override
	public void entityLivingSetCurrentItemOrArmor(Object entityLiving, Object entityEquipmentSlotOrInt, Object itemStack) {
		base.superEntityLivingSetCurrentItemOrArmor(entityLiving, entityEquipmentSlotOrInt, itemStack);
	}

	@Override
	public void entitySetVelocity(Object entityLiving, double d, double d1, double d2) {
		base.superEntitySetVelocity(entityLiving, d, d1, d2);
	}

	@Override
	public void entitySetSneaking(Object entityLiving, boolean b) {
		base.superEntitySetSneaking(entityLiving, b);
	}

	@Override
	public void openGlHelperSetLightmapTextureCoords(int i, float f, float f1) {
		base.superOpenGlHelperSetLightmapTextureCoords(i, f, f1);
	}

	@Override
	public void entityTameableSetTamed(Object entityTameable, boolean b) {
		base.superEntityTameableSetTamed(entityTameable, b);
	}

	@Override
	public void entityAgeableSetGrowingAge(Object entityTameable, int i) {
		base.superEntityAgeableSetGrowingAge(entityTameable, i);
	}

	@Override
	public String chatAllowedCharactersFilterAllowedCharacters(String s) {
		return base.superChatAllowedCharactersFilterAllowedCharacters(s);
	}

	@Override
	public String itemGetUnlocalizedName(Object item) {
		return base.superItemGetUnlocalizedName(item);
	}

	@Override
	public int entityLivingBaseAttackTime(Object entity) {
		return base.superEntityLivingBaseAttackTime(entity);
	}

	@Override
	public void setEntityLivingBaseAttackTime(Object entityLivingBase, int i) {
		base.superSetEntityLivingBaseAttackTime(entityLivingBase, i);
	}

	@Override
	public void setEntityPlayerCapabilitiesIsCreativeMode(Object entityplayer, boolean b) {
		base.superSetEntityPlayerCapabilitiesIsCreativeMode(entityplayer, b);
	}

	@Override
	public void setEntityPlayerInventoryCurrentItem(Object entityplayer, int i) {
		base.superSetEntityPlayerInventoryCurrentItem(entityplayer, i);
	}

	@Override
	public void guiSlotHandleMouseInput(Object guiSlot) {
		base.superGuiSlotHandleMouseInput(guiSlot);
	}

	@Override
	public void worldPlaySoundAtEntity(Object worldOrEntity, Object entityPlayer, double x, double y, double z, Object soundEvent, Object soundCategory, float f, float f1) {
		base.superWorldPlaySoundAtEntity(worldOrEntity, entityPlayer, x, y, z, soundEvent, soundCategory, f, f1);
	}

	@Override
	public Object newDataParameter(Class c, Class[] c1, int i) {
		return base.superNewDataParameter(c, c1, i);
	}

	@Override
	public Object newSoundEvent(Object resourceLocationOrString) {
		return base.superNewSoundEvent(resourceLocationOrString);
	}

	@Override
	public Object newResourceLocation(String s) {
		return base.superNewResourceLocation(s);
	}

}
