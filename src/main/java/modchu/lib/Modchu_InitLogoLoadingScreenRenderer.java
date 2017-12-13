package modchu.lib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Modchu_InitLogoLoadingScreenRenderer {
	public static String message = "";
	public static String currentlyDisplayedText = "";
	public static String progressMessage;
	public static String subProgressMessage;
	public static int subProgress;
	public static Object scaledResolution = null;
	public static Object framebuffer = null;
	public static boolean drawInitLogoLoadingScreen = false;
	private static boolean tempSubProgressFlag;
	private static Object tempResourceLocation;
	private static int tempProgress;

	static {
		if (drawInitLogoLoadingScreen
				&& !Modchu_Main.isServer) {
			int version = Modchu_Main.getMinecraftVersion();
			if (version > 169) {
				if (framebuffer != null); else {
					int displayWidth = Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth);
					int displayHeight = Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight);
					framebuffer = Modchu_Reflect.newInstance("Framebuffer", new Class[]{ int.class, int.class, boolean.class }, new Object[]{ displayWidth, displayHeight, false });
				}
			}
		}
	}

	public static void init() {
		if (!drawInitLogoLoadingScreen
				| Modchu_Main.isServer) return;
		//Modchu_GlStateManager.pushMatrix();
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 169) {
			for (int i = 0; i < 2; i++) {
				int displayWidth = Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth);
				int displayHeight = Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight);
				if (framebuffer != null); else {
					Modchu_GlStateManager.clearColor(1F, 1F, 1F, 1F);
					Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
					Modchu_GlStateManager.clear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
				}
				double x = 0.0D;
				double y = 0.0D;
				Modchu_GlStateManager.disableTexture2D();
				Object tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
				if (version > 180) {
					Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator, 7, Modchu_AS.get("DefaultVertexFormats", version > 188 ? "POSITION_COLOR" : "field_181706_f"));
				} else {
					Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);
				}
				Modchu_AS.set(Modchu_AS.tessellatorSetColorOpaque_I, tessellator, 16777215);
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, 0.0D + x, displayHeight + y, 0.0D, 0.0D, 1.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, displayWidth + x, displayHeight + y, 1.0D, 1.0D, 0.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, displayWidth + x, 0.0D + y, 0.0D, 1.0D, 0.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, 0.0D + x, 0.0D + y, 0.0D, 0.0D, 0.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);
				Modchu_GlStateManager.enableTexture2D();
				boolean debug1 = false;
				endDisplayUpdate(debug1 ? i == 1 : false);
				framebufferClear();
			}
		}
		//Modchu_GlStateManager.popMatrix();
	}

	public static void framebufferClear() {
		if (framebuffer != null) {
			Modchu_AS.set("Framebuffer", "framebufferClear", framebuffer);
			Modchu_AS.set(Modchu_AS.framebufferBindFramebuffer, framebuffer, false);
			//Modchu_GlStateManager.popMatrix();
			//Modchu_GlStateManager.pushMatrix();
			int displayWidth = Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth);
			int displayHeight = Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight);
			Modchu_AS.set(Modchu_AS.framebufferFramebufferRender, framebuffer, displayWidth, displayHeight);
		} else {
			Modchu_GlStateManager.clearColor(1F, 1F, 1F, 1F);
			Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			Modchu_GlStateManager.clear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		}
	}

	public static void setLoadingProgress(int progress, Object resourceLocation) {
		if (!drawInitLogoLoadingScreen
				| Modchu_Main.isServer) return;
		boolean debug = false;
		//Modchu_GlStateManager.pushMatrix();
		//Modchu_GlStateManager.pushAttrib();
		int version = Modchu_Main.getMinecraftVersion();
		Object mc = Modchu_AS.get(Modchu_AS.minecraftGetMinecraft);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setLoadingProgress progress=" + progress + " resourceLocation=" + resourceLocation);
		}

		if (version > 180) {
			scaledResolution = Modchu_Reflect.newInstance("ScaledResolution", new Class[]{ Modchu_Reflect.loadClass("Minecraft") }, new Object[]{ mc });
		} else {
			int displayWidth = Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth);
			int displayHeight = Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight);
			scaledResolution = Modchu_Reflect.newInstance("ScaledResolution", new Class[]{ version > 172 ? Modchu_Reflect.loadClass("Minecraft") : Modchu_Reflect.loadClass("GameSettings"), int.class, int.class }, new Object[]{ version > 172 ? mc : Modchu_AS.get(Modchu_AS.minecraftGameSettings), displayWidth, displayHeight });
		}
		int j = Modchu_AS.getInt("ScaledResolution", "getScaleFactor", scaledResolution);
		int k = Modchu_AS.getInt("ScaledResolution", "getScaledWidth", scaledResolution);
		int l = Modchu_AS.getInt("ScaledResolution", "getScaledHeight", scaledResolution);
		if (debug) Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setLoadingProgress j=" + j + " k=" + k + " l=" + l);
		boolean isFramebufferEnabled = version > 169 ? Modchu_AS.getBoolean("OpenGlHelper", "isFramebufferEnabled") :false;
		if (isFramebufferEnabled) {
			if (framebuffer != null) {
				boolean b = Modchu_AS.set("Framebuffer", "framebufferClear", framebuffer);
				//Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setLoadingProgress @1 framebufferClear b="+b);
			} else {
				Modchu_GlStateManager.clear(256);
			}
		} else {
			Modchu_GlStateManager.clear(256);
		}
		if (framebuffer != null) {
			boolean b = Modchu_AS.set(Modchu_AS.framebufferBindFramebuffer, framebuffer, false);
			if (debug) Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setLoadingProgress @2 framebufferBindFramebuffer b=" + b);
		}
		//for (int i = 0; i < 2; i++) {
			//debug();
			Modchu_GlStateManager.matrixMode(5889);
			Modchu_GlStateManager.loadIdentity();
			Modchu_GlStateManager.ortho(0.0D, Modchu_AS.getDouble("ScaledResolution", "getScaledWidth_double", scaledResolution), Modchu_AS.getDouble("ScaledResolution", "getScaledHeight_double", scaledResolution), 0.0D, 100.0D, 300.0D);
			Modchu_GlStateManager.matrixMode(5888);
			Modchu_GlStateManager.loadIdentity();
			Modchu_GlStateManager.translate(0.0F, 0.0F, -200.0F);

			if (isFramebufferEnabled
					&& framebuffer != null) {
			} else {
				Modchu_GlStateManager.clear(16640);
			}

			try {

				Object tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
				if (version > 169) {
					Object textureManager = Modchu_AS.get(Modchu_AS.minecraftGetTextureManager);
					if (textureManager != null) {
						Modchu_AS.set(Modchu_AS.textureManagerBindTexture, textureManager, resourceLocation);
					} else {
						Modchu_Main.bindBufferedImage(resourceLocation);
					}
				} else {
					Modchu_AS.set(Modchu_AS.renderEngineBindTexture, resourceLocation);
				}
				float f = 32.0F;
				if (version > 180) {
					Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator, 7, Modchu_AS.get("DefaultVertexFormats", version > 188 ? "POSITION_TEX_COLOR" : "field_181709_i"));
				} else {
					Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);
				}
				double posX = 0;
				double posY = 0;
				double posZ = 0;
				double X = 256;
				double Y = 256;
				double x1 = (k - X) / 2 + posX;
				double y1 = (l - Y) / 2 + posY;
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x1, (double) l + y1, posZ, 0.0D, 1.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, (double) l + x1, (double) l + y1, posZ, 1.0D, 1.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, (double) l + x1, y1, posZ, 1.0D, 0.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorAddVertexWithUV, tessellator, x1, y1, posZ, 0.0D, 0.0D, 255, 255, 255, 255);
				Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);

				Object fontRendererObj = Modchu_AS.get(Modchu_AS.minecraftFontRenderer);
				if (progress >= 0) {
					int i1 = 200;
					int j1 = 12;
					int k1 = k / 2 - i1 / 2;
					int l1 = l / 2 + 41;
					if (Modchu_Main.isForge) {
						drawProgressRect(progress, k1, l1, i1, j1);
						String s = progressMessage != null ? progressMessage : progress + " / 100";
						if (s != null
								&& !s.isEmpty()) {
							drawString(fontRendererObj, s, (float) ((k - Modchu_AS.getInt("FontRenderer", "getStringWidth", new Class[]{ String.class }, fontRendererObj, new Object[]{ s })) / 2), (float) (l / 2 + 43), 0);
						}
						if (subProgress > 1) {
							drawProgressRect(subProgress, k1, l1 + 30, i1, j1);
							String s1 = subProgressMessage != null ? subProgressMessage : subProgress + " / 100";
							if (s1 != null
									&& !s1.isEmpty()) {
								drawString(fontRendererObj, s1, (float) ((k - Modchu_AS.getInt("FontRenderer", "getStringWidth", new Class[]{ String.class }, fontRendererObj, new Object[]{ s1 })) / 2), (float) (l / 2 + 73), 0);
							}
						}
					} else {
						modloaderRenderer(progress, resourceLocation);
					}
				}

				if (Modchu_Main.isForge) {
					Modchu_GlStateManager.enableBlend();
					Modchu_GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
					if (debug) Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setLoadingProgress fontRendererObj="+fontRendererObj);
					if (currentlyDisplayedText != null
							&& !currentlyDisplayedText.isEmpty()) {
						drawString(fontRendererObj, currentlyDisplayedText, (float) ((k - Modchu_AS.getInt("FontRenderer", "getStringWidth", new Class[]{ String.class }, fontRendererObj, new Object[]{ currentlyDisplayedText })) / 2), (float) (l / 2 + 30), 0);
					}
					if (message != null
							&& !message.isEmpty()) {
						drawString(fontRendererObj, message, (float) ((k - Modchu_AS.getInt("FontRenderer", "getStringWidth", new Class[]{ String.class }, fontRendererObj, new Object[]{ message })) / 2), (float) (l / 2 + 60), 0);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			boolean debug1 = false;
			//endDisplayUpdate(debug1 ? i == 1 : false);
			endDisplayUpdate(debug1);
			if (framebuffer != null) {
				boolean b = Modchu_AS.set("Framebuffer", "unbindFramebuffer", framebuffer);
				if (debug) Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setLoadingProgress @3 unbindFramebuffer b=" + b);
			}
			if (isFramebufferEnabled) {
				if (framebuffer != null) {
					//Modchu_GlStateManager.popMatrix();
					//Modchu_GlStateManager.pushMatrix();
					boolean b = Modchu_AS.set(Modchu_AS.framebufferFramebufferRender, framebuffer, k * j, l * j);
					//Modchu_GlStateManager.popMatrix();
					//Modchu_GlStateManager.pushMatrix();
					if (debug) Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setLoadingProgress @4 framebufferFramebufferRender b=" + b);
				}
			}
		//}
		tempResourceLocation = resourceLocation;
		tempProgress = progress;
		//Modchu_GlStateManager.popAttrib();
		//Modchu_GlStateManager.popMatrix();
	}

	private static void debug() {
		drawString(Modchu_AS.get(Modchu_AS.minecraftFontRenderer), "[------------------------debug------------------------------]", 0.0F, 0.0F, 0);
		endDisplayUpdate(true);
	}

	private static void endDisplayUpdate() {
		endDisplayUpdate(false);
	}

	private static void endDisplayUpdate(boolean b) {
		int version = Modchu_Main.getMinecraftVersion();
		Object mc = Modchu_AS.get(Modchu_AS.minecraftGetMinecraft);
		if (b) {
			Modchu_Main.debugSleep();
		}
		else if (version > 179) {
			Modchu_AS.set("Minecraft", "updateDisplay", mc);
		}
		else if (version > 169) {
			Modchu_AS.set("Minecraft", "func_147120_f", mc);
		} else {
			Display.update();
		}
		try {
			Thread.yield();
		} catch (Exception e) {
		}
	}

	private static void drawProgressRect(int i, int posX, int posY, int sizeX, int sizeY) {
		int version = Modchu_Main.getMinecraftVersion();
		Object tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
		Modchu_GlStateManager.disableTexture2D();
		if (version > 180) {
			Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator, 7, Modchu_AS.get("DefaultVertexFormats", version > 188 ? "POSITION_COLOR" : "field_181706_f"));
		} else {
			Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);
		}
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX, (double) posY, 0.0D, 128, 128, 128, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX, (double) (posY + sizeY), 0.0D, 128, 128, 128, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + sizeX), (double) (posY + sizeY), 0.0D, 128, 128, 128, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + sizeX), (double) posY, 0.0D, 128, 128, 128, 255);

		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX + 1, (double) posY + 1, 0.0D, 255, 255, 255, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX + 1, (double) (posY + sizeY - 1), 0.0D, 255, 255, 255, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + sizeX - 1), (double) (posY + sizeY - 1), 0.0D, 255, 255, 255, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + sizeX - 1), (double) posY + 1, 0.0D, 255, 255, 255, 255);

		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX + 1, (double) posY + 1, 0.0D, 128, 255, 128, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX + 1, (double) (posY + sizeY - 1), 0.0D, 128, 255, 128, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + (i * 2) - 1), (double) (posY + sizeY - 1), 0.0D, 128, 255, 128, 255);
		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + (i * 2) - 1), (double) posY + 1, 0.0D, 128, 255, 128, 255);
		Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);
		Modchu_GlStateManager.enableTexture2D();
	}

	private static void modloaderRenderer(int progress, Object resourceLocation) {
		int displayWidth = Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth);
		int displayHeight = Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight);
		int version = Modchu_Main.getMinecraftVersion();
		float fontSize = 1.0F;

		int sizeX = 255;
		int sizeY = 10;
		int posX = 0;
		int posY = 170;
		int squareWidth = posX;
		int squareHeight = displayHeight / 2 + posY;
		int k = Modchu_AS.getInt("ScaledResolution", "getScaledWidth", scaledResolution);
		int l = Modchu_AS.getInt("ScaledResolution", "getScaledHeight", scaledResolution);
		if (version < 170) {
			Modchu_GlStateManager.clearColor(1F, 1F, 1F, 1F);
			Modchu_GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			Modchu_GlStateManager.clear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		}
		BufferedImage bufferedImage = Modchu_Main.getBufferedImage(resourceLocation);
		Graphics2D graphics2D = bufferedImage.createGraphics();
		int sizeX2 = 0;
		modloaderDrawProgressRect(graphics2D, progress, posX, posY, sizeX, sizeY);
		String s = progressMessage != null ? progressMessage : progress + " / 100";
		if (s != null
				&& !s.isEmpty()) {
			Modchu_Main.drawString(s, displayWidth / 4 - (s.length() / 2 * 5), displayHeight / 4 + 32, 0, fontSize);
		}
		if (subProgress > 0) {
			modloaderDrawProgressRect(graphics2D, subProgress, posX, posY + 30, sizeX, sizeY);
			String s1 = subProgressMessage != null ? subProgressMessage : subProgress + " / 100";
			if (s1 != null
					&& !s1.isEmpty()) {
				Modchu_Main.drawString(s1, displayWidth / 4 - (s1.length() / 2 * 5), displayHeight / 4 + 62, 0, fontSize);
			}
		}
		if (currentlyDisplayedText != null
				&& !currentlyDisplayedText.isEmpty()) {
			Modchu_Main.drawString(currentlyDisplayedText, displayWidth / 4 - (currentlyDisplayedText.length() / 2 * 5), displayHeight / 4 + 20, 0, fontSize);
		}
		if (message != null
				&& !message.isEmpty()) {
			Modchu_Main.drawString(message, displayWidth / 4 - (message.length() / 2 * 5), displayHeight / 4 + 50, 0, fontSize);
		}
		Modchu_RenderSupport.instance.bindBufferedImage(bufferedImage);
		Modchu_Main.renderTexture((k - 256) / 2, -20, 256, 256);
	}

	private static void modloaderDrawProgressRect(Graphics2D graphics2D, int i, int posX, int posY, int sizeX, int sizeY) {
		if (i > 0) {
			int sizeX2 = sizeX * i / 100;
			graphics2D.setColor(new Color(0x77ff77));
			graphics2D.fillRect(posX + 1, posY + 1, sizeX2 - 1, sizeY - 1);
		}
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawRect(posX, posY, sizeX, sizeY);
	}

	private static int drawString(Object fontRendererObj, String s, float f, float f1, int i) {
		int version = Modchu_Main.getMinecraftVersion();
		return Modchu_AS.getInt("FontRenderer", "drawString", new Class[]{ String.class, int.class, int.class, int.class }, fontRendererObj, new Object[]{ s, Modchu_CastHelper.Int(f, 0, false), Modchu_CastHelper.Int(f1, 0, false), i });
	}

	public static void setSubProgress(int i) {
		if (!drawInitLogoLoadingScreen
				| Modchu_Main.isServer) return;
		subProgress = i;
		//Modchu_Debug.mDebug("Modchu_InitLogoLoadingScreenRenderer setSubProgress subProgress="+subProgress);
		if (subProgress < 1) {
			tempSubProgressFlag = false;
			return;
		}
		String s = subProgress + " / 100";
		int displayWidth = Modchu_AS.getInt(Modchu_AS.minecraftDisplayWidth);
		int displayHeight = Modchu_AS.getInt(Modchu_AS.minecraftDisplayHeight);
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 179) {
			float f = 2.0F;
			if (Modchu_Main.isForge
					&& !tempSubProgressFlag) {
				Modchu_GlStateManager.scale(f, f, f);
				tempSubProgressFlag = true;
			}
		}
		setLoadingProgress(tempProgress, tempResourceLocation);
	}

}