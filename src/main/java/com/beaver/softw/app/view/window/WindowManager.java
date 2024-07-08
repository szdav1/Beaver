package com.beaver.softw.app.view.window;

import javax.swing.JOptionPane;

import com.beaver.softw.support.config.Language;

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

	public static WindowStage getStage() {
		return window.getStage();
	}

	public static void setStage(final WindowStage stage) {
		window.setStage(stage);
	}

	public static void showExitConfirmationWindow() {
		if (JOptionPane.showConfirmDialog(null, Language.get("Question.ConfirmExit"), Language.get("Question.ConfirmExitTitle"), JOptionPane.YES_NO_OPTION) == 0) {
			window.dispose();
			System.exit(0);
		}
	}

	public static void resetWindow() {
		window.resetToolbar();
	}

	public static void disableWindow() {
		window.setEnabled(false);
	}

	public static void enableWindow() {
		window.setEnabled(true);
	}

	public static void showAppearanceSettingsDialog() {
		setStage(WindowStage.DISABLED);
		disableWindow();
		window.getAppearanceSettingsDialog()
			.reset()
			.setVisible(true);
	}
}