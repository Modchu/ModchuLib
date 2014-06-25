package modchu.lib.characteristic;

import java.util.List;
import java.util.Random;
import java.util.Set;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IItem;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.google.common.collect.Multimap;

public class Modchu_Item extends Item {
	public Modchu_IItem master;

	public Modchu_Item(Class masterClass, int i) {
		super(i);
		Modchu_Debug.mDebug("Modchu_Item init i="+i);
		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_Item.class, Object[].class }, new Object[]{ this, new Object[]{ i } });
		Modchu_Debug.mDebug("Modchu_Item init instance="+instance);
		master = instance instanceof Modchu_IItem ? (Modchu_IItem) instance : null;
		Modchu_Debug.mDebug("Modchu_Item init master="+master);
	}

	@Override
	public Item setMaxStackSize(int par1) {
		return (Item) (master != null ? master.setMaxStackSize(par1) : super.setMaxStackSize(par1));
	}

	public Item superSetMaxStackSize(int par1) {
		return super.setMaxStackSize(par1);
	}

	@Override
	public int getSpriteNumber() {
		return master != null ? master.getSpriteNumber() : super.getSpriteNumber();
	}

	public int superGetSpriteNumber() {
		return super.getSpriteNumber();
	}

	@Override
	public Icon getIconFromDamage(int par1) {
		return (Icon) (master != null ? master.getIconFromDamage(par1) : super.getIconFromDamage(par1));
	}

	public Icon superGetIconFromDamage(int par1) {
		return super.getIconFromDamage(par1);
	}

	@Override
	public Icon getIconIndex(ItemStack itemStack) {
		return (Icon) (master != null ? master.getIconIndex(itemStack) : super.getIconIndex(itemStack));
	}

	public Icon superGetIconIndex(Object itemStack) {
		return super.getIconIndex((ItemStack) itemStack);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return master != null ? master.onItemUse(itemStack, entityPlayer, world, par4, par5, par6, par7, par8, par9, par10) : super.onItemUse(itemStack, entityPlayer, world, par4, par5, par6, par7, par8, par9, par10);
	}

	public boolean superOnItemUse(Object itemStack, Object entityPlayer, Object world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		return super.onItemUse((ItemStack) itemStack, (EntityPlayer) entityPlayer, (World) world, par4, par5, par6, par7, par8, par9, par10);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		return (ItemStack) (master != null ? master.onItemRightClick(itemStack, world, entityPlayer) : super.onItemRightClick(itemStack, world, entityPlayer));
	}

	public ItemStack superOnItemRightClick(Object itemStack, Object world, Object entityPlayer) {
		return super.onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		return (ItemStack) (master != null ? master.onEaten(itemStack, world, entityPlayer) : super.onEaten(itemStack, world, entityPlayer));
	}

	public ItemStack superOnEaten(Object itemStack, Object world, Object entityPlayer) {
		return super.onEaten((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public int getItemStackLimit() {
		return master != null ? master.getItemStackLimit() : super.getItemStackLimit();
	}

	public int superGetItemStackLimit() {
		return super.getItemStackLimit();
	}

	@Override
	public int getMetadata(int par1) {
		return master != null ? master.getMetadata(par1) : super.getMetadata(par1);
	}

	public int superGetMetadata(int par1) {
		return super.getMetadata(par1);
	}

	@Override
	public boolean getHasSubtypes() {
		return master != null ? master.getHasSubtypes() : super.getHasSubtypes();
	}

	public boolean superGetHasSubtypes() {
		return super.getHasSubtypes();
	}

	@Override
	public Item setHasSubtypes(boolean par1) {
		return (Item) (master != null ? master.setHasSubtypes(par1) : super.setHasSubtypes(par1));
	}

	public Item superSetHasSubtypes(boolean par1) {
		return super.setHasSubtypes(par1);
	}

	@Override
	public int getMaxDamage() {
		return master != null ? master.getMaxDamage() : super.getMaxDamage();
	}

	public int superGetMaxDamage() {
		return super.getMaxDamage();
	}

	@Override
	public Item setMaxDamage(int par1) {
		return (Item) (master != null ? master.setMaxDamage(par1) : super.setMaxDamage(par1));
	}

	public Item superSetMaxDamage(int par1) {
		return super.setMaxDamage(par1);
	}

	@Override
	public boolean isDamageable() {
		return master != null ? master.isDamageable() : super.isDamageable();
	}

	public boolean superIsDamageable() {
		return super.isDamageable();
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.hitEntity(itemStack, entityLivingBase, entityLivingBase1) : super.hitEntity(itemStack, entityLivingBase, entityLivingBase1);
	}

	public boolean superHitEntity(Object itemStack, Object entityLivingBase, Object entityLivingBase1) {
		return super.hitEntity((ItemStack) itemStack, (EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
		return master != null ? master.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase) : super.itemInteractionForEntity(itemStack, entityPlayer, entityLivingBase);
	}

	public boolean superItemInteractionForEntity(Object itemStack, Object entityPlayer, Object entityLivingBase) {
		return super.itemInteractionForEntity((ItemStack) itemStack, (EntityPlayer) entityPlayer, (EntityLivingBase) entityLivingBase);
	}

	@Override
	public Item setFull3D() {
		return (Item) (master != null ? master.setFull3D() : super.setFull3D());
	}

	public Item superSetFull3D() {
		return (Item) (super.setFull3D());
	}

	@Override
	public boolean isFull3D() {
		return master != null ? master.isFull3D() : super.isFull3D();
	}

	public boolean superIsFull3D() {
		return super.isFull3D();
	}

	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return master != null ? master.shouldRotateAroundWhenRendering() : super.shouldRotateAroundWhenRendering();
	}

	public boolean superShouldRotateAroundWhenRendering() {
		return super.shouldRotateAroundWhenRendering();
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		Modchu_Debug.mDebug("Modchu_Item setUnlocalizedName par1Str="+par1Str+" master="+master);
		return (Item) (master != null ? master.setUnlocalizedName(par1Str) : super.setUnlocalizedName(par1Str));
	}

	public Item superSetUnlocalizedName(String par1Str) {
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	public String getUnlocalizedNameInefficiently(ItemStack itemStack) {
		return master != null ? master.getUnlocalizedNameInefficiently(itemStack) : super.getUnlocalizedNameInefficiently(itemStack);
	}

	public String superGetUnlocalizedNameInefficiently(Object itemStack) {
		return super.getUnlocalizedNameInefficiently((ItemStack) itemStack);
	}

	@Override
	public String getUnlocalizedName() {
		return master != null ? master.getUnlocalizedName() : super.getUnlocalizedName();
	}

	public String superGetUnlocalizedName() {
		return super.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return master != null ? master.getUnlocalizedName(itemStack) : super.getUnlocalizedName(itemStack);
	}

	public String superGetUnlocalizedName(Object itemStack) {
		return super.getUnlocalizedName((ItemStack) itemStack);
	}

	@Override
	public Item setContainerItem(Item item) {
		return (Item) (master != null ? master.setContainerItem(item) : super.setContainerItem(item));
	}

	public Item superSetContainerItem(Object item) {
		return super.setContainerItem((Item) item);
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
		return master != null ? master.doesContainerItemLeaveCraftingGrid(itemStack) : super.doesContainerItemLeaveCraftingGrid(itemStack);
	}

	public boolean superDoesContainerItemLeaveCraftingGrid(Object itemStack) {
		return super.doesContainerItemLeaveCraftingGrid((ItemStack) itemStack);
	}

	@Override
	public boolean getShareTag() {
		return master != null ? master.getShareTag() : super.getShareTag();
	}

	public boolean superGetShareTag() {
		return super.getShareTag();
	}

	@Override
	public Item getContainerItem() {
		return (Item) (master != null ? master.getContainerItem() : super.getContainerItem());
	}

	public Item superGetContainerItem() {
		return (Item) (super.getContainerItem());
	}

	@Override
	public boolean hasContainerItem() {
		return master != null ? master.hasContainerItem() : super.hasContainerItem();
	}

	public boolean superHasContainerItem() {
		return super.hasContainerItem();
	}

	@Override
	public int getColorFromItemStack(ItemStack itemStack, int par2) {
		return master != null ? master.getColorFromItemStack(itemStack, par2) : super.getColorFromItemStack(itemStack, par2);
	}

	public int superGetColorFromItemStack(Object itemStack, int par2) {
		return super.getColorFromItemStack((ItemStack) itemStack, par2);
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
		if (master != null) master.onUpdate(itemStack, world, entity, par4, par5);
		else super.onUpdate(itemStack, world, entity, par4, par5);
	}

	public void superOnUpdate(Object itemStack, Object world, Object entity, int par4, boolean par5) {
		super.onUpdate((ItemStack) itemStack, (World) world, (Entity) entity, par4, par5);
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if (master != null) master.onCreated(itemStack, world, entityPlayer);
		else super.onCreated(itemStack, world, entityPlayer);
	}

	public void superOnCreated(Object itemStack, Object world, Object entityPlayer) {
		super.onCreated((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isMap() {
		return master != null ? master.isMap() : super.isMap();
	}

	public boolean superIsMap() {
		return super.isMap();
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
		return (EnumAction) (master != null ? master.getItemUseAction(itemStack) : super.getItemUseAction(itemStack));
	}

	public EnumAction superGetItemUseAction(Object itemStack) {
		return super.getItemUseAction((ItemStack) itemStack);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
		return master != null ? master.getMaxItemUseDuration(itemStack) : super.getMaxItemUseDuration(itemStack);
	}

	public int superGetMaxItemUseDuration(Object itemStack) {
		return super.getMaxItemUseDuration((ItemStack) itemStack);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int par4) {
		if (master != null) master.onPlayerStoppedUsing(itemStack, world, entityPlayer, par4);
		else super.onPlayerStoppedUsing(itemStack, world, entityPlayer, par4);
	}

	public void superOnPlayerStoppedUsing(Object itemStack, Object world, Object entityPlayer, int par4) {
		super.onPlayerStoppedUsing((ItemStack) itemStack, (World) world, (EntityPlayer) entityPlayer, par4);
	}

	@Override
	public Item setPotionEffect(String par1Str) {
		return (Item) (master != null ? master.setPotionEffect(par1Str) : super.setPotionEffect(par1Str));
	}

	public Item superSetPotionEffect(String par1Str) {
		return super.setPotionEffect(par1Str);
	}

	@Override
	public String getPotionEffect(ItemStack itemStack) {
		return master != null ? master.getPotionEffect(itemStack) : super.getPotionEffect(itemStack);
	}

	public String superGetPotionEffect(Object itemStack) {
		return super.getPotionEffect((ItemStack) itemStack);
	}

	@Override
	public boolean isPotionIngredient(ItemStack itemStack) {
		return master != null ? master.isPotionIngredient(itemStack) : super.isPotionIngredient(itemStack);
	}

	public boolean superIsPotionIngredient(Object itemStack) {
		return super.isPotionIngredient((ItemStack) itemStack);
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List par3List, boolean par4) {
		if (master != null) master.addInformation(itemStack, entityPlayer, par3List, par4);
		else super.addInformation(itemStack, entityPlayer, par3List, par4);
	}

	public void superAddInformation(Object itemStack, Object entityPlayer, List par3List, boolean par4) {
		super.addInformation((ItemStack) itemStack, (EntityPlayer) entityPlayer, par3List, par4);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return master != null ? master.getItemStackDisplayName(itemStack) : super.getItemStackDisplayName(itemStack);
	}

	public String superGetItemStackDisplayName(Object itemStack) {
		return super.getItemStackDisplayName((ItemStack) itemStack);
	}

	@Override
	public boolean hasEffect(ItemStack itemStack) {
		return master != null ? master.hasEffect(itemStack) : super.hasEffect(itemStack);
	}

	public boolean superHasEffect(Object itemStack) {
		return super.hasEffect((ItemStack) itemStack);
	}

	@Override
	public EnumRarity getRarity(ItemStack itemStack) {
		return (EnumRarity) (master != null ? master.getRarity(itemStack) : super.getRarity(itemStack));
	}

	public EnumRarity superGetRarity(Object itemStack) {
		return super.getRarity((ItemStack) itemStack);
	}

	@Override
	public boolean isItemTool(ItemStack itemStack) {
		return master != null ? master.isItemTool(itemStack) : super.isItemTool(itemStack);
	}

	public boolean superIsItemTool(Object itemStack) {
		return super.isItemTool((ItemStack) itemStack);
	}

	@Override
	protected MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityPlayer entityPlayer, boolean par3) {
		return (MovingObjectPosition) (master != null ? master.getMovingObjectPositionFromPlayer(world, entityPlayer, par3) : super.getMovingObjectPositionFromPlayer(world, entityPlayer, par3));
	}

	public MovingObjectPosition superGetMovingObjectPositionFromPlayer(Object world, Object entityPlayer, boolean par3) {
		return super.getMovingObjectPositionFromPlayer((World) world, (EntityPlayer) entityPlayer, par3);
	}

	@Override
	public int getItemEnchantability() {
		return master != null ? master.getItemEnchantability() : super.getItemEnchantability();
	}

	public int superGetItemEnchantability() {
		return super.getItemEnchantability();
	}

	@Override
	public boolean requiresMultipleRenderPasses() {
		return master != null ? master.requiresMultipleRenderPasses() : super.requiresMultipleRenderPasses();
	}

	public boolean superRequiresMultipleRenderPasses() {
		return super.requiresMultipleRenderPasses();
	}

	@Override
	public Icon getIconFromDamageForRenderPass(int par1, int par2) {
		return (Icon) (master != null ? master.getIconFromDamageForRenderPass(par1, par2) : super.getIconFromDamageForRenderPass(par1, par2));
	}

	public Icon superGetIconFromDamageForRenderPass(int par1, int par2) {
		return super.getIconFromDamageForRenderPass(par1, par2);
	}

	@Override
	public Item setCreativeTab(CreativeTabs creativeTabs) {
		return (Item) (master != null ? master.setCreativeTab(creativeTabs) : super.setCreativeTab(creativeTabs));
	}

	public Item superSetCreativeTab(Object creativeTabs) {
		return super.setCreativeTab((CreativeTabs) creativeTabs);
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return (CreativeTabs) (master != null ? master.getCreativeTab() : super.getCreativeTab());
	}

	public CreativeTabs superGetCreativeTab() {
		return (CreativeTabs) (super.getCreativeTab());
	}

	@Override
	public boolean canItemEditBlocks() {
		return master != null ? master.canItemEditBlocks() : super.canItemEditBlocks();
	}

	public boolean superCanItemEditBlocks() {
		return super.canItemEditBlocks();
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack1) {
		return master != null ? master.getIsRepairable(itemStack, itemStack1) : super.getIsRepairable(itemStack, itemStack1);
	}

	public boolean superGetIsRepairable(Object itemStack, Object itemStack1) {
		return super.getIsRepairable((ItemStack) itemStack, (ItemStack) itemStack1);
	}

	@Override
	public void registerIcons(IconRegister iIconRegister) {
		if (master != null) master.registerIcons(iIconRegister);
		else super.registerIcons(iIconRegister);
	}

	public void superRegisterIcons(Object iIconRegister) {
		super.registerIcons((IconRegister) iIconRegister);
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		return (Multimap) (master != null ? master.getItemAttributeModifiers() : super.getItemAttributeModifiers());
	}

	public Multimap superGetItemAttributeModifiers() {
		return (Multimap) (super.getItemAttributeModifiers());
	}

	@Override
	public Item setTextureName(String par1Str) {
		return (Item) (master != null ? master.setTextureName(par1Str) : super.setTextureName(par1Str));
	}

	public Item superSetTextureName(String par1Str) {
		return super.setTextureName(par1Str);
	}

	@Override
	protected String getIconString() {
		return master != null ? master.getIconString() : super.getIconString();
	}

	public String superGetIconString() {
		return super.getIconString();
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemStack, EntityPlayer entityPlayer) {
		return master != null ? master.onDroppedByPlayer(itemStack, entityPlayer) : super.onDroppedByPlayer(itemStack, entityPlayer);
	}

	public boolean superOnDroppedByPlayer(Object itemStack, Object entityPlayer) {
		return super.onDroppedByPlayer((ItemStack) itemStack, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return master != null ? master.onItemUseFirst(itemStack, entityPlayer, world, x, y, z, side, hitX, hitY, hitZ) : super.onItemUseFirst(itemStack, entityPlayer, world, x, y, z, side, hitX, hitY, hitZ);
	}

	public boolean superOnItemUseFirst(Object itemStack, Object entityPlayer, Object world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return super.onItemUseFirst((ItemStack) itemStack, (EntityPlayer) entityPlayer, (World) world, x, y, z, side, hitX, hitY, hitZ);
	}

	@Override
	public boolean isRepairable() {
		return master != null ? master.isRepairable() : super.isRepairable();
	}

	public boolean superIsRepairable() {
		return super.isRepairable();
	}

	@Override
	public Item setNoRepair() {
		return (Item) (master != null ? master.setNoRepair() : super.setNoRepair());
	}

	public Item superSetNoRepair() {
		return (Item) (super.setNoRepair());
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemStack, int X, int Y, int Z, EntityPlayer entityPlayer) {
		return master != null ? master.onBlockStartBreak(itemStack, X, Y, Z, entityPlayer) : super.onBlockStartBreak(itemStack, X, Y, Z, entityPlayer);
	}

	public boolean superOnBlockStartBreak(Object itemStack, int X, int Y, int Z, Object entityPlayer) {
		return super.onBlockStartBreak((ItemStack) itemStack, X, Y, Z, (EntityPlayer) entityPlayer);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
		return master != null ? master.onLeftClickEntity(itemStack, entityPlayer, entity) : super.onLeftClickEntity(itemStack, entityPlayer, entity);
	}

	public boolean superOnLeftClickEntity(Object itemStack, Object entityPlayer, Object entity) {
		return super.onLeftClickEntity((ItemStack) itemStack, (EntityPlayer) entityPlayer, (Entity) entity);
	}

	@Override
	public Icon getIcon(ItemStack itemStack, int renderPass, EntityPlayer entityPlayer, ItemStack itemStack1, int useRemaining) {
		return (Icon) (master != null ? master.getIcon(itemStack, renderPass, entityPlayer, itemStack1, useRemaining) : super.getIcon(itemStack, renderPass, entityPlayer, itemStack1, useRemaining));
	}

	public Icon superGetIcon(Object itemStack, int renderPass, Object entityPlayer, Object itemStack1, int useRemaining) {
		return super.getIcon((ItemStack) itemStack, renderPass, (EntityPlayer) entityPlayer, (ItemStack) itemStack1, useRemaining);
	}

	@Override
	public int getRenderPasses(int metadata) {
		return master != null ? master.getRenderPasses(metadata) : super.getRenderPasses(metadata);
	}

	public int superGetRenderPasses(int metadata) {
		return super.getRenderPasses(metadata);
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return master != null ? master.getEntityLifespan(itemStack, world) : super.getEntityLifespan(itemStack, world);
	}

	public int superGetEntityLifespan(Object itemStack, Object world) {
		return super.getEntityLifespan((ItemStack) itemStack, (World) world);
	}

	@Override
	public boolean hasCustomEntity(ItemStack itemStack) {
		return master != null ? master.hasCustomEntity(itemStack) : super.hasCustomEntity(itemStack);
	}

	public boolean superHasCustomEntity(Object itemStack) {
		return super.hasCustomEntity((ItemStack) itemStack);
	}

	@Override
	public Entity createEntity(World world, Entity entity, ItemStack itemStack) {
		return (Entity) (master != null ? master.createEntity(world, entity, itemStack) : super.createEntity(world, entity, itemStack));
	}

	public Entity superCreateEntity(Object world, Object entity, Object itemStack) {
		return super.createEntity((World) world, (Entity) entity, (ItemStack) itemStack);
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		return master != null ? master.onEntityItemUpdate(entityItem) : super.onEntityItemUpdate(entityItem);
	}

	public boolean superOnEntityItemUpdate(Object entityItem) {
		return super.onEntityItemUpdate((EntityItem) entityItem);
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
		return (CreativeTabs[]) (master != null ? master.getCreativeTabs() : super.getCreativeTabs());
	}

	public CreativeTabs[] superGetCreativeTabs() {
		return (CreativeTabs[]) (super.getCreativeTabs());
	}

	@Override
	public float getSmeltingExperience(ItemStack itemStack) {
		return master != null ? master.getSmeltingExperience(itemStack) : super.getSmeltingExperience(itemStack);
	}

	public float superGetSmeltingExperience(Object itemStack) {
		return super.getSmeltingExperience((ItemStack) itemStack);
	}

	@Override
	public Icon getIcon(ItemStack itemStack, int pass) {
		return (Icon) (master != null ? master.getIcon(itemStack, pass) : super.getIcon(itemStack, pass));
	}

	public Icon superGetIcon(Object itemStack, int pass) {
		return super.getIcon((ItemStack) itemStack, pass);
	}

	@Override
	public WeightedRandomChestContent getChestGenBase(ChestGenHooks chestGenHooks, Random random, WeightedRandomChestContent weightedRandomChestContent) {
		return (WeightedRandomChestContent) (master != null ? master.getChestGenBase(chestGenHooks, random, weightedRandomChestContent) : super.getChestGenBase(chestGenHooks, random, weightedRandomChestContent));
	}

	public WeightedRandomChestContent superGetChestGenBase(Object chestGenHooks, Object random, Object weightedRandomChestContent) {
		return super.getChestGenBase((ChestGenHooks) chestGenHooks, (Random) random, (WeightedRandomChestContent) weightedRandomChestContent);
	}

	@Override
	public boolean isValidArmor(ItemStack itemStack, int armorType, Entity entity) {
		return master != null ? master.isValidArmor(itemStack, armorType, entity) : super.isValidArmor(itemStack, armorType, entity);
	}

	public boolean superIsValidArmor(Object itemStack, int armorType, Object entity) {
		return super.isValidArmor((ItemStack) itemStack, armorType, (Entity) entity);
	}

	@Override
	public boolean isBookEnchantable(ItemStack itemStack, ItemStack itemStack1) {
		return master != null ? master.isBookEnchantable(itemStack, itemStack1) : super.isBookEnchantable(itemStack, itemStack1);
	}

	public boolean superIsBookEnchantable(Object itemStack, Object itemStack1) {
		return super.isBookEnchantable((ItemStack) itemStack, (ItemStack) itemStack1);
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		return master != null ? master.getArmorTexture(itemStack, entity, slot, type) : super.getArmorTexture(itemStack, entity, slot, type);
	}

	public String superGetArmorTexture(Object itemStack, Object entity, int slot, String type) {
		return super.getArmorTexture((ItemStack) itemStack, (Entity) entity, slot, type);
	}

	@Override
	public FontRenderer getFontRenderer(ItemStack itemStack) {
		return (FontRenderer) (master != null ? master.getFontRenderer(itemStack) : super.getFontRenderer(itemStack));
	}

	public FontRenderer superGetFontRenderer(Object itemStack) {
		return super.getFontRenderer((ItemStack) itemStack);
	}

	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLivingBase, ItemStack itemStack, int armorSlot) {
		return (ModelBiped) (master != null ? master.getArmorModel(entityLivingBase, itemStack, armorSlot) : super.getArmorModel(entityLivingBase, itemStack, armorSlot));
	}

	public ModelBiped superGetArmorModel(Object entityLivingBase, Object itemStack, int armorSlot) {
		return super.getArmorModel((EntityLivingBase) entityLivingBase, (ItemStack) itemStack, armorSlot);
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLivingBase, ItemStack itemStack) {
		return master != null ? master.onEntitySwing(entityLivingBase, itemStack) : super.onEntitySwing(entityLivingBase, itemStack);
	}

	public boolean superOnEntitySwing(Object entityLivingBase, Object itemStack) {
		return super.onEntitySwing((EntityLivingBase) entityLivingBase, (ItemStack) itemStack);
	}

	@Override
	public void renderHelmetOverlay(ItemStack itemStack, EntityPlayer entityPlayer, ScaledResolution scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
		if (master != null) master.renderHelmetOverlay(itemStack, entityPlayer, scaledResolution, partialTicks, hasScreen, mouseX, mouseY);
		else super.renderHelmetOverlay(itemStack, entityPlayer, scaledResolution, partialTicks, hasScreen, mouseX, mouseY);
	}

	public void superRenderHelmetOverlay(Object itemStack, Object entityPlayer, Object scaledResolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
		super.renderHelmetOverlay((ItemStack) itemStack, (EntityPlayer) entityPlayer, (ScaledResolution) scaledResolution, partialTicks, hasScreen, mouseX, mouseY);
	}

	@Override
	public int getDamage(ItemStack itemStack) {
		return master != null ? master.getDamage(itemStack) : super.getDamage(itemStack);
	}

	public int superGetDamage(Object itemStack) {
		return super.getDamage((ItemStack) itemStack);
	}

	@Override
	public int getDisplayDamage(ItemStack itemStack) {
		return master != null ? master.getDisplayDamage(itemStack) : super.getDisplayDamage(itemStack);
	}

	public int superGetDisplayDamage(Object itemStack) {
		return super.getDisplayDamage((ItemStack) itemStack);
	}

	@Override
	public int getMaxDamage(ItemStack itemStack) {
		return master != null ? master.getMaxDamage(itemStack) : super.getMaxDamage(itemStack);
	}

	public int superGetMaxDamage(Object itemStack) {
		return super.getMaxDamage((ItemStack) itemStack);
	}

	@Override
	public boolean isDamaged(ItemStack itemStack) {
		return master != null ? master.isDamaged(itemStack) : super.isDamaged(itemStack);
	}

	public boolean superIsDamaged(Object itemStack) {
		return super.isDamaged((ItemStack) itemStack);
	}

	@Override
	public void setDamage(ItemStack itemStack, int damage) {
		if (master != null) master.setDamage(itemStack, damage);
		else super.setDamage(itemStack, damage);
	}

	public void superSetDamage(Object itemStack, int damage) {
		super.setDamage((ItemStack) itemStack, damage);
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
		return master != null ? master.canHarvestBlock(block, itemStack) : super.canHarvestBlock(block, itemStack);
	}

	public boolean superCanHarvestBlock(Object block, Object itemStack) {
		return super.canHarvestBlock((Block) block, (ItemStack) itemStack);
	}

	@Override
	public boolean hasEffect(ItemStack itemStack, int pass) {
		return master != null ? master.hasEffect(itemStack, pass) : super.hasEffect(itemStack, pass);
	}

	public boolean superHasEffect(Object itemStack, int pass) {
		return super.hasEffect((ItemStack) itemStack, pass);
	}

	@Override
	public int getItemStackLimit(ItemStack itemStack) {
		return master != null ? master.getItemStackLimit(itemStack) : super.getItemStackLimit(itemStack);
	}

	public int superGetItemStackLimit(Object itemStack) {
		return super.getItemStackLimit((ItemStack) itemStack);
	}

	//164
	public float getStrVsBlock(ItemStack itemStack, Block block) {
		return 0.0F;
	}

	public float superGetStrVsBlock(Object itemStack, Object block) {
		return 0.0F;
	}

	public boolean onBlockDestroyed(ItemStack itemStack, World world, int par3, int par4, int par5, int par6, EntityLivingBase entityLivingBase) {
		return false;
	}

	public boolean superOnBlockDestroyed(Object itemStack, Object world, int par3, int par4, int par5, int par6, Object entityLivingBase) {
		return false;
	}

	public boolean canHarvestBlock(Block block) {
		return false;
	}

	public boolean superCanHarvestBlock(Object block) {
		return false;
	}

	public String getStatName() {
		return null;
	}

	public String superGetStatName() {
		return null;
	}

	public String getPotionEffect() {
		return null;
	}

	public String superGetPotionEffect() {
		return null;
	}

	public boolean isPotionIngredient() {
		return false;
	}

	public boolean superIsPotionIngredient() {
		return false;
	}

	public String getItemDisplayName(ItemStack itemStack) {
		return null;
	}

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
	public void getSubItems(int par1, CreativeTabs creativeTabs, List par3List) {
	}

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

	public float superGetStrVsBlock(Object itemStack, Object block, int metadata) {
		return 0.0F;
	}

	public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int count) {
	}

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

	public boolean superShouldPassSneakingClickToBlock(Object world, int par4, int par5, int par6) {
		return false;
	}

	public void onArmorTickUpdate(World world, EntityPlayer entityPlayer, ItemStack itemStack) {
	}

	public void superOnArmorTickUpdate(Object world, Object entityPlayer, Object itemStack) {
	}

	public float getDamageVsEntity(Entity entity, ItemStack itemStack) {
		return 0.0F;
	}

	public float superGetDamageVsEntity(Object entity, Object itemStack) {
		return 0.0F;
	}

	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, int layer) {
		return null;
	}

	public String superGetArmorTexture(Object itemStack, Object entity, int slot, int layer) {
		return null;
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

	public void superGetSubItems(Object item, Object creativeTabs, List p_150895_3_) {
	}

	public Multimap getAttributeModifiers(ItemStack itemStack) {
		return null;
	}

	public Multimap superGetAttributeModifiers(Object itemStack) {
		return null;
	}

	public float getDigSpeed(ItemStack itemStack, Block block, int metadata) {
		return 0.0F;
	}

	public float superGetDigSpeed(Object itemStack, Object block, int metadata) {
		return 0.0F;
	}

	public void onUsingTick(ItemStack itemStack, EntityPlayer entityPlayer, int count) {
	}

	public void superOnUsingTick(Object itemStack, Object entityPlayer, int count) {
	}

	public ItemStack getContainerItem(ItemStack itemStack) {
		return null;
	}

	public ItemStack superGetContainerItem(Object itemStack) {
		return null;
	}

	public boolean hasContainerItem(ItemStack itemStack) {
		return false;
	}

	public boolean superHasContainerItem(Object itemStack) {
		return false;
	}

	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer entityPlayer) {
		return false;
	}

	public boolean superDoesSneakBypassUse(Object world, int x, int y, int z, Object entityPlayer) {
		return false;
	}

	public void onArmorTick(World world, EntityPlayer entityPlayer, ItemStack itemStack) {
	}

	public void superOnArmorTick(Object world, Object entityPlayer, Object itemStack) {
	}

	public boolean showDurabilityBar(ItemStack itemStack) {
		return false;
	}

	public boolean superShowDurabilityBar(Object itemStack) {
		return false;
	}

	public double getDurabilityForDisplay(ItemStack itemStack) {
		return 0.0D;
	}

	public double superGetDurabilityForDisplay(Object itemStack) {
		return 0.0D;
	}

	public void setHarvestLevel(String toolClass, int level) {
	}

	public void superSetHarvestLevel(String toolClass, int level) {
	}

	public Set<String> getToolClasses(ItemStack itemStack) {
		return null;
	}

	public Set<String> superGetToolClasses(Object itemStack) {
		return null;
	}

	public int getHarvestLevel(ItemStack itemStack, String toolClass) {
		return -1;
	}

	public int superGetHarvestLevel(Object itemStack, String toolClass) {
		return -1;
	}

}
