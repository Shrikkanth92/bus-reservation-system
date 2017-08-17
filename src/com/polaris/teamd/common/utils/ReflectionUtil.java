package com.polaris.teamd.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {

	public static Object getObject(String className) {
		Object objectForClassName = null;
		try {
			objectForClassName = Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return objectForClassName;
	}

	public static String formMethodName(String beanProperty, String prefix) {
		StringBuffer methodNameBuffer = new StringBuffer();
		methodNameBuffer.append(prefix)
				.append(Character.toUpperCase(beanProperty.charAt(0)))
				.append(beanProperty.substring(1));
		return methodNameBuffer.toString();
	}

	public static Method findMethod(Class className, String methodName,
			Class... classes) {
		Method[] allMethodsOfClass = className.getDeclaredMethods();
		for (Method methodOfClass : allMethodsOfClass) {
			try {
				if (methodOfClass.toString().equals(
						className.getMethod(methodName,classes).toString()))
					return methodOfClass;
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Object invokeGetterMethod(Object targetObject,
			Method methodToInvoke) {
		Object resultObject = null;
		try {
			resultObject = methodToInvoke.invoke(targetObject);
			return resultObject;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return resultObject;
	}

	public static Object invokeGetterMethod(Object targetObject,
			String methodName) {
		Method methodToInvoke = findMethod(targetObject.getClass(), methodName);
		Object resultObject;
		resultObject = invokeGetterMethod(targetObject, methodToInvoke);
		return resultObject;
	}

	public static void invokeSetterMethod(Object targetObject,
			Object beanPropertyName, Object beanPropertyValue) {

		Method setterMethod = null;
		Field[] fields = (targetObject.getClass()).getDeclaredFields();
		for (Field field : fields) {
			if (field.toString().endsWith(beanPropertyName.toString()))
				setterMethod = findMethod(targetObject.getClass(),
						formMethodName(beanPropertyName.toString(), "set"),
						field.getType());
			try {
				if (setterMethod != null)
					setterMethod.invoke(targetObject, beanPropertyValue);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	public static void invokeSetterMethod(Class targetClass,
			Object beanPropertyName, Object beanPropertyValue) {
		Method setterMethod = null;
		Field[] fields = (targetClass).getDeclaredFields();
		for (Field field : fields) {
			if (field.toString().endsWith(beanPropertyName.toString()))
				setterMethod = findMethod(targetClass,
						formMethodName(beanPropertyName.toString(), "set"),
						field.getType());
			try {
				if (setterMethod != null)
					setterMethod.invoke(targetClass.newInstance(),
							beanPropertyValue);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
		return;
	}
}
