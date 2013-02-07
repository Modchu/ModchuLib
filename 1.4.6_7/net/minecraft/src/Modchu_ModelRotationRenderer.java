package net.minecraft.src;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.smart.render.ModelRotationRenderer;
import net.smart.render.RendererData;

public class Modchu_ModelRotationRenderer extends ModelRotationRenderer
{
    public Modchu_ModelRenderer main;

    public Modchu_ModelRotationRenderer(ModelBase modelbase, int i, int j)
    {
    	super(modelbase, i, j, null);
    	init(modelbase, i, j, (String) null);
    }

    public Modchu_ModelRotationRenderer(ModelBase modelbase, int i, int j, String s)
    {
    	super(modelbase, i, j, null);
    	init(modelbase, i, j, s);
    }

    public Modchu_ModelRotationRenderer(ModelBase modelbase, int i, int j, ModelRotationRenderer modelRotationRenderer) {
    	super(modelbase, i, j, modelRotationRenderer);
    	init(modelbase, i, j, modelRotationRenderer);
    }

    public Modchu_ModelRotationRenderer(ModelBase modelbase) {
    	this(modelbase, 0, 0);
    }

    public Modchu_ModelRotationRenderer(ModelBase modelbase, String s) {
    	this(modelbase, 64, 32, s);
    }

    public void init(ModelBase modelbase, int i, int j, ModelRotationRenderer modelRotationRenderer) {
    	main = new Modchu_ModelRenderer(modelbase, i, j, modelRotationRenderer);
    	setTextureOffset(i, j);
    }

    public void init(ModelBase modelbase, int i, int j, String s) {
    	main = new Modchu_ModelRenderer(modelbase, i, j, s);
    	setTextureOffset(i, j);
    }

    public Modchu_ModelRotationRenderer setTextureOffset(int i, int j) {
    	if (main != null) main.setTextureOffset(i, j);
    	return this;
    }

    public Modchu_ModelRotationRenderer addPlate(String s, float f, float f1, float f2, int i, int j, int k) {
    	main.addPlate(s, f, f1, f2, i, j, k);
    	return this;
    }

    public Modchu_ModelRotationRenderer addPlate(float f, float f1, float f2, int i, int j, int k) {
    	main.addPlate(f, f1, f2, i, j, k);
    	return this;
    }

    public Modchu_ModelRotationRenderer addPlate(float f, float f1, float f2, int i, int j, int k, float f3) {
    	main.addPlate(f, f1, f2, i, j, k, f3);
    	return this;
    }

    public Modchu_ModelRotationRenderer addPlateFreeShape(float[][] vertex, float[][] vertexN, int px, int py)
    {
    	main.addPlateFreeShape(vertex, vertexN, px, py);
    	return this;
    }

