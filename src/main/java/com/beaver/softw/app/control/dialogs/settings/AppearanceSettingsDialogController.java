package com.beaver.softw.app.control.dialogs.settings;

import java.awt.event.ActionEvent;

import com.beaver.softw.app.control.dialogs.DialogController;
import com.beaver.softw.support.util.XMLWriter;

public final class AppearanceSettingsDialogController extends DialogController {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			XMLWriter.writeToXML();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
