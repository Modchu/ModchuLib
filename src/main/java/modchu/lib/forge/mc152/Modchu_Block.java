package modchu.lib.forge.mc152;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import modchu.lib.Modchu_IBlock;
import modchu.lib.Modchu_IBlockMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class Modchu_Block extends Block implements Modchu_IBlock {
	public Modchu_IBlockMaster master;

	public Modchu_Block(HashMap<String, Object> map) {
		super((Integer) map.get("Integer"), (Material) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IBlockMaster ? (Modchu_IBlockMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_Block init master="+master);
	}

	@Override
	public Block setLightOpacity(int par1) {
		return (Block) (master != null ? master.setLightOpacity(par1) : super.setLightOpacity(par1));
	}

	@Override
	public Block superSetLightOpacity(int par1) {
		return super.setLightOpacity(par1);
	}

	@Override
	public Block setResistance(float par1) {
		return (Block) (master != null ? master.setResistance(par1) : super.setResistance(par1));
	}

	@Override
	public Block superSetResistance(float par1) {
		return super.setResistance(par1);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return master != null ? master.isFullCube() : super.renderAsNormalBlock();
	}

	@Override
	public boolean superIsFullCube() {
		return super.renderAsNormalBlock();
	}

	@Override
	public boolean getBlocksMovement(IBlockAccess iBlockAccess, int par2, int par3, int par4) {
		return master != null ? master.isPassable(iBlockAccess, par2, par3, par4) : super.getBlocksMovement(iBlockAccess, par2, par3, par4);
	}

	@Override
	public boolean superIsPassable(Object iBlockAccess, int par2, int par3, int par4) {
		return super.getBlocksMovement((IBlockAccess) iBlockAccess, par2, par3, par4);
	}

	@Override
	public int getRenderType() {
		return master != null ? master.getRenderType() : super.getRenderType();
	}

	@Override
	public int superGetRenderType() {
		return super.getRenderType();
	}

	@Override
	public Block setHardness(float par1) {
		return (Block) (master != null ? master.setHardness(par1) : super.setHardness(par1));
	}

	@Override
	public Block superSetHardness(float par1) {
		return super.setHardness(par1);
	}

	@Override
	public Block setBlockUnbreakable() {
		return (Block) (master != null ? master.setBlockUnbreakable() : super.setBlockUnbreakable());
	}

	@Override
	public Block superSetBlockUnbreakable() {
		return super.setBlockUnbreakable();
	}

	@Override
	public float getBlockHardness(World world, int par2, int par3, int par4) {
		return master != null ? master.getBlockHardness(world, par2, par3, par4) : super.getBlockHardness(world, par2, par3, par4);
	}

	@Override
	public float superGetBlockHardness(Object world, int par2, int par3, int par4) {
		return super.getBlockHardness((World) world, par2, par3, par4);
	}

	@Override
	public Block setTickRandomly(boolean par1) {
		return (Block) (master != null ? master.setTickRandomly(par1) : super.setTickRandomly(par1));
	}

	@Override
	public Block superSetTickRandomly(boolean par1) {
		return super.setTickRandomly(par1);
	}

	@Override
	public boolean getTickRandomly() {
		return master != null ? master.getTickRandomly() : super.getTickRandomly();
	}

	@Override
	public boolean superGetTickRandomly() {
		return super.getTickRandomly();
	}

	@Override
	public boolean hasTileEntity() {
		return master != null ? master.hasTileEntity() : super.hasTileEntity();
	}

	@Override
	public boolean superHasTileEntity() {
		return super.hasTileEntity();
	}

	@Override
	public int getMixedBrightnessForBlock(IBlockAccess iBlockAccess, int par2, int par3, int par4) {
		return master != null ? master.getPackedLightmapCoords(iBlockAccess, par2, par3, par4) : super.getMixedBrightnessForBlock(iBlockAccess, par2, par3, par4);
	}

	@Override
	public int superGetPackedLightmapCoords(Object iBlockAccess, int par2, int par3, int par4) {
		return super.getMixedBrightnessForBlock((IBlockAccess) iBlockAccess, par2, par3, par4);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int par2, int par3, int par4, int par5) {
		return master != null ? master.shouldSideBeRendered(iBlockAccess, par2, par3, par4, par5) : super.shouldSideBeRendered(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public boolean superShouldSideBeRendered(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return super.shouldSideBeRendered((IBlockAccess) iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public boolean isBlockSolid(IBlockAccess iBlockAccess, int par2, int par3, int par4, int par5) {
		return master != null ? master.isBlockSolid(iBlockAccess, par2, par3, par4, par5) : super.isBlockSolid(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public boolean superIsBlockSolid(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return super.isBlockSolid((IBlockAccess) iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public Icon getBlockTexture(IBlockAccess iBlockAccess, int par2, int par3, int par4, int par5) {
		return (Icon) (master != null ? master.getBlockTexture(iBlockAccess, par2, par3, par4, par5) : super.getBlockTexture(iBlockAccess, par2, par3, par4, par5));
	}

	@Override
	public Icon superGetBlockTexture(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return super.getBlockTexture((IBlockAccess) iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return (Icon) (master != null ? master.getIcon(par1, par2) : super.getIcon(par1, par2));
	}

	@Override
	public Icon superGetIcon(int par1, int par2) {
		return super.getIcon(par1, par2);
	}

	@Override
	public void addCollisionBoxesToList(World world, int par2, int par3, int par4, AxisAlignedBB axisAlignedBB, List par6List, Entity entity) {
		if (master != null) master.addCollisionBoxesToList(world, par2, par3, par4, axisAlignedBB, par6List, entity);
		else super.addCollisionBoxesToList(world, par2, par3, par4, axisAlignedBB, par6List, entity);
	}

	@Override
	public void superAddCollisionBoxesToList(Object world, int par2, int par3, int par4, Object axisAlignedBB, List par6List, Object entity) {
		super.addCollisionBoxesToList((World) world, par2, par3, par4, (AxisAlignedBB) axisAlignedBB, par6List, (Entity) entity);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int par2, int par3, int par4) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox(world, par2, par3, par4) : super.getSelectedBoundingBoxFromPool(world, par2, par3, par4));
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox(Object world, int par2, int par3, int par4) {
		return super.getSelectedBoundingBoxFromPool((World) world, par2, par3, par4);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBoxFromPool(world, par2, par3, par4) : super.getCollisionBoundingBoxFromPool(world, par2, par3, par4));
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBoxFromPool(Object world, int par2, int par3, int par4) {
		return super.getCollisionBoundingBoxFromPool((World) world, par2, par3, par4);
	}

	@Override
	public boolean isOpaqueCube() {
		return master != null ? master.isOpaqueCube() : super.isOpaqueCube();
	}

	@Override
	public boolean superIsOpaqueCube() {
		return super.isOpaqueCube();
	}

	@Override
	public boolean canCollideCheck(int par1, boolean par2) {
		return master != null ? master.canCollideCheck(par1, par2) : super.canCollideCheck(par1, par2);
	}

	@Override
	public boolean superCanCollideCheck(Object par1, boolean par2) {
		return super.canCollideCheck((Integer) par1, par2);
	}

	@Override
	public boolean isCollidable() {
		return master != null ? master.isCollidable() : super.isCollidable();
	}

	@Override
	public boolean superIsCollidable() {
		return super.isCollidable();
	}

	@Override
	public void updateTick(World world, int par2, int par3, int par4, Random par5Random) {
		if (master != null) master.updateTick(world, par2, par3, par4, par5Random);
		else super.updateTick(world, par2, par3, par4, par5Random);
	}

	@Override
	public void superUpdateTick(Object world, int par2, int par3, int par4, Random par5Random) {
		super.updateTick((World) world, par2, par3, par4, par5Random);
	}

	@Override
	public void randomDisplayTick(World world, int par2, int par3, int par4, Random par5Random) {
		if (master != null) master.randomDisplayTick(world, par2, par3, par4, par5Random);
		else super.randomDisplayTick(world, par2, par3, par4, par5Random);
	}

	@Override
	public void superRandomDisplayTick(Object world, int par2, int par3, int par4, Random par5Random) {
		super.randomDisplayTick((World) world, par2, par3, par4, par5Random);
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int par2, int par3, int par4, int par5) {
		if (master != null) master.onBlockDestroyedByPlayer(world, par2, par3, par4, par5);
		else super.onBlockDestroyedByPlayer(world, par2, par3, par4, par5);
	}

	@Override
	public void superOnBlockDestroyedByPlayer(Object world, int par2, int par3, int par4, int par5) {
		super.onBlockDestroyedByPlayer((World) world, par2, par3, par4, par5);
	}

	@Override
	public int tickRate(World world) {
		return master != null ? master.tickRate(world) : super.tickRate(world);
	}

	@Override
	public int superTickRate(Object world) {
		return super.tickRate((World) world);
	}

	@Override
	public void onBlockAdded(World world, int par2, int par3, int par4) {
		if (master != null) master.onBlockAdded(world, par2, par3, par4);
		else super.onBlockAdded(world, par2, par3, par4);
	}

	@Override
	public void superOnBlockAdded(Object world, int par2, int par3, int par4) {
		super.onBlockAdded((World) world, par2, par3, par4);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return master != null ? master.quantityDropped(par1Random) : super.quantityDropped(par1Random);
	}

	@Override
	public int superQuantityDropped(Random par1Random) {
		return super.quantityDropped(par1Random);
	}

	@Override
	public float getPlayerRelativeBlockHardness(EntityPlayer entityPlayer, World world, int par3, int par4, int par5) {
		return master != null ? master.getPlayerRelativeBlockHardness(entityPlayer, world, par3, par4, par5) : super.getPlayerRelativeBlockHardness(entityPlayer, world, par3, par4, par5);
	}

	@Override
	public float superGetPlayerRelativeBlockHardness(Object entityPlayer, Object world, int par3, int par4, int par5) {
		return super.getPlayerRelativeBlockHardness((EntityPlayer) entityPlayer, (World) world, par3, par4, par5);
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7) {
		if (master != null) master.dropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, par7);
		else super.dropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void superDropBlockAsItemWithChance(Object world, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance((World) world, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void dropXpOnBlockBreak(World world, int par2, int par3, int par4, int par5) {
		if (master != null) master.dropXpOnBlockBreak(world, par2, par3, par4, par5);
		else super.dropXpOnBlockBreak(world, par2, par3, par4, par5);
	}

	@Override
	public void superDropXpOnBlockBreak(Object world, int par2, int par3, int par4, int par5) {
		super.dropXpOnBlockBreak((World) world, par2, par3, par4, par5);
	}

	@Override
	public int damageDropped(int par1) {
		return master != null ? master.damageDropped(par1) : super.damageDropped(par1);
	}

	@Override
	public int superDamageDropped(int par1) {
		return super.damageDropped(par1);
	}

	@Override
	public float getExplosionResistance(Entity entity) {
		return master != null ? master.getExplosionResistance(entity) : super.getExplosionResistance(entity);
	}

	@Override
	public float superGetExplosionResistance(Object entity) {
		return super.getExplosionResistance((Entity) entity);
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World world, int par2, int par3, int par4, Vec3 vec3, Vec3 vec31) {
		return (MovingObjectPosition) (master != null ? master.collisionRayTrace(world, par2, par3, par4, vec3, vec31) : super.collisionRayTrace(world, par2, par3, par4, vec3, vec31));
	}

	@Override
	public MovingObjectPosition superCollisionRayTrace(Object world, int par2, int par3, int par4, Object vec3, Object vec31) {
		return super.collisionRayTrace((World) world, par2, par3, par4, (Vec3) vec3, (Vec3) vec31);
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int par2, int par3, int par4, Explosion explosion) {
		if (master != null) master.onBlockDestroyedByExplosion(world, par2, par3, par4, explosion);
		else super.onBlockDestroyedByExplosion(world, par2, par3, par4, explosion);
	}

	@Override
	public void superOnBlockDestroyedByExplosion(Object world, int par2, int par3, int par4, Object explosion) {
		super.onBlockDestroyedByExplosion((World) world, par2, par3, par4, (Explosion) explosion);
	}

	@Override
	public int getRenderBlockPass() {
		return master != null ? master.getRenderBlockPass() : super.getRenderBlockPass();
	}

	@Override
	public int superGetRenderBlockPass() {
		return super.getRenderBlockPass();
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int par2, int par3, int par4, int par5) {
		return master != null ? master.canPlaceBlockOnSide(world, par2, par3, par4, par5) : super.canPlaceBlockOnSide(world, par2, par3, par4, par5);
	}

	@Override
	public boolean superCanPlaceBlockOnSide(Object world, int par2, int par3, int par4, int par5) {
		return super.canPlaceBlockOnSide((World) world, par2, par3, par4, par5);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int par2, int par3, int par4) {
		return master != null ? master.canPlaceBlockAt(world, par2, par3, par4) : super.canPlaceBlockAt(world, par2, par3, par4);
	}

	@Override
	public boolean superCanPlaceBlockAt(Object world, int par2, int par3, int par4) {
		return super.canPlaceBlockAt((World) world, par2, par3, par4);
	}

	@Override
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9) {
		return master != null ? master.onBlockActivated(world, par2, par3, par4, entityPlayer, par6, par7, par8, par9) : super.onBlockActivated(world, par2, par3, par4, entityPlayer, par6, par7, par8, par9);
	}

	@Override
	public boolean superOnBlockActivated(Object world, int par2, int par3, int par4, Object entityPlayer, int par6, float par7, float par8, float par9) {
		return super.onBlockActivated((World) world, par2, par3, par4, (EntityPlayer) entityPlayer, par6, par7, par8, par9);
	}

	@Override
	public void onEntityWalking(World world, int par2, int par3, int par4, Entity entity) {
		if (master != null) master.onEntityWalk(world, par2, par3, par4, entity);
		else super.onEntityWalking(world, par2, par3, par4, entity);
	}

	@Override
	public int onBlockPlaced(World world, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return master != null ? master.onBlockPlaced(world, par2, par3, par4, par5, par6, par7, par8, par9) : super.onBlockPlaced(world, par2, par3, par4, par5, par6, par7, par8, par9);
	}

	@Override
	public int superOnBlockPlaced(Object world, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return super.onBlockPlaced((World) world, par2, par3, par4, par5, par6, par7, par8, par9);
	}

	@Override
	public void onBlockClicked(World world, int par2, int par3, int par4, EntityPlayer entityPlayer) {
		if (master != null) master.onBlockClicked(world, par2, par3, par4, entityPlayer);
		else super.onBlockClicked(world, par2, par3, par4, entityPlayer);
	}

	@Override
	public void superOnBlockClicked(Object world, int par2, int par3, int par4, Object entityPlayer) {
		super.onBlockClicked((World) world, par2, par3, par4, (EntityPlayer) entityPlayer);
	}

	@Override
	public void velocityToAddToEntity(World world, int par2, int par3, int par4, Entity entity, Vec3 vec3) {
		if (master != null) master.velocityToAddToEntity(world, par2, par3, par4, entity, vec3);
		else super.velocityToAddToEntity(world, par2, par3, par4, entity, vec3);
	}

	@Override
	public void superVelocityToAddToEntity(Object world, int par2, int par3, int par4, Object entity, Object vec3) {
		super.velocityToAddToEntity((World) world, par2, par3, par4, (Entity) entity, (Vec3) vec3);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int par2, int par3, int par4) {
		if (master != null) master.setBlockBoundsBasedOnState(iBlockAccess, par2, par3, par4);
		else super.setBlockBoundsBasedOnState(iBlockAccess, par2, par3, par4);
	}

	@Override
	public void superSetBlockBoundsBasedOnState(Object iBlockAccess, int par2, int par3, int par4) {
		super.setBlockBoundsBasedOnState((IBlockAccess) iBlockAccess, par2, par3, par4);
	}

	@Override
	public int getBlockColor() {
		return master != null ? master.getBlockColor() : super.getBlockColor();
	}

	@Override
	public int superGetBlockColor() {
		return super.getBlockColor();
	}

	@Override
	public int getRenderColor(int par1) {
		return master != null ? master.getRenderColor(par1) : super.getRenderColor(par1);
	}

	@Override
	public int superGetRenderColor(int par1) {
		return super.getRenderColor(par1);
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess iBlockAccess, int par2, int par3, int par4, int par5) {
		return master != null ? master.getWeakPower(iBlockAccess, par2, par3, par4, par5) : super.isProvidingWeakPower(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public int superGetWeakPower(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return super.isProvidingWeakPower((IBlockAccess) iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public int colorMultiplier(IBlockAccess iBlockAccess, int par2, int par3, int par4) {
		return master != null ? master.colorMultiplier(iBlockAccess, par2, par3, par4) : super.colorMultiplier(iBlockAccess, par2, par3, par4);
	}

	@Override
	public int superColorMultiplier(Object iBlockAccess, int par2, int par3, int par4) {
		return super.colorMultiplier((IBlockAccess) iBlockAccess, par2, par3, par4);
	}

	@Override
	public boolean canProvidePower() {
		return master != null ? master.canProvidePower() : super.canProvidePower();
	}

	@Override
	public boolean superCanProvidePower() {
		return super.canProvidePower();
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity entity) {
		if (master != null) master.onEntityWalk(world, par2, par3, par4, entity);
		else super.onEntityCollidedWithBlock(world, par2, par3, par4, entity);
	}

	@Override
	public void superOnEntityWalk(Object world, int par2, int par3, int par4, Object entity) {
		super.onEntityCollidedWithBlock((World) world, par2, par3, par4, (Entity) entity);
	}

	@Override
	public int isProvidingStrongPower(IBlockAccess iBlockAccess, int par2, int par3, int par4, int par5) {
		return master != null ? master.getStrongPower(iBlockAccess, par2, par3, par4, par5) : super.isProvidingStrongPower(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public int superGetStrongPower(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return super.isProvidingStrongPower((IBlockAccess) iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public void setBlockBoundsForItemRender() {
		if (master != null) master.setBlockBoundsForItemRender();
		else super.setBlockBoundsForItemRender();
	}

	@Override
	public void superSetBlockBoundsForItemRender() {
		super.setBlockBoundsForItemRender();
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityPlayer, int par3, int par4, int par5, int par6) {
		if (master != null) master.harvestBlock(world, entityPlayer, par3, par4, par5, par6);
		else super.harvestBlock(world, entityPlayer, par3, par4, par5, par6);
	}

	@Override
	public void superHarvestBlock(Object world, Object entityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock((World) world, (EntityPlayer) entityPlayer, par3, par4, par5, par6);
	}

	@Override
	protected boolean canSilkHarvest() {
		return master != null ? master.canSilkHarvest() : super.canSilkHarvest();
	}

	@Override
	public boolean superCanSilkHarvest() {
		return super.canSilkHarvest();
	}

	@Override
	protected ItemStack createStackedBlock(int par1) {
		return (ItemStack) (master != null ? master.createStackedBlock(par1) : super.createStackedBlock(par1));
	}

	@Override
	public ItemStack superCreateStackedBlock(int par1) {
		return super.createStackedBlock(par1);
	}

	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random) {
		return master != null ? master.quantityDroppedWithBonus(par1, par2Random) : super.quantityDroppedWithBonus(par1, par2Random);
	}

	@Override
	public int superQuantityDroppedWithBonus(int par1, Random par2Random) {
		return super.quantityDroppedWithBonus(par1, par2Random);
	}

	@Override
	public boolean canBlockStay(World world, int par2, int par3, int par4) {
		return master != null ? master.canBlockStay(world, par2, par3, par4) : super.canBlockStay(world, par2, par3, par4);
	}

	@Override
	public boolean superCanBlockStay(Object world, int par2, int par3, int par4) {
		return super.canBlockStay((World) world, par2, par3, par4);
	}

	@Override
	public void onBlockPlacedBy(World world, int par2, int par3, int par4, EntityLiving entityLivingBase, ItemStack itemStack) {
		if (master != null) master.onBlockPlacedBy(world, par2, par3, par4, entityLivingBase, itemStack);
		else super.onBlockPlacedBy(world, par2, par3, par4, entityLivingBase, itemStack);
	}

	@Override
	public void superOnBlockPlacedBy(Object world, int par2, int par3, int par4, Object entityLivingBase, Object itemStack) {
		super.onBlockPlacedBy((World) world, par2, par3, par4, (EntityLiving) entityLivingBase, (ItemStack) itemStack);
	}

	@Override
	public void onPostBlockPlaced(World world, int par2, int par3, int par4, int par5) {
		if (master != null) master.onPostBlockPlaced(world, par2, par3, par4, par5);
		else super.onPostBlockPlaced(world, par2, par3, par4, par5);
	}

	@Override
	public void superOnPostBlockPlaced(Object world, int par2, int par3, int par4, int par5) {
		super.onPostBlockPlaced((World) world, par2, par3, par4, par5);
	}

	@Override
	public String getLocalizedName() {
		return master != null ? master.getLocalizedName() : super.getLocalizedName();
	}

	@Override
	public String superGetLocalizedName() {
		return super.getLocalizedName();
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
	public boolean onBlockEventReceived(World world, int par2, int par3, int par4, int par5, int par6) {
		return master != null ? master.eventReceived(world, par2, par3, par4, par5, par6) : super.onBlockEventReceived(world, par2, par3, par4, par5, par6);
	}

	@Override
	public boolean superEventReceived(Object world, int par2, int par3, int par4, int par5, int par6) {
		return super.onBlockEventReceived((World) world, par2, par3, par4, par5, par6);
	}

	@Override
	public boolean getEnableStats() {
		return master != null ? master.getEnableStats() : super.getEnableStats();
	}

	@Override
	public boolean superGetEnableStats() {
		return super.getEnableStats();
	}

	@Override
	protected Block disableStats() {
		return (Block) (master != null ? master.disableStats() : super.disableStats());
	}

	@Override
	public Block superDisableStats() {
		return super.disableStats();
	}

	@Override
	public int getMobilityFlag() {
		return master != null ? master.getMobilityFlag() : super.getMobilityFlag();
	}

	@Override
	public int superGetMobilityFlag() {
		return super.getMobilityFlag();
	}

	@Override
	public void onFallenUpon(World world, int par2, int par3, int par4, Entity entity, float par6) {
		if (master != null) master.onFallenUpon(world, par2, par3, par4, entity, par6);
		else super.onFallenUpon(world, par2, par3, par4, entity, par6);
	}

	@Override
	public void superOnFallenUpon(Object world, int par2, int par3, int par4, Object entity, float par6) {
		super.onFallenUpon((World) world, par2, par3, par4, (Entity) entity, par6);
	}

	@Override
	public int getDamageValue(World world, int par2, int par3, int par4) {
		return master != null ? master.getDamageValue(world, par2, par3, par4) : super.getDamageValue(world, par2, par3, par4);
	}

	@Override
	public int superGetDamageValue(Object world, int par2, int par3, int par4) {
		return super.getDamageValue((World) world, par2, par3, par4);
	}

	@Override
	public Block setCreativeTab(CreativeTabs creativeTabs) {
		return (Block) (master != null ? master.setCreativeTab(creativeTabs) : super.setCreativeTab(creativeTabs));
	}

	@Override
	public Block superSetCreativeTab(Object creativeTabs) {
		return super.setCreativeTab((CreativeTabs) creativeTabs);
	}

	@Override
	public void onBlockHarvested(World world, int par2, int par3, int par4, int par5, EntityPlayer entityPlayer) {
		if (master != null) master.onBlockHarvested(world, par2, par3, par4, par5, entityPlayer);
		else super.onBlockHarvested(world, par2, par3, par4, par5, entityPlayer);
	}

	@Override
	public void superOnBlockHarvested(Object world, int par2, int par3, int par4, int par5, Object entityPlayer) {
		super.onBlockHarvested((World) world, par2, par3, par4, par5, (EntityPlayer) entityPlayer);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return (CreativeTabs) (master != null ? master.getCreativeTabToDisplayOn() : super.getCreativeTabToDisplayOn());
	}

	@Override
	public CreativeTabs superGetCreativeTabToDisplayOn() {
		return super.getCreativeTabToDisplayOn();
	}

	@Override
	public void fillWithRain(World world, int par2, int par3, int par4) {
		if (master != null) master.fillWithRain(world, par2, par3, par4);
		else super.fillWithRain(world, par2, par3, par4);
	}

	@Override
	public void superFillWithRain(Object world, int par2, int par3, int par4) {
		super.fillWithRain((World) world, par2, par3, par4);
	}

	@Override
	public boolean isFlowerPot() {
		return master != null ? master.isFlowerPot() : super.isFlowerPot();
	}

	@Override
	public boolean superIsFlowerPot() {
		return super.isFlowerPot();
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		return master != null ? master.canDropFromExplosion(explosion) : super.canDropFromExplosion(explosion);
	}

	@Override
	public boolean superCanDropFromExplosion(Object explosion) {
		return super.canDropFromExplosion((Explosion) explosion);
	}

	@Override
	public boolean hasComparatorInputOverride() {
		return master != null ? master.hasComparatorInputOverride() : super.hasComparatorInputOverride();
	}

	@Override
	public boolean superHasComparatorInputOverride() {
		return super.hasComparatorInputOverride();
	}

	@Override
	public int getComparatorInputOverride(World world, int par2, int par3, int par4, int par5) {
		return master != null ? master.getComparatorInputOverride(world, par2, par3, par4, par5) : super.getComparatorInputOverride(world, par2, par3, par4, par5);
	}

	@Override
	public int superGetComparatorInputOverride(Object world, int par2, int par3, int par4, int par5) {
		return super.getComparatorInputOverride((World) world, par2, par3, par4, par5);
	}

	@Override
	public String getItemIconName() {
		return master != null ? master.getItemIconName() : super.getItemIconName();
	}

	@Override
	public String superGetItemIconName() {
		return super.getItemIconName();
	}

	@Override
	public int getLightValue(IBlockAccess iBlockAccess, int x, int y, int z) {
		return master != null ? master.getLightValue(iBlockAccess, x, y, z) : super.getLightValue(iBlockAccess, x, y, z);
	}

	@Override
	public int superGetLightValue(Object iBlockAccess, int x, int y, int z) {
		return super.getLightValue((IBlockAccess) iBlockAccess, x, y, z);
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer entityPlayer, int meta) {
		return master != null ? master.canHarvestBlock(entityPlayer, meta) : super.canHarvestBlock(entityPlayer, meta);
	}

	@Override
	public boolean superCanHarvestBlock(Object entityPlayer, int meta) {
		return super.canHarvestBlock((EntityPlayer) entityPlayer, meta);
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return master != null ? master.hasTileEntity(metadata) : super.hasTileEntity(metadata);
	}

	@Override
	public boolean superHasTileEntity(int metadata) {
		return super.hasTileEntity(metadata);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return (TileEntity) (master != null ? master.createTileEntity(world, metadata) : super.createTileEntity(world, metadata));
	}

	@Override
	public TileEntity superCreateTileEntity(Object world, int metadata) {
		return super.createTileEntity((World) world, metadata);
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return master != null ? master.quantityDropped(meta, fortune, random) : super.quantityDropped(meta, fortune, random);
	}

	@Override
	public int superQuantityDropped(int meta, int fortune, Random random) {
		return super.quantityDropped(meta, fortune, random);
	}

	@Override
	public boolean canSilkHarvest(World world, EntityPlayer entityPlayer, int x, int y, int z, int metadata) {
		return master != null ? master.canSilkHarvest(world, entityPlayer, x, y, z, metadata) : super.canSilkHarvest(world, entityPlayer, x, y, z, metadata);
	}

	@Override
	public boolean superCanSilkHarvest(Object world, Object entityPlayer, int x, int y, int z, int metadata) {
		return super.canSilkHarvest((World) world, (EntityPlayer) entityPlayer, x, y, z, metadata);
	}

	@Override
	public int getBedDirection(IBlockAccess iBlockAccess, int x, int y, int z) {
		return master != null ? master.getBedDirection(iBlockAccess, x, y, z) : super.getBedDirection(iBlockAccess, x, y, z);
	}

	@Override
	public int superGetBedDirection(Object iBlockAccess, int x, int y, int z) {
		return super.getBedDirection((IBlockAccess) iBlockAccess, x, y, z);
	}

	@Override
	public boolean isBedFoot(IBlockAccess iBlockAccess, int x, int y, int z) {
		return master != null ? master.isBedFoot(iBlockAccess, x, y, z) : super.isBedFoot(iBlockAccess, x, y, z);
	}

	@Override
	public boolean superIsBedFoot(Object iBlockAccess, int x, int y, int z) {
		return super.isBedFoot((IBlockAccess) iBlockAccess, x, y, z);
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z) {
		if (master != null) master.beginLeavesDecay(world, x, y, z);
		else super.beginLeavesDecay(world, x, y, z);
	}

	@Override
	public void superBeginLeavesDecay(Object world, int x, int y, int z) {
		super.beginLeavesDecay((World) world, x, y, z);
	}

	@Override
	public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		return master != null ? master.getExplosionResistance(entity, world, x, y, z, explosionX, explosionY, explosionZ) : super.getExplosionResistance(entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public float superGetExplosionResistance(Object entity, Object world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		return super.getExplosionResistance((Entity) entity, (World) world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
		if (master != null) master.onBlockExploded(world, x, y, z, explosion);
		else super.onBlockExploded(world, x, y, z, explosion);
	}

	@Override
	public void superOnBlockExploded(Object world, int x, int y, int z, Object explosion) {
		super.onBlockExploded((World) world, x, y, z, (Explosion) explosion);
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
		return master != null ? master.canConnectRedstone(iBlockAccess, x, y, z, side) : super.canConnectRedstone(iBlockAccess, x, y, z, side);
	}

	@Override
	public boolean superCanConnectRedstone(Object iBlockAccess, int x, int y, int z, int side) {
		return super.canConnectRedstone((IBlockAccess) iBlockAccess, x, y, z, side);
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return master != null ? master.canPlaceTorchOnTop(world, x, y, z) : super.canPlaceTorchOnTop(world, x, y, z);
	}

	@Override
	public boolean superCanPlaceTorchOnTop(Object world, int x, int y, int z) {
		return super.canPlaceTorchOnTop((World) world, x, y, z);
	}

	@Override
	public boolean canRenderInPass(int pass) {
		return master != null ? master.canRenderInPass(pass) : super.canRenderInPass(pass);
	}

	@Override
	public boolean superCanRenderInPass(int pass) {
		return super.canRenderInPass(pass);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition movingObjectPosition, World world, int x, int y, int z) {
		return (ItemStack) (master != null ? master.getPickBlock(movingObjectPosition, world, x, y, z) : super.getPickBlock(movingObjectPosition, world, x, y, z));
	}

	@Override
	public ItemStack superGetPickBlock(Object movingObjectPosition, Object world, int x, int y, int z) {
		return super.getPickBlock((MovingObjectPosition) movingObjectPosition, (World) world, x, y, z);
	}

	@Override
	public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		if (master != null) master.onPlantGrow(world, x, y, z, sourceX, sourceY, sourceZ);
		else super.onPlantGrow(world, x, y, z, sourceX, sourceY, sourceZ);
	}

	@Override
	public void superOnPlantGrow(Object world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		super.onPlantGrow((World) world, x, y, z, sourceX, sourceY, sourceZ);
	}

	@Override
	public boolean isFertile(World world, int x, int y, int z) {
		return master != null ? master.isFertile(world, x, y, z) : super.isFertile(world, x, y, z);
	}

	@Override
	public boolean superIsFertile(Object world, int x, int y, int z) {
		return super.isFertile((World) world, x, y, z);
	}

	@Override
	public float getEnchantPowerBonus(World world, int x, int y, int z) {
		return master != null ? master.getEnchantPowerBonus(world, x, y, z) : super.getEnchantPowerBonus(world, x, y, z);
	}

	@Override
	public float superGetEnchantPowerBonus(Object world, int x, int y, int z) {
		return super.getEnchantPowerBonus((World) world, x, y, z);
	}

	@Override
	public Block setStepSound(StepSound stepSound) {
		return (Block) (master != null ? master.setSoundType(stepSound) : super.setStepSound(stepSound));
	}

	@Override
	public Block superSetSoundType(Object stepSound) {
		return super.setStepSound((StepSound) stepSound);
	}

	@Override
	public Block setLightValue(float par1) {
		return (Block) (master != null ? master.setLightLevel(par1) : super.setLightValue(par1));
	}

	@Override
	public Block superSetLightLevel(float par1) {
		return super.setLightValue(par1);
	}

	@Override
	public boolean func_82506_l() {
		return master != null ? master.requiresUpdates() : super.func_82506_l();
	}

	@Override
	public boolean superRequiresUpdates() {
		return super.func_82506_l();
	}

	@Override
	public boolean isAssociatedBlockID(int par1) {
		return master != null ? master.isAssociatedBlock(par1) : super.isAssociatedBlockID(par1);
	}

	@Override
	public boolean superIsAssociatedBlock(Object par1) {
		return super.isAssociatedBlockID((Integer) par1);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		if (master != null) master.registerIcons(iconRegister);
		else super.registerIcons(iconRegister);
	}

	@Override
	public void superRegisterIcons(Object iconRegister) {
		super.registerIcons((IconRegister) iconRegister);
	}

	@Override
	public boolean isLadder(World world, int x, int y, int z, EntityLiving entityLivingBase) {
		return master != null ? master.isLadder(world, x, y, z, entityLivingBase) : super.isLadder(world, x, y, z, entityLivingBase);
	}

	@Override
	public boolean superIsLadder(Object world, int x, int y, int z, Object entityLivingBase) {
		return super.isLadder((World) world, x, y, z, (EntityLiving) entityLivingBase);
	}

	@Override
	public boolean isBlockNormalCube(World world, int x, int y, int z) {
		return master != null ? master.isNormalCube(world, x, y, z) : super.isBlockNormalCube(world, x, y, z);
	}

	@Override
	public boolean superIsNormalCube(Object world, int x, int y, int z) {
		return super.isBlockNormalCube((World) world, x, y, z);
	}

	@Override
	public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection forgeDirection) {
		return master != null ? master.isSideSolid(world, x, y, z, forgeDirection) : super.isBlockSolidOnSide(world, x, y, z, forgeDirection);
	}

	@Override
	public boolean superIsSideSolid(Object world, int x, int y, int z, Object forgeDirection) {
		return super.isBlockSolidOnSide((World) world, x, y, z, (ForgeDirection) forgeDirection);
	}

	@Override
	public boolean isBlockReplaceable(World world, int x, int y, int z) {
		return master != null ? master.isReplaceable(world, x, y, z) : super.isBlockReplaceable(world, x, y, z);
	}

	@Override
	public boolean superIsReplaceable(Object world, int x, int y, int z) {
		return super.isBlockReplaceable((World) world, x, y, z);
	}

	@Override
	public boolean isBlockBurning(World world, int x, int y, int z) {
		return master != null ? master.isBurning(world, x, y, z) : super.isBlockBurning(world, x, y, z);
	}

	@Override
	public boolean superIsBurning(Object world, int x, int y, int z) {
		return super.isBlockBurning((World) world, x, y, z);
	}

	@Override
	public boolean isAirBlock(World world, int x, int y, int z) {
		return master != null ? master.isAir(world, x, y, z) : super.isAirBlock(world, x, y, z);
	}

	@Override
	public boolean superIsAir(Object world, int x, int y, int z) {
		return super.isAirBlock((World) world, x, y, z);
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer entityPlayer, int x, int y, int z) {
		return master != null ? master.removedByPlayer(world, entityPlayer, x, y, z, false) : super.removeBlockByPlayer(world, entityPlayer, x, y, z);
	}

	@Override
	public boolean superRemovedByPlayer(Object world, Object entityPlayer, int x, int y, int z) {
		return super.removeBlockByPlayer((World) world, (EntityPlayer) entityPlayer, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int par2, int par3, int par4, int par5) {
		if (master != null) master.neighborChanged(world, par2, par3, par4, (Integer) par5);
		else super.onNeighborBlockChange(world, par2, par3, par4, par5);
	}

	@Override
	public void superNeighborChanged(Object world, int par2, int par3, int par4, Object par5) {
		super.onNeighborBlockChange((World) world, par2, par3, par4, (Integer) par5);
	}

	@Override
	public void breakBlock(World world, int par2, int par3, int par4, int par5, int par6) {
		if (master != null) master.breakBlock(world, par2, par3, par4, par5, par6);
		else super.breakBlock(world, par2, par3, par4, par5, par6);
	}

	@Override
	public void superBreakBlock(Object world, int par2, int par3, int par4, Object par5, int par6) {
		super.breakBlock((World) world, par2, par3, par4, (Integer) par5, par6);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return (Integer) (master != null ? master.getItemDropped(par1, par2Random, par3) : super.idDropped(par1, par2Random, par3));
	}

	@Override
	public Object superGetItemDropped(int par1, Random par2Random, int par3) {
		return super.idDropped(par1, par2Random, par3);
	}

	@Override
	protected void dropBlockAsItem_do(World world, int par2, int par3, int par4, ItemStack itemStack) {
		if (master != null) master.dropBlockAsItem(world, par2, par3, par4, itemStack);
		else super.dropBlockAsItem_do(world, par2, par3, par4, itemStack);
	}

	@Override
	public void superDropBlockAsItem(Object world, int par2, int par3, int par4, Object itemStack) {
		super.dropBlockAsItem_do((World) world, par2, par3, par4, (ItemStack) itemStack);
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int par2, int par3, int par4, int par5, ItemStack itemStack) {
		return master != null ? master.canReplace(world, par2, par3, par4, par5, itemStack) : super.canPlaceBlockOnSide(world, par2, par3, par4, par5, itemStack);
	}

	@Override
	public boolean superCanReplace(Object world, int par2, int par3, int par4, int par5, Object itemStack) {
		return super.canPlaceBlockOnSide((World) world, par2, par3, par4, par5, (ItemStack) itemStack);
	}

	@Override
	public Block setUnlocalizedName(String par1Str) {
		return (Block) (master != null ? master.setUnlocalizedName(par1Str) : super.setUnlocalizedName(par1Str));
	}

	@Override
	public Block superSetUnlocalizedName(String par1Str) {
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	public float getAmbientOcclusionLightValue(IBlockAccess iBlockAccess, int par2, int par3, int par4) {
		return master != null ? master.getAmbientOcclusionLightValue(iBlockAccess, par2, par3, par4) : super.getAmbientOcclusionLightValue(iBlockAccess, par2, par3, par4);
	}

	@Override
	public float superGetAmbientOcclusionLightValue(Object iBlockAccess, int par2, int par3, int par4) {
		return super.getAmbientOcclusionLightValue((IBlockAccess) iBlockAccess, par2, par3, par4);
	}

	@Override
	public int idPicked(World world, int par2, int par3, int par4) {
		return (Integer) (master != null ? master.getItem(world, par2, par3, par4) : super.idPicked(world, par2, par3, par4));
	}

	@Override
	public Object superGetItem(Object world, int par2, int par3, int par4) {
		return super.idPicked((World) world, par2, par3, par4);
	}

	@Override
	public int getFlammability(IBlockAccess iBlockAccess, int x, int y, int z, int metadata, ForgeDirection forgeDirection) {
		return master != null ? master.getFlammability(iBlockAccess, x, y, z, metadata, forgeDirection) : super.getFlammability(iBlockAccess, x, y, z, metadata, forgeDirection);
	}

	@Override
	public int superGetFlammability(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return super.getFlammability((IBlockAccess) iBlockAccess, x, y, z, metadata, (ForgeDirection) forgeDirection);
	}

	@Override
	public boolean isFlammable(IBlockAccess iBlockAccess, int x, int y, int z, int metadata, ForgeDirection forgeDirection) {
		return master != null ? master.isFlammable(iBlockAccess, x, y, z, metadata, forgeDirection) : super.isFlammable(iBlockAccess, x, y, z, metadata, forgeDirection);
	}

	@Override
	public boolean superIsFlammable(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return super.isFlammable((IBlockAccess) iBlockAccess, x, y, z, metadata, (ForgeDirection) forgeDirection);
	}

	@Override
	public int getFireSpreadSpeed(World world, int x, int y, int z, int metadata, ForgeDirection forgeDirection) {
		return master != null ? master.getFireSpreadSpeed(world, x, y, z, metadata, forgeDirection) : super.getFireSpreadSpeed(world, x, y, z, metadata, forgeDirection);
	}

	@Override
	public int superGetFireSpreadSpeed(Object world, int x, int y, int z, int metadata, Object forgeDirection) {
		return super.getFireSpreadSpeed((World) world, x, y, z, metadata, (ForgeDirection) forgeDirection);
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, int metadata, ForgeDirection forgeDirection) {
		return master != null ? master.isFireSource(world, x, y, z, metadata, forgeDirection) : super.isFireSource(world, x, y, z, metadata, forgeDirection);
	}

	@Override
	public boolean superIsFireSource(Object world, int x, int y, int z, int metadata, Object forgeDirection) {
		return super.isFireSource((World) world, x, y, z, metadata, (ForgeDirection) forgeDirection);
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
		return (ArrayList<ItemStack>) (master != null ? master.getDrops(world, x, y, z, metadata, fortune) : super.getBlockDropped(world, x, y, z, metadata, fortune));
	}

	@Override
	public ArrayList<ItemStack> superGetDrops(Object world, int x, int y, int z, int metadata, int fortune) {
		return super.getBlockDropped((World) world, x, y, z, metadata, fortune);
	}

	@Override
	public boolean canCreatureSpawn(EnumCreatureType enumCreatureType, World world, int x, int y, int z) {
		return master != null ? master.canCreatureSpawn(enumCreatureType, world, x, y, z) : super.canCreatureSpawn(enumCreatureType, world, x, y, z);
	}

	@Override
	public boolean superCanCreatureSpawn(Object enumCreatureType, Object world, int x, int y, int z) {
		return super.canCreatureSpawn((EnumCreatureType) enumCreatureType, (World) world, x, y, z);
	}

	@Override
	public boolean isBed(World world, int x, int y, int z, EntityLiving entityLivingBase) {
		return master != null ? master.isBed(world, x, y, z, entityLivingBase) : super.isBed(world, x, y, z, entityLivingBase);
	}

	@Override
	public boolean superIsBed(Object world, int x, int y, int z, Object entityLivingBase) {
		return super.isBed((World) world, x, y, z, (EntityLiving) entityLivingBase);
	}

	@Override
	public ChunkCoordinates getBedSpawnPosition(World world, int x, int y, int z, EntityPlayer entityPlayer) {
		return (ChunkCoordinates) (master != null ? master.getBedSpawnPosition(world, x, y, z, entityPlayer) : super.getBedSpawnPosition(world, x, y, z, entityPlayer));
	}

	@Override
	public ChunkCoordinates superGetBedSpawnPosition(Object world, int x, int y, int z, Object entityPlayer) {
		return super.getBedSpawnPosition((World) world, x, y, z, (EntityPlayer) entityPlayer);
	}

	@Override
	public void setBedOccupied(World world, int x, int y, int z, EntityPlayer entityPlayer, boolean occupied) {
		if (master != null) master.setBedOccupied(world, x, y, z, entityPlayer, occupied);
		else super.setBedOccupied(world, x, y, z, entityPlayer, occupied);
	}

	@Override
	public void superSetBedOccupied(Object world, int x, int y, int z, Object entityPlayer, boolean occupied) {
		super.setBedOccupied((World) world, x, y, z, (EntityPlayer) entityPlayer, occupied);
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return master != null ? master.canSustainLeaves(world, x, y, z) : super.canSustainLeaves(world, x, y, z);
	}

	@Override
	public boolean superCanSustainLeaves(Object world, int x, int y, int z) {
		return super.canSustainLeaves((World) world, x, y, z);
	}

	@Override
	public boolean isLeaves(World world, int x, int y, int z) {
		return master != null ? master.isLeaves(world, x, y, z) : super.isLeaves(world, x, y, z);
	}

	@Override
	public boolean superIsLeaves(Object world, int x, int y, int z) {
		return super.isLeaves((World) world, x, y, z);
	}

	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
		return master != null ? master.canBeReplacedByLeaves(world, x, y, z) : super.canBeReplacedByLeaves(world, x, y, z);
	}

	@Override
	public boolean superCanBeReplacedByLeaves(Object world, int x, int y, int z) {
		return super.canBeReplacedByLeaves((World) world, x, y, z);
	}

	@Override
	public boolean isWood(World world, int x, int y, int z) {
		return master != null ? master.isWood(world, x, y, z) : super.isWood(world, x, y, z);
	}

	@Override
	public boolean superIsWood(Object world, int x, int y, int z) {
		return super.isWood((World) world, x, y, z);
	}

	@Override
	public boolean isGenMineableReplaceable(World world, int x, int y, int z, int target) {
		return master != null ? master.isReplaceableOreGen(world, x, y, z, target) : super.isGenMineableReplaceable(world, x, y, z, target);
	}

	@Override
	public boolean superIsReplaceableOreGen(Object world, int x, int y, int z, Object target) {
		return super.isGenMineableReplaceable((World) world, x, y, z, (Integer) target);
	}

	@Override
	public boolean isBlockFoliage(World world, int x, int y, int z) {
		return master != null ? master.isFoliage(world, x, y, z) : super.isBlockFoliage(world, x, y, z);
	}

	@Override
	public boolean superIsFoliage(Object world, int x, int y, int z) {
		return super.isBlockFoliage((World) world, x, y, z);
	}

	@Override
	public boolean addBlockHitEffects(World world, MovingObjectPosition movingObjectPosition, EffectRenderer effectRenderer) {
		return master != null ? master.addHitEffects(world, movingObjectPosition, effectRenderer) : super.addBlockHitEffects(world, movingObjectPosition, effectRenderer);
	}

	@Override
	public boolean superAddHitEffects(Object world, Object movingObjectPosition, Object effectRenderer) {
		return super.addBlockHitEffects((World) world, (MovingObjectPosition) movingObjectPosition, (EffectRenderer) effectRenderer);
	}

	@Override
	public boolean addBlockDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
		return master != null ? master.addDestroyEffects(world, x, y, z, meta, effectRenderer) : super.addBlockDestroyEffects(world, x, y, z, meta, effectRenderer);
	}

	@Override
	public boolean superAddDestroyEffects(Object world, int x, int y, int z, int meta, Object effectRenderer) {
		return super.addBlockDestroyEffects((World) world, x, y, z, meta, (EffectRenderer) effectRenderer);
	}

	@Override
	public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection forgeDirection, IPlantable iPlantable) {
		return master != null ? master.canSustainPlant(world, x, y, z, forgeDirection, iPlantable) : super.canSustainPlant(world, x, y, z, forgeDirection, iPlantable);
	}

	@Override
	public boolean superCanSustainPlant(Object world, int x, int y, int z, Object forgeDirection, Object iPlantable) {
		return super.canSustainPlant((World) world, x, y, z, (ForgeDirection) forgeDirection, (IPlantable) iPlantable);
	}

	@Override
	public int getLightOpacity(World world, int x, int y, int z) {
		return master != null ? master.getLightOpacity(world, x, y, z) : super.getLightOpacity(world, x, y, z);
	}

	@Override
	public int superGetLightOpacity(Object world, int x, int y, int z) {
		return super.getLightOpacity((World) world, x, y, z);
	}

	@Override
	public boolean isBeaconBase(World world, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return master != null ? master.isBeaconBase(world, x, y, z, beaconX, beaconY, beaconZ) : super.isBeaconBase(world, x, y, z, beaconX, beaconY, beaconZ);
	}

	@Override
	public boolean superIsBeaconBase(Object world, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return super.isBeaconBase((World) world, x, y, z, beaconX, beaconY, beaconZ);
	}

	@Override
	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection forgeDirection) {
		return master != null ? master.rotateBlock(world, x, y, z, forgeDirection) : super.rotateBlock(world, x, y, z, forgeDirection);
	}

	@Override
	public boolean superRotateBlock(Object world, int x, int y, int z, Object forgeDirection) {
		return super.rotateBlock((World) world, x, y, z, (ForgeDirection) forgeDirection);
	}

	@Override
	public ForgeDirection[] getValidRotations(World world, int x, int y, int z) {
		return (ForgeDirection[]) (master != null ? master.getValidRotations(world, x, y, z) : super.getValidRotations(world, x, y, z));
	}

	@Override
	public ForgeDirection[] superGetValidRotations(Object world, int x, int y, int z) {
		return super.getValidRotations((World) world, x, y, z);
	}

	@Override
	public boolean recolourBlock(World world, int x, int y, int z, ForgeDirection forgeDirection, int colour) {
		return master != null ? master.recolourBlock(world, x, y, z, forgeDirection, colour) : super.recolourBlock(world, x, y, z, forgeDirection, colour);
	}

	@Override
	public boolean superRecolourBlock(Object world, int x, int y, int z, Object forgeDirection, int colour) {
		return super.recolourBlock((World) world, x, y, z, (ForgeDirection) forgeDirection, colour);
	}
	// 164~
	public int getExpDrop(World world, int data, int enchantmentLevel) {
		return master != null ? master.getExpDrop(world, data, enchantmentLevel) : 0;
	}

	@Override
	public int superGetExpDrop(Object world, int data, int enchantmentLevel) {
		return 0;
	}

	public boolean shouldCheckWeakPower(World world, int x, int y, int z, int side) {
		return master != null ? master.shouldCheckWeakPower(world, x, y, z, side) : superShouldCheckWeakPower(world, x, y, z, side);
	}

	@Override
	public boolean superShouldCheckWeakPower(Object world, int x, int y, int z, int side) {
		return !this.isNormalCube(((IBlockAccess) world).getBlockId(x, y, z));
	}
	// ~164
	@Override
	protected void initializeBlock() {
		if (master != null) master.initializeBlock();
		else super.initializeBlock();
	}

	@Override
	public void superInitializeBlock() {
		super.initializeBlock();
	}

	@Override
	public float getBlockBrightness(IBlockAccess iBlockAccess, int par2, int par3, int par4) {
		return master != null ? master.getBlockBrightness(iBlockAccess, par2, par3, par4) : super.getBlockBrightness(iBlockAccess, par2, par3, par4);
	}

	@Override
	public float superGetBlockBrightness(Object iBlockAccess, int par2, int par3, int par4) {
		return super.getBlockBrightness((IBlockAccess) iBlockAccess, par2, par3, par4);
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs creativeTabs, List par3List) {
		if (master != null) master.getSubBlocks(par1, creativeTabs, par3List);
		else super.getSubBlocks(par1, creativeTabs, par3List);
	}

	@Override
	public void superGetSubBlocks(Object par1, Object creativeTabs, Object par3List) {
		super.getSubBlocks((Integer) par1, (CreativeTabs) creativeTabs, (List) par3List);
	}

	@Override
	public void addCreativeItems(ArrayList itemList) {
		if (master != null) master.addCreativeItems(itemList);
		else super.addCreativeItems(itemList);
	}

	@Override
	public void superAddCreativeItems(ArrayList itemList) {
		super.addCreativeItems(itemList);
	}

	@Override
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return master != null ? master.canDragonDestroy(world, x, y, z) : super.canDragonDestroy(world, x, y, z);
	}

	@Override
	public boolean superCanDragonDestroy(Object world, int x, int y, int z) {
		return super.canDragonDestroy((World) world, x, y, z);
	}
	// ~152
	@Override
	public String getUnlocalizedName2() {
		return master != null ? master.getUnlocalizedName2() : super.getUnlocalizedName2();
	}

	@Override
	public String superGetUnlocalizedName2() {
		return super.getUnlocalizedName2();
	}

	@Override
	public void onSetBlockIDWithMetaData(World world, int par2, int par3, int par4, int par5) {
		if (master != null) master.onSetBlockIDWithMetaData(world, par2, par3, par4, par5);
		else super.onSetBlockIDWithMetaData(world, par2, par3, par4, par5);
	}

	@Override
	public void superOnSetBlockIDWithMetaData(Object world, int par2, int par3, int par4, int par5) {
		super.onSetBlockIDWithMetaData((World) world, par2, par3, par4, par5);
	}

	@Override
	public boolean isLadder(World world, int x, int y, int z) {
		return master != null ? master.isLadder(world, x, y, z) : super.isLadder(world, x, y, z);
	}

	@Override
	public boolean superIsLadder(Object world, int x, int y, int z) {
		return super.isLadder((World) world, x, y, z);
	}

	@Override
	public int getEnchantPower(World world, int x, int y, int z) {
		return master != null ? master.getEnchantPower(world, x, y, z) : super.getEnchantPower(world, x, y, z);
	}

	@Override
	public int superGetEnchantPower(Object world, int x, int y, int z) {
		return super.getEnchantPower((World) world, x, y, z);
	}
	//
	@Override
	public float superGetAmbientOcclusionLightValue() {
		return 0.0F;
	}

	@Override
	public int superGetFlammability(Object iBlockAccess, int x, int y, int z, Object forgeDirection) {
		return -1;
	}

	@Override
	public boolean superIsFlammable(Object iBlockAccess, int x, int y, int z, Object forgeDirection) {
		return false;
	}

	@Override
	public int superGetFireSpreadSpeed(Object world, int x, int y, int z, Object forgeDirection) {
		return -1;
	}

	@Override
	public boolean superIsFireSource(Object world, int x, int y, int z, Object forgeDirection) {
		return false;
	}

	@Override
	public boolean superCanEntityDestroy(Object world, Object pos, Object entity) {
		return false;
	}

	@Override
	public boolean superIsPassable(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public float superGetBlockHardness(Object world, Object blockPos) {
		return 0.0F;
	}

	@Override
	public int superGetPackedLightmapCoords(Object iBlockAccess, Object blockPos) {
		return -1;
	}

	@Override
	public boolean superShouldSideBeRendered(Object iBlockAccess, Object blockPos, Object side) {
		return false;
	}

	@Override
	public boolean superIsBlockSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public void superAddCollisionBoxesToList(Object world, Object blockPos, Object iBlockState, Object axisAlignedBB, List list, Object entity) {
	}

	@Override
	public Object getCollisionBoundingBox(Object world, Object blockPos, Object iBlockState) {
		return null;
	}

	@Override
	public Object superGetCollisionBoundingBox(Object world, Object blockPos, Object iBlockState) {
		return null;
	}

	@Override
	public void superUpdateTick(Object world, Object blockPos, Object iBlockState, Random par5Random) {
	}

	@Override
	public void superRandomDisplayTick(Object world, Object blockPos, Object iBlockState, Random par5Random) {
	}

	@Override
	public void superOnBlockDestroyedByPlayer(Object world, Object blockPos, Object iBlockState) {
	}

	@Override
	public void superOnBlockAdded(Object world, Object blockPos, Object iBlockState) {
	}

	@Override
	public float superGetPlayerRelativeBlockHardness(Object entityPlayer, Object world, Object blockPos) {
		return 0.0F;
	}

	@Override
	public void superDropBlockAsItemWithChance(Object world, Object blockPos, Object iBlockState, float par6, int par7) {
	}

	@Override
	public void superOnEntityWalk(Object world, Object blockPos, Object entity) {
	}

	@Override
	public boolean superIsFullBlock() {
		return false;
	}

	@Override
	public int superGetLightOpacity() {
		return -1;
	}

	@Override
	public boolean superIsTranslucent() {
		return false;
	}

	@Override
	public int superGetLightValue() {
		return -1;
	}

	@Override
	public boolean superGetUseNeighborBrightness() {
		return false;
	}

	@Override
	public Object superGetMaterial() {
		return null;
	}

	@Override
	public Object superGetMapColor(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return null;
	}

	@Override
	public Object superGetStateFromMeta(int meta) {
		return null;
	}

	@Override
	public int superGetMetaFromState(Object iBlockState) {
		return -1;
	}

	@Override
	public Object superGetActualState(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return null;
	}

	@Override
	public boolean superCausesSuffocation(Object iBlockState) {
		return false;
	}

	@Override
	public boolean superIsReplaceable(Object world, Object blockPos) {
		return false;
	}

	@Override
	public Object superGetSelectedBoundingBox(Object world, Object blockPos) {
		return null;
	}

	@Override
	public void superRandomTick(Object world, Object blockPos, Object iBlockState, Random random) {
	}

	@Override
	public void superNeighborChanged(Object world, Object blockPos, Object iBlockState, Object block, Object blockPos1) {
	}

	@Override
	public void superBreakBlock(Object world, Object blockPos, Object iBlockState) {
	}

	@Override
	public Object superGetItemDropped(Object iBlockState, Random rand, int fortune) {
		return null;
	}

	@Override
	public void superDropXpOnBlockBreak(Object world, Object blockPos, int amount) {
	}

	@Override
	public int superDamageDropped(Object iBlockState) {
		return -1;
	}

	@Override
	public Object superCollisionRayTrace(Object world, Object blockPos, Object vec3, Object vec31) {
		return null;
	}

	@Override
	public void superOnBlockDestroyedByExplosion(Object world, Object blockPos, Object explosion) {
	}

	@Override
	public boolean superCanReplace(Object world, Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}

	@Override
	public boolean superCanPlaceBlockOnSide(Object world, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetBlockLayer() {
		return null;
	}

	@Override
	public boolean superCanPlaceBlockAt(Object world, Object blockPos) {
		return false;
	}

	@Override
	public boolean superOnBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumFacing, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public Object superGetStateForPlacement(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase) {
		return null;
	}

	@Override
	public void superOnBlockClicked(Object world, Object blockPos, Object entityPlayer) {
	}

	@Override
	public Object superModifyAcceleration(Object world, Object blockPos, Object entity, Object vec3) {
		return null;
	}

	@Override
	public void superSetBlockBoundsBasedOnState(Object iBlockAccess, Object blockPos) {
	}

	@Override
	public int superGetRenderColor(Object iBlockState) {
		return -1;
	}

	@Override
	public int superColorMultiplier(Object iBlockAccess, Object blockPos, int renderPass) {
		return -1;
	}

	@Override
	public int superGetWeakPower(Object iBlockAccess, Object blockPos, Object iBlockState, Object enumFacing) {
		return -1;
	}

	@Override
	public void superOnEntityWalk(Object world, Object blockPos, Object iBlockState, Object entity) {
	}

	@Override
	public int superGetStrongPower(Object iBlockAccess, Object blockPos, Object iBlockState, Object enumFacing) {
		return -1;
	}

	@Override
	public void superHarvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity) {
	}

	@Override
	public Object superGetSilkTouchDrop(Object iBlockState) {
		return null;
	}

	@Override
	public void superOnBlockPlacedBy(Object world, Object blockPos, Object iBlockState, Object entityLivingBase, Object itemStack) {
	}

	@Override
	public boolean superEventReceived(Object world, Object blockPos, Object iBlockState, int eventID, int eventParam) {
		return false;
	}

	@Override
	public void superOnFallenUpon(Object world, Object blockPos, Object entity, float fallDistance) {
	}

	@Override
	public void superOnLanded(Object world, Object entity) {
	}

	@Override
	public Object superGetItem(Object world, Object blockPos) {
		return null;
	}

	@Override
	public int superGetDamageValue(Object world, Object blockPos) {
		return -1;
	}

	@Override
	public void superOnBlockHarvested(Object world, Object blockPos, Object iBlockState, Object entityPlayer) {
	}

	@Override
	public void superFillWithRain(Object world, Object blockPos) {
	}

	@Override
	public int superGetComparatorInputOverride(Object world, Object blockPos) {
		return -1;
	}

	@Override
	public Object superGetStateForEntityRender(Object iBlockState) {
		return null;
	}

	@Override
	public Object superCreateBlockState() {
		return null;
	}

	@Override
	public Object superGetBlockState() {
		return null;
	}

	@Override
	public Object superGetOffsetType() {
		return null;
	}

	@Override
	public int superGetLightValue(Object iBlockAccess, Object blockPos) {
		return -1;
	}

	@Override
	public boolean superIsLadder(Object iBlockAccess, Object blockPos, Object entityLivingBase) {
		return false;
	}

	@Override
	public boolean superIsNormalCube(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsSideSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superIsBurning(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsAir(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superCanHarvestBlock(Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return false;
	}

	@Override
	public boolean superRemovedByPlayer(Object world, Object blockPos, Object entityPlayer, boolean willHarvest) {
		return false;
	}

	@Override
	public int superGetFlammability(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return -1;
	}

	@Override
	public boolean superIsFlammable(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public int superGetFireSpreadSpeed(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return -1;
	}

	@Override
	public boolean superIsFireSource(Object world, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superHasTileEntity(Object iBlockState) {
		return false;
	}

	@Override
	public Object superCreateTileEntity(Object world, Object iBlockState) {
		return null;
	}

	@Override
	public int superQuantityDropped(Object iBlockState, int fortune, Random random) {
		return -1;
	}

	@Override
	public Object superGetDrops(Object iBlockAccess, Object blockPos, Object iBlockState, int fortune) {
		return null;
	}

	@Override
	public boolean superCanSilkHarvest(Object world, Object blockPos, Object iBlockState, Object entityPlayer) {
		return false;
	}

	@Override
	public boolean superCanCreatureSpawn(Object iBlockAccess, Object blockPos, Object spawnPlacementType) {
		return false;
	}

	@Override
	public boolean superIsBed(Object iBlockAccess, Object blockPos, Object entity) {
		return false;
	}

	@Override
	public Object superGetBedSpawnPosition(Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return null;
	}

	@Override
	public void superSetBedOccupied(Object iBlockAccess, Object blockPos, Object entityPlayer, boolean occupied) {
	}

	@Override
	public Object superGetBedDirection(Object iBlockAccess, Object blockPos) {
		return null;
	}

	@Override
	public boolean superIsBedFoot(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public void superBeginLeavesDecay(Object world, Object blockPos) {
	}

	@Override
	public boolean superCanSustainLeaves(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsLeaves(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superCanBeReplacedByLeaves(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsWood(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsReplaceableOreGen(Object world, Object blockPos, Object predicate) {
		return false;
	}

	@Override
	public float superGetExplosionResistance(Object world, Object blockPos, Object entity, Object explosion) {
		return 0.0F;
	}

	@Override
	public void superOnBlockExploded(Object world, Object blockPos, Object explosion) {
	}

	@Override
	public boolean superCanConnectRedstone(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superCanPlaceTorchOnTop(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public Object superGetPickBlock(Object movingObjectPosition, Object world, Object blockPos) {
		return null;
	}

	@Override
	public boolean superIsFoliage(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superAddDestroyEffects(Object world, Object blockPos, Object effectRenderer) {
		return false;
	}

	@Override
	public boolean superCanSustainPlant(Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable) {
		return false;
	}

	@Override
	public void superOnPlantGrow(Object world, Object blockPos, Object blockPos1) {
	}

	@Override
	public boolean superIsFertile(Object world, Object blockPos) {
		return false;
	}

	@Override
	public int superGetLightOpacity(Object iBlockAccess, Object blockPos) {
		return -1;
	}

	@Override
	public boolean superIsBeaconBase(Object iBlockAccess, Object blockPos, Object blockPos1) {
		return false;
	}

	@Override
	public boolean superRotateBlock(Object world, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public Object[] superGetValidRotations(Object world, Object blockPos) {
		return null;
	}

	@Override
	public float superGetEnchantPowerBonus(Object world, Object blockPos) {
		return 0.0F;
	}

	@Override
	public boolean superRecolorBlock(Object world, Object blockPos, Object enumFacing, Object enumDyeColor) {
		return false;
	}

	@Override
	public int superGetExpDrop(Object iBlockAccess, Object blockPos, int fortune) {
		return -1;
	}

	@Override
	public void superOnNeighborChange(Object iBlockAccess, Object blockPos, Object blockPos1) {
	}

	@Override
	public boolean superShouldCheckWeakPower(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superGetWeakChanges(Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public void superSetHarvestLevel(String toolClass, int level) {
	}

	@Override
	public void superSetHarvestLevel(String toolClass, int level, Object iBlockState) {
	}

	@Override
	public String superGetHarvestTool(Object iBlockState) {
		return null;
	}

	@Override
	public int superGetHarvestLevel(Object iBlockState) {
		return -1;
	}

	@Override
	public boolean superIsToolEffective(String type, Object iBlockState) {
		return false;
	}

	@Override
	public Object superGetExtendedState(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return null;
	}

	@Override
	public boolean superCanRenderInLayer(Object enumWorldBlockLayer) {
		return false;
	}

	@Override
	public Object superCaptureDrops(boolean start) {
		return null;
	}

	@Override
	public void superOnEntityWalking(Object world, int par2, int par3, int par4, Object entity) {
	}

	@Override
	public boolean superIsNormalCube() {
		return false;
	}

	@Override
	public void superOnBlockPreDestroy(Object world, int par2, int par3, int par4, int par5) {
	}

	@Override
	public Object superSetBlockTextureName(String par1Str) {
		return null;
	}

	@Override
	public String superGetTextureName() {
		return null;
	}

	@Override
	public boolean superCanEntityDestroy(Object world, int x, int y, int z, Object entity) {
		return false;
	}

	@Override
	public void superOnNeighborChange(Object world, int x, int y, int z, int tileX, int tileY, int tileZ) {
	}

	@Override
	public boolean superWeakTileChanges() {
		return false;
	}

	@Override
	public float superGetFilledPercentage(Object world, int x, int y, int z) {
		return 0.0F;
	}
	// 190~
	@Override
	public boolean superIsNormalCube(Object iBlockState) {
		return false;
	}

	@Override
	public Object superGetRenderType(Object iBlockState) {
		return null;
	}

	@Override
	public boolean superIsOpaqueCube(Object iBlockState) {
		return false;
	}

	@Override
	public boolean superCanProvidePower(Object iBlockState) {
		return false;
	}

	@Override
	public Object superGetMobilityFlag(Object iBlockState) {
		return null;
	}

	@Override
	public boolean superHasComparatorInputOverride(Object iBlockState) {
		return false;
	}

	@Override
	public float superGetAmbientOcclusionLightValue(Object iBlockState) {
		return 0.0F;
	}

	@Override
	public boolean superAddHitEffects(Object iBlockState, Object world, Object rayTraceResult, Object effectRenderer) {
		return false;
	}

	@Override
	public float superGetBlockHardness(Object iBlockState, Object world, Object blockPos) {
		return 0.0F;
	}

	@Override
	public int superGetPackedLightmapCoords(Object iBlockStatem, Object iBlockAccess, Object blockPos) {
		return -1;
	}

	@Override
	public boolean superShouldSideBeRendered(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public float superGetPlayerRelativeBlockHardness(Object iBlockState, Object entityPlayer, Object world, Object blockPos) {
		return 0.0F;
	}

	@Override
	public boolean superIsFullBlock(Object iBlockState) {
		return false;
	}

	@Override
	public int superGetLightOpacity(Object iBlockState) {
		return -1;
	}

	@Override
	public boolean superIsTranslucent(Object iBlockState) {
		return false;
	}

	@Override
	public int superGetLightValue(Object iBlockState) {
		return -1;
	}

	@Override
	public boolean superGetUseNeighborBrightness(Object iBlockState) {
		return false;
	}

	@Override
	public Object superGetMaterial(Object iBlockState) {
		return null;
	}

	@Override
	public Object superGetSelectedBoundingBox(Object iBlockState, Object world, Object blockPos) {
		return null;
	}

	@Override
	public Object superCollisionRayTrace(Object iBlockState, Object world, Object blockPos, Object vec3, Object vec31) {
		return null;
	}

	@Override
	public boolean superOnBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumHand, Object itemStack, Object enumFacing, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public void superHarvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity, Object itemStack) {
	}

	@Override
	public Object superGetItem(Object world, Object blockPos, Object iBlockState) {
		return null;
	}

	@Override
	public int superGetComparatorInputOverride(Object iBlockState, Object world, Object blockPos) {
		return -1;
	}

	@Override
	public int superGetLightValue(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return -1;
	}

	@Override
	public boolean superIsLadder(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityLivingBase) {
		return false;
	}

	@Override
	public boolean superIsNormalCube(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsSideSolid(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superIsAir(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superRemovedByPlayer(Object iBlockState, Object world, Object blockPos, Object entityPlayer, boolean willHarvest) {
		return false;
	}

	@Override
	public boolean superCanCreatureSpawn(Object iBlockState, Object iBlockAccess, Object blockPos, Object spawnPlacementType) {
		return false;
	}

	@Override
	public boolean superIsBed(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity) {
		return false;
	}

	@Override
	public Object superGetBedSpawnPosition(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return null;
	}

	@Override
	public Object superGetBedDirection(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return null;
	}

	@Override
	public void superBeginLeavesDecay(Object iBlockState, Object world, Object blockPos) {
	}

	@Override
	public boolean superCanSustainLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superCanBeReplacedByLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public boolean superIsReplaceableOreGen(Object iBlockState, Object iBlockAccess, Object blockPos, Object predicate) {
		return false;
	}

	@Override
	public boolean superCanConnectRedstone(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superCanPlaceTorchOnTop(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return false;
	}

	@Override
	public Object superGetPickBlock(Object iBlockState, Object movingObjectPosition, Object world, Object blockPos, Object entityPlayer) {
		return null;
	}

	@Override
	public boolean superCanSustainPlant(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable) {
		return false;
	}

	@Override
	public void superOnPlantGrow(Object iBlockState, Object world, Object blockPos, Object blockPos1) {
	}

	@Override
	public int superGetLightOpacity(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return -1;
	}

	@Override
	public boolean superCanEntityDestroy(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity) {
		return false;
	}

	@Override
	public int superGetExpDrop(Object iBlockState, Object iBlockAccess, Object blockPos, int fortune) {
		return -1;
	}

	@Override
	public boolean superShouldCheckWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superIsFullCube(Object iBlockState) {
		return false;
	}

	@Override
	public boolean superIsTopSolid(Object iBlockState) {
		return false;
	}

	@Override
	public Object superWithRotation(Object iBlockState, Object rotation) {
		return null;
	}

	@Override
	public Object superWithMirror(Object iBlockState, Object mirror) {
		return null;
	}

	@Override
	public Object superGetBoundingBox(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return null;
	}

	@Override
	public void superAddCollisionBoxToList(Object iBlockState, Object world, Object blockPos, Object axisAlignedBB, Object p_185477_5_, Object entity) {
	}

	@Override
	public void superAddCollisionBoxToList(Object iBlockState, Object world, Object blockPos, Object axisAlignedBB, Object p_185477_5_, Object entity, boolean p_185477_7_) {
	}

	@Override
	public Object superRayTrace(Object blockPos, Object vec3d, Object vec3d1, Object axisAlignedBB) {
		return null;
	}

	@Override
	public boolean superCanSpawnInBlock() {
		return false;
	}

	@Override
	public Object superGetSoundType() {
		return null;
	}

	@Override
	public String superToString() {
		return super.toString();
	}

	@Override
	public boolean superDoesSideBlockRendering(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public boolean superAddLandingEffects(Object iBlockState, Object worldServer, Object blockPos, Object iBlockState1, Object entityLivingBase, int numberOfParticles) {
		return false;
	}

	@Override
	public Object superIsEntityInsideMaterial(Object iBlockAccess, Object blockPos, Object iBlockState, Object entity, double yToTest, Object material, boolean testingHead) {
		return null;
	}

	@Override
	public Object superIsAABBInsideMaterial(Object world, Object blockPos, Object axisAlignedBB, Object material) {
		return null;
	}

	@Override
	public void superEventReceived(Object world, int par2, int par3, int par4, Object par5) {
	}

	@Override
	public boolean superNeighborChanged(Object world, int par2, int par3, int par4, int par5, int par6) {
		return false;
	}

	@Override
	public boolean superGetWeakChanges(Object iBlockAccess, int x, int y, int z) {
		return false;
	}

	@Override
	public void superSetHarvestLevel(String toolClass, int level, int metadata) {
	}

	@Override
	public String superGetHarvestTool(int metadata) {
		return null;
	}

	@Override
	public int superGetHarvestLevel(int metadata) {
		return -1;
	}

	@Override
	public boolean superIsToolEffective(String type, int metadata) {
		return false;
	}

	@Override
	public boolean superFunc_181623_g() {
		return false;
	}

	@Override
	public boolean superDoesSideBlockRendering(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetPickBlock(Object movingObjectPosition, Object world, Object blockPos, Object entityPlayer) {
		return null;
	}

	@Override
	public boolean superAddLandingEffects(Object worldServer, Object blockPos, Object iBlockState, Object entityLivingBase, int numberOfParticles) {
		return false;
	}

	@Override
	public boolean superFunc_149730_j() {
		return superIsFullBlock();
	}

	@Override
	public boolean superGetCanBlockGrass() {
		return false;
	}

	@Override
	public Object superGetMapColor(int p_149728_1_) {
		return null;
	}

	@Override
	public boolean superIsBlockNormalCube() {
		return false;
	}

	@Override
	public Object superFunc_149735_b(int p_149735_1_, int p_149735_2_) {
		return null;
	}

	@Override
	public boolean superRemovedByPlayer(Object world, Object entityPlayer, int x, int y, int z, boolean willHarvest) {
		return super.removeBlockByPlayer((World) world, (EntityPlayer) entityPlayer, x, y, z);
	}

	@Override
	public Object superGetPickBlock(Object movingObjectPosition, Object world, int x, int y, int z, Object entityPlayer) {
		return super.getPickBlock((MovingObjectPosition) movingObjectPosition, (World) world, x, y, z);
	}

	@Override
	public void superAddInformation(Object itemStack, Object world, List tooltip, Object iTooltipFlag) {
	}

	@Override
	public void superObservedNeighborChange(Object iBlockState, Object world, Object blockPos, Object block, Object blockPos1) {
	}

	@Override
	public boolean superCanRenderInLayer(Object iBlockState, Object blockRenderLayer) {
		return false;
	}

	@Override
	public Object superGetSoundType(Object iBlockState, Object world, Object blockPos, Object entity) {
		return null;
	}

	@Override
	public float[] superGetBeaconColorMultiplier(Object iBlockState, Object world, Object blockPos, Object blockPos1) {
		return null;
	}

	@Override
	public Object superGetStateForPlacement(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase, Object enumHand) {
		return null;
	}

	@Override
	public boolean superCanBeConnectedTo(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetAiPathNodeType(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return null;
	}

}
