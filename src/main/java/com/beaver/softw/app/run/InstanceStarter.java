package com.beaver.softw.app.run;

import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.support.appdata.AppData;

public final class InstanceStarter {
	public static void startNewAppInstance() {
		new App();
	}

	public static void restartApp() {
		try {
			Runtime.getRuntime()
				.exec(new String[]{"cmd", "/K", String.format("Start javaw -jar %s exit", AppData.JAR_NAME)});
			WindowManager.closeWindow();
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR, exc);
		}
	}
}
