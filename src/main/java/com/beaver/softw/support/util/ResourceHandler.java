package com.beaver.softw.support.util;

import java.io.FileReader;
import java.net.URL;

public final class ResourceHandler {
	private ResourceHandler() {
	}

	public static String get(final String path) {
		URL url = ResourceHandler.class.getResource(path);

		if (url == null)
			return "";

		try (FileReader fileReader = new FileReader(url.getFile())) {
			return url.getFile();
		}
		catch (Exception exc) {
			return new StringBuilder("resources/main")
				.append(path)
				.toString();
		}
	}
}