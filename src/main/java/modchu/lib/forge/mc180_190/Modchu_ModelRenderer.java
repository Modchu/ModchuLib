package modchu.lib.forge.mc180_190;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class Modchu_ModelRenderer extends modchu.lib.forge.mc172_222.Modchu_ModelRenderer {

	public Modchu_ModelRenderer(ModelBase modelBase) {
		super(modelBase);
	}

	public Modchu_ModelRenderer(ModelBase modelBase, String s) {
		super(modelBase, s);
	}

	public Modchu_ModelRenderer(ModelBase modelBase, int i, int i1) {
		super(modelBase, i, i1);
	}

	public Modchu_ModelRenderer(ModelBase modelBase, int i, int i1, String s) {
		super(modelBase, s);
	}

	@Override
	public ModelRenderer addBox(float p_178769_1_, float p_178769_2_, float p_178769_3_, int p_178769_4_, int p_178769_5_, int p_178769_6_, boolean p_178769_7_) {
		return (ModelRenderer) (master != null ? master.addBox(p_178769_1_, p_178769_2_, p_178769_3_, p_178769_4_, p_178769_5_, p_178769_6_, p_178769_7_) : super.addBox(p_178769_1_, p_178769_2_, p_178769_3_, p_178769_4_, p_178769_5_, p_178769_6_, p_178769_7_));
	}

	@Override
	public Object superAddBox(float p_178769_1_, float p_178769_2_, float p_178769_3_, int p_178769_4_, int p_178769_5_, int p_178769_6_, boolean p_178769_7_) {
		return super.addBox(p_178769_1_, p_178769_2_, p_178769_3_, p_178769_4_, p_178769_5_, p_178769_6_, p_178769_7_);
	}

}
