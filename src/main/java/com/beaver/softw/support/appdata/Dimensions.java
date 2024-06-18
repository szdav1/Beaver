package com.beaver.softw.support.appdata;

import java.awt.Dimension;
import java.awt.Toolkit;

public final class Dimensions {

	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit()
		.getScreenSize();
	private static final ProportionalityHandler ph = new ProportionalityHandler(SCREEN_SIZE);
	public static final int SCREEN_WIDTH = SCREEN_SIZE.width;
	public static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

	public static final int WINDOW_WIDTH = ph.calculate(55);
	public static final int WINDOW_HEIGHT = ph.calculate(55, 'h');
	public static final Dimension WINDOW_DIMENSION = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

	public static final int MENU_WIDTH = WINDOW_WIDTH;
	public static final int MENU_HEIGHT = ph.calculate(2, 'h');
	public static final Dimension MENU_DIMENSION = new Dimension(MENU_WIDTH, MENU_HEIGHT);

	public static final int SIDEBAR_WIDTH = ph.calculate(12);
	public static final int SIDEBAR_HEIGHT = WINDOW_HEIGHT;
	public static final Dimension SIDEBAR_DIMENSION = new Dimension(SIDEBAR_WIDTH, SIDEBAR_HEIGHT);

	public static final int N_BUTTON_WIDTH = ph.calculate(6);
	public static final int BUTTON_HEIGHT = ph.calculate(6, 'h');

	public static final int CONTENT_WIDTH = WINDOW_WIDTH;
	public static final int CONTENT_HEIGHT = WINDOW_HEIGHT;

	public static final int GAP = ph.calculate(1, 'h');

	private Dimensions() {
	}
}
