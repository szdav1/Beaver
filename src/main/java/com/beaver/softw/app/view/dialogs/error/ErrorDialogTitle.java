package com.beaver.softw.app.view.dialogs.error;

import lombok.Getter;

@Getter
public enum ErrorDialogTitle {
	XML_RESOURCE_ERROR("Error while loading XML resources"),
	LANGUAGE_XML_FILE_ERROR("Failed to load language XML"),
	SUPPORTED_FILE_EXTENSIONS_WARNING("Failed to load supported file extensions XML"),
	COMPONENT_COMMUNICATION_ERROR("Component communication failed"),
	LOOK_AND_FEEL_ERROR("Look And Feel error (LAF can not be loaded or can not be written)"),
	OS_ERROR("Could not restart the application (OS does not support command)"),
	INVALID_FILE_ERROR("Specified file is invalid or can not be opened");

	private final String title;

	ErrorDialogTitle(String title) {
		this.title = title;
	}
}