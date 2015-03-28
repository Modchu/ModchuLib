package modchu.lib.modloader.mc152;import java.util.HashMap;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IEntityPlayer;import modchu.lib.Modchu_IEntityPlayerMaster;import modchu.lib.Modchu_Main;import net.minecraft.client.Minecraft;import net.minecraft.src.DamageSource;import net.minecraft.src.Entity;import net.minecraft.src.EntityClientPlayerMP;import net.minecraft.src.EntityPlayer;import net.minecraft.src.EnumCreatureAttribute;import net.minecraft.src.InventoryPlayer;import net.minecraft.src.NetClientHandler;import net.minecraft.src.Session;import net.minecraft.src.World;public class Modchu_EntityPlayerSP extends EntityClientPlayerMP implements Modchu_IEntityPlayer {	public static Modchu_IEntityPlayerMaster master;	public boolean initFlag;	public Modchu_EntityPlayerSP(HashMap<String, Object> map) {		super((Minecraft)map.get("Object"), (World)map.get("Object1"), (Session)map.get("Object2"), (NetClientHandler)map.get("Object3"));		map.put("base", this);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.lDebug("Modchu_EntityPlayerSP init instance="+instance);		master = instance != null				&& instance instanceof Modchu_IEntityPlayerMaster ? (Modchu_IEntityPlayerMaster) instance : null;		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityPlayerSP init master == null !!");	}	@Override	public void init() {		if (master != null) master.init();		initFlag = true;	}	@Override	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {		super.wakeUpPlayer(flag, flag1, flag2);		if (master != null) master.wakeUpPlayer(flag, flag1, flag2);	}	@Override	public void preparePlayerToSpawn() {		super.preparePlayerToSpawn();		if (master != null) master.preparePlayerToSpawn();	}	@Override	public void setPositionCorrection(double par1, double par3, double par5) {		if (master != null) master.setPositionCorrection(par1, par3, par5);	}	@Override	public void onLivingUpdate() {		if (master != null) master.onLivingUpdate();		super.onLivingUpdate();	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) master.moveEntityWithHeading(f, f1);		super.moveEntityWithHeading(f, f1);	}	@Override	public String getHurtSound() {		Modchu_Debug.mDebug("Modchu_EntityPlayerSP getHurtSound");		if (master != null) return master.getHurtSound();		return super.getHurtSound();	}	@Override	public EnumCreatureAttribute getCreatureAttribute() {		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();		return super.getCreatureAttribute();	}	@Override	public EnumCreatureAttribute supergetCreatureAttribute() {		return super.getCreatureAttribute();	}	@Override	protected void setSize(float f, float f1) {		if (master != null) master.setSize(f, f1);	}	@Override	public void supersetSize(float f, float f1) {		super.setSize(f, f1);	}	@Override	public double getMountedYOffset() {		if (master != null) return master.getMountedYOffset();		return super.getMountedYOffset();	}	@Override	protected void resetHeight() {		if (master != null) master.resetHeight();	}	@Override	public double getYOffset() {		if (master != null) return master.getYOffset();		return super.getYOffset();	}	@Override	public boolean pushOutOfBlocks(double d, double d1, double d2) {		if (master != null) return master.pushOutOfBlocks(d, d1, d2);		return super.pushOutOfBlocks(d, d1, d2);	}	@Override	public boolean superpushOutOfBlocks(double d, double d1, double d2) {		return super.pushOutOfBlocks(d, d1, d2);	}	@Override	public boolean isEntityInsideOpaqueBlock() {		if (master != null) return master.isEntityInsideOpaqueBlock();		return super.isEntityInsideOpaqueBlock();	}	public void copyPlayer(EntityPlayer entityplayer) {		if (master != null) master.copyPlayer(entityplayer);	}	public void supercopyPlayer(EntityPlayer entityplayer) {		//super.copyPlayer(entityplayer);	}	public void copyInventory(InventoryPlayer inventoryplayer) {		if (master != null) master.copyInventory(inventoryplayer);	}	@Override	public void publicResetHeight() {		if (master != null) master.resetHeight();	}	@Override	public void publicSetSize(float f, float f1) {		if (master != null) master.setSize(f, f1);	}	@Override	public void updateRidden() {		if (master != null) master.updateRidden();	}	@Override	public void superupdateRidden() {		super.updateRidden();	}	public boolean attackEntityFrom(Entity var1, DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;	}	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;	}	public boolean superattackEntityFrom(DamageSource par1DamageSource, int par2) {		return super.attackEntityFrom(par1DamageSource, par2);	}	@Override	public void onDeath(DamageSource par1DamageSource) {		if (master != null) master.onDeath(par1DamageSource);	}	@Override	public void superonDeath(Object par1DamageSource) {		super.onDeath((DamageSource) par1DamageSource);	}	@Override	public void setHealth(int i) {		if (master != null) master.setHealth(i);	}	@Override	public void sendMotionUpdates() {		if (master != null) master.sendMotionUpdates();	}	@Override	public void supersendMotionUpdates() {		super.sendMotionUpdates();	}/*	public float getMaxHealth() {		return master != null ? master.getMaxHealth() : super.getMaxHealth();	}*/	public float getEntityHealth() {		return master != null ? master.getHealth() : super.getHealth();	}	public void setEntityHealth(float f) {		if (master != null) master.setHealth(f);	}	@Override	public Object supercopyPlayer(Object entityplayer) {		return null;	}	@Override	public boolean superattackEntityFrom(Object damageSource, int par2) {		return super.attackEntityFrom((DamageSource) damageSource, par2);	}	@Override	public void superwakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {		super.wakeUpPlayer(flag, flag1, flag2);	}	@Override	public void superpreparePlayerToSpawn() {		super.preparePlayerToSpawn();	}	@Override	public void supersetPositionCorrection(double par1, double par3, double par5) {	}	@Override	public void superonLivingUpdate() {		super.onLivingUpdate();	}	@Override	public void supermoveEntityWithHeading(float f, float f1) {		super.moveEntityWithHeading(f, f1);	}	@Override	public String supergetHurtSound() {		return super.getHurtSound();	}	@Override	public double supergetMountedYOffset() {		return super.getMountedYOffset();	}	@Override	public void superresetHeight() {		super.resetHeight();	}	@Override	public double supergetYOffset() {		return super.getYOffset();	}	@Override	public boolean superisEntityInsideOpaqueBlock() {		return super.isEntityInsideOpaqueBlock();	}	@Override	public Object supercopyInventory(Object inventoryplayer) {		return null;	}	@Override	public boolean superattackEntityFrom(Object entity, Object damageSource, int i) {		return super.attackEntityFrom((DamageSource) damageSource, i);	}	@Override	public float supergetMaxHealth() {		return super.getMaxHealth();	}	@Override	public int supergetMaxHealthInt() {		return (int) super.getMaxHealth();	}	@Override	public float supergetHealth() {		return super.getHealth();	}	@Override	public int supergetHealthInt() {		return (int) super.getHealth();	}	@Override	public void supersetHealth(float f) {		super.setHealth((int) f);	}	@Override	public void supersetHealthInt(int i) {		super.setHealth(i);	}}