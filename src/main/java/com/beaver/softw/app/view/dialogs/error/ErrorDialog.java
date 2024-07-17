package com.beaver.softw.app.view.dialogs.error;

import javax.swing.JOptionPane;

import com.beaver.softw.support.config.Language;
import lombok.Getter;

public final class ErrorDialog {
	@Getter
	private static boolean displayed = false;

	public static void displayError(ErrorDialogTitle title, final Exception exception) {
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
			title.getTitle(),
			JOptionPane.ERROR_MESSAGE
		);
	}

	public static void displayWarning(ErrorDialogTitle title, String message) {
		JOptionPane.showMessageDialog(null, message, title.getTitle(), JOptionPane.WARNING_MESSAGE);
	}
}