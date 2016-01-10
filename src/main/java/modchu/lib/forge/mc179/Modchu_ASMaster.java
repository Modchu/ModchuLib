package modchu.lib.forge.mc179;

import java.util.HashMap;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;

public class Modchu_ASMaster extends modchu.lib.forge.mc172_179.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public String entityTameableGetOwnerName(Object entityTameable) {
		return ((EntityTameable) entityTameable).func_152113_b();
	}

	@Override
	public Object nbtUtilReadGameProfileFromNBT(Object nBTTagCompound) {
		return NBTUtil.func_152459_a((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		NBTUtil.func_152460_a((NBTTagCompound) nBTTagCompound, (GameProfile) gameprofile);
		return nBTTagCompound;
	}

	@Override
	public void entityTameableSetOwner(Object entityTameable, String s) {
		((EntityTameable) entityTameable).func_152115_b(s);
	}

}