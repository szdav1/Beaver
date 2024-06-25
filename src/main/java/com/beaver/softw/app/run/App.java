package com.beaver.softw.app.run;

import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.dialog.ErrorDialog;
import com.beaver.softw.app.view.window.Window;
import com.beaver.softw.support.config.Configurator;

public final class App {
	public App() {
		Configurator.configure("/settings/Settings.xml");

		if (!ErrorDialog.wasDisplayed())
			new Window(null, "Beaver - Version 0.5");

		ComponentCommunicationInterface.requestMethodInvocationOn("displayPane", "openFileToTab", "C:\\Users\\Dave\\IdeaProjects\\Beaver\\src\\main\\java\\com\\beaver\\softw\\support\\config\\xml\\AbstractXMLObjectParser.java");
	}
}