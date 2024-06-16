package com.beaver.softw.app.view.winparts.sidebar;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;

public final class WindowSidebar extends JPanel implements WindowPart {
	private JTree projectTree;
	private final JScrollPane scrollPane;

	public WindowSidebar() {
		this.projectTree = new JTree();

		this.scrollPane = new JScrollPane(this.projectTree);
		this.scrollPane.setPreferredSize(Dimensions.SIDEBAR_DIMENSION);

		this.setup();
		this.add(this.scrollPane);
	}

	@Override
	public void setup() {
		this.setPreferredSize(Dimensions.SIDEBAR_DIMENSION);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
}
