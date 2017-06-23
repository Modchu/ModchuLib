package modchu.lib;

import java.util.List;

public interface Modchu_IItem {
	public Object superSetMaxStackSize(int par1);
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float f, float f1, float f2);
	public Object superOnItemRightClick(Object itemStack, Object world, Object entityPlayer);
	public Object superOnItemUseFinish(Object itemStack, Object world, Object entityPlayer);
	public int superGetItemStackLimit();
	public int superGetMetadata(int par1);
	public boolean superGetHasSubtypes();
	public Object superSetHasSubtypes(boolean par1);
	public int superGetMaxDamage();
	public Object superSetMaxDamage(int par1);
	public boolean superIsDamageable();
	public boolean superHitEntity(Object itemStack, Object entityLivingBase, Object entityLivingBase1);
	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase);
	public Object superSetFull3D();
	public boolean superIsFull3D();
	public boolean superShouldRotateAroundWhenRendering();
	public Object superSetUnlocalizedName(String par1Str);
	public String superGetUnlocalizedNameInefficiently(Object itemStack);
	public String superGetUnlocalizedName();
	public String superGetUnlocalizedName(Object itemStack);
	public Object superSetContainerItem(Object item);
	public boolean superGetShareTag();
	public Object superGetContainerItem();
	public boolean superHasContainerItem();
	public int superGetColorFromItemStack(Object itemStack, int par2);
	public void superOnUpdate(Object itemStack, Object world, Object entity, int par4, boolean par5);
	public void superOnCreated(Object itemStack, Object world, Object entityPlayer);
	public boolean superIsMap();
	public Object superGetItemUseAction(Object itemStack);
	public int superGetMaxItemUseDuration(Object itemStack);
	public void superOnPlayerStoppedUsing(Object itemStack, Object world, Object entityPlayer, int par4);
	public Object superSetPotionEffect(String par1Str);
	public String superGetItemStackDisplayName(Object itemStack);
	public boolean superHasEffect(Object itemStack);
	public Object superGetRarity(Object itemStack);
	public boolean superIsEnchantable(Object itemStack);
	public Object superRayTrace(Object world, Object entityPlayer, boolean par3);
	public int superGetItemEnchantability();
	public Object superSetCreativeTab(Object creativeTabs);
	public Object superGetCreativeTab();
	public boolean superCanItemEditBlocks();
	public boolean superGetIsRepairable(Object itemStack, Object itemStack1);
	public Object superGetItemAttributeModifiers();
	public boolean superOnBlockDestroyed(Object itemStack, Object world, int par3, int par4, int par5, int par6, Object entityLivingBase);
	public String superGetStatName();
	public String superGetPotionEffect();
	public boolean superIsPotionIngredient();
	public String superGetItemDisplayName(Object itemStack);
	public void superGetSubItems(int par1, Object creativeTabs, List par3List);
	public float superGetStrVsBlock(Object itemStack, Object block, int metadata);
	public void superOnUsingItemTick(Object itemStack, Object entityPlayer, int count);
	public Object superGetContainerItemStack(Object itemStack);
	public boolean superShouldPassSneakingClickToBlock(Object world, int par4, int par5, int par6);
	public void superOnArmorTickUpdate(Object world, Object entityPlayer, Object itemStack);
	public float superGetDamageVsEntity(Object entity, Object itemStack);
	public String superGetArmorTexture(Object itemStack, Object entity, Object entityEquipmentSlot, int layer);
	public Object superGetIconIndex(Object itemStack);
	public String superGetPotionEffect(Object itemStack);
	public boolean superIsPotionIngredient(Object itemStack);
	public boolean superOnDroppedByPlayer(Object itemStack, Object entityPlayer);
	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ);
	public boolean superIsRepairable();
	public Object superSetNoRepair();
	public boolean superOnBlockStartBreak(Object itemStack, Object blockPos, Object entityPlayer);
	public boolean superOnLeftClickEntity(Object itemStack, Object entityPlayer, Object entity);
	public int superGetEntityLifespan(Object itemStack, Object world);
	public boolean superHasCustomEntity(Object itemStack);
	public Object superCreateEntity(Object world, Object entity, Object itemStack);
	public boolean superOnEntityItemUpdate(Object entityItem);
	public Object[] superGetCreativeTabs();
	public float superGetSmeltingExperience(Object itemStack);
	public Object superGetChestGenBase(Object chestGenHooks, Object random, Object weightedRandomChestContent);
	public boolean superIsValidArmor(Object itemStack, Object entityEquipmentSlot, Object entity);
	public boolean superIsBookEnchantable(Object itemStack, Object itemStack1);
	public String superGetArmorTexture(Object itemStack, Object entity, Object entityEquipmentSlot, String type);
	public Object superGetFontRenderer(Object itemStack);
	public Object superGetArmorModel(Object entityLivingBase, Object itemStack, int armorSlot);
	public boolean superOnEntitySwing(Object entityLivingBase, Object itemStack);
	public void superRenderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks);
	public int superGetDamage(Object itemStack);
	public int superGetMetadata(Object itemStack);
	public int superGetMaxDamage(Object itemStack);
	public boolean superIsDamaged(Object itemStack);
	public void superSetDamage(Object itemStack, int damage);
	public boolean superCanHarvestBlock(Object block, Object itemStack);
	public int superGetItemStackLimit(Object itemStack);
	public float superGetStrVsBlock(Object itemStack, Object block);
	public boolean superOnBlockDestroyed(Object itemStack, Object world, Object block, Object blockPos, Object entityLivingBase);
	public boolean superCanHarvestBlock(Object block);
	public void superGetSubItems(Object item, Object creativeTabs, Object p_150895_3_);
	public Object superGetAttributeModifiers(Object itemStack);
	public float superGetDigSpeed(Object itemStack, Object iBlockState);
	public void superOnUsingTick(Object itemStack, Object entityPlayer, int count);
	public Object superGetContainerItem(Object itemStack);
	public boolean superHasContainerItem(Object itemStack);
	public boolean superDoesSneakBypassUse(Object world, Object blockPos, Object entityPlayer);
	public void superOnArmorTick(Object world, Object entityPlayer, Object itemStack);
	public boolean superShowDurabilityBar(Object itemStack);
	public double superGetDurabilityForDisplay(Object itemStack);
	public void superSetHarvestLevel(String toolClass, int level);
	public Object superGetToolClasses(Object itemStack);
	public int superGetHarvestLevel(Object itemStack, String toolClass);
	public int superGetSpriteNumber();
	public Object superGetIconFromDamage(int par1);
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, int par4, int par5, int par6, int par7, float par8, float par9, float par10);
	public Object superOnEaten(Object itemStack, Object world, Object entityPlayer);
	public boolean superDoesContainerItemLeaveCraftingGrid(Object itemStack);
	public boolean superRequiresMultipleRenderPasses();
	public Object superGetIconFromDamageForRenderPass(int par1, int par2);
	public void superRegisterIcons(Object iIconRegister);
	public Object superSetTextureName(String par1Str);
	public String superGetIconString();
	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, int x, int y, int z, int side, float hitX, float hitY, float hitZ);
	public boolean superOnBlockStartBreak(Object itemStack, int X, int Y, int Z, Object entityPlayer);
	public Object superGetIcon(Object itemStack, int renderPass, Object entityPlayer, Object itemStack1, int useRemaining);
	public int superGetRenderPasses(int metadata);
	public Object superGetIcon(Object itemStack, int pass);
	public void superRenderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY);
	public int superGetDisplayDamage(Object itemStack);
	public boolean superHasEffect(Object itemStack, int pass);
	public boolean superOnBlockDestroyed(Object itemStack, Object world, Object block, int p_150894_4_, int p_150894_5_, int p_150894_6_, Object entityLivingBase);
	public float superGetDigSpeed(Object itemStack, Object block, int metadata);
	public boolean superDoesSneakBypassUse(Object world, int x, int y, int z, Object entityPlayer);
	// ~152
	public int superGetDamageVsEntity(Object entity);
	public String superGetLocalizedName(Object itemStack);
	public String superFunc_77653_i(Object itemStack);
	public boolean superFunc_82788_x();
	public boolean superIsValidArmor(Object itemStack, int armorType);
	public int superGetItemDamageFromStack(Object itemStack);
	public int superGetItemDamageFromStackForDisplay(Object itemStack);
	public int superGetItemMaxDamageFromStack(Object itemStack);
	public boolean superIsItemStackDamaged(Object itemStack);
	public void superSetItemDamageForStack(Object itemStack, int damage);
	// 190~
	public Object superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumHand, Object enumFacing, float f, float f1, float f2);
	public Object superOnItemRightClick(Object itemStack, Object world, Object entityPlayer, Object enumHand);
	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase, Object enumHand);
	public Object superGetItemAttributeModifiers(Object entityEquipmentSlot);
	public Object superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, Object enumHand);
	public Object superGetArmorModel(Object entityLivingBase, Object itemStack, Object entityEquipmentSlot, Object modelBiped);
	public Object superGetAttributeModifiers(Object entityEquipmentSlot, Object itemStack);
	boolean superDoesSneakBypassUse(Object itemStack, Object iBlockAccess, Object blockPos, Object entityPlayer);
	public Object superGetPropertyGetter(Object resourceLocation);
	public boolean superUpdateItemStackNBT(Object nBTTagCompound);
	public boolean superHasCustomProperties();
	public String superGetHighlightTip(Object itemStack, String displayName);
	public int superGetItemEnchantability(Object itemStack);
	public boolean superIsBeaconPayment(Object itemStack);
	public boolean superShouldCauseReequipAnimation(Object itemStack, Object itemStack1, boolean slotChanged);
	public Object superInitCapabilities(Object itemStack, Object nBTTagCompound);
	public void superAddInformation(Object itemStack, Object world, List par3List, Object iTooltipFlag);

	// 220~
	public boolean superIsInCreativeTab(Object creativeTabs);
	public Object superGetNBTShareTag(Object itemStack);
	public int superGetRGBDurabilityForDisplay(Object itemStack);
	public boolean superCanDestroyBlockInCreative(Object world, Object blockPos, Object itemStack, Object entityPlayer);
	public int superGetHarvestLevel(Object itemStack, String toolClass, Object entityPlayer, Object iBlockState);
	public boolean superCanApplyAtEnchantingTable(Object itemStack, Object enchantment);
	public boolean superShouldCauseBlockBreakReset(Object itemStack, Object itemStack1);
	public Object superGetAnimationParameters(Object itemStack, Object world, Object entityLivingBase);
	public Object superGetDefaultInstance();

}
