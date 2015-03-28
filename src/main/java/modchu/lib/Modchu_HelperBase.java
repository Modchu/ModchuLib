package modchu.lib;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Modchu_HelperBase {

	public static final Package fpackage;
	public static final String packegeBase;
	public static Method methGetSmeltingResultForge = null;
	public static Class entityRegistry = null;
	public static Method registerModEntity = null;
	protected static final Map<Class, Class>replaceEntitys = new HashMap<Class, Class>();
	protected static Map<String, Integer> entityIDList = new HashMap<String, Integer>();

	static {
		fpackage = null;
		packegeBase = fpackage == null ? "" : fpackage.getName().concat(".");

/*
		if (isForge) {
			try {
				methGetSmeltingResultForge = FurnaceRecipes.class.getMethod("getExperience", ItemStack.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				entityRegistry = getNameOfClass("EntityRegistry");
				registerModEntity = entityRegistry.getMethod("registerModEntity",
						Class.class, String.class, int.class, Object.class, int.class, int.class, boolean.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
*/
	}

	/**
	 * 現在の実行環境がローカルかどうかを判定する。
	 */
	public static boolean isLocalPlay() {
		return !Modchu_Main.isServer
				&& Modchu_AS.getBoolean(Modchu_AS.isIntegratedServerRunning);
	}

	/**
	 * マルチ対応用。
	 * ItemStackに情報更新を行うと、サーバー側との差異からSlotのアップデートが行われる。
	 * その際、UsingItemの更新処理が行われないため違うアイテムに持替えられたと判定される。
	 * ここでは比較用に使われるスタックリストを強制的に書換える事により対応した。
	 */
	public static void updateCheckinghSlot(Object entity, Object itemStack) {
		// サーバー側でのみ処理
		if (!Modchu_Main.isServer) return;
		if (Modchu_Reflect.loadClass("EntityPlayerMP").isInstance(entity)) {
			Object container = Modchu_AS.get(Modchu_AS.entityPlayerMPOpenContainer, entity);
			List inventorySlots = Modchu_AS.getList(Modchu_AS.containerInventorySlots, container);
			for (int li = 0; li < inventorySlots.size(); li++) {
				Object itemStack2 = Modchu_AS.get(Modchu_AS.slotGetStack, Modchu_AS.get(Modchu_AS.containerGetSlot, container, li));
				if (itemStack2 == itemStack) {
					List inventoryItemStacks = Modchu_AS.getList(Modchu_AS.containerInventoryItemStacks, container);
					inventoryItemStacks.set(li, Modchu_AS.get(Modchu_AS.itemStackCopyItemStack, itemStack));
					break;
				}
			}
		}
	}

	/**
	 * Forge用クラス獲得。
	 */
	public static Class getForgeClass(Object pMod, String pName) {
		if (Modchu_Main.isForge) {
			pName = pName.concat("_Forge");
		}
		return getNameOfClass(pName);
	}

	/**
	 * 名前からクラスを獲得する
	 */
	public static Class getNameOfClass(String pName) {
		if (fpackage != null) {
			pName = fpackage.getName() + "." + pName;
		}
		Class lclass = null;
		try {
			lclass = Class.forName(pName);
		} catch (Exception e) {
			Modchu_Debug.Debug("Class:%s is not found.", pName);
		}

		return lclass;
	}

	/**
	 * 送信用データのセット
	 */
	public static void setValue(byte[] pData, int pIndex, int pVal, int pSize) {
		for (int li = 0; li < pSize; li++) {
			pData[pIndex++] = (byte)(pVal & 0xff);
			pVal = pVal >>> 8;
		}
	}

	public static void setInt(byte[] pData, int pIndex, int pVal) {
		pData[pIndex + 3]	= (byte)(pVal & 0xff);
		pData[pIndex + 2]	= (byte)((pVal >>> 8) & 0xff);
		pData[pIndex + 1]	= (byte)((pVal >>> 16) & 0xff);
		pData[pIndex + 0]	= (byte)((pVal >>> 24) & 0xff);
	}

	public static int getInt(byte[] pData, int pIndex) {
		return (pData[pIndex + 3] & 0xff) | ((pData[pIndex + 2] & 0xff) << 8) | ((pData[pIndex + 1] & 0xff) << 16) | ((pData[pIndex + 0] & 0xff) << 24);
	}

	public static void setFloat(byte[] pData, int pIndex, float pVal) {
		setInt(pData, pIndex, Float.floatToIntBits(pVal));
	}

	public static float getFloat(byte[] pData, int pIndex) {
		return Float.intBitsToFloat(getInt(pData, pIndex));
	}

	public static void setShort(byte[] pData, int pIndex, int pVal) {
		pData[pIndex++]	= (byte)(pVal & 0xff);
		pData[pIndex]	= (byte)((pVal >>> 8) & 0xff);
	}

	public static short getShort(byte[] pData, int pIndex) {
		return (short)((pData[pIndex] & 0xff) | ((pData[pIndex + 1] & 0xff) << 8));
	}

	public static String getStr(byte[] pData, int pIndex, int pLen) {
		String ls = new String(pData, pIndex, pLen);
		return ls;
	}
	public static String getStr(byte[] pData, int pIndex) {
		return getStr(pData, pIndex, pData.length - pIndex);
	}

	public static void setStr(byte[] pData, int pIndex, String pVal) {
		byte[] lb = pVal.getBytes();
		for (int li = pIndex; li < pData.length; li++) {
			pData[li] = lb[li - pIndex];
		}
	}

	// 状況判断要関数群
/*
	protected static boolean canBlockBeSeen(Entity entity, int x, int y, int z, boolean toTop, boolean do1, boolean do2) {
		// ブロックの可視判定
		Vec3 vec3d = Vec3.createVectorHelper(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ);
		Vec3 vec3d1 = Vec3.createVectorHelper((double)x + 0.5D, (double)y + (toTop ? 0.9D : 0.5D), (double)z + 0.5D);

		MovingObjectPosition movingobjectposition = entity.worldObj.rayTraceBlocks_do_do(vec3d, vec3d1, do1, do2);
		if (movingobjectposition == null) {
			return false;
		}
		if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
			if (movingobjectposition.blockX == MathHelper.floor_double(vec3d1.xCoord) &&
				movingobjectposition.blockY == MathHelper.floor_double(vec3d1.yCoord) &&
				movingobjectposition.blockZ == MathHelper.floor_double(vec3d1.zCoord)) {
				return true;
			}
		}
		return false;
	}
*/
	public static boolean setPathToTile(Object entityLiving, Object tileEntity, boolean flag) {
		// Tileまでのパスを作る
		Object pathNavigate = Modchu_AS.get(Modchu_AS.entityLivingGetNavigator, entityLiving);
		float lspeed = 1.0F;
		// 向きに合わせて距離を調整
		int x = Modchu_AS.getInt(Modchu_AS.tileEntityXCoord, tileEntity);
		int y = Modchu_AS.getInt(Modchu_AS.tileEntityYCoord, tileEntity);
		int z = Modchu_AS.getInt(Modchu_AS.tileEntityZCoord, tileEntity);
		int i = (y == Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosY, entityLiving))
				&& flag) ? 2 : 1;
		switch (Modchu_AS.getInt(Modchu_AS.worldGetBlockStateGetBlockMetadata, entityLiving, x, y, z)) {
		case 3:
			return Modchu_AS.getBoolean(Modchu_AS.pathNavigateTryMoveToXYZ, pathNavigate, x, y, z + i, lspeed);
		case 2:
			return Modchu_AS.getBoolean(Modchu_AS.pathNavigateTryMoveToXYZ, pathNavigate, x, y, z - i, lspeed);
		case 5:
			return Modchu_AS.getBoolean(Modchu_AS.pathNavigateTryMoveToXYZ, pathNavigate, x + 1, y, z, lspeed);
		case 4:
			return Modchu_AS.getBoolean(Modchu_AS.pathNavigateTryMoveToXYZ, pathNavigate, x - i, y, z, lspeed);
		default:
			return Modchu_AS.getBoolean(Modchu_AS.pathNavigateTryMoveToXYZ, pathNavigate, x, y, z, lspeed);
		}
	}

	/**
	 * Modloader環境下で空いているEntityIDを返す。
	 * 有効な値を獲得できなければ-1を返す。
	 */
