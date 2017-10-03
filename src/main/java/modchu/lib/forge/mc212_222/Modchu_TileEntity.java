package modchu.lib.forge.mc212_222;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class Modchu_TileEntity extends modchu.lib.forge.mc194_222.Modchu_TileEntity {

	public Modchu_TileEntity() {
		super();
	}

	public Modchu_TileEntity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	@Override
	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public boolean hasWorld() {
		return master != null ? master.hasWorld() : super.hasWorld();
	}

	@Override
	public boolean superHasWorld() {
		return super.hasWorld();
	}

	@Override
	public void setWorldCreate(World world) {
		if (master != null) master.setWorldCreate(world);
		else super.setWorldCreate(world);
	}

	@Override
	public void superSetWorldCreate(Object world) {
		super.setWorldCreate((World) world);
	}

	public ITextComponent getDisplayName() {
		return (ITextComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	@Override
	public ITextComponent superGetDisplayName() {
		return super.getDisplayName();
	}

	public void rotate(Rotation rotation) {
		if (master != null) master.rotate(rotation);
		else super.rotate(rotation);
	}

	@Override
	public void superRotate(Object rotation) {
		super.rotate((Rotation) rotation);
	}

	public void mirror(Mirror mirror) {
		if (master != null) master.mirror(mirror);
		else super.mirror(mirror);
	}

	@Override
	public void superMirror(Object mirror) {
		super.mirror((Mirror) mirror);
	}

	public void handleUpdateTag(NBTTagCompound nBTTagCompound) {
		if (master != null) master.handleUpdateTag(nBTTagCompound);
		else super.handleUpdateTag(nBTTagCompound);
	}

	@Override
	public void superHandleUpdateTag(Object nBTTagCompound) {
		super.handleUpdateTag((NBTTagCompound) nBTTagCompound);
	}

}
