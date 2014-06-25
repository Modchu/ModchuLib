package modchu.lib.characteristic;import modchu.lib.Modchu_IEntityLivingMaster;import modchu.lib.Modchu_Reflect;import modchu.lib.characteristic.recompileonly.Modchu_CastHelper;import net.minecraft.entity.Entity;import net.minecraft.entity.EntityLiving;import net.minecraft.entity.EnumCreatureAttribute;import net.minecraft.entity.SharedMonsterAttributes;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.entity.player.InventoryPlayer;import net.minecraft.nbt.NBTTagCompound;import net.minecraft.util.DamageSource;import net.minecraft.world.World;public class Modchu_EntityPlayerDummy extends EntityLiving {	public static Class masterClass;	public Modchu_IEntityLivingMaster master;	public Modchu_EntityPlayerDummy(World world) {		super(world);		Object instance = (Modchu_IEntityLivingMaster) Modchu_Reflect.newInstance(masterClass, new Class[]{ Object.class }, new Object[]{ world });		//Modchu_Debug.mDebug("Modchu_EntityPlayerDummy instance="+instance);		master = instance instanceof Modchu_IEntityLivingMaster ? (Modchu_IEntityLivingMaster) instance : null;		init();	}	public void setMaxHealth(double d) {		if (master != null) getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(master.setMaxHealth(d));	}	public void supersetMaxHealth(double d) {		getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(d);	}	public void setMaxHealth(float f) {		if (master != null) getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(master.setMaxHealth(f));	}	public void supersetMaxHealth(float f) {		getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(Modchu_CastHelper.Double(""+f));	}	public void setMaxHealth(int i) {		if (master != null) getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(master.setMaxHealth(i));	}	public void supersetMaxHealth(int i) {		getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute((double) i);	}	@Override	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {	}	@Override	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {	}	@Override	public float getShadowSize() {		return master.getShadowSize();	}	public void init() {		if (master != null) master.init();	}	@Override	public void preparePlayerToSpawn() {		super.preparePlayerToSpawn();		if (master != null) master.preparePlayerToSpawn();	}	@Override	public void onLivingUpdate() {		if (master != null				&& master.onLivingUpdate()) super.onLivingUpdate();	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) {			float[] f2 = master.moveEntityWithHeading(f, f1);			super.moveEntityWithHeading(f2[0], f2[1]);		} else {			super.moveEntityWithHeading(f, f1);		}	}	@Override	public String getHurtSound() {		if (master != null) return master.getHurtSound();		return super.getHurtSound();	}	@Override	public EnumCreatureAttribute getCreatureAttribute() {		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();		return super.getCreatureAttribute();	}	public EnumCreatureAttribute supergetCreatureAttribute() {		return super.getCreatureAttribute();	}	@Override	protected void setSize(float f, float f1) {		if (master != null) {			float[] f2 = master.setSize(f, f1);			super.setSize(f2[0], f2[1]);		}	}	protected void supersetSize(float f, float f1) {		super.setSize(f, f1);	}	@Override	public double getMountedYOffset() {		if (master != null) return master.getMountedYOffset();		return super.getMountedYOffset();	}	@Override	public double getYOffset() {		if (master != null) return master.getYOffset();		return super.getYOffset();	}	@Override	public boolean pushOutOfBlocks(double d, double d1, double d2) {		if (master != null) return master.pushOutOfBlocks(d, d1, d2);		return super.pushOutOfBlocks(d, d1, d2);	}	public boolean superpushOutOfBlocks(double d, double d1, double d2) {		return super.pushOutOfBlocks(d, d1, d2);	}	@Override	public boolean isEntityInsideOpaqueBlock() {		if (master != null) return master.isEntityInsideOpaqueBlock();		return super.isEntityInsideOpaqueBlock();	}	public void copyPlayer(EntityPlayer entityplayer) {		if (master != null) master.copyPlayer(entityplayer);	}	public void supercopyPlayer(EntityPlayer entityplayer) {		//super.copyPlayer(entityplayer);	}	public void copyInventory(InventoryPlayer inventoryplayer) {		if (master != null) master.copyInventory(inventoryplayer);	}	public void publicResetHeight() {		if (master != null) master.resetHeight();	}	public void publicSetSize(float f, float f1) {		if (master != null) master.setSize(f, f1);	}	@Override	public void updateRidden() {		if (master != null) master.updateRidden();	}	public void superupdateRidden() {		super.updateRidden();	}	public boolean attackEntityFrom(Entity var1, DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;	}	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;	}	public boolean superattackEntityFrom(DamageSource par1DamageSource, int par2) {		return super.attackEntityFrom(par1DamageSource, par2);	}	@Override	public void onDeath(DamageSource par1DamageSource) {		if (master != null) master.onDeath(par1DamageSource);	}	public void superonDeath(DamageSource par1DamageSource) {		super.onDeath(par1DamageSource);	}	@Override	public void setHealth(float f) {		if (master != null) master.setHealth((int) f);	}/*	public float getMaxHealth() {		return master != null ? master.getMaxHealth() : super.getMaxHealth();	}*/	public float getEntityHealth() {		return master != null ? master.getHealth() : super.getHealth();	}	public void setEntityHealth(float f) {		if (master != null) master.setHealth(f);	}}