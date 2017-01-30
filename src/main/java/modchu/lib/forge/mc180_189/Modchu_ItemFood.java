package modchu.lib.forge.mc180_189;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IItemFood;
import modchu.lib.Modchu_IItemFoodMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.google.common.collect.Multimap;

public class Modchu_ItemFood extends ItemFood implements Modchu_IItemFood {
	public Modchu_IItemFoodMaster master;

	public Modchu_ItemFood(HashMap<String, Object> map) {
		super((Integer)map.get("Integer"), (Float)map.get("Float"), (Boolean)map.get("boolean"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_ItemFood init instance="+instance);
		master = instance instanceof Modchu_IItemFoodMaster ? (Modchu_IItemFoodMaster) instance : null;
		Modchu_Debug.mDebug("Modchu_ItemFood init master="+master);
	}

	@Override
	public Item setMaxStackSize(int par1) {
		return (Item) (master != null ? master.setMaxStackSize(par1) : super.setMaxStackSize(par1));
	}

	@Override
	public Item superSetMaxStackSize(int par1) {
		return super.setMaxStackSize(par1);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, BlockPos blockPos, EnumFacing enumFacing, float f, float f1, float f2) {
		return master != null ? master.onItemUse(itemStack, entityPlayer, world, blockPos, enumFacing, f, f1, f2) : super.onItemUse(itemStack, entityPlayer, world, blockPos, enumFacing, f, f1, f2);
	}

	@Override
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float f, float f1, float f2) {
		return super.onItemUse((ItemStack) itemStack, (EntityPlayer) entityPlayer, (World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, f, f1, f2);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		return (ItemStack) (master != null ? master.onItemRightClick(itemStack, world, entityPlayer) : super.onItemRightClick(itemStack, world, entityPlayer));
	}

	@Override
	public ItemStack superOnItemRightClick(Object itemStack, Object world, Object entityPlayer) {
		return super.onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		return (ItemStack) (master != null ? master.onItemUseFinish(itemStack, world, entityPlayer) : super.onItemUseFinish(itemStack, world, entityPlayer));
	}

	@Override
	public ItemStack superOnItemUseFinish(Object itemStack, Object world, Object entityPlayer) {
		return super.onItemUseFinish((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public int getItemStackLimit() {
		return master != null ? master.getItemStackLimit() : super.getItemStackLimit();
	}

	@Override
	public int superGetItemStackLimit() {
		return super.getItemStackLimit();
	}

	@Override
	public int getMetadata(int par1) {
		return master != null ? master.getMetadata(par1) : super.getMetadata(par1);
	}

	@Override
	public int superGetMetadata(int par1) {
		return super.getMetadata(par1);
	}

	@Override
	public boolean getHasSubtypes() {
		return master != null ? master.getHasSubtypes() : super.getHasSubtypes();
	}

	@Override
	public boolean superGetHasSubtypes() {
		return super.getHasSubtypes();
	}

	@Override
	public Item setHasSubtypes(boolean par1) {
		return (Item) (master != null ? master.setHasSubtypes(par1) : super.setHasSubtypes(par1));
	}

	@Override
	public Item superSetHasSubtypes(boolean par1) {
		return super.setHasSubtypes(par1);
	}

	@Override
	public int getMaxDamage() {
		return master != null ? master.getMaxDamage() : super.getMaxDamage();
	}

	@Override
	public int superGetMaxDamage() {
		return super.getMaxDamage();
	}

	@Override
	public Item setMaxDamage(int par1) {
		return (Item) (master != null ? master.setMaxDamage(par1) : super.setMaxDamage(par1));
	}

	@Override
	public Item superSetMaxDamage(int par1) {
		return super.setMaxDamage(par1);
	}

	@Override
	public boolean isDamageable() {
		return master != null ? master.isDamageable() : super.isDamageable();
	}

	@Override
	public boolean superIsDamageable() {
		return super.isDamageable();
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.hitEntity(itemStack, entityLivingBase, entityLivingBase1) : super.hitEntity(itemStack, entityLivingBase, entityLivingBase1);
	}

	@Override
	public boolean superHitEntity(Object itemStack, Object entityLivingBase, Object entityLivingBase1) {
		return super.hitEntity((ItemStack) itemStack, (EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
		return master != null ? master.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase) : super.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase);
	}

	@Override
	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase) {
		return super.itemInteractionForEntity((ItemStack) itemStack, (EntityPlayer) entityPlayer, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public Item setFull3D() {
		return (Item) (master != null ? master.setFull3D() : super.setFull3D());
	}

	@Override
	public Item superSetFull3D() {
		return (super.setFull3D());
	}

	@Override
	public boolean isFull3D() {
		return master != null ? master.isFull3D() : super.isFull3D();
	}

	@Override
	public boolean superIsFull3D() {
		return super.isFull3D();
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return master != null ? master.shouldRotateAroundWhenRendering() : super.shouldRotateAroundWhenRendering();
	}

	@Override
	public boolean superShouldRotateAroundWhenRendering() {
		return super.shouldRotateAroundWhenRendering();
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		Modchu_Debug.mDebug("Modchu_Item setUnlocalizedName par1Str="+par1Str+" master="+master);
		return (Item) (master != null ? master.setUnlocalizedName(par1Str) : super.setUnlocalizedName(par1Str));
	}

	@Override
	public Item superSetUnlocalizedName(String par1Str) {
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	public String getUnlocalizedNameInefficiently(ItemStack itemStack) {
		return master != null ? master.getUnlocalizedNameInefficiently(itemStack) : super.getUnlocalizedNameInefficiently(itemStack);
	}

	@Override
	public String superGetUnlocalizedNameInefficiently(Object itemStack) {
		return super.getUnlocalizedNameInefficiently((ItemStack) itemStack);
	}

	@Override
	public String getUnlocalizedName() {
		return master != null ? master.getUnlocalizedName() : super.getUnlocalizedName();
	}

	@Override
	public String superGetUnlocalizedName() {
		return super.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return master != null ? master.getUnlocalizedName(itemStack) : super.getUnlocalizedName(itemStack);
	}

	@Override
	public String superGetUnlocalizedName(Object itemStack) {
		return super.getUnlocalizedName((ItemStack) itemStack);
	}

	@Override
	public Item setContainerItem(Item item) {
		return (Item) (master != null ? master.setContainerItem(item) : super.setContainerItem(item));
	}

	@Override
	public Item superSetContainerItem(Object item) {
		return super.setContainerItem((Item) item);
	}

	@Override
	public boolean getShareTag() {
		return master != null ? master.getShareTag() : super.getShareTag();
	}

	@Override
	public boolean superGetShareTag() {
		return super.getShareTag();
	}

	@Override
	public Item getContainerItem() {
		return (Item) (master != null ? master.getContainerItem() : super.getContainerItem());
	}

	@Override
	public Item superGetContainerItem() {
		return (super.getContainerItem());
	}

	@Override
	public boolean hasContainerItem() {
		return master != null ? master.hasContainerItem() : super.hasContainerItem();
	}

	@Override
	public boolean superHasContainerItem() {
		return super.hasContainerItem();
	}

	@Override
	public int getColorFromItemStack(ItemStack itemStack, int par2) {
		return master != null ? master.getColorFromItemStack(itemStack, par2) : super.getColorFromItemStack(itemStack, par2);
	}

	@Override
	public int superGetColorFromItemStack(Object itemStack, int par2) {
		return super.getColorFromItemStack((ItemStack) itemStack, par2);
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
		if (master != null) master.onUpdate(itemStack, world, entity, par4, par5);
		else super.onUpdate(itemStack, world, entity, par4, par5);
	}

	@Override
	public void superOnUpdate(Object itemStack, Object world, Object entity, int par4, boolean par5) {
		super.onUpdate((ItemStack) itemStack, (World) world, (Entity) entity, par4, par5);
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if (master != null) master.onCreated(itemStack, world, entityPlayer);
		else super.onCreated(itemStack, world, entityPlayer);
	}

	@Override
	public void superOnCreated(Object itemStack, Object world, Object entityPlayer) {
		super.onCreated((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isMap() {
		return master != null ? master.isMap() : super.isMap();
	}

	@Override
	public boolean superIsMap() {
		return super.isMap();
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		return (EnumAction) (master != null ? master.getItemUseAction(itemStack) : super.getItemUseAction(itemStack));
	}

	@Override
	public EnumAction superGetItemUseAction(Object itemStack) {
		return super.getItemUseAction((ItemStack) itemStack);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		return master != null ? master.getMaxItemUseDuration(itemStack) : super.getMaxItemUseDuration(itemStack);
	}

	@Override
	public int superGetMaxItemUseDuration(Object itemStack) {
		return super.getMaxItemUseDuration((ItemStack) itemStack);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int par4) {
		if (master != null) master.onPlayerStoppedUsing(itemStack, world, entityPlayer, par4);
		else super.onPlayerStoppedUsing(itemStack, world, entityPlayer, par4);
	}

	@Override
	public void superOnPlayerStoppedUsing(Object itemStack, Object world, Object entityPlayer, int par4) {
		super.onPlayerStoppedUsing((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer, par4);
	}

	@Override
	public Item setPotionEffect(String par1Str) {
		return (Item) (master != null ? master.setPotionEffect(par1Str) : super.setPotionEffect(par1Str));
	}

	@Override
	public Item superSetPotionEffect(String par1Str) {
		return super.setPotionEffect(par1Str);
	}

	@Override
	public String getPotionEffect(ItemStack itemStack) {
		return master != null ? master.getPotionEffect(itemStack) : super.getPotionEffect(itemStack);
	}

	@Override
	public String superGetPotionEffect(Object itemStack) {
		return super.getPotionEffect((ItemStack) itemStack);
	}

	@Override
	public boolean isPotionIngredient(ItemStack itemStack) {
		return master != null ? master.isPotionIngredient(itemStack) : super.isPotionIngredient(itemStack);
	}

	@Override
	public boolean superIsPotionIngredient(Object itemStack) {
		return super.isPotionIngredient((ItemStack) itemStack);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List par3List, boolean par4) {
		if (master != null) master.addInformation(itemStack, entityPlayer, par3List, par4);
		else super.addInformation(itemStack, entityPlayer, par3List, par4);
	}

	@Override
	public void superAddInformation(Object itemStack, Object entityPlayer, List par3List, boolean par4) {
		super.addInformation((ItemStack) itemStack, (EntityPlayer) entityPlayer, par3List, par4);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return master != null ? master.getItemStackDisplayName(itemStack) : super.getItemStackDisplayName(itemStack);
	}

	@Override
	public String superGetItemStackDisplayName(Object itemStack) {
		return super.getItemStackDisplayName((ItemStack) itemStack);
	}

	@Override
	public boolean hasEffect(ItemStack itemStack) {
		return master != null ? master.hasEffect(itemStack) : super.hasEffect(itemStack);
	}

	@Override
	public boolean superHasEffect(Object itemStack) {
		return super.hasEffect((ItemStack) itemStack);
	}

	@Override
	public EnumRarity getRarity(ItemStack itemStack) {
		return (EnumRarity) (master != null ? master.getRarity(itemStack) : super.getRarity(itemStack));
	}

	@Override
	public EnumRarity superGetRarity(Object itemStack) {
		return super.getRarity((ItemStack) itemStack);
	}

	@Override
	public boolean isItemTool(ItemStack itemStack) {
		return master != null ? master.isEnchantable(itemStack) : super.isItemTool(itemStack);
	}

	@Override
	public boolean superIsEnchantable(Object itemStack) {
		return super.isItemTool((ItemStack) itemStack);
	}

	@Override
	protected MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityPlayer entityPlayer, boolean par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(world, entityPlayer, par3) : super.getMovingObjectPositionFromPlayer(world, entityPlayer, par3));
	}

	@Override
	public MovingObjectPosition superRayTrace(Object world, Object entityPlayer, boolean par3) {
		return super.getMovingObjectPositionFromPlayer((World) world, (EntityPlayer) entityPlayer, par3);
	}

	@Override
	public int getItemEnchantability() {
		return master != null ? master.getItemEnchantability() : super.getItemEnchantability();
	}

	@Override
	public int superGetItemEnchantability() {
		return super.getItemEnchantability();
	}

	@Override
	public Item setCreativeTab(CreativeTabs creativeTabs) {
		return (Item) (master != null ? master.setCreativeTab(creativeTabs) : super.setCreativeTab(creativeTabs));
	}

	@Override
	public Item superSetCreativeTab(Object creativeTabs) {
		return super.setCreativeTab((CreativeTabs) creativeTabs);
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return (CreativeTabs) (master != null ? master.getCreativeTab() : super.getCreativeTab());
	}

	@Override
	public CreativeTabs superGetCreativeTab() {
		return (super.getCreativeTab());
	}

	@Override
	public boolean canItemEditBlocks() {
		return master != null ? master.canItemEditBlocks() : super.canItemEditBlocks();
	}

	@Override
	public boolean superCanItemEditBlocks() {
		return super.canItemEditBlocks();
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack1) {
		return master != null ? master.getIsRepairable(itemStack, itemStack1) : super.getIsRepairable(itemStack, itemStack1);
	}

	@Override
	public boolean superGetIsRepairable(Object itemStack, Object itemStack1) {
		return super.getIsRepairable((ItemStack) itemStack, (ItemStack) itemStack1);
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		return (Multimap) (master != null ? master.getItemAttributeModifiers() : super.getItemAttributeModifiers());
	}

	@Override
	public Multimap superGetItemAttributeModifiers() {
		return (super.getItemAttributeModifiers());
	}
	// ~164
	public boolean onBlockDestroyed(ItemStack itemStack, World world, int par3, int par4, int par5, int par6, EntityLivingBase entityLivingBase) {
		return false;
	}

	@Override
	public boolean superOnBlockDestroyed(Object itemStack, Object world, int par3, int par4, int par5, int par6, Object entityLivingBase) {
		return false;
	}

	public String getStatName() {
		return null;
	}

	@Override
	public String superGetStatName() {
		return null;
	}

	public String getPotionEffect() {
		return null;
	}

	@Override
	public String superGetPotionEffect() {
		return null;
	}

	public boolean isPotionIngredient() {
		return false;
	}

	@Override
	public boolean superIsPotionIngredient() {
		return false;
	}

	public String getItemDisplayName(ItemStack itemStack) {
		return null;
	}

	@Override
	public String superGetItemDisplayName(Object itemStack) {
		return null;
	}
/*
	public Icon getIconFromDamageForRenderPass(int par1, int par2) {
		return null;
	}

	public Icon superGetIconFromDamageForRenderPass(int par1, int par2) {
		return null;
	}
*/
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return false;
	}

	@Override
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return false;
	}

	public void getSubItems(int par1, CreativeTabs creativeTabs, List par3List) {
	}

	@Override
	public void superGetSubItems(int par1, Object creativeTabs, List par3List) {
	}

	//	public void registerIcons(IconRegister iconRegister) {
	public void registerIcons(Object iconRegister) {
	}
/*
	public void superRegisterIcons(Object iconRegister) {
	}
*/
	public float getStrVsBlock(ItemStack itemStack, Block block, int metadata) {
		return 0.0F;
	}

	@Override
	public float superGetStrVsBlock(Object itemStack, Object block, int metadata) {
		return 0.0F;
	}

	public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int count) {
	}

	@Override
	public void superOnUsingItemTick(Object itemStack, Object entityPlayer, int count) {
	}
/*
	public Icon getIcon(ItemStack itemStack, int renderPass, EntityPlayer entityPlayer, ItemStack itemStack1, int useRemaining) {
		return null;
	}

	public Icon superGetIcon(Object itemStack, int renderPass, Object entityPlayer, Object itemStack1, int useRemaining) {
		return null;
	}
*/
	public ItemStack getContainerItemStack(ItemStack itemStack) {
		return null;
	}

	@Override
	public ItemStack superGetContainerItemStack(Object itemStack) {
		return null;
	}
/*
	public Icon getIcon(ItemStack itemStack, int pass) {
		return null;
	}

	public Icon superGetIcon(Object itemStack, int pass) {
		return null;
	}
*/
	public boolean shouldPassSneakingClickToBlock(World world, int par4, int par5, int par6) {
		return false;
	}

	@Override
	public boolean superShouldPassSneakingClickToBlock(Object world, int par4, int par5, int par6) {
		return false;
	}

	public void onArmorTickUpdate(World world, EntityPlayer entityPlayer, ItemStack itemStack) {
	}

	@Override
	public void superOnArmorTickUpdate(Object world, Object entityPlayer, Object itemStack) {
	}

	public float getDamageVsEntity(Entity entity, ItemStack itemStack) {
		return 0.0F;
	}

	@Override
	public float superGetDamageVsEntity(Object entity, Object itemStack) {
		return 0.0F;
	}

	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, int layer) {
		return null;
	}

	@Override
	public String superGetArmorTexture(Object itemStack, Object entity, int slot, int layer) {
		return null;
	}
	// 172~

	@Override
	public boolean onDroppedByPlayer(ItemStack itemStack, EntityPlayer entityPlayer) {
		return master != null ? master.onDroppedByPlayer(itemStack, entityPlayer) : super.onDroppedByPlayer(itemStack, entityPlayer);
	}

	@Override
	public boolean superOnDroppedByPlayer(Object itemStack, Object entityPlayer) {
		return super.onDroppedByPlayer((ItemStack) itemStack, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, BlockPos blockPos, EnumFacing enumFacing, float hitX, float hitY, float hitZ) {
		return master != null ? master.onItemUseFirst(itemStack, entityPlayer, world, blockPos, enumFacing, hitX, hitY, hitZ) : super.onItemUseFirst(itemStack, entityPlayer, world, blockPos, enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ) {
		return super.onItemUseFirst((ItemStack) itemStack, (EntityPlayer) entityPlayer, (World) world, (BlockPos) blockPos, (EnumFacing) enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean isRepairable() {
		return master != null ? master.isRepairable() : super.isRepairable();
	}

	@Override
	public boolean superIsRepairable() {
		return super.isRepairable();
	}

	@Override
	public Item setNoRepair() {
		return (Item) (master != null ? master.setNoRepair() : super.setNoRepair());
	}

	@Override
	public Item superSetNoRepair() {
		return (super.setNoRepair());
	}

	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
		return master != null ? master.onLeftClickEntity(itemStack, entityPlayer, entity) : super.onLeftClickEntity(itemStack, entityPlayer, entity);
	}

	@Override
	public boolean superOnLeftClickEntity(Object itemStack, Object entityPlayer, Object entity) {
		return super.onLeftClickEntity((ItemStack) itemStack, (EntityPlayer) entityPlayer, (Entity) entity);
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return master != null ? master.getEntityLifespan(itemStack, world) : super.getEntityLifespan(itemStack, world);
	}

	@Override
	public int superGetEntityLifespan(Object itemStack, Object world) {
		return super.getEntityLifespan((ItemStack) itemStack, (World) world);
	}

	@Override
	public boolean hasCustomEntity(ItemStack itemStack) {
		return master != null ? master.hasCustomEntity(itemStack) : super.hasCustomEntity(itemStack);
	}

	@Override
	public boolean superHasCustomEntity(Object itemStack) {
		return super.hasCustomEntity((ItemStack) itemStack);
	}

	@Override
	public Entity createEntity(World world, Entity entity, ItemStack itemStack) {
		return (Entity) (master != null ? master.createEntity(world, entity, itemStack) : super.createEntity(world, entity, itemStack));
	}

	@Override
	public Entity superCreateEntity(Object world, Object entity, Object itemStack) {
		return super.createEntity((World) world, (Entity) entity, (ItemStack) itemStack);
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		return master != null ? master.onEntityItemUpdate(entityItem) : super.onEntityItemUpdate(entityItem);
	}

	@Override
	public boolean superOnEntityItemUpdate(Object entityItem) {
		return super.onEntityItemUpdate((EntityItem) entityItem);
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
		return (CreativeTabs[]) (master != null ? master.getCreativeTabs() : super.getCreativeTabs());
	}

	@Override
	public CreativeTabs[] superGetCreativeTabs() {
		return (super.getCreativeTabs());
	}

	@Override
	public float getSmeltingExperience(ItemStack itemStack) {
		return master != null ? master.getSmeltingExperience(itemStack) : super.getSmeltingExperience(itemStack);
	}

	@Override
	public float superGetSmeltingExperience(Object itemStack) {
		return super.getSmeltingExperience((ItemStack) itemStack);
	}

	@Override
	public WeightedRandomChestContent getChestGenBase(ChestGenHooks chestGenHooks, Random random, WeightedRandomChestContent weightedRandomChestContent) {
		return (WeightedRandomChestContent) (master != null ? master.getChestGenBase(chestGenHooks, random, weightedRandomChestContent) : super.getChestGenBase(chestGenHooks, random, weightedRandomChestContent));
	}

	@Override
	public WeightedRandomChestContent superGetChestGenBase(Object chestGenHooks, Object random, Object weightedRandomChestContent) {
		return super.getChestGenBase((ChestGenHooks) chestGenHooks, (Random) random, (WeightedRandomChestContent) weightedRandomChestContent);
	}

	@Override
	public boolean isValidArmor(ItemStack itemStack, int armorType, Entity entity) {
		return master != null ? master.isValidArmor(itemStack, armorType, entity) : super.isValidArmor(itemStack, armorType, entity);
	}

	@Override
	public boolean superIsValidArmor(Object itemStack, int armorType, Object entity) {
		return super.isValidArmor((ItemStack) itemStack, armorType, (Entity) entity);
	}

	@Override
	public boolean isBookEnchantable(ItemStack itemStack, ItemStack itemStack1) {
		return master != null ? master.isBookEnchantable(itemStack, itemStack1) : super.isBookEnchantable(itemStack, itemStack1);
	}

	@Override
	public boolean superIsBookEnchantable(Object itemStack, Object itemStack1) {
		return super.isBookEnchantable((ItemStack) itemStack, (ItemStack) itemStack1);
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		return master != null ? master.getArmorTexture(itemStack, entity, slot, type) : super.getArmorTexture(itemStack, entity, slot, type);
	}

	@Override
	public String superGetArmorTexture(Object itemStack, Object entity, int slot, String type) {
		return super.getArmorTexture((ItemStack) itemStack, (Entity) entity, slot, type);
	}

	@Override
	public FontRenderer getFontRenderer(ItemStack itemStack) {
		return (FontRenderer) (master != null ? master.getFontRenderer(itemStack) : super.getFontRenderer(itemStack));
	}

	@Override
	public FontRenderer superGetFontRenderer(Object itemStack) {
		return super.getFontRenderer((ItemStack) itemStack);
	}

	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLivingBase, ItemStack itemStack, int armorSlot) {
		return (ModelBiped) (master != null ? master.getArmorModel(entityLivingBase, itemStack, armorSlot) : super.getArmorModel(entityLivingBase, itemStack, armorSlot));
	}

	@Override
	public ModelBiped superGetArmorModel(Object entityLivingBase, Object itemStack, int armorSlot) {
		return super.getArmorModel((EntityLivingBase) entityLivingBase, (ItemStack) itemStack, armorSlot);
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLivingBase, ItemStack itemStack) {
		return master != null ? master.onEntitySwing(entityLivingBase, itemStack) : super.onEntitySwing(entityLivingBase, itemStack);
	}

	@Override
	public boolean superOnEntitySwing(Object entityLivingBase, Object itemStack) {
		return super.onEntitySwing((EntityLivingBase) entityLivingBase, (ItemStack) itemStack);
	}

	@Override
    public void renderHelmetOverlay(ItemStack itemStack, EntityPlayer entityPlayer, ScaledResolution scaledResolution, float partialTicks) {
		if (master != null) master.renderHelmetOverlay(itemStack, entityPlayer, scaledResolution, partialTicks);
		else super.renderHelmetOverlay(itemStack, entityPlayer, scaledResolution, partialTicks);
	}

	@Override
	public void superRenderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks) {
		super.renderHelmetOverlay((ItemStack) itemStack, (EntityPlayer) entityPlayer, (ScaledResolution) scaledResolution, partialTicks);
	}

	@Override
	public int getDamage(ItemStack itemStack) {
		return master != null ? master.getDamage(itemStack) : super.getDamage(itemStack);
	}

	@Override
	public int superGetDamage(Object itemStack) {
		return super.getDamage((ItemStack) itemStack);
	}

	@Override
	public int getMetadata(ItemStack itemStack) {
		return master != null ? master.getMetadata(itemStack) : super.getMetadata(itemStack);
	}

	@Override
	public int superGetMetadata(Object itemStack) {
		return super.getMetadata((ItemStack) itemStack);
	}

	@Override
	public int getMaxDamage(ItemStack itemStack) {
		return master != null ? master.getMaxDamage(itemStack) : super.getMaxDamage(itemStack);
	}

	@Override
	public int superGetMaxDamage(Object itemStack) {
		return super.getMaxDamage((ItemStack) itemStack);
	}

	@Override
	public boolean isDamaged(ItemStack itemStack) {
		return master != null ? master.isDamaged(itemStack) : super.isDamaged(itemStack);
	}

	@Override
	public boolean superIsDamaged(Object itemStack) {
		return super.isDamaged((ItemStack) itemStack);
	}

	@Override
	public void setDamage(ItemStack itemStack, int damage) {
		if (master != null) master.setDamage(itemStack, damage);
		else super.setDamage(itemStack, damage);
	}

	@Override
	public void superSetDamage(Object itemStack, int damage) {
		super.setDamage((ItemStack) itemStack, damage);
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		return master != null ? master.canHarvestBlock(block, itemStack) : super.canHarvestBlock(block, itemStack);
	}

	@Override
	public boolean superCanHarvestBlock(Object block, Object itemStack) {
		return super.canHarvestBlock((Block) block, (ItemStack) itemStack);
	}

	@Override
	public int getItemStackLimit(ItemStack itemStack) {
		return master != null ? master.getItemStackLimit(itemStack) : super.getItemStackLimit(itemStack);
	}

	@Override
	public int superGetItemStackLimit(Object itemStack) {
		return super.getItemStackLimit((ItemStack) itemStack);
	}
	// 172~
	@Override
	public float getStrVsBlock(ItemStack itemStack, Block block) {
		return master != null ? master.getStrVsBlock(itemStack, block) : super.getStrVsBlock(itemStack, block);
	}

	@Override
	public float superGetStrVsBlock(Object itemStack, Object block) {
		return super.getStrVsBlock((ItemStack) itemStack, (Block) block);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, BlockPos blockPos, EntityLivingBase entityLivingBase) {
		return master != null ? master.onBlockDestroyed(itemStack, world, block, blockPos, entityLivingBase) : super.onBlockDestroyed(itemStack, world, block, blockPos, entityLivingBase);
	}

	@Override
	public boolean superOnBlockDestroyed(Object itemStack, Object world, Object block, Object blockPos, Object entityLivingBase) {
		return super.onBlockDestroyed((ItemStack) itemStack, (World) world, (Block) block, (BlockPos) blockPos, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.func_150897_b(block) : super.canHarvestBlock(block);
	}

	@Override
	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}

	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List p_150895_3_) {
		if (master != null) master.getSubItems(item, creativeTabs, p_150895_3_);
		else super.getSubItems(item, creativeTabs, p_150895_3_);
	}

	@Override
	public void superGetSubItems(Object item, Object creativeTabs, Object p_150895_3_) {
		super.getSubItems((Item) item, (CreativeTabs) creativeTabs, (List) p_150895_3_);
	}

	@Override
	public Multimap getAttributeModifiers(ItemStack itemStack) {
		return (Multimap) (master != null ? master.getAttributeModifiers(itemStack) : super.getAttributeModifiers(itemStack));
	}

	@Override
	public Multimap superGetAttributeModifiers(Object itemStack) {
		return super.getAttributeModifiers((ItemStack) itemStack);
	}

	@Override
	public float getDigSpeed(ItemStack itemStack, IBlockState iBlockState) {
		return master != null ? master.getDigSpeed(itemStack, iBlockState) : super.getDigSpeed(itemStack, iBlockState);
	}

	@Override
	public float superGetDigSpeed(Object itemStack, Object iBlockState) {
		return super.getDigSpeed((ItemStack) itemStack, (IBlockState) iBlockState);
	}

	@Override
	public void onUsingTick(ItemStack itemStack, EntityPlayer entityPlayer, int count) {
		if (master != null) master.onUsingTick(itemStack, entityPlayer, count);
		else super.onUsingTick(itemStack, entityPlayer, count);
	}

	@Override
	public void superOnUsingTick(Object itemStack, Object entityPlayer, int count) {
		super.onUsingTick((ItemStack) itemStack, (EntityPlayer) entityPlayer, count);
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return (ItemStack) (master != null ? master.getContainerItem(itemStack) : super.getContainerItem(itemStack));
	}

	@Override
	public ItemStack superGetContainerItem(Object itemStack) {
		return super.getContainerItem((ItemStack) itemStack);
	}

	@Override
	public boolean hasContainerItem(ItemStack itemStack) {
		return master != null ? master.hasContainerItem(itemStack) : super.hasContainerItem(itemStack);
	}

	@Override
	public boolean superHasContainerItem(Object itemStack) {
		return super.hasContainerItem((ItemStack) itemStack);
	}

	@Override
	public boolean doesSneakBypassUse(World world, BlockPos blockPos, EntityPlayer entityPlayer) {
		return master != null ? master.doesSneakBypassUse(world, blockPos, entityPlayer) : super.doesSneakBypassUse(world, blockPos, entityPlayer);
	}

	@Override
	public boolean superDoesSneakBypassUse(Object world, Object blockPos, Object entityPlayer) {
		return super.doesSneakBypassUse((World) world, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer entityPlayer, ItemStack itemStack) {
		if (master != null) master.onArmorTick(world, entityPlayer, itemStack);
		else super.onArmorTick(world, entityPlayer, itemStack);
	}

	@Override
	public void superOnArmorTick(Object world, Object entityPlayer, Object itemStack) {
		super.onArmorTick((World) world, (EntityPlayer) entityPlayer, (ItemStack) itemStack);
	}

	@Override
	public boolean showDurabilityBar(ItemStack itemStack) {
		return master != null ? master.showDurabilityBar(itemStack) : super.showDurabilityBar(itemStack);
	}

	@Override
	public boolean superShowDurabilityBar(Object itemStack) {
		return super.showDurabilityBar((ItemStack) itemStack);
	}

	@Override
	public double getDurabilityForDisplay(ItemStack itemStack) {
		return master != null ? master.getDurabilityForDisplay(itemStack) : super.getDurabilityForDisplay(itemStack);
	}

	@Override
	public double superGetDurabilityForDisplay(Object itemStack) {
		return super.getDurabilityForDisplay((ItemStack) itemStack);
	}

	@Override
	public void setHarvestLevel(String toolClass, int level) {
		if (master != null) master.setHarvestLevel(toolClass, level);
		else super.setHarvestLevel(toolClass, level);
	}

	@Override
	public void superSetHarvestLevel(String toolClass, int level) {
		super.setHarvestLevel(toolClass, level);
	}

	@Override
	public Set<String> getToolClasses(ItemStack itemStack) {
		return (Set<String>) (master != null ? master.getToolClasses(itemStack) : super.getToolClasses(itemStack));
	}

	@Override
	public Set<String> superGetToolClasses(Object itemStack) {
		return super.getToolClasses((ItemStack) itemStack);
	}

	@Override
	public int getHarvestLevel(ItemStack itemStack, String toolClass) {
		return master != null ? master.getHarvestLevel(itemStack, toolClass) : super.getHarvestLevel(itemStack, toolClass);
	}

	@Override
	public int superGetHarvestLevel(Object itemStack, String toolClass) {
		return super.getHarvestLevel((ItemStack) itemStack, toolClass);
	}

	// ItemFood
	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if (master != null) master.onFoodEaten(itemStack, world, entityPlayer);
		else super.onFoodEaten(itemStack, world, entityPlayer);
	}

	@Override
	public void superOnFoodEaten(Object itemStack, Object world, Object entityPlayer) {
		super.onFoodEaten((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isWolfsFavoriteMeat() {
		return master != null ? master.isWolfsFavoriteMeat() : super.isWolfsFavoriteMeat();
	}

	@Override
	public boolean superIsWolfsFavoriteMeat() {
		return super.isWolfsFavoriteMeat();
	}

	@Override
	public ItemFood setPotionEffect(int par1, int par2, int par3, float par4) {
		return (ItemFood) (master != null ? master.setPotionEffect(par1, par2, par3, par4) : super.setPotionEffect(par1, par2, par3, par4));
	}

	@Override
	public ItemFood superSetPotionEffect(int par1, int par2, int par3, float par4) {
		return super.setPotionEffect(par1, par2, par3, par4);
	}

	@Override
	public ItemFood setAlwaysEdible() {
		return (ItemFood) (master != null ? master.setAlwaysEdible() : super.setAlwaysEdible());
	}

	@Override
	public ItemFood superSetAlwaysEdible() {
		return super.setAlwaysEdible();
	}

	@Override
	public Object superOnEaten(Object itemStack, Object world, Object entityPlayer) {
		return null;
	}

	@Override
	public Object superSetPotionEffect(Object potionEffect, float p_185070_2_) {
		return null;
	}
	// 180~
	@Override
	public boolean updateItemStackNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.updateItemStackNBT(nBTTagCompound) : super.updateItemStackNBT(nBTTagCompound);
	}

	@Override
	public boolean superUpdateItemStackNBT(Object nBTTagCompound) {
		return super.updateItemStackNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemStack, BlockPos blockPos, EntityPlayer entityPlayer) {
		return master != null ? master.onBlockStartBreak(itemStack, blockPos, entityPlayer) : super.onBlockStartBreak(itemStack, blockPos, entityPlayer);
	}

	@Override
	public boolean superOnBlockStartBreak(Object itemStack, Object blockPos, Object entityPlayer) {
		return super.onBlockStartBreak((ItemStack) itemStack, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
	}

	@Override
	public ModelResourceLocation getModel(ItemStack itemStack, EntityPlayer entityPlayer, int useRemaining) {
		return (ModelResourceLocation) (master != null ? master.getModel(itemStack, entityPlayer, useRemaining) : super.getModel(itemStack, entityPlayer, useRemaining));
	}

	@Override
	public ModelResourceLocation superGetModel(Object itemStack, Object entityPlayer, int useRemaining) {
		return super.getModel((ItemStack) itemStack, (EntityPlayer) entityPlayer, useRemaining);
	}

	@Override
	public int getItemEnchantability(ItemStack itemStack) {
		return master != null ? master.getItemEnchantability(itemStack) : super.getItemEnchantability(itemStack);
	}

	@Override
	public int superGetItemEnchantability(Object itemStack) {
		return super.getItemEnchantability((ItemStack) itemStack);
	}

	@Override
	public boolean isBeaconPayment(ItemStack itemStack) {
		return master != null ? master.isBeaconPayment(itemStack) : super.isBeaconPayment(itemStack);
	}

	@Override
	public boolean superIsBeaconPayment(Object itemStack) {
		return super.isBeaconPayment((ItemStack) itemStack);
	}
	// 172~
	@Override
	public int getHealAmount(ItemStack itemStack) {
		return master != null ? master.getHealAmount(itemStack) : super.getHealAmount(itemStack);
	}

	@Override
	public int superGetHealAmount(Object itemStack) {
		return super.getHealAmount((ItemStack) itemStack);
	}

	@Override
	public float getSaturationModifier(ItemStack itemStack) {
		return master != null ? master.getSaturationModifier(itemStack) : super.getSaturationModifier(itemStack);
	}

	@Override
	public float superGetSaturationModifier(Object itemStack) {
		return super.getSaturationModifier((ItemStack) itemStack);
	}

	// ~179
	public int getSpriteNumber() {
		return -1;
	}

	@Override
	public int superGetSpriteNumber() {
		return -1;
	}

	public Object getIconFromDamage(int par1) {
		return null;
	}

	@Override
	public Object superGetIconFromDamage(int par1) {
		return null;
	}

	public Object getIconIndex(ItemStack itemStack) {
		return null;
	}

	@Override
	public Object superGetIconIndex(Object itemStack) {
		return null;
	}

	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superDoesContainerItemLeaveCraftingGrid(Object itemStack) {
		return false;
	}

	public boolean requiresMultipleRenderPasses() {
		return false;
	}

	@Override
	public boolean superRequiresMultipleRenderPasses() {
		return false;
	}

	public Object getIconFromDamageForRenderPass(int par1, int par2) {
		return null;
	}

	@Override
	public Object superGetIconFromDamageForRenderPass(int par1, int par2) {
		return null;
	}

	@Override
	public void superRegisterIcons(Object iIconRegister) {
	}

	public Item setTextureName(String par1Str) {
		return null;
	}

	@Override
	public Item superSetTextureName(String par1Str) {
		return null;
	}

	protected String getIconString() {
		return null;
	}

	@Override
	public String superGetIconString() {
		return null;
	}

	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return false;
	}

	public boolean onBlockStartBreak(ItemStack itemStack, int X, int Y, int Z, EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superOnBlockStartBreak(Object itemStack, int X, int Y, int Z, Object entityPlayer) {
		return false;
	}

	public Object getIcon(ItemStack itemStack, int renderPass, EntityPlayer entityPlayer, ItemStack itemStack1, int useRemaining) {
		return null;
	}

	@Override
	public Object superGetIcon(Object itemStack, int renderPass, Object entityPlayer, Object itemStack1, int useRemaining) {
		return null;
	}

	public int getRenderPasses(int metadata) {
		return -1;
	}

	@Override
	public int superGetRenderPasses(int metadata) {
		return -1;
	}

	public Object getIcon(ItemStack itemStack, int pass) {
		return null;
	}

	@Override
	public Object superGetIcon(Object itemStack, int pass) {
		return null;
	}

	public void renderHelmetOverlay(ItemStack itemStack, EntityPlayer entityPlayer, ScaledResolution scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
	}

	@Override
	public void superRenderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
	}

	public int getDisplayDamage(ItemStack itemStack) {
		return getMetadata(itemStack);
	}

	@Override
	public int superGetDisplayDamage(Object itemStack) {
		return superGetMetadata(itemStack);
	}

	public boolean hasEffect(ItemStack itemStack, int pass) {
		return hasEffect(itemStack);
	}

	@Override
	public boolean superHasEffect(Object itemStack, int pass) {
		return superHasEffect(itemStack);
	}

	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase entityLivingBase) {
		return false;
	}

	@Override
	public boolean superOnBlockDestroyed(Object itemStack, Object world, Object block, int p_150894_4_, int p_150894_5_, int p_150894_6_, Object entityLivingBase) {
		return false;
	}

	public float getDigSpeed(ItemStack itemStack, Block block, int metadata) {
		return 0.0F;
	}

	@Override
	public float superGetDigSpeed(Object itemStack, Object block, int metadata) {
		return 0.0F;
	}

	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superDoesSneakBypassUse(Object world, int x, int y, int z, Object entityPlayer) {
		return false;
	}

	@Override
	public String superGetArmorTexture(Object itemStack, Object entity, Object entityEquipmentSlot, int layer) {
		return null;
	}

	@Override
	public boolean superIsValidArmor(Object itemStack, Object entityEquipmentSlot, Object entity) {
		return false;
	}

	@Override
	public String superGetArmorTexture(Object itemStack, Object entity, Object entityEquipmentSlot, String type) {
		return null;
	}

	@Override
	public Object superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumHand, Object enumFacing, float f, float f1, float f2) {
		return null;
	}

	@Override
	public Object superOnItemRightClick(Object itemStack, Object world, Object entityPlayer, Object enumHand) {
		return null;
	}

	@Override
	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase, Object enumHand) {
		return false;
	}

	@Override
	public Multimap<String, Object> superGetItemAttributeModifiers(Object entityEquipmentSlot) {
		return null;
	}

	@Override
	public Object superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, Object enumHand) {
		return null;
	}

	@Override
	public Object superGetArmorModel(Object entityLivingBase, Object itemStack, Object entityEquipmentSlot, Object modelBiped) {
		return null;
	}

	@Override
	public Multimap superGetAttributeModifiers(Object entityEquipmentSlot, Object itemStack) {
		return null;
	}

	@Override
	public boolean superDoesSneakBypassUse(Object itemStack, Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return false;
	}

	@Override
	public Object superGetPropertyGetter(Object resourceLocation) {
		return null;
	}

	@Override
	public boolean superHasCustomProperties() {
		return false;
	}

	@Override
	public String superGetHighlightTip(Object itemStack, String displayName) {
		return null;
	}

	@Override
	public boolean superShouldCauseReequipAnimation(Object itemStack, Object itemStack1, boolean slotChanged) {
		return false;
	}

	@Override
	public Object superInitCapabilities(Object itemStack, Object nBTTagCompound) {
		return null;
	}

	@Override
	public int superGetDamageVsEntity(Object entity) {
		return -1;
	}

	@Override
	public String superGetLocalizedName(Object itemStack) {
		return null;
	}

	@Override
	public String superFunc_77653_i(Object itemStack) {
		return null;
	}

	@Override
	public boolean superFunc_82788_x() {
		return false;
	}

	@Override
	public boolean superIsValidArmor(Object itemStack, int armorType) {
		return false;
	}

	@Override
	public int superGetItemDamageFromStack(Object itemStack) {
		return -1;
	}

	@Override
	public int superGetItemDamageFromStackForDisplay(Object itemStack) {
		return -1;
	}

	@Override
	public int superGetItemMaxDamageFromStack(Object itemStack) {
		return -1;
	}

	@Override
	public boolean superIsItemStackDamaged(Object itemStack) {
		return false;
	}

	@Override
	public void superSetItemDamageForStack(Object itemStack, int damage) {
	}

}
