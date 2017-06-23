package modchu.lib.forge.mc220;

import java.util.HashMap;
import java.util.List;

public class Modchu_GuiSlot extends modchu.lib.forge.mc194_220.Modchu_GuiSlot {

	public Modchu_GuiSlot(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	protected void updateItemPos(int p_178040_1_, int p_178040_2_, int p_178040_3_, float p_192639_4_) {
		if (master != null) master.updateItemPos(p_178040_1_, p_178040_2_, p_178040_3_, p_192639_4_);
		else super.updateItemPos(p_178040_1_, p_178040_2_, p_178040_3_, p_192639_4_);
	}

	@Override
	public void superUpdateItemPos(int p_178040_1_, int p_178040_2_, int p_178040_3_, float p_192639_4_) {
		super.updateItemPos(p_178040_1_, p_178040_2_, p_178040_3_, p_192639_4_);
	}

	@Override
	protected void drawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_, float p_192638_5_) {
		if (master != null) master.drawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_, p_192638_5_);
		else super.drawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_, p_192638_5_);
	}

	@Override
	public void superDrawSelectionBox(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_, float p_192638_5_) {
		super.drawSelectionBox(p_148120_1_, p_148120_2_, p_148120_3_, p_148120_4_, p_192638_5_);
	}

	@Override
	protected void drawSlot(int entryID, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_, float p_192637_7_) {
		if (master != null) master.drawSlot(entryID, p_180791_2_, p_180791_3_, p_180791_4_, p_180791_5_, p_180791_6_, p_192637_7_);
	}

}
