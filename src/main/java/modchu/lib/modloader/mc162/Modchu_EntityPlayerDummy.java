package modchu.lib.modloader.mc162;import java.util.HashMap;import modchu.lib.Modchu_CastHelper;import modchu.lib.Modchu_IEntityPlayerDummyMaster;import modchu.lib.Modchu_IEntityPlayerDummy;import modchu.lib.Modchu_Main;import net.minecraft.src.DamageSource;import net.minecraft.src.Entity;import net.minecraft.src.EntityLiving;import net.minecraft.src.EntityPlayer;import net.minecraft.src.EnumCreatureAttribute;import net.minecraft.src.InventoryPlayer;import net.minecraft.src.ItemStack;import net.minecraft.src.NBTTagCompound;import net.minecraft.src.SharedMonsterAttributes;import net.minecraft.src.World;public class Modchu_EntityPlayerDummy extends EntityLiving implements Modchu_IEntityPlayerDummy {	public Modchu_IEntityPlayerDummyMaster master;	public Modchu_EntityPlayerDummy(HashMap<String, Object> map) {		super((World)map.get("Object"));		map.put("base", this);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.mDebug("Modchu_EntityPlayerDummy instance="+instance);		master = instance != null				&& instance instanceof Modchu_IEntityPlayerDummyMaster ? (Modchu_IEntityPlayerDummyMaster) instance : null;		init();	}	public void setMaxHealth(double d) {		if (master != null) func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(master.setMaxHealth(d));	}	@Override	public void supersetMaxHealth(double d) {		func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(d);	}	public void setMaxHealth(float f) {		if (master != null) func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(master.setMaxHealth(f));	}	@Override	public void supersetMaxHealth(float f) {		func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(Modchu_CastHelper.Double(""+f));	}	public void setMaxHealth(int i) {		if (master != null) func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(master.setMaxHealth(i));	}	@Override	public void supersetMaxHealth(int i) {		func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(i);	}	@Override	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {	}	@Override	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {	}	@Override	public float getShadowSize() {		return master.getShadowSize();	}	public void init() {		if (master != null) master.init();	}	@Override	public void preparePlayerToSpawn() {		super.preparePlayerToSpawn();		if (master != null) master.preparePlayerToSpawn();	}	@Override	public void onLivingUpdate() {		if (master != null				&& master.onLivingUpdate()) super.onLivingUpdate();	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) master.moveEntityWithHeading(f, f1);		else super.moveEntityWithHeading(f, f1);	}	@Override	public void superMoveEntityWithHeading(float f, float f1) {		super.moveEntityWithHeading(f, f1);	}	@Override	public String getHurtSound() {		if (master != null) return (String) master.getHurtSound();		return super.getHurtSound();	}	@Override	public EnumCreatureAttribute getCreatureAttribute() {		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();		return super.getCreatureAttribute();	}	@Override	public EnumCreatureAttribute supergetCreatureAttribute() {		return super.getCreatureAttribute();	}	@Override	protected void setSize(float f, float f1) {		if (master != null) {			float[] f2 = master.setSize(f, f1);			super.setSize(f2[0], f2[1]);		}	}	@Override	public void supersetSize(float f, float f1) {		super.setSize(f, f1);	}	@Override	public double getMountedYOffset() {		if (master != null) return master.getMountedYOffset();		return super.getMountedYOffset();	}	@Override	public double getYOffset() {		if (master != null) return master.getYOffset();		return super.getYOffset();	}	@Override	public boolean pushOutOfBlocks(double d, double d1, double d2) {		if (master != null) return master.pushOutOfBlocks(d, d1, d2);		return super.pushOutOfBlocks(d, d1, d2);	}	@Override	public boolean superpushOutOfBlocks(double d, double d1, double d2) {		return super.pushOutOfBlocks(d, d1, d2);	}	@Override	public boolean isEntityInsideOpaqueBlock() {		if (master != null) return master.isEntityInsideOpaqueBlock();		return super.isEntityInsideOpaqueBlock();	}	public void copyPlayer(EntityPlayer entityplayer) {		if (master != null) master.copyPlayer(entityplayer);	}	@Override	public void supercopyPlayer(Object entityplayer) {		//super.copyPlayer(entityplayer);	}	public void copyInventory(InventoryPlayer inventoryplayer) {		if (master != null) master.copyInventory(inventoryplayer);	}	public void publicResetHeight() {		if (master != null) master.resetHeight();	}	public void publicSetSize(float f, float f1) {		if (master != null) master.setSize(f, f1);	}	@Override	public void updateRidden() {		if (master != null) master.updateRidden();	}	@Override	public void superupdateRidden() {		super.updateRidden();	}	public boolean attackEntityFrom(Entity var1, DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;	}	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;	}	@Override	public boolean superattackEntityFrom(Object damageSource, int par2) {		return super.attackEntityFrom((DamageSource) damageSource, par2);	}	@Override	public void onDeath(DamageSource damageSource) {		if (master != null) master.onDeath(damageSource);	}	@Override	public void superonDeath(Object damageSource) {		super.onDeath((DamageSource) damageSource);	}/*	public float getMaxHealth() {		return master != null ? master.getMaxHealth() : super.getMaxHealth();	}*/	public float getEntityHealth() {		return master != null ? master.getHealth() : super.func_110143_aJ();	}	public void setEntityHealth(float f) {		if (master != null) master.setHealth(f);	}	@Override	public ItemStack getHeldItem() {		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());	}	@Override	public ItemStack superGetHeldItem() {		return super.getHeldItem();	}	@Override	public ItemStack getCurrentItemOrArmor(int i) {		return (ItemStack) (master != null ? master.getItemStackFromSlot(i) : super.getCurrentItemOrArmor(i));	}	@Override	public ItemStack superGetItemStackFromSlot(int i) {		return super.getCurrentItemOrArmor(i);	}	@Override	public ItemStack func_130225_q(int i) {		return (ItemStack) (master != null ? master.getCurrentArmor(i) : super.func_130225_q(i));	}	@Override	public ItemStack superFunc_130225_q(int i) {		return super.func_130225_q(i);	}	@Override	public void setCurrentItemOrArmor(int i, ItemStack itemStack) {		if (master != null) master.setCurrentItemOrArmor(i, itemStack);		else super.setCurrentItemOrArmor(i, itemStack);	}	@Override	public void superSetCurrentItemOrArmor(int i, Object itemStack) {		super.setCurrentItemOrArmor(i, (ItemStack) itemStack);	}	@Override	public ItemStack[] getLastActiveItems() {		return (ItemStack[]) (master != null ? master.getInventory() : super.getLastActiveItems());	}	public ItemStack[] superGetLastActiveItems() {		return super.getLastActiveItems();	}	@Override	public Object[] superGetInventory() {		return super.getLastActiveItems();	}}