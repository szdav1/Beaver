package com.beaver.softw.app.view.window;

import java.awt.BorderLayout;
import java.awt.Image;

import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.menu.WindowMenuBar;
import com.beaver.softw.app.view.winparts.sidebar.WindowSidebar;

public final class Window extends AbstractWindow {
	private final WindowMenuBar windowMenuBar;
	private final WindowSidebar windowSidebar;

	public Window(Image image, String title) {
		super(image, title);
		ComponentCommunicationInterface.init(this);
		WindowManager.init(this);

		this.windowMenuBar = new WindowMenuBar();
		this.windowSidebar = new WindowSidebar();

		this.constructWindowStructure();
		this.setVisible(true);
		this.repaint();
	}

	private void constructWindowStructure() {
		this.setJMenuBar(this.windowMenuBar);
		this.addnr(this.windowSidebar, BorderLayout.WEST);
		this.pack();
	}
}