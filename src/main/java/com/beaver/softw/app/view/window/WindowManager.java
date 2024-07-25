package com.beaver.softw.app.view.window;

import javax.swing.JOptionPane;

import com.beaver.softw.app.view.dialogs.AbstractDialog;
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

	public static void closeWindow() {
		window.dispose();
		System.exit(0);
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
		if (JOptionPane.showConfirmDialog(null, Language.get("Question.ConfirmExit"), Language.get("Question.ConfirmExitTitle"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			window.dispose();
			System.exit(0);
		}
	}

	public static void resetWindow() {
		window.resetToolbar();
	}

	public static void disableWindow() {
		setStage(WindowStage.DISABLED);
		window.setEnabled(false);
	}

	public static void enableWindow() {
		setStage(WindowStage.NORMAL);
		window.setEnabled(true);
	}

	public static void setOpenedDialog(final AbstractDialog dialog) {
		setStage(WindowStage.DIALOG_OPENED);
		window.setOpenedDialog(dialog);
	}

	public static void closeOpenedDialog() {
		window.getOpenedDialog()
				.dispose();
		window.setOpenedDialog(null);
		setStage(WindowStage.NORMAL);
	}
}