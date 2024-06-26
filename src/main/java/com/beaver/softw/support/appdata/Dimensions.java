package com.beaver.softw.support.appdata;

import java.awt.Dimension;
import java.awt.Toolkit;

public final class Dimensions {
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit()
		.getScreenSize();
	public static final int SCREEN_WIDTH = SCREEN_SIZE.width;
	public static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

	public static final int WINDOW_WIDTH = (int) (SCREEN_WIDTH*(1000.0/SCREEN_WIDTH*100.0)/100.0);
	public static final int WINDOW_HEIGHT = (int) (SCREEN_HEIGHT*(600.0/SCREEN_HEIGHT*100.0)/100.0);
	public static final Dimension WINDOW_DIMENSION = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

	private static final ProportionalityHandler ph = new ProportionalityHandler(WINDOW_DIMENSION);

	public static final int MENU_WIDTH = WINDOW_WIDTH;
	public static final int MENU_HEIGHT = ph.calculate(3);
	public static final Dimension MENU_DIMENSION = new Dimension(MENU_WIDTH, MENU_HEIGHT);

	public static final int SIDEBAR_WIDTH = ph.calculate(18);
	public static final int SIDEBAR_HEIGHT = WINDOW_HEIGHT;
	public static final Dimension SIDEBAR_DIMENSION = new Dimension(SIDEBAR_WIDTH, SIDEBAR_HEIGHT);

	public static final int N_BUTTON_WIDTH = ph.calculate(15);
	public static final int BUTTON_HEIGHT = MENU_HEIGHT;
	public static final Dimension N_BUTTON_DIMENSION = new Dimension(N_BUTTON_WIDTH, BUTTON_HEIGHT);

	public static final int CONTENT_WIDTH = WINDOW_WIDTH;
	public static final int CONTENT_HEIGHT = WINDOW_HEIGHT;

	public static final int GAP = ph.calculate(1, 'h');

	public static final int TOOL_BAR_WIDTH = WINDOW_WIDTH;
	public static final int TOOL_BAR_HEIGHT = BUTTON_HEIGHT;
	public static final Dimension TOOL_BAR_DIMENSIONS = new Dimension(TOOL_BAR_WIDTH, TOOL_BAR_HEIGHT);

	private Dimensions() {
	}
}