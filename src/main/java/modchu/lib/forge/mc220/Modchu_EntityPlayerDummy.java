package modchu.lib.forge.mc220;import java.util.HashMap;import net.minecraft.util.DamageSource;import net.minecraft.util.SoundEvent;import net.minecraft.world.World;public class Modchu_EntityPlayerDummy extends modchu.lib.forge.mc190_220.Modchu_EntityPlayerDummy {	public Modchu_EntityPlayerDummy(World world) {		super(world);	}	public Modchu_EntityPlayerDummy(HashMap<String, Object> map) {		super(map);	}	@Override	public void func_191986_a(float par1, float par2, float par3) {		if (master != null) master.moveEntityWithHeading(par1, par2, par3);		else super.func_191986_a(par1, par2, par3);	}	@Override	public void superMoveEntityWithHeading(float par1, float par2, float par3) {		super.func_191986_a(par1, par2, par3);	}	@Override	public SoundEvent getHurtSound(DamageSource damageSource) {		if (master != null) return (SoundEvent) master.getHurtSound(damageSource);		return super.getHurtSound(damageSource);	}}