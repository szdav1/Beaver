package com.beaver.softw.app.view.winparts.sidebar;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;
import com.beaver.softw.support.config.Language;

public final class WindowSidebar extends JPanel implements WindowPart {
	private final JLabel titleLabel;
	private JTree projectTree;
	private final JScrollPane scrollPane;
	private final JFileChooser fileChooser;

	public WindowSidebar() {
		this.titleLabel = new JLabel(Language.get("Sidebar.Title"));
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		this.scrollPane = new JScrollPane(this.projectTree);
		this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		this.fileChooser = new JFileChooser();
		this.fileChooser.setDialogTitle("");
		this.fileChooser.setMultiSelectionEnabled(false);
		this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		this.setup();
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

	public void constructTreeStructure() {
		this.fileChooser.showOpenDialog(null);
		File rootFile = this.fileChooser.getSelectedFile();

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
		this.setLayout(new BorderLayout());
		this.add(this.titleLabel, BorderLayout.NORTH);
		this.add(this.scrollPane, BorderLayout.CENTER);
	}
}
