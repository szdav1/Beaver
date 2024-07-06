package com.beaver.softw.app.control.winparts.menubar;

import java.awt.event.ActionEvent;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.winparts.menu.MenuBar;
import com.beaver.softw.app.view.winparts.menu.MenuItem;

public final class MenuBarController extends AbstractController {
	public MenuBarController(final MenuBar menuBar) {
		new MenuBarKeystrokesController(menuBar);
	}

	private void handleFileMenuActions(final MenuItem menuItem) {
		// TODO: Look out for the indexes!
		switch (menuItem.getItemIndex()) {
			case 0 -> ComponentCommunicationInterface.requestMethodInvocationOn("sidebar", "constructTreeStructure");
			case 1 -> WindowManager.showExitConfirmationWindow();
		}
	}

	private void handleSettingsMenuActions(final MenuItem menuItem) {
		switch (menuItem.getItemIndex()) {
			case 0 -> {
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof MenuItem menuItem) {
			switch (menuItem.getMenuIndex()) {
				case 0 -> this.handleFileMenuActions(menuItem);
				case 1 -> this.handleSettingsMenuActions(menuItem);
			}
		}
	}
}