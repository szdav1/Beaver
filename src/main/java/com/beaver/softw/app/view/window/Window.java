package com.beaver.softw.app.view.window;

import java.awt.Image;

import javax.swing.JComponent;

import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.display.DisplayPane;
import com.beaver.softw.app.view.winparts.menu.WindowMenuBar;
import com.beaver.softw.app.view.winparts.sidebar.WindowSidebar;

public final class Window extends AbstractWindow {
	private final WindowMenuBar windowMenuBar;
	private final WindowSidebar windowSidebar;
	private final DisplayPane displayPane;

	public Window(Image image, String title) {
		super(image, title);
		ComponentCommunicationInterface.init(this);
		WindowManager.init(this);

		this.windowMenuBar = new WindowMenuBar();
		this.windowSidebar = new WindowSidebar();

		this.displayPane = new DisplayPane();
		this.displayPane.setLeftComponent(this.windowSidebar);

		this.constructWindowStructure();
		this.setVisible(true);
		this.repaint();
	}

	private void constructWindowStructure() {
		this.setJMenuBar(this.windowMenuBar);
		this.add(this.displayPane);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void addnr(JComponent component) {
		this.displayPane.getDisplay()
			.add(component);
	}

	@Override
	public void addnr(JComponent component, String position) {
		this.displayPane.getDisplay()
			.add(component, position);
	}
}