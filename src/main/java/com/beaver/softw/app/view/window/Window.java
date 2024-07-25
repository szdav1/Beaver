package com.beaver.softw.app.view.window;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.SwingConstants;

import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.app.view.dialogs.settings.AppearanceSettingsDialog;
import com.beaver.softw.app.view.winparts.display.DisplayPane;
import com.beaver.softw.app.view.winparts.menu.MenuBar;
import com.beaver.softw.app.view.winparts.sidebar.Sidebar;
import com.beaver.softw.app.view.winparts.toolbar.ToolBar;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public final class Window extends AbstractWindow {
	private final MenuBar menuBar;
	private final ToolBar toolBar;
	private final Sidebar sidebar;
	private final DisplayPane displayPane;
	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private AbstractDialog openedDialog;
	@Getter(AccessLevel.PACKAGE)
	private final AppearanceSettingsDialog appearanceSettingsDialog;

	public Window(Image image, String title) {
		super(image, title);
		ComponentCommunicationInterface.init(this);

		this.menuBar = new MenuBar();
		this.toolBar = new ToolBar();
		this.sidebar = new Sidebar();

		this.displayPane = new DisplayPane();
		this.displayPane.setLeftComponent(this.sidebar);

		this.appearanceSettingsDialog = new AppearanceSettingsDialog();

		WindowManager.init(this);
		this.constructWindowStructure();
		this.setVisible(true);
		this.repaint();
	}

	void addToolbar() {
		this.add(this.toolBar, BorderLayout.NORTH);
		this.repaint();
	}

	void resetToolbar() {
		this.remove(this.toolBar);
		this.toolBar.setOrientation(SwingConstants.HORIZONTAL);
		this.add(this.toolBar, BorderLayout.NORTH);
		this.repaint();
		this.revalidate();
	}

	void constructWindowStructure() {
		this.setJMenuBar(this.menuBar);
		this.addToolbar();
		this.add(this.displayPane, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}