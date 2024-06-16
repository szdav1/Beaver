package com.beaver.softw.app.view.winparts.menu;

import javax.swing.JMenuBar;

import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;

public final class WindowMenuBar extends JMenuBar implements WindowPart {
	public WindowMenuBar() {
		new WindowMenuBuilder(this)
			.addMenus("File", "Settings")
			.addMenuItems(0, "Open")
			.addMenuItems(1, "Appearance");

		this.setup();
	}

	@Override
	public void setup() {
		this.setPreferredSize(Dimensions.MENU_DIMENSION);
	}
}
