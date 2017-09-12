package modchu.lib.forge.mc194_212;

import java.util.HashMap;
import java.util.List;

public class Modchu_GuiSlot extends modchu.lib.forge.mc194_221.Modchu_GuiSlot {

	public Modchu_GuiSlot(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void setShowSelectionBox(boolean p_148130_1_) {
		if (master != null) master.setShowSelectionBox(p_148130_1_);
		else super.setShowSelectionBox(p_148130_1_);
	}

	@Override
	public void superSetShowSelectionBox(boolean p_148130_1_) {
		super.setShowSelectionBox(p_148130_1_);
	}

	@Override
	protected void updateItemPos(int p_178040_1_, int p_178040_2_, int p_178040_3_) {
		if (master != null) master.updateItemPos(p_178040_1_, p_178040_2_, p_178040_3_, 0.0F);
		else super.updateItemPos(p_178040_1_, p_178040_2_, p_178040_3_);
	}

	public void superUpdateItemPos(int p_178040_1_, int p_178040_2_, int p_178040_3_) {
		super.updateItemPos(p_178040_1_, p_178040_2_, p_178040_3_);
	}

	@Override
	protected void drawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_) {
		if (master != null) master.drawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_, 0.0F);
		else super.drawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_);
	}

	public void superDrawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_) {
		super.drawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_);
	}

	@Override
	protected void drawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_) {
		if (master != null) master.drawSlot(entryID, p_180791_2_, p_180791_3_, p_180791_4_, p_180791_5_, p_180791_6_, 0.0F);
	}

	@Override
	public void superUpdateItemPos(int p_178040_1_, int p_178040_2_, int p_178040_3_, float p_192639_4_) {
		super.updateItemPos(p_178040_1_, p_178040_2_, p_178040_3_);
	}

	@Override
	public void superDrawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_, float p_192638_5_) {
		superDrawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_);
	}

	@Override
	public void superDrawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_, float p_192637_7_) {
		superDrawSlot(entryID, p_180791_2_, p_180791_3_, p_180791_4_, p_180791_5_);
	}

	@Override
	public void superRegisterScrollButtons(List par1List, int par2, int par3) {
		superRegisterScrollButtons(par2,par3);
	}

}
