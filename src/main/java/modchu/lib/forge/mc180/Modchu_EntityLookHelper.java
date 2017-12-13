package modchu.lib.forge.mc180;

import java.util.HashMap;

public class Modchu_EntityLookHelper extends modchu.lib.forge.mc164_222.Modchu_EntityLookHelper {

	public Modchu_EntityLookHelper(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean func_180424_b() {
		return master != null ? master.getIsLooking() : super.func_180424_b();
	}

	@Override
	public boolean superGetIsLooking() {
		return super.func_180424_b();
	}

	@Override
	public double func_180423_e() {
		return master != null ? master.getLookPosX() : super.func_180423_e();
	}

	@Override
	public double superGetLookPosX() {
		return super.func_180423_e();
	}

	@Override
	public double func_180422_f() {
		return master != null ? master.getLookPosY() : super.func_180422_f();
	}

	@Override
	public double superGetLookPosY() {
		return super.func_180422_f();
	}

	@Override
	public double func_180421_g() {
		return master != null ? master.getLookPosZ() : super.func_180421_g();
	}

	@Override
	public double superGetLookPosZ() {
		return super.func_180421_g();
	}

}
