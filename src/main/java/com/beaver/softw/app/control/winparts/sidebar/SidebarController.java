package com.beaver.softw.app.control.winparts.sidebar;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.sidebar.Sidebar;
import com.beaver.softw.support.config.SupportedFileExtensions;
import com.beaver.softw.support.util.Util;

public final class SidebarController extends AbstractController {
	private final Sidebar sidebar;

	public SidebarController(final Sidebar sidebar) {
		this.sidebar = sidebar;
	}

	private String createStringPath(final TreePath treePath) {
		StringBuilder strb = new StringBuilder();

		if (Util.isNull(treePath))
			return "";

		for (Object o : treePath.getPath()) {
			strb.append(o)
				.append("\\");
		}

		return strb.toString();
	}

	private String getFileExtension(final File file) {
		String fn = file.getName();
		String[] fnParts = fn.split("\\.");

		return fnParts[fnParts.length-1];
	}

	private boolean isReadableFile(final String filePath) {
		File f = new File(filePath);

		return f.isFile() && f.exists() && SupportedFileExtensions.getSupportedExtensions()
			.contains(this.getFileExtension(f));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTree pt = sidebar.getProjectTree();
		TreePath stp = pt.getSelectionPath();
		String path = this.createStringPath(stp);

		if (this.isReadableFile(path))
			ComponentCommunicationInterface.requestMethodInvocationOn("displayPane", "openFileToTab", path);
	}
}