package com.beaver.softw.app.view.winparts.menu;

import javax.swing.JMenu;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.support.config.Language;

public final class MenuBarBuilder {
	private final MenuBar menuBar;
	private AbstractController controller;

	public MenuBarBuilder(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MenuBarBuilder setController(final AbstractController controller) {
		this.controller = controller;

		return this;
	}

	public MenuBarBuilder addMenus(final String... menuTitles) {
		for (String menuTitle : menuTitles) {
			JMenu menu = new JMenu(Language.get(menuTitle));
			this.menuBar.add(menu);
		}

		return this;
	}

	public MenuBarBuilder addMenuItems(int menuIndex, final String... menuItemTitles) {
		JMenu menu = this.menuBar.getMenu(menuIndex);

		if (menu == null)
			return this;

		for (int i = 0; i < menuItemTitles.length; i++) {
			MenuItem wmi = new MenuItem(Language.get(menuItemTitles[i]), menuIndex, i);
			wmi.addActionListener(this.controller);
			menu.add(wmi);
		}

		return this;
	}

	public MenuBar build() {
		return this.menuBar;
	}
}