    public Modchu_ModelRotationRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN)
    {
    	main.addPlateFreeShape(vertex, texUV, vertexN);
    	return this;
    }

    public Modchu_ModelRotationRenderer addPlateFreeShape(float[][] var1, float[][] var2, float[][] var3, float[] var4)
    {
    	main.addPlateFreeShape(var1, var2, var3, var4);
    	return this;
    }

    public Modchu_ModelRotationRenderer addBall(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    	main.addBall(var1, var2, var3, var4, var5, var6);
    	return this;
    }

    public void clearCubeList() {
    	main.clearCubeList();
    }

    public Modchu_ModelRotationRenderer setItemStack(ItemStack pItemStack) {
    	main.setItemStack(pItemStack);
    	return this;
    }

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack, float scale, int addSupport) {
    	main.renderItems(pEntityLiving, pRender, pRealBlock, pAction, pItemStack, scale, addSupport);
    }

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, ItemStack pItemStack) {
    	main.renderItems(pEntityLiving, pRender, pRealBlock, pAction, pItemStack);
    }

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction) {
    	main.renderItems(pEntityLiving, pRender, pRealBlock, pAction);
    }

    public void renderItems(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, float scale) {
    	main.renderItems(pEntityLiving, pRender, pRealBlock, pAction, scale);
    }

    public boolean renderDecoBlock(EntityLiving pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction, float scale, int addSupport) {
    	return main.renderDecoBlock(pEntityLiving, pRender, pRealBlock, pAction, scale, addSupport);
    }

    public void setRotatePriority(int pValue) {
    	main.setRotatePriority(pValue);
    }

    protected void setRotation() {
    	main.setRotation();
    }

    public void renderObject(float par1, EntityLiving pEntityLiving) {
    	main.renderObject(par1, pEntityLiving);
    }

    @Override
    public void render(float par1)
    {
    	render(par1, null);
    }

    public void render(float par1, EntityLiving pEntityLiving)
    {
    	main.render(par1, pEntityLiving);
    }

    @Override
    public void renderWithRotation(float par1) {
    	main.renderWithRotation(par1);
    }

    @Override
    public void postRender(float par1)
    {
    	main.postRender(par1);
    }

    public void postRenderAll(float par1, EntityLiving pEntityLiving) {
    	main.postRenderAll(par1, pEntityLiving);
    }

    public Modchu_ModelRotationRenderer loadMatrix() {
    	main.loadMatrix();
    	return this;
    }

    @Override
    public Modchu_ModelRotationRenderer addBox(String par1Str, float par2, float par3, float par4, int par5, int par6, int par7) {
    	main.addBox(par1Str, par2, par3, par4, par5, par6, par7);
    	return this;
    }

    @Override
    public Modchu_ModelRotationRenderer addBox(float par1, float par2, float par3, int par4, int par5, int par6) {
    	main.addBox(par1, par2, par3, par4, par5, par6);
    	return this;
    }

    @Override
    public void addBox(float par1, float par2, float par3, int par4, int par5, int par6, float par7) {
    	main.addBox(par1, par2, par3, par4, par5, par6, par7);
    }

    public Modchu_ModelRotationRenderer setRotationPointLM(float f, float f1, float f2) {
    	main.setRotationPointLM(f, f1, f2);
    	return this;
    }

    public boolean getMirror() {
    	return main.getMirror();
    }

    public void setMirror(boolean flag) {
    	main.setMirror(flag);
    }

    public boolean getVisible() {
    	return main.getVisible();
    }

    public boolean setVisible(boolean flag) {
    	return main.setVisible(flag);
    }

    // Deg付きは角度指定が度数法
    public float getRotateAngleX() {
    	return main.getRotateAngleX();
    }

    public float getRotateAngleDegX() {
    	return main.getRotateAngleDegX();
    }

    public float setRotateAngleX(float value) {
    	return main.setRotateAngleX(value);
    }

    public float setRotateAngleDegX(float value) {
    	return main.setRotateAngleDegX(value);
    }

    public float getRotateAngleY() {
    	return main.getRotateAngleY();
    }

    public float getRotateAngleDegY() {
    	return main.getRotateAngleDegY();
    }

    public float setRotateAngleY(float value) {
    	return main.setRotateAngleY(value);
    }

    public float setRotateAngleDegY(float value) {
    	return main.setRotateAngleDegY(value);
    }

    public float getRotateAngleZ() {
    	return main.getRotateAngleZ();
    }

    public float getRotateAngleDegZ() {
    	return main.getRotateAngleDegZ();
    }

    public float setRotateAngleZ(float value) {
    	return main.setRotateAngleZ(value);
    }

    public float setRotateAngleDegZ(float value) {
    	return main.setRotateAngleDegZ(value);
    }

    public Modchu_ModelRotationRenderer setRotateAngle(float x, float y, float z) {
    	main.setRotateAngle(x, y, z);
    	return this;
    }

    public Modchu_ModelRotationRenderer setRotateAngleDeg(float x, float y, float z) {
    	main.setRotateAngleDeg(x, y, z);
    	return this;
    }

    public float getRotationPointX() {
    	return main.getRotationPointX();
    }

    public float setRotationPointX(float value) {
    	return main.setRotationPointX(value);
    }

    public float getRotationPointY() {
    	return main.getRotationPointY();
    }

    public float setRotationPointY(float value) {
    	return main.setRotationPointY(value);
    }

    public float getRotationPointZ() {
    	return main.getRotationPointZ();
    }

    public float setRotationPointZ(float value) {
    	return main.setRotationPointZ(value);
    }

    public void preRotateRender(float f) {
    	main.preRotateRender(f);
    }

    public void preRotateRenderDeg(float f) {
    	main.preRotateRenderDeg(f);
    }

    protected boolean setParentsRotate() {
    	return main.setParentsRotate();
    }

    public void setPreRotationPointLM(float f, float f1, float f2) {
    	main.setPreRotationPointLM(f, f1, f2);
    }

    // バージョン変更に依存させないための関数群

    public void addBoxLM(float f, float f1, float f2, int i, int j, int k) {
        addBox(f, f1, f2, i, j, k);
    }

    public void addBoxLM(float f, float f1, float f2, int i, int j, int k, float f3) {
    	addBox(f, f1, f2, i, j, k, f3);
    }

    public void renderLM(float f) {
    	render(f);
    }

    public void renderWithRotationLM(float f) {
    	renderWithRotation(f);
    }

    public void postRenderLM(float f) {
    	postRender(f);
    }

    public void individuallyHidePreRotateRender(float par1) {
    	main.individuallyHidePreRotateRender(par1);
    }

    public void removeChild(ModelRenderer par1ModelRenderer)
    {
    	main.removeChild(par1ModelRenderer);
    }

    public void clearChildModels() {
    	main.clearChildModels();
    }

    public void setScale(float f, float f1, float f2) {
    	main.setScale(f, f1, f2);
    }

    public void setCompiled(boolean b) {
    	main.setCompiled(b);
    }

    public void reset()
    {
    	main.reset();
    }

    public void fadeStore(float var1)
    {
    	main.fadeStore(var1);
    }

    public void fadeIntermediate(float var1)
    {
    	main.fadeIntermediate(var1);
    }
    //SmartMoving関連↑

    //標準ModelRenderer関連↓
    public void addChild(ModelRenderer par1ModelRenderer)
    {
    	main.addChild(par1ModelRenderer);
    }
/*//b173delete
    public ModelRenderer setTextureSize(int i, int j)
    {
        modchu_ModelRenderer.setTextureSize(i, j);
        return this;
    }
*///b173delete
}
