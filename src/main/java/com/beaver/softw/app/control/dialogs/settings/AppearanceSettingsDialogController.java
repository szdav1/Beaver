package com.beaver.softw.app.control.dialogs.settings;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.beaver.softw.app.control.dialogs.DialogController;
import com.beaver.softw.app.view.dialogs.settings.AppearanceSettingsDialog;
import com.beaver.softw.support.InstanceStarter;
import com.beaver.softw.support.config.Configurator;
import com.beaver.softw.support.config.Language;

public final class AppearanceSettingsDialogController extends DialogController {
	private final AppearanceSettingsDialog appearanceSettingsDialog;

	public AppearanceSettingsDialogController(final AppearanceSettingsDialog appearanceSettingsDialog) {
		this.appearanceSettingsDialog = appearanceSettingsDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Configurator.updater.updateLookAndFeelConfiguration(this.appearanceSettingsDialog.getSelectedLookAndFeel());
		if (JOptionPane.showOptionDialog(
			null,
			Language.get("Question.RestartText"),
			Language.get("Question.RestartTitle"),
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null, null, null
		) == JOptionPane.YES_OPTION)
			InstanceStarter.restartApp();
	}
}
