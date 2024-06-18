package com.beaver.softw.app.view.dialog;

import javax.swing.JOptionPane;

public final class ErrorDialog {
	private static boolean wasDisplayed = false;

	public static void display(ErrorDialogTitle title, final StackTraceElement[] stackTraceElement) {
		StringBuilder strb = new StringBuilder();

		for (StackTraceElement traceElement : stackTraceElement) {
			strb.append(traceElement)
				.append("\n");
		}

		JOptionPane.showMessageDialog(null, strb.toString(), title.getTitle(), JOptionPane.ERROR_MESSAGE);
		wasDisplayed = true;
	}

	public static boolean wasDisplayed() {
		return wasDisplayed;
	}
}
