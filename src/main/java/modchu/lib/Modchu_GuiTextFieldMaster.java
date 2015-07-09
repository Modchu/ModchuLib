package modchu.lib;import java.util.HashMap;public class Modchu_GuiTextFieldMaster extends Modchu_GuiMasterBasis {	/**	 * Have the font renderer from GuiScreen to render the textbox text into the screen.	 */	public Object fontRenderer;	public int xPos;	public int yPos;	/** The width of this text field. */	public int width;	public int height;	/** Have the current text beign edited on the textbox. */	public String text = "";	public int maxStringLength = 32;	public int cursorCounter;	public boolean enableBackgroundDrawing = true;	/**	 * if true the textbox can lose focus by clicking elsewhere on the screen	 */	public boolean canLoseFocus = true;	/**	 * If this value is true along isEnabled, keyTyped will process the keys.	 */	public boolean isFocused = false;	/**	 * If this value is true along isFocused, keyTyped will process the keys.	 */	public boolean isEnabled = true;	/**	 * The current character index that should be used as start of the rendered text.	 */	public int lineScrollOffset = 0;	public int cursorPosition = 0;	/** other selection position, maybe the same as the cursor */	public int selectionEnd = 0;	public int enabledColor = 14737632;	public int disabledColor = 7368816;	/** True if this textbox is visible */	public boolean visible = true;	public Modchu_GuiTextFieldMaster(HashMap<String, Object> map) {		super(map);		fontRenderer = map.get("Object");		xPos = (Integer)map.get("Integer");		yPos = (Integer)map.get("Integer1");		width = (Integer)map.get("Integer2");		height = (Integer)map.get("Integer3");	}	/**	 * Increments the cursor counter	 */	public void updateCursorCounter() {		++cursorCounter;	}	/**	 * Sets the text of the textbox.	 */	public void setText(String par1Str) {		if (par1Str.length() > maxStringLength) {			text = par1Str.substring(0, maxStringLength);		} else {			text = par1Str;		}		setCursorPositionEnd();	}	/**	 * Returns the text beign edited on the textbox.	 */	public String getText() {		return text;	}	/**	 * @return returns the text between the cursor and selectionEnd	 */	public String getSelectedtext() {		int var1 = cursorPosition < selectionEnd ? cursorPosition : selectionEnd;		int var2 = cursorPosition < selectionEnd ? selectionEnd : cursorPosition;		return text.substring(var1, var2);	}	/**	 * replaces selected text, or inserts text at the position on the cursor	 */	public void writeText(String par1Str) {		String var2 = "";		String var3 = Modchu_AS.getString(Modchu_AS.chatAllowedCharactersFilterAllowedCharacters, par1Str);		int var4 = cursorPosition < selectionEnd ? cursorPosition : selectionEnd;		int var5 = cursorPosition < selectionEnd ? selectionEnd : cursorPosition;		int var6 = maxStringLength - text.length() - (var4 - selectionEnd);		boolean var7 = false;		if (text.length() > 0) {			var2 = var2 + text.substring(0, var4);		}		int var8;		if (var6 < var3.length()) {			var2 = var2 + var3.substring(0, var6);			var8 = var6;		} else {			var2 = var2 + var3;			var8 = var3.length();		}		if (text.length() > 0 && var5 < text.length()) {			var2 = var2 + text.substring(var5);		}		text = var2;		moveCursorBy(var4 - selectionEnd + var8);	}	/**	 * Deletes the specified number of words starting at the cursor position. Negative numbers will delete words left of	 * the cursor.	 */	public void deleteWords(int par1) {		if (text.length() != 0) {			if (selectionEnd != cursorPosition) {				writeText("");			} else {				deleteFromCursor(getNthWordFromCursor(par1) - cursorPosition);			}		}	}	/**	 * delete the selected text, otherwsie deletes characters from either side of the cursor. params: delete num	 */	public void deleteFromCursor(int par1) {		if (text.length() != 0) {			if (selectionEnd != cursorPosition) {				writeText("");			} else {				boolean var2 = par1 < 0;				int var3 = var2 ? cursorPosition + par1 : cursorPosition;				int var4 = var2 ? cursorPosition : cursorPosition + par1;				String var5 = "";				if (var3 >= 0) {					var5 = text.substring(0, var3);				}				if (var4 < text.length()) {					var5 = var5 + text.substring(var4);				}				text = var5;				if (var2) {					moveCursorBy(par1);				}			}		}	}	/**	 * see @getNthNextWordFromPos() params: N, position	 */	public int getNthWordFromCursor(int par1) {		return getNthWordFromPos(par1, getCursorPosition());	}	/**	 * gets the position of the nth word. N may be negative, then it looks backwards. params: N, position	 */	public int getNthWordFromPos(int par1, int par2) {		return func_73798_a(par1, getCursorPosition(), true);	}	public int func_73798_a(int par1, int par2, boolean par3) {		int var4 = par2;		boolean var5 = par1 < 0;		int var6 = Math.abs(par1);		for (int var7 = 0; var7 < var6; ++var7) {			if (var5) {				while (par3 && var4 > 0 && text.charAt(var4 - 1) == 32) {					--var4;				}				while (var4 > 0 && text.charAt(var4 - 1) != 32) {					--var4;				}			} else {				int var8 = text.length();				var4 = text.indexOf(32, var4);				if (var4 == -1) {					var4 = var8;				} else {					while (par3 && var4 < var8 && text.charAt(var4) == 32) {						++var4;					}				}			}		}		return var4;	}	/**	 * Moves the text cursor by a specified number of characters and clears the selection	 */	public void moveCursorBy(int par1) {		setCursorPosition(selectionEnd + par1);	}	/**	 * sets the position of the cursor to the provided index	 */	public void setCursorPosition(int par1) {		cursorPosition = par1;		int var2 = text.length();		if (cursorPosition < 0) {			cursorPosition = 0;		}		if (cursorPosition > var2) {			cursorPosition = var2;		}		setSelectionPos(cursorPosition);	}	/**	 * sets the cursors position to the beginning	 */	public void setCursorPositionZero() {		setCursorPosition(0);	}	/**	 * sets the cursors position to after the text	 */	public void setCursorPositionEnd() {		setCursorPosition(text.length());	}	/**	 * Call this method from you GuiScreen to process the keys into textbox.	 */	public boolean textboxKeyTyped(char par1, int par2) {		if (isEnabled && isFocused) {			boolean isShiftKeyDown = Modchu_AS.getBoolean("GuiScreen", "isShiftKeyDown");			boolean isCtrlKeyDown = Modchu_AS.getBoolean("GuiScreen", "isCtrlKeyDown");			switch (par1) {			case 1:				setCursorPositionEnd();				setSelectionPos(0);				return true;			case 3:				Modchu_AS.set("GuiScreen", "setClipboardString", getSelectedtext());				return true;			case 22:				writeText(Modchu_AS.getString("GuiScreen", "getClipboardString"));				return true;			case 24:				Modchu_AS.set("GuiScreen", "setClipboardString", getSelectedtext());				writeText("");				return true;			default:				switch (par2) {				case 14:					if (isCtrlKeyDown) {						deleteWords(-1);					} else {						deleteFromCursor(-1);					}					return true;				case 199:					if (isShiftKeyDown) {						setSelectionPos(0);					} else {						setCursorPositionZero();					}					return true;				case 203:					if (isShiftKeyDown) {						if (isCtrlKeyDown) {							setSelectionPos(getNthWordFromPos(-1, getSelectionEnd()));						} else {							setSelectionPos(getSelectionEnd() - 1);						}					} else if (isCtrlKeyDown) {						setCursorPosition(getNthWordFromCursor(-1));					} else {						moveCursorBy(-1);					}					return true;				case 205:					if (isShiftKeyDown) {						if (isCtrlKeyDown) {							setSelectionPos(getNthWordFromPos(1, getSelectionEnd()));						} else {							setSelectionPos(getSelectionEnd() + 1);						}					} else if (isCtrlKeyDown) {						setCursorPosition(getNthWordFromCursor(1));					} else {						moveCursorBy(1);					}					return true;				case 207:					if (isShiftKeyDown) {						setSelectionPos(text.length());					} else {						setCursorPositionEnd();					}					return true;				case 211:					if (isCtrlKeyDown) {						deleteWords(1);					} else {						deleteFromCursor(1);					}					return true;				default:					if (Modchu_AS.getBoolean("ChatAllowedCharacters", "isAllowedCharacter", par1)) {						writeText(Character.toString(par1));						return true;					} else {						return false;					}				}			}		} else {			return false;		}	}	/**	 * Args: x, y, buttonClicked	 */	public void mouseClicked(int par1, int par2, int par3) {		boolean var4 = par1 >= xPos && par1 < xPos + width && par2 >= yPos && par2 < yPos + height;		if (canLoseFocus) {			setFocused(isEnabled && var4);		}		if (isFocused && par3 == 0) {			int var5 = par1 - xPos;			if (enableBackgroundDrawing) {				var5 -= 4;			}			String var6 = Modchu_AS.getString("FontRenderer", "trimStringToWidth", new Class[]{ String.class, int.class }, fontRenderer, new Object[]{ text.substring(lineScrollOffset), getWidth() });			setCursorPosition(Modchu_AS.getString("FontRenderer", "trimStringToWidth", new Class[]{ String.class, int.class }, fontRenderer, new Object[]{ var6, var5 }).length() + lineScrollOffset);		}	}	/**	 * Draws the textbox	 */	public void drawTextBox() {		if (getVisible()) {			if (getEnableBackgroundDrawing()) {				Modchu_AS.set("Gui", "drawRect", xPos - 1, yPos - 1, xPos + width + 1, yPos + height + 1, -6250336);				Modchu_AS.set("Gui", "drawRect", xPos, yPos, xPos + width, yPos + height, -16777216);			}			int var1 = isEnabled ? enabledColor : disabledColor;			int var2 = cursorPosition - lineScrollOffset;			int var3 = selectionEnd - lineScrollOffset;			String var4 = Modchu_AS.getString("FontRenderer", "trimStringToWidth", new Class[]{ String.class, int.class }, fontRenderer, new Object[]{ text.substring(lineScrollOffset), getWidth() });			boolean var5 = var2 >= 0 && var2 <= var4.length();			boolean var6 = isFocused && cursorCounter / 6 % 2 == 0 && var5;			int var7 = enableBackgroundDrawing ? xPos + 4 : xPos;			int var8 = enableBackgroundDrawing ? yPos + (height - 8) / 2 : yPos;			int var9 = var7;			if (var3 > var4.length()) {				var3 = var4.length();			}			if (var4.length() > 0) {				String var10 = var5 ? var4.substring(0, var2) : var4;				var9 = Modchu_AS.getInt("FontRenderer", "drawStringWithShadow", new Class[]{ String.class, int.class, int.class, int.class }, new Object[]{ var10, var7, var8, var1 });			}			boolean var13 = cursorPosition < text.length() || text.length() >= getMaxStringLength();			int var11 = var9;			if (!var5) {				var11 = var2 > 0 ? var7 + width : var7;			} else if (var13) {				var11 = var9 - 1;				--var9;			}			if (var4.length() > 0 && var5 && var2 < var4.length()) {				Modchu_AS.getInt("FontRenderer", "drawStringWithShadow", new Class[]{ String.class, int.class, int.class, int.class }, new Object[]{ var4.substring(var2), var9, var8, var1 });			}			if (var6) {				if (var13) {					Modchu_AS.set("Gui", "drawRect", var11, var8 - 1, var11 + 1, var8 + 1 + Modchu_AS.getInt("fontRenderer", "FONT_HEIGHT"), -3092272);				} else {					Modchu_AS.getInt("FontRenderer", "drawStringWithShadow", new Class[]{ String.class, int.class, int.class, int.class }, new Object[]{ "_", var11, var8, var1 });				}			}			if (var3 != var2) {				int var12 = var7 + Modchu_AS.getInt("fontRenderer", "getStringWidth", var4.substring(0, var3));				drawCursorVertical(var11, var8 - 1, var12 - 1, var8 + 1 + Modchu_AS.getInt("fontRenderer", "FONT_HEIGHT"));			}		}	}	/**	 * draws the vertical line cursor in the textbox	 */	public void drawCursorVertical(int par1, int par2, int par3, int par4) {		int var5;		if (par1 < par3) {			var5 = par1;			par1 = par3;			par3 = var5;		}		if (par2 < par4) {			var5 = par2;			par2 = par4;			par4 = var5;		}		Object tessellator = Modchu_AS.get(Modchu_AS.tessellatorInstance);		Modchu_GlStateManager.color(0.0F, 0.0F, 255.0F, 255.0F);		Modchu_GlStateManager.disableTexture2D();		Modchu_GlStateManager.enableColorLogic();		Modchu_GlStateManager.colorLogicOp(5387);		Modchu_AS.set(Modchu_AS.tessellatorStartDrawingQuads, tessellator);		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, (double) par1, (double) par4, 0.0D);		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, (double) par3, (double) par4, 0.0D);		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, (double) par3, (double) par2, 0.0D);		Modchu_AS.set(Modchu_AS.tessellatorAddVertex, (double) par1, (double) par2, 0.0D);		Modchu_AS.set(Modchu_AS.tessellatorDraw, tessellator);		Modchu_GlStateManager.disableColorLogic();		Modchu_GlStateManager.enableTexture2D();	}	public void setMaxStringLength(int par1) {		maxStringLength = par1;		if (text.length() > par1) {			text = text.substring(0, par1);		}	}	/**	 * returns the maximum number of character that can be contained in this textbox	 */	public int getMaxStringLength() {		return maxStringLength;	}	/**	 * returns the current position of the cursor	 */	public int getCursorPosition() {		return cursorPosition;	}	/**	 * get enable drawing background and outline	 */	public boolean getEnableBackgroundDrawing() {		return enableBackgroundDrawing;	}	/**	 * enable drawing background and outline	 */	public void setEnableBackgroundDrawing(boolean par1) {		enableBackgroundDrawing = par1;	}	/**	 * Sets the text colour for this textbox (disabled text will not use this colour)	 */	public void setTextColor(int par1) {		enabledColor = par1;	}	public void setDisabledTextColour(int par1) {		disabledColor = par1;	}	/**	 * setter for the focused field	 */	public void setFocused(boolean par1) {		if (par1 && !isFocused) {			cursorCounter = 0;		}		isFocused = par1;	}	/**	 * getter for the focused field	 */	public boolean isFocused() {		return isFocused;	}	public void setEnabled(boolean par1) {		isEnabled = par1;	}	/**	 * the side of the selection that is not the cursor, maye be the same as the cursor	 */	public int getSelectionEnd() {		return selectionEnd;	}	/**	 * returns the width of the textbox depending on if the the box is enabled	 */	public int getWidth() {		return getEnableBackgroundDrawing() ? width - 8 : width;	}	/**	 * Sets the position of the selection anchor (i.e. position the selection was started at)	 */	public void setSelectionPos(int par1) {		int var2 = text.length();		if (par1 > var2) {			par1 = var2;		}		if (par1 < 0) {			par1 = 0;		}		selectionEnd = par1;		if (fontRenderer != null) {			if (lineScrollOffset > var2) {				lineScrollOffset = var2;			}			int var3 = getWidth();			String var4 = Modchu_AS.getString("FontRenderer", "trimStringToWidth", new Class[]{ String.class, int.class }, fontRenderer, new Object[]{ text.substring(lineScrollOffset), var3 });			int var5 = var4.length() + lineScrollOffset;			if (par1 == lineScrollOffset) {				lineScrollOffset -= Modchu_AS.getString("FontRenderer", "trimStringToWidth", new Class[]{ String.class, int.class, boolean.class }, fontRenderer, new Object[]{ text, var3, true }).length();			}			if (par1 > var5) {				lineScrollOffset += par1 - var5;			} else if (par1 <= lineScrollOffset) {				lineScrollOffset -= lineScrollOffset - par1;			}			if (lineScrollOffset < 0) {				lineScrollOffset = 0;			}			if (lineScrollOffset > var2) {				lineScrollOffset = var2;			}		}	}	/**	 * if true the textbox can lose focus by clicking elsewhere on the screen	 */	public void setCanLoseFocus(boolean par1) {		canLoseFocus = par1;	}	/**	 * @return {@code true} if this textbox is visible	 */	public boolean getVisible() {		return visible;	}	/**	 * Sets whether or not this textbox is visible	 */	public void setVisible(boolean par1) {		visible = par1;	}}