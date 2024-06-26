package com.beaver.softw.app.view.window;

import java.awt.BorderLayout;
import java.awt.Image;

import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.display.DisplayPane;
import com.beaver.softw.app.view.winparts.menu.MenuBar;
import com.beaver.softw.app.view.winparts.sidebar.Sidebar;
import com.beaver.softw.app.view.winparts.toolbar.ToolBar;
import lombok.Getter;

public final class Window extends AbstractWindow {
	private final MenuBar menuBar;
	private final ToolBar toolBar;
	private final Sidebar sidebar;
	@Getter
	private final DisplayPane displayPane;

	public Window(Image image, String title) {
		super(image, title);
		ComponentCommunicationInterface.init(this);
		WindowManager.init(this);

		this.menuBar = new MenuBar();
		this.toolBar = new ToolBar();
		this.sidebar = new Sidebar();

		this.displayPane = new DisplayPane();
		this.displayPane.setLeftComponent(this.sidebar);

		this.constructWindowStructure();
		this.setVisible(true);
		this.repaint();
	}

	private void constructWindowStructure() {
		this.setJMenuBar(this.menuBar);
		this.add(this.toolBar, BorderLayout.NORTH);
		this.add(this.displayPane, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}