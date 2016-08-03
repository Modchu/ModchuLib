package modchu.lib.forge.mc164;
import modchu.lib.Modchu_IGuiScreen;
import modchu.lib.Modchu_IGuiScreenMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
	public Modchu_IGuiScreenMaster master;
		super();
		Modchu_Debug.lDebug("Modchu_GuiScreen init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.lDebug("Modchu_GuiScreen instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IGuiScreenMaster ? (Modchu_IGuiScreenMaster) instance : null;
		if (master != null); else throw new RuntimeException("Modchu_GuiScreen master null !!");
	}
		master.initGui();
	}
		return master.getFontRenderer();
	}
		master.setFontRenderer(fontRenderer);
	}
	protected void actionPerformed(GuiButton guibutton) {
		master.actionPerformed(guibutton);
	}
	public void updateScreen() {
		master.updateScreen();
	}
	public void drawScreen(int i, int j, float f) {
		master.drawScreen(i, j, f);
	}
		super.drawScreen(i, j, f);
	}
	public void onGuiClosed() {
		master.onGuiClosed();
	}
		super.onGuiClosed();
	}
	public void handleMouseInput() {
		master.handleMouseInput();
	}
		try {
			super.handleMouseInput();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void keyTyped(char c, int i) {
		master.keyTyped(c, i);
	}
		try {
			super.keyTyped(c, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void mouseClicked(int x, int y, int i) {
		master.mouseClicked(x, y, i);
	}
		try {
			super.mouseClicked(x, y, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void mouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		master.mouseClickMove(mouseX, mouseY, clickButton, time);
	}
		super.mouseClickMove(mouseX, mouseY, clickButton, time);
	}
	protected void mouseMovedOrUp(int mouseX, int mouseY, int clickButton) {
		master.mouseReleased(mouseX, mouseY, clickButton);
	}
		super.mouseMovedOrUp(mouseX, mouseY, clickButton);
	}
	public boolean doesGuiPauseGame() {
		return master.doesGuiPauseGame();
	}
		return super.doesGuiPauseGame();
	}
		superMouseMovedOrUp(mouseX, mouseY, clickButton);
	}