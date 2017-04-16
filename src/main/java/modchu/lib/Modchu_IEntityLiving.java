package modchu.lib;

public interface Modchu_IEntityLiving extends Modchu_IEntityLivingBase {
	public boolean superIsOnLivingUpdateCancel();
	public boolean isOnLivingUpdateCancel();

	public Object superGetLookHelper();
	public Object superGetMoveHelper();
	public Object superGetJumpHelper();
	public Object superGetNavigator();
	public Object superGetEntitySenses();
	public Object superGetAttackTarget();
	public void superSetAttackTarget(Object entityLivingBase);
	public boolean superCanAttackClass(Class par1Class);
	public void superEatGrassBonus();
	public int superGetTalkInterval();
	public void superPlayLivingSound();
	public void superSpawnExplosionParticle();
	public Object superGetAmbientSound();
	public int superGetDropItemId();
	public void superSetMoveForward(float par1);
	public boolean superCanDespawn();
	public void superDespawnEntity();
	public int superGetVerticalFaceSpeed();
	public void superFaceEntity(Object entity, float par2, float par3);
	public boolean superGetCanSpawnHere();
	public float superGetRenderSizeModifier();
	public int superGetMaxSpawnedInChunk();
	public void superEnchantEquipment();
	public Object superOnSpawnWithEgg(Object entityLivingData);
	public boolean superCanBeSteered();
	public void superEnablePersistence();
	public void superSetCustomNameTag(String par1Str);
	public String superGetCustomNameTag();
	public boolean superHasCustomNameTag();
	public void superSetAlwaysRenderNameTag(boolean par1);
	public boolean superGetAlwaysRenderNameTag();
	public boolean superCanPickUpLoot();
	public void superSetCanPickUpLoot(boolean par1);
	public boolean superIsNoDespawnRequired();
	public boolean superInteract(Object entityPlayer);
	public void superUpdateLeashedState();
	public void superClearLeashed(boolean par1, boolean par2);
	public boolean superAllowLeashing();
	public boolean superGetLeashed();
	public Object superGetLeashedToEntity();
	public void superSetLeashedToEntity(Object entity, boolean par2);
	public void superSetDropChance(Object entityEquipmentSlotOrInt, float par2);

}
