package modchu.lib.forge.mc172_180;import java.util.HashMap;import modchu.lib.Modchu_IGuiSmallButton;import modchu.lib.Modchu_IGuiSmallButtonMaster;import modchu.lib.Modchu_Main;import modchu.lib.Modchu_Reflect;import net.minecraft.client.Minecraft;import net.minecraft.client.gui.GuiButton;public class Modchu_GuiSmallButton extends GuiButton implements Modchu_IGuiSmallButton {	public Modchu_IGuiSmallButtonMaster master;	public Modchu_GuiSmallButton(HashMap<String, Object> map) {		super((Integer)map.get("Integer"), (Integer)map.get("Integer1"), (Integer)map.get("Integer2"), (Integer)map.get("Integer3"), (Integer)map.get("Integer4"), (String)map.get("String"));		map.put("base", this);		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);		//Modchu_Debug.mDebug("Modchu_GuiSmallButton instance="+instance);		master = instance instanceof Modchu_IGuiSmallButtonMaster ? (Modchu_IGuiSmallButtonMaster) instance : null;	}	@Override	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {		return master.mousePressed(par1Minecraft, par2, par3);	}	@Override	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {		super.drawButton(par1Minecraft, par2, par3);		//pflm_GuiSmallButtonMaster.setButtonPressed(field_82253_i);		master.drawButton(par1Minecraft, par2, par3);		//field_82253_i = pflm_GuiSmallButtonMaster.func_82252_a();	}	public boolean getButtonRange() {		return master.getButtonRange();	}	public boolean getButtonClick() {		return master.getButtonClick();	}	public void setButtonClick(boolean b) {		master.setButtonClick(b);	}	public boolean getButtonClickTransmission() {		return master.getButtonClickTransmission();	}	public void setButtonClickTransmission(boolean b) {		master.setButtonClickTransmission(b);	}}