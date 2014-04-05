package modchu.lib.characteristic;

import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Modchu_ForgeEVENTHandler {

	@SubscribeEvent
	public void chat(ServerChatEvent event) {
	}
/*
	@SubscribeEvent
	public void onPlaySoundAtEntity(PlaySoundAtEntityEvent event) {
		if ((!(event.entity instanceof EntityPlayer))
				| (!event.name.equals("game.player.hurt"))) return;
		EntityPlayer player = (EntityPlayer) event.entity;
		if ((player.getHealth() <= 1.0F)
				| (player.isDead)) {
			//event.name = "minecraft:death";
		} else {
			//event.name = "minecraft:hurt";
		}
	}

	@SubscribeEvent
	public void onAttack(LivingAttackEvent event) {
		if ((event.entityLiving.worldObj.isRemote)
				| (event.ammount < 1.0F)
				| (!event.source.damageType.equals("player"))
				| (!(event.source.getSourceOfDamage() instanceof EntityPlayer))) return;
		EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
		boolean flag = (player.fallDistance > 0.0F)
				&& (!player.onGround)
				&& (!player.isOnLadder())
				&& (!player.isInWater())
				&& (!player.isPotionActive(Potion.blindness))
				&& (player.ridingEntity == null);
		if ((!flag)
				| (event.entityLiving.getHealth() < 0.0F)
				| (player.hurtResistantTime > player.maxHurtResistantTime / 2.0F)) {
			return;
		}

		String sound = "";
		switch (data.soundType) {
		case 1:
			sound = "minecraft:attack";
		}

		float pitch = (player.getRNG().nextFloat() - player.getRNG().nextFloat()) * 0.2F + 1.0F;
		player.worldObj.playSoundAtEntity(player, sound, 0.9876543F, pitch);
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.side == Side.CLIENT) return;
		EntityPlayerMP player = (EntityPlayerMP) event.player;
		ItemStack item = player.inventory.mainInventory[0];
		if (item == null) {
			//Server.sendAssociatedData(player, EnumPackets.BACK_ITEM_REMOVE, new Object[]{ player.getCommandSenderName() });
		} else {
			NBTTagCompound tag = item.writeToNBT(new NBTTagCompound());
			//Server.sendAssociatedData(player, EnumPackets.BACK_ITEM_UPDATE, new Object[]{ player.getCommandSenderName(), tag });
		}
	}
*/
}