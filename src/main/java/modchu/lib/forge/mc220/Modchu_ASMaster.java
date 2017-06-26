package modchu.lib.forge.mc220;

import java.util.HashMap;
import java.util.UUID;

import modchu.lib.Modchu_Main;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Rotations;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;

public class Modchu_ASMaster extends modchu.lib.forge.mc212_220.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public float entityGetBrightness(Object entity, float f) {
		return ((Entity) entity).getBrightness();
	}

	@Override
	public int entityGetBrightnessForRender(Object entity, float f) {
		return ((Entity) entity).getBrightnessForRender();
	}

	@Override
	public Object minecraftFontRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().fontRenderer;
	}

	@Override
	public void minecraftFontRenderer(Object fontRenderer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().fontRenderer = (FontRenderer) fontRenderer;
	}

	@Override
	public void guiIngameDrawString(String s, int i, int j, int k) {
		if (Modchu_Main.isServer) return;
		Minecraft mc = Minecraft.getMinecraft();
		mc.ingameGUI.drawString(mc.fontRenderer, s, i, j, k);
	}

	@Override
	public Object damageSourceGetEntity(Object damageSource) {
		return ((DamageSource) damageSource).getTrueSource();
	}

	@Override
	public int guiButtonXPosition(Object guiButton) {
		return ((GuiButton) guiButton).x;
	}

	@Override
	public int guiButtonYPosition(Object guiButton) {
		return ((GuiButton) guiButton).y;
	}

	@Override
	public void setGuiButtonXPosition(Object guiButton, int i) {
		((GuiButton) guiButton).x = i;
	}

	@Override
	public void setGuiButtonYPosition(Object guiButton, int i) {
		((GuiButton) guiButton).y = i;
	}

	@Override
	public double vec3XCoord(Object vec3) {
		return ((Vec3d) vec3).x;
	}

	@Override
	public double vec3YCoord(Object vec3) {
		return ((Vec3d) vec3).y;
	}

	@Override
	public double vec3ZCoord(Object vec3) {
		return ((Vec3d) vec3).z;
	}

	@Override
	public boolean axisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return ((AxisAlignedBB) axisAlignedBB).contains((Vec3d) vec3);
	}

	@Override
	public Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getRevengeTarget();
	}

	@Override
	public Object newDataParameter(Class c, Class[] c1, int i) {
		//Modchu_Debug.mDebug("Modchu_ASMaster newDataParameter c="+c+" c1="+c1+" i="+i);
		DataSerializer dataSerializers =
				c1[0] == Byte.class ? DataSerializers.BYTE :
					c1[0] == Integer.class ? DataSerializers.VARINT :
						c1[0] == Float.class ? DataSerializers.FLOAT :
							c1[0] == String.class ? DataSerializers.STRING :
								c1[0] == ITextComponent.class ? DataSerializers.TEXT_COMPONENT :
									c1[0] == com.google.common.base.Optional.class && c1[1] == ItemStack.class ? DataSerializers.ITEM_STACK :
										c1[0] == com.google.common.base.Optional.class && c1[1] == IBlockState.class ? DataSerializers.OPTIONAL_BLOCK_STATE :
											c1[0] == Boolean.class ? DataSerializers.BOOLEAN :
												c1[0] == Rotations.class ? DataSerializers.ROTATIONS :
													c1[0] == BlockPos.class ? DataSerializers.BLOCK_POS :
														c1[0] == com.google.common.base.Optional.class && c1[1] == BlockPos.class ? DataSerializers.OPTIONAL_BLOCK_POS :
															c1[0] == EnumFacing.class ? DataSerializers.FACING :
																c1[0] == com.google.common.base.Optional.class && c1[1] == UUID.class ? DataSerializers.OPTIONAL_UNIQUE_ID :
																	null;
		//Modchu_Debug.mDebug("Modchu_ASMaster newDataParameter dataSerializers="+dataSerializers);
		DataParameter dataParameter = dataSerializers != null ? EntityDataManager.createKey(c, dataSerializers) : null;
		//Modchu_Debug.mDebug("Modchu_ASMaster newDataParameter return. dataParameter="+dataParameter);
		return dataParameter;
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).tex(d4, d5).endVertex();
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).tex(d4, d5).normal(f, f1, f2).endVertex();
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).tex(d4, d5).color(i, i1, i2, i3).endVertex();
	}

	@Override
	public void tessellatorStartDrawing(Object tessellator, int i, Object vertexFormat) {
		((Tessellator) tessellator).getBuffer().begin(i, (VertexFormat) vertexFormat);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).endVertex();
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getBuffer().pos(d, d2, d3).color(i, i1, i2, i3).endVertex();
	}

	@Override
	public void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw(((Tessellator) tessellator).getBuffer(), f);
	}

	@Override
	public float entityLivingBaseMoveForward(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveForward;
	}

	@Override
	public void setEntityLivingBaseMoveForward(Object entityplayer, float f) {
		((EntityLivingBase) entityplayer).moveForward = f;
	}

}