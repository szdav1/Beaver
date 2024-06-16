package com.beaver.softw.app.control.winparts.menubar;

import java.awt.event.ActionEvent;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.menu.WindowMenuBar;
import com.beaver.softw.app.view.winparts.menu.WindowMenuItem;

public final class MenuBarController extends AbstractController {
	private final WindowMenuBar menuBar;

	public MenuBarController(WindowMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	private void handleFileMenuActions(final WindowMenuItem windowMenuItem) {
		switch (windowMenuItem.getItemIndex()) {
			case 0 -> ComponentCommunicationInterface.requestMethodInvocationOn("windowSidebar", "constructTreeStructure");
		}
	}

	private void handleSettingsMenuActions(final WindowMenuItem windowMenuItem) {
		switch (windowMenuItem.getItemIndex()) {
			case 0 -> {}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof WindowMenuItem wmi) {
			switch (wmi.getMenuIndex()) {
				case 0 -> this.handleFileMenuActions(wmi);
				case 1 -> this.handleSettingsMenuActions(wmi);
			}
		}
	}
}
