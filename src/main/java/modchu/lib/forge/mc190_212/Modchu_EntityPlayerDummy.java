package modchu.lib.forge.mc190_212;import java.util.HashMap;import net.minecraft.util.SoundEvent;import net.minecraft.world.World;public class Modchu_EntityPlayerDummy extends modchu.lib.forge.mc190_220.Modchu_EntityPlayerDummy {	public Modchu_EntityPlayerDummy(World world) {		super(world);	}	public Modchu_EntityPlayerDummy(HashMap<String, Object> map) {		super(map);	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) master.moveEntityWithHeading(f, f1, 0.0F);		else super.moveEntityWithHeading(f, f1);	}	@Override	public void superMoveEntityWithHeading(float f, float f1, float f2) {		super.moveEntityWithHeading(f, f1);	}	@Override	public SoundEvent getHurtSound() {		if (master != null) return (SoundEvent) master.getHurtSound(null);		return super.getHurtSound();	}}