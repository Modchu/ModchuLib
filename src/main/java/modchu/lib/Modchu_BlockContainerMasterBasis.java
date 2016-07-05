package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Modchu_BlockContainerMasterBasis implements Modchu_IBlockContainerMaster {
	public Modchu_IBlockContainer base;

	public Modchu_BlockContainerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IBlockContainer) map.get("base");
	}

	@Override
	public void initializeBlock() {
		base.superInitializeBlock();
	}

	@Override
	public Object setSoundType(Object stepSound) {
		return base.superSetSoundType(stepSound);
	}

	@Override
	public Object setLightOpacity(int par1) {
		return base.superSetLightOpacity(par1);
	}

	@Override
	public Object setLightLevel(float par1) {
		return base.superSetLightLevel(par1);
	}

	@Override
	public Object setResistance(float par1) {
		return base.superSetResistance(par1);
	}

	@Override
	public boolean isFullCube() {
		return base.superIsFullCube();
	}

	@Override
	public boolean isPassable(Object iBlockAccess, int par2, int par3, int par4) {
		return base.superIsPassable(iBlockAccess, par2, par3, par4);
	}

	@Override
	public int getRenderType() {
		return base.superGetRenderType();
	}

	@Override
	public Object setHardness(float par1) {
		return base.superSetHardness(par1);
	}

	@Override
	public Object setBlockUnbreakable() {
		return base.superSetBlockUnbreakable();
	}

	@Override
	public float getBlockHardness(Object world, int par2, int par3, int par4) {
		return base.superGetBlockHardness(world, par2, par3, par4);
	}

	@Override
	public Object setTickRandomly(boolean par1) {
		return base.superSetTickRandomly(par1);
	}

	@Override
	public boolean getTickRandomly() {
		return base.superGetTickRandomly();
	}

	@Override
	public boolean hasTileEntity() {
		return base.superHasTileEntity();
	}

	@Override
	public float getBlockBrightness(Object iBlockAccess, int par2, int par3, int par4) {
		return base.superGetBlockBrightness(iBlockAccess, par2, par3, par4);
	}

	@Override
	public int getPackedLightmapCoords(Object iBlockAccess, int par2, int par3, int par4) {
		return base.superGetPackedLightmapCoords(iBlockAccess, par2, par3, par4);
	}

	@Override
	public boolean shouldSideBeRendered(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return base.superShouldSideBeRendered(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public boolean isBlockSolid(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return base.superIsBlockSolid(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public Object getBlockTexture(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return base.superGetBlockTexture(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public Object getIcon(int par1, int par2) {
		return base.superGetIcon(par1, par2);
	}

	@Override
	public void addCollisionBoxesToList(Object world, int par2, int par3, int par4, Object axisAlignedBB, List par6List, Object entity) {
		base.superAddCollisionBoxesToList(world, par2, par3, par4, axisAlignedBB, par6List, entity);
	}

	@Override
	public Object getCollisionBoundingBox(Object world, int par2, int par3, int par4) {
		return base.superGetCollisionBoundingBox(world, par2, par3, par4);
	}

	@Override
	public Object getCollisionBoundingBoxFromPool(Object world, int par2, int par3, int par4) {
		return base.superGetCollisionBoundingBoxFromPool(world, par2, par3, par4);
	}

	@Override
	public boolean isOpaqueCube() {
		return base.superIsOpaqueCube();
	}

	@Override
	public boolean canCollideCheck(int par1, boolean par2) {
		return base.superCanCollideCheck(par1, par2);
	}

	@Override
	public boolean isCollidable() {
		return base.superIsCollidable();
	}

	@Override
	public void updateTick(Object world, int par2, int par3, int par4, Random par5Random) {
		base.superUpdateTick(world, par2, par3, par4, par5Random);
	}

	@Override
	public void randomDisplayTick(Object world, int par2, int par3, int par4, Random par5Random) {
		base.superRandomDisplayTick(world, par2, par3, par4, par5Random);
	}

	@Override
	public void onBlockDestroyedByPlayer(Object world, int par2, int par3, int par4, int par5) {
		base.superOnBlockDestroyedByPlayer(world, par2, par3, par4, par5);
	}

	@Override
	public void neighborChanged(Object world, int par2, int par3, int par4, Object par5) {
		base.superNeighborChanged(world, par2, par3, par4, par5);
	}

	@Override
	public int tickRate(Object world) {
		return base.superTickRate(world);
	}

	@Override
	public void onBlockAdded(Object world, int par2, int par3, int par4) {
		base.superOnBlockAdded(world, par2, par3, par4);
	}

	@Override
	public void breakBlock(Object world, int par2, int par3, int par4, Object par5, int par6) {
		base.superBreakBlock(world, par2, par3, par4, par5, par6);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return base.superQuantityDropped(par1Random);
	}

	@Override
	public Object getItemDropped(int par1, Random par2Random, int par3) {
		return base.superGetItemDropped(par1, par2Random, par3);
	}

	@Override
	public float getPlayerRelativeBlockHardness(Object entityPlayer, Object world, int par3, int par4, int par5) {
		return base.superGetPlayerRelativeBlockHardness(entityPlayer, world, par3, par4, par5);
	}

	@Override
	public void dropBlockAsItemWithChance(Object world, int par2, int par3, int par4, int par5, float par6, int par7) {
		base.superDropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void dropBlockAsItem(Object world, int par2, int par3, int par4, Object itemStack) {
		base.superDropBlockAsItem(world, par2, par3, par4, itemStack);
	}

	@Override
	public void dropXpOnBlockBreak(Object world, int par2, int par3, int par4, int par5) {
		base.superDropXpOnBlockBreak(world, par2, par3, par4, par5);
	}

	@Override
	public int damageDropped(int par1) {
		return base.superDamageDropped(par1);
	}

	@Override
	public float getExplosionResistance(Object entity) {
		return base.superGetExplosionResistance(entity);
	}

	@Override
	public Object collisionRayTrace(Object world, int par2, int par3, int par4, Object vec3, Object vec31) {
		return base.superCollisionRayTrace(world, par2, par3, par4, vec3, vec31);
	}

	@Override
	public void onBlockDestroyedByExplosion(Object world, int par2, int par3, int par4, Object explosion) {
		base.superOnBlockDestroyedByExplosion(world, par2, par3, par4, explosion);
	}

	@Override
	public boolean canReplace(Object world, int par2, int par3, int par4, int par5, Object itemStack) {
		return base.superCanReplace(world, par2, par3, par4, par5, itemStack);
	}

	@Override
	public int getRenderBlockPass() {
		return base.superGetRenderBlockPass();
	}

	@Override
	public boolean canPlaceBlockOnSide(Object world, int par2, int par3, int par4, int par5) {
		return base.superCanPlaceBlockOnSide(world, par2, par3, par4, par5);
	}

	@Override
	public boolean canPlaceBlockAt(Object world, int par2, int par3, int par4) {
		return base.superCanPlaceBlockAt(world, par2, par3, par4);
	}

	@Override
	public boolean onBlockActivated(Object world, int par2, int par3, int par4, Object entityPlayer, int par6, float par7, float par8, float par9) {
		return base.superOnBlockActivated(world, par2, par3, par4, entityPlayer, par6, par7, par8, par9);
	}

	@Override
	public void onEntityWalk(Object world, int par2, int par3, int par4, Object entity) {
		base.superOnEntityWalking(world, par2, par3, par4, entity);
	}

	@Override
	public int onBlockPlaced(Object world, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return base.superOnBlockPlaced(world, par2, par3, par4, par5, par6, par7, par8, par9);
	}

	@Override
	public void onBlockClicked(Object world, int par2, int par3, int par4, Object entityPlayer) {
		base.superOnBlockClicked(world, par2, par3, par4, entityPlayer);
	}

	@Override
	public void velocityToAddToEntity(Object world, int par2, int par3, int par4, Object entity, Object vec3) {
		base.superVelocityToAddToEntity(world, par2, par3, par4, entity, vec3);
	}

	@Override
	public void setBlockBoundsBasedOnState(Object iBlockAccess, int par2, int par3, int par4) {
		base.superSetBlockBoundsBasedOnState(iBlockAccess, par2, par3, par4);
	}

	@Override
	public int getBlockColor() {
		return base.superGetBlockColor();
	}

	@Override
	public int getRenderColor(int par1) {
		return base.superGetRenderColor(par1);
	}

	@Override
	public int getWeakPower(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return base.superGetWeakPower(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public int colorMultiplier(Object iBlockAccess, int par2, int par3, int par4) {
		return base.superColorMultiplier(iBlockAccess, par2, par3, par4);
	}

	@Override
	public boolean canProvidePower() {
		return base.superCanProvidePower();
	}

	@Override
	public int getStrongPower(Object iBlockAccess, int par2, int par3, int par4, int par5) {
		return base.superGetStrongPower(iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public void setBlockBoundsForItemRender() {
		base.superSetBlockBoundsForItemRender();
	}

	@Override
	public void harvestBlock(Object world, Object entityPlayer, int par3, int par4, int par5, int par6) {
		base.superHarvestBlock(world, entityPlayer, par3, par4, par5, par6);
	}

	@Override
	public boolean canSilkHarvest() {
		return base.superCanSilkHarvest();
	}

	@Override
	public Object createStackedBlock(int par1) {
		return base.superCreateStackedBlock(par1);
	}

	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random) {
		return base.superQuantityDroppedWithBonus(par1, par2Random);
	}

	@Override
	public boolean canBlockStay(Object world, int par2, int par3, int par4) {
		return base.superCanBlockStay(world, par2, par3, par4);
	}

	@Override
	public void onBlockPlacedBy(Object world, int par2, int par3, int par4, Object entityLivingBase, Object itemStack) {
		base.superOnBlockPlacedBy(world, par2, par3, par4, entityLivingBase, itemStack);
	}

	@Override
	public void onPostBlockPlaced(Object world, int par2, int par3, int par4, int par5) {
		base.superOnPostBlockPlaced(world, par2, par3, par4, par5);
	}

	@Override
	public Object setUnlocalizedName(String par1Str) {
		return base.superSetUnlocalizedName(par1Str);
	}

	@Override
	public String getLocalizedName() {
		return base.superGetLocalizedName();
	}

	@Override
	public String getUnlocalizedName() {
		return base.superGetUnlocalizedName();
	}

	@Override
	public boolean eventReceived(Object world, int par2, int par3, int par4, int par5, int par6) {
		return base.superEventReceived(world, par2, par3, par4, par5, par6);
	}

	@Override
	public boolean getEnableStats() {
		return base.superGetEnableStats();
	}

	@Override
	public Object disableStats() {
		return base.superDisableStats();
	}

	@Override
	public int getMobilityFlag() {
		return base.superGetMobilityFlag();
	}

	@Override
	public float getAmbientOcclusionLightValue(Object iBlockAccess, int par2, int par3, int par4) {
		return base.superGetAmbientOcclusionLightValue(iBlockAccess, par2, par3, par4);
	}

	@Override
	public void onFallenUpon(Object world, int par2, int par3, int par4, Object entity, float par6) {
		base.superOnFallenUpon(world, par2, par3, par4, entity, par6);
	}

	@Override
	public Object getItem(Object world, int par2, int par3, int par4) {
		return base.superGetItem(world, par2, par3, par4);
	}

	@Override
	public int getDamageValue(Object world, int par2, int par3, int par4) {
		return base.superGetDamageValue(world, par2, par3, par4);
	}

	@Override
	public void getSubBlocks(Object par1, Object creativeTabs, List par3List) {
		base.superGetSubBlocks(par1, creativeTabs, par3List);
	}

	@Override
	public Object setCreativeTab(Object creativeTabs) {
		return base.superSetCreativeTab(creativeTabs);
	}

	@Override
	public void onBlockHarvested(Object world, int par2, int par3, int par4, int par5, Object entityPlayer) {
		base.superOnBlockHarvested(world, par2, par3, par4, par5, entityPlayer);
	}

	@Override
	public Object getCreativeTabToDisplayOn() {
		return base.superGetCreativeTabToDisplayOn();
	}

	@Override
	public void onBlockPreDestroy(Object world, int par2, int par3, int par4, int par5) {
		base.superOnBlockPreDestroy(world, par2, par3, par4, par5);
	}

	@Override
	public void fillWithRain(Object world, int par2, int par3, int par4) {
		base.superFillWithRain(world, par2, par3, par4);
	}

	@Override
	public boolean isFlowerPot() {
		return base.superIsFlowerPot();
	}

	@Override
	public boolean requiresUpdates() {
		return base.superRequiresUpdates();
	}

	@Override
	public boolean canDropFromExplosion(Object explosion) {
		return base.superCanDropFromExplosion(explosion);
	}

	@Override
	public boolean isAssociatedBlock(Object par1) {
		return base.superIsAssociatedBlock(par1);
	}

	@Override
	public boolean hasComparatorInputOverride() {
		return base.superHasComparatorInputOverride();
	}

	@Override
	public int getComparatorInputOverride(Object world, int par2, int par3, int par4, int par5) {
		return base.superGetComparatorInputOverride(world, par2, par3, par4, par5);
	}

	@Override
	public Object setBlockTextureName(String par1Str) {
		return base.superSetBlockTextureName(par1Str);
	}

	@Override
	public String getTextureName() {
		return base.superGetTextureName();
	}

	@Override
	public void registerIcons(Object iconRegister) {
		base.superRegisterIcons(iconRegister);
	}

	@Override
	public String getItemIconName() {
		return base.superGetItemIconName();
	}

	@Override
	public int getLightValue(Object iBlockAccess, int x, int y, int z) {
		return base.superGetLightValue(iBlockAccess, x, y, z);
	}

	@Override
	public boolean isLadder(Object world, int x, int y, int z, Object entityLivingBase) {
		return base.superIsLadder(world, x, y, z, entityLivingBase);
	}

	@Override
	public boolean isNormalCube(Object world, int x, int y, int z) {
		return base.superIsNormalCube(world, x, y, z);
	}

	@Override
	public boolean isSideSolid(Object world, int x, int y, int z, Object forgeDirection) {
		return base.superIsSideSolid(world, x, y, z, forgeDirection);
	}

	@Override
	public boolean isReplaceable(Object world, int x, int y, int z) {
		return base.superIsReplaceable(world, x, y, z);
	}

	@Override
	public boolean isBurning(Object world, int x, int y, int z) {
		return base.superIsBurning(world, x, y, z);
	}

	@Override
	public boolean isAir(Object world, int x, int y, int z) {
		return base.superIsAir(world, x, y, z);
	}

	@Override
	public boolean canHarvestBlock(Object entityPlayer, int meta) {
		return base.superCanHarvestBlock(entityPlayer, meta);
	}

	@Override
	public boolean removedByPlayer(Object world, Object entityPlayer, int x, int y, int z) {
		return base.superRemovedByPlayer(world, entityPlayer, x, y, z);
	}

	@Override
	public void addCreativeItems(ArrayList itemList) {
		base.superAddCreativeItems(itemList);
	}

	@Override
	public int getFlammability(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return base.superGetFlammability(iBlockAccess, x, y, z, metadata, forgeDirection);
	}

	@Override
	public boolean isFlammable(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection) {
		return base.superIsFlammable(iBlockAccess, x, y, z, metadata, forgeDirection);
	}

	@Override
	public int getFireSpreadSpeed(Object world, int x, int y, int z, int metadata, Object forgeDirection) {
		return base.superGetFireSpreadSpeed(world, x, y, z, metadata, forgeDirection);
	}

	@Override
	public boolean isFireSource(Object world, int x, int y, int z, int metadata, Object forgeDirection) {
		return base.superIsFireSource(world, x, y, z, metadata, forgeDirection);
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return base.superHasTileEntity(metadata);
	}

	@Override
	public Object createTileEntity(Object world, int metadata) {
		return base.superCreateTileEntity(world, metadata);
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return base.superQuantityDropped(meta, fortune, random);
	}

	@Override
	public Object getDrops(Object world, int x, int y, int z, int metadata, int fortune) {
		return base.superGetDrops(world, x, y, z, metadata, fortune);
	}

	@Override
	public boolean canSilkHarvest(Object world, Object entityPlayer, int x, int y, int z, int metadata) {
		return base.superCanSilkHarvest(world, entityPlayer, x, y, z, metadata);
	}

	@Override
	public boolean canCreatureSpawn(Object enumCreatureType, Object world, int x, int y, int z) {
		return base.superCanCreatureSpawn(enumCreatureType, world, x, y, z);
	}

	@Override
	public boolean isBed(Object world, int x, int y, int z, Object entityLivingBase) {
		return base.superIsBed(world, x, y, z, entityLivingBase);
	}

	@Override
	public Object getBedSpawnPosition(Object world, int x, int y, int z, Object entityPlayer) {
		return base.superGetBedSpawnPosition(world, x, y, z, entityPlayer);
	}

	@Override
	public void setBedOccupied(Object world, int x, int y, int z, Object entityPlayer, boolean occupied) {
		base.superSetBedOccupied(world, x, y, z, entityPlayer, occupied);
	}

	@Override
	public int getBedDirection(Object iBlockAccess, int x, int y, int z) {
		return base.superGetBedDirection(iBlockAccess, x, y, z);
	}

	@Override
	public boolean isBedFoot(Object iBlockAccess, int x, int y, int z) {
		return base.superIsBedFoot(iBlockAccess, x, y, z);
	}

	@Override
	public void beginLeavesDecay(Object world, int x, int y, int z) {
		base.superBeginLeavesDecay(world, x, y, z);
	}

	@Override
	public boolean canSustainLeaves(Object world, int x, int y, int z) {
		return base.superCanSustainLeaves(world, x, y, z);
	}

	@Override
	public boolean isLeaves(Object world, int x, int y, int z) {
		return base.superIsLeaves(world, x, y, z);
	}

	@Override
	public boolean canBeReplacedByLeaves(Object world, int x, int y, int z) {
		return base.superCanBeReplacedByLeaves(world, x, y, z);
	}

	@Override
	public boolean isWood(Object world, int x, int y, int z) {
		return base.superIsWood(world, x, y, z);
	}

	@Override
	public boolean isReplaceableOreGen(Object world, int x, int y, int z, int target) {
		return base.superIsReplaceableOreGen(world, x, y, z, target);
	}

	@Override
	public float getExplosionResistance(Object entity, Object world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		return base.superGetExplosionResistance(entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public void onBlockExploded(Object world, int x, int y, int z, Object explosion) {
		base.superOnBlockExploded(world, x, y, z, explosion);
	}

	@Override
	public boolean canConnectRedstone(Object iBlockAccess, int x, int y, int z, int side) {
		return base.superCanConnectRedstone(iBlockAccess, x, y, z, side);
	}

	@Override
	public boolean canPlaceTorchOnTop(Object world, int x, int y, int z) {
		return base.superCanPlaceTorchOnTop(world, x, y, z);
	}

	@Override
	public boolean canRenderInPass(int pass) {
		return base.superCanRenderInPass(pass);
	}

	@Override
	public Object getPickBlock(Object movingObjectPosition, Object world, int x, int y, int z) {
		return base.superGetPickBlock(movingObjectPosition, world, x, y, z);
	}

	@Override
	public boolean isFoliage(Object world, int x, int y, int z) {
		return base.superIsFoliage(world, x, y, z);
	}

	@Override
	public boolean addHitEffects(Object world, Object movingObjectPosition, Object effectRenderer) {
		return base.superAddHitEffects(world, movingObjectPosition, effectRenderer);
	}

	@Override
	public boolean addDestroyEffects(Object world, int x, int y, int z, int meta, Object effectRenderer) {
		return base.superAddDestroyEffects(world, x, y, z, meta, effectRenderer);
	}

	@Override
	public boolean canSustainPlant(Object world, int x, int y, int z, Object forgeDirection, Object iPlantable) {
		return base.superCanSustainPlant(world, x, y, z, forgeDirection, iPlantable);
	}

	@Override
	public void onPlantGrow(Object world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		base.superOnPlantGrow(world, x, y, z, sourceX, sourceY, sourceZ);
	}

	@Override
	public boolean isFertile(Object world, int x, int y, int z) {
		return base.superIsFertile(world, x, y, z);
	}

	@Override
	public int getLightOpacity(Object world, int x, int y, int z) {
		return base.superGetLightOpacity(world, x, y, z);
	}

	@Override
	public boolean canEntityDestroy(Object world, int x, int y, int z, Object entity) {
		return base.superCanEntityDestroy(world, x, y, z, entity);
	}

	@Override
	public boolean canDragonDestroy(Object world, int x, int y, int z) {
		return base.superCanDragonDestroy(world, x, y, z);
	}

	@Override
	public boolean isBeaconBase(Object world, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return base.superIsBeaconBase(world, x, y, z, beaconX, beaconY, beaconZ);
	}

	@Override
	public boolean rotateBlock(Object world, int x, int y, int z, Object forgeDirection) {
		return base.superRotateBlock(world, x, y, z, forgeDirection);
	}

	@Override
	public Object[] getValidRotations(Object world, int x, int y, int z) {
		return base.superGetValidRotations(world, x, y, z);
	}

	@Override
	public float getEnchantPowerBonus(Object world, int x, int y, int z) {
		return base.superGetEnchantPowerBonus(world, x, y, z);
	}

	@Override
	public boolean recolourBlock(Object world, int x, int y, int z, Object forgeDirection, int colour) {
		return base.superRecolourBlock(world, x, y, z, forgeDirection, colour);
	}

	@Override
	public int getExpDrop(Object world, int data, int enchantmentLevel) {
		return base.superGetExpDrop(world, data, enchantmentLevel);
	}

	@Override
	public void onNeighborChange(Object world, int x, int y, int z, int tileX, int tileY, int tileZ) {
		base.superOnNeighborChange(world, x, y, z, tileX, tileY, tileZ);
	}

	@Override
	public boolean weakTileChanges() {
		return base.superWeakTileChanges();
	}

	@Override
	public boolean shouldCheckWeakPower(Object world, int x, int y, int z, int side) {
		return base.superShouldCheckWeakPower(world, x, y, z, side);
	}

	@Override
	public float getFilledPercentage(Object world, int x, int y, int z) {
		return base.superGetFilledPercentage(world, x, y, z);
	}

	@Override
	public float getAmbientOcclusionLightValue() {
		return base.superGetAmbientOcclusionLightValue();
	}

	@Override
	public int getFlammability(Object iBlockAccess, int x, int y, int z, Object forgeDirection) {
		return base.superGetFlammability(iBlockAccess, x, y, z, forgeDirection);
	}

	@Override
	public boolean isFlammable(Object iBlockAccess, int x, int y, int z, Object forgeDirection) {
		return base.superIsFlammable(iBlockAccess, x, y, z, forgeDirection);
	}

	@Override
	public int getFireSpreadSpeed(Object iBlockAccess, int x, int y, int z, Object forgeDirection) {
		return base.superGetFireSpreadSpeed(iBlockAccess, x, y, z, forgeDirection);
	}

	@Override
	public boolean isFireSource(Object world, int x, int y, int z, Object forgeDirection) {
		return base.superIsFireSource(world, x, y, z, forgeDirection);
	}

	@Override
	public boolean isReplaceableOreGen(Object world, int x, int y, int z, Object target) {
		return base.superIsReplaceableOreGen(world, x, y, z, target);
	}

	@Override
	public boolean isPassable(Object iBlockAccess, Object blockPos) {
		return base.superIsPassable(iBlockAccess, blockPos);
	}

	@Override
	public float getBlockHardness(Object world, Object blockPos) {
		return base.superGetBlockHardness(world, blockPos);
	}

	@Override
	public int getPackedLightmapCoords(Object iBlockAccess, Object blockPos) {
		return base.superGetPackedLightmapCoords(iBlockAccess, blockPos);
	}

	@Override
	public boolean shouldSideBeRendered(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superShouldSideBeRendered(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean isBlockSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superIsBlockSolid(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public void addCollisionBoxesToList(Object world, Object blockPos, Object iBlockState, Object axisAlignedBB, List list, Object entity) {
		base.superAddCollisionBoxesToList(world, blockPos, iBlockState, axisAlignedBB, list, entity);
	}

	@Override
	public Object getCollisionBoundingBox(Object world, Object blockPos, Object iBlockState) {
		return base.superGetCollisionBoundingBox(world, blockPos, iBlockState);
	}

	@Override
	public boolean canCollideCheck(Object iBlockState, boolean par2) {
		return base.superCanCollideCheck(iBlockState, par2);
	}

	@Override
	public void updateTick(Object world, Object blockPos, Object iBlockState, Random par5Random) {
		base.superUpdateTick(world, blockPos, iBlockState, par5Random);
	}

	@Override
	public void randomDisplayTick(Object world, Object blockPos, Object iBlockState, Random par5Random) {
		base.superRandomDisplayTick(world, blockPos, iBlockState, par5Random);
	}

	@Override
	public void onBlockDestroyedByPlayer(Object world, Object blockPos, Object iBlockState) {
		base.superOnBlockDestroyedByPlayer(world, blockPos, iBlockState);
	}

	@Override
	public void onBlockAdded(Object world, Object blockPos, Object iBlockState) {
		base.superOnBlockAdded(world, blockPos, iBlockState);
	}

	@Override
	public float getPlayerRelativeBlockHardness(Object entityPlayer, Object world, Object blockPos) {
		return base.superGetPlayerRelativeBlockHardness(entityPlayer, world, blockPos);
	}

	@Override
	public void dropBlockAsItemWithChance(Object world, Object blockPos, Object iBlockState, float par6, int par7) {
		base.superDropBlockAsItemWithChance(world, blockPos, iBlockState, par6, par7);
	}

	@Override
	public void onEntityWalk(Object world, Object blockPos, Object entity) {
		base.superOnEntityWalk(world, blockPos, entity);
	}

	@Override
	public boolean isFullBlock() {
		return base.superIsFullBlock();
	}

	@Override
	public int getLightOpacity() {
		return base.superGetLightOpacity();
	}

	@Override
	public boolean isTranslucent() {
		return base.superIsTranslucent();
	}

	@Override
	public int getLightValue() {
		return base.superGetLightValue();
	}

	@Override
	public boolean getUseNeighborBrightness() {
		return base.superGetUseNeighborBrightness();
	}

	@Override
	public Object getMaterial() {
		return base.superGetMaterial();
	}

	@Override
	public Object getMapColor(Object iBlockState) {
		return base.superGetMapColor(iBlockState);
	}

	@Override
	public Object getStateFromMeta(int meta) {
		return base.superGetStateFromMeta(meta);
	}

	@Override
	public int getMetaFromState(Object iBlockState) {
		return base.superGetMetaFromState(iBlockState);
	}

	@Override
	public Object getActualState(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superGetActualState(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean isBlockNormalCube() {
		return base.superIsNormalCube();
	}

	@Override
	public boolean isNormalCube() {
		return base.superIsNormalCube();
	}

	@Override
	public boolean isVisuallyOpaque() {
		return base.superIsVisuallyOpaque();
	}

	@Override
	public boolean isReplaceable(Object world, Object blockPos) {
		return base.superIsReplaceable(world, blockPos);
	}

	@Override
	public Object getSelectedBoundingBox(Object world, Object blockPos) {
		return base.superGetSelectedBoundingBox(world, blockPos);
	}

	@Override
	public void randomTick(Object world, Object blockPos, Object iBlockState, Random random) {
		base.superRandomTick(world, blockPos, iBlockState, random);
	}

	@Override
	public void neighborChanged(Object world, Object blockPos, Object iBlockState, Object block) {
		base.superNeighborChanged(world, blockPos, iBlockState, block);
	}

	@Override
	public void breakBlock(Object world, Object blockPos, Object iBlockState) {
		base.superBreakBlock(world, blockPos, iBlockState);
	}

	@Override
	public Object getItemDropped(Object iBlockState, Random rand, int fortune) {
		return base.superGetItemDropped(iBlockState, rand, fortune);
	}

	@Override
	public void dropXpOnBlockBreak(Object world, Object blockPos, int amount) {
		base.superDropXpOnBlockBreak(world, blockPos, amount);
	}

	@Override
	public int damageDropped(Object iBlockState) {
		return base.superDamageDropped(iBlockState);
	}

	@Override
	public Object collisionRayTrace(Object world, Object blockPos, Object vec3, Object vec31) {
		return base.superCollisionRayTrace(world, blockPos, vec3, vec31);
	}

	@Override
	public void onBlockDestroyedByExplosion(Object world, Object blockPos, Object explosion) {
		base.superOnBlockDestroyedByExplosion(world, blockPos, explosion);
	}

	@Override
	public boolean canReplace(Object world, Object blockPos, Object enumFacing, Object itemStack) {
		return base.superCanReplace(world, blockPos, enumFacing, itemStack);
	}

	@Override
	public boolean canPlaceBlockOnSide(Object world, Object blockPos, Object enumFacing) {
		return base.superCanPlaceBlockOnSide(world, blockPos, enumFacing);
	}

	@Override
	public Object getBlockLayer() {
		return base.superGetBlockLayer();
	}

	@Override
	public boolean canPlaceBlockAt(Object world, Object blockPos) {
		return base.superCanPlaceBlockAt(world, blockPos);
	}

	@Override
	public boolean onBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumFacing, float hitX, float hitY, float hitZ) {
		return base.superOnBlockActivated(world, blockPos, iBlockState, entityPlayer, enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public Object onBlockPlaced(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase) {
		return base.superOnBlockPlaced(world, blockPos, enumFacing, hitX, hitY, hitZ, meta, entityLivingBase);
	}

	@Override
	public void onBlockClicked(Object world, Object blockPos, Object entityPlayer) {
		base.superOnBlockClicked(world, blockPos, entityPlayer);
	}

	@Override
	public Object modifyAcceleration(Object world, Object blockPos, Object entity, Object vec3) {
		return base.superModifyAcceleration(world, blockPos, entity, vec3);
	}

	@Override
	public void setBlockBoundsBasedOnState(Object iBlockAccess, Object blockPos) {
		base.superSetBlockBoundsBasedOnState(iBlockAccess, blockPos);
	}

	@Override
	public int getRenderColor(Object iBlockState) {
		return base.superGetRenderColor(iBlockState);
	}

	@Override
	public int colorMultiplier(Object iBlockAccess, Object blockPos, int renderPass) {
		return base.superColorMultiplier(iBlockAccess, blockPos, renderPass);
	}

	@Override
	public int getWeakPower(Object iBlockAccess, Object blockPos, Object iBlockState, Object enumFacing) {
		return base.superGetWeakPower(iBlockAccess, blockPos, iBlockState, enumFacing);
	}

	@Override
	public void onEntityWalk(Object world, Object blockPos, Object iBlockState, Object entity) {
		base.superOnEntityWalk(world, blockPos, iBlockState, entity);
	}

	@Override
	public int getStrongPower(Object iBlockAccess, Object blockPos, Object iBlockState, Object enumFacing) {
		return base.superGetStrongPower(iBlockAccess, blockPos, iBlockState, enumFacing);
	}

	@Override
	public void harvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity) {
		base.superHarvestBlock(world, entityPlayer, blockPos, iBlockState, tileEntity);
	}

	@Override
	public Object createStackedBlock(Object iBlockState) {
		return base.superCreateStackedBlock(iBlockState);
	}

	@Override
	public void onBlockPlacedBy(Object world, Object blockPos, Object iBlockState, Object entityLivingBase, Object itemStack) {
		base.superOnBlockPlacedBy(world, blockPos, iBlockState, entityLivingBase, itemStack);
	}

	@Override
	public boolean eventReceived(Object world, Object blockPos, Object iBlockState, int eventID, int eventParam) {
		return base.superEventReceived(world, blockPos, iBlockState, eventID, eventParam);
	}

	@Override
	public void onFallenUpon(Object world, Object blockPos, Object entity, float fallDistance) {
		base.superOnFallenUpon(world, blockPos, entity, fallDistance);
	}

	@Override
	public void onLanded(Object world, Object entity) {
		base.superOnLanded(world, entity);
	}

	@Override
	public Object getItem(Object world, Object blockPos) {
		return base.superGetItem(world, blockPos);
	}

	@Override
	public int getDamageValue(Object world, Object blockPos) {
		return base.superGetDamageValue(world, blockPos);
	}

	@Override
	public void onBlockHarvested(Object world, Object blockPos, Object iBlockState, Object entityPlayer) {
		base.superOnBlockHarvested(world, blockPos, iBlockState, entityPlayer);
	}

	@Override
	public void fillWithRain(Object world, Object blockPos) {
		base.superFillWithRain(world, blockPos);
	}

	@Override
	public int getComparatorInputOverride(Object world, Object blockPos) {
		return base.superGetComparatorInputOverride(world, blockPos);
	}

	@Override
	public Object getStateForEntityRender(Object iBlockState) {
		return base.superGetStateForEntityRender(iBlockState);
	}

	@Override
	public Object createBlockState() {
		return base.superCreateBlockState();
	}

	@Override
	public Object getBlockState() {
		return base.superGetBlockState();
	}

	@Override
	public Object getOffsetType() {
		return base.superGetOffsetType();
	}

	@Override
	public int getLightValue(Object iBlockAccess, Object blockPos) {
		return base.superGetLightValue(iBlockAccess, blockPos);
	}

	@Override
	public boolean isLadder(Object iBlockAccess, Object blockPos, Object entityLivingBase) {
		return base.superIsLadder(iBlockAccess, blockPos, entityLivingBase);
	}

	@Override
	public boolean isNormalCube(Object iBlockAccess, Object blockPos) {
		return base.superIsNormalCube(iBlockAccess, blockPos);
	}

	@Override
	public boolean isSideSolid(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superIsSideSolid(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean isBurning(Object iBlockAccess, Object blockPos) {
		return base.superIsBurning(iBlockAccess, blockPos);
	}

	@Override
	public boolean isAir(Object iBlockAccess, Object blockPos) {
		return base.superIsAir(iBlockAccess, blockPos);
	}

	@Override
	public boolean canHarvestBlock(Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return base.superCanHarvestBlock(iBlockAccess, blockPos, entityPlayer);
	}

	@Override
	public boolean removedByPlayer(Object world, Object blockPos, Object entityPlayer, boolean willHarvest) {
		return base.superRemovedByPlayer(world, blockPos, entityPlayer, willHarvest);
	}

	@Override
	public int getFlammability(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superGetFlammability(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean isFlammable(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superIsFlammable(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public int getFireSpreadSpeed(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superGetFireSpreadSpeed(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean isFireSource(Object world, Object blockPos, Object enumFacing) {
		return base.superIsFireSource(world, blockPos, enumFacing);
	}

	@Override
	public boolean hasTileEntity(Object iBlockState) {
		return base.superHasTileEntity(iBlockState);
	}

	@Override
	public Object createTileEntity(Object world, Object iBlockState) {
		return base.superCreateTileEntity(world, iBlockState);
	}

	@Override
	public int quantityDropped(Object iBlockState, int fortune, Random random) {
		return base.superQuantityDropped(iBlockState, fortune, random);
	}

	@Override
	public Object getDrops(Object iBlockAccess, Object blockPos, Object iBlockState, int fortune) {
		return base.superGetDrops(iBlockAccess, blockPos, iBlockState, fortune);
	}

	@Override
	public boolean canSilkHarvest(Object world, Object blockPos, Object iBlockState, Object entityPlayer) {
		return base.superCanSilkHarvest(world, blockPos, iBlockState, entityPlayer);
	}

	@Override
	public boolean canCreatureSpawn(Object iBlockAccess, Object blockPos, Object spawnPlacementType) {
		return base.superCanCreatureSpawn(iBlockAccess, blockPos, spawnPlacementType);
	}

	@Override
	public boolean isBed(Object iBlockAccess, Object blockPos, Object entity) {
		return base.superIsBed(iBlockAccess, blockPos, entity);
	}

	@Override
	public Object getBedSpawnPosition(Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return base.superGetBedSpawnPosition(iBlockAccess, blockPos, entityPlayer);
	}

	@Override
	public void setBedOccupied(Object iBlockAccess, Object blockPos, Object entityPlayer, boolean occupied) {
		base.superSetBedOccupied(iBlockAccess, blockPos, entityPlayer, occupied);
	}

	@Override
	public Object getBedDirection(Object iBlockAccess, Object blockPos) {
		return base.superGetBedDirection(iBlockAccess, blockPos);
	}

	@Override
	public boolean isBedFoot(Object iBlockAccess, Object blockPos) {
		return base.superIsBedFoot(iBlockAccess, blockPos);
	}

	@Override
	public void beginLeavesDecay(Object world, Object blockPos) {
		base.superBeginLeavesDecay(world, blockPos);
	}

	@Override
	public boolean canSustainLeaves(Object iBlockAccess, Object blockPos) {
		return base.superCanSustainLeaves(iBlockAccess, blockPos);
	}

	@Override
	public boolean isLeaves(Object iBlockAccess, Object blockPos) {
		return base.superIsLeaves(iBlockAccess, blockPos);
	}

	@Override
	public boolean canBeReplacedByLeaves(Object iBlockAccess, Object blockPos) {
		return base.superCanBeReplacedByLeaves(iBlockAccess, blockPos);
	}

	@Override
	public boolean isWood(Object iBlockAccess, Object blockPos) {
		return base.superIsWood(iBlockAccess, blockPos);
	}

	@Override
	public boolean isReplaceableOreGen(Object world, Object blockPos, Object predicate) {
		return base.superIsReplaceableOreGen(world, blockPos, predicate);
	}

	@Override
	public float getExplosionResistance(Object world, Object blockPos, Object entity, Object explosion) {
		return base.superGetExplosionResistance(world, blockPos, entity, explosion);
	}

	@Override
	public void onBlockExploded(Object world, Object blockPos, Object explosion) {
		base.superOnBlockExploded(world, blockPos, explosion);
	}

	@Override
	public boolean canConnectRedstone(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superCanConnectRedstone(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean canPlaceTorchOnTop(Object iBlockAccess, Object blockPos) {
		return base.superCanPlaceTorchOnTop(iBlockAccess, blockPos);
	}

	@Override
	public Object getPickBlock(Object movingObjectPosition, Object world, Object blockPos) {
		return base.superGetPickBlock(movingObjectPosition, world, blockPos);
	}

	@Override
	public boolean isFoliage(Object iBlockAccess, Object blockPos) {
		return base.superIsFoliage(iBlockAccess, blockPos);
	}

	@Override
	public boolean addDestroyEffects(Object world, Object blockPos, Object effectRenderer) {
		return base.superAddDestroyEffects(world, blockPos, effectRenderer);
	}

	@Override
	public boolean canSustainPlant(Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable) {
		return base.superCanSustainPlant(iBlockAccess, blockPos, enumFacing, iPlantable);
	}

	@Override
	public void onPlantGrow(Object world, Object blockPos, Object blockPos1) {
		base.superOnPlantGrow(world, blockPos, blockPos1);
	}

	@Override
	public boolean isFertile(Object world, Object blockPos) {
		return base.superIsFertile(world, blockPos);
	}

	@Override
	public int getLightOpacity(Object iBlockAccess, Object blockPos) {
		return base.superGetLightOpacity(iBlockAccess, blockPos);
	}

	@Override
	public boolean canEntityDestroy(Object iBlockAccess, Object blockPos, Object entity) {
		return base.superCanEntityDestroy(iBlockAccess, blockPos, entity);
	}

	@Override
	public boolean isBeaconBase(Object iBlockAccess, Object blockPos, Object blockPos1) {
		return base.superIsBeaconBase(iBlockAccess, blockPos, blockPos1);
	}

	@Override
	public boolean rotateBlock(Object world, Object blockPos, Object enumFacing) {
		return base.superRotateBlock(world, blockPos, enumFacing);
	}

	@Override
	public Object[] getValidRotations(Object world, Object blockPos) {
		return base.superGetValidRotations(world, blockPos);
	}

	@Override
	public float getEnchantPowerBonus(Object world, Object blockPos) {
		return base.superGetEnchantPowerBonus(world, blockPos);
	}

	@Override
	public boolean recolorBlock(Object world, Object blockPos, Object enumFacing, Object enumDyeColor) {
		return base.superRecolorBlock(world, blockPos, enumFacing, enumDyeColor);
	}

	@Override
	public int getExpDrop(Object iBlockAccess, Object blockPos, int fortune) {
		return base.superGetExpDrop(iBlockAccess, blockPos, fortune);
	}

	@Override
	public void onNeighborChange(Object iBlockAccess, Object blockPos, Object blockPos1) {
		base.superOnNeighborChange(iBlockAccess, blockPos, blockPos1);
	}

	@Override
	public boolean shouldCheckWeakPower(Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superShouldCheckWeakPower(iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean getWeakChanges(Object iBlockAccess, Object blockPos) {
		return base.superGetWeakChanges(iBlockAccess, blockPos);
	}

	@Override
	public void setHarvestLevel(String toolClass, int level) {
		base.superSetHarvestLevel(toolClass, level);
	}

	@Override
	public void setHarvestLevel(String toolClass, int level, Object iBlockState) {
		base.superSetHarvestLevel(toolClass, level, iBlockState);
	}

	@Override
	public String getHarvestTool(Object iBlockState) {
		return base.superGetHarvestTool(iBlockState);
	}

	@Override
	public int getHarvestLevel(Object iBlockState) {
		return base.superGetHarvestLevel(iBlockState);
	}

	@Override
	public boolean isToolEffective(String type, Object iBlockState) {
		return base.superIsToolEffective(type, iBlockState);
	}

	@Override
	public Object getExtendedState(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superGetExtendedState(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean canRenderInLayer(Object enumWorldBlockLayer) {
		return base.superCanRenderInLayer(enumWorldBlockLayer);
	}

	@Override
	public Object captureDrops(boolean start) {
		return base.superCaptureDrops(start);
	}

	@Override
	public String getUnlocalizedName2() {
		return base.superGetUnlocalizedName2();
	}

	@Override
	public void onSetBlockIDWithMetaData(Object world, int par2, int par3, int par4, int par5) {
		base.superOnSetBlockIDWithMetaData(world, par2, par3, par4, par5);
	}

	@Override
	public boolean isLadder(Object world, int x, int y, int z) {
		return base.superIsLadder(world, x, y, z);
	}

	@Override
	public int getEnchantPower(Object world, int x, int y, int z) {
		return base.superGetEnchantPower(world, x, y, z);
	}

	@Override
	public Object createNewTileEntity(Object world) {
		return base.superCreateNewTileEntity(world);
	}

	@Override
	public Object createNewTileEntity(Object world, int i) {
		return base.superCreateNewTileEntity(world, i);
	}

	@Override
	public boolean isBlockNormalCube(Object iBlockState) {
		return base.superIsNormalCube(iBlockState);
	}

	@Override
	public Object getRenderType(Object iBlockState) {
		return base.superGetRenderType(iBlockState);
	}

	@Override
	public boolean isOpaqueCube(Object iBlockState) {
		return base.superIsOpaqueCube(iBlockState);
	}

	@Override
	public boolean canProvidePower(Object iBlockState) {
		return base.superCanProvidePower(iBlockState);
	}

	@Override
	public Object getMobilityFlag(Object iBlockState) {
		return base.superGetMobilityFlag(iBlockState);
	}

	@Override
	public boolean hasComparatorInputOverride(Object iBlockState) {
		return base.superHasComparatorInputOverride(iBlockState);
	}

	@Override
	public float getAmbientOcclusionLightValue(Object iBlockState) {
		return base.superGetAmbientOcclusionLightValue(iBlockState);
	}

	@Override
	public boolean addHitEffects(Object iBlockState, Object world, Object rayTraceResult, Object effectRenderer) {
		return base.superAddHitEffects(iBlockState, world, rayTraceResult, effectRenderer);
	}

	@Override
	public float getBlockHardness(Object iBlockState, Object world, Object blockPos) {
		return base.superGetBlockHardness(iBlockState, world, blockPos);
	}

	@Override
	public int getPackedLightmapCoords(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superGetPackedLightmapCoords(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean shouldSideBeRendered(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superShouldSideBeRendered(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public float getPlayerRelativeBlockHardness(Object iBlockState, Object entityPlayer, Object world, Object blockPos) {
		return base.superGetPlayerRelativeBlockHardness(iBlockState, entityPlayer, world, blockPos);
	}

	@Override
	public boolean isFullBlock(Object iBlockState) {
		return base.superIsFullBlock(iBlockState);
	}

	@Override
	public int getLightOpacity(Object iBlockState) {
		return base.superGetLightOpacity(iBlockState);
	}

	@Override
	public boolean isTranslucent(Object iBlockState) {
		return base.superIsTranslucent(iBlockState);
	}

	@Override
	public int getLightValue(Object iBlockState) {
		return base.superGetLightValue(iBlockState);
	}

	@Override
	public boolean getUseNeighborBrightness(Object iBlockState) {
		return base.superGetUseNeighborBrightness(iBlockState);
	}

	@Override
	public Object getMaterial(Object iBlockState) {
		return base.superGetMaterial(iBlockState);
	}

	@Override
	public boolean isNormalCube(Object iBlockState) {
		return base.superIsNormalCube(iBlockState);
	}

	@Override
	public Object getSelectedBoundingBox(Object iBlockState, Object world, Object blockPos) {
		return base.superGetSelectedBoundingBox(iBlockState, world, blockPos);
	}

	@Override
	public Object collisionRayTrace(Object iBlockState, Object world, Object blockPos, Object vec3, Object vec31) {
		return base.superCollisionRayTrace(iBlockState, world, blockPos, vec3, vec31);
	}

	@Override
	public boolean onBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumHand, Object itemStack, Object enumFacing, float hitX, float hitY, float hitZ) {
		return base.superOnBlockActivated(world, blockPos, iBlockState, entityPlayer, enumHand, itemStack, enumFacing, hitX, hitY, hitZ);
	}

	@Override
	public void harvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity, Object itemStack) {
		base.superHarvestBlock(world, entityPlayer, blockPos, iBlockState, tileEntity, itemStack);
	}

	@Override
	public Object getItem(Object world, Object blockPos, Object iBlockState) {
		return base.superGetItem(world, blockPos, iBlockState);
	}

	@Override
	public int getComparatorInputOverride(Object iBlockState, Object world, Object blockPos) {
		return base.superGetComparatorInputOverride(iBlockState, world, blockPos);
	}

	@Override
	public int getLightValue(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superGetLightValue(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean isLadder(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityLivingBase) {
		return base.superIsLadder(iBlockState, iBlockAccess, blockPos, entityLivingBase);
	}

	@Override
	public boolean isNormalCube(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superIsNormalCube(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean isSideSolid(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superIsSideSolid(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean isAir(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superIsAir(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean removedByPlayer(Object iBlockState, Object world, Object blockPos, Object entityPlayer, boolean willHarvest) {
		return base.superRemovedByPlayer(iBlockState, world, blockPos, entityPlayer, willHarvest);
	}

	@Override
	public boolean canCreatureSpawn(Object iBlockState, Object iBlockAccess, Object blockPos, Object spawnPlacementType) {
		return base.superCanCreatureSpawn(iBlockState, iBlockAccess, blockPos, spawnPlacementType);
	}

	@Override
	public boolean isBed(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity) {
		return base.superIsBed(iBlockState, iBlockAccess, blockPos, entity);
	}

	@Override
	public Object getBedSpawnPosition(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityPlayer) {
		return base.superGetBedSpawnPosition(iBlockState, iBlockAccess, blockPos, entityPlayer);
	}

	@Override
	public Object getBedDirection(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superGetBedDirection(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public void beginLeavesDecay(Object iBlockState, Object world, Object blockPos) {
		base.superBeginLeavesDecay(iBlockState, world, blockPos);
	}

	@Override
	public boolean canSustainLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superCanSustainLeaves(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean isLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superIsLeaves(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean canBeReplacedByLeaves(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superCanBeReplacedByLeaves(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean isReplaceableOreGen(Object iBlockState, Object iBlockAccess, Object blockPos, Object predicate) {
		return base.superIsReplaceableOreGen(iBlockState, iBlockAccess, blockPos, predicate);
	}

	@Override
	public boolean canConnectRedstone(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superCanConnectRedstone(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean canPlaceTorchOnTop(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superCanPlaceTorchOnTop(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public Object getPickBlock(Object iBlockState, Object rayTraceResult, Object world, Object blockPos, Object entityPlayer) {
		return base.superGetPickBlock(iBlockState, rayTraceResult, world, blockPos, entityPlayer);
	}

	@Override
	public boolean canSustainPlant(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable) {
		return base.superCanSustainPlant(iBlockState, iBlockAccess, blockPos, enumFacing, iPlantable);
	}

	@Override
	public void onPlantGrow(Object iBlockState, Object world, Object blockPos, Object blockPos1) {
		base.superOnPlantGrow(iBlockState, world, blockPos, blockPos1);
	}

	@Override
	public int getLightOpacity(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superGetLightOpacity(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public boolean canEntityDestroy(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity) {
		return base.superCanEntityDestroy(iBlockState, iBlockAccess, blockPos, entity);
	}

	@Override
	public int getExpDrop(Object iBlockState, Object iBlockAccess, Object blockPos, int fortune) {
		return base.superGetExpDrop(iBlockState, iBlockAccess, blockPos, fortune);
	}

	@Override
	public boolean shouldCheckWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superShouldCheckWeakPower(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean isFullCube(Object iBlockState) {
		return base.superIsFullCube(iBlockState);
	}

	@Override
	public boolean isFullyOpaque(Object iBlockState) {
		return base.superIsFullyOpaque(iBlockState);
	}

	@Override
	public Object withRotation(Object iBlockState, Object rotation) {
		return base.superWithRotation(iBlockState, rotation);
	}

	@Override
	public Object withMirror(Object iBlockState, Object mirror) {
		return base.superWithMirror(iBlockState, mirror);
	}

	@Override
	public Object getBoundingBox(Object iBlockState, Object iBlockAccess, Object blockPos) {
		return base.superGetBoundingBox(iBlockState, iBlockAccess, blockPos);
	}

	@Override
	public void addCollisionBoxToList(Object iBlockState, Object world, Object blockPos, Object axisAlignedBB, Object p_185477_5_, Object entity) {
		base.superAddCollisionBoxToList(iBlockState, world, blockPos, axisAlignedBB, p_185477_5_, entity);
	}

	@Override
	public Object rayTrace(Object blockPos, Object vec3d, Object vec3d1, Object axisAlignedBB) {
		return base.superRayTrace(blockPos, vec3d, vec3d1, axisAlignedBB);
	}

	@Override
	public boolean canSpawnInBlock() {
		return base.superCanSpawnInBlock();
	}

	@Override
	public Object getSoundType() {
		return base.superGetSoundType();
	}

	@Override
	public boolean doesSideBlockRendering(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing) {
		return base.superDoesSideBlockRendering(iBlockState, iBlockAccess, blockPos, enumFacing);
	}

	@Override
	public boolean addLandingEffects(Object iBlockState, Object worldServer, Object blockPos, Object iBlockState1, Object entityLivingBase, int numberOfParticles) {
		return base.superAddLandingEffects(iBlockState, worldServer, blockPos, iBlockState1, entityLivingBase, numberOfParticles);
	}

	@Override
	public Object isEntityInsideMaterial(Object iBlockAccess, Object blockPos, Object iBlockState, Object entity, double yToTest, Object material, boolean testingHead) {
		return base.superIsEntityInsideMaterial(iBlockAccess, blockPos, iBlockState, entity, yToTest, material, testingHead);
	}

	@Override
	public Object isAABBInsideMaterial(Object world, Object blockPos, Object axisAlignedBB, Object material) {
		return base.superIsAABBInsideMaterial(world, blockPos, axisAlignedBB, material);
	}

	@Override
	public boolean isInvalidNeighbor(Object world, Object blockPos, Object enumFacing) {
		return base.superIsInvalidNeighbor(world, blockPos, enumFacing);
	}

	@Override
	public boolean hasInvalidNeighbor(Object world, Object blockPos) {
		return base.superHasInvalidNeighbor(world, blockPos);
	}

}
