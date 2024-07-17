package com.beaver.softw.support.config;

import javax.swing.UIManager;

import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import com.beaver.softw.support.appdata.AppData;
import com.beaver.softw.support.config.xml.LanguageReader;
import com.beaver.softw.support.config.xml.LanguageSpecifierReader;
import com.beaver.softw.support.config.xml.LookAndFeelReader;
import com.beaver.softw.support.config.xml.SupportedFileExtensionsReader;

public final class Configurator {
	public static void configure(final String settingsFilePath) {
		loadLookAndFeelConfiguration();
		loadLanguageConfiguration();
		loadSupportedFileExtensionsConfiguration();
	}

	private static void loadLookAndFeelConfiguration() {
		try {
			LookAndFeelReader lookAndFeelReader = new LookAndFeelReader();
			lookAndFeelReader.readFromXML(AppData.LOOK_AND_FEEL_XML_LOCATION);

			UIManager.setLookAndFeel(
				lookAndFeelReader.getData()
					.get("LookAndFeel")
			);
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.LOOK_AND_FEEL_ERROR, exc);
		}
	}

	private static void loadLanguageConfiguration() {
		try {
			LanguageSpecifierReader languageSpecifierReader = new LanguageSpecifierReader();
			languageSpecifierReader.readFromXML(AppData.LANGUAGE_SPECIFIER_XML_LOCATION);

			LanguageReader languageReader = new LanguageReader();
			languageReader.readFromXML(
				new StringBuilder(AppData.LANGUAGE_FOLDER_LOCATION)
					.append(
						languageSpecifierReader.getData()
							.get("Language")
					)
					.toString()
			);

			Language.init(languageReader.getData());
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.LANGUAGE_XML_FILE_ERROR, exc);
		}
	}

	private static void loadSupportedFileExtensionsConfiguration() {
		try {
			SupportedFileExtensionsReader supportedFileExtensionsReader = new SupportedFileExtensionsReader();
			supportedFileExtensionsReader.readFromXML(AppData.SUPPORTED_FILE_EXTENSIONS_XML_LOCATION);
			SupportedFileExtensions.init(supportedFileExtensionsReader.getData());
		}
		catch (Exception exc) {
			ErrorDialog.displayWarning(ErrorDialogTitle.SUPPORTED_FILE_EXTENSIONS_WARNING, "Default supported file extensions are used.");
		}
	}
}