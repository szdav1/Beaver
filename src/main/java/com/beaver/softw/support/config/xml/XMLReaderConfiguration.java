package com.beaver.softw.support.config.xml;

import lombok.Getter;

@Getter
public enum XMLReaderConfiguration {
	SETTINGS_READER("Setting", ""),
	LANGUAGE_READER("Words", "user"),
	SUPPORTED_FILE_EXTENSION_READER("Extension", "");

	private final String rootTagName;
	private final String attributeName;

	XMLReaderConfiguration(String rootTagName, String attributeName) {
		this.rootTagName = rootTagName;
		this.attributeName = attributeName;
	}
}
