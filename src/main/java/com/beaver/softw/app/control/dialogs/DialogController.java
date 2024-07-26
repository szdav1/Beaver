package com.beaver.softw.app.control.dialogs;

import java.awt.event.WindowEvent;

import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.app.view.window.WindowManager;

public class DialogController extends AbstractDialogController {
	protected final AbstractDialog dialog;

	public DialogController(final AbstractDialog dialog) {
		this.dialog = dialog;
		new DialogKeystrokesController(dialog);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		WindowManager.closeOpenedDialog();
	}
}