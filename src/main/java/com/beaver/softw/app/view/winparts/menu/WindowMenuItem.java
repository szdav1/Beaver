package com.beaver.softw.app.view.winparts.menu;

import javax.swing.JMenuItem;

import lombok.Getter;

@Getter
public final class WindowMenuItem extends JMenuItem {
	private final int menuIndex;
	private final int itemIndex;

	public WindowMenuItem(String title, int menuIndex, int itemIndex) {
		this.menuIndex = menuIndex;
		this.itemIndex = itemIndex;
		this.setText(title);
	}
}
