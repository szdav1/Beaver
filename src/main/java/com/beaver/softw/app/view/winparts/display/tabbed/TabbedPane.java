package com.beaver.softw.app.view.winparts.display.tabbed;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public final class TabbedPane extends JTabbedPane {
	private final TabCloser tabCloser;

	public TabbedPane() {
		this.tabCloser = new TabCloser(this);
	}

	public void addCloseableTab(String tabTitle, final JComponent component) {
		DisplayTab displayTab = new DisplayTab(tabTitle);
		displayTab.implementCloseFunction(this.tabCloser);

		this.addTab(tabTitle, component);
		this.setTabComponentAt(this.indexOfTab(tabTitle), displayTab);
	}
}