package modchu.lib;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

public class Modchu_ItemSpawnEggMaster extends Modchu_ItemMasterBasis {
	public final int primaryColor;
	public final int secondaryColor;
	public HashMap<Integer, String> spawnNameMap = new HashMap();
	public Object theIcon;

	public Modchu_ItemSpawnEggMaster(HashMap<String, Object> map) {
		super(map);
		setHasSubtypes(true);
		primaryColor = (Integer) map.get("Integer1");
		secondaryColor = (Integer) map.get("Integer2");
	}

	public void setSpawn(int i, String s) {
		Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster setSpawn i="+i+" s="+s);
		spawnNameMap.put(i, s);
	}

	@Override
	public int getColorFromItemStack(Object itemStack, int par2) {
		return par2 == 0 ? primaryColor : secondaryColor;
	}

	@Override
	public String getItemStackDisplayName(Object itemStack) {
		String s = getUnlocalizedName();
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster getItemStackDisplayName 1 s="+s);
		int version = Modchu_Main.getMinecraftVersion();
		s = Modchu_AS.getString(version > 189 ? "net.minecraft.util.text.translation.I18n" : "StatCollector", "translateToLocal", new Class[]{ String.class }, new Object[]{ s + ".name" });
		//Modchu_Debug.mDebug("2 s="+s);
		s = s != null ? s.trim() : null;
		//Modchu_Debug.mDebug("3 s="+s);
		//String s1 = Modchu_CastHelper.String(Modchu_AS.getMap(Modchu_AS.entityListClassToStringMapping).get(spawEntityClass));
		//Modchu_Debug.mDebug("4 s1="+s1);
		//if (s1 != null) s = s + " " + Modchu_AS.getString("StatCollector", "translateToLocal", new Class[]{ String.class }, new Object[]{ "entity." + s1 + ".name" });
		//Modchu_Debug.mDebug("5 s="+s);
		return s;
	}

