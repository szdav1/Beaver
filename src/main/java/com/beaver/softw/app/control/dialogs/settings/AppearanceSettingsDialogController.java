package com.beaver.softw.app.control.dialogs.settings;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.beaver.softw.app.control.dialogs.DialogController;
import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.app.view.dialogs.settings.AppearanceSettingsDialog;
import com.beaver.softw.app.run.InstanceStarter;
import com.beaver.softw.support.config.Configurator;
import com.beaver.softw.support.config.Language;

public final class AppearanceSettingsDialogController extends DialogController {
	public AppearanceSettingsDialogController(final AbstractDialog dialog) {
		super(dialog);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.dialog instanceof AppearanceSettingsDialog appearanceSettingsDialog) {
			Configurator.updater.updateLookAndFeelConfiguration(appearanceSettingsDialog.getSelectedLookAndFeel());
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
}
