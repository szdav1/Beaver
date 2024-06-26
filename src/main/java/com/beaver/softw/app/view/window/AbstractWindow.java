package com.beaver.softw.app.view.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import static com.beaver.softw.support.appdata.Dimensions.WINDOW_HEIGHT;
import static com.beaver.softw.support.appdata.Dimensions.WINDOW_WIDTH;

public abstract class AbstractWindow extends JFrame {
	protected final JLayeredPane contentPane;

	protected AbstractWindow(Image image, String title) {
		this.contentPane = new JLayeredPane();

		// Default JFrame setup code (Boilerplate code)
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.contentPane);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(true);
		this.setIconImage(image);
		this.setTitle(title);
	}
}