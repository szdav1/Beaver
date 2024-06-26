package com.beaver.softw.app.view.window;

public final class WindowManager {
	private static Window window;
	private static boolean initialized = false;

	private WindowManager() {
	}

	static void init(final Window window) {
		if (initialized)
			return;

		WindowManager.window = window;
		initialized = true;
	}

	public static void repaint() {
		if (!initialized)
			return;

		window.repaint();
	}

}