package com.beaver.softw.support.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.beaver.softw.support.appdata.AppData;
import lombok.Getter;

public final class SupportedFileExtensions {
	private static boolean initialized = false;
	@Getter
	private static final List<String> supportedExtensions = new ArrayList<>(Arrays.asList(AppData.DEFAULT_SUPPORTED_FILE_EXTENSIONS));

	public static void init(final HashMap<String, String> data) {
		if (data.isEmpty() || initialized)
			return;

		supportedExtensions.clear();
		data.forEach((k, v) -> supportedExtensions.add(v));
		initialized = true;
	}
}