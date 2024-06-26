package com.beaver.softw.app.view.winparts.display.tabbed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.beaver.softw.app.view.window.WindowManager;

public final class TabCloser implements ActionListener {
	private final TabbedPane tabbedPane;

	public TabCloser(final TabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<DisplayTab> sourceDisplayTabs = this.tabbedPane.getDisplayTabs()
			.stream()
			.filter(displayTab -> displayTab.getCloseButton().equals(e.getSource()))
			.toList();

		if (sourceDisplayTabs.isEmpty())
			return;

		DisplayTab displayTab = sourceDisplayTabs.get(0);

		this.tabbedPane.getAbsolutePaths()
			.remove(displayTab.getToolTipText());

		this.tabbedPane.removeTabAt(
			this.tabbedPane.indexOfTab(
				displayTab.getTitleLabel()
					.getText()
			)
		);
		WindowManager.repaint();
	}
}