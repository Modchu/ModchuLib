package modchu.lib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.characteristic.Modchu_CastHelper;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Multimap;

public class Modchu_ASAlmighty extends Modchu_ASBase {
	public static Modchu_ASAlmighty instance;
	protected static boolean initNewVersionItemNameMap = false;
	protected static boolean initNewVersionBlockNameMap = false;
	protected static boolean initOldVersionItemMap = false;
	protected static boolean initOldVersionBlockMap = false;
	protected static ConcurrentHashMap<String, String> newVersionItemNameMap;
	protected static ConcurrentHashMap<String, String> newVersionBlockNameMap;
	protected static ConcurrentHashMap<String, Object> oldVersionItemMap;
	protected static ConcurrentHashMap<String, Object> oldVersionBlockMap;
	private int getMinecraftMode = 0;

	public Modchu_ASAlmighty() {
		instance = this;
	}

	public static Object get(int pIndex, Object... pArg) {
		return instance.getB(null, pIndex, (Object[])pArg);
	}

	public static Object get(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return instance.getB(accessSupport, pIndex, (Object[])pArg);
	}

	public static boolean set(int pIndex, Object... pArg) {
		return instance.setB(null, pIndex, (Object[])pArg);
	}

	public static boolean set(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return instance.setB(accessSupport, pIndex, (Object[])pArg);
	}

	@Override
	public Object getB(int pIndex, Object... pArg) {
		return getB(null, pIndex, (Object[])pArg);
	}

	@Override
	public Object getB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		if (accessSupport != null) {
			Object o = accessSupport.getB(pIndex, (Object[])pArg);
			if (o != null) return o;
		}
		if (pIndex == render) return render(pArg);
		if (pIndex == FMLCommonHandlerInstance) return FMLCommonHandlerInstance();
		if (pIndex == FMLCommonHandlerInstanceGetMinecraftServerInstance) return FMLCommonHandlerInstanceGetMinecraftServerInstance();
		if (pIndex == FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers) return FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers();
		if (pIndex == minecraftGetMinecraft) return minecraftGetMinecraft();
		if (pIndex == minecraftThePlayer) return minecraftThePlayer();
		if (pIndex == minecraftTheWorld) return minecraftTheWorld();
		if (pIndex == minecraftDisplayGuiScreen) return minecraftDisplayGuiScreen();
		if (pIndex == minecraftGetIntegratedServer) return minecraftGetIntegratedServer();
		if (pIndex == minecraftMcDataDir) return minecraftMcDataDir();
		if (pIndex == minecraftFontRenderer) return minecraftFontRenderer();
		if (pIndex == minecraftSession) return minecraftSession();
		if (pIndex == minecraftGetSession) return minecraftGatSession();
		if (pIndex == minecraftGetBlockRendererDispatcher) return minecraftGetBlockRendererDispatcher();
		if (pIndex == minecraftGetRenderItem) return minecraftGetRenderItem();
		if (pIndex == isMac) return isMac();
		if (pIndex == isCtrlKeyDown) return isCtrlKeyDown();
		if (pIndex == isShiftKeyDown) return isShiftKeyDown();
		if (pIndex == sharedMonsterAttributesAttackDamage) return sharedMonsterAttributesAttackDamage();
		if (pIndex == keyBindingKeyCode) return pArg != null && pArg.length > 0 ? keyBindingKeyCode(pArg[0]) : null;
		if (pIndex == keyBindingKeyDescription) return pArg != null && pArg.length > 0 ? keyBindingKeyDescription(pArg[0]) : null;
		if (pIndex == keyBindingKeyCategory) return pArg != null && pArg.length > 0 ? keyBindingKeyCategory(pArg[0]) : null;
		if (pIndex == keyBindingPressed) return pArg != null && pArg.length > 0 ? keyBindingPressed(pArg[0]) : null;
		if (pIndex == keyBindingGetIsKeyPressed) return pArg != null && pArg.length > 0 ? keyBindingGetIsKeyPressed(pArg[0]) : null;
		if (pIndex == keyBindingIsPressed) return pArg != null && pArg.length > 0 ? keyBindingIsPressed(pArg[0]) : null;
		if (pIndex == keyBindingPressTime) return pArg != null && pArg.length > 0 ? keyBindingPressTime(pArg[0]) : null;
		if (pIndex == blockBlockList) return blockBlockList();
		if (pIndex == blockGetRenderType) return pArg != null && pArg.length > 0 ? blockGetRenderType(pArg[0]) : null;
		if (pIndex == blockGetDefaultState) return pArg != null && pArg.length > 0 ? blockGetDefaultState(pArg[0]) : null;
		if (pIndex == iBlockStateGetBlock) return pArg != null && pArg.length > 0 ? iBlockStateGetBlock(pArg[0]) : null;
		if (pIndex == itemItemsList) return itemItemsList();
		if (pIndex == tileEntitySkullRendererInstance) return tileEntitySkullRendererSkullRenderer();
		if (pIndex == itemIsFull3D) return pArg != null && pArg.length > 0 ? itemIsFull3D(pArg[0]) : null;
		if (pIndex == getBlock) return pArg != null && pArg.length > 0 ? getBlock(pArg[0]) : null;
		if (pIndex == blockGetBlockFromItem) return pArg != null && pArg.length > 0 ? blockGetBlockFromItem(pArg[0]) : null;
		if (pIndex == blockPosGetX) return pArg != null && pArg.length > 0 ? blockPosGetX(pArg[0]) : null;
		if (pIndex == blockPosGetY) return pArg != null && pArg.length > 0 ? blockPosGetY(pArg[0]) : null;
		if (pIndex == blockPosGetZ) return pArg != null && pArg.length > 0 ? blockPosGetZ(pArg[0]) : null;
		if (pIndex == blockDoublePlantVARIANT) return blockDoublePlantVARIANT();
		if (pIndex == blockDoublePlantHALF) return blockDoublePlantHALF();
		if (pIndex == tileEntityXCoord) return pArg != null && pArg.length > 0 ? tileEntityXCoord(pArg[0]) : null;
		if (pIndex == tileEntityYCoord) return pArg != null && pArg.length > 0 ? tileEntityYCoord(pArg[0]) : null;
		if (pIndex == tileEntityZCoord) return pArg != null && pArg.length > 0 ? tileEntityZCoord(pArg[0]) : null;
		if (pIndex == getBlockItemStack) return pArg != null && pArg.length > 0 ? getBlockItemStack(pArg[0]) : null;
		if (pIndex == getItem) return pArg != null && pArg.length > 0 ? getItem((String) pArg[0]) : null;
		if (pIndex == itemStackGetItem) return pArg != null && pArg.length > 0 ? itemStackGetItem(pArg[0]) : null;
		if (pIndex == itemItemID) return pArg != null && pArg.length > 0 ? itemItemID(pArg[0]) : null;
		if (pIndex == itemStackItemID) return pArg != null && pArg.length > 0 ? itemStackItemID(pArg[0]) : null;
		if (pIndex == itemShouldRotateAroundWhenRendering) return pArg != null && pArg.length > 0 ? itemShouldRotateAroundWhenRendering(pArg[0]) : null;
		if (pIndex == itemStackHasTagCompound) return pArg != null && pArg.length > 0 ? itemStackHasTagCompound(pArg[0]) : null;
		if (pIndex == itemStackGetTagCompound) return pArg != null && pArg.length > 0 ? itemStackGetTagCompound(pArg[0]) : null;
		if (pIndex == itemStackGetAttributeModifiers) return pArg != null && pArg.length > 0 ? itemStackGetAttributeModifiers(pArg[0]) : null;
		if (pIndex == itemStackGetMetadata) return pArg != null && pArg.length > 0 ? itemStackGetMetadata(pArg[0]) : null;
		if (pIndex == itemStackHasDisplayName) return pArg != null && pArg.length > 0 ? itemStackHasDisplayName(pArg[0]) : null;
		if (pIndex == itemCameraTransformsTransformTypeNONE) return itemCameraTransformsTransformTypeNONE();
		if (pIndex == itemCameraTransformsTransformTypeTHIRD_PERSON) return itemCameraTransformsTransformTypeTHIRD_PERSON();
		if (pIndex == itemCameraTransformsTransformTypeFIRST_PERSON) return itemCameraTransformsTransformTypeFIRST_PERSON();
		if (pIndex == itemCameraTransformsTransformTypeHEAD) return itemCameraTransformsTransformTypeHEAD();
		if (pIndex == itemCameraTransformsTransformTypeGUI) return itemCameraTransformsTransformTypeGUI();
		if (pIndex == isSkull) return pArg != null && pArg.length > 0 ? isSkull(pArg[0]) : null;
		if (pIndex == entityEntityID) return pArg != null && pArg.length > 0 ? entityEntityID(pArg[0]) : entityEntityID();
		if (pIndex == keybindArray) return keybindArray();
		if (pIndex == entityRendererAnaglyphEnable) return entityRendererAnaglyphEnable();
		if (pIndex == userName) return pArg != null && pArg.length > 0 ? getUserName(pArg[0]) : getUserName();
		if (pIndex == isPlanter) return pArg != null && pArg.length > 0 ? isPlanter(pArg[0]) : null;
		if (pIndex == isCamouflage) return pArg != null && pArg.length > 0 ? isCamouflage(pArg[0]) : null;
		if (pIndex == isPumpkin) return pArg != null && pArg.length > 0 ? isPumpkin(pArg[0]) : null;
		if (pIndex == vacancyGlobalEntityID) return getVacancyGlobalEntityID();
		if (pIndex == isLANWorld) return isLANWorld();
		if (pIndex == isIntegratedServerRunning) return isIntegratedServerRunning();
		if (pIndex == isMuiti) return isMuiti();
		if (pIndex == textureMapLocationBlocksTexture) return textureMapLocationBlocksTexture();
		if (pIndex == renderRenderBlocks) return pArg != null && pArg.length > 0 ? renderRenderBlocks(pArg[0]) : null;
		if (pIndex == renderRenderManager) return pArg != null && pArg.length > 0 ? renderRenderManager(pArg[0]) : null;
		if (pIndex == renderRenderManagerRenderEngine) return pArg != null && pArg.length > 0 ? renderRenderManagerRenderEngine(pArg[0]) : null;
		if (pIndex == renderManagerGetEntityRenderObject) return pArg != null && pArg.length > 0 ? renderManagerGetEntityRenderObject(pArg[0]) : renderManagerGetEntityRenderObject();
		if (pIndex == renderMainModel) return pArg != null && pArg.length > 0 ? renderMainModel(pArg[0]) : null;
		if (pIndex == renderPlayerSmallArms) return pArg != null && pArg.length > 0 ? renderPlayerSmallArms(pArg[0]) : null;
		if (pIndex == nbtUtilReadGameProfileFromNBT) return pArg != null && pArg.length > 0 ? nbtUtilReadGameProfileFromNBT(pArg[0]) : null;
		if (pIndex == blockRendererDispatcherGetBlockModelRenderer) return pArg != null && pArg.length > 0 ? blockRendererDispatcherGetBlockModelRenderer(pArg[0]) : null;
		if (pIndex == tileEntitySkullUpdateGameprofile) return pArg != null && pArg.length > 0 ? tileEntitySkullUpdateGameprofile(pArg[0]) : null;
		if (pIndex == entityLivingBaseGetAITarget) return pArg != null && pArg.length > 0 ? entityLivingBaseGetAITarget(pArg[0]) : entityLivingBaseGetAITarget();
		if (pIndex == entityClientPlayerMPFunc_142021_k) return pArg != null && pArg.length > 0 ? entityClientPlayerMPFunc_142021_k(pArg[0]) : entityClientPlayerMPFunc_142021_k();
		if (pIndex == nbtTagCompoundHasKey) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					return nbtTagCompoundHasKey(pArg[0], (String) pArg[1], (Integer) pArg[2]);
				}
				return nbtTagCompoundHasKey(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbtTagCompoundGetString) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbtTagCompoundGetString(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == renderLivingFunc_110813_b) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return renderLivingFunc_110813_b(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == blockGetStateFromMeta) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return blockGetStateFromMeta(pArg[0], (Integer) pArg[1]);
			}
			return null;
		}
		if (pIndex == blockGetMetaFromState) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return blockGetMetaFromState(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == blockRendererDispatcherGetBakedModel) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null) {
				return blockRendererDispatcherGetBakedModel(pArg[0], pArg[1], pArg[2]);
			}
			return null;
		}
		if (pIndex == blockColorMultiplier) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return blockColorMultiplier(pArg[0], pArg[1], pArg[2], (Integer) pArg[3]);
			}
			return null;
		}
		if (pIndex == nBTUtilWriteGameProfile) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nBTUtilWriteGameProfile(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == nbtTagCompoundGetCompoundTag) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbtTagCompoundGetCompoundTag(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == inventoryPlayerArmorItemInSlot) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return inventoryPlayerArmorItemInSlot(pArg[0], (Integer) pArg[1]);
			}
			return null;
		}
		if (pIndex == itemStackStackSize) return pArg != null && pArg.length > 0 ? itemStackStackSize(pArg[0]) : null;
		if (pIndex == itemStackGetDisplayName) return pArg != null && pArg.length > 0 ? itemStackGetDisplayName(pArg[0]) : null;
		if (pIndex == itemRequiresMultipleRenderPasses) return pArg != null && pArg.length > 0 ? itemRequiresMultipleRenderPasses(pArg[0]) : null;
		if (pIndex == itemStackIsItemEnchanted) return pArg != null && pArg.length > 0 ? itemStackIsItemEnchanted(pArg[0]) : null;
		if (pIndex == mathHelperSin) return pArg != null && pArg.length > 0 ? mathHelperSin((Float) pArg[0]) : null;
		if (pIndex == mathHelperCos) return pArg != null && pArg.length > 0 ? mathHelperCos((Float) pArg[0]) : null;
		if (pIndex == mathHelperSqrt_float) return pArg != null && pArg.length > 0 ? mathHelperSqrt_float((Float) pArg[0]) : null;
		if (pIndex == mathHelperSqrt_double) return pArg != null && pArg.length > 0 ? mathHelperSqrt_double((Double) pArg[0]) : null;
		if (pIndex == mathHelperFloor_double) return pArg != null && pArg.length > 0 ? mathHelperFloor_double((Double) pArg[0]) : null;
		if (pIndex == mathHelperFloor_float) return pArg != null && pArg.length > 0 ? mathHelperFloor_float((Float) pArg[0]) : null;
		if (pIndex == mathHelperWrapAngleTo180_float) return pArg != null && pArg.length > 0 ? mathHelperWrapAngleTo180_float((Float) pArg[0]) : null;
		if (pIndex == mathHelperFloor_double_long) return pArg != null && pArg.length > 0 ? mathHelperFloor_double_long((Double) pArg[0]) : null;
		if (pIndex == mathHelperAbs) return pArg != null && pArg.length > 0 ? mathHelperAbs((Float) pArg[0]) : null;
		if (pIndex == mathHelperAbs_max) return pArg != null && pArg.length > 1 ? mathHelperAbs_max((Double) pArg[0], (Double) pArg[1]) : null;
		if (pIndex == mathHelperBucketInt) return pArg != null && pArg.length > 1 ? mathHelperBucketInt((Integer) pArg[0], (Integer) pArg[1]) : null;
		if (pIndex == mathHelperStringNullOrLengthZero) return pArg != null && pArg.length > 0 ? mathHelperStringNullOrLengthZero((String) pArg[0]) : null;
		if (pIndex == modelRendererGetTextureOffsetMap) return pArg != null && pArg.length > 0 ? modelRendererGetTextureOffsetMap(pArg[0]) : null;
		if (pIndex == textureOffsetTextureOffsetX) return pArg != null && pArg.length > 0 ? textureOffsetTextureOffsetX(pArg[0]) : null;
		if (pIndex == textureOffsetTextureOffsetY) return pArg != null && pArg.length > 0 ? textureOffsetTextureOffsetY(pArg[0]) : null;
		if (pIndex == minecraftCurrentScreen) return minecraftCurrentScreen();
		if (pIndex == minecraftMyNetworkManager) return minecraftMyNetworkManager();
		if (pIndex == entityPlayerIsPlayerSleeping) return pArg != null && pArg.length > 0 ? entityPlayerIsPlayerSleeping(pArg[0]) : entityPlayerIsPlayerSleeping();
		if (pIndex == entityPlayerCapabilitiesIsCreativeMode) return pArg != null && pArg.length > 0 ? entityPlayerCapabilitiesIsCreativeMode(pArg[0]) : entityPlayerCapabilitiesIsCreativeMode();
		if (pIndex == entityWidth) return pArg != null && pArg.length > 0 ? entityWidth(pArg[0]) : entityWidth();
		if (pIndex == entityHeight) return pArg != null && pArg.length > 0 ? entityHeight(pArg[0]) : entityHeight();
		if (pIndex == entityLivingBaseAttackedAtYaw) return pArg != null && pArg.length > 0 ? entityLivingBaseAttackedAtYaw(pArg[0]) : entityLivingBaseAttackedAtYaw();
		if (pIndex == entityLivingBasePrevHealth) return pArg != null && pArg.length > 0 ? entityLivingBasePrevHealth(pArg[0]) : entityLivingBasePrevHealth();
		if (pIndex == entityLivingBaseIsChild) return pArg != null && pArg.length > 0 ? entityLivingBaseIsChild(pArg[0]) : entityLivingBaseIsChild();
		if (pIndex == entityAgeableGetGrowingAge) return pArg != null && pArg.length > 0 ? entityAgeableGetGrowingAge(pArg[0]) : entityAgeableGetGrowingAge();
		if (pIndex == entityLivingBaseHurtTime) return pArg != null && pArg.length > 0 ? entityLivingBaseHurtTime(pArg[0]) : entityLivingBaseHurtTime();
		if (pIndex == entityLivingBaseMaxHurtTime) return pArg != null && pArg.length > 0 ? entityLivingBaseMaxHurtTime(pArg[0]) : entityLivingBaseMaxHurtTime();
		if (pIndex == entityZombieIsVillager) return pArg != null && pArg.length > 0 ? entityZombieIsVillager(pArg[0]) : null;
		if (pIndex == gLAllocationCreateDirectIntBuffer) return pArg != null && pArg.length > 0 ? gLAllocationCreateDirectIntBuffer((Integer) pArg[0]) : null;
		if (pIndex == gLAllocationGenerateDisplayLists) return pArg != null && pArg.length > 0 ? gLAllocationGenerateDisplayLists((Integer) pArg[0]) : null;
		if (pIndex == modelBaseIsChild) return pArg != null && pArg.length > 0 ? modelBaseIsChild(pArg[0]) : null;
		if (pIndex == modelBaseBoxList) return pArg != null && pArg.length > 0 ? modelBaseBoxList(pArg[0]) : null;
		if (pIndex == modelBaseTextureWidth) return pArg != null && pArg.length > 0 ? modelBaseTextureWidth(pArg[0]) : null;
		if (pIndex == modelBaseTextureHeight) return pArg != null && pArg.length > 0 ? modelBaseTextureHeight(pArg[0]) : null;
		if (pIndex == modelRightArm) return pArg != null && pArg.length > 0 ? modelRightArm(pArg[0]) : null;
		if (pIndex == modelBipedBipedRightArm) return pArg != null && pArg.length > 0 ? modelBipedBipedRightArm(pArg[0]) : null;
		if (pIndex == modelQuadrupedLeg1) return pArg != null && pArg.length > 0 ? modelQuadrupedLeg1(pArg[0]) : null;
		if (pIndex == modelCreeperLeg1) return pArg != null && pArg.length > 0 ? modelCreeperLeg1(pArg[0]) : null;
		if (pIndex == modelHorseFrontRightLeg) return pArg != null && pArg.length > 0 ? modelHorseFrontRightLeg(pArg[0]) : null;
		if (pIndex == modelIronGolemIronGolemRightArm) return pArg != null && pArg.length > 0 ? modelIronGolemIronGolemRightArm(pArg[0]) : null;
		if (pIndex == modelOcelotOcelotFrontRightLeg) return pArg != null && pArg.length > 0 ? modelOcelotOcelotFrontRightLeg(pArg[0]) : null;
		if (pIndex == modelSnowManRightHand) return pArg != null && pArg.length > 0 ? modelSnowManRightHand(pArg[0]) : null;
		if (pIndex == modelWolfWolfLeg1) return pArg != null && pArg.length > 0 ? modelWolfWolfLeg1(pArg[0]) : null;
		if (pIndex == modelSpiderSpiderLeg1) return pArg != null && pArg.length > 0 ? modelSpiderSpiderLeg1(pArg[0]) : null;
		if (pIndex == modelBatBatRightWing) return pArg != null && pArg.length > 0 ? modelBatBatRightWing(pArg[0]) : null;
		if (pIndex == modelBlazeBlazeSticks) return pArg != null && pArg.length > 0 ? modelBlazeBlazeSticks(pArg[0]) : null;
		if (pIndex == modelSquidSquidTentacles) return pArg != null && pArg.length > 0 ? modelSquidSquidTentacles(pArg[0]) : null;
		if (pIndex == modelGhastTentacles) return pArg != null && pArg.length > 0 ? modelGhastTentacles(pArg[0]) : null;
		if (pIndex == modelChickenRightWing) return pArg != null && pArg.length > 0 ? modelChickenRightWing(pArg[0]) : null;
		if (pIndex == stringUtilsIsNullOrEmpty) return pArg != null && pArg.length > 0 ? stringUtilsIsNullOrEmpty((String) pArg[0]) : null;
		if (pIndex == scaledresolutionGetScaleFactor) return pArg != null && pArg.length > 0 ? scaledresolutionGetScaleFactor(pArg[0]) : null;
		if (pIndex == scaledresolutionGetScaledWidth) return pArg != null && pArg.length > 0 ? scaledresolutionGetScaledWidth(pArg[0]) : null;
		if (pIndex == scaledresolutionGetScaledHeight) return pArg != null && pArg.length > 0 ? scaledresolutionGetScaledHeight(pArg[0]) : null;
		if (pIndex == movingObjectPositionBlockPosGetX) return pArg != null && pArg.length > 0 ? movingObjectPositionBlockPosGetX(pArg[0]) : null;
		if (pIndex == movingObjectPositionBlockPosGetY) return pArg != null && pArg.length > 0 ? movingObjectPositionBlockPosGetY(pArg[0]) : null;
		if (pIndex == movingObjectPositionBlockPosGetZ) return pArg != null && pArg.length > 0 ? movingObjectPositionBlockPosGetZ(pArg[0]) : null;
		if (pIndex == movingObjectPositionTypeOfHit) return pArg != null && pArg.length > 0 ? movingObjectPositionTypeOfHit(pArg[0]) : null;
		if (pIndex == movingObjectPositionSideHit) return pArg != null && pArg.length > 0 ? movingObjectPositionSideHit(pArg[0]) : null;
		if (pIndex == movingObjectPositionMovingObjectTypeMISS) return pArg != null && pArg.length > 0 ? movingObjectPositionMovingObjectTypeMISS(pArg[0]) : null;
		if (pIndex == movingObjectPositionMovingObjectTypeBLOCK) return pArg != null && pArg.length > 0 ? movingObjectPositionMovingObjectTypeBLOCK(pArg[0]) : null;
		if (pIndex == movingObjectPositionMovingObjectTypeENTITY) return pArg != null && pArg.length > 0 ? movingObjectPositionMovingObjectTypeENTITY(pArg[0]) : null;
		if (pIndex == movingObjectPositionHitVec) return pArg != null && pArg.length > 0 ? movingObjectPositionHitVec(pArg[0]) : null;
		if (pIndex == slotGetStack) return pArg != null && pArg.length > 0 ? slotGetStack(pArg[0]) : null;
		if (pIndex == inventoryPlayerGetStackInSlot) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return inventoryPlayerGetStackInSlot(pArg[0], (Integer) pArg[1]);
			}
			return null;
		}
		if (pIndex == itemSetTextureName) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return itemSetTextureName(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == iIconRegisterRegisterIcon) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return iIconRegisterRegisterIcon(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == blockDoublePlantFunc_149887_c) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				return blockDoublePlantFunc_149887_c((Integer) pArg[0]);
			}
			return null;
		}
		if (pIndex == blockDoublePlantFunc_149888_a) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return blockDoublePlantFunc_149888_a(pArg[0], (Boolean) pArg[1], (Integer) pArg[2]);
			}
			return null;
		}
		if (pIndex == iIconGetMinU) return pArg != null && pArg.length > 0 ? iIconGetMinU(pArg[0]) : null;
		if (pIndex == iIconGetMinV) return pArg != null && pArg.length > 0 ? iIconGetMinV(pArg[0]) : null;
		if (pIndex == iIconGetMaxU) return pArg != null && pArg.length > 0 ? iIconGetMaxU(pArg[0]) : null;
		if (pIndex == iIconGetMaxV) return pArg != null && pArg.length > 0 ? iIconGetMaxV(pArg[0]) : null;
		if (pIndex == iAttributeGetAttributeUnlocalizedName) return pArg != null && pArg.length > 0 ? iAttributeGetAttributeUnlocalizedName(pArg[0]) : null;
		if (pIndex == blockDoublePlantSunflowerIcons) return pArg != null && pArg.length > 0 ? blockDoublePlantSunflowerIcons(pArg[0]) : null;
		if (pIndex == blockDoublePlantFunc_149890_d) return pArg != null && pArg.length > 0 ? blockDoublePlantFunc_149890_d((Integer) pArg[0]) : null;
		if (pIndex == itemStackGetItemDamage) return pArg != null && pArg.length > 0 ? itemStackGetItemDamage(pArg[0]) : null;
		if (pIndex == itemStackGetMaxDamage) return pArg != null && pArg.length > 0 ? itemStackGetMaxDamage(pArg[0]) : null;
		if (pIndex == renderManagerInstance) return renderManagerInstance();
		if (pIndex == renderManagerGetEntityClassRenderObject) return pArg != null && pArg.length > 0 ? renderManagerGetEntityClassRenderObject((Class) pArg[0]) : null;
		if (pIndex == itemGetColorFromItemStack) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return itemGetColorFromItemStack(pArg[0], pArg[1], (Integer) pArg[2]);
			}
			return null;
		}
		if (pIndex == blockDoublePlantGetMixedBrightnessForBlock) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				if (pArg.length > 4
						&& pArg[4] != null) {
					return blockDoublePlantGetMixedBrightnessForBlock(pArg[0], pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Integer) pArg[4]);
				} else {
					return blockDoublePlantGetMixedBrightnessForBlock(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				}
			}
			return null;
		}
		if (pIndex == blockDoublePlantColorMultiplier) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				if (pArg.length > 4
						&& pArg[4] != null) {
					return blockDoublePlantColorMultiplier(pArg[0], pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Integer) pArg[4]);
				} else {
					return blockDoublePlantColorMultiplier(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				}
			}
			return null;
		}
		if (pIndex == biomeGenBaseGetBiomeGrassColor) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 3
						&& pArg[1] != null
						&& pArg[2] != null
						&& pArg[3] != null) {
					return biomeGenBaseGetBiomeGrassColor(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				} else {
					return biomeGenBaseGetBiomeGrassColor(pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == newInstanceKeyBinding) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return newInstanceKeyBinding((String) pArg[0], (Integer) pArg[1], (String) pArg[2]);
			}
			return null;
		}
		if (pIndex == serverConfigurationManagerRespawnPlayer) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return serverConfigurationManagerRespawnPlayer(pArg[0], pArg[1], (Integer) pArg[2], (Boolean) pArg[3]);
			}
			return null;
		}
		if (pIndex == newModelRenderer) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				return newModelRenderer(pArg);
			}
			return null;
		}
		if (pIndex == renderManagerEntityRenderMap) return renderManagerEntityRenderMap();
		if (pIndex == renderManagerSkinMap) return renderManagerSkinMap();
		if (pIndex == minecraftGameSettings) return minecraftGameSettings();
		if (pIndex == minecraftGameSettingsThirdPersonView) return minecraftGameSettingsThirdPersonView();
		if (pIndex == minecraftEntityRenderer) return minecraftEntityRenderer();
		if (pIndex == minecraftTextureManager) return minecraftTextureManager();
		if (pIndex == minecraftGetTextureManager) return minecraftGetTextureManager();
		if (pIndex == minecraftGetResourceManager) return minecraftGetResourceManager();
		if (pIndex == minecraftSystemTime) return minecraftSystemTime();
		if (pIndex == minecraftGetSystemTime) return minecraftGetSystemTime();
		if (pIndex == minecraftDisplayWidth) return minecraftDisplayWidth();
		if (pIndex == minecraftDisplayHeight) return minecraftDisplayHeight();
		if (pIndex == minecraftEntityRendererItemRenderer) return minecraftEntityRendererItemRenderer();
		if (pIndex == renderManagerItemRenderer) return renderManagerItemRenderer();
		if (pIndex == minecraftPlayerController) return minecraftPlayerController();
		if (pIndex == minecraftLoadingScreen) return minecraftLoadingScreen();
		if (pIndex == worldGetWorldInfo) return worldGetWorldInfo();
		if (pIndex == worldGetWorldInfoGetGameType) return worldGetWorldInfoGetGameType();
		if (pIndex == worldSettingsGameTypeNOT_SET) return worldSettingsGameTypeNOT_SET();
		if (pIndex == worldSettingsGameTypeSURVIVAL) return worldSettingsGameTypeSURVIVAL();
		if (pIndex == worldSettingsGameTypeCREATIVE) return worldSettingsGameTypeCREATIVE();
		if (pIndex == worldSettingsGameTypeADVENTURE) return worldSettingsGameTypeADVENTURE();
		if (pIndex == entityPosX) return pArg != null && pArg.length > 0 ? entityPosX(pArg[0]) : entityPosX();
		if (pIndex == entityPosY) return pArg != null && pArg.length > 0 ? entityPosY(pArg[0]) : entityPosY();
		if (pIndex == entityPosZ) return pArg != null && pArg.length > 0 ? entityPosZ(pArg[0]) : entityPosZ();
		if (pIndex == entityPrevPosX) return pArg != null && pArg.length > 0 ? entityPrevPosX(pArg[0]) : entityPrevPosX();
		if (pIndex == entityPrevPosY) return pArg != null && pArg.length > 0 ? entityPrevPosY(pArg[0]) : entityPrevPosY();
		if (pIndex == entityPrevPosZ) return pArg != null && pArg.length > 0 ? entityPrevPosZ(pArg[0]) : entityPrevPosZ();
		if (pIndex == entityMotionX) return pArg != null && pArg.length > 0 ? entityMotionX(pArg[0]) : entityMotionX();
		if (pIndex == entityMotionY) return pArg != null && pArg.length > 0 ? entityMotionY(pArg[0]) : entityMotionY();
		if (pIndex == entityMotionZ) return pArg != null && pArg.length > 0 ? entityMotionZ(pArg[0]) : entityMotionZ();
		if (pIndex == entityPrevDistanceWalkedModified) return pArg != null && pArg.length > 0 ? entityPrevDistanceWalkedModified(pArg[0]) : entityPrevDistanceWalkedModified();
		if (pIndex == entityDistanceWalkedModified) return pArg != null && pArg.length > 0 ? entityDistanceWalkedModified(pArg[0]) : entityDistanceWalkedModified();
		if (pIndex == entityTicksExisted) return pArg != null && pArg.length > 0 ? entityTicksExisted(pArg[0]) : entityTicksExisted();
		if (pIndex == entityLivingGetNavigator) return pArg != null && pArg.length > 0 ? entityLivingGetNavigator(pArg[0]) : entityLivingGetNavigator();
		if (pIndex == entityPlayerGetHideCape) return pArg != null && pArg.length > 0 ? entityPlayerGetHideCape(pArg[0]) : entityPlayerGetHideCape();
		if (pIndex == playerControllerMPCreatePlayer) return pArg != null && pArg.length > 0 ? playerControllerMPCreatePlayer(pArg[0]) : null;
		if (pIndex == entityPlayerInventory) return pArg != null && pArg.length > 0 ? entityPlayerInventory(pArg[0]) : entityPlayerInventory();
		if (pIndex == entityPlayerInventoryGetCurrentItem) return pArg != null && pArg.length > 0 ? entityPlayerInventoryGetCurrentItem(pArg[0]) : entityPlayerInventoryGetCurrentItem();
		if (pIndex == entityPlayerInventoryCurrentItem) return pArg != null && pArg.length > 0 ? entityPlayerInventoryCurrentItem(pArg[0]) : entityPlayerInventoryCurrentItem();
		if (pIndex == entityPlayerMainInventory) return pArg != null && pArg.length > 0 ? entityPlayerMainInventory(pArg[0]) : entityPlayerMainInventory();
		if (pIndex == entityPlayerArmorInventory) return pArg != null && pArg.length > 0 ? entityPlayerArmorInventory(pArg[0]) : entityPlayerArmorInventory();
		if (pIndex == entityClientPlayerMPSendQueue) return pArg != null && pArg.length > 0 ? entityClientPlayerMPSendQueue(pArg[0]) : entityClientPlayerMPSendQueue();
		if (pIndex == entityOnGround) return pArg != null && pArg.length > 0 ? entityOnGround(pArg[0]) : entityOnGround();
		if (pIndex == minecraftLaunchedVersion) return pArg != null && pArg.length > 0 ? minecraftLaunchedVersion(pArg[0]) : minecraftLaunchedVersion();
		if (pIndex == entityLivingBaseIsPotionActive) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return entityLivingBaseIsPotionActive(pArg[0], pArg[1]);
				} else {
					return entityLivingBaseIsPotionActive(pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == entityPlayerInventoryGetStackInSlot) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return entityPlayerInventoryGetStackInSlot(pArg[0], (Integer) pArg[1]);
				} else {
					return entityPlayerInventoryGetStackInSlot((Integer) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == entityPlayerInventoryPlayerArmorItemInSlot) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return entityPlayerInventoryPlayerArmorItemInSlot(pArg[0], (Integer) pArg[1]);
				} else {
					return entityPlayerInventoryPlayerArmorItemInSlot((Integer) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == itemItemInteractionForEntity) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null) {
				return itemItemInteractionForEntity(pArg[0], pArg[1], pArg[2], pArg[3]);
			}
			return null;
		}
		if (pIndex == entityDimension) return pArg != null && pArg.length > 0 ? entityDimension(pArg[0]) : entityDimension();
		if (pIndex == gameSettingsKeyBindForward) return gameSettingsKeyBindForward();
		if (pIndex == gameSettingsKeyBindBack) return gameSettingsKeyBindBack();
		if (pIndex == gameSettingsKeyBindLeft) return gameSettingsKeyBindLeft();
		if (pIndex == gameSettingsKeyBindRight) return gameSettingsKeyBindRight();
		if (pIndex == entityIsRiding) return pArg != null && pArg.length > 0 ? entityIsRiding(pArg[0]) : entityIsRiding();
		if (pIndex == minecraftInGameHasFocus) return minecraftInGameHasFocus();
		if (pIndex == entityLivingBaseMaxHurtResistantTime) return pArg != null && pArg.length > 0 ? entityLivingBaseMaxHurtResistantTime(pArg[0]) : entityLivingBaseMaxHurtResistantTime();
		if (pIndex == entityHurtResistantTime) return pArg != null && pArg.length > 0 ? entityHurtResistantTime(pArg[0]) : entityHurtResistantTime();
		if (pIndex == entityGetEyeHeight) return pArg != null && pArg.length > 0 ? entityGetEyeHeight(pArg[0]) : entityGetEyeHeight();
		if (pIndex == entityBoundingBox) return pArg != null && pArg.length > 0 ? entityBoundingBox(pArg[0]) : entityBoundingBox();
		if (pIndex == entityBoundingBoxMinX) return pArg != null && pArg.length > 0 ? entityBoundingBoxMinX(pArg[0]) : entityBoundingBoxMinX();
		if (pIndex == entityBoundingBoxMinY) return pArg != null && pArg.length > 0 ? entityBoundingBoxMinY(pArg[0]) : entityBoundingBoxMinY();
		if (pIndex == entityBoundingBoxMinZ) return pArg != null && pArg.length > 0 ? entityBoundingBoxMinZ(pArg[0]) : entityBoundingBoxMinZ();
		if (pIndex == entityBoundingBoxMaxX) return pArg != null && pArg.length > 0 ? entityBoundingBoxMaxX(pArg[0]) : entityBoundingBoxMaxX();
		if (pIndex == entityBoundingBoxMaxY) return pArg != null && pArg.length > 0 ? entityBoundingBoxMaxY(pArg[0]) : entityBoundingBoxMaxY();
		if (pIndex == entityBoundingBoxMaxZ) return pArg != null && pArg.length > 0 ? entityBoundingBoxMaxZ(pArg[0]) : entityBoundingBoxMaxZ();
		if (pIndex == entityIsSneaking) return pArg != null && pArg.length > 0 ? entityIsSneaking(pArg[0]) : entityIsSneaking();
		if (pIndex == entityWorldObj) return pArg != null && pArg.length > 0 ? entityWorldObj(pArg[0]) : entityWorldObj();
		if (pIndex == entityPlayerField_71091_bM) return pArg != null && pArg.length > 0 ? entityPlayerField_71091_bM(pArg[0]) : entityPlayerField_71091_bM();
		if (pIndex == entityPlayerField_71096_bN) return pArg != null && pArg.length > 0 ? entityPlayerField_71096_bN(pArg[0]) : entityPlayerField_71096_bN();
		if (pIndex == entityPlayerField_71097_bO) return pArg != null && pArg.length > 0 ? entityPlayerField_71097_bO(pArg[0]) : entityPlayerField_71097_bO();
		if (pIndex == entityPlayerField_71094_bP) return pArg != null && pArg.length > 0 ? entityPlayerField_71094_bP(pArg[0]) : entityPlayerField_71094_bP();
		if (pIndex == entityPlayerField_71095_bQ) return pArg != null && pArg.length > 0 ? entityPlayerField_71095_bQ(pArg[0]) : entityPlayerField_71095_bQ();
		if (pIndex == entityPlayerField_71085_bR) return pArg != null && pArg.length > 0 ? entityPlayerField_71085_bR(pArg[0]) : entityPlayerField_71085_bR();
		if (pIndex == worldIsAirBlock) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					return worldIsAirBlock(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				}
				return worldIsAirBlock((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
			}
			return null;
		}
		if (pIndex == entityLivingGetCurrentArmor) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityLivingGetCurrentArmor(pArg[0], (Integer) pArg[1]);
			}
			return null;
		}
		if (pIndex == renderLoadDownloadableImageTexture) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return renderLoadDownloadableImageTexture(pArg[0], (String) pArg[1], (String) pArg[2]);
			}
			return null;
		}
		if (pIndex == positionTextureVertexSetTexturePosition) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return positionTextureVertexSetTexturePosition(pArg[0], (Float) pArg[1], (Float) pArg[2]);
			}
			return null;
		}
		if (pIndex == positionTextureVertexVector3D) return pArg != null && pArg.length > 0 ? positionTextureVertexVector3D(pArg[0]) : null;
		if (pIndex == vec3CreateVectorHelper) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return vec3CreateVectorHelper((Double) pArg[0], (Double) pArg[1], (Double) pArg[2]);
			}
			return null;
		}
		if (pIndex == vec3Subtract) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return vec3Subtract(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == vec3CrossProduct) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return vec3CrossProduct(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == vec3Normalize) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				return vec3Normalize(pArg[0]);
			}
			return null;
		}
		if (pIndex == positionTextureVertexTexturePositionX) return pArg != null && pArg.length > 0 ? positionTextureVertexTexturePositionX(pArg[0]) : null;
		if (pIndex == positionTextureVertexTexturePositionY) return pArg != null && pArg.length > 0 ? positionTextureVertexTexturePositionY(pArg[0]) : null;
		if (pIndex == convertGlColor) return pArg != null && pArg.length > 0 ? convertGlColor((Integer) pArg[0]) : null;
		if (pIndex == vec3XCoord) return pArg != null && pArg.length > 0 ? vec3XCoord(pArg[0]) : null;
		if (pIndex == vec3YCoord) return pArg != null && pArg.length > 0 ? vec3YCoord(pArg[0]) : null;
		if (pIndex == vec3ZCoord) return pArg != null && pArg.length > 0 ? vec3ZCoord(pArg[0]) : null;
		if (pIndex == entityAnimalInLove) return pArg != null && pArg.length > 0 ? entityAnimalInLove(pArg[0]) : entityAnimalInLove();
		if (pIndex == entityRidingEntity) return pArg != null && pArg.length > 0 ? entityRidingEntity(pArg[0]) : entityRidingEntity();
		if (pIndex == entityGetBoundingBox) return pArg != null && pArg.length > 0 ? entityGetBoundingBox(pArg[0]) : entityGetBoundingBox();
		if (pIndex == entityCanBeCollidedWith) return pArg != null && pArg.length > 0 ? entityCanBeCollidedWith(pArg[0]) : entityCanBeCollidedWith();
		if (pIndex == entityGetCollisionBorderSize) return pArg != null && pArg.length > 0 ? entityGetCollisionBorderSize(pArg[0]) : entityGetCollisionBorderSize();
		if (pIndex == entityRiddenByEntity) return pArg != null && pArg.length > 0 ? entityRiddenByEntity(pArg[0]) : entityRiddenByEntity();
		if (pIndex == entityIsDead) return pArg != null && pArg.length > 0 ? entityIsDead(pArg[0]) : entityIsDead();
		if (pIndex == entityTameableIsTamed) return pArg != null && pArg.length > 0 ? entityTameableIsTamed(pArg[0]) : null;
		if (pIndex == entityHorseIsTame) return pArg != null && pArg.length > 0 ? entityHorseIsTame(pArg[0]) : null;
		if (pIndex == isTamed) return pArg != null && pArg.length > 0 ? isTamed(pArg[0]) : null;
		if (pIndex == entityLivingBaseDeathTime) return pArg != null && pArg.length > 0 ? entityLivingBaseDeathTime(pArg[0]) : entityLivingBaseDeathTime();
		if (pIndex == entityLivingBaseRecentlyHit) return pArg != null && pArg.length > 0 ? entityLivingBaseRecentlyHit(pArg[0]) : entityLivingBaseRecentlyHit();
		if (pIndex == entityLivingBaseAttackingPlayer) return pArg != null && pArg.length > 0 ? entityLivingBaseAttackingPlayer(pArg[0]) : entityLivingBaseAttackingPlayer();
		if (pIndex == entityLivingBaseGetHeldItem) return pArg != null && pArg.length > 0 ? entityLivingBaseGetHeldItem(pArg[0]) : entityLivingBaseGetHeldItem();
		if (pIndex == entityLivingBaseGetSoundVolume) return pArg != null && pArg.length > 0 ? entityLivingBaseGetSoundVolume(pArg[0]) : entityLivingBaseGetSoundVolume();
		if (pIndex == entityLivingBaseGetSoundPitch) return pArg != null && pArg.length > 0 ? entityLivingBaseGetSoundPitch(pArg[0]) : entityLivingBaseGetSoundPitch();
		if (pIndex == entityLastDamage) return pArg != null && pArg.length > 0 ? entityLastDamage(pArg[0]) : entityLastDamage();
		if (pIndex == entityYOffset) return pArg != null && pArg.length > 0 ? entityYOffset(pArg[0]) : entityYOffset();
		if (pIndex == worldIsDaytime) return pArg != null && pArg.length > 0 ? worldIsDaytime(pArg[0]) : worldIsDaytime();
		if (pIndex == entityGetBrightness) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityGetBrightness(pArg[0], (Float) pArg[1]);
			}
			return entityGetBrightness((Float) pArg[0]);
		}
		if (pIndex == entityGetBrightnessForRender) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityGetBrightnessForRender(pArg[0], (Float) pArg[1]);
			}
			return entityGetBrightnessForRender((Float) pArg[0]);
		}
		if (pIndex == vec3AddVector) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return vec3AddVector(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
			}
		}
		if (pIndex == vec3SquareDistanceTo) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return vec3SquareDistanceTo(pArg[0], pArg[1]);
			}
		}
		if (pIndex == itemPotionGetEffects) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return itemPotionGetEffects(pArg[0], pArg[1]);
			}
		}
		if (pIndex == worldCanBlockSeeTheSky) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					if (pArg[1] instanceof Double
							&& pArg[2] instanceof Double
							&& pArg[3] instanceof Double) {
						return worldCanBlockSeeTheSky(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
					} else {
						return worldCanBlockSeeTheSky(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
					}
				}
				if (pArg[1] instanceof Double
						&& pArg[2] instanceof Double
						&& pArg[3] instanceof Double) {
					return worldCanBlockSeeTheSky((Double) pArg[0], (Double) pArg[1], (Double) pArg[2]);
				} else {
					return worldCanBlockSeeTheSky((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
				}
			}
			return null;
		}
		if (pIndex == entityIsEntityAlive) return pArg != null && pArg.length > 0 ? entityIsEntityAlive(pArg[0]) : entityIsEntityAlive();
		if (pIndex == entityCreatureHasAttacked) return pArg != null && pArg.length > 0 ? entityCreatureHasAttacked(pArg[0]) : entityCreatureHasAttacked();
		if (pIndex == entityIsWet) return pArg != null && pArg.length > 0 ? entityIsWet(pArg[0]) : entityIsWet();
		if (pIndex == entityIsInWater) return pArg != null && pArg.length > 0 ? entityIsInWater(pArg[0]) : entityIsInWater();
		if (pIndex == entityCreatureEntityToAttack) return pArg != null && pArg.length > 0 ? entityCreatureEntityToAttack(pArg[0]) : entityCreatureEntityToAttack();
		if (pIndex == entityLivingNumTicksToChaseTarget) return pArg != null && pArg.length > 0 ? entityLivingNumTicksToChaseTarget(pArg[0]) : entityLivingNumTicksToChaseTarget();
		if (pIndex == entityCreatureGetEntityToAttack) return pArg != null && pArg.length > 0 ? entityCreatureGetEntityToAttack(pArg[0]) : entityCreatureGetEntityToAttack();
		if (pIndex == attributeModifierGetAmount) return pArg != null && pArg.length > 0 ? attributeModifierGetAmount(pArg[0]) : null;
		if (pIndex == abstractClientPlayerGetTextureSkin) return pArg != null && pArg.length > 0 ? abstractClientPlayerGetTextureSkin(pArg[0]) : abstractClientPlayerGetTextureSkin();
		if (pIndex == abstractClientPlayerLocationSkin) return pArg != null && pArg.length > 0 ? abstractClientPlayerLocationSkin(pArg[0]) : abstractClientPlayerLocationSkin();
		if (pIndex == abstractClientPlayerGetSkinType) return pArg != null && pArg.length > 0 ? abstractClientPlayerGetSkinType(pArg[0]) : abstractClientPlayerGetSkinType();
		if (pIndex == threadDownloadImageDataIsTextureUploaded) return pArg != null && pArg.length > 0 ? threadDownloadImageDataIsTextureUploaded(pArg[0]) : null;
		if (pIndex == threadDownloadImageDataGetGlTextureId) return pArg != null && pArg.length > 0 ? threadDownloadImageDataGetGlTextureId(pArg[0]) : null;
		if (pIndex == entityListStringToClassMapping) return entityListStringToClassMapping();
		if (pIndex == entityListClassToStringMapping) return entityListClassToStringMapping();
		if (pIndex == entityListIDtoClassMapping) return entityListIDtoClassMapping();
		if (pIndex == entityListClassToIDMapping) return entityListClassToIDMapping();
		if (pIndex == potionMoveSpeed) return potionMoveSpeed();
		if (pIndex == potionMoveSlowdown) return potionMoveSlowdown();
		if (pIndex == potionDigSpeed) return potionDigSpeed();
		if (pIndex == potionDigSlowdown) return potionDigSlowdown();
		if (pIndex == potionDamageBoost) return potionDamageBoost();
		if (pIndex == potionHeal) return potionHeal();
		if (pIndex == potionHarm) return potionHarm();
		if (pIndex == potionJump) return potionJump();
		if (pIndex == potionConfusion) return potionConfusion();
		if (pIndex == potionRegeneration) return potionRegeneration();
		if (pIndex == potionResistance) return potionResistance();
		if (pIndex == potionFireResistance) return potionFireResistance();
		if (pIndex == potionWaterBreathing) return potionWaterBreathing();
		if (pIndex == potionInvisibility) return potionInvisibility();
		if (pIndex == potionBlindness) return potionBlindness();
		if (pIndex == potionNightVision) return potionNightVision();
		if (pIndex == potionHunger) return potionHunger();
		if (pIndex == potionWeakness) return potionWeakness();
		if (pIndex == potionPoison) return potionPoison();
		if (pIndex == potionWither) return potionWither();
		if (pIndex == potionHealthBoost) return potionHealthBoost();
		if (pIndex == potionAbsorption) return potionAbsorption();
		if (pIndex == potionSaturation) return potionSaturation();
		if (pIndex == damageSourceStarve) return damageSourceStarve();
		if (pIndex == damageSourceCactus) return damageSourceCactus();
		if (pIndex == damageSourceInWall) return damageSourceInWall();
		if (pIndex == damageSourceDrown) return damageSourceDrown();
		if (pIndex == damageSourceOnFire) return damageSourceOnFire();
		if (pIndex == damageSourceLava) return damageSourceLava();
		if (pIndex == damageSourceInFire) return damageSourceInFire();
		if (pIndex == damageSourceMagic) return damageSourceMagic();
		if (pIndex == damageSourceGeneric) return damageSourceGeneric();
		if (pIndex == damageSourceFall) return damageSourceFall();
		if (pIndex == damageSourceOutOfWorld) return damageSourceOutOfWorld();
		if (pIndex == damageSourceWither) return damageSourceWither();
		if (pIndex == damageSourceAnvil) return damageSourceAnvil();
		if (pIndex == damageSourceFallingBlock) return damageSourceFallingBlock();
		if (pIndex == damageSourceGetEntity) return pArg != null && pArg.length > 0 ? damageSourceGetEntity(pArg[0]) : null;
		if (pIndex == damageSourceIsFireDamage) return pArg != null && pArg.length > 0 ? damageSourceIsFireDamage(pArg[0]) : null;
		if (pIndex == damageSourceCauseMobDamage) return pArg != null && pArg.length > 0 ? damageSourceCauseMobDamage(pArg[0]) : null;
		if (pIndex == entityArrowShootingEntity) return pArg != null && pArg.length > 0 ? entityArrowShootingEntity(pArg[0]) : null;
		if (pIndex == entityLivingCurrentTarget) return pArg != null && pArg.length > 0 ? entityLivingCurrentTarget(pArg[0]) : entityLivingCurrentTarget();
		if (pIndex == entityLivingBaseEntityAge) return pArg != null && pArg.length > 0 ? entityLivingBaseEntityAge(pArg[0]) : entityLivingBaseEntityAge();
		if (pIndex == entityLivingBaseGetMaxHealth) return pArg != null && pArg.length > 0 ? entityLivingBaseGetMaxHealth(pArg[0]) : entityLivingBaseGetMaxHealth();
		if (pIndex == entityLivingBaseHealth) return pArg != null && pArg.length > 0 ? entityLivingBaseHealth(pArg[0]) : entityLivingBaseHealth();
		if (pIndex == entityLivingBaseGetHealth) return pArg != null && pArg.length > 0 ? entityLivingBaseGetHealth(pArg[0]) : entityLivingBaseGetHealth();
		if (pIndex == entityLivingTasks) return pArg != null && pArg.length > 0 ? entityLivingTasks(pArg[0]) : null;
		if (pIndex == worldIsRemote) return pArg != null && pArg.length > 0 ? worldIsRemote(pArg[0]) : worldIsRemote();
		if (pIndex == enumCreatureAttributeUNDEFINED) return enumCreatureAttributeUNDEFINED();
		if (pIndex == enumCreatureAttributeUNDEAD) return enumCreatureAttributeUNDEAD();
		if (pIndex == enumCreatureAttributeARTHROPOD) return enumCreatureAttributeARTHROPOD();
		if (pIndex == enumCreatureTypeMonster) return enumCreatureTypeMonster();
		if (pIndex == enumCreatureTypeCreature) return enumCreatureTypeCreature();
		if (pIndex == enumCreatureTypeAmbient) return enumCreatureTypeAmbient();
		if (pIndex == enumCreatureTypeWaterCreature) return enumCreatureTypeWaterCreature();
		if (pIndex == enumFacingUP) return enumFacingUP();
		if (pIndex == enumFacingDOWN) return enumFacingDOWN();
		if (pIndex == enumFacingEAST) return enumFacingEAST();
		if (pIndex == enumFacingNORTH) return enumFacingNORTH();
		if (pIndex == enumFacingSOUTH) return enumFacingSOUTH();
		if (pIndex == enumFacingWEST) return enumFacingWEST();
		if (pIndex == biomeGenBaseOcean) return biomeGenBaseOcean();
		if (pIndex == biomeGenBasePlains) return biomeGenBasePlains();
		if (pIndex == biomeGenBaseDesert) return biomeGenBaseDesert();
		if (pIndex == biomeGenBaseExtremeHills) return biomeGenBaseExtremeHills();
		if (pIndex == biomeGenBaseForest) return biomeGenBaseForest();
		if (pIndex == biomeGenBaseTaiga) return biomeGenBaseTaiga();
		if (pIndex == biomeGenBaseRiver) return biomeGenBaseRiver();
		if (pIndex == biomeGenBaseHell) return biomeGenBaseHell();
		if (pIndex == biomeGenBaseSky) return biomeGenBaseSky();
		if (pIndex == biomeGenBaseFrozenOcean) return biomeGenBaseFrozenOcean();
		if (pIndex == biomeGenBaseFrozenRiver) return biomeGenBaseFrozenRiver();
		if (pIndex == biomeGenBaseIcePlains) return biomeGenBaseIcePlains();
		if (pIndex == biomeGenBaseIceMountains) return biomeGenBaseIceMountains();
		if (pIndex == biomeGenBaseMushroomIsland) return biomeGenBaseMushroomIsland();
		if (pIndex == biomeGenBaseMushroomIslandShore) return biomeGenBaseMushroomIslandShore();
		if (pIndex == biomeGenBaseBeach) return biomeGenBaseBeach();
		if (pIndex == biomeGenBaseDesertHills) return biomeGenBaseDesertHills();
		if (pIndex == biomeGenBaseForestHills) return biomeGenBaseForestHills();
		if (pIndex == biomeGenBaseTaigaHills) return biomeGenBaseTaigaHills();
		if (pIndex == biomeGenBaseExtremeHillsEdge) return biomeGenBaseExtremeHillsEdge();
		if (pIndex == biomeGenBaseJungle) return biomeGenBaseJungle();
		if (pIndex == biomeGenBaseJungleHills) return biomeGenBaseJungleHills();
		if (pIndex == biomeGenBaseJungleEdge) return biomeGenBaseJungleEdge();
		if (pIndex == biomeGenBaseDeepOcean) return biomeGenBaseDeepOcean();
		if (pIndex == biomeGenBaseStoneBeach) return biomeGenBaseStoneBeach();
		if (pIndex == biomeGenBaseStoneColdBeach) return biomeGenBaseStoneColdBeach();
		if (pIndex == biomeGenBaseBirchForest) return biomeGenBaseBirchForest();
		if (pIndex == biomeGenBaseBirchForestHills) return biomeGenBaseBirchForestHills();
		if (pIndex == biomeGenBaseRoofedForest) return biomeGenBaseRoofedForest();
		if (pIndex == biomeGenBaseColdTaiga) return biomeGenBaseColdTaiga();
		if (pIndex == biomeGenBaseColdTaigaHills) return biomeGenBaseColdTaigaHills();
		if (pIndex == biomeGenBaseMegaTaiga) return biomeGenBaseMegaTaiga();
		if (pIndex == biomeGenBaseMegaTaigaHills) return biomeGenBaseMegaTaigaHills();
		if (pIndex == biomeGenBaseExtremeHillsPlus) return biomeGenBaseExtremeHillsPlus();
		if (pIndex == biomeGenBaseSavanna) return biomeGenBaseSavanna();
		if (pIndex == biomeGenBaseSavannaPlateau) return biomeGenBaseSavannaPlateau();
		if (pIndex == biomeGenBaseMesa) return biomeGenBaseMesa();
		if (pIndex == biomeGenBaseMesaPlateau_F) return biomeGenBaseMesaPlateau_F();
		if (pIndex == biomeGenBaseMesaPlateau) return biomeGenBaseMesaPlateau();
		if (pIndex == creativeTabsTabBlock) return creativeTabsTabBlock();
		if (pIndex == creativeTabsTabDecorations) return creativeTabsTabDecorations();
		if (pIndex == creativeTabsTabRedstone) return creativeTabsTabRedstone();
		if (pIndex == creativeTabsTabTransport) return creativeTabsTabTransport();
		if (pIndex == creativeTabsTabMisc) return creativeTabsTabMisc();
		if (pIndex == creativeTabsTabAllSearch) return creativeTabsTabAllSearch();
		if (pIndex == creativeTabsTabFood) return creativeTabsTabFood();
		if (pIndex == creativeTabsTabTools) return creativeTabsTabTools();
		if (pIndex == creativeTabsTabCombat) return creativeTabsTabCombat();
		if (pIndex == creativeTabsTabBrewing) return creativeTabsTabBrewing();
		if (pIndex == creativeTabsTabMaterials) return creativeTabsTabMaterials();
		if (pIndex == creativeTabsTabInventory) return creativeTabsTabInventory();
		if (pIndex == worldIsBlockNormalCubeDefault) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return worldIsBlockNormalCubeDefault((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Boolean) pArg[3]);
			}
			return null;
		}
		if (pIndex == worldGetBlock) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					return worldGetBlock(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				}
				return worldGetBlock((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
			}
			return null;
		}
		if (pIndex == entityPlayerFoodStats) return pArg != null && pArg.length > 0 ? entityPlayerFoodStats(pArg[0]) : entityPlayerFoodStats();
		if (pIndex == entityPlayerGetCurrentEquippedItem) return pArg != null && pArg.length > 0 ? entityplayerGetCurrentEquippedItem(pArg[0]) : entityplayerGetCurrentEquippedItem();
		if (pIndex == entityPlayerGetFoodStats) return pArg != null && pArg.length > 0 ? entityPlayerGetFoodStats(pArg[0]) : entityPlayerGetFoodStats();
		if (pIndex == entityPlayerPlayerLevel) return pArg != null && pArg.length > 0 ? entityPlayerPlayerLevel(pArg[0]) : entityPlayerPlayerLevel();
		if (pIndex == entityPlayerTotalXP) return pArg != null && pArg.length > 0 ? entityPlayerTotalXP(pArg[0]) : entityPlayerTotalXP();
		if (pIndex == entityPlayerCurrentXP) return pArg != null && pArg.length > 0 ? entityPlayerCurrentXP(pArg[0]) : entityPlayerCurrentXP();
		if (pIndex == entityPlayerScore) return pArg != null && pArg.length > 0 ? entityPlayerScore(pArg[0]) : entityPlayerScore();
		if (pIndex == entityPlayerPrevCameraYaw) return pArg != null && pArg.length > 0 ? entityPlayerPrevCameraYaw(pArg[0]) : entityPlayerPrevCameraYaw();
		if (pIndex == entityPlayerCameraYaw) return pArg != null && pArg.length > 0 ? entityPlayerCameraYaw(pArg[0]) : entityPlayerCameraYaw();
		if (pIndex == entityPlayerGetItemInUseCount) return pArg != null && pArg.length > 0 ? entityPlayerGetItemInUseCount(pArg[0]) : entityPlayerGetItemInUseCount();
		if (pIndex == entityPlayerFishEntity) return pArg != null && pArg.length > 0 ? entityPlayerFishEntity(pArg[0]) : entityPlayerFishEntity();
		if (pIndex == entityPlayerMPPlayerNetServerHandler) return pArg != null && pArg.length > 0 ? entityPlayerMPPlayerNetServerHandler(pArg[0]) : entityPlayerMPPlayerNetServerHandler();
		if (pIndex == entityGetDataWatcher) return pArg != null && pArg.length > 0 ? entityGetDataWatcher(pArg[0]) : entityGetDataWatcher();
		if (pIndex == itemStackCopyItemStack) return pArg != null && pArg.length > 0 ? itemStackCopyItemStack(pArg[0]) : null;
		if (pIndex == itemStackGetItemUseAction) return pArg != null && pArg.length > 0 ? itemStackGetItemUseAction(pArg[0]) : null;
		if (pIndex == itemIconString) return pArg != null && pArg.length > 0 ? itemIconString(pArg[0]) : null;
		if (pIndex == itemItemIcon) return pArg != null && pArg.length > 0 ? itemItemIcon(pArg[0]) : null;
		if (pIndex == gameSettingsAnaglyph) return pArg != null && pArg.length > 0 ? gameSettingsAnaglyph(pArg[0]) : null;
		if (pIndex == containerInventorySlots) return pArg != null && pArg.length > 0 ? containerInventorySlots(pArg[0]) : null;
		if (pIndex == containerInventoryItemStacks) return pArg != null && pArg.length > 0 ? containerInventoryItemStacks(pArg[0]) : null;
		if (pIndex == containerGetSlot) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return containerGetSlot(pArg[0], (Integer) pArg[1]);
			}
			return null;
		}
		if (pIndex == entityLivingBaseGetLook) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return entityLivingBaseGetLook(pArg[0], (Float) pArg[1]);
				}
				return entityLivingBaseGetLook((Float) pArg[0]);
			}
			return null;
		}
		if (pIndex == itemSetUnlocalizedName) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return itemSetUnlocalizedName(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == itemSetCreativeTab) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return itemSetCreativeTab(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == renderBipedBipedArmorFilenamePrefix) return renderBipedBipedArmorFilenamePrefix();
		if (pIndex == itemArmorRenderIndex) return pArg != null && pArg.length > 0 ? itemArmorRenderIndex(pArg[0]) : null;
		if (pIndex == itemArmorGetArmorMaterial) return pArg != null && pArg.length > 0 ? itemArmorGetArmorMaterial(pArg[0]) : null;
		if (pIndex == itemArmorArmorMaterialGetName) return pArg != null && pArg.length > 0 ? itemArmorArmorMaterialGetName(pArg[0]) : null;
		if (pIndex == entityGetUniqueID) return pArg != null && pArg.length > 0 ? entityGetUniqueID(pArg[0]) : entityGetUniqueID();
		if (pIndex == entityTameableGetOwnerName) return pArg != null && pArg.length > 0 ? entityTameableGetOwnerName(pArg[0]) : entityTameableGetOwnerName();
		if (pIndex == entityTameableAiSit) return pArg != null && pArg.length > 0 ? entityTameableAiSit(pArg[0]) : null;
		if (pIndex == entityAnimalBreeding) return pArg != null && pArg.length > 0 ? entityAnimalBreeding(pArg[0]) : entityAnimalBreeding();
		if (pIndex == entityLivingBasePrevRenderYawOffset) return pArg != null && pArg.length > 0 ? entityLivingBasePrevRenderYawOffset(pArg[0]) : entityLivingBasePrevRenderYawOffset();
		if (pIndex == entityLivingBaseRenderYawOffset) return pArg != null && pArg.length > 0 ? entityLivingBaseRenderYawOffset(pArg[0]) : entityLivingBaseRenderYawOffset();
		if (pIndex == entityLivingBasePrevRotationYawHead) return pArg != null && pArg.length > 0 ? entityLivingBasePrevRotationYawHead(pArg[0]) : entityLivingBasePrevRotationYawHead();
		if (pIndex == entityLivingBaseRotationYawHead) return pArg != null && pArg.length > 0 ? entityLivingBaseRotationYawHead(pArg[0]) : entityLivingBaseRotationYawHead();
		if (pIndex == entityLivingBasePrevLimbSwingAmount) return pArg != null && pArg.length > 0 ? entityLivingBasePrevLimbSwingAmount(pArg[0]) : entityLivingBasePrevLimbSwingAmount();
		if (pIndex == entityLivingBaseLimbSwingAmount) return pArg != null && pArg.length > 0 ? entityLivingBaseLimbSwingAmount(pArg[0]) : entityLivingBaseLimbSwingAmount();
		if (pIndex == entityLivingBaseLimbSwing) return pArg != null && pArg.length > 0 ? entityLivingBaseLimbSwing(pArg[0]) : entityLivingBaseLimbSwing();
		if (pIndex == entityLivingBaseIsJumping) return pArg != null && pArg.length > 0 ? entityLivingBaseIsJumping(pArg[0]) : entityLivingBaseIsJumping();
		if (pIndex == entityPrevRotationYaw) return pArg != null && pArg.length > 0 ? entityPrevRotationYaw(pArg[0]) : entityPrevRotationYaw();
		if (pIndex == entityRotationYaw) return pArg != null && pArg.length > 0 ? entityRotationYaw(pArg[0]) : entityRotationYaw();
		if (pIndex == entityPrevRotationPitch) return pArg != null && pArg.length > 0 ? entityPrevRotationPitch(pArg[0]) : entityPrevRotationPitch();
		if (pIndex == entityRotationPitch) return pArg != null && pArg.length > 0 ? entityRotationPitch(pArg[0]) : entityRotationPitch();
		if (pIndex == entityLivingBaseMoveStrafing) return pArg != null && pArg.length > 0 ? entityLivingBaseMoveStrafing(pArg[0]) : entityLivingBaseMoveStrafing();
		if (pIndex == entityLivingBaseMoveForward) return pArg != null && pArg.length > 0 ? entityLivingBaseMoveForward(pArg[0]) : entityLivingBaseMoveForward();
		if (pIndex == entityIsInvisible) return pArg != null && pArg.length > 0 ? entityIsInvisible(pArg[0]) : entityIsInvisible();
		if (pIndex == entityLivingBaseGetSwingProgress) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return entityLivingBaseGetSwingProgress(pArg[0], (Float) pArg[1]);
				} else {
					return entityLivingBaseGetSwingProgress((Float) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == itemSetPotionEffect) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[1] != null) {
				return itemSetPotionEffect(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == itemGetMetadata) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return itemGetMetadata(pArg[0], (Integer) pArg[1]);
			}
			return null;
		}
		if (pIndex == itemArmorGetColor) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[1] != null) {
				return itemArmorGetColor(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == entityLivingBaseGetEquipmentInSlot) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return entityLivingBaseGetEquipmentInSlot(pArg[0], (Integer) pArg[1]);
				} else {
					return entityLivingBaseGetEquipmentInSlot((Integer) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == dataWatcherGetWatchedObject) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return dataWatcherGetWatchedObject(pArg[0], (Integer) pArg[1]);
				} else {
					return dataWatcherGetWatchedObject((Integer) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == dataWatcherGetWatchableObjectItemStack) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return dataWatcherGetWatchableObjectItemStack(pArg[0], (Integer) pArg[1]);
				} else {
					return dataWatcherGetWatchableObjectItemStack((Integer) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == dataWatcherGetWatchableObjectString) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return dataWatcherGetWatchableObjectString(pArg[0], (Integer) pArg[1]);
				} else {
					return dataWatcherGetWatchableObjectString((Integer) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == dataWatcherGetWatchableObjectByte) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return dataWatcherGetWatchableObjectByte(pArg[0], (Integer) pArg[1]);
				} else {
					return dataWatcherGetWatchableObjectByte((Integer) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == enumActionBlock) return enumActionBlock();
		if (pIndex == enumActionBow) return enumActionBow();
		if (pIndex == enumActionDrink) return enumActionDrink();
		if (pIndex == enumActionEat) return enumActionEat();
		if (pIndex == enumActionNone) return enumActionNone();
		if (pIndex == itemItemRegistry) return itemItemRegistry();
		if (pIndex == potionHelperSugarEffect) return potionHelperSugarEffect();
		if (pIndex == potionHelperGhastTearEffect) return potionHelperGhastTearEffect();
		if (pIndex == potionHelperSpiderEyeEffect) return potionHelperSpiderEyeEffect();
		if (pIndex == potionHelperFermentedSpiderEyeEffect) return potionHelperFermentedSpiderEyeEffect();
		if (pIndex == potionHelperSpeckledMelonEffect) return potionHelperSpeckledMelonEffect();
		if (pIndex == potionHelperBlazePowderEffect) return potionHelperBlazePowderEffect();
		if (pIndex == potionHelperMagmaCreamEffect) return potionHelperMagmaCreamEffect();
		if (pIndex == potionHelperRedstoneEffect) return potionHelperRedstoneEffect();
		if (pIndex == potionHelperGlowstoneEffect) return potionHelperGlowstoneEffect();
		if (pIndex == potionHelperGunpowderEffect) return potionHelperGunpowderEffect();
		if (pIndex == potionHelperGoldenCarrotEffect) return potionHelperGoldenCarrotEffect();
		if (pIndex == facingOffsetsXForSide) return facingOffsetsXForSide();
		if (pIndex == facingOffsetsYForSide) return facingOffsetsYForSide();
		if (pIndex == facingOffsetsZForSide) return facingOffsetsZForSide();
		if (pIndex == rendererLivingEntityRES_ITEM_GLINT) return pArg != null && pArg.length > 0 ? rendererLivingEntityRES_ITEM_GLINT(pArg[0]) : null;
		if (pIndex == renderItemGetItemModelMesher) return pArg != null && pArg.length > 0 ? renderItemGetItemModelMesher(pArg[0]) : null;
		if (pIndex == openGlHelperDefaultTexUnit) return openGlHelperDefaultTexUnit();
		if (pIndex == openGlHelperLightmapTexUnit) return openGlHelperLightmapTexUnit();
		if (pIndex == minecraftServerGetServer) return minecraftServerGetServer();
		if (pIndex == minecraftServerGetServerWorldServers) return minecraftServerGetServerWorldServers();
		if (pIndex == minecraftServerGetConfigurationManager) return pArg != null && pArg.length > 0 ? minecraftServerGetConfigurationManager(pArg[0]) : null;
		if (pIndex == minecraftServerGetFile) return pArg != null && pArg.length > 0 ? minecraftServerGetFile((String) pArg[0]) : null;
		if (pIndex == guiScreenButtonList) return pArg != null && pArg.length > 0 ? guiScreenButtonList(pArg[0]) : null;
		if (pIndex == guiScreenWidth) return pArg != null && pArg.length > 0 ? guiScreenWidth(pArg[0]) : null;
		if (pIndex == guiScreenHeight) return pArg != null && pArg.length > 0 ? guiScreenHeight(pArg[0]) : null;
		if (pIndex == guiScreenFontRenderer) return pArg != null && pArg.length > 0 ? guiScreenFontRenderer(pArg[0]) : null;
		if (pIndex == guiButtonWidth) return pArg != null && pArg.length > 0 ? guiButtonWidth(pArg[0]) : null;
		if (pIndex == guiButtonHeight) return pArg != null && pArg.length > 0 ? guiButtonHeight(pArg[0]) : null;
		if (pIndex == guiButtonID) return pArg != null && pArg.length > 0 ? guiButtonID(pArg[0]) : null;
		if (pIndex == guiButtonEnabled) return pArg != null && pArg.length > 0 ? guiButtonEnabled(pArg[0]) : null;
		if (pIndex == guiButtonXPosition) return pArg != null && pArg.length > 0 ? guiButtonXPosition(pArg[0]) : null;
		if (pIndex == guiButtonYPosition) return pArg != null && pArg.length > 0 ? guiButtonYPosition(pArg[0]) : null;
		if (pIndex == guiButtonVisible) return pArg != null && pArg.length > 0 ? guiButtonVisible(pArg[0]) : null;
		if (pIndex == resourceManagerInputStream) return pArg != null && pArg.length > 0 ? resourceManagerInputStream(pArg[0]) : null;
		if (pIndex == resourceGetInputStream) return pArg != null && pArg.length > 0 ? resourceGetInputStream(pArg[0]) : null;
		if (pIndex == resourceLocationGetResourceDomain) return pArg != null && pArg.length > 0 ? resourceLocationGetResourceDomain(pArg[0]) : null;
		if (pIndex == resourceLocationGetResourcePath) return pArg != null && pArg.length > 0 ? resourceLocationGetResourcePath(pArg[0]) : null;
		if (pIndex == textureUtilAnaglyphColor) return pArg != null && pArg.length > 0 ? textureUtilAnaglyphColor((Integer) pArg[0]) : null;
		if (pIndex == textureUtilUploadTextureImage) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return textureUtilUploadTextureImage((Integer) pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == tessellatorInstance) return tessellatorInstance();
		if (pIndex == registrySimpleRegistryObjects) return pArg != null && pArg.length > 0 ? registrySimpleRegistryObjects(pArg[0]) : registrySimpleRegistryObjects();
		if (pIndex == worldPlayerEntities) return pArg != null && pArg.length > 0 ? worldPlayerEntities(pArg[0]) : worldPlayerEntities();
		if (pIndex == playerEntities) return pArg != null && pArg.length > 0 ? playerEntities(pArg[0]) : playerEntities();
		if (pIndex == worldWeatherEffects) return pArg != null && pArg.length > 0 ? worldWeatherEffects(pArg[0]) : worldWeatherEffects();
		if (pIndex == worldRand) return pArg != null && pArg.length > 0 ? worldRand(pArg[0]) : worldRand();
		if (pIndex == gameSettingsGetKeyDisplayString) return pArg != null && pArg.length > 0 ? gameSettingsGetKeyDisplayString((Integer) pArg[0]) : null;
		if (pIndex == renderEngine) return renderEngine();
		if (pIndex == newModelResourceLocation) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return newModelResourceLocation((String) pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == renderManagerRenderEntityWithPosYaw) {
			if (pArg != null
			&& pArg.length > 5
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				return renderManagerRenderEntityWithPosYaw(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3], (Float) pArg[4], (Float) pArg[5]);
			}
			return null;
		}
		if (pIndex == getBipedArmor) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return getBipedArmor(pArg[0], pArg[1], (Integer) pArg[2], (Integer) pArg[3], (String) pArg[4]);
			}
			return null;
		}
		if (pIndex == axisAlignedBBGetBoundingBox) {
			if (pArg != null
			&& pArg.length > 5
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				return axisAlignedBBGetBoundingBox((Double) pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3], (Double) pArg[4], (Double) pArg[5]);
			}
			return null;
		}
		if (pIndex == axisAlignedBBExpand) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return axisAlignedBBExpand(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
			}
			return null;
		}
		if (pIndex == axisAlignedBBCalculateIntercept) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return axisAlignedBBCalculateIntercept(pArg[0], pArg[1], pArg[2]);
			}
			return null;
		}
		if (pIndex == axisAlignedBBIsVecInside) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return axisAlignedBBIsVecInside(pArg[0], pArg[1]);
			}
			return null;
		}
		if (pIndex == textureManagerGetTexture) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return textureManagerGetTexture(pArg[0], pArg[1]);
			}
			if (pArg != null) {
				return textureManagerGetTexture(pArg[0]);
			}
			return null;
		}
		if (pIndex == textureManagerGetResourceLocation) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return textureManagerGetResourceLocation(pArg[0], (Integer) pArg[1]);
			}
			if (pArg != null) {
				return textureManagerGetResourceLocation((Integer) pArg[0]);
			}
			return null;
		}
		if (pIndex == resourceManagerGetResource) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return resourceManagerGetResource(pArg[0], pArg[1]);
			}
			if (pArg != null) {
				return resourceManagerGetResource(pArg[0]);
			}
			return null;
		}
		if (pIndex == renderBlocksRenderItemIn3d) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return renderBlocksRenderItemIn3d(pArg[0], (Integer) pArg[1]);
			}
			return null;
		}
		if (pIndex == modelRendererShowModel) return pArg != null && pArg.length > 0 ? modelRendererShowModel(pArg[0]) : null;
		if (pIndex == modelRendererRotateAngleX) return pArg != null && pArg.length > 0 ? modelRendererRotateAngleX(pArg[0]) : null;
		if (pIndex == modelRendererRotateAngleY) return pArg != null && pArg.length > 0 ? modelRendererRotateAngleY(pArg[0]) : null;
		if (pIndex == modelRendererRotateAngleZ) return pArg != null && pArg.length > 0 ? modelRendererRotateAngleZ(pArg[0]) : null;
		if (pIndex == modelRendererRotationPointX) return pArg != null && pArg.length > 0 ? modelRendererRotationPointX(pArg[0]) : null;
		if (pIndex == modelRendererRotationPointY) return pArg != null && pArg.length > 0 ? modelRendererRotationPointY(pArg[0]) : null;
		if (pIndex == modelRendererRotationPointZ) return pArg != null && pArg.length > 0 ? modelRendererRotationPointZ(pArg[0]) : null;
		if (pIndex == modelBoxVertexPositions) return pArg != null && pArg.length > 0 ? modelBoxVertexPositions(pArg[0]) : null;
		if (pIndex == modelBoxQuadList) return pArg != null && pArg.length > 0 ? modelBoxQuadList(pArg[0]) : null;
		if (pIndex == worldLoadedEntityList) return pArg != null && pArg.length > 0 ? worldLoadedEntityList(pArg[0]) : worldLoadedEntityList();
		if (pIndex == netClientHandlerGetNetManager) return pArg != null && pArg.length > 0 ? netClientHandlerGetNetManager(pArg[0]) : null;
		if (pIndex == nbttagcompoundGetBoolean) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetBoolean(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetString) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetString(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetInteger) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetInteger(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetIntArray) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetIntArray(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetFloat) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetFloat(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetDouble) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetDouble(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetLong) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetLong(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetShort) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetShort(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetByte) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetByte(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == nbttagcompoundGetByteArray) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return nbttagcompoundGetByteArray(pArg[0], (String) pArg[1]);
			}
			return null;
		}
		if (pIndex == worldGetPlayerEntityByName) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return worldGetPlayerEntityByName(pArg[0], (String) pArg[1]);
				} else {
					return worldGetPlayerEntityByName((String) pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == worldSpawnEntityInWorld) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return worldSpawnEntityInWorld(pArg[0], pArg[1]);
				} else {
					return worldSpawnEntityInWorld(pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == getResource) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return getResource((Class) pArg[0], (String) pArg[1]);
				}
				return getResource((String) pArg[0]);
			}
			return null;
		}
		if (pIndex == entityPlayerCanPlayerEdit) {
			if (pArg != null
			&& pArg.length > 6
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				if (pArg.length > 7
						&& pArg[6] != null) {
					return entityPlayerCanPlayerEdit(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Integer) pArg[4], pArg[5]);
				}
				return entityPlayerCanPlayerEdit((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3], pArg[4]);
			}
		}
		if (pIndex == worldGetBlockStateGetBlockMetadata) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					return worldGetBlockStateGetBlockMetadata(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				}
				return worldGetBlockStateGetBlockMetadata((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
			}
		}
		if (pIndex == worldGetBlockLightValue) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					return worldGetBlockLightValue(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				}
				return worldGetBlockLightValue((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
			}
		}
		if (pIndex == worldGetStrongPower) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					return worldGetStrongPower(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				}
				return worldGetStrongPower((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
			}
		}
		if (pIndex == worldGetEntityByID) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					return worldGetEntityByID(pArg[0], (Integer) pArg[1]);
				}
				return worldGetEntityByID((Integer) pArg[0]);
			}
		}
		if (pIndex == worldGetBlockState) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return worldGetBlockState(pArg[0], pArg[1]);
			}
		}
		if (pIndex == newBlockPos) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return newBlockPos(pArg[0], pArg[1], pArg[2]);
			}
		}
		if (pIndex == pathNavigateTryMoveToXYZ) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null) {
				return pathNavigateTryMoveToXYZ(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Float) pArg[4]);
			}
		}
		if (pIndex == worldGetPathEntityToEntity) {
			if (pArg != null
			&& pArg.length > 6
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null
			&& pArg[6] != null) {
				if (pArg.length > 7
						&& pArg[7] != null) {
					return worldGetPathEntityToEntity(pArg[0], pArg[1], pArg[2], (Float) pArg[3], (Boolean) pArg[4], (Boolean) pArg[5], (Boolean) pArg[6], (Boolean) pArg[7]);
				}
				return worldGetPathEntityToEntity(pArg[0], pArg[1], (Float) pArg[2], (Boolean) pArg[3], (Boolean) pArg[4], (Boolean) pArg[5], (Boolean) pArg[6]);
			}
			return null;
		}
		if (pIndex == worldIsBlockModifiable) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return worldIsBlockModifiable(pArg[0], pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Integer) pArg[4]);
			}
			return null;
		}
		if (pIndex == worldGetEntitiesWithinAABB) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return worldGetEntitiesWithinAABB(pArg[0], (Class) pArg[1], pArg[2]);
			}
			return null;
		}
		if (pIndex == worldGetClosestPlayerToEntity) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					return worldGetClosestPlayerToEntity(pArg[0], pArg[1], (Double) pArg[2]);
				} else {
					return worldGetClosestPlayerToEntity(pArg[0], (Double) pArg[1]);
				}
			}
			return null;
		}
		if (pIndex == worldGetBiomeGenForCoords) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					if (pArg.length > 2
							&& pArg[2] != null) {
						return worldGetBiomeGenForCoords(pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
					} else {
						return worldGetBiomeGenForCoords(pArg[0], pArg[1]);
					}
				} else {
					return worldGetBiomeGenForCoords(pArg[0]);
				}
			}
			return null;
		}
		if (pIndex == worldGetEntitiesWithinAABBExcludingEntity) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					return worldGetEntitiesWithinAABBExcludingEntity(pArg[0], pArg[1], pArg[2]);
				} else {
					return worldGetEntitiesWithinAABBExcludingEntity(pArg[0], pArg[1]);
				}
			}
			return null;
		}
		if (pIndex == iBlockStateWithProperty) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return iBlockStateWithProperty(pArg[0], pArg[1], (Comparable) pArg[2]);
			}
			return null;
		}
		Modchu_Debug.mDebug1("Modchu_ASAlmighty getB other return null !! pIndex="+pIndex);
		return null;
	}

	@Override
	public boolean setB(int pIndex, Object... pArg) {
		return setB(null, pIndex, (Object[])pArg);
	}

	@Override
	public boolean setB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		if (pIndex == entityPlayerDestroyCurrentEquippedItem) {
			if (pArg != null
					&& pArg.length > 0) {
				entityPlayerDestroyCurrentEquippedItem(pArg[0]);
			}
			entityPlayerDestroyCurrentEquippedItem();
		}
		if (pIndex == setRender) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setRender(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBaseIsChild) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBaseIsChild(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBaseBoxList) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBaseBoxList(pArg[0], (List) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBaseTextureWidth) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBaseTextureWidth(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBaseTextureHeight) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBaseTextureHeight(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBipedBipedRightArm) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBipedBipedRightArm(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelQuadrupedLeg1) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelQuadrupedLeg1(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelCreeperLeg1) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelCreeperLeg1(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelHorseFrontRightLeg) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelHorseFrontRightLeg(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelIronGolemIronGolemRightArm) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelIronGolemIronGolemRightArm(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelOcelotOcelotFrontRightLeg) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelOcelotOcelotFrontRightLeg(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelSnowManRightHand) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelSnowManRightHand(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelWolfWolfLeg1) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelWolfWolfLeg1(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerPreparePlayerToSpawn) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				entityPlayerPreparePlayerToSpawn(pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == modelSpiderSpiderLeg1) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelSpiderSpiderLeg1(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBatBatRightWing) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBatBatRightWing(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBlazeBlazeSticks) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBlazeBlazeSticks(pArg[0], (Object[]) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelSquidSquidTentacles) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelSquidSquidTentacles(pArg[0], (Object[]) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelGhastTentacles) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelGhastTentacles(pArg[0], (Object[]) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelChickenRightWing) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelChickenRightWing(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == minecraftMyNetworkManager) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				setMinecraftMyNetworkManager(pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == allModelInit) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				allModelInit(pArg[0], pArg[1], (Boolean) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == setArmorRendering) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setArmorRendering(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == rendererLivingEntitySetRenderPassModel) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				rendererLivingEntitySetRenderPassModel(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetBoolean) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetBoolean(pArg[0], (String) pArg[1], (Boolean) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetString) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null) {
				nbttagcompoundSetString(pArg[0], (String) pArg[1], (String) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == netClientHandlerHandleClientCommand) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				netClientHandlerHandleClientCommand(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == worldRemoveEntity) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				worldRemoveEntity(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetInteger) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetInteger(pArg[0], (String) pArg[1], (Integer) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetFloat) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetFloat(pArg[0], (String) pArg[1], (Float) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetDouble) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetDouble(pArg[0], (String) pArg[1], (Float) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetShort) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetShort(pArg[0], (String) pArg[1], (Short) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetLong) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetLong(pArg[0], (String) pArg[1], (Long) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetByte) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetByte(pArg[0], (String) pArg[1], (Byte) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetByteArray) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetByteArray(pArg[0], (String) pArg[1], (byte[]) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == nbttagcompoundSetIntArray) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbttagcompoundSetIntArray(pArg[0], (String) pArg[1], (int[]) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == minecraftThePlayer) {
			setMinecraftThePlayer(pArg[0]);
			return true;
		}
		if (pIndex == minecraftFontRenderer) {
			minecraftFontRenderer(pArg[0]);
			return true;
		}
		if (pIndex == printChatMessage) {
			printChatMessage((String) pArg[0]);
			return true;
		}
		if (pIndex == entityLivingBaseSetBeenAttacked) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				entityLivingBaseSetBeenAttacked(pArg[0]);
				return true;
			}
			entityLivingBaseSetBeenAttacked();
			return true;
		}
		if (pIndex == entityLivingBaseLimbSwing) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseLimbSwing(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseLimbSwing((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBasePrevRenderYawOffset) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBasePrevRenderYawOffset(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBasePrevRenderYawOffset((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseRenderYawOffset) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseRenderYawOffset(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseRenderYawOffset((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBasePrevRotationYawHead) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBasePrevRotationYawHead(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBasePrevRotationYawHead((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseRotationYawHead) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseRotationYawHead(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseRotationYawHead((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBasePrevLimbSwingAmount) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBasePrevLimbSwingAmount(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBasePrevLimbSwingAmount((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseLimbSwingAmount) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseLimbSwingAmount(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseLimbSwingAmount((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseMoveForward) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseMoveForward(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseMoveForward((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseMoveStrafing) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseMoveStrafing(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseMoveStrafing((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseLimbSwing) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseLimbSwing(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseLimbSwing((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityTameableSetOwner) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					entityTameableSetOwner(pArg[0], (String) pArg[1]);
				} else {
					entityTameableSetOwner(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseSwingItem) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				entityLivingBaseSwingItem(pArg[0]);
				return true;
			}
			entityLivingBaseSwingItem();
			return true;
		}
		if (pIndex == entityLivingNavigatorClearPathEntity) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				entityLivingNavigatorClearPathEntity(pArg[0]);
				return true;
			}
			entityLivingNavigatorClearPathEntity();
			return true;
		}
		if (pIndex == entityLivingBaseOnDeath) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					entityLivingBaseOnDeath(pArg[0], pArg[1]);
				} else {
					entityLivingBaseOnDeath(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseAttackedAtYaw) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseAttackedAtYaw(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseAttackedAtYaw((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityDimension) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityDimension(pArg[0], (Integer) pArg[1]);
					return true;
				}
				setEntityDimension((Integer) pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == entityHurtResistantTime) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					setEntityHurtResistantTime(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityHurtResistantTime((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == itemStackStackSize) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setItemStackStackSize(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == keyBindingPressed) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				keyBindingSetPressed(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == entityEntityID) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityEntityID(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityEntityID((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseMaxHurtResistantTime) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseMaxHurtResistantTime(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityLivingBaseMaxHurtResistantTime((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseRecentlyHit) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseRecentlyHit(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityLivingBaseRecentlyHit((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityRidingEntity) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					setEntityRidingEntity(pArg[0], pArg[1]);
				} else {
					setEntityRidingEntity(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityRiddenByEntity) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					setEntityRiddenByEntity(pArg[0], pArg[1]);
				} else {
					setEntityRiddenByEntity(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityIsDead) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityIsDead(pArg[0], (Boolean) pArg[1]);
				} else {
					setEntityIsDead((Boolean) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseAttackingPlayer) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					setEntityLivingBaseAttackingPlayer(pArg[0], pArg[1]);
				} else {
					setEntityLivingBaseAttackingPlayer(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == dataWatcherAddObject) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				if (pArg.length > 2
						&& pArg[1] != null) {
					dataWatcherAddObject(pArg[0], (Integer) pArg[1], pArg[2]);
				} else {
					dataWatcherAddObject((Integer) pArg[0], pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == minecraftDisplayGuiScreen) {
			setMinecraftDisplayGuiScreen(pArg[0]);
			return true;
		}
		if (pIndex == guiIngameDrawString) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				guiIngameDrawString((String) pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == renderBlocksRenderBlockAsItem) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				renderBlocksRenderBlockAsItem(pArg[0], pArg[1], (Integer) pArg[2], (Float) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == itemOnItemRightClick) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				itemOnItemRightClick(pArg[0], pArg[1], pArg[2], pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == renderBlocksRenderBlockAllFaces) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null) {
				renderBlocksRenderBlockAllFaces(pArg[0], pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Integer) pArg[4]);
				return true;
			}
			return false;
		}
		if (pIndex == renderBlocksDrawCrossedSquares) {
			if (pArg != null
			&& pArg.length > 5
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				renderBlocksDrawCrossedSquares(pArg[0], pArg[1], (Double) pArg[2], (Double) pArg[3], (Double) pArg[4], (Float) pArg[5]);
				return true;
			}
			return false;
		}
		if (pIndex == fontRendererDrawString) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null) {
				fontRendererDrawString(pArg[0], (String) pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Integer) pArg[4]);
				return true;
			}
			return false;
		}
		if (pIndex == renderBindTexture) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				renderBindTexture(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == renderEngineBindTexture) {
			renderEngineBindTexture(pArg[0]);
			return true;
		}
		if (pIndex == renderRenderManager) {
			renderSetRenderManager(pArg[0]);
			return true;
		}
		if (pIndex == entityOnUpdate) {
			entityOnUpdate(pArg[0]);
			return true;
		}
		if (pIndex == renderFirstPersonArm) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				renderFirstPersonArm(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == pathNavigateGroundFunc_179690_a) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				pathNavigateGroundFunc_179690_a(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == entityTicksExisted) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityTicksExisted(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityTicksExisted((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == blockSetLightOpacity) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				blockSetLightOpacity(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == entityClientPlayerMPFunc_142020_c) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1) {
					entityClientPlayerMPFunc_142020_c(pArg[0], (String) pArg[1]);
					return true;
				}
				entityClientPlayerMPFunc_142020_c((String) pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == blockRendererDispatcherRenderBlockBrightness) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				blockRendererDispatcherRenderBlockBrightness(pArg[0], pArg[1], (Float) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == blockModelRendererRenderModelBrightness) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null) {
				blockModelRendererRenderModelBrightness(pArg[0], pArg[1], pArg[2], (Float) pArg[3], (Boolean) pArg[4]);
				return true;
			}
			return false;
		}
		if (pIndex == minecraftGameSettingsSetThirdPersonView) {
			minecraftGameSettingsSetThirdPersonView((Integer) pArg[0]);
			return true;
		}
		if (pIndex == entityRendererItemRenderer) {
			setEntityRendererItemRenderer(pArg[0]);
			return true;
		}
		if (pIndex == renderManagerItemRenderer) {
			setRenderManagerItemRenderer(pArg[0]);
			return true;
		}
		if (pIndex == renderMainModel) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setRenderMainModel(pArg[0], pArg[1]);
			}
			return true;
		}
		if (pIndex == modelBoxVertexPositions) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBoxVertexPositions(pArg[0], pArg[1]);
			}
			return true;
		}
		if (pIndex == modelBoxQuadList) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setModelBoxQuadList(pArg[0], pArg[1]);
			}
			return true;
		}
		if (pIndex == minecraftPlayerController) {
			setMinecraftPlayerController(pArg[0]);
			return true;
		}
		if (pIndex == setEntityPosX) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPosX(pArg[0], (Double) pArg[1]);
				} else {
					setEntityPosX((Double) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == setEntityPosY) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPosY(pArg[0], (Double) pArg[1]);
				} else {
					setEntityPosY((Double) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == setEntityPosZ) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPosZ(pArg[0], (Double) pArg[1]);
				} else {
					setEntityPosZ((Double) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == playerControllerSetGameType) {
			playerControllerSetGameType(pArg[0]);
			return true;
		}
		if (pIndex == minecraftSetDimensionAndSpawnPlayer) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				minecraftSetDimensionAndSpawnPlayer((Integer) pArg[0]);
				return true;
			}
			minecraftSetDimensionAndSpawnPlayer();
			return true;
		}
		if (pIndex == playerControllerMPSetPlayerCapabilities) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					playerControllerMPSetPlayerCapabilities(pArg[0], pArg[1]);
				} else {
					playerControllerMPSetPlayerCapabilities(pArg[0]);
				}
				return true;
			}
			playerControllerMPSetPlayerCapabilities();
			return true;
		}
		if (pIndex == worldSetEntityDead) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					worldSetEntityDead(pArg[0], pArg[1]);
				} else {
					worldSetEntityDead(pArg[0]);
				}
				return true;
			}
			worldSetEntityDead();
			return true;
		}
		if (pIndex == entitySetDead) {
			if (pArg[0] != null) entitySetDead(pArg[0]);
			else entitySetDead();
			return true;
		}
		if (pIndex == minecraftRenderViewEntity) {
			if (pArg[0] != null) setMinecraftRenderViewEntity(pArg[0]);
			else setMinecraftRenderViewEntity();
			return true;
		}
		if (pIndex == playerControllerMPFlipPlayer) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					playerControllerMPFlipPlayer(pArg[0], pArg[1]);
				} else {
					playerControllerMPFlipPlayer(pArg[0]);
				}
				return true;
			}
			playerControllerMPFlipPlayer();
			return true;
		}
		if (pIndex == worldSpawnPlayerWithLoadedChunks) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					worldSpawnPlayerWithLoadedChunks(pArg[0], pArg[1]);
				} else {
					worldSpawnPlayerWithLoadedChunks(pArg[0]);
				}
				return true;
			}
			worldSpawnPlayerWithLoadedChunks();
			return true;
		}
		if (pIndex == entityPlayerSPMovementInput) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerSPMovementInput(pArg[0], pArg[1]);
				} else {
					setEntityPlayerSPMovementInput(pArg[0]);
				}
				return true;
			}
			setEntityPlayerSPMovementInput();
			return true;
		}
		if (pIndex == entityPlayerSetItemInUse) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					entityPlayerSetItemInUse(pArg[0], pArg[1], (Integer) pArg[2]);
				} else {
					entityPlayerSetItemInUse(pArg[0], (Integer) pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerSPFunc_6420_o) {
			if (pArg[0] != null) entityPlayerSPFunc_6420_o(pArg[0]);
			else entityPlayerSPFunc_6420_o();
			return true;
		}
		if (pIndex == playerControllerFunc_6473_b) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					playerControllerFunc_6473_b(pArg[0], pArg[1]);
				} else {
					playerControllerFunc_6473_b(pArg[0]);
				}
				return true;
			}
			playerControllerFunc_6473_b();
			return true;
		}
		if (pIndex == entityPlayerInventory) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerInventory(pArg[0], pArg[1]);
				} else {
					setEntityPlayerInventory(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerMainInventory) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerMainInventory(pArg[0], pArg[1]);
				} else {
					setEntityPlayerMainInventory(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerArmorInventory) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerArmorInventory(pArg[0], pArg[1]);
				} else {
					setEntityPlayerArmorInventory(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityCreatureHasAttacked) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityCreatureHasAttacked(pArg[0], (Boolean) pArg[1]);
				} else {
					setEntityCreatureHasAttacked((Boolean) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == gameSettingsKeyBindForward)
			setGameSettingsKeyBindForward(pArg[0]);
		if (pIndex == gameSettingsKeyBindBack)
			setGameSettingsKeyBindBack(pArg[0]);
		if (pIndex == gameSettingsKeyBindRight)
			setGameSettingsKeyBindRight(pArg[0]);
		if (pIndex == gameSettingsKeyBindLeft)
			setGameSettingsKeyBindLeft(pArg[0]);
		if (pIndex == entityMotionX) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityMotionX(pArg[0], (Double) pArg[1]);
				} else {
					setEntityMotionX((Double) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityMotionY) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityMotionY(pArg[0], (Double) pArg[1]);
				} else {
					setEntityMotionY((Double) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityMotionZ) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityMotionZ(pArg[0], (Double) pArg[1]);
				} else {
					setEntityMotionZ((Double) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entitySetPosition) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					entitySetPosition(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
				} else {
					entitySetPosition((Double) pArg[0], (Double) pArg[1], (Double) pArg[2]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseSetPositionAndUpdate) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					entityLivingBaseSetPositionAndUpdate(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
				} else {
					entityLivingBaseSetPositionAndUpdate((Double) pArg[0], (Double) pArg[1], (Double) pArg[2]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entitySetLocationAndAngles) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null) {
				if (pArg.length > 5
						&& pArg[5] != null) {
					entitySetLocationAndAngles(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3], (Float) pArg[4], (Float) pArg[5]);
				} else {
					entitySetLocationAndAngles((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Float) pArg[3], (Float) pArg[4]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entitySetPositionAndRotation) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null) {
				if (pArg.length > 5
						&& pArg[5] != null) {
					entitySetPositionAndRotation(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3], (Float) pArg[4], (Float) pArg[5]);
				} else {
					entitySetPositionAndRotation((Double) pArg[0], (Double) pArg[1], (Double) pArg[2], (Float) pArg[3], (Float) pArg[4]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entitySetSize) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					entitySetSize(pArg[0], (Float) pArg[1], (Float) pArg[2]);
				} else {
					entitySetSize((Float) pArg[0], (Float) pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityMountEntity) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					entityMountEntity(pArg[0], pArg[1]);
				} else {
					entityMountEntity(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseDeathTime) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseDeathTime(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityLivingBaseDeathTime((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entitySetFire) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					entitySetFire(pArg[0], (Integer) pArg[1]);
				} else {
					entitySetFire((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityCreatureEntityToAttack) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					setEntityCreatureEntityToAttack(pArg[0], pArg[1]);
				} else {
					setEntityCreatureEntityToAttack(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingNumTicksToChaseTarget) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingNumTicksToChaseTarget(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityLivingNumTicksToChaseTarget((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseHurtTime) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseHurtTime(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityLivingBaseHurtTime((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseMaxHurtTime) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseMaxHurtTime(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityLivingBaseMaxHurtTime((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entitySetCustomNameTag) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					entitySetCustomNameTag(pArg[0], (String) pArg[1]);
				} else {
					entitySetCustomNameTag((String) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityAnimalInLove) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityAnimalInLove(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityAnimalInLove((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityCreatureSetPathToEntity) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					entityCreatureSetPathToEntity(pArg[0], pArg[1]);
				} else {
					entityCreatureSetPathToEntity(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseEntityAge) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseEntityAge(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityLivingBaseEntityAge((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityAttackEntityFrom) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					entityAttackEntityFrom(pArg[0], pArg[1], (Float) pArg[2]);
				} else {
					entityAttackEntityFrom(pArg[0], (Float) pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseSetHealth) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					entityLivingBaseSetHealth(pArg[0], (Float) pArg[1]);
				} else {
					entityLivingBaseSetHealth((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityYOffset) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityYOffset(pArg[0], (Float) pArg[1]);
				} else {
					setEntityYOffset((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerFoodStats) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityFoodStats(pArg[0], pArg[1]);
				} else {
					setEntityFoodStats(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerPlayerLevel) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerPlayerLevel(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityPlayerPlayerLevel((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerTotalXP) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerTotalXP(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityPlayerTotalXP((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerCurrentXP) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerCurrentXP(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityPlayerCurrentXP((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerScore) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerScore(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityPlayerScore((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseHealth) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityLivingBaseHealth(pArg[0], (Float) pArg[1]);
				} else {
					setEntityLivingBaseHealth((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseKnockBack) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				if (pArg.length > 4
						&& pArg[4] != null) {
					entityLivingBaseKnockBack(pArg[0], pArg[1], (Float) pArg[2], (Double) pArg[3], (Double) pArg[4]);
				} else {
					entityLivingBaseKnockBack(pArg[0], (Float) pArg[1], (Double) pArg[2], (Double) pArg[3]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == renderHelperEnableStandardItemLighting) {
			renderHelperEnableStandardItemLighting();
			return true;
		}
		if (pIndex == renderHelperDisableStandardItemLighting) {
			renderHelperDisableStandardItemLighting();
			return true;
		}
		if (pIndex == modelBaseSetLivingAnimations) {
			if (pArg != null
			&& pArg.length > 4
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null) {
				modelBaseSetLivingAnimations(pArg[0], pArg[1], (Float) pArg[2], (Float) pArg[3], (Float) pArg[4]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBaseSetRotationAngles) {
			if (pArg != null
			&& pArg.length > 7
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null
			&& pArg[6] != null
			&& pArg[7] != null) {
				modelBaseSetRotationAngles(pArg[0], (Float) pArg[1], (Float) pArg[2], (Float) pArg[3], (Float) pArg[4], (Float) pArg[5], (Float) pArg[6], pArg[7]);
				return true;
			}
			return false;
		}
		if (pIndex == modelBaseRender) {
			if (pArg != null
			&& pArg.length > 7
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null
			&& pArg[6] != null
			&& pArg[7] != null) {
				modelBaseRender(pArg[0], pArg[1], (Float) pArg[2], (Float) pArg[3], (Float) pArg[4], (Float) pArg[5], (Float) pArg[6], (Float) pArg[7]);
				return true;
			}
			return false;
		}
		if (pIndex == guiScreenFontRenderer) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenFontRenderer(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == guiScreenButtonList) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenButtonList(pArg[0], (List) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == guiScreenWidth) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenWidth(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == guiScreenHeight) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenHeight(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == renderEngineSetupTexture) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				renderEngineSetupTexture(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == loadingScreenDisplayLoadingString) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					loadingScreenDisplayLoadingString(pArg[0], (String) pArg[1]);
				}
				loadingScreenDisplayLoadingString((String) pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == loadingScreenResetProgressAndMessage) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					loadingScreenResetProgressAndMessage(pArg[0], (String) pArg[1]);
				}
				loadingScreenResetProgressAndMessage((String) pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == loadingScreenSetLoadingProgress) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					loadingScreenSetLoadingProgress(pArg[0], (Integer) pArg[1]);
				}
				loadingScreenSetLoadingProgress((Integer) pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == renderEngineDeleteTexture) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg != null
						&& pArg.length > 1
						&& pArg[1] != null) {
					renderEngineDeleteTexture(pArg[0], pArg[1]);
				} else {
					renderEngineDeleteTexture(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == renderItems) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				renderItems(pArg[0], pArg[1], pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == textureUtilBindTexture) {
			if (pArg != null) {
				textureUtilBindTexture((Integer) pArg[0]);
				return true;
			}
			return false;
		}
		if (pIndex == textureManagerBindTexture) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1) {
					textureManagerBindTexture(pArg[0], pArg[1]);
				} else {
					textureManagerBindTexture(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseSetRevengeTarget) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					entityLivingBaseSetRevengeTarget(pArg[0], pArg[1]);
				} else {
					entityLivingBaseSetRevengeTarget(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseHeal) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					entityLivingBaseHeal(pArg[0], (Float) pArg[1]);
				} else {
					entityLivingBaseHeal((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityRotationYaw) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityRotationYaw(pArg[0], (Float) pArg[1]);
				} else {
					setEntityRotationYaw((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPrevRotationPitch) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPrevRotationPitch(pArg[0], (Float) pArg[1]);
				} else {
					setEntityPrevRotationPitch((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPrevRotationYaw) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPrevRotationYaw(pArg[0], (Float) pArg[1]);
				} else {
					setEntityPrevRotationYaw((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityRotationPitch) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityRotationPitch(pArg[0], (Float) pArg[1]);
				} else {
					setEntityRotationPitch((Float) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityAnimalBreeding) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityAnimalBreeding(pArg[0], (Integer) pArg[1]);
				} else {
					setEntityAnimalBreeding((Integer) pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerFishEntity) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					setEntityPlayerFishEntity(pArg[0], pArg[1]);
				} else {
					setEntityPlayerFishEntity(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityZombieSetVillager) {
			if (pArg != null
					&& pArg.length > 1
					&& pArg[0] != null
					&& pArg[1] != null) {
					entityZombieSetVillager(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerMPPlayerNetServerHandler) {
			if (pArg != null
			&& pArg.length > 0) {
				if (pArg.length > 1
						&& pArg[0] != null) {
					setEntityPlayerMPPlayerNetServerHandler(pArg[0], pArg[1]);
				} else {
					setEntityPlayerMPPlayerNetServerHandler(pArg[0]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorStartDrawingQuads) {
			tessellatorStartDrawingQuads(pArg[0]);
			return true;
		}
		if (pIndex == tessellatorStartDrawing) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				tessellatorStartDrawing(pArg[0], (Byte) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorSetColorOpaque_I) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				tessellatorSetColorOpaque_I(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorSetColorOpaque_F) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				tessellatorSetColorOpaque_F(pArg[0], (Float) pArg[1], (Float) pArg[2], (Float) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorSetBrightness) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				tessellatorSetBrightness(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorSetNormal) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				tessellatorSetNormal(pArg[0], (Float) pArg[1], (Float) pArg[2], (Float) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorAddVertex) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				tessellatorAddVertex(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorAddVertexWithUV) {
			if (pArg != null
			&& pArg.length > 5
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				tessellatorAddVertexWithUV(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3], (Double) pArg[4], (Double) pArg[5]);
				return true;
			}
			return false;
		}
		if (pIndex == tessellatorDraw) {
			tessellatorDraw(pArg[0]);
			return true;
		}
		if (pIndex == framebufferBindFramebuffer) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				framebufferBindFramebuffer(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == framebufferUnbindFramebuffer) {
			framebufferUnbindFramebuffer(pArg[0]);
			return true;
		}
		if (pIndex == framebufferFramebufferRender) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				framebufferFramebufferRender(pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == openGlHelperSetActiveTexture) {
			openGlHelperSetActiveTexture((Integer) pArg[0]);
			return true;
		}
		if (pIndex == guiSlotRegisterScrollButtons) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					guiSlotRegisterScrollButtons(pArg[0], (List) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
					return true;
				}
				if (pArg[1] != null) guiSlotRegisterScrollButtons(pArg[0], null, (Integer) pArg[1], (Integer) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == guiScreenDrawScreen) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				guiScreenDrawScreen(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Float) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == guiScreenFunc_175273_b) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					guiScreenFunc_175273_b(pArg[0], pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
					return true;
				}
				guiScreenFunc_175273_b(pArg[0], (Integer) pArg[1], (Integer) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == guiSlotDrawScreen) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				guiSlotDrawScreen(pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Float) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == guiDrawCenteredString) {
			if (pArg != null
			&& pArg.length > 5
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				guiDrawCenteredString(pArg[0], pArg[1], (String) pArg[2], (Integer) pArg[3], (Integer) pArg[4], (Integer) pArg[5]);
				return true;
			}
			return false;
		}
		if (pIndex == guiScreenActionPerformed) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				guiScreenActionPerformed(pArg[0], pArg[1]);
			}
			return false;
		}
		if (pIndex == guiSlotActionPerformed) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				guiSlotActionPerformed(pArg[0], pArg[1]);
			}
			return false;
		}
		if (pIndex == guiButtonID) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonID(pArg[0], (Integer) pArg[1]);
			}
			return false;
		}
		if (pIndex == renderManagerRenderEntityWithPosYaw) {
			if (pArg != null
			&& pArg.length > 5
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				renderManagerRenderEntityWithPosYaw(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3], (Float) pArg[4], (Float) pArg[5]);
				return true;
			}
			return false;
		}
		if (pIndex == renderManagerItemRendererRenderItem) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					renderManagerItemRendererRenderItem(pArg[0], pArg[1], pArg[2], pArg[3]);
					return true;
				}
				renderManagerItemRendererRenderItem(pArg[0], pArg[1], pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == guiButtonEnabled) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonEnabled(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == guiButtonXPosition) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonXPosition(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == guiButtonYPosition) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonYPosition(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == guiButtonVisible) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonVisible(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == texturedQuadDraw) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				texturedQuadDraw(pArg[0], pArg[1], (Float) pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == entityPlayerInventorySetInventorySlotContents) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null) {
				entityPlayerInventorySetInventorySlotContents(pArg[0], (Integer) pArg[1], pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererAddBox) {
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				modelRendererAddBox(pArg);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererSetRotationPoint) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				modelRendererSetRotationPoint(pArg[0], (Float) pArg[1], (Float) pArg[2], (Float) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererShowModel) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setModelRendererShowModel(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRotateAngleX) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setModelRendererRotateAngleX(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRotateAngleY) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setModelRendererRotateAngleY(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRotateAngleZ) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setModelRendererRotateAngleZ(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRotationPointX) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setModelRendererRotationPointX(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRotationPointY) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setModelRendererRotationPointY(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRotationPointZ) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setModelRendererRotationPointZ(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRender) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				modelRendererRender(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererPostRender) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				modelRendererPostRender(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == modelRendererRenderWithRotation) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				modelRendererRenderWithRotation(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBasePrevHealth) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityLivingBasePrevHealth(pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == itemIconString) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setItemIconString(pArg[0], (String) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == itemItemIcon) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setItemItemIcon(pArg[0], pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == itemStackDamageItem) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				itemStackDamageItem(pArg[0], (Integer) pArg[1], pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == worldSetEntityState) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					worldSetEntityState(pArg[0], pArg[1], (Byte) pArg[2]);
				} else {
					worldSetEntityState(pArg[0], (Byte) pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityLivingBaseDamageEntity) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					entityLivingBaseDamageEntity(pArg[0], pArg[1], (Float) pArg[2]);
				} else {
					entityLivingBaseDamageEntity(pArg[0], (Float) pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == worldPlaySoundAtEntity) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				if (pArg.length > 4
						&& pArg[4] != null) {
					worldPlaySoundAtEntity(pArg[0], pArg[1], (String) pArg[2], (Float) pArg[3], (Float) pArg[4]);
				} else {
					worldPlaySoundAtEntity(pArg[0], (String) pArg[1], (Float) pArg[2], (Float) pArg[3]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == worldSpawnParticle) {
			if (pArg != null
			&& pArg.length > 6
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null
			&& pArg[6] != null) {
				if (pArg.length > 7
						&& pArg[7] != null) {
					worldSpawnParticle(pArg[0], (String) pArg[1], (Double) pArg[2], (Double) pArg[3], (Double) pArg[4], (Double) pArg[5], (Double) pArg[6], (Double) pArg[7]);
				} else {
					worldSpawnParticle((String) pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3], (Double) pArg[4], (Double) pArg[5], (Double) pArg[6]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == rendererLivingEntityPassSpecialRender) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				if (pArg.length > 4
						&& pArg[4] != null) {
					rendererLivingEntityPassSpecialRender(pArg[0], pArg[1], (Double) pArg[2], (Double) pArg[3], (Double) pArg[4]);
				} else {
					rendererLivingEntityPassSpecialRender(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == tileEntitySkullRendererRenderSkull) {
			if (pArg != null
			&& pArg.length > 6
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null) {
				if (pArg.length > 7
						&& pArg[7] != null) {
					if (pArg.length > 8
							&& pArg[8] != null) {
						tileEntitySkullRendererRenderSkull(pArg[0], (Float) pArg[1], (Float) pArg[2], (Float) pArg[3], (Enum) pArg[4], (Float) pArg[5], (Integer) pArg[6], pArg[7], (Integer) pArg[8]);
						return true;
					}
					tileEntitySkullRendererRenderSkull((Float) pArg[0], (Float) pArg[1], (Float) pArg[2], (Enum) pArg[3], (Float) pArg[4], (Integer) pArg[5], pArg[6], (Integer) pArg[7]);
					return true;
				}
				tileEntitySkullRendererRenderSkull((Float) pArg[0], (Float) pArg[1], (Float) pArg[2], (Integer) pArg[3], (Float) pArg[4], (Integer) pArg[5], pArg[6]);
				return true;
			}
			return false;
		}
		if (pIndex == entityPlaySound) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					entityPlaySound(pArg[0], (String) pArg[1], (Float) pArg[2], (Float) pArg[3]);
				} else {
					entityPlaySound((String) pArg[0], (Float) pArg[1], (Float) pArg[2]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == dataWatcherUpdateObject) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					dataWatcherUpdateObject(pArg[0], (Integer) pArg[1], pArg[2]);
				} else {
					dataWatcherUpdateObject((Integer) pArg[0], pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == entityAITasksAddTask) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				entityAITasksAddTask(pArg[0], (Integer) pArg[1], pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == entityBatSetIsBatHanging) {
			Modchu_Debug.lDebug("entityBatSetIsBatHanging");
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				Modchu_Debug.lDebug("entityBatSetIsBatHanging ok pArg[0]="+pArg[0]);
				Modchu_Debug.lDebug("entityBatSetIsBatHanging ok pArg[1]="+pArg[1]);
				entityBatSetIsBatHanging(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			Modchu_Debug.lDebug("entityBatSetIsBatHanging else !! pArg="+pArg);
			Modchu_Debug.lDebug("entityBatSetIsBatHanging else !! pArg.length="+pArg.length);
			return false;
		}
		if (pIndex == entitySetEating) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				entitySetEating(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		}
		if (pIndex == abstractClientPlayerLocationSkin) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				setAbstractClientPlayerLocationSkin(pArg[0], pArg[1]);
				return true;
			}
			setAbstractClientPlayerLocationSkin(pArg[0]);
			return true;
		}
		if (pIndex == abstractClientPlayerLocationCape) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null) {
				abstractClientPlayerLocationCape(pArg[0], pArg[1]);
				return true;
			}
			abstractClientPlayerLocationCape(pArg[0]);
			return true;
		}
		if (pIndex == worldAddEntityToWorld) {
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					worldClientAddEntityToWorld(pArg[0], (Integer) pArg[1], pArg[2]);
				} else {
					worldClientAddEntityToWorld((Integer) pArg[0], pArg[1]);
				}
				return true;
			}
			return false;
		}
		if (pIndex == minecraftLoadingScreen) {
			setMinecraftLoadingScreen(pArg[0]);
			return true;
		}
		if (pIndex == openGlHelperGlBlendFunc) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				openGlHelperGlBlendFunc((Integer) pArg[0],(Integer) pArg[1], (Integer) pArg[2], (Integer) pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == itemModelMesherRegister) {
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				itemModelMesherRegister(pArg[0], pArg[1], (Integer) pArg[2], pArg[3]);
				return true;
			}
			return false;
		}
		if (pIndex == nbtTagCompoundSetTag) {
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				nbtTagCompoundSetTag(pArg[0], (String) pArg[1], pArg[2]);
				return true;
			}
			return false;
		}
		if (pIndex == renderLivingFunc_110827_b) {
			if (pArg != null
			&& pArg.length > 6
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null
			&& pArg[4] != null
			&& pArg[5] != null
			&& pArg[6] != null) {
				renderLivingFunc_110827_b(pArg[0], pArg[1], (Double) pArg[2], (Double) pArg[3], (Double) pArg[4], (Float) pArg[5], (Float) pArg[6]);
				return true;
			}
			return false;
		}
		if (pIndex == minecraftUpdateFramebufferSize) {
			if (pArg != null
					&& pArg.length > 0) {
				minecraftUpdateFramebufferSize(pArg[0]);
			}
			minecraftUpdateFramebufferSize();
			return true;
		}
		Modchu_Debug.mDebug1("Modchu_ASAlmighty setB other return null !! pIndex="+pIndex);
		return false;
	}

	public static boolean getBoolean(int pIndex, Object... pArg) {
		return instance.getBooleanB(null, pIndex, (Object[])pArg);
	}

	public static boolean getBoolean(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Boolean(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public boolean getBooleanB(int pIndex, Object... pArg) {
		return getBooleanB(null, pIndex, (Object[])pArg);
	}

	public boolean getBooleanB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Boolean(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static int getInt(int pIndex, Object... pArg) {
		return instance.getIntB(null, pIndex, (Object[])pArg);
	}

	public static int getInt(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Int(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public int getIntB(int pIndex, Object... pArg) {
		return getIntB(null, pIndex, (Object[])pArg);
	}

	public int getIntB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Int(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static long getLong(int pIndex, Object... pArg) {
		return instance.getLongB(null, pIndex, (Object[])pArg);
	}

	public static long getLong(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Long(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public long getLongB(int pIndex, Object... pArg) {
		return getLongB(null, pIndex, (Object[])pArg);
	}

	public long getLongB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Long(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static byte getByte(int pIndex, Object... pArg) {
		return instance.getByteB(null, pIndex, (Object[])pArg);
	}

	public static byte getByte(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Byte(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public byte getByteB(int pIndex, Object... pArg) {
		return getByteB(null, pIndex, (Object[])pArg);
	}

	public byte getByteB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Byte(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static float getFloat(int pIndex, Object... pArg) {
		return instance.getFloatB(null, pIndex, (Object[])pArg);
	}

	public static float getFloat(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Float(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public float getFloatB(int pIndex, Object... pArg) {
		return getFloatB(null, pIndex, (Object[])pArg);
	}

	public float getFloatB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Float(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static double getDouble(int pIndex, Object... pArg) {
		return instance.getDoubleB(null, pIndex, (Object[])pArg);
	}

	public static double getDouble(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Float(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public double getDoubleB(int pIndex, Object... pArg) {
		return getFloatB(null, pIndex, (Object[])pArg);
	}

	public double getDoubleB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Double(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static String getString(int pIndex, Object... pArg) {
		return instance.getStringB(null, pIndex, (Object[])pArg);
	}

	public static String getString(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.String(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public String getStringB(int pIndex, Object... pArg) {
		return getStringB(null, pIndex, (Object[])pArg);
	}

	public String getStringB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.String(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static List getList(int pIndex, Object... pArg) {
		return instance.getListB(null, pIndex, (Object[])pArg);
	}

	public static List getList(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.List(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public List getListB(int pIndex, Object... pArg) {
		return getListB(null, pIndex, (Object[])pArg);
	}

	public List getListB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.List(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static ArrayList getArrayList(int pIndex, Object... pArg) {
		return instance.getArrayListB(null, pIndex, (Object[])pArg);
	}

	public static ArrayList getArrayList(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ArrayList(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public ArrayList getArrayListB(int pIndex, Object... pArg) {
		return getArrayListB(null, pIndex, (Object[])pArg);
	}

	public ArrayList getArrayListB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ArrayList(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static LinkedList getLinkedList(int pIndex, Object... pArg) {
		return instance.getLinkedListB(null, pIndex, (Object[])pArg);
	}

	public static LinkedList getLinkedList(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.LinkedList(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public LinkedList getLinkedListB(int pIndex, Object... pArg) {
		return getLinkedListB(null, pIndex, (Object[])pArg);
	}

	public LinkedList getLinkedListB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.LinkedList(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static ConcurrentHashMap getConcurrentHashMap(int pIndex, Object... pArg) {
		return instance.getConcurrentHashMapB(null, pIndex, (Object[])pArg);
	}

	public static ConcurrentHashMap getConcurrentHashMap(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ConcurrentHashMap(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public ConcurrentHashMap getConcurrentHashMapB(int pIndex, Object... pArg) {
		return getConcurrentHashMapB(null, pIndex, (Object[])pArg);
	}

	public ConcurrentHashMap getConcurrentHashMapB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ConcurrentHashMap(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static HashMap getHashMap(int pIndex, Object... pArg) {
		return instance.getHashMapB(null, pIndex, (Object[])pArg);
	}

	public static HashMap getHashMap(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.HashMap(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public HashMap getHashMapB(int pIndex, Object... pArg) {
		return getHashMapB(null, pIndex, (Object[])pArg);
	}

	public HashMap getHashMapB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.HashMap(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static Map getMap(int pIndex, Object... pArg) {
		return instance.getMapB(null, pIndex, (Object[])pArg);
	}

	public static Map getMap(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Map(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public Map getMapB(int pIndex, Object... pArg) {
		return getMapB(null, pIndex, (Object[])pArg);
	}

	public Map getMapB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Map(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static Multimap getMultimap(int pIndex, Object... pArg) {
		return instance.getMultimapB(null, pIndex, (Object[])pArg);
	}

	public static Multimap getMultimap(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Multimap(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public Multimap getMultimapB(int pIndex, Object... pArg) {
		return getMultimapB(null, pIndex, (Object[])pArg);
	}

	public Multimap getMultimapB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Multimap(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static Enum getEnum(int pIndex, Object... pArg) {
		return instance.getEnumB(null, pIndex, (Object[])pArg);
	}

	public static Enum getEnum(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Enum(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public Enum getEnumB(int pIndex, Object... pArg) {
		return getEnumB(null, pIndex, (Object[])pArg);
	}

	public Enum getEnumB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Enum(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static File getFile(int pIndex, Object... pArg) {
		return instance.getFileB(null, pIndex, (Object[])pArg);
	}

	public static File getFile(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.File(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public File getFileB(int pIndex, Object... pArg) {
		return getFileB(null, pIndex, (Object[])pArg);
	}

	public File getFileB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.File(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static IntBuffer getIntBuffer(int pIndex, Object... pArg) {
		return instance.getIntBufferB(null, pIndex, (Object[])pArg);
	}

	public static IntBuffer getIntBuffer(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.IntBuffer(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public IntBuffer getIntBufferB(int pIndex, Object... pArg) {
		return getIntBufferB(null, pIndex, (Object[])pArg);
	}

	public IntBuffer getIntBufferB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.IntBuffer(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static UUID getUUID(int pIndex, Object... pArg) {
		return instance.getUUIDB(null, pIndex, (Object[])pArg);
	}

	public static UUID getUUID(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.UUID(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public UUID getUUIDB(int pIndex, Object... pArg) {
		return getUUIDB(null, pIndex, (Object[])pArg);
	}

	public UUID getUUIDB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.UUID(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static int[] getIntArray(int pIndex, Object... pArg) {
		return instance.getIntArrayB(null, pIndex, (Object[])pArg);
	}

	public static int[] getIntArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.IntArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public int[] getIntArrayB(int pIndex, Object... pArg) {
		return getIntArrayB(null, pIndex, (Object[])pArg);
	}

	public int[] getIntArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.IntArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static InputStream getInputStream(int pIndex, Object... pArg) {
		return instance.getInputStreamB(null, pIndex, (Object[])pArg);
	}

	public static InputStream getInputStream(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.InputStream(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public InputStream getInputStreamB(int pIndex, Object... pArg) {
		return getInputStreamB(null, pIndex, (Object[])pArg);
	}

	public InputStream getInputStreamB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.InputStream(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static float[] getFloatArray(int pIndex, Object... pArg) {
		return instance.getFloatArrayB(null, pIndex, (Object[])pArg);
	}

	public static float[] getFloatArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.FloatArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public float[] getFloatArrayB(int pIndex, Object... pArg) {
		return getFloatArrayB(null, pIndex, (Object[])pArg);
	}

	public float[] getFloatArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.FloatArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static double[] getDoubleArray(int pIndex, Object... pArg) {
		return instance.getDoubleArrayB(null, pIndex, (Object[])pArg);
	}

	public static double[] getDoubleArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.DoubleArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public double[] getDoubleArrayB(int pIndex, Object... pArg) {
		return getDoubleArrayB(null, pIndex, (Object[])pArg);
	}

	public double[] getDoubleArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.DoubleArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static byte[] getByteArray(int pIndex, Object... pArg) {
		return instance.getByteArrayB(null, pIndex, (Object[])pArg);
	}

	public static byte[] getByteArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ByteArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public byte[] getByteArrayB(int pIndex, Object... pArg) {
		return getByteArrayB(null, pIndex, (Object[])pArg);
	}

	public byte[] getByteArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ByteArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static String[] getStringArray(int pIndex, Object... pArg) {
		return instance.getStringArrayB(null, pIndex, (Object[])pArg);
	}

	public static String[] getStringArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.StringArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public String[] getStringArrayB(int pIndex, Object... pArg) {
		return getStringArrayB(null, pIndex, (Object[])pArg);
	}

	public String[] getStringArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.StringArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static Object[] getObjectArray(int pIndex, Object... pArg) {
		return instance.getObjectArrayB(null, pIndex, (Object[])pArg);
	}

	public static Object[] getObjectArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ObjectArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public Object[] getObjectArrayB(int pIndex, Object... pArg) {
		return getObjectArrayB(null, pIndex, (Object[])pArg);
	}

	public Object[] getObjectArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ObjectArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static void instanceCheck() {
		if (instance != null); else instance = new Modchu_ASAlmighty();
	}

	protected float[] convertGlColor(int i) {
		float f1 = (float)(i >> 16 & 255) / 255.0F;
		float f2 = (float)(i >> 8 & 255) / 255.0F;
		float f3 = (float)(i & 255) / 255.0F;
		return new float[]{
				f1, f2, f3
		};
	}

	protected Object abstractClientPlayerGetTextureCape() {
		return abstractClientPlayerGetTextureCape(minecraftThePlayer());
	}

	protected Object abstractClientPlayerGetTextureCape(Object entity) {
		return Modchu_Reflect.invokeMethod("AbstractClientPlayer", "func_110310_o", "getTextureCape", entity);
	}

	protected Object abstractClientPlayerGetTextureSkin() {
		return abstractClientPlayerGetTextureSkin(minecraftThePlayer());
	}

	protected Object abstractClientPlayerGetTextureSkin(Object entity) {
		return Modchu_Reflect.invokeMethod("AbstractClientPlayer", "func_110309_l", "getTextureSkin", entity);
	}

	protected Object abstractClientPlayerLocationSkin() {
		return abstractClientPlayerLocationSkin(minecraftThePlayer());
	}

	protected Object abstractClientPlayerLocationSkin(Object entity) {
		return Modchu_Main.getMinecraftVersion() > 179 ? Modchu_Reflect.invokeMethod("AbstractClientPlayer", "func_110306_p", "getLocationSkin", entity) : Modchu_Reflect.getFieldObject("AbstractClientPlayer", "field_110312_d", "locationSkin", entity);
	}

	protected void setAbstractClientPlayerLocationSkin(Object o) {
		setAbstractClientPlayerLocationSkin(minecraftThePlayer(), o);
	}

	protected void setAbstractClientPlayerLocationSkin(Object entity, Object o) {
		Modchu_Reflect.setFieldObject("AbstractClientPlayer", "field_110312_d", "locationSkin", entity, o);
	}

	protected void abstractClientPlayerLocationCape(Object o) {
		abstractClientPlayerLocationCape(minecraftThePlayer(), o);
	}

	protected void abstractClientPlayerLocationCape(Object entity, Object o) {
		Modchu_Reflect.setFieldObject("AbstractClientPlayer", "field_110313_e", "locationCape", entity, o);
	}

	protected String abstractClientPlayerGetSkinType() {
		return abstractClientPlayerGetSkinType(minecraftThePlayer());
	}

	protected String abstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("AbstractClientPlayer", "func_175154_l", abstractClientPlayer));
	}

	protected void allModelInit(Object render, Object entity, boolean b) {
		Modchu_Reflect.invokeMethod(render.getClass(), "allModelInit", new Class[]{ Object.class, boolean.class }, render, new Object[]{ entity, b });
	}

	protected double attributeModifierGetAmount(Object attributeModifier) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod(attributeModifier.getClass(), "func_111164_d", "getAmount", attributeModifier));
	}

	protected Object getBipedArmor(Object entityPlayer, Object itemStack, int i, int i2, String s) {
		if (Modchu_Main.isServer) return null;
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 179) {
			Object render = renderManagerGetEntityRenderObject(entityPlayer);
			if (render != null); else return null;
			List<Object> list = Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(render.getClass(), "field_177097_h", "layerRenderers", render));
			if (list != null
					&& !list.isEmpty()); else return null;
			Object layerArmorBase = null;
			Class LayerArmorBase = Modchu_Reflect.loadClass("LayerArmorBase");
			if (LayerArmorBase != null); else return null;
			for (Object o : list) {
				if (LayerArmorBase.isInstance(o)) {
					layerArmorBase = o;
					break;
				}
			}
			return layerArmorBase != null ? Modchu_Reflect.invokeMethod(layerArmorBase.getClass(), "getArmorResource", new Class[]{ Modchu_Reflect.loadClass("Entity"), Modchu_Reflect.loadClass("ItemStack"), int.class, String.class }, render, new Object[]{ entityPlayer, itemStack, i, s }) : null;
		}
		Object item = itemStackGetItem(itemStack);
		if (Modchu_Reflect.loadClass("ItemArmor").isInstance(item)) {
			int renderIndex = itemArmorRenderIndex(item);
			String[] armorFilename = renderBipedBipedArmorFilenamePrefix();
			if (Modchu_Main.isForge
					&& Modchu_Main.getMinecraftVersion() > 129) {
				String a1 = renderIndex < armorFilename.length ? armorFilename[renderIndex] : armorFilename[armorFilename.length - 1];
				if (version > 164) {
					return Modchu_Reflect.invokeMethod("RenderBiped", "getArmorResource", new Class[]{ Modchu_Reflect.loadClass("Entity"), Modchu_Reflect.loadClass("ItemStack"), int.class, String.class }, new Object[]{ entityPlayer, itemStack, i, s });
				} else if (version > 160) {
					return Modchu_Reflect.invokeMethod("RenderBiped", "func_110858_a", new Class[]{ Modchu_Reflect.loadClass("ItemArmor"), int.class, String.class }, new Object[]{ item, i, s });
				} else if (version > 149) {
					return Modchu_Reflect.invokeMethod("net.minecraftforge.client.ForgeHooksClient", "getArmorTexture", new Class[]{ Modchu_Reflect.loadClass("Entity"), Modchu_Reflect.loadClass("ItemStack"), String.class, int.class, int.class }, new Object[]{ entityPlayer, itemStack, "/armor/" + a1 + "_" + i + ".png", i2, 2 });
				} else {
					return Modchu_Reflect.invokeMethod("net.minecraftforge.client.ForgeHooksClient", "getArmorTexture", new Class[]{ Modchu_Reflect.loadClass("ItemStack"), String.class }, new Object[]{ itemStack, "/armor/" + a1 + "_" + i + ".png" });
				}
			} else {
				if (version > 159) {
					return Modchu_Reflect.invokeMethod("RenderBiped", "func_110857_a", new Class[]{ Modchu_Reflect.loadClass("ItemArmor"), int.class }, new Object[]{ item, i });
				} else {
					String a1 = renderIndex < armorFilename.length ? armorFilename[renderIndex] : armorFilename[armorFilename.length - 1];
					return  "/armor/" + a1 + "_" + i + ".png";
				}
			}
		}
		return null;
	}

	protected Object[] blockBlockList() {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject("Block", "field_71973_m", "blocksList"));
	}

	protected Object blockGetBlockFromItem(Object item) {
		if (item != null); else return null;
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.invokeMethod("Block", "func_149634_a", "getBlockFromItem", new Class[]{ Modchu_Reflect.loadClass("Item") }, null, new Object[]{ item }) : blockBlockList()[itemItemID(item)];
	}

	protected Object blockGetStateFromMeta(Object block, int i) {
		return Modchu_Reflect.invokeMethod("Block", "func_176203_a", "getStateFromMeta", new Class[]{ int.class }, block, new Object[]{ i });
	}

	protected float blockPosGetX(Object blockPos) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod(blockPos.getClass(), "func_177958_n", "getX", blockPos));
	}

	protected float blockPosGetY(Object blockPos) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod(blockPos.getClass(), "func_177956_o", "getY", blockPos));
	}

	protected float blockPosGetZ(Object blockPos) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod(blockPos.getClass(), "func_177952_p", "getZ", blockPos));
	}

	protected void blockSetLightOpacity(Object block, int lightOpacity) {
		Modchu_Reflect.invokeMethod("Block", "func_71868_h", "setLightOpacity", new Class[]{ int.class }, block, new Object[]{ lightOpacity });
	}

	protected int blockGetRenderType(Object block) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Block", "func_71857_b", "getRenderType", block));
	}

	protected int blockGetMetaFromState(Object block, Object iBlockState) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Block", "func_176201_c", "getMetaFromState", new Class[]{ iBlockState.getClass() }, block, new Object[]{ iBlockState }));
	}

	protected int blockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Block", "func_176202_d", "colorMultiplier", new Class[]{ iBlockAccess.getClass(), blockPos.getClass(), int.class }, block, new Object[]{ iBlockAccess, blockPos, i }));
	}

	protected Object blockGetDefaultState(Object block) {
		return Modchu_Reflect.invokeMethod("Block", "func_176223_P", "getDefaultState", block);
	}

	protected void blockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
		Modchu_Reflect.invokeMethod(blockModelRenderer.getClass(), "func_178266_a", new Class[]{ iBakedModel.getClass(), iBlockState.getClass(), float.class, boolean.class }, blockModelRenderer, new Object[]{ iBakedModel, iBlockState, f, b });
	}

	protected void blockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
		Modchu_Reflect.invokeMethod(blockRendererDispatcher.getClass(), "func_175016_a", new Class[]{ iBlockState.getClass(), float.class }, blockRendererDispatcher, new Object[]{ iBlockState, f });
	}

	protected Object blockRendererDispatcherGetBakedModel(Object blockRendererDispatcher, Object iBlockState, Object blockPos) {
		return Modchu_Reflect.invokeMethod(blockRendererDispatcher.getClass(), "func_175017_a", "getBakedModel", new Class[]{ Modchu_Reflect.loadClass("IBlockState"), Modchu_Reflect.loadClass("BlockPos") }, blockRendererDispatcher, new Object[]{ iBlockState, blockPos });
	}

	protected Object blockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return Modchu_Reflect.invokeMethod(blockRendererDispatcher.getClass(), "func_175019_b", blockRendererDispatcher);
	}

	protected Object blockDoublePlantVARIANT() {
		return Modchu_Reflect.invokeMethod("BlockDoublePlant", "field_176493_a", "VARIANT_PROP");
	}

	protected Object blockDoublePlantHALF() {
		return Modchu_Reflect.invokeMethod("BlockDoublePlant", "field_176492_b", "HALF_PROP");
	}

	protected Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return Modchu_Reflect.invokeMethod("AxisAlignedBB", "func_75071_a", "getBoundingBox", new Class[]{ double.class, double.class, double.class, double.class, double.class, double.class }, new Object[]{ d, d1, d2, d3, d4, d5 });
	}

	protected Object axisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return Modchu_Reflect.invokeMethod("AxisAlignedBB", "func_72314_b", "expand", new Class[]{ double.class, double.class, double.class }, axisAlignedBB, new Object[]{ d, d1, d2 });
	}

	protected Object axisAlignedBBCalculateIntercept(Object axisAlignedBB, Object vec3, Object vec3_2) {
		return Modchu_Reflect.invokeMethod("AxisAlignedBB", "func_72327_a", "calculateIntercept", new Class[]{ Modchu_Reflect.loadClass("Vec3"), Modchu_Reflect.loadClass("Vec3") }, axisAlignedBB, new Object[]{ vec3, vec3_2 });
	}

	protected boolean axisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("AxisAlignedBB", "func_72318_a", "isVecInside", new Class[]{ Modchu_Reflect.loadClass("Vec3") }, axisAlignedBB, new Object[]{ vec3 }));
	}

	protected Object damageSourceAnvil() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_82728_o", "anvil");
	}

	protected Object damageSourceCactus() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76367_g", "cactus");
	}

	protected Object damageSourceDrown() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76369_e", "drown");
	}

	protected Object damageSourceFall() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76379_h", "fall");
	}

	protected Object damageSourceFallingBlock() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_82729_p", "fallingBlock");
	}

	protected Object damageSourceGeneric() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76377_j", "generic");
	}

	protected Object damageSourceInFire() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76372_a", "inFire");
	}

	protected Object damageSourceInWall() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76368_d", "inWall");
	}

	protected Object damageSourceLava() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76371_c", "lava");
	}

	protected Object damageSourceMagic() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76376_m", "magic");
	}

	protected Object damageSourceOnFire() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76370_b", "onFire");
	}

	protected Object damageSourceOutOfWorld() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76380_i", "outOfWorld");
	}

	protected Object damageSourceStarve() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76366_f", "starve");
	}

	protected Object damageSourceWither() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_82727_n", "wither");
	}

	protected Object damageSourceGetEntity(Object damageSource) {
		return Modchu_Reflect.invokeMethod("DamageSource", "func_76346_g", "getEntity", damageSource);
	}

	protected boolean damageSourceIsFireDamage(Object damageSource) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("DamageSource", "func_76347_k", "isFireDamage", damageSource));
	}

	protected Object damageSourceCauseMobDamage(Object entityLivingBase) {
		return Modchu_Reflect.invokeMethod("DamageSource", "func_76358_a", "causeMobDamage", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase") }, new Object[]{ entityLivingBase });
	}

	protected Object potionMoveSpeed() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76424_c", "moveSpeed");
	}

	protected Object potionMoveSlowdown() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76421_d", "moveSlowdown");
	}

	protected Object potionDigSpeed() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76422_e", "digSpeed");
	}

	protected Object potionDigSlowdown() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76419_f", "digSlowdown");
	}

	protected Object potionDamageBoost() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76420_g", "damageBoost");
	}

	protected Object potionHeal() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76432_h", "heal");
	}

	protected Object potionHarm() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76433_i", "harm");
	}

	protected Object potionJump() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76430_j", "jump");
	}

	protected Object potionConfusion() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76431_k", "confusion");
	}

	protected Object potionRegeneration() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76428_l", "regeneration");
	}

	protected Object potionResistance() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76429_m", "resistance");
	}

	protected Object potionFireResistance() {
		return Modchu_Reflect.invokeMethod("Potion", "field_70174_ab", "fireResistance");
	}

	protected Object potionWaterBreathing() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76427_o", "waterBreathing");
	}

	protected Object potionInvisibility() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76427_o", "invisibility");
	}

	protected Object potionBlindness() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76440_q", "blindness");
	}

	protected Object potionNightVision() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76439_r", "nightVision");
	}

	protected Object potionHunger() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76438_s", "hunger");
	}

	protected Object potionWeakness() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76437_t", "weakness");
	}

	protected Object potionPoison() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76436_u", "poison");
	}

	protected Object potionWither() {
		return Modchu_Reflect.invokeMethod("Potion", "field_82731_v", "wither");
	}

	protected Object potionHealthBoost() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76434_w");
	}

	protected Object potionAbsorption() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76444_x");
	}

	protected Object potionSaturation() {
		return Modchu_Reflect.invokeMethod("Potion", "field_76443_y");
	}

	protected Object entityLivingCurrentTarget() {
		return entityLivingCurrentTarget(minecraftThePlayer());
	}

	protected Object entityLivingCurrentTarget(Object entityLivingBase) {
		return Modchu_Main.getMinecraftVersion() < 180 ? Modchu_Reflect.getFieldObject("EntityLiving", "field_70776_bF", "currentTarget", entityLivingBase) : null;
	}

	protected Object entityAnimalInLove() {
		return entityAnimalInLove(minecraftThePlayer());
	}

	protected Object entityAnimalInLove(Object entityLivingBase) {
		return Modchu_Reflect.getFieldObject("EntityAnimal", "field_70881_d", "inLove", entityLivingBase);
	}

	protected void setEntityAnimalInLove(int i) {
		setEntityAnimalInLove(minecraftThePlayer(), i);
	}

	protected void setEntityAnimalInLove(Object entityLivingBase, int i) {
		Modchu_Reflect.setFieldObject("EntityAnimal", "field_70881_d", "inLove", entityLivingBase, i, 0);
	}

	protected Object entityLivingBaseGetEquipmentInSlot(int i) {
		return entityLivingBaseGetEquipmentInSlot(minecraftThePlayer(), i);
	}

	protected Object entityLivingBaseGetEquipmentInSlot(Object entityLivingBase, int i) {
		return Modchu_Reflect.invokeMethod("EntityLivingBase", "func_71124_b", "getEquipmentInSlot", new Class[]{ int.class }, entityLivingBase, new Object[]{ i });
	}

	protected Object entityArrowShootingEntity(Object entityArrow) {
		return Modchu_Reflect.getFieldObject("EntityArrow", "field_70250_c", "shootingEntity", entityArrow);
	}

	protected void entityAttackEntityFrom(Object damageSource, float f) {
		entityAttackEntityFrom(minecraftThePlayer(), damageSource, f);
	}

	protected void entityAttackEntityFrom(Object entity, Object damageSource, float f) {
		Modchu_Reflect.invokeMethod("Entity", "func_70097_a", "attackEntityFrom", new Class[]{ Modchu_Reflect.loadClass("DamageSource"), float.class }, entity, new Object[]{ damageSource, f });
	}

	protected int entityLivingBaseEntityAge() {
		return entityLivingBaseEntityAge(minecraftThePlayer());
	}

	protected int entityLivingBaseEntityAge(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70708_bq", "entityAge", entity));
	}

	protected Object entityLivingBaseGetLook(float f) {
		return entityLivingBaseGetLook(minecraftThePlayer(), f);
	}

	protected Object entityLivingBaseGetLook(Object entityLivingBase, float f) {
		return Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70676_i", "getLook", new Class[]{ float.class }, entityLivingBase, new Object[]{ f });
	}

	protected void setEntityLivingBaseEntityAge(int i) {
		setEntityLivingBaseEntityAge(minecraftThePlayer(), i);
	}

	protected void setEntityLivingBaseEntityAge(Object entity, int i) {
		if (Modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70708_bq", "entityAge", entity, i, 0);
	}

	protected Object entityBoundingBox() {
		return entityBoundingBox(minecraftThePlayer());
	}

	protected Object entityBoundingBox(Object entity) {
		return Modchu_Reflect.getFieldObject("Entity", "field_70121_D", "boundingBox", entity);
	}

	protected double entityBoundingBoxMaxX() {
		return entityBoundingBoxMaxY(minecraftThePlayer());
	}

	protected double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		Object boundingBox = Modchu_Reflect.loadClass("Entity").isInstance(entityOrBoundingBox) ? entityBoundingBox(entityOrBoundingBox) : entityOrBoundingBox;
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(boundingBox.getClass(), "field_72336_d", "maxX", boundingBox));
	}

	protected double entityBoundingBoxMaxY() {
		return entityBoundingBoxMaxY(minecraftThePlayer());
	}

	protected double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		Object boundingBox = Modchu_Reflect.loadClass("Entity").isInstance(entityOrBoundingBox) ? entityBoundingBox(entityOrBoundingBox) : entityOrBoundingBox;
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(boundingBox.getClass(), "field_72337_e", "maxY", boundingBox));
	}

	protected double entityBoundingBoxMaxZ() {
		return entityBoundingBoxMaxY(minecraftThePlayer());
	}

	protected double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		Object boundingBox = Modchu_Reflect.loadClass("Entity").isInstance(entityOrBoundingBox) ? entityBoundingBox(entityOrBoundingBox) : entityOrBoundingBox;
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(boundingBox.getClass(), "field_72334_f", "maxZ", boundingBox));
	}

	protected double entityBoundingBoxMinX() {
		return entityBoundingBoxMinY(minecraftThePlayer());
	}

	protected double entityBoundingBoxMinX(Object entity) {
		Object boundingBox = entityBoundingBox(entity);
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(boundingBox.getClass(), "field_72340_a", "minX", boundingBox));
	}

	protected double entityBoundingBoxMinY() {
		return entityBoundingBoxMinY(minecraftThePlayer());
	}

	protected double entityBoundingBoxMinY(Object entity) {
		Object boundingBox = entityBoundingBox(entity);
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(boundingBox.getClass(), "field_72338_b", "minY", boundingBox));
	}

	protected double entityBoundingBoxMinZ() {
		return entityBoundingBoxMinY(minecraftThePlayer());
	}

	protected double entityBoundingBoxMinZ(Object entity) {
		Object boundingBox = entityBoundingBox(entity);
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(boundingBox.getClass(), "field_72339_c", "minZ", boundingBox));
	}

	protected String entityCloakUrl() {
		return entityCloakUrl(minecraftThePlayer());
	}

	protected String entityCloakUrl(Object entity) {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("Entity", "field_622_aY", "cloakUrl", entity));
	}

	protected int entityDimension() {
		return entityDimension(minecraftThePlayer());
	}

	protected int entityDimension(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", "field_71093_bK", "dimension", entity));
	}

	protected void setEntityDimension(int i) {
		setEntityDimension(minecraftThePlayer(), i);
	}

	protected void setEntityDimension(Object entity, int i) {
		Modchu_Reflect.setFieldObject("Entity", "field_71093_bK", "dimension", entity, i);
	}

	protected float entityDistanceWalkedModified() {
		return entityDistanceWalkedModified(minecraftThePlayer());
	}

	protected float entityDistanceWalkedModified(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70140_Q", "distanceWalkedModified", entity));
	}

	protected int entityEntityID() {
		return entityEntityID(minecraftThePlayer());
	}

	protected int entityEntityID(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", Modchu_Main.getMinecraftVersion() > 169 ? "field_145783_c" : "field_73319_a", "entityId", entity));
	}

	protected float entityGetBrightness(float f) {
		return entityGetBrightness(minecraftThePlayer(), f);
	}

	protected float entityGetBrightness(Object entity, float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("Entity", "func_70013_c", "getBrightness", new Class[]{ float.class }, entity, new Object[]{ f }));
	}

	protected int entityGetBrightnessForRender(float f) {
		return entityGetBrightnessForRender(minecraftThePlayer(), f);
	}

	protected int entityGetBrightnessForRender(Object entity, float f) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Entity", "func_70070_b", "getBrightnessForRender", new Class[]{ float.class }, entity, new Object[]{ f }));
	}

	protected Object entityGetDataWatcher() {
		return entityGetDataWatcher(minecraftThePlayer());
	}

	protected Object entityGetDataWatcher(Object dataWatcherOrEntity) {
		return Modchu_Reflect.loadClass("DataWatcher").isInstance(dataWatcherOrEntity) ? dataWatcherOrEntity : Modchu_Reflect.invokeMethod("Entity", "func_70096_w", "getDataWatcher", dataWatcherOrEntity);
	}

	protected void entitySetCustomNameTag(String s) {
		entitySetCustomNameTag(minecraftThePlayer(), s);
	}

	protected void entitySetCustomNameTag(Object entity, String s) {
		Modchu_Reflect.invokeMethod("Entity", "func_94058_c", "setCustomNameTag", new Class[]{ String.class }, entity, new Object[]{ s });
	}

	protected Object dataWatcherGetWatchedObject(int i) {
		return dataWatcherGetWatchedObject(minecraftThePlayer(), i);
	}

	protected Object dataWatcherGetWatchedObject(Object dataWatcherOrEntity, int i) {
		Object dataWatcher = entityGetDataWatcher(dataWatcherOrEntity);
		Object o = Modchu_Reflect.invokeMethod("DataWatcher", "func_75691_i", "getWatchedObject", new Class[]{ int.class }, dataWatcher, new Object[]{ i });
		return o != null ? Modchu_Reflect.invokeMethod(o.getClass(), "func_75669_b", "getObject", o) : null;
	}

	protected void dataWatcherAddObject(int i, Object o) {
		dataWatcherAddObject(minecraftThePlayer(), i, o);
	}

	protected void dataWatcherAddObject(Object dataWatcherOrEntity, int i, Object o) {
		Modchu_Reflect.invokeMethod("DataWatcher", "func_75682_a", "addObject", new Class[]{ int.class, Object.class }, entityGetDataWatcher(dataWatcherOrEntity), new Object[]{ i, o });
	}

	protected Object dataWatcherGetWatchableObjectItemStack(int i) {
		return dataWatcherGetWatchableObjectItemStack(minecraftThePlayer(), i);
	}

	protected Object dataWatcherGetWatchableObjectItemStack(Object dataWatcherOrEntity, int i) {
		return Modchu_Reflect.invokeMethod("DataWatcher", "func_82710_f", "getWatchableObjectItemStack", new Class[]{ int.class }, entityGetDataWatcher(dataWatcherOrEntity), new Object[]{ i });
	}

	protected String dataWatcherGetWatchableObjectString(int i) {
		return dataWatcherGetWatchableObjectString(minecraftThePlayer(), i);
	}

	protected String dataWatcherGetWatchableObjectString(Object dataWatcherOrEntity, int i) {
		return Modchu_CastHelper.String(dataWatcherGetWatchedObject(dataWatcherOrEntity, i));
	}

	protected byte dataWatcherGetWatchableObjectByte(int i) {
		return dataWatcherGetWatchableObjectByte(minecraftThePlayer(), i);
	}

	protected byte dataWatcherGetWatchableObjectByte(Object dataWatcherOrEntity, int i) {
		return Modchu_CastHelper.Byte(dataWatcherGetWatchedObject(dataWatcherOrEntity, i));
	}

	protected void dataWatcherUpdateObject(int i, Object o) {
		dataWatcherUpdateObject(minecraftThePlayer(), i, o);
	}

	protected void dataWatcherUpdateObject(Object dataWatcherOrEntity, int i, Object o) {
		if (dataWatcherGetWatchedObject(dataWatcherOrEntity, i) != null) Modchu_Reflect.invokeMethod("DataWatcher", "func_75692_b", "updateObject", new Class[]{ int.class, Object.class }, entityGetDataWatcher(dataWatcherOrEntity), new Object[]{ i, o });
		else dataWatcherAddObject(dataWatcherOrEntity, i, o);
	}

	protected void entityAITasksAddTask(Object entityAITasks, int i, Object entityAIBase) {
		Modchu_Reflect.invokeMethod("EntityAITasks", "func_75776_a", "addTask", new Class[]{ int.class, Modchu_Reflect.loadClass("EntityAIBase") }, entityAITasks, new Object[]{ i, entityAIBase });
	}

	protected float entityGetEyeHeight() {
		return entityGetEyeHeight(minecraftThePlayer());
	}

	protected float entityGetEyeHeight(Object entityplayer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityPlayer", "func_70047_e", "getEyeHeight", entityplayer));
	}

	protected float entityHeight() {
		return entityHeight(minecraftThePlayer());
	}

	protected float entityHeight(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70131_O", "height", entity));
	}

	protected boolean entityIsInvisible() {
		return entityIsInvisible(minecraftThePlayer());
	}

	protected boolean entityIsInvisible(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_82150_aj", "isInvisible", entity));
	}

	protected boolean entityIsInWater() {
		return entityIsInWater(minecraftThePlayer());
	}

	protected boolean entityIsInWater(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70090_H", "isInWater", entity));
	}

	protected boolean entityIsRiding() {
		return entityIsRiding(minecraftThePlayer());
	}

	protected boolean entityIsRiding(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70115_ae", "isRiding", entity));
	}

	protected boolean entityIsSneaking() {
		return entityIsSneaking(minecraftThePlayer());
	}

	protected boolean entityIsSneaking(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70093_af", "isSneaking", entity));
	}

	protected boolean entityIsWet() {
		return entityIsWet(minecraftThePlayer());
	}

	protected boolean entityIsWet(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70026_G", "isWet", entity));
	}

	protected void entityOnUpdate(Object entity) {
		Modchu_Reflect.invokeMethod("Entity", "func_70071_h_", "onUpdate", entity);
	}

	protected void entityMountEntity(Object entity) {
		entityMountEntity(minecraftThePlayer(), entity);
	}

	protected void entityMountEntity(Object entity, Object entity2) {
		Modchu_Reflect.invokeMethod("Entity", "func_70078_a", "mountEntity", new Class[]{ Modchu_Reflect.loadClass("Entity") }, entity, new Object[]{ entity2 });
	}

	protected Object entityLivingTasks(Object entityLiving) {
		return Modchu_Reflect.getFieldObject("EntityLiving", "field_70714_bg", "tasks", entityLiving);
	}

	protected void entityLivingBaseSetPositionAndUpdate(double x, double y, double z) {
		entityLivingBaseSetPositionAndUpdate(minecraftThePlayer(), x, y, z);
	}

	protected void entityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70634_a", "setPositionAndUpdate", new Class[]{ double.class, double.class, double.class }, entity, new Object[]{ x, y, z });
	}

	protected Map entityListStringToClassMapping() {
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject("EntityList", "field_75625_b", "stringToClassMapping"));
	}

	protected Map entityListClassToStringMapping() {
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject("EntityList", "field_75626_c", "classToStringMapping"));
	}

	protected Map entityListIDtoClassMapping() {
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject("EntityList", "field_75623_d", "idToClassMapping"));
	}

	protected Map entityListClassToIDMapping() {
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject("EntityList", "field_75624_e", "classToIDMapping"));
	}

	protected void entitySetLocationAndAngles(double x, double y, double z, float f, float f1) {
		entitySetLocationAndAngles(minecraftThePlayer(), x, y, z, f, f1);
	}

	protected void entitySetLocationAndAngles(Object entity, double x, double y, double z, float f, float f1) {
		Modchu_Reflect.invokeMethod("Entity", "func_70012_b", "setLocationAndAngles", new Class[]{ double.class, double.class, double.class, float.class, float.class }, entity, new Object[]{ x, y, z, f, f1 });
	}

	protected void entitySetPositionAndRotation(double x, double y, double z, float f, float f1) {
		entitySetPositionAndRotation(minecraftThePlayer(), x, y, z, f, f1);
	}

	protected void entitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		Modchu_Reflect.invokeMethod("Entity", "func_70056_a", "setPositionAndRotation", new Class[]{ double.class, double.class, double.class, float.class, float.class }, entity, new Object[]{ x, y, z, f, f1 });
	}

	protected int entityAnimalBreeding() {
		return entityAnimalBreeding(minecraftThePlayer());
	}

	protected int entityAnimalBreeding(Object entityAnimal) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityAnimal", "field_70882_e", "breeding", entityAnimal));
	}

	protected void setEntityAnimalBreeding(int i) {
		setEntityAnimalBreeding(minecraftThePlayer(), i);
	}

	protected void setEntityAnimalBreeding(Object entityAnimal, int i) {
		Modchu_Reflect.setFieldObject("EntityAnimal", "field_70882_e", "breeding", entityAnimal, i, 0);
	}

	protected boolean entityCreatureHasAttacked() {
		return entityCreatureHasAttacked(minecraftThePlayer());
	}

	protected boolean entityCreatureHasAttacked(Object entity) {
		return Modchu_Main.getMinecraftVersion() < 180 ? Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("EntityCreature", "field_70787_b", "hasAttacked", entity)) : false;
	}

	protected void setEntityCreatureHasAttacked(boolean b) {
		setEntityCreatureHasAttacked(minecraftThePlayer(), b);
	}

	protected void setEntityCreatureHasAttacked(Object entity, boolean b) {
		if (Modchu_Main.getMinecraftVersion() < 180) Modchu_Reflect.setFieldObject("EntityCreature", "field_70787_b", "hasAttacked", entity, b);
	}

	protected float entityGetDistanceToEntity(Object entity) {
		return entityGetDistanceToEntity(minecraftThePlayer(), entity);
	}

	protected float entityGetDistanceToEntity(Object entity, Object entity2) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("Entity", "func_70032_d", "getDistanceToEntity", new Class[]{ Modchu_Reflect.loadClass("Entity") }, entity, new Object[]{ entity2 }));
	}

	protected boolean entityIsEntityAlive() {
		return entityIsEntityAlive(minecraftThePlayer());
	}

	protected boolean entityIsEntityAlive(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70089_S", "isEntityAlive", entity));
	}

	protected Object entityCreatureEntityToAttack() {
		return entityCreatureEntityToAttack(minecraftThePlayer());
	}

	protected Object entityCreatureEntityToAttack(Object entity) {
		return Modchu_Main.getMinecraftVersion() < 180 ? Modchu_Reflect.getFieldObject("EntityCreature", "field_70789_a", "entityToAttack", entity) : null;
	}

	protected int entityLivingNumTicksToChaseTarget() {
		return entityLivingNumTicksToChaseTarget(minecraftThePlayer());
	}

	protected int entityLivingNumTicksToChaseTarget(Object entityLiving) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLiving", "field_70700_bx", "numTicksToChaseTarget", entityLiving));
	}

	protected void setEntityLivingNumTicksToChaseTarget(int i) {
		setEntityLivingNumTicksToChaseTarget(minecraftThePlayer(), i);
	}

	protected void setEntityLivingNumTicksToChaseTarget(Object entityLiving, int i) {
		Modchu_Reflect.setFieldObject("EntityLiving", "field_70700_bx", "numTicksToChaseTarget", entityLiving, i, 0);
	}

	protected Object entityCreatureGetEntityToAttack() {
		return entityCreatureGetEntityToAttack(minecraftThePlayer());
	}

	protected Object entityCreatureGetEntityToAttack(Object entity) {
		return Modchu_Main.getMinecraftVersion() < 180 ? Modchu_Reflect.invokeMethod("EntityCreature", "func_70777_m", "getEntityToAttack", entity) : null;
	}

	protected void setEntityCreatureEntityToAttack(Object entity) {
		setEntityCreatureEntityToAttack(minecraftThePlayer(), entity);
	}

	protected void setEntityCreatureEntityToAttack(Object entity, Object entity2) {
		if (Modchu_Main.getMinecraftVersion() < 180) Modchu_Reflect.setFieldObject("EntityCreature", "field_70789_a", "entityToAttack", entity, entity2);
	}

	protected void entityClientPlayerMPFunc_142020_c(String s) {
		entityClientPlayerMPFunc_142020_c(minecraftThePlayer(), s);
	}

	protected void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
		Modchu_Reflect.invokeMethod("EntityClientPlayerMP", "func_142020_c", new Class[]{ String.class }, entityClientPlayerMP, new Object[]{ s });
	}

	protected String entityClientPlayerMPFunc_142021_k() {
		return entityClientPlayerMPFunc_142021_k(minecraftThePlayer());
	}

	protected String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("EntityClientPlayerMP", "func_142021_k", entityClientPlayerMP));
	}

	protected void entityCreatureSetPathToEntity(Object entityPath) {
		entityCreatureSetPathToEntity(minecraftThePlayer(), entityPath);
	}

	protected void entityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
		Modchu_Reflect.invokeMethod("EntityCreature", "func_70778_a", "setPathToEntity", new Class[]{ entityPath.getClass() }, entityCreature, new Object[]{ entityPath });
	}

	protected float entityLivingBaseGetSoundVolume() {
		return entityLivingBaseGetSoundVolume(minecraftThePlayer());
	}

	protected float entityLivingBaseGetSoundVolume(Object entityLivingBase) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70599_aP", "getSoundVolume", entityLivingBase));
	}

	protected float entityLivingBaseGetSoundPitch() {
		return entityLivingBaseGetSoundPitch(minecraftThePlayer());
	}

	protected float entityLivingBaseGetSoundPitch(Object entityLivingBase) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70647_i", "getSoundPitch", entityLivingBase));
	}

	protected float entityLastDamage() {
		return entityLastDamage(minecraftThePlayer());
	}

	protected float entityLastDamage(Object entityLivingBase) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_110153_bc", "lastDamage", entityLivingBase));
	}

	protected int entityLivingBaseRecentlyHit() {
		return entityLivingBaseRecentlyHit(minecraftThePlayer());
	}

	protected int entityLivingBaseRecentlyHit(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70718_bc", "recentlyHit", entityLivingBase));
	}

	protected void setEntityLivingBaseRecentlyHit(int i) {
		setEntityLivingBaseRecentlyHit(minecraftThePlayer(), i);
	}

	protected void setEntityLivingBaseRecentlyHit(Object entityLivingBase, int i) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70718_bc", "recentlyHit", entityLivingBase, i, 0);
	}

	protected int entityLivingBaseAttackingPlayer() {
		return entityLivingBaseAttackingPlayer(minecraftThePlayer());
	}

	protected int entityLivingBaseAttackingPlayer(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70717_bb", "attackingPlayer", entityLivingBase));
	}

	protected void setEntityLivingBaseAttackingPlayer(Object entityLivingBase) {
		setEntityLivingBaseAttackingPlayer(minecraftThePlayer(), entityLivingBase);
	}

	protected void setEntityLivingBaseAttackingPlayer(Object entityLivingBase, Object entityLivingBase2) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70717_bb", "attackingPlayer", entityLivingBase, entityLivingBase2);
	}

	protected int entityLivingBaseDeathTime() {
		return entityLivingBaseDeathTime(minecraftThePlayer());
	}

	protected int entityLivingBaseDeathTime(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70725_aQ", "deathTime", entityLivingBase));
	}

	protected int entityLivingBaseMaxHurtResistantTime() {
		return entityLivingBaseMaxHurtResistantTime(minecraftThePlayer());
	}

	protected int entityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70771_an", "maxHurtResistantTime", entityLivingBase));
	}

	protected void setEntityLivingBaseMaxHurtResistantTime(int i) {
		setEntityLivingBaseMaxHurtResistantTime(minecraftThePlayer(), i);
	}

	protected void setEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70771_an", "maxHurtResistantTime", entityLivingBase, i, 0);
	}

	protected int entityHurtResistantTime() {
		return entityHurtResistantTime(minecraftThePlayer());
	}

	protected int entityHurtResistantTime(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", "field_70172_ad", "hurtResistantTime", entity));
	}

	protected void setEntityHurtResistantTime(int i) {
		setEntityHurtResistantTime(minecraftThePlayer(), i);
	}

	protected void setEntityHurtResistantTime(Object entity, int i) {
		Modchu_Reflect.setFieldObject("Entity", "field_70172_ad", "hurtResistantTime", entity, i, 0);
	}

	protected UUID entityGetUniqueID() {
		return entityGetUniqueID(minecraftThePlayer());
	}

	protected UUID entityGetUniqueID(Object entity) {
		return Modchu_CastHelper.UUID(Modchu_Reflect.invokeMethod("Entity", "func_110124_au", "getUniqueID", entity));
	}

	protected Object entityLivingBaseGetHeldItem() {
		return entityLivingBaseGetHeldItem(minecraftThePlayer());
	}

	protected Object entityLivingBaseGetHeldItem(Object entityLivingBase) {
		return Modchu_Reflect.getFieldObject("EntityLivingBase", "func_70694_bm", "getHeldItem", entityLivingBase);
	}

	protected float entityLivingBaseGetHealth() {
		return entityLivingBaseGetHealth(minecraftThePlayer());
	}

	protected float entityLivingBaseGetHealth(Object entity) {
		if (Modchu_Main.getMinecraftVersion() < 130) return entityLivingGetHealth(entity);
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_110143_aJ", "getHealth", entity));
	}

	protected float entityLivingBaseGetMaxHealth() {
		return entityLivingBaseGetMaxHealth(minecraftThePlayer());
	}

	protected float entityLivingBaseGetMaxHealth(Object entity) {
		if (Modchu_Main.getMinecraftVersion() < 130) return entityLivingGetMaxHealth(entity);
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_110138_aP", "getMaxHealth", entity));
	}

	protected void entityLivingBaseDamageEntity(Object damageSource, float f) {
		entityLivingBaseDamageEntity(minecraftThePlayer(), damageSource, f);
	}

	protected void entityLivingBaseDamageEntity(Object entity, Object damageSource, float f) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70665_d", "damageEntity", new Class[]{ Modchu_Reflect.loadClass("DamageSource"), float.class }, entity, new Object[]{ damageSource, f });
	}

	protected void entityLivingBaseHeal(float f) {
		entityLivingBaseHeal(minecraftThePlayer(), f);
	}

	protected void entityLivingBaseHeal(Object entityLivingBase, float f) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70691_i", "heal", new Class[]{ float.class }, entityLivingBase, new Object[]{ f });
	}

	protected void entityLivingBaseSetRevengeTarget(Object entity) {
		entityLivingBaseSetRevengeTarget(minecraftThePlayer(), entity);
	}

	protected void entityLivingBaseSetRevengeTarget(Object entity, Object entity2) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70604_c", "setRevengeTarget", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase") }, entity, new Object[]{ entity2 });
	}

	protected float entityLivingBaseGetSwingProgress(float f) {
		return entityLivingBaseGetSwingProgress(minecraftThePlayer(), f);
	}

	protected float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70678_g", "getSwingProgress", new Class[]{ float.class }, entity, new Object[]{ f }));
	}

	protected float entityLivingBaseHealth() {
		return entityLivingBaseHealth(minecraftThePlayer());
	}

	protected float entityLivingBaseHealth(Object entity) {
		if (Modchu_Main.getMinecraftVersion() > 159) {
			return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("DataWatcher", "func_111145_d", "getWatchableObjectFloat", new Class[]{ int.class }, entityGetDataWatcher(entity), new Object[]{ 6 }));
		}
		if (Modchu_Main.getMinecraftVersion() > 129) return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70734_aK", "health", entity));
		return entityLivingGetHealth(entity);
	}

	protected boolean entityLivingBaseIsJumping() {
		return entityLivingBaseIsJumping(minecraftThePlayer());
	}

	protected boolean entityLivingBaseIsJumping(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70703_bu", "isJumping", entity));
	}

	protected float entityLivingBaseLimbSwing() {
		return entityLivingBaseLimbSwing(minecraftThePlayer());
	}

	protected float entityLivingBaseLimbSwing(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70754_ba", "limbSwing", entity));
	}

	protected void setEntityLivingBaseLimbSwing(float f) {
		setEntityLivingBaseLimbSwing(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseLimbSwing(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70754_ba", "limbSwing", entity, f);
	}

	protected float entityLivingBaseLimbSwingAmount() {
		return entityLivingBaseLimbSwingAmount(minecraftThePlayer());
	}

	protected float entityLivingBaseLimbSwingAmount(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70721_aZ", Modchu_Main.getMinecraftVersion() > 159 ? "limbSwingAmount" : "limbYaw", entity));
	}

	protected void setEntityLivingBaseLimbSwingAmount(float f) {
		setEntityLivingBaseLimbSwingAmount(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70721_aZ", Modchu_Main.getMinecraftVersion() > 159 ? "limbSwingAmount" : "limbYaw", entity, f);
	}

	protected float entityLivingBaseMoveForward() {
		return entityLivingBaseMoveForward(minecraftThePlayer());
	}

	protected float entityLivingBaseMoveForward(Object entityplayer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70701_bs", "moveForward", entityplayer));
	}

	protected void setEntityLivingBaseMoveForward(float f) {
		setEntityLivingBaseMoveForward(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseMoveForward(Object entityplayer, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70701_bs", "moveForward", entityplayer, f);
	}

	protected float entityLivingBaseMoveStrafing() {
		return entityLivingBaseMoveStrafing(minecraftThePlayer());
	}

	protected float entityLivingBaseMoveStrafing(Object entityplayer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70702_br", "moveStrafing", entityplayer));
	}

	protected void setEntityLivingBaseMoveStrafing(float f) {
		setEntityLivingBaseMoveStrafing(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseMoveStrafing(Object entityplayer, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70702_br", "moveStrafing", entityplayer, f);
	}

	protected float entityLivingBasePrevLimbSwingAmount() {
		return entityLivingBasePrevLimbSwingAmount(minecraftThePlayer());
	}

	protected float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70722_aY", Modchu_Main.getMinecraftVersion() > 159 ? "prevLimbSwingAmount" : "prevLimbYaw", entity));
	}

	protected void setEntityLivingBasePrevLimbSwingAmount(float f) {
		setEntityLivingBasePrevLimbSwingAmount(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70722_aY", Modchu_Main.getMinecraftVersion() > 159 ? "prevLimbSwingAmount" : "prevLimbYaw", entity, f);
	}

	protected float entityLivingBasePrevRenderYawOffset() {
		return entityLivingBasePrevRenderYawOffset(minecraftThePlayer());
	}

	protected float entityLivingBasePrevRenderYawOffset(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70760_ar", "prevRenderYawOffset", entity));
	}

	protected void setEntityLivingBasePrevRenderYawOffset(float f) {
		setEntityLivingBasePrevRenderYawOffset(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70760_ar", "prevRenderYawOffset", entity, f);
	}

	protected float entityLivingBasePrevRotationYawHead() {
		return entityLivingBasePrevRotationYawHead(minecraftThePlayer());
	}

	protected float entityLivingBasePrevRotationYawHead(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70758_at", "prevRotationYawHead", entity));
	}

	protected void setEntityLivingBasePrevRotationYawHead(float f) {
		setEntityLivingBasePrevRotationYawHead(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70758_at", "prevRotationYawHead", entity, f);
	}

	protected float entityLivingBaseRenderYawOffset() {
		return entityLivingBaseRenderYawOffset(minecraftThePlayer());
	}

	protected float entityLivingBaseRenderYawOffset(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70761_aq", "renderYawOffset", entity));
	}

	protected void setEntityLivingBaseRenderYawOffset(float f) {
		setEntityLivingBaseRenderYawOffset(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseRenderYawOffset(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70761_aq", "renderYawOffset", entity, f);
	}

	protected float entityLivingBaseRotationYawHead() {
		return entityLivingBaseRotationYawHead(minecraftThePlayer());
	}

	protected float entityLivingBaseRotationYawHead(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70759_as", "rotationYawHead", entity));
	}

	protected void setEntityLivingBaseRotationYawHead(float f) {
		setEntityLivingBaseRotationYawHead(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseRotationYawHead(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70759_as", "rotationYawHead", entity, f);
	}

	protected void entityLivingBaseSetHealth(float f) {
		entityLivingBaseSetHealth(minecraftThePlayer(), f);
	}

	protected void entityLivingBaseSetHealth(Object entity, float f) {
		if (Modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70606_j", "setHealth", new Class[]{ float.class }, entity, new Object[]{ f });
		else Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70606_j", "setEntityHealth", new Class[]{ int.class }, entity, new Object[]{ (int) f });
	}

	protected int entityLivingGetHealth() {
		return entityLivingGetHealth(minecraftThePlayer());
	}

	protected int entityLivingGetHealth(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_41031_b", "health", entity));
	}

	protected int entityLivingGetMaxHealth() {
		return entityLivingGetMaxHealth(minecraftThePlayer());
	}

	protected int entityLivingGetMaxHealth(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_40117_c", "getMaxHealth", entity));
	}

	protected Object entityTameableAiSit(Object entityTameable) {
		return Modchu_Reflect.getFieldObject("EntityTameable", "field_70911_d", "aiSit", entityTameable);
	}

	protected String entityTameableGetOwnerName() {
		return entityTameableGetOwnerName(minecraftThePlayer());
	}

	protected String entityTameableGetOwnerName(Object entityTameable) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("EntityTameable", "func_70905_p", "getOwnerName", entityTameable));
	}

	protected void entityTameableSetOwner(Object entityTameable) {
		entityTameableSetOwner(entityTameable, getUserName(minecraftThePlayer()));
	}

	protected void entityTameableSetOwner(Object entityTameable, String s) {
		boolean b = Modchu_Main.getMinecraftVersion() > 172;
		Modchu_Reflect.invokeMethod("EntityTameable", b ? "func_152115_b" : "func_70910_a", b ? "func_152115_b" : "setOwner", new Class[]{ String.class }, entityTameable, new Object[]{ s });
	}

	protected void entityLivingSetHealth(int i) {
		entityLivingSetHealth(minecraftThePlayer(), i);
	}

	protected void entityLivingSetHealth(Object entity, int i) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_9372_a_", "setHealth", new Class[]{ int.class }, entity, new Object[]{ i });
	}

	protected double entityMotionX() {
		return entityMotionX(minecraftThePlayer());
	}

	protected double entityMotionX(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_73388_b", "motionX", entity));
	}

	protected double entityMotionY() {
		return entityMotionY(minecraftThePlayer());
	}

	protected double entityMotionY(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_73389_c", "motionY", entity));
	}

	protected double entityMotionZ() {
		return entityMotionZ(minecraftThePlayer());
	}

	protected double entityMotionZ(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_73387_d", "motionZ", entity));
	}

	protected Object[] entityPlayerArmorInventory() {
		return entityPlayerArmorInventory(entityPlayerInventory());
	}

	protected Object[] entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (Modchu_Reflect.loadClass("InventoryPlayer").isInstance(entityplayerORInventory)); else {
			entityplayerORInventory = entityPlayerArmorInventory(entityplayerORInventory);
		}
		return (Object[]) Modchu_Reflect.getFieldObject("InventoryPlayer", "field_70460_b", "armorInventory", entityplayerORInventory);
	}

	protected float entityPlayerCameraYaw() {
		return entityPlayerCameraYaw(minecraftThePlayer());
	}

	protected float entityPlayerCameraYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityPlayer", "field_71109_bG", "cameraYaw", entity));
	}

	protected float entityPlayerCurrentXP() {
		return entityPlayerCurrentXP(minecraftThePlayer());
	}

	protected float entityPlayerCurrentXP(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_35211_aX", "currentXP", entityplayer));
	}

	protected double entityPlayerField_71085_bR() {
		return entityPlayerField_71085_bR(minecraftThePlayer());
	}

	protected double entityPlayerField_71085_bR(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71085_bR", entityplayer));
	}

	protected double entityPlayerField_71091_bM() {
		return entityPlayerField_71091_bM(minecraftThePlayer());
	}

	protected double entityPlayerField_71091_bM(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71091_bM", entityplayer));
	}

	protected double entityPlayerField_71094_bP() {
		return entityPlayerField_71094_bP(minecraftThePlayer());
	}

	protected double entityPlayerField_71094_bP(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71094_bP", entityplayer));
	}

	protected double entityPlayerField_71095_bQ() {
		return entityPlayerField_71095_bQ(minecraftThePlayer());
	}

	protected double entityPlayerField_71095_bQ(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71095_bQ", entityplayer));
	}

	protected double entityPlayerField_71096_bN() {
		return entityPlayerField_71096_bN(minecraftThePlayer());
	}

	protected double entityPlayerField_71096_bN(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71096_bN", entityplayer));
	}

	protected double entityPlayerField_71097_bO() {
		return entityPlayerField_71097_bO(minecraftThePlayer());
	}

	protected double entityPlayerField_71097_bO(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71097_bO", entityplayer));
	}

	protected Object entityPlayerFoodStats() {
		return entityPlayerFoodStats(minecraftThePlayer());
	}

	protected Object entityPlayerFoodStats(Object entityplayer) {
		return Modchu_Reflect.getFieldObject("EntityPlayer", "field_71100_bB", "foodStats", entityplayer);
	}

	protected Object entityplayerGetCurrentEquippedItem() {
		return entityplayerGetCurrentEquippedItem(minecraftThePlayer());
	}

	protected Object entityplayerGetCurrentEquippedItem(Object entityplayer) {
		return Modchu_Reflect.getFieldObject("EntityPlayer", "func_71045_bC", "getCurrentEquippedItem", entityplayer);
	}

	protected Object entityPlayerGetFoodStats() {
		return entityPlayerGetFoodStats(minecraftThePlayer());
	}

	protected Object entityPlayerGetFoodStats(Object entityplayer) {
		return Modchu_Reflect.invokeMethod("EntityPlayer", "func_71024_bL", "getFoodStats", entityplayer);
	}

	protected boolean entityPlayerGetHideCape() {
		return entityPlayerGetHideCape(minecraftThePlayer());
	}

	protected boolean entityPlayerGetHideCape(Object entityplayer) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityPlayer", "func_82241_s", "getHideCape", entityplayer));
	}

	protected int entityPlayerGetItemInUseCount() {
		return entityPlayerGetItemInUseCount(minecraftThePlayer());
	}

	protected int entityPlayerGetItemInUseCount(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("EntityPlayer", "func_71052_bv", "getItemInUseCount", entityplayer));
	}

	protected Object entityPlayerInventory() {
		return entityPlayerInventory(minecraftThePlayer());
	}

	protected Object entityPlayerInventory(Object entityplayer) {
		return Modchu_Reflect.getFieldObject("EntityPlayer", "field_71071_by", "inventory", entityplayer);
	}

	protected Object entityPlayerInventoryGetCurrentItem() {
		return entityPlayerInventoryGetCurrentItem(minecraftThePlayer());
	}

	protected Object entityPlayerInventoryGetCurrentItem(Object entityplayer) {
		Object inventory = entityPlayerInventory(entityplayer);
		return Modchu_Reflect.invokeMethod(inventory.getClass(), "func_70448_g", "getCurrentItem", inventory);
	}

	protected Object entityPlayerInventoryCurrentItem() {
		return entityPlayerInventoryCurrentItem(minecraftThePlayer());
	}

	protected int entityPlayerInventoryCurrentItem(Object entityplayer) {
		Object inventory = entityPlayerInventory(entityplayer);
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(inventory.getClass(), "field_70461_c", "currentItem", inventory));
	}

	protected Object entityPlayerInventoryGetStackInSlot(int i) {
		return entityPlayerInventoryGetStackInSlot(minecraftThePlayer(), i);
	}

	protected Object entityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return Modchu_Reflect.invokeMethod("InventoryPlayer", "func_70301_a", "getStackInSlot", new Class[]{ int.class }, entityPlayerInventory(entityplayer), new Object[]{ i });
	}

	protected Object entityPlayerInventoryPlayerArmorItemInSlot(int i) {
		return entityPlayerInventoryPlayerArmorItemInSlot(minecraftThePlayer(), i);
	}

	protected Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		if (Modchu_Reflect.loadClass("InventoryPlayer").isInstance(entityplayerORInventory)); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return Modchu_Reflect.invokeMethod("InventoryPlayer", "func_70440_f", "armorItemInSlot", new Class[]{ int.class }, entityplayerORInventory, new Object[]{ i });
	}

	protected void entityPlayerInventorySetInventorySlotContents(Object entityplayer, int i, Object itemstack) {
		Modchu_Reflect.invokeMethod("InventoryPlayer", "func_70299_a", "setInventorySlotContents", new Class[]{ int.class, Modchu_Reflect.loadClass("ItemStack") }, entityPlayerInventory(entityplayer), new Object[]{ i, itemstack });
	}

	protected boolean entityPlayerIsPlayerSleeping() {
		return entityPlayerIsPlayerSleeping(minecraftThePlayer());
	}

	protected boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(entityplayer.getClass(), "func_70608_bn", "isPlayerSleeping", entityplayer));
	}

	protected boolean entityPlayerCapabilitiesIsCreativeMode() {
		return entityPlayerCapabilitiesIsCreativeMode(minecraftThePlayer());
	}

	protected boolean entityPlayerCapabilitiesIsCreativeMode(Object entityplayer) {
		Object capabilities = Modchu_Reflect.getFieldObject(entityplayer.getClass(), "field_71075_bZ", "capabilities", entityplayer);
		return capabilities != null ? Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject(capabilities.getClass(), "field_75098_d", "isCreativeMode", capabilities)) : false;
	}

	protected Object[] entityPlayerMainInventory() {
		return entityPlayerMainInventory(minecraftThePlayer());
	}

	protected Object[] entityPlayerMainInventory(Object entityplayerORInventory) {
		if (Modchu_Reflect.loadClass("InventoryPlayer").isInstance(entityplayerORInventory)); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return (Object[]) Modchu_Reflect.getFieldObject("InventoryPlayer", "field_70462_a", "mainInventory", entityplayerORInventory);
	}

	protected void entityPlayerPreparePlayerToSpawn(Object entityplayer) {
		Modchu_Reflect.invokeMethod("EntityPlayer", "func_70065_x", "preparePlayerToSpawn", entityplayer);
	}

	protected Object entityClientPlayerMPSendQueue() {
		return entityClientPlayerMPSendQueue(minecraftThePlayer());
	}

	protected Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return Modchu_Reflect.getFieldObject("EntityClientPlayerMP", "field_71174_a", "sendQueue", entityClientPlayerMP);
	}

	protected void entityLivingBaseSwingItem() {
		entityLivingBaseSwingItem(minecraftThePlayer());
	}

	protected void entityLivingBaseSwingItem(Object entityLivingBase) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_71038_i", "swingItem", entityLivingBase);
	}

	protected int entityPlayerPlayerLevel() {
		return entityPlayerPlayerLevel(minecraftThePlayer());
	}

	protected int entityPlayerPlayerLevel(Object entityplayer) {
		// b181 aY
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_35210_aY", "playerLevel", entityplayer));
	}

	protected float entityPlayerPrevCameraYaw() {
		return entityPlayerPrevCameraYaw(minecraftThePlayer());
	}

	protected float entityPlayerPrevCameraYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityPlayer", "field_71107_bF", "prevCameraYaw", entity));
	}

	protected int entityPlayerScore() {
		return entityPlayerScore(minecraftThePlayer());
	}

	protected int entityPlayerScore(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_9370_g", "score", entityplayer));
	}

	protected void entityPlayerSPFunc_6420_o() {
		entityPlayerSPFunc_6420_o(minecraftThePlayer());
	}

	protected void entityPlayerSPFunc_6420_o(Object entityplayer) {
		Modchu_Reflect.invokeMethod("EntityPlayerSP", "func_6420_o", entityplayer);
	}

	protected int entityPlayerTotalXP() {
		return entityPlayerTotalXP(minecraftThePlayer());
	}

	protected int entityPlayerTotalXP(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_35209_aZ", "totalXP", entityplayer));
	}

	protected void entityPlayerSetItemInUse(Object itemstack, int i) {
		entityPlayerSetItemInUse(minecraftThePlayer(), itemstack, i);
	}

	protected void entityPlayerSetItemInUse(Object entityplayer, Object itemstack, int i) {
		Modchu_Reflect.invokeMethod("EntityPlayer", "func_71008_a", "setItemInUse", new Class[]{ Modchu_Reflect.loadClass("ItemStack"), int.class }, entityplayer, new Object[]{ itemstack, i });
	}

	protected void entityPlayerDestroyCurrentEquippedItem() {
		entityPlayerDestroyCurrentEquippedItem(minecraftThePlayer());
	}

	protected void entityPlayerDestroyCurrentEquippedItem(Object entityplayer) {
		Modchu_Reflect.invokeMethod("EntityPlayer", "func_71028_bD", "destroyCurrentEquippedItem", entityplayer);
	}

	protected boolean entityPlayerCanPlayerEdit(int x, int y, int z, int i, Object itemStack) {
		return entityPlayerCanPlayerEdit(minecraftThePlayer(), x, y, z, i, itemStack);
	}

	protected boolean entityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		if (Modchu_Main.getMinecraftVersion() > 179) {
			return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityPlayer", "func_175142_cm", entityplayer));
		}
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityPlayer", "func_82247_a", "canPlayerEdit", new Class[]{ int.class, int.class, int.class, int.class, Modchu_Reflect.loadClass("ItemStack") }, entityplayer, new Object[]{ x, y, z, i, itemStack }));
	}

	protected Object entityPlayerMPPlayerNetServerHandler() {
		return entityPlayerMPPlayerNetServerHandler(minecraftThePlayer());
	}

	protected Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return Modchu_Reflect.getFieldObject("EntityPlayerMP", "field_71135_a", "playerNetServerHandler", entityplayerMP);
	}

	protected void setEntityPlayerMPPlayerNetServerHandler(Object netServerHandler) {
		setEntityPlayerMPPlayerNetServerHandler(minecraftThePlayer(), netServerHandler);
	}

	protected void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netServerHandler) {
		Modchu_Reflect.setFieldObject("EntityPlayerMP", "field_71135_a", "playerNetServerHandler", entityplayerMP, netServerHandler);
	}

	protected Object entityPlayerFishEntity() {
		return entityPlayerFishEntity(minecraftThePlayer());
	}

	protected Object entityPlayerFishEntity(Object entityplayer) {
		return Modchu_Reflect.getFieldObject("EntityPlayer", "field_71104_cf", "fishEntity", entityplayer);
	}

	protected void setEntityPlayerFishEntity(Object entityFishHook) {
		setEntityPlayerFishEntity(minecraftThePlayer(), entityFishHook);
	}

	protected void setEntityPlayerFishEntity(Object entityplayer, Object entityFishHook) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_71104_cf", "fishEntity", entityplayer, entityFishHook);
	}

	protected boolean entityZombieIsVillager(Object entityZombie) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityZombie", "func_82231_m", "isVillager", entityZombie));
	}

	protected void entityZombieSetVillager(Object entityZombie, boolean b) {
		Modchu_Reflect.invokeMethod("EntityZombie", "func_82229_g", "setVillager", new Class[]{ boolean.class }, entityZombie, new Object[]{ b });
	}

	protected double entityPosX() {
		return entityPosX(minecraftThePlayer());
	}

	protected double entityPosX(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_70165_t", "posX", entity));
	}

	protected double entityPosY() {
		return entityPosY(minecraftThePlayer());
	}

	protected double entityPosY(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_70163_u", "posY", entity));
	}

	protected double entityPosZ() {
		return entityPosZ(minecraftThePlayer());
	}

	protected double entityPosZ(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_70161_v", "posZ", entity));
	}

	protected float entityPrevDistanceWalkedModified() {
		return entityPrevDistanceWalkedModified(minecraftThePlayer());
	}

	protected float entityPrevDistanceWalkedModified(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70141_P", "prevDistanceWalkedModified", entity));
	}

	protected double entityPrevPosX() {
		return entityPrevPosX(minecraftThePlayer());
	}

	protected double entityPrevPosX(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_70169_q", "prevPosX", entity));
	}

	protected double entityPrevPosY() {
		return entityPrevPosY(minecraftThePlayer());
	}

	protected double entityPrevPosY(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_70167_r", "prevPosY", entity));
	}

	protected double entityPrevPosZ() {
		return entityPrevPosZ(minecraftThePlayer());
	}

	protected double entityPrevPosZ(Object entity) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Entity", "field_70166_s", "prevPosZ", entity));
	}

	protected float entityPrevRotationPitch() {
		return entityPrevRotationPitch(minecraftThePlayer());
	}

	protected float entityPrevRotationPitch(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70127_C", "prevRotationPitch", entity));
	}

	protected void setEntityPrevRotationPitch(float f) {
		setEntityPrevRotationPitch(minecraftThePlayer(), f);
	}

	protected void setEntityPrevRotationPitch(Object entity, float f) {
		Modchu_Reflect.setFieldObject("Entity", "field_70127_C", "prevRotationPitch", entity, f);
	}

	protected float entityPrevRotationYaw() {
		return entityPrevRotationYaw(minecraftThePlayer());
	}

	protected float entityPrevRotationYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70126_B", "prevRotationYaw", entity));
	}

	protected void setEntityPrevRotationYaw(float f) {
		setEntityPrevRotationYaw(minecraftThePlayer(), f);
	}

	protected void setEntityPrevRotationYaw(Object entity, float f) {
		Modchu_Reflect.setFieldObject("Entity", "field_70126_B", "prevRotationYaw", entity, f);
	}

	protected Object entityRidingEntity() {
		return entityRidingEntity(minecraftThePlayer());
	}

	protected Object entityRidingEntity(Object entity) {
		return Modchu_Reflect.getFieldObject("Entity", "field_70154_o", "ridingEntity", entity);
	}

	protected Object entityGetBoundingBox() {
		return entityGetBoundingBox(minecraftThePlayer());
	}

	protected Object entityGetBoundingBox(Object entity) {
		return Modchu_Reflect.invokeMethod("Entity", "func_70046_E", "getBoundingBox", entity);
	}

	protected boolean entityCanBeCollidedWith() {
		return entityCanBeCollidedWith(minecraftThePlayer());
	}

	protected boolean entityCanBeCollidedWith(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70067_L", "canBeCollidedWith", entity));
	}

	protected float entityGetCollisionBorderSize() {
		return entityGetCollisionBorderSize(minecraftThePlayer());
	}

	protected float entityGetCollisionBorderSize(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("Entity", "func_70111_Y", "getCollisionBorderSize", entity));
	}

	protected void setEntityRidingEntity(Object entity) {
		setEntityRidingEntity(minecraftThePlayer(), entity);
	}

	protected void setEntityRidingEntity(Object entity, Object entity2) {
		Modchu_Reflect.setFieldObject("Entity", "field_70154_o", "ridingEntity", entity, entity2);
	}

	protected Object entityRiddenByEntity() {
		return entityRiddenByEntity(minecraftThePlayer());
	}

	protected Object entityRiddenByEntity(Object entity) {
		return Modchu_Reflect.getFieldObject("Entity", "field_70153_n", "riddenByEntity", entity);
	}

	protected void setEntityRiddenByEntity(Object entity) {
		setEntityRiddenByEntity(minecraftThePlayer(), entity);
	}

	protected void setEntityRiddenByEntity(Object entity, Object entity2) {
		Modchu_Reflect.setFieldObject("Entity", "field_70153_n", "riddenByEntity", entity, entity2);
	}

	protected boolean entityIsDead() {
		return entityIsDead(minecraftThePlayer());
	}

	protected boolean entityIsDead(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("Entity", "field_70128_L", "isDead", entity));
	}

	protected boolean entityTameableIsTamed(Object entityTameable) {
		return Modchu_Reflect.loadClass("EntityTameable").isInstance(entityTameable) ? Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityTameable", "func_70909_n", "isTamed", entityTameable)) : false;
	}

	protected boolean entityHorseIsTame(Object entityHorse) {
		return Modchu_Main.getMinecraftVersion() > 159
				&& Modchu_Reflect.loadClass("EntityHorse").isInstance(entityHorse) ? Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityHorse", "func_110248_bS", "isTame", entityHorse)) : false;
	}

	protected boolean isTamed(Object entity) {
		return Modchu_Main.getMinecraftVersion() > 159
				&& Modchu_Reflect.loadClass("EntityHorse").isInstance(entity) ? entityHorseIsTame(entity) : Modchu_Reflect.loadClass("EntityTameable").isInstance(entity) ? entityTameableIsTamed(entity) : false;
	}

	protected void setEntityIsDead(boolean b) {
		setEntityIsDead(minecraftThePlayer(), b);
	}

	protected void setEntityIsDead(Object entity, boolean b) {
		Modchu_Reflect.setFieldObject("Entity", "field_70128_L", "isDead", entity, b);
	}

	protected float entityRotationPitch() {
		return entityRotationPitch(minecraftThePlayer());
	}

	protected float entityRotationPitch(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70125_A", "rotationPitch", entity));
	}

	protected void setEntityRotationPitch(float f) {
		setEntityRotationPitch(minecraftThePlayer(), f);
	}

	protected void setEntityRotationPitch(Object entity, float f) {
		Modchu_Reflect.setFieldObject("Entity", "field_70125_A", "rotationPitch", entity, f);
	}

	protected float entityRotationYaw() {
		return entityRotationYaw(minecraftThePlayer());
	}

	protected float entityRotationYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70177_z", "rotationYaw", entity));
	}

	protected void setEntityRotationYaw(float f) {
		setEntityRotationYaw(minecraftThePlayer(), f);
	}

	protected void setEntityRotationYaw(Object entity, float f) {
		Modchu_Reflect.setFieldObject("Entity", "field_70177_z", "rotationYaw", entity, f);
	}

	protected void entitySetDead() {
		entitySetDead(minecraftThePlayer());
	}

	protected void entitySetDead(Object entity) {
		Modchu_Reflect.invokeMethod("Entity", "func_70106_y", "setDead", entity);
	}

	protected void entitySetFire(int i) {
		entitySetFire(minecraftThePlayer(), i);
	}

	protected void entitySetFire(Object entity, int i) {
		Modchu_Reflect.invokeMethod("Entity", "func_70015_d", "setFire", new Class[]{ int.class }, entity, new Object[]{ i });
	}

	protected void entitySetPosition(double x, double y, double z) {
		entitySetPosition(minecraftThePlayer(), x, y, z);
	}

	protected void entitySetPosition(Object entity, double x, double y, double z) {
		Modchu_Reflect.invokeMethod("Entity", "func_70107_b", "setPosition", new Class[]{ double.class, double.class, double.class }, entity, new Object[]{ x, y, z });
	}

	protected void entitySetSize(float f1, float f2) {
		entitySetSize(minecraftThePlayer(), f1, f2);
	}

	protected void entitySetSize(Object entity, float f1, float f2) {
		Modchu_Reflect.invokeMethod("Entity", "func_70105_a", "setSize", new Class[]{ float.class, float.class }, entity, new Object[]{ f1, f2 });
	}

	protected void entityPlaySound(String s, float f1, float f2) {
		entityPlaySound(minecraftThePlayer(), s, f1, f2);
	}

	protected void entityPlaySound(Object entity, String s, float f1, float f2) {
		Modchu_Reflect.invokeMethod("Entity", "func_72704_a", "playSound", new Class[]{ String.class, float.class, float.class }, entity, new Object[]{ s, f1, f2 });
	}

	protected int entityTicksExisted() {
		return entityTicksExisted(minecraftThePlayer());
	}

	protected int entityTicksExisted(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", "field_70173_aa", "ticksExisted", entity));
	}

	protected void setEntityTicksExisted(int i) {
		setEntityTicksExisted(minecraftThePlayer(), i);
	}

	protected void setEntityTicksExisted(Object entity, int i) {
		Modchu_Reflect.setFieldObject("Entity", "field_70173_aa", "ticksExisted", entity, i);
	}

	protected Object entityLivingGetNavigator() {
		return entityLivingGetNavigator(minecraftThePlayer());
	}

	protected Object entityLivingGetNavigator(Object entityLivingOrPathNavigate) {
		return Modchu_Reflect.loadClass("Entity").isInstance(entityLivingOrPathNavigate) ? Modchu_Reflect.invokeMethod("EntityLiving", "func_70661_as", "getNavigator", entityLivingOrPathNavigate) : entityLivingOrPathNavigate;
	}

	protected void entityLivingNavigatorClearPathEntity() {
		entityLivingNavigatorClearPathEntity(minecraftThePlayer());
	}

	protected void entityLivingNavigatorClearPathEntity(Object entityLivingOrPathNavigate) {
		Object navigator = entityLivingGetNavigator(entityLivingOrPathNavigate);
		if (navigator != null) Modchu_Reflect.invokeMethod(navigator.getClass(), "func_75499_g", "clearPathEntity", navigator);
	}

	protected Object entityLivingGetCurrentArmor(Object entityLiving, int i) {
		return Modchu_Reflect.invokeMethod("EntityLiving", "func_130225_q", "getCurrentArmor", new Class[]{ int.class }, entityLiving, new Object[]{ i });
	}

	protected boolean entityLivingBaseIsPotionActive(Object potionOrPotionId) {
		return entityLivingBaseIsPotionActive(minecraftThePlayer(), potionOrPotionId);
	}

	protected boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70644_a", "isPotionActive", new Class[]{ potionOrPotionId.getClass() == int.class ? int.class : Modchu_Reflect.loadClass("Potion") }, entityLivingBase, new Object[]{ potionOrPotionId }));
	}

	protected boolean entityOnGround() {
		return entityOnGround(minecraftThePlayer());
	}

	protected boolean entityOnGround(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "field_70122_E", "onGround", entity));
	}

	protected void entityLivingBaseSetBeenAttacked() {
		entityLivingBaseSetBeenAttacked(minecraftThePlayer());
	}

	protected void entityLivingBaseSetBeenAttacked(Object entityLivingBase) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70018_K", "setBeenAttacked", entityLivingBase);
	}

	protected void entityLivingBaseOnDeath(Object damageSource) {
		entityLivingBaseOnDeath(minecraftThePlayer(), damageSource);
	}

	protected void entityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70645_a", "onDeath", new Class[]{ Modchu_Reflect.loadClass("DamageSource") }, entityLivingBase, new Object[]{ damageSource });
	}

	protected int entityAgeableGetGrowingAge() {
		return entityAgeableGetGrowingAge(minecraftThePlayer());
	}

	protected int entityAgeableGetGrowingAge(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("EntityAgeable", "func_70874_b", "getGrowingAge", entityLivingBase));
	}

	protected int entityLivingBaseHurtTime() {
		return entityLivingBaseHurtTime(minecraftThePlayer());
	}

	protected int entityLivingBaseHurtTime(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70737_aN", "hurtTime", entityLivingBase));
	}

	protected void setEntityLivingBaseHurtTime(int i) {
		setEntityLivingBaseHurtTime(minecraftThePlayer(), i);
	}

	protected void setEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70737_aN", "hurtTime", entityLivingBase, i, 0);
	}

	protected int entityLivingBaseMaxHurtTime() {
		return entityLivingBaseMaxHurtTime(minecraftThePlayer());
	}

	protected int entityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70738_aO", "maxHurtTime", entityLivingBase));
	}

	protected void setEntityLivingBaseMaxHurtTime(int i) {
		setEntityLivingBaseMaxHurtTime(minecraftThePlayer(), i);
	}

	protected void setEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70738_aO", "maxHurtTime", entityLivingBase, i, 0);
	}

	protected float entityLivingBaseAttackedAtYaw() {
		return entityLivingBaseAttackedAtYaw(minecraftThePlayer());
	}

	protected float entityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70739_aP", "attackedAtYaw", entityLivingBase));
	}

	protected void setEntityLivingBaseAttackedAtYaw(float f) {
		setEntityLivingBaseAttackedAtYaw(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70739_aP", "attackedAtYaw", entityLivingBase, f);
	}

	protected float entityLivingBasePrevHealth() {
		return entityLivingBasePrevHealth(minecraftThePlayer());
	}

	protected float entityLivingBasePrevHealth(Object entityLivingBase) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70735_aL", "prevHealth", entityLivingBase));
	}

	protected void setEntityLivingBasePrevHealth(float f) {
		setEntityLivingBasePrevHealth(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70735_aL", "prevHealth", entityLivingBase, f);
	}

	protected boolean entityLivingBaseIsChild() {
		return entityLivingBaseIsChild(minecraftThePlayer());
	}

	protected boolean entityLivingBaseIsChild(Object entityLivingBase) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70631_g_", "isChild", entityLivingBase));
	}

	protected void entityLivingBaseKnockBack(Object entityLivingBase, float f, double d, double d1) {
		entityLivingBaseKnockBack(minecraftThePlayer(), entityLivingBase, f, d, d1);
	}

	protected void entityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70653_a", "knockBack", new Class[]{ Modchu_Reflect.loadClass("Entity"), float.class, double.class, double.class }, entityLivingBase, new Object[]{ entityLivingBase2, f, d, d1 });
	}

	protected Object entityLivingBaseGetAITarget() {
		return entityLivingBaseGetAITarget(minecraftThePlayer());
	}

	protected Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70643_av", "getAITarget", entityLivingBase);
	}

	protected void entityBatSetIsBatHanging(Object entityBat, boolean b) {
		Modchu_Reflect.setFieldObject(entityBat.getClass(), "func_82236_f", "setIsBatHanging", entityBat, b);
	}

	protected void entitySetEating(Object entity, boolean b) {
		Modchu_Reflect.setFieldObject(entity.getClass(), "func_70019_c", "setEating", entity, b);
	}

	protected float entityWidth() {
		return entityWidth(minecraftThePlayer());
	}

	protected float entityWidth(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70130_N", "width", entity));
	}

	protected Object entityWorldObj() {
		return entityWorldObj(minecraftThePlayer());
	}

	protected Object entityWorldObj(Object worldOrEntity) {
		return Modchu_Reflect.loadClass("World").isInstance(worldOrEntity) ? worldOrEntity : Modchu_Reflect.getFieldObject("Entity", "field_70170_p", "worldObj", worldOrEntity);
	}

	protected float entityYOffset() {
		return entityYOffset(minecraftThePlayer());
	}

	protected float entityYOffset(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70129_M", "YOffset", entity));
	}

	protected Enum enumActionBlock() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "block"));
	}

	protected Enum enumActionBow() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "bow"));
	}

	protected Enum enumActionDrink() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "drink"));
	}

	protected Enum enumActionEat() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "eat"));
	}

	protected Enum enumActionNone() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "none"));
	}

	protected Enum enumCreatureAttributeARTHROPOD() {
		return Modchu_Reflect.getEnum("EnumCreatureAttribute", "ARTHROPOD");
	}

	protected Enum enumCreatureAttributeUNDEAD() {
		return Modchu_Reflect.getEnum("EnumCreatureAttribute", "UNDEAD");
	}

	protected Enum enumCreatureAttributeUNDEFINED() {
		return Modchu_Reflect.getEnum("EnumCreatureAttribute", "UNDEFINED");
	}

	protected Enum enumCreatureTypeMonster() {
		return Modchu_Reflect.getEnum("EnumCreatureType", "monster");
	}

	protected Enum enumCreatureTypeCreature() {
		return Modchu_Reflect.getEnum("EnumCreatureType", "creature");
	}

	protected Enum enumCreatureTypeAmbient() {
		return Modchu_Reflect.getEnum("EnumCreatureType", "ambient");
	}

	protected Enum enumCreatureTypeWaterCreature() {
		return Modchu_Reflect.getEnum("EnumCreatureType", "waterCreature");
	}

	protected Enum enumFacingUP() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("EnumFacing", "UP"));
	}

	protected Enum enumFacingDOWN() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("EnumFacing", "DOWN"));
	}

	protected Enum enumFacingEAST() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("EnumFacing", "EAST"));
	}

	protected Enum enumFacingNORTH() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("EnumFacing", "NORTH"));
	}

	protected Enum enumFacingSOUTH() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("EnumFacing", "SOUTH"));
	}

	protected Enum enumFacingWEST() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("EnumFacing", "WEST"));
	}

	protected boolean gameSettingsAnaglyph(Object gameSettings) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("GameSettings", "anaglyph", gameSettings));
	}

	protected Object biomeGenBaseOcean() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "ocean");
	}

	protected Object biomeGenBasePlains() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "plains");
	}

	protected Object biomeGenBaseDesert() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "desert");
	}

	protected Object biomeGenBaseExtremeHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "extremeHills");
	}

	protected Object biomeGenBaseForest() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "forest");
	}

	protected Object biomeGenBaseTaiga() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "taiga");
	}

	protected Object biomeGenBaseSwampland() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "swampland");
	}

	protected Object biomeGenBaseRiver() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "river");
	}

	protected Object biomeGenBaseHell() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "hell");
	}

	protected Object biomeGenBaseSky() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "sky");
	}

	protected Object biomeGenBaseFrozenOcean() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "frozenOcean");
	}

	protected Object biomeGenBaseFrozenRiver() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "frozenRiver");
	}

	protected Object biomeGenBaseIcePlains() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "icePlains");
	}

	protected Object biomeGenBaseIceMountains() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "iceMountains");
	}

	protected Object biomeGenBaseMushroomIsland() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "mushroomIsland");
	}

	protected Object biomeGenBaseMushroomIslandShore() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "mushroomIslandShore");
	}

	protected Object biomeGenBaseBeach() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "beach");
	}

	protected Object biomeGenBaseDesertHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "desertHills");
	}

	protected Object biomeGenBaseForestHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "forestHills");
	}

	protected Object biomeGenBaseTaigaHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "taigaHills");
	}

	protected Object biomeGenBaseExtremeHillsEdge() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "extremeHillsEdge");
	}

	protected Object biomeGenBaseJungle() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "jungle");
	}

	protected Object biomeGenBaseJungleHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "jungleHills");
	}

	protected Object biomeGenBaseJungleEdge() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "jungleEdge");
	}

	protected Object biomeGenBaseDeepOcean() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "deepOcean");
	}

	protected Object biomeGenBaseStoneBeach() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "stoneBeach");
	}

	protected Object biomeGenBaseStoneColdBeach() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "coldBeach");
	}

	protected Object biomeGenBaseBirchForest() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "birchForest");
	}

	protected Object biomeGenBaseBirchForestHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "birchForestHills");
	}

	protected Object biomeGenBaseRoofedForest() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "roofedForest");
	}

	protected Object biomeGenBaseColdTaiga() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "coldTaiga");
	}

	protected Object biomeGenBaseColdTaigaHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "coldTaigaHills");
	}

	protected Object biomeGenBaseMegaTaiga() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "megaTaiga");
	}

	protected Object biomeGenBaseMegaTaigaHills() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "megaTaigaHills");
	}

	protected Object biomeGenBaseExtremeHillsPlus() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "extremeHillsPlus");
	}

	protected Object biomeGenBaseSavanna() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "savanna");
	}

	protected Object biomeGenBaseSavannaPlateau() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "savannaPlateau");
	}

	protected Object biomeGenBaseMesa() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "mesa");
	}

	protected Object biomeGenBaseMesaPlateau_F() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "mesaPlateau_F");
	}

	protected Object biomeGenBaseMesaPlateau() {
		return Modchu_Reflect.getFieldObject("BiomeGenBase", "mesaPlateau");
	}

	protected Object creativeTabsTabBlock() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78030_b", "tabBlock");
	}

	protected Object creativeTabsTabDecorations() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78031_c", "tabDecorations");
	}

	protected Object creativeTabsTabRedstone() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78028_d", "tabRedstone");
	}

	protected Object creativeTabsTabTransport() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78029_e", "tabTransport");
	}

	protected Object creativeTabsTabMisc() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78026_f", "tabMisc");
	}

	protected Object creativeTabsTabAllSearch() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78027_g", "tabAllSearch");
	}

	protected Object creativeTabsTabFood() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78039_h", "tabFood");
	}

	protected Object creativeTabsTabTools() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78040_i", "tabTools");
	}

	protected Object creativeTabsTabCombat() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78037_j", "tabCombat");
	}

	protected Object creativeTabsTabBrewing() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78038_k", "tabBrewing");
	}

	protected Object creativeTabsTabMaterials() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78035_l", "tabMaterials");
	}

	protected Object creativeTabsTabInventory() {
		return Modchu_Reflect.getFieldObject("CreativeTabs", "field_78036_m", "tabInventory");
	}

	protected Object containerInventorySlots(Object container) {
		return Modchu_Reflect.getFieldObject("Container", "field_74193_d", "inventorySlots", container);
	}

	protected Object containerInventoryItemStacks(Object container) {
		return Modchu_Reflect.getFieldObject("Container", "field_75153_a", "inventoryItemStacks", container);
	}

	protected Object containerGetSlot(Object container, int i) {
		return Modchu_Reflect.invokeMethod("Container", "func_75139_a", "getSlot", new Class[]{ int.class }, container, new Object[]{ i });
	}

	protected Object FMLCommonHandlerInstance() {
		return Modchu_Reflect.invokeMethod("cpw.mods.fml.common.FMLCommonHandler", "instance");
	}

	protected Object FMLCommonHandlerInstanceGetMinecraftServerInstance() {
		return Modchu_Reflect.invokeMethod("cpw.mods.fml.common.FMLCommonHandler", "getMinecraftServerInstance", FMLCommonHandlerInstance());
	}

	protected Object[] FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() {
		Object minecraftServer = FMLCommonHandlerInstanceGetMinecraftServerInstance();
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(minecraftServer.getClass(), "worldServers", minecraftServer));
	}

	protected void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		Modchu_Reflect.invokeMethod("FontRenderer", "func_78276_b", "drawString", new Class[]{ String.class, int.class, int.class, int.class }, fontRenderer, new Object[]{ s, i, j, k });
	}

	protected int[] facingOffsetsXForSide() {
		return Modchu_CastHelper.IntArray(Modchu_Reflect.getFieldObject("Facing", "field_71586_b", "offsetsXForSide"));
	}

	protected int[] facingOffsetsYForSide() {
		return Modchu_CastHelper.IntArray(Modchu_Reflect.getFieldObject("Facing", "field_71587_c", "offsetsYForSide"));
	}

	protected int[] facingOffsetsZForSide() {
		return Modchu_CastHelper.IntArray(Modchu_Reflect.getFieldObject("Facing", "field_71585_d", "offsetsZForSide"));
	}

	protected String gameSettingsGetKeyDisplayString(int i) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("GameSettings", "func_74298_c", "getKeyDisplayString", new Class[]{ int.class }, new Object[]{ i }));
	}

	protected Object gameSettingsKeyBindBack() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74368_y", "keyBindBack", gameSettings);
	}

	protected Object gameSettingsKeyBindForward() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74351_w", "keyBindForward", gameSettings);
	}

	protected Object gameSettingsKeyBindLeft() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74370_x", "keyBindLeft", gameSettings);
	}

	protected Object gameSettingsKeyBindRight() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74366_z", "keyBindRight", gameSettings);
	}

	protected Object getBlock(Object itemStackOrItemOrBlock) {
		Object block = itemStackOrItemOrBlock;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItemOrBlock)) {
			return getBlockItemStack(itemStackOrItemOrBlock);
		} else if (Modchu_Reflect.loadClass("Item").isInstance(itemStackOrItemOrBlock)) {
			return blockGetBlockFromItem(itemStackOrItemOrBlock);
		} else if (itemStackOrItemOrBlock.getClass() == String.class) {
			return getBlock((String) itemStackOrItemOrBlock);
		} else if (Modchu_Reflect.loadClass("Block").isInstance(itemStackOrItemOrBlock)) {
			return block;
		}
		return null;
	}

	protected Object getBlockItemStack(Object itemstack) {
		if (itemstack != null); else return null;
		return Modchu_Main.getMinecraftVersion() > 169 ? blockGetBlockFromItem(itemStackGetItem(itemstack)) : blockBlockList()[itemStackItemID(itemstack)];
	}

	protected Object getItem(String s) {
		if (s != null); else return null;
		if (Modchu_Main.getMinecraftVersion() > 169) {
			Object itemRegistry = Modchu_Reflect.getFieldObject("Item", "field_150901_e", "itemRegistry");
			if (itemRegistry != null); else return null;
			Object item = Modchu_Reflect.invokeMethod(itemRegistry.getClass(), "func_82594_a", "getObject", new Class[]{ String.class }, itemRegistry, new Object[]{ s });
			//Modchu_Debug.mDebug("getItem s="+s+" item="+item);
			return item != null ? item : null;
		}
		return oldVersionItem(s);
	}

	protected Object getBlock(String s) {
		if (s != null); else return null;
		if (Modchu_Main.getMinecraftVersion() > 169) {
			Object blockRegistry = Modchu_Reflect.getFieldObject("Block", "field_149771_c", "blockRegistry");
			if (blockRegistry != null); else return null;
			Object block = Modchu_Reflect.invokeMethod(blockRegistry.getClass(), "func_82594_a", "getObject", new Class[]{ String.class }, blockRegistry, new Object[]{ s });
			Modchu_Debug.mDebug("getBlock s="+s+" block="+block);
			return block != null ? block : null;
		}
		return oldVersionBlock(s);
	}

	protected Object getResource(Class c, String s) {
		return c.getResource(s);
	}

	protected Object getResource(String s) {
		return getResource(Modchu_Reflect.loadClass("Minecraft"), s);
	}

	protected String getUserName() {
		return getUserName(minecraftThePlayer());
	}

	protected String getUserName(Object entityplayer) {
		return Modchu_CastHelper.String(Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.invokeMethod("EntityPlayer", "func_70005_c_", "getCommandSenderName", entityplayer) : Modchu_Reflect.getFieldObject("EntityPlayer", "field_71092_bJ", "username", entityplayer));
	}

	protected int getVacancyGlobalEntityID() {
		if (Modchu_Main.getMinecraftVersion() < 150) {
			return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("ModLoader", "getUniqueEntityId"));
		}
		Map map = (Map) Modchu_Reflect.getFieldObject("EntityList", "field_75623_d", -1);
		if (map != null); else map = (Map) Modchu_Reflect.getFieldObject("EntityList", "IDtoClassMapping");
		int ID = -1;
		if (map != null) {
			for(int i = 64; i < 3000; i++) {
				//Modchu_Debug.mDebug("i"+i+" !map.containsKey(i) = "+(!map.containsKey(i)));
				if (!map.containsKey(i)) {
					ID = i;
					//Modchu_Debug.mDebug("!map.containsKey ID="+ID);
					break;
				}
			}
		} else {
			Modchu_Debug.lDebug("IDtoClassMapping map == null !!");
		}
		return ID;
	}

	protected IntBuffer gLAllocationCreateDirectIntBuffer(int i) {
		return (IntBuffer) Modchu_Reflect.invokeMethod("GLAllocation", "func_74527_f", "createDirectIntBuffer", new Class[]{ int.class }, null, new Object[]{ i });
	}

	protected int gLAllocationGenerateDisplayLists(int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("GLAllocation", "func_74526_a", "generateDisplayLists", new Class[]{ int.class }, null, new Object[]{ i }));
	}

	protected boolean guiButtonEnabled(Object guiButton) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146124_l" : "field_73742_g", "enabled", guiButton));
	}

	protected int guiButtonHeight(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146121_g" : "field_73745_b", "height", guiButton));
	}

	protected int guiButtonID(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146127_k" : "field_73741_f", "id", guiButton));
	}

	protected boolean guiButtonVisible(Object guiButton) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146125_m" : "field_73748_h", "visible", guiButton));
	}

	protected int guiButtonWidth(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146120_f" : "field_73747_a", "width", guiButton));
	}

	protected int guiButtonXPosition(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146128_h" : "field_73746_c", "xPosition", guiButton));
	}

	protected int guiButtonYPosition(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146129_i" : "field_73743_d", "yPosition", guiButton));
	}

	protected void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		Modchu_Reflect.invokeMethod("Gui", "func_73732_a", "drawCenteredString", new Class[]{ Modchu_Reflect.loadClass("FontRenderer"), String.class, int.class, int.class, int.class }, gui, new Object[]{ fontRenderer, s, i, i2, i3 });
	}

	protected void guiIngameDrawString(String s, int i, int j, int k) {
		if (Modchu_Main.isServer) return;
		Object mc = minecraftGetMinecraft();
		if (mc != null); else return;
		Object ingameGUI = Modchu_Reflect.getFieldObject("Minecraft", "field_71456_v", "ingameGUI", minecraftGetMinecraft());
		if (ingameGUI != null) Modchu_Reflect.invokeMethod("Gui", "func_73731_b", "drawString", new Class[]{ Modchu_Reflect.loadClass("FontRenderer"), String.class, int.class, int.class, int.class }, ingameGUI, new Object[]{ minecraftFontRenderer(), s, i, j, k });
	}

	protected Object guiOptionsBackground() {
		return Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("Gui", "field_110325_k", "optionsBackground") : "/gui/background.png";
	}

	protected void guiScreenActionPerformed(Object guiScreen, Object guiButton) {
		Modchu_Reflect.invokeMethod("GuiScreen", "func_73875_a", "actionPerformed", new Class[]{ Modchu_Reflect.loadClass("GuiButton") }, guiScreen, new Object[]{ guiButton });
	}

	protected List guiScreenButtonList(Object guiScreen) {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146292_n" : "field_73887_h", "buttonList", guiScreen));
	}

	protected void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		Modchu_Reflect.invokeMethod("GuiScreen", "func_73863_a", "drawScreen", new Class[]{ int.class, int.class, float.class }, guiScreen, new Object[]{ i, i2, f });
	}

	protected Object guiScreenFontRenderer(Object guiScreen) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.getFieldObject("GuiScreen", "field_146289_q", "fontRendererObj", guiScreen) :
			Modchu_Reflect.getFieldObject("GuiScreen", "field_73886_k", "fontRenderer", guiScreen);
	}

	protected int guiScreenHeight(Object guiScreen) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146295_m" : "field_73881_g", "height", guiScreen));
	}

	protected int guiScreenWidth(Object guiScreen) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146294_l" : "field_73880_f", "width", guiScreen));
	}

	protected void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		Modchu_Reflect.invokeMethod("GuiSlot", "func_77219_a", "actionPerformed", new Class[]{ Modchu_Reflect.loadClass("GuiButton") }, guiSlot, new Object[]{ guiButton });
	}

	protected void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		Modchu_Reflect.invokeMethod("GuiSlot", "func_77211_a", "drawScreen", new Class[]{ int.class, int.class, float.class }, guiSlot, new Object[]{ i, i2, f });
	}

	protected void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		Modchu_Reflect.invokeMethod("GuiSlot", "func_77220_a", "registerScrollButtons",
				Modchu_Main.getMinecraftVersion() > 159 ? new Class[]{ int.class, int.class } : new Class[]{ List.class, int.class, int.class },
				guiSlot,
				Modchu_Main.getMinecraftVersion() > 159 ? new Object[]{ i, i2 } : new Object[]{ list, i, i2 });
	}

	protected void guiScreenFunc_175273_b(Object guiScreen, int i, int i1) {
		guiScreenFunc_175273_b(guiScreen, minecraftGetMinecraft(), i, i1);
	}

	protected void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
		Modchu_Reflect.invokeMethod("GuiScreen", "func_175273_b", new Class[]{ Modchu_Reflect.loadClass("Minecraft"), int.class, int.class }, guiScreen, new Object[]{ minecraft, i, i2 });
	}

	protected Object iBlockStateGetBlock(Object iBlockState) {
		return Modchu_Reflect.invokeMethod(iBlockState.getClass(), "func_179223_d", "getBlock", iBlockState);
	}

	protected Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return Modchu_Reflect.invokeMethod(inventory.getClass(), "func_70440_f", "armorItemInSlot", new Class[]{ int.class }, inventory, new Object[]{ i });
	}

	protected Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return Modchu_Reflect.invokeMethod(inventory.getClass(), "func_70301_a", "getStackInSlot", new Class[]{ int.class }, inventory, new Object[]{ i });
	}

	protected boolean isCamouflage(Object itemStackOrItemOrBlock) {
		if (itemStackOrItemOrBlock != null); else return false;
		Object block = getBlock(itemStackOrItemOrBlock);
		return isCamouflageCheck(block);
	}

	protected boolean isCamouflageCheck(Object block) {
		return block != null
				&& (Modchu_Reflect.loadClass("BlockLeaves").isInstance(block)
				| Modchu_Reflect.loadClass("BlockPumpkin").isInstance(block));
	}

	protected boolean isPumpkin(Object itemStackOrItemOrBlock) {
		if (itemStackOrItemOrBlock != null); else return false;
		Object block = getBlock(itemStackOrItemOrBlock);
		return block != null
				&& Modchu_Reflect.loadClass("BlockPumpkin").isInstance(block);
	}

	protected boolean isCtrlKeyDown() {
		return isMac() ? Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220) : Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
	}

	protected boolean isIntegratedServerRunning() {
		Object mc = minecraftGetMinecraft();
		if (mc != null); else return false;
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Minecraft", "func_71387_A", "isIntegratedServerRunning", mc));
	}

	protected boolean isLANWorld() {
		if (!isMuiti()) {
			Object theIntegratedServer = getIntegratedServer();
			if (theIntegratedServer != null
					&& Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(theIntegratedServer.getClass(), "func_71344_c", "getPublic", theIntegratedServer))) {
				return true;
			}
		}
		return false;
	}

	protected Object getIntegratedServer() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71437_Z", "theIntegratedServer", minecraftGetMinecraft());
	}

	protected boolean isMac() {
		return Modchu_Main.getMinecraftVersion() > 159 ? (Boolean)Modchu_Reflect.getFieldObject("Minecraft", "field_142025_a", "isRunningOnMac", minecraftGetMinecraft()) :
			Modchu_Reflect.invokeMethod("Minecraft", "func_71376_c", "getOs", minecraftGetMinecraft()) == Modchu_Reflect.getEnum("net.minecraft.util.EnumOS", "MACOS");
	}

	protected boolean isMuiti() {
		Object mc = minecraftGetMinecraft();
		if (mc != null); else return false;
		return Modchu_Reflect.invokeMethod("Minecraft", Modchu_Main.getMinecraftVersion() > 169 ? "func_147114_u" : "func_71391_r", "getNetHandler", mc) != null
				&& !Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Minecraft", "func_71356_B", "isSingleplayer", mc));
	}

	protected boolean isPlanter(Object itemStackOrItemOrBlock) {
		if (itemStackOrItemOrBlock != null); else return false;
		Object block = itemStackOrItemOrBlock;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItemOrBlock)) {
			block = getBlockItemStack(itemStackOrItemOrBlock);
		} else if (Modchu_Reflect.loadClass("Item").isInstance(itemStackOrItemOrBlock)) {
			block = blockGetBlockFromItem(itemStackOrItemOrBlock);
		}
		return isPlanterCheck(block);
	}

	protected boolean isPlanterCheck(Object itemStackOrBlock) {
		itemStackOrBlock = Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrBlock) ? getBlock(itemStackOrBlock) : itemStackOrBlock;
		if (Modchu_Main.getMinecraftVersion() > 169) {
			//Modchu_Debug.mDebug("isPlanter block.getClass()="+block.getClass());
			Class BlockMushroom = Modchu_Reflect.loadClass("BlockMushroom");
			Class BlockDoublePlant = Modchu_Reflect.loadClass("net.minecraft.block.BlockDoublePlant");
			Class BlockSapling = Modchu_Reflect.loadClass("net.minecraft.block.BlockSapling");
			Class BlockTallGrass = Modchu_Reflect.loadClass("net.minecraft.block.BlockTallGrass");
			return itemStackOrBlock != null
					&& (Modchu_Reflect.loadClass("BlockFlower").isInstance(itemStackOrBlock)
					| ((BlockDoublePlant != null
					&& BlockDoublePlant.isInstance(itemStackOrBlock)
					| BlockDoublePlant == null))
					| ((BlockMushroom != null
						&& BlockMushroom.isInstance(itemStackOrBlock)
						| BlockMushroom == null))
					| ((BlockSapling != null
						&& BlockSapling.isInstance(itemStackOrBlock)
						| BlockSapling == null))
					| ((BlockTallGrass != null
						&& BlockTallGrass.isInstance(itemStackOrBlock)
						| BlockTallGrass == null)));
		} else {
			return itemStackOrBlock != null
					&& (Modchu_Reflect.loadClass("BlockFlower").isInstance(itemStackOrBlock)
							| Modchu_Reflect.loadClass("BlockMushroom").isInstance(itemStackOrBlock)
							| Modchu_Reflect.loadClass("BlockSapling").isInstance(itemStackOrBlock)
							| Modchu_Reflect.loadClass("BlockTallGrass").isInstance(itemStackOrBlock));
		}
	}

	protected boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
	}

	protected boolean isSkull(Object itemStackOrItem) {
		int version = Modchu_Main.getMinecraftVersion();
		Object item = itemStackOrItem;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItem)) {
			item = itemStackGetItem(itemStackOrItem);
		}
		Object skull = version > 169 ? getItem("skull") : 
			version > 139 ? Modchu_Reflect.getFieldObject("Item", "field_82512_cj", "skull") : null;
		return skull != null
				&& skull.getClass().isInstance(item);
	}

	protected int itemArmorRenderIndex(Object itemArmor) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ItemArmor", "field_77880_c", "renderIndex", itemArmor));
	}

	protected int itemArmorGetColor(Object itemArmor, Object itemstack) {
		return Modchu_Reflect.loadClass("ItemArmor").isInstance(itemArmor) ? Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("ItemArmor", "func_82814_b", "getColor", new Class[]{ Modchu_Reflect.loadClass("ItemStack") }, itemArmor, new Object[]{ itemstack })) : -1;
	}

	protected Object itemArmorGetArmorMaterial(Object itemArmor) {
		return Modchu_Reflect.invokeMethod("ItemArmor", "func_82812_d", "getArmorMaterial", itemArmor);
	}

	protected String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod(armorMaterial.getClass(), "func_179242_c", armorMaterial));
	}

	protected Object itemSetPotionEffect(Object item, String s) {
		return Modchu_Reflect.invokeMethod("Item", "func_77631_c", "setPotionEffect", new Class[]{ String.class }, item, new Object[]{ s });
	}

	protected int itemItemID(Object item) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Item", "field_73438_a", "itemID", item));
	}

	protected Object itemItemRegistry() {
		return Modchu_Reflect.getFieldObject("Item", "field_150901_e", "itemRegistry");
	}

	protected int itemGetMetadata(Object item, int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Item", "func_110526_a", "getMetadata", item));
	}

	protected String potionHelperSugarEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77922_b", "sugarEffect"));
	}

	protected String potionHelperGhastTearEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77923_c", "ghastTearEffect"));
	}

	protected String potionHelperSpiderEyeEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77920_d", "spiderEyeEffect"));
	}

	protected String potionHelperFermentedSpiderEyeEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77921_e", "speckledMelonEffect"));
	}

	protected String potionHelperSpeckledMelonEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77918_f", "speckledMelonEffect"));
	}

	protected String potionHelperBlazePowderEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77919_g", "blazePowderEffect"));
	}

	protected String potionHelperMagmaCreamEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77931_h", "magmaCreamEffect"));
	}

	protected String potionHelperRedstoneEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77932_i", "redstoneEffect"));
	}

	protected String potionHelperGlowstoneEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77929_j", "glowstoneEffect"));
	}

	protected String potionHelperGunpowderEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_77930_k", "gunpowderEffect"));
	}

	protected String potionHelperGoldenCarrotEffect() {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("PotionHelper", "field_82818_l", "goldenCarrotEffect"));
	}

	protected Map registrySimpleRegistryObjects() {
		return registrySimpleRegistryObjects(itemItemRegistry());
	}

	protected Map registrySimpleRegistryObjects(Object registrySimple) {
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(registrySimple.getClass(), "field_82596_a", "registryObjects", registrySimple));
	}

	protected Object iBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Comparable comparable) {
		return Modchu_Reflect.invokeMethod("IBlockState", "func_177226_a", "withProperty", new Class[]{ iProperty.getClass(), Comparable.class }, blockGetDefaultState(blockOrIBlockState), new Object[]{ iProperty, comparable });
	}

	protected boolean itemIsFull3D(Object item) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Item", "func_77662_d", "isFull3D", item));
	}

	protected boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Item", "func_111207_a", "itemInteractionForEntity", new Class[]{ Modchu_Reflect.loadClass("ItemStack"), Modchu_Reflect.loadClass("EntityPlayer"), Modchu_Reflect.loadClass("EntityLivingBase") }, item, new Object[]{ itemstack, entityplayer, entityLivingBase }));
	}

	protected void itemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
		Modchu_Reflect.invokeMethod(itemModelMesher.getClass(), "func_177775_a", "register", new Class[]{ Modchu_Reflect.loadClass("Item"), int.class, Modchu_Reflect.loadClass("ModelResourceLocation") }, itemModelMesher, new Object[]{ item, i, modelResourceLocation });
	}

	protected List itemPotionGetEffects(Object itemPotion, Object itemStack) {
		return Modchu_CastHelper.List(Modchu_Reflect.invokeMethod("ItemPotion", "func_77832_l", "getEffects", new Class[]{ Modchu_Reflect.loadClass("ItemStack") }, itemPotion, new Object[]{ itemStack }));
	}

	protected Object[] itemItemsList() {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject("Item", "field_77698_e", "itemsList"));
	}

	protected Object itemSetTextureName(Object item, String s) {
		boolean flag = Modchu_Main.getMinecraftVersion() > 159;
		return Modchu_Reflect.invokeMethod("Item", flag ? "func_111206_d" : "func_71864_b", flag ? "setTextureName" : "setUnlocalizedName", new Class[]{ String.class }, item, new Object[]{ s });
	}

	protected Object itemSetUnlocalizedName(Object item, String s) {
		return Modchu_Reflect.invokeMethod("Item", "func_77655_b", "setUnlocalizedName", new Class[]{ String.class }, item, new Object[]{ s });
	}

	protected Object itemSetCreativeTab(Object item, Object creativeTabs) {
		return Modchu_Reflect.invokeMethod("Item", "func_71849_a", "setCreativeTab", new Class[]{ creativeTabs.getClass() }, item, new Object[]{ creativeTabs });
	}

	protected String itemIconString(Object item) {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("Item", "field_111218_cA", "iconString", item));
	}

	protected void setItemIconString(Object item, String s) {
		Modchu_Reflect.setFieldObject("Item", "field_111218_cA", "iconString", item, s);
	}

	protected Object itemItemIcon(Object item) {
		return Modchu_Reflect.getFieldObject("Item", "field_77791_bV", "itemIcon", item);
	}

	protected void setItemItemIcon(Object item, Object icon) {
		Modchu_Reflect.setFieldObject("Item", "field_77791_bV", "itemIcon", item, icon);
	}

	protected void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		Modchu_Reflect.invokeMethod("Item", "func_77659_a", "onItemRightClick", new Class[]{ Modchu_Reflect.loadClass("ItemStack"), Modchu_Reflect.loadClass("World"), Modchu_Reflect.loadClass("EntityPlayer") }, item, new Object[]{ itemStack, world, entityplayer });
	}

	protected Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		return Modchu_Reflect.invokeMethod(Modchu_Main.getMinecraftVersion() > 169 ? "net.minecraft.client.renderer.texture.iIconRegister" : "net.minecraft.client.renderer.texture.IconRegister", "func_94245_a", "registerIcon", new Class[]{ String.class }, iIconRegister, new Object[]{ s });
	}

	protected Object itemStackCopyItemStack(Object itemStack) {
		return Modchu_Reflect.invokeMethod("ItemStack", "func_77944_b", "copyItemStack", new Class[]{ Modchu_Reflect.loadClass("ItemStack") }, null, new Object[]{ itemStack });
	}

	protected Object itemStackGetItem(Object itemstack) {
		return Modchu_Reflect.invokeMethod("ItemStack", "func_77973_b", "getItem", itemstack);
	}

	protected int itemStackGetItemDamage(Object itemstack) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("ItemStack", "func_77960_j", "getItemDamage", itemstack));
	}

	protected int itemStackGetMaxDamage(Object itemstack) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("ItemStack", "func_77612_l", "getMaxDamage", itemstack));
	}

	protected Object itemStackGetItemUseAction(Object itemstack) {
		return Modchu_Reflect.invokeMethod("ItemStack", "func_77975_n", "getItemUseAction", itemstack);
	}

	protected boolean itemStackIsItemEnchanted(Object itemstack) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("ItemStack", "func_77948_v", "isItemEnchanted", itemstack));
	}

	protected boolean itemStackHasDisplayName(Object itemstack) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("ItemStack", "func_82837_s", "hasDisplayName", itemstack));
	}

	protected boolean itemShouldRotateAroundWhenRendering(Object item) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Item", "func_77629_n_", "shouldRotateAroundWhenRendering", item));
	}

	protected boolean itemStackHasTagCompound(Object itemStack) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("ItemStack", "func_77942_o", "hasTagCompound", itemStack));
	}

	protected Object itemStackGetTagCompound(Object nBTTagCompoundOrItemStack) {
		return Modchu_Reflect.loadClass("ItemStack").isInstance(nBTTagCompoundOrItemStack) ? Modchu_Reflect.invokeMethod("ItemStack", "func_77978_p", "getTagCompound", nBTTagCompoundOrItemStack) : nBTTagCompoundOrItemStack;
	}

	protected Multimap itemStackGetAttributeModifiers(Object itemStack) {
		return Modchu_CastHelper.Multimap(Modchu_Reflect.invokeMethod("ItemStack", "func_111283_C", "getAttributeModifiers", itemStack));
	}

	protected int itemStackGetMetadata(Object itemStack) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("ItemStack", "func_77647_b", "getMetadata", itemStack));
	}

	protected Enum itemCameraTransformsTransformTypeNONE() {
		Class c = Modchu_Reflect.loadClass("ItemCameraTransforms$TransformType");
		return Modchu_Reflect.getEnum(c, "NONE");
	}

	protected Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		Class c = Modchu_Reflect.loadClass("ItemCameraTransforms$TransformType");
		return Modchu_Reflect.getEnum(c, "THIRD_PERSON");
	}

	protected Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		Class c = Modchu_Reflect.loadClass("ItemCameraTransforms$TransformType");
		return Modchu_Reflect.getEnum(c, "FIRST_PERSON");
	}

	protected Enum itemCameraTransformsTransformTypeHEAD() {
		Class c = Modchu_Reflect.loadClass("ItemCameraTransforms$TransformType");
		return Modchu_Reflect.getEnum(c, "HEAD");
	}

	protected Enum itemCameraTransformsTransformTypeGUI() {
		Class c = Modchu_Reflect.loadClass("ItemCameraTransforms$TransformType");
		return Modchu_Reflect.getEnum(c, "GUI");
	}

	protected boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("NBTTagCompound", "func_74764_b", "hasKey", new Class[]{ String.class }, itemStackGetTagCompound(nBTTagCompoundOrItemStack), new Object[]{ s }));
	}

	protected boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s, int i) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("NBTTagCompound", "func_74764_b", "hasKey", new Class[]{ String.class, int.class }, itemStackGetTagCompound(nBTTagCompoundOrItemStack), new Object[]{ s, i }));
	}

	protected String nbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("NBTTagCompound", "func_74779_i", "getString", new Class[]{ String.class }, itemStackGetTagCompound(nBTTagCompoundOrItemStack), new Object[]{ s }));
	}

	protected void nbtTagCompoundSetTag(Object nBTTagCompound, String s, Object nbtBase) {
		Modchu_Reflect.invokeMethod("NBTTagCompound", "func_74782_a", "setTag", new Class[]{ String.class, nbtBase.getClass() }, nBTTagCompound, new Object[]{ s, nbtBase });
	}

	protected Object nbtTagCompoundGetCompoundTag(Object nBTTagCompoundOrItemStack, String s) {
		return Modchu_Reflect.invokeMethod("NBTTagCompound", "func_74775_l", "getCompoundTag", new Class[]{ String.class }, itemStackGetTagCompound(nBTTagCompoundOrItemStack), new Object[]{ s });
	}

	protected Object nbtUtilReadGameProfileFromNBT(Object nBTTagCompound) {
		return Modchu_Reflect.invokeMethod("net.minecraft.nbt.NBTUtil", "func_152459_a", new Class[]{ Modchu_Reflect.loadClass("NBTTagCompound") }, new Object[]{ nBTTagCompound });
	}

	protected Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return Modchu_Reflect.invokeMethod("net.minecraft.nbt.NBTUtil", "func_180708_a", "writeGameProfile", new Class[]{ Modchu_Reflect.loadClass("NBTTagCompound"), gameprofile.getClass() }, new Object[]{ nBTTagCompound, gameprofile });
	}

	protected Object tileEntitySkullRendererSkullRenderer() {
		int version = Modchu_Main.getMinecraftVersion();
		return Modchu_Reflect.getFieldObject("TileEntitySkullRenderer", version > 169 ? "field_147536_b" : "field_82397_a", version > 179 ? "instance" : version > 169 ? "field_147536_b" : "skullRenderer");
	}

	protected Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return Modchu_Reflect.invokeMethod("TileEntitySkull", "func_174884_b", "updateGameprofile", new Class[]{ gameprofile.getClass() }, new Object[]{ gameprofile });
	}

	protected void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, int i, float f3, int i2, Object gameProfile) {
		tileEntitySkullRendererRenderSkull(tileEntitySkullRendererSkullRenderer(), f, f1, f2, null, f3, i, gameProfile, i2);
	}

	protected void tileEntitySkullRendererRenderSkull(float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		tileEntitySkullRendererRenderSkull(tileEntitySkullRendererSkullRenderer(), f, f1, f2, en, f3, i, gameProfile, i2);
	}

	protected void tileEntitySkullRendererRenderSkull(Object skullRenderer, float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 179) {
			Modchu_Reflect.invokeMethod("net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer", "func_180543_a", "renderSkull", new Class[]{ float.class, float.class, float.class, Modchu_Reflect.loadClass("EnumFacing"), float.class, int.class, Modchu_Reflect.loadClass("com.mojang.authlib.GameProfile"), int.class }, skullRenderer, new Object[]{ f, f1, f2, en, f3, i, gameProfile, i2 });
		} else if (version > 172) {
			Modchu_Reflect.invokeMethod("net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer", "func_152674_a", new Class[]{ float.class, float.class, float.class, int.class, float.class, int.class, Modchu_Reflect.loadClass("com.mojang.authlib.GameProfile") }, skullRenderer, new Object[]{ f, f1, f2, i, f3, i2, gameProfile });
		} else {
			Modchu_Reflect.invokeMethod(skullRenderer.getClass(), Modchu_Main.getMinecraftVersion() > 169 ? "func_147530_a" : "func_82393_a", new Class[]{ float.class, float.class, float.class, int.class, float.class, int.class, String.class }, skullRenderer, new Object[]{ f, f1, f2, i, f3, i2, gameProfile });
		}
	}

	protected int itemStackItemID(Object itemstack) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ItemStack", "field_77993_c", "itemID", itemstack));
	}

	protected int itemStackStackSize(Object itemstack) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ItemStack", "field_77994_a", "stackSize", itemstack));
	}

	protected void setItemStackStackSize(Object itemstack, int i) {
		Modchu_Reflect.setFieldObject("ItemStack", "field_77994_a", "stackSize", itemstack, i);
	}

	protected String itemStackGetDisplayName(Object itemstack) {
		return Modchu_CastHelper.String(Modchu_Reflect.setFieldObject("ItemStack", "func_96678_d", "getDisplayName", itemstack));
	}

	protected void itemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		Modchu_Reflect.invokeMethod("ItemStack", "func_77972_a", "damageItem", new Class[]{ int.class, Modchu_Reflect.loadClass("EntityLivingBase") }, itemstack, new Object[]{ i, entityLivingBase });
	}

	protected boolean itemRequiresMultipleRenderPasses(Object item) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Item", "func_77623_v", "requiresMultipleRenderPasses", item));
	}

	protected int itemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Item", "func_82790_a", "getColorFromItemStack", new Class[]{ Modchu_Reflect.loadClass("ItemStack"), int.class }, item, new Object[]{ itemstack, i }));
	}

	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		return blockDoublePlantGetMixedBrightnessForBlock(blockDoublePlant, minecraftTheWorld(), x, y, z);
	}

	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object iBlockAccess, int x, int y, int z) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(blockDoublePlant.getClass(), "func_71874_e", "getMixedBrightnessForBlock", new Class[]{ Modchu_Reflect.loadClass("World"), int.class, int.class, int.class }, blockDoublePlant, new Object[]{ iBlockAccess, x, y, z }));
	}

	protected int blockDoublePlantColorMultiplier(Object blockDoublePlant, int x, int y, int z) {
		return blockDoublePlantColorMultiplier(blockDoublePlant, minecraftTheWorld(), x, y, z);
	}

	protected int blockDoublePlantColorMultiplier(Object blockDoublePlant, Object world, int x, int y, int z) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(blockDoublePlant.getClass(), "func_149720_d", "colorMultiplier", new Class[]{ Modchu_Reflect.loadClass("net.minecraft.world.IBlockAccess"), int.class, int.class, int.class }, blockDoublePlant, new Object[]{ world, x, y, z }));
	}

	protected int biomeGenBaseGetBiomeGrassColor(Object biomeGenBase) {
		return biomeGenBaseGetBiomeGrassColor(biomeGenBase, 0, 0, 0);
	}

	protected int biomeGenBaseGetBiomeGrassColor(Object biomeGenBase, int x, int y, int z) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(biomeGenBase.getClass(), "func_76737_k", "getBiomeGrassColor", new Class[]{ int.class, int.class, int.class }, biomeGenBase, new Object[]{ x, y, z })) :
			Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(biomeGenBase.getClass(), "func_76737_k", "getBiomeGrassColor", biomeGenBase));
	}

	protected boolean blockDoublePlantFunc_149887_c(int i) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("BlockDoublePlant", "func_149887_c", new Class[]{ int.class }, new Object[]{ i }));
	}

	protected int blockDoublePlantFunc_149890_d(int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("BlockDoublePlant", "func_149890_d", new Class[]{ int.class }, new Object[]{ i }));
	}

	protected Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		return Modchu_Reflect.invokeMethod(blockDoublePlant.getClass(), "func_149888_a", new Class[]{ boolean.class, int.class }, blockDoublePlant, new Object[]{ b, i });
	}

	protected Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.invokeMethod(blockDoublePlant.getClass(), "field_149891_b", "sunflowerIcons", blockDoublePlant));
	}

	protected double iIconGetMinU(Object iIcon) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("IIcon", "func_94209_e", "getMinU", iIcon));
	}

	protected double iIconGetMinV(Object iIcon) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("IIcon", "func_94206_g", "getMinV", iIcon));
	}

	protected double iIconGetMaxU(Object iIcon) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("IIcon", "func_94212_f", "getMaxU", iIcon));
	}

	protected double iIconGetMaxV(Object iIcon) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("IIcon", "func_94210_h", "getMaxV", iIcon));
	}

	protected String iAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod(iAttribute.getClass(), "func_111108_a", "getAttributeUnlocalizedName", iAttribute));
	}

	protected boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? Modchu_Main.getMinecraftVersion() > 169 ? Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(keyBinding.getClass(), "func_151470_d", "getIsKeyPressed", keyBinding)) : keyBindingPressed(keyBinding) : null;
	}

	protected List keybindArray() {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("KeyBinding", "field_74516_a", "keybindArray"));
	}

	protected boolean entityRendererAnaglyphEnable() {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("EntityRenderer", "field_78517_a", "anaglyphEnable"));
	}

	protected boolean keyBindingIsPressed(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(keyBinding.getClass(), "func_74509_c", "isPressed", keyBinding)) : false;
	}

	protected String keyBindingKeyCategory(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_151471_f", "keyCategory", keyBinding)) : null;
	}

	protected int keyBindingKeyCode(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_74512_d", "keyCode", keyBinding)) : -1;
	}

	protected String keyBindingKeyDescription(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_74515_c", "keyDescription", keyBinding)) : null;
	}

	protected boolean keyBindingPressed(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_74513_e", "pressed", keyBinding)) : false;
	}

	protected int keyBindingPressTime(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(keyBinding.getClass(), Modchu_Main.getMinecraftVersion() > 169 ? "field_151474_i" : "field_74511_f", "pressTime", keyBinding)) : 0;
	}

	protected boolean keyBindingSetPressed(Object keyBinding, boolean b) {
		return keyBinding != null ? Modchu_Reflect.setFieldObject(keyBinding.getClass(), "field_74513_e", "pressed", keyBinding, b) : false;
	}

	protected void loadingScreenDisplayLoadingString(String s) {
		loadingScreenDisplayLoadingString(minecraftLoadingScreen(), s);
	}

	protected void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		Modchu_Reflect.invokeMethod(loadingScreenRenderer.getClass(), "func_73719_c", "displayLoadingString", new Class[]{ String.class }, loadingScreenRenderer, new Object[]{ s });
	}

	protected void loadingScreenResetProgressAndMessage(String s) {
		loadingScreenResetProgressAndMessage(minecraftLoadingScreen(), s);
	}

	protected void loadingScreenResetProgressAndMessage(Object loadingScreenRenderer, String s) {
		Modchu_Reflect.invokeMethod(loadingScreenRenderer.getClass(), "func_73721_b", "resetProgressAndMessage", new Class[]{ String.class }, loadingScreenRenderer, new Object[]{ s });
	}

	protected void loadingScreenSetLoadingProgress(int i) {
		loadingScreenSetLoadingProgress(minecraftLoadingScreen(), i);
	}

	protected void loadingScreenSetLoadingProgress(Object loadingScreenRenderer, int i) {
		Modchu_Reflect.invokeMethod(loadingScreenRenderer.getClass(), "func_73718_a", "setLoadingProgress", new Class[]{ int.class }, loadingScreenRenderer, new Object[]{ i });
	}

	protected float mathHelperCos(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76134_b", "cos", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected double mathHelperFloor_double(double d) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("MathHelper", "func_76128_c", "floor_double", new Class[]{ double.class }, null, new Object[]{ d }));
	}

	protected float mathHelperFloor_float(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76141_d", "floor_float", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected float mathHelperWrapAngleTo180_float(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76142_g", "wrapAngleTo180_float", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected long mathHelperFloor_double_long(double d) {
		return Modchu_CastHelper.Long(Modchu_Reflect.invokeMethod("MathHelper", "func_76124_d", "floor_double_long", new Class[]{ double.class }, null, new Object[]{ d }));
	}

	protected float mathHelperAbs(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76135_e", "abs", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected double mathHelperAbs_max(double d, double d1) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("MathHelper", "func_76132_a", "abs_max", new Class[]{ double.class, double.class }, null, new Object[]{ d, d1 }));
	}

	protected int mathHelperBucketInt(int i, int j) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("MathHelper", "func_76137_a", "bucketInt", new Class[]{ int.class, int.class }, null, new Object[]{ i, j }));
	}

	protected boolean mathHelperStringNullOrLengthZero(String s) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("MathHelper", "func_76139_a", "stringNullOrLengthZero", new Class[]{ String.class }, null, new Object[]{ s }));
	}

	protected float mathHelperSin(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76126_a", "sin", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected float mathHelperSqrt_float(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76129_c", "sqrt_float", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected double mathHelperSqrt_double(double d) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("MathHelper", "func_76133_a", "sqrt_double", new Class[]{ double.class }, null, new Object[]{ d }));
	}

	protected Object minecraftCurrentScreen() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71462_r", "currentScreen", minecraftGetMinecraft());
	}

	protected Object minecraftMyNetworkManager() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71453_ak", "myNetworkManager", minecraftGetMinecraft());
	}

	protected void setMinecraftMyNetworkManager(Object iNetworkManager) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.setFieldObject("Minecraft", "field_71453_ak", "myNetworkManager", minecraftGetMinecraft(), iNetworkManager);
	}

	protected int minecraftDisplayHeight() {
		if (Modchu_Main.isServer) return -1;
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Minecraft", "field_71440_d", "displayHeight", minecraftGetMinecraft()));
	}

	protected int minecraftDisplayWidth() {
		if (Modchu_Main.isServer) return -1;
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Minecraft", "field_71443_c", "displayWidth", minecraftGetMinecraft()));
	}

	protected Object minecraftEntityRenderer() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71460_t", "entityRenderer", minecraftGetMinecraft());
	}

	protected Object minecraftEntityRendererItemRenderer() {
		if (Modchu_Main.isServer) return null;
		Object entityRenderer = minecraftEntityRenderer();
		return Modchu_Reflect.getFieldObject(entityRenderer.getClass(), "field_78516_c", "itemRenderer", entityRenderer);
	}

	protected Object minecraftFontRenderer() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71466_p", "fontRenderer", minecraftGetMinecraft());
	}

	protected void minecraftFontRenderer(Object fontRenderer) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.setFieldObject("Minecraft", "field_71466_p", "fontRenderer", minecraftGetMinecraft(), fontRenderer);
	}

	protected Object minecraftGameSettings() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71474_y", "gameSettings", minecraftGetMinecraft());
	}

	protected void minecraftGameSettingsSetThirdPersonView(int i) {
		if (Modchu_Main.isServer) return;
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74320_O", "thirdPersonView", gameSettings, i, 0);
	}

	protected int minecraftGameSettingsThirdPersonView() {
		if (Modchu_Main.isServer) return -1;
		Object gameSettings = minecraftGameSettings();
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74320_O", "thirdPersonView", gameSettings));
	}

	protected boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		if (Modchu_Main.isServer) return false;
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("GameSettings", "field_85185_A", "touchscreen", gameSettings));
	}

	protected Object minecraftGatSession() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod("Minecraft", "func_110432_I", "getSession", minecraftGetMinecraft());
	}

	protected Object minecraftGetMinecraft() {
		if (Modchu_Main.isServer) return null;
		Object o = null;
		if (getMinecraftMode == 0
				| getMinecraftMode == 1) {
			o = Modchu_Reflect.invokeMethod("Minecraft", "func_71410_x", -1);
			if (o != null) {
				getMinecraftMode = 1;
				return o;
			}
		}
		if (getMinecraftMode == 0
				| getMinecraftMode == 2) {
			o = Modchu_Reflect.invokeMethod("Minecraft", "getMinecraft");
			if (o != null) {
				getMinecraftMode = 2;
				return o;
			}
		}
		o = Modchu_Main.getMinecraftVersion() > 129 ? Modchu_Reflect.getPrivateValue("Minecraft", null, 8)
				: Modchu_Reflect.getPrivateValue("Minecraft", null, 1);
		if (o == null) {
			String s = "Modchu_Main-getMinecraft o == null !! loadClass(Minecraft)="+Modchu_Reflect.loadClass("Minecraft")+" isForge="+Modchu_Main.isForge+" getMinecraftVersion()="+Modchu_Main.getMinecraftVersion();
			Modchu_Debug.lDebug(s);
			throw new RuntimeException(s);
		}
		getMinecraftMode = 3;
		return o;
	}

	protected Object minecraftGetRenderItem() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod("Minecraft", "func_175599_af", "getRenderItem", minecraftGetMinecraft());
	}

	protected Object minecraftGetResourceManager() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod("Minecraft", "func_110442_L", "getResourceManager", minecraftGetMinecraft());
	}

	protected long minecraftGetSystemTime() {
		if (Modchu_Main.isServer) return -1;
		return Modchu_CastHelper.Long(Modchu_Reflect.invokeMethod("Minecraft", "func_71386_F", "getSystemTime", minecraftGetMinecraft()));
	}

	protected Object minecraftGetTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod("Minecraft", "func_110434_K", "getTextureManager", minecraftGetMinecraft());
	}

	protected boolean minecraftInGameHasFocus() {
		if (Modchu_Main.isServer) return false;
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("Minecraft", "field_71415_G", "inGameHasFocus", minecraftGetMinecraft()));
	}

	protected File minecraftMcDataDir() {
		if (Modchu_Main.isServer) return new File(".");
		File file = (File) (Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("Minecraft", "field_71412_D", minecraftGetMinecraft(), -1) :
			Modchu_Reflect.invokeMethod("Minecraft", "func_71380_b", minecraftGetMinecraft(), -1));
		if (file != null) return file;
		file = (File) (Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("Minecraft", "mcDataDir", minecraftGetMinecraft()) :
			Modchu_Reflect.invokeMethod("Minecraft", "getMinecraftDir", minecraftGetMinecraft()));
		return file;
	}

	protected Object minecraftGetBlockRendererDispatcher() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod("Minecraft", "func_175602_ab", "getBlockRendererDispatcher", minecraftGetMinecraft());
	}

	protected Object minecraftLoadingScreen() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71461_s", "loadingScreen", minecraftGetMinecraft());
	}

	protected void setMinecraftLoadingScreen(Object loadingScreenRenderer) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.setFieldObject("Minecraft", "field_71461_s", "loadingScreen", minecraftGetMinecraft(), loadingScreenRenderer);
	}

	protected Object minecraftPlayerController() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71442_b", "playerController", minecraftGetMinecraft());
	}

	protected Object minecraftSession() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71449_j", "session", minecraftGetMinecraft());
	}

	protected void minecraftSetDimensionAndSpawnPlayer() {
		if (Modchu_Main.isServer) return;
		Object thePlayer = minecraftThePlayer();
		minecraftSetDimensionAndSpawnPlayer(Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", "field_71093_bK", "dimension", thePlayer)));
	}

	protected void minecraftSetDimensionAndSpawnPlayer(int i) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.invokeMethod("Minecraft", "func_71354_a", "setDimensionAndSpawnPlayer", new Class[]{ int.class }, minecraftGetMinecraft(), new Object[]{ i });
	}

	protected long minecraftSystemTime() {
		if (Modchu_Main.isServer) return -1;
		return Modchu_CastHelper.Long(Modchu_Reflect.getFieldObject("Minecraft", "field_71423_H", "systemTime", minecraftGetMinecraft()));
	}

	protected Object minecraftTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71446_o", "renderEngine", minecraftGetMinecraft());
	}

	protected Object minecraftThePlayer() {
		if (Modchu_Main.isServer) return null;
/*
		Modchu_Debug.Debug("getThePlayer mc="+(mc != null));
		Field[] f = getMinecraft().getClass().getDeclaredFields();
		for(int i = 0; i < f.length; i++) {
			Modchu_Debug.mlDebug("getThePlayer i="+i+" "+f[i].getName());
		}
*/
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71439_g", "thePlayer", minecraftGetMinecraft());
	}

	protected Object minecraftTheWorld() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71441_e", "theWorld", minecraftGetMinecraft());
	}

	protected Object minecraftDisplayGuiScreen() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71462_r", "currentScreen", minecraftGetMinecraft());
	}

	protected Object minecraftGetIntegratedServer() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod("Minecraft", "func_71401_C", "getIntegratedServer", minecraftGetMinecraft());
	}

	protected Object minecraftServerGetServer() {
		return Modchu_Reflect.invokeMethod("net.minecraft.server.MinecraftServer", "func_71276_C", "getServer");
	}

	protected Object[] minecraftServerGetServerWorldServers() {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject("net.minecraft.server.MinecraftServer", "field_71305_c", "worldServers", minecraftServerGetServer()));
	}

	protected File minecraftServerGetFile(String s) {
		return Modchu_CastHelper.File(Modchu_Reflect.invokeMethod("net.minecraft.server.MinecraftServer", "func_71209_f", "getFile", new Class[]{ String.class }, minecraftServerGetServer(), new Object[]{ s }));
	}

	protected Object minecraftServerGetConfigurationManager(Object minecraftServer) {
		return Modchu_Reflect.invokeMethod("MinecraftServer", "func_71203_ab", "getConfigurationManager", minecraftServer);
	}

	protected String minecraftLaunchedVersion() {
		return minecraftLaunchedVersion(minecraftGetMinecraft());
	}

	protected String minecraftLaunchedVersion(Object minecraft) {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("Minecraft", "field_110447_Z", "launchedVersion", minecraft));
	}

	protected void minecraftUpdateFramebufferSize() {
		minecraftUpdateFramebufferSize(minecraftGetMinecraft());
	}

	protected void minecraftUpdateFramebufferSize(Object minecraft) {
		if (Modchu_Main.isServer
				| Modchu_Main.getMinecraftVersion() < 170) return;
		Modchu_Reflect.invokeMethod("Minecraft", "func_147119_ah", "updateFramebufferSize", minecraft);
	}

	protected Object modelRightArm(Object model) {
		if (Modchu_Main.isVanillaModel(model)) {
			if (Modchu_Reflect.loadClass("ModelBiped").isInstance(model)) return modelBipedBipedRightArm(model);
			if (Modchu_Reflect.loadClass("ModelQuadruped").isInstance(model)) return modelQuadrupedLeg1(model);
			if (Modchu_Reflect.loadClass("ModelBat").isInstance(model)) return modelBatBatRightWing(model);
			if (Modchu_Reflect.loadClass("ModelChicken").isInstance(model)) return modelChickenRightWing(model);
			if (Modchu_Reflect.loadClass("ModelCreeper").isInstance(model)) return modelCreeperLeg1(model);
			if (Modchu_Reflect.loadClass("ModelHorse").isInstance(model)) return modelHorseFrontRightLeg(model);
			if (Modchu_Reflect.loadClass("ModelIronGolem").isInstance(model)) return modelIronGolemIronGolemRightArm(model);
			if (Modchu_Reflect.loadClass("ModelOcelot").isInstance(model)) return modelOcelotOcelotFrontRightLeg(model);
			if (Modchu_Reflect.loadClass("ModelSnowMan").isInstance(model)) return modelSnowManRightHand(model);
			if (Modchu_Reflect.loadClass("ModelSpider").isInstance(model)) return modelSpiderSpiderLeg1(model);
			if (Modchu_Reflect.loadClass("ModelWolf").isInstance(model)) return modelWolfWolfLeg1(model);
			if (Modchu_Reflect.loadClass("ModelSquid").isInstance(model)) {
				Object[] o = modelSquidSquidTentacles(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
			if (Modchu_Reflect.loadClass("ModelBlaze").isInstance(model)) {
				Object[] o = modelBlazeBlazeSticks(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
			if (Modchu_Reflect.loadClass("ModelGhast").isInstance(model)) {
				Object[] o = modelGhastTentacles(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
		}
		return Modchu_Reflect.getFieldObject(model.getClass(), "bipedRightArm", model);
	}

	protected Object modelBipedBipedRightArm(Object modelBiped) {
		return Modchu_Reflect.getFieldObject(modelBiped.getClass(), "field_78112_f", "bipedRightArm", modelBiped);
	}

	protected void setModelBipedBipedRightArm(Object modelBiped, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelBiped.getClass(), "field_78112_f", "bipedRightArm", modelBiped, modelRenderer);
	}

	protected Object modelWolfWolfLeg1(Object modelWolf) {
		return Modchu_Reflect.getFieldObject(modelWolf.getClass(), "field_78184_c", "wolfLeg1", modelWolf);
	}

	protected void setModelWolfWolfLeg1(Object modelWolf, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelWolf.getClass(), "field_78184_c", "wolfLeg1", modelWolf, modelRenderer);
	}

	protected Object modelSnowManRightHand(Object modelSnowMan) {
		return Modchu_Reflect.getFieldObject(modelSnowMan.getClass(), "field_78192_d", "rightHand", modelSnowMan);
	}

	protected void setModelSnowManRightHand(Object modelSnowMan, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelSnowMan.getClass(), "field_78192_d", "rightHand", modelSnowMan, modelRenderer);
	}

	protected Object modelSpiderSpiderLeg1(Object modelSpider) {
		return Modchu_Reflect.getFieldObject(modelSpider.getClass(), "field_78205_d", "spiderLeg1", modelSpider);
	}

	protected void setModelSpiderSpiderLeg1(Object modelSpider, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelSpider.getClass(), "field_78205_d", "spiderLeg1", modelSpider, modelRenderer);
	}

	protected Object modelOcelotOcelotFrontRightLeg(Object modelOcelot) {
		return Modchu_Reflect.getFieldObject(modelOcelot.getClass(), "field_78157_d", "ocelotFrontRightLeg", modelOcelot);
	}

	protected void setModelOcelotOcelotFrontRightLeg(Object modelOcelot, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelOcelot.getClass(), "field_78157_d", "ocelotFrontRightLeg", modelOcelot, modelRenderer);
	}

	protected Object modelIronGolemIronGolemRightArm(Object modelIronGolem) {
		return Modchu_Reflect.getFieldObject(modelIronGolem.getClass(), "field_78177_c", "ironGolemRightArm", modelIronGolem);
	}

	protected void setModelIronGolemIronGolemRightArm(Object modelIronGolem, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelIronGolem.getClass(), "field_78177_c", "ironGolemRightArm", modelIronGolem, modelRenderer);
	}

	protected Object modelQuadrupedLeg1(Object modelQuadruped) {
		return Modchu_Reflect.getFieldObject(modelQuadruped.getClass(), "field_78131_d", "leg1", modelQuadruped);
	}

	protected void setModelQuadrupedLeg1(Object modelQuadruped, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelQuadruped.getClass(), "field_78131_d", "leg1", modelQuadruped, modelRenderer);
	}

	protected Object modelCreeperLeg1(Object modelCreeper) {
		return Modchu_Reflect.getFieldObject(modelCreeper.getClass(), "field_78149_c", "leg1", modelCreeper);
	}

	protected void setModelCreeperLeg1(Object modelCreeper, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelCreeper.getClass(), "field_78149_c", "leg1", modelCreeper, modelRenderer);
	}

	protected Object modelHorseFrontRightLeg(Object modelHorse) {
		return Modchu_Reflect.getFieldObject(modelHorse.getClass(), "field_110688_A", "frontRightLeg", modelHorse);
	}

	protected void setModelHorseFrontRightLeg(Object modelHorse, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelHorse.getClass(), "field_110688_A", "frontRightLeg", modelHorse, modelRenderer);
	}

	protected Object modelBatBatRightWing(Object modelBat) {
		return Modchu_Reflect.getFieldObject(modelBat.getClass(), "field_82894_c", "batRightWing", modelBat);
	}

	protected void setModelBatBatRightWing(Object modelBat, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelBat.getClass(), "field_82894_c", "batRightWing", modelBat, modelRenderer);
	}

	protected Object[] modelSquidSquidTentacles(Object modelSquid) {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(modelSquid.getClass(), "field_78201_b", "squidTentacles", modelSquid));
	}

	protected void setModelSquidSquidTentacles(Object modelSquid, Object[] modelRenderer) {
		Modchu_Reflect.setFieldObject(modelSquid.getClass(), "field_78201_b", "squidTentacles", modelSquid, modelRenderer);
	}

	protected Object[] modelBlazeBlazeSticks(Object modelBlaze) {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(modelBlaze.getClass(), "field_78106_a", "blazeSticks", modelBlaze));
	}

	protected void setModelBlazeBlazeSticks(Object modelBlaze, Object[] modelRenderer) {
		Modchu_Reflect.setFieldObject(modelBlaze.getClass(), "field_78106_a", "blazeSticks", modelBlaze, modelRenderer);
	}

	protected Object[] modelGhastTentacles(Object modelGhast) {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(modelGhast.getClass(), "field_78127_b", "tentacles", modelGhast));
	}

	protected void setModelGhastTentacles(Object modelBlaze, Object[] modelRenderer) {
		Modchu_Reflect.setFieldObject(modelBlaze.getClass(), "field_78127_b", "tentacles", modelBlaze, modelRenderer);
	}

	protected Object modelChickenRightWing(Object modelChicken) {
		return Modchu_Reflect.getFieldObject(modelChicken.getClass(), "field_78139_e", "rightWing", modelChicken);
	}

	protected void setModelChickenRightWing(Object modelChicken, Object modelRenderer) {
		Modchu_Reflect.setFieldObject(modelChicken.getClass(), "field_78139_e", "rightWing", modelChicken, modelRenderer);
	}

	protected boolean modelBaseIsChild(Object modelBase) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("ModelBase", "field_78091_s", "isChild", modelBase));
	}

	protected void setModelBaseIsChild(Object modelBase, boolean b) {
		Modchu_Reflect.setFieldObject("ModelBase", "field_78091_s", "isChild", modelBase, b);
	}

	protected List modelBaseBoxList(Object modelBase) {
		if (!Modchu_Reflect.loadClass("ModelBase").isInstance(modelBase)) {
			return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(modelBase.getClass(), "boxList", modelBase));
		}
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("ModelBase", "field_78092_r", "boxList", modelBase));
	}

	protected void setModelBaseBoxList(Object modelBase, List list) {
		if (!Modchu_Reflect.loadClass("ModelBase").isInstance(modelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "boxList", modelBase, list);
			return;
		}
		Modchu_Reflect.setFieldObject("ModelBase", "field_78092_r", "boxList", modelBase, list);
	}

	protected int modelBaseTextureWidth(Object modelBase) {
		if (!Modchu_Reflect.loadClass("ModelBase").isInstance(modelBase)) {
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureWidth", modelBase));
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ModelBase", "field_78801_a", "textureWidth", modelBase));
	}

	protected void setModelBaseTextureWidth(Object modelBase, int i) {
		if (!Modchu_Reflect.loadClass("ModelBase").isInstance(modelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureWidth", modelBase, i);
			return;
		}
		Modchu_Reflect.setFieldObject("ModelBase", "field_78801_a", "textureWidth", modelBase, i);
	}

	protected int modelBaseTextureHeight(Object modelBase) {
		if (!Modchu_Reflect.loadClass("ModelBase").isInstance(modelBase)) {
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureHeight", modelBase));
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ModelBase", "field_78799_b", "textureHeight", modelBase));
	}

	protected void setModelBaseTextureHeight(Object modelBase, int i) {
		if (!Modchu_Reflect.loadClass("ModelBase").isInstance(modelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureHeight", modelBase, i);
			return;
		}
		Modchu_Reflect.setFieldObject("ModelBase", "", "textureHeight", modelBase, i);
	}

	protected Object modelBaseRender(Object model, Object entity, float f, float f2, float f3, float f4, float f5, float f6) {
		return Modchu_Reflect.invokeMethod("ModelBase", "func_78088_a", "render", new Class[]{ Modchu_Reflect.loadClass("Entity"), float.class, float.class, float.class, float.class, float.class, float.class }, model, new Object[]{ entity, f, f2, f3, f4, f5, f6 });
	}

	protected void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		Modchu_Reflect.invokeMethod("ModelBase", "func_78086_a", "setLivingAnimations", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), float.class, float.class, float.class }, model, new Object[]{ entity, f, f1, f2 });
	}

	protected void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		Modchu_Reflect.invokeMethod("ModelBase", "func_78087_a", "setRotationAngles", new Class[]{ float.class, float.class, float.class, float.class, float.class, float.class, Modchu_Reflect.loadClass("Entity") }, model, new Object[]{ f, f1, f2, f3, f4, f5, entity });
	}

	protected ConcurrentHashMap modelRendererGetTextureOffsetMap(Object modelRenderer) {
		return (ConcurrentHashMap) Modchu_Reflect.invokeMethod(modelRenderer.getClass(), "getTextureOffsetMap", modelRenderer);
	}

	protected int movingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		if (Modchu_Main.getMinecraftVersion() > 179) {
			Object blockPos = Modchu_Reflect.invokeMethod(movingObjectPosition.getClass(), "func_178782_a", movingObjectPosition);
			return blockPos != null ? Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(blockPos.getClass(), "func_177958_n", "getX", blockPos)) : -1;
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(movingObjectPosition.getClass(), "field_72311_b", "blockX", movingObjectPosition));
	}

	protected int movingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		if (Modchu_Main.getMinecraftVersion() > 179) {
			Object blockPos = Modchu_Reflect.invokeMethod(movingObjectPosition.getClass(), "func_178782_a", movingObjectPosition);
			return blockPos != null ? Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(blockPos.getClass(), "func_82617_b", "getY", blockPos)) : -1;
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(movingObjectPosition.getClass(), "field_72312_c", "blockY", movingObjectPosition));
	}

	protected int movingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		if (Modchu_Main.getMinecraftVersion() > 179) {
			Object blockPos = Modchu_Reflect.invokeMethod(movingObjectPosition.getClass(), "func_178782_a", movingObjectPosition);
			return blockPos != null ? Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(blockPos.getClass(), "func_177952_p", "getZ", blockPos)) : -1;
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(movingObjectPosition.getClass(), "field_72309_d", "blockZ", movingObjectPosition));
	}

	protected int movingObjectPositionSideHit(Object movingObjectPosition) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(movingObjectPosition.getClass(), "field_72310_e", "sideHit", movingObjectPosition));
	}

	protected Enum movingObjectPositionTypeOfHit(Object movingObjectPosition) {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getFieldObject(movingObjectPosition.getClass(), "field_72313_a", "typeOfHit", movingObjectPosition));
	}

	protected Enum movingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		Enum typeOfHit = movingObjectPositionTypeOfHit(movingObjectPosition);
		return Modchu_CastHelper.Enum(Modchu_Reflect.getFieldObject(typeOfHit.getClass(), "MISS", typeOfHit));
	}

	protected Enum movingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		Enum typeOfHit = movingObjectPositionTypeOfHit(movingObjectPosition);
		return Modchu_CastHelper.Enum(Modchu_Reflect.getFieldObject(typeOfHit.getClass(), "BLOCK", typeOfHit));
	}

	protected Enum movingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		Enum typeOfHit = movingObjectPositionTypeOfHit(movingObjectPosition);
		return Modchu_CastHelper.Enum(Modchu_Reflect.getFieldObject(typeOfHit.getClass(), "ENTITY", typeOfHit));
	}

	protected Object movingObjectPositionHitVec(Object movingObjectPosition) {
		return Modchu_Reflect.getFieldObject(movingObjectPosition.getClass(), "field_72307_f", "hitVec", movingObjectPosition);
	}

	protected Object newInstanceKeyBinding(String s, int i, String s2) {
		if (Modchu_Main.isServer) return null;
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.newInstance("KeyBinding", new Class[]{ String.class, int.class, String.class }, new Object[]{ s, i, s2 }) : Modchu_Reflect.newInstance("KeyBinding", new Class[]{ String.class, int.class }, new Object[]{ s, i });
	}

	protected Object newModelRenderer(Object[] pArg) {
		Class[] cl = new Class[pArg.length];
		for (int i = 0; i < cl.length; i++) {
			cl[i] = unWrappingClass(pArg[i].getClass());
		}
		cl[0] = Modchu_Reflect.loadClass("ModelBase");
		return Modchu_Reflect.newInstance("ModelRenderer", cl, pArg);
	}

	protected Object modelRendererAddBox(Object[] pArg) {
		Object[] o = instanceCut(pArg);
		return Modchu_Reflect.invokeMethod("ModelRenderer", o.length > 7 ? "func_78789_a" : o.length > 6 ? "func_78790_a" : "func_78786_a", "addBox", objectArrayGetClass(o), pArg[0], o);
	}

	protected void modelRendererSetRotationPoint(Object modelRenderer, float f, float f1, float f2 ) {
		Modchu_Reflect.invokeMethod("ModelRenderer", "func_78793_a", "setRotationPoint", new Class[]{ float.class, float.class, float.class }, modelRenderer, new Object[]{ f, f1, f2 });
	}

	protected boolean modelRendererShowModel(Object modelRenderer) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("ModelRenderer", "field_78806_j", "showModel", modelRenderer));
	}

	protected void setModelRendererShowModel(Object modelRenderer, boolean b) {
		Modchu_Reflect.setFieldObject("ModelRenderer", "field_78806_j", "showModel", modelRenderer, b);
	}

	protected float modelRendererRotateAngleX(Object modelRenderer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("ModelRenderer", "field_78795_f", "rotateAngleX", modelRenderer));
	}

	protected void setModelRendererRotateAngleX(Object modelRenderer, float f) {
		Modchu_Reflect.setFieldObject("ModelRenderer", "field_78795_f", "rotateAngleX", modelRenderer, f);
	}

	protected float modelRendererRotateAngleY(Object modelRenderer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("ModelRenderer", "field_78796_g", "rotateAngleY", modelRenderer));
	}

	protected void setModelRendererRotateAngleY(Object modelRenderer, float f) {
		Modchu_Reflect.setFieldObject("ModelRenderer", "field_78796_g", "rotateAngleY", modelRenderer, f);
	}

	protected float modelRendererRotateAngleZ(Object modelRenderer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("ModelRenderer", "field_78808_h", "rotateAngleZ", modelRenderer));
	}

	protected void setModelRendererRotateAngleZ(Object modelRenderer, float f) {
		Modchu_Reflect.setFieldObject("ModelRenderer", "field_78808_h", "rotateAngleZ", modelRenderer, f);
	}

	protected float modelRendererRotationPointX(Object modelRenderer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("ModelRenderer", "field_78800_c", "rotationPointX", modelRenderer));
	}

	protected void setModelRendererRotationPointX(Object modelRenderer, float f) {
		Modchu_Reflect.setFieldObject("ModelRenderer", "field_78800_c", "rotationPointX", modelRenderer, f);
	}

	protected float modelRendererRotationPointY(Object modelRenderer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("ModelRenderer", "field_78797_d", "rotationPointY", modelRenderer));
	}

	protected void setModelRendererRotationPointY(Object modelRenderer, float f) {
		Modchu_Reflect.setFieldObject("ModelRenderer", "field_78797_d", "rotationPointY", modelRenderer, f);
	}

	protected float modelRendererRotationPointZ(Object modelRenderer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("ModelRenderer", "field_78798_e", "rotationPointZ", modelRenderer));
	}

	protected void setModelRendererRotationPointZ(Object modelRenderer, float f) {
		Modchu_Reflect.setFieldObject("ModelRenderer", "field_78798_e", "rotationPointZ", modelRenderer, f);
	}

	protected void modelRendererRender(Object modelRenderer, float f) {
		Modchu_Reflect.invokeMethod("ModelRenderer", "func_78785_a", "render", new Class[]{ float.class }, modelRenderer, new Object[]{ f });
	}

	protected void modelRendererPostRender(Object modelRenderer, float f) {
		Modchu_Reflect.invokeMethod("ModelRenderer", "func_78794_c", "postRender", new Class[]{ float.class }, modelRenderer, new Object[]{ f });
	}

	protected void modelRendererRenderWithRotation(Object modelRenderer, float f) {
		Modchu_Reflect.invokeMethod("ModelRenderer", "func_78791_b", "renderWithRotation", new Class[]{ float.class }, modelRenderer, new Object[]{ f });
	}

	protected Object[] modelBoxVertexPositions(Object modelBox) {
		Object[] o = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(modelBox.getClass(), "vertexPositions", modelBox));
		if (o != null) return o;
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(modelBox.getClass(), "field_78253_h", "vertexPositions", modelBox));
	}

	protected void setModelBoxVertexPositions(Object modelBox, Object vertexPositions) {
		boolean b = Modchu_Reflect.setFieldObject(modelBox.getClass(), "vertexPositions", modelBox, vertexPositions);
		if (!b) b = Modchu_Reflect.setFieldObject(modelBox.getClass(), "field_78253_h", modelBox, vertexPositions);
		if (!b) Modchu_Reflect.setFieldObject(modelBox.getClass(), "field_78239_a", modelBox, vertexPositions);
	}

	protected Object[] modelBoxQuadList(Object modelBox) {
		Object[] o = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(modelBox.getClass(), "quadList", modelBox));
		if (o != null) return o;
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(modelBox.getClass(), "field_78254_i", "quadList", modelBox));
	}

	protected void setModelBoxQuadList(Object modelBox, Object quadList) {
		boolean b = Modchu_Reflect.setFieldObject(modelBox.getClass(), "quadList", modelBox, quadList);
		if (!b) Modchu_Reflect.setFieldObject(modelBox.getClass(), "field_78254_i", "quadList", modelBox, quadList);
	}

	protected boolean nbttagcompoundGetBoolean(Object nbttagcompound, String s) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74767_n", "getBoolean", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetBoolean(Object nbttagcompound, String s, boolean b) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74757_a", "setBoolean", new Class[]{ boolean.class, String.class }, nbttagcompound, new Object[]{ s, b });
	}

	protected String nbttagcompoundGetString(Object nbttagcompound, String s) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74779_i", "getString", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetString(Object nbttagcompound, String s, String s1) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74778_a", "setString", new Class[]{ String.class, String.class }, nbttagcompound, new Object[]{ s, s1 });
	}

	protected int nbttagcompoundGetInteger(Object nbttagcompound, String s) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74762_e", "getInteger", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetInteger(Object nbttagcompound, String s, int i) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74768_a", "setInteger", new Class[]{ int.class, String.class }, nbttagcompound, new Object[]{ s, i });
	}

	protected float nbttagcompoundGetFloat(Object nbttagcompound, String s) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74760_g", "getFloat", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetFloat(Object nbttagcompound, String s, float f) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74776_a", "setFloat", new Class[]{ float.class, String.class }, nbttagcompound, new Object[]{ s, f });
	}

	protected double nbttagcompoundGetDouble(Object nbttagcompound, String s) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74769_h", "getDouble", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetDouble(Object nbttagcompound, String s, double d) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74780_a", "setDouble", new Class[]{ double.class, String.class }, nbttagcompound, new Object[]{ s, d });
	}

	protected short nbttagcompoundGetShort(Object nbttagcompound, String s) {
		return Modchu_CastHelper.Short(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74765_d", "getShort", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetShort(Object nbttagcompound, String s, short sh) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74777_a", "setShort", new Class[]{ short.class, String.class }, nbttagcompound, new Object[]{ s, sh });
	}

	protected long nbttagcompoundGetLong(Object nbttagcompound, String s) {
		return Modchu_CastHelper.Long(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74763_f", "getLong", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetLong(Object nbttagcompound, String s, long l) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74772_a", "setLong", new Class[]{ long.class, String.class }, nbttagcompound, new Object[]{ s, l });
	}

	protected byte nbttagcompoundGetByte(Object nbttagcompound, String s) {
		return Modchu_CastHelper.Byte(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74771_c", "getByte", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetByte(Object nbttagcompound, String s, byte by) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74774_a", "setByte", new Class[]{ byte.class, String.class }, nbttagcompound, new Object[]{ s, by });
	}

	protected byte[] nbttagcompoundGetByteArray(Object nbttagcompound, String s) {
		return Modchu_CastHelper.ByteArray(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74770_j", "getByteArray", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetByteArray(Object nbttagcompound, String s, byte[] by) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74773_a", "setByteArray", new Class[]{ byte[].class, String.class }, nbttagcompound, new Object[]{ s, by });
	}

	protected int[] nbttagcompoundGetIntArray(Object nbttagcompound, String s) {
		return Modchu_CastHelper.IntArray(Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74759_k", "getIntArray", new Class[]{ String.class }, nbttagcompound, new Object[]{ s }));
	}

	protected void nbttagcompoundSetIntArray(Object nbttagcompound, String s, int[] in) {
		Modchu_Reflect.invokeMethod(nbttagcompound.getClass(), "func_74783_a", "setIntArray", new Class[]{ int[].class, String.class }, nbttagcompound, new Object[]{ s, in });
	}

	protected Object netClientHandlerGetNetManager(Object netClientHandler) {
		return Modchu_Reflect.invokeMethod(netClientHandler.getClass(), "func_72548_f", "getNetManager", netClientHandler);
	}

	protected void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
		Modchu_Reflect.invokeMethod(netClientHandler.getClass(), "func_72458_a", "handleClientCommand", new Class[]{ packet205ClientCommand.getClass() }, netClientHandler, new Object[]{ packet205ClientCommand });
	}

	protected Object oldVersionItem(String s) {
		if (!initOldVersionItemMap) {
			oldVersionItemMap = new ConcurrentHashMap();
			String[] s1 = new String[]{
					"map",
					"sugar",
					"dye",
					"diamond_helmet",
					"diamond_chestplate",
					"diamond_leggings",
					"diamond_boots",
					"blaze_rod",
					"redstone",
					"waterStill",
					"waterMoving"
			};
			Object[] s2 = new Object[]{
					Modchu_Reflect.getFieldObject("Item", "field_77744_bd", "map"),
					Modchu_Reflect.getFieldObject("Item", "field_77747_aY", "sugar"),
					Modchu_Reflect.getFieldObject("Item", "field_77756_aW", "dyePowder"),
					Modchu_Reflect.getFieldObject("Item", "field_77820_ah", "helmetDiamond"),
					Modchu_Reflect.getFieldObject("Item", "field_77798_ai", "plateDiamond"),
					Modchu_Reflect.getFieldObject("Item", "field_77800_aj", "legsDiamond"),
					Modchu_Reflect.getFieldObject("Item", "field_77794_ak", "bootsDiamond"),
					Modchu_Reflect.getFieldObject("Item", "field_77731_bo", "blazeRod"),
					Modchu_Reflect.getFieldObject("Item", "field_77767_aC", "redstone"),
					Modchu_Reflect.getFieldObject("Block", "field_71943_B", "waterStill"),
					Modchu_Reflect.getFieldObject("Block", "field_71942_A", "waterMoving")
			};
			for(int i = 0; i < s1.length
					&& i < s2.length; i++) {
				oldVersionItemMap.put(s1[i], s2[i]);
			}
			initOldVersionItemMap = true;
		}
		if (!oldVersionItemMap.containsKey(s)) {
			Modchu_Main.setRuntimeException("oldVersionItemMap s="+s+" is null !!");
			return null;
		}
		return oldVersionItemMap.get(s);
	}

	protected Object oldVersionBlock(String s) {
		if (!initOldVersionBlockMap) {
			oldVersionBlockMap = new ConcurrentHashMap();
			String[] s1 = new String[]{
					//"",
			};
			Object[] s2 = new Object[]{
					//Modchu_Reflect.getFieldObject("Block", "", ""),
			};
			for(int i = 0; i < s1.length
					&& i < s2.length; i++) {
				oldVersionBlockMap.put(s1[i], s2[i]);
			}
			initOldVersionBlockMap = true;
		}
		if (!oldVersionBlockMap.containsKey(s)) {
			Modchu_Main.setRuntimeException("oldVersionBlockMap s="+s+" is null !!");
			return null;
		}
		return oldVersionBlockMap.get(s);
	}

	protected int openGlHelperDefaultTexUnit() {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("OpenGlHelper", "field_77478_a", "defaultTexUnit"));
	}

	protected int openGlHelperLightmapTexUnit() {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("OpenGlHelper", "field_77476_b", "lightmapTexUnit"));
	}

	protected void openGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
		Modchu_Reflect.invokeMethod("OpenGlHelper", "func_148821_a", "glBlendFunc", new Class[]{ int.class, int.class, int.class, int.class }, new Object[]{ i, i1, i2, i3 });
	}

	protected void openGlHelperSetActiveTexture(int i) {
		Modchu_Reflect.invokeMethod("OpenGlHelper", "func_77473_a", "setActiveTexture", new Class[]{ int.class }, null, new Object[]{ i });
	}

	protected Object pathNavigateTryMoveToXYZ(Object pathNavigate, int x, int y, int z, float f) {
		return Modchu_Reflect.invokeMethod(pathNavigate.getClass(), "func_75492_a", "tryMoveToXYZ", new Class[]{ int.class, int.class, int.class, float.class }, pathNavigate, new Object[]{ x, y, z, f });
	}

	protected void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		Modchu_Reflect.invokeMethod(pathNavigateGround.getClass(), "func_179690_a", new Class[]{ boolean.class }, pathNavigateGround, new Object[]{ b });
	}

	protected void playerControllerMPSetPlayerCapabilities() {
		if (Modchu_Main.isServer) return;
		Object playerController = minecraftPlayerController();
		playerControllerMPSetPlayerCapabilities(playerController, minecraftThePlayer());
	}

	protected void playerControllerMPSetPlayerCapabilities(Object playerController) {
		if (Modchu_Main.isServer) return;
		playerControllerMPSetPlayerCapabilities(playerController, minecraftThePlayer());
	}

	protected void playerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
		if (Modchu_Main.isServer) return;
		if (Modchu_Reflect.loadClass("PlayerControllerCreative").isInstance(playerController)); else return;
		Modchu_Reflect.invokeMethod("PlayerControllerCreative", "func_78748_a", "setPlayerCapabilities", new Class[]{Modchu_Reflect.loadClass("EntityPlayer")}, playerController, new Object[]{ entityplayer });
	}

	protected void playerControllerFunc_6473_b() {
		if (Modchu_Main.isServer) return;
		playerControllerFunc_6473_b(minecraftPlayerController(), minecraftThePlayer());
	}

	protected void playerControllerFunc_6473_b(Object playerController) {
		if (Modchu_Main.isServer) return;
		playerControllerFunc_6473_b(playerController, minecraftThePlayer());
	}

	protected void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.invokeMethod("PlayerController", "func_6473_b", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, playerController, new Object[]{ entityplayer });
	}

	protected Object playerControllerMPCreatePlayer() {
		if (Modchu_Main.isServer) return null;
		return playerControllerMPCreatePlayer(minecraftPlayerController());
	}

	protected Object playerControllerMPCreatePlayer(Object playerController) {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod("PlayerControllerMP", "func_4087_b", "createPlayer", new Class[]{ Modchu_Reflect.loadClass("World") }, playerController, new Object[]{ minecraftTheWorld() });
	}

	protected void playerControllerMPFlipPlayer() {
		if (Modchu_Main.isServer) return;
		playerControllerMPFlipPlayer(minecraftPlayerController(), minecraftThePlayer());
	}

	protected void playerControllerMPFlipPlayer(Object playerController) {
		if (Modchu_Main.isServer) return;
		playerControllerMPFlipPlayer(playerController, minecraftThePlayer());
	}

	protected void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.invokeMethod("PlayerControllerMP", "func_78745_b", "flipPlayer", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, playerController, new Object[]{ entityplayer });
	}

	protected void playerControllerSetGameType(Object enumGameType) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.invokeMethod("PlayerControllerMP", "func_78746_a", "setGameType", new Class[]{ Modchu_Reflect.loadClass("EnumGameType") }, minecraftPlayerController(), new Object[]{ enumGameType });
	}

	protected Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return Modchu_Reflect.invokeMethod("PositionTextureVertex", "func_78240_a", "setTexturePosition", new Class[]{ float.class, float.class }, positionTextureVertex, new Object[]{ f, f1 });
	}

	protected float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("PositionTextureVertex", "field_78241_b", "texturePositionX", positionTextureVertex));
	}

	protected float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("PositionTextureVertex", "field_78242_c", "texturePositionY", positionTextureVertex));
	}

	protected Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return Modchu_Reflect.getFieldObject("PositionTextureVertex", "field_78243_a", "vector3D", positionTextureVertex);
	}

	protected void printChatMessage(String s) {
		if (Modchu_Main.isServer) return;
		Object ingameGUI = Modchu_Reflect.getFieldObject("Minecraft", "field_71456_v", "ingameGUI", minecraftGetMinecraft());
		if (ingameGUI != null); else {
			Modchu_Debug.lDebug("printChatMessage ingameGUI == null !!");
			return;
		}
		Object chatGUI = Modchu_Reflect.invokeMethod(ingameGUI.getClass(), Modchu_Main.getMinecraftVersion() > 169 ? "func_146158_b" : "func_73827_b", "getChatGUI", ingameGUI);
		if (chatGUI != null); else {
			Modchu_Debug.lDebug("printChatMessage chatGUI == null !!");
			return;
		}
		if (Modchu_Main.getMinecraftVersion() > 169) {
			Object o = Modchu_Reflect.newInstance("net.minecraft.util.ChatComponentText", new Class[]{ String.class }, new Object[]{ s });
			Modchu_Reflect.invokeMethod(chatGUI.getClass(), "func_146227_a", "printChatMessage", new Class[]{ Modchu_Reflect.loadClass("net.minecraft.util.IChatComponent") }, chatGUI, new Object[]{ o });
		} else {
			Modchu_Reflect.invokeMethod(chatGUI.getClass(), "func_73765_a", "printChatMessage", new Class[]{ String.class }, chatGUI, new Object[]{ s });
		}
	}

	protected Object render(Object model) {
		return Modchu_Reflect.getFieldObject(model.getClass(), "render", model, -1);
	}

	protected void renderBindTexture(Object render, Object resourceLocation) {
		if (Modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.invokeMethod("Render", "func_110776_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, render, new Object[]{ resourceLocation });
		else Modchu_Reflect.invokeMethod("Render", "func_76985_a", "loadTexture", new Class[]{ String.class }, render, new Object[]{ resourceLocation });
	}

	protected String[] renderBipedBipedArmorFilenamePrefix() {
		return (String[]) (Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("RenderBiped", "field_82424_k", "bipedArmorFilenamePrefix") : Modchu_Reflect.getFieldObject("RenderPlayer", "field_77110_j", "armorFilenamePrefix"));
	}

	protected void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		Modchu_Reflect.invokeMethod(renderBlocks.getClass(), "func_147769_a", "renderBlockAllFaces", new Class[]{ Modchu_Reflect.loadClass("Block"), int.class, int.class, int.class }, renderBlocks, new Object[]{ block, i, i2, i3 });
	}

	protected void renderBlocksDrawCrossedSquares(Object renderBlocks, Object iIcon, double d, double d2, double d3, float f) {
		//Modchu_Debug.mDebug("renderBlocksDrawCrossedSquares iIcon="+iIcon);
		//Modchu_Debug.mDebug("renderBlocksDrawCrossedSquares d="+d+" d2="+d2+" d3="+d3+" f="+f);
		Modchu_Reflect.invokeMethod("RenderBlocks", "func_147765_a", "drawCrossedSquares", new Class[]{ Modchu_Reflect.loadClass("net.minecraft.util.IIcon"), double.class, double.class, double.class, float.class }, renderBlocks, new Object[]{ iIcon, d, d2, d3, f });
	}

	protected void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		Modchu_Reflect.invokeMethod(renderBlocks.getClass(), "func_78600_a", "renderBlockAsItem", new Class[]{ Modchu_Reflect.loadClass("Block"), int.class, float.class }, renderBlocks, new Object[]{ block, i, f });
	}

	protected boolean renderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(renderBlocks.getClass(), "func_78597_b", "renderItemIn3d", new Class[]{ int.class }, renderBlocks, new Object[]{ i }));
	}

	protected Object renderEngine() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71446_o", "renderEngine", minecraftGetMinecraft());
	}

	protected void renderEngineBindTexture(Object o) {
		textureManagerBindTexture(o);
	}

	protected void renderEngineSetupTexture(Object bufferedimage, int i) {
		Modchu_Reflect.invokeMethod("RenderEngine", "func_78351_a", "setupTexture", new Class[]{ BufferedImage.class, int.class }, renderEngine(), new Object[]{ bufferedimage, 1 });
	}

	protected void renderEngineDeleteTexture(Object resourceLocation) {
		renderEngineDeleteTexture(minecraftGetTextureManager(), resourceLocation);
	}

	protected void renderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
		if (Modchu_Main.getMinecraftVersion() > 169) Modchu_Reflect.invokeMethod("RenderEngine", "func_147645_c", "deleteTexture", new Class[]{ resourceLocation.getClass() }, renderEngine, new Object[]{ resourceLocation });
	}

	protected Object renderItemGetItemModelMesher(Object renderItem) {
		return Modchu_Reflect.invokeMethod(renderItem.getClass(), "func_175037_a", "getItemModelMesher", renderItem);
	}

	protected Object rendererLivingEntityRES_ITEM_GLINT(Object render) {
		return Modchu_Reflect.getFieldObject("RendererLivingEntity", "field_110814_a", "RES_ITEM_GLINT", render);
	}

	protected void rendererLivingEntityPassSpecialRender(Object rendererLivingEntity, double d, double d1, double d2) {
		rendererLivingEntityPassSpecialRender(rendererLivingEntity, minecraftThePlayer(), d, d1, d2);
	}

	protected void rendererLivingEntityPassSpecialRender(Object rendererLivingEntity, Object entity, double d, double d1, double d2) {
		Modchu_Reflect.invokeMethod("RendererLivingEntity", "func_77033_b", "passSpecialRender", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), double.class, double.class, double.class }, rendererLivingEntity, new Object[]{ entity, d, d1, d2 });
	}

	protected void rendererLivingEntitySetRenderPassModel(Object rendererLivingEntity, Object modelBase) {
		Modchu_Reflect.invokeMethod("RendererLivingEntity", "func_77042_a", "setRenderPassModel", new Class[]{ Modchu_Reflect.loadClass("ModelBase") }, rendererLivingEntity, new Object[]{ modelBase });
	}

	protected void renderFirstPersonArm(Object render, Object entityplayer) {
		Modchu_Reflect.invokeMethod("RenderPlayer", "func_82441_a", "renderFirstPersonArm", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, render, new Object[]{ entityplayer });
	}

	protected boolean renderPlayerSmallArms(Object renderPlayer) {
		return Modchu_Main.getMinecraftVersion() > 179 ? Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("RenderPlayer", "field_177140_a",  "smallArms", renderPlayer)) : false;
	}

	protected void renderHelperDisableStandardItemLighting() {
		Modchu_Reflect.invokeMethod("RenderHelper", "func_74518_a", "disableStandardItemLighting");
	}

	protected void renderHelperEnableStandardItemLighting() {
		Modchu_Reflect.invokeMethod("RenderHelper", "func_74519_b", "enableStandardItemLighting");
	}

	protected void renderItems(Object model, Object entity, Object render) {
		Modchu_Reflect.invokeMethod(model.getClass(), "renderItems", new Class[]{ Object.class, Object.class }, model, new Object[]{ entity, render });
	}

	protected Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return Modchu_Reflect.invokeMethod("Render", "func_76984_a", "loadDownloadableImageTexture", new Class[]{ String.class, String.class }, render, new Object[]{ s, s1 });
	}

	protected Object renderMainModel(Object render) {
		return Modchu_Reflect.getFieldObject("RendererLivingEntity", "field_77045_g",  "mainModel", render);
	}

	protected void renderLivingFunc_110827_b(Object renderLiving, Object entityLiving, double d, double d2, double d3, float f, float f1) {
		Modchu_Reflect.invokeMethod("RenderLiving", "func_110827_b", new Class[]{ Modchu_Reflect.loadClass("EntityLiving"), double.class, double.class, double.class, float.class, float.class }, renderLiving, new Object[]{ entityLiving, d, d2, d3, f, f1 });
	}

	protected boolean renderLivingFunc_110813_b(Object renderLiving, Object entityLiving) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("RenderLiving", "func_110813_b", new Class[]{ Modchu_Reflect.loadClass("EntityLiving") }, renderLiving, new Object[]{ entityLiving }));
	}

	protected Map renderManagerEntityRenderMap() {
		Object renderManagerInstance = renderManagerInstance();
		return renderManagerInstance != null ? Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject("RenderManager", "field_78729_o", "entityRenderMap", renderManagerInstance)) : null;
	}

	protected Map renderManagerSkinMap() {
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject("RenderManager", "field_178636_l", "skinMap", renderManagerInstance()));
	}

	protected Object renderManagerGetEntityClassRenderObject(Class c) {
		return Modchu_Reflect.invokeMethod("RenderManager", "func_78715_a", "getEntityClassRenderObject", new Class[]{ Class.class }, renderManagerInstance(), new Object[]{ c });
	}

	protected Object renderManagerGetEntityRenderObject() {
		return renderManagerGetEntityRenderObject(minecraftThePlayer());
	}

	protected Object renderManagerGetEntityRenderObject(Object entity) {
		return Modchu_Reflect.invokeMethod("RenderManager", "func_78713_a", "getEntityRenderObject", new Class[]{ Modchu_Reflect.loadClass("Entity") }, renderManagerInstance(), new Object[]{ entity });
	}

	protected Object renderManagerInstance() {
		return Modchu_Reflect.getFieldObject("RenderManager", "field_78727_a", "instance");
	}

	protected Object renderManagerItemRenderer() {
		Object renderManager = renderManagerInstance();
		return Modchu_Reflect.getFieldObject(renderManager.getClass(), "field_78721_f", "itemRenderer", renderManager);
	}

	protected void renderManagerItemRendererRenderItem(Object entity, Object itemstack, Object o) {
		renderManagerItemRendererRenderItem(renderManagerItemRenderer(), entity, itemstack, o);
	}

	protected void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		Modchu_Reflect.invokeMethod("ItemRenderer", Modchu_Main.getMinecraftVersion() > 179 ? "func_178099_a" : "func_78443_a", "renderItem", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), Modchu_Reflect.loadClass("ItemStack"), o.getClass() }, itemRenderer, new Object[]{ entity, itemstack, o });
	}

	protected boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("RenderManager", Modchu_Main.getMinecraftVersion() > 169 ? "func_147940_a" : "func_78719_a", "renderEntityWithPosYaw", new Class[]{ Modchu_Reflect.loadClass("Entity"), double.class, double.class, double.class, float.class, float.class }, renderManagerInstance(), new Object[]{ entity, d, d2, d3, f, f2 }));
	}

	protected Object renderRenderBlocks(Object pRender) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.getFieldObject("Render", "field_147909_c", pRender) :
			Modchu_Reflect.getFieldObject("Render", "field_76988_d", "renderBlocks", pRender);
	}

	protected Object renderRenderManager(Object render) {
		return Modchu_Reflect.getFieldObject("Render", "field_76990_c", "renderManager", render);
	}

	protected Object renderRenderManagerRenderEngine(Object render) {
		return Modchu_Reflect.getFieldObject("RenderManager", "field_78724_e", "renderEngine", renderRenderManager(render));
	}

	protected void renderSetRenderManager(Object render) {
		if (Modchu_Main.getMinecraftVersion() < 180) Modchu_Reflect.invokeMethod("Render", "func_76976_a", "setRenderManager", new Class[]{ Modchu_Reflect.loadClass("RenderManager") }, render, new Object[]{ renderManagerInstance() });
	}

	protected InputStream resourceGetInputStream(Object resource) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_CastHelper.InputStream(Modchu_Reflect.invokeMethod("net.minecraft.client.resources.IResource", "func_110527_b", "getInputStream", resource)) :
			Modchu_CastHelper.InputStream(Modchu_Reflect.invokeMethod("Resource", "func_110527_b", "getInputStream", resource));
	}

	protected Object resourceManagerGetResource(Object o) {
		if (Modchu_Main.isServer) return null;
		return resourceManagerGetResource(minecraftGetResourceManager(), o);
	}

	protected Object resourceManagerGetResource(Object resourceManager, Object o) {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.invokeMethod(resourceManager.getClass(), "func_110536_a", "getResource", new Class[]{ o.getClass() }, resourceManager, new Object[]{ o });
	}

	protected InputStream resourceManagerInputStream(Object o) {
		if (Modchu_Main.isServer) return null;
		InputStream inputStream = null;
		Object resource = resourceManagerGetResource(o);
		if (resource != null) inputStream = resourceGetInputStream(resource);
		return inputStream;
	}

	protected String resourceLocationGetResourceDomain(Object resourceLocation) {
		if (Modchu_Main.getMinecraftVersion() > 159); else return null;
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod(resourceLocation.getClass(), "func_110624_b", "getResourceDomain", resourceLocation));
	}

	protected String resourceLocationGetResourcePath(Object resourceLocation) {
		if (Modchu_Main.getMinecraftVersion() > 159); else return Modchu_CastHelper.String(resourceLocation);
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod(resourceLocation.getClass(), "func_110623_a", "getResourcePath", resourceLocation));
	}

	protected void setArmorRendering(Object model, boolean b) {
		Modchu_Reflect.setFieldObject(model.getClass(), "setArmorRendering", model, b, -1);
	}

	protected void setEntityEntityID(int i) {
		setEntityEntityID(minecraftThePlayer(), i);
	}

	protected void setEntityEntityID(Object entity, int i) {
		Modchu_Reflect.setFieldObject("Entity", Modchu_Main.getMinecraftVersion() > 169 ? "field_145783_c" : "field_73319_a", "entityId", entity, i, 0);
	}

	protected void setEntityFoodStats(Object entityGetFoodStats) {
		setEntityFoodStats(minecraftThePlayer(), entityGetFoodStats);
	}

	protected void setEntityFoodStats(Object entityplayer, Object entityGetFoodStats) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_71100_bB", "foodStats", entityplayer, entityGetFoodStats);
	}

	protected void setEntityLivingBaseDeathTime(int i) {
		setEntityLivingBaseDeathTime(minecraftThePlayer(), i);
	}

	protected void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70725_aQ", "deathTime", entityLivingBase, i, 0);
	}

	protected void setEntityLivingBaseHealth(float f) {
		setEntityLivingBaseHealth(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseHealth(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_41031_b", "health", entity, f);
	}

	protected void setEntityMotionX(double d) {
		setEntityMotionX(minecraftThePlayer(), d);
	}

	protected void setEntityMotionX(Object entity, double d) {
		Modchu_Reflect.setFieldObject("Entity", "field_73388_b", "motionX", entity, d);
	}

	protected void setEntityMotionY(double d) {
		setEntityMotionY(minecraftThePlayer(), d);
	}

	protected void setEntityMotionY(Object entity, double d) {
		Modchu_Reflect.setFieldObject("Entity", "field_73389_c", "motionY", entity, d);
	}

	protected void setEntityMotionZ(double d) {
		setEntityMotionZ(minecraftThePlayer(), d);
	}

	protected void setEntityMotionZ(Object entity, double d) {
		Modchu_Reflect.setFieldObject("Entity", "field_73387_d", "motionZ", entity, d);
	}

	protected void setEntityPlayerArmorInventory(Object armorInventory) {
		setEntityPlayerArmorInventory(minecraftThePlayer(), armorInventory);
	}

	protected void setEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		Modchu_Reflect.setFieldObject("InventoryPlayer", "field_70460_b", "armorInventory", entityPlayerInventory(entityplayer), armorInventory);
	}

	protected void setEntityPlayerCurrentXP(int i) {
		setEntityPlayerPlayerLevel(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_35211_aX", "currentXP", entityplayer, (int) f);
	}

	protected void setEntityPlayerInventory(Object inventory) {
		setEntityPlayerInventory(minecraftThePlayer(), inventory);
	}

	protected void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_71071_by", "inventory", entityplayer, inventory);
	}

	protected void setEntityPlayerMainInventory(Object mainInventory) {
		setEntityPlayerMainInventory(minecraftThePlayer(), mainInventory);
	}

	protected void setEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		Modchu_Reflect.setFieldObject("InventoryPlayer", "field_70462_a", "mainInventory", entityPlayerInventory(entityplayer), mainInventory);
	}

	protected void setEntityPlayerPlayerLevel(int i) {
		setEntityPlayerPlayerLevel(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		// b181 aY
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_35210_aY", "playerLevel", entityplayer, i, 0);
	}

	protected void setEntityPlayerScore(int i) {
		setEntityPlayerScore(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerScore(Object entityplayer, int i) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_9370_g", "score", entityplayer, i, 0);
	}

	protected void setEntityPlayerSPMovementInput() {
		Object thePlayer = minecraftThePlayer();
		Object gameSettings = minecraftGameSettings();
		setEntityPlayerSPMovementInput(thePlayer, Modchu_Reflect.newInstance("MovementInputFromOptions", new Class[]{ gameSettings.getClass() }, new Object[]{ gameSettings }));
	}

	protected void setEntityPlayerSPMovementInput(Object movementInput) {
		setEntityPlayerSPMovementInput(minecraftThePlayer(), movementInput);
	}

	protected void setEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		Modchu_Reflect.setFieldObject("EntityPlayerSP", "field_71158_b", "movementInput", entityplayer, movementInput);
	}

	protected void setEntityPlayerTotalXP(int i) {
		setEntityPlayerPlayerLevel(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerTotalXP(Object entityplayer, int i) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_35209_aZ", "totalXP", entityplayer, i, 0);
	}

	protected void setEntityPosX(double d) {
		setEntityPosX(minecraftThePlayer(), d);
	}

	protected void setEntityPosX(Object entity, double d) {
		Modchu_Reflect.setFieldObject("Entity", "field_70165_t", "posX", entity, d);
	}

	protected void setEntityPosY(double d) {
		setEntityPosY(minecraftThePlayer(), d);
	}

	protected void setEntityPosY(Object entity, double d) {
		Modchu_Reflect.setFieldObject("Entity", "field_70163_u", "posY", entity, d);
	}

	protected void setEntityPosZ(double d) {
		setEntityPosZ(minecraftThePlayer(), d);
	}

	protected void setEntityPosZ(Object entity, double d) {
		Modchu_Reflect.setFieldObject("Entity", "field_70161_v", "posZ", entity, d);
	}

	protected void setEntityRendererItemRenderer(Object itemRenderer) {
		Modchu_Reflect.setFieldObject("EntityRenderer", Modchu_Main.getMinecraftVersion() > 169 ? "field_78516_c" : "field_73841_b", "itemRenderer", minecraftEntityRenderer(), itemRenderer);
	}

	protected void setEntityYOffset(float f) {
		setEntityYOffset(minecraftThePlayer(), f);
	}

	protected void setEntityYOffset(Object entity, float f) {
		Modchu_Reflect.setFieldObject("Entity", "field_70129_M", "YOffset", entity, f);
	}

	protected void setGameSettingsKeyBindBack(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74368_y", "keyBindBack", gameSettings, keyBinding);
	}

	protected void setGameSettingsKeyBindForward(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74351_w", "keyBindForward", gameSettings, keyBinding);
	}

	protected void setGameSettingsKeyBindLeft(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74366_z", "keyBindRight", gameSettings, keyBinding);
	}

	protected void setGameSettingsKeyBindRight(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74370_x", "keyBindLeft", gameSettings, keyBinding);
	}

	protected void setGuiButtonEnabled(Object guiButton, boolean b) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146124_l" : "field_73742_g", "enabled", guiButton, b);
	}

	protected void setGuiButtonID(Object guiButton, int i) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146127_k" : "field_73741_f", "id", guiButton, i, 0);
	}

	protected void setGuiButtonVisible(Object guiButton, boolean b) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146125_m" : "field_73748_h", "visible", guiButton, b);
	}

	protected void setGuiButtonXPosition(Object guiButton, int i) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146128_h" : "field_73746_c", "xPosition", guiButton, i, 0);
	}

	protected void setGuiButtonYPosition(Object guiButton, int i) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146129_i" : "field_73743_d", "yPosition", guiButton, i, 0);
	}

	protected void setGuiScreenButtonList(Object guiScreen, List list) {
		Modchu_Reflect.setFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146292_n" : "field_73887_h", "buttonList", guiScreen, list);
	}

	protected void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		if (Modchu_Main.getMinecraftVersion() > 169) Modchu_Reflect.setFieldObject("GuiScreen", "fontRendererObj", guiScreen, fontRenderer);
		else Modchu_Reflect.setFieldObject("GuiScreen", "field_73886_k", "fontRenderer", guiScreen, fontRenderer);
	}

	protected void setGuiScreenHeight(Object guiScreen, int i) {
		Modchu_Reflect.setFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146295_m" : "field_73881_g", "height", guiScreen, i, 0);
	}

	protected void setGuiScreenWidth(Object guiScreen, int i) {
		Modchu_Reflect.setFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146294_l" : "field_73880_f", "width", guiScreen, i, 0);
	}

	protected void setMinecraftDisplayGuiScreen(Object guiScreen) {
		Modchu_Reflect.invokeMethod("Minecraft", Modchu_Main.getMinecraftVersion() > 169 ? "func_147108_a" : "func_71373_a", "displayGuiScreen", new Class[]{ Modchu_Reflect.loadClass("GuiScreen") }, minecraftGetMinecraft(), new Object[]{ guiScreen });
	}

	protected void setMinecraftPlayerController(Object playerController) {
		Modchu_Reflect.setFieldObject("Minecraft", "field_71442_b", "playerController", minecraftGetMinecraft(), playerController);
	}

	protected void setMinecraftRenderViewEntity() {
		setMinecraftRenderViewEntity(minecraftThePlayer());
	}

	protected void setMinecraftRenderViewEntity(Object entity) {
		Modchu_Reflect.setFieldObject("Minecraft", "field_71451_h", "renderViewEntity", minecraftGetMinecraft(), new Object[]{ entity });
	}

	protected void setMinecraftThePlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.setFieldObject("Minecraft", "field_71439_g", "thePlayer", minecraftGetMinecraft(), entityPlayer);
	}

	protected void setRender(Object model, Object render) {
		//Modchu_Debug.mDebug("setRender model="+model.getClass());
		//Modchu_Debug.mDebug("setRender render="+render.getClass());
		Modchu_Reflect.setFieldObject(model.getClass(), "render", model, render, -1);
	}

	protected void setRenderMainModel(Object render, Object model) {
		Modchu_Reflect.setFieldObject("RendererLivingEntity", "field_77045_g",  "mainModel", render, model);
	}

	protected void setRenderManagerItemRenderer(Object itemRenderer) {
		if (Modchu_Main.getMinecraftVersion() > 179) Modchu_Reflect.setFieldObject("Minecraft", "field_175620_Y", "itemRenderer", minecraftGetMinecraft(), itemRenderer);
		else Modchu_Reflect.setFieldObject("RenderManager", "field_78721_f", "itemRenderer", renderManagerInstance(), itemRenderer);
	}

	protected boolean stringUtilsIsNullOrEmpty(String s) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("net.minecraft.util.StringUtils", "func_151246_b", "isNullOrEmpty", new Class[]{ String.class }, new Object[]{ s }));
	}

	protected Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return Modchu_Reflect.invokeMethod("ServerConfigurationManager", "func_72368_a", "respawnPlayer", new Class[]{ Modchu_Reflect.loadClass("EntityPlayerMP"), int.class, boolean.class }, serverConfigurationManager, new Object[]{ entityPlayerMP, i, b });
	}

	protected int scaledresolutionGetScaleFactor(Object scaledresolution) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(scaledresolution.getClass(), "func_78325_e", "getScaleFactor", scaledresolution));
	}

	protected int scaledresolutionGetScaledWidth(Object scaledresolution) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(scaledresolution.getClass(), "func_78326_a", "getScaledWidth", scaledresolution));
	}

	protected int scaledresolutionGetScaledHeight(Object scaledresolution) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(scaledresolution.getClass(), "func_78328_b", "getScaledHeight", scaledresolution));
	}

	protected Object slotGetStack(Object slot) {
		return Modchu_Reflect.invokeMethod(slot.getClass(), "func_75211_c", "getStack", slot);
	}

	protected Object sharedMonsterAttributesAttackDamage() {
		return Modchu_Reflect.getFieldObject("SharedMonsterAttributes", "field_111264_e", "attackDamage");
	}

	protected void framebufferBindFramebuffer(Object framebuffer, boolean b) {
		Modchu_Reflect.invokeMethod(framebuffer.getClass(), "func_147610_a", "bindFramebuffer", new Class[]{ boolean.class }, framebuffer, new Object[]{ b });
	}

	protected void framebufferUnbindFramebuffer(Object framebuffer) {
		Modchu_Reflect.invokeMethod(framebuffer.getClass(), "func_147609_e", "unbindFramebuffer", framebuffer);
	}

	protected void framebufferFramebufferRender(Object framebuffer, int i, int i1) {
		Modchu_Reflect.invokeMethod(framebuffer.getClass(), "func_147615_c", "framebufferRender", new Class[]{ int.class, int.class }, framebuffer, new Object[]{ i, i1 });
	}

	protected void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78377_a", "addVertex", new Class[]{ double.class, double.class, double.class }, tessellator, new Object[]{ d, d2, d3 });
	}

	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78374_a", "addVertexWithUV", new Class[]{ double.class, double.class, double.class, double.class, double.class }, tessellator, new Object[]{ d, d2, d3, d4, d5 });
	}

	protected void tessellatorDraw(Object tessellator) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78381_a", "draw", tessellator);
	}

	protected Object tessellatorInstance() {
		return Modchu_Reflect.getFieldObject("Tessellator", "field_78398_a", "instance");
	}

	protected void tessellatorSetColorOpaque_I(int i) {
		tessellatorSetColorOpaque_I(tessellatorInstance(), i);
	}

	protected void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78378_d", "setColorOpaque_I", new Class[]{ int.class }, tessellator, new Object[]{ i });
	}

	protected void tessellatorSetColorOpaque_F(float f, float f1, float f2) {
		tessellatorSetColorOpaque_F(tessellatorInstance(), f, f1, f2);
	}

	protected void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78386_a", "setColorOpaque_F", new Class[]{ float.class, float.class, float.class }, tessellator, new Object[]{ f, f1, f2 });
	}

	protected void tessellatorSetBrightness(Object tessellator, int i) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78380_c", "setBrightness", new Class[]{ int.class }, tessellator, new Object[]{ i });
	}

	protected void tessellatorSetColorRGBA_I(int i, int i2) {
		tessellatorSetColorRGBA_I(tessellatorInstance(), i, i2);
	}

	protected void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78384_a", "setColorRGBA_I", new Class[]{ int.class, int.class }, tessellator, new Object[]{ i, i2 });
	}

	protected void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78375_b", "setNormal", new Class[]{ float.class, float.class, float.class }, tessellator, new Object[]{ f, f2, f3 });
	}

	protected void tessellatorStartDrawing(Object tessellator, byte by) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78371_b", "startDrawing", new Class[]{ byte.class }, tessellator, new Object[]{ by });
	}

	protected void tessellatorStartDrawingQuads() {
		tessellatorStartDrawingQuads(tessellatorInstance());
	}

	protected void tessellatorStartDrawingQuads(Object tessellator) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78382_b", "startDrawingQuads", tessellator);
	}

	protected void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		Modchu_Reflect.invokeMethod("TexturedQuad", "func_78236_a", "draw", new Class[]{ Modchu_Reflect.loadClass("Tessellator"), float.class }, texturedQuad, new Object[]{ tessellator, f });
	}

	protected void textureManagerBindTexture(Object o) {
		textureManagerBindTexture(Modchu_Main.getMinecraftVersion() > 159 ? minecraftGetTextureManager() : renderEngine(), o);
	}

	protected void textureManagerBindTexture(Object textureManager, Object o) {
		if (Modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.invokeMethod("TextureManager", "func_110577_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, textureManager, new Object[]{ o });
		else Modchu_Reflect.invokeMethod("RenderEngine", "func_94277_a", "bindTexture", new Class[]{ String.class }, textureManager, new Object[]{ o });
	}

	protected Object textureManagerGetResourceLocation(int i) {
		return textureManagerGetResourceLocation(Modchu_Main.getMinecraftVersion() > 159 ? minecraftGetTextureManager() : renderEngine(), i);
	}

	protected Object textureManagerGetResourceLocation(Object textureManager, int i) {
		return Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.invokeMethod("TextureManager", "func_130087_a", "getResourceLocation", new Class[]{ int.class }, textureManager, new Object[]{ i }) : null;
	}

	protected Object textureManagerGetTexture(Object o) {
		return textureManagerGetTexture(Modchu_Main.getMinecraftVersion() > 159 ? minecraftGetTextureManager() : renderEngine(), o);
	}

	protected Object textureManagerGetTexture(Object textureManager, Object o) {
		return Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.invokeMethod("TextureManager", "func_110581_b", "getTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, textureManager, new Object[]{ o }) : o;
	}

	protected Object textureMapLocationBlocksTexture() {
		return Modchu_Reflect.getFieldObject("TextureMap", "field_110575_b", "locationBlocksTexture");
	}

	protected int textureOffsetTextureOffsetX(Object textureOffset) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(textureOffset.getClass(), "field_78783_a", "textureOffsetX", textureOffset));
	}

	protected int textureOffsetTextureOffsetY(Object textureOffset) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(textureOffset.getClass(), "field_78782_b", "textureOffsetY", textureOffset));
	}

	protected void textureUtilBindTexture(int i) {
		Modchu_Reflect.invokeMethod("TextureUtil", "func_94277_a", "bindTexture", new Class[]{ int.class }, new Object[]{ i });
	}

	protected int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("TextureUtil", "func_110987_a", "uploadTextureImage", new Class[]{ int.class, BufferedImage.class }, new Object[]{ i, bufferedimage }));
	}

	protected int textureUtilAnaglyphColor(int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("TextureUtil", "func_177054_c", new Class[]{ int.class }, new Object[]{ i }));
	}

	protected boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		if (Modchu_Main.getMinecraftVersion() > 172) {
			int i = threadDownloadImageDataGetGlTextureId(threadDownloadImageData);
			return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("ThreadDownloadImageData", "field_110559_g", "textureUploaded", threadDownloadImageData));
		}
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("ThreadDownloadImageData", "func_110557_a", "isTextureUploaded", threadDownloadImageData));
	}

	protected int threadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(threadDownloadImageData.getClass(), "func_110552_b", "getGlTextureId", threadDownloadImageData));
	}

	protected Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72443_a", "createVectorHelper", new Class[]{ double.class, double.class, double.class }, new Object[]{ d, d2, d3 });
	}

	protected Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72431_c", "crossProduct", new Class[]{ vec3.getClass() }, vec3, new Object[]{ vec3_2 });
	}

	protected Object vec3Normalize(Object vec3) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72432_b", "normalize", vec3);
	}

	protected Object vec3Subtract(Object vec3, Object vec3_2) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72444_a", "subtract", new Class[]{ vec3.getClass() }, vec3, new Object[]{ vec3_2 });
	}

	protected double vec3XCoord(Object vec3) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Vec3", "field_72450_a", "xCoord", vec3));
	}

	protected double vec3YCoord(Object vec3) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Vec3", "field_72448_b", "yCoord", vec3));
	}

	protected double vec3ZCoord(Object vec3) {
		return Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject("Vec3", "field_72449_c", "zCoord", vec3));
	}

	protected double vec3SquareDistanceTo(Object vec3, Object vec3_2) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("Vec3", "func_72436_e", "squareDistanceTo", new Class[]{ Modchu_Reflect.loadClass("Vec3")  }, vec3, new Object[]{ vec3_2 }));
	}

	protected Object vec3AddVector(Object vec3, double d, double d2, double d3) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72441_c", "addVector", new Class[]{ double.class, double.class, double.class }, vec3, new Object[]{ d, d2, d3 });
	}

	protected boolean worldCanBlockSeeTheSky(double d, double d2, double d3) {
		return worldCanBlockSeeTheSky(minecraftThePlayer(), d, d2, d3);
	}

	protected boolean worldCanBlockSeeTheSky(int i, int i2, int i3) {
		return worldCanBlockSeeTheSky(minecraftThePlayer(), i, i2, i3);
	}

	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72937_j", "canBlockSeeTheSky", new Class[]{ int.class, int.class, int.class }, entityWorldObj(worldOrEntity), new Object[]{ (int) d, (int) d2, (int) d3 }));
	}

	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72937_j", "canBlockSeeTheSky", new Class[]{ int.class, int.class, int.class }, entityWorldObj(worldOrEntity), new Object[]{ (int) i, (int) i2, (int) i3 }));
	}

	protected List worldGetEntitiesWithinAABBExcludingEntity(Object entity, Object axisAlignedBB) {
		return worldGetEntitiesWithinAABBExcludingEntity(minecraftTheWorld(), entity, axisAlignedBB);
	}

	protected List worldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return Modchu_CastHelper.List(Modchu_Reflect.invokeMethod("World", "func_72839_b", "getEntitiesWithinAABBExcludingEntity", new Class[]{ Modchu_Reflect.loadClass("Entity"), Modchu_Reflect.loadClass("AxisAlignedBB") }, entityWorldObj(worldOrEntity), new Object[]{ entity, axisAlignedBB }));
	}

	protected Object worldGetWorldInfo() {
		return Modchu_Reflect.invokeMethod(minecraftTheWorld().getClass(), "func_72912_H", "getWorldInfo", minecraftTheWorld());
	}

	protected void worldRemoveEntity(Object world, Object entity) {
		Modchu_Reflect.invokeMethod("World", "func_72900_e", "removeEntity", new Class[]{ Modchu_Reflect.loadClass("Entity") }, world, new Object[]{ entity });
	}

	protected Object worldGetBlock(int i, int i2, int i3) {
		return worldGetBlock(minecraftTheWorld(), i, i2, i3);
	}

	protected Object worldGetBlock(Object world, int i, int i2, int i3) {
		return Modchu_Reflect.invokeMethod(world.getClass(), "func_150810_a", "getBlock", world);
	}

	protected Enum worldGetWorldInfoGetGameType() {
		Object worldInfo = worldGetWorldInfo();
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod(worldInfo.getClass(), "func_73081_b", "getGameType", worldInfo));
	}

	protected Enum worldSettingsGameTypeNOT_SET() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("WorldSettings.GameType", "NOT_SET"));
	}

	protected Enum worldSettingsGameTypeSURVIVAL() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("WorldSettings.GameType", "SURVIVAL"));
	}

	protected Enum worldSettingsGameTypeCREATIVE() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("WorldSettings.GameType", "CREATIVE"));
	}

	protected Enum worldSettingsGameTypeADVENTURE() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod("WorldSettings.GameType", "ADVENTURE"));
	}

	protected boolean worldIsAirBlock(int i, int j, int k) {
		return worldIsAirBlock(minecraftThePlayer(), i, j, k);
	}

	protected boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		Object worldObj = entityWorldObj(worldOrEntity);
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", Modchu_Main.getMinecraftVersion() > 169 ? "func_147437_c" : "func_72799_c", "isAirBlock", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ i, j, k }));
	}

	protected boolean worldIsBlockNormalCubeDefault(int i, int j, int k, boolean b) {
		return worldIsBlockNormalCubeDefault(minecraftThePlayer(), i, j, k, b);
	}

	protected boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72887_b", "isBlockNormalCubeDefault", new Class[]{ int.class, int.class, int.class, boolean.class }, entityWorldObj(worldOrEntity), new Object[]{ i, j, k, b }));
	}

	protected boolean worldIsDaytime() {
		return worldIsDaytime(minecraftThePlayer());
	}

	protected boolean worldIsDaytime(Object worldOrEntity) {
		Object worldObj = entityWorldObj(worldOrEntity);
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72935_r", "isDaytime", worldObj));
	}

	protected boolean worldIsRemote() {
		return worldIsRemote(minecraftThePlayer());
	}

	protected boolean worldIsRemote(Object worldOrEntity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("World", "field_72995_K", "isRemote", entityWorldObj(worldOrEntity)));
	}

	protected List playerEntities() {
		return playerEntities(minecraftTheWorld());
	}

	protected List playerEntities(Object worldOrEntity) {
		if (Modchu_Main.getMinecraftVersion() < 170) 	return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("World", "field_73010_i", "playerEntities", entityWorldObj(worldOrEntity)));
		Object minecraftServerInstance = null;
		if (Modchu_Main.isServer) {
			Object fMLCommonHandlerInstance = Modchu_Reflect.invokeMethod("cpw.mods.fml.common.FMLCommonHandler", "instance");
			if (fMLCommonHandlerInstance != null) minecraftServerInstance = Modchu_Reflect.invokeMethod(fMLCommonHandlerInstance.getClass(), "getMinecraftServerInstance", fMLCommonHandlerInstance);
		}
		if (isIntegratedServerRunning()) {
			minecraftServerInstance = getIntegratedServer();
		}
		if (minecraftServerInstance != null) {
			Object configurationManager = Modchu_Reflect.invokeMethod(minecraftServerInstance.getClass(), "func_71203_ab", "getConfigurationManager", minecraftServerInstance);
			return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(configurationManager.getClass(), "field_72404_b", "playerEntityList", configurationManager));
		}
		Modchu_Debug.Debug1("Modchu_ASAlmighty playerEntities return null !!");
		return null;
	}

	protected List worldPlayerEntities() {
		return worldPlayerEntities(minecraftTheWorld());
	}

	protected List worldPlayerEntities(Object worldOrEntity) {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("World", "field_73010_i", "playerEntities", entityWorldObj(worldOrEntity)));
	}

	protected List worldWeatherEffects() {
		return worldWeatherEffects(minecraftTheWorld());
	}

	protected List worldWeatherEffects(Object worldOrEntity) {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("World", "field_73007_j", "weatherEffects", entityWorldObj(worldOrEntity)));
	}

	protected void worldSetEntityDead() {
		worldSetEntityDead(minecraftThePlayer());
	}

	protected void worldSetEntityDead(Object entity) {
		worldSetEntityDead(entity, entity);
	}

	protected void worldSetEntityDead(Object worldOrEntity, Object entity) {
		Modchu_Reflect.invokeMethod("World", "func_607_d", "setEntityDead", new Class[]{ Modchu_Reflect.loadClass("Entity") }, entityWorldObj(worldOrEntity), new Object[]{ entity });
	}

	protected void worldSpawnPlayerWithLoadedChunks() {
		worldSpawnPlayerWithLoadedChunks(minecraftThePlayer());
	}

	protected void worldSpawnPlayerWithLoadedChunks(Object entity) {
		worldSpawnPlayerWithLoadedChunks(entity, entity);
	}

	protected Random worldRand() {
		return worldRand(minecraftTheWorld());
	}

	protected Random worldRand(Object worldOrEntity) {
		return (Random) (Modchu_Reflect.getFieldObject("World", "field_73012_v", "rand", entityWorldObj(worldOrEntity)));
	}

	protected void worldSpawnPlayerWithLoadedChunks(Object worldOrEntity, Object entity) {
		Modchu_Reflect.invokeMethod("World", "func_608_a", "spawnPlayerWithLoadedChunks", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, entityWorldObj(worldOrEntity), new Object[]{ entity });
	}

	protected void worldSpawnParticle(String s, double d, double d1, double d2, double d3, double d4, double d5) {
		worldSpawnParticle(minecraftTheWorld(), s, d, d1, d2, d3, d4, d5);
	}

	protected void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		Modchu_Reflect.invokeMethod("World", "func_72869_a", "spawnParticle", new Class[]{ String.class, double.class, double.class, double.class, double.class, double.class, double.class }, entityWorldObj(worldOrEntity), new Object[]{ stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5 });
	}

	protected void worldPlaySoundAtEntity(Object entity, String s, float f, float f1) {
		worldPlaySoundAtEntity(entity, entity, s, f, f1);
	}

	protected void worldPlaySoundAtEntity(Object worldOrEntity, Object entity, String s, float f, float f1) {
		Modchu_Reflect.invokeMethod("World", "func_72956_a", "playSoundAtEntity", new Class[]{ Modchu_Reflect.loadClass("Entity"), String.class, float.class, float.class }, entityWorldObj(worldOrEntity), new Object[]{ entity, s, f, f1 });
	}

	protected boolean worldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		if (Modchu_Main.getMinecraftVersion() > 179) {
			return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_175660_a", "isBlockModifiable", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), Modchu_Reflect.loadClass("BlockPos") }, entityWorldObj(worldOrEntity), new Object[]{ entityPlayer, Modchu_Reflect.newInstance("net.minecraft.util.BlockPos", new Class[]{ int.class, int.class, int.class  }, new Object[]{ x, y, z }) }));
		}
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72962_a", "canMineBlock", new Class[]{ Modchu_Reflect.loadClass("Entity"), int.class, int.class, int.class }, entityWorldObj(worldOrEntity), new Object[]{ entityPlayer, x, y, z }));
	}

	protected void worldSetEntityState(Object entity, byte by) {
		worldSetEntityState(entity, entity, by);
	}

	protected void worldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		Modchu_Reflect.invokeMethod("World", "func_72960_a", "setEntityState", new Class[]{ Modchu_Reflect.loadClass("Entity"), byte.class }, entityWorldObj(worldOrEntity), new Object[]{ entity, by });
	}

	protected Object worldGetPathEntityToEntity(Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return worldGetPathEntityToEntity(entity, entity, entity2, f, b, b1, b2, b3);
	}

	protected Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return Modchu_Reflect.invokeMethod("World", "func_72865_a", "getPathEntityToEntity", new Class[]{ Modchu_Reflect.loadClass("Entity"), Modchu_Reflect.loadClass("Entity"), float.class, boolean.class, boolean.class, boolean.class, boolean.class }, entityWorldObj(worldOrEntity), new Object[]{ entity, entity2, f, b, b1, b2, b3 });
	}

	protected List worldGetEntitiesWithinAABB(Object worldOrEntity, Class c, Object axisAlignedBB) {
		return Modchu_CastHelper.List(Modchu_Reflect.invokeMethod("World", "func_72872_a", "getEntitiesWithinAABB", new Class[]{ Class.class, Modchu_Reflect.loadClass("AxisAlignedBB") }, entityWorldObj(worldOrEntity), new Object[]{ c, axisAlignedBB }));
	}

	protected List worldLoadedEntityList() {
		return worldLoadedEntityList(minecraftTheWorld());
	}

	protected List worldLoadedEntityList(Object worldOrEntity) {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("World", "field_72996_f", "loadedEntityList", entityWorldObj(worldOrEntity)));
	}

	protected Object worldGetClosestPlayerToEntity(Object entity, double d) {
		return worldGetClosestPlayerToEntity(entity, entity, d);
	}

	protected Object worldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return Modchu_Reflect.invokeMethod("World", "func_72890_a", "getClosestPlayerToEntity", new Class[]{ Modchu_Reflect.loadClass("Entity"), double.class }, entityWorldObj(worldOrEntity), new Object[]{ entity, d });
	}

	protected Object worldGetPlayerEntityByName(String s) {
		return worldGetPlayerEntityByName(minecraftThePlayer(), s);
	}

	protected Object worldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return Modchu_Reflect.invokeMethod("World", "func_72924_a", "getPlayerEntityByName", new Class[]{ String.class }, entityWorldObj(worldOrEntity), new Object[]{ s });
	}

	protected Object worldGetBiomeGenForCoords(Object blockPosOrInt) {
		return worldGetBiomeGenForCoords(minecraftTheWorld(), blockPosOrInt);
	}

	protected Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		if (Modchu_Reflect.loadClass("World").isInstance(worldOrInt)
				&& Modchu_Reflect.loadClass("BlockPos").isInstance(blockPosOrInt)) {
			return Modchu_Reflect.invokeMethod("World", "func_180494_b", "getBiomeGenForCoords", new Class[]{ Modchu_Reflect.loadClass("BlockPos") }, entityWorldObj(worldOrInt), new Object[]{ blockPosOrInt });
		}
		return worldGetBiomeGenForCoords((Integer) worldOrInt, (Integer) blockPosOrInt);
	}

	protected Object worldGetBiomeGenForCoords(int i, int i1) {
		return worldGetBiomeGenForCoords(minecraftThePlayer(), i, i1);
	}

	protected Object worldGetBiomeGenForCoords(Object worldOrEntity, int i, int i1) {
		return Modchu_Reflect.invokeMethod("World", "func_72807_a", "getBiomeGenForCoords", new Class[]{ int.class, int.class }, entityWorldObj(worldOrEntity), new Object[]{ i, i1 });
	}

	protected boolean worldSpawnEntityInWorld(Object entity) {
		return worldSpawnEntityInWorld(minecraftThePlayer(), entity);
	}

	protected boolean worldSpawnEntityInWorld(Object worldOrEntity, Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72838_d", "spawnEntityInWorld", new Class[]{ Modchu_Reflect.loadClass("Entity") }, entityWorldObj(worldOrEntity), new Object[]{ entity }));
	}

	protected void worldClientAddEntityToWorld(int i, Object entity) {
		worldClientAddEntityToWorld(minecraftTheWorld(), i, entity);
	}

	protected void worldClientAddEntityToWorld(Object worldClient, int i, Object entity) {
		Modchu_Reflect.invokeMethod("WorldClient", "func_73027_a", "addEntityToWorld", new Class[]{ int.class, Modchu_Reflect.loadClass("Entity") }, entityWorldObj(worldClient), new Object[]{ i, entity });
	}

	protected int worldGetBlockStateGetBlockMetadata(int x, int y, int z) {
		return worldGetBlockStateGetBlockMetadata(minecraftTheWorld(), x, y, z);
	}

	protected int worldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		if (Modchu_Main.getMinecraftVersion() > 179) {
			Object iBlockState = worldGetBlockState(worldOrEntity, newBlockPos(x, y, z));
			Object block = iBlockState != null ? iBlockStateGetBlock(iBlockState) : null;
			if (block != null); else return 0;
			return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Block", "func_176201_c", "getMetaFromState", new Class[]{ iBlockState.getClass() }, block, new Object[]{ iBlockState }));
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("World", "func_72805_g", "getBlockMetadata", new Class[]{ int.class, int.class, int.class }, entityWorldObj(worldOrEntity), new Object[]{ x, y, z }));
	}

	protected int worldGetBlockLightValue(int x, int y, int z) {
		return worldGetBlockLightValue(minecraftTheWorld(), x, y, z);
	}

	protected int worldGetBlockLightValue(Object worldOrEntity, int x, int y, int z) {
		if (Modchu_Main.getMinecraftVersion() > 179) {
			Object iBlockState = worldGetBlockState(worldOrEntity, newBlockPos(x, y, z));
			Object block = iBlockState != null ? iBlockStateGetBlock(iBlockState) : null;
			if (block != null); else return 0;
			return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("Block", "func_149750_m", "getLightValue", block));
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("World", "func_72957_l", "getBlockLightValue", new Class[]{ int.class, int.class, int.class }, entityWorldObj(worldOrEntity), new Object[]{ x, y, z }));
	}

	protected int worldGetStrongPower(int x, int y, int z) {
		return worldGetStrongPower(minecraftTheWorld(), x, y, z);
	}

	protected int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		if (Modchu_Main.getMinecraftVersion() > 179) return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("World", "func_175627_a", "getStrongPower", new Class[]{ Modchu_Reflect.loadClass("BlockPos") }, entityWorldObj(worldOrEntity), new Object[]{ newBlockPos(x, y, z) }));
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("World", "func_94577_B", "getBlockPowerInput", new Class[]{ int.class, int.class, int.class }, entityWorldObj(worldOrEntity), new Object[]{ x, y, z }));
	}

	protected int tileEntityXCoord(Object tileEntity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(tileEntity.getClass(), "field_72450_a", "xCoord", tileEntity));
	}

	protected int tileEntityYCoord(Object tileEntity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(tileEntity.getClass(), "field_72448_b", "yCoord", tileEntity));
	}

	protected int tileEntityZCoord(Object tileEntity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod(tileEntity.getClass(), "field_72449_c", "zCoord", tileEntity));
	}

	protected Object newBlockPos(Object x, Object y, Object z) {
		return Modchu_Reflect.newInstance("BlockPos", new Class[]{ x.getClass(), y.getClass(), z.getClass() }, new Object[]{ x, y, z });
	}

	protected Object newModelResourceLocation(String s, String s1) {
		return Modchu_Reflect.newInstance("ModelResourceLocation", new Class[]{ String.class, String.class }, new Object[]{ s, s1 });
	}

	protected Object worldGetBlockState(Object worldOrEntity, Object blockPos) {
		return Modchu_Reflect.invokeMethod("World", "func_177435_g", "getBlockState", new Class[]{ blockPos.getClass() }, entityWorldObj(worldOrEntity), new Object[]{ blockPos });
	}

	protected Object worldGetEntityByID(int i) {
		return worldGetEntityByID(minecraftTheWorld(), i);
	}

	protected Object worldGetEntityByID(Object worldOrEntity, int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("World", "func_72545_a", "getEntityByID", new Class[]{ int.class }, entityWorldObj(worldOrEntity), new Object[]{ i }));
	}

	private Object[] instanceCut(Object[] pArg) {
		Object[] o = new Object[pArg.length - 1];
		for (int i = 0; i < pArg.length - 1; i++) {
			o[i] = pArg[i + 1];
		}
		return o;
	}

	private Class[] objectArrayGetClass(Object[] o) {
		Class[] cl = new Class[o.length];
		for (int i = 0; i < o.length; i++) {
			cl[i] = unWrappingClass(o[i].getClass());
		}
		return cl;
	}

	private Class unWrappingClass(Class c) {
		if (c == Integer.class) return int.class;
		if (c == Float.class) return float.class;
		if (c == Double.class) return double.class;
		if (c == Byte.class) return byte.class;
		if (c == Short.class) return short.class;
		if (c == Long.class) return long.class;
		return c;
	}

}
