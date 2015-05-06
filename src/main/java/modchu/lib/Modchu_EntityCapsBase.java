package modchu.lib;

public class Modchu_EntityCapsBase implements Modchu_IEntityCapsBase {
	protected Object owner;

	public Modchu_EntityCapsBase(Object pOwner) {
		owner = pOwner;
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_Entity:
			//Modchu_Debug.mDebug("owner="+owner+" this="+this);
			return owner;
		case caps_health:
			Object o = owner != null ? Modchu_AS.get(Modchu_AS.entityLivingBaseGetHealth, owner) : -1;
			int i = -1;
			if (o != null) {
				if (o instanceof Integer) i = (Integer) o;
				if (o instanceof Float) {
					float f = (Float) o;
					i = (int) f;
				}
			}
			return i;
		case caps_healthFloat:
			Object o1 = owner != null ? Modchu_AS.get(Modchu_AS.entityLivingBaseGetHealth, owner) : -1F;
			float f = -1F;
			if (o1 != null) {
				if (o1 instanceof Float) f = (Float) o1;
				if (o1 instanceof Integer) {
					int i1 = (Integer) o1;
					f = (float) i1;
				}
			}
			return f;
		case caps_ticksExisted:
			return owner != null ? Modchu_AS.getInt(Modchu_AS.entityTicksExisted, owner) : 0;
		case caps_heldItems:
		case caps_currentEquippedItem:
			return owner != null ? Modchu_AS.get(Modchu_AS.entityLivingBaseGetHeldItem, owner) : null;
		case caps_currentArmor:
			return owner != null ? Modchu_AS.get(Modchu_AS.entityLivingBaseGetEquipmentInSlot, owner, (Integer)pArg[0] + 1) : null;
		case caps_posX:
			return owner != null ? Modchu_AS.getDouble(Modchu_AS.entityPosX, owner) : -1D;
		case caps_posY:
			return owner != null ? Modchu_AS.getDouble(Modchu_AS.entityPosY, owner) : -1D;
		case caps_posZ:
			return owner != null ? Modchu_AS.getDouble(Modchu_AS.entityPosZ, owner) : -1D;
		case caps_pos:
			if (pArg == null) {
				if (owner != null) {
					return new Double[] {-1.0D, -1.0D, -1.0D};
				}
				return new Double[] {Modchu_AS.getDouble(Modchu_AS.entityPosX, owner), Modchu_AS.getDouble(Modchu_AS.entityPosY, owner), Modchu_AS.getDouble(Modchu_AS.entityPosZ, owner)};
			} else {
				return (Integer)pArg[0] == 0 ? Modchu_AS.getDouble(Modchu_AS.entityPosX, owner) : (Integer)pArg[0] == 1 ? Modchu_AS.getDouble(Modchu_AS.entityPosY, owner) : Modchu_AS.getDouble(Modchu_AS.entityPosZ, owner);
			}
		case caps_motionX:
			return owner != null ? Modchu_AS.getDouble(Modchu_AS.entityMotionX, owner) : 0.0D;
		case caps_motionY:
			return owner != null ? Modchu_AS.getDouble(Modchu_AS.entityMotionY, owner) : 0.0D;
		case caps_motionZ:
			return owner != null ? Modchu_AS.getDouble(Modchu_AS.entityMotionZ, owner) : 0.0D;
		case caps_motion:
			if (pArg == null) {
				if (owner != null) {
					return new Double[] {0.0D, 0.0D, 0.0D};
				}
				return new Double[] {Modchu_AS.getDouble(Modchu_AS.entityMotionX, owner), Modchu_AS.getDouble(Modchu_AS.entityMotionY, owner), Modchu_AS.getDouble(Modchu_AS.entityMotionZ, owner)};
			} else {
				return (Integer)pArg[0] == 0 ? Modchu_AS.getDouble(Modchu_AS.entityMotionX, owner) : (Integer)pArg[0] == 1 ? Modchu_AS.getDouble(Modchu_AS.entityMotionY, owner) : Modchu_AS.getDouble(Modchu_AS.entityMotionZ, owner);
			}
		case caps_rotationYaw:
			return owner != null ? Modchu_AS.getFloat(Modchu_AS.entityRotationYaw, owner) : 0.0F;
		case caps_rotationPitch:
			return owner != null ? Modchu_AS.getFloat(Modchu_AS.entityRotationPitch, owner) : 0.0F;
		case caps_prevRotationYaw:
			return owner != null ? Modchu_AS.getFloat(Modchu_AS.entityPrevRotationYaw, owner) : 0.0F;
		case caps_prevRotationPitch:
			return owner != null ? Modchu_AS.getFloat(Modchu_AS.entityPrevRotationPitch, owner) : 0.0F;
		case caps_renderYawOffset:
			return owner != null ? Modchu_AS.getFloat(Modchu_AS.entityLivingBaseRenderYawOffset, owner) : 0.0F;

		case caps_onGround:
			return owner != null ? Modchu_AS.getFloat(Modchu_AS.entityOnGround, owner) : 0.0F;
		case caps_isRiding:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsRiding, owner) : false;
		case caps_isRidingPlayer:
			return owner != null ? Modchu_Reflect.loadClass("EntityPlayer").isInstance(Modchu_AS.get(Modchu_AS.entityRidingEntity, owner)) : false;
		case caps_isChild:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityLivingBaseIsChild, owner) : false;
		case caps_isWet:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsWet, owner) : false;
		case caps_isDead:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsDead, owner) : false;
		case caps_isJumping:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityLivingBaseIsJumping, owner) : false;
		case caps_isInWeb:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsInWeb, owner) : false;
		case caps_isSwingInProgress:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityLivingBaseIsSwingInProgress, owner) : false;
		case caps_isSneak:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsSneaking, owner) : false;
