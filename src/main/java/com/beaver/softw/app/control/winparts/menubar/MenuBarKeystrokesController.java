package com.beaver.softw.app.control.winparts.menubar;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import com.beaver.softw.app.control.AbstractKeystrokesController;
import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.window.WindowStage;
import com.beaver.softw.app.view.winparts.menu.MenuBar;
import com.beaver.softw.app.view.winparts.menu.MenuItem;

public final class MenuBarKeystrokesController extends AbstractKeystrokesController {
	private final MenuBar menuBar;

	public MenuBarKeystrokesController(final MenuBar menuBar) {
		this.menuBar = menuBar;

		String[] fileMenuActionNames = {"OpenProjectAction", "ExitApplicationAction"};
		AbstractAction[] fileMenuActions = {new OpenProjectAction(), new ExitApplicationAction()};
		List<JMenu> menus = menuBar.getMenus();

		menus.forEach(menu -> {
			List<MenuItem> menuItems = menuBar.getMenuItemsInMenu(menu);

			menuItems.forEach(menuItem -> {
				int index = menuItems.indexOf(menuItem);

				// TODO: Create the actions for the settings menus too
				switch (menus.indexOf(menu)) {
					case 0 -> this.setupShortcutKeyAction(menuItem.getShortcutKeyString(), fileMenuActionNames[index], fileMenuActions[index]);
				}
			});
		});
	}

	@Override
	protected void setupShortcutKeyAction(String keyString, String actionName, final AbstractAction action) {
		this.menuBar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyString), actionName);
		this.menuBar.getActionMap().put(actionName, action);
	}

	private static final class OpenProjectAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (WindowManager.getStage() == WindowStage.NORMAL)
				ComponentCommunicationInterface.requestMethodInvocationOn("sidebar", "constructTreeStructure");
		}
	}

	private static final class ExitApplicationAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (WindowManager.getStage() == WindowStage.NORMAL)
				WindowManager.showExitConfirmationWindow();
		}
	}
}
