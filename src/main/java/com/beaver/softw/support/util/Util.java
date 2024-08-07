package com.beaver.softw.support.util;

import javax.swing.UIManager;

public final class Util {
	private Util() {
	}

	public static String getCurrentLookAndFeelName() {
		return UIManager.getLookAndFeel()
			.toString()
			.strip()
			.replaceAll(" ", "")
			.replace("]", "")
			.split("-")[1];
	}
}