package com.beaver.softw.app.view.dialog;

import java.util.List;
import java.util.Objects;

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

		if (title == ErrorDialogTitle.SETTINGS_XML_FILE_ERROR)
			wasDisplayed = true;
	}

	public static boolean wasDisplayed() {
		return wasDisplayed;
	}
}