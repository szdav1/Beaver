package com.beaver.softw.app.view.dialog;

import javax.swing.JOptionPane;

import com.beaver.softw.support.config.Language;

public final class ErrorDialog {
	private static boolean wasDisplayed = false;

	public static void display(ErrorDialogTitle title, final Exception exception) {
		StringBuilder stringBuilder = new StringBuilder();
		StackTraceElement[] stackTraceElements = exception.getStackTrace();

		for (StackTraceElement traceElement : stackTraceElements) {
			stringBuilder.append(traceElement)
				.append("\n");
		}

		JOptionPane.showMessageDialog(
			null,
			title == ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR ?
				Language.get("Error.CouldNotPerformAction") :
				stringBuilder.toString(),
			exception.getMessage() == null ? title.getTitle() : exception.getMessage(),
			JOptionPane.ERROR_MESSAGE
		);

		if (title == ErrorDialogTitle.SETTINGS_XML_FILE_ERROR)
			wasDisplayed = true;
	}

	public static boolean wasDisplayed() {
		return wasDisplayed;
	}
}