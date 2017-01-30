package modchu.lib.forge.mc210;

import java.util.HashMap;
import java.util.UUID;

import modchu.lib.Modchu_IParticle;
import modchu.lib.Modchu_IParticleMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_Particle extends modchu.lib.forge.mc194_212.Modchu_Particle {

	public Modchu_Particle(HashMap<String, Object> map) {
		super(map);
	}
	// 194~210共通コピペ　↓
	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.move(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMove(double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}

	@Override
	public AxisAlignedBB getEntityBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getEntityBoundingBox());
	}

	public AxisAlignedBB superGetBoundingBox() {
		return super.getEntityBoundingBox();
	}

	@Override
	public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
		if (master != null) master.setBoundingBox(axisAlignedBB);
		else super.setEntityBoundingBox(axisAlignedBB);
	}

	public void superSetBoundingBox(Object axisAlignedBB) {
		super.setEntityBoundingBox((AxisAlignedBB) axisAlignedBB);
	}
	// 194~210共通コピペ　↑

}