	@Override
	public boolean onItemUse(Object itemStack, Object entityPlayer, Object world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, world)) {
			return true;
		} else {
			Object block = Modchu_AS.get(Modchu_AS.worldGetBlock, world, par4, par5, par6);
			par4 += Modchu_AS.getIntArray("Facing", "offsetsXForSide")[par7];
			par5 += Modchu_AS.getIntArray("Facing", "offsetsYForSide")[par7];
			par6 += Modchu_AS.getIntArray("Facing", "offsetsZForSide")[par7];
			double d0 = 0.0D;

			if (par7 == 1
					&& Modchu_AS.getInt(Modchu_AS.blockGetRenderType, block) == 11) {
				d0 = 0.5D;
			}

			Object entity = spawnCreature(world, Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemStack), (double) par4 + 0.5D, (double) par5 + d0, (double) par6 + 0.5D);

			if (entity != null) {
				if (Modchu_Reflect.loadClass("EntityLivingBase").isInstance(entity)
						&& Modchu_AS.getBoolean(Modchu_AS.itemStackHasDisplayName, itemStack)) {
					Modchu_AS.set(Modchu_AS.entitySetCustomNameTag, entity, Modchu_AS.getString(Modchu_AS.itemStackGetDisplayName, itemStack));
				}

				if (!Modchu_AS.getBoolean(Modchu_AS.entityPlayerCapabilitiesIsCreativeMode, entityPlayer)) {
					Modchu_AS.set(Modchu_AS.itemStackStackSize, itemStack, Modchu_AS.getInt(Modchu_AS.itemStackStackSize, itemStack) - 1);
				}
			}

			return true;
		}
	}

	@Override
	public Object onItemRightClick(Object itemStack, Object world, Object entityPlayer) {
		return onItemRightClick(itemStack, world, entityPlayer, null);
	}

	@Override
	public Object onItemRightClick(Object itemStack, Object world, Object entityPlayer, Object enumHand) {
		int version = Modchu_Main.getMinecraftVersion();
		boolean flag = version > 189;
		if (Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, world)) {
			Object actionResult = flag ? Modchu_Reflect.newInstance("ActionResult", new Class[]{ Modchu_Reflect.loadClass("EnumActionResult"), Object.class }, new Object[]{ Modchu_AS.getEnum("EnumActionResult", "SUCCESS"), itemStack }) : itemStack;
			return actionResult;
		}
		Object movingObjectPosition = rayTrace(world, entityPlayer, true);
		if (movingObjectPosition != null) {
			if (Modchu_AS.getEnum(Modchu_AS.movingObjectPositionTypeOfHit, movingObjectPosition) == Modchu_AS.getEnum(Modchu_AS.movingObjectPositionMovingObjectTypeBLOCK, movingObjectPosition)) {
				int i = Modchu_AS.getInt(Modchu_AS.movingObjectPositionBlockPosGetX, movingObjectPosition);
				int j = Modchu_AS.getInt(Modchu_AS.movingObjectPositionBlockPosGetY, movingObjectPosition);
				int k = Modchu_AS.getInt(Modchu_AS.movingObjectPositionBlockPosGetZ, movingObjectPosition);
				boolean canMineBlock = version > 179 ? Modchu_AS.getBoolean("World", "isBlockModifiable", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), Modchu_Reflect.loadClass("BlockPos") }, world, new Object[]{ entityPlayer, Modchu_AS.get(Modchu_AS.newBlockPos, i, j, k) }) : Modchu_AS.getBoolean("World", "canMineBlock", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), int.class, int.class, int.class }, world, new Object[]{ entityPlayer, i, j, k });
				if (!canMineBlock) {
					return itemStack;
				}
				boolean canPlayerEdit = version > 179 ? Modchu_AS.getBoolean("EntityPlayer", "canPlayerEdit", new Class[]{ Modchu_Reflect.loadClass("BlockPos"), Modchu_Reflect.loadClass("EnumFacing"), Modchu_Reflect.loadClass("ItemStack") }, entityPlayer, new Object[]{ Modchu_AS.get(Modchu_AS.newBlockPos, i, j, k), Modchu_AS.get(version > 189 ? "RayTraceResult" : "MovingObjectPosition", "sideHit", movingObjectPosition), itemStack }) :
					Modchu_AS.getBoolean("EntityPlayer", "canPlayerEdit", new Class[]{ int.class, int.class, int.class, int.class, Modchu_Reflect.loadClass("ItemStack") }, entityPlayer, new Object[]{ i, j, k, Modchu_AS.getInt("MovingObjectPosition", "sideHit", movingObjectPosition), itemStack });
				if (!canPlayerEdit) {
					return itemStack;
				}
				Object block = Modchu_AS.get(Modchu_AS.worldGetBlock, world, i, j, k);
				Object entity = spawnCreature(world, Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemStack), (double) i, (double) j, (double) k);
				if (entity != null) {
					if (Modchu_Reflect.loadClass("EntityLivingBase").isInstance(entity)
							&& Modchu_AS.getBoolean(Modchu_AS.itemStackHasDisplayName, itemStack)) {
						Modchu_AS.set(Modchu_AS.entitySetCustomNameTag, entity, Modchu_AS.getString(Modchu_AS.itemStackGetDisplayName, itemStack));
					}
					if (!Modchu_AS.getBoolean(Modchu_AS.entityPlayerCapabilitiesIsCreativeMode, entityPlayer)) {
						Modchu_AS.set(Modchu_AS.itemStackStackSize, itemStack, Modchu_AS.getInt(Modchu_AS.itemStackStackSize, itemStack) - 1);
					}
				}
			}
		}
		Object actionResult = flag ? Modchu_Reflect.newInstance("ActionResult", new Class[]{ Modchu_Reflect.loadClass("EnumActionResult"), Object.class }, new Object[]{ Modchu_AS.getEnum("EnumActionResult", "SUCCESS"), itemStack }) : itemStack;
		return actionResult;
	}

	protected Object spawnCreature(Object world, int par1, double par2, double par4, double par6) {
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster spawnCreature par1="+par1);
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster spawnCreature spawnNameMap="+spawnNameMap);
		String spawName = spawnNameMap.get(par1);
		return Modchu_SpawnManager.instance.spawnCreature(spawName, world, par2, par4, par6);
	}

	@Override
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	public Object getIconFromDamageForRenderPass(int i, int i1) {
		Object o = i1 > 0 ? theIcon : super.getIconFromDamageForRenderPass(i, i1);
		//Modchu_Debug.mDebug("getIconFromDamageForRenderPass o="+o);
		return o;
	}

	@Override
	public void registerIcons(Object iIconRegister) {
		String name = Modchu_Main.getMinecraftVersion() < 160 ? "monsterPlacer" : "spawn_egg";
		//Modchu_Debug.mDebug("registerIcons name="+name);
		//Object itemIcon = Modchu_AS.get(Modchu_AS.iIconRegisterRegisterIcon, iIconRegister, name);
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster registerIcons itemIcon="+itemIcon);
		//Modchu_AS.set(Modchu_AS.itemItemIcon, base, itemIcon);
		Modchu_AS.set(Modchu_AS.itemItemIcon, base, Modchu_AS.get(Modchu_AS.iIconRegisterRegisterIcon, iIconRegister, name));
		theIcon = Modchu_AS.get(Modchu_AS.iIconRegisterRegisterIcon, iIconRegister, name + "_overlay");
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster registerIcons theIcon="+theIcon);
	}

}
