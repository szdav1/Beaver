package com.beaver.softw.app.view.dialogs;

import javax.swing.JDialog;

import com.beaver.softw.support.appdata.Dimensions;

public abstract class AbstractDialog extends JDialog {
	public AbstractDialog() {
		this.setSize(Dimensions.DIALOG_DIMENSION);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setAutoRequestFocus(true);
	}

	protected abstract void constructDialogStructure();
}
