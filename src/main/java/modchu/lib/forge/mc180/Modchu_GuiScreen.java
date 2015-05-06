package modchu.lib.forge.mc180;import java.io.IOException;import java.util.HashMap;import java.util.List;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IGuiScreen;import modchu.lib.Modchu_IGuiScreenMaster;import modchu.lib.Modchu_Main;import net.minecraft.client.Minecraft;import net.minecraft.client.gui.FontRenderer;import net.minecraft.client.gui.GuiButton;import net.minecraft.client.gui.GuiScreen;import net.minecraft.client.renderer.texture.TextureAtlasSprite;import net.minecraft.item.ItemStack;import net.minecraft.util.IChatComponent;public class Modchu_GuiScreen extends GuiScreen implements Modchu_IGuiScreen {
	public Modchu_IGuiScreenMaster master;	public Modchu_GuiScreen(HashMap<String, Object> map) {
		super();
		Modchu_Debug.lDebug("Modchu_GuiScreen init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.lDebug("Modchu_GuiScreen instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IGuiScreenMaster ? (Modchu_IGuiScreenMaster) instance : null;
		if (master != null); else throw new RuntimeException("Modchu_GuiScreen master null !!");
	}	public void initGui() {
		master.initGui();
	}	public Object getFontRenderer() {
		return master.getFontRenderer();
	}	public void setFontRenderer(Object fontRenderer) {
		master.setFontRenderer(fontRenderer);
	}	@Override
	protected void actionPerformed(GuiButton guibutton) {
		master.actionPerformed(guibutton);
	}	@Override
	public void updateScreen() {
		master.updateScreen();
	}	@Override
	public void drawScreen(int i, int j, float f) {
		master.drawScreen(i, j, f);
	}	public void superDrawScreen(int i, int j, float f) {
		super.drawScreen(i, j, f);
	}	@Override
	public void onGuiClosed() {
		master.onGuiClosed();
	}	public void superOnGuiClosed() {
		super.onGuiClosed();
	}	@Override
	public void handleMouseInput() {
		master.handleMouseInput();
	}	public void superHandleMouseInput() {
		try {
			super.handleMouseInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	@Override
	protected void keyTyped(char c, int i) {
		master.keyTyped(c, i);
	}	public void superKeyTyped(char c, int i) {
		try {
			super.keyTyped(c, i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	@Override
	public void mouseClicked(int x, int y, int i) {
		master.mouseClicked(x, y, i);
	}	public void superMouseClicked(int x, int y, int i) {
		try {
			super.mouseClicked(x, y, i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		master.mouseClickMove(mouseX, mouseY, clickButton, time);
	}	public void superMouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		super.mouseClickMove(mouseX, mouseY, clickButton, time);
	}	@Override
	protected void mouseReleased(int mouseX, int mouseY, int clickButton) {
		master.mouseReleased(mouseX, mouseY, clickButton);
	}	public void superMouseReleased(int mouseX, int mouseY, int clickButton) {
		super.mouseReleased(mouseX, mouseY, clickButton);
	}	@Override
	public boolean doesGuiPauseGame() {
		return master.doesGuiPauseGame();
	}	public boolean superDoesGuiPauseGame() {
		return super.doesGuiPauseGame();
	}	@Override	protected void renderToolTip(ItemStack itemStack, int x, int y) {		if (master != null) master.renderToolTip(itemStack, x, y);		else super.renderToolTip(itemStack, x, y);	}	public void superRenderToolTip(Object itemStack, int x, int y) {		super.renderToolTip((ItemStack) itemStack, x, y);	}	@Override	protected void drawCreativeTabHoveringText(String tabName, int mouseX, int mouseY) {		if (master != null) master.drawCreativeTabHoveringText(tabName, mouseX, mouseY);		else super.drawCreativeTabHoveringText(tabName, mouseX, mouseY);	}	public void superDrawCreativeTabHoveringText(String tabName, int mouseX, int mouseY) {		super.drawCreativeTabHoveringText(tabName, mouseX, mouseY);	}	@Override	protected void drawHoveringText(List textLines, int x, int y) {		if (master != null) master.drawHoveringText(textLines, x, y);		else super.drawHoveringText(textLines, x, y);	}	public void superDrawHoveringText(List textLines, int x, int y) {		super.drawHoveringText(textLines, x, y);	}	@Override	protected void drawHoveringText(List textLines, int x, int y, FontRenderer fontRenderer) {		if (master != null) master.drawHoveringText(textLines, x, y, fontRenderer);		else super.drawHoveringText(textLines, x, y, fontRenderer);	}	public void superDrawHoveringText(List textLines, int x, int y, Object fontRenderer) {		super.drawHoveringText(textLines, x, y, (FontRenderer) fontRenderer);	}	@Override	protected void func_175272_a(IChatComponent iChatComponent, int p_175272_2_, int p_175272_3_) {		if (master != null) master.func_175272_a(iChatComponent, p_175272_2_, p_175272_3_);		else super.func_175272_a(iChatComponent, p_175272_2_, p_175272_3_);	}	public void superFunc_175272_a(Object iChatComponent, int p_175272_2_, int p_175272_3_) {		super.func_175272_a((IChatComponent) iChatComponent, p_175272_2_, p_175272_3_);	}	@Override	protected void setText(String newChatText, boolean shouldOverwrite) {		if (master != null) master.setText(newChatText, shouldOverwrite);		else super.setText(newChatText, shouldOverwrite);	}	public void superSetText(String newChatText, boolean shouldOverwrite) {		super.setText(newChatText, shouldOverwrite);	}	@Override	protected boolean func_175276_a(IChatComponent iChatComponent) {		return master != null ? master.func_175276_a(iChatComponent) : super.func_175276_a(iChatComponent);	}	public boolean superFunc_175276_a(Object iChatComponent) {		return super.func_175276_a((IChatComponent) iChatComponent);	}	@Override	public void sendChatMessage(String msg) {		if (master != null) master.sendChatMessage(msg);		else super.sendChatMessage(msg);	}	public void superSendChatMessage(String msg) {		super.sendChatMessage(msg);	}	@Override	public void sendChatMessage(String msg, boolean addToChat) {		if (master != null) master.sendChatMessage(msg, addToChat);		else super.sendChatMessage(msg, addToChat);	}	public void superSendChatMessage(String msg, boolean addToChat) {		super.sendChatMessage(msg, addToChat);	}	@Override	public void setWorldAndResolution(Minecraft minecraft, int width, int height) {		if (master != null) master.setWorldAndResolution(minecraft, width, height);		else super.setWorldAndResolution(minecraft, width, height);	}	public void superSetWorldAndResolution(Object minecraft, int width, int height) {		super.setWorldAndResolution((Minecraft) minecraft, width, height);	}	@Override	public void handleInput() throws IOException {		if (master != null) master.handleInput();		else super.handleInput();	}	public void superHandleInput() {		try {			super.handleInput();		} catch (IOException e) {			e.printStackTrace();		}	}	@Override	public void handleKeyboardInput() throws IOException {		if (master != null) master.handleKeyboardInput();		else super.handleKeyboardInput();	}	public void superHandleKeyboardInput() {		try {			super.handleKeyboardInput();		} catch (IOException e) {			e.printStackTrace();		}	}	@Override	public void drawDefaultBackground() {		if (master != null) master.drawDefaultBackground();		else super.drawDefaultBackground();	}	public void superDrawDefaultBackground() {		super.drawDefaultBackground();	}	@Override	public void drawWorldBackground(int tint) {		if (master != null) master.drawWorldBackground(tint);		else super.drawWorldBackground(tint);	}	public void superDrawWorldBackground(int tint) {		super.drawWorldBackground(tint);	}	@Override	public void drawBackground(int tint) {		if (master != null) master.drawBackground(tint);		else super.drawBackground(tint);	}	public void superDrawBackground(int tint) {		super.drawBackground(tint);	}	@Override	public void confirmClicked(boolean result, int id) {		if (master != null) master.confirmClicked(result, id);		else super.confirmClicked(result, id);	}	public void superConfirmClicked(boolean result, int id) {		super.confirmClicked(result, id);	}	@Override	public void func_175273_b(Minecraft minecraft, int p_175273_2_, int p_175273_3_) {		if (master != null) master.func_175273_b(minecraft, p_175273_2_, p_175273_3_);		else super.func_175273_b(minecraft, p_175273_2_, p_175273_3_);	}	public void superFunc_175273_b(Object minecraft, int p_175273_2_, int p_175273_3_) {		super.func_175273_b((Minecraft) minecraft, p_175273_2_, p_175273_3_);	}	@Override	protected void drawHorizontalLine(int startX, int endX, int y, int color) {		if (master != null) master.drawHorizontalLine(startX, endX, y, color);		else super.drawHorizontalLine(startX, endX, y, color);	}	public void superDrawHorizontalLine(int startX, int endX, int y, int color) {		super.drawHorizontalLine(startX, endX, y, color);	}	@Override	protected void drawVerticalLine(int x, int startY, int endY, int color) {		if (master != null) master.drawVerticalLine(x, startY, endY, color);		else super.drawVerticalLine(x, startY, endY, color);	}	public void superDrawVerticalLine(int x, int startY, int endY, int color) {		super.drawVerticalLine(x, startY, endY, color);	}	@Override	protected void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {		if (master != null) master.drawGradientRect(left, top, right, bottom, startColor, endColor);		else super.drawGradientRect(left, top, right, bottom, startColor, endColor);	}	public void superDrawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {		super.drawGradientRect(left, top, right, bottom, startColor, endColor);	}	@Override	public void drawCenteredString(FontRenderer fontRenderer, String text, int x, int y, int color) {		if (master != null) master.drawCenteredString(fontRenderer, text, x, y, color);		else super.drawCenteredString(fontRenderer, text, x, y, color);	}	public void superDrawCenteredString(Object fontRenderer, String text, int x, int y, int color) {		super.drawCenteredString((FontRenderer) fontRenderer, text, x, y, color);	}	@Override	public void drawString(FontRenderer fontRenderer, String text, int x, int y, int color) {		if (master != null) master.drawString(fontRenderer, text, x, y, color);		else super.drawString(fontRenderer, text, x, y, color);	}	public void superDrawString(Object fontRenderer, String text, int x, int y, int color) {		super.drawString((FontRenderer) fontRenderer, text, x, y, color);	}	@Override	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {		if (master != null) master.drawTexturedModalRect(x, y, textureX, textureY, width, height);		else super.drawTexturedModalRect(x, y, textureX, textureY, width, height);	}	public void superDrawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {		super.drawTexturedModalRect(x, y, textureX, textureY, width, height);	}	@Override	public void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {		if (master != null) master.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);		else super.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);	}	public void superDrawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {		super.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);	}	@Override	public void drawTexturedModalRect(int xCoord, int yCoord, TextureAtlasSprite textureAtlasSprite, int p_175175_4_, int p_175175_5_) {		if (master != null) master.drawTexturedModalRect(xCoord, yCoord, textureAtlasSprite, p_175175_4_, p_175175_5_);		else super.drawTexturedModalRect(xCoord, yCoord, textureAtlasSprite, p_175175_4_, p_175175_5_);	}	public void superDrawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_) {		super.drawTexturedModalRect(xCoord, yCoord, (TextureAtlasSprite) textureAtlasSprite, p_175175_4_, p_175175_5_);	}	@Override	public void superMouseMovedOrUp(int mouseX, int mouseY, int clickButton) {	}	@Override	public void superDrawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5) {	}	@Override	public Object superGetFontRenderer() {		return fontRendererObj;	}	@Override	public void superSetFontRenderer(Object o) {		fontRendererObj = (FontRenderer) o;	}	@Override	public void superDrawString(String s, int i, int j, int k) {		super.drawString(fontRendererObj, s, i, j, k);	}	@Override	public void superUpdateScreen() {		super.updateScreen();	}	@Override	public void superActionPerformed(Object guibutton) {		try {			super.actionPerformed((GuiButton) guibutton);		} catch (IOException e) {			e.printStackTrace();		}	}	@Override	public void superFunc_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {	}}