package com.beaver.softw.app.control;

import javax.swing.AbstractAction;

public abstract class AbstractKeystrokesController {
	protected abstract void setupShortcutKeyAction(String keyString, String actionName, final AbstractAction action);
}
