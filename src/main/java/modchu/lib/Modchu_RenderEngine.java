package modchu.lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import modchu.lib.characteristic.Modchu_AS;
import modchu.lib.characteristic.Modchu_CastHelper;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class Modchu_RenderEngine {
	public static Modchu_RenderEngine instance;
	private static final int displayListsNumber = 2;
	private HashMap<String, Integer> textureMap = new HashMap();
	private BufferedImage missingTextureImage = new BufferedImage(64, 64, 2);
	private IntBuffer imageData = Modchu_AS.getIntBuffer(Modchu_AS.gLAllocationCreateDirectIntBuffer, 4194304);
	//private int boundTexture;
	public boolean anaglyph = false;
	private int boundTexture;

	public Modchu_RenderEngine() {
		instance = this;
		Graphics graphics = missingTextureImage.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 64, 64);
	}

	public void bindTexture(Object resourceLocation) {
		//Modchu_Debug.mDebug("Modchu_RenderEngine bindTexture resourceLocation="+resourceLocation);
		if (resourceLocation instanceof String) bindTexture(Modchu_CastHelper.String(resourceLocation));
		else bindTexture(getResourceLocationString(resourceLocation));
	}

	public void bindTexture(String s) {
		bindTexture(getTexture(s));
	}

	public void bindBufferedImage(String s, BufferedImage image) {
		if (s != null
				&& image != null); else {
			Modchu_Debug.lDebug("Modchu_RenderEngine bindBufferedImage s == null !!");
			return;
		}
		int generateDisplayList = Modchu_AS.getInt(Modchu_AS.gLAllocationGenerateDisplayLists, displayListsNumber);
		bindTexture(generateDisplayList);
		setupTextureExt(image, generateDisplayList, false, false);
		textureMap.put(s, generateDisplayList);
	}

	private void bindTexture(int i) {
		//if (i != boundTexture) {
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, i);
			boundTexture = i;
		//}
	}

	public int getTexture(String s) {
		//Modchu_Debug.mDebug("Modchu_RenderEngine getTexture s="+s);
		if (s != null
				&& !s.isEmpty()); else return -1;
		//Modchu_Debug.mDebug("Modchu_RenderEngine getTexture 1");
		int i = textureMap.containsKey(s) ? textureMap.get(s) : -1;

		if (i > -1) {
			//if (i != boundTexture) 
			//Modchu_Debug.mDebug("Modchu_RenderEngine getTexture i > -1 return i="+i);
			return i;
		} else {
			//Modchu_Debug.mDebug("Modchu_RenderEngine getTexture 2");
			String s0 = s;
			//int generateDisplayList = Modchu_AS.getInt(Modchu_AS.gLAllocationGenerateDisplayLists, displayListsNumber);
			int generateDisplayList = textureMap.size() + 100;
			//Modchu_Debug.mDebug("Modchu_RenderEngine getTexture generateDisplayList="+generateDisplayList);
			try {
				boolean var9 = s0.startsWith("%blur%");
				if (var9) s0 = s0.substring(6);
				boolean var6 = s0.startsWith("%clamp%");
				if (var6) s0 = s0.substring(7);

				InputStream inputStream = getClass().getResourceAsStream(s0);
				//Modchu_Debug.mDebug("Modchu_RenderEngine getTexture inputStream="+inputStream);
				if (inputStream == null) {
					setupTextureExt(missingTextureImage, generateDisplayList, var9, var6);
				} else {
					setupTextureExt(readTextureImage(inputStream), generateDisplayList, var9, var6);
				}
				textureMap.put(s, generateDisplayList);
			} catch (Exception e) {
				e.printStackTrace();
				setupTexture(missingTextureImage, generateDisplayList);
				textureMap.put(s, generateDisplayList);
			}
			//Modchu_Debug.mDebug("Modchu_RenderEngine getTexture ok return.");
			return generateDisplayList;
		}
	}

	public BufferedImage readTextureImage(InputStream inputStream) throws IOException {
		BufferedImage image = ImageIO.read(inputStream);
		inputStream.close();
		return image;
	}

	public void setupTexture(BufferedImage par1BufferedImage, int par2) {
		setupTextureExt(par1BufferedImage, par2, false, false);
	}

	public void setupTextureExt(BufferedImage bufferedImage, int par2, boolean par3, boolean par4) {
		bindTexture(par2);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		if (par3) {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		}

		if (par4) {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		} else {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
		}

		//Modchu_Debug.mDebug("Modchu_RenderEngine setupTextureExt bufferedImage="+bufferedImage);
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		//Modchu_Debug.mDebug("Modchu_RenderEngine setupTextureExt width="+width);
		//Modchu_Debug.mDebug("Modchu_RenderEngine setupTextureExt height="+height);
		int[] var7 = new int[width * height];
		var7 = bufferedImage.getRGB(0, 0, width, height, var7, 0, width);

		if (anaglyph) {
			var7 = colorToAnaglyph(var7);
		}

		imageData.clear();
		imageData.put(var7);
		imageData.position(0).limit(var7.length);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, imageData);
	}

	private int[] colorToAnaglyph(int[] par1ArrayOfInteger) {
		int[] var2 = new int[par1ArrayOfInteger.length];

		for (int var3 = 0; var3 < par1ArrayOfInteger.length; ++var3) {
			int var4 = par1ArrayOfInteger[var3] >> 24 & 255;
			int var5 = par1ArrayOfInteger[var3] >> 16 & 255;
			int var6 = par1ArrayOfInteger[var3] >> 8 & 255;
			int var7 = par1ArrayOfInteger[var3] & 255;
			int var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
			int var9 = (var5 * 30 + var6 * 70) / 100;
			int var10 = (var5 * 30 + var7 * 70) / 100;
			var2[var3] = var4 << 24 | var8 << 16 | var9 << 8 | var10;
		}

		return var2;
	}

	private String getResourceLocationString(Object resourceLocation) {
		if (Modchu_Main.getMinecraftVersion() < 160) return Modchu_CastHelper.String(resourceLocation);
		String resourceDomain = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourceDomain, resourceLocation);
		String resourcePath = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourcePath, resourceLocation);
		//Modchu_Debug.mDebug("Modchu_RenderEngine getResourceLocationString resourcePath="+resourcePath);
		String s = null;
		if (Modchu_Main.getMinecraftVersion() < 170) {
			s = Modchu_Main.lastIndexProcessing(resourcePath, ":");
			StringBuilder sb = new StringBuilder().append(resourceDomain != null ? "/assets/" +resourceDomain+"/" : "/assets/minecraft/"); 
			s = sb.append(s).toString();
			//Modchu_Debug.mDebug("Modchu_RenderEngine getResourceLocationString s="+s);
			return s;
		}
		StringBuilder sb = new StringBuilder().append(resourceDomain != null ? "/assets/" +resourceDomain+"/" : "/assets/minecraft/"); 
		s = sb.append(resourcePath).toString();
		//Modchu_Debug.mDebug("Modchu_RenderEngine getResourceLocationString s="+s);
		return s;
	}

	public InputStream getResourceStream(Object resourceLocation) {
		return getClass().getResourceAsStream(getResourceLocationString(resourceLocation));
	}

	public void deleteTexture(Object resourceLocation) {
		GL11.glDeleteTextures(getTexture(getResourceLocationString(resourceLocation)));
	}

	public void deleteTexture(int i) {
		if (i > -1) GL11.glDeleteTextures(i);
	}

	public void drawPicture(int textureWidth, int textureHeight, float renderWidth, float renderHeight) {
		drawPicture(0, 0, textureWidth, textureHeight, renderWidth, renderHeight, true);
	}

	public void drawPicture(int textureWidth, int textureHeight, float renderWidth, float renderHeight, boolean center) {
		drawPicture(0, 0, textureWidth, textureHeight, renderWidth, renderHeight, center);
	}

	public void drawPicture(int offsetX, int offsetY, int textureWidth, int textureHeight, float renderWidth, float renderHeight) {
		drawPicture(offsetX, offsetY, textureWidth, textureHeight, renderWidth, renderHeight, true);
	}

	public void drawPicture(int offsetX, int offsetY, int textureWidth, int textureHeight, float renderWidth, float renderHeight, boolean center) {
		if (center) GL11.glTranslatef(Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth) / 2f, Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight) / 2f, 0.0F);
		GL11.glBegin(GL11.GL_QUADS);
		float x = -renderWidth / 2;
		float y = renderHeight / 2;
		float x2 = -x;
		float y2 = -y;
		point(textureWidth + offsetX, 0, textureWidth, textureHeight);
		GL11.glVertex2f(x2, y);
		point(offsetX, offsetY, textureWidth, textureHeight);
		GL11.glVertex2f(x, y);
		point(offsetX, textureHeight + offsetY, textureWidth, textureHeight);
		GL11.glVertex2f(x, y2);
		point(textureWidth + offsetX, textureHeight + offsetY, textureWidth, textureHeight);
		GL11.glVertex2f(x2, y2);
		GL11.glEnd();
	}

	public void drawPicture3f(int textureWidth, int textureHeight, float renderWidth, float renderHeight, float z) {
		drawPicture3f(0, 0, textureWidth, textureHeight, renderWidth, renderHeight, z, true);
	}

	public void drawPicture3f(int textureWidth, int textureHeight, float renderWidth, float renderHeight, float z, boolean center) {
		drawPicture3f(0, 0, textureWidth, textureHeight, renderWidth, renderHeight, z, center);
	}

	public void drawPicture3f(int offsetX, int offsetY, int textureWidth, int textureHeight, float renderWidth, float renderHeight, float z) {
		drawPicture3f(offsetX, offsetY, textureWidth, textureHeight, renderWidth, renderHeight, z, true);
	}

	public void drawPicture3f(int offsetX, int offsetY, int textureWidth, int textureHeight, float renderWidth, float renderHeight, float z, boolean center) {
		if (center) GL11.glTranslatef(Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth) / 2f, Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight) / 2f, 0.0F);
		GL11.glBegin(GL11.GL_QUADS);
		float x = -renderWidth / 2;
		float y = renderHeight / 2;
		float x2 = -x;
		float y2 = -y;
		point(textureWidth + offsetX, 0, textureWidth, textureHeight);
		GL11.glVertex3f(x2, y, z);
		point(offsetX, offsetY, textureWidth, textureHeight);
		GL11.glVertex3f(x, y, z);
		point(offsetX, textureHeight + offsetY, textureWidth, textureHeight);
		GL11.glVertex3f(x, y2, z);
		point(textureWidth + offsetX, textureHeight + offsetY, textureWidth, textureHeight);
		GL11.glVertex3f(x2, y2, z);
		GL11.glEnd();
	}

	public void point(int x, int y, int width, int height) {
		GL11.glTexCoord2f(1.0F * x / width, 1.0F * y / height);
	}

	public int colorA(int c) {
		return c >>> 24;
	}

	public int colorR(int c) {
		return c >> 16 & 0xff;
	}

	public int colorG(int c) {
		return c >> 8 & 0xff;
	}

	public int colorB(int c) {
		return c & 0xff;
	}

	public int colorRGB(int r, int g, int b) {
		return 0xff000000 | r << 16 | g << 8 | b;
	}

	public int colorARGB(int a, int r, int g, int b) {
		return a << 24 | r << 16 | g << 8 | b;
	}


}
