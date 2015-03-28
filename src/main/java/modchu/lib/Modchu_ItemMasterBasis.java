package modchu.lib;

import java.util.HashMap;
import java.util.List;

public class Modchu_ItemMasterBasis implements Modchu_IItemMaster {
	public Modchu_IItem base;

	public Modchu_ItemMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IItem) map.get("base");
	}

	@Override
	public Object setMaxStackSize(int par1) {
		return base.superSetMaxStackSize(par1);
	}

	@Override
	public int getSpriteNumber() {
		return base.superGetSpriteNumber();
	}

	@Override
	public Object getIconFromDamage(int par1) {
		return base.superGetIconFromDamage(par1);
	}

	@Override
	public Object getIconIndex(Object itemStack) {
		return base.superGetIconIndex(itemStack);
	}

	@Override
	public boolean onItemUse(Object itemStack, Object entityPlayer, Object world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return base.superOnItemUse(itemStack, entityPlayer, world, par4, par5, par6, par7, par8, par9, par10);
	}

	@Override
	public Object onItemRightClick(Object itemStack, Object world, Object entityPlayer) {
		return base.superOnItemRightClick(itemStack, world, entityPlayer);
	}

	@Override
	public Object onItemUseFinish(Object itemStack, Object world, Object entityPlayer) {
		return base.superOnEaten(itemStack, world, entityPlayer);
	}

	@Override
	public int getItemStackLimit() {
		return base.superGetItemStackLimit();
	}

	@Override
	public int getMetadata(int par1) {
		return base.superGetMetadata(par1);
	}

	@Override
	public boolean getHasSubtypes() {
		return base.superGetHasSubtypes();
	}

	@Override
	public Object setHasSubtypes(boolean par1) {
		return base.superSetHasSubtypes(par1);
	}

	@Override
	public int getMaxDamage() {
		return base.superGetMaxDamage();
	}

	@Override
	public Object setMaxDamage(int par1) {
		return base.superSetMaxDamage(par1);
	}

	@Override
	public boolean isDamageable() {
		return base.superIsDamageable();
	}

	@Override
	public boolean hitEntity(Object itemStack, Object entityLivingBase, Object entityLivingBase1) {
		return base.superHitEntity(itemStack, entityLivingBase, entityLivingBase1);
	}

	@Override
	public boolean itemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase) {
		return base.superItemInteractionForEntity(itemStack, entityPlayer, entityLivingBase);
	}

	@Override
	public Object setFull3D() {
		return base.superSetFull3D();
	}

	@Override
	public boolean isFull3D() {
		return base.superIsFull3D();
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return base.superShouldRotateAroundWhenRendering();
	}

	@Override
	public Object setUnlocalizedName(String par1Str) {
		return base.superSetUnlocalizedName(par1Str);
	}

	@Override
	public String getUnlocalizedNameInefficiently(Object itemStack) {
		return base.superGetUnlocalizedNameInefficiently(itemStack);
	}

	@Override
	public String getUnlocalizedName() {
		return base.superGetUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(Object itemStack) {
		return base.superGetUnlocalizedName(itemStack);
	}

	@Override
	public Object setContainerItem(Object item) {
		return base.superSetContainerItem(item);
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(Object itemStack) {
		return base.superDoesContainerItemLeaveCraftingGrid(itemStack);
	}

	@Override
	public boolean getShareTag() {
		return base.superGetShareTag();
	}

	@Override
	public Object getContainerItem() {
		return base.superGetContainerItem();
	}

	@Override
	public boolean hasContainerItem() {
		return base.superHasContainerItem();
	}

	@Override
	public int getColorFromItemStack(Object itemStack, int par2) {
		return base.superGetColorFromItemStack(itemStack, par2);
	}

	@Override
	public void onUpdate(Object itemStack, Object world, Object entity, int par4, boolean par5) {
		base.superOnUpdate(itemStack, world, entity, par4, par5);
	}

	@Override
	public void onCreated(Object itemStack, Object world, Object entityPlayer) {
		base.superOnCreated(itemStack, world, entityPlayer);
	}

	@Override
	public boolean isMap() {
		return base.superIsMap();
	}

	@Override
	public Object getItemUseAction(Object itemStack) {
		return base.superGetItemUseAction(itemStack);
	}

	@Override
	public int getMaxItemUseDuration(Object itemStack) {
		return base.superGetMaxItemUseDuration(itemStack);
	}

	@Override
	public void onPlayerStoppedUsing(Object itemStack, Object world, Object entityPlayer, int par4) {
		base.superOnPlayerStoppedUsing(itemStack, world, entityPlayer, par4);
	}

	@Override
	public Object setPotionEffect(String par1Str) {
		return base.superSetPotionEffect(par1Str);
	}

	@Override
	public String getPotionEffect(Object itemStack) {
		return base.superGetPotionEffect(itemStack);
	}

	@Override
	public boolean isPotionIngredient(Object itemStack) {
		return base.superIsPotionIngredient(itemStack);
	}

	@Override
	public void addInformation(Object itemStack, Object entityPlayer, List par3List, boolean par4) {
		base.superAddInformation(itemStack, entityPlayer, par3List, par4);
	}

	@Override
	public String getItemStackDisplayName(Object itemStack) {
		return base.superGetItemStackDisplayName(itemStack);
	}

	@Override
	public boolean hasEffect(Object itemStack) {
		return base.superHasEffect(itemStack);
	}

	@Override
	public Object getRarity(Object itemStack) {
		return base.superGetRarity(itemStack);
	}

	@Override
	public boolean isItemTool(Object itemStack) {
		return base.superIsItemTool(itemStack);
	}

	@Override
	public Object getMovingObjectPositionFromPlayer(Object world, Object entityPlayer, boolean par3) {
		return base.superGetMovingObjectPositionFromPlayer(world, entityPlayer, par3);
	}

	@Override
	public int getItemEnchantability() {
		return base.superGetItemEnchantability();
	}

	@Override
	public boolean requiresMultipleRenderPasses() {
		return base.superRequiresMultipleRenderPasses();
	}

	@Override
	public Object getIconFromDamageForRenderPass(int par1, int par2) {
		return base.superGetIconFromDamageForRenderPass(par1, par2);
	}

	@Override
	public Object setCreativeTab(Object creativeTabs) {
		return base.superSetCreativeTab(creativeTabs);
	}

	@Override
	public Object getCreativeTab() {
		return base.superGetCreativeTab();
	}

	@Override
	public boolean canItemEditBlocks() {
		return base.superCanItemEditBlocks();
	}

	@Override
	public boolean getIsRepairable(Object itemStack, Object itemStack1) {
		return base.superGetIsRepairable(itemStack, itemStack1);
	}

	@Override
	public void registerIcons(Object iIconRegister) {
		base.superRegisterIcons(iIconRegister);
	}

	@Override
	public Object getItemAttributeModifiers() {
		return base.superGetItemAttributeModifiers();
	}

	@Override
	public Object setTextureName(String par1Str) {
		return base.superSetTextureName(par1Str);
	}

	@Override
	public String getIconString() {
		return base.superGetIconString();
	}

	@Override
	public boolean onDroppedByPlayer(Object itemStack, Object entityPlayer) {
		return base.superOnDroppedByPlayer(itemStack, entityPlayer);
	}

	@Override
	public boolean onItemUseFirst(Object itemStack, Object entityPlayer, Object world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return base.superOnItemUseFirst(itemStack, entityPlayer, world, x, y, z, side, hitX, hitY, hitZ);
	}

	@Override
	public boolean isRepairable() {
		return base.superIsRepairable();
	}

	@Override
	public Object setNoRepair() {
		return base.superSetNoRepair();
	}

	@Override
	public boolean onBlockStartBreak(Object itemStack, int X, int Y, int Z, Object entityPlayer) {
		return base.superOnBlockStartBreak(itemStack, X, Y, Z, entityPlayer);
	}

	@Override
	public boolean onLeftClickEntity(Object itemStack, Object entityPlayer, Object entity) {
		return base.superOnLeftClickEntity(itemStack, entityPlayer, entity);
	}

	@Override
	public Object getIcon(Object itemStack, int renderPass, Object entityPlayer, Object itemStack1, int useRemaining) {
		return base.superGetIcon(itemStack, renderPass, entityPlayer, itemStack1, useRemaining);
	}

	@Override
	public int getRenderPasses(int metadata) {
		return base.superGetRenderPasses(metadata);
	}

	@Override
	public int getEntityLifespan(Object itemStack, Object world) {
		return base.superGetEntityLifespan(itemStack, world);
	}

	@Override
	public boolean hasCustomEntity(Object itemStack) {
		return base.superHasCustomEntity(itemStack);
	}

	@Override
	public Object createEntity(Object world, Object entity, Object itemStack) {
		return base.superCreateEntity(world, entity, itemStack);
	}

	@Override
	public boolean onEntityItemUpdate(Object entityItem) {
		return base.superOnEntityItemUpdate(entityItem);
	}

	@Override
	public Object[] getCreativeTabs() {
		return base.superGetCreativeTabs();
	}

	@Override
	public float getSmeltingExperience(Object itemStack) {
		return base.superGetSmeltingExperience(itemStack);
	}

	@Override
	public Object getIcon(Object itemStack, int pass) {
		return base.superGetIcon(itemStack, pass);
	}

	@Override
	public Object getChestGenBase(Object chestGenHooks, Object random, Object weightedRandomChestContent) {
		return base.superGetChestGenBase(chestGenHooks, random, weightedRandomChestContent);
	}

	@Override
	public boolean isValidArmor(Object itemStack, int armorType, Object entity) {
		return base.superIsValidArmor(itemStack, armorType, entity);
	}

	@Override
	public boolean isBookEnchantable(Object itemStack, Object itemStack1) {
		return base.superIsBookEnchantable(itemStack, itemStack1);
	}

	@Override
	public String getArmorTexture(Object itemStack, Object entity, int slot, String type) {
		return base.superGetArmorTexture(itemStack, entity, slot, type);
	}

	@Override
	public Object getFontRenderer(Object itemStack) {
		return base.superGetFontRenderer(itemStack);
	}

	@Override
	public Object getArmorModel(Object entityLivingBase, Object itemStack, int armorSlot) {
		return base.superGetArmorModel(entityLivingBase, itemStack, armorSlot);
	}

	@Override
	public boolean onEntitySwing(Object entityLivingBase, Object itemStack) {
		return base.superOnEntitySwing(entityLivingBase, itemStack);
	}

	@Override
	public void renderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
		base.superRenderHelmetOverlay(itemStack, entityPlayer, scaledResolution, partialTicks, hasScreen, mouseX, mouseY);
	}

	@Override
	public int getDamage(Object itemStack) {
		return base.superGetDamage(itemStack);
	}

	@Override
	public int getDisplayDamage(Object itemStack) {
		return base.superGetDisplayDamage(itemStack);
	}

	@Override
	public int getMaxDamage(Object itemStack) {
		return base.superGetMaxDamage(itemStack);
	}

	@Override
	public boolean isDamaged(Object itemStack) {
		return base.superIsDamaged(itemStack);
	}

	@Override
	public void setDamage(Object itemStack, int damage) {
		base.superSetDamage(itemStack, damage);
	}

	@Override
	public boolean canHarvestBlock(Object block, Object itemStack) {
		return base.superCanHarvestBlock(block, itemStack);
	}

	@Override
	public boolean hasEffect(Object itemStack, int pass) {
		return base.superHasEffect(itemStack, pass);
	}

	@Override
	public int getItemStackLimit(Object itemStack) {
		return base.superGetItemStackLimit(itemStack);
	}

	@Override
	public float getStrVsBlock(Object itemStack, Object block) {
		return base.superGetStrVsBlock(itemStack, block);
	}

	@Override
	public boolean onBlockDestroyed(Object itemStack, Object world, Object block, int p_150894_4_, int p_150894_5_, int p_150894_6_, Object entityLivingBase) {
		return base.superOnBlockDestroyed(itemStack, world, block, p_150894_4_, p_150894_5_, p_150894_6_, entityLivingBase);
	}

	@Override
	public boolean canHarvestBlock(Object block) {
		return base.superCanHarvestBlock(block);
	}

	@Override
	public void getSubItems(Object item, Object creativeTabs, List p_150895_3_) {
		base.superGetSubItems(item, creativeTabs, p_150895_3_);
		
	}

	@Override
	public Object getAttributeModifiers(Object itemStack) {
		return base.superGetAttributeModifiers(itemStack);
	}

	@Override
	public float getDigSpeed(Object itemStack, Object block, int metadata) {
		return base.superGetDigSpeed(itemStack, block, metadata);
	}

	@Override
	public void onUsingTick(Object itemStack, Object entityPlayer, int count) {
		base.superOnUsingTick(itemStack, entityPlayer, count);
		
	}

	@Override
	public Object getContainerItem(Object itemStack) {
		return base.superGetContainerItem(itemStack);
	}

	@Override
	public boolean hasContainerItem(Object itemStack) {
		return base.superHasContainerItem(itemStack);
	}

	@Override
	public boolean doesSneakBypassUse(Object world, int x, int y, int z, Object entityPlayer) {
		return base.superDoesSneakBypassUse(world, x, y, z, entityPlayer);
	}

	@Override
	public void onArmorTick(Object world, Object entityPlayer, Object itemStack) {
		base.superOnArmorTick(world, entityPlayer, itemStack);
		
	}

	@Override
	public boolean showDurabilityBar(Object itemStack) {
		return base.superShowDurabilityBar(itemStack);
	}

	@Override
	public double getDurabilityForDisplay(Object itemStack) {
		return base.superGetDurabilityForDisplay(itemStack);
	}

	@Override
	public void setHarvestLevel(String toolClass, int level) {
		base.superSetHarvestLevel(toolClass, level);
		
	}

	@Override
	public Object getToolClasses(Object itemStack) {
		return base.superGetToolClasses(itemStack);
	}

	@Override
	public int getHarvestLevel(Object itemStack, String toolClass) {
		return base.superGetHarvestLevel(itemStack, toolClass);
	}

	//164
	@Override
	public boolean onBlockDestroyed(Object itemStack, Object world, int par3, int par4, int par5, int par6, Object entityLivingBase) {
		return base.superOnBlockDestroyed(itemStack, world, par3, par4, par5, par6, entityLivingBase);
	}

	@Override
	public String getStatName() {
		return base.superGetStatName();
	}

	@Override
	public String getPotionEffect() {
		return base.superGetPotionEffect();
	}

	@Override
	public boolean isPotionIngredient() {
		return base.superIsPotionIngredient();
	}

	@Override
	public String getItemDisplayName(Object itemStack) {
		return base.superGetItemDisplayName(itemStack);
	}

	@Override
	public void getSubItems(int par1, Object creativeTabs, List par3List) {
		base.superGetSubItems(par1, creativeTabs, par3List);
	}

	@Override
	public float getStrVsBlock(Object itemStack, Object block, int metadata) {
		return base.superGetStrVsBlock(itemStack, block, metadata);
	}

	@Override
	public void onUsingItemTick(Object itemStack, Object entityPlayer, int count) {
		base.superOnUsingItemTick(itemStack, entityPlayer, count);
	}

	@Override
	public Object getContainerItemStack(Object itemStack) {
		return base.superGetContainerItemStack(itemStack);
	}

	@Override
	public boolean shouldPassSneakingClickToBlock(Object world, int par4, int par5, int par6) {
		return base.superShouldPassSneakingClickToBlock(world, par4, par5, par6);
	}

	@Override
	public void onArmorTickUpdate(Object world, Object entityPlayer, Object itemStack) {
		base.superOnArmorTickUpdate(world, entityPlayer, itemStack);
		
	}

	@Override
	public float getDamageVsEntity(Object entity, Object itemStack) {
		return base.superGetDamageVsEntity(entity, itemStack);
	}

	@Override
	public String getArmorTexture(Object itemStack, Object entity, int slot, int layer) {
		return base.superGetArmorTexture(itemStack, entity, slot, layer);
	}

	// 180~
	@Override
	public boolean onItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ) {
		return base.superOnItemUseFirst(itemStack, entityPlayer, world, blockPos, enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public boolean onBlockStartBreak(Object itemStack, Object blockPos, Object entityPlayer) {
		return base.superOnBlockStartBreak(itemStack, blockPos, entityPlayer);
	}

	@Override
	public void renderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks) {
		base.superRenderHelmetOverlay(itemStack, entityPlayer, scaledResolution, partialTicks);
	}

	@Override
	public int getMetadata(Object itemStack) {
		return base.superGetMetadata(itemStack);
	}

	@Override
	public boolean onBlockDestroyed(Object itemStack, Object world, Object block, Object blockPos, Object entityLivingBase) {
		return base.superOnBlockDestroyed(itemStack, world, block, blockPos, entityLivingBase);
	}

	@Override
	public float getDigSpeed(Object itemStack, Object iBlockState) {
		return base.superGetDigSpeed(itemStack, iBlockState);
	}

	@Override
	public boolean doesSneakBypassUse(Object world, Object blockPos, Object entityPlayer) {
		return base.superDoesSneakBypassUse(world, blockPos, entityPlayer);
	}

	@Override
	public boolean onItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float f, float f1, float f2) {
		return base.superOnItemUse(itemStack, entityPlayer, world, blockPos, enumFacing, f, f1, f2);
	}

	@Override
	public float func_150893_a(Object itemStack, Object block) {
		return base.superGetStrVsBlock(itemStack, block);
	}

	@Override
	public boolean func_150897_b(Object block) {
		return base.superCanHarvestBlock(block);
	}
}