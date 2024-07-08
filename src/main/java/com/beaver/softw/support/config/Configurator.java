package com.beaver.softw.support.config;

import java.util.HashMap;

import javax.swing.UIManager;

import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import com.beaver.softw.support.config.xml.LanguageReader;
import com.beaver.softw.support.config.xml.SettingsReader;
import com.beaver.softw.support.config.xml.SupportedFileExtensionsReader;

public final class Configurator {
	private static HashMap<String, String> settings;

	public static void configure(final String settingsFilePath) {
		try {
			loadSettingsConfiguration(settingsFilePath);
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.SETTINGS_XML_FILE_ERROR, exc);
			return;
		}

		loadLanguageConfiguration();
		loadSupportedFileExtensionsConfiguration();

		try {
			UIManager.setLookAndFeel(settings.get("LookAndFeel"));
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.LOOK_AND_FEEL_ERROR, exc);
		}
	}

	private static void loadSettingsConfiguration(final String settingsFilePath) throws Exception {
		SettingsReader settingsReader = new SettingsReader();
		settingsReader.readFromXML(settingsFilePath);
		settings = settingsReader.getData();
	}

	private static void loadLanguageConfiguration() {
		try {
			LanguageReader languageReader = new LanguageReader();
			languageReader.readFromXML(
				new StringBuilder()
					.append("/language/")
					.append(settings.get("Language"))
					.toString()
			);
			Language.init(languageReader.getData());
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.LANGUAGE_XML_FILE_ERROR, exc);
		}
	}

	private static void loadSupportedFileExtensionsConfiguration() {
		try {
			SupportedFileExtensionsReader supportedFileExtensionsReader = new SupportedFileExtensionsReader();
			supportedFileExtensionsReader.readFromXML(
				new StringBuilder()
					.append("/settings/")
					.append(settings.get("SupportedFileExtensions"))
					.toString()
			);
			SupportedFileExtensions.init(supportedFileExtensionsReader.getData());
		}
		catch (Exception exc) {
		}
	}
}