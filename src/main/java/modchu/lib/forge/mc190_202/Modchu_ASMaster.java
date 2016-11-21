package modchu.lib.forge.mc190_202;

import java.util.HashMap;

import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
import net.minecraft.world.World;

public class Modchu_ASMaster extends modchu.lib.forge.mc190_210.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}
	// 210~分離
	@Override
	public Object worldGetBiomeGenForCoords(Object worldOrInt, Object blockPosOrInt) {
		return ((World) entityWorldObj(worldOrInt)).getBiomeGenForCoords((BlockPos) blockPosOrInt);
	}

	@Override
	public Object[] entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorInventory;
	}

	@Override
	public Object[] entityPlayerMainInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer); else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).mainInventory;
	}

	@Override
	public Object itemStackCopyItemStack(Object itemstack) {
		return ItemStack.copyItemStack((ItemStack) itemstack);
	}

	@Override
	public int itemStackStackSize(Object itemstack) {
		return ((ItemStack) itemstack).stackSize;
	}

	@Override
	public void setEntityPlayerArmorInventory(Object entityplayerORInventory, Object armorInventory) {
		ItemStack[] itemStacks = ((ItemStack[]) armorInventory);
		if (entityplayerORInventory instanceof InventoryPlayer) {
			for (int i = 0; i < ((InventoryPlayer) entityplayerORInventory).armorInventory.length; i++) {
				if (i > itemStacks.length) break;
				((InventoryPlayer) entityplayerORInventory).armorInventory[i] = itemStacks[i];
			}
		} else {
			for (int i = 0; i < ((EntityPlayer) entityplayerORInventory).inventory.armorInventory.length; i++) {
				if (i > itemStacks.length) break;
				((EntityPlayer) entityplayerORInventory).inventory.armorInventory[i] = itemStacks[i];
			}
		}
	}

	@Override
	public void setEntityPlayerMainInventory(Object entityplayerORInventory, Object mainInventory) {
		ItemStack[] itemStacks = ((ItemStack[]) mainInventory);
		if (entityplayerORInventory instanceof InventoryPlayer) {
			for (int i = 0; i < ((InventoryPlayer) entityplayerORInventory).mainInventory.length; i++) {
				if (i > itemStacks.length) break;
				((InventoryPlayer) entityplayerORInventory).mainInventory[i] = itemStacks[i];
			}
		} else {
			for (int i = 0; i < ((EntityPlayer) entityplayerORInventory).inventory.mainInventory.length; i++) {
				if (i > itemStacks.length) break;
				((EntityPlayer) entityplayerORInventory).inventory.mainInventory[i] = itemStacks[i];
			}
		}
	}

	@Override
	public void setItemStackStackSize(Object itemstack, int i) {
		((ItemStack) itemstack).stackSize = i;
	}

	@Override
	public void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer, Object enumHand) {
		((Item) item).onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityplayer, (EnumHand) enumHand);
	}

	@Override
	public boolean entityZombieIsVillager(Object entityZombie) {
		return ((EntityZombie) entityZombie).isVillager();
	}

}