/*
	private static int getNextEntityID(boolean isLiving) {
		if (isLiving) {
			// 生物用
			for (int li = 1; li < 256; li++) {
				if (EntityList.getClassFromID(li) == null) {
					return li;
				}
			}
		} else {
			// 物用
			for (int li = mod_MMM_MMMLib.cfg_startVehicleEntityID; li < mod_MMM_MMMLib.cfg_startVehicleEntityID + 2048; li++) {
				if (EntityList.getClassFromID(li) == null) {
					return li;
				}
			}
		}
		return -1;
	}
*/
	/**
	 * Entityを登録する。
	 * RML、Forge両対応。
	 * @param entityclass
	 * @param entityName
	 * @param defaultId
	 * 0 : オートアサイン
	 * @param mod
	 * @param uniqueModeName
	 * @param trackingRange
	 * @param updateFrequency
	 * @param sendVelocityUpdate
	 */
/*
	public static int registerEntity(
			Class<? extends Entity> entityclass, String entityName, int defaultId,
			BaseMod mod, int trackingRange, int updateFrequency, boolean sendVelocityUpdate,
			int pEggColor1, int pEggColor2) {
		int lid = 0;
		lid = getModEntityID(mod.getName());
		if (isForge) {
			try {
				Method lmethod;
				// EntityIDの獲得
				lmethod = entityRegistry.getMethod("findGlobalUniqueEntityId");
				defaultId = (Integer)lmethod.invoke(null);

				if (pEggColor1 == 0 && pEggColor2 == 0) {
					lmethod = entityRegistry.getMethod("registerGlobalEntityID",
							Class.class, String.class, int.class);
					lmethod.invoke(null, entityclass, entityName, defaultId);
				} else {
					lmethod = entityRegistry.getMethod("registerGlobalEntityID",
							Class.class, String.class, int.class, int.class, int.class);
					lmethod.invoke(null, entityclass, entityName, defaultId, pEggColor1, pEggColor2);
				}
				// EntityListへの登録は適当な数字でよい。
				registerModEntity.invoke(
						null, entityclass, entityName, lid,
						mod, trackingRange, updateFrequency, sendVelocityUpdate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// EntityListへの登録は
			if (defaultId == 0) {
				defaultId = getNextEntityID(entityclass.isAssignableFrom(EntityLivingBase.class));
			}
			if (pEggColor1 == 0 && pEggColor2 == 0) {
				ModLoader.registerEntityID(entityclass, entityName, defaultId);
			} else {
				ModLoader.registerEntityID(entityclass, entityName, defaultId, pEggColor1, pEggColor2);
			}
			ModLoader.addEntityTracker(mod, entityclass, defaultId, trackingRange, updateFrequency, sendVelocityUpdate);
		}
		Modchu_Debug.Debug("RegisterEntity ID:%d / %s-%d : %s", defaultId, mod.getName(), lid, entityName);
		return defaultId;
	}
	public static int registerEntity(
			Class<? extends Entity> entityclass, String entityName, int defaultId,
			BaseMod mod, int trackingRange, int updateFrequency, boolean sendVelocityUpdate) {
		return registerEntity(entityclass, entityName, defaultId, mod, trackingRange, updateFrequency, sendVelocityUpdate, 0, 0);
	}
*/
	private static int getModEntityID(String uniqueModeName) {
		int li = 0;
		if (entityIDList.containsKey(uniqueModeName)) {
			li = entityIDList.get(uniqueModeName);
		}
		entityIDList.put(uniqueModeName, li + 1);
		return li;
	}

	/**
	 * Entityを返す。
	 */
	public static Object getEntity(byte[] pData, int pIndex, Object world) {
		return Modchu_AS.get(Modchu_AS.worldGetEntityByID, world, Modchu_HelperBase.getInt(pData, pIndex));
	}

	/**
	 * 変数「avatar」から値を取り出し戻り値として返す。
	 * avatarが存在しない場合は元の値を返す。
	 * avatarはEntityLiving互換。
	 */
	public static Object getAvatarEntity(Object entity){
		// littleMaid用コードここから
		if (entity == null) return null;
		try {
			// 射手の情報をEntityLittleMaidAvatarからEntityLittleMaidへ置き換える
			Field field = entity.getClass().getField("avatar");
			entity = field.get(entity);
		} catch (NoSuchFieldException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
		}
		// ここまで
		return entity;
	}

	/**
	 * 変数「maidAvatar」から値を取り出し戻り値として返す。
	 * maidAvatarが存在しない場合は元の値を返す。
	 * maidAvatarはEntityPlayer互換。
	 */
	public static Object getAvatarPlayer(Object entity) {
		// メイドさんチェック
		try {
			Field field = entity.getClass().getField("maidAvatar");
			entity = field.get(entity);
		}
		catch (NoSuchFieldException e) {
		}
		catch (Exception e) {
		}
		return entity;
	}

	/**
	 * プレーヤのインベントリからアイテムを減らす
	 */
