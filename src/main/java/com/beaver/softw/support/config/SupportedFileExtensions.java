package com.beaver.softw.support.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;

public final class SupportedFileExtensions {
	@Getter
	private static final List<String> supportedExtensions = new ArrayList<>();

	public static void init(final HashMap<String, String> data) {
		if (data.isEmpty())
			supportedExtensions.addAll(List.of("java", "xml", "md", "txt", "json", "gradle", "html", "css", "js"));
		else
			data.forEach((k, v) -> supportedExtensions.add(v));
	}
}