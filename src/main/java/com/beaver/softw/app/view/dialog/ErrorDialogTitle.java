package com.beaver.softw.app.view.dialog;

import lombok.Getter;

@Getter
public enum ErrorDialogTitle {
	XML_RESOURCE_ERROR("Error while loading XML resources"),
	COMPONENT_COMMUNICATION_ERROR("Component communication failed");

	private final String title;

	ErrorDialogTitle(String title) {
		this.title = title;
	}
}
