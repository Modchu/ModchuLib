package modchu.lib.characteristic;import modchu.lib.Modchu_IGuiSmallButtonMaster;import modchu.lib.Modchu_Reflect;import net.minecraft.client.Minecraft;import net.minecraft.client.gui.GuiButton;import net.minecraft.client.gui.GuiScreen;public class Modchu_GuiSmallButton extends GuiButton {	public Modchu_IGuiSmallButtonMaster master;	public Modchu_GuiSmallButton(Class masterClass, GuiScreen guiscreen, int i, int x, int j, int k,			int l, String s) {		super(i, x, j, k, l, s);		Object instance = (Modchu_IGuiSmallButtonMaster) Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_GuiSmallButton.class, Object.class, int.class, int.class, int.class, int.class, int.class, String.class, Object[].class }, new Object[]{ this, guiscreen, i, x, j, k, l, s, (Object[])null });		//Modchu_Debug.mDebug("Modchu_GuiSmallButton instance="+instance);		master = instance instanceof Modchu_IGuiSmallButtonMaster ? (Modchu_IGuiSmallButtonMaster) instance : null;	}	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {		return master.mousePressed((Object) par1Minecraft, par2, par3);	}	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {		super.drawButton(par1Minecraft, par2, par3);		//pflm_GuiSmallButtonMaster.setButtonPressed(field_82253_i);		master.drawButton((Object) par1Minecraft, par2, par3);		//field_82253_i = pflm_GuiSmallButtonMaster.func_82252_a();	}	public boolean getButtonRange() {		return master.getButtonRange();	}	public boolean getButtonClick() {		return master.getButtonClick();	}	public void setButtonClick(boolean b) {		master.setButtonClick(b);	}	public boolean getButtonClickTransmission() {		return master.getButtonClickTransmission();	}	public void setButtonClickTransmission(boolean b) {		master.setButtonClickTransmission(b);	}}