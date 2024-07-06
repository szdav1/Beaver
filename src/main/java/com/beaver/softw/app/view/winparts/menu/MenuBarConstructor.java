package com.beaver.softw.app.view.winparts.menu;

import javax.swing.JMenu;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.support.config.Language;

public final class MenuBarConstructor {
	private final MenuBar menuBar;
	private AbstractController controller;

	public MenuBarConstructor(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MenuBarConstructor setController(final AbstractController controller) {
		this.controller = controller;

		return this;
	}

	public MenuBarConstructor addMenus(final String... menuTitles) {
		for (String menuTitle : menuTitles) {
			JMenu menu = new JMenu(Language.get(menuTitle));
			menu.setMnemonic(menu.getText()
				.charAt(0));
			this.menuBar.add(menu);
		}

		return this;
	}

	public MenuBarConstructor addMenuItems(int menuIndex, final String... menuItemTitles) {
		JMenu menu = this.menuBar.getMenu(menuIndex);

		if (menu == null)
			return this;

		for (int i = 0; i < menuItemTitles.length; i++) {
			MenuItem menuItem = new MenuItem(Language.get(menuItemTitles[i]), menuIndex, i);
			menuItem.addActionListener(this.controller);
			menu.add(menuItem);
		}

		return this;
	}

	public MenuBarConstructor addShortcutKeysToMenuItems(int menuIndex, final String... shortcutKeyStrings) {
		JMenu menu = this.menuBar.getMenu(menuIndex);

		for (int i = 0; i < shortcutKeyStrings.length; i++) {
			((MenuItem) menu.getItem(i))
				.setShortcutKeyString(shortcutKeyStrings[i]);
		}

		return this;
	}
}