//		case caps_isBlocking:
//			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsBlocking, owner) : false;
		case caps_isBurning:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsBurning, owner) : false;
		case caps_isInWater:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsInWater, owner) : false;
		case caps_isInvisible:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsInvisible, owner) : false;
		case caps_isSprinting:
			return owner != null ? Modchu_AS.getBoolean(Modchu_AS.entityIsSprinting, owner) : false;
		case caps_PosBlockID:
			return -1;
/*
			return owner != null ? owner.getBlockId(
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosX, owner) + (Double)pArg[0]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, owner.posY + (Double)pArg[1]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, owner.posZ + (Double)pArg[2])) : -1;
*/
		case caps_PosBlockMeta:
			return owner != null ? Modchu_AS.get(Modchu_AS.worldGetBlockStateGetBlockMetadata, owner, 
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosX, owner) + (Double)pArg[0]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosY, owner) + (Double)pArg[1]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosZ, owner) + (Double)pArg[2])) : -1;
		case caps_PosBlockAir:
			return owner != null ? Modchu_AS.get(Modchu_AS.worldIsAirBlock, owner,
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosX, owner) + (Double)pArg[0]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosY, owner) + (Double)pArg[1]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosZ, owner) + (Double)pArg[2])) : false;
		case caps_PosBlockLight:
			return owner != null ? Modchu_AS.get(Modchu_AS.worldGetBlockLightValue, owner,
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosX, owner) + (Double)pArg[0]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosY, owner) + (Double)pArg[1]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosZ, owner) + (Double)pArg[2])) : -1;
		case caps_PosBlockPower:
			return owner != null ? Modchu_AS.get(Modchu_AS.worldGetStrongPower, owner,
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosX, owner) + (Double)pArg[0]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosY, owner) + (Double)pArg[1]),
					Modchu_AS.getDouble(Modchu_AS.mathHelperFloor_double, Modchu_AS.getDouble(Modchu_AS.entityPosZ, owner) + (Double)pArg[2])) : -1;
		case caps_boundingBox:
			if (owner != null) {
				return null;
			}
			else if (pArg == null) {
				return Modchu_AS.get(Modchu_AS.entityGetBoundingBox, owner);
			} else {
				switch ((Integer)pArg[0]) {
				case 0:
					return Modchu_AS.getDouble(Modchu_AS.entityBoundingBoxMaxX, owner);
				case 1:
					return Modchu_AS.getDouble(Modchu_AS.entityBoundingBoxMaxY, owner);
				case 2:
					return Modchu_AS.getDouble(Modchu_AS.entityBoundingBoxMaxZ, owner);
				case 3:
					return Modchu_AS.getDouble(Modchu_AS.entityBoundingBoxMinX, owner);
				case 4:
					return Modchu_AS.getDouble(Modchu_AS.entityBoundingBoxMinY, owner);
				case 5:
					return Modchu_AS.getDouble(Modchu_AS.entityBoundingBoxMinZ, owner);
				}
			}
		case caps_isLeeding:
			return owner != null ? Modchu_Reflect.loadClass("EntityLiving").isInstance(owner)
					&& Modchu_AS.getBoolean(Modchu_AS.entityLivingGetLeashed, owner) : false;
		case caps_getRidingName:
			return owner != null ? Modchu_AS.get(Modchu_AS.entityRidingEntity, owner) == null ? "" : Modchu_AS.getString(Modchu_AS.entityListGetEntityString, Modchu_AS.get(Modchu_AS.entityRidingEntity, owner)) : null;

		// World
		case caps_WorldTotalTime:
			return owner != null ? Modchu_AS.getLong(Modchu_AS.worldInfoGetWorldTotalTime, owner) : Modchu_AS.getLong(Modchu_AS.worldInfoGetWorldTotalTime);
		case caps_WorldTime:
			return owner != null ? Modchu_AS.getLong(Modchu_AS.worldInfoGetWorldTime, owner) : Modchu_AS.getLong(Modchu_AS.worldInfoGetWorldTime);
		case caps_MoonPhase:
			return owner != null ? Modchu_AS.get(Modchu_AS.worldGetMoonPhase, owner) : Modchu_AS.get(Modchu_AS.worldGetMoonPhase);
		case caps_TextureEntity:
			return owner;
		}

		return null;
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		if (owner != null); else return false;
		switch (pIndex) {
		case caps_health:
			return Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, owner, pArg[0]);
		case caps_ticksExisted:
			return Modchu_AS.set(Modchu_AS.entityTicksExisted, owner, pArg[0]);
		case caps_heldItems:
		case caps_currentEquippedItem:
			return Modchu_AS.set(Modchu_AS.entityLivingSetCurrentItemOrArmor, owner, pArg[0], pArg[1]);
		case caps_currentArmor:
			return Modchu_AS.set(Modchu_AS.entityLivingSetCurrentItemOrArmor, owner, (Integer)pArg[0] + 1, pArg[1]);
		case caps_posX:
			return Modchu_AS.set(Modchu_AS.entityPosX, owner, pArg[0]);
		case caps_posY:
			return Modchu_AS.set(Modchu_AS.entityPosY, owner, pArg[0]);
		case caps_posZ:
			return Modchu_AS.set(Modchu_AS.entityPosZ, owner, pArg[0]);
		case caps_pos:
			return Modchu_AS.set(Modchu_AS.entitySetPosition, owner, pArg[0], pArg[1], pArg[2]);
		case caps_motionX:
			return Modchu_AS.set(Modchu_AS.entityMotionX, owner, pArg[0]);
		case caps_motionY:
			return Modchu_AS.set(Modchu_AS.entityMotionY, owner, pArg[0]);
		case caps_motionZ:
			return Modchu_AS.set(Modchu_AS.entityMotionZ, owner, pArg[0]);
		case caps_motion:
			return Modchu_AS.set(Modchu_AS.entitySetVelocity, owner, pArg[0], pArg[1], pArg[2]);
		case caps_onGround:
			return Modchu_AS.set(Modchu_AS.entityOnGround, owner, pArg[0]);
		case caps_isRiding:
			return Modchu_AS.set(Modchu_AS.entityIsRiding, owner, pArg[0]);
		case caps_isSneak:
			return Modchu_AS.set(Modchu_AS.entitySetSneaking, owner, pArg[0]);
		}

		return false;
	}

	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		return getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		return setCapsValue(pIndex, pArg);
	}

}
