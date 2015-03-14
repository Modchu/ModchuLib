package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityPlayerMasterBasis implements Modchu_IEntityPlayerMaster {
	public Modchu_IEntityPlayer base;

	public Modchu_EntityPlayerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityPlayer) map.get("base");
	}

	@Override
	public void init() {
	}

	@Override
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		base.superwakeUpPlayer(flag, flag1, flag2);
	}

	@Override
	public void preparePlayerToSpawn() {
		base.superpreparePlayerToSpawn();
	}

	@Override
	public void setPositionCorrection(double par1, double par3, double par5) {
		base.supersetPositionCorrection(par1, par3, par5);
	}

	@Override
	public void onLivingUpdate() {
		base.superonLivingUpdate();
	}

	@Override
	public void moveEntityWithHeading(float f, float f1) {
		base.supermoveEntityWithHeading(f, f1);
	}

	@Override
	public String getHurtSound() {
		return base.supergetHurtSound();
	}

	@Override
	public Object getCreatureAttribute() {
		return base.supergetCreatureAttribute();
	}

	@Override
	public double getMountedYOffset() {
		return base.supergetMountedYOffset();
	}

	@Override
	public void resetHeight() {
		base.superresetHeight();
	}

	@Override
	public double getYOffset() {
		return base.supergetYOffset();
	}

	@Override
	public boolean pushOutOfBlocks(double d, double d1, double d2) {
		return base.superpushOutOfBlocks(d, d1, d2);
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return base.superisEntityInsideOpaqueBlock();
	}

	@Override
	public Object copyPlayer(Object entityplayer) {
		return base.supercopyPlayer(entityplayer);
	}

	@Override
	public Object copyInventory(Object inventoryplayer) {
		return base.supercopyInventory(inventoryplayer);
	}

	@Override
	public void setSize(float f, float f1) {
		base.supersetSize(f, f1);
	}

	@Override
	public void updateRidden() {
		base.superupdateRidden();
	}

	@Override
	public boolean attackEntityFrom(Object var1, Object damageSource, int i) {
		return base.superattackEntityFrom(var1, damageSource, i);
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, int i) {
		return base.superattackEntityFrom(damageSource, i);
	}

	@Override
	public void onDeath(Object damageSource) {
		base.superonDeath(damageSource);
	}

	@Override
	public void sendMotionUpdates() {
		base.supersendMotionUpdates();
	}

	@Override
	public float getMaxHealth() {
		return base.supergetMaxHealth();
	}

	@Override
	public int getMaxHealthInt() {
		return base.supergetMaxHealthInt();
	}

	@Override
	public float getHealth() {
		return base.supergetHealth();
	}

	@Override
	public int getHealthInt() {
		return base.supergetHealthInt();
	}

	@Override
	public void setHealth(float f) {
		base.supersetHealth(f);
	}

	@Override
	public void setHealthInt(int i) {
		base.supersetHealthInt(i);
	}
}