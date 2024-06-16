package com.beaver.softw.support.config;

import java.util.HashMap;

public final class Language {
	private static HashMap<String, String> words;

	private Language() {
	}

	public static void init(final HashMap<String, String> words) {
		Language.words = words;
	}

	public static String get(String keyWord) {
		if (!words.containsKey(keyWord))
			return "!Lookup Failed!";

		return words.get(keyWord);
	}
}
