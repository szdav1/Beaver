package com.beaver.softw.app.run;

import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.window.Window;
import com.beaver.softw.support.appdata.AppData;
import com.beaver.softw.support.config.Configurator;

final class App {
	public App() {
		Configurator.configure("/settings/Settings.xml");

		if (!ErrorDialog.isDisplayed())
			new Window(null, AppData.APPLICATION_NAME);
	}
}