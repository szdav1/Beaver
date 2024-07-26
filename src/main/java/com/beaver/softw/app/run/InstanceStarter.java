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
				.exec(AppData.WINDOWS_RESTART_COMMAND);
			WindowManager.closeWindow();
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.OS_ERROR, exc);
		}
	}
}
