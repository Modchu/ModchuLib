package modchu.lib.characteristic.recompileonly;import modchu.lib.Modchu_IModelPlateFreeShape;import modchu.lib.Modchu_ModelBox;import modchu.lib.Modchu_Reflect;import modchu.lib.replacepoint.Modchu_ModelRendererReplacePoint;public class Modchu_ModelPlateFreeShape extends Modchu_ModelBox {	public Modchu_IModelPlateFreeShape master;	public Modchu_ModelPlateFreeShape(Modchu_ModelRendererReplacePoint pMRenderer, Object... pArg) {		this(null, pMRenderer, (Object[])pArg);	}	public Modchu_ModelPlateFreeShape(Class masterClass, Modchu_ModelRendererReplacePoint pMRenderer, Object... pArg) {		super(pMRenderer, (Integer)pArg[0], (Integer)pArg[1], 0.0F, 0.0F, 0.0F, 0, 0, 0, (Float)pArg[6]);		if (masterClass != null) ;else masterClass = Modchu_Reflect.loadClass("modchu.model.ModchuModel_ModelPlateFreeShape");		if (masterClass != null) ;else throw new RuntimeException("Modchu_ModelPlateFreeShape init masterClass null !!");		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_ModelPlateFreeShape.class, Modchu_ModelRendererReplacePoint.class, Object[].class }, new Object[]{ this, pMRenderer, (Object[])pArg });		//Modchu_Debug.mDebug("Modchu_ModelPlateFreeShape instance="+instance);		master = instance instanceof Modchu_IModelPlateFreeShape ? (Modchu_IModelPlateFreeShape) instance : null;		if (master != null) ;else throw new RuntimeException("Modchu_ModelPlateFreeShape init master null !! masterClass=" + masterClass);	}	@Override	public void render(Object var1, float var2) {		master.render(var1, var2);	}}