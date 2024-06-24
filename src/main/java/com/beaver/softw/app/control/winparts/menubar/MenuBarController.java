package com.beaver.softw.app.control.winparts.menubar;

import java.awt.event.ActionEvent;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.menu.MenuBar;
import com.beaver.softw.app.view.winparts.menu.MenuItem;

public final class MenuBarController extends AbstractController {
	private final MenuBar menuBar;

	public MenuBarController(final MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	private void handleFileMenuActions(final MenuItem menuItem) {
		switch (menuItem.getItemIndex()) {
			case 0 -> ComponentCommunicationInterface.requestMethodInvocationOn("sidebar", "constructTreeStructure");
		}
	}

	private void handleSettingsMenuActions(final MenuItem menuItem) {
		switch (menuItem.getItemIndex()) {
			case 0 -> {}
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