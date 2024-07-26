package com.beaver.softw.app.control.dialogs.settings;

import java.awt.event.ActionEvent;

import com.beaver.softw.app.control.dialogs.DialogController;
import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.app.view.dialogs.settings.AppearanceSettingsDialog;
import com.beaver.softw.support.config.Configurator;

public final class AppearanceSettingsDialogController extends DialogController {
	public AppearanceSettingsDialogController(final AbstractDialog dialog) {
		super(dialog);
		new AppearanceSettingsDialogKeystrokesController(dialog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.dialog instanceof AppearanceSettingsDialog appearanceSettingsDialog)
			Configurator.updater.updateLookAndFeelConfiguration(appearanceSettingsDialog.getSelectedLookAndFeel());
	}
}
