package com.beaver.softw.app.control.winparts.menubar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.beaver.softw.app.control.AbstractKeystrokesController;
import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.winparts.menu.MenuBar;

public final class MenuBarKeystrokesController extends AbstractKeystrokesController {
	private final MenuBar menuBar;

	public MenuBarKeystrokesController(final MenuBar menuBar) {
		this.menuBar = menuBar;
		EscapeKeyAction escapeKeyAction = new EscapeKeyAction();
		F1KeyAction f1KeyAction = new F1KeyAction();
		F2KeyAction f2KeyAction = new F2KeyAction();

		String[][] actionNames = {
			{"F1KeyAction", "EscapeKeyAction"},
			{"F2KeyAction", ""},
			{""}
		};

		AbstractAction[][] actions = {
			{f1KeyAction, escapeKeyAction},
			{f2KeyAction, null},
			{null}
		};

		this.menuBar.getMenus()
			.forEach(menu -> this.menuBar.getMenuItemsInMenu(menu)
				.forEach(menuItem -> {
					menuItem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
						.put(KeyStroke.getKeyStroke(menuItem.getShortcutKeyString()), actionNames[menuItem.getMenuIndex()][menuItem.getItemIndex()]);

					menuItem.getActionMap()
						.put(actionNames[menuItem.getMenuIndex()][menuItem.getItemIndex()], actions[menuItem.getMenuIndex()][menuItem.getItemIndex()]);
				})
			);
	}

	@Override
	protected void setupShortcutKeyAction(String keyString, String actionName, final AbstractAction action) {
	}

	private static final class EscapeKeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (WindowManager.getStage()) {
				case NORMAL -> WindowManager.showExitConfirmationWindow();
			}
		}
	}

	private static final class F1KeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (WindowManager.getStage()) {
				case NORMAL -> ComponentCommunicationInterface.requestMethodInvocationOn("sidebar", "constructTreeStructure");
			}
		}
	}

	private static final class F2KeyAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (WindowManager.getStage()) {
				case NORMAL ->  ComponentCommunicationInterface.requestMethodInvocationOn("appearanceSettingsDialog", "appear");
			}
		}
	}
}
