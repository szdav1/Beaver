package com.beaver.softw.app.view.dialogs;

import javax.swing.JDialog;

import com.beaver.softw.app.view.window.WindowManager;
import com.beaver.softw.support.appdata.Dimensions;

public abstract class AbstractDialog extends JDialog {
	public AbstractDialog() {
		this.setSize(Dimensions.DIALOG_DIMENSION);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(true);
	}

	protected abstract void reset();

	protected abstract void constructDialogStructure();

	protected void display(final AbstractDialog source) {
		WindowManager.setOpenedDialog(source);
		this.reset();
		this.setVisible(true);
	}
}
