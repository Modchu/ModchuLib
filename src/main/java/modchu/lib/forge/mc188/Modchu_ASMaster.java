package modchu.lib.forge.mc188;

import java.util.HashMap;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.player.EntityPlayer;

public class Modchu_ASMaster extends modchu.lib.forge.mc188_189.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public String getUserName(Object entityplayer) {
		return entityplayer instanceof EntityPlayer ? ((EntityPlayer) entityplayer).getCommandSenderName() : null;
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).getWorldRenderer().func_181662_b(d, d2, d3).func_181673_a(d4, d5).func_181675_d();
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		((Tessellator) tessellator).getWorldRenderer().func_181662_b(d, d2, d3).func_181673_a(d4, d5).func_181663_c(f, f1, f2).func_181675_d();
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getWorldRenderer().func_181662_b(d, d2, d3).func_181673_a(d4, d5).func_181669_b(i, i1, i2, i3).func_181675_d();
	}

	@Override
	public void tessellatorStartDrawing(Object tessellator, int i, Object vertexFormat) {
		((Tessellator) tessellator).getWorldRenderer().func_181668_a(i, (VertexFormat) vertexFormat);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).getWorldRenderer().func_181662_b(d, d2, d3).func_181675_d();
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getWorldRenderer().func_181662_b(d, d2, d3).func_181669_b(i, i1, i2, i3).func_181675_d();
	}

}