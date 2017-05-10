package modchu.lib.forge.mc180;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;

public class Modchu_ASMaster extends modchu.lib.forge.mc180_189.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public Object entityBoundingBox(Object entity) {
		return ((Entity) entity).getBoundingBox();
	}

	@Override
	public double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).getBoundingBox() : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox != null ? boundingBox.maxX : 0.0D;
	}

	@Override
	public double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).getBoundingBox() : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox != null ? boundingBox.maxY : 0.0D;
	}

	@Override
	public double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).getBoundingBox() : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox != null ? boundingBox.maxZ : 0.0D;
	}

	@Override
	public double entityBoundingBoxMinX(Object entity) {
		AxisAlignedBB boundingBox = ((Entity) entity).getBoundingBox();
		return boundingBox != null ? boundingBox.minX : 0.0D;
	}

	@Override
	public double entityBoundingBoxMinY(Object entity) {
		AxisAlignedBB boundingBox = ((Entity) entity).getBoundingBox();
		return boundingBox != null ? boundingBox.minY : 0.0D;
	}

	@Override
	public double entityBoundingBoxMinZ(Object entity) {
		AxisAlignedBB boundingBox = ((Entity) entity).getBoundingBox();
		return boundingBox != null ? boundingBox.minZ : 0.0D;
	}

	@Override
	public double entityPlayerChasingPosZ(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71085_bR;
	}

	@Override
	public double entityPlayerPrevChasingPosX(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71091_bM;
	}

	@Override
	public double entityPlayerChasingPosX(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71094_bP;
	}

	@Override
	public double entityPlayerChasingPosY(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71095_bQ;
	}

	@Override
	public double entityPlayerPrevChasingPosY(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71096_bN;
	}

	@Override
	public double entityPlayerPrevChasingPosZ(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71097_bO;
	}

	@Override
	public void renderFirstPersonArm(Object renderplayer, Object entityplayer) {
		((RenderPlayer) renderplayer).func_177138_b((AbstractClientPlayer) entityplayer);
	}

	@Override
	public Object entityGetCollisionBoundingBox(Object entity) {
		return ((Entity) entity).getBoundingBox();
	}

	@Override
	public void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
		((GuiScreen) guiScreen).func_175273_b((Minecraft) minecraft, i, i2);
	}
/*
	@Override
	public Enum itemCameraTransformsTransformTypeNONE() {
		return ItemCameraTransforms.TransformType.NONE;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		return ItemCameraTransforms.TransformType.THIRD_PERSON;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		return ItemCameraTransforms.TransformType.FIRST_PERSON;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeHEAD() {
		return ItemCameraTransforms.TransformType.HEAD;
	}

	@Override
	public Enum itemCameraTransformsTransformTypeGUI() {
		return ItemCameraTransforms.TransformType.GUI;
	}
*/
	@Override
	public void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		((PathNavigateGround) pathNavigateGround).func_179690_a(b);
	}

	@Override
	public void tessellatorStartDrawingQuads(Object tessellator) {
		((Tessellator) tessellator).getWorldRenderer().startDrawingQuads();
	}

	@Override
	public String getUserName(Object entityplayer) {
		return entityplayer instanceof EntityPlayer ? ((EntityPlayer) entityplayer).getName() : null;
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).getWorldRenderer().addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, float f, float f1, float f2) {
		((Tessellator) tessellator).getWorldRenderer().addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	public void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getWorldRenderer().addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	public void tessellatorStartDrawing(Object tessellator, int i, Object vertexFormat) {
		((Tessellator) tessellator).getWorldRenderer().startDrawing(i);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).getWorldRenderer().addVertex(d, d2, d3);
	}

	@Override
	public void tessellatorAddVertex(Object tessellator, double d, double d2, double d3, int i, int i1, int i2, int i3) {
		((Tessellator) tessellator).getWorldRenderer().addVertex(d, d2, d3);
	}

	@Override
	public Object getItem(String s) {
		if (s != null); else return null;
		return Item.itemRegistry.getObject(s);
	}

	@Override
	public Object itemSetTextureName(Object item, String s) {
		return item;
	}

	@Override
	public Map entityListIDtoClassMapping() {
		return EntityList.idToClassMapping;
	}

	@Override
	public void tessellatorDraw(Object tessellator) {
		((Tessellator) tessellator).draw();
	}

	@Override
	public Object entityLivingOnInitialSpawn(Object entityLiving, Object difficultyInstance, Object iEntityLivingData) {
		return ((EntityLiving) entityLiving).func_180482_a((DifficultyInstance) difficultyInstance, (IEntityLivingData) iEntityLivingData);
	}

}