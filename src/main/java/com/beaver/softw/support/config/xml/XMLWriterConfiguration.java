package com.beaver.softw.support.config.xml;

import com.beaver.softw.support.appdata.AppData;
import lombok.Getter;

@Getter
public enum XMLWriterConfiguration {
	LOOK_AND_FEEL_WRITER("LookAndFeel", "SelectedLookAndFeel", "LookAndFeel", "resources/settings/LookAndFeel.xml");

	private final String xmlName;
	private final String selectedElementName;
	private final String elementName;
	private final String filePath;

	XMLWriterConfiguration(String xmlName, String selectedElementName, String elementName, String filePath) {
		this.xmlName = xmlName;
		this.selectedElementName = selectedElementName;
		this.elementName = elementName;
		this.filePath = filePath;
	}
}
