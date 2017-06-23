package modchu.lib.forge.mc190;

import java.util.HashMap;
import java.util.UUID;

import modchu.lib.Modchu_IParticle;
import modchu.lib.Modchu_IParticleMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_Particle extends EntityFX implements Modchu_IParticle {
	public Modchu_IParticleMaster master;

	public Modchu_Particle(HashMap<String, Object> map) {
		super((World) map.get("Object"), (Double) (map.containsKey("spawnX") ? map.get("spawnX") : map.get("Double")), (Double) (map.containsKey("spawnY") ? map.get("spawnY") : map.get("Double1")), (Double) (map.containsKey("spawnZ") ? map.get("spawnZ") : map.get("Double2")), (Double) (map.containsKey("spawnX") ? map.get("Double") : map.get("Double3")), (Double) (map.containsKey("spawnY") ? map.get("Double1") : map.get("Double4")), (Double) (map.containsKey("spawnZ") ? map.get("Double2") : map.get("Double5")));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IParticleMaster ? (Modchu_IParticleMaster) instance : null;
	}

	@Override
	public EntityFX multiplyVelocity(float par1) {
		return (EntityFX) (master != null ? master.multiplyVelocity(par1) : super.multiplyVelocity(par1));
	}

	@Override
	public EntityFX superMultiplyVelocity(float par1) {
		return super.multiplyVelocity(par1);
	}

	@Override
	public EntityFX multipleParticleScaleBy(float par1) {
		return (EntityFX) (master != null ? master.multipleParticleScaleBy(par1) : super.multipleParticleScaleBy(par1));
	}

	@Override
	public EntityFX superMultipleParticleScaleBy(float par1) {
		return super.multipleParticleScaleBy(par1);
	}

	@Override
	public void setRBGColorF(float par1, float par2, float par3) {
		if (master != null) master.setRBGColorF(par1, par2, par3);
		else super.setRBGColorF(par1, par2, par3);
	}

	@Override
	public void superSetRBGColorF(float par1, float par2, float par3) {
		super.setRBGColorF(par1, par2, par3);
	}

	@Override
	public void setAlphaF(float par1) {
		if (master != null) master.setAlphaF(par1);
		else super.setAlphaF(par1);
	}

	@Override
	public void superSetAlphaF(float par1) {
		super.setAlphaF(par1);
	}

	@Override
	public float getRedColorF() {
		return master != null ? master.getRedColorF() : super.getRedColorF();
	}

	@Override
	public float superGetRedColorF() {
		return super.getRedColorF();
	}

	@Override
	public float getGreenColorF() {
		return master != null ? master.getGreenColorF() : super.getGreenColorF();
	}

	@Override
	public float superGetGreenColorF() {
		return super.getGreenColorF();
	}

	@Override
	public float getBlueColorF() {
		return master != null ? master.getBlueColorF() : super.getBlueColorF();
	}

	@Override
	public float superGetBlueColorF() {
		return super.getBlueColorF();
	}

	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	public int getFXLayer() {
		return master != null ? master.getFXLayer() : super.getFXLayer();
	}

	@Override
	public int superGetFXLayer() {
		return super.getFXLayer();
	}

	@Override
	public void setParticleTextureIndex(int par1) {
		if (master != null) master.setParticleTextureIndex(par1);
		else super.setParticleTextureIndex(par1);
	}

	@Override
	public void superSetParticleTextureIndex(int par1) {
		super.setParticleTextureIndex(par1);
	}

	@Override
	public void nextTextureIndexX() {
		if (master != null) master.nextTextureIndexX();
		else super.nextTextureIndexX();
	}

	@Override
	public void superNextTextureIndexX() {
		super.nextTextureIndexX();
	}

	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	@Override
	public String superToString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	@Override
	public boolean superEquals(Object par1Obj) {
		return super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	@Override
	public int superHashCode() {
		return super.hashCode();
	}

	@Override
	protected void setSize(float par1, float par2) {
		if (master != null) master.setSize(par1, par2);
		else super.setSize(par1, par2);
	}

	@Override
	public void superSetSize(float par1, float par2) {
		super.setSize(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	@Override
	public void superSetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.move(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMove(double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	@Override
	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}
	// TODO
	// 190~
	@Override
	public boolean func_187111_c() {
		return master != null ? master.shouldDisableDepth() : super.func_187111_c();
	}

	@Override
	public boolean superShouldDisableDepth() {
		return super.func_187111_c();
	}

	@Override
	public void setMaxAge(int p_187114_1_) {
		if (master != null) master.setMaxAge(p_187114_1_);
		else super.setMaxAge(p_187114_1_);
	}

	@Override
	public void superSetMaxAge(int p_187114_1_) {
		super.setMaxAge(p_187114_1_);
	}

	@Override
	public void setParticleTexture(TextureAtlasSprite textureAtlasSprite) {
		if (master != null) master.setParticleTexture(textureAtlasSprite);
		else super.setParticleTexture(textureAtlasSprite);
	}

	@Override
	public void superSetParticleTexture(Object textureAtlasSprite) {
		super.setParticleTexture((TextureAtlasSprite) textureAtlasSprite);
	}

	@Override
	public void setExpired() {
		if (master != null) master.setExpired();
		else super.setExpired();
	}

	@Override
	public void superSetExpired() {
		super.setExpired();
	}

	@Override
	protected void resetPositionToBB() {
		if (master != null) master.resetPositionToBB();
		else super.resetPositionToBB();
	}

	@Override
	public void superResetPositionToBB() {
		super.resetPositionToBB();
	}

	@Override
	public boolean isAlive() {
		return master != null ? master.isAlive() : super.isAlive();
	}

	@Override
	public boolean superIsAlive() {
		return super.isAlive();
	}

	@Override
	public AxisAlignedBB getEntityBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getEntityBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetBoundingBox() {
		return super.getEntityBoundingBox();
	}

	@Override
	public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
		if (master != null) master.setBoundingBox(axisAlignedBB);
		else super.setEntityBoundingBox(axisAlignedBB);
	}

	@Override
	public void superSetBoundingBox(Object axisAlignedBB) {
		super.setEntityBoundingBox((AxisAlignedBB) axisAlignedBB);
	}
	// ~164
	@Override
	public String superGetTranslatedEntityName() {
		return null;
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}

	@Override
	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}

	@Override
	public Object superDropItem(int par1, int par2) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	// ~172
	public int getEntityId() {
		return -1;
	}

	@Override
	public int superGetEntityId() {
		return -1;
	}

	public void setEntityId(int p_145769_1_) {
	}

	@Override
	public void superSetEntityId(int p_145769_1_) {
	}

	protected SoundEvent getSwimSound() {
		return null;
	}

	@Override
	public Object superGetSwimSound() {
		return null;
	}

	protected SoundEvent getSplashSound() {
		return null;
	}

	@Override
	public String superGetSplashSound() {
		return null;
	}

	public ITextComponent getDisplayName() {
		return null;
	}

	@Override
	public ITextComponent superGetDisplayName() {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(Object par1, int par2, float par3) {
		return null;
	}

	public void fall(float par1, float damageMultiplier) {
	}

	@Override
	public void superFall(float par1, float damageMultiplier) {
	}

	public ItemStack[] getInventory() {
		return null;
	}

	@Override
	public Object[] superGetInventory() {
		return null;
	}

	public boolean isEntityInvulnerable(DamageSource p_180431_1_) {
		return false;
	}

	@Override
	public boolean superIsEntityInvulnerable(Object p_180431_1_) {
		return false;
	}

	public void copyDataFromOld(Entity entity) {
	}

	@Override
	public void superCopyDataFromOld(Object entity) {
	}

	public int getMaxFallHeight() {
		return -1;
	}

	@Override
	public int superGetMaxFallHeight() {
		return -1;
	}

	protected void doBlockCollisions() {
	}

	@Override
	public void superDoBlockCollisions() {
	}

	protected void playStepSound(BlockPos blockPos, Block block) {
	}

	@Override
	public void superPlayStepSound(Object blockPos, Object par4) {
	}

	public EntityItem dropItemWithOffset(Item par1, int par2, float par3) {
		return null;
	}

	public EntityItem superDropItemWithOffset(Item par1, int par2, float par3) {
		return null;
	}

	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return false;
	}

	@Override
	public boolean superPushOutOfBlocks(double par1, double par3, double par5) {
		return false;
	}

	public String getName() {
		return null;
	}

	@Override
	public String superGetName() {
		return null;
	}

	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return 0.0F;
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0.0F;
	}
	// ~179
	@Override
	public void superUpdateFallState(double par1, boolean par3) {
	}

	@Override
	public void superFall(float par1) {
	}

	@Override
	public boolean superHandleLavaMovement() {
		return false;
	}

	@Override
	public float superGetShadowSize() {
		return height / 2.0F;
	}

	@Override
	public void superSetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	@Override
	public boolean superIsEntityInvulnerable() {
		return false;
	}

	public void superCopyDataFrom(Object entity, boolean par2) {
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return false;
	}

	@Override
	public void superRenderParticle(Object tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
	}

	@Override
	public void superCopyDataFromOld(Object entity, boolean par2) {
		superCopyDataFromOld(entity);
	}

	public AxisAlignedBB getCollisionBoundingBox() {
		return null;
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return null;
	}

	public void setPortal(BlockPos bockPos) {
	}

	@Override
	public void superSetPortal(Object bockPos) {
	}

	public Vec3d getTeleportDirection() {
		return null;
	}

	@Override
	public Object superGetTeleportDirection() {
		return null;
	}

	public void setParticleIcon(TextureAtlasSprite textureAtlasSprite) {
	}

	@Override
	public void superSetParticleIcon(Object textureAtlasSprite) {
	}

	@Override
	public void renderParticle(VertexBuffer tessellator, Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
	}

	@Override
	public void superRenderParticle(Object tessellator, Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
	}

	protected void updateFallState(double par1, boolean par3, Block block, BlockPos blockPos) {
	}

	@Override
	public void superUpdateFallState(double par1, boolean par3, Object block, Object blockPos) {
	}

	public void onDataWatcherUpdate(int p_145781_1_) {
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}

	public void setPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9, boolean b) {
	}

	@Override
	public void superSetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9, boolean b) {
	}

	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float par7) {
		return false;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float par7) {
		return false;
	}

	@Override
	public void superSetPortal() {
	}

	@Override
	public void superSetParticleIcon(Object renderEngine, Object icon) {
		superSetParticleIcon(icon);
	}
	// ~189
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean superCanTriggerWalking() {
		return false;
	}

	protected void entityInit() {
	}

	@Override
	public void superEntityInit() {
	}

	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
	}

	@Override
	public void superWriteEntityToNBT(Object nBTTagCompound) {
	}

	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
	}

	@Override
	public void superReadEntityFromNBT(Object nBTTagCompound) {
	}

	public boolean canAttackWithItem() {
		return false;
	}

	@Override
	public boolean superCanBeAttackedWithItem() {
		return false;
	}

	public Object getDataWatcher() {
		return null;
	}

	@Override
	public Object superGetDataWatcher() {
		return null;
	}

	protected void preparePlayerToSpawn() {
	}

	@Override
	public void superPreparePlayerToSpawn() {
	}

	public void setDead() {
	}

	@Override
	public void superSetDead() {
	}

	protected void setRotation(float par1, float par2) {
	}

	@Override
	public void superSetRotation(float par1, float par2) {
	}

	public void setAngles(float par1, float par2) {
	}

	@Override
	public void superSetAngles(float par1, float par2) {
	}

	public void onEntityUpdate() {
	}

	@Override
	public void superOnEntityUpdate() {
	}

	public int getMaxInPortalTime() {
		return -1;
	}

	@Override
	public int superGetMaxInPortalTime() {
		return -1;
	}

	protected void setOnFireFromLava() {
	}

	@Override
	public void superSetOnFireFromLava() {
	}

	public void setFire(int par1) {
	}

	@Override
	public void superSetFire(int par1) {
	}

	public void extinguish() {
	}

	@Override
	public void superExtinguish() {
	}

	protected void kill() {
	}

	@Override
	public void superKill() {
	}

	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return false;
	}

	@Override
	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return false;
	}


	public void playSound(String par1Str, float par2, float par3) {
	}

	@Override
	public void superPlaySound(String par1Str, float par2, float par3) {
	}

	protected void dealFireDamage(int par1) {
	}

	@Override
	public void superDealFireDamage(int par1) {
	}

	public boolean isWet() {
		return false;
	}

	@Override
	public boolean superIsWet() {
		return false;
	}

	public boolean isInWater() {
		return false;
	}

	@Override
	public boolean superIsInWater() {
		return false;
	}

	public boolean handleWaterMovement() {
		return false;
	}

	@Override
	public boolean superHandleWaterMovement() {
		return false;
	}

	public boolean isInsideOfMaterial(Material material) {
		return false;
	}

	@Override
	public boolean superIsInsideOfMaterial(Object material) {
		return false;
	}

	public float getEyeHeight() {
		return 0.0F;
	}

	@Override
	public float superGetEyeHeight() {
		return 0.0F;
	}

	public void moveFlying(float par1, float par2, float par3) {
	}

	@Override
	public void superMoveRelative(float par1, float par2, float par3) {
	}

	public float getBrightness(float par1) {
		return 0.0F;
	}

	@Override
	public float superGetBrightness(float par1) {
		return 0.0F;
	}

	public void setWorld(World world) {
	}

	@Override
	public void superSetWorld(Object world) {
	}

	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
	}

	@Override
	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
	}

	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
	}

	@Override
	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
	}

	public float getDistanceToEntity(Entity entity) {
		return 0.0F;
	}

	@Override
	public float superGetDistanceToEntity(Object entity) {
		return 0.0F;
	}

	public double getDistanceSq(double par1, double par3, double par5) {
		return 0.0D;
	}

	@Override
	public double superGetDistanceSq(double par1, double par3, double par5) {
		return 0.0D;
	}

	public double getDistance(double par1, double par3, double par5) {
		return 0.0D;
	}

	@Override
	public double superGetDistance(double par1, double par3, double par5) {
		return 0.0D;
	}

	public double getDistanceSqToEntity(Entity entity) {
		return 0.0D;
	}

	@Override
	public double superGetDistanceSqToEntity(Object entity) {
		return 0.0D;
	}

	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
	}

	@Override
	public void superOnCollideWithPlayer(Object entityPlayer) {
	}

	public void applyEntityCollision(Entity entity) {
	}

	@Override
	public void superApplyEntityCollision(Object entity) {
	}

	public void addVelocity(double par1, double par3, double par5) {
	}

	@Override
	public void superAddVelocity(double par1, double par3, double par5) {
	}

	protected void setBeenAttacked() {
	}

	@Override
	public void superSetBeenAttacked() {
	}

	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return false;
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return false;
	}

	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean superCanBeCollidedWith() {
		return false;
	}

	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean superCanBePushed() {
		return false;
	}

	public void addToPlayerScore(Entity entity, int par2) {
	}

	@Override
	public void superAddToPlayerScore(Object entity, int par2) {
	}

	public boolean isInRangeToRenderDist(double par1) {
		return false;
	}

	@Override
	public boolean superIsInRangeToRenderDist(double par1) {
		return false;
	}

	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return false;
	}

	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return false;
	}

	public void writeToNBT(NBTTagCompound nBTTagCompound) {
	}

	@Override
	public void superWriteToNBT(Object nBTTagCompound) {
	}

	public void readFromNBT(NBTTagCompound nBTTagCompound) {
	}

	@Override
	public void superReadFromNBT(Object nBTTagCompound) {
	}

	protected boolean shouldSetPosAfterLoading() {
		return false;
	}

	@Override
	public boolean superShouldSetPosAfterLoading() {
		return false;
	}

	public void onChunkLoad() {
	}

	@Override
	public void superOnChunkLoad() {
	}

	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return null;
	}

	@Override
	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return null;
	}

	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return null;
	}

	@Override
	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return null;
	}

	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return null;
	}

	@Override
	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return null;
	}

	public boolean isEntityAlive() {
		return false;
	}

	@Override
	public boolean superIsEntityAlive() {
		return false;
	}

	public boolean isEntityInsideOpaqueBlock() {
		return false;
	}

	@Override
	public boolean superIsEntityInsideOpaqueBlock() {
		return false;
	}

	public boolean interactFirst(EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return false;
	}

	public AxisAlignedBB getCollisionBox(Entity entity) {
		return null;
	}

	@Override
	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return null;
	}

	public void updateRidden() {
	}

	@Override
	public void superUpdateRidden() {
	}

	public void updateRiderPosition() {
	}

	@Override
	public void superUpdateRiderPosition() {
	}

	public double getYOffset() {
		return 0.0D;
	}

	@Override
	public double superGetYOffset() {
		return 0.0D;
	}

	public double getMountedYOffset() {
		return 0.0D;
	}

	@Override
	public double superGetMountedYOffset() {
		return 0.0D;
	}

	public void mountEntity(Entity entity) {
	}

	@Override
	public void superMountEntity(Object entity) {
	}

	public float getCollisionBorderSize() {
		return 0.0F;
	}

	@Override
	public float superGetCollisionBorderSize() {
		return 0.0F;
	}

	public Vec3d getLookVec() {
		return null;
	}

	@Override
	public Vec3d superGetLookVec() {
		return null;
	}

	public int getPortalCooldown() {
		return -1;
	}

	@Override
	public int superGetPortalCooldown() {
		return -1;
	}

	public void setVelocity(double par1, double par3, double par5) {
	}

	@Override
	public void superSetVelocity(double par1, double par3, double par5) {
	}

	public void handleStatusUpdate(byte par1) {
	}

	@Override
	public void superHandleStatusUpdate(byte par1) {
	}

	public void performHurtAnimation() {
	}

	@Override
	public void superPerformHurtAnimation() {
	}

	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
	}

	@Override
	public void superSetCurrentItemOrArmor(int par1, Object itemStack) {
	}

	public boolean isBurning() {
		return false;
	}

	@Override
	public boolean superIsBurning() {
		return false;
	}

	public boolean isRiding() {
		return false;
	}

	@Override
	public boolean superIsRiding() {
		return false;
	}

	public boolean isSneaking() {
		return false;
	}

	@Override
	public boolean superIsSneaking() {
		return false;
	}

	public void setSneaking(boolean par1) {
	}

	@Override
	public void superSetSneaking(boolean par1) {
	}

	public boolean isSprinting() {
		return false;
	}

	@Override
	public boolean superIsSprinting() {
		return false;
	}

	public void setSprinting(boolean par1) {
	}

	@Override
	public void superSetSprinting(boolean par1) {
	}

	public boolean isInvisible() {
		return false;
	}

	@Override
	public boolean superIsInvisible() {
		return false;
	}

	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return false;
	}

	public void setInvisible(boolean par1) {
	}

	@Override
	public void superSetInvisible(boolean par1) {
	}

	public boolean isEating() {
		return false;
	}

	@Override
	public boolean superIsEating() {
		return false;
	}

	public void setEating(boolean par1) {
	}

	@Override
	public void superSetEating(boolean par1) {
	}

	protected boolean getFlag(int par1) {
		return false;
	}

	@Override
	public boolean superGetFlag(int par1) {
		return false;
	}

	protected void setFlag(int par1, boolean par2) {
	}

	@Override
	public void superSetFlag(int par1, boolean par2) {
	}

	public int getAir() {
		return -1;
	}

	@Override
	public int superGetAir() {
		return -1;
	}

	public void setAir(int par1) {
	}

	@Override
	public void superSetAir(int par1) {
	}

	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
	}

	@Override
	public void superOnStruckByLightning(Object entityLightningBolt) {
	}

	public void onKillEntity(EntityLivingBase entityLivingBase) {
	}

	@Override
	public void superOnKillEntity(Object entityLivingBase) {
	}

	public void setInWeb() {
	}

	@Override
	public void superSetInWeb() {
	}

	public Entity[] getParts() {
		return null;
	}

	@Override
	public Entity[] superGetParts() {
		return null;
	}

	public boolean isEntityEqual(Entity entity) {
		return false;
	}

	@Override
	public boolean superIsEntityEqual(Object entity) {
		return false;
	}

	public float getRotationYawHead() {
		return 0.0F;
	}

	@Override
	public float superGetRotationYawHead() {
		return 0.0F;
	}

	public void setRotationYawHead(float par1) {
	}

	@Override
	public void superSetRotationYawHead(float par1) {
	}

	public boolean hitByEntity(Entity entity) {
		return false;
	}

	@Override
	public boolean superHitByEntity(Object entity) {
		return false;
	}

	public void copyLocationAndAnglesFrom(Entity entity) {
	}

	@Override
	public void superCopyLocationAndAnglesFrom(Object entity) {
	}

	public void travelToDimension(int par1) {
	}

	@Override
	public void superTravelToDimension(int par1) {
	}

	public boolean doesEntityNotTriggerPressurePlate() {
		return false;
	}

	@Override
	public boolean superDoesEntityNotTriggerPressurePlate() {
		return false;
	}

	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
	}

	@Override
	public void superAddEntityCrashInfo(Object crashReportCategory) {
	}

	public boolean canRenderOnFire() {
		return false;
	}

	@Override
	public boolean superCanRenderOnFire() {
		return false;
	}

	public UUID getUniqueID() {
		return null;
	}

	@Override
	public UUID superGetUniqueID() {
		return null;
	}

	public boolean isPushedByWater() {
		return false;
	}

	@Override
	public boolean superIsPushedByWater() {
		return false;
	}

	public NBTTagCompound getEntityData() {
		return null;
	}

	@Override
	public NBTTagCompound superGetEntityData() {
		return null;
	}

	public boolean shouldRiderSit() {
		return false;
	}

	@Override
	public boolean superShouldRiderSit() {
		return false;
	}

	public ItemStack getPickedResult(RayTraceResult rayTraceResult) {
		return null;
	}

	@Override
	public ItemStack superGetPickedResult(Object rayTraceResult) {
		return null;
	}

	public UUID getPersistentID() {
		return null;
	}

	@Override
	public UUID superGetPersistentID() {
		return null;
	}

	public boolean shouldRenderInPass(int pass) {
		return false;
	}

	@Override
	public boolean superShouldRenderInPass(int pass) {
		return false;
	}

	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	@Override
	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	@Override
	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	public Object getExtendedProperties(String identifier) {
		return null;
	}

	@Override
	public Object superGetExtendedProperties(String identifier) {
		return null;
	}

	public boolean canRiderInteract() {
		return false;
	}

	@Override
	public boolean superCanRiderInteract() {
		return false;
	}

	public boolean shouldDismountInWater(Entity entity) {
		return false;
	}

	@Override
	public boolean superShouldDismountInWater(Object entity) {
		return false;
	}

	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	@Override
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	public EntityItem dropItem(Item par1, int par2) {
		return null;
	}

	@Override
	public Object superDropItem(Object par1, int par2) {
		return null;
	}

	@Override
	public Object superGetEntityBoundingBox() {
		return super.getEntityBoundingBox();
	}

	@Override
	public void superSetEntityBoundingBox(Object axisAlignedBB) {
		super.setEntityBoundingBox((AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public String superGetTexture() {
		return null;
	}

	@Override
	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superAddEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public void superUnmountEntity(Object entity) {

	}

	@Override
	public void superUpdateCloak() {

	}

	@Override
	public float superGetAlpha() {
		return 0.0F;
	}

	@Override
	public void superOnKillCommand() {

	}

	@Override
	public boolean superIsSilent() {
		return false;
	}

	@Override
	public void superSetSilent(boolean isSilent) {

	}

	@Override
	public void superResetHeight() {

	}

	@Override
	public void superSpawnRunningParticles() {

	}

	@Override
	public void superCreateRunningParticles() {

	}

	@Override
	public boolean superIsInLava() {
		return false;
	}

	@Override
	public void superMoveToBlockPosAndAngles(Object blockPos, float rotationYawIn, float rotationPitchIn) {

	}

	@Override
	public double superGetDistanceSq(Object blockPos) {
		return 0.0D;
	}

	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0.0D;
	}

	@Override
	public Object superGetLook(float partialTicks) {
		return null;
	}

	@Override
	public Object superGetPositionEyes(float partialTicks) {
		return null;
	}

	@Override
	public Object superRayTrace(double blockReachDistance, float partialTicks) {
		return null;
	}

	@Override
	public void superFunc_181013_g(float p_181013_1_) {

	}

	@Override
	public Object superFunc_181012_aH() {
		return null;
	}

	@Override
	public void superSetCustomNameTag(String name) {

	}

	@Override
	public String superGetCustomNameTag() {
		return null;
	}

	@Override
	public boolean superHasCustomName() {
		return false;
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean alwaysRenderNameTag) {

	}

	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return false;
	}

	@Override
	public void superSetPositionAndUpdate(double x, double y, double z) {

	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
		return false;
	}

	@Override
	public Object superGetHorizontalFacing() {
		return null;
	}

	@Override
	public Object superGetHoverEvent() {
		return null;
	}

	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return false;
	}

	@Override
	public boolean superIsOutsideBorder() {
		return false;
	}

	@Override
	public void superSetOutsideBorder(boolean outsideBorder) {

	}

	@Override
	public boolean superReplaceItemInInventory(int inventorySlot, Object itemStack) {
		return false;
	}

	@Override
	public void superAddChatMessage(Object iChatComponent) {

	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return false;
	}

	@Override
	public Object superGetPosition() {
		return null;
	}

	@Override
	public Object superGetPositionVector() {
		return null;
	}

	@Override
	public Object superGetEntityWorld() {
		return null;
	}

	@Override
	public Object superGetCommandSenderEntity() {
		return null;
	}

	@Override
	public boolean superSendCommandFeedback() {
		return false;
	}

	@Override
	public void superSetCommandStat(Object type, int amount) {

	}

	@Override
	public Object superGetCommandStats() {
		return null;
	}

	@Override
	public void superFunc_174817_o(Object entity) {

	}

	@Override
	public Object superGetNBTTagCompound() {
		return null;
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {

	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public boolean superIsImmuneToExplosions() {
		return false;
	}

	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {

	}

	@Override
	public boolean superHasCapability(Object capability, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetCapability(Object capability, Object enumFacing) {
		return null;
	}

	@Override
	public void superDeserializeNBT(Object nBTTagCompound) {

	}

	@Override
	public Object superSerializeNBT() {
		return null;
	}

}
