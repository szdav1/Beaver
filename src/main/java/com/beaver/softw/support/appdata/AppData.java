package com.beaver.softw.support.appdata;

import com.beaver.softw.support.util.Util;

public final class AppData {
	public static final String CURRENT_LOOK_AND_FEEL = Util.getCurrentLookAndFeel();
	public static final String[] AVAILABLE_LOOK_AND_FEELS = {
		"javax.swing.plaf.metal.MetalLookAndFeel",
		"javax.swing.plaf.nimbus.NimbusLookAndFeel",
		"com.sun.java.swing.plaf.motif.MotifLookAndFeel",
		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
		"com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel",
		"com.jtattoo.plaf.hifi.HiFiLookAndFeel",
		"com.jtattoo.plaf.noire.NoireLookAndFeel",
		"com.jtattoo.plaf.acryl.AcrylLookAndFeel",
		"com.jtattoo.plaf.aero.AeroLookAndFeel",
		"com.jtattoo.plaf.aluminium.AluminiumLookAndFeel",
		"com.jtattoo.plaf.fast.FastLookAndFeel",
		"com.jtattoo.plaf.mcwin.McWinLookAndFeel",
		"com.jtattoo.plaf.mint.MintLookAndFeel",
		"com.jtattoo.plaf.smart.SmartLookAndFeel",
		"com.jtattoo.plaf.texture.TextureLookAndFeel"
	};
	public static final String[] DEFAULT_SUPPORTED_FILE_EXTENSIONS = {"java", "xml", "md", "txt", "json", "gradle", "html", "css", "js", "bat"};
}
