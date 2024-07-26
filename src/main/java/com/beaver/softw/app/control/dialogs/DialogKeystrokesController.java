package com.beaver.softw.app.control.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.beaver.softw.app.control.AbstractKeystrokesController;
import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.app.view.window.WindowManager;

public class DialogKeystrokesController extends AbstractKeystrokesController {
	protected final AbstractDialog dialog;

	public DialogKeystrokesController(final AbstractDialog dialog) {
		this.dialog = dialog;
		this.setupShortcutKeyAction("ESCAPE", "EscapeKeyAction", new EscapeKeyAction());
	}

	@Override
	protected void setupShortcutKeyAction(String keyString, String actionName, final AbstractAction action) {
		this.dialog.getRootPane()
			.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke(keyString), actionName);

		this.dialog.getRootPane()
			.getActionMap()
			.put(actionName, action);
	}

	private static final class EscapeKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (WindowManager.getStage()) {
				case DIALOG_OPENED -> WindowManager.closeOpenedDialog();
			}
		}
	}
}
