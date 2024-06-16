package com.beaver.softw.app.view.winparts.sidebar;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;

public final class WindowSidebar extends JPanel implements WindowPart {
	private JTree projectTree;
	private final JScrollPane scrollPane;

	public WindowSidebar() {
		this.scrollPane = new JScrollPane(this.projectTree);
		this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setPreferredSize(Dimensions.SIDEBAR_DIMENSION);

		this.constructTreeStructure("D:\\projects\\Beaver");
		this.setup();
		this.add(this.scrollPane);
	}

	private void addChildToRootOnDisplay(final File rootFile, final DefaultMutableTreeNode rootNode) {
		if (!rootFile.isDirectory())
			return;

		File[] childFiles = rootFile.listFiles();

		for (File childFile : childFiles) {
			DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(childFile.getName());
			rootNode.add(childNode);
			this.addChildToRootOnDisplay(childFile, childNode);
		}
	}

	private void constructTreeStructure(final String filePath) {
		File rootFile = new File(filePath);

		if (!rootFile.isDirectory() || !rootFile.exists())
			return;

		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootFile.getAbsolutePath());
		File[] childFiles = rootFile.listFiles();

		for (File childFile : childFiles) {
			DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(childFile.getName());
			this.addChildToRootOnDisplay(childFile, childNode);
			rootNode.add(childNode);
		}

		this.projectTree = new JTree(rootNode);
		this.scrollPane.setViewportView(this.projectTree);
		WindowManager.repaint();
	}

	@Override
	public void setup() {
		this.setPreferredSize(Dimensions.SIDEBAR_DIMENSION);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
}
