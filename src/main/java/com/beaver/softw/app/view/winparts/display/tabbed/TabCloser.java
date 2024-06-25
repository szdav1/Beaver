package com.beaver.softw.app.view.winparts.display.tabbed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class TabCloser implements ActionListener {
	private final TabbedPane tabbedPane;

	public TabCloser(final TabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.tabbedPane.remove(this.tabbedPane.getSelectedComponent());
	}
}