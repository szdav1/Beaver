package com.beaver.softw.app.view.window;

import java.awt.Image;

import javax.swing.JComponent;

import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.display.DisplayPane;
import com.beaver.softw.app.view.winparts.menu.MenuBar;
import com.beaver.softw.app.view.winparts.sidebar.Sidebar;

public final class Window extends AbstractWindow {
	private final MenuBar menuBar;
	private final Sidebar sidebar;
	private final DisplayPane displayPane;

	public Window(Image image, String title) {
		super(image, title);
		ComponentCommunicationInterface.init(this);
		WindowManager.init(this);

		this.menuBar = new MenuBar();
		this.sidebar = new Sidebar();

		this.displayPane = new DisplayPane();
		this.displayPane.setLeftComponent(this.sidebar);

		this.constructWindowStructure();
		this.setVisible(true);
		this.repaint();
	}

	private void constructWindowStructure() {
		this.setJMenuBar(this.menuBar);
		this.add(this.displayPane);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void addAndRepaint(final JComponent component) {
		this.displayPane.getDisplay()
			.add(component);
		this.repaint();
	}

	@Override
	public void addAndRepaint(final JComponent component, String position) {
		this.displayPane.getDisplay()
			.add(component, position);
		this.repaint();
	}
}