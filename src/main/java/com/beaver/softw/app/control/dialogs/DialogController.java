package com.beaver.softw.app.control.dialogs;

import java.awt.event.WindowEvent;

import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.window.WindowStage;

public class DialogController extends AbstractDialogController {
	@Override
	public void windowClosing(WindowEvent e) {
		WindowManager.enableWindow();
		WindowManager.setStage(WindowStage.NORMAL);
	}
}