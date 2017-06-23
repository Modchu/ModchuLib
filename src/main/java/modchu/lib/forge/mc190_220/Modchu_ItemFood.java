package modchu.lib.forge.mc190_220;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Multimap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IItemFood;
import modchu.lib.Modchu_IItemFoodMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public abstract class Modchu_ItemFood extends ItemFood implements Modchu_IItemFood {
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
	public boolean superIsValidArmor(Object itemStack, int armorType, Object entity) {
		return false;
	}

	@Override
	public String superGetArmorTexture(Object itemStack, Object entity, int slot, String type) {
		return null;
	}

	@Override
	public void superOnFoodEaten(Object itemStack, Object world, Object entityPlayer) {
		super.onFoodEaten((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean superIsWolfsFavoriteMeat() {
		return super.isWolfsFavoriteMeat();
	}

	@Override
	public Object superSetPotionEffect(int par1, int par2, int par3, float par4) {
		return null;
	}

	@Override
	public Object superSetAlwaysEdible() {
		return super.setAlwaysEdible();
	}

	@Override
	public Object superGetModel(Object itemStack, Object entityPlayer, int useRemaining) {
		return null;
	}

	@Override
	public int superGetHealAmount(Object itemStack) {
		return super.getHealAmount((ItemStack) itemStack);
	}

	@Override
	public float superGetSaturationModifier(Object itemStack) {
		return super.getSaturationModifier((ItemStack) itemStack);
	}

	@Override
	public Object superSetPotionEffect(Object potionEffect, float p_185070_2_) {
		return null;
	}
	// Modchu_Item のコピー　↓
	@Override
	public Item setMaxStackSize(int par1) {
		return (Item) (master != null ? master.setMaxStackSize(par1) : super.setMaxStackSize(par1));
	}

	@Override
	public Item superSetMaxStackSize(int par1) {
		return super.setMaxStackSize(par1);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityLivingBase entityLivingBase) {
		return (ItemStack) (master != null ? master.onItemUseFinish(itemStack, world, entityLivingBase) : super.onItemUseFinish(itemStack, world, entityLivingBase));
	}

	@Override
	public ItemStack superOnItemUseFinish(Object itemStack, Object world, Object entityLivingBase) {
		return super.onItemUseFinish((ItemStack) itemStack, (World) world, (EntityLivingBase) entityLivingBase);
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
		Modchu_Debug.mDebug("Modchu_Item ModchuModel_Main hitEntity");
		return master != null ? master.hitEntity(itemStack, entityLivingBase, entityLivingBase1) : super.hitEntity(itemStack, entityLivingBase, entityLivingBase1);
	}

	@Override
	public boolean superHitEntity(Object itemStack, Object entityLivingBase, Object entityLivingBase1) {
		return super.hitEntity((ItemStack) itemStack, (EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase, EnumHand enumHand) {
		return master != null ? master.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase, enumHand) : super.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase, enumHand);
	}

	@Override
	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase, Object enumHand) {
		return super.itemInteractionForEntity((ItemStack) itemStack, (EntityPlayer) entityPlayer, (EntityLivingBase) entityLivingBase, (EnumHand) enumHand);
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
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityLivingBase entityLivingBase, int par4) {
		if (master != null) master.onPlayerStoppedUsing(itemStack, world, entityLivingBase, par4);
		else super.onPlayerStoppedUsing(itemStack, world, entityLivingBase, par4);
	}

	@Override
	public void superOnPlayerStoppedUsing(Object itemStack, Object world, Object entityLivingBase, int par4) {
		super.onPlayerStoppedUsing((ItemStack) itemStack, (World) world, (EntityLivingBase) entityLivingBase, par4);
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
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot entityEquipmentSlot) {
		return (Multimap) (master != null ? master.getItemAttributeModifiers(entityEquipmentSlot) : super.getItemAttributeModifiers(entityEquipmentSlot));
	}

	@Override
	public Multimap<String, Object> superGetItemAttributeModifiers(Object entityEquipmentSlot) {
		return (Multimap) (super.getItemAttributeModifiers((EntityEquipmentSlot) entityEquipmentSlot));
	}
	// 190~
	@Override
	public IItemPropertyGetter getPropertyGetter(ResourceLocation resourceLocation) {
		return (IItemPropertyGetter) (master != null ? master.getPropertyGetter(resourceLocation) : super.getPropertyGetter(resourceLocation));
	}

	@Override
	public IItemPropertyGetter superGetPropertyGetter(Object resourceLocation) {
		return super.getPropertyGetter((ResourceLocation) resourceLocation);
	}

	@Override
	public boolean updateItemStackNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.updateItemStackNBT(nBTTagCompound) : super.updateItemStackNBT(nBTTagCompound);
	}

	@Override
	public boolean superUpdateItemStackNBT(Object nBTTagCompound) {
		return super.updateItemStackNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean hasCustomProperties() {
		return master != null ? master.hasCustomProperties() : super.hasCustomProperties();
	}

	@Override
	public boolean superHasCustomProperties() {
		return super.hasCustomProperties();
	}

	@Override
	public String getHighlightTip(ItemStack itemStack, String displayName) {
		return master != null ? master.getHighlightTip(itemStack, displayName) : super.getHighlightTip(itemStack, displayName);
	}

	@Override
	public String superGetHighlightTip(Object itemStack, String displayName) {
		return super.getHighlightTip((ItemStack) itemStack, displayName);
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

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack itemStack, ItemStack itemStack1, boolean slotChanged) {
		return master != null ? master.shouldCauseReequipAnimation(itemStack, itemStack1, slotChanged) : super.shouldCauseReequipAnimation(itemStack, itemStack1, slotChanged);
	}

	@Override
	public boolean superShouldCauseReequipAnimation(Object itemStack, Object itemStack1, boolean slotChanged) {
		return super.shouldCauseReequipAnimation((ItemStack) itemStack, (ItemStack) itemStack1, slotChanged);
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack itemStack, NBTTagCompound nBTTagCompound) {
		return (ICapabilityProvider) (master != null ? master.initCapabilities(itemStack, nBTTagCompound) : super.initCapabilities(itemStack, nBTTagCompound));
	}

	@Override
	public ICapabilityProvider superInitCapabilities(Object itemStack, Object nBTTagCompound) {
		return super.initCapabilities((ItemStack) itemStack, (NBTTagCompound) nBTTagCompound);
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

	public void getSubItems(int par1, CreativeTabs creativeTabs, List par3List) {
	}

	@Override
	public void superGetSubItems(int par1, Object creativeTabs, List par3List) {
	}

	public void registerIcons(Object iconRegister) {
	}
	// 164~
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

	public ItemStack getContainerItemStack(ItemStack itemStack) {
		return null;
	}

	@Override
	public ItemStack superGetContainerItemStack(Object itemStack) {
		return null;
	}

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

	public String superGetArmorTexture(Object itemStack, Object entity, int slot, int layer) {
		return null;
	}
	// 164~179
	public Object getIconIndex(ItemStack itemStack) {
		return null;
	}

	@Override
	public Object superGetIconIndex(Object itemStack) {
		return null;
	}
	// 164~
	@Override
	public boolean onDroppedByPlayer(ItemStack itemStack, EntityPlayer entityPlayer) {
		return master != null ? master.onDroppedByPlayer(itemStack, entityPlayer) : super.onDroppedByPlayer(itemStack, entityPlayer);
	}

	@Override
	public boolean superOnDroppedByPlayer(Object itemStack, Object entityPlayer) {
		return super.onDroppedByPlayer((ItemStack) itemStack, (EntityPlayer) entityPlayer);
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
	public boolean onBlockStartBreak(ItemStack itemStack, BlockPos blockPos, EntityPlayer entityPlayer) {
		return master != null ? master.onBlockStartBreak(itemStack, blockPos, entityPlayer) : super.onBlockStartBreak(itemStack, blockPos, entityPlayer);
	}

	@Override
	public boolean superOnBlockStartBreak(Object itemStack, Object blockPos, Object entityPlayer) {
		return super.onBlockStartBreak((ItemStack) itemStack, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
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
	public boolean isValidArmor(ItemStack itemStack, EntityEquipmentSlot entityEquipmentSlot, Entity entity) {
		return master != null ? master.isValidArmor(itemStack, entityEquipmentSlot, entity) : super.isValidArmor(itemStack, entityEquipmentSlot, entity);
	}

	@Override
	public boolean superIsValidArmor(Object itemStack, Object entityEquipmentSlot, Object entity) {
		return super.isValidArmor((ItemStack) itemStack, (EntityEquipmentSlot) entityEquipmentSlot, (Entity) entity);
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
	public String getArmorTexture(ItemStack itemStack, Entity entity, EntityEquipmentSlot entityEquipmentSlot, String type) {
		return master != null ? master.getArmorTexture(itemStack, entity, entityEquipmentSlot, type) : super.getArmorTexture(itemStack, entity, entityEquipmentSlot, type);
	}

	@Override
	public String superGetArmorTexture(Object itemStack, Object entity, Object entityEquipmentSlot, String type) {
		return super.getArmorTexture((ItemStack) itemStack, (Entity) entity, (EntityEquipmentSlot) entityEquipmentSlot, type);
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
	public ModelBiped getArmorModel(EntityLivingBase entityLivingBase, ItemStack itemStack, EntityEquipmentSlot entityEquipmentSlot, net.minecraft.client.model.ModelBiped modelBiped) {
		return (ModelBiped) (master != null ? master.getArmorModel(entityLivingBase, itemStack, entityEquipmentSlot, modelBiped) : super.getArmorModel(entityLivingBase, itemStack, entityEquipmentSlot, modelBiped));
	}

	@Override
	public Object superGetArmorModel(Object entityLivingBase, Object itemStack, Object entityEquipmentSlot, Object modelBiped) {
		return super.getArmorModel((EntityLivingBase) entityLivingBase, (ItemStack) itemStack, (EntityEquipmentSlot) entityEquipmentSlot, (ModelBiped) modelBiped);
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
	public boolean canHarvestBlock(IBlockState iBlockState, ItemStack itemStack) {
		return master != null ? master.canHarvestBlock(iBlockState, itemStack) : super.canHarvestBlock(iBlockState, itemStack);
	}

	@Override
	public boolean superCanHarvestBlock(Object iBlockState, Object itemStack) {
		return super.canHarvestBlock((IBlockState) iBlockState, (ItemStack) itemStack);
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
	public float getStrVsBlock(ItemStack itemStack, IBlockState iBlockState) {
		return master != null ? master.getStrVsBlock(itemStack, iBlockState) : super.getStrVsBlock(itemStack, iBlockState);
	}

	@Override
	public float superGetStrVsBlock(Object itemStack, Object iBlockState) {
		return super.getStrVsBlock((ItemStack) itemStack, (IBlockState) iBlockState);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, IBlockState iBlockState, BlockPos blockPos, EntityLivingBase entityLivingBase) {
		return master != null ? master.onBlockDestroyed(itemStack, world, iBlockState, blockPos, entityLivingBase) : super.onBlockDestroyed(itemStack, world, iBlockState, blockPos, entityLivingBase);
	}

	@Override
	public boolean superOnBlockDestroyed(Object itemStack, Object world, Object iBlockState, Object blockPos, Object entityLivingBase) {
		return super.onBlockDestroyed((ItemStack) itemStack, (World) world, (IBlockState) iBlockState, (BlockPos) blockPos, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean canHarvestBlock(IBlockState iBlockState) {
		return master != null ? master.func_150897_b(iBlockState) : super.canHarvestBlock(iBlockState);
	}

	@Override
	public boolean superCanHarvestBlock(Object iBlockState) {
		return super.canHarvestBlock((IBlockState) iBlockState);
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot entityEquipmentSlot, ItemStack itemStack) {
		return (Multimap) (master != null ? master.getAttributeModifiers(entityEquipmentSlot, itemStack) : super.getAttributeModifiers(entityEquipmentSlot, itemStack));
	}

	@Override
	public Multimap superGetAttributeModifiers(Object entityEquipmentSlot, Object itemStack) {
		return super.getAttributeModifiers((EntityEquipmentSlot) entityEquipmentSlot, (ItemStack) itemStack);
	}

	@Override
	public void onUsingTick(ItemStack itemStack, EntityLivingBase entityLivingBase, int count) {
		if (master != null) master.onUsingTick(itemStack, entityLivingBase, count);
		else super.onUsingTick(itemStack, entityLivingBase, count);
	}

	@Override
	public void superOnUsingTick(Object itemStack, Object entityLivingBase, int count) {
		super.onUsingTick((ItemStack) itemStack, (EntityLivingBase) entityLivingBase, count);
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
	public boolean doesSneakBypassUse(ItemStack itemStack, net.minecraft.world.IBlockAccess iBlockAccess, BlockPos blockPos, EntityPlayer entityPlayer) {
		return master != null ? master.doesSneakBypassUse(itemStack, iBlockAccess, blockPos, entityPlayer) : super.doesSneakBypassUse(itemStack, iBlockAccess, blockPos, entityPlayer);
	}

	@Override
	public boolean superDoesSneakBypassUse(Object itemStack, Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return super.doesSneakBypassUse((ItemStack) itemStack, (net.minecraft.world.IBlockAccess) iBlockAccess, (BlockPos) blockPos, (EntityPlayer) entityPlayer);
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

	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return false;
	}

	@Override
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return false;
	}

	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		return onItemUseFinish(itemStack, world, entityPlayer);
	}

	@Override
	public ItemStack superOnEaten(Object itemStack, Object world, Object entityPlayer) {
		return superOnItemUseFinish(itemStack, world, entityPlayer);
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
	// ~189
	public int getColorFromItemStack(ItemStack itemStack, int par2) {
		return -1;
	}

	@Override
	public int superGetColorFromItemStack(Object itemStack, int par2) {
		return -1;
	}

	public Item setPotionEffect(String par1Str) {
		return null;
	}

	@Override
	public Object superSetPotionEffect(String par1Str) {
		return null;
	}

	public String getPotionEffect(ItemStack itemStack) {
		return null;
	}

	@Override
	public String superGetPotionEffect(Object itemStack) {
		return null;
	}

	public boolean isPotionIngredient(ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superIsPotionIngredient(Object itemStack) {
		return false;
	}

	public Object getChestGenBase(Object chestGenHooks, Random random, Object weightedRandomChestContent) {
		return null;
	}

	@Override
	public Object superGetChestGenBase(Object chestGenHooks, Object random, Object weightedRandomChestContent) {
		return null;
	}

	public float getDigSpeed(ItemStack itemStack, IBlockState iBlockState) {
		return 0.0F;
	}

	@Override
	public float superGetDigSpeed(Object itemStack, Object iBlockState) {
		return 0.0F;
	}

	@Override
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float f, float f1, float f2) {
		return false;
	}

	@Override
	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase) {
		return false;
	}

	@Override
	public Object superGetItemAttributeModifiers() {
		return null;
	}

	@Override
	public String superGetArmorTexture(Object itemStack, Object entity, Object entityEquipmentSlot, int layer) {
		return null;
	}

	@Override
	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public Object superGetArmorModel(Object entityLivingBase, Object itemStack, int armorSlot) {
		return null;
	}

	@Override
	public Object superGetAttributeModifiers(Object itemStack) {
		return null;
	}

	@Override
	public boolean superDoesSneakBypassUse(Object world, Object blockPos, Object entityPlayer) {
		return false;
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
