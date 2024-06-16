package com.beaver.softw.app.view.winparts.menu;

import javax.swing.JMenuBar;

import com.beaver.softw.app.control.winparts.menubar.MenuBarController;
import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;

public final class WindowMenuBar extends JMenuBar implements WindowPart {
	public WindowMenuBar() {
		new WindowMenuBuilder(this)
			.setController(new MenuBarController(this))
			.addMenus("MenuBar.FileMenu", "MenuBar.SettingsMenu")
			.addMenuItems(0, "MenuBar.FileMenuOpen")
			.addMenuItems(1, "MenuBar.SettingsMenuAppearance");

		this.setup();
	}

	@Override
	public void setup() {
		this.setPreferredSize(Dimensions.MENU_DIMENSION);
	}
}
