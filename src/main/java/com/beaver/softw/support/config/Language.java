package com.beaver.softw.support.config;

import java.util.HashMap;

public final class Language {
	private static boolean initialized = false;
	private static final HashMap<String, String> words = new HashMap<>();

	private Language() {
	}

	public static void init(final HashMap<String, String> words) {
		if (initialized)
			return;

		Language.words.putAll(words);
		initialized = true;
	}

	public static String get(String keyWord) {
		if (!words.containsKey(keyWord))
			return "Lookup Failed!";

		return words.get(keyWord);
	}
}