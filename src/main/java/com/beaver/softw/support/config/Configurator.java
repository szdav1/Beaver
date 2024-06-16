package com.beaver.softw.support.config;

import java.util.HashMap;

import javax.swing.UIManager;

import com.beaver.softw.app.view.dialog.ErrorDialog;
import com.beaver.softw.app.view.dialog.ErrorDialogTitle;
import com.beaver.softw.support.config.xml.LanguageReader;
import com.beaver.softw.support.config.xml.SettingsReader;

public final class Configurator {
	private static HashMap<String, String> settings;

	public static void configure(final String settingsFilePath) {
		loadSettingsConfiguration(settingsFilePath);
		loadLanguageConfiguration();

		try {
			UIManager.setLookAndFeel(settings.get("LookAndFeel"));
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.XML_RESOURCE_ERROR, exc);
		}
	}

	private static void loadSettingsConfiguration(final String settingsFilePath) {
		SettingsReader sr = new SettingsReader();
		sr.readFromXML(settingsFilePath);
		settings = sr.getData();
	}

	private static void loadLanguageConfiguration() {
		LanguageReader lr = new LanguageReader();
		lr.readFromXML("/language/"+settings.get("Language"));
		Language.init(lr.getData());
	}
}
