package modchu.lib.forge.mc162;
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
		super.handleMouseInput();
	}
	protected void keyTyped(char c, int i) {
		master.keyTyped(c, i);
	}
		super.keyTyped(c, i);
	}
	public void mouseClicked(int x, int y, int i) {
		master.mouseClicked(x, y, i);
	}
		super.mouseClicked(x, y, i);
	}
	protected void mouseClickMove(int mouseX, int mouseY, int clickButton, long time) {
		master.mouseClickMove(mouseX, mouseY, clickButton, time);
	}
		super.mouseClickMove(mouseX, mouseY, clickButton, time);
	}
	protected void mouseMovedOrUp(int mouseX, int mouseY, int clickButton) {
		master.mouseMovedOrUp(mouseX, mouseY, clickButton);
	}
		super.mouseMovedOrUp(mouseX, mouseY, clickButton);
	}
	public boolean doesGuiPauseGame() {
		return master.doesGuiPauseGame();
	}
		return super.doesGuiPauseGame();
	}
	public void superMouseReleased(int mouseX, int mouseY, int clickButton) {
		superMouseMovedOrUp(mouseX, mouseY, clickButton);
	}