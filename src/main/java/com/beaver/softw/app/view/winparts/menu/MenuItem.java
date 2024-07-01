package com.beaver.softw.app.view.winparts.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import lombok.Getter;

@Getter
public final class MenuItem extends JMenuItem {
	private final int menuIndex;
	private final int itemIndex;
	private final String title;
	private String shortcutKeyString;

	public MenuItem(String title, int menuIndex, int itemIndex) {
		this.menuIndex = menuIndex;
		this.itemIndex = itemIndex;
		this.title = title;
		JLabel titleLabel = new JLabel(title);

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(titleLabel.getPreferredSize().width*2, titleLabel.getPreferredSize().height));
		this.add(titleLabel, BorderLayout.CENTER);
	}

	public void setShortcutKeyString(String shortcutKeyString) {
		this.shortcutKeyString = shortcutKeyString;
		JLabel shortcutKeyLabel = new JLabel(shortcutKeyString);

		this.setPreferredSize(new Dimension(this.getPreferredSize().width+(shortcutKeyLabel.getPreferredSize().width*2), this.getPreferredSize().height));
		this.add(shortcutKeyLabel, BorderLayout.EAST);
	}
}