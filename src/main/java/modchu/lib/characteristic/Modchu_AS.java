package modchu.lib.characteristic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Map;

import modchu.lib.Modchu_ASAlmighty;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import cpw.mods.fml.common.FMLCommonHandler;

public class Modchu_AS extends Modchu_ASAlmighty {

	public Modchu_AS() {
		super();
		instance = this;
	}

	public static void instanceCheck() {
		if (instance != null
				&& instance instanceof Modchu_AS) ;else instance = new Modchu_AS();
	}

	@Override
	protected Object FMLCommonHandlerInstance() {
		return FMLCommonHandler.instance();
	}

	@Override
	protected Object FMLCommonHandlerInstanceGetMinecraftServerInstance() {
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}

	@Override
	protected Object[] FMLCommonHandlerInstanceGetMinecraftServerInstanceWorldServers() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
	}

	@Override
	protected Object minecraftGetMinecraft() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft();
	}

	@Override
	protected Object minecraftThePlayer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().thePlayer;
	}

	@Override
	protected void setMinecraftThePlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().thePlayer = (EntityClientPlayerMP) entityPlayer;
	}

	@Override
	protected Object minecraftTheWorld() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	protected File minecraftMcDataDir() {
		if (Modchu_Main.isServer) return new File(".");
		return Minecraft.getMinecraft().mcDataDir;
	}

	@Override
	protected Object minecraftFontRenderer() {
		return Minecraft.getMinecraft().fontRenderer;
	}

	@Override
	protected Object minecraftGatSession() {
		return Minecraft.getMinecraft().getSession();
	}

	@Override
	protected void minecraftFontRenderer(Object fontRenderer) {
		Minecraft.getMinecraft().fontRenderer = (FontRenderer) fontRenderer;
	}

	@Override
	protected Object minecraftGameSettings() {
		return Minecraft.getMinecraft().gameSettings;
	}

	@Override
	protected int minecraftGameSettingsThirdPersonView() {
		return Minecraft.getMinecraft().gameSettings.thirdPersonView;
	}

	@Override
	protected void minecraftGameSettingsSetThirdPersonView(int i) {
		Minecraft.getMinecraft().gameSettings.thirdPersonView = i;
	}

	@Override
	protected boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		return Minecraft.getMinecraft().gameSettings.touchscreen;
	}

	@Override
	protected Object minecraftEntityRenderer() {
		return Minecraft.getMinecraft().entityRenderer;
	}

	@Override
	protected Object minecraftTextureManager() {
		return Minecraft.getMinecraft().renderEngine;
	}

	@Override
	protected Object minecraftGetTextureManager() {
		return Minecraft.getMinecraft().getTextureManager();
	}

	@Override
	protected long minecraftGetSystemTime() {
		return Minecraft.getMinecraft().getSystemTime();
	}

	@Override
	protected int minecraftDisplayWidth() {
		return Minecraft.getMinecraft().displayWidth;
	}

	@Override
	protected int minecraftDisplayHeight() {
		return Minecraft.getMinecraft().displayHeight;
	}

	@Override
	protected Object textureManagerGetTexture(Object textureManager, Object o) {
		return ((TextureManager) textureManager).getTexture((ResourceLocation) o);
	}

	@Override
	protected void setMinecraftRenderViewEntity(Object entity) {
		Minecraft.getMinecraft().renderViewEntity = (EntityLivingBase) entity;
	}

	@Override
	protected void printChatMessage(String s) {
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(s));
	}

	@Override
	protected boolean isMac() {
		return Minecraft.getMinecraft().isRunningOnMac;
	}

	@Override
	protected int keyBindingKeyCode(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyCode() : -1;
	}

	@Override
	protected String keyBindingKeyDescription(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyDescription() : null;
	}

	@Override
	protected String keyBindingKeyCategory(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getKeyCategory() : null;
	}

	@Override
	protected boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).getIsKeyPressed() : null;
	}

	@Override
	protected boolean keyBindingIsPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).isPressed() : null;
	}

	@Override
	protected Object[] blockBlockList() {
		return null;
	}

	@Override
	protected Object[] itemItemsList() {
		return null;
	}

	@Override
	protected Object blockGetBlockFromItem(Object item) {
		if (item != null) ;else return null;
		return Block.getBlockFromItem((Item) item);
	}

	@Override
	protected Object getBlockItemStack(Object itemstack) {
		if (itemstack != null) ;else return null;
		return blockGetBlockFromItem(itemStackGetItem(itemstack));
	}

	@Override
	protected Object getItem(String s) {
		if (s != null) ;else return null;
		return Item.itemRegistry.getObject(s);
	}

	@Override
	protected int itemItemID(Object item) {
		return -1;
	}

	@Override
	protected int itemStackItemID(Object itemstack) {
		return -1;
	}

	@Override
	protected boolean isSkull(Object itemStackOrItem) {
		int version = Modchu_Main.getMinecraftVersion();
		Object item = itemStackOrItem;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItem)) {
			item = itemStackGetItem(itemStackOrItem);
		}
		return getItem("skull").getClass().isInstance(item);
	}

	@Override
	protected int entityEntityID(Object entity) {
		return ((Entity) entity).getEntityId();
	}

	@Override
	protected void setEntityEntityID(Object entity, int i) {
		((Entity) entity).setEntityId(i);
	}

	@Override
	protected int guiButtonID(Object guiButton) {
		return ((GuiButton) guiButton).id;
	}

	@Override
	protected void setGuiButtonID(Object guiButton, int i) {
		((GuiButton) guiButton).id = i;
	}

	@Override
	protected boolean guiButtonEnabled(Object guiButton) {
		return ((GuiButton) guiButton).enabled;
	}

	@Override
	protected void setGuiButtonEnabled(Object guiButton, boolean b) {
		((GuiButton) guiButton).enabled = b;
	}

	@Override
	protected int guiButtonXPosition(Object guiButton) {
		return ((GuiButton) guiButton).xPosition;
	}

	@Override
	protected void setGuiButtonXPosition(Object guiButton, int i) {
		((GuiButton) guiButton).xPosition = i;
	}

	@Override
	protected int guiButtonYPosition(Object guiButton) {
		return ((GuiButton) guiButton).yPosition;
	}

	@Override
	protected void setGuiButtonYPosition(Object guiButton, int i) {
		((GuiButton) guiButton).yPosition = i;
	}

	@Override
	protected boolean guiButtonVisible(Object guiButton) {
		return ((GuiButton) guiButton).visible;
	}

	@Override
	protected void setGuiButtonVisible(Object guiButton, boolean b) {
		((GuiButton) guiButton).visible = b;
	}

	@Override
	protected InputStream resourceManagerInputStream(Object o) {
		try {
			return Minecraft.getMinecraft().getResourceManager().getResource((ResourceLocation) o).getInputStream();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	protected InputStream resourceGetInputStream(Object resource) {
		return ((IResource) resource).getInputStream();
	}

	@Override
	protected Object newInstanceKeyBinding(String s, int i, String s2) {
		return new KeyBinding(s, i, s2);
	}

	@Override
	protected String getUserName(Object entityplayer) {
		return entityplayer instanceof EntityPlayer ? ((EntityPlayer) entityplayer).getCommandSenderName() : null;
	}

	@Override
	protected boolean isPlanterCheck(Object block) {
		return block instanceof BlockFlower
				| block instanceof BlockDoublePlant
				| block instanceof BlockMushroom
				| block instanceof BlockSapling
				| block instanceof BlockTallGrass;
	}

	@Override
	protected boolean isCamouflageCheck(Object block) {
		return block instanceof BlockLeaves
				| block instanceof BlockPumpkin;
	}

	@Override
	protected int getVacancyGlobalEntityID() {
		Map map = EntityList.IDtoClassMapping;
		int ID = -1;
		if (map != null) {
			for(int i = 64; i < 3000; i++) {
				//Modchu_Debug.mDebug("getVacancyGlobalEntityID i"+i+" !map.containsKey(i) = "+(!map.containsKey(i)));
				if (!map.containsKey(i)) {
					ID = i;
					//Modchu_Debug.mDebug("getVacancyGlobalEntityID !map.containsKey ID="+ID);
					break;
				}
			}
		} else {
			Modchu_Debug.lDebug("getVacancyGlobalEntityID IDtoClassMapping map == null !!");
		}
		return ID;
	}

	@Override
	protected boolean isLANWorld() {
		if (!isMuiti()) {
			Object theIntegratedServer = Modchu_Reflect.getFieldObject("Minecraft", "field_71437_Z", "theIntegratedServer", minecraftGetMinecraft());
			if (theIntegratedServer != null
					&& (Boolean) Modchu_Reflect.invokeMethod(theIntegratedServer.getClass(), "func_71344_c", "getPublic", theIntegratedServer)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean isIntegratedServerRunning() {
		return Minecraft.getMinecraft().isIntegratedServerRunning();
	}

	@Override
	protected boolean isMuiti() {
		return Minecraft.getMinecraft().getNetHandler() != null
				&& !Minecraft.getMinecraft().isSingleplayer();
	}

	@Override
	protected Object renderRenderBlocks(Object pRender) {
		return Modchu_Reflect.getFieldObject("Render", "field_147909_c", pRender);
	}

	@Override
	protected void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		((RenderBlocks) renderBlocks).renderBlockAsItem((Block) block, i, f);
	}

	@Override
	protected void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		((RenderBlocks) renderBlocks).renderBlockAllFaces((Block) block, i, i2, i3);
	}

	@Override
	protected void setMinecraftDisplayGuiScreen(Object guiScreen) {
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) guiScreen);
	}

	@Override
	protected void guiIngameDrawString(String s, int i, int j, int k) {
		Minecraft mc = Minecraft.getMinecraft();
		mc.ingameGUI.drawString(mc.fontRenderer, s, i, j, k);
	}

	@Override
	protected void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		((FontRenderer) fontRenderer).drawString(s, i, j, k);
	}

	@Override
	protected Object itemStackGetItem(Object itemstack) {
		return ((ItemStack) itemstack).getItem();
	}

	@Override
	protected float itemStackGetItemDamage(Object itemstack) {
		return ((ItemStack) itemstack).getItemDamage();
	}

	@Override
	protected Object renderManagerInstance() {
		return RenderManager.instance;
	}

	@Override
	protected Object renderManagerGetEntityRenderObject(Object entity) {
		return RenderManager.instance.getEntityRenderObject((Entity) entity);
	}

	@Override
	protected Object renderManagerGetEntityClassRenderObject(Class c) {
		return RenderManager.instance.getEntityClassRenderObject(c);
	}

	@Override
	protected boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		return RenderManager.instance.renderEntityWithPosYaw((Entity) entity, d, d2, d3, f, f2);
	}

	@Override
	protected Map renderManagerEntityRenderMap() {
		return RenderManager.instance.entityRenderMap;
	}

	@Override
	protected Object renderRenderManagerRenderEngine(Object render) {
		return ((RenderManager) renderRenderManager(render)).renderEngine;
	}

	@Override
	protected void renderFirstPersonArm(Object renderplayer, Object entityplayer) {
		((RenderPlayer) renderplayer).renderFirstPersonArm((EntityPlayer) entityplayer);
	}

	@Override
	protected Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return null;
	}

	@Override
	protected void renderBindTexture(Object render, Object resourceLocation) {
		Modchu_Reflect.invokeMethod("Render", "func_110776_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, render, new Object[]{ resourceLocation });
	}

	@Override
	protected Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).armorItemInSlot(i);
	}

	@Override
	protected Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).getStackInSlot(i);
	}

	@Override
	protected int itemStackStackSize(Object itemstack) {
		return ((ItemStack) itemstack).stackSize;
	}

	@Override
	protected boolean itemStackIsItemEnchanted(Object itemstack) {
		return ((ItemStack) itemstack).isItemEnchanted();
	}

	@Override
	protected float mathHelperSin(float f) {
		return MathHelper.sin(f);
	}

	@Override
	protected float mathHelperCos(float f) {
		return MathHelper.cos(f);
	}

	@Override
	protected float mathHelperSqrt_float(float f) {
		return MathHelper.sqrt_float(f);
	}

	@Override
	protected double mathHelperFloor_double(double d) {
		return MathHelper.floor_double(d);
	}

	@Override
	protected int textureOffsetTextureOffsetX(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetX;
	}

	@Override
	protected int textureOffsetTextureOffsetY(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetY;
	}

	@Override
	protected Object minecraftCurrentScreen() {
		return Minecraft.getMinecraft().currentScreen;
	}

	@Override
	protected int openGlHelperLightmapTexUnit() {
		return OpenGlHelper.lightmapTexUnit;
	}

	@Override
	protected void openGlHelperSetActiveTexture(int i) {
		OpenGlHelper.setActiveTexture(i);
	}

	@Override
	protected int openGlHelperDefaultTexUnit() {
		return OpenGlHelper.defaultTexUnit;
	}

	@Override
	protected int guiScreenWidth(Object guiScreen) {
		return ((GuiScreen) guiScreen).width;
	}

	@Override
	protected void setGuiScreenWidth(Object guiScreen, int i) {
		((GuiScreen) guiScreen).width = i;
	}

	@Override
	protected int guiScreenHeight(Object guiScreen) {
		return ((GuiScreen) guiScreen).height;
	}

	@Override
	protected void setGuiScreenHeight(Object guiScreen, int i) {
		((GuiScreen) guiScreen).height = i;
	}

	@Override
	protected Object guiScreenFontRenderer(Object guiScreen) {
		return Modchu_Reflect.getFieldObject("GuiScreen", "field_146289_q", "fontRendererObj", guiScreen);
	}

	@Override
	protected void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		Modchu_Reflect.setFieldObject("GuiScreen", "fontRendererObj", guiScreen, fontRenderer);
	}

	@Override
	protected void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		((GuiSlot) guiSlot).actionPerformed((GuiButton) guiButton);
	}

	@Override
	protected boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return ((EntityPlayer) entityplayer).isPlayerSleeping();
	}

	@Override
	protected float entityWidth(Object entity) {
		return ((Entity) entity).width;
	}

	@Override
	protected float entityHeight(Object entity) {
		return ((Entity) entity).height;
	}

	@Override
	protected IntBuffer glAllocationCreateDirectIntBuffer(int i) {
		return GLAllocation.createDirectIntBuffer(i);
	}

	@Override
	protected int glAllocationGenerateDisplayLists(int i) {
		return GLAllocation.generateDisplayLists(i);
	}

	@Override
	protected void renderEngineBindTexture(String s) {
		return;
	}

	@Override
	protected void blockSetLightOpacity(Object block, int lightOpacity) {
		((Block) block).setLightOpacity(lightOpacity);
	}

	@Override
	protected Object minecraftEntityRendererItemRenderer() {
		return Minecraft.getMinecraft().entityRenderer.itemRenderer;
	}

	@Override
	protected Object renderManagerItemRenderer() {
		return RenderManager.instance.itemRenderer;
	}

	@Override
	protected void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, int i) {
		RenderManager.instance.itemRenderer.renderItem((EntityLivingBase) entity, (ItemStack) itemstack, i);
	}

	@Override
	protected void setEntityRendererItemRenderer(Object itemRenderer) {
		//final orz
		Modchu_Reflect.setFieldObject("EntityRenderer", Modchu_Main.getMinecraftVersion() > 169 ? "field_78516_c" : "field_73841_b", "itemRenderer", minecraftEntityRenderer(), itemRenderer);
	}

	@Override
	protected void setRenderManagerItemRenderer(Object itemRenderer) {
		RenderManager.instance.itemRenderer = (ItemRenderer) itemRenderer;
	}

	@Override
	protected Object minecraftPlayerController() {
		return Minecraft.getMinecraft().playerController;
	}

	@Override
	protected void setMinecraftPlayerController(Object playerController) {
		Minecraft.getMinecraft().playerController = (PlayerControllerMP) playerController;
	}

	@Override
	protected Object worldGetWorldInfo() {
		return Minecraft.getMinecraft().theWorld.getWorldInfo();
	}

	@Override
	protected Enum worldGetWorldInfoGetGameType() {
		return Minecraft.getMinecraft().theWorld.getWorldInfo().getGameType();
	}

	@Override
	protected Enum enumactionBlock() {
		return EnumAction.block;
	}

	@Override
	protected Enum enumactionBow() {
		return EnumAction.bow;
	}

	@Override
	protected Enum enumactionDrink() {
		return EnumAction.drink;
	}

	@Override
	protected Enum enumactionEat() {
		return EnumAction.eat;
	}

	@Override
	protected Enum enumactionNone() {
		return EnumAction.none;
	}

	@Override
	protected double entityPosX(Object entity) {
		return ((Entity) entity).posX;
	}

	@Override
	protected double entityPosY(Object entity) {
		return ((Entity) entity).posY;
	}

	@Override
	protected double entityPosZ(Object entity) {
		return ((Entity) entity).posZ;
	}

	@Override
	protected double entityPrevPosX(Object entity) {
		return ((Entity) entity).prevPosX;
	}

	@Override
	protected double entityPrevPosY(Object entity) {
		return ((Entity) entity).prevPosY;
	}

	@Override
	protected double entityPrevPosZ(Object entity) {
		return ((Entity) entity).prevPosZ;
	}

	@Override
	protected float entityPrevDistanceWalkedModified(Object entity) {
		return ((Entity) entity).prevDistanceWalkedModified;
	}

	@Override
	protected float entityDistanceWalkedModified(Object entity) {
		return ((Entity) entity).distanceWalkedModified;
	}

	@Override
	protected int entityTicksExisted(Object entity) {
		return ((Entity) entity).ticksExisted;
	}

	@Override
	protected float entityPlayerPrevCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).prevCameraYaw;
	}

	@Override
	protected float entityPlayerCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).cameraYaw;
	}

	@Override
	protected void setEntityPosX(Object entity, double d) {
		((Entity) entity).posX = d;
	}

	@Override
	protected void setEntityPosY(Object entity, double d) {
		((Entity) entity).posY = d;
	}

	@Override
	protected void setEntityPosZ(Object entity, double d) {
		((Entity) entity).posZ = d;
	}

	@Override
	protected double entityMotionX(Object entity) {
		return ((Entity) entity).motionX;
	}

	@Override
	protected double entityMotionY(Object entity) {
		return ((Entity) entity).motionY;
	}

	@Override
	protected double entityMotionZ(Object entity) {
		return ((Entity) entity).motionZ;
	}

	@Override
	protected void setEntityMotionX(Object entity, double d) {
		((Entity) entity).motionX = d;
	}

	@Override
	protected void setEntityMotionY(Object entity, double d) {
		((Entity) entity).motionY = d;
	}

	@Override
	protected void setEntityMotionZ(Object entity, double d) {
		((Entity) entity).motionZ = d;
	}

	@Override
	protected void playerControllerSetGameType(Object enumGameType) {
		Minecraft.getMinecraft().playerController.setGameType((GameType) enumGameType);
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer() {
		Object thePlayer = minecraftThePlayer();
		minecraftSetDimensionAndSpawnPlayer(((Entity) thePlayer).dimension);
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer(int i) {
		Minecraft.getMinecraft().setDimensionAndSpawnPlayer(i);
	}

	@Override
	protected void playerControllerCreativeSetPlayerCapabilities(Object playerController, Object entityplayer) {
	}

	@Override
	protected void worldSetEntityDead(Object entity) {
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object entity, double d, double d2, double d3) {
		return ((Entity) entity).worldObj.canBlockSeeTheSky((int) d, (int) d2, (int) d3);
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object entity, int i, int i2, int i3) {
		return ((Entity) entity).worldObj.canBlockSeeTheSky(i, i2, i3);
	}

	@Override
	protected boolean worldIsRemote(Object entity) {
		return ((Entity) entity).worldObj.isRemote;
	}

	@Override
	protected void entitySetDead(Object entity) {
		((Entity) entity).setDead();
	}

	@Override
	protected Object playerControllerMPCreatePlayer(Object playerController) {
		return null;
	}

	@Override
	protected void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		((PlayerControllerMP) playerController).flipPlayer((EntityPlayer) entityplayer);
	}

	@Override
	protected void worldSpawnPlayerWithLoadedChunks(Object entityplayer) {
	}

	@Override
	protected void setEntityPlayerSPMovementInput() {
		Object thePlayer = minecraftThePlayer();
		Object gameSettings = minecraftGameSettings();
		setEntityPlayerSPMovementInput(thePlayer, new MovementInputFromOptions((GameSettings) gameSettings));
	}

	@Override
	protected void setEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		((EntityPlayerSP) entityplayer).movementInput = (MovementInput) movementInput;
	}

	@Override
	protected void entityPlayerSPFunc_6420_o(Object entityplayer) {
	}

	@Override
	protected boolean entityPlayerGetHideCape(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getHideCape();
	}

	@Override
	protected double entityPlayerField_71091_bM(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71091_bM;
	}

	@Override
	protected double entityPlayerField_71096_bN(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71096_bN;
	}

	@Override
	protected double entityPlayerField_71097_bO(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71097_bO;
	}

	@Override
	protected double entityPlayerField_71094_bP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71094_bP;
	}

	@Override
	protected double entityPlayerField_71095_bQ(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71095_bQ;
	}

	protected double entityPlayerField_71085_bR(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71085_bR;
	}

	@Override
	protected void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
	}

	@Override
	protected Object entityPlayerInventory(Object entityplayer) {
		return ((EntityPlayer) entityplayer).inventory;
	}

	@Override
	protected Object entityPlayerInventoryGetCurrentItem(Object entityplayer) {
		return ((EntityPlayer) entityplayer).inventory.getCurrentItem();
	}

	@Override
	protected void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		((EntityPlayer) entityplayer).inventory = (InventoryPlayer) inventory;
	}

	@Override
	protected Object[] entityPlayerMainInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).mainInventory;
	}

	@Override
	protected Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorItemInSlot(i);
	}

	@Override
	protected void setEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		((EntityPlayer) entityplayer).inventory.mainInventory = (ItemStack[]) mainInventory;
	}

	@Override
	protected Object[] entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerArmorInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorInventory;
	}

	@Override
	protected void setEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		((EntityPlayer) entityplayer).inventory.armorInventory = (ItemStack[]) armorInventory;
	}

	@Override
	protected Object entityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return ((EntityPlayer) entityplayer).inventory.getStackInSlot(i);
	}

	@Override
	protected int entityDimension(Object entity) {
		return ((Entity) entity).dimension;
	}

	@Override
	protected Object gameSettingsKeyBindForward() {
		return Minecraft.getMinecraft().gameSettings.keyBindForward;
	}

	@Override
	protected Object gameSettingsKeyBindBack() {
		return Minecraft.getMinecraft().gameSettings.keyBindBack;
	}

	@Override
	protected Object gameSettingsKeyBindLeft() {
		return Minecraft.getMinecraft().gameSettings.keyBindLeft;
	}

	@Override
	protected Object gameSettingsKeyBindRight() {
		return Minecraft.getMinecraft().gameSettings.keyBindRight;
	}

	@Override
	protected void setGameSettingsKeyBindForward(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindForward = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindBack(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindBack = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindRight(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindRight = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindLeft(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindLeft = (KeyBinding) keyBinding;
	}

	@Override
	protected boolean entityIsRiding(Object entity) {
		return ((Entity) entity).isRiding();
	}

	@Override
	protected boolean minecraftInGameHasFocus() {
		return Minecraft.getMinecraft().inGameHasFocus;
	}

	@Override
	protected void entitySetPosition(Object entity, double x, double y, double z) {
		((Entity) entity).setPosition(x, y, z);
	}

	@Override
	protected float entityGetEyeHeight(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getEyeHeight();
	}

	@Override
	protected Object entityBoundingBox(Object entity) {
		return ((Entity) entity).boundingBox;
	}

	@Override
	protected double entityBoundingBoxMinX(Object entity) {
		return ((Entity) entity).boundingBox.minX;
	}

	@Override
	protected double entityBoundingBoxMinY(Object entity) {
		return ((Entity) entity).boundingBox.minY;
	}

	@Override
	protected double entityBoundingBoxMinZ(Object entity) {
		return ((Entity) entity).boundingBox.minZ;
	}

	@Override
	protected double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxX;
	}

	@Override
	protected double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxY;
	}

	@Override
	protected double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxZ;
	}

	@Override
	protected boolean entityIsSneaking(Object entity) {
		return ((Entity) entity).isSneaking();
	}

	@Override
	protected Object entityWorldObj(Object entity) {
		return ((Entity) entity).worldObj;
	}

	@Override
	protected boolean worldIsAirBlock(Object entity, int i, int j, int k) {
		return ((Entity) entity).worldObj.isAirBlock(i, j, k);
	}

	@Override
	protected boolean worldIsDaytime(Object entity) {
		return ((Entity) entity).worldObj.isDaytime();
	}

	@Override
	protected Object entityRidingEntity(Object entity) {
		return ((Entity) entity).ridingEntity;
	}

	@Override
	protected int entityLivingBaseDeathTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).deathTime;
	}

	@Override
	protected void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).deathTime = i;
	}

	@Override
	protected float entityYOffset(Object entity) {
		return ((Entity) entity).yOffset;
	}

	@Override
	protected void setEntityYOffset(Object entity, float f) {
		((Entity) entity).yOffset = f;
	}

	@Override
	protected float entityGetBrightness(Object entity, float f) {
		return ((Entity) entity).getBrightness(f);
	}

	@Override
	protected int entityGetBrightnessForRender(Object entity, float f) {
		return ((Entity) entity).getBrightnessForRender(f);
	}

	@Override
	protected void entitySetFire(Object entity, int i) {
		((Entity) entity).setFire(i);
	}

	@Override
	protected boolean entityIsWet(Object entity) {
		return ((Entity) entity).isWet();
	}

	@Override
	protected boolean entityIsInWater(Object entity) {
		return ((Entity) entity).isInWater();
	}

	@Override
	protected Object damageSourceStarve() {
		return DamageSource.starve;
	}

	@Override
	protected Object damageSourceCactus() {
		return DamageSource.cactus;
	}

	@Override
	protected Object damageSourceInWall() {
		return DamageSource.inWall;
	}

	@Override
	protected Object damageSourceDrown() {
		return DamageSource.drown;
	}

	@Override
	protected Object damageSourceOnFire() {
		return DamageSource.onFire;
	}

	@Override
	protected Object damageSourceLava() {
		return DamageSource.lava;
	}

	@Override
	protected Object damageSourceInFire() {
		return DamageSource.inFire;
	}

	@Override
	protected Object damageSourceMagic() {
		return DamageSource.magic;
	}

	@Override
	protected Object damageSourceGeneric() {
		return DamageSource.generic;
	}

	@Override
	protected Object damageSourceFall() {
		return DamageSource.fall;
	}

	@Override
	protected Object damageSourceOutOfWorld() {
		return DamageSource.outOfWorld;
	}

	@Override
	protected Object damageSourceWither() {
		return DamageSource.wither;
	}

	@Override
	protected Object damageSourceAnvil() {
		return DamageSource.anvil;
	}

	@Override
	protected Object damageSourceFallingBlock() {
		return DamageSource.fallingBlock;
	}

	@Override
	protected void entityAttackEntityFrom(Object entity, Object damageSource, int i) {
		((Entity) entity).attackEntityFrom((DamageSource) damageSource, i);
	}

	@Override
	protected float entityLivingBaseGetMaxHealth(Object entity) {
		return ((EntityLivingBase) entity).getMaxHealth();
	}

	@Override
	protected float entityLivingBaseGetHealth(Object entity) {
		return ((EntityLivingBase) entity).getHealth();
	}

	@Override
	protected Enum enumCreatureAttributeUNDEFINED() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	protected Enum enumCreatureAttributeUNDEAD() {
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	protected Enum enumCreatureAttributeARTHROPOD() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	protected boolean worldIsBlockNormalCubeDefault(Object entity, int i, int j, int k, boolean b) {
		return ((Entity) entity).worldObj.isBlockNormalCubeDefault(i, j, k, b);
	}

	@Override
	protected Object entityPlayerGetFoodStats(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getFoodStats();
	}

	@Override
	protected int entityPlayerPlayerLevel(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceLevel;
	}

	@Override
	protected void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceLevel = i;
	}

	@Override
	protected int entityPlayerTotalXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceTotal;
	}

	@Override
	protected void setEntityPlayerTotalXP(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceTotal = i;
	}

	@Override
	protected float entityPlayerCurrentXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experience;
	}

	@Override
	protected float entityLivingBaseMoveForward(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveForward;
	}

	@Override
	protected float entityLivingBaseMoveStrafing(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveStrafing;
	}

	@Override
	protected void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		((EntityPlayer) entityplayer).experience = f;
	}

	@Override
	protected int entityPlayerScore(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getScore();
	}

	@Override
	protected void setEntityPlayerScore(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).setScore(i);
	}

	@Override
	protected void setEntityLivingBaseHealth(Object entity, float f) {
		((EntityLivingBase) entity).getDataWatcher().updateObject(6, Float.valueOf(MathHelper.clamp_float(f, 0.0F, entityLivingGetMaxHealth(entity))));
	}

	@Override
	protected void entityLivingBaseSetHealth(Object entity, float f) {
		((EntityLivingBase) entity).setHealth(f);
	}

	@Override
	protected int entityPlayerGetItemInUseCount(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getItemInUseCount();
	}

	@Override
	protected Object itemStackCopyItemStack(Object itemstack) {
		return ItemStack.copyItemStack((ItemStack) itemstack);
	}

	@Override
	protected Object itemStackGetItemUseAction(Object itemstack) {
		return ((ItemStack) itemstack).getItemUseAction();
	}

	@Override
	protected String[] renderBipedBipedArmorFilenamePrefix() {
		return RenderBiped.bipedArmorFilenamePrefix;
	}

	@Override
	protected int itemArmorRenderIndex(Object itemArmor) {
		return ((ItemArmor) itemArmor).renderIndex;
	}

	@Override
	protected void renderHelperEnableStandardItemLighting() {
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	protected void renderHelperDisableStandardItemLighting() {
		RenderHelper.disableStandardItemLighting();
	}

	@Override
	protected float entityLivingBasePrevRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).prevRenderYawOffset;
	}

	@Override
	protected float entityLivingBaseRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).renderYawOffset;
	}

	@Override
	protected float entityPrevRotationYaw(Object entity) {
		return ((EntityLivingBase) entity).prevRotationYaw;
	}

	@Override
	protected float entityLivingBasePrevRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).prevRotationYawHead;
	}

	@Override
	protected float entityLivingBaseRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).rotationYawHead;
	}

	@Override
	protected float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).prevLimbSwingAmount;
	}

	@Override
	protected float entityLivingBaseLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).limbSwingAmount;
	}

	@Override
	protected float entityLivingBaseLimbSwing(Object entity) {
		return ((EntityLivingBase) entity).limbSwing;
	}

	@Override
	protected float entityRotationYaw(Object entity) {
		return ((EntityLivingBase) entity).rotationYaw;
	}

	@Override
	protected float entityPrevRotationPitch(Object entity) {
		return ((EntityLivingBase) entity).prevRotationPitch;
	}

	@Override
	protected float entityRotationPitch(Object entity) {
		return ((EntityLivingBase) entity).rotationPitch;
	}

	@Override
	protected float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return ((EntityLivingBase) entity).getSwingProgress(f);
	}

	@Override
	protected String entityCloakUrl(Object entity) {
		return null;
	}

	@Override
	protected Object abstractClientPlayerGetTextureSkin(Object entity) {
		return ((AbstractClientPlayer) entity).getTextureSkin();
	}

	@Override
	protected Object abstractClientPlayerGetTextureCape(Object entity) {
		return ((AbstractClientPlayer) entity).getTextureCape();
	}

	@Override
	protected void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		((ModelBase) model).setLivingAnimations((EntityLivingBase) entity, f, f1, f2);
	}

	@Override
	protected void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		((ModelBase) model).setRotationAngles(f, f1, f2, f3, f4, f5, (EntityLivingBase) entity);
	}

	@Override
	protected boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return ((ThreadDownloadImageData) threadDownloadImageData).isTextureUploaded();
	}

	@Override
	protected boolean entityIsInvisible(Object entity) {
		return ((Entity) entity).isInvisible();
	}

	@Override
	protected Object getResource(String s) {
		return getResource(Minecraft.class, s);
	}

	@Override
	protected int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return TextureUtil.uploadTextureImage(i, (BufferedImage) bufferedimage);
	}

	@Override
	protected void textureManagerBindTexture(Object textureManager, Object o) {
		Modchu_Reflect.invokeMethod("TextureManager", "func_110577_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, textureManager, new Object[]{ o });
	}

	@Override
	protected Object renderEngine() {
		return Minecraft.getMinecraft().renderEngine;
	}

	@Override
	protected void renderEngineSetupTexture(Object bufferedimage, int i) {
	}

	@Override
	protected Object tessellatorInstance() {
		return Tessellator.instance;
	}

	@Override
	protected void tessellatorStartDrawingQuads(Object tessellator) {
		((Tessellator) tessellator).startDrawingQuads();
	}

	@Override
	protected void tessellatorStartDrawing(Object tessellator, byte by) {
		((Tessellator) tessellator).startDrawing(by);
	}

	@Override
	protected void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		((Tessellator) tessellator).setNormal(f, f2, f3);
	}

	@Override
	protected void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		((Tessellator) tessellator).setColorOpaque_I(i);
	}

	@Override
	protected void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		((Tessellator) tessellator).setColorRGBA_I(i, i2);
	}

	@Override
	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	protected void tessellatorDraw(Object tessellator) {
		((Tessellator) tessellator).draw();
	}

	@Override
	protected void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw((Tessellator) tessellator, f);
	}

	@Override
	protected Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return ((PositionTextureVertex) positionTextureVertex).setTexturePosition(f, f1);
	}

	@Override
	protected Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).vector3D;
	}

	@Override
	protected float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionX;
	}

	@Override
	protected float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionY;
	}

	@Override
	protected Object vec3Subtract(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).subtract((Vec3) vec3_2);
	}

	@Override
	protected Object vec3Normalize(Object vec3) {
		return ((Vec3) vec3).normalize();
	}

	@Override
	protected Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).crossProduct((Vec3) vec3_2);
	}

	@Override
	protected double vec3XCoord(Object vec3) {
		return ((Vec3) vec3).xCoord;
	}

	@Override
	protected double vec3YCoord(Object vec3) {
		return ((Vec3) vec3).yCoord;
	}

	@Override
	protected double vec3ZCoord(Object vec3) {
		return ((Vec3) vec3).zCoord;
	}

	@Override
	protected void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		((GuiSlot) guiSlot).registerScrollButtons(i, i2);
	}

	@Override
	protected List worldPlayerEntities(Object world) {
		return ((World) world).playerEntities;
	}

	@Override
	protected void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		((GuiScreen) guiScreen).drawScreen(i, i2, f);
	}

	@Override
	protected void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		((GuiSlot) guiSlot).drawScreen(i, i2, f);
	}

	@Override
	protected void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		((Gui) gui).drawCenteredString((FontRenderer) fontRenderer, s, i, i2, i3);
	}

	@Override
	protected String gameSettingsGetKeyDisplayString(int i) {
		return GameSettings.getKeyDisplayString(i);
	}

	@Override
	protected Object guiOptionsBackground() {
		return Gui.optionsBackground;
	}

}
