package modchu.lib.modloader.mc162;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IItem;
import modchu.lib.Modchu_IItemMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Icon;
import net.minecraft.src.IconRegister;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.WeightedRandomChestContent;
import net.minecraft.src.World;

import com.google.common.collect.Multimap;

public class Modchu_Item extends Item implements Modchu_IItem {
	public Modchu_IItemMaster master;

	public Modchu_Item(HashMap<String, Object> map) {
		super((Integer) map.get("Integer"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_Item init instance="+instance);
		master = instance instanceof Modchu_IItemMaster ? (Modchu_IItemMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_Item init master="+master);
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
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return master != null ? master.onItemUse(itemStack, entityPlayer, world, par4, par5, par6, par7, par8, par9, par10) : super.onItemUse(itemStack, entityPlayer, world, par4, par5, par6, par7, par8, par9, par10);
	}

	@Override
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return super.onItemUse((ItemStack) itemStack, (EntityPlayer) entityPlayer, (World) world, par4, par5, par6, par7, par8, par9, par10);
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
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		return (ItemStack) (master != null ? master.onItemUseFinish(itemStack, world, entityPlayer) : super.onEaten(itemStack, world, entityPlayer));
	}

	@Override
	public ItemStack superOnEaten(Object itemStack, Object world, Object entityPlayer) {
		return super.onEaten((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
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
	public boolean func_111207_a(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
		return master != null ? master.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase) : super.func_111207_a(itemStack, entityPlayer, entityLivingBase);
	}

	@Override
	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase) {
		return super.func_111207_a((ItemStack) itemStack, (EntityPlayer) entityPlayer, (EntityLivingBase) entityLivingBase);
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
	public String getLocalizedName(ItemStack itemStack) {
		return master != null ? master.getUnlocalizedNameInefficiently(itemStack) : super.getLocalizedName(itemStack);
	}

	@Override
	public String superGetUnlocalizedNameInefficiently(Object itemStack) {
		return super.getLocalizedName((ItemStack) itemStack);
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
	public Multimap func_111205_h() {
		return (Multimap) (master != null ? master.getItemAttributeModifiers() : super.func_111205_h());
	}

	@Override
	public Multimap superGetItemAttributeModifiers() {
		return (super.func_111205_h());
	}

	@Override
	public Icon superGetIconIndex(Object itemStack) {
		return super.getIconIndex((ItemStack) itemStack);
	}
	// ~164
	@Override
	public float getStrVsBlock(ItemStack itemStack, Block block) {
		return master != null ? master.getStrVsBlock(itemStack, block) : super.getStrVsBlock(itemStack, block);
	}

	@Override
	public float superGetStrVsBlock(Object itemStack, Object block) {
		return super.getStrVsBlock((ItemStack) itemStack, (Block) block);
	}

	@Override
	public void getSubItems(int par1, CreativeTabs creativeTabs, List par3List) {
		if (master != null) master.getSubItems(par1, creativeTabs, par3List);
		else super.getSubItems(par1, creativeTabs, par3List);
	}

	@Override
	public void superGetSubItems(int par1, Object creativeTabs, List par3List) {
		super.getSubItems(par1, (CreativeTabs) creativeTabs, par3List);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, int par3, int par4, int par5, int par6, EntityLivingBase entityLivingBase) {
		return master != null ? master.onBlockDestroyed(itemStack, world, par3, par4, par5, par6, entityLivingBase) : super.onBlockDestroyed(itemStack, world, par3, par4, par5, par6, entityLivingBase);
	}

	@Override
	public boolean superOnBlockDestroyed(Object itemStack, Object world, int par3, int par4, int par5, int par6, Object entityLivingBase) {
		return super.onBlockDestroyed((ItemStack) itemStack, (World) world, par3, par4, par5, par6, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}

	@Override
	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}

	@Override
	public String getStatName() {
		return master != null ? master.getStatName() : super.getStatName();
	}

	@Override
	public String superGetStatName() {
		return super.getStatName();
	}

	@Override
	public String getPotionEffect() {
		return master != null ? master.getPotionEffect() : super.getPotionEffect();
	}

	@Override
	public String superGetPotionEffect() {
		return super.getPotionEffect();
	}

	@Override
	public boolean isPotionIngredient() {
		return master != null ? master.isPotionIngredient() : super.isPotionIngredient();
	}

	@Override
	public boolean superIsPotionIngredient() {
		return super.isPotionIngredient();
	}

	@Override
	public String getItemDisplayName(ItemStack itemStack) {
		return master != null ? master.getItemDisplayName(itemStack) : super.getItemDisplayName(itemStack);
	}

	@Override
	public String superGetItemDisplayName(Object itemStack) {
		return super.getItemDisplayName((ItemStack) itemStack);
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
		if (master != null) master.onUsingItemTick(itemStack, entityPlayer, count);
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

	public void registerIcons(Object iconRegister) {
	}
	// 164~
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

	public boolean onDroppedByPlayer(ItemStack itemStack, EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superOnDroppedByPlayer(Object itemStack, Object entityPlayer) {
		return false;
	}

	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return false;
	}

	public boolean isRepairable() {
		return false;
	}

	@Override
	public boolean superIsRepairable() {
		return false;
	}

	public Item setNoRepair() {
		return null;
	}

	@Override
	public Item superSetNoRepair() {
		return null;
	}

	public boolean onBlockStartBreak(ItemStack itemStack, int X, int Y, int Z, EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superOnBlockStartBreak(Object itemStack, int X, int Y, int Z, Object entityPlayer) {
		return false;
	}

	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
		return false;
	}

	@Override
	public boolean superOnLeftClickEntity(Object itemStack, Object entityPlayer, Object entity) {
		return false;
	}

	public Icon getIcon(ItemStack itemStack, int renderPass, EntityPlayer entityPlayer, ItemStack itemStack1, int useRemaining) {
		return null;
	}

	@Override
	public Icon superGetIcon(Object itemStack, int renderPass, Object entityPlayer, Object itemStack1, int useRemaining) {
		return null;
	}

	public int getRenderPasses(int metadata) {
		return -1;
	}

	@Override
	public int superGetRenderPasses(int metadata) {
		return -1;
	}

	public int getEntityLifespan(ItemStack itemStack, World world) {
		return -1;
	}

	@Override
	public int superGetEntityLifespan(Object itemStack, Object world) {
		return -1;
	}

	public boolean hasCustomEntity(ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superHasCustomEntity(Object itemStack) {
		return false;
	}

	public Entity createEntity(World world, Entity entity, ItemStack itemStack) {
		return null;
	}

	@Override
	public Entity superCreateEntity(Object world, Object entity, Object itemStack) {
		return null;
	}

	public boolean onEntityItemUpdate(EntityItem entityItem) {
		return false;
	}

	@Override
	public boolean superOnEntityItemUpdate(Object entityItem) {
		return false;
	}
/*
	public CreativeTabs[] getCreativeTabs() {
		return null;
	}
*/
	@Override
	public CreativeTabs[] superGetCreativeTabs() {
		return (CreativeTabs[]) Modchu_Reflect.invokeMethod(getClass(), "getCreativeTabs", this);
	}

	public float getSmeltingExperience(ItemStack itemStack) {
		return 0.0F;
	}

	@Override
	public float superGetSmeltingExperience(Object itemStack) {
		return 0.0F;
	}

	public Icon getIcon(ItemStack itemStack, int pass) {
		return null;
	}

	@Override
	public Icon superGetIcon(Object itemStack, int pass) {
		return null;
	}

	public WeightedRandomChestContent getChestGenBase(Object chestGenHooks, Random random, WeightedRandomChestContent weightedRandomChestContent) {
		return null;
	}

	@Override
	public WeightedRandomChestContent superGetChestGenBase(Object chestGenHooks, Object random, Object weightedRandomChestContent) {
		return null;
	}

	public boolean isValidArmor(ItemStack itemStack, int armorType, Entity entity) {
		return false;
	}

	public boolean superIsValidArmor(Object itemStack, int armorType, Object entity) {
		return false;
	}

	public boolean isBookEnchantable(ItemStack itemStack, ItemStack itemStack1) {
		return false;
	}

	@Override
	public boolean superIsBookEnchantable(Object itemStack, Object itemStack1) {
		return false;
	}

	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		return null;
	}

	public String superGetArmorTexture(Object itemStack, Object entity, int slot, String type) {
		return null;
	}

	public FontRenderer getFontRenderer(ItemStack itemStack) {
		return null;
	}

	@Override
	public FontRenderer superGetFontRenderer(Object itemStack) {
		return null;
	}

	public ModelBiped getArmorModel(EntityLivingBase entityLivingBase, ItemStack itemStack, int armorSlot) {
		return null;
	}

	@Override
	public ModelBiped superGetArmorModel(Object entityLivingBase, Object itemStack, int armorSlot) {
		return null;
	}

	public boolean onEntitySwing(EntityLivingBase entityLivingBase, ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superOnEntitySwing(Object entityLivingBase, Object itemStack) {
		return false;
	}

	public void renderHelmetOverlay(ItemStack itemStack, EntityPlayer entityPlayer, ScaledResolution scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
	}

	@Override
	public void superRenderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
	}

	public int getDamage(ItemStack itemStack) {
		return -1;
	}

	@Override
	public int superGetDamage(Object itemStack) {
		return -1;
	}

	public int getDisplayDamage(ItemStack itemStack) {
		return -1;
	}

	@Override
	public int superGetDisplayDamage(Object itemStack) {
		return -1;
	}

	public int getMaxDamage(ItemStack itemStack) {
		return -1;
	}

	@Override
	public int superGetMaxDamage(Object itemStack) {
		return -1;
	}

	public boolean isDamaged(ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superIsDamaged(Object itemStack) {
		return false;
	}

	public void setDamage(ItemStack itemStack, int damage) {
	}

	@Override
	public void superSetDamage(Object itemStack, int damage) {
	}

	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superCanHarvestBlock(Object block, Object itemStack) {
		return false;
	}

	public boolean hasEffect(ItemStack itemStack, int pass) {
		return false;
	}

	@Override
	public boolean superHasEffect(Object itemStack, int pass) {
		return false;
	}

	public int getItemStackLimit(ItemStack itemStack) {
		return -1;
	}

	@Override
	public int superGetItemStackLimit(Object itemStack) {
		return -1;
	}
	// 172~
	public float func_150893_a(ItemStack itemStack, Block block) {
		return 0.0F;
	}

	public float superFunc_150893_a(Object itemStack, Object block) {
		return 0.0F;
	}

	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase entityLivingBase) {
		return false;
	}

	@Override
	public boolean superOnBlockDestroyed(Object itemStack, Object world, Object block, int p_150894_4_, int p_150894_5_, int p_150894_6_, Object entityLivingBase) {
		return false;
	}

	public boolean func_150897_b(Block block) {
		return false;
	}

	public boolean superFunc_150897_b(Object block) {
		return false;
	}

	public void getSubItems(Item item, CreativeTabs creativeTabs, List p_150895_3_) {
	}

	@Override
	public void superGetSubItems(Object item, Object creativeTabs, Object p_150895_3_) {
	}

	public Multimap getAttributeModifiers(ItemStack itemStack) {
		return null;
	}

	@Override
	public Multimap superGetAttributeModifiers(Object itemStack) {
		return null;
	}

	public float getDigSpeed(ItemStack itemStack, Block block, int metadata) {
		return 0.0F;
	}

	@Override
	public float superGetDigSpeed(Object itemStack, Object block, int metadata) {
		return 0.0F;
	}

	public void onUsingTick(ItemStack itemStack, EntityPlayer entityPlayer, int count) {
	}

	@Override
	public void superOnUsingTick(Object itemStack, Object entityPlayer, int count) {
	}

	public ItemStack getContainerItem(ItemStack itemStack) {
		return null;
	}

	@Override
	public ItemStack superGetContainerItem(Object itemStack) {
		return null;
	}

	public boolean hasContainerItem(ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superHasContainerItem(Object itemStack) {
		return false;
	}

	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superDoesSneakBypassUse(Object world, int x, int y, int z, Object entityPlayer) {
		return false;
	}

	public void onArmorTick(World world, EntityPlayer entityPlayer, ItemStack itemStack) {
	}

	@Override
	public void superOnArmorTick(Object world, Object entityPlayer, Object itemStack) {
	}

	public boolean showDurabilityBar(ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean superShowDurabilityBar(Object itemStack) {
		return false;
	}

	public double getDurabilityForDisplay(ItemStack itemStack) {
		return 0.0D;
	}

	@Override
	public double superGetDurabilityForDisplay(Object itemStack) {
		return 0.0D;
	}

	public void setHarvestLevel(String toolClass, int level) {
	}

	@Override
	public void superSetHarvestLevel(String toolClass, int level) {
	}

	public Set<String> getToolClasses(ItemStack itemStack) {
		return null;
	}

	@Override
	public Set<String> superGetToolClasses(Object itemStack) {
		return null;
	}

	public int getHarvestLevel(ItemStack itemStack, String toolClass) {
		return -1;
	}

	@Override
	public int superGetHarvestLevel(Object itemStack, String toolClass) {
		return -1;
	}

	// ~179
	@Override
	public int getSpriteNumber() {
		return master != null ? master.getSpriteNumber() : super.getSpriteNumber();
	}

	@Override
	public int superGetSpriteNumber() {
		return super.getSpriteNumber();
	}

	@Override
	public Icon getIconFromDamage(int par1) {
		return (Icon) (master != null ? master.getIconFromDamage(par1) : super.getIconFromDamage(par1));
	}

	@Override
	public Icon superGetIconFromDamage(int par1) {
		return super.getIconFromDamage(par1);
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
		return master != null ? master.doesContainerItemLeaveCraftingGrid(itemStack) : super.doesContainerItemLeaveCraftingGrid(itemStack);
	}

	@Override
	public boolean superDoesContainerItemLeaveCraftingGrid(Object itemStack) {
		return super.doesContainerItemLeaveCraftingGrid((ItemStack) itemStack);
	}

	@Override
	public boolean requiresMultipleRenderPasses() {
		return master != null ? master.requiresMultipleRenderPasses() : super.requiresMultipleRenderPasses();
	}

	@Override
	public boolean superRequiresMultipleRenderPasses() {
		return super.requiresMultipleRenderPasses();
	}

	@Override
	public Icon getIconFromDamageForRenderPass(int par1, int par2) {
		return (Icon) (master != null ? master.getIconFromDamageForRenderPass(par1, par2) : super.getIconFromDamageForRenderPass(par1, par2));
	}

	@Override
	public Icon superGetIconFromDamageForRenderPass(int par1, int par2) {
		return super.getIconFromDamageForRenderPass(par1, par2);
	}

	@Override
	public void registerIcons(IconRegister iIconRegister) {
		if (master != null) master.registerIcons(iIconRegister);
		else super.registerIcons(iIconRegister);
	}

	@Override
	public void superRegisterIcons(Object iIconRegister) {
		super.registerIcons((IconRegister) iIconRegister);
	}

	@Override
	public Item func_111206_d(String par1Str) {
		return (Item) (master != null ? master.setTextureName(par1Str) : super.func_111206_d(par1Str));
	}

	@Override
	public Item superSetTextureName(String par1Str) {
		return super.func_111206_d(par1Str);
	}

	@Override
	protected String func_111208_A() {
		return master != null ? master.getIconString() : super.func_111208_A();
	}

	@Override
	public String superGetIconString() {
		return super.func_111208_A();
	}

	// 180~
	@Override
	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public boolean superOnBlockStartBreak(Object itemStack, Object blockPos, Object entityPlayer) {
		return false;
	}

	@Override
	public void superRenderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks) {
	}

	@Override
	public int superGetMetadata(Object itemStack) {
		return 0;
	}

	@Override
	public boolean superOnBlockDestroyed(Object itemStack, Object world, Object block, Object blockPos, Object entityLivingBase) {
		return false;
	}

	@Override
	public float superGetDigSpeed(Object itemStack, Object iBlockState) {
		return 0;
	}

	@Override
	public boolean superDoesSneakBypassUse(Object world, Object blockPos, Object entityPlayer) {
		return false;
	}

	@Override
	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, Object blockPos, Object enumFacing, float f, float f1, float f2) {
		return false;
	}

	@Override
	public Object superOnItemUseFinish(Object itemStack, Object world, Object entityPlayer) {
		return superOnEaten(itemStack, world, entityPlayer);
	}
	// 190~
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
	public boolean superUpdateItemStackNBT(Object nBTTagCompound) {
		return false;
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
	public int superGetItemEnchantability(Object itemStack) {
		return -1;
	}

	@Override
	public boolean superIsBeaconPayment(Object itemStack) {
		return false;
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
