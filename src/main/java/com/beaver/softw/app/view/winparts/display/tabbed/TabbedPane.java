package com.beaver.softw.app.view.winparts.display.tabbed;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import com.beaver.softw.app.view.window.WindowManager;
import lombok.Getter;

public final class TabbedPane extends JTabbedPane {
	private final TabSelector tabSelector;
	private final TabCloser tabCloser;
	@Getter
	private final List<DisplayTab> displayTabs;
	@Getter
	private final List<String> absolutePaths;

	public TabbedPane() {
		this.tabSelector = new TabSelector(this);
		this.tabCloser = new TabCloser(this);
		this.displayTabs = new ArrayList<>();
		this.absolutePaths = new ArrayList<>();
	}

	public void addCloseableTab(String tabTitle, String toolTip, final JComponent component) {
		DisplayTab displayTab = new DisplayTab(tabTitle);
		displayTab.setToolTipText(toolTip);
		displayTab.implementSelectFunction(this.tabSelector);
		displayTab.implementCloseFunction(this.tabCloser);

		this.displayTabs.add(displayTab);
		this.absolutePaths.add(toolTip);
		this.addTab(tabTitle, component);
		this.setTabComponentAt(this.indexOfTab(tabTitle), displayTab);
		WindowManager.repaint();
	}
}