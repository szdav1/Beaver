package com.beaver.softw.support;

import com.beaver.softw.app.run.App;
import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import com.beaver.softw.app.view.window.WindowManager;

public final class InstanceStarter {
	public static void startNewAppInstance() {
		new App();
	}

	public static void restartApp() {
		try {
			Runtime.getRuntime()
				.exec(new String[] {"cmd", "/K", "Start javaw -jar Beaver-0.5-WORK-IN-PROGRESS-all.jar exit"});
			WindowManager.closeWindow();
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR, exc);
		}
	}
}
