package com.beaver.softw.app.control.winparts.sidebar;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import com.beaver.softw.app.control.AbstractController;
import com.beaver.softw.app.control.cci.ComponentCommunicationInterface;
import com.beaver.softw.app.view.winparts.sidebar.Sidebar;
import com.beaver.softw.support.config.SupportedFileExtensions;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class SidebarController extends AbstractController {
	private final Sidebar sidebar;

	private String createStringPathFromTreePath(final TreePath treePath) {
		StringBuilder stringBuilder = new StringBuilder();

		if (treePath == null)
			return "";

		for (Object object : treePath.getPath()) {
			stringBuilder.append(object)
				.append("\\");
		}

		return stringBuilder.toString();
	}

	private String getFileExtensionOfFile(final File file) {
		String fileName = file.getName();
		String[] fileNameParts = fileName.split("\\.");

		return fileNameParts[fileNameParts.length-1];
	}

	private boolean isReadableFile(final String filePath) {
		File file = new File(filePath);

		return file.isFile() &&
			file.exists() &&
			file.canRead() &&
			SupportedFileExtensions.getSupportedExtensions()
				.contains(this.getFileExtensionOfFile(file));
	}

	@Override
	public void getNotified() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTree pt = sidebar.getProjectTree();
		TreePath stp = pt.getSelectionPath();
		String path = this.createStringPathFromTreePath(stp);

		if (this.isReadableFile(path))
			ComponentCommunicationInterface.requestMethodInvocationOn("displayPane", "openFileToTab", path);
	}
}