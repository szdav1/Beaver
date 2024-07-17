package com.beaver.softw.app.control.cci;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import com.beaver.softw.app.view.window.Window;

public final class ComponentCommunicationInterface {
	private static Window window;

	public static void init(final Window window) {
		ComponentCommunicationInterface.window = window;
	}

	private static boolean doesNotHaveField(final String fieldName) {
		Field[] fields = window.getClass()
			.getDeclaredFields();

		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(fieldName))
				return false;
		}

		return true;
	}

	private static boolean doesNotHaveMethod(final Object object, final String methodName) {
		Method[] methods = object.getClass()
			.getDeclaredMethods();

		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(methodName))
				return false;
		}

		return true;
	}

	private static Class<?>[] getTypesForMethod(final Object object, final String methodName) {
		Method[] methods = object.getClass()
			.getDeclaredMethods();

		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(methodName))
				return method.getParameterTypes();
		}

		return new Class[0];
	}

	public static void requestMethodInvocationOn(final String componentName, final String methodName, final Object... arguments) {
		try {
			if (doesNotHaveField(componentName))
				return;

			Field field = window.getClass()
				.getDeclaredField(componentName);
			field.setAccessible(true);

			Object object = field.get(window);

			if (doesNotHaveMethod(object, methodName))
				return;

			Method method = object.getClass()
				.getDeclaredMethod(methodName, getTypesForMethod(object, methodName));
			method.setAccessible(true);
			method.invoke(object, arguments);
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR, exc);
		}
	}

	public static void requestMethodInvocationOn(final String componentName, final String methodName) {
		try {
			if (doesNotHaveField(componentName))
				return;

			Field field = window.getClass()
				.getDeclaredField(componentName);
			field.setAccessible(true);

			Object object = field.get(window);

			if (doesNotHaveMethod(object, methodName))
				return;

			Method method = object.getClass()
				.getDeclaredMethod(methodName);
			method.setAccessible(true);
			method.invoke(object);
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR, exc);
		}
	}
}