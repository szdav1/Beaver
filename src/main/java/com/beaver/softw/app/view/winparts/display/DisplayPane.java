package com.beaver.softw.app.view.winparts.display;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;

import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;
import lombok.Getter;

@Getter
public final class DisplayPane extends JSplitPane implements WindowPart {
	private final JLayeredPane display;

	public DisplayPane() {
		this.display = new JLayeredPane();
		this.display.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.setup();
	}



	@Override
	public void setup() {
		this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.setPreferredSize(new Dimension(Dimensions.WINDOW_DIMENSION));
		this.setRightComponent(this.display);
	}
}
