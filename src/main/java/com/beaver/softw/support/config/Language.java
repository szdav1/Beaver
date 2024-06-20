package com.beaver.softw.support.config;

import java.util.HashMap;

public final class Language {
	private static final HashMap<String, String> words = new HashMap<>();

	private Language() {
	}

	public static void init(final HashMap<String, String> words) {
		Language.words.putAll(words);
	}

	public static String get(String keyWord) {
		if (!words.containsKey(keyWord))
			return "!Lookup Failed!";

		return words.get(keyWord);
	}
}