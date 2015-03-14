package modchu.lib.forge.mc172_179;import java.util.HashMap;import modchu.lib.Modchu_IEntityLivingMaster;import modchu.lib.Modchu_IEntityPlayerDummy;import modchu.lib.Modchu_Main;import net.minecraft.entity.Entity;import net.minecraft.entity.EntityLiving;import net.minecraft.entity.EnumCreatureAttribute;import net.minecraft.entity.SharedMonsterAttributes;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.entity.player.InventoryPlayer;import net.minecraft.item.ItemStack;import net.minecraft.nbt.NBTTagCompound;import net.minecraft.util.DamageSource;import net.minecraft.world.World;public class Modchu_EntityPlayerDummy extends EntityLiving implements Modchu_IEntityPlayerDummy {	public Modchu_IEntityLivingMaster master;	public Modchu_EntityPlayerDummy(HashMap<String, Object> map) {		super((World)map.get("Object"));		map.put("base", this);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.mDebug("Modchu_EntityPlayerDummy instance="+instance);		master = instance != null				&& instance instanceof Modchu_IEntityLivingMaster ? (Modchu_IEntityLivingMaster) instance : null;		init();	}	public void setMaxHealth(double d) {		if (master != null) getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(master.setMaxHealth(d));	}	public void supersetMaxHealth(double d) {		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d);	}	public void setMaxHealth(float f) {		if (master != null) getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(master.setMaxHealth(f));	}	public void supersetMaxHealth(float f) {		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Double.valueOf(""+f));	}	public void setMaxHealth(int i) {		if (master != null) getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(master.setMaxHealth(i));	}	public void supersetMaxHealth(int i) {		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double) i);	}	@Override	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {	}	@Override	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {	}	@Override	public float getShadowSize() {		return master.getShadowSize();	}	public void init() {		if (master != null) master.init();	}	@Override	public void preparePlayerToSpawn() {		super.preparePlayerToSpawn();		if (master != null) master.preparePlayerToSpawn();	}	@Override	public void onLivingUpdate() {		if (master != null				&& master.onLivingUpdate()) super.onLivingUpdate();	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) {			float[] f2 = master.moveEntityWithHeading(f, f1);			super.moveEntityWithHeading(f2[0], f2[1]);		} else {			super.moveEntityWithHeading(f, f1);		}	}	@Override	public String getHurtSound() {		if (master != null) return master.getHurtSound();		return super.getHurtSound();	}	@Override	public EnumCreatureAttribute getCreatureAttribute() {		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();		return super.getCreatureAttribute();	}	public EnumCreatureAttribute supergetCreatureAttribute() {		return super.getCreatureAttribute();	}	@Override	protected void setSize(float f, float f1) {		if (master != null) {			float[] f2 = master.setSize(f, f1);			super.setSize(f2[0], f2[1]);		}	}	public void supersetSize(float f, float f1) {		super.setSize(f, f1);	}	@Override	public double getMountedYOffset() {		if (master != null) return master.getMountedYOffset();		return super.getMountedYOffset();	}	@Override	public double getYOffset() {		if (master != null) return master.getYOffset();		return super.getYOffset();	}	@Override	public boolean func_145771_j(double d, double d1, double d2) {		if (master != null) return master.pushOutOfBlocks(d, d1, d2);		return super.func_145771_j(d, d1, d2);	}	public boolean superpushOutOfBlocks(double d, double d1, double d2) {		return super.func_145771_j(d, d1, d2);	}	@Override	public boolean isEntityInsideOpaqueBlock() {		if (master != null) return master.isEntityInsideOpaqueBlock();		return super.isEntityInsideOpaqueBlock();	}	public void copyPlayer(EntityPlayer entityplayer) {		if (master != null) master.copyPlayer(entityplayer);	}	public void supercopyPlayer(EntityPlayer entityplayer) {		//super.copyPlayer(entityplayer);	}	public void copyInventory(InventoryPlayer inventoryplayer) {		if (master != null) master.copyInventory(inventoryplayer);	}	public void publicResetHeight() {		if (master != null) master.resetHeight();	}	public void publicSetSize(float f, float f1) {		if (master != null) master.setSize(f, f1);	}	@Override	public void updateRidden() {		if (master != null) master.updateRidden();	}	public void superupdateRidden() {		super.updateRidden();	}	public boolean attackEntityFrom(Entity var1, DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;	}	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;	}	public boolean superattackEntityFrom(DamageSource par1DamageSource, int par2) {		return super.attackEntityFrom(par1DamageSource, par2);	}	@Override	public void onDeath(DamageSource par1DamageSource) {		if (master != null) master.onDeath(par1DamageSource);	}	public void superonDeath(DamageSource par1DamageSource) {		super.onDeath(par1DamageSource);	}	@Override	public void setHealth(float f) {		if (master != null) master.setHealth((int) f);	}/*	public float getMaxHealth() {		return master != null ? master.getMaxHealth() : super.getMaxHealth();	}*/	public float getEntityHealth() {		return master != null ? master.getHealth() : super.getHealth();	}	public void setEntityHealth(float f) {		if (master != null) master.setHealth(f);	}	public ItemStack getHeldItem() {		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());	}	public ItemStack superGetHeldItem() {		return super.getHeldItem();	}	public ItemStack getEquipmentInSlot(int i) {		return (ItemStack) (master != null ? master.getEquipmentInSlot(i) : super.getEquipmentInSlot(i));	}	public ItemStack superGetEquipmentInSlot(int i) {		return super.getEquipmentInSlot(i);	}	public ItemStack func_130225_q(int i) {		return (ItemStack) (master != null ? master.getCurrentArmor(i) : super.func_130225_q(i));	}	public ItemStack superGetCurrentArmor(int i) {		return super.func_130225_q(i);	}	public void setCurrentItemOrArmor(int i, ItemStack itemStack) {		if (master != null) master.setCurrentItemOrArmor(i, itemStack);		else super.setCurrentItemOrArmor(i, itemStack);	}	public void superSetCurrentItemOrArmor(int i, ItemStack itemStack) {		super.setCurrentItemOrArmor(i, itemStack);	}	public ItemStack[] getInventory() {		return (ItemStack[]) (master != null ? master.getInventory() : super.getLastActiveItems());	}	public ItemStack[] superGetLastActiveItems() {		return super.getLastActiveItems();	}	@Override	public void supercopyPlayer(Object entityplayer) {		//super.copyPlayer(entityplayer);	}	@Override	public boolean superattackEntityFrom(Object damageSource, int par2) {		return super.attackEntityFrom((DamageSource) damageSource, par2);	}	@Override	public void superonDeath(Object damageSource) {		super.onDeath((DamageSource) damageSource);	}	@Override	public Object superFunc_130225_q(int i) {		return super.func_130225_q(i);	}	@Override	public void superSetCurrentItemOrArmor(int i, Object itemStack) {		super.setCurrentItemOrArmor(i, (ItemStack) itemStack);	}	@Override	public Object[] superGetInventory() {		return super.getLastActiveItems();	}}