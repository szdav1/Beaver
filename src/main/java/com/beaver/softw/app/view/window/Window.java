package com.beaver.softw.app.view.window;

import java.awt.BorderLayout;
import java.awt.Image;

import com.beaver.softw.app.view.winparts.menu.WindowMenuBar;
import com.beaver.softw.app.view.winparts.sidebar.WindowSidebar;

public final class Window extends AbstractWindow {
	private final WindowMenuBar windowMenuBar;
	private final WindowSidebar windowSidebar;

	public Window(Image image, String title) {
		super(image, title);
		this.windowMenuBar = new WindowMenuBar();
		this.windowSidebar = new WindowSidebar();

		this.setJMenuBar(this.windowMenuBar);
		this.addnr(this.windowSidebar, BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
		this.repaint();
	}
}