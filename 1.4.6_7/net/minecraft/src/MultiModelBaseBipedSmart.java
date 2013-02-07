package net.minecraft.src;

import java.util.Random;

import net.smart.moving.render.SmartMovingModel;
import net.smart.render.IModelPlayer;
import net.smart.render.ModelCapeRenderer;
import net.smart.render.ModelEarsRenderer;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.RendererData;
import net.smart.render.SmartRenderModel;

import org.lwjgl.opengl.GL11;

/**
 * PlayerFormLittleMaid SmartMoving‘Î‰ƒ‚ƒfƒ‹‹¤’ÊƒNƒ‰ƒX
 */
public class MultiModelBaseBipedSmart extends MultiModel_Biped implements IModelPlayer, net.smart.moving.render.IModelPlayer
{
    //Utilities
    public static final float Whole = ((float)Math.PI * 2F);
    public static final float Half = (float)Math.PI;
    public static final float Quarter = ((float)Math.PI / 2F);
    public static final float Eighth = ((float)Math.PI / 4F);
    public static final float Sixteenth = 0.3926991F;
    public static final float Thirtytwoth = 0.19634955F;
    public static final float Sixtyfourth = 0.09817477F;
    public static final float RadiantToAngle = (180F / (float)Math.PI);

    //SmartRenderModel
    public int scaleArmType;
    public int scaleLegType;
    public float totalVerticalDistance;
    public float currentVerticalSpeed;
    public float totalDistance;
    public float currentSpeed;
    public double distance;
    public double verticalDistance;
    public double horizontalDistance;
    public float currentCameraAngle;
    public float currentVerticalAngle;
    public float currentHorizontalAngle;
    public float actualRotation;
    public float forwardRotation;
    public float workingAngle;
    public Modchu_ModelRotationRenderer bipedOuter;
    public Modchu_ModelRotationRenderer bipedTorso;
    public Modchu_ModelRotationRenderer bipedBreast;
    public Modchu_ModelRotationRenderer bipedNeck;
    public Modchu_ModelRotationRenderer bipedRightShoulder;
    public Modchu_ModelRotationRenderer bipedLeftShoulder;
    public Modchu_ModelRotationRenderer bipedPelvic;
    public ModelEarsRenderer bipedEars;
    public ModelCapeRenderer bipedCloak;
    public boolean disabled;
    public boolean attemptToCallRenderCape;
    public RendererData prevOuterRenderData;

    public Modchu_ModelRotationRenderer bipedHead;
    public Modchu_ModelRotationRenderer bipedHeadwear;
    public Modchu_ModelRotationRenderer bipedBody;
    public Modchu_ModelRotationRenderer bipedRightArm;
    public Modchu_ModelRotationRenderer bipedLeftArm;
    public Modchu_ModelRotationRenderer bipedRightLeg;
    public Modchu_ModelRotationRenderer bipedLeftLeg;
    public final PFLM_SmartMovingModel movingModel;

    public MultiModelBaseBipedSmart()
    {
    	this(0.0F);
    }

    public MultiModelBaseBipedSmart(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModelBaseBipedSmart(float f, float f1) {
    	this(f, f1, 64, 32);
    }

    public MultiModelBaseBipedSmart(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    	movingModel = new PFLM_SmartMovingModel(f, this, this);
    }

    public void superSetRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    public static float Factor(float var0, float f, float f1)
    {
    	return f > f1 ? (var0 <= f1 ? 1.0F : (var0 >= f ? 0.0F : (f - var0) / (f - f1))) : (var0 >= f1 ? 1.0F : (var0 <= f ? 0.0F : (var0 - f) / (f1 - f)));
    }

    public void superRender(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
    	super.render(var1, var2, var3, var4, var5, var6, var7);
    }

    public SmartRenderModel getRenderModel()
    {
        return new SmartRenderModel(0.0F, this, this);
    }

    public SmartMovingModel getMovingModel()
    {
        return movingModel;
    }

    public void animateHeadRotation(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateHeadRotation(var1, var2, var3, var4, var5, var6);
    }

    public void animateSleeping(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateSleeping(var1, var2, var3, var4, var5, var6);
    }

    public void animateArmSwinging(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateArmSwinging(var1, var2, var3, var4, var5, var6);
    }

    public void animateRiding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateRiding(var1, var2, var3, var4, var5, var6);
    }

    public void animateLeftArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateLeftArmItemHolding(var1, var2, var3, var4, var5, var6);
    }

    public void animateRightArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateRightArmItemHolding(var1, var2, var3, var4, var5, var6);
    }

    public void animateWorkingBody(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateWorkingBody(var1, var2, var3, var4, var5, var6);
    }

    public void animateWorkingArms(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateWorkingArms(var1, var2, var3, var4, var5, var6);
    }

    public void animateSneaking(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateSneaking(var1, var2, var3, var4, var5, var6);
    }

    public void animateArms(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateArms(var1, var2, var3, var4, var5, var6);
    }

    public void animateBowAiming(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        movingModel.animateBowAiming(var1, var2, var3, var4, var5, var6);
    }

    public void superAnimateHeadRotation(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateSleeping(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateArmSwinging(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateRiding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateLeftArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateRightArmItemHolding(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateWorkingBody(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateWorkingArms(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateSneaking(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superApplyAnimationOffsets(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

    public void superAnimateBowAiming(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    }

	@Override
	public void initialize(ModelRenderer var1, ModelRenderer var2,
			ModelRenderer var3, ModelRenderer var4, ModelRenderer var5,
			ModelRenderer var6, ModelRenderer var7, ModelRenderer var8,
			ModelRenderer var9) {
	}

	@Override
	public void superRenderCloak(float var1) {
	}

	@Override
	public ModelRenderer getOuter() {
		return null;
	}

	@Override
	public ModelRenderer getTorso() {
		return null;
	}

	@Override
	public ModelRenderer getBody() {
		return null;
	}

	@Override
	public ModelRenderer getBreast() {
		return null;
	}

	@Override
	public ModelRenderer getNeck() {
		return null;
	}

	@Override
	public ModelRenderer getHead() {
		return null;
	}

	@Override
	public ModelRenderer getHeadwear() {
		return null;
	}

	@Override
	public ModelRenderer getRightShoulder() {
		return null;
	}

	@Override
	public ModelRenderer getRightArm() {
		return null;
	}

	@Override
	public ModelRenderer getLeftShoulder() {
		return null;
	}

	@Override
	public ModelRenderer getLeftArm() {
		return null;
	}

	@Override
	public ModelRenderer getPelvic() {
		return null;
	}

	@Override
	public ModelRenderer getRightLeg() {
		return null;
	}

	@Override
	public ModelRenderer getLeftLeg() {
		return null;
	}

	@Override
	public ModelRenderer getEars() {
		return null;
	}

	@Override
	public ModelRenderer getCloak() {
		return null;
	}
}
