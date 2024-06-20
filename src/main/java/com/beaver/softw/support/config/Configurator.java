package com.beaver.softw.support.config;

import java.util.HashMap;

import javax.swing.UIManager;

import com.beaver.softw.app.view.dialog.ErrorDialog;
import com.beaver.softw.app.view.dialog.ErrorDialogTitle;
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
			ErrorDialog.display(ErrorDialogTitle.SETTINGS_XML_FILE_ERROR, exc.getStackTrace());
			return;
		}

		loadLanguageConfiguration();
		loadSupportedFileExtensionsConfiguration();

		try {
			UIManager.setLookAndFeel(settings.get("LookAndFeel"));
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.LOOK_AND_FEEL_ERROR, exc.getStackTrace());
		}
	}

	private static void loadSettingsConfiguration(final String settingsFilePath) throws Exception {
		SettingsReader sr = new SettingsReader();
		sr.readFromXML(settingsFilePath);
		settings = sr.getData();
	}

	private static void loadLanguageConfiguration() {
		try {
			LanguageReader lr = new LanguageReader();
			lr.readFromXML("/language/"+settings.get("Language"));
			Language.init(lr.getData());
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.LANGUAGE_XML_FILE_ERROR, exc.getStackTrace());
		}
	}

	private static void loadSupportedFileExtensionsConfiguration() {
		try {
			SupportedFileExtensionsReader sfer = new SupportedFileExtensionsReader();
			sfer.readFromXML("/settings/"+settings.get("SupportedFileExtensions"));
			SupportedFileExtensions.init(sfer.getData());
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.SUPPORTED_FILE_EXTENSIONS, exc.getStackTrace());
		}
	}
}