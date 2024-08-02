package com.beaver.softw.support.config;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.beaver.softw.app.run.InstanceStarter;
import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.support.appdata.AppData;
import com.beaver.softw.support.config.xml.*;

public final class Configurator {
	public static Updater updater;

	public static void configure(final String settingsFilePath) {
//		javax.swing.plaf.metal.MetalLookAndFeel
//		javax.swing.plaf.nimbus.NimbusLookAndFeel
//		com.sun.java.swing.plaf.motif.MotifLookAndFeel
//		com.sun.java.swing.plaf.windows.WindowsLookAndFeel
//		com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
//		com.jtattoo.plaf.hifi.HiFiLookAndFeel
//		com.jtattoo.plaf.noire.NoireLookAndFeel
//		com.jtattoo.plaf.acryl.AcrylLookAndFeel
		updater = new Updater();

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

	public static final class Updater {
		private final LookAndFeelWriter lookAndFeelWriter;

		public Updater() {
			this.lookAndFeelWriter = new LookAndFeelWriter();
		}

		public void updateLookAndFeelConfiguration(final String data) {
			if (data.equals(AppData.CURRENT_LOOK_AND_FEEL)) {
				WindowManager.closeOpenedDialog();
				return;
			}

			try {
				this.lookAndFeelWriter.writeXML(data);
			}
			catch (Exception exc) {
				ErrorDialog.displayError(ErrorDialogTitle.LOOK_AND_FEEL_ERROR, exc);
			}

			if (JOptionPane.showOptionDialog(
				null,
				Language.get("Question.RestartText"),
				Language.get("Question.RestartTitle"),
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, null, null
			) == JOptionPane.YES_OPTION)
				InstanceStarter.restartApp();
			else
				WindowManager.closeOpenedDialog();
		}
	}
}