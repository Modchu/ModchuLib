package modchu.lib;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

public class Modchu_FontRenderer {

	private static final Object[] unicodePageLocations = Modchu_Reflect.newInstanceArray("ResourceLocation", 256);
	/** Array of width of all the characters in default.png */
	private int[] charWidth = new int[256];
	/** the height in pixels of default text */
	public int FONT_HEIGHT = 9;
	public Random fontRandom = new Random();
	/**
	 * Array of the start/end column (in upper/lower nibble) for every glyph in the /font directory.
	 */
	private byte[] glyphWidth = new byte[65536];
	/**
	 * Array of RGB triplets defining the 16 standard chat colors followed by 16 darker version of the same colors for
	 * drop shadows.
	 */
	private int[] colorCode = new int[32];
	private final Object locationFontTexture;
	/** Current X coordinate at which to draw the next character. */
	private float posX;
	/** Current Y coordinate at which to draw the next character. */
	private float posY;
	/**
	 * If true, strings should be rendered with Unicode fonts instead of the default.png font
	 */
	private boolean unicodeFlag;
	/**
	 * If true, the Unicode Bidirectional Algorithm should be run before rendering any string.
	 */
	private boolean bidiFlag;
	/** Used to specify new red value for the current color. */
	private float red;
	/** Used to specify new blue value for the current color. */
	private float blue;
	/** Used to specify new green value for the current color. */
	private float green;
	/** Used to speify new alpha value for the current color. */
	private float alpha;
	/** Text color of the currently rendering string. */
	private int textColor;
	/** Set if the "k" style (random) is active in currently rendering string */
	private boolean randomStyle;
	/** Set if the "l" style (bold) is active in currently rendering string */
	private boolean boldStyle;
	/** Set if the "o" style (italic) is active in currently rendering string */
	private boolean italicStyle;
	/**
	 * Set if the "n" style (underlined) is active in currently rendering string
	 */
	private boolean underlineStyle;
	/**
	 * Set if the "m" style (strikethrough) is active in currently rendering string
	 */
	private boolean strikethroughStyle;
	private static final String __OBFID = "CL_00000660";

	private float fontSize;

	public Modchu_FontRenderer(Object resourceLocation, boolean flag) {
		fontSize = 1.0F;
		locationFontTexture = resourceLocation;
		unicodeFlag = flag;
		Modchu_RenderEngine.instance.bindTexture(locationFontTexture);

		for (int i = 0; i < 32; ++i) {
			int j = (i >> 3 & 1) * 85;
			int k = (i >> 2 & 1) * 170 + j;
			int l = (i >> 1 & 1) * 170 + j;
			int i1 = (i >> 0 & 1) * 170 + j;

			if (i == 6) {
				k += 85;
			}
			Object gameSettings = Modchu_AS.get(Modchu_AS.minecraftGameSettings);
			if (gameSettings != null
					&& Modchu_AS.getBoolean(Modchu_AS.gameSettingsAnaglyph, gameSettings)) {
				int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
				int k1 = (k * 30 + l * 70) / 100;
				int l1 = (k * 30 + i1 * 70) / 100;
				k = j1;
				l = k1;
				i1 = l1;
			}

			if (i >= 16) {
				k /= 4;
				l /= 4;
				i1 /= 4;
			}

			colorCode[i] = (k & 255) << 16 | (l & 255) << 8 | i1 & 255;
		}

		readGlyphSizes();
	}

	public void onResourceManagerReload(Object iResourceManager) {
		readFontTexture();
	}

