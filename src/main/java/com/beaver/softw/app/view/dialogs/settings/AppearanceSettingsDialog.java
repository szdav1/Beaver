package com.beaver.softw.app.view.dialogs.settings;

import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.support.config.Language;

public final class AppearanceSettingsDialog extends AbstractDialog {
	public AppearanceSettingsDialog() {
		super();
		this.setTitle(Language.get("Dialogs.AppearanceSettingsTitle"));
	}
}
