package com.beaver.softw.app.view.winparts.display;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import javax.swing.*;

import com.beaver.softw.app.view.dialog.ErrorDialog;
import com.beaver.softw.app.view.dialog.ErrorDialogTitle;
import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;
import lombok.Getter;

@Getter
public final class DisplayPane extends JSplitPane implements WindowPart {
	private final JLayeredPane display;
	private final JTabbedPane tabbedPane;

	public DisplayPane() {
		this.display = new JLayeredPane();
		this.display.setLayout(new BorderLayout());

		this.tabbedPane = new JTabbedPane();
		this.setPreferredSize(Dimensions.WINDOW_DIMENSION);

		this.setup();
	}

	public void openFileToTab(final String filePath) {
		File f = new File(filePath);

		if (this.tabbedPane.getTabCount() != 0 && this.tabbedPane.indexOfTab(f.getName()) >= 0)
			return;

		try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
			JTextArea ta = new JTextArea();
			String line = raf.readLine();

			JScrollPane sp = new JScrollPane(ta);
			sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			sp.setPreferredSize(Dimensions.WINDOW_DIMENSION);

			while (line != null) {
				ta.setText(ta.getText()+line+"\n");
				line = raf.readLine();
			}

			sp.setViewportView(ta);
			this.tabbedPane.addTab(f.getName(), sp);
		}
		catch (FileNotFoundException exc) {
			exc.printStackTrace();
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR, exc);
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
