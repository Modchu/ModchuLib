package modchu.lib;

import java.util.HashMap;
import java.util.Random;

public class Modchu_ItemSpawnEggMaster extends Modchu_ItemMasterBasis {
	public final int primaryColor;
	public final int secondaryColor;
	public String spawModchuClassName;
	public Class spawEntityClass;
	public HashMap<String, Object> spawnableMap;
	public Object theIcon;

	public Modchu_ItemSpawnEggMaster(HashMap<String, Object> map) {
		super(map);
		setHasSubtypes(true);
		primaryColor = (Integer) map.get("Integer1");
		secondaryColor = (Integer) map.get("Integer2");
		spawModchuClassName = (String) map.get("String");
		Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster map="+map);
		spawnableMap = (HashMap) map.get("HashMap");
		spawEntityClass = (Class) spawnableMap.get("Class");
	}

	@Override
	public int getColorFromItemStack(Object itemStack, int par2) {
		return par2 == 0 ? primaryColor : secondaryColor;
	}

	@Override
	public String getItemStackDisplayName(Object itemStack) {
		String s = getUnlocalizedName();
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster getItemStackDisplayName 1 s="+s);
		s = Modchu_AS.getString("StatCollector", "translateToLocal", new Class[]{ String.class }, new Object[]{ s + ".name" });
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
		if (Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, world)) {
			return itemStack;
		} else {
			Object movingObjectPosition = getMovingObjectPositionFromPlayer(world, entityPlayer, true);

			if (movingObjectPosition == null) {
				return itemStack;
			} else {
				if (Modchu_AS.getEnum(Modchu_AS.movingObjectPositionTypeOfHit, movingObjectPosition) == Modchu_AS.getEnum(Modchu_AS.movingObjectPositionMovingObjectTypeBLOCK, movingObjectPosition)) {
					int i = Modchu_AS.getInt(Modchu_AS.movingObjectPositionBlockPosGetX, movingObjectPosition);
					int j = Modchu_AS.getInt(Modchu_AS.movingObjectPositionBlockPosGetY, movingObjectPosition);
					int k = Modchu_AS.getInt(Modchu_AS.movingObjectPositionBlockPosGetZ, movingObjectPosition);
					int version = Modchu_Main.getMinecraftVersion();
					boolean canMineBlock = version > 179 ? Modchu_AS.getBoolean("World", "isBlockModifiable", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), Modchu_Reflect.loadClass("BlockPos") }, world, new Object[]{ entityPlayer, Modchu_AS.get(Modchu_AS.newBlockPos, i, j, k) }) : Modchu_AS.getBoolean("World", "canMineBlock", new Class[]{ Modchu_Reflect.loadClass("EntityPlayer"), int.class, int.class, int.class }, world, new Object[]{ entityPlayer, i, j, k });
					if (!canMineBlock) {
						return itemStack;
					}
					boolean canPlayerEdit = version > 179 ? Modchu_AS.getBoolean("EntityPlayer", "canPlayerEdit", new Class[]{ Modchu_Reflect.loadClass("BlockPos"), Modchu_Reflect.loadClass("EnumFacing"), Modchu_Reflect.loadClass("ItemStack") }, entityPlayer, new Object[]{ Modchu_AS.get(Modchu_AS.newBlockPos, i, j, k), Modchu_AS.get("MovingObjectPosition", "sideHit", movingObjectPosition), itemStack }) : Modchu_AS.getBoolean("EntityPlayer", "canPlayerEdit", new Class[]{ int.class, int.class, int.class, int.class, Modchu_Reflect.loadClass("ItemStack") }, entityPlayer, new Object[]{ i, j, k, Modchu_AS.getInt("MovingObjectPosition", "sideHit", movingObjectPosition), itemStack });
					if (!canPlayerEdit) {
						return itemStack;
					}
					Object block = Modchu_AS.get(Modchu_AS.worldGetBlock, world, i, j, k);
					//if (Modchu_Reflect.loadClass("BlockLiquid").isInstance(block)) {
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
					//} else {
						//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster onItemRightClick !BlockLiquid block="+block);
					//}
				}

				return itemStack;
			}
		}
	}

	protected Object spawnCreature(Object world, int par1, double par2, double par4, double par6) {
		Object entity = null;
		try {
			spawnableMap.put("Object", world);
			Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster spawnCreature 1");
			entity = Modchu_Main.newModchuCharacteristicObject(spawModchuClassName, spawnableMap);
			Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster spawnCreature 2");

			Modchu_AS.set(Modchu_AS.entitySetLocationAndAngles, entity, par2 + 0.5D, par4 + 1.0D, par6 + 0.5D, Modchu_AS.getFloat(Modchu_AS.mathHelperWrapAngleTo180_float, ((Random) Modchu_AS.get(Modchu_AS.worldRand, world)).nextFloat() * 360.0F), 0.0F);
			float rotationYaw = Modchu_AS.getFloat(Modchu_AS.entityRotationYaw, entity);
			Modchu_AS.set(Modchu_AS.entityLivingBaseRotationYawHead, entity, rotationYaw);
			Modchu_AS.set(Modchu_AS.entityLivingBaseRenderYawOffset, entity, rotationYaw);
			int version = Modchu_Main.getMinecraftVersion();
			if (version > 179) {
				Modchu_AS.set("EntityLiving", "func_180482_a", new Class[]{ Modchu_Reflect.loadClass("DifficultyInstance"), Modchu_Reflect.loadClass("IEntityLivingData") }, entity, new Object[]{ Modchu_AS.get("World", "getDifficultyForLocation", new Class[]{ Modchu_Reflect.loadClass("BlockPos") }, world, new Object[]{ Modchu_AS.get(Modchu_AS.newBlockPos, Modchu_AS.getDouble(Modchu_AS.entityPosX, entity), Modchu_AS.getDouble(Modchu_AS.entityPosY, entity), Modchu_AS.getDouble(Modchu_AS.entityPosZ, entity)) }), null });
			} else if (version > 159) {
				Modchu_AS.set("EntityLiving", "onSpawnWithEgg", new Class[]{ Modchu_Reflect.loadClass(version > 169 ? "IEntityLivingData" : "EntityLivingData") }, entity, new Object[]{ null });
			}
			Modchu_AS.getBoolean(Modchu_AS.worldSpawnEntityInWorld, world, entity);
			Modchu_AS.set("EntityLiving", "playLivingSound", entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entity;
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
		String name = "spawn_egg";
		//Modchu_Debug.mDebug("registerIcons name="+name);
		//Object itemIcon = Modchu_AS.get(Modchu_AS.iIconRegisterRegisterIcon, iIconRegister, name);
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster registerIcons itemIcon="+itemIcon);
		//Modchu_AS.set(Modchu_AS.itemItemIcon, base, itemIcon);
		Modchu_AS.set(Modchu_AS.itemItemIcon, base, Modchu_AS.get(Modchu_AS.iIconRegisterRegisterIcon, iIconRegister, name));
		theIcon = Modchu_AS.get(Modchu_AS.iIconRegisterRegisterIcon, iIconRegister, name + "_overlay");
		//Modchu_Debug.mDebug("Modchu_ItemSpawnEggMaster registerIcons theIcon="+theIcon);
	}

}
