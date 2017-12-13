package modchu.lib.modloader.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_IEntityLookHelper;
import modchu.lib.Modchu_IEntityLookHelperMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityLookHelper;

public class Modchu_EntityLookHelper extends EntityLookHelper implements Modchu_IEntityLookHelper {
	public Modchu_IEntityLookHelperMaster master;

	public Modchu_EntityLookHelper(HashMap<String, Object> map) {
		super((EntityLiving) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityLookHelper init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityLookHelperMaster ? (Modchu_IEntityLookHelperMaster) instance : null;
	}

	@Override
	public void setLookPositionWithEntity(Entity entity, float deltaYaw, float deltaPitch) {
		if (master != null) master.setLookPositionWithEntity(entity, deltaYaw, deltaPitch);
		else super.setLookPositionWithEntity(entity, deltaYaw, deltaPitch);
	}

	@Override
	public void superSetLookPositionWithEntity(Object entity, float deltaYaw, float deltaPitch) {
		super.setLookPositionWithEntity((Entity) entity, deltaYaw, deltaPitch);
	}

	@Override
	public void setLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch) {
		if (master != null) master.setLookPosition(x, y, z, deltaYaw, deltaPitch);
		else super.setLookPosition(x, y, z, deltaYaw, deltaPitch);
	}

	@Override
	public void superSetLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch) {
		super.setLookPosition(x, y, z, deltaYaw, deltaPitch);
	}

	@Override
	public void onUpdateLook() {
		if (master != null) master.onUpdateLook();
		else super.onUpdateLook();
	}

	@Override
	public void superOnUpdateLook() {
		super.onUpdateLook();
	}

	@Override
	public boolean superGetIsLooking() {
		return Modchu_AS.getBoolean("EntityLookHelper", "isLooking", this);
	}

	@Override
	public double superGetLookPosX() {
		return Modchu_AS.getDouble("EntityLookHelper", "posX", this);
	}

	@Override
	public double superGetLookPosY() {
		return Modchu_AS.getDouble("EntityLookHelper", "posY", this);
	}

	@Override
	public double superGetLookPosZ() {
		return Modchu_AS.getDouble("EntityLookHelper", "posZ", this);
	}

}
