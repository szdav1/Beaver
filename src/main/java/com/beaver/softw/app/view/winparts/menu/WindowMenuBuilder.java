package com.beaver.softw.app.view.winparts.menu;

import javax.swing.JMenu;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.support.config.Language;
import com.beaver.softw.support.util.Util;

public final class WindowMenuBuilder {
	private WindowMenuBar windowMenuBar;
	private AbstractController controller;

	public WindowMenuBuilder(WindowMenuBar windowMenuBar) {
		this.windowMenuBar = windowMenuBar;
	}

	public WindowMenuBuilder setController(final AbstractController controller) {
		this.controller = controller;

		return this;
	}

	public WindowMenuBuilder addMenus(final String... menuTitles) {
		for (String menuTitle : menuTitles) {
			JMenu m = new JMenu(Language.get(menuTitle));
			this.windowMenuBar.add(m);
		}

		return this;
	}

	public WindowMenuBuilder addMenuItems(int menuIndex, final String... menuItemTitles) {
		JMenu m = this.windowMenuBar.getMenu(menuIndex);

		if (Util.isNull(m))
			return this;

		for (int i = 0; i < menuItemTitles.length; i++) {
			WindowMenuItem wmi = new WindowMenuItem(Language.get(menuItemTitles[i]), menuIndex, i);
			wmi.addActionListener(this.controller);
			m.add(wmi);
		}

		return this;
	}

	public WindowMenuBar build() {
		return this.windowMenuBar;
	}
}
