package com.beaver.softw.app.view.winparts.display.tabbed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.beaver.softw.support.appdata.Dimensions;
import lombok.Getter;

import static com.beaver.softw.support.appdata.Dimensions.GAP;

@Getter
public final class DisplayTab extends JPanel {
	private final JLabel titleLabel;
	private final JButton closeButton;

	public DisplayTab(String title) {
		this.titleLabel = new JLabel(title);
		this.titleLabel.setPreferredSize(title.length() > 50 ? Dimensions.N_BUTTON_DIMENSION : null);

		this.closeButton = new JButton("X");
		this.closeButton.setForeground(Color.red);
		this.closeButton.setContentAreaFilled(false);
		this.closeButton.setOpaque(false);
		this.closeButton.setBorder(new EmptyBorder(new Insets(GAP, GAP, GAP, GAP)));

		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setToolTipText(title);
		this.add(titleLabel, BorderLayout.CENTER);
		this.add(this.closeButton, BorderLayout.EAST);
	}

	public void implementSelectFunction(final TabSelector tabSelector) {
		this.titleLabel.addMouseListener(tabSelector);
	}

	public void implementCloseFunction(final TabCloser tabCloser) {
		this.closeButton.addActionListener(tabCloser);
	}
}