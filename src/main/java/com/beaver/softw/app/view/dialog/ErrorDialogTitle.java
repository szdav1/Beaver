package com.beaver.softw.app.view.dialog;

import lombok.Getter;

@Getter
public enum ErrorDialogTitle {
	XML_RESOURCE_ERROR("Error while loading XML resources"),
	COMPONENT_COMMUNICATION_ERROR("Component communication failed"),
	LOOK_AND_FEEL_ERROR("Missing look & feel name"),
	INVALID_FILE_ERROR("Specified file is invalid or can not be opened");

	private final String title;

	ErrorDialogTitle(String title) {
		this.title = title;
	}
}
