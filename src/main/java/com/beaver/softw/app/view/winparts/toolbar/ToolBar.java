package com.beaver.softw.app.view.winparts.toolbar;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.beaver.softw.app.view.winparts.WindowPart;
import com.beaver.softw.support.appdata.Dimensions;

public final class ToolBar extends JToolBar implements WindowPart {
	public ToolBar() {
		this.setup();
	}

	@Override
	public void setup() {
		this.setPreferredSize(Dimensions.TOOL_BAR_DIMENSIONS);
		this.setOrientation(SwingConstants.HORIZONTAL);
	}
}
