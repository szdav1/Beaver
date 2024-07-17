package com.beaver.softw.support.config.xml;

import lombok.Getter;

@Getter
public enum XMLReaderConfiguration {
	LOOK_AND_FEEL_READER("SelectedLookAndFeel", ""),
	LANGUAGE_SPECIFIER_READER("SelectedLanguage", ""),
	LANGUAGE_READER("Words", "user"),
	SUPPORTED_FILE_EXTENSION_READER("Extension", "");

	private final String rootTagName;
	private final String attributeName;

	XMLReaderConfiguration(String rootTagName, String attributeName) {
		this.rootTagName = rootTagName;
		this.attributeName = attributeName;
	}
}
