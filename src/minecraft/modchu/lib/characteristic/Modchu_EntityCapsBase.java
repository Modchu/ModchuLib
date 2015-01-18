package modchu.lib.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Reflect;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class Modchu_EntityCapsBase implements Modchu_IEntityCapsBase {

	protected EntityLivingBase owner;

	public Modchu_EntityCapsBase(Object pOwner) {
		owner = (EntityLivingBase) pOwner;
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_Entity:
			//Modchu_Debug.mDebug("owner="+owner+" this="+this);
			return owner;
		case caps_health:
			return owner != null ? (int)owner.getHealth() : -1;
		case caps_healthFloat:
			return owner != null ? owner.getHealth() : -1.0F;
		case caps_ticksExisted:
			return owner != null ? owner.ticksExisted : 0;
		case caps_heldItems:
		case caps_currentEquippedItem:
			return owner != null ? owner.getHeldItem() : null;
		case caps_currentArmor:
			return owner != null ? owner.getCurrentItemOrArmor((Integer)pArg[0] + 1) : null;
		case caps_posX:
			return owner != null ? owner.posX : -1;
		case caps_posY:
			return owner != null ? owner.posY : -1;
		case caps_posZ:
			return owner != null ? owner.posZ : -1;
		case caps_pos:
			if (pArg == null) {
				if (owner != null) {
					return new Double[] {-1.0D, -1.0D, -1.0D};
				}
				return new Double[] {owner.posX, owner.posY, owner.posZ};
			} else {
				return (Integer)pArg[0] == 0 ? owner.posX : (Integer)pArg[0] == 1 ? owner.posY : owner.posZ;
			}
		case caps_motionX:
			return owner != null ? owner.motionX : 0.0D;
		case caps_motionY:
			return owner != null ? owner.motionY : 0.0D;
		case caps_motionZ:
			return owner != null ? owner.motionZ : 0.0D;
		case caps_motion:
			if (pArg == null) {
				if (owner != null) {
					return new Double[] {0.0D, 0.0D, 0.0D};
				}
				return new Double[] {owner.motionX, owner.motionY, owner.motionZ};
			} else {
				return (Integer)pArg[0] == 0 ? owner.motionX : (Integer)pArg[0] == 1 ? owner.motionY : owner.motionZ;
			}
		case caps_rotationYaw:
			return owner != null ? owner.rotationYaw : 0.0F;
		case caps_rotationPitch:
			return owner != null ? owner.rotationPitch : 0.0F;
		case caps_prevRotationYaw:
			return owner != null ? owner.prevRotationYaw : 0.0F;
		case caps_prevRotationPitch:
			return owner != null ? owner.prevRotationPitch : 0.0F;
		case caps_renderYawOffset:
			return owner != null ? owner.renderYawOffset : 0.0F;

		case caps_onGround:
			return owner != null ? owner.onGround : 0.0F;
		case caps_isRiding:
			return owner != null ? owner.isRiding() : false;
		case caps_isRidingPlayer:
			return owner != null ? owner.ridingEntity instanceof EntityPlayer : false;
		case caps_isChild:
			return owner != null ? owner.isChild() : false;
		case caps_isWet:
			return owner != null ? owner.isWet() : false;
		case caps_isDead:
			return owner != null ? owner.isDead : false;
		case caps_isJumping:
			return owner != null ? (Boolean)Modchu_Reflect.getFieldObject("EntityLivingBase", "field_70703_bu", "isJumping", owner) : false;
		case caps_isInWeb:
			return owner != null ? (Boolean)Modchu_Reflect.getFieldObject("Entity", "field_70134_J", "isInWeb", owner) : false;
		case caps_isSwingInProgress:
			return owner != null ? owner.isSwingInProgress : false;
		case caps_isSneak:
			return owner != null ? owner.isSneaking() : false;
//		case caps_isBlocking:
//			return owner != null ? owner.isBlocking() : false;
		case caps_isBurning:
			return owner != null ? owner.isBurning() : false;
		case caps_isInWater:
			return owner != null ? owner.isInWater() : false;
		case caps_isInvisible:
			return owner != null ? owner.isInvisible() : false;
		case caps_isSprinting:
			return owner != null ? owner.isSprinting() : false;
		case caps_PosBlockID:
			return -1;
/*
			return owner != null ? owner.worldObj.getBlockId(
					MathHelper.floor_double(owner.posX + (Double)pArg[0]),
					MathHelper.floor_double(owner.posY + (Double)pArg[1]),
					MathHelper.floor_double(owner.posZ + (Double)pArg[2])) : -1;
*/
		case caps_PosBlockMeta:
			return owner != null ? owner.worldObj.getBlockMetadata(
					MathHelper.floor_double(owner.posX + (Double)pArg[0]),
					MathHelper.floor_double(owner.posY + (Double)pArg[1]),
					MathHelper.floor_double(owner.posZ + (Double)pArg[2])) : -1;
		case caps_PosBlockAir:
			return owner != null ? owner.worldObj.isAirBlock(
					MathHelper.floor_double(owner.posX + (Double)pArg[0]),
					MathHelper.floor_double(owner.posY + (Double)pArg[1]),
					MathHelper.floor_double(owner.posZ + (Double)pArg[2])) : false;
		case caps_PosBlockLight:
			return owner != null ? owner.worldObj.getBlockLightValue(
					MathHelper.floor_double(owner.posX + (Double)pArg[0]),
					MathHelper.floor_double(owner.posY + (Double)pArg[1]),
					MathHelper.floor_double(owner.posZ + (Double)pArg[2])) : -1;
		case caps_PosBlockPower:
			return owner != null ? owner.worldObj.getBlockPowerInput(
					MathHelper.floor_double(owner.posX + (Double)pArg[0]),
					MathHelper.floor_double(owner.posY + (Double)pArg[1]),
					MathHelper.floor_double(owner.posZ + (Double)pArg[2])) : -1;
		case caps_boundingBox:
			if (owner != null) {
				return null;
			}
			else if (pArg == null) {
				return owner.boundingBox;
			} else {
				switch ((Integer)pArg[0]) {
				case 0:
					return owner.boundingBox.maxX;
				case 1:
					return owner.boundingBox.maxY;
				case 2:
					return owner.boundingBox.maxZ;
				case 3:
					return owner.boundingBox.minX;
				case 4:
					return owner.boundingBox.minY;
				case 5:
					return owner.boundingBox.minZ;
				}
			}
		case caps_isLeeding:
			return owner != null ? (owner instanceof EntityLiving) && ((EntityLiving)owner).getLeashed() : false;
		case caps_getRidingName:
			return owner != null ? owner.ridingEntity == null ? "" : EntityList.getEntityString(owner.ridingEntity) : null;

		// World
		case caps_WorldTotalTime:
			return owner != null ? owner.worldObj.getWorldInfo().getWorldTotalTime() : Modchu_CastHelper.world(Modchu_AS.get(Modchu_AS.minecraftTheWorld)).getWorldInfo().getWorldTotalTime();
		case caps_WorldTime:
			return owner != null ? owner.worldObj.getWorldInfo().getWorldTime() : Modchu_CastHelper.world(Modchu_AS.get(Modchu_AS.minecraftTheWorld)).getWorldInfo().getWorldTime();
		case caps_MoonPhase:
			return owner != null ? owner.worldObj.getMoonPhase() : Modchu_CastHelper.world(Modchu_AS.get(Modchu_AS.minecraftTheWorld)).getMoonPhase();
		case caps_TextureEntity:
			return owner;
		}

		return null;
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		if (owner != null) ;else return false;
		switch (pIndex) {
		case caps_health:
			owner.setHealth((Integer)pArg[0]);
			return true;
		case caps_ticksExisted:
			owner.ticksExisted = (Integer)pArg[0];
			return true;
		case caps_heldItems:
		case caps_currentEquippedItem:
			owner.setCurrentItemOrArmor((Integer)pArg[0], (ItemStack)pArg[1]);
			return true;
		case caps_currentArmor:
			owner.setCurrentItemOrArmor((Integer)pArg[0] + 1, (ItemStack)pArg[1]);
			return true;
		case caps_posX:
			owner.posX = (Double)pArg[0];
			return true;
		case caps_posY:
			owner.posY = (Double)pArg[0];
			return true;
		case caps_posZ:
			owner.posZ = (Double)pArg[0];
			return true;
		case caps_pos:
			owner.setPosition((Double)pArg[0], (Double)pArg[1], (Double)pArg[2]);
			return true;
		case caps_motionX:
			owner.motionX = (Double)pArg[0];
			return true;
		case caps_motionY:
			owner.motionY = (Double)pArg[0];
			return true;
		case caps_motionZ:
			owner.motionZ = (Double)pArg[0];
			return true;
		case caps_motion:
			owner.setVelocity((Double)pArg[0], (Double)pArg[1], (Double)pArg[2]);
			return true;
		case caps_onGround:
			owner.onGround = (Boolean)pArg[0];
			return true;
		case caps_isRiding:
			return owner.isRiding();
//		case caps_isChild:
//		case caps_isWet:
//		case caps_isDead:
//		case caps_isJumping:
//		case caps_isInWeb:
//		case caps_isSwingInProgress:
		case caps_isSneak:
			owner.setSneaking((Boolean)pArg[0]);
//		case caps_isBlocking:
//		case caps_isBurning:
//		case caps_isInWater:
//		case caps_isInvisible:
//		case caps_isSprinting:
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
