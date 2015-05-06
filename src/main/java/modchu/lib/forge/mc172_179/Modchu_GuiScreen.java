package modchu.lib.forge.mc172_179;import java.util.HashMap;import java.util.List;import modchu.lib.Modchu_Debug;import modchu.lib.Modchu_IGuiScreen;import modchu.lib.Modchu_IGuiScreenMaster;import modchu.lib.Modchu_Main;import net.minecraft.client.Minecraft;import net.minecraft.client.gui.FontRenderer;import net.minecraft.client.gui.GuiButton;import net.minecraft.client.gui.GuiScreen;import net.minecraft.item.ItemStack;import net.minecraft.util.IIcon;public class Modchu_GuiScreen extends GuiScreen implements Modchu_IGuiScreen {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	@Override
	protected void keyTyped(char c, int i) {
		master.keyTyped(c, i);
	}	public void superKeyTyped(char c, int i) {
		try {
			super.keyTyped(c, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	@Override
	public void mouseClicked(int x, int y, int i) {
		master.mouseClicked(x, y, i);
	}	public void superMouseClicked(int x, int y, int i) {
		try {
			super.mouseClicked(x, y, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		master.mouseClickMove(mouseX, mouseY, clickButton, time);
	}	public void superMouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		super.mouseClickMove(mouseX, mouseY, clickButton, time);
	}	@Override
	protected void mouseMovedOrUp(int mouseX, int mouseY, int clickButton) {
		master.mouseReleased(mouseX, mouseY, clickButton);
	}	public void superMouseMovedOrUp(int mouseX, int mouseY, int clickButton) {
		super.mouseMovedOrUp(mouseX, mouseY, clickButton);
	}	@Override
	public boolean doesGuiPauseGame() {
		return master.doesGuiPauseGame();
	}	public boolean superDoesGuiPauseGame() {
		return super.doesGuiPauseGame();
	}	public void superMouseReleased(int mouseX, int mouseY, int clickButton) {
		superMouseMovedOrUp(mouseX, mouseY, clickButton);
	}	@Override	protected void renderToolTip(ItemStack itemStack, int p_146285_2_, int p_146285_3_) {		if (master != null) master.renderToolTip(itemStack, p_146285_2_, p_146285_3_);		else super.renderToolTip(itemStack, p_146285_2_, p_146285_3_);	}	public void superRenderToolTip(Object itemStack, int p_146285_2_, int p_146285_3_) {		super.renderToolTip((ItemStack) itemStack, p_146285_2_, p_146285_3_);	}	@Override	protected void drawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_) {		if (master != null) master.drawCreativeTabHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);		else super.drawCreativeTabHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);	}	public void superDrawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_) {		super.drawCreativeTabHoveringText(p_146279_1_, p_146279_2_, p_146279_3_);	}	@Override	protected void func_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {		if (master != null) master.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);		else super.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);	}	public void superFunc_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {		super.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);	}	@Override	protected void drawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, FontRenderer fontRenderer) {		if (master != null) master.drawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, fontRenderer);		else super.drawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, fontRenderer);	}	public void superDrawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, Object fontRenderer) {		super.drawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, (FontRenderer) fontRenderer);	}	@Override	public void setWorldAndResolution(Minecraft minecraft, int p_146280_2_, int p_146280_3_) {		if (master != null) master.setWorldAndResolution(minecraft, p_146280_2_, p_146280_3_);		else super.setWorldAndResolution(minecraft, p_146280_2_, p_146280_3_);	}	public void superSetWorldAndResolution(Object minecraft, int p_146280_2_, int p_146280_3_) {		super.setWorldAndResolution((Minecraft) minecraft, p_146280_2_, p_146280_3_);	}	@Override	public void handleInput() {		if (master != null) master.handleInput();		else super.handleInput();	}	public void superHandleInput() {		super.handleInput();	}	@Override	public void handleKeyboardInput() {		if (master != null) master.handleKeyboardInput();		else super.handleKeyboardInput();	}	public void superHandleKeyboardInput() {		super.handleKeyboardInput();	}	@Override	public void drawDefaultBackground() {		if (master != null) master.drawDefaultBackground();		else super.drawDefaultBackground();	}	public void superDrawDefaultBackground() {		super.drawDefaultBackground();	}	@Override	public void drawWorldBackground(int p_146270_1_) {		if (master != null) master.drawWorldBackground(p_146270_1_);		else super.drawWorldBackground(p_146270_1_);	}	public void superDrawWorldBackground(int p_146270_1_) {		super.drawWorldBackground(p_146270_1_);	}	@Override	public void drawBackground(int p_146278_1_) {		if (master != null) master.drawBackground(p_146278_1_);		else super.drawBackground(p_146278_1_);	}	public void superDrawBackground(int p_146278_1_) {		super.drawBackground(p_146278_1_);	}	@Override	public void confirmClicked(boolean par1, int par2) {		if (master != null) master.confirmClicked(par1, par2);		else super.confirmClicked(par1, par2);	}	public void superConfirmClicked(boolean par1, int par2) {		super.confirmClicked(par1, par2);	}	@Override	protected void drawHorizontalLine(int par1, int par2, int par3, int par4) {		if (master != null) master.drawHorizontalLine(par1, par2, par3, par4);		else super.drawHorizontalLine(par1, par2, par3, par4);	}	public void superDrawHorizontalLine(int par1, int par2, int par3, int par4) {		super.drawHorizontalLine(par1, par2, par3, par4);	}	@Override	protected void drawVerticalLine(int par1, int par2, int par3, int par4) {		if (master != null) master.drawVerticalLine(par1, par2, par3, par4);		else super.drawVerticalLine(par1, par2, par3, par4);	}	public void superDrawVerticalLine(int par1, int par2, int par3, int par4) {		super.drawVerticalLine(par1, par2, par3, par4);	}	@Override	protected void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {		if (master != null) master.drawGradientRect(par1, par2, par3, par4, par5, par6);		else super.drawGradientRect(par1, par2, par3, par4, par5, par6);	}	public void superDrawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {		super.drawGradientRect(par1, par2, par3, par4, par5, par6);	}	@Override	public void drawCenteredString(FontRenderer fontRenderer, String par2Str, int par3, int par4, int par5) {		if (master != null) master.drawCenteredString(fontRenderer, par2Str, par3, par4, par5);		else super.drawCenteredString(fontRenderer, par2Str, par3, par4, par5);	}	public void superDrawCenteredString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {		super.drawCenteredString((FontRenderer) fontRenderer, par2Str, par3, par4, par5);	}	@Override	public void drawString(FontRenderer fontRenderer, String par2Str, int par3, int par4, int par5) {		if (master != null) master.drawString(fontRenderer, par2Str, par3, par4, par5);		else super.drawString(fontRenderer, par2Str, par3, par4, par5);	}	public void superDrawString(Object fontRenderer, String par2Str, int par3, int par4, int par5) {		super.drawString((FontRenderer) fontRenderer, par2Str, par3, par4, par5);	}	@Override	public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {		if (master != null) master.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);		else super.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);	}	public void superDrawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {		super.drawTexturedModalRect(par1, par2, par3, par4, par5, par6);	}	@Override	public void drawTexturedModelRectFromIcon(int par1, int par2, IIcon iIcon, int par4, int par5) {		if (master != null) master.drawTexturedModelRectFromIcon(par1, par2, iIcon, par4, par5);		else super.drawTexturedModelRectFromIcon(par1, par2, iIcon, par4, par5);	}	public void superDrawTexturedModelRectFromIcon(int par1, int par2, Object iIcon, int par4, int par5) {		super.drawTexturedModelRectFromIcon(par1, par2, (IIcon) iIcon, par4, par5);	}	@Override	public Object superGetFontRenderer() {		return fontRendererObj;	}	@Override	public void superSetFontRenderer(Object o) {		fontRendererObj = (FontRenderer) o;	}	@Override	public void superDrawString(String s, int i, int j, int k) {		super.drawString(fontRendererObj, s, i, j, k);	}	@Override	public void superUpdateScreen() {		super.updateScreen();	}	@Override	public void superActionPerformed(Object guibutton) {		super.actionPerformed((GuiButton) guibutton);	}	@Override	public void superDrawHoveringText(List textLines, int x, int y) {	}	@Override	public void superFunc_175272_a(Object iChatComponent, int p_175272_2_, int p_175272_3_) {	}	@Override	public void superSetText(String newChatText, boolean shouldOverwrite) {	}	@Override	public boolean superFunc_175276_a(Object iChatComponent) {		return false;	}	@Override	public void superSendChatMessage(String msg) {	}	@Override	public void superSendChatMessage(String msg, boolean addToChat) {	}	@Override	public void superFunc_175273_b(Object minecraft, int p_175273_2_, int p_175273_3_) {	}	@Override	public void superDrawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {	}	@Override	public void superDrawTexturedModalRect(int xCoord, int yCoord, Object textureAtlasSprite, int p_175175_4_, int p_175175_5_) {	}}