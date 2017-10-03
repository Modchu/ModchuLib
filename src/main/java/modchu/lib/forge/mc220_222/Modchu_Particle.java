package modchu.lib.forge.mc220_222;

import java.util.HashMap;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;

public class Modchu_Particle extends modchu.lib.forge.mc212_222.Modchu_Particle {

	public Modchu_Particle(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean shouldDisableDepth() {
		return master != null ? master.shouldDisableDepth() : super.shouldDisableDepth();
	}

	@Override
	public boolean superShouldDisableDepth() {
		return super.shouldDisableDepth();
	}

	public void renderParticle(BufferBuilder bufferBuilder, Entity entity, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		if (master != null) master.renderParticle(bufferBuilder, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
		else super.renderParticle(bufferBuilder, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public void superRenderParticle(Object bufferBuilder, Object entity, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		super.renderParticle((BufferBuilder) bufferBuilder, (Entity) entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

}
