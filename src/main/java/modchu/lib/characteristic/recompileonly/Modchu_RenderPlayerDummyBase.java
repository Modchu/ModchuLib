package modchu.lib.characteristic.recompileonly;import modchu.lib.Modchu_IRenderPlayerMaster;import net.minecraft.client.model.ModelBase;import net.minecraft.client.renderer.entity.RenderLiving;import net.minecraft.client.renderer.entity.RenderManager;import net.minecraft.entity.Entity;public abstract class Modchu_RenderPlayerDummyBase extends RenderLiving {	public static Modchu_IRenderPlayerMaster master;	public Modchu_RenderPlayerDummyBase(ModelBase par1ModelBase, float par2) {		super(par1ModelBase, par2);	}	public abstract void superDoRenderLiving(Entity entity, double d, double d1, double d2, float f, float f1);	public abstract void allModelInit(Entity entity, boolean debug);	public abstract ModelBase getRenderPassModel();	public abstract RenderManager getRenderManager();}