	private void readFontTexture() {
		BufferedImage bufferedimage;
		Object resourceManager = Modchu_AS.get(Modchu_AS.minecraftGetResourceManager);
		InputStream inputStream = Modchu_AS.getInputStream(Modchu_AS.resourceGetInputStream, Modchu_AS.get(Modchu_AS.resourceManagerGetResource, resourceManager, locationFontTexture));
		try {
			//bufferedimage = ImageIO.read(Minecraft.getMinecraft().getResourceManager().getResource((ResourceLocation) locationFontTexture).getInputStream());
			bufferedimage = ImageIO.read(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			IOUtils.closeQuietly(inputStream);
   	    }

		int i = bufferedimage.getWidth();
		int j = bufferedimage.getHeight();
		int[] aint = new int[i * j];
		bufferedimage.getRGB(0, 0, i, j, aint, 0, i);
		int k = j / 16;
		int l = i / 16;
		byte b0 = 1;
		float f = 8.0F / (float) l;
		int i1 = 0;

		while (i1 < 256) {
			int j1 = i1 % 16;
			int k1 = i1 / 16;

			if (i1 == 32) {
				charWidth[i1] = 3 + b0;
			}

			int l1 = l - 1;

			while (true) {
				if (l1 >= 0) {
					int i2 = j1 * l + l1;
					boolean flag = true;

					for (int j2 = 0; j2 < k && flag; ++j2) {
						int k2 = (k1 * l + j2) * i;

						if ((aint[i2 + k2] >> 24 & 255) != 0) {
							flag = false;
						}
					}

					if (flag) {
						--l1;
						continue;
					}
				}

				++l1;
				charWidth[i1] = (int) (0.5D + (double) ((float) l1 * f)) + b0;
				++i1;
				break;
			}
		}
	}

	private void readGlyphSizes() {
		Object resourceManager = Modchu_AS.get(Modchu_AS.minecraftGetResourceManager);
		if (resourceManager != null); else Modchu_Debug.lDebug("Modchu_FontRenderer readGlyphSizes() resourceManager == null !!");
		InputStream inputStream = null;
		try {
			//InputStream inputstream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("font/glyph_sizes.bin")).getInputStream();
			//inputstream.read(this.glyphWidth);
			Object resourceLocation = Modchu_Main.newResourceLocation("font/glyph_sizes.bin");
			if (resourceLocation != null); else Modchu_Debug.lDebug("Modchu_FontRenderer readGlyphSizes() resourceLocation == null !!");
			Object resource = Modchu_AS.get(Modchu_AS.resourceManagerGetResource, resourceManager, resourceLocation);
			if (resource != null); else Modchu_Debug.lDebug("Modchu_FontRenderer readGlyphSizes() resource == null !!");
			inputStream = Modchu_AS.getInputStream(Modchu_AS.resourceGetInputStream, resource);
			inputStream.read(glyphWidth);
		} catch (IOException ioexception) {
			throw new RuntimeException(ioexception);
		}
		finally
		{
			IOUtils.closeQuietly(inputStream);
   	    }
	}

	/**
	 * Pick how to render a single character and return the width used.
	 */
	private float renderCharAtPos(int i, char c, boolean b) {
		return c == 32 ? 4.0F : ("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c) != -1 && !unicodeFlag ? renderDefaultChar(i, b) : renderUnicodeChar(c, b));
	}

	/**
	 * Render a single character with the default.png font at current (posX,posY) location...
	 */
	private float renderDefaultChar(int c, boolean b) {
		float f = (float) (c % 16 * 8);
		float f1 = (float) (c / 16 * 8);
		float f2 = b ? 1.0F : 0.0F;
		Modchu_RenderEngine.instance.bindTexture(locationFontTexture);
		float f3 = (float) charWidth[c] - 0.01F;
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
		GL11.glTexCoord2f(f / 128.0F, f1 / 128.0F);
		GL11.glVertex3f(posX + f2, posY, 0.0F);
		GL11.glTexCoord2f(f / 128.0F, (f1 + 7.99F) / 128.0F);
		GL11.glVertex3f(posX - f2, posY + 7.99F, 0.0F);
		GL11.glTexCoord2f((f + f3 - 1.0F) / 128.0F, f1 / 128.0F);
		GL11.glVertex3f(posX + f3 - 1.0F + f2, posY, 0.0F);
		GL11.glTexCoord2f((f + f3 - 1.0F) / 128.0F, (f1 + 7.99F) / 128.0F);
		GL11.glVertex3f(posX + f3 - 1.0F - f2, posY + 7.99F, 0.0F);
		GL11.glEnd();
		return (float) charWidth[c];
	}

	private Object getUnicodePageLocation(int i) {
		if (unicodePageLocations[i] == null) {
			unicodePageLocations[i] = Modchu_Main.newResourceLocation(String.format("textures/font/unicode_page_%02x.png", new Object[]{ Integer.valueOf(i) }));
		}

		return unicodePageLocations[i];
	}

	/**
	 * Load one of the /font/glyph_XX.png into a new GL texture and store the texture ID in glyphTextureName array.
	 */
	private void loadGlyphTexture(int i) {
		Modchu_RenderEngine.instance.bindTexture(getUnicodePageLocation(i));
	}

	/**
	 * Render a single Unicode character at current (posX,posY) location using one of the /font/glyph_XX.png files...
	 */
	private float renderUnicodeChar(char c, boolean b) {
		if (glyphWidth[c] == 0) {
			return 0.0F;
		} else {
			int i = c / 256;
			loadGlyphTexture(i);
			int j = glyphWidth[c] >>> 4;
			int k = glyphWidth[c] & 15;
			float f = (float) j;
			float f1 = (float) (k + 1);
			float f2 = (float) (c % 16 * 16) + f;
			float f3 = (float) ((c & 255) / 16 * 16);
			float f4 = f1 - f - 0.02F;
			float f5 = b ? 1.0F : 0.0F;
			GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
			GL11.glTexCoord2f(f2 / 256.0F, f3 / 256.0F);
			GL11.glVertex3f(posX + f5, posY, 0.0F);
			GL11.glTexCoord2f(f2 / 256.0F, (f3 + 15.98F) / 256.0F);
			GL11.glVertex3f(posX - f5, posY + 7.99F, 0.0F);
			GL11.glTexCoord2f((f2 + f4) / 256.0F, f3 / 256.0F);
			GL11.glVertex3f(posX + f4 / 2.0F + f5, posY, 0.0F);
			GL11.glTexCoord2f((f2 + f4) / 256.0F, (f3 + 15.98F) / 256.0F);
			GL11.glVertex3f(posX + f4 / 2.0F - f5, posY + 7.99F, 0.0F);
			GL11.glEnd();
			return (f1 - f) / 2.0F + 1.0F;
		}
	}

	/**
	 * Draws the specified string with a shadow.
	 */
	public int drawStringWithShadow(String s, int x, int y, int color) {
		return drawString(s, x, y, color, true, fontSize);
	}

	public int drawStringWithShadow(String s, int x, int y, int color, float fontSize) {
		return drawString(s, x, y, color, true, fontSize);
	}

	/**
	 * Draws the specified string.
	 */
	public int drawString(String s, int x, int y, int color) {
		return drawString(s, x, y, color, false, fontSize);
	}

	public int drawString(String s, int x, int y, int color, float fontSize) {
		return drawString(s, x, y, color, false, fontSize);
	}

	/**
	 * Draws the specified string. Args: string, x, y, color, dropShadow
	 */
	public int drawString(String s, int x, int y, int color, boolean flag, float fontSize) {
		//Modchu_GlStateManager.pushMatrix();
		Modchu_GlStateManager.enableAlpha();
		Modchu_GlStateManager.scale(fontSize, fontSize, fontSize);
		resetStyles();
		int l;

		if (flag) {
			l = renderString(s, x + 1, y + 1, color, true);
			l = Math.max(l, renderString(s, x, y, color, false));
		} else {
			l = renderString(s, x, y, color, false);
		}
		//Modchu_GlStateManager.popMatrix();
		return l;
	}

	/**
	 * Apply Unicode Bidirectional Algorithm to string and return a new possibly reordered string for visual rendering.
	 */
	private String bidiReorder(String s) {
		if (Modchu_Main.getMinecraftVersion() > 169) {
			try {
				//Bidi bidi = new Bidi((new ArabicShaping(8)).shape(s), 127);
				Object arabicShaping = Modchu_Reflect.invokeMethod("com.ibm.icu.text.ArabicShaping", "shape", new Class[]{ String.class }, Modchu_Reflect.newInstance("com.ibm.icu.text.ArabicShaping", new Class[]{ int.class }, new Object[]{ 8 }), new Object[]{ s });
				Object bidi = Modchu_Reflect.newInstance("com.ibm.icu.text.Bidi", new Class[]{ Modchu_Reflect.loadClass("com.ibm.icu.text.ArabicShaping"), int.class }, new Object[]{ arabicShaping, 127 });
				//bidi.setReorderingMode(0);
				Modchu_Reflect.invokeMethod("com.ibm.icu.text.Bidi", "setReorderingMode", new Class[]{ int.class }, bidi, new Object[]{ 0 });
				//return bidi.writeReordered(2);
				return Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("com.ibm.icu.text.Bidi", "writeReordered", new Class[]{ int.class }, bidi, new Object[]{ 2 }));
			} catch (Exception e) {
			}
			return s;
		}
		if (s != null
				//&& Bidi.requiresBidi(s.toCharArray(), 0, s.length())) {
				&& Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod("java.text.Bidi", "requiresBidi", new Class[]{ char[].class, int.class, int.class }, new Object[]{ s.toCharArray(), 0, s.length() }))) {
			Object bidi = Modchu_Reflect.newInstance("java.text.Bidi", new Class[]{ String.class, int.class }, new Object[]{ s, -2 });
			byte[] abyte = new byte[Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("java.text.Bidi", "getRunCount", bidi))];
			String[] astring = new String[abyte.length];
			int i;

			for (int j = 0; j < abyte.length; ++j) {
				int k = Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("java.text.Bidi", "getRunStart", new Class[]{ int.class }, bidi, new Object[]{ j }));
				i = Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("java.text.Bidi", "getRunLimit", new Class[]{ int.class }, bidi, new Object[]{ j }));
				int l = Modchu_CastHelper.Int(Modchu_Reflect.invokeMethod("java.text.Bidi", "getRunLevel", new Class[]{ int.class }, bidi, new Object[]{ j }));
				String s1 = s.substring(k, i);
				abyte[j] = (byte) l;
				astring[j] = s1;
			}

			String[] astring1 = (String[]) astring.clone();
			Modchu_Reflect.invokeMethod("java.text.Bidi", "reorderVisually", new Class[]{ byte[].class, int.class, Object[].class, int.class, int.class }, new Object[]{ abyte, 0, astring, 0, abyte.length });
			StringBuilder stringbuilder = new StringBuilder();
			i = 0;

			while (i < astring.length) {
				byte b0 = abyte[i];
				int i1 = 0;

				while (true) {
					if (i1 < astring1.length) {
						if (!astring1[i1].equals(astring[i])) {
							++i1;
							continue;
						}

						b0 = abyte[i1];
					}

					if ((b0 & 1) == 0) {
						stringbuilder.append(astring[i]);
					} else {
						for (i1 = astring[i].length() - 1; i1 >= 0; --i1) {
							char c0 = astring[i].charAt(i1);

							if (c0 == 40) {
								c0 = 41;
							} else if (c0 == 41) {
								c0 = 40;
							}

							stringbuilder.append(c0);
						}
					}

					++i;
					break;
				}
			}

			return stringbuilder.toString();
		}
		return s;
	}

	/**
	 * Reset all style flag fields in the class to false; called at the start of string rendering
	 */
	private void resetStyles() {
		randomStyle = false;
		boldStyle = false;
		italicStyle = false;
		underlineStyle = false;
		strikethroughStyle = false;
	}

	/**
	 * Render a single line string at the current (posX,posY) and update posX
	 */
	private void renderStringAtPos(String s, boolean flag) {
		for (int i = 0; i < s.length(); ++i) {
			char c0 = s.charAt(i);
			int j;
			int k;

			if (c0 == 167 && i + 1 < s.length()) {
				j = "0123456789abcdefklmnor".indexOf(s.toLowerCase().charAt(i + 1));

				if (j < 16) {
					randomStyle = false;
					boldStyle = false;
					strikethroughStyle = false;
					underlineStyle = false;
					italicStyle = false;

					if (j < 0 || j > 15) {
						j = 15;
					}

					if (flag) {
						j += 16;
					}

					k = colorCode[j];
					textColor = k;
					Modchu_GlStateManager.color((float) (k >> 16) / 255.0F, (float) (k >> 8 & 255) / 255.0F, (float) (k & 255) / 255.0F, alpha);
				} else if (j == 16) {
					randomStyle = true;
				} else if (j == 17) {
					boldStyle = true;
				} else if (j == 18) {
					strikethroughStyle = true;
				} else if (j == 19) {
					underlineStyle = true;
				} else if (j == 20) {
					italicStyle = true;
				} else if (j == 21) {
					randomStyle = false;
					boldStyle = false;
					strikethroughStyle = false;
					underlineStyle = false;
					italicStyle = false;
					Modchu_GlStateManager.color(red, blue, green, alpha);
				}

				++i;
			} else {
				j = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c0);

				if (randomStyle && j != -1) {
					do {
						k = fontRandom.nextInt(charWidth.length);
					} while (charWidth[j] != charWidth[k]);

					j = k;
				}

				float f1 = unicodeFlag ? 0.5F : 1.0F;
				boolean flag1 = (c0 == 0 || j == -1 || unicodeFlag) && flag;

				if (flag1) {
					posX -= f1;
					posY -= f1;
				}

				float f = renderCharAtPos(j, c0, italicStyle);

				if (flag1) {
					posX += f1;
					posY += f1;
				}

				if (boldStyle) {
					posX += f1;

					if (flag1) {
						posX -= f1;
						posY -= f1;
					}

					renderCharAtPos(j, c0, italicStyle);
					posX -= f1;

					if (flag1) {
						posX += f1;
						posY += f1;
					}

					++f;
				}

				Object tessellator;

				if (strikethroughStyle) {
					tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
					Modchu_GlStateManager.disableTexture2D();
					Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX, (double) (posY + (float) (FONT_HEIGHT / 2)), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + f), (double) (posY + (float) (FONT_HEIGHT / 2)), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + f), (double) (posY + (float) (FONT_HEIGHT / 2) - 1.0F), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) posX, (double) (posY + (float) (FONT_HEIGHT / 2) - 1.0F), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);
					Modchu_GlStateManager.enableTexture2D();
				}

				if (underlineStyle) {
					tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);
					Modchu_GlStateManager.disableTexture2D();
					Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);
					int l = underlineStyle ? -1 : 0;
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + (float) l), (double) (posY + (float) FONT_HEIGHT), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + f), (double) (posY + (float) FONT_HEIGHT), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + f), (double) (posY + (float) FONT_HEIGHT - 1.0F), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorAddVertex, tessellator, (double) (posX + (float) l), (double) (posY + (float) FONT_HEIGHT - 1.0F), 0.0D);
					Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);
					Modchu_GlStateManager.enableTexture2D();// GL11.glEnable(GL11.GL_TEXTURE_2D);
				}

				posX += (float) ((int) f);
			}
		}
	}

	/**
	 * Render string either left or right aligned depending on bidiFlag
	 */
	private int renderStringAligned(String s, int x, int y, int color, int p_78274_5_, boolean flag) {
		if (bidiFlag) {
			int i1 = getStringWidth(bidiReorder(s));
			x = x + color - i1;
		}

		return renderString(s, x, y, p_78274_5_, flag);
	}

	/**
	 * Render single line string by setting GL color, current (posX,posY), and calling renderStringAtPos()
	 */
	private int renderString(String s, int x, int y, int color, boolean flag) {
		if (s == null) {
			return 0;
		} else {
			if (bidiFlag) {
				s = bidiReorder(s);
			}

			if ((color & -67108864) == 0) {
				color |= -16777216;
			}

			if (flag) {
				color = (color & 16579836) >> 2 | color & -16777216;
			}

			red = (float) (color >> 16 & 255) / 255.0F;
			blue = (float) (color >> 8 & 255) / 255.0F;
			green = (float) (color & 255) / 255.0F;
			alpha = (float) (color >> 24 & 255) / 255.0F;
			Modchu_GlStateManager.color(red, blue, green, alpha);
			posX = (float) x;
			posY = (float) y;
			renderStringAtPos(s, flag);
			return (int) posX;
		}
	}

	/**
	 * Returns the width of this string. Equivalent of FontMetrics.stringWidth(String s).
	 */
	public int getStringWidth(String s) {
		if (s == null) {
			return 0;
		} else {
			int i = 0;
			boolean flag = false;

			for (int j = 0; j < s.length(); ++j) {
				char c0 = s.charAt(j);
				int k = getCharWidth(c0);

				if (k < 0 && j < s.length() - 1) {
					++j;
					c0 = s.charAt(j);

					if (c0 != 108 && c0 != 76) {
						if (c0 == 114 || c0 == 82) {
							flag = false;
						}
					} else {
						flag = true;
					}

					k = 0;
				}

				i += k;

				if (flag && k > 0) {
					++i;
				}
			}

			return i;
		}
	}

	/**
	 * Returns the width of this character as rendered.
	 */
	public int getCharWidth(char c) {
		if (c == 167) {
			return -1;
		} else if (c == 32) {
			return 4;
		} else {
			int i = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c);

			if (c > 0 && i != -1 && !unicodeFlag) {
				return charWidth[i];
			} else if (glyphWidth[c] != 0) {
				int j = glyphWidth[c] >>> 4;
				int k = glyphWidth[c] & 15;

				if (k > 7) {
					k = 15;
					j = 0;
				}

				++k;
				return (k - j) / 2 + 1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * Trims a string to fit a specified Width.
	 */
	public String trimStringToWidth(String s, int size) {
		return trimStringToWidth(s, size, false);
	}

	/**
	 * Trims a string to a specified width, and will reverse it if par3 is set.
	 */
	public String trimStringToWidth(String s, int size, boolean flag) {
		StringBuilder stringbuilder = new StringBuilder();
		int j = 0;
		int k = flag ? s.length() - 1 : 0;
		int l = flag ? -1 : 1;
		boolean flag1 = false;
		boolean flag2 = false;

		for (int i1 = k; i1 >= 0 && i1 < s.length() && j < size; i1 += l) {
			char c0 = s.charAt(i1);
			int j1 = getCharWidth(c0);

			if (flag1) {
				flag1 = false;

				if (c0 != 108 && c0 != 76) {
					if (c0 == 114 || c0 == 82) {
						flag2 = false;
					}
				} else {
					flag2 = true;
				}
			} else if (j1 < 0) {
				flag1 = true;
			} else {
				j += j1;

				if (flag2) {
					++j;
				}
			}

			if (j > size) {
				break;
			}

			if (flag) {
				stringbuilder.insert(0, c0);
			} else {
				stringbuilder.append(c0);
			}
		}

		return stringbuilder.toString();
	}

	/**
	 * Remove all newline characters from the end of the string
	 */
	private String trimStringNewline(String s) {
		while (s != null && s.endsWith("\n")) {
			s = s.substring(0, s.length() - 1);
		}

		return s;
	}

	/**
	 * Splits and draws a String with wordwrap (maximum length is parameter k)
	 */
	public void drawSplitString(String s, int x, int y, int size, int color) {
		resetStyles();
		textColor = color;
		s = trimStringNewline(s);
		renderSplitString(s, x, y, size, false);
	}

	/**
	 * Perform actual work of rendering a multi-line string with wordwrap and with darker drop shadow color if flag is
	 * set
	 */
	private void renderSplitString(String s, int x, int y, int size, boolean flag) {
		List list = listFormattedStringToWidth(s, size);

		for (Iterator iterator = list.iterator(); iterator.hasNext(); y += FONT_HEIGHT) {
			String s1 = (String) iterator.next();
			renderStringAligned(s1, x, y, size, textColor, flag);
		}
	}

	/**
	 * Returns the width of the wordwrapped String (maximum length is parameter k)
	 */
	public int splitStringWidth(String s, int size) {
		return FONT_HEIGHT * listFormattedStringToWidth(s, size).size();
	}

	/**
	 * Set unicodeFlag controlling whether strings should be rendered with Unicode fonts instead of the default.png
	 * font.
	 */
	public void setUnicodeFlag(boolean flag) {
		unicodeFlag = flag;
	}

	/**
	 * Get unicodeFlag controlling whether strings should be rendered with Unicode fonts instead of the default.png
	 * font.
	 */
	public boolean getUnicodeFlag() {
		return unicodeFlag;
	}

	/**
	 * Set bidiFlag to control if the Unicode Bidirectional Algorithm should be run before rendering any string.
	 */
	public void setBidiFlag(boolean flag) {
		bidiFlag = flag;
	}

	/**
	 * Breaks a string into a list of pieces that will fit a specified width.
	 */
	public List listFormattedStringToWidth(String s, int size) {
		return Arrays.asList(wrapFormattedStringToWidth(s, size).split("\n"));
	}

	/**
	 * Inserts newline and formatting into a string to wrap it within the specified width.
	 */
	String wrapFormattedStringToWidth(String s, int size) {
		int j = sizeStringToWidth(s, size);

		if (s.length() <= j) {
			return s;
		} else {
			String s1 = s.substring(0, j);
			char c0 = s.charAt(j);
			boolean flag = c0 == 32 || c0 == 10;
			String s2 = getFormatFromString(s1) + s.substring(j + (flag ? 1 : 0));
			return s1 + "\n" + wrapFormattedStringToWidth(s2, size);
		}
	}

	/**
	 * Determines how many characters from the string will fit into the specified width.
	 */
	private int sizeStringToWidth(String s, int size) {
		int j = s.length();
		int k = 0;
		int l = 0;
		int i1 = -1;

		for (boolean flag = false; l < j; ++l) {
			char c0 = s.charAt(l);

			switch (c0) {
			case 10:
				--l;
				break;
			case 167:
				if (l < j - 1) {
					++l;
					char c1 = s.charAt(l);

					if (c1 != 108 && c1 != 76) {
						if (c1 == 114 || c1 == 82 || isFormatColor(c1)) {
							flag = false;
						}
					} else {
						flag = true;
					}
				}

				break;
			case 32:
				i1 = l;
			default:
				k += getCharWidth(c0);

				if (flag) {
					++k;
				}
			}

			if (c0 == 10) {
				++l;
				i1 = l;
				break;
			}

			if (k > size) {
				break;
			}
		}

		return l != j && i1 != -1 && i1 < l ? i1 : l;
	}

	/**
	 * Checks if the char code is a hexadecimal character, used to set colour.
	 */
	private static boolean isFormatColor(char c) {
		return c >= 48 && c <= 57 || c >= 97 && c <= 102 || c >= 65 && c <= 70;
	}

	/**
	 * Checks if the char code is O-K...lLrRk-o... used to set special formatting.
	 */
	private static boolean isFormatSpecial(char c) {
		return c >= 107 && c <= 111 || c >= 75 && c <= 79 || c == 114 || c == 82;
	}

	/**
	 * Digests a string for nonprinting formatting characters then returns a string containing only that formatting.
	 */
	private static String getFormatFromString(String s) {
		String s1 = "";
		int i = -1;
		int j = s.length();

		while ((i = s.indexOf(167, i + 1)) != -1) {
			if (i < j - 1) {
				char c0 = s.charAt(i + 1);

				if (isFormatColor(c0)) {
					s1 = "\u00a7" + c0;
				} else if (isFormatSpecial(c0)) {
					s1 = s1 + "\u00a7" + c0;
				}
			}
		}

		return s1;
	}

	/**
	 * Get bidiFlag that controls if the Unicode Bidirectional Algorithm should be run before rendering any string
	 */
	public boolean getBidiFlag() {
		return bidiFlag;
	}

	public float getFontSize() {
		return fontSize;
	}

	public void setFontSize(float f) {
		fontSize = f;
	}
}