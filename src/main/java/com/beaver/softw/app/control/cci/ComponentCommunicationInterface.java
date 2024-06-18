package com.beaver.softw.app.control.cci;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.beaver.softw.app.view.dialog.ErrorDialog;
import com.beaver.softw.app.view.dialog.ErrorDialogTitle;
import com.beaver.softw.app.view.window.Window;

public final class ComponentCommunicationInterface {
	private static Window window;

	public static void init(final Window window) {
		ComponentCommunicationInterface.window = window;
	}

	private static boolean hasField(final String fieldName) {
		Field[] fields = window.getClass()
			.getDeclaredFields();

		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(fieldName))
				return true;
		}

		return false;
	}

	private static boolean hasMethod(final Object object, final String methodName) {
		Method[] methods = object.getClass()
			.getDeclaredMethods();

		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(methodName))
				return true;
		}

		return false;
	}

	private static Class<?>[] getTypesForMethod(final Object object, final String methodName) {
		Method[] ms = object.getClass()
			.getDeclaredMethods();

		for (Method m : ms) {
			if (m.getName().equalsIgnoreCase(methodName))
				return m.getParameterTypes();
		}

		return new Class[0];
	}

	public static void requestMethodInvocationOn(final String componentName, final String methodName, final Object... arguments) {
		try {
			if (!hasField(componentName))
				return;

			Field f = window.getClass()
				.getDeclaredField(componentName);
			f.setAccessible(true);

			Object o = f.get(window);

			if (!hasMethod(o, methodName))
				return;

			Method m = o.getClass()
				.getDeclaredMethod(methodName, getTypesForMethod(o, methodName));
			m.setAccessible(true);
			m.invoke(o, arguments);
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR, exc.getStackTrace());
		}
	}

	public static void requestMethodInvocationOn(final String componentName, final String methodName) {
		try {
			if (!hasField(componentName))
				return;

			Field f = window.getClass()
				.getDeclaredField(componentName);
			f.setAccessible(true);

			Object o = f.get(window);

			if (!hasMethod(o, methodName))
				return;

			Method m = o.getClass()
				.getDeclaredMethod(methodName);
			m.setAccessible(true);
			m.invoke(o);
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.COMPONENT_COMMUNICATION_ERROR, exc.getStackTrace());
		}
	}
}
