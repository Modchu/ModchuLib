package modchu.lib;

import java.util.Random;

public interface Modchu_IModelBase {

	public void setLivingAnimations(Object entityliving, float f, float f1, float f2);
	public void render(Object entity, float f, float f1, float f2, float f3, float f4, float f5);
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Object entity);
	public Object getRandomModelBox(Random random);
	public void setTextureOffset(String s, int i, int j);
	public Object getTextureOffset(String s);
	public Object getRightArm();

}