/*
	protected static ItemStack decPlayerInventory(EntityPlayer par1EntityPlayer, int par2Index, int par3DecCount) {
		if (par1EntityPlayer == null) {
			return null;
		}

		if (par2Index == -1) {
			par2Index = par1EntityPlayer.inventory.currentItem;
		}
		ItemStack itemstack1 = par1EntityPlayer.inventory.getStackInSlot(par2Index);
		if (itemstack1 == null) {
			return null;
		}

		if (!par1EntityPlayer.capabilities.isCreativeMode) {
			// クリエイティブだと減らない
			itemstack1.stackSize -= par3DecCount;
		}

		if (itemstack1.getItem() instanceof ItemPotion) {
			if(itemstack1.stackSize <= 0) {
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Item.glassBottle, par3DecCount));
				return null;
			} else {
				par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle, par3DecCount));
			}
		} else {
			if (itemstack1.stackSize <= 0) {
				par1EntityPlayer.inventory.setInventorySlotContents(par2Index, null);
				return null;
			}
		}

		return itemstack1;
	}
*/
	protected static float convRevision(String pRev) {
		Pattern lp = Pattern.compile("(\\d+)(\\w*)");
		Matcher lm = lp.matcher(pRev);
		float lf = 0;
		if (lm.find()) {
			lf = Integer.valueOf(lm.group(1));
			if (!lm.group(2).isEmpty()) {
				lf += (float)(lm.group(2).charAt(0) - 96) * 0.01;
			}
		}
		return lf;
	}

	/**
	 * EntityListに登録されていいるEntityを置き換える。
	 */
	public static void replaceEntityList(Class pSrcClass, Class pDestClass) {
		// EntityList登録情報を置き換え
		// 古いEntityでもスポーンできるように一部の物は二重登録
		try {
			// stringToClassMapping
			Map lmap;
			int lint = 0;
			String ls = "";
			lmap = Modchu_AS.getMap(Modchu_AS.entityListStringToClassMapping);
			for (Entry<String, Class> le : ((Map<String, Class>)lmap).entrySet()) {
				if (le.getValue() == pSrcClass) {
					le.setValue(pDestClass);
				}
			}
			// classToStringMapping
			lmap = Modchu_AS.getMap(Modchu_AS.entityListClassToStringMapping);
			if (lmap.containsKey(pSrcClass)) {
				ls = (String)lmap.get(pSrcClass);
//				lmap.remove(pSrcClass);
				lmap.put(pDestClass, ls);
			}
			// IDtoClassMapping
			lmap = Modchu_AS.getMap(Modchu_AS.entityListIDtoClassMapping);
			for (Entry<Integer, Class> le : ((Map<Integer, Class>)lmap).entrySet()) {
				if (le.getValue() == pSrcClass) {
					le.setValue(pDestClass);
				}
			}
			// classToIDMapping
			lmap = Modchu_AS.getMap(Modchu_AS.entityListClassToIDMapping);
			if (lmap.containsKey(pSrcClass)) {
				lint = (Integer)lmap.get(pSrcClass);
//				lmap.remove(pSrcClass);
				lmap.put(pDestClass, lint);
			}
			replaceEntitys.put(pSrcClass, pDestClass);
			Modchu_Debug.Debug("Replace %s -> %s(EntityListID: %d, EntityListString: %s)", pSrcClass.getSimpleName(), pDestClass.getSimpleName(), lint, ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/*
	private static void replaceCreatureList(List<SpawnListEntry> pMobs) {
		if (pMobs == null) return;
		for (Entry<Class, Class> le : replaceEntitys.entrySet()) {
			for (int j = 0; j < pMobs.size(); j++) {
				if (pMobs.get(j).entityClass == le.getKey()) {
					pMobs.get(j).entityClass = le.getValue();
					Modchu_Debug.Debug("ReplaceCreatureList: %s -> %s", le.getKey().getSimpleName(), le.getValue().getSimpleName());
				}
			}
		}
	}
*/
	/**
	 * バイオームの設定Entityを置き換えられたEntityへ置き換える。
	 * 基本的にMMMLib以外からは呼ばれない。
	 */
/*
	protected static void replaceBaiomeSpawn() {
		// バイオームの発生処理をのっとる
		if (replaceEntitys.isEmpty()) return;
		for (int i = 0; i < BiomeGenBase.biomeList.length; i++) {
			if (BiomeGenBase.biomeList[i] == null) continue;
			List<SpawnListEntry> mobs;
			Modchu_Debug.Debug("ReplaceBaiomeSpawn:%s", BiomeGenBase.biomeList[i].biomeName);
			Modchu_Debug.Debug("[Creature]");
			replaceCreatureList(BiomeGenBase.biomeList[i].spawnableCreatureList);
			Modchu_Debug.Debug("[WaterCreature]");
			replaceCreatureList(BiomeGenBase.biomeList[i].spawnableWaterCreatureList);
			Modchu_Debug.Debug("[CaveCreature]");
			replaceCreatureList(BiomeGenBase.biomeList[i].spawnableCaveCreatureList);
			Modchu_Debug.Debug("[Monster]");
			replaceCreatureList(BiomeGenBase.biomeList[i].spawnableMonsterList);
		}
	}
*/
	/**
	 * 視線の先にいる最初のEntityを返す
	 * @param entityLivingBase
	 * 視点
	 * @param range
	 * 視線の有効距離
	 * @param delta
	 * 時刻補正
	 * @param expand
	 * 検知領域の拡大範囲
	 * @return
	 */
	public static Object getRayTraceEntity(Object entityLivingBase, double range, float delta, float expand) {
		Object vec3 = Modchu_Reflect.newInstance("Vec3", new Class[]{ double.class, double.class, double.class }, new Object[]{ Modchu_AS.getDouble(Modchu_AS.entityPosX, entityLivingBase), Modchu_AS.getDouble(Modchu_AS.entityPosY, entityLivingBase) + Modchu_AS.getFloat(Modchu_AS.entityGetEyeHeight, entityLivingBase), Modchu_AS.getDouble(Modchu_AS.entityPosZ, entityLivingBase) });
		Object vec3Look =  Modchu_AS.get(Modchu_AS.entityLivingBaseGetLook, entityLivingBase, delta);
		int xCoord = Modchu_AS.getInt(Modchu_AS.vec3XCoord, vec3Look);
		int yCoord = Modchu_AS.getInt(Modchu_AS.vec3YCoord, vec3Look);
		int zCoord = Modchu_AS.getInt(Modchu_AS.vec3ZCoord, vec3Look);
		Object vec3View = Modchu_AS.get(Modchu_AS.vec3AddVector, vec3, xCoord * range, yCoord * range, zCoord * range);
		Object targetEntity = null;
		List list = Modchu_AS.getList(Modchu_AS.worldGetEntitiesWithinAABBExcludingEntity, entityLivingBase, entityLivingBase, Modchu_AS.get(Modchu_AS.axisAlignedBBExpand, Modchu_AS.get(Modchu_AS.axisAlignedBBExpand, Modchu_AS.get(Modchu_AS.entityGetBoundingBox, entityLivingBase), xCoord * range, yCoord * range, zCoord * range), (double)expand, (double)expand, (double)expand));
		double ltdistance = range * range;

		for (int var13 = 0; var13 < list.size(); ++var13) {
			Object entity = list.get(var13);

			if (Modchu_AS.getBoolean(Modchu_AS.entityCanBeCollidedWith, entity)) {
				float lexpand = Modchu_AS.getFloat(Modchu_AS.entityGetCollisionBorderSize, entity) + 0.3F;
				Object axisAlignedBB = Modchu_AS.get(Modchu_AS.axisAlignedBBExpand, Modchu_AS.get(Modchu_AS.entityGetBoundingBox, entity), (double)lexpand, (double)lexpand, (double)lexpand);
				Object movingObjectPosition = Modchu_AS.get(Modchu_AS.axisAlignedBBCalculateIntercept, axisAlignedBB, vec3, vec3View);

				if (Modchu_AS.getBoolean(Modchu_AS.axisAlignedBBIsVecInside, axisAlignedBB, vec3)) {
					if (0.0D < ltdistance || ltdistance == 0.0D) {
						targetEntity = entity;
						ltdistance = 0.0D;
					}
				} else if (movingObjectPosition != null) {
					double ldis = Modchu_AS.getDouble(Modchu_AS.vec3SquareDistanceTo, vec3, Modchu_AS.get(Modchu_AS.movingObjectPositionHitVec, movingObjectPosition));

					if (ldis < ltdistance || ltdistance == 0.0D) {
						targetEntity = entity;
						ltdistance = ldis;
					}
				}
			}
		}
		return targetEntity;
	}


	// Forge対策

	/**
	 * Forge対策用のメソッド
	 */
/*
	public static ItemStack getSmeltingResult(ItemStack pItemStack) {
		if (methGetSmeltingResultForge != null) {
			try {
				return (ItemStack)methGetSmeltingResultForge.invoke(FurnaceRecipes.smelting(), pItemStack);
			}catch (Exception e) {
			}
		}
		return FurnaceRecipes.smelting().getSmeltingResult(pItemStack.itemID);
	}
*/
	/**
	 * アイテムに追加効果が在るかを判定する。
	 * Forge対策。
	 * @param itemStack
	 * @return
	 */
	public static boolean hasEffect(Object itemStack) {
		if (itemStack != null) {
			Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemStack);
			if (Modchu_Reflect.loadClass("ItemPotion").isInstance(item)) {
				List list = Modchu_AS.getList(Modchu_AS.itemPotionGetEffects, item, itemStack);
				return list != null
						&& !list.isEmpty();
			}
		}
		return false;
	}

	/**
	 * Blockのインスタンスを置き換える。
	 * static finalの変数に対して行うのでForgeでは無効。
	 * @param block
	 * @param block2
	 * @return
	 */
	public static boolean replaceBlock(Object block, Object block2) {
		if (Modchu_Main.isForge) {
			return false;
		}
		try {
			// Blockのstatic final分の置換え
			Class Block = Modchu_Reflect.loadClass("Block");
			Field[] lfield = Block.getDeclaredFields();
			for (int li = 0; li < lfield.length; li++) {
				if (!Modifier.isStatic(lfield[li].getModifiers())) {
					// static以外は対象外
					continue;
				}

				Object lobject = lfield[li].get(null);
				if (lobject == block) {
					Modchu_Reflect.setPrivateValue(Block, null, li, block2);
					return true;
				}
			}
		}
		catch(Exception exception) {
		}
		return false;
	}

	/**
	 * 16進数の文字列をIntへ変換する。
	 * 0xffffffff対策。
	 * @param pValue
	 * @return
	 */
	public static int getHexToInt(String pValue) {
		String ls = "00000000".concat(pValue);
		int llen = ls.length();
		int li = Integer.parseInt(ls.substring(llen - 4, llen), 16);
		int lj = Integer.parseInt(ls.substring(llen - 8, llen - 4), 16);
		return (lj << 16) | li;
	}

	/**
	 *  アイテムに設定された攻撃力を見る
	 * @param itemStack
	 * @return
	 */
	public static double getAttackVSEntity(Object itemStack) {
		Collection attributeModifier = (Collection) Modchu_AS.getMap(Modchu_AS.itemStackGetAttributeModifiers, itemStack).get(Modchu_AS.getString(Modchu_AS.iAttributeGetAttributeUnlocalizedName, Modchu_AS.get(Modchu_AS.sharedMonsterAttributesAttackDamage)));
		return attributeModifier == null ? 0 : Modchu_AS.getDouble(Modchu_AS.attributeModifierGetAmount, attributeModifier);
	}

}
