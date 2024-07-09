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
			return new StringBuilder("resources")
				.append(path)
				.toString();
		}
//
//		try {
//			System.out.println(url.getFile());
//			return url.getFile();
//		}
//		catch (Exception exc) {
//			System.out.println(new StringBuilder("resources")
//				.append(path)
//				.toString());
//			return new StringBuilder("resources")
//				.append(path)
//				.toString();
//		}
	}

	public static String getTarget(final String path, final String fileName) {
		URL url = ResourceHandler.class.getResource(path);

		if (url != null)
			return new StringBuilder(url.getFile())
				.append(fileName)
				.toString();

		return new StringBuilder("resources")
			.append("/settings/")
			.append(fileName)
			.toString();
	}
}