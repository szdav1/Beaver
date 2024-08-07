package com.beaver.softw.support.appdata;

import com.beaver.softw.support.util.Util;

public final class AppData {
	public static final String APPLICATION_NAME = "Beaver-Tattoo_Extension";
	public static final String JAR_NAME = "Beaver-Tattoo_Extension.jar";
	public static final String CURRENT_LOOK_AND_FEEL = Util.getCurrentLookAndFeelName();
	public static final String[] WINDOWS_RESTART_COMMAND = {"cmd", "/K", String.format("javaw -jar %s", JAR_NAME)};
	// TODO: Remove JTattoo lafs before release
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
	public static final String LANGUAGE_SPECIFIER_XML_LOCATION = "/settings/Language.xml";
	public static final String LANGUAGE_FOLDER_LOCATION = "/languages/";
	public static final String LOOK_AND_FEEL_XML_LOCATION = "/settings/LookAndFeel.xml";
	public static final String SUPPORTED_FILE_EXTENSIONS_XML_LOCATION = "/settings/SupportedFileExtensions.xml";
}