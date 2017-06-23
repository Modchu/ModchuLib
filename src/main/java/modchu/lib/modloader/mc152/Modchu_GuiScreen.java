package modchu.lib.modloader.mc152;import java.util.HashMap;import java.util.List;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IGuiScreen;import modchu.lib.Modchu_IGuiScreenMaster;import modchu.lib.Modchu_Main;import net.minecraft.client.Minecraft;import net.minecraft.src.FontRenderer;import net.minecraft.src.GuiButton;import net.minecraft.src.GuiScreen;import net.minecraft.src.Icon;public class Modchu_GuiScreen extends GuiScreen implements Modchu_IGuiScreen {
	public Modchu_IGuiScreenMaster master;	public Modchu_GuiScreen(HashMap<String, Object> map) {
		super();
		Modchu_Debug.lDebug("Modchu_GuiScreen init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.lDebug("Modchu_GuiScreen instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IGuiScreenMaster ? (Modchu_IGuiScreenMaster) instance : null;
		if (master != null); else throw new RuntimeException("Modchu_GuiScreen master null !!");
	}	@Override	public void initGui() {
		master.initGui();
	}	@Override	public Object getFontRenderer() {
		return master.getFontRenderer();
	}	@Override	public void setFontRenderer(Object fontRenderer) {
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
	}	@Override	public void superDrawScreen(int i, int j, float f) {
		super.drawScreen(i, j, f);
	}	@Override
	public void onGuiClosed() {
		master.onGuiClosed();
	}	@Override	public void superOnGuiClosed() {
		super.onGuiClosed();
	}	@Override
	public void handleMouseInput() {
		master.handleMouseInput();
	}	@Override	public void superHandleMouseInput() {
		super.handleMouseInput();
	}	@Override
	protected void keyTyped(char c, int i) {
		master.keyTyped(c, i);
	}	@Override	public void superKeyTyped(char c, int i) {
		super.keyTyped(c, i);
	}	@Override
	public void mouseClicked(int x, int y, int i) {
		master.mouseClicked(x, y, i);
	}	@Override	public void superMouseClicked(int x, int y, int i) {
		super.mouseClicked(x, y, i);
	}	@Override
	protected void func_85041_a(int mouseX, int mouseY, int clickButton, long time) {
		master.mouseClickMove(mouseX, mouseY, clickButton, time);
	}	@Override	public void superMouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		super.func_85041_a(mouseX, mouseY, clickButton, time);
	}	@Override
	protected void mouseMovedOrUp(int mouseX, int mouseY, int clickButton) {
		master.mouseMovedOrUp(mouseX, mouseY, clickButton);
	}	@Override	public void superMouseMovedOrUp(int mouseX, int mouseY, int clickButton) {
		super.mouseMovedOrUp(mouseX, mouseY, clickButton);
	}	@Override
	public boolean doesGuiPauseGame() {
		return master.doesGuiPauseGame();
	}	@Override	public boolean superDoesGuiPauseGame() {
		return super.doesGuiPauseGame();
	}	@Override
	public void superMouseReleased(int mouseX, int mouseY, int clickButton) {
		superMouseMovedOrUp(mouseX, mouseY, clickButton);
	}	@Override	public void setWorldAndResolution(Minecraft minecraft, int par2, int par3) {		if (master != null) master.setWorldAndResolution(minecraft, par2, par3);		else super.setWorldAndResolution(minecraft, par2, par3);	}	@Override	public void superSetWorldAndResolution(Object minecraft, int par2, int par3) {		super.setWorldAndResolution((Minecraft) minecraft, par2, par3);	}	@Override	public void handleInput() {		if (master != null) master.handleInput();		else super.handleInput();	}	@Override	public void superHandleInput() {		super.handleInput();	}	@Override	public void handleKeyboardInput() {		if (master != null) master.handleKeyboardInput();		else super.handleKeyboardInput();	}	@Override	public void superHandleKeyboardInput() {		super.handleKeyboardInput();	}	@Override	public void drawDefaultBackground() {		if (master != null) master.drawDefaultBackground();		else super.drawDefaultBackground();	}	@Override	public void superDrawDefaultBackground() {		super.drawDefaultBackground();	}	@Override	public void drawWorldBackground(int par1) {		if (master != null) master.drawWorldBackground(par1);		else super.drawWorldBackground(par1);	}	@Override	public void superDrawWorldBackground(int par1) {		super.drawWorldBackground(par1);	}	@Override	public void drawBackground(int par1) {		if (master != null) master.drawBackground(par1);		else super.drawBackground(par1);	}	@Override	public void superDrawBackground(int par1) {		super.drawBackground(par1);	}	@Override	public void confirmClicked(boolean par1, int par2) {		if (master != null) master.confirmClicked(par1, par2);		else super.confirmClicked(par1, par2);	}	@Override	public void superConfirmClicked(boolean par1, int par2) {		super.confirmClicked(par1, par2);	}	@Override	protected void drawHorizontalLine(int par1, int par2, int par3, int par4) {		if (master != null) master.drawHorizontalLine(par1, par2, par3, par4);		else super.drawHorizontalLine(par1, par2, par3, par4);	}	@Override	public void superDrawHorizontalLine(int par1, int par2, int par3, int par4) {		super.drawHorizontalLine(par1, par2, par3, par4);	}	@Override	protected void drawVerticalLine(int par1, int par2, int par3, int par4) {		if (master != null) master.drawVerticalLine(par1, par2, par3, par4);		else super.drawVerticalLine(par1, par2, par3, par4);	}	@Override	public void superDrawVerticalLine(int par1, int par2, int par3, int par4) {		super.drawVerticalLine(par1, par2, par3, par4);	}	@Override	protected void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {		if (master != null) master.drawGradientRect(par1, par2, par3, par4, par5, par6);		else super.drawGradientRect(par1, par2, par3, par4, par5, par6);	}	@Override	public void superDrawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {		super.drawGradientRect(par1, par2, par3, par4, par5, par6);	}	@Override	public void drawCenteredString(FontRenderer fontRenderer, String par2Str, int par3, int par4, int par5) {		if (master != null) master.drawCenteredString(fontRenderer, par2Str, par3, par4, par5);		else super.drawCenteredString(fontRenderer, par2Str, par3, par4, par5);	}	@Override	public void superDrawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {		super.drawCenteredString((FontRenderer) fontRenderer, par2Str, par3, par4, par5);	}	@Override	public void drawString(FontRenderer fontRenderer, String par2Str, int par3, int par4, int par5) {		if (master != null) master.drawString(fontRenderer, par2Str, par3, par4, par5);		else super.drawString(fontRenderer, par2Str, par3, par4, par5);	}	@Override	public void superDrawString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {		super.drawString((FontRenderer) fontRenderer, par2Str, par3, par4, par5);	}	@Override	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {		if (master != null) master.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);		else super.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);	}	@Override	public void superDrawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {		super.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);	}	@Override	public void drawTexturedModelRectFromIcon(int par1, int par2, Icon icon, int par4, int par5) {		if (master != null) master.drawTexturedModelRectFromIcon(par1, par2, icon, par4, par5);		else super.drawTexturedModelRectFromIcon(par1, par2, icon, par4, par5);	}	@Override	public void superDrawTexturedModelRectFromIcon(int par1, int par2, Object icon, int par4, int par5) {		super.drawTexturedModelRectFromIcon(par1, par2, (Icon) icon, par4, par5);	}	@Override	public Object superGetFontRenderer() {		return fontRenderer;	}	@Override	public void superSetFontRenderer(Object o) {		fontRenderer = (FontRenderer) o;	}	@Override	public void superDrawString(String s, int i, int j, int k) {		super.drawString(fontRenderer, s, i, j, k);	}	@Override	public void superUpdateScreen() {		super.updateScreen();	}	@Override	public void superActionPerformed(Object guibutton) {		super.actionPerformed((GuiButton) guibutton);	}	@Override	public void superRenderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_) {	}	@Override	public void superDrawHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_) {	}	@Override	public void superFunc_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {	}	@Override	public void superDrawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer) {	}	@Override	public void superDrawHoveringText(List textLines, int x, int y) {	}	@Override	public void superHandleComponentHover(Object iChatComponent, int p_175272_2_, int p_175272_3_) {	}	@Override	public void superSetText(String newChatText, boolean shouldOverwrite) {	}	@Override	public boolean superHandleComponentClick(Object iChatComponent) {		return false;	}	@Override	public void superSendChatMessage(String msg) {	}	@Override	public void superSendChatMessage(String msg, boolean addToChat) {	}	@Override	public void superOnResize(Object minecraft, int p_175273_2_, int p_175273_3_) {	}	@Override	public void superDrawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {	}	@Override	public void superDrawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_) {	}	@Override	public void superSetGuiSize(int w, int h) {	}	@Override	public Object superAddButton(Object buttonIn) {		return null;	}	@Override	public List superGetItemToolTip(Object itemStack) {		return null;	}	@Override	public void superSetFocused(boolean hasFocusedControlIn) {	}	@Override	public boolean superIsFocused() {		return false;	}}