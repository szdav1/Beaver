package com.beaver.softw.app.view.winparts.display.tabbed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.beaver.softw.support.appdata.Dimensions;

import static com.beaver.softw.support.appdata.Dimensions.GAP;

public final class DisplayTab extends JPanel {
	private final JLabel titleLabel;
	private final JButton closeButton;

	public DisplayTab(String title) {
		this.titleLabel = new JLabel(title);

		this.closeButton = new JButton("X");
		this.closeButton.setForeground(Color.red);
		this.closeButton.setContentAreaFilled(false);
		this.closeButton.setOpaque(false);
		this.closeButton.setBorder(new EmptyBorder(new Insets(GAP, GAP, GAP, GAP)));

		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.add(this.titleLabel, BorderLayout.CENTER);
		this.add(this.closeButton, BorderLayout.EAST);
	}

	public void implementCloseFunction(final TabCloser tabCloser) {
		this.closeButton.addActionListener(tabCloser);
	}
}