package com.beaver.softw.app.view.winparts.display;

import java.awt.BorderLayout;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.*;

import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.app.view.winparts.display.tabbed.TabbedPane;
import com.beaver.softw.support.appdata.Dimensions;
import lombok.Getter;

@Getter
public final class DisplayPane extends JSplitPane implements WindowPart {
	private final JLayeredPane display;
	private final TabbedPane tabbedPane;

	public DisplayPane() {
		this.display = new JLayeredPane();
		this.display.setLayout(new BorderLayout());

		this.tabbedPane = new TabbedPane();

		this.setPreferredSize(Dimensions.WINDOW_DIMENSION);
		this.setup();
	}

	public void openFileToTab(final String filePath) {
		File file = new File(filePath);

		if (this.tabbedPane.getAbsolutePaths().contains(file.getAbsolutePath()))
			return;

		try (RandomAccessFile reader = new RandomAccessFile(file, "r")) {
			JTextArea textArea = new JTextArea();
			String line = reader.readLine();

			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setPreferredSize(Dimensions.WINDOW_DIMENSION);

			while (line != null) {
				textArea.setText(
					new StringBuilder(textArea.getText())
						.append(line)
						.append("\n")
						.toString()
				);
				line = reader.readLine();
			}

			scrollPane.setViewportView(textArea);
			this.tabbedPane.addCloseableTab(
				this.tabbedPane.indexOfTab(file.getName()) >= 0 ? file.getAbsolutePath() : file.getName(),
				file.getAbsolutePath(),
				scrollPane
			);
			WindowManager.repaint();
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.INVALID_FILE_ERROR, exc);
		}
	}

	@Override
	public void setup() {
		this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.setPreferredSize(Dimensions.WINDOW_DIMENSION);
		this.display.add(this.tabbedPane, BorderLayout.CENTER);
		this.setRightComponent(this.display);
	}
}