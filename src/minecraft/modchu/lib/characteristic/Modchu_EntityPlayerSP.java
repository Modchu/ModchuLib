package modchu.lib.characteristic;import modchu.lib.Modchu_IEntityPlayerMaster;import modchu.pflm.PFLM_EntityPlayerMaster;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.EntityClientPlayerMP;import net.minecraft.client.multiplayer.NetClientHandler;import net.minecraft.entity.Entity;import net.minecraft.entity.EnumCreatureAttribute;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.entity.player.InventoryPlayer;import net.minecraft.util.DamageSource;import net.minecraft.util.Session;import net.minecraft.world.World;public class Modchu_EntityPlayerSP extends EntityClientPlayerMP {	public static Modchu_IEntityPlayerMaster master;	public boolean initFlag;	public Modchu_EntityPlayerSP(Minecraft par1Minecraft, World par2World, Session par3Session, NetClientHandler par4NetClientHandler) {		super(par1Minecraft, par2World, par3Session, par4NetClientHandler);		master = new PFLM_EntityPlayerMaster(this);	}	public void init() {		if (master != null) master.init();	}	@Override	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {		super.wakeUpPlayer(flag, flag1, flag2);		if (master != null) master.wakeUpPlayer(flag, flag1, flag2);	}	@Override	public void preparePlayerToSpawn() {		super.preparePlayerToSpawn();		if (master != null) master.preparePlayerToSpawn();	}	public void setPositionCorrection(double par1, double par3, double par5) {		if (master != null) master.setPositionCorrection(par1, par3, par5);	}	@Override	public void onLivingUpdate() {		if (master != null) master.onLivingUpdate();		super.onLivingUpdate();	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) master.moveEntityWithHeading(f, f1);		super.moveEntityWithHeading(f, f1);	}	@Override	public String getHurtSound() {		if (master != null) return master.getHurtSound();		return super.getHurtSound();	}	@Override	public EnumCreatureAttribute getCreatureAttribute() {		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();		return super.getCreatureAttribute();	}	public EnumCreatureAttribute supergetCreatureAttribute() {		return super.getCreatureAttribute();	}	@Override	protected void setSize(float f, float f1) {		if (master != null) master.setSize(f, f1);	}	protected void supersetSize(float f, float f1) {		super.setSize(f, f1);	}	@Override	public double getMountedYOffset() {		if (master != null) return master.getMountedYOffset();		return super.getMountedYOffset();	}	@Override	protected void resetHeight() {		if (master != null) master.resetHeight();	}	@Override	public double getYOffset() {		if (master != null) return master.getYOffset();		return super.getYOffset();	}	@Override	public boolean pushOutOfBlocks(double d, double d1, double d2) {		if (master != null) return master.pushOutOfBlocks(d, d1, d2);		return super.pushOutOfBlocks(d, d1, d2);	}	public boolean superpushOutOfBlocks(double d, double d1, double d2) {		return super.pushOutOfBlocks(d, d1, d2);	}	@Override	public boolean isEntityInsideOpaqueBlock() {		if (master != null) return master.isEntityInsideOpaqueBlock();		return super.isEntityInsideOpaqueBlock();	}	public void copyPlayer(EntityPlayer entityplayer) {		if (master != null) master.copyPlayer(entityplayer);	}	public void supercopyPlayer(EntityPlayer entityplayer) {		//super.copyPlayer(entityplayer);	}	public void copyInventory(InventoryPlayer inventoryplayer) {		if (master != null) master.copyInventory(inventoryplayer);	}	public void publicResetHeight() {		if (master != null) master.resetHeight();	}	public void publicSetSize(float f, float f1) {		if (master != null) master.setSize(f, f1);	}	@Override	public void updateRidden() {		if (master != null) master.updateRidden();	}	public void superupdateRidden() {		super.updateRidden();	}	public boolean attackEntityFrom(Entity var1, DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;	}	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;	}	public boolean superattackEntityFrom(DamageSource par1DamageSource, int par2) {		return super.attackEntityFrom(par1DamageSource, par2);	}	@Override	public void onDeath(DamageSource par1DamageSource) {		if (master != null) master.onDeath(par1DamageSource);	}	public void superonDeath(DamageSource par1DamageSource) {		super.onDeath(par1DamageSource);	}	@Override	public void setHealth(float f) {		if (master != null) master.setHealth((int) f);	}	@Override	public void sendMotionUpdates() {		if (master != null) master.sendMotionUpdates();	}	public void supersendMotionUpdates() {		super.sendMotionUpdates();	}/*	public float getMaxHealth() {		return master != null ? master.getMaxHealth() : super.getMaxHealth();	}*/	public float getEntityHealth() {		return master != null ? master.getHealth() : super.getHealth();	}	public void setEntityHealth(float f) {		if (master != null) master.setHealth(f);	}}