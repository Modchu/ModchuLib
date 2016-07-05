package modchu.lib.forge.mc194_202;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Multimap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IItemFood;
import modchu.lib.Modchu_IItemFoodMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Modchu_ItemFood extends modchu.lib.forge.mc190_202.Modchu_ItemFood implements Modchu_IItemFood {
	public Modchu_IItemFoodMaster master;

	public Modchu_ItemFood(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	protected RayTraceResult rayTrace(World world, EntityPlayer entityPlayer, boolean par3) {
		return (RayTraceResult) (master != null ? master.rayTrace(world, entityPlayer, par3) : super.rayTrace(world, entityPlayer, par3));
	}

	@Override
	public Object superRayTrace(Object world, Object entityPlayer, boolean par3) {
		return super.rayTrace((World) world, (EntityPlayer) entityPlayer, par3);
	}

}
