package modchu.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Modchu_IBlockMaster {
	public void initializeBlock();
	public Object setSoundType(Object stepSound);
	public Object setLightOpacity(int par1);
	public Object setLightLevel(float par1);
	public Object setResistance(float par1);
	public boolean isFullCube();
	public boolean isPassable(Object iBlockAccess, int par2, int par3, int par4);
	public int getRenderType();
	public Object setHardness(float par1);
	public Object setBlockUnbreakable();
	public float getBlockHardness(Object world, int par2, int par3, int par4);
	public Object setTickRandomly(boolean par1);
	public boolean getTickRandomly();
	public boolean hasTileEntity();
	public float getBlockBrightness(Object iBlockAccess, int par2, int par3, int par4);
	public int getPackedLightmapCoords(Object iBlockAccess, int par2, int par3, int par4);
	public boolean shouldSideBeRendered(Object iBlockAccess, int par2, int par3, int par4, int par5);
	public boolean isBlockSolid(Object iBlockAccess, int par2, int par3, int par4, int par5);
	public Object getBlockTexture(Object iBlockAccess, int par2, int par3, int par4, int par5);
	public Object getIcon(int par1, int par2);
	public void addCollisionBoxesToList(Object world, int par2, int par3, int par4, Object axisAlignedBB, List par6List, Object entity);
	public Object getCollisionBoundingBox(Object world, int par2, int par3, int par4);
	public Object getCollisionBoundingBoxFromPool(Object world, int par2, int par3, int par4);
	public boolean isOpaqueCube();
	public boolean canCollideCheck(int par1, boolean par2);
	public boolean isCollidable();
	public void updateTick(Object world, int par2, int par3, int par4, Random par5Random);
	public void randomDisplayTick(Object world, int par2, int par3, int par4, Random par5Random);
	public void onBlockDestroyedByPlayer(Object world, int par2, int par3, int par4, int par5);
	public void neighborChanged(Object world, int par2, int par3, int par4, Object par5);
	public int tickRate(Object world);
	public void onBlockAdded(Object world, int par2, int par3, int par4);
	public void breakBlock(Object world, int par2, int par3, int par4, Object par5, int par6);
	public int quantityDropped(Random par1Random);
	public Object getItemDropped(int par1, Random par2Random, int par3);
	public float getPlayerRelativeBlockHardness(Object entityPlayer, Object world, int par3, int par4, int par5);
	public void dropBlockAsItemWithChance(Object world, int par2, int par3, int par4, int par5, float par6, int par7);
	public void dropBlockAsItem(Object world, int par2, int par3, int par4, Object itemStack);
	public void dropXpOnBlockBreak(Object world, int par2, int par3, int par4, int par5);
	public int damageDropped(int par1);
	public float getExplosionResistance(Object entity);
	public Object collisionRayTrace(Object world, int par2, int par3, int par4, Object vec3, Object vec31);
	public void onBlockDestroyedByExplosion(Object world, int par2, int par3, int par4, Object explosion);
	public boolean canReplace(Object world, int par2, int par3, int par4, int par5, Object itemStack);
	public int getRenderBlockPass();
	public boolean canPlaceBlockOnSide(Object world, int par2, int par3, int par4, int par5);
	public boolean canPlaceBlockAt(Object world, int par2, int par3, int par4);
	public boolean onBlockActivated(Object world, int par2, int par3, int par4, Object entityPlayer, int par6, float par7, float par8, float par9);
	public void onEntityWalk(Object world, int par2, int par3, int par4, Object entity);
	public int onBlockPlaced(Object world, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9);
	public void onBlockClicked(Object world, int par2, int par3, int par4, Object entityPlayer);
	public void velocityToAddToEntity(Object world, int par2, int par3, int par4, Object entity, Object vec3);
	public void setBlockBoundsBasedOnState(Object iBlockAccess, int par2, int par3, int par4);
	public int getBlockColor();
	public int getRenderColor(int par1);
	public int getWeakPower(Object iBlockAccess, int par2, int par3, int par4, int par5);
	public int colorMultiplier(Object iBlockAccess, int par2, int par3, int par4);
	public boolean canProvidePower();
	public int getStrongPower(Object iBlockAccess, int par2, int par3, int par4, int par5);
	public void setBlockBoundsForItemRender();
	public void harvestBlock(Object world, Object entityPlayer, int par3, int par4, int par5, int par6);
	public boolean canSilkHarvest();
	public Object createStackedBlock(int par1);
	public int quantityDroppedWithBonus(int par1, Random par2Random);
	public boolean canBlockStay(Object world, int par2, int par3, int par4);
	public void onBlockPlacedBy(Object world, int par2, int par3, int par4, Object entityLivingBase, Object itemStack);
	public void onPostBlockPlaced(Object world, int par2, int par3, int par4, int par5);
	public Object setUnlocalizedName(String par1Str);
	public String getLocalizedName();
	public String getUnlocalizedName();
	public boolean eventReceived(Object world, int par2, int par3, int par4, int par5, int par6);
	public boolean getEnableStats();
	public Object disableStats();
	public int getMobilityFlag();
	public float getAmbientOcclusionLightValue(Object iBlockAccess, int par2, int par3, int par4);
	public void onFallenUpon(Object world, int par2, int par3, int par4, Object entity, float par6);
	public Object getItem(Object world, int par2, int par3, int par4);
	public int getDamageValue(Object world, int par2, int par3, int par4);
	public void getSubBlocks(Object par1, Object creativeTabs, List par3List);
	public Object setCreativeTab(Object creativeTabs);
	public void onBlockHarvested(Object world, int par2, int par3, int par4, int par5, Object entityPlayer);
	public Object getCreativeTabToDisplayOn();
	public void onBlockPreDestroy(Object world, int par2, int par3, int par4, int par5);
	public void fillWithRain(Object world, int par2, int par3, int par4);
	public boolean isFlowerPot();
	public boolean requiresUpdates();
	public boolean canDropFromExplosion(Object explosion);
	public boolean isAssociatedBlock(Object par1);
	public boolean hasComparatorInputOverride();
	public int getComparatorInputOverride(Object world, int par2, int par3, int par4, int par5);
	public Object setBlockTextureName(String par1Str);
	public String getTextureName();
	public void registerIcons(Object iconRegister);
	public String getItemIconName();
	public int getLightValue(Object iBlockAccess, int x, int y, int z);
	public boolean isLadder(Object world, int x, int y, int z, Object entityLivingBase);
	public boolean isNormalCube(Object world, int x, int y, int z);
	public boolean isSideSolid(Object world, int x, int y, int z, Object forgeDirection);
	public boolean isReplaceable(Object world, int x, int y, int z);
	public boolean isBurning(Object world, int x, int y, int z);
	public boolean isAir(Object world, int x, int y, int z);
	public boolean canHarvestBlock(Object entityPlayer, int meta);
	public boolean removedByPlayer(Object world, Object entityPlayer, int x, int y, int z);
	public void addCreativeItems(ArrayList itemList);
	public int getFlammability(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection);
	public boolean isFlammable(Object iBlockAccess, int x, int y, int z, int metadata, Object forgeDirection);
	public int getFireSpreadSpeed(Object world, int x, int y, int z, int metadata, Object forgeDirection);
	public boolean isFireSource(Object world, int x, int y, int z, int metadata, Object forgeDirection);
	public boolean hasTileEntity(int metadata);
	public Object createTileEntity(Object world, int metadata);
	public int quantityDropped(int meta, int fortune, Random random);
	public Object getDrops(Object world, int x, int y, int z, int metadata, int fortune);
	public boolean canSilkHarvest(Object world, Object entityPlayer, int x, int y, int z, int metadata);
	public boolean canCreatureSpawn(Object enumCreatureType, Object world, int x, int y, int z);
	public boolean isBed(Object world, int x, int y, int z, Object entityLivingBase);
	public Object getBedSpawnPosition(Object world, int x, int y, int z, Object entityPlayer);
	public void setBedOccupied(Object world, int x, int y, int z, Object entityPlayer, boolean occupied);
	public int getBedDirection(Object iBlockAccess, int x, int y, int z);
	public boolean isBedFoot(Object iBlockAccess, int x, int y, int z);
	public void beginLeavesDecay(Object world, int x, int y, int z);
	public boolean canSustainLeaves(Object world, int x, int y, int z);
	public boolean isLeaves(Object world, int x, int y, int z);
	public boolean canBeReplacedByLeaves(Object world, int x, int y, int z);
	public boolean isWood(Object world, int x, int y, int z);
	public boolean isReplaceableOreGen(Object world, int x, int y, int z, int target);
	public float getExplosionResistance(Object entity, Object world, int x, int y, int z, double explosionX, double explosionY, double explosionZ);
	public void onBlockExploded(Object world, int x, int y, int z, Object explosion);
	public boolean canConnectRedstone(Object iBlockAccess, int x, int y, int z, int side);
	public boolean canPlaceTorchOnTop(Object world, int x, int y, int z);
	public boolean canRenderInPass(int pass);
	public Object getPickBlock(Object movingObjectPosition, Object world, int x, int y, int z);
	public boolean isFoliage(Object world, int x, int y, int z);
	public boolean addHitEffects(Object world, Object movingObjectPosition, Object effectRenderer);
	public boolean addDestroyEffects(Object world, int x, int y, int z, int meta, Object effectRenderer);
	public boolean canSustainPlant(Object world, int x, int y, int z, Object forgeDirection, Object iPlantable);
	public void onPlantGrow(Object world, int x, int y, int z, int sourceX, int sourceY, int sourceZ);
	public boolean isFertile(Object world, int x, int y, int z);
	public int getLightOpacity(Object world, int x, int y, int z);
	public boolean canEntityDestroy(Object world, int x, int y, int z, Object entity);
	public boolean canDragonDestroy(Object world, int x, int y, int z);
	public boolean isBeaconBase(Object world, int x, int y, int z, int beaconX, int beaconY, int beaconZ);
	public boolean rotateBlock(Object world, int x, int y, int z, Object forgeDirection);
	public Object[] getValidRotations(Object world, int x, int y, int z);
	public float getEnchantPowerBonus(Object world, int x, int y, int z);
	public boolean recolourBlock(Object world, int x, int y, int z, Object forgeDirection, int colour);
	public int getExpDrop(Object world, int data, int enchantmentLevel);
	public void onNeighborChange(Object world, int x, int y, int z, int tileX, int tileY, int tileZ);
	public boolean weakTileChanges();
	public boolean shouldCheckWeakPower(Object world, int x, int y, int z, int side);
	public float getFilledPercentage(Object world, int x, int y, int z);
	// 172~
	public float getAmbientOcclusionLightValue();
	public int getFlammability(Object iBlockAccess, int x, int y, int z, Object forgeDirection);
	public boolean isFlammable(Object iBlockAccess, int x, int y, int z, Object forgeDirection);
	public int getFireSpreadSpeed(Object iBlockAccess, int x, int y, int z, Object forgeDirection);
	public boolean isFireSource(Object world, int x, int y, int z, Object forgeDirection);
	public boolean isReplaceableOreGen(Object world, int x, int y, int z, Object target);
	// 180~
	public boolean isPassable(Object iBlockAccess, Object blockPos);
	public float getBlockHardness(Object world, Object blockPos);
	public int getPackedLightmapCoords(Object iBlockAccess, Object blockPos);
	public boolean shouldSideBeRendered(Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean isBlockSolid(Object iBlockAccess, Object blockPos, Object enumFacing);
	public void addCollisionBoxesToList(Object world, Object blockPos, Object iBlockState, Object axisAlignedBB, List list, Object entity);
	public Object getCollisionBoundingBox(Object iBlockState, Object world, Object blockPos);
	public boolean canCollideCheck(Object iBlockState, boolean par2);
	public void updateTick(Object world, Object blockPos, Object iBlockState, Random par5Random);
	public void randomDisplayTick(Object iBlockState, Object world, Object blockPos, Random par5Random);
	public void onBlockDestroyedByPlayer(Object world, Object blockPos, Object iBlockState);
	public void onBlockAdded(Object world, Object blockPos, Object iBlockState);
	public float getPlayerRelativeBlockHardness(Object entityPlayer, Object world, Object blockPos);
	public void dropBlockAsItemWithChance(Object world, Object blockPos, Object iBlockState, float par6, int par7);
	public void onEntityWalk(Object world, Object blockPos, Object entity);
	public boolean isFullBlock();
	public int getLightOpacity();
	public boolean isTranslucent();
	public int getLightValue();
	public boolean getUseNeighborBrightness();
	public Object getMaterial();
	public Object getMapColor(Object iBlockState);
	public Object getStateFromMeta(int meta);
	public int getMetaFromState(Object iBlockState);
	public Object getActualState(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean isBlockNormalCube();
	public boolean isNormalCube();
	public boolean isVisuallyOpaque(Object iBlockState);
	public boolean isReplaceable(Object iBlockAccess, Object blockPos);
	public Object getSelectedBoundingBox(Object world, Object blockPos);
	public void randomTick(Object world, Object blockPos, Object iBlockState, Random random);
	public void neighborChanged(Object world, Object blockPos, Object iBlockState, Object block, Object blockPos1);
	public void breakBlock(Object world, Object blockPos, Object iBlockState);
	public Object getItemDropped(Object iBlockState, Random rand, int fortune);
	public void dropXpOnBlockBreak(Object world, Object blockPos, int amount);
	public int damageDropped(Object iBlockState);
	public Object collisionRayTrace(Object world, Object blockPos, Object vec3, Object vec31);
	public void onBlockDestroyedByExplosion(Object world, Object blockPos, Object explosion);
	public boolean canReplace(Object world, Object blockPos, Object enumFacing, Object itemStack);
	public boolean canPlaceBlockOnSide(Object world, Object blockPos, Object enumFacing);
	public Object getBlockLayer();
	public boolean canPlaceBlockAt(Object world, Object blockPos);
	public boolean onBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumFacing, float hitX, float hitY, float hitZ);
	public Object onBlockPlaced(Object world, Object blockPos, Object enumFacing, float hitX, float hitY, float hitZ, int meta, Object entityLivingBase);
	public void onBlockClicked(Object world, Object blockPos, Object entityPlayer);
	public Object modifyAcceleration(Object world, Object blockPos, Object entity, Object vec3);
	public void setBlockBoundsBasedOnState(Object iBlockAccess, Object blockPos);
	public int getRenderColor(Object iBlockState);
	public int colorMultiplier(Object iBlockAccess, Object blockPos, int renderPass);
	public int getWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing);
	public void onEntityWalk(Object world, Object blockPos, Object iBlockState, Object entity);
	public int getStrongPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing);
	public void harvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity);
	public Object createStackedBlock(Object iBlockState);
	public void onBlockPlacedBy(Object world, Object blockPos, Object iBlockState, Object entityLivingBase, Object itemStack);
	public boolean eventReceived(Object world, Object blockPos, Object iBlockState, int eventID, int eventParam);
	public void onFallenUpon(Object world, Object blockPos, Object entity, float fallDistance);
	public void onLanded(Object world, Object entity);
	public Object getItem(Object world, Object blockPos);
	public int getDamageValue(Object world, Object blockPos);
	public void onBlockHarvested(Object world, Object blockPos, Object iBlockState, Object entityPlayer);
	public void fillWithRain(Object world, Object blockPos);
	public int getComparatorInputOverride(Object world, Object blockPos);
	public Object getStateForEntityRender(Object iBlockState);
	public Object createBlockState();
	public Object getBlockState();
	public Object getOffsetType();
	public int getLightValue(Object iBlockAccess, Object blockPos);
	public boolean isLadder(Object iBlockAccess, Object blockPos, Object entityLivingBase);
	public boolean isNormalCube(Object iBlockAccess, Object blockPos);
	public boolean isSideSolid(Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean isBurning(Object iBlockAccess, Object blockPos);
	public boolean isAir(Object iBlockAccess, Object blockPos);
	public boolean canHarvestBlock(Object iBlockAccess, Object blockPos, Object entityPlayer);
	public boolean removedByPlayer(Object world, Object blockPos, Object entityPlayer, boolean willHarvest);
	public int getFlammability(Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean isFlammable(Object iBlockAccess, Object blockPos, Object enumFacing);
	public int getFireSpreadSpeed(Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean isFireSource(Object world, Object blockPos, Object enumFacing);
	public boolean hasTileEntity(Object iBlockState);
	public Object createTileEntity(Object world, Object iBlockState);
	public int quantityDropped(Object iBlockState, int fortune, Random random);
	public Object getDrops(Object iBlockAccess, Object blockPos, Object iBlockState, int fortune);
	public boolean canSilkHarvest(Object world, Object blockPos, Object iBlockState, Object entityPlayer);
	public boolean canCreatureSpawn(Object iBlockAccess, Object blockPos, Object spawnPlacementType);
	public boolean isBed(Object iBlockAccess, Object blockPos, Object entity);
	public Object getBedSpawnPosition(Object iBlockAccess, Object blockPos, Object entityPlayer);
	public void setBedOccupied(Object iBlockAccess, Object blockPos, Object entityPlayer, boolean occupied);
	public Object getBedDirection(Object iBlockAccess, Object blockPos);
	public boolean isBedFoot(Object iBlockAccess, Object blockPos);
	public void beginLeavesDecay(Object world, Object blockPos);
	public boolean canSustainLeaves(Object iBlockAccess, Object blockPos);
	public boolean isLeaves(Object iBlockAccess, Object blockPos);
	public boolean canBeReplacedByLeaves(Object iBlockAccess, Object blockPos);
	public boolean isWood(Object iBlockAccess, Object blockPos);
	public boolean isReplaceableOreGen(Object world, Object blockPos, Object predicate);
	public float getExplosionResistance(Object world, Object blockPos, Object entity, Object explosion);
	public void onBlockExploded(Object world, Object blockPos, Object explosion);
	public boolean canConnectRedstone(Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean canPlaceTorchOnTop(Object iBlockAccess, Object blockPos);
	public Object getPickBlock(Object movingObjectPosition, Object world, Object blockPos);
	public boolean isFoliage(Object iBlockAccess, Object blockPos);
	public boolean addDestroyEffects(Object world, Object blockPos, Object effectRenderer);
	public boolean canSustainPlant(Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable);
	public void onPlantGrow(Object world, Object blockPos, Object blockPos1);
	public boolean isFertile(Object world, Object blockPos);
	public int getLightOpacity(Object iBlockAccess, Object blockPos);
	public boolean canEntityDestroy(Object iBlockAccess, Object blockPos, Object entity);
	public boolean isBeaconBase(Object iBlockAccess, Object blockPos, Object blockPos1);
	public boolean rotateBlock(Object world, Object blockPos, Object enumFacing);
	public Object[] getValidRotations(Object world, Object blockPos);
	public float getEnchantPowerBonus(Object world, Object blockPos);
	public boolean recolorBlock(Object world, Object blockPos, Object enumFacing, Object enumDyeColor);
	public int getExpDrop(Object iBlockAccess, Object blockPos, int fortune);
	public void onNeighborChange(Object iBlockAccess, Object blockPos, Object blockPos1);
	public boolean shouldCheckWeakPower(Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean getWeakChanges(Object iBlockAccess, Object blockPos);
	public void setHarvestLevel(String toolClass, int level);
	public void setHarvestLevel(String toolClass, int level, Object iBlockState);
	public String getHarvestTool(Object iBlockState);
	public int getHarvestLevel(Object iBlockState);
	public boolean isToolEffective(String type, Object iBlockState);
	public Object getExtendedState(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean canRenderInLayer(Object enumWorldBlockLayer);
	public Object captureDrops(boolean start);
	// ~152
	public String getUnlocalizedName2();
	public void onSetBlockIDWithMetaData(Object world, int par2, int par3, int par4, int par5);
	public boolean isLadder(Object world, int x, int y, int z);
	public int getEnchantPower(Object world, int x, int y, int z);
	// 190~
	public boolean isBlockNormalCube(Object iBlockState);
	public Object getRenderType(Object iBlockState);
	public boolean isOpaqueCube(Object iBlockState);
	public boolean canProvidePower(Object iBlockState);
	public Object getMobilityFlag(Object iBlockState);
	public boolean hasComparatorInputOverride(Object iBlockState);
	public float getAmbientOcclusionLightValue(Object iBlockState);
	public boolean addHitEffects(Object iBlockState, Object world, Object rayTraceResult, Object effectRenderer);
	public float getBlockHardness(Object iBlockState, Object world, Object blockPos);
	public int getPackedLightmapCoords(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean shouldSideBeRendered(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing);
	public float getPlayerRelativeBlockHardness(Object iBlockState, Object entityPlayer, Object world, Object blockPos);
	public boolean isFullBlock(Object iBlockState);
	public int getLightOpacity(Object iBlockState);
	public boolean isTranslucent(Object iBlockState);
	public int getLightValue(Object iBlockState);
	public boolean getUseNeighborBrightness(Object iBlockState);
	public Object getMaterial(Object iBlockState);
	public boolean isNormalCube(Object iBlockState);
	public Object getSelectedBoundingBox(Object iBlockState, Object world, Object blockPos);
	public Object collisionRayTrace(Object iBlockState, Object world, Object blockPos, Object vec3, Object vec31);
	public boolean onBlockActivated(Object world, Object blockPos, Object iBlockState, Object entityPlayer, Object enumHand, Object itemStack, Object enumFacing, float hitX, float hitY, float hitZ);
	public void harvestBlock(Object world, Object entityPlayer, Object blockPos, Object iBlockState, Object tileEntity, Object itemStack);
	public Object getItem(Object world, Object blockPos, Object iBlockState);
	public int getComparatorInputOverride(Object iBlockState, Object world, Object blockPos);
	public int getLightValue(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean isLadder(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityLivingBase);
	public boolean isNormalCube(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean isSideSolid(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean isAir(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean removedByPlayer(Object iBlockState, Object world, Object blockPos, Object entityPlayer, boolean willHarvest);
	public boolean canCreatureSpawn(Object iBlockState, Object iBlockAccess, Object blockPos, Object spawnPlacementType);
	public boolean isBed(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity);
	public Object getBedSpawnPosition(Object iBlockState, Object iBlockAccess, Object blockPos, Object entityPlayer);
	public Object getBedDirection(Object iBlockState, Object iBlockAccess, Object blockPos);
	public void beginLeavesDecay(Object iBlockState, Object world, Object blockPos);
	public boolean canSustainLeaves(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean isLeaves(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean canBeReplacedByLeaves(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean isReplaceableOreGen(Object iBlockState, Object iBlockAccess, Object blockPos, Object predicate);
	public boolean canConnectRedstone(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean canPlaceTorchOnTop(Object iBlockState, Object iBlockAccess, Object blockPos);
	public Object getPickBlock(Object iBlockState, Object rayTraceResult, Object world, Object blockPos, Object entityPlayer);
	public boolean canSustainPlant(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing, Object iPlantable);
	public void onPlantGrow(Object iBlockState, Object world, Object blockPos, Object blockPos1);
	public int getLightOpacity(Object iBlockState, Object iBlockAccess, Object blockPos);
	public boolean canEntityDestroy(Object iBlockState, Object iBlockAccess, Object blockPos, Object entity);
	public int getExpDrop(Object iBlockState, Object iBlockAccess, Object blockPos, int fortune);
	public boolean shouldCheckWeakPower(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean isFullCube(Object iBlockState);
	public boolean isFullyOpaque(Object iBlockState);
	public Object withRotation(Object iBlockState, Object rotation);
	public Object withMirror(Object iBlockState, Object mirror);
	public Object getBoundingBox(Object iBlockState, Object iBlockAccess, Object blockPos);
	public void addCollisionBoxToList(Object iBlockState, Object world, Object blockPos, Object axisAlignedBB, Object p_185477_5_, Object entity);
	public Object rayTrace(Object blockPos, Object vec3d, Object vec3d1, Object axisAlignedBB);
	public boolean canSpawnInBlock();
	public Object getSoundType();
	public String toString();
	public boolean doesSideBlockRendering(Object iBlockState, Object iBlockAccess, Object blockPos, Object enumFacing);
	public boolean addLandingEffects(Object iBlockState, Object worldServer, Object blockPos, Object iBlockState1, Object entityLivingBase, int numberOfParticles);
	public Object isEntityInsideMaterial(Object iBlockAccess, Object blockPos, Object iBlockState, Object entity, double yToTest, Object material, boolean testingHead);
	public Object isAABBInsideMaterial(Object world, Object blockPos, Object axisAlignedBB, Object material);

}
