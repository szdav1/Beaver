package com.beaver.softw.app.control.dialogs.settings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.beaver.softw.app.control.dialogs.DialogKeystrokesController;
import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.app.view.dialogs.settings.AppearanceSettingsDialog;
import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.window.WindowStage;
import com.beaver.softw.support.config.Configurator;

public final class AppearanceSettingsDialogKeystrokesController extends DialogKeystrokesController {
	public AppearanceSettingsDialogKeystrokesController(final AbstractDialog dialog) {
		super(dialog);
		this.setupShortcutKeyAction("ENTER", "EnterKeyAction", new EnterKeyAction());
	}

	@Override
	protected void setupShortcutKeyAction(String keyString, String actionName, final AbstractAction action) {
		super.setupShortcutKeyAction(keyString, actionName, action);
	}

	private final class EnterKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (WindowManager.getStage() == WindowStage.DIALOG_OPENED && dialog instanceof AppearanceSettingsDialog appearanceSettingsDialog)
				Configurator.updater.updateLookAndFeelConfiguration(appearanceSettingsDialog.getSelectedLookAndFeel());
		}
	}
}
