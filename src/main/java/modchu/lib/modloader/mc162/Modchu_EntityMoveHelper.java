package modchu.lib.modloader.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityMoveHelper;
import modchu.lib.Modchu_IEntityMoveHelperMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMoveHelper;

public class Modchu_EntityMoveHelper extends EntityMoveHelper implements Modchu_IEntityMoveHelper {
	public Modchu_IEntityMoveHelperMaster master;

	public Modchu_EntityMoveHelper(HashMap<String, Object> map) {
		super((EntityLiving) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityMoveHelper init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityMoveHelperMaster ? (Modchu_IEntityMoveHelperMaster) instance : null;
	}

	@Override
	public boolean isUpdating() {
		return master != null ? master.isUpdating() : super.isUpdating();
	}

	@Override
	public boolean superIsUpdating() {
		return super.isUpdating();
	}

	@Override
	public double getSpeed() {
		return master != null ? master.getSpeed() : super.getSpeed();
	}

	@Override
	public double superGetSpeed() {
		return super.getSpeed();
	}

	@Override
	public void setMoveTo(double x, double y, double z, double speedIn) {
		if (master != null) master.setMoveTo(x, y, z, speedIn);
		else super.setMoveTo(x, y, z, speedIn);
	}

	@Override
	public void superSetMoveTo(double x, double y, double z, double speedIn) {
		super.setMoveTo(x, y, z, speedIn);
	}

	@Override
	public void onUpdateMoveHelper() {
		if (master != null) master.onUpdateMoveHelper();
		else super.onUpdateMoveHelper();
	}

	@Override
	public void superOnUpdateMoveHelper() {
		super.onUpdateMoveHelper();
	}

	@Override
	public float superLimitAngle(float sourceAngle, float targetAngle, float maximumChange) {
		return 0.0F;
	}

	@Override
	public double superGetX() {
		return Modchu_AS.getDouble("EntityMoveHelper", "posX", this);
	}

	@Override
	public double superGetY() {
		return Modchu_AS.getDouble("EntityMoveHelper", "posY", this);
	}

	@Override
	public double superGetZ() {
		return Modchu_AS.getDouble("EntityMoveHelper", "posZ", this);
	}

	@Override
	public void superStrafe(float forward, float strafe) {
	}

	@Override
	public void superRead(Object entityMoveHelper) {
	}

}
