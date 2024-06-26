package com.beaver.softw.app.view.winparts.display.tabbed;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import com.beaver.softw.app.view.window.WindowManager;

public final class TabSelector implements MouseListener {
	private final TabbedPane tabbedPane;

	public TabSelector(TabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		List<DisplayTab> sourceDisplayTabs = this.tabbedPane.getDisplayTabs()
			.stream()
			.filter(displayTab -> displayTab.getTitleLabel().equals(e.getSource()))
			.toList();

		if (sourceDisplayTabs.isEmpty())
			return;

		this.tabbedPane.setSelectedIndex(
			this.tabbedPane.indexOfTab(
				sourceDisplayTabs.get(0)
					.getTitleLabel()
					.getText()
			)
		);
		WindowManager.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}