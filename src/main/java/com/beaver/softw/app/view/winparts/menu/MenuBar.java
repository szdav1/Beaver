package com.beaver.softw.app.view.winparts.menu;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.beaver.softw.app.control.winparts.menubar.MenuBarController;
import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;

public final class MenuBar extends JMenuBar implements WindowPart {
	public MenuBar() {
		new MenuBarConstructor(this)
			.setController(new MenuBarController(this))
			.addMenus("MenuBar.FileMenu", "MenuBar.SettingsMenu", "MenuBar.WindowMenu")
			.addMenuItems(0, "MenuBar.FileMenuOpen", "MenuBar.FileMenuExit")
			.addShortcutKeysToMenuItems(0, "F1", "ESCAPE")
			.addMenuItems(1, "MenuBar.SettingsMenuAppearance", "MenuBar.SettingsMenuLanguage")
			.addShortcutKeysToMenuItems(1, "F2")
			.addMenuItems(2, "MenuBar.WindowMenuResetWindow")
			.notifyController();

		this.setup();
	}

	public List<JMenu> getMenus() {
		List<JMenu> menus = new ArrayList<>();

		for (int i = 0; i < this.getMenuCount(); i++) {
			menus.add(this.getMenu(i));
		}

		return menus;
	}

	public List<MenuItem> getMenuItemsInMenu(final JMenu menu) {
		List<MenuItem> menuItems = new ArrayList<>();

		for (int i = 0; i < menu.getItemCount(); i++) {
			menuItems.add((MenuItem) menu.getItem(i));
		}

		return menuItems;
	}

	@Override
	public void setup() {
		this.setPreferredSize(Dimensions.MENU_DIMENSION);
	}
}