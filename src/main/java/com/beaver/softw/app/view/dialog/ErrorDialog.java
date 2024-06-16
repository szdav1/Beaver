package com.beaver.softw.app.view.dialog;

import javax.swing.JOptionPane;

public final class ErrorDialog {
	private static boolean wasDisplayed = false;

	public static void display(ErrorDialogTitle title, Exception exception) {
		JOptionPane.showMessageDialog(null, exception.getMessage(), title.getTitle(), JOptionPane.ERROR_MESSAGE);
		wasDisplayed = true;
	}

	public static boolean wasDisplayed() {
		return wasDisplayed;
	}
}
