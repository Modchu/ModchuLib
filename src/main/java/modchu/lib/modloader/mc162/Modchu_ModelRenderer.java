package modchu.lib.modloader.mc162;import java.util.HashMap;import modchu.lib.Modchu_IModelRenderer;import modchu.lib.Modchu_IModelRendererMaster;import modchu.lib.Modchu_Reflect;import net.minecraft.src.ModelBase;import net.minecraft.src.ModelRenderer;public class Modchu_ModelRenderer extends ModelRenderer implements Modchu_IModelRenderer {	public Modchu_IModelRendererMaster master;	public static Class defaultMasterClass;	public Modchu_ModelRenderer(ModelBase modelBase) {		super(modelBase);		init(null);	}	public Modchu_ModelRenderer(ModelBase modelBase, String s) {		super(modelBase, s);		init(null);	}	public Modchu_ModelRenderer(ModelBase modelBase, int i, int i1) {		super(modelBase, i, i1);		init(null);	}	public Modchu_ModelRenderer(ModelBase modelBase, int i, int i1, String s) {		super(modelBase, s);		setTextureOffset(i, i1);		init(null);	}	public void init(Class masterClass) {		if (masterClass != null) ;else masterClass = defaultMasterClass;		if (masterClass != null); else throw new RuntimeException("Modchu_ModelRenderer init masterClass null !!");		HashMap<String, Object> map = new HashMap();		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_IModelRenderer.class, HashMap.class }, new Object[]{ this, map });		//Modchu_Debug.mDebug("Modchu_ModelRenderer instance="+instance);		master = instance instanceof Modchu_IModelRendererMaster ? (Modchu_IModelRendererMaster) instance : null;		if (master != null); else throw new RuntimeException("Modchu_ModelRenderer init master null !! masterClass=" + masterClass);	}	@Override	public Modchu_IModelRendererMaster getMaster() {		return master;	}	@Override	public void setMaster(Modchu_IModelRendererMaster modchu_IModelRendererMaster) {		master = modchu_IModelRendererMaster;	}	@Override	public void addChild(ModelRenderer modelRenderer) {		if (master != null) master.addChild(modelRenderer);		else super.addChild(modelRenderer);	}	@Override	public void superAddChild(Object modelRenderer) {		super.addChild((ModelRenderer) modelRenderer);	}	@Override	public ModelRenderer setTextureOffset(int p_78784_1_, int p_78784_2_) {		return (ModelRenderer) (master != null ? master.setTextureOffset(p_78784_1_, p_78784_2_) : super.setTextureOffset(p_78784_1_, p_78784_2_));	}	@Override	public Object superSetTextureOffset(int p_78784_1_, int p_78784_2_) {		return super.setTextureOffset(p_78784_1_, p_78784_2_);	}	@Override	public ModelRenderer addBox(String p_78786_1_, float p_78786_2_, float p_78786_3_, float p_78786_4_, int p_78786_5_, int p_78786_6_, int p_78786_7_) {		return (ModelRenderer) (master != null ? master.addBox(p_78786_1_, p_78786_2_, p_78786_3_, p_78786_4_, p_78786_5_, p_78786_6_, p_78786_7_) : super.addBox(p_78786_1_, p_78786_2_, p_78786_3_, p_78786_4_, p_78786_5_, p_78786_6_, p_78786_7_));	}	@Override	public Object superAddBox(String p_78786_1_, float p_78786_2_, float p_78786_3_, float p_78786_4_, int p_78786_5_, int p_78786_6_, int p_78786_7_) {		return super.addBox(p_78786_1_, p_78786_2_, p_78786_3_, p_78786_4_, p_78786_5_, p_78786_6_, p_78786_7_);	}	@Override	public ModelRenderer addBox(float p_78789_1_, float p_78789_2_, float p_78789_3_, int p_78789_4_, int p_78789_5_, int p_78789_6_) {		return (ModelRenderer) (master != null ? master.addBox(p_78789_1_, p_78789_2_, p_78789_3_, p_78789_4_, p_78789_5_, p_78789_6_) : super.addBox(p_78789_1_, p_78789_2_, p_78789_3_, p_78789_4_, p_78789_5_, p_78789_6_));	}	@Override	public Object superAddBox(float p_78789_1_, float p_78789_2_, float p_78789_3_, int p_78789_4_, int p_78789_5_, int p_78789_6_) {		return super.addBox(p_78789_1_, p_78789_2_, p_78789_3_, p_78789_4_, p_78789_5_, p_78789_6_);	}	@Override	public Object superAddBox(float p_178769_1_, float p_178769_2_, float p_178769_3_, int p_178769_4_, int p_178769_5_, int p_178769_6_, boolean p_178769_7_) {		return super.addBox(p_178769_1_, p_178769_2_, p_178769_3_, p_178769_4_, p_178769_5_, p_178769_6_);	}	@Override	public void addBox(float p_78790_1_, float p_78790_2_, float p_78790_3_, int p_78790_4_, int p_78790_5_, int p_78790_6_, float p_78790_7_) {		if (master != null) master.addBox(p_78790_1_, p_78790_2_, p_78790_3_, p_78790_4_, p_78790_5_, p_78790_6_, p_78790_7_);		else super.addBox(p_78790_1_, p_78790_2_, p_78790_3_, p_78790_4_, p_78790_5_, p_78790_6_, p_78790_7_);	}	@Override	public void superAddBox(float p_78790_1_, float p_78790_2_, float p_78790_3_, int p_78790_4_, int p_78790_5_, int p_78790_6_, float p_78790_7_) {		super.addBox(p_78790_1_, p_78790_2_, p_78790_3_, p_78790_4_, p_78790_5_, p_78790_6_, p_78790_7_);	}	@Override	public void setRotationPoint(float p_78793_1_, float p_78793_2_, float p_78793_3_) {		if (master != null) master.setRotationPoint(p_78793_1_, p_78793_2_, p_78793_3_);		else super.setRotationPoint(p_78793_1_, p_78793_2_, p_78793_3_);	}	@Override	public void superSetRotationPoint(float p_78793_1_, float p_78793_2_, float p_78793_3_) {		super.setRotationPoint(p_78793_1_, p_78793_2_, p_78793_3_);	}	@Override	public void render(float p_78785_1_) {		if (master != null) master.render(p_78785_1_);		else super.render(p_78785_1_);	}	@Override	public void superRender(float p_78785_1_) {		super.render(p_78785_1_);	}	@Override	public void renderWithRotation(float p_78791_1_) {		if (master != null) master.renderWithRotation(p_78791_1_);		else super.renderWithRotation(p_78791_1_);	}	@Override	public void superRenderWithRotation(float p_78791_1_) {		super.renderWithRotation(p_78791_1_);	}	@Override	public void postRender(float p_78794_1_) {		if (master != null) master.postRender(p_78794_1_);		else super.postRender(p_78794_1_);	}	@Override	public void superPostRender(float p_78794_1_) {		super.postRender(p_78794_1_);	}	@Override	public ModelRenderer setTextureSize(int p_78787_1_, int p_78787_2_) {		return (ModelRenderer) (master != null ? master.setTextureSize(p_78787_1_, p_78787_2_) : super.setTextureSize(p_78787_1_, p_78787_2_));	}	@Override	public Object superSetTextureSize(int p_78787_1_, int p_78787_2_) {		return super.setTextureSize(p_78787_1_, p_78787_2_);	}}