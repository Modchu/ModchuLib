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
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.characteristic.Modchu_CastHelper;
import modchu.pflm.PFLM_ItemRendererMaster;
import net.minecraft.client.gui.GuiSlot;

import org.lwjgl.input.Keyboard;

public class Modchu_ASAlmighty extends Modchu_ASBase {
	public static Modchu_ASAlmighty instance;
	protected static boolean initNewVersionItemNameMap = false;
	protected static boolean initOldVersionItemMap = false;
	protected static ConcurrentHashMap<String, String> newVersionItemNameMap;
	protected static ConcurrentHashMap<String, Object> oldVersionItemMap;
	private int getMinecraftMode = 0;

	public Modchu_ASAlmighty() {
		instance = this;
	}

	public static Object get(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getB(null, pIndex, (Object[])pArg);
	}

	public static Object get(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getB(accessSupport, pIndex, (Object[])pArg);
	}

	public static boolean set(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.setB(null, pIndex, (Object[])pArg);
	}

	public static boolean set(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
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
		switch (pIndex) {
		case render:
			return render(pArg);
		case FMLCommonHandlerInstance:
			return FMLCommonHandlerInstance();
		case FMLCommonHandlerInstanceGetMinecraftServerInstance:
			return FMLCommonHandlerInstanceGetMinecraftServerInstance();
		case FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers:
			return FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers();
		case minecraftGetMinecraft:
			return minecraftGetMinecraft();
		case minecraftThePlayer:
			return minecraftThePlayer();
		case minecraftTheWorld:
			return minecraftTheWorld();
		case minecraftMcDataDir:
			return minecraftMcDataDir();
		case minecraftFontRenderer:
			return minecraftFontRenderer();
		case minecraftSession:
			return minecraftSession();
		case minecraftGetSession:
			return minecraftGatSession();
		case isMac:
			return isMac();
		case isCtrlKeyDown:
			return isCtrlKeyDown();
		case isShiftKeyDown:
			return isShiftKeyDown();
		case keyBindingKeyCode:
			return pArg != null && pArg.length > 0 ? keyBindingKeyCode(pArg[0]) : null;
		case keyBindingKeyDescription:
			return pArg != null && pArg.length > 0 ? keyBindingKeyDescription(pArg[0]) : null;
		case keyBindingKeyCategory:
			return pArg != null && pArg.length > 0 ? keyBindingKeyCategory(pArg[0]) : null;
		case keyBindingPressed:
			return pArg != null && pArg.length > 0 ? keyBindingPressed(pArg[0]) : null;
		case keyBindingGetIsKeyPressed:
			return pArg != null && pArg.length > 0 ? keyBindingGetIsKeyPressed(pArg[0]) : null;
		case keyBindingIsPressed:
			return pArg != null && pArg.length > 0 ? keyBindingIsPressed(pArg[0]) : null;
		case keyBindingPressTime:
			return pArg != null && pArg.length > 0 ? keyBindingPressTime(pArg[0]) : null;
		case blockBlockList:
			return blockBlockList();
		case itemItemsList:
			return itemItemsList();
		case getBlock:
			return pArg != null && pArg.length > 0 ? getBlock(pArg[0]) : null;
		case blockGetBlockFromItem:
			return pArg != null && pArg.length > 0 ? blockGetBlockFromItem(pArg[0]) : null;
		case getBlockItemStack:
			return pArg != null && pArg.length > 0 ? getBlockItemStack(pArg[0]) : null;
		case getItem:
			return pArg != null && pArg.length > 0 ? getItem((String) pArg[0]) : null;
		case itemStackGetItem:
			return pArg != null && pArg.length > 0 ? itemStackGetItem(pArg[0]) : null;
		case itemItemID:
			return pArg != null && pArg.length > 0 ? itemItemID(pArg[0]) : null;
		case itemStackItemID:
			return pArg != null && pArg.length > 0 ? itemStackItemID(pArg[0]) : null;
		case isSkull:
			return pArg != null && pArg.length > 0 ? isSkull(pArg[0]) : null;
		case entityEntityID:
			return pArg != null && pArg.length > 0 ? entityEntityID(pArg[0]) : entityEntityID();
		case keybindArray:
			return keybindArray();
		case userName:
			return pArg != null && pArg.length > 0 ? getUserName(pArg[0]) : getUserName();
		case isPlanter:
			return pArg != null && pArg.length > 0 ? isPlanter(pArg[0]) : null;
		case isCamouflage:
			return pArg != null && pArg.length > 0 ? isCamouflage(pArg[0]) : null;
		case vacancyGlobalEntityID:
			return getVacancyGlobalEntityID();
		case isLANWorld:
			return isLANWorld();
		case isIntegratedServerRunning:
			return isIntegratedServerRunning();
		case isMuiti:
			return isMuiti();
		case renderRenderBlocks:
			return pArg != null && pArg.length > 0 ? renderRenderBlocks(pArg[0]) : null;
		case renderManagerGetEntityRenderObject:
			return pArg != null && pArg.length > 0 ? renderManagerGetEntityRenderObject(pArg[0]) : null;
		case renderMainModel:
			return pArg != null && pArg.length > 0 ? renderMainModel(pArg[0]) : null;
		case inventoryPlayerArmorItemInSlot:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return inventoryPlayerArmorItemInSlot(pArg[0], (Integer) pArg[1]);
			}
			return null;
		case itemStackStackSize:
			return pArg != null && pArg.length > 0 ? itemStackStackSize(pArg[0]) : null;
		case itemStackIsItemEnchanted:
			return pArg != null && pArg.length > 0 ? itemStackIsItemEnchanted(pArg[0]) : null;
		case mathHelperSin:
			return pArg != null && pArg.length > 0 ? mathHelperSin((Float) pArg[0]) : null;
		case mathHelperCos:
			return pArg != null && pArg.length > 0 ? mathHelperCos((Float) pArg[0]) : null;
		case mathHelperSqrt_float:
			return pArg != null && pArg.length > 0 ? mathHelperSqrt_float((Float) pArg[0]) : null;
		case mathHelperFloor_double:
			return pArg != null && pArg.length > 0 ? mathHelperFloor_double((Double) pArg[0]) : null;
		case modelRendererGetTextureOffsetMap:
			return pArg != null && pArg.length > 0 ? modelRendererGetTextureOffsetMap(pArg[0]) : null;
		case textureOffsetTextureOffsetX:
			return pArg != null && pArg.length > 0 ? textureOffsetTextureOffsetX(pArg[0]) : null;
		case textureOffsetTextureOffsetY:
			return pArg != null && pArg.length > 0 ? textureOffsetTextureOffsetY(pArg[0]) : null;
		case minecraftCurrentScreen:
			return minecraftCurrentScreen();
		case entityPlayerIsPlayerSleeping:
			return pArg != null && pArg.length > 0 ? entityPlayerIsPlayerSleeping(pArg[0]) : entityPlayerIsPlayerSleeping();
		case entityWidth:
			return pArg != null && pArg.length > 0 ? entityWidth(pArg[0]) : entityWidth();
		case entityHeight:
			return pArg != null && pArg.length > 0 ? entityHeight(pArg[0]) : entityHeight();
		case glAllocationCreateDirectIntBuffer:
			return pArg != null && pArg.length > 0 ? glAllocationCreateDirectIntBuffer((Integer) pArg[0]) : null;
		case glAllocationGenerateDisplayLists:
			return pArg != null && pArg.length > 0 ? glAllocationGenerateDisplayLists((Integer) pArg[0]) : null;
		case inventoryPlayerGetStackInSlot:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return inventoryPlayerGetStackInSlot(pArg[0], (Integer) pArg[1]);
			}
			return null;
		case itemStackGetItemDamage:
			return pArg != null && pArg.length > 0 ? itemStackGetItemDamage(pArg[0]) : null;
		case renderManagerInstance:
			return renderManagerInstance();
		case renderManagerGetEntityClassRenderObject:
			return pArg != null && pArg.length > 0 ? renderManagerGetEntityClassRenderObject((Class) pArg[0]) : null;
		case newInstanceKeyBinding:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return newInstanceKeyBinding((String) pArg[0], (Integer) pArg[1], (String) pArg[2]);
			}
			return null;
		case renderManagerEntityRenderMap:
			return renderManagerEntityRenderMap();
		case minecraftGameSettings:
			return minecraftGameSettings();
		case minecraftGameSettingsThirdPersonView:
			return minecraftGameSettingsThirdPersonView();
		case minecraftEntityRenderer:
			return minecraftEntityRenderer();
		case minecraftTextureManager:
			return minecraftTextureManager();
		case minecraftGetTextureManager:
			return minecraftGetTextureManager();
		case minecraftGetResourceManager:
			return minecraftGetResourceManager();
		case minecraftSystemTime:
			return minecraftSystemTime();
		case minecraftGetSystemTime:
			return minecraftGetSystemTime();
		case minecraftDisplayWidth:
			return minecraftDisplayWidth();
		case minecraftDisplayHeight:
			return minecraftDisplayHeight();
		case minecraftEntityRendererItemRenderer:
			return minecraftEntityRendererItemRenderer();
		case renderManagerItemRenderer:
			return renderManagerItemRenderer();
		case newInstanceItemRenderer:
			return newInstanceItemRenderer();
		case minecraftPlayerController:
			return minecraftPlayerController();
		case worldGetWorldInfo:
			return worldGetWorldInfo();
		case worldGetWorldInfoGetGameType:
			return worldGetWorldInfoGetGameType();
		case entityPosX:
			return pArg != null && pArg.length > 0 ? entityPosX(pArg[0]) : entityPosX();
		case entityPosY:
			return pArg != null && pArg.length > 0 ? entityPosY(pArg[0]) : entityPosY();
		case entityPosZ:
			return pArg != null && pArg.length > 0 ? entityPosZ(pArg[0]) : entityPosZ();
		case entityPrevPosX:
			return pArg != null && pArg.length > 0 ? entityPrevPosX(pArg[0]) : entityPrevPosX();
		case entityPrevPosY:
			return pArg != null && pArg.length > 0 ? entityPrevPosY(pArg[0]) : entityPrevPosY();
		case entityPrevPosZ:
			return pArg != null && pArg.length > 0 ? entityPrevPosZ(pArg[0]) : entityPrevPosZ();
		case entityMotionX:
			return pArg != null && pArg.length > 0 ? entityMotionX(pArg[0]) : entityMotionX();
		case entityMotionY:
			return pArg != null && pArg.length > 0 ? entityMotionY(pArg[0]) : entityMotionY();
		case entityMotionZ:
			return pArg != null && pArg.length > 0 ? entityMotionZ(pArg[0]) : entityMotionZ();
		case entityPrevDistanceWalkedModified:
			return pArg != null && pArg.length > 0 ? entityPrevDistanceWalkedModified(pArg[0]) : entityPrevDistanceWalkedModified();
		case entityDistanceWalkedModified:
			return pArg != null && pArg.length > 0 ? entityDistanceWalkedModified(pArg[0]) : entityDistanceWalkedModified();
		case entityTicksExisted:
			return pArg != null && pArg.length > 0 ? entityTicksExisted(pArg[0]) : entityTicksExisted();
		case entityPlayerGetHideCape:
			return pArg != null && pArg.length > 0 ? entityPlayerGetHideCape(pArg[0]) : entityPlayerGetHideCape();
		case playerControllerMPCreatePlayer:
			return pArg != null && pArg.length > 0 ? playerControllerMPCreatePlayer(pArg[0]) : null;
		case entityPlayerInventory:
			return pArg != null && pArg.length > 0 ? entityPlayerInventory(pArg[0]) : entityPlayerInventory();
		case entityPlayerInventoryGetCurrentItem:
			return pArg != null && pArg.length > 0 ? entityPlayerInventoryGetCurrentItem(pArg[0]) : entityPlayerInventoryGetCurrentItem();
		case entityPlayerMainInventory:
			return pArg != null && pArg.length > 0 ? entityPlayerMainInventory(pArg[0]) : entityPlayerMainInventory();
		case entityPlayerArmorInventory:
			return pArg != null && pArg.length > 0 ? entityPlayerArmorInventory(pArg[0]) : entityPlayerArmorInventory();
		case entityPlayerInventoryGetStackInSlot:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityPlayerInventoryGetStackInSlot(pArg[0], (Integer) pArg[1]);
			}
			return entityPlayerInventoryGetStackInSlot((Integer) pArg[0]);
		case entityPlayerInventoryPlayerArmorItemInSlot:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityPlayerInventoryPlayerArmorItemInSlot(pArg[0], (Integer) pArg[1]);
			}
			return entityPlayerInventoryPlayerArmorItemInSlot((Integer) pArg[0]);
		case entityDimension:
			return pArg != null && pArg.length > 0 ? entityDimension(pArg[0]) : entityDimension();
		case gameSettingsKeyBindForward:
			return gameSettingsKeyBindForward();
		case gameSettingsKeyBindBack:
			return gameSettingsKeyBindBack();
		case gameSettingsKeyBindLeft:
			return gameSettingsKeyBindLeft();
		case gameSettingsKeyBindRight:
			return gameSettingsKeyBindRight();
		case entityIsRiding:
			return pArg != null && pArg.length > 0 ? entityIsRiding(pArg[0]) : entityIsRiding();
		case minecraftInGameHasFocus:
			return minecraftInGameHasFocus();
		case entityGetEyeHeight:
			return pArg != null && pArg.length > 0 ? entityGetEyeHeight(pArg[0]) : entityGetEyeHeight();
		case entityBoundingBox:
			return pArg != null && pArg.length > 0 ? entityBoundingBox(pArg[0]) : entityBoundingBox();
		case entityBoundingBoxMinX:
			return pArg != null && pArg.length > 0 ? entityBoundingBoxMinX(pArg[0]) : entityBoundingBoxMinX();
		case entityBoundingBoxMinY:
			return pArg != null && pArg.length > 0 ? entityBoundingBoxMinY(pArg[0]) : entityBoundingBoxMinY();
		case entityBoundingBoxMinZ:
			return pArg != null && pArg.length > 0 ? entityBoundingBoxMinZ(pArg[0]) : entityBoundingBoxMinZ();
		case entityBoundingBoxMaxX:
			return pArg != null && pArg.length > 0 ? entityBoundingBoxMaxX(pArg[0]) : entityBoundingBoxMaxX();
		case entityBoundingBoxMaxY:
			return pArg != null && pArg.length > 0 ? entityBoundingBoxMaxY(pArg[0]) : entityBoundingBoxMaxY();
		case entityBoundingBoxMaxZ:
			return pArg != null && pArg.length > 0 ? entityBoundingBoxMaxZ(pArg[0]) : entityBoundingBoxMaxZ();
		case entityIsSneaking:
			return pArg != null && pArg.length > 0 ? entityIsSneaking(pArg[0]) : entityIsSneaking();
		case entityWorldObj:
			return pArg != null && pArg.length > 0 ? entityWorldObj(pArg[0]) : entityWorldObj();
		case entityPlayerField_71091_bM:
			return pArg != null && pArg.length > 0 ? entityPlayerField_71091_bM(pArg[0]) : entityPlayerField_71091_bM();
		case entityPlayerField_71096_bN:
			return pArg != null && pArg.length > 0 ? entityPlayerField_71096_bN(pArg[0]) : entityPlayerField_71096_bN();
		case entityPlayerField_71097_bO:
			return pArg != null && pArg.length > 0 ? entityPlayerField_71097_bO(pArg[0]) : entityPlayerField_71097_bO();
		case entityPlayerField_71094_bP:
			return pArg != null && pArg.length > 0 ? entityPlayerField_71094_bP(pArg[0]) : entityPlayerField_71094_bP();
		case entityPlayerField_71095_bQ:
			return pArg != null && pArg.length > 0 ? entityPlayerField_71095_bQ(pArg[0]) : entityPlayerField_71095_bQ();
		case entityPlayerField_71085_bR:
			return pArg != null && pArg.length > 0 ? entityPlayerField_71085_bR(pArg[0]) : entityPlayerField_71085_bR();
		case worldIsAirBlock:
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
		case renderLoadDownloadableImageTexture:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return renderLoadDownloadableImageTexture(pArg[0], (String) pArg[1], (String) pArg[2]);
			}
			return null;
		case positionTextureVertexSetTexturePosition:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return positionTextureVertexSetTexturePosition(pArg[0], (Float) pArg[1], (Float) pArg[2]);
			}
			return null;
		case positionTextureVertexVector3D:
			return pArg != null && pArg.length > 0 ? positionTextureVertexVector3D(pArg[0]) : null;
		case vec3CreateVectorHelper:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				return vec3CreateVectorHelper((Double) pArg[0], (Double) pArg[1], (Double) pArg[2]);
			}
			return null;
		case vec3Subtract:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return vec3Subtract(pArg[0], pArg[1]);
			}
			return null;
		case vec3CrossProduct:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return vec3CrossProduct(pArg[0], pArg[1]);
			}
			return null;
		case vec3Normalize:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				return vec3Normalize(pArg[0]);
			}
			return null;
		case positionTextureVertexTexturePositionX:
			return pArg != null && pArg.length > 0 ? positionTextureVertexTexturePositionX(pArg[0]) : null;
		case positionTextureVertexTexturePositionY:
			return pArg != null && pArg.length > 0 ? positionTextureVertexTexturePositionY(pArg[0]) : null;
		case vec3XCoord:
			return pArg != null && pArg.length > 0 ? vec3XCoord(pArg[0]) : null;
		case vec3YCoord:
			return pArg != null && pArg.length > 0 ? vec3YCoord(pArg[0]) : null;
		case vec3ZCoord:
			return pArg != null && pArg.length > 0 ? vec3ZCoord(pArg[0]) : null;
		case entityRidingEntity:
			return pArg != null && pArg.length > 0 ? entityRidingEntity(pArg[0]) : entityRidingEntity();
		case entityLivingBaseDeathTime:
			return pArg != null && pArg.length > 0 ? entityLivingBaseDeathTime(pArg[0]) : entityLivingBaseDeathTime();
		case entityYOffset:
			return pArg != null && pArg.length > 0 ? entityYOffset(pArg[0]) : entityYOffset();
		case worldIsDaytime:
			return pArg != null && pArg.length > 0 ? worldIsDaytime(pArg[0]) : worldIsDaytime();
		case entityGetBrightness:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityGetBrightness(pArg[0], (Float) pArg[1]);
			}
			return entityGetBrightness((Float) pArg[0]);
		case entityGetBrightnessForRender:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityGetBrightnessForRender(pArg[0], (Float) pArg[1]);
			}
			return entityGetBrightnessForRender((Float) pArg[0]);
		case worldCanBlockSeeTheSky:
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
		case entityIsWet:
			return pArg != null && pArg.length > 0 ? entityIsWet(pArg[0]) : entityIsWet();
		case entityIsInWater:
			return pArg != null && pArg.length > 0 ? entityIsInWater(pArg[0]) : entityIsInWater();
		case abstractClientPlayerGetTextureSkin:
			return pArg != null && pArg.length > 0 ? abstractClientPlayerGetTextureSkin(pArg[0]) : abstractClientPlayerGetTextureSkin();
		case threadDownloadImageDataIsTextureUploaded:
			return pArg != null && pArg.length > 0 ? threadDownloadImageDataIsTextureUploaded(pArg[0]) : null;
		case damageSourceStarve:
			return damageSourceStarve();
		case damageSourceCactus:
			return damageSourceCactus();
		case damageSourceInWall:
			return damageSourceInWall();
		case damageSourceDrown:
			return damageSourceDrown();
		case damageSourceOnFire:
			return damageSourceOnFire();
		case damageSourceLava:
			return damageSourceLava();
		case damageSourceInFire:
			return damageSourceInFire();
		case damageSourceMagic:
			return damageSourceMagic();
		case damageSourceGeneric:
			return damageSourceGeneric();
		case damageSourceFall:
			return damageSourceFall();
		case damageSourceOutOfWorld:
			return damageSourceOutOfWorld();
		case damageSourceWither:
			return damageSourceWither();
		case damageSourceAnvil:
			return damageSourceAnvil();
		case damageSourceFallingBlock:
			return damageSourceFallingBlock();
		case entityLivingBaseGetMaxHealth:
			return pArg != null && pArg.length > 0 ? entityLivingBaseGetMaxHealth(pArg[0]) : entityLivingBaseGetMaxHealth();
		case entityLivingBaseHealth:
			return pArg != null && pArg.length > 0 ? entityLivingBaseHealth(pArg[0]) : entityLivingBaseHealth();
		case entityLivingBaseGetHealth:
			return pArg != null && pArg.length > 0 ? entityLivingBaseGetHealth(pArg[0]) : entityLivingBaseGetHealth();
		case worldIsRemote:
			return pArg != null && pArg.length > 0 ? worldIsRemote(pArg[0]) : worldIsRemote();
		case enumCreatureAttributeUNDEFINED:
			return enumCreatureAttributeUNDEFINED();
		case enumCreatureAttributeUNDEAD:
			return enumCreatureAttributeUNDEAD();
		case enumCreatureAttributeARTHROPOD:
			return enumCreatureAttributeARTHROPOD();
		case worldIsBlockNormalCubeDefault:
			if (pArg != null
			&& pArg.length > 3
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null
			&& pArg[3] != null) {
				return worldIsBlockNormalCubeDefault((Integer) pArg[0], (Integer) pArg[1], (Integer) pArg[2], (Boolean) pArg[3]);
			}
			return null;
		case entityPlayerFoodStats:
			return pArg != null && pArg.length > 0 ? entityPlayerFoodStats(pArg[0]) : entityPlayerFoodStats();
		case entityPlayerGetFoodStats:
			return pArg != null && pArg.length > 0 ? entityPlayerGetFoodStats(pArg[0]) : entityPlayerGetFoodStats();
		case entityPlayerPlayerLevel:
			return pArg != null && pArg.length > 0 ? entityPlayerPlayerLevel(pArg[0]) : entityPlayerPlayerLevel();
		case entityPlayerTotalXP:
			return pArg != null && pArg.length > 0 ? entityPlayerTotalXP(pArg[0]) : entityPlayerTotalXP();
		case entityPlayerCurrentXP:
			return pArg != null && pArg.length > 0 ? entityPlayerCurrentXP(pArg[0]) : entityPlayerCurrentXP();
		case entityPlayerScore:
			return pArg != null && pArg.length > 0 ? entityPlayerScore(pArg[0]) : entityPlayerScore();
		case entityPlayerPrevCameraYaw:
			return pArg != null && pArg.length > 0 ? entityPlayerPrevCameraYaw(pArg[0]) : entityPlayerPrevCameraYaw();
		case entityPlayerCameraYaw:
			return pArg != null && pArg.length > 0 ? entityPlayerCameraYaw(pArg[0]) : entityPlayerCameraYaw();
		case entityPlayerGetItemInUseCount:
			return pArg != null && pArg.length > 0 ? entityPlayerGetItemInUseCount(pArg[0]) : entityPlayerGetItemInUseCount();
		case itemStackCopyItemStack:
			return pArg != null && pArg.length > 0 ? itemStackCopyItemStack(pArg[0]) : null;
		case itemStackGetItemUseAction:
			return pArg != null && pArg.length > 0 ? itemStackGetItemUseAction(pArg[0]) : null;
		case renderBipedBipedArmorFilenamePrefix:
			return renderBipedBipedArmorFilenamePrefix();
		case itemArmorRenderIndex:
			return pArg != null && pArg.length > 0 ? itemArmorRenderIndex(pArg[0]) : null;
		case entityLivingBasePrevRenderYawOffset:
			return pArg != null && pArg.length > 0 ? entityLivingBasePrevRenderYawOffset(pArg[0]) : entityLivingBasePrevRenderYawOffset();
		case entityLivingBaseRenderYawOffset:
			return pArg != null && pArg.length > 0 ? entityLivingBaseRenderYawOffset(pArg[0]) : entityLivingBaseRenderYawOffset();
		case entityLivingBasePrevRotationYawHead:
			return pArg != null && pArg.length > 0 ? entityLivingBasePrevRotationYawHead(pArg[0]) : entityLivingBasePrevRotationYawHead();
		case entityLivingBaseRotationYawHead:
			return pArg != null && pArg.length > 0 ? entityLivingBaseRotationYawHead(pArg[0]) : entityLivingBaseRotationYawHead();
		case entityLivingBasePrevLimbSwingAmount:
			return pArg != null && pArg.length > 0 ? entityLivingBasePrevLimbSwingAmount(pArg[0]) : entityLivingBasePrevLimbSwingAmount();
		case entityLivingBaseLimbSwingAmount:
			return pArg != null && pArg.length > 0 ? entityLivingBaseLimbSwingAmount(pArg[0]) : entityLivingBaseLimbSwingAmount();
		case entityLivingBaseLimbSwing:
			return pArg != null && pArg.length > 0 ? entityLivingBaseLimbSwing(pArg[0]) : entityLivingBaseLimbSwing();
		case entityLivingBaseIsJumping:
			return pArg != null && pArg.length > 0 ? entityLivingBaseIsJumping(pArg[0]) : entityLivingBaseIsJumping();
		case entityPrevRotationYaw:
			return pArg != null && pArg.length > 0 ? entityPrevRotationYaw(pArg[0]) : entityPrevRotationYaw();
		case entityRotationYaw:
			return pArg != null && pArg.length > 0 ? entityRotationYaw(pArg[0]) : entityRotationYaw();
		case entityPrevRotationPitch:
			return pArg != null && pArg.length > 0 ? entityPrevRotationPitch(pArg[0]) : entityPrevRotationPitch();
		case entityRotationPitch:
			return pArg != null && pArg.length > 0 ? entityRotationPitch(pArg[0]) : entityRotationPitch();
		case entityLivingBaseMoveStrafing:
			return pArg != null && pArg.length > 0 ? entityLivingBaseMoveStrafing(pArg[0]) : entityLivingBaseMoveStrafing();
		case entityLivingBaseMoveForward:
			return pArg != null && pArg.length > 0 ? entityLivingBaseMoveForward(pArg[0]) : entityLivingBaseMoveForward();
		case entityIsInvisible:
			return pArg != null && pArg.length > 0 ? entityIsInvisible(pArg[0]) : entityIsInvisible();
		case entityLivingBaseGetSwingProgress:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return entityLivingBaseGetSwingProgress(pArg[0], (Float) pArg[1]);
			}
			return entityLivingBaseGetSwingProgress((Float) pArg[0]);
		case enumactionBlock:
			return enumactionBlock();
		case enumactionBow:
			return enumactionBow();
		case enumactionDrink:
			return enumactionDrink();
		case enumactionEat:
			return enumactionEat();
		case enumactionNone:
			return enumactionNone();
		case rendererLivingEntityRES_ITEM_GLINT:
			return pArg != null && pArg.length > 0 ? rendererLivingEntityRES_ITEM_GLINT(pArg[0]) : null;
		case openGlHelperDefaultTexUnit:
			return openGlHelperDefaultTexUnit();
		case openGlHelperLightmapTexUnit:
			return openGlHelperLightmapTexUnit();
		case guiScreenButtonList:
			return pArg != null && pArg.length > 0 ? guiScreenButtonList(pArg[0]) : null;
		case guiScreenWidth:
			return pArg != null && pArg.length > 0 ? guiScreenWidth(pArg[0]) : null;
		case guiScreenHeight:
			return pArg != null && pArg.length > 0 ? guiScreenHeight(pArg[0]) : null;
		case guiScreenFontRenderer:
			return pArg != null && pArg.length > 0 ? guiScreenFontRenderer(pArg[0]) : null;
		case guiButtonWidth:
			return pArg != null && pArg.length > 0 ? guiButtonWidth(pArg[0]) : null;
		case guiButtonHeight:
			return pArg != null && pArg.length > 0 ? guiButtonHeight(pArg[0]) : null;
		case guiButtonID:
			return pArg != null && pArg.length > 0 ? guiButtonID(pArg[0]) : null;
		case guiButtonEnabled:
			return pArg != null && pArg.length > 0 ? guiButtonEnabled(pArg[0]) : null;
		case guiButtonXPosition:
			return pArg != null && pArg.length > 0 ? guiButtonXPosition(pArg[0]) : null;
		case guiButtonYPosition:
			return pArg != null && pArg.length > 0 ? guiButtonYPosition(pArg[0]) : null;
		case guiButtonVisible:
			return pArg != null && pArg.length > 0 ? guiButtonVisible(pArg[0]) : null;
		case resourceManagerInputStream:
			return pArg != null && pArg.length > 0 ? resourceManagerInputStream(pArg[0]) : null;
		case resourceGetInputStream:
			return pArg != null && pArg.length > 0 ? resourceGetInputStream(pArg[0]) : null;
		case textureUtilUploadTextureImage:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				return textureUtilUploadTextureImage((Integer) pArg[0], pArg[1]);
			}
			return null;
		case tessellatorInstance:
			return tessellatorInstance();
		case worldPlayerEntities:
			return pArg != null && pArg.length > 0 ? worldPlayerEntities(pArg[0]) : worldPlayerEntities();
		case gameSettingsGetKeyDisplayString:
			return pArg != null && pArg.length > 0 ? gameSettingsGetKeyDisplayString((Integer) pArg[0]) : null;
		case renderEngine:
			return renderEngine();
		case renderManagerRenderEntityWithPosYaw:
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
		case textureManagerGetTexture:
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
		case resourceManagerGetResource:
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
		return null;
	}

	@Override
	public boolean setB(int pIndex, Object... pArg) {
		return setB(null, pIndex, (Object[])pArg);
	}

	@Override
	public boolean setB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		switch (pIndex) {
		case setRender:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setRender(pArg[0], pArg[1]);
				return true;
			}
			return false;
		case allModelInit:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				allModelInit(pArg[0], pArg[1], (Boolean) pArg[2]);
				return true;
			}
			return false;
		case setArmorRendering:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setArmorRendering(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		case minecraftThePlayer:
			setMinecraftThePlayer(pArg[0]);
			return true;
		case minecraftFontRenderer:
			minecraftFontRenderer(pArg[0]);
			return true;
		case printChatMessage:
			printChatMessage((String) pArg[0]);
			return true;
		case keyBindingPressed:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				keyBindingSetPressed(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		case entityEntityID:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityEntityID(pArg[0], (Integer) pArg[1]);
					return true;
				}
				setEntityEntityID((Integer) pArg[0]);
				return true;
			}
			return false;
		case minecraftDisplayGuiScreen:
			setMinecraftDisplayGuiScreen(pArg[0]);
			return true;
		case guiIngameDrawString:
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
		case renderBlocksRenderBlockAsItem:
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
		case renderBlocksRenderBlockAllFaces:
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
		case fontRendererDrawString:
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
		case renderBindTexture:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				renderBindTexture(pArg[0], pArg[1]);
				return true;
			}
			return false;
		case renderEngineBindTexture:
			renderEngineBindTexture((String) pArg[0]);
			return true;
		case renderRenderManager:
			renderSetRenderManager(pArg[0]);
			return true;
		case renderFirstPersonArm:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				renderFirstPersonArm(pArg[0], pArg[1]);
				return true;
			}
			return false;
		case blockSetLightOpacity:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				blockSetLightOpacity(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		case minecraftGameSettingsSetThirdPersonView:
			minecraftGameSettingsSetThirdPersonView((Integer) pArg[0]);
			return true;
		case entityRendererItemRenderer:
			setEntityRendererItemRenderer(pArg[0]);
			return true;
		case renderManagerItemRenderer:
			setRenderManagerItemRenderer(pArg[0]);
			return true;
		case renderMainModel:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setRenderMainModel(pArg[0], pArg[1]);
			}
			return true;
		case minecraftPlayerController:
			setMinecraftPlayerController(pArg[0]);
			return true;
		case setEntityPosX:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPosX(pArg[0], (Double) pArg[1]);
					return true;
				}
				setEntityPosX((Double) pArg[0]);
				return true;
			}
			return false;
		case setEntityPosY:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPosY(pArg[0], (Double) pArg[1]);
					return true;
				}
				setEntityPosY((Double) pArg[0]);
				return true;
			}
			return false;
		case setEntityPosZ:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPosZ(pArg[0], (Double) pArg[1]);
					return true;
				}
				setEntityPosZ((Double) pArg[0]);
				return true;
			}
			return false;
		case playerControllerSetGameType:
			playerControllerSetGameType(pArg[0]);
			return true;
		case minecraftSetDimensionAndSpawnPlayer:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				minecraftSetDimensionAndSpawnPlayer((Integer) pArg[0]);
				return true;
			}
			minecraftSetDimensionAndSpawnPlayer();
			return true;
		case playerControllerCreativeSetPlayerCapabilities:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					playerControllerCreativeSetPlayerCapabilities(pArg[0], pArg[1]);
					return true;
				}
				playerControllerCreativeSetPlayerCapabilities(pArg[0]);
				return true;
			}
			playerControllerCreativeSetPlayerCapabilities();
			return true;
		case worldSetEntityDead:
			if (pArg[0] != null) worldSetEntityDead(pArg[0]);
			else worldSetEntityDead();
			return true;
		case entitySetDead:
			if (pArg[0] != null) entitySetDead(pArg[0]);
			else entitySetDead();
			return true;
		case minecraftRenderViewEntity:
			if (pArg[0] != null) setMinecraftRenderViewEntity(pArg[0]);
			else setMinecraftRenderViewEntity();
			return true;
		case playerControllerMPFlipPlayer:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					playerControllerMPFlipPlayer(pArg[0], pArg[1]);
					return true;
				}
				playerControllerMPFlipPlayer(pArg[0]);
				return true;
			}
			playerControllerMPFlipPlayer();
			return true;
		case worldSpawnPlayerWithLoadedChunks:
			if (pArg[0] != null) worldSpawnPlayerWithLoadedChunks(pArg[0]);
			else worldSpawnPlayerWithLoadedChunks();
			return true;
		case entityPlayerSPMovementInput:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					setEntityPlayerSPMovementInput(pArg[0], pArg[1]);
					return true;
				}
				setEntityPlayerSPMovementInput(pArg[0]);
				return true;
			}
			setEntityPlayerSPMovementInput();
			return true;
		case entityPlayerSPFunc_6420_o:
			if (pArg[0] != null) entityPlayerSPFunc_6420_o(pArg[0]);
			else entityPlayerSPFunc_6420_o();
			return true;
		case playerControllerFunc_6473_b:
			if (pArg != null
			&& pArg.length > 0
			&& pArg[0] != null) {
				if (pArg.length > 1
						&& pArg[1] != null) {
					playerControllerFunc_6473_b(pArg[0], pArg[1]);
					return true;
				}
				playerControllerFunc_6473_b(pArg[0]);
				return true;
			}
			playerControllerFunc_6473_b();
			return true;
		case entityPlayerInventory:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityPlayerInventory(pArg[0], pArg[1]);
				return true;
			}
			setEntityPlayerInventory(pArg[0]);
			return true;
		case entityPlayerMainInventory:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityPlayerMainInventory(pArg[0], pArg[1]);
				return true;
			}
			setEntityPlayerMainInventory(pArg[0]);
			return true;
		case entityPlayerArmorInventory:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityPlayerArmorInventory(pArg[0], pArg[1]);
				return true;
			}
			setEntityPlayerArmorInventory(pArg[0]);
			return true;
		case getResource:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				getResource((Class) pArg[0], (String) pArg[1]);
				return true;
			}
			getResource((String) pArg[0]);
			return true;
		case gameSettingsKeyBindForward:
			setGameSettingsKeyBindForward(pArg[0]);
		case gameSettingsKeyBindBack:
			setGameSettingsKeyBindBack(pArg[0]);
		case gameSettingsKeyBindRight:
			setGameSettingsKeyBindRight(pArg[0]);
		case gameSettingsKeyBindLeft:
			setGameSettingsKeyBindLeft(pArg[0]);
		case entityMotionX:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityMotionX(pArg[0], (Double) pArg[1]);
				return true;
			}
			setEntityMotionX((Double) pArg[0]);
			return true;
		case entityMotionY:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityMotionY(pArg[0], (Double) pArg[1]);
				return true;
			}
			setEntityMotionY((Double) pArg[0]);
			return true;
		case entityMotionZ:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityMotionZ(pArg[0], (Double) pArg[1]);
				return true;
			}
			setEntityMotionZ((Double) pArg[0]);
			return true;
		case entitySetPosition:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					entitySetPosition(pArg[0], (Double) pArg[1], (Double) pArg[2], (Double) pArg[3]);
					return true;
				}
				entitySetPosition((Double) pArg[0], (Double) pArg[1], (Double) pArg[2]);
				return true;
			}
			return false;
		case entitySetSize:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					entitySetSize(pArg[0], (Float) pArg[1], (Float) pArg[2]);
					return true;
				}
				entitySetSize((Float) pArg[0], (Float) pArg[1]);
				return true;
			}
			return false;
		case entityLivingBaseDeathTime:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityLivingBaseDeathTime(pArg[0], (Integer) pArg[1]);
				return true;
			}
			setEntityLivingBaseDeathTime((Integer) pArg[0]);
		case entitySetFire:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				entitySetFire(pArg[0], (Integer) pArg[1]);
				return true;
			}
			entitySetFire((Integer) pArg[0]);
		case entityAttackEntityFrom:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				if (pArg.length > 2
						&& pArg[2] != null) {
					entityAttackEntityFrom(pArg[0], pArg[1], (Integer) pArg[2]);
					return true;
				}
				entityAttackEntityFrom(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		case entityLivingBaseSetHealth:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				entityLivingBaseSetHealth(pArg[0], (Float) pArg[1]);
				return true;
			}
			entityLivingBaseSetHealth((Float) pArg[0]);
			return true;
		case entityYOffset:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityYOffset(pArg[0], (Float) pArg[1]);
				return true;
			}
			setEntityYOffset((Float) pArg[0]);
			return true;
		case entityPlayerFoodStats:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityFoodStats(pArg[0], pArg[1]);
				return true;
			}
			setEntityFoodStats(pArg[0]);
			return true;
		case entityPlayerPlayerLevel:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityPlayerPlayerLevel(pArg[0], (Integer) pArg[1]);
				return true;
			}
			setEntityPlayerPlayerLevel((Integer) pArg[0]);
			return true;
		case entityPlayerTotalXP:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityPlayerTotalXP(pArg[0], (Integer) pArg[1]);
				return true;
			}
			setEntityPlayerTotalXP((Integer) pArg[0]);
			return true;
		case entityPlayerCurrentXP:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityPlayerCurrentXP(pArg[0], (Integer) pArg[1]);
				return true;
			}
			setEntityPlayerCurrentXP((Integer) pArg[0]);
			return true;
		case entityPlayerScore:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityPlayerScore(pArg[0], (Integer) pArg[1]);
				return true;
			}
			setEntityPlayerScore((Integer) pArg[0]);
			return true;
		case entityLivingBaseHealth:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setEntityLivingBaseHealth(pArg[0], (Float) pArg[1]);
				return true;
			}
			setEntityLivingBaseHealth((Float) pArg[0]);
			return true;
		case renderHelperEnableStandardItemLighting:
			renderHelperEnableStandardItemLighting();
			return true;
		case renderHelperDisableStandardItemLighting:
			renderHelperDisableStandardItemLighting();
			return true;
		case modelBaseSetLivingAnimations:
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
		case modelBaseSetRotationAngles:
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
		case modelBaseRender:
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
		case guiScreenFontRenderer:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenFontRenderer(pArg[0], pArg[1]);
				return true;
			}
			return false;
		case guiScreenButtonList:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenButtonList(pArg[0], (List) pArg[1]);
				return true;
			}
			return false;
		case guiScreenWidth:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenWidth(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		case guiScreenHeight:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiScreenHeight(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		case renderEngineSetupTexture:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				renderEngineSetupTexture(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		case renderItems:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				renderItems(pArg[0], pArg[1], pArg[2]);
				return true;
			}
			return false;
		case textureUtilBindTexture:
			if (pArg != null) {
				textureUtilBindTexture((Integer) pArg[0]);
				return true;
			}
			return false;
		case textureManagerBindTexture:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				textureManagerBindTexture(pArg[0], pArg[1]);
				return true;
			}
			if (pArg != null) {
				textureManagerBindTexture(pArg[0]);
				return true;
			}
			return false;
		case tessellatorStartDrawingQuads:
			tessellatorStartDrawingQuads(pArg[0]);
			return true;
		case tessellatorStartDrawing:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				tessellatorStartDrawing(pArg[0], (Byte) pArg[1]);
				return true;
			}
			return false;
		case tessellatorSetNormal:
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
		case tessellatorAddVertexWithUV:
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
		case tessellatorDraw:
			tessellatorDraw(pArg[0]);
			return true;
		case openGlHelperSetActiveTexture:
			openGlHelperSetActiveTexture((Integer) pArg[0]);
			return true;
		case guiSlotRegisterScrollButtons:
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
		case guiScreenDrawScreen:
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
		case guiSlotDrawScreen:
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
		case guiDrawCenteredString:
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
		case guiScreenActionPerformed:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				guiScreenActionPerformed(pArg[0], pArg[1]);
			}
			return false;
		case guiSlotActionPerformed:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				guiSlotActionPerformed(pArg[0], pArg[1]);
			}
			return false;
		case guiButtonID:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonID(pArg[0], (Integer) pArg[1]);
			}
			return false;
		case renderManagerRenderEntityWithPosYaw:
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
		case renderManagerItemRendererRenderItem:
			if (pArg != null
			&& pArg.length > 2
			&& pArg[0] != null
			&& pArg[1] != null
			&& pArg[2] != null) {
				if (pArg.length > 3
						&& pArg[3] != null) {
					renderManagerItemRendererRenderItem(pArg[0], pArg[1], pArg[2], (Integer) pArg[3]);
					return true;
				}
				renderManagerItemRendererRenderItem(pArg[0], pArg[1], (Integer) pArg[2]);
				return true;
			}
			return false;
		case guiButtonEnabled:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonEnabled(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		case guiButtonXPosition:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonXPosition(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		case guiButtonYPosition:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonYPosition(pArg[0], (Integer) pArg[1]);
				return true;
			}
			return false;
		case guiButtonVisible:
			if (pArg != null
			&& pArg.length > 1
			&& pArg[0] != null
			&& pArg[1] != null) {
				setGuiButtonVisible(pArg[0], (Boolean) pArg[1]);
				return true;
			}
			return false;
		case texturedQuadDraw:
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
		return false;
	}

	public static boolean getBoolean(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getBooleanB(null, pIndex, (Object[])pArg);
	}

	public static boolean getBoolean(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Boolean(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public boolean getBooleanB(int pIndex, Object... pArg) {
		return getBooleanB(null, pIndex, (Object[])pArg);
	}

	public boolean getBooleanB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Boolean(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static int getInt(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getIntB(null, pIndex, (Object[])pArg);
	}

	public static int getInt(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Int(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public int getIntB(int pIndex, Object... pArg) {
		return getIntB(null, pIndex, (Object[])pArg);
	}

	public int getIntB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Int(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static long getLong(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getLongB(null, pIndex, (Object[])pArg);
	}

	public static long getLong(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Long(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public long getLongB(int pIndex, Object... pArg) {
		return getLongB(null, pIndex, (Object[])pArg);
	}

	public long getLongB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Long(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static byte getByte(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getByteB(null, pIndex, (Object[])pArg);
	}

	public static byte getByte(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Byte(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public byte getByteB(int pIndex, Object... pArg) {
		return getByteB(null, pIndex, (Object[])pArg);
	}

	public byte getByteB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Byte(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static float getFloat(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getFloatB(null, pIndex, (Object[])pArg);
	}

	public static float getFloat(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Float(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public float getFloatB(int pIndex, Object... pArg) {
		return getFloatB(null, pIndex, (Object[])pArg);
	}

	public float getFloatB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Float(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static double getDouble(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getDoubleB(null, pIndex, (Object[])pArg);
	}

	public static double getDouble(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Float(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public double getDoubleB(int pIndex, Object... pArg) {
		return getFloatB(null, pIndex, (Object[])pArg);
	}

	public double getDoubleB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Double(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static String getString(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getStringB(null, pIndex, (Object[])pArg);
	}

	public static String getString(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.String(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public String getStringB(int pIndex, Object... pArg) {
		return getStringB(null, pIndex, (Object[])pArg);
	}

	public String getStringB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.String(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static List getList(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getListB(null, pIndex, (Object[])pArg);
	}

	public static List getList(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.List(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public List getListB(int pIndex, Object... pArg) {
		return getListB(null, pIndex, (Object[])pArg);
	}

	public List getListB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.List(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static ArrayList getArrayList(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getArrayListB(null, pIndex, (Object[])pArg);
	}

	public static ArrayList getArrayList(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.ArrayList(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public ArrayList getArrayListB(int pIndex, Object... pArg) {
		return getArrayListB(null, pIndex, (Object[])pArg);
	}

	public ArrayList getArrayListB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ArrayList(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static LinkedList getLinkedList(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getLinkedListB(null, pIndex, (Object[])pArg);
	}

	public static LinkedList getLinkedList(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.LinkedList(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public LinkedList getLinkedListB(int pIndex, Object... pArg) {
		return getLinkedListB(null, pIndex, (Object[])pArg);
	}

	public LinkedList getLinkedListB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.LinkedList(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static ConcurrentHashMap getConcurrentHashMap(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getConcurrentHashMapB(null, pIndex, (Object[])pArg);
	}

	public static ConcurrentHashMap getConcurrentHashMap(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.ConcurrentHashMap(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public ConcurrentHashMap getConcurrentHashMapB(int pIndex, Object... pArg) {
		return getConcurrentHashMapB(null, pIndex, (Object[])pArg);
	}

	public ConcurrentHashMap getConcurrentHashMapB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ConcurrentHashMap(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static HashMap getHashMap(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getHashMapB(null, pIndex, (Object[])pArg);
	}

	public static HashMap getHashMap(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.HashMap(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public HashMap getHashMapB(int pIndex, Object... pArg) {
		return getHashMapB(null, pIndex, (Object[])pArg);
	}

	public HashMap getHashMapB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.HashMap(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static Map getMap(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getMapB(null, pIndex, (Object[])pArg);
	}

	public static Map getMap(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Map(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public Map getMapB(int pIndex, Object... pArg) {
		return getMapB(null, pIndex, (Object[])pArg);
	}

	public Map getMapB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Map(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static Enum getEnum(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getEnumB(null, pIndex, (Object[])pArg);
	}

	public static Enum getEnum(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.Enum(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public Enum getEnumB(int pIndex, Object... pArg) {
		return getEnumB(null, pIndex, (Object[])pArg);
	}

	public Enum getEnumB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.Enum(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static File getFile(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getFileB(null, pIndex, (Object[])pArg);
	}

	public static File getFile(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.File(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public File getFileB(int pIndex, Object... pArg) {
		return getFileB(null, pIndex, (Object[])pArg);
	}

	public File getFileB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.File(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static IntBuffer getIntBuffer(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getIntBufferB(null, pIndex, (Object[])pArg);
	}

	public static IntBuffer getIntBuffer(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.IntBuffer(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public IntBuffer getIntBufferB(int pIndex, Object... pArg) {
		return getIntBufferB(null, pIndex, (Object[])pArg);
	}

	public IntBuffer getIntBufferB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.IntBuffer(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static int[] getIntArray(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getIntArrayB(null, pIndex, (Object[])pArg);
	}

	public static int[] getIntArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.IntArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public int[] getIntArrayB(int pIndex, Object... pArg) {
		return getIntArrayB(null, pIndex, (Object[])pArg);
	}

	public int[] getIntArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.IntArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static InputStream getInputStream(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getInputStreamB(null, pIndex, (Object[])pArg);
	}

	public static InputStream getInputStream(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.InputStream(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public InputStream getInputStreamB(int pIndex, Object... pArg) {
		return getInputStreamB(null, pIndex, (Object[])pArg);
	}

	public InputStream getInputStreamB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.InputStream(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static float[] getFloatArray(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getFloatArrayB(null, pIndex, (Object[])pArg);
	}

	public static float[] getFloatArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.FloatArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public float[] getFloatArrayB(int pIndex, Object... pArg) {
		return getFloatArrayB(null, pIndex, (Object[])pArg);
	}

	public float[] getFloatArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.FloatArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static double[] getDoubleArray(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getDoubleArrayB(null, pIndex, (Object[])pArg);
	}

	public static double[] getDoubleArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.DoubleArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public double[] getDoubleArrayB(int pIndex, Object... pArg) {
		return getDoubleArrayB(null, pIndex, (Object[])pArg);
	}

	public double[] getDoubleArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.DoubleArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static byte[] getByteArray(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getByteArrayB(null, pIndex, (Object[])pArg);
	}

	public static byte[] getByteArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.ByteArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public byte[] getByteArrayB(int pIndex, Object... pArg) {
		return getByteArrayB(null, pIndex, (Object[])pArg);
	}

	public byte[] getByteArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ByteArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static String[] getStringArray(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getStringArrayB(null, pIndex, (Object[])pArg);
	}

	public static String[] getStringArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.StringArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public String[] getStringArrayB(int pIndex, Object... pArg) {
		return getStringArrayB(null, pIndex, (Object[])pArg);
	}

	public String[] getStringArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.StringArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static Object[] getObjectArray(int pIndex, Object... pArg) {
		//instanceCheck();
		return instance.getObjectArrayB(null, pIndex, (Object[])pArg);
	}

	public static Object[] getObjectArray(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		//instanceCheck();
		return Modchu_CastHelper.ObjectArray(instance.getB(accessSupport, pIndex, (Object[])pArg));
	}

	public Object[] getObjectArrayB(int pIndex, Object... pArg) {
		return getObjectArrayB(null, pIndex, (Object[])pArg);
	}

	public Object[] getObjectArrayB(Modchu_ASBase accessSupport, int pIndex, Object... pArg) {
		return Modchu_CastHelper.ObjectArray(getB(accessSupport, pIndex, (Object[])pArg));
	}

	public static void instanceCheck() {
		if (instance != null) ;else instance = new Modchu_ASAlmighty();
	}

	protected Object render(Object model) {
		return Modchu_Reflect.getFieldObject(model.getClass(), "render", model, -1);
	}

	protected void renderItems(Object model, Object entity, Object render) {
		Modchu_Reflect.invokeMethod(model.getClass(), "renderItems", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), Modchu_Reflect.loadClass("Render") }, model, new Object[]{ entity, render });
	}

	protected void allModelInit(Object render, Object entity, boolean b) {
		Modchu_Reflect.invokeMethod(render.getClass(), "allModelInit", new Class[]{ Modchu_Reflect.loadClass("Entity"), boolean.class }, render, new Object[]{ entity, b });
	}

	protected void setRender(Object model, Object render) {
		//Modchu_Debug.mDebug("setRender model="+model.getClass());
		//Modchu_Debug.mDebug("setRender render="+render.getClass());
		Modchu_Reflect.setFieldObject(model.getClass(), "render", model, render, -1);
	}

	protected ConcurrentHashMap modelRendererGetTextureOffsetMap(Object modelRenderer) {
		return (ConcurrentHashMap) Modchu_Reflect.invokeMethod(modelRenderer.getClass(), "getTextureOffsetMap", modelRenderer);
	}

	protected void setArmorRendering(Object model, boolean b) {
		Modchu_Reflect.setFieldObject(model.getClass(), "setArmorRendering", model, b, -1);
	}

	protected Object modelBaseRender(Object model, Object entity, float f, float f2, float f3, float f4, float f5, float f6) {
		return Modchu_Reflect.invokeMethod("ModelBase", "func_78088_a", "render", new Class[]{ Modchu_Reflect.loadClass("Entity"), float.class, float.class, float.class, float.class, float.class, float.class }, model, new Object[]{ entity, f, f2, f3, f4, f5, f6 });
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
			throw new RuntimeException("Modchu_Main-getMinecraft o == null !! loadClass(Minecraft)="+Modchu_Reflect.loadClass("Minecraft")+" isForge="+Modchu_Main.isForge+" getMinecraftVersion()="+Modchu_Main.getMinecraftVersion());
		}
		getMinecraftMode = 3;
		return o;
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

	protected void setMinecraftThePlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Modchu_Reflect.setFieldObject("Minecraft", "field_71439_g", "thePlayer", minecraftGetMinecraft(), entityPlayer);
	}

	protected Object minecraftTheWorld() {
		if (Modchu_Main.isServer) return null;
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71441_e", "theWorld", minecraftGetMinecraft());
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

	protected Object minecraftFontRenderer() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71466_p", "fontRenderer", minecraftGetMinecraft());
	}

	protected Object minecraftSession() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71449_j", "session", minecraftGetMinecraft());
	}

	protected Object minecraftGatSession() {
		return Modchu_Reflect.invokeMethod("Minecraft", "func_110432_I", "getSession", minecraftGetMinecraft());
	}

	protected void minecraftFontRenderer(Object fontRenderer) {
		Modchu_Reflect.setFieldObject("Minecraft", "field_71466_p", "fontRenderer", minecraftGetMinecraft(), fontRenderer);
	}

	protected Object minecraftGameSettings() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71474_y", "gameSettings", minecraftGetMinecraft());
	}

	protected int minecraftGameSettingsThirdPersonView() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74320_O", "thirdPersonView", gameSettings));
	}

	protected void minecraftGameSettingsSetThirdPersonView(int i) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74320_O", "thirdPersonView", gameSettings, i);
	}

	protected boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("GameSettings", "field_85185_A", "touchscreen", gameSettings));
	}

	protected Object minecraftEntityRenderer() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71460_t", "entityRenderer", minecraftGetMinecraft());
	}

	protected Object minecraftTextureManager() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_72770_i", "renderEngine", minecraftGetMinecraft());
	}

	protected Object minecraftGetTextureManager() {
		return Modchu_Reflect.invokeMethod("Minecraft", "func_110434_K", "getTextureManager", minecraftGetMinecraft());
	}

	protected Object minecraftGetResourceManager() {
		return Modchu_Reflect.invokeMethod("Minecraft", "func_110442_L", "getResourceManager", minecraftGetMinecraft());
	}

	protected Object resourceManagerGetResource(Object o) {
		return resourceManagerGetResource(minecraftGetResourceManager(), o);
	}

	protected Object resourceManagerGetResource(Object resourceManager, Object o) {
		return Modchu_Reflect.invokeMethod(resourceManager.getClass(), "func_110536_a", "getResource", new Class[]{ o.getClass() }, resourceManager, new Object[]{ o });
	}

	protected long minecraftSystemTime() {
		return Modchu_CastHelper.Long(Modchu_Reflect.getFieldObject("Minecraft", "field_71423_H", "systemTime", minecraftGetMinecraft()));
	}

	protected long minecraftGetSystemTime() {
		return Modchu_CastHelper.Long(Modchu_Reflect.invokeMethod("Minecraft", "func_71386_F", "getSystemTime", minecraftGetMinecraft()));
	}

	protected int minecraftDisplayWidth() {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Minecraft", "field_71443_c", "displayWidth", minecraftGetMinecraft()));
	}

	protected int minecraftDisplayHeight() {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Minecraft", "field_71440_d", "displayHeight", minecraftGetMinecraft()));
	}

	protected void setMinecraftRenderViewEntity() {
		setMinecraftRenderViewEntity(minecraftThePlayer());
	}

	protected void setMinecraftRenderViewEntity(Object entity) {
		Modchu_Reflect.setFieldObject("Minecraft", "field_71451_h", "renderViewEntity", minecraftGetMinecraft(), new Object[]{ entity });
	}

	protected void printChatMessage(String s) {
		Object ingameGUI = Modchu_Reflect.getFieldObject("Minecraft", "field_71456_v", "ingameGUI", minecraftGetMinecraft());
		if (ingameGUI != null) ;else {
			Modchu_Debug.lDebug("printChatMessage ingameGUI == null !!");
			return;
		}
		Object chatGUI = Modchu_Reflect.invokeMethod(ingameGUI.getClass(), Modchu_Main.getMinecraftVersion() > 169 ? "func_146158_b" : "func_73827_b", "getChatGUI", ingameGUI);
		if (chatGUI != null) ;else {
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

	protected boolean isMac() {
		return Modchu_Main.getMinecraftVersion() > 159 ? (Boolean)Modchu_Reflect.getFieldObject("Minecraft", "field_142025_a", "isRunningOnMac", minecraftGetMinecraft()) :
			Modchu_Reflect.invokeMethod("Minecraft", "func_71376_c", "getOs", minecraftGetMinecraft()) == Modchu_Reflect.getEnum("net.minecraft.util.EnumOS", "MACOS");
	}

	protected boolean isCtrlKeyDown() {
		return isMac() ? Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220) : Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
	}

	protected boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
	}

	protected int keyBindingKeyCode(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_74512_d", "keyCode", keyBinding)) : -1;
	}

	protected String keyBindingKeyDescription(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_74515_c", "keyDescription", keyBinding)) : null;
	}

	protected String keyBindingKeyCategory(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_151471_f", "keyCategory", keyBinding)) : null;
	}

	protected boolean keyBindingPressed(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject(keyBinding.getClass(), "field_74513_e", "pressed", keyBinding)) : false;
	}

	protected boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? Modchu_Main.getMinecraftVersion() > 169 ? Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(keyBinding.getClass(), "func_151470_d", "getIsKeyPressed", keyBinding)) : keyBindingPressed(keyBinding) : null;
	}

	protected boolean keyBindingIsPressed(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(keyBinding.getClass(), "func_74509_c", "isPressed", keyBinding)) : false;
	}

	protected boolean keyBindingSetPressed(Object keyBinding, boolean b) {
		return keyBinding != null ? Modchu_Reflect.setFieldObject(keyBinding.getClass(), "field_74513_e", "pressed", keyBinding, b) : false;
	}

	protected int keyBindingPressTime(Object keyBinding) {
		return keyBinding != null ? Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(keyBinding.getClass(), Modchu_Main.getMinecraftVersion() > 169 ? "field_151474_i" : "field_74511_f", "pressTime", keyBinding)) : 0;
	}

	protected Object[] blockBlockList() {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject("Block", "field_71973_m", "blocksList"));
	}

	protected Object[] itemItemsList() {
		return Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject("Item", "field_77698_e", "itemsList"));
	}

	protected Object getBlock(Object itemStackOrItemOrBlock) {
		Object block = itemStackOrItemOrBlock;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItemOrBlock)) {
			return getBlockItemStack(itemStackOrItemOrBlock);
		} else if (Modchu_Reflect.loadClass("Item").isInstance(itemStackOrItemOrBlock)) {
			return blockGetBlockFromItem(itemStackOrItemOrBlock);
		} else if (Modchu_Reflect.loadClass("Block").isInstance(itemStackOrItemOrBlock)) {
			return block;
		}
		return null;
	}

	protected Object blockGetBlockFromItem(Object item) {
		if (item != null) ;else return null;
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.invokeMethod("Block", "func_149634_a", "getBlockFromItem", new Class[]{ Modchu_Reflect.loadClass("Item") }, null, new Object[]{ item }) : blockBlockList()[itemItemID(item)];
	}

	protected Object getBlockItemStack(Object itemstack) {
		if (itemstack != null) ;else return null;
		return Modchu_Main.getMinecraftVersion() > 169 ? blockGetBlockFromItem(itemStackGetItem(itemstack)) : blockBlockList()[itemStackItemID(itemstack)];
	}

	protected Object getItem(String s) {
		if (s != null) ;else return null;
		if (Modchu_Main.getMinecraftVersion() > 169) {
			Object itemRegistry = Modchu_Reflect.getFieldObject("Item", "field_150901_e", "itemRegistry");
			if (itemRegistry != null) ;else return null;
			Object item = Modchu_Reflect.invokeMethod(itemRegistry.getClass(), "func_82594_a", "getObject", new Class[]{ String.class }, itemRegistry, new Object[]{ s });
			//Modchu_Debug.mDebug("getItem s="+s+" item="+item);
			return item != null ? item : null;
		}
		return oldVersionItem(s);
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
					Modchu_Reflect.getFieldObject("Item", "field_71943_B", "waterStill"),
					Modchu_Reflect.getFieldObject("Item", "field_71942_A", "waterMoving")
			};
			for(int i = 0; i < s1.length
					&& i < s2.length; i++) {
				oldVersionItemMap.put(s1[i], s2[i]);
			}
			initOldVersionItemMap = true;
		}
		if (!oldVersionItemMap.containsKey(s)) {
			Modchu_Main.runtimeExceptionFlag = true;
			Modchu_Main.runtimeExceptionString = "oldVersionItemMap s="+s+" is null !!";
			return null;
		}
		return oldVersionItemMap.get(s);
	}

	protected int itemItemID(Object item) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Item", "field_73438_a", "itemID", item));
	}

	protected int itemStackItemID(Object itemstack) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ItemStack", "field_77993_c", "itemID", itemstack));
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

	protected int entityEntityID() {
		return entityEntityID(minecraftThePlayer());
	}

	protected int entityEntityID(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", Modchu_Main.getMinecraftVersion() > 169 ? "field_145783_c" : "field_73319_a", "entityId", entity));
	}

	protected void setEntityEntityID(int i) {
		setEntityEntityID(minecraftThePlayer(), i);
	}

	protected void setEntityEntityID(Object entity, int i) {
		Modchu_Reflect.setFieldObject("Entity", Modchu_Main.getMinecraftVersion() > 169 ? "field_145783_c" : "field_73319_a", "entityId", entity, i);
	}

	protected int guiButtonWidth(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146120_f" : "field_73747_a", "width", guiButton));
	}

	protected int guiButtonHeight(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146121_g" : "field_73745_b", "height", guiButton));
	}

	protected int guiButtonID(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146127_k" : "field_73741_f", "id", guiButton));
	}

	protected void setGuiButtonID(Object guiButton, int i) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146127_k" : "field_73741_f", "id", guiButton, i);
	}

	protected boolean guiButtonEnabled(Object guiButton) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146124_l" : "field_73742_g", "enabled", guiButton));
	}

	protected void setGuiButtonEnabled(Object guiButton, boolean b) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146124_l" : "field_73742_g", "enabled", guiButton, b);
	}

	protected int guiButtonXPosition(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146128_h" : "field_73746_c", "xPosition", guiButton));
	}

	protected void setGuiButtonXPosition(Object guiButton, int i) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146128_h" : "field_73746_c", "xPosition", guiButton, i);
	}

	protected int guiButtonYPosition(Object guiButton) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146129_i" : "field_73743_d", "yPosition", guiButton));
	}

	protected void setGuiButtonYPosition(Object guiButton, int i) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146129_i" : "field_73743_d", "yPosition", guiButton, i);
	}

	protected boolean guiButtonVisible(Object guiButton) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146125_m" : "field_73748_h", "visible", guiButton));
	}

	protected void setGuiButtonVisible(Object guiButton, boolean b) {
		Modchu_Reflect.setFieldObject("GuiButton", Modchu_Main.getMinecraftVersion() > 169 ? "field_146125_m" : "field_73748_h", "visible", guiButton, b);
	}

	protected InputStream resourceManagerInputStream(Object o) {
		InputStream inputStream = null;
		Object resource = resourceManagerGetResource(o);
		if (resource != null) inputStream = resourceGetInputStream(resource);
		return inputStream;
	}

	protected InputStream resourceGetInputStream(Object resource) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_CastHelper.InputStream(Modchu_Reflect.invokeMethod("net.minecraft.client.resources.IResource", "func_110527_b", "getInputStream", resource)) :
			Modchu_CastHelper.InputStream(Modchu_Reflect.invokeMethod("Resource", "func_110527_b", "getInputStream", resource));
	}

	protected List keybindArray() {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("KeyBinding", "field_74516_a", "keybindArray"));
	}

	protected Object newInstanceKeyBinding(String s, int i, String s2) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.newInstance("KeyBinding", new Class[]{ String.class, int.class, String.class }, new Object[]{ s, i, s2 }) : Modchu_Reflect.newInstance("KeyBinding", new Class[]{ String.class, int.class }, new Object[]{ s, i });
	}

	protected String getUserName() {
		return getUserName(minecraftThePlayer());
	}

	protected String getUserName(Object entityplayer) {
		return Modchu_Main.getMinecraftVersion() > 169 ? (String)Modchu_Reflect.invokeMethod("EntityPlayer", "func_70005_c_", "getCommandSenderName", entityplayer) : (String)Modchu_Reflect.getFieldObject("EntityPlayer", "field_71092_bJ", "username", entityplayer);
	}

	protected boolean isPlanter(Object itemStackOrItemOrBlock) {
		if (itemStackOrItemOrBlock != null) ;else return false;
		Object block = itemStackOrItemOrBlock;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItemOrBlock)) {
			block = getBlockItemStack(itemStackOrItemOrBlock);
		} else if (Modchu_Reflect.loadClass("Item").isInstance(itemStackOrItemOrBlock)) {
			block = blockGetBlockFromItem(itemStackOrItemOrBlock);
		}
		return isPlanterCheck(block);
	}

	protected boolean isPlanterCheck(Object block) {
		if (Modchu_Main.getMinecraftVersion() > 169) {
			//Modchu_Debug.mDebug("isPlanter block.getClass()="+block.getClass());
			Class BlockMushroom = Modchu_Reflect.loadClass("BlockMushroom");
			Class BlockDoublePlant = Modchu_Reflect.loadClass("net.minecraft.block.BlockDoublePlant");
			Class BlockSapling = Modchu_Reflect.loadClass("net.minecraft.block.BlockSapling");
			Class BlockTallGrass = Modchu_Reflect.loadClass("net.minecraft.block.BlockTallGrass");
			return block != null
					&& (Modchu_Reflect.loadClass("BlockFlower").isInstance(block)
					| ((BlockDoublePlant != null
					&& BlockDoublePlant.isInstance(block)
					| BlockDoublePlant == null))
					| ((BlockMushroom != null
						&& BlockMushroom.isInstance(block)
						| BlockMushroom == null))
					| ((BlockSapling != null
						&& BlockSapling.isInstance(block)
						| BlockSapling == null))
					| ((BlockTallGrass != null
						&& BlockTallGrass.isInstance(block)
						| BlockTallGrass == null)));
		} else {
			return block != null
					&& Modchu_Reflect.loadClass("BlockFlower").isInstance(block);
		}
	}

	protected boolean isCamouflage(Object itemStackOrItemOrBlock) {
		if (itemStackOrItemOrBlock != null) ;else return false;
		Object block = getBlock(itemStackOrItemOrBlock);
		return isCamouflageCheck(block);
	}

	protected boolean isCamouflageCheck(Object block) {
		return block != null
				&& (Modchu_Reflect.loadClass("BlockLeaves").isInstance(block)
				| Modchu_Reflect.loadClass("BlockPumpkin").isInstance(block));
	}

	protected int getVacancyGlobalEntityID() {
		if (Modchu_Main.getMinecraftVersion() < 150) {
			return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("ModLoader", "getUniqueEntityId"));
		}
		Map map = (Map) Modchu_Reflect.getFieldObject("EntityList", "field_75623_d", -1);
		if (map != null) ;else map = (Map) Modchu_Reflect.getFieldObject("EntityList", "IDtoClassMapping");
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

	protected boolean isLANWorld() {
		if (!isMuiti()) {
			Object theIntegratedServer = Modchu_Reflect.getFieldObject("Minecraft", "field_71437_Z", "theIntegratedServer", minecraftGetMinecraft());
			if (theIntegratedServer != null
					&& Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(theIntegratedServer.getClass(), "func_71344_c", "getPublic", theIntegratedServer))) {
				return true;
			}
		}
		return false;
	}

	protected boolean isIntegratedServerRunning() {
		Object mc = minecraftGetMinecraft();
		if (mc != null) ;else return false;
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Minecraft", "func_71387_A", "isIntegratedServerRunning", mc));
	}

	protected boolean isMuiti() {
		Object mc = minecraftGetMinecraft();
		if (mc != null) ;else return false;
		return Modchu_Reflect.invokeMethod("Minecraft", Modchu_Main.getMinecraftVersion() > 169 ? "func_147114_u" : "func_71391_r", "getNetHandler", mc) != null
				&& !Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Minecraft", "func_71356_B", "isSingleplayer", mc));
	}

	protected Object renderRenderBlocks(Object pRender) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.getFieldObject("Render", "field_147909_c", pRender) :
			Modchu_Reflect.getFieldObject("Render", "field_76988_d", "renderBlocks", pRender);
	}

	protected void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		Modchu_Reflect.invokeMethod(renderBlocks.getClass(), "func_78600_a", "renderBlockAsItem", new Class[]{ Modchu_Reflect.loadClass("Block"), int.class, float.class }, renderBlocks, new Object[]{ block, i, f });
	}

	protected void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		Modchu_Reflect.invokeMethod(renderBlocks.getClass(), "func_147769_a", "renderBlockAllFaces", new Class[]{ Modchu_Reflect.loadClass("Block"), int.class, int.class, int.class }, renderBlocks, new Object[]{ block, i, i2, i3 });
	}

	protected void setMinecraftDisplayGuiScreen(Object guiScreen) {
		Modchu_Reflect.invokeMethod("Minecraft", Modchu_Main.getMinecraftVersion() > 169 ? "func_147108_a" : "func_71373_a", "displayGuiScreen", new Class[]{ Modchu_Reflect.loadClass("GuiScreen") }, minecraftGetMinecraft(), new Object[]{ guiScreen });
	}

	protected void guiIngameDrawString(String s, int i, int j, int k) {
		Object mc = minecraftGetMinecraft();
		if (mc != null) ;else return;
		Object ingameGUI = Modchu_Reflect.getFieldObject("Minecraft", "field_71456_v", "ingameGUI", minecraftGetMinecraft());
		if (ingameGUI != null) Modchu_Reflect.invokeMethod("Gui", "func_73731_b", "drawString", new Class[]{ Modchu_Reflect.loadClass("FontRenderer"), String.class, int.class, int.class, int.class }, ingameGUI, new Object[]{ minecraftFontRenderer(), s, i, j, k });
	}

	protected void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		Modchu_Reflect.invokeMethod("FontRenderer", "func_78276_b", "drawString", new Class[]{ String.class, int.class, int.class, int.class }, fontRenderer, new Object[]{ s, i, j, k });
	}

	protected Object itemStackGetItem(Object itemstack) {
		return Modchu_Reflect.invokeMethod("ItemStack", "func_77973_b", "getItem", itemstack);
	}

	protected float itemStackGetItemDamage(Object itemstack) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("ItemStack", "func_77960_j", "getItemDamage", itemstack));
	}

	protected Object renderManagerInstance() {
		return Modchu_Reflect.getFieldObject("RenderManager", "field_78727_a", "instance");
	}

	protected Object renderManagerGetEntityRenderObject(Object entity) {
		return Modchu_Reflect.invokeMethod("RenderManager", "func_78713_a", "getEntityRenderObject", new Class[]{ Modchu_Reflect.loadClass("Entity") }, renderManagerInstance(), new Object[]{ entity });
	}

	protected Object renderManagerGetEntityClassRenderObject(Class c) {
		return Modchu_Reflect.invokeMethod("RenderManager", "func_78715_a", "getEntityClassRenderObject", new Class[]{ Class.class }, renderManagerInstance(), new Object[]{ c });
	}

	protected boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("RenderManager", Modchu_Main.getMinecraftVersion() > 169 ? "func_147940_a" : "func_78719_a", "renderEntityWithPosYaw", new Class[]{ Modchu_Reflect.loadClass("Entity"), double.class, double.class, double.class, float.class, float.class }, renderManagerInstance(), new Object[]{ entity, d, d2, d3, f, f2 }));
	}

	protected Map renderManagerEntityRenderMap() {
		return (Map) Modchu_Reflect.getFieldObject("RenderManager", "field_78729_o", "entityRenderMap", renderManagerInstance());
	}

	protected Object renderRenderManager(Object render) {
		return Modchu_Reflect.getFieldObject("Render", "field_76990_c", "renderManager", render);
	}

	protected void renderSetRenderManager(Object render) {
		Modchu_Reflect.invokeMethod("Render", "func_76976_a", "setRenderManager", new Class[]{ Modchu_Reflect.loadClass("RenderManager") }, render, new Object[]{ renderManagerInstance() });
	}

	protected Object renderRenderManagerRenderEngine(Object render) {
		return Modchu_Reflect.getFieldObject("RenderManager", "field_78724_e", "renderEngine", renderRenderManager(render));
	}

	protected void renderFirstPersonArm(Object render, Object entityplayer) {
		Modchu_Reflect.invokeMethod("RenderPlayer", "func_82441_a", "renderFirstPersonArm", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, render, new Object[]{ entityplayer });
	}

	protected Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return Modchu_Reflect.invokeMethod("Render", "func_76984_a", "loadDownloadableImageTexture", new Class[]{ String.class, String.class }, render, new Object[]{ s, s1 });
	}

	protected void renderBindTexture(Object render, Object resourceLocation) {
		if (Modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.invokeMethod("Render", "func_110776_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, render, new Object[]{ resourceLocation });
		else Modchu_Reflect.invokeMethod("Render", "func_76985_a", "loadTexture", new Class[]{ String.class }, render, new Object[]{ resourceLocation });
	}

	protected Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return Modchu_Reflect.invokeMethod(inventory.getClass(), "func_70440_f", "armorItemInSlot", new Class[]{ int.class }, inventory, new Object[]{ i });
	}

	protected Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return Modchu_Reflect.invokeMethod(inventory.getClass(), "func_70301_a", "getStackInSlot", new Class[]{ int.class }, inventory, new Object[]{ i });
	}

	protected int itemStackStackSize(Object itemstack) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ItemStack", "field_77994_a", "stackSize", itemstack));
	}

	protected boolean itemStackIsItemEnchanted(Object itemstack) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("ItemStack", "func_77948_v", "isItemEnchanted", itemstack));
	}

	protected float mathHelperSin(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76126_a", "sin", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected float mathHelperCos(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76134_b", "cos", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected float mathHelperSqrt_float(float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("MathHelper", "func_76129_c", "sqrt_float", new Class[]{ float.class }, null, new Object[]{ f }));
	}

	protected double mathHelperFloor_double(double d) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("MathHelper", "func_76128_c", "floor_double", new Class[]{ double.class }, null, new Object[]{ d }));
	}

	protected int textureOffsetTextureOffsetX(Object textureOffset) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(textureOffset.getClass(), "field_78783_a", "textureOffsetX", textureOffset));
	}

	protected int textureOffsetTextureOffsetY(Object textureOffset) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(textureOffset.getClass(), "field_78782_b", "textureOffsetY", textureOffset));
	}

	protected Object minecraftCurrentScreen() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71462_r", "currentScreen", minecraftGetMinecraft());
	}

	protected int openGlHelperLightmapTexUnit() {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("OpenGlHelper", "field_77476_b", "lightmapTexUnit"));
	}

	protected void openGlHelperSetActiveTexture(int i) {
		Modchu_Reflect.invokeMethod("OpenGlHelper", "func_77473_a", "setActiveTexture", new Class[]{ int.class }, null, new Object[]{ i });
	}

	protected int openGlHelperDefaultTexUnit() {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("OpenGlHelper", "field_77478_a", "defaultTexUnit"));
	}

	protected List guiScreenButtonList(Object guiScreen) {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146292_n" : "field_73887_h", "buttonList", guiScreen));
	}

	protected void setGuiScreenButtonList(Object guiScreen, List list) {
		Modchu_Reflect.setFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146292_n" : "field_73887_h", "buttonList", guiScreen, list);
	}

	protected int guiScreenWidth(Object guiScreen) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146294_l" : "field_73880_f", "width", guiScreen));
	}

	protected void setGuiScreenWidth(Object guiScreen, int i) {
		Modchu_Reflect.setFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146294_l" : "field_73880_f", "width", guiScreen, i);
	}

	protected int guiScreenHeight(Object guiScreen) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146295_m" : "field_73881_g", "height", guiScreen));
	}

	protected void setGuiScreenHeight(Object guiScreen, int i) {
		Modchu_Reflect.setFieldObject("GuiScreen", Modchu_Main.getMinecraftVersion() > 169 ? "field_146295_m" : "field_73881_g", "height", guiScreen, i);
	}

	protected Object guiScreenFontRenderer(Object guiScreen) {
		return Modchu_Main.getMinecraftVersion() > 169 ? Modchu_Reflect.getFieldObject("GuiScreen", "field_146289_q", "fontRendererObj", guiScreen) :
			Modchu_Reflect.getFieldObject("GuiScreen", "field_73815_a", "fontRenderer", guiScreen);
	}

	protected void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		if (Modchu_Main.getMinecraftVersion() > 169) Modchu_Reflect.setFieldObject("GuiScreen", "fontRendererObj", guiScreen, fontRenderer);
		else Modchu_Reflect.setFieldObject("GuiScreen", "field_73815_a", "fontRenderer", guiScreen, fontRenderer);
	}

	protected boolean entityPlayerIsPlayerSleeping() {
		return entityPlayerIsPlayerSleeping(minecraftThePlayer());
	}

	protected boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(entityplayer.getClass(), "func_70608_bn", "isPlayerSleeping", entityplayer));
	}

	protected float entityWidth() {
		return entityWidth(minecraftThePlayer());
	}

	protected float entityWidth(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70130_N", "width", entity));
	}

	protected float entityHeight() {
		return entityHeight(minecraftThePlayer());
	}

	protected float entityHeight(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70131_O", "height", entity));
	}

	protected IntBuffer glAllocationCreateDirectIntBuffer(int i) {
		return (IntBuffer) Modchu_Reflect.invokeMethod("GLAllocation", "func_74527_f", "createDirectIntBuffer", new Class[]{ int.class }, null, new Object[]{ i });
	}

	protected int glAllocationGenerateDisplayLists(int i) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("GLAllocation", "func_74526_a", "generateDisplayLists", new Class[]{ int.class }, null, new Object[]{ i }));
	}

	protected void renderEngineBindTexture(String s) {
		if (s != null) ;else return;
		Object renderEngine = Modchu_Reflect.getFieldObject("Minecraft", "field_71446_o", "renderEngine", minecraftGetMinecraft());
		Modchu_Reflect.invokeMethod(renderEngine.getClass(), "func_78342_b", "bindTexture", new Class[]{ String.class }, renderEngine, new Object[]{ s });
	}

	protected void blockSetLightOpacity(Object block, int lightOpacity) {
		Modchu_Reflect.invokeMethod("Block", "func_71868_h", "setLightOpacity", new Class[]{ int.class }, block, new Object[]{ lightOpacity });
	}

	protected Object minecraftEntityRendererItemRenderer() {
		Object entityRenderer = minecraftEntityRenderer();
		return Modchu_Reflect.getFieldObject(entityRenderer.getClass(), "field_78516_c", "itemRenderer", entityRenderer);
	}

	protected Object renderManagerItemRenderer() {
		Object renderManager = renderManagerInstance();
		return Modchu_Reflect.getFieldObject(renderManager.getClass(), "field_78721_f", "itemRenderer", renderManager);
	}

	protected void renderManagerItemRendererRenderItem(Object entity, Object itemstack, int i) {
		renderManagerItemRendererRenderItem(renderManagerItemRenderer(), entity, itemstack, i);
	}

	protected void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, int i) {
		Modchu_Reflect.invokeMethod("ItemRenderer", "func_78443_a", "renderItem", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), Modchu_Reflect.loadClass("ItemStack"), int.class }, itemRenderer, new Object[]{ entity, itemstack, i });
	}

	protected Object newInstanceItemRenderer() {
		Object o = Modchu_Reflect.newInstance(Modchu_Main.itemRendererClass, new Class[]{ Modchu_Reflect.loadClass("Minecraft") }, new Object[]{ minecraftGetMinecraft() });
		Modchu_Reflect.setFieldObject(o.getClass(), "master", o, new PFLM_ItemRendererMaster(o));
		return o;
	}

	protected void setEntityRendererItemRenderer(Object itemRenderer) {
		Modchu_Reflect.setFieldObject("EntityRenderer", Modchu_Main.getMinecraftVersion() > 169 ? "field_78516_c" : "field_73841_b", "itemRenderer", minecraftEntityRenderer(), itemRenderer);
	}

	protected void setRenderManagerItemRenderer(Object itemRenderer) {
		Modchu_Reflect.setFieldObject("RenderManager", "field_78721_f", "itemRenderer", renderManagerInstance(), itemRenderer);
	}

	protected Object renderMainModel(Object render) {
		return Modchu_Reflect.getFieldObject("RendererLivingEntity", "field_77045_g",  "mainModel", render);
	}

	protected void setRenderMainModel(Object render, Object model) {
		Modchu_Reflect.setFieldObject("RendererLivingEntity", "field_77045_g",  "mainModel", render, model);
	}

	protected Object minecraftPlayerController() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71442_b", "playerController", minecraftGetMinecraft());
	}

	protected void setMinecraftPlayerController(Object playerController) {
		Modchu_Reflect.setFieldObject("Minecraft", "field_71442_b", "playerController", minecraftGetMinecraft(), playerController);
	}

	protected Object worldGetWorldInfo() {
		return Modchu_Reflect.invokeMethod(minecraftTheWorld().getClass(), "func_72912_H", "getWorldInfo", minecraftTheWorld());
	}

	protected Enum worldGetWorldInfoGetGameType() {
		Object worldInfo = worldGetWorldInfo();
		return Modchu_CastHelper.Enum(Modchu_Reflect.invokeMethod(worldInfo.getClass(), "func_73081_b", "getGameType", worldInfo));
	}

	protected Enum enumactionBlock() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "block"));
	}

	protected Enum enumactionBow() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "bow"));
	}

	protected Enum enumactionDrink() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "drink"));
	}

	protected Enum enumactionEat() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "eat"));
	}

	protected Enum enumactionNone() {
		return Modchu_CastHelper.Enum(Modchu_Reflect.getEnum("EnumAction", "none"));
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

	protected float entityPrevDistanceWalkedModified() {
		return entityPrevDistanceWalkedModified(minecraftThePlayer());
	}

	protected float entityPrevDistanceWalkedModified(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70141_P", "prevDistanceWalkedModified", entity));
	}

	protected float entityDistanceWalkedModified() {
		return entityDistanceWalkedModified(minecraftThePlayer());
	}

	protected float entityDistanceWalkedModified(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70140_Q", "distanceWalkedModified", entity));
	}

	protected int entityTicksExisted() {
		return entityTicksExisted(minecraftThePlayer());
	}

	protected int entityTicksExisted(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", "field_70173_aa", "ticksExisted", entity));
	}

	protected float entityPlayerPrevCameraYaw() {
		return entityPlayerPrevCameraYaw(minecraftThePlayer());
	}

	protected float entityPlayerPrevCameraYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityPlayer", "field_71107_bF", "prevCameraYaw", entity));
	}

	protected float entityPlayerCameraYaw() {
		return entityPlayerCameraYaw(minecraftThePlayer());
	}

	protected float entityPlayerCameraYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityPlayer", "field_71109_bG", "cameraYaw", entity));
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

	protected void playerControllerSetGameType(Object enumGameType) {
		Modchu_Reflect.invokeMethod("PlayerControllerMP", "func_78746_a", "setGameType", new Class[]{ Modchu_Reflect.loadClass("EnumGameType") }, minecraftPlayerController(), new Object[]{ enumGameType });
	}

	protected void minecraftSetDimensionAndSpawnPlayer() {
		Object thePlayer = minecraftThePlayer();
		minecraftSetDimensionAndSpawnPlayer(Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", "field_71093_bK", "dimension", thePlayer)));
	}

	protected void minecraftSetDimensionAndSpawnPlayer(int i) {
		Modchu_Reflect.invokeMethod("Minecraft", "func_71354_a", "setDimensionAndSpawnPlayer", new Class[]{ int.class }, minecraftGetMinecraft(), new Object[]{ i });
	}

	protected void playerControllerCreativeSetPlayerCapabilities() {
		Object playerController = minecraftPlayerController();
		playerControllerCreativeSetPlayerCapabilities(playerController, minecraftThePlayer());
	}

	protected void playerControllerCreativeSetPlayerCapabilities(Object playerController) {
		playerControllerCreativeSetPlayerCapabilities(playerController, minecraftThePlayer());
	}

	protected void playerControllerCreativeSetPlayerCapabilities(Object playerController, Object entityplayer) {
		if (Modchu_Reflect.loadClass("PlayerControllerCreative").isInstance(playerController)) ;else return;
		Modchu_Reflect.invokeMethod("PlayerControllerCreative", "func_78748_a", "setPlayerCapabilities", new Class[]{Modchu_Reflect.loadClass("EntityPlayer")}, playerController, new Object[]{ entityplayer });
	}

	protected void worldSetEntityDead() {
		worldSetEntityDead(minecraftThePlayer());
	}

	protected void worldSetEntityDead(Object entity) {
		Modchu_Reflect.invokeMethod("World", "func_607_d", "setEntityDead", new Class[]{ Modchu_Reflect.loadClass("Entity") }, minecraftTheWorld(), new Object[]{ entity });
	}

	protected boolean worldCanBlockSeeTheSky(double d, double d2, double d3) {
		return worldCanBlockSeeTheSky(minecraftThePlayer(), d, d2, d3);
	}

	protected boolean worldCanBlockSeeTheSky(Object entity, double d, double d2, double d3) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72937_j", "canBlockSeeTheSky", new Class[]{ int.class, int.class, int.class }, entityWorldObj(entity), new Object[]{ (int) d, (int) d2, (int) d3 }));
	}

	protected boolean worldCanBlockSeeTheSky(int i, int i2, int i3) {
		return worldCanBlockSeeTheSky(minecraftThePlayer(), i, i2, i3);
	}

	protected boolean worldCanBlockSeeTheSky(Object entity, int i, int i2, int i3) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72937_j", "canBlockSeeTheSky", new Class[]{ int.class, int.class, int.class }, entityWorldObj(entity), new Object[]{ (int) i, (int) i2, (int) i3 }));
	}

	protected boolean worldIsRemote() {
		return worldIsRemote(minecraftThePlayer());
	}

	protected boolean worldIsRemote(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("World", "field_72995_K", "isRemote", entityWorldObj(entity)));
	}

	protected void entitySetDead() {
		entitySetDead(minecraftThePlayer());
	}

	protected void entitySetDead(Object entity) {
		Modchu_Reflect.invokeMethod("Entity", "func_70106_y", "setDead", entity);
	}

	protected Object playerControllerMPCreatePlayer() {
		return playerControllerMPCreatePlayer(minecraftPlayerController());
	}

	protected Object playerControllerMPCreatePlayer(Object playerController) {
		return Modchu_Reflect.invokeMethod("PlayerControllerMP", "func_4087_b", "createPlayer", new Class[]{ Modchu_Reflect.loadClass("World") }, playerController, new Object[]{ minecraftTheWorld() });
	}

	protected void playerControllerMPFlipPlayer() {
		playerControllerMPFlipPlayer(minecraftPlayerController(), minecraftThePlayer());
	}

	protected void playerControllerMPFlipPlayer(Object playerController) {
		playerControllerMPFlipPlayer(playerController, minecraftThePlayer());
	}

	protected void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		Modchu_Reflect.invokeMethod("PlayerControllerMP", "func_78745_b", "flipPlayer", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, playerController, new Object[]{ entityplayer });
	}

	protected void worldSpawnPlayerWithLoadedChunks() {
		worldSpawnPlayerWithLoadedChunks(minecraftThePlayer());
	}

	protected void worldSpawnPlayerWithLoadedChunks(Object entityplayer) {
		Modchu_Reflect.invokeMethod("World", "func_608_a", "spawnPlayerWithLoadedChunks", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, minecraftTheWorld(), new Object[]{ entityplayer });
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

	protected void entityPlayerSPFunc_6420_o() {
		entityPlayerSPFunc_6420_o(minecraftThePlayer());
	}

	protected void entityPlayerSPFunc_6420_o(Object entityplayer) {
		Modchu_Reflect.invokeMethod("EntityPlayerSP", "func_6420_o", entityplayer);
	}

	protected boolean entityPlayerGetHideCape() {
		return entityPlayerGetHideCape(minecraftThePlayer());
	}

	protected boolean entityPlayerGetHideCape(Object entityplayer) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("EntityPlayer", "func_82241_s", "getHideCape", entityplayer));
	}

	protected double entityPlayerField_71091_bM() {
		return entityPlayerField_71091_bM(minecraftThePlayer());
	}

	protected double entityPlayerField_71091_bM(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71091_bM", entityplayer));
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

	protected double entityPlayerField_71085_bR() {
		return entityPlayerField_71085_bR(minecraftThePlayer());
	}

	protected double entityPlayerField_71085_bR(Object entityplayer) {
		return Modchu_CastHelper.Double(Modchu_Reflect.invokeMethod("EntityPlayer", "field_71085_bR", entityplayer));
	}

	protected void playerControllerFunc_6473_b() {
		playerControllerFunc_6473_b(minecraftPlayerController(), minecraftThePlayer());
	}

	protected void playerControllerFunc_6473_b(Object playerController) {
		playerControllerFunc_6473_b(playerController, minecraftThePlayer());
	}

	protected void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
		Modchu_Reflect.invokeMethod("PlayerController", "func_6473_b", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer") }, playerController, new Object[]{ entityplayer });
	}

	protected Object entityPlayerInventory() {
		return entityPlayerInventory(minecraftThePlayer());
	}

	protected Object entityPlayerInventory(Object entityplayer) {
		return Modchu_Reflect.getFieldObject("EntityPlayer", "field_71071_by", "inventory", entityplayer);
	}

	protected Object entityPlayerInventoryGetCurrentItem() {
		return entityPlayerInventory(minecraftThePlayer());
	}

	protected Object entityPlayerInventoryGetCurrentItem(Object entityplayer) {
		Object inventory = entityPlayerInventory(entityplayer);
		return Modchu_Reflect.invokeMethod(inventory.getClass(), "func_70448_g", "getCurrentItem", inventory);
	}

	protected void setEntityPlayerInventory(Object inventory) {
		setEntityPlayerInventory(minecraftThePlayer(), inventory);
	}

	protected void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_71071_by", "inventory", entityplayer, inventory);
	}

	protected Object[] entityPlayerMainInventory() {
		return entityPlayerMainInventory(minecraftThePlayer());
	}

	protected Object[] entityPlayerMainInventory(Object entityplayerORInventory) {
		if (Modchu_Reflect.loadClass("InventoryPlayer").isInstance(entityplayerORInventory)) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return (Object[]) Modchu_Reflect.getFieldObject("InventoryPlayer", "field_70462_a", "mainInventory", entityplayerORInventory);
	}

	protected Object entityPlayerInventoryPlayerArmorItemInSlot(int i) {
		return entityPlayerInventoryPlayerArmorItemInSlot(minecraftThePlayer(), i);
	}

	protected Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		if (Modchu_Reflect.loadClass("InventoryPlayer").isInstance(entityplayerORInventory)) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return Modchu_Reflect.invokeMethod("InventoryPlayer", "func_70440_f", "armorItemInSlot", new Class[]{ int.class }, entityplayerORInventory, new Object[]{ i });
	}

	protected void setEntityPlayerMainInventory(Object mainInventory) {
		setEntityPlayerMainInventory(minecraftThePlayer(), mainInventory);
	}

	protected void setEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		Modchu_Reflect.setFieldObject("InventoryPlayer", "field_70462_a", "mainInventory", entityPlayerInventory(entityplayer), mainInventory);
	}

	protected Object[] entityPlayerArmorInventory() {
		return entityPlayerArmorInventory(entityPlayerInventory());
	}

	protected Object[] entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (Modchu_Reflect.loadClass("InventoryPlayer").isInstance(entityplayerORInventory)) ;else {
			entityplayerORInventory = entityPlayerArmorInventory(entityplayerORInventory);
		}
		return (Object[]) Modchu_Reflect.getFieldObject("InventoryPlayer", "field_70460_b", "armorInventory", entityplayerORInventory);
	}

	protected void setEntityPlayerArmorInventory(Object armorInventory) {
		setEntityPlayerArmorInventory(minecraftThePlayer(), armorInventory);
	}

	protected void setEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		Modchu_Reflect.setFieldObject("InventoryPlayer", "field_70460_b", "armorInventory", entityPlayerInventory(entityplayer), armorInventory);
	}

	protected Object entityPlayerInventoryGetStackInSlot(int i) {
		return entityPlayerInventoryGetStackInSlot(minecraftThePlayer(), i);
	}

	protected Object entityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return Modchu_Reflect.invokeMethod("InventoryPlayer", "func_70301_a", "getStackInSlot", new Class[]{ int.class }, entityPlayerInventory(entityplayer), new Object[]{ i });
	}

	protected int entityDimension() {
		return entityDimension(minecraftThePlayer());
	}

	protected int entityDimension(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("Entity", "field_71093_bK", "dimension", entity));
	}

	protected Object gameSettingsKeyBindForward() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74351_w", "keyBindForward", gameSettings);
	}

	protected Object gameSettingsKeyBindBack() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74368_y", "keyBindBack", gameSettings);
	}

	protected Object gameSettingsKeyBindLeft() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74370_x", "keyBindLeft", gameSettings);
	}

	protected Object gameSettingsKeyBindRight() {
		Object gameSettings = minecraftGameSettings();
		return Modchu_Reflect.getFieldObject(gameSettings.getClass(), "field_74366_z", "keyBindRight", gameSettings);
	}

	protected void setGameSettingsKeyBindForward(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74351_w", "keyBindForward", gameSettings, keyBinding);
	}

	protected void setGameSettingsKeyBindBack(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74368_y", "keyBindBack", gameSettings, keyBinding);
	}

	protected void setGameSettingsKeyBindRight(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74370_x", "keyBindLeft", gameSettings, keyBinding);
	}

	protected void setGameSettingsKeyBindLeft(Object keyBinding) {
		Object gameSettings = minecraftGameSettings();
		Modchu_Reflect.setFieldObject(gameSettings.getClass(), "field_74366_z", "keyBindRight", gameSettings, keyBinding);
	}

	protected boolean entityIsRiding() {
		return entityIsRiding(minecraftThePlayer());
	}

	protected boolean entityIsRiding(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70115_ae", "isRiding", entity));
	}

	protected boolean minecraftInGameHasFocus() {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("Minecraft", "field_71415_G", "inGameHasFocus", minecraftGetMinecraft()));
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

	protected float entityGetEyeHeight() {
		return entityGetEyeHeight(minecraftThePlayer());
	}

	protected float entityGetEyeHeight(Object entityplayer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityPlayer", "func_70047_e", "getEyeHeight", entityplayer));
	}

	protected Object entityBoundingBox() {
		return entityBoundingBox(minecraftThePlayer());
	}

	protected Object entityBoundingBox(Object entity) {
		return Modchu_Reflect.getFieldObject("Entity", "field_70121_D", "boundingBox", entity);
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

	protected boolean entityIsSneaking() {
		return entityIsSneaking(minecraftThePlayer());
	}

	protected boolean entityIsSneaking(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70093_af", "isSneaking", entity));
	}

	protected Object entityWorldObj() {
		return entityWorldObj(minecraftThePlayer());
	}

	protected Object entityWorldObj(Object entity) {
		return Modchu_Reflect.getFieldObject("Entity", "field_70170_p", "worldObj", entity);
	}

	protected boolean worldIsAirBlock(int i, int j, int k) {
		return worldIsAirBlock(minecraftThePlayer(), i, j, k);
	}

	protected boolean worldIsAirBlock(Object entity, int i, int j, int k) {
		Object worldObj = entityWorldObj(entity);
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", Modchu_Main.getMinecraftVersion() > 169 ? "func_147437_c" : "func_72799_c", "isAirBlock", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ i, j, k }));
	}

	protected boolean worldIsDaytime() {
		return worldIsDaytime(minecraftThePlayer());
	}

	protected boolean worldIsDaytime(Object entity) {
		Object worldObj = entityWorldObj(entity);
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72935_r", "isDaytime", worldObj));
	}

	protected Object entityRidingEntity() {
		return entityRidingEntity(minecraftThePlayer());
	}

	protected Object entityRidingEntity(Object entity) {
		return Modchu_Reflect.getFieldObject("Entity", "field_70154_o", "ridingEntity", entity);
	}

	protected int entityLivingBaseDeathTime() {
		return entityLivingBaseDeathTime(minecraftThePlayer());
	}

	protected int entityLivingBaseDeathTime(Object entityLivingBase) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70725_aQ", "deathTime", entityLivingBase));
	}

	protected void setEntityLivingBaseDeathTime(int i) {
		setEntityLivingBaseDeathTime(minecraftThePlayer(), i);
	}

	protected void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_70725_aQ", "deathTime", entityLivingBase, i);
	}

	protected float entityYOffset() {
		return entityYOffset(minecraftThePlayer());
	}

	protected float entityYOffset(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70129_M", "yOffset", entity));
	}

	protected void setEntityYOffset(float f) {
		setEntityYOffset(minecraftThePlayer(), f);
	}

	protected void setEntityYOffset(Object entity, float f) {
		Modchu_Reflect.setFieldObject("Entity", "field_70129_M", "yOffset", entity, f);
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

	protected void entitySetFire(int i) {
		entitySetFire(minecraftThePlayer(), i);
	}

	protected void entitySetFire(Object entity, int i) {
		Modchu_Reflect.invokeMethod("Entity", "func_70015_d", "setFire", entity, i);
	}

	protected boolean entityIsWet() {
		return entityIsWet(minecraftThePlayer());
	}

	protected boolean entityIsWet(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70026_G", "isWet", entity));
	}

	protected boolean entityIsInWater() {
		return entityIsInWater(minecraftThePlayer());
	}

	protected boolean entityIsInWater(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_70090_H", "isInWater", entity));
	}

	protected Object damageSourceStarve() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76366_f", "starve");
	}

	protected Object damageSourceCactus() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76367_g", "cactus");
	}

	protected Object damageSourceInWall() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76368_d", "inWall");
	}

	protected Object damageSourceDrown() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76369_e", "drown");
	}

	protected Object damageSourceOnFire() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76370_b", "onFire");
	}

	protected Object damageSourceLava() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76371_c", "lava");
	}

	protected Object damageSourceInFire() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76372_a", "inFire");
	}

	protected Object damageSourceMagic() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76376_m", "magic");
	}

	protected Object damageSourceGeneric() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76377_j", "generic");
	}

	protected Object damageSourceFall() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76379_h", "fall");
	}

	protected Object damageSourceOutOfWorld() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_76380_i", "outOfWorld");
	}

	protected Object damageSourceWither() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_82727_n", "wither");
	}

	protected Object damageSourceAnvil() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_82728_o", "anvil");
	}

	protected Object damageSourceFallingBlock() {
		return Modchu_Reflect.getFieldObject("DamageSource", "field_82729_p", "fallingBlock");
	}

	protected void entityAttackEntityFrom(Object damageSource, int i) {
		entityAttackEntityFrom(minecraftThePlayer(), damageSource, i);
	}

	protected void entityAttackEntityFrom(Object entity, Object damageSource, int i) {
		Modchu_Reflect.invokeMethod("Entity", "func_70097_a", "attackEntityFrom", new Class[]{ Modchu_Reflect.loadClass("DamageSource"), int.class }, entity, new Object[]{ damageSource, i });
	}

	protected float entityLivingBaseGetMaxHealth() {
		return entityLivingBaseGetMaxHealth(minecraftThePlayer());
	}

	protected float entityLivingBaseGetMaxHealth(Object entity) {
		if (Modchu_Main.getMinecraftVersion() < 130) return entityLivingGetMaxHealth(entity);
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_110138_aP", "getMaxHealth", entity));
	}

	protected int entityLivingGetMaxHealth() {
		return entityLivingGetMaxHealth(minecraftThePlayer());
	}

	protected int entityLivingGetMaxHealth(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_40117_c", "getMaxHealth", entity));
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

	protected Object entityGetDataWatcher() {
		return entityGetDataWatcher(minecraftThePlayer());
	}

	protected Object entityGetDataWatcher(Object entity) {
		return Modchu_Reflect.invokeMethod("Entity", "func_70096_w", "getDataWatcher", entity);
	}

	protected float entityLivingBaseGetHealth() {
		return entityLivingBaseGetHealth(minecraftThePlayer());
	}

	protected float entityLivingBaseGetHealth(Object entity) {
		if (Modchu_Main.getMinecraftVersion() < 130) return entityLivingGetHealth(entity);
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_110143_aJ", "getHealth", entity));
	}

	protected int entityLivingGetHealth() {
		return entityLivingGetHealth(minecraftThePlayer());
	}

	protected int entityLivingGetHealth(Object entity) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_41031_b", "health", entity));
	}

	protected void entityLivingBaseSetHealth(float f) {
		entityLivingBaseSetHealth(minecraftThePlayer(), f);
	}

	protected void entityLivingBaseSetHealth(Object entity, float f) {
		if (Modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70606_j", "setHealth", new Class[]{ float.class }, entity, new Object[]{ f });
		else Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70606_j", "setEntityHealth", new Class[]{ int.class }, entity, new Object[]{ (int) f });
	}

	protected void entityLivingSetHealth(int i) {
		entityLivingSetHealth(minecraftThePlayer(), i);
	}

	protected void entityLivingSetHealth(Object entity, int i) {
		Modchu_Reflect.invokeMethod("EntityLivingBase", "func_9372_a_", "setHealth", new Class[]{ int.class }, entity, new Object[]{ i });
	}

	protected Enum enumCreatureAttributeUNDEFINED() {
		return Modchu_Reflect.getEnum("EnumCreatureAttribute", "UNDEFINED");
	}

	protected Enum enumCreatureAttributeUNDEAD() {
		return Modchu_Reflect.getEnum("EnumCreatureAttribute", "UNDEAD");
	}

	protected Enum enumCreatureAttributeARTHROPOD() {
		return Modchu_Reflect.getEnum("EnumCreatureAttribute", "ARTHROPOD");
	}

	protected boolean worldIsBlockNormalCubeDefault(int i, int j, int k, boolean b) {
		return worldIsBlockNormalCubeDefault(minecraftThePlayer(), i, j, k, b);
	}

	protected boolean worldIsBlockNormalCubeDefault(Object entity, int i, int j, int k, boolean b) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("World", "func_72887_b", "isBlockNormalCubeDefault", new Class[]{ int.class, int.class, int.class, boolean.class }, entityWorldObj(entity), new Object[]{ i, j, k, b }));
	}

	protected Object entityPlayerFoodStats() {
		return entityPlayerFoodStats(minecraftThePlayer());
	}

	protected Object entityPlayerFoodStats(Object entityplayer) {
		return Modchu_Reflect.getFieldObject("EntityPlayer", "field_71100_bB", "foodStats", entityplayer);
	}

	protected Object entityPlayerGetFoodStats() {
		return entityPlayerGetFoodStats(minecraftThePlayer());
	}

	protected Object entityPlayerGetFoodStats(Object entityplayer) {
		return Modchu_Reflect.invokeMethod("EntityPlayer", "func_71024_bL", "getFoodStats", entityplayer);
	}

	protected void setEntityFoodStats(Object entityGetFoodStats) {
		setEntityFoodStats(minecraftThePlayer(), entityGetFoodStats);
	}

	protected void setEntityFoodStats(Object entityplayer, Object entityGetFoodStats) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_71100_bB", "foodStats", entityplayer, entityGetFoodStats);
	}

	protected int entityPlayerPlayerLevel() {
		return entityPlayerPlayerLevel(minecraftThePlayer());
	}

	protected int entityPlayerPlayerLevel(Object entityplayer) {
		// b181 aY
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_35210_aY", "playerLevel", entityplayer));
	}

	protected void setEntityPlayerPlayerLevel(int i) {
		setEntityPlayerPlayerLevel(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		// b181 aY
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_35210_aY", "playerLevel", entityplayer, i);
	}


	protected int entityPlayerTotalXP() {
		return entityPlayerTotalXP(minecraftThePlayer());
	}

	protected int entityPlayerTotalXP(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_35209_aZ", "totalXP", entityplayer));
	}

	protected void setEntityPlayerTotalXP(int i) {
		setEntityPlayerPlayerLevel(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerTotalXP(Object entityplayer, int i) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_35209_aZ", "totalXP", entityplayer, i);
	}

	protected float entityPlayerCurrentXP() {
		return entityPlayerCurrentXP(minecraftThePlayer());
	}

	protected float entityPlayerCurrentXP(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_35211_aX", "currentXP", entityplayer));
	}

	protected float entityLivingBaseMoveForward() {
		return entityLivingBaseMoveForward(minecraftThePlayer());
	}

	protected float entityLivingBaseMoveForward(Object entityplayer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70701_bs", "moveForward", entityplayer));
	}

	protected float entityLivingBaseMoveStrafing() {
		return entityLivingBaseMoveStrafing(minecraftThePlayer());
	}

	protected float entityLivingBaseMoveStrafing(Object entityplayer) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70702_br", "moveStrafing", entityplayer));
	}

	protected void setEntityPlayerCurrentXP(int i) {
		setEntityPlayerPlayerLevel(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_35211_aX", "currentXP", entityplayer, (int) f);
	}

	protected int entityPlayerScore() {
		return entityPlayerScore(minecraftThePlayer());
	}

	protected int entityPlayerScore(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("EntityPlayer", "field_9370_g", "score", entityplayer));
	}

	protected void setEntityPlayerScore(int i) {
		setEntityPlayerScore(minecraftThePlayer(), i);
	}

	protected void setEntityPlayerScore(Object entityplayer, int i) {
		Modchu_Reflect.setFieldObject("EntityPlayer", "field_9370_g", "score", entityplayer, i);
	}

	protected void setEntityLivingBaseHealth(float f) {
		setEntityLivingBaseHealth(minecraftThePlayer(), f);
	}

	protected void setEntityLivingBaseHealth(Object entity, float f) {
		Modchu_Reflect.setFieldObject("EntityLivingBase", "field_41031_b", "health", entity, f);
	}

	protected int entityPlayerGetItemInUseCount() {
		return entityPlayerGetItemInUseCount(minecraftThePlayer());
	}

	protected int entityPlayerGetItemInUseCount(Object entityplayer) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("EntityPlayer", "func_71052_bv", "getItemInUseCount", entityplayer));
	}

	protected Object itemStackCopyItemStack(Object o) {
		return Modchu_Reflect.invokeMethod("ItemStack", "func_77944_b", "copyItemStack", new Class[]{ Modchu_Reflect.loadClass("ItemStack") }, null, new Object[]{ o });
	}

	protected Object itemStackGetItemUseAction(Object itemstack) {
		return Modchu_Reflect.invokeMethod("ItemStack", "func_77975_n", "getItemUseAction", itemstack);
	}

	protected String[] renderBipedBipedArmorFilenamePrefix() {
		return (String[]) (Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("RenderBiped", "field_82424_k", "bipedArmorFilenamePrefix") : Modchu_Reflect.getFieldObject("RenderPlayer", "field_77110_j", "armorFilenamePrefix"));
	}

	protected int itemArmorRenderIndex(Object itemArmor) {
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("ItemArmor", "field_77880_c", "renderIndex", itemArmor));
	}

	protected void renderHelperEnableStandardItemLighting() {
		Modchu_Reflect.invokeMethod("RenderHelper", "func_74519_b", "enableStandardItemLighting");
	}

	protected void renderHelperDisableStandardItemLighting() {
		Modchu_Reflect.invokeMethod("RenderHelper", "func_74518_a", "disableStandardItemLighting");
	}

	protected float entityLivingBasePrevRenderYawOffset() {
		return entityLivingBasePrevRenderYawOffset(minecraftThePlayer());
	}

	protected float entityLivingBasePrevRenderYawOffset(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70760_ar", "prevRenderYawOffset", entity));
	}

	protected float entityLivingBaseRenderYawOffset() {
		return entityLivingBaseRenderYawOffset(minecraftThePlayer());
	}

	protected float entityLivingBaseRenderYawOffset(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70761_aq", "renderYawOffset", entity));
	}

	protected float entityPrevRotationYaw() {
		return entityPrevRotationYaw(minecraftThePlayer());
	}

	protected float entityPrevRotationYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70126_B", "prevRotationYaw", entity));
	}

	protected float entityLivingBasePrevRotationYawHead() {
		return entityLivingBasePrevRotationYawHead(minecraftThePlayer());
	}

	protected float entityLivingBasePrevRotationYawHead(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70758_at", "prevRotationYawHead", entity));
	}

	protected float entityLivingBaseRotationYawHead() {
		return entityLivingBaseRotationYawHead(minecraftThePlayer());
	}

	protected float entityLivingBaseRotationYawHead(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70759_as", "rotationYawHead", entity));
	}

	protected float entityLivingBasePrevLimbSwingAmount() {
		return entityLivingBasePrevLimbSwingAmount(minecraftThePlayer());
	}

	protected float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70722_aY", Modchu_Main.getMinecraftVersion() > 159 ? "prevLimbSwingAmount" : "prevLimbYaw", entity));
	}

	protected float entityLivingBaseLimbSwingAmount() {
		return entityLivingBaseLimbSwingAmount(minecraftThePlayer());
	}

	protected float entityLivingBaseLimbSwingAmount(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70721_aZ", Modchu_Main.getMinecraftVersion() > 159 ? "limbSwingAmount" : "limbYaw", entity));
	}

	protected float entityLivingBaseLimbSwing() {
		return entityLivingBaseLimbSwing(minecraftThePlayer());
	}

	protected float entityLivingBaseLimbSwing(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70754_ba", "limbSwing", entity));
	}

	protected boolean entityLivingBaseIsJumping() {
		return entityLivingBaseIsJumping(minecraftThePlayer());
	}

	protected boolean entityLivingBaseIsJumping(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70703_bu", "isJumping", entity));
	}

	protected float entityRotationYaw() {
		return entityRotationYaw(minecraftThePlayer());
	}

	protected float entityRotationYaw(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70177_z", "rotationYaw", entity));
	}

	protected float entityPrevRotationPitch() {
		return entityPrevRotationPitch(minecraftThePlayer());
	}

	protected float entityPrevRotationPitch(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70127_C", "prevRotationPitch", entity));
	}

	protected float entityRotationPitch() {
		return entityRotationPitch(minecraftThePlayer());
	}

	protected float entityRotationPitch(Object entity) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("Entity", "field_70125_A", "rotationPitch", entity));
	}

	protected float entityLivingBaseGetSwingProgress(float f) {
		return entityLivingBaseGetSwingProgress(minecraftThePlayer(), f);
	}

	protected float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return Modchu_CastHelper.Float(Modchu_Reflect.invokeMethod("EntityLivingBase", "func_70678_g", "getSwingProgress", new Class[]{ float.class }, entity, new Object[]{ f }));
	}

	protected String entityCloakUrl() {
		return entityCloakUrl(minecraftThePlayer());
	}

	protected String entityCloakUrl(Object entity) {
		return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("Entity", "field_622_aY", "cloakUrl", entity));
	}

	protected Object abstractClientPlayerGetTextureSkin() {
		return abstractClientPlayerGetTextureSkin(minecraftThePlayer());
	}

	protected Object abstractClientPlayerGetTextureSkin(Object entity) {
		return Modchu_Reflect.invokeMethod("AbstractClientPlayer", "func_110309_l", "getTextureSkin", entity);
	}

	protected Object abstractClientPlayerGetTextureCape() {
		return abstractClientPlayerGetTextureCape(minecraftThePlayer());
	}

	protected Object abstractClientPlayerGetTextureCape(Object entity) {
		return Modchu_Reflect.invokeMethod("AbstractClientPlayer", "func_110310_o", "getTextureCape", entity);
	}

	protected void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		Modchu_Reflect.invokeMethod("ModelBase", "func_78086_a", "setLivingAnimations", new Class[]{ Modchu_Reflect.loadClass("EntityLivingBase"), float.class, float.class, float.class }, model, new Object[]{ entity, f, f1, f2 });
	}

	protected void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		Modchu_Reflect.invokeMethod("ModelBase", "func_78087_a", "setRotationAngles", new Class[]{ float.class, float.class, float.class, float.class, float.class, float.class, Modchu_Reflect.loadClass("Entity") }, model, new Object[]{ f, f1, f2, f3, f4, f5, entity });
	}

	protected boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("ThreadDownloadImageData", "func_110557_a", "isTextureUploaded", threadDownloadImageData));
	}

	protected boolean entityIsInvisible() {
		return entityIsInvisible(minecraftThePlayer());
	}

	protected boolean entityIsInvisible(Object entity) {
		return Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("Entity", "func_82150_aj", "isInvisible", entity));
	}

	protected Object rendererLivingEntityRES_ITEM_GLINT(Object render) {
		return Modchu_Reflect.getFieldObject("RendererLivingEntity", "field_110814_a", "RES_ITEM_GLINT", render);
	}

	protected Object getResource(String s) {
		return getResource(Modchu_Reflect.loadClass("Minecraft"), s);
	}

	protected Object getResource(Class c, String s) {
		return c.getResource(s);
	}

	protected int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("TextureUtil", "func_110987_a", "uploadTextureImage", new Class[]{ int.class, BufferedImage.class }, new Object[]{ i, bufferedimage }));
	}

	protected void textureUtilBindTexture(int i) {
		Modchu_Reflect.invokeMethod("TextureUtil", "func_94277_a", "bindTexture", new Class[]{ int.class }, new Object[]{ i });
	}

	protected void textureManagerBindTexture(Object o) {
		textureManagerBindTexture(Modchu_Main.getMinecraftVersion() > 159 ? minecraftGetTextureManager() : renderEngine(), o);
	}

	protected void textureManagerBindTexture(Object textureManager, Object o) {
		if (Modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.invokeMethod("TextureManager", "func_110577_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, textureManager, new Object[]{ o });
		else Modchu_Reflect.invokeMethod("RenderEngine", "func_94277_a", "bindTexture", new Class[]{ String.class }, textureManager, new Object[]{ o });
	}

	protected Object textureManagerGetTexture(Object o) {
		return textureManagerGetTexture(Modchu_Main.getMinecraftVersion() > 159 ? minecraftGetTextureManager() : renderEngine(), o);
	}

	protected Object textureManagerGetTexture(Object textureManager, Object o) {
		return Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.invokeMethod("TextureManager", "func_110581_b", "getTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, textureManager, new Object[]{ o }) : o;
	}

	protected Object renderEngine() {
		return Modchu_Reflect.getFieldObject("Minecraft", "field_71446_o", "renderEngine", minecraftGetMinecraft());
	}

	protected void renderEngineSetupTexture(Object bufferedimage, int i) {
		Modchu_Reflect.invokeMethod("RenderEngine", "func_78351_a", "setupTexture", new Class[]{ BufferedImage.class, int.class }, renderEngine(), new Object[]{ bufferedimage, 1 });
	}

	protected Object tessellatorInstance() {
		return Modchu_Reflect.getFieldObject("Tessellator", "field_78398_a", "instance");
	}

	protected void tessellatorStartDrawingQuads() {
		tessellatorStartDrawingQuads(tessellatorInstance());
	}

	protected void tessellatorStartDrawingQuads(Object tessellator) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78382_b", "startDrawingQuads", tessellator);
	}

	protected void tessellatorStartDrawing(Object tessellator, byte by) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78371_b", "startDrawing", new Class[]{ byte.class }, tessellator, new Object[]{ by });
	}

	protected void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78375_b", "setNormal", new Class[]{ float.class, float.class, float.class }, tessellator, new Object[]{ f, f2, f3 });
	}

	protected void tessellatorSetColorOpaque_I(int i) {
		tessellatorSetColorOpaque_I(tessellatorInstance(), i);
	}

	protected void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78378_d", "setColorOpaque_I", new Class[]{ int.class }, tessellator, new Object[]{ i });
	}

	protected void tessellatorSetColorRGBA_I(int i, int i2) {
		tessellatorSetColorRGBA_I(tessellatorInstance(), i, i2);
	}

	protected void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78384_a", "setColorRGBA_I", new Class[]{ int.class, int.class }, tessellator, new Object[]{ i, i2 });
	}

	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78374_a", "addVertexWithUV", new Class[]{ double.class, double.class, double.class, double.class, double.class }, tessellator, new Object[]{ d, d2, d3, d4, d5 });
	}

	protected void tessellatorDraw(Object tessellator) {
		Modchu_Reflect.invokeMethod("Tessellator", "func_78381_a", "draw", tessellator);
	}

	protected void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		Modchu_Reflect.invokeMethod("TexturedQuad", "func_78236_a", "draw", new Class[]{ Modchu_Reflect.loadClass("Tessellator"), float.class }, texturedQuad, new Object[]{ tessellator, f });
	}

	protected Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return Modchu_Reflect.invokeMethod("PositionTextureVertex", "func_78240_a", "setTexturePosition", new Class[]{ float.class, float.class }, positionTextureVertex, new Object[]{ f, f1 });
	}

	protected Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return Modchu_Reflect.getFieldObject("PositionTextureVertex", "field_78243_a", "vector3D", positionTextureVertex);
	}

	protected float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("PositionTextureVertex", "field_78241_b", "texturePositionX", positionTextureVertex));
	}

	protected float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject("PositionTextureVertex", "field_78242_c", "texturePositionY", positionTextureVertex));
	}

	protected Object vec3Subtract(Object vec3, Object vec3_2) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72444_a", "subtract", new Class[]{ vec3.getClass() }, vec3, new Object[]{ vec3_2 });
	}

	protected Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72431_c", "crossProduct", new Class[]{ vec3.getClass() }, vec3, new Object[]{ vec3_2 });
	}

	protected Object vec3Normalize(Object vec3) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72432_b", "normalize", vec3);
	}

	protected Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return Modchu_Reflect.invokeMethod("Vec3", "func_72443_a", "createVectorHelper", new Class[]{ double.class, double.class, double.class }, new Object[]{ d, d2, d3 });
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

	protected void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		Modchu_Reflect.invokeMethod("GuiSlot", "func_77220_a", "registerScrollButtons",
				Modchu_Main.getMinecraftVersion() > 159 ? new Class[]{ int.class, int.class } : new Class[]{ List.class, int.class, int.class },
				guiSlot,
				Modchu_Main.getMinecraftVersion() > 159 ? new Object[]{ i, i2 } : new Object[]{ list, i, i2 });
	}

	protected List worldPlayerEntities() {
		return worldPlayerEntities(minecraftTheWorld());
	}

	protected List worldPlayerEntities(Object world) {
		return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject("World", "field_73010_i", "playerEntities", world));
	}

	protected void guiScreenActionPerformed(Object guiScreen, Object guiButton) {
		Modchu_Reflect.invokeMethod("GuiScreen", "func_73875_a", "actionPerformed", new Class[]{ Modchu_Reflect.loadClass("GuiButton") }, guiScreen, new Object[]{ guiButton });
	}

	protected void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		Modchu_Reflect.invokeMethod("GuiScreen", "func_73863_a", "drawScreen", new Class[]{ int.class, int.class, float.class }, guiScreen, new Object[]{ i, i2, f });
	}

	protected void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		Modchu_Reflect.invokeMethod("GuiSlot", "func_77211_a", "drawScreen", new Class[]{ int.class, int.class, float.class }, guiSlot, new Object[]{ i, i2, f });
	}

	protected void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		Modchu_Reflect.invokeMethod("GuiSlot", "func_77219_a", "actionPerformed", new Class[]{ Modchu_Reflect.loadClass("GuiButton") }, guiSlot, new Object[]{ guiButton });
	}

	protected void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		Modchu_Reflect.invokeMethod("Gui", "func_73732_a", "drawCenteredString", new Class[]{ Modchu_Reflect.loadClass("FontRenderer"), String.class, int.class, int.class, int.class }, gui, new Object[]{ fontRenderer, s, i, i2, i3 });
	}

	protected String gameSettingsGetKeyDisplayString(int i) {
		return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("GameSettings", "func_74298_c", "getKeyDisplayString", new Class[]{ int.class }, new Object[]{ i }));
	}

	protected Object guiOptionsBackground() {
		return Modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("Gui", "field_110325_k", "optionsBackground") : "/gui/background.png";
	